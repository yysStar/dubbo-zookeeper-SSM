//package com.qiyun.task;
//
//import com.qiyun.grabber.model.AbstractAward;
//import com.qiyun.grabber.model.AwardListEnum;
//import com.qiyun.model.*;
//import com.qiyun.model.basketball.BasketBallMatch;
//import com.qiyun.model.basketball.BasketballDxp;
//import com.qiyun.model.basketball.BasketballOp;
//import com.qiyun.model.basketball.BasketballYp;
//import com.qiyun.service.BasketBetService;
//import com.qiyun.service.BasketballDataService;
//import com.qiyun.service.LotteryTypePropsService;
//import com.qiyun.tools.DateTools;
//import com.qiyun.tools.StringTools;
//import com.qiyun.util.Constants;
//import com.qiyun.util.LogUtil;
//import com.qiyun.utils.TimeTools;
//import com.qiyun.commonModel.LotteryType;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
//@Component
//@Lazy(value=false)
//public class BasketMatchTask {
//    @Autowired
//    private BasketBetService basketBallService;
//    @Autowired
//    private BasketballDataService basketballDataService;
//    @Autowired
//    private LotteryTypePropsService lotteryTypePropsService;
//
//    private static Map<String,Integer> gameSortMap;
//
//    static {
//        gameSortMap=new HashMap<String,Integer>();
//        gameSortMap.put("NBA",1);
//        gameSortMap.put("世锦赛",2);
//        gameSortMap.put("WNBA",3);
//    }
//
//    /**
//     * 篮球模版生成
//     * @throws Exception
//     */
////    @Scheduled(cron = "0 0/3 * * * ?")//每隔三分钟处理一次
//    public void getFreeMarkerBasketBallMatch() throws Exception {
//        List<String> termList = DateTools.getDESCDatesBetween(DateTools.getNMonthBeforeCurrentDay(3),
//                DateTools.getNowDateYYYY_MM_DD(),"yyyy-MM-dd");
//        String currentTerm = DateTools.getNowDateYYYY_MM_DD();
//        LotteryTypeProps props = lotteryTypePropsService.findById(LotteryType.JC_LQ_RFSF.getValue());
//        for (LotteryType lotteryType : LotteryType.JCLQList) {
//            for (PassMode passMode : PassMode.values()) {
//                if(lotteryType == LotteryType.JC_LQ_DGTZ) {
//                    LogUtil.info("单关...");
//                }
//                if (passMode.ordinal() == PassMode.SINGLE.ordinal() && lotteryType != LotteryType.JC_LQ_SFC
//                        && lotteryType != LotteryType.JC_LQ_DGTZ) {
//                    continue;
//                }
//                if (passMode.ordinal() == PassMode.PASS.ordinal() && lotteryType.getValue() == LotteryType.JC_LQ_DGTZ.getValue()) {
//                    continue;
//                }
//                HashMap<String, Object> root = new HashMap<String, Object>();
//                LogUtil.info("生成" + lotteryType.getName() + passMode.getText() + "模板信息开始");
//                List<BasketBallMatch> raceList=null;
//                //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//                raceList= basketBallService.findMatchListByToday(lotteryType,
//                        BasketBallPlayType.getByLotteryType(lotteryType), passMode);
//                //如果是过关，且只有一场赛事，就不显示
//                if(passMode.ordinal()==PassMode.PASS.ordinal() && raceList.size()<2) {
//                    raceList.clear();
//                }
//
//                if(lotteryType==LotteryType.JC_LQ_DGTZ){
//                    raceList=listSort(raceList);
//                }
//                Map<String, Integer> gameCountMap = new LinkedHashMap<String, Integer>();// 统计相同赛事拥有的场数
//                Map<String, String> termCountMap = new LinkedHashMap<String, String>();// 统计相同日期
//                Map<String, String> resultMap = new HashMap<String, String>();// 比赛结果集合
//                String nowDateText = DateTools.dateToString(new Date(), "MM月dd日");
//                Map<String, Boolean> isShowMap = new HashMap<String, Boolean>();
//                int cnt = 0;// 已停售场次
//                List<Integer> matchIdList = new ArrayList<Integer>();
//                List<String> intTimeList = new ArrayList<String>();
//                Map<String,Integer> weekCountMap=new HashMap<String, Integer>();
//                String today = "今天 "+DateTools.dateToString(new Date(), "MM/dd");
//
//                Map<String,List<BasketBallMatch>> gameNameMap=new HashMap<String, List<BasketBallMatch>>();//按联赛分类
//                Map<String,List<BasketBallMatch>> saleDateMap=new LinkedHashMap<String, List<BasketBallMatch>>();//在售的赛事,按intTime分类
//                Map<String,List<BasketBallMatch>> stopDateMap=new LinkedHashMap<String, List<BasketBallMatch>>(); //停售的赛事,按intTime分类
//                Map<String,List<BasketBallMatch>>  focusMap=new HashMap<String, List<BasketBallMatch>>();//焦点赛事
//                focusMap.put("焦点赛事", new ArrayList<BasketBallMatch>());
//                List<Integer> oddIdList=new ArrayList<Integer>();
//                for (BasketBallMatch race : raceList) {
//					/*  SFSINGLE(0, "胜负单场", "00"),
//						SFPASS(1, "胜负过关", "01"),
//						RFSFSINGLE(2, "让分胜负单场", "10"),
//						RFSFPASS(3, "让分胜负过关", "11"),
//						SFCSINGLE(4, "胜分差单场", "20"),
//						SFCPASS(5, "胜分差过关", "21"),
//						DXFSINGLE(6, "大小分单场", "30"),
//						DXFPASS(7, "大小分过关", "31");
//
//					boolean s1=race.getStatusIsSale(MatchShowStatus.SFSINGLE);
//					boolean s2=race.getStatusIsSale(MatchShowStatus.SFPASS);
//					boolean s3=race.getStatusIsSale(MatchShowStatus.RFSFSINGLE);
//					boolean s4=race.getStatusIsSale(MatchShowStatus.RFSFPASS);
//					boolean s5=race.getStatusIsSale(MatchShowStatus.SFCSINGLE);
//					boolean s6=race.getStatusIsSale(MatchShowStatus.SFCPASS);
//					boolean s7=race.getStatusIsSale(MatchShowStatus.DXFSINGLE);
//					boolean s8=race.getStatusIsSale(MatchShowStatus.DXFPASS);
//					* */
//                    if(!StringTools.isNullOrBlank(race.getOutId())){
//                        oddIdList.add(Integer.parseInt(race.getOutId()));
//                    }
//
//                    String gameName = race.getShortGameName();
//                    Integer gameCount = gameCountMap.get(gameName);
//                    if (gameCount == null) {
//                        gameCount = 0;
//                    }
//                    if (race.getStatus() == MatchStatus.ONSALE.ordinal()) {// 只统计销售的赛事
//                        gameCount++;
//                    }
//                    gameCountMap.put(gameName, gameCount);
//
//                    Date showDate = race.getShowDate();
//                    String dateText = DateTools.dateToString(showDate, "MM月dd日");
//                    if (nowDateText.equals(dateText)) {
//                        dateText += "(今天)";
//                    }
//                    String date = DateTools.dateToString(showDate, "yyyyMMdd");
//                    termCountMap.put(dateText, date);
//                    if (race.getStatus() != MatchStatus.ONSALE.ordinal()) {
//                        cnt++;
//                        isShowMap.put(Constants.PREFIX_S + race.getIntTime(), false);
//                    } else {
//                        isShowMap.put(Constants.PREFIX_S + race.getIntTime(), true);
//                    }
//                    if (!matchIdList.contains(race.getId())) {
//                        matchIdList.add(race.getId());
//                    }
//                    if (!intTimeList.contains(race.getIntTime())) {
//                        intTimeList.add(race.getIntTime() + "");
//                    }
//                    Date endTime = TimeTools.getBbEndSaleTime(race.getMatchTime(), props.getFsAheadTime());
//                    race.setEndTime(endTime);// 截止日期
//                    OptionItem resultOption = race.getResult(lotteryType);
//                    if (resultOption != null) {
//                        resultMap.put(Constants.PREFIX_R + race.getId(), resultOption.getValue());
//                    }
//
//                    String week=race.getWeekStr();
//                    String key=week;
//                    if (nowDateText.equals(DateTools.dateToString(showDate, "MM月dd日"))) {
//                        key = today;
//                    }else{
//                        key+=" "+DateTools.dateToString(showDate,"MM/dd");
//                    }
//
//                    if(race.getStatus()==MatchStatus.ONSALE.ordinal()){
//                        Integer weekCnt=weekCountMap.get(week);
//                        if(weekCnt==null){
//                            weekCnt=1;
//                        }else{
//                            weekCnt++;
//                        }
//                        weekCountMap.put(week, weekCnt);
//
//
//                        List<BasketBallMatch> bbList=gameNameMap.get(gameName);
//                        bbList=bbList==null?new ArrayList<BasketBallMatch>():bbList;
//
//                        List<BasketBallMatch> dateList=saleDateMap.get(key);
//                        dateList=dateList==null?new ArrayList<BasketBallMatch>():dateList;
//
//                        if(    race.getStatusIsSale(MatchShowStatus.SFSINGLE)  || race.getStatusIsSale(MatchShowStatus.RFSFSINGLE)
//                                || race.getStatusIsSale(MatchShowStatus.SFCSINGLE) || race.getStatusIsSale(MatchShowStatus.DXFSINGLE)){
//                            dateList.add(race);
//                            saleDateMap.put(key, dateList); //按intTime分类
//                            bbList.add(race);
//                            gameNameMap.put(gameName, bbList); //按联赛名分类
//                            //焦点赛事 单关让分胜负开售
//                            boolean rfsfSingle=race.getStatusIsSale(MatchShowStatus.RFSFSINGLE);
//                            if(rfsfSingle){
//                                focusMap.get("焦点赛事").add(race);
//                            }
//                        }
//
//                    }else{
//                        List<BasketBallMatch> dateList=stopDateMap.get(key);
//                        dateList=dateList==null?new ArrayList<BasketBallMatch>():dateList;
//                        dateList.add(race);
//                        stopDateMap.put(key, dateList); //按intTime分类
//                    }
//                }
//
//                if(!oddIdList.isEmpty()){
//                    //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//                    List<BasketBallBase> baseList=basketballDataService.findByIds(oddIdList);
//                    if(baseList!=null){
//                        Map<String,BasketBallBase> baseMap=new HashMap<String, BasketBallBase>();
//                        for (int i = 0,len=baseList.size(); i <len; i++) {
//                            BasketBallBase base =baseList.get(i);
//                            baseMap.put(base.getMapKey(),base);
//                        }
//                        for (BasketBallMatch race : raceList) {
//                            BasketBallBase base = baseMap.get(race.getMapKey());
//                            if(base!=null){
//                                String homePm=base.getHomePm();
//                                String guestPm=base.getGuestPm();
//                                if (homePm != null && guestPm != null && homePm.length() < 5 && guestPm.length() < 5) {
//                                    race.setShowPm(true);
//                                } else {
//                                    race.setShowPm(false);
//                                }
//                                race.setBasketBallBase(base);
//                            }
//                        }
//                    }
//                }
//
//                Map<String, AbstractAward> awardMap = null;
//                // sp 数据
//                // freemark map 如果是map<Integer,> 页面无法使用map[key]
//                if (lotteryType == LotteryType.JC_LQ_SFC) {
//                    awardMap = getAwardMapSFC(matchIdList, lotteryType);
//                } else if (LotteryType.JC_HT_LIST.contains(lotteryType)) {
//                    awardMap = getHTAwardMapByIntTimes(intTimeList);
//                    Map<String, Double> resultAwardMap_HT = new HashMap<String, Double>();
//                    for (BasketBallMatch match : raceList) {
//                        HTAward award=(HTAward) awardMap.get(Constants.PREFIX_A+match.getId());
//                        if(award!=null){
//                            Double sfc=award.getAwardByOption(match.getSFCResult());
//                            resultAwardMap_HT.put(Constants.PREFIX_A + match.getId() + "_" + LotteryType.JC_LQ_SFC.getValue(), sfc);
//                        }
//                    }
//                    root.put("resultAwardMap_HT", resultAwardMap_HT);
//                } else {
//                    awardMap = getAwardMapByIntTimes(intTimeList, lotteryType);
//                }
//                // rfsf,dxf-> 亚盘 sf,sfc->平均欧赔,
//                StringBuilder intTimes = new StringBuilder("");
//                for (String string : intTimeList) {
//                    intTimes.append("," + string);
//                }
//                intTimes = intTimes.delete(0, 1);
//                // 亚盘数据
//                if (LotteryType.JC_LQ_RFSF == lotteryType) {
//                    //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//                    List<BasketballYp> ypList = basketballDataService.getYpListByintTimes(intTimes.toString());
//                    Map<String, Map<String, BasketballYp>> allYpMap = new HashMap<String, Map<String, BasketballYp>>();
//                    for (String company : BasketballYp.COMAPNY.values()) {
//                        Map<String, BasketballYp> tempYpMap = new HashMap<String, BasketballYp>();
//                        allYpMap.put(company, tempYpMap);
//                    }
//                    if (ypList != null) {
//                        for (BasketballYp yp : ypList) {
//                            if (yp != null && yp.getCompany() != null) {
//                                Map<String, BasketballYp> tempYpMap = allYpMap.get(BasketballYp.COMAPNY.get(yp.getCompany()));
//                                if (tempYpMap != null) {
//                                    tempYpMap.put(Constants.PREFIX_YP + yp.getMatchId(), yp);
//                                }
//                            }
//                        }
//                    }
//                    root.put("allYpMap", allYpMap);
//                } else if (LotteryType.JC_LQ_SF == lotteryType || LotteryType.JC_LQ_SFC == lotteryType) {
//                    // 欧赔数据 只查询 平均欧赔
//                    String company = BasketballYp.COMAPNY.get(BasketballYp.AVG_COMPANY);// 平均欧赔
//                    //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//                    List<BasketballOp> opList = basketballDataService.getOpListByintTimes(intTimeList,
//                            BasketballYp.AVG_COMPANY);
//                    Map<String, BasketballOp> tempOpMap = new HashMap<String, BasketballOp>();
//                    if (opList != null) {
//                        for (BasketballOp op : opList) {
//                            tempOpMap.put(Constants.PREFIX_OP + op.getMatchId(), op);
//                        }
//                    }
//                    root.put(company + "OpMap", tempOpMap);
//                }
//                // 大小盘数据 dxf
//                else if (LotteryType.JC_LQ_DXF == lotteryType) {
//                    //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//                    List<BasketballDxp> dxpList = basketballDataService.getDxpListByintTimes(intTimes.toString());
//                    Map<String, Map<String, BasketballDxp>> allDxpMap = new HashMap<String, Map<String, BasketballDxp>>();
//                    for (String company : BasketballDxp.COMAPNY.values()) {
//                        Map<String, BasketballDxp> tempDxpMap = new HashMap<String, BasketballDxp>();
//                        allDxpMap.put(company, tempDxpMap);
//                    }
//                    if (dxpList != null) {
//                        for (BasketballDxp dxp : dxpList) {
//                            if (dxp != null && dxp.getCompany() != null) {
//                                Map<String, BasketballDxp> tempDxpMap = (Map<String, BasketballDxp>) allDxpMap.get(BasketballDxp.COMAPNY.get(dxp
//                                        .getCompany()));
//                                if (tempDxpMap != null) {
//                                    tempDxpMap.put(Constants.PREFIX_DXF + dxp.getMatchId(), dxp);
//                                }
//                            }
//                        }
//                    }
//                    root.put("allDxpMap", allDxpMap);
//                }
//                root.put("weekCountMap", weekCountMap);
//                root.put("resultMap", resultMap);
//                root.put("awardMap", awardMap);
//                root.put("playType", lotteryType.getValue());
//                root.put("raceList", raceList);
//                root.put("focusMap", focusMap); //焦点赛事
//                root.put("gameNameMap", sortMap(gameNameMap));
//                root.put("saleDateMap", saleDateMap);
//                root.put("stopDateMap", stopDateMap);
//                root.put("gameCountMap", gameCountMap);
//                root.put("termCountMap", termCountMap);
//                root.put("isShowMap", isShowMap);
//                root.put("passMode", passMode.toString());
//                root.put("stopCount", cnt);
//                root.put("termList", termList);
//                root.put("currentTerm", currentTerm);
//                root.put("matchShowStatus", MatchShowStatus.values());
//                if(lotteryType==LotteryType.JC_LQ_DGTZ){
//                    FreeMarker.process(Constants.pathFlt, root, "dgtzHome.ftl",
//                            Constants.pathHtml + "jcbb_" + passMode.toString().toLowerCase() + "_"
//                            + lotteryType.getValue() + ".shtml");
//                    FreeMarker.process(Constants.pathFlt_3g, root, "bsHome.ftl",
//                            Constants.pathHtml_3g + "jcbb_" + passMode.toString().toLowerCase() + "_"
//                                    + lotteryType.getValue() + ".shtml");
//                }else{
//                    FreeMarker.process(Constants.pathFlt, root, "bsHome.ftl",
//                            Constants.pathHtml + "jcbb_" + passMode.toString().toLowerCase() + "_"
//                                    + lotteryType.getValue() + ".shtml");
//                    FreeMarker.process(Constants.pathFlt_3g, root, "bsHome.ftl",
//                            Constants.pathHtml_3g + "jcbb_" + passMode.toString().toLowerCase() + "_"
//                                    + lotteryType.getValue() + ".shtml");
//                }
//                LogUtil.info("生成" + lotteryType.getName() + passMode.getText() + "模板信息结束");
//            }
//        }
//    }
//
//    /**
//     * 类型转换
//     * @param raceList
//     * @return
//     */
//    private List<BasketBallMatch> listSort(List<BasketBallMatch> raceList){
//        if(raceList!=null){
//            Map<Integer,List<BasketBallMatch>> raceMap=new LinkedHashMap<Integer, List<BasketBallMatch>>();
//            for (BasketBallMatch race : raceList) {
//                List<BasketBallMatch> list=raceMap.get(race.getIntTime());
//                list=list==null?new ArrayList<BasketBallMatch>():list;
//                list.add(race);
//                raceMap.put(race.getIntTime(), list);
//            }
//            raceList.clear();
//            for (Map.Entry<Integer, List<BasketBallMatch>> entry : raceMap.entrySet()) {
//                Collections.sort(entry.getValue(),new Comparator<BasketBallMatch>(){
//                    public int compare(BasketBallMatch o1, BasketBallMatch o2) {
//                        Boolean b1=o1.getStatusIsSale(MatchShowStatus.RFSFSINGLE)
//                                ||o1.getStatusIsSale(MatchShowStatus.DXFSINGLE) ;
//                        Boolean b2=o2.getStatusIsSale(MatchShowStatus.RFSFSINGLE)
//                                ||o2.getStatusIsSale(MatchShowStatus.DXFSINGLE) ;
//                        //true.compareTo(false)=1
//                        int result=b2.compareTo(b1);
//                        if(result==0){
//                            result=o1.getLineId().compareTo(o2.getLineId());
//                        }
//                        return result;
//                    }
//                });
//                raceList.addAll(entry.getValue());
//            }
//        }
//        return raceList;
//    }
//
//    private Map<String,List<BasketBallMatch>> sortMap(Map<String,List<BasketBallMatch>> gameNameMap){
//        List<String> keys = new ArrayList<String>(gameNameMap.keySet());
//        Collections.sort(keys, new Comparator<String>(){
//            public int compare(String o1, String o2) {
//                Integer n1=gameSortMap.get(o1);
//                n1=n1==null?1000:n1;
//                Integer n2=gameSortMap.get(o2);
//                n2=n2==null?1000:n2;
//                return n1.compareTo(n2);
//            }
//
//        });
//        Map<String,List<BasketBallMatch>> linkMap=new LinkedHashMap<String, List<BasketBallMatch>>();
//        for (String key : keys) {
//            linkMap.put(key, gameNameMap.get(key));
//        }
//        return linkMap;
//    }
//
//    /**
//     * 篮球胜分差SP
//     * @param matchIdList
//     * @param lotteryType
//     * @return
//     */
//    private Map<String, AbstractAward> getAwardMapSFC(List<Integer> matchIdList, LotteryType lotteryType) {
//        Map<String, AbstractAward> newAwardMap = new HashMap<String, AbstractAward>();
//        if (matchIdList == null || matchIdList.isEmpty()) {
//            return newAwardMap;
//        }
//        Map<Integer, AbstractAward> awardMap = null;
//        //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//        awardMap = basketBallService.findMatchAwardMap(matchIdList, PassMode.PASS, lotteryType);
//        for (Map.Entry<Integer, AbstractAward> award : awardMap.entrySet()) {
//            newAwardMap.put(Constants.PREFIX_A + award.getKey(), award.getValue());
//        }
//        return newAwardMap;
//    }
//
//    /**
//     * 混投SP
//     * @param intTimeList
//     * @return
//     */
//    private Map<String, AbstractAward> getHTAwardMapByIntTimes(List<String> intTimeList) {
//        Map<String, AbstractAward> awardMap = new HashMap<String, AbstractAward>();
//        if (intTimeList == null || intTimeList.isEmpty()) {
//            return awardMap;
//        }
//        //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//        List<AbstractAward> awardList = basketBallService.findForBbHTAwardByIntTime(intTimeList, PassMode.PASS.ordinal());
//        if (awardList != null && !awardList.isEmpty()) {
//            for (AbstractAward award : awardList) {
//                if (award != null) {
//                    awardMap.put(Constants.PREFIX_A + award.getMatchId(), award);
//                }
//            }
//        }
//        return awardMap;
//    }
//
//    /**
//     * 通过销售日期获取SP
//     * @param intTimeList
//     * @param tempLotteryType
//     * @return
//     */
//    private Map<String, AbstractAward> getAwardMapByIntTimes(List<String> intTimeList, LotteryType tempLotteryType) {
//        Map<String, AbstractAward> awardMap = new HashMap<String, AbstractAward>();
//        if (intTimeList == null || intTimeList.isEmpty()) {
//            return awardMap;
//        }
//        StringBuilder intTimes = new StringBuilder("");
//        for (String string : intTimeList) {
//            intTimes.append("," + string);
//        }
//        intTimes = intTimes.delete(0, 1);
//        if (!intTimes.toString().equals("")) {
//            Integer pType = AwardListEnum.enumOfAwardByLotteryType(tempLotteryType).ordinal();
//            //CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//            List<AbstractAward> awardList = basketBallService.findForBbAwardByIntTime(intTimes.toString(),
//                    pType, PassMode.PASS.ordinal());
//            if (awardList != null && !awardList.isEmpty()) {
//                for (AbstractAward award : awardList) {
//                    if (award != null) {
//                        awardMap.put(Constants.PREFIX_A + award.getMatchId(), award);
//                    }
//                }
//            }
//        }
//        return awardMap;
//    }
//}
