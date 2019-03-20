package com.qiyun.serviceImpl;

import com.qiyun.checkBingo.BingoCheck;
import com.qiyun.checkBingo.SportteryBingoCheck;
import com.qiyun.commonModel.PlayType;
import com.qiyun.commonModel.TradeType;
import com.qiyun.httpUtil.WebConstants;
import com.qiyun.mapper2.LotteryPlan2Mapper;
import com.qiyun.mapper2.SportteryBasketMatch2Mapper;
import com.qiyun.mapper2.SportteryFootballMatch2Mapper;
import com.qiyun.mapper2.Ticket2Mapper;
import com.qiyun.model.*;
import com.qiyun.model2.*;
import com.qiyun.service.CheckBingoService;
//import com.qiyun.task.CheckBingoTask;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.CommonUtils;
import com.qiyun.commonModel.LotteryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("checkBingoService")
public class CheckBingoServiceImpl implements CheckBingoService {

    private static final int OPEN_DAY = 30;//保存最近开奖天数

    private HashMap<String, String> bingoCheckMap;

    public void setBingoCheckMap(HashMap<String, String> bingoCheckMap) {
        this.bingoCheckMap = bingoCheckMap;
    }
    private static Logger logger = LoggerFactory.getLogger(CheckBingoServiceImpl.class);

    @Resource
    SportteryBasketMatch2Mapper sportteryBasketMatch2Mapper;
    @Resource
    SportteryFootballMatch2Mapper sportteryFootballMatch2Mapper;
    @Resource
    LotteryPlan2Mapper lotteryPlan2Mapper;
    @Resource
    Ticket2Mapper ticket2Mapper;

