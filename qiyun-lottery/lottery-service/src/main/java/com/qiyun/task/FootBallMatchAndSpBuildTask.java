package com.qiyun.task;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.grabber.model.PlatformEnum;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.PassMode;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model.football.MatchAwardOfRQSPF;
import com.qiyun.model.football.MatchAwardOfSPF;
import com.qiyun.model2.Config;
import com.qiyun.service.FootBallService;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.StringTools;
import com.qiyun.utils.basketball.SportteryGrabberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Lazy(value=false)
public class FootBallMatchAndSpBuildTask {
    @Autowired
    private FootBallService footBallService;

    /**
     * 竞彩足球SP任务触发器
     */
    @Scheduled(cron = "0 0/3 * * * ?")//每隔三分钟处理一次
    private void updateAward() {
        LogUtil.info("----竞彩足球维护赛程,SP开始-----");
        //抓取新的赛程
        snatchNewMatch();
        Config configById = footBallService.getConfigById(1);
        Integer spSource = configById.getSpSource();
        if(spSource == 1) {
            List<LotteryType> typeList = LotteryType.JCZQList;
            // 拿到对阵先,组装一下MATCH，拿到所有对阵的intTime_lineId值
            //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
            List<FootBallMatch> matchs = footBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
            Map<Integer, List<FootBallMatch>> matchListMap = new HashMap<Integer, List<FootBallMatch>>();
            Map<String, FootBallMatch> matchTeamInfoMap = new HashMap<String, FootBallMatch>();

            for (FootBallMatch match : matchs) {
                Integer intTime = match.getIntTime();
                List<FootBallMatch> matchList = matchListMap.get(intTime);
                if (matchList == null) matchList = new ArrayList<FootBallMatch>();
                matchList.add(match);
                matchListMap.put(intTime, matchList);
                String key = match.getIntTime() + "_" + match.getLineId();
                matchTeamInfoMap.put(key, match);
            }
            for (LotteryType lType : typeList) {
                //竞彩足球混投是抓取各个玩法的sp ,不需要更新跳过
                //胜平负/让球胜平负玩法 sp由checkData()方法保存
                if (LotteryType.JC_HT_LIST.contains(lType) || LotteryType.JC_ZQ_SPF == lType
                        || LotteryType.JC_ZQ_RQSPF == lType) {
                    continue;
                }
                LogUtil.info("开始执行" + lType.getName() + "玩法保存奖金值任务");
                AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
                if (!matchTeamInfoMap.keySet().isEmpty()) {
                    // 数据库中的奖金值
                    List<AbstractAward> dbAwardList = footBallService
                            .getAwardListByIntTimeListAndPlayType(matchListMap.keySet(), lType);
                    Map<String, AbstractAward> dbAwardMap = new HashMap<String, AbstractAward>();
                    for (AbstractAward award : dbAwardList) {
                        String key = award.getIntTime() + "_" + award.getLineId() + "_" + award.getPassMode();
                        dbAwardMap.put(key, award);
                    }
                    // 拿到抓取过来的奖金值
                    Map<String, AbstractAward> tempAwardMap = new HashMap<String, AbstractAward>();
                    List<AbstractAward> temp = SportteryGrabberUtil.getAwardList(lType, (byte) 1);
                    for (AbstractAward award : temp) {
                        if (award.getPassMode() == PassMode.PASS.ordinal()) { //SINGLE 忽略
                            String key = award.getIntTime() + "_" + award.getLineId() + "_" + award.getPassMode();
                            tempAwardMap.put(key, award);
                        }
                    }
                    // 遍历容器，与数据中的对象进行比较，如果无则插入
                    for (Map.Entry<String, AbstractAward> entry : tempAwardMap.entrySet()) {
                        String key = entry.getKey();
                        AbstractAward tempAward = entry.getValue();
                        FootBallMatch match = matchTeamInfoMap.get(tempAward.getIntTime() + "_" + tempAward.getLineId());
                        if (match == null) {
                            continue;
                        }
                        key = match.getIntTime() + "_" + match.getLineId() + "_" + tempAward.getPassMode();
                        AbstractAward dbAward = dbAwardMap.get(key);
                        //默认都保存
                        boolean isChange = true;
                        if (dbAward != null) {
                            if (lType.getValue() == LotteryType.JC_ZQ_RQSPF.getValue()) {
                                MatchAwardOfRQSPF dbSPFAward = (MatchAwardOfRQSPF) dbAward;
                                isChange = dbSPFAward.checkAwardIsChange(tempAward);
                            } else if (lType.getValue() == LotteryType.JC_ZQ_SPF.getValue()) {
                                MatchAwardOfSPF dbSPFAward = (MatchAwardOfSPF) dbAward;
                                isChange = dbSPFAward.checkAwardIsChange(tempAward);
                            } else {
                                isChange = dbAward.checkAwardIsChange(tempAward);
                            }
                        }
                        if (match != null && isChange) {
                            tempAward.setMatchId(match.getId());
                            tempAward.setIntTime(match.getIntTime());
                            tempAward.setLastUpdateTime(new Date());
                            tempAward.setCreateDate(new Date());
                            tempAward = this.footBallService.saveAward(tempAward, en);
                        }
                    }
                    LogUtil.info("执行" + lType.getName() + "玩法保存奖金值任务完成");
                } else {
                    LogUtil.info("抓取对阵为空，返回");
                }
            }
            checkData(matchs);
//		saveFile(matchs);
            LogUtil.info("----竞彩足球维护赛程,SP结束-----");
        }
    }

