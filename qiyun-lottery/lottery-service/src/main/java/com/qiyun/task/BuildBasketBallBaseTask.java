package com.qiyun.task;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.grabber.model.PlatformEnum;
import com.qiyun.httpUtil.WebConstants;
import com.qiyun.model.BasketBallBase;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.BasketBallGame;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.basketball.BasketBallTeam;
import com.qiyun.model.bean.BasketBallBaseBean;
import com.qiyun.service.BasketBallService;
import com.qiyun.service.BasketTeamService;
import com.qiyun.service.BasketballDataService;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.FileTools;
import com.qiyun.utils.StringTools;
import com.qiyun.utils.basketball.SnatchBasketBallDataUtil;
import com.qiyun.utils.basketball.SportteryGrabberUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.qiyun.util.Constants.dateOffsetLimit;

/**
 * 抓取500w 对阵入资料库basketBallBase
 * 1.抓取对阵入库,得到数据和500w的gameName
 * 2.根据gameName 查找BasketballGame, 并更新BasketballGame 和资料库的gameId
 * 3.根据homeTeam/guestTeam查找 basketballTeam表,并更新basketballTeam和资料库的homeId/guestId
 *
 * @author Administrator
 *
 */
@Component
@Lazy(value=false)
public class BuildBasketBallBaseTask {
    @Autowired
    private BasketballDataService basketballDataService;
    @Autowired
    private BasketTeamService basketTeamService;
    @Autowired
    private BasketBallService basketBallService;

    @Scheduled(cron = "0 0/3 * * * ?")//每隔3分钟处理一次
    public void BasketBallBase(){
        LogUtil.info("--------------保存篮球赛事到篮球资料库开始---------------");
        try{
            List<BasketBallBaseBean> allMatchList=new ArrayList<BasketBallBaseBean>();
            for (int i = 0; i < dateOffsetLimit; i++) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_YEAR, -i); //前3天.抓取赛果
                String date = DateTools.dateToString(cal.getTime(), "yyyy-MM-dd");
                List<BasketBallBaseBean> matchList = SnatchBasketBallDataUtil.get500wMatch(date);
                allMatchList.addAll(matchList);
            }
            for (int i = 0; i < dateOffsetLimit; i++) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_YEAR, +i);//后3天抓取数据
                String date = DateTools.dateToString(cal.getTime(), "yyyy-MM-dd");
                List<BasketBallBaseBean> matchList = SnatchBasketBallDataUtil.get500wMatch(date);
                allMatchList.addAll(matchList);
            }

            buildBasketBallBase(allMatchList);
            LogUtil.info("-----保存篮球赛事到篮球资料库成功,场次数"+allMatchList.size()+"-------");
        } catch (Exception e) {
            LogUtil.error("-----保存篮球赛事到篮球资料库失败-------",e);
        }
        LogUtil.info("---------------保存篮球赛事到篮球资料库结束---------------");
    }

    /**
     * 1. 抓取500w的全称 fullName
     * 2. fullName 查找数据库
     * 3. 抓来的投注页缩写 更新 game
     * @param baseMatchList
     */
    public void buildBasketBallBase(List<BasketBallBaseBean> baseMatchList) {
        for (BasketBallBaseBean match : baseMatchList) {
            try {
                if (StringTools.isNullOrBlank(match.getMatchName())) {
                    continue;
                }
                BasketBallBase base = new BasketBallBase();

                //game表逻辑
                BasketBallGame game = basketballDataService.findGameByStandardName(match.getMatchName());
                if (game == null) {
                    game = new BasketBallGame();
                    game.setStandardName(match.getMatchName());
                }
                if(StringTools.isNullOrBlank(game.getShortName())){
                    game.setShortName(match.getShortMatchName());
                }
                game.setGameColor(match.getGameColor());
                basketballDataService.attachDirty(game);

                //Team表逻辑
                BasketBallTeam homeTeam = basketTeamService.getTeamInfoByFullName(match.getHome());
                BasketBallTeam guestTeam = basketTeamService.getTeamInfoByFullName(match.getGuest());
                if (homeTeam == null) {
                    homeTeam = new BasketBallTeam();
                    homeTeam.setFullTeamName(match.getHome());
                    homeTeam.setShortTeamName(match.getShortHome());
                    basketTeamService.saveIfChange(homeTeam);
                }else{
                    if(StringTools.isNullOrBlank(homeTeam.getShortTeamName())){
                        homeTeam.setShortTeamName(match.getShortHome());
                        basketTeamService.saveIfChange(homeTeam);
                    }
                }

                if (guestTeam == null) {
                    guestTeam = new BasketBallTeam();
                    guestTeam.setFullTeamName(match.getGuest());
                    guestTeam.setShortTeamName(match.getShortGuest());
                    basketTeamService.saveIfChange(guestTeam);
                }else{
                    if(StringTools.isNullOrBlank(guestTeam.getShortTeamName())){
                        guestTeam.setShortTeamName(match.getShortHome());
                        basketTeamService.saveIfChange(guestTeam);
                    }

                }

                base.setHomeId(homeTeam.getId());
                base.setGuestId(guestTeam.getId());
                base.setMatchName(match.getMatchName());
                base.setGameId(game.getId());
                base.setHome(match.getHome());
                base.setGuest(match.getGuest());
                base.setHomePm(match.getHomePm());
                base.setGuestPm(match.getGuestPm());
                base.setMatchTime(match.getMatchTime());
                base.setMatchDateStr(match.getMatchDateStr());
                base.setIntTime(match.getIntTime());
                base.setLineId(match.getLineId());
                base.setFirstSection(match.getFirstSection());
                base.setSecondSection(match.getSecondSection());
                base.setThirdSection(match.getThirdSection());
                base.setFourthSection(match.getFourthSection());
                base.setAddSection(match.getAddSection());
                base.setBfWhole(match.getBfWhole());
                basketballDataService.saveIfChange(base);
            } catch (Exception e) {
                LogUtil.error(e);
            }
        }
    }

    /**
     * 篮球sp创建修改
     */