    public HashMap<String, String> getOpenInfoMapForCheckBingo(LotteryTerm2 term, LotteryType type) {
        HashMap<String, String> openResultMap = new HashMap<String, String>();
        openResultMap.put("lotteryType", type.getValue() + "");
        openResultMap.put("term", term.getTerm());
        // 查出最近三十天的开奖的数据
        Map<String, Integer> timeMap = CommonUtils.getBgTimeAndEdTime(OPEN_DAY);
        Integer bgintTime = timeMap.get(CommonUtils.beginIntTimeKey);
        Integer edintTime = timeMap.get(CommonUtils.endIntTimeKey);
        if (LotteryType.JCLQList.contains(type)) {// 竞彩篮球
            SportteryBasketMatch2Query sportteryBasketMatch2Query = new SportteryBasketMatch2Query();
            SportteryBasketMatch2Query.Criteria criteria = sportteryBasketMatch2Query.createCriteria();
            criteria.andInttimeBetween(bgintTime,edintTime);
            sportteryBasketMatch2Query.setOrderByClause("intTime,lineId");
            List<SportteryBasketMatch2> matchList = sportteryBasketMatch2Mapper.selectByExample(sportteryBasketMatch2Query);
            List<SportteryBasketMatch2> tempmatchList = new ArrayList<SportteryBasketMatch2>();
            for (SportteryBasketMatch2 match : matchList) {
                if (match.getStatus().intValue() != MatchStatus.ONSALE.ordinal()) {
                    tempmatchList.add(match);
                }
            }
            matchList = tempmatchList;
            // 无论是什么玩法，将所需要的参数全部设置进去
            for (SportteryBasketMatch2 bm : matchList) {
                String tempKey = bm.getInttime() + "_" + bm.getLineid();
                Integer homeScore = bm.getHomescore();
                Integer guestScore = bm.getGuestscore();
                if (homeScore == null || guestScore == null) {
                    if (bm.getStatus().equals(2)) {// 取消的赛事
                        openResultMap.put(CommonUtils.homeScoreKey + tempKey, "-1"); //和竞彩足球保持一致
                        openResultMap.put(CommonUtils.guestScoreKey + tempKey, "-1");
                        openResultMap.put(CommonUtils.handicapKey + tempKey, "0");
                        openResultMap.put(CommonUtils.bigSmallKey + tempKey, "0");
                        openResultMap.put(CommonUtils.resultSFKey + tempKey, "1");
                        openResultMap.put(CommonUtils.resultSFCKey + tempKey, "1");
                        openResultMap.put(CommonUtils.resultRFSFKey + tempKey, "1");
                        openResultMap.put(CommonUtils.resultDXFKey + tempKey, "1");
                    } else {
                        continue;
                    }
                } else {
                    String Handicap = "0";
                    if (bm.getSingleHandicap() != null)
                        Handicap = bm.getSingleHandicap().toString();// 让分
                    Double SFResult = bm.getResultofsf() == null ? 0d : bm.getResultofsf();
                    Double RFSFResult = bm.getResultofrfsf() == null ? 0d : bm.getResultofrfsf();
                    Double DXFResult = bm.getResultofdxf() == null ? 0d : bm.getResultofdxf();
                    Double SFCResult = bm.getResultofsfc() == null ? 0d : bm.getResultofsfc();
                    Double bigSmallBase = bm.getSingleBasebigorsmall() == null ? 0d : bm.getSingleBasebigorsmall();// 大小分基数
                    openResultMap.put(CommonUtils.homeScoreKey + tempKey, homeScore.toString());
                    openResultMap.put(CommonUtils.guestScoreKey + tempKey, guestScore.toString());
                    openResultMap.put(CommonUtils.handicapKey + tempKey, Handicap);
                    openResultMap.put(CommonUtils.bigSmallKey + tempKey, bigSmallBase.toString());
                    openResultMap.put(CommonUtils.resultSFKey + tempKey, SFResult.toString());
                    openResultMap.put(CommonUtils.resultSFCKey + tempKey, SFCResult.toString());
                    openResultMap.put(CommonUtils.resultRFSFKey + tempKey, RFSFResult.toString());
                    openResultMap.put(CommonUtils.resultDXFKey + tempKey, DXFResult.toString());
                }
            }
        } else if (LotteryType.JCZQList.contains(type)) {// 竞彩足球
            SportteryFootballMatch2Query sportteryFootballMatch2Query = new SportteryFootballMatch2Query();
            SportteryFootballMatch2Query.Criteria criteria = sportteryFootballMatch2Query.createCriteria();
            criteria.andInttimeBetween(bgintTime,edintTime);
            sportteryFootballMatch2Query.setOrderByClause("intTime,lineId");
            List<SportteryFootballMatch2> matchList = sportteryFootballMatch2Mapper.selectByExample(sportteryFootballMatch2Query);
            List<SportteryFootballMatch2> tempmatchList = new ArrayList<SportteryFootballMatch2>();
            for (SportteryFootballMatch2 match : matchList) {//
                if (match.getStatus().intValue() != MatchStatus.ONSALE.ordinal()) {
                    tempmatchList.add(match);
                }
            }
            matchList = tempmatchList;
            // 无论是什么玩法，将所需要的参数全部设置进去
            for (SportteryFootballMatch2 bm : matchList) {
                String tempKey = bm.getInttime() + "_" + bm.getLineid();
                Integer homeScore = bm.getHomescore();
                Integer guestScore = bm.getGuestscore();
                Integer halfhomeScore = bm.getHalfhomescore();
                Integer halfGuestScore = bm.getHalfguestscore();
                if (bm.getStatus().equals(2)) {//  取消的赛事
                    openResultMap.put(CommonUtils.homeScoreKey + tempKey, "-1");
                    openResultMap.put(CommonUtils.guestScoreKey + tempKey, "-1");
                    openResultMap.put(CommonUtils.resultHalfHomeScore + tempKey, "-1");
                    openResultMap.put(CommonUtils.resultHalfGuestScore + tempKey, "-1");
                    openResultMap.put(CommonUtils.resultRQSPFKey + tempKey, "1");
                    openResultMap.put(CommonUtils.resultSPFKey + tempKey, "1");
                    openResultMap.put(CommonUtils.resultBFKey + tempKey, "1");
                    openResultMap.put(CommonUtils.resultJQSKey + tempKey, "1");
                    openResultMap.put(CommonUtils.resultBQCKey + tempKey, "1");
                    openResultMap.put(CommonUtils.CONCEDEKEY + tempKey, "0");
                } else {
                    if (homeScore == null || guestScore == null) {
                        continue;
                    } else {
                        String Handicap = "0";
                        if (bm.getConcede() != null)
                            Handicap = bm.getConcede().toString();// 让球
                        Double SPFResult = bm.getResultawardoftotopass() == null ? 0d : bm.getResultawardoftotopass();
                        Double RQSPFResult = bm.getResultrqawardoftotopass() == null ? 0d : bm.getResultrqawardoftotopass();
                        Double BFResult = bm.getResultawardofsinglescore() == null ? 0d : bm.getResultawardofsinglescore();
                        Double JQSResult = bm.getResultawardofscorepass() == null ? 0d : bm.getResultawardofscorepass();
                        Double BQCResult = bm.getResultawardofhftotopass() == null ? 0d : bm.getResultawardofhftotopass();

                        openResultMap.put(CommonUtils.resultHalfHomeScore + tempKey, halfhomeScore.toString());
                        openResultMap.put(CommonUtils.resultHalfGuestScore + tempKey, halfGuestScore.toString());
                        openResultMap.put(CommonUtils.CONCEDEKEY + tempKey, Handicap);
                        openResultMap.put(CommonUtils.homeScoreKey + tempKey, homeScore.toString());
                        openResultMap.put(CommonUtils.guestScoreKey + tempKey, guestScore.toString());
                        openResultMap.put(CommonUtils.resultRQSPFKey + tempKey, RQSPFResult.toString());
                        openResultMap.put(CommonUtils.resultSPFKey + tempKey, SPFResult.toString());
                        openResultMap.put(CommonUtils.resultBFKey + tempKey, BFResult.toString());
                        openResultMap.put(CommonUtils.resultJQSKey + tempKey, JQSResult.toString());
                        openResultMap.put(CommonUtils.resultBQCKey + tempKey, BQCResult.toString());
                    }
                }
            }
        }

        if(!LotteryType.GYJ_ZQ_LIST.contains(type) &&
                !LotteryType.JCZQList.contains(type) &&
                !LotteryType.JCLQList.contains(type) &&
                !LotteryType.DCZQList.contains(type)) {
            if (term.getResult()==null || term.getResult().equals("")) {
                try {
                    throw new Exception("开奖结果未录入!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            openResultMap.put("result", term.getResult());
            // 将奖金描述解析成 List<PrizeBean>
            List<PrizeBean> beanList = PrizeCommon.buildToList(type.getValue(), term.getResultDetail());
            if (beanList == null || beanList.size() == 0) {
                try {
                    throw new Exception("奖金解析失败，请联系管理员!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (term.getResultDetail() == null || term.getResultDetail().equals("")) {
                try {
                    throw new Exception("开奖奖金未录入!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 奖List<PrizeBean>注入到openResultMap,以供开奖
            for (int i = 0; i < beanList.size(); i++) {
                PrizeBean bean = beanList.get(i);
                openResultMap.put(bean.getPrizeName(), bean.getAmount());
            }
        }
        return openResultMap;
    }

    /**
     * 开奖业务
     * @param openResultMap
     * @return
     */
    public List<LotteryPlan2WithBLOBs> checkBingo(HashMap<String, String> openResultMap) {
        List<LotteryPlan2WithBLOBs> bingoList = new ArrayList<LotteryPlan2WithBLOBs>();
        //获取参数
        String term = openResultMap.get("term");
        String lotteryType = openResultMap.get("lotteryType");
        Long startTime = System.currentTimeMillis();
        //查找已经出票&未开奖 的方案
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andPlanStatusEqualTo(PlanStatus.TICKET_OUT.getValue());
        criteria.andWinStatusEqualTo(WinStatus.NOT_RESULT.getValue());
        criteria.andTradeTypeEqualTo(TradeType.TRADE_BALANCE.getValue());
        criteria.andLotteryTypeEqualTo(Integer.parseInt(lotteryType));
        lotteryPlan2Query.setOrderByClause("plan_no desc");
        if (LotteryType.JCLQList.contains(LotteryType.getItem(Integer.parseInt(lotteryType))) || LotteryType.JCZQList.contains(LotteryType.getItem(Integer.parseInt(lotteryType)))) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -30);
            Date time = cal.getTime();
            criteria.andPrintTicketDateTimeGreaterThanOrEqualTo(time);
        }
        List<LotteryPlan2WithBLOBs> planList = lotteryPlan2Mapper.selectByExampleWithBLOBs(lotteryPlan2Query);

        if (planList!=null && planList.size()>0) {
            LogUtil.info("待开奖方案数："+planList.size());
            for (LotteryPlan2WithBLOBs lotteryPlan : planList) {
                if (Integer.parseInt(lotteryType) == LotteryType.JXSSC.getValue()) {//江西时时彩
                    openResultMap.put("amount", lotteryPlan.getAmount() + "");
                }
                if (Integer.parseInt(lotteryType) == LotteryType.GD11X5.getValue() || Integer.parseInt(lotteryType) == LotteryType.SYYDJ.getValue()) {//广东11x5 || 山东11选5
                    openResultMap.put("account", lotteryPlan.getAccount() + "");
                }

                //开奖
                if (planCheckBingo(openResultMap, lotteryPlan)) {
                    bingoList.add(lotteryPlan);
                }
            }
        }
        LogUtil.info("中奖方案数："+bingoList.size());
        return bingoList;
    }

    /**
     * 未支付方案开奖
     * @param openResultMap
     * @return
     */
    public List<LotteryPlan2WithBLOBs> checkBingoForNoPay(HashMap<String, String> openResultMap) {
        List<LotteryPlan2WithBLOBs> bingoList = new ArrayList<LotteryPlan2WithBLOBs>();
        //获取参数
        String term = openResultMap.get("term");
        String lotteryType = openResultMap.get("lotteryType");
        Long startTime = System.currentTimeMillis();
        //查找未支付&未开奖 的方案
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andPlanStatusEqualTo(PlanStatus.NOT_PAY.getValue());
        criteria.andWinStatusEqualTo(WinStatus.NOT_RESULT.getValue());
        criteria.andTradeTypeEqualTo(TradeType.TRADE_BALANCE.getValue());
        lotteryPlan2Query.setOrderByClause("plan_no desc");
        if (LotteryType.JCLQList.contains(LotteryType.getItem(Integer.parseInt(lotteryType))) || LotteryType.JCZQList.contains(LotteryType.getItem(Integer.parseInt(lotteryType)))) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -30);
            Date time = cal.getTime();
            criteria.andPrintTicketDateTimeGreaterThanOrEqualTo(time);
        }
        List<LotteryPlan2WithBLOBs> planList = lotteryPlan2Mapper.selectByExampleWithBLOBs(lotteryPlan2Query);

        if (planList!=null && planList.size()>0) {
            for (LotteryPlan2WithBLOBs lotteryPlan : planList) {
                if (Integer.parseInt(lotteryType) == LotteryType.JXSSC.getValue()) {//江西时时彩
                    openResultMap.put("amount", lotteryPlan.getAmount() + "");
                }
                if (Integer.parseInt(lotteryType) == LotteryType.GD11X5.getValue() || Integer.parseInt(lotteryType) == LotteryType.SYYDJ.getValue()) {//广东11x5 || 山东11选5
                    openResultMap.put("account", lotteryPlan.getAccount() + "");
                }

                //开奖
                if (planCheckBingo(openResultMap, lotteryPlan)) {
                    bingoList.add(lotteryPlan);
                }
            }
        }

        return bingoList;
    }

    private boolean planCheckBingo(HashMap<String, String> openResultMap, LotteryPlan2WithBLOBs lotteryPlan) {
        boolean isBingo = false;
        String clazzString = bingoCheckMap.get(lotteryPlan.getLotteryType() + "");
        BingoCheck check = null;
        BingoCheck oldCheck = null;
        try {
            check = (BingoCheck) Class.forName(clazzString).newInstance();
            oldCheck = (BingoCheck) Class.forName(clazzString).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Ticket2Query ticket2Query = new Ticket2Query();
        Ticket2Query.Criteria criteria = ticket2Query.createCriteria();
        criteria.andPlanNoEqualTo(lotteryPlan.getPlanNo());
        criteria.andStatusEqualTo(4);
        List<Ticket2WithBLOBs> ticketList = ticket2Mapper.selectByExampleWithBLOBs(ticket2Query);

        for (int j = 0; j < ticketList.size(); j++) {
            Ticket2WithBLOBs t = ticketList.get(j);
            openResultMap.put("ticketAmount", t.getAmount()+"");//开奖器需要用到(比如北单全部取消比赛,重庆11选5加奖)
            String tempContent=null;
            if(t.getLotteryType() == LotteryType.DLT.getValue()){
                tempContent=t.getPlayType() + ":" + t.getContent() + "=" + t.getAddAttribute();
            }else if(LotteryType.JCLQList.contains(LotteryType.getItem(t.getLotteryType())) || LotteryType.JCZQList.contains(LotteryType.getItem(t.getLotteryType()))){
                tempContent = t.getContent();
            }else{
                tempContent = t.getPlayType() + ":" + t.getContent();
            }
            check.execute(tempContent, PlayType.getItem(t.getPlayType()), t.getMultiple(), openResultMap);
            double bingoAmount=check.getBingoPosttaxTotal();
            if(t.getBingoAmount()==null || bingoAmount!=t.getBingoAmount()) {// 开奖金额不一致,更新开奖时间
                if (check.isBingo()) {
                    t.setIsBingo(0);
                    //1.查询不是发单人
                    if(t.getWinStatus()!=WinStatus.SEND_AWARD.getValue()){//已派奖的票不更新状态
                        t.setWinStatus(WinStatus.AWARD.getValue());
                        t.setOpenResultTime(new Date());
                        t.setBingoContent(check.getBingoContent());
                        t.setBingoAmount(bingoAmount);
                    }
                } else {
                    t.setIsBingo(1);
                    if(LotteryType.JCLQList.contains(LotteryType.getItem(lotteryPlan.getLotteryType())) || LotteryType.JCZQList.contains(LotteryType.getItem(lotteryPlan.getLotteryType()))){
                        SportteryBingoCheck sf =  (SportteryBingoCheck) check;
                        if(sf.isOpenAble()){ //防止竞技彩玩法有赛事没结果,不能开奖情况
                            t.setWinStatus(WinStatus.NOT_AWARD.getValue());//未中奖
                            t.setOpenResultTime(new Date());
                            t.setBingoContent(check.getBingoContent());
                            t.setBingoAmount(bingoAmount);
                        }else{
                            t.setWinStatus(WinStatus.NOT_RESULT.getValue()); //未开奖
                            t.setOpenResultTime(null);
                            t.setBingoContent(null);
                            t.setBingoAmount(null);
                        }
                    }else{
                        t.setOpenResultTime(new Date());
                        t.setBingoContent(check.getBingoContent());
                        t.setBingoAmount(bingoAmount);
                        t.setWinStatus(WinStatus.NOT_AWARD.getValue());
                    }
                }
            }
            ticket2Mapper.updateByPrimaryKeySelective(t);
            if (j == 0) {
                try {
                    oldCheck = check.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            } else {
                oldCheck.addCheck(check);
            }
            try {
                check = (BingoCheck) Class.forName(clazzString).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (oldCheck.isBingo()) {
            isBingo = true;
        }
        if(WebConstants.CLL.equals(WebConstants.WEB_SITE_NAME)){
            if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryPlan.getLotteryType()))||LotteryType.JCZQList.contains(LotteryType.getItem(lotteryPlan.getLotteryType()))){
                SportteryBingoCheck b = (SportteryBingoCheck) oldCheck;
                //新增非分步派奖代码2015-9-16  更新中奖状态
                if (b.isOpenAble()) {
                    updateBingoPlan(lotteryPlan, oldCheck);
                } else {
                    LogUtil.info("-----------------方案号：" + lotteryPlan.getPlanNo() + " 有未出赛果的场次，不能开奖！！！");
                }
            } else if(LotteryType.gpMap.containsKey(lotteryPlan.getLotteryType())) {
                updateAddPrizePlan(lotteryPlan, oldCheck, 0);
            }else {
                updateBingoPlan(lotteryPlan, oldCheck);
            }
            //更新分享表
            //this.updateShareStatus(lotteryPlan);
        }
        return isBingo;
    }

    //更新加奖方案
    private void updateAddPrizePlan(LotteryPlan2WithBLOBs lotteryPlan, BingoCheck oldCheck, int addPrize) {
        //添加开奖时间信息
        if(lotteryPlan.getPosttaxPrize()!=oldCheck.getBingoPosttaxTotal()){
            LogUtil.info(lotteryPlan.getPlanNo() + "中奖设置开奖时间" + new Date());
            lotteryPlan.setOpenResultTime(new Date());
        }
        if(!oldCheck.isBingo()){
            LogUtil.info(lotteryPlan.getPlanNo() + "不中奖设置开奖时间" + new Date());
            lotteryPlan.setOpenResultTime(new Date());
        }
        lotteryPlan.setPrizeContent(oldCheck.getBingoContent());

        if(addPrize > 0) {
            lotteryPlan.setPretaxPrize(oldCheck.getBingoPretaxTotal() + addPrize);
            lotteryPlan.setPosttaxPrize(oldCheck.getBingoPosttaxTotal() + addPrize);
            lotteryPlan.setAddPrize((double) addPrize);//记录真实用户加奖金额
        } else {
            lotteryPlan.setPretaxPrize(oldCheck.getBingoPretaxTotal());
            lotteryPlan.setPosttaxPrize(oldCheck.getBingoPosttaxTotal());
        }

        lotteryPlan.setWinStatus(oldCheck.isBingo()?WinStatus.AWARD.getValue():WinStatus.NOT_AWARD.getValue());
        lotteryPlan.setOpenFinish(1); //票全部开完奖
        lotteryPlan2Mapper.updateByPrimaryKeySelective(lotteryPlan);
    }

    private LotteryPlan2WithBLOBs updateBingoPlan(LotteryPlan2WithBLOBs plan, BingoCheck check) {
        boolean allowUpdate=true; //是否允许更新方案
        boolean isPartOpen=false; //是否部分开奖.
        boolean isOpenAble=true;//是否全部开完奖
        if(LotteryType.JCZQList.contains(LotteryType.getItem(plan.getLotteryType())) || LotteryType.JCLQList.contains(LotteryType.getItem(plan.getLotteryType()))){
            SportteryBingoCheck bc =(SportteryBingoCheck)check;
		    /*暂屏蔽分步派奖代码2015-9-16
		    isOpenAble=bc.isOpenAble();
			if(plan.getPlanType()==PlanType.HM || plan.getGenType()==GenType.EXPERT_TIPS || isFailurePlan){ //这些情况只有全部赛事出赛果,才开奖
				allowUpdate=bc.isOpenAble();
			}else{
				allowUpdate=true;
				isPartOpen=true;
			}
			*/
            //新增非分步派奖代码2015-9-16
            allowUpdate=bc.isOpenAble();
            isOpenAble=bc.isOpenAble();
        }
        LogUtil.info("方案"+plan.getPlanNo()+"是否允许更新状态:"+allowUpdate);
        if(allowUpdate){
            //添加开奖时间信息
            if(plan.getPosttaxPrize()!=check.getBingoPosttaxTotal()){
                LogUtil.info(plan.getPlanNo() + "中奖设置开奖时间" + new Date());
                plan.setOpenResultTime(new Date());
            }
            if(!check.isBingo()){
                LogUtil.info(plan.getPlanNo() + "不中奖设置开奖时间" + new Date());
                plan.setOpenResultTime(new Date());
            }
            plan.setPrizeContent(check.getBingoContent());
            LogUtil.info(plan.getPlanNo() + "getBingoContent:" + check.getBingoContent());
            plan.setPretaxPrize(check.getBingoPretaxTotal());
            plan.setPosttaxPrize(check.getBingoPosttaxTotal());

            if(isPartOpen){ //部分开奖
                LogUtil.info("方案"+plan.getPlanNo()+"进行分步开奖");
                if (check.isBingo()){ //已中奖,走分布派奖
                    if(plan.getWinStatus()!=WinStatus.PART_SEND.getValue() ){//已部分派奖的方案不更新状态
                        plan.setWinStatus(WinStatus.PART_AWARD.getValue());
                    }
                } else {//未中奖,设置未中奖
                    plan.setWinStatus(isOpenAble?WinStatus.NOT_AWARD.getValue():WinStatus.PART_NOT_AWARD.getValue());
                }
            }else{
                plan.setWinStatus(check.isBingo()?WinStatus.AWARD.getValue():WinStatus.NOT_AWARD.getValue());
            }
            plan.setOpenFinish(isOpenAble?1:0);
            lotteryPlan2Mapper.updateByPrimaryKeySelective(plan);
        }
        return plan;
    }
}