    /**
     * 赛事抓取
     */
    private void snatchNewMatch() {
        LogUtil.info("----------竞彩自动维护线程抓取新赛事开始-----------");
        try {
            Set<Integer> intTimeSet=new HashSet<Integer>();
            /** 得到抓取的数据* */
            List<FootBallMatch> fballList = SportteryGrabberUtil.getMatchList(PlatformEnum.FOOTBALL.name());
            for (FootBallMatch ms : fballList) {
                intTimeSet.add(ms.getIntTime());
            }
            //根据抓取到的数据intTime集合 查询数据库数据
            List<FootBallMatch> dbMatchs = this.footBallService.getMatchListByIntTime(intTimeSet);
            Map<String, FootBallMatch> dbMap = new HashMap<String, FootBallMatch>();
            for (FootBallMatch match : dbMatchs) {
                dbMap.put(match.getMapKey(), match);
            }
            for (FootBallMatch ms : fballList) {
                if (dbMap.containsKey(ms.getMapKey())) {
                    if(dbMap.get(ms.getMapKey()).getStatus() == 0) {//对阵为正常销售情况下，才更新状态
                        dbMap.get(ms.getMapKey()).setShowNum(ms.getShowNum());
                    }
                } else {
                    LogUtil.info("---竞彩足球抓取赛程:"+ms.getMapKey()+"--主队VS客队:"+ms.getHomeTeam()
                            +"vs"+ms.getGuestTeam()+";比赛时间:"+ DateTools.dateToString(ms.getMatchTime())
                            +";让球:"+ms.getConcede()+"---");
                    dbMap.put(ms.getMapKey(), ms);
                }
            }
            /** 新的容器* */
            List<FootBallMatch> arrangeList = new ArrayList<FootBallMatch>();
            for (String key : dbMap.keySet()) {
                arrangeList.add(dbMap.get(key));
            }
            footBallService.attachDirty(arrangeList);
        } catch (Exception e) {
            LogUtil.error(e);
        }
        LogUtil.info("----------竞彩自动维护线程抓取新赛事结束-----------");
    }

