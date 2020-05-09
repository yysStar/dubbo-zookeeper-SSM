package com.qiyun.task;

import com.qiyun.api.LotteryApi;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.grabber.model.PlatformEnum;
import com.qiyun.model.LotteryTypeProps;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.basketball.BasketBallTeam;
import com.qiyun.model.basketball.SFAward;
import com.qiyun.service.BasketBallService;
import com.qiyun.service.BasketTeamService;
import com.qiyun.service.DGService;
import com.qiyun.service.LotteryTypePropsService;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.TimeTools;
import com.qiyun.utils.basketball.SportteryGrabberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Lazy(value=false)
public class BasketBallMatchAndSpBuildTask {
    @Autowired
    private BasketBallService basketBallService;
    @Autowired
    private LotteryTypePropsService lotteryTypePropsService;
    @Autowired
    private BasketTeamService basketTeamService;

    /**
     * 抓取SP
     */
    @Scheduled(cron = "0 0/3 * * * ?")//每隔3分钟处理一次
    public void buildAward() {
        snatchNewMatch();
        // 拿到对阵先,组装一下MATCH，拿到所有对阵的intTime_lineId值
        List<BasketBallMatch> matchs = basketBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());

        Map<Integer, List<BasketBallMatch>> matchMap = new HashMap<Integer, List<BasketBallMatch>>();
        Map<String, Integer> matchIdMap = new HashMap<String, Integer>();
        if (!matchs.isEmpty()) {
            for (BasketBallMatch match : matchs) {
                Integer intTime = match.getIntTime();
                List<BasketBallMatch> matchList = matchMap.get(intTime);
                if (matchList == null)
                    matchList = new ArrayList<BasketBallMatch>();
                matchList.add(match);
                matchMap.put(intTime, matchList);
                Integer lineId = match.getLineId();
                matchIdMap.put(intTime + "_" + lineId, match.getId());
            }
            buildAwardInfo(matchIdMap, LotteryType.JC_LQ_DXF);
            buildAwardInfo(matchIdMap, LotteryType.JC_LQ_SF);
            buildAwardInfo(matchIdMap, LotteryType.JC_LQ_RFSF);
            buildFcawardInfo(matchMap, matchIdMap, LotteryType.JC_LQ_SFC);
        } else {
            LogUtil.info("抓取对阵为空，返回");
        }
    }

    /**
     * 抓取新的对阵,更新对阵缩写
     * 如果缩写表存在: 更新对阵表缩写.
     * 如果缩写表不存在: 则用全称代替缩写,更新缩写表和对阵表
     */
    public void snatchNewMatch() {
        boolean flag = false;
        LogUtil.info("----------竞彩篮球自动维护线程抓取新赛事开始-----------");
        try {
            Set<Integer> intTimeSet =new HashSet<Integer>();
            //得到抓取的数据
            List<BasketBallMatch> bballList = SportteryGrabberUtil.getMatchList(PlatformEnum.BASKETBALL.name());
            for (BasketBallMatch ms : bballList) {
                intTimeSet.add(ms.getIntTime());
            }
            //根据抓取到的intTimeSet查数据库中的数据
            //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
            List<BasketBallMatch> dbMatchs = this.basketBallService.getMatchListByIntTime(intTimeSet);

            Map<String, BasketBallMatch> dbMap = new HashMap<String, BasketBallMatch>();
            dbMap = arrangeListToMap(dbMatchs);

            //数据库不存在.把抓取到的放入数据库map
            for (BasketBallMatch ms : bballList) {
                String msKey=ms.getMapKey();
                if (dbMap.containsKey(msKey)) {
                    if(dbMap.get(msKey).getStatus() == 0) {//对阵为正常销售情况下，才更新状态
                        if (dbMap.get(msKey).getShowNum()!=ms.getShowNum()) {
                            dbMap.get(msKey).setShowNum(ms.getShowNum());
                            flag = true;
                        }
                    }
                }else{
                    LogUtil.info("---竞彩篮球抓取赛程:"+msKey+"--主队VS客队:"+ms.getHomeTeam()+"vs"
                            +ms.getGuestTeam()+";比赛时间:"+ DateTools.dateToString(ms.getMatchTime())
                            +";让分:"+ms.getHandicap()+";大小分:"+ms.getBaseBigOrSmall()+"---");
                    dbMap.put(msKey, ms);
                    flag = true;
                }
            }
            /** 新的容器* */
            LotteryTypeProps props = lotteryTypePropsService.findById(LotteryType.JC_LQ_SF.getValue());
            List<BasketBallMatch> arrangeList = new ArrayList<BasketBallMatch>();
            for (Map.Entry<String, BasketBallMatch> entry : dbMap.entrySet()) {
                BasketBallMatch match =entry.getValue();
                //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
                BasketBallTeam guestTeam = basketTeamService.getTeamInfoByFullName(match.getGuestTeam().trim());
                //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
                BasketBallTeam homeTeam = basketTeamService.getTeamInfoByFullName(match.getHomeTeam().trim());
                // 客队
                if (guestTeam != null) {
                    if (!match.getShortGuestTeam().equals(guestTeam.getShortTeamName())) {
                        match.setShortGuestTeam(guestTeam.getShortTeamName());
                        flag = true;
                    }
                }
                // 主队
                if (homeTeam != null) {
                    if (!match.getShortHomeTeam().equals(homeTeam.getShortTeamName())) {
                        match.setShortHomeTeam(homeTeam.getShortTeamName());
                        flag = true;
                    }
                }

                if(TimeTools.getBbEndSaleTime(match.getMatchTime(), props.getDsAheadTime()).getTime() <= System.currentTimeMillis()) {
                    match.setStatus(MatchStatus.SALEEND.ordinal());
                    flag = true;
                }
                arrangeList.add(match);
            }
            basketBallService.attachDirty(arrangeList);

        } catch (Exception e) {
            LogUtil.error(e);
        }
        LogUtil.info("----------竞彩篮球自动维护线程抓取新赛事结束-----------");
        return;
    }

    /**
     * SP值生成
     * @param matchIdMap
     * @param lType
     */
    public void buildAwardInfo(Map<String, Integer> matchIdMap, LotteryType lType) {
        LogUtil.info("开始执行" + lType.getName() + "玩法保存奖金值任务");
        AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
        List<PassMode> pmList = new ArrayList<PassMode>();
        pmList.add(PassMode.SINGLE);
        pmList.add(PassMode.PASS);
        for (PassMode pm : pmList) {
            // 拿到抓取过来的奖金值
            List<SFAward> tempAwardList = SportteryGrabberUtil.getAwardList(lType, (byte) pm.ordinal());
            if (!tempAwardList.isEmpty()) {
                for (SFAward tempAward : tempAwardList) {
                    Integer intTime = tempAward.getIntTime();
                    Integer lineId = tempAward.getLineId();
                    if (matchIdMap.get(intTime + "_" + lineId) != null) {
                        //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
                        SFAward award = basketBallService.getAwardSpecial(intTime, lineId, pm, en);
                        if (award == null) {
                            tempAward.setWinOrBigChange(0);
                            tempAward.setLoseOrSmallChange(0);
                            tempAward.setBsChange(0);
                            tempAward.setBsUpdateTime(new Date());
                            tempAward.setHandicapChange(0);
                            tempAward.setHandUpdateTime(new Date());
                        } else {
                            Double winOrBigAward = award.getWinOrBigAward();
                            Double tempWinOrBigAward = tempAward.getWinOrBigAward();
                            Double loseOrSmall=award.getLoseOrSmallAward();
                            Double tempLoseOrSmall=tempAward.getLoseOrSmallAward();
                            if (loseOrSmall.equals(tempLoseOrSmall)&&tempWinOrBigAward.equals(winOrBigAward)
                                    && tempAward.getHandicap().equals(award.getHandicap())
                                    && tempAward.getBaseBigOrSmall().equals(award.getBaseBigOrSmall())) {
                                continue;
                            }
                            int winOrBigChange = getSWchange(tempWinOrBigAward, winOrBigAward);
                            int loseOrSmallChange = getSWchange(tempAward.getLoseOrSmallAward(), award.getLoseOrSmallAward());
                            tempAward.setWinOrBigChange(winOrBigChange);
                            tempAward.setLoseOrSmallChange(loseOrSmallChange);
                            int bsChange = getSWchange(tempAward.getBaseBigOrSmall(), award.getBaseBigOrSmall());
                            int handicapChange = getSWchange(tempAward.getHandicap(),award.getHandicap());
                            tempAward.setBsChange(bsChange);
                            tempAward.setHandicapChange(handicapChange);
                            tempAward.setBsUpdateTime(new Date());
                            tempAward.setHandUpdateTime(new Date());
                            if(winOrBigChange == 0 && loseOrSmallChange == 0 && bsChange == 0 && handicapChange == 0){
                                tempAward.setId(award.getId());
                            }
                        }
                        tempAward.setMatchId(matchIdMap.get(intTime + "_" + lineId));
                        tempAward.setLastUpdateTime(new Date());
                        basketBallService.attachDirty(tempAward, en);
                    }

                }
            }
        }
        LogUtil.info("执行" + lType.getName() + "玩法保存奖金值任务完成");
    }

    /**
     * 分差SP值生成
     * @param matchIdMap
     * @param lType
     */
    public void buildFcawardInfo(Map<Integer, List<BasketBallMatch>> matchMap, Map<String, Integer> matchIdMap, LotteryType lType) {
        LogUtil.info("开始执行" + lType.getName() + "玩法保存奖金值任务");
        AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
        if (!matchMap.keySet().isEmpty()) {
            // 数据库中的奖金值
            //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
            List<AbstractAward> awardList = basketBallService.getAwardListByIntTimeListAndPlayType(matchMap.keySet(), lType);
            Map<String, AbstractAward> awardMap = new HashMap<String, AbstractAward>();
            for (AbstractAward award : awardList) {
                String key = award.getIntTime() + "_" + award.getLineId() + "_" + award.getPassMode();
                awardMap.put(key, award);
            }
            // 拿到抓取过来的奖金值
            List<AbstractAward> tempAwardList = new ArrayList<AbstractAward>();
            for (byte i = 0; i <= 1; i++) {
                List<AbstractAward> temp = SportteryGrabberUtil.getAwardList(lType, i);
                tempAwardList.addAll(temp);
            }
            // 遍历容器，与数据中的对象进行比较，如果有，则更新，无则插入
            for (AbstractAward s : tempAwardList) {
                String key = s.getIntTime() + "_" + s.getLineId() + "_" + s.getPassMode();
                AbstractAward tempAward = awardMap.get(key);
                Integer matchId = matchIdMap.get(s.getIntTime() + "_" + s.getLineId());
                if (tempAward == null) {
                    if (matchId != null) {
                        s.setMatchId(matchId);
                        s.setLastUpdateTime(new Date());
                        this.basketBallService.saveAward(s, en);
                    }
                } else {
                    tempAward.setAwardArr(s.getAwardArr());
                    tempAward.setLastUpdateTime(new Date());
                    this.basketBallService.attachDirty(tempAward, en);
                }
            }
        }
        LogUtil.info("执行" + lType.getName() + "玩法保存奖金值任务完成");
    }

    /**
     * SP变化
     * @param d1
     * @param d2
     * @return
     */
    public int getSWchange(Double d1, Double d2) {
        if (d1 > d2) {
            return 1;
        } else if (d1 < d2) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * list转map
     * @param arrangeList
     * @return
     */
    public Map<String, BasketBallMatch> arrangeListToMap(List<BasketBallMatch> arrangeList) {
        Map<String, BasketBallMatch> arrangeMap = new LinkedHashMap<String, BasketBallMatch>();
        for (BasketBallMatch b : arrangeList) {
            arrangeMap.put(b.getMapKey(), b);
        }
        return arrangeMap;
    }
}