//    @Scheduled(cron = "0 0/3 * * * ?")//每隔3分钟处理一次
//    public void updateAward() {
//        List<LotteryType> typeList = LotteryType.JCLQList;
//        // 拿到对阵先,组装一下MATCH，拿到所有对阵的intTime_lineId值
//        List<BasketBallMatch> matchs = basketBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
//        Map<Integer, List<BasketBallMatch>> matchMap = new HashMap<Integer, List<BasketBallMatch>>();
//        Map<String, Integer> matchIDMap = new HashMap<String, Integer>();
//        for (BasketBallMatch bbm : matchs) {
//            Integer intTime = bbm.getIntTime();
//            List<BasketBallMatch> matchList = matchMap.get(intTime);
//            if (matchList == null)
//                matchList = new ArrayList<BasketBallMatch>();
//            matchList.add(bbm);
//            matchMap.put(intTime, matchList);
//            String key = bbm.getIntTime() + "_" + bbm.getLineId();
//            matchIDMap.put(key, bbm.getId());
//        }
//        for (LotteryType lType : typeList) {
//            if(lType==LotteryType.JC_LQ_HT){
//                continue;
//            }
//            LogUtil.info("开始执行" + lType.getName() + "玩法保存奖金值任务");
//            AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
//            if (!matchMap.keySet().isEmpty()) {
//                // 数据库中的奖金值
//                List<AbstractAward> awardList = basketBallService.getAwardListByIntTimeListAndPlayType(
//                        matchMap.keySet(), lType);
//                Map<String, AbstractAward> awardMap = new HashMap<String, AbstractAward>();
//                for (AbstractAward award : awardList) {
//                    String key = award.getIntTime() + "_" + award.getLineId() + "_" + award.getPassMode();
//                    awardMap.put(key, award);
//                }
//                // 拿到抓取过来的奖金值
//                List<AbstractAward> tempAwardList = new ArrayList<AbstractAward>();
//                for (byte i = 0; i <= 1; i++) {
//                    List<AbstractAward> temp = SportteryGrabberUtil.getAwardList(lType, i);
//                    tempAwardList.addAll(temp);
//                }
//                Map<String, List<AbstractAward>> cacheMap = new HashMap<String, List<AbstractAward>>();
//                List<AbstractAward> cacheList = null;
//                // 遍历容器，与数据中的对象进行比较，如果有，则更新，无则插入
//                for (AbstractAward s : tempAwardList) {
//                    String key = s.getIntTime() + "_" + s.getLineId() + "_" + s.getPassMode();
//                    AbstractAward tempAward = awardMap.get(key);
//                    Integer matchId = matchIDMap.get(s.getIntTime() + "_" + s.getLineId());
//                    if (tempAward == null) {
//                        if (matchId != null) {
//                            s.setMatchId(matchId);
//                            s.setLastUpdateTime(new Date());
//                            s = basketBallService.saveAward(s, en);
//                            // 进行缓存操作
//                            String temkey = "PASS";
//                            if (s.getPassMode().intValue() == PassMode.SINGLE.ordinal()) {
//                                temkey = "SINGLE";
//                            }
//                            String cacheKey = lType.getValue() + "_" + temkey;
//                            cacheList = cacheMap.get(cacheKey);
//                            if (cacheList == null)
//                                cacheList = new ArrayList<AbstractAward>();
//                            cacheList.add(s);
//                            cacheMap.put(cacheKey, cacheList);
//                        }
//                    } else {
//                        tempAward.setAwardArr(s.getAwardArr());
//                        tempAward.setLastUpdateTime(new Date());
//                        tempAward = basketBallService.saveAward(tempAward, en);
//                        // 进行缓存操作
//                        String temkey = "PASS";
//                        if (tempAward.getPassMode().intValue() == PassMode.SINGLE.ordinal()) {
//                            temkey = "SINGLE";
//                        }
//                        String cacheKey = lType.getValue() + "_" + temkey;
//                        cacheList = cacheMap.get(cacheKey);
//                        if (cacheList == null)
//                            cacheList = new ArrayList<AbstractAward>();
//                        cacheList.add(s);
//                        cacheMap.put(cacheKey, cacheList);
//                    }
//                }
//                // 以玩法和过关方式作为KEY，奖金LIST作为VALUE生成缓存
//                for (String key : cacheMap.keySet()) {
//                    Map<String, AbstractAward> awardJsonMap = new HashMap<String, AbstractAward>();
//                    List<AbstractAward> teawardList = cacheMap.get(key);
//                    for (AbstractAward a : teawardList) {
//                        String awakey = a.getIntTime() + "_" + a.getLineId();
//                        awardJsonMap.put(awakey, a);
//                    }
//                    JSONObject infoJson = JSONObject.fromObject(awardJsonMap);
//                    try {
//                        FileTools.setFileContent(infoJson.toString(), WebConstants.getWebPath()
//                                + "/static/basketball/" + key + ".json");
//                    } catch (Exception e) {
//                        LogUtil.error(e);
//                    }
//                }
//                LogUtil.info("执行" + lType.getName() + "玩法保存奖金值任务完成");
//            } else {
//                LogUtil.info("抓取对阵为空，返回");
//            }
//        }
//    }

  /*  @Scheduled(cron = "0 0/3 * * * ?")//每隔3分钟处理一次
    public void updateAward() {
        List<LotteryType> typeList = LotteryType.JCLQList;
        // 拿到对阵先,组装一下MATCH，拿到所有对阵的intTime_lineId值
        List<BasketBallMatch> matchs = basketBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
        Map<Integer, List<BasketBallMatch>> matchMap = new HashMap<Integer, List<BasketBallMatch>>();
        Map<String, Integer> matchIDMap = new HashMap<String, Integer>();
        for (BasketBallMatch bbm : matchs) {
            Integer intTime = bbm.getIntTime();
            List<BasketBallMatch> matchList = matchMap.get(intTime);
            if (matchList == null)
                matchList = new ArrayList<BasketBallMatch>();
            matchList.add(bbm);
            matchMap.put(intTime, matchList);
            String key = bbm.getIntTime() + "_" + bbm.getLineId();
            matchIDMap.put(key, bbm.getId());
        }
        for (LotteryType lType : typeList) {
            if(lType==LotteryType.JC_LQ_HT){
                continue;
            }
            LogUtil.info("开始执行" + lType.getName() + "玩法保存奖金值任务");
            AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
            if (!matchMap.keySet().isEmpty()) {
                // 数据库中的奖金值
                List<AbstractAward> awardList = basketBallService.getAwardListByIntTimeListAndPlayType(
                        matchMap.keySet(), lType);
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
                Map<String, List<AbstractAward>> cacheMap = new HashMap<String, List<AbstractAward>>();
                List<AbstractAward> cacheList = null;
                // 遍历容器，与数据中的对象进行比较，如果有，则更新，无则插入
                for (AbstractAward s : tempAwardList) {
                    String key = s.getIntTime() + "_" + s.getLineId() + "_" + s.getPassMode();
                    AbstractAward tempAward = awardMap.get(key);
                    Integer matchId = matchIDMap.get(s.getIntTime() + "_" + s.getLineId());
                    if (tempAward == null) {
                        if (matchId != null) {
                            s.setMatchId(matchId);
                            s.setLastUpdateTime(new Date());
                            s = basketBallService.saveAward(s, en);
                            // 进行缓存操作
                            String temkey = "PASS";
                            if (s.getPassMode().intValue() == PassMode.SINGLE.ordinal()) {
                                temkey = "SINGLE";
                            }
                            String cacheKey = lType.getValue() + "_" + temkey;
                            cacheList = cacheMap.get(cacheKey);
                            if (cacheList == null)
                                cacheList = new ArrayList<AbstractAward>();
                            cacheList.add(s);
                            cacheMap.put(cacheKey, cacheList);
                        }
                    } else {
                        tempAward.setAwardArr(s.getAwardArr());
                        tempAward.setLastUpdateTime(new Date());
                        tempAward = basketBallService.saveAward(tempAward, en);
                        // 进行缓存操作
                        String temkey = "PASS";
                        if (tempAward.getPassMode().intValue() == PassMode.SINGLE.ordinal()) {
                            temkey = "SINGLE";
                        }
                        String cacheKey = lType.getValue() + "_" + temkey;
                        cacheList = cacheMap.get(cacheKey);
                        if (cacheList == null)
                            cacheList = new ArrayList<AbstractAward>();
                        cacheList.add(s);
                        cacheMap.put(cacheKey, cacheList);
                    }
                }
                // 以玩法和过关方式作为KEY，奖金LIST作为VALUE生成缓存
                for (String key : cacheMap.keySet()) {
                    Map<String, AbstractAward> awardJsonMap = new HashMap<String, AbstractAward>();
                    List<AbstractAward> teawardList = cacheMap.get(key);
                    for (AbstractAward a : teawardList) {
                        String awakey = a.getIntTime() + "_" + a.getLineId();
                        awardJsonMap.put(awakey, a);
                    }
                    JSONObject infoJson = JSONObject.fromObject(awardJsonMap);
                    try {
                        FileTools.setFileContent(infoJson.toString(), WebConstants.getWebPath()
                                + "/static/basketball/" + key + ".json");
                    } catch (Exception e) {
                        LogUtil.error(e);
                    }
                }
                LogUtil.info("执行" + lType.getName() + "玩法保存奖金值任务完成");
            } else {
                LogUtil.info("抓取对阵为空，返回");
            }
        }
    }*/

    /**
     * 更新胜负,让分胜负，大小分数据
     */