    /**
     * 重新check胜平负/让球胜平负的概率/SP数据
     *
     * @param dbMatchList
     */
    private void checkData(List<FootBallMatch> dbMatchList) {
        //对比每条记录sp是否存在, 存在:检查概率是否存在,无则更新. 不存在:插入新数据
        Map<String,List<AbstractAward>> rateMap =new HashMap<String, List<AbstractAward>>();//缓存概率map
        List<LotteryType> typeList = new ArrayList<LotteryType>();
        typeList.add(LotteryType.JC_ZQ_SPF);
        typeList.add(LotteryType.JC_ZQ_RQSPF);
        for (LotteryType lType : typeList) {
            LogUtil.info("---检查" + lType.getName() + "的概率数据开始---");
            AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
            if (dbMatchList != null && !dbMatchList.isEmpty()) {
                Map<String, AbstractAward> webAwardMap = new LinkedHashMap<String, AbstractAward>();
                List<AbstractAward> tempList = SportteryGrabberUtil.getAwardList(lType, (byte) 1);// 只需要过关sp
                for (AbstractAward award : tempList) {
                    String sportteryMatchId = null;// 竞彩官网对阵ID,用于抓取概率
                    if (lType == LotteryType.JC_ZQ_SPF) {
                        MatchAwardOfSPF spfAward = (MatchAwardOfSPF) award;
                        sportteryMatchId = spfAward.getSportteryMatchId();
                    } else if (lType == LotteryType.JC_ZQ_RQSPF) {
                        MatchAwardOfRQSPF rqspfAward = (MatchAwardOfRQSPF) award;
                        sportteryMatchId = rqspfAward.getSportteryMatchId();
                    }
                    if (!StringTools.isNullOrBlank(sportteryMatchId)) {
                        String key = award.getIntTime() + "_" + award.getLineId()+"_"+lType.getValue();
                        if(!rateMap.containsKey(key)){
                            Map<String,List<AbstractAward>> tmpRateMap = SportteryGrabberUtil
                                    .getFbAwardRateList(sportteryMatchId, award.getIntTime(), award.getLineId());
                            rateMap.putAll(tmpRateMap);
                        }
                        // 抓取概率和奖金值
                        List<AbstractAward> newAwardList =rateMap.get(key);
                        if(newAwardList!=null){
                            for (AbstractAward newAward : newAwardList) {
                                newAward.setIntTime(award.getIntTime());
                                newAward.setLineId(award.getLineId());
                                Double[] awardArr = newAward.getAwardArr();
                                String upTime=DateTools.dateToString(newAward.getLastUpdateTime(),
                                        "yyyyMMddHHmmss");
                                String newKey = award.getIntTime()+"_"+award.getLineId() + "_"
                                        + awardArr[0] + "_" + awardArr[1] + "_" + awardArr[2]+"_"+upTime;
                                webAwardMap.put(newKey, newAward);
                            }
                        }
                    }
                }
                List<Integer> matchIdList = new ArrayList<Integer>();
                Map<String, FootBallMatch> matchMap = new HashMap<String, FootBallMatch>();
                for (FootBallMatch match : dbMatchList) {
                    matchIdList.add(match.getId());
                    matchMap.put(match.getMapKey(), match);
                }

                Map<String, List<AbstractAward>> awardMap = footBallService.findAllAward(matchIdList,
                        lType, PassMode.PASS);
                Map<String, AbstractAward> dbAwardMap = new HashMap<String, AbstractAward>();
                if (awardMap != null) {
                    // 组装数据
                    for (Map.Entry<String, List<AbstractAward>> entry : awardMap.entrySet()) {
                        List<AbstractAward> dbList = entry.getValue();
                        for (AbstractAward dbAward : dbList) {
                            Double[] awardArr = dbAward.getAwardArr();
                            String upTime=DateTools.dateToString(dbAward.getLastUpdateTime(),"yyyyMMddHHmmss");
                            String dbkey = dbAward.getIntTime() + "_" + dbAward.getLineId() + "_" + awardArr[0] + "_" + awardArr[1] + "_"
                                    + awardArr[2]+"_"+upTime;
                            dbAwardMap.put(dbkey, dbAward);
                        }
                    }
                    Map<String, List<AbstractAward>> reloadDbMap = new HashMap<String, List<AbstractAward>>();// 如果有新插入的数据,需要重新计算homeChange
                    // 对比数据
                    for (Map.Entry<String, AbstractAward> entry : webAwardMap.entrySet()) {
                        AbstractAward webAward = entry.getValue();
                        if (!dbAwardMap.containsKey(entry.getKey())) {
                            String matchKey = webAward.getIntTime() + "_" + webAward.getLineId();
                            FootBallMatch match = matchMap.get(matchKey);
                            if(match==null){
                                continue;
                            }
                            webAward.setMatchId(match.getId());
                            webAward.setMatchTime(match.getMatchTime());
                            // 不存在插入
                            List<AbstractAward> dbAwardList = reloadDbMap.get(matchKey);
                            if (dbAwardList == null) {
                                dbAwardList = new ArrayList<AbstractAward>();
                                List<AbstractAward> tmpDbList = awardMap.get(matchKey);
                                if (tmpDbList != null) {// 添加已经查询出来的数据
                                    dbAwardList.addAll(tmpDbList);
                                }
                            }
                            dbAwardList.add(webAward);// 添加新增的数据
                            reloadDbMap.put(matchKey, dbAwardList);
                        } else { // 更新
                            AbstractAward dbAward = dbAwardMap.get(entry.getKey());
                            if (dbAward instanceof MatchAwardOfSPF) {
                                MatchAwardOfSPF newDbAward = (MatchAwardOfSPF) dbAward;
                                MatchAwardOfSPF newWebAward = (MatchAwardOfSPF) webAward;
                                if (newDbAward.getHomeRate() == null) {
                                    newDbAward.setHomeRate(newWebAward.getHomeRate());
                                    newDbAward.setDrawRate(newWebAward.getDrawRate());
                                    newDbAward.setGuestRate(newWebAward.getGuestRate());
                                    newDbAward.setLastUpdateTime(newWebAward.getLastUpdateTime());
                                    footBallService.attachDirty(newDbAward, en);
                                }
                            } else {
                                MatchAwardOfRQSPF newDbAward = (MatchAwardOfRQSPF) dbAward;
                                MatchAwardOfRQSPF newWebAward = (MatchAwardOfRQSPF) webAward;
                                if (newDbAward.getHomeRate() == null) {
                                    newDbAward.setHomeRate(newWebAward.getHomeRate());
                                    newDbAward.setDrawRate(newWebAward.getDrawRate());
                                    newDbAward.setGuestRate(newWebAward.getGuestRate());
                                    newDbAward.setLastUpdateTime(newWebAward.getLastUpdateTime());
                                    footBallService.attachDirty(newDbAward, en);
                                }
                            }
                        }
                    }
                    // 重新计算homeChange
                    if (!reloadDbMap.isEmpty()) {
                        LogUtil.info("======重新计算homechange========");
                        for (Map.Entry<String, List<AbstractAward>> entry : reloadDbMap.entrySet()) {
                            List<AbstractAward> list = entry.getValue();
                            Collections.sort(list, new Comparator<AbstractAward>() {
                                public int compare(AbstractAward o1, AbstractAward o2) {
                                    return o1.getLastUpdateTime().compareTo(o2.getLastUpdateTime());
                                }
                            });
                            AbstractAward prevAward = null;
                            for (AbstractAward award : list) {
                                if (lType.getValue() == LotteryType.JC_ZQ_RQSPF.getValue()) {
                                    MatchAwardOfRQSPF dbSPFAward = (MatchAwardOfRQSPF) award;
                                    if (prevAward == null) {
                                        dbSPFAward.setHomeChange(0);
                                        dbSPFAward.setDrawChange(0);
                                        dbSPFAward.setGuestChange(0);
                                    } else {
                                        prevAward.checkAwardIsChange(dbSPFAward);
                                    }
                                    prevAward = dbSPFAward;
                                } else if (lType.getValue() == LotteryType.JC_ZQ_SPF.getValue()) {
                                    MatchAwardOfSPF dbSPFAward = (MatchAwardOfSPF) award;
                                    if (prevAward == null) {
                                        dbSPFAward.setHomeChange(0);
                                        dbSPFAward.setDrawChange(0);
                                        dbSPFAward.setGuestChange(0);
                                    } else {
                                        prevAward.checkAwardIsChange(dbSPFAward);
                                    }
                                    prevAward = dbSPFAward;
                                }
                                footBallService.attachDirty(prevAward, en);
                            }
                        }
                    }
                }
            }
            LogUtil.info("---检查" + lType.getName() + "的概率数据结束---");
        }
    }
}