//    @Scheduled(cron = "0 0/3 * * * ?")//每隔3分钟处理一次
//    public void updateSFRFandDX() {
//        // 数据库中的让分胜负对阵
//        List<BasketBallMatch> dbMatchList = basketBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
//        Map<String, BasketBallMatch> matchMap = new HashMap<String, BasketBallMatch>();
//        for (BasketBallMatch match : dbMatchList) {
//            String key = match.getIntTime() + "_" + match.getLineId();
//            matchMap.put(key, match);
//        }
//        // 抓取到的让分基数
//        List<BasketBallMatch> tempRFSingle = SportteryGrabberUtil.getRFList(PlatformEnum.BASKETBALL.name(), (byte) 0);
//        for (BasketBallMatch tempMatch : tempRFSingle) {
//            String key = tempMatch.getIntTime() + "_" + tempMatch.getLineId();
//            BasketBallMatch match = matchMap.get(key);
//            if (match != null) {
//                if (!match.getSingle_handicap().equals(tempMatch.getSingle_handicap())) {
//                    match.setSingle_handicap(tempMatch.getSingle_handicap());
//                    basketBallService.save(match);
//                }
//            }
//        }
//        List<BasketBallMatch> tempRFPass = SportteryGrabberUtil.getRFList(PlatformEnum.BASKETBALL.name(), (byte) 1);
//        for (BasketBallMatch tempMatch : tempRFPass) {
//            String key = tempMatch.getIntTime() + "_" + tempMatch.getLineId();
//            BasketBallMatch match = matchMap.get(key);
//            if (match != null) {
//                if (!match.getHandicap().equals(tempMatch.getHandicap())) {
//                    match.setHandicap(tempMatch.getHandicap());
//                    basketBallService.save(match);
//                }
//            }
//        }
//        // 抓取到的大小分基数
//        List<BasketBallMatch> tempDXSingle = SportteryGrabberUtil.getDXbaseList(PlatformEnum.BASKETBALL.name(),
//                (byte) 0);
//        for (BasketBallMatch tempMatch : tempDXSingle) {
//            String key = tempMatch.getIntTime() + "_" + tempMatch.getLineId();
//            BasketBallMatch match = matchMap.get(key);
//            if (match != null) {
//                if (!match.getSingle_baseBigOrSmall().equals(tempMatch.getSingle_baseBigOrSmall())) {
//                    match.setSingle_baseBigOrSmall(tempMatch.getSingle_baseBigOrSmall());
//                    basketBallService.save(match);
//                }
//            }
//        }
//        List<BasketBallMatch> tempDXPass = SportteryGrabberUtil.getDXbaseList(PlatformEnum.BASKETBALL.name(), (byte) 1);
//        for (BasketBallMatch tempMatch : tempDXPass) {
//            String key = tempMatch.getIntTime() + "_" + tempMatch.getLineId();
//            BasketBallMatch match = matchMap.get(key);
//            if (match != null) {
//                if (!match.getBaseBigOrSmall().equals(tempMatch.getBaseBigOrSmall())) {
//                    match.setBaseBigOrSmall(tempMatch.getBaseBigOrSmall());
//                    basketBallService.save(match);
//                }
//            }
//        }
//    }

  /*  @Scheduled(cron = "0 0/3 * * * ?")//每隔3分钟处理一次
    public void updateSFRFandDX() {
        // 数据库中的让分胜负对阵
        List<BasketBallMatch> dbMatchList = basketBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
        Map<String, BasketBallMatch> matchMap = new HashMap<String, BasketBallMatch>();
        for (BasketBallMatch match : dbMatchList) {
            String key = match.getIntTime() + "_" + match.getLineId();
            matchMap.put(key, match);
        }
        // 抓取到的让分基数
        List<BasketBallMatch> tempRFSingle = SportteryGrabberUtil.getRFList(PlatformEnum.BASKETBALL.name(), (byte) 0);
        for (BasketBallMatch tempMatch : tempRFSingle) {
            String key = tempMatch.getIntTime() + "_" + tempMatch.getLineId();
            BasketBallMatch match = matchMap.get(key);
            if (match != null) {
                if (!match.getSingle_handicap().equals(tempMatch.getSingle_handicap())) {
                    match.setSingle_handicap(tempMatch.getSingle_handicap());
                    basketBallService.save(match);
                }
            }
        }
        List<BasketBallMatch> tempRFPass = SportteryGrabberUtil.getRFList(PlatformEnum.BASKETBALL.name(), (byte) 1);
        for (BasketBallMatch tempMatch : tempRFPass) {
            String key = tempMatch.getIntTime() + "_" + tempMatch.getLineId();
            BasketBallMatch match = matchMap.get(key);
            if (match != null) {
                if (!match.getHandicap().equals(tempMatch.getHandicap())) {
                    match.setHandicap(tempMatch.getHandicap());
                    basketBallService.save(match);
                }
            }
        }
        // 抓取到的大小分基数
        List<BasketBallMatch> tempDXSingle = SportteryGrabberUtil.getDXbaseList(PlatformEnum.BASKETBALL.name(),
                (byte) 0);
        for (BasketBallMatch tempMatch : tempDXSingle) {
            String key = tempMatch.getIntTime() + "_" + tempMatch.getLineId();
            BasketBallMatch match = matchMap.get(key);
            if (match != null) {
                if (!match.getSingle_baseBigOrSmall().equals(tempMatch.getSingle_baseBigOrSmall())) {
                    match.setSingle_baseBigOrSmall(tempMatch.getSingle_baseBigOrSmall());
                    basketBallService.save(match);
                }
            }
        }
        List<BasketBallMatch> tempDXPass = SportteryGrabberUtil.getDXbaseList(PlatformEnum.BASKETBALL.name(), (byte) 1);
        for (BasketBallMatch tempMatch : tempDXPass) {
            String key = tempMatch.getIntTime() + "_" + tempMatch.getLineId();
            BasketBallMatch match = matchMap.get(key);
            if (match != null) {
                if (!match.getBaseBigOrSmall().equals(tempMatch.getBaseBigOrSmall())) {
                    match.setBaseBigOrSmall(tempMatch.getBaseBigOrSmall());
                    basketBallService.save(match);
                }
            }
        }
    }*/

    /**
     * 生成静态页面（新版不使用）
     */
    public void updateOpAndHref() {
        List<BasketBallMatch> tempMatchList = basketBallService.findMatchByStatus(0);

        if (!tempMatchList.isEmpty() && tempMatchList.get(0) != null) {
            int intTime = tempMatchList.get(0).getIntTime();
            Map<String, String> infoMap = SportteryGrabberUtil.getBballInfo();
            JSONObject infoJson = JSONObject.fromObject(infoMap);
            try {
                FileTools.setFileContent(infoJson.toString(),
                        WebConstants.getWebPath() + "/static/basketball/bball_" + intTime + ".txt");
            } catch (Exception e) {
                LogUtil.error(e);
            }
        }
    }

    /**
     * 生成静态页面（新版不使用）
     */
    public void updateScheduledMatch(){
        StringBuffer sb=SnatchBasketBallDataUtil.getScheduledMatch();
        try {
            FileTools.setFileContent(sb.toString(),
                    WebConstants.getWebPath() + "/static/basketMatch/ScheduledMatch.htm");
        } catch (Exception e) {
            LogUtil.error(e);
        }
    }

//    public static void main(String[] args) {
//        BuildBasketBallBaseTask buildBasketBallBaseTask = new BuildBasketBallBaseTask();
//        buildBasketBallBaseTask.updateAward();
//    }
}
