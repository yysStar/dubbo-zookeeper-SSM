package com.qiyun.serviceImpl;

import com.qiyun.common.CommonStatus;
import com.qiyun.commonModel.PlayType;
import com.qiyun.commonModel.TradeType;
import com.qiyun.dto.Member2DTO;
import com.qiyun.mapper2.*;
import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallBetContent;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.model2.*;
import com.qiyun.service.DGService;
import com.qiyun.type.SelectType;
import com.qiyun.util.BigDecimalUtil;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.*;
import com.qiyun.commonModel.LotteryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service("dgService")
public class DGServiceImpl implements DGService {

    private static Logger logger = LoggerFactory.getLogger(DGServiceImpl.class);

    @Resource
    private TicketFindNew2Mapper ticketFindNew2Mapper;
    @Resource
    private BlackForAddPrize2Mapper blackForAddPrize2Mapper;
    @Resource
    private AddPrize2Mapper addPrize2Mapper;
    @Resource
    private LotteryPlanAddPrize2Mapper lotteryPlanAddPrize2Mapper;
    @Resource
    private DgMapper dgMapper;
    @Resource
    private LotteryPlan2Mapper lotteryPlan2Mapper;
    @Resource
    private LotteryPlanOrder2Mapper lotteryPlanOrder2Mapper;
    @Resource
    private SportteryBasketMatch2Mapper sportteryBasketMatch2Mapper;
    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;
    @Resource
    private MemberWalletLine2Mapper memberWalletLine2Mapper;

    public Map<String,Object> dg(Map<String, Object> dgMap) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();

            Member2DTO member2DTO = (Member2DTO) dgMap.get("member2DTO");
            String term = dgMap.get("term").toString();
            String content = dgMap.get("content").toString();
            Integer amount = (Integer) dgMap.get("amount");
            Integer isCopy = (Integer) dgMap.get("isCopy");
            Integer copyPlanNo = (Integer) dgMap.get("copyPlanNo");
            Integer publicStatus = (Integer) dgMap.get("publicStatus");
            Integer tradeType = (Integer) dgMap.get("tradeType");
            Integer multiple = (Integer) dgMap.get("multiple");
            Integer isFocus = (Integer) dgMap.get("isFocus");
            Integer lotteryType = (Integer) dgMap.get("lotteryType");
            Double maxSp = (Double) dgMap.get("maxSp");
            Date dealDateTime = (Date) dgMap.get("dealDateTime");
            String[] passType = (String[]) dgMap.get("passType");
            Integer walletType = WalletType.DUOBAO.getValue();
            Double minBonus = (Double) dgMap.get("minBonus");
            Double maxBonus = (Double) dgMap.get("maxBonus");
            String dlAccount = (String) dgMap.get("dlAccount");
            String qdAccount = (String) dgMap.get("qdAccount");
            logger.info("--------------------请求代购服务------------------------");
            logger.info("account:" + member2DTO.getAccount());
            logger.info("term:" + term);
            logger.info("amount:" + amount);

            boolean flag = true;

            //余额判断
            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByMemberId(member2DTO.getId());
            if (memberWallet2==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            if (memberWallet2.getAbleBalance()+Integer.parseInt(dgMap.get("cardMoney").toString())<amount){
                flag = false;
            }

            if (!flag){
                //金额不足 保存方案
                LotteryPlan2WithBLOBs lotteryPlan = new LotteryPlan2WithBLOBs();
                Integer playType = null;
                if (passType==null || passType.length<=0){
                    //抄单
                    playType = (Integer) dgMap.get("playType");
                    lotteryPlan.setPlayType(playType);
                }else {
                    playType = getPlayType(passType);
                    lotteryPlan.setPlayType(playType);
                }
                lotteryPlan.setLotteryType(lotteryType);
                lotteryPlan.setMemberId(member2DTO.getId());
                lotteryPlan.setAccount(member2DTO.getAccount());
                lotteryPlan.setSumamount(amount);
                lotteryPlan.setAmount(amount);
                lotteryPlan.setMultiple(multiple);
                lotteryPlan.setClicks(0);
                lotteryPlan.setCreateDateTime(new Date());
                lotteryPlan.setExperience(0);
                lotteryPlan.setIsSuperMan(1);
                lotteryPlan.setPart(1);
                lotteryPlan.setPerAmount(amount);
                lotteryPlan.setReservePart(0);
                lotteryPlan.setFounderPart(1);
                lotteryPlan.setSoldPart(1);
                lotteryPlan.setPlanDesc("");
                lotteryPlan.setPlanStatus(PlanStatus.NOT_PAY.getValue());
                lotteryPlan.setIsAbleTicketing(CommonStatus.NO.getValue());
                lotteryPlan.setPlanTicketStatus(PlanTicketStatus.NO_PROCESS.getValue());
                lotteryPlan.setPlanType(PlanType.DG.getValue());// 代购
                lotteryPlan.setPosttaxPrize(0d);
                lotteryPlan.setPretaxPrize(0d);
                lotteryPlan.setPrizeContent("");
                lotteryPlan.setPublicStatus(publicStatus);// 代购的方案是否公开
                lotteryPlan.setPlatform(1);
                lotteryPlan.setContent(content);
                lotteryPlan.setSelectType(SelectType.getItem(2).getValue());
                lotteryPlan.setIsUploadContent(0);
                lotteryPlan.setTerm(term);
                lotteryPlan.setTradeType(tradeType);
                lotteryPlan.setWinStatus(WinStatus.NOT_RESULT.getValue());
                lotteryPlan.setOutPlanNo(null);
                lotteryPlan.setCommision(0);
                lotteryPlan.setJoinCount(0);
                lotteryPlan.setOpenFinish(0);
                lotteryPlan.setAcceptTime(new Date());
                lotteryPlan.setDealDateTime(dealDateTime);
                lotteryPlan.setMaxSp(maxSp);
                lotteryPlan.setPlanDesc(dgMap.get("planDesc").toString());
                lotteryPlan.setHaploidAmount(amount/multiple);
                lotteryPlan.setMinBonus(minBonus==null?BigDecimalUtil.round(0):BigDecimalUtil.round(minBonus));
                lotteryPlan.setMaxBonus(maxBonus==null?BigDecimalUtil.round(0):BigDecimalUtil.round(maxBonus));
                lotteryPlan.setDlAccount(dlAccount);
                lotteryPlan.setQdAccount(qdAccount);
                lotteryPlan.setVerifyMd5(DbDataVerify.getLotteryPlanVerify(lotteryPlan));
                lotteryPlan2Mapper.insertSelective(lotteryPlan);

                //订单
                LotteryPlanOrder2 lotteryPlanOrder = new LotteryPlanOrder2();
                lotteryPlanOrder.setPlanNo(lotteryPlan.getPlanNo());
                lotteryPlanOrder.setAccount(member2DTO.getAccount());
                lotteryPlanOrder.setAmount(amount);
                lotteryPlanOrder.setBuyType(BuyType.SELF_BUY.getValue());
                lotteryPlanOrder.setCreateDateTime(new Date());
                lotteryPlanOrder.setExperience(new Integer(0));
                if (tradeType == TradeType.TRADE_BALANCE.getValue()) {
                    lotteryPlanOrder.setScore(new Integer(amount * Constants.CONSUME_PRESENT_RATE));
                } else {
                    lotteryPlanOrder.setScore(new Integer(0));
                }
                lotteryPlanOrder.setMemberId(member2DTO.getId());
                lotteryPlanOrder.setPosttaxPrize(0d);
                lotteryPlanOrder.setPart(1);
                lotteryPlanOrder.setPrizeSettleStatus(1);
                lotteryPlanOrder.setStatus(PlanOrderStatus.NOT_PAY.getValue());
                lotteryPlanOrder.setWalletType(walletType);
                lotteryPlanOrder.setVerifyMd5(DbDataVerify.getLotteryPlanOrder2Verify(lotteryPlanOrder));
                lotteryPlanOrder.setFollowingType(MemberFollowingType.NONE.getValue());
                lotteryPlanOrder.setPlatform(1);
                lotteryPlanOrder2Mapper.insertSelective(lotteryPlanOrder);

                map.put(Constants.CODE,Constants.ERROR_CODE_417);
                map.put(Constants.MSG,Constants.ERROR_MSG_417);
                return map;
            }

            //根据id去查询彩金卡的使用额度
            if (Double.valueOf(dgMap.get("cardMoney").toString())!=0) {
                BigDecimal big = memberWalletLine2Mapper.findCardFullMoneyById(dgMap.get("cardId"));
                if (amount < Double.valueOf(big.toPlainString())) {
                    map.put(Constants.CODE, Constants.ERROR_CODE_435);
                    map.put(Constants.MSG,Constants.ERROR_MSG_435);
                    return map;
                }
            }

            //方案
            LotteryPlan2WithBLOBs lotteryPlan = new LotteryPlan2WithBLOBs();
            Integer playType = null;
            if (passType==null || passType.length<=0){
                //抄单
                playType = (Integer) dgMap.get("playType");
                lotteryPlan.setPlayType(playType);
            }else {
                playType = getPlayType(passType);
                lotteryPlan.setPlayType(playType);
            }
            lotteryPlan.setLotteryType(lotteryType);
            lotteryPlan.setMemberId(member2DTO.getId());
            lotteryPlan.setAccount(member2DTO.getAccount());
            lotteryPlan.setSumamount(amount);
            lotteryPlan.setAmount(amount);
            lotteryPlan.setMultiple(multiple);
            lotteryPlan.setClicks(0);
            lotteryPlan.setCreateDateTime(new Date());
            lotteryPlan.setExperience(0);
            lotteryPlan.setIsSuperMan(1);
            lotteryPlan.setPart(1);
            lotteryPlan.setPerAmount(amount);
            lotteryPlan.setReservePart(0);
            lotteryPlan.setFounderPart(1);
            lotteryPlan.setSoldPart(1);
            lotteryPlan.setPlanStatus(PlanStatus.PAY_FINISH.getValue());
            lotteryPlan.setIsAbleTicketing(CommonStatus.YES.getValue());
            lotteryPlan.setPlanTicketStatus(PlanTicketStatus.NO_PROCESS.getValue());
            lotteryPlan.setPlanType(PlanType.DG.getValue());// 代购
            lotteryPlan.setPosttaxPrize(0d);
            lotteryPlan.setPretaxPrize(0d);
            lotteryPlan.setPrizeContent("");
            lotteryPlan.setPublicStatus(publicStatus);// 代购的方案是否公开
            lotteryPlan.setPlatform(1);
            lotteryPlan.setContent(content);
            lotteryPlan.setSelectType(SelectType.getItem(2).getValue());
            lotteryPlan.setIsUploadContent(0);
            lotteryPlan.setTerm(term);
            lotteryPlan.setTradeType(tradeType);
            lotteryPlan.setWinStatus(WinStatus.NOT_RESULT.getValue());
            lotteryPlan.setOutPlanNo(null);
            lotteryPlan.setCommision(0);
            lotteryPlan.setJoinCount(0);
            lotteryPlan.setOpenFinish(0);
            lotteryPlan.setAcceptTime(new Date());
            lotteryPlan.setDealDateTime(dealDateTime);
            lotteryPlan.setMaxSp(maxSp);
            lotteryPlan.setPlanDesc(dgMap.get("planDesc").toString());
            lotteryPlan.setHaploidAmount(amount/multiple);
            lotteryPlan.setMinBonus(minBonus==null?BigDecimalUtil.round(0):BigDecimalUtil.round(minBonus));
            lotteryPlan.setMaxBonus(maxBonus==null?BigDecimalUtil.round(0):BigDecimalUtil.round(maxBonus));
            lotteryPlan.setDlAccount(dlAccount);
            lotteryPlan.setQdAccount(qdAccount);
            lotteryPlan.setVerifyMd5(DbDataVerify.getLotteryPlanVerify(lotteryPlan));
            lotteryPlan2Mapper.insertSelective(lotteryPlan);

            if (isCopy==1){
                //抄单
                TicketFindNew2 ticketFindNew2 = ticketFindNew2Mapper.getByPlanNo(copyPlanNo);
                if (ticketFindNew2==null){
                    map.put(Constants.CODE,Constants.ERROR_CODE_400);
                    map.put(Constants.MSG,Constants.ERROR_MSG_400);
                    return map;
                }
                ticketFindNew2.setCopyStatus(0);
                ticketFindNew2.setCopyPlanNo(lotteryPlan.getPlanNo());
                ticketFindNew2Mapper.updateByPrimaryKeySelective(ticketFindNew2);
            }

            //订单
            LotteryPlanOrder2 lotteryPlanOrder = new LotteryPlanOrder2();
            lotteryPlanOrder.setPlanNo(lotteryPlan.getPlanNo());
            lotteryPlanOrder.setAccount(member2DTO.getAccount());
            lotteryPlanOrder.setAmount(amount);
            lotteryPlanOrder.setBuyType(BuyType.SELF_BUY.getValue());
            lotteryPlanOrder.setCreateDateTime(new Date());
            lotteryPlanOrder.setExperience(new Integer(0));
            if (tradeType == TradeType.TRADE_BALANCE.getValue()) {
                lotteryPlanOrder.setScore(new Integer(amount * Constants.CONSUME_PRESENT_RATE));
            } else {
                lotteryPlanOrder.setScore(new Integer(0));
            }
            lotteryPlanOrder.setMemberId(member2DTO.getId());
            lotteryPlanOrder.setPosttaxPrize(0d);
            lotteryPlanOrder.setPart(1);
            lotteryPlanOrder.setPrizeSettleStatus(1);
            lotteryPlanOrder.setStatus(PlanOrderStatus.PAYED.getValue());
            lotteryPlanOrder.setWalletType(walletType);
            lotteryPlanOrder.setVerifyMd5(DbDataVerify.getLotteryPlanOrder2Verify(lotteryPlanOrder));
            lotteryPlanOrder.setFollowingType(MemberFollowingType.NONE.getValue());
            lotteryPlanOrder.setPlatform(1);
            lotteryPlanOrder2Mapper.insertSelective(lotteryPlanOrder);

            //钱包金额修改
            //判断彩金卡是否使用
            if (0==Integer.parseInt(dgMap.get("cardMoney").toString())) {
                if (memberWallet2.getAbleBalance()-memberWallet2.getTakeCashQuota()<amount){
                    memberWallet2.setTakeCashQuota(NumberTools.round(memberWallet2.getAbleBalance()-amount,2));
                }
                memberWallet2.setAbleBalance(NumberTools.round(memberWallet2.getAbleBalance() - amount,2));
                memberWallet2.setHeapBalance(NumberTools.round(memberWallet2.getHeapBalance()+amount,2));
            }else {
                Double cardMoney = Double.valueOf(dgMap.get("cardMoney").toString());
                //把使用彩金卡的金额加入钱包
                if (memberWallet2.getAbleBalance()+cardMoney-memberWallet2.getTakeCashQuota()<amount){
                    memberWallet2.setTakeCashQuota(NumberTools.round(memberWallet2.getAbleBalance()+cardMoney-amount,2));
                }
                memberWallet2.setAbleBalance(NumberTools.round(memberWallet2.getAbleBalance() - amount + cardMoney,2));
                memberWallet2.setHeapBalance(NumberTools.round(memberWallet2.getHeapBalance() + amount - amount + Double.valueOf(dgMap.get("cardMoney").toString()),2));
                //生成钱包流水
                MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
                memberWalletLine2.setPlanNo(lotteryPlan.getPlanNo());
                memberWalletLine2.setOrderNo(lotteryPlanOrder.getOrderNo());
                memberWalletLine2.setAccount(memberWallet2.getAccount());
                memberWalletLine2.setMemberId(memberWallet2.getMemberId());
                memberWalletLine2.setTransType(-1001);// 独立扣款科目，负数值存为正
                memberWalletLine2.setWalletType(1);
                memberWalletLine2.setAmount(cardMoney);
                memberWalletLine2.setLotteryType(lotteryType);
                memberWalletLine2.setCreateDateTime(new Date());
                memberWalletLine2.setStatus(0);
                memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
                memberWalletLine2.setSourceId(member2DTO.getSourceId());
                memberWalletLine2.setAbleBalance(NumberTools.round(memberWallet2.getAbleBalance() + cardMoney,2));
                memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
                memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
                memberWalletLine2.setRemark("彩金卡抵扣");
                memberWalletLine2.setPrizeBalance(memberWallet2.getPrizeBalance());
                memberWalletLine2Mapper.insertSelective(memberWalletLine2);
                //修改这张 彩金卡
                memberWalletLine2Mapper.updateCard(dgMap.get("cardId"), new Date());
            }

            memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);

            //钱包流水
            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setPlanNo(lotteryPlan.getPlanNo());
            memberWalletLine2.setOrderNo(lotteryPlanOrder.getOrderNo());
            memberWalletLine2.setAccount(memberWallet2.getAccount());
            memberWalletLine2.setMemberId(memberWallet2.getMemberId());
            memberWalletLine2.setTransType(30);
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setAmount((double)amount);
            memberWalletLine2.setLotteryType(lotteryType);
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2.setSourceId(member2DTO.getSourceId());
            memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLine2.setRemark("购买彩票");
            memberWalletLine2.setPrizeBalance(memberWallet2.getPrizeBalance());
            memberWalletLine2Mapper.insertSelective(memberWalletLine2);


            //判断加奖
            if (isFocus==1) {
                AddPrize2 addPrize2 = addPrize2Mapper.selectByPrimaryKey(lotteryType);
                if (!StringUtils.isNullOrBlank(member2DTO.getName()) && !StringUtils.isNullOrBlank(member2DTO.getCertNo())) {
                    if (addPrize2 != null) {
                        String playTypes = addPrize2.getPlayTypes();
                        if (!StringUtils.isNullOrBlank(playTypes)) {
                            String[] split = playTypes.split(",");
                            List<String> strings = Arrays.asList(split);
                            if (strings.contains(playType + "")) {
                                if (lotteryPlan.getAmount() >= addPrize2.getMinAmount()) {
                                    List<String> blackAccounts = blackForAddPrize2Mapper.selectAllAccount();
                                    if (!blackAccounts.contains(lotteryPlan.getAccount())) {
                                        //有加奖
                                        LotteryPlanAddPrize2 lotteryPlanAddPrize2 = new LotteryPlanAddPrize2();
                                        lotteryPlanAddPrize2.setPlanNo(lotteryPlan.getPlanNo());
                                        lotteryPlanAddPrize2.setRate(addPrize2.getRate());
                                        lotteryPlanAddPrize2Mapper.insertSelective(lotteryPlanAddPrize2);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            Map<String,Object> map = new HashMap<String,Object>();
            e.printStackTrace();
            map.put(Constants.CODE,Constants.ERROR_CODE_414);
            map.put(Constants.MSG,Constants.ERROR_MSG_414);
            return map;
        }
    }

    public Integer getLotteryTerm(Integer lotteryType) {
        Integer[] terms = dgMapper.getLotteryTerm(lotteryType);
        if (terms.length>0){
            return terms[0];
        }
        return null;
    }

    public int getDealTime() {
        return dgMapper.getDealTime();
    }

    public Map<String, Object> updateMatchDealTime(Integer dealTime) {
        Map<String,Object> map = new HashMap<String,Object>();
        dgMapper.updateDealTime(dealTime);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public double getMaxAddPrize() {
        return dgMapper.getMaxAddPrize();
    }

    public Map<String, Object> updateMaxAddPrize(double maxAddPrize) {
        Map<String,Object> map = new HashMap<String,Object>();
        dgMapper.updateMaxAddPrize(maxAddPrize);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public void updateDG(int status) {
        dgMapper.updateDG(status);
    }

    public int getDGStatus() {
        return dgMapper.getDGStatus();
    }

    public Map<String, Object> superLottoDG(Map<String, Object> dgMap) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();

            Member2DTO member2DTO = (Member2DTO) dgMap.get("member2DTO");
            String term = dgMap.get("term").toString();
            String content = dgMap.get("content").toString();
            Integer amount = (Integer) dgMap.get("amount");
            Integer publicStatus = (Integer) dgMap.get("publicStatus");
            Integer tradeType = (Integer) dgMap.get("tradeType");
            Integer multiple = (Integer) dgMap.get("multiple");
            Integer lotteryType = (Integer) dgMap.get("lotteryType");
            Date dealDateTime = (Date) dgMap.get("dealDateTime");
            Integer walletType = WalletType.DUOBAO.getValue();
            logger.info("--------------------请求代购服务------------------------");
            logger.info("account:" + member2DTO.getAccount());
            logger.info("term:" + term);
            logger.info("amount:" + amount);



            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByMemberId(member2DTO.getId());
            if (memberWallet2==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            if (memberWallet2.getAbleBalance()<amount){
                map.put(Constants.CODE,Constants.ERROR_CODE_417);
                map.put(Constants.MSG,Constants.ERROR_MSG_417);
                return map;
            }
            ContentCheck contentCheck = null;
            try {
                contentCheck = checkPlan(content, amount, TradeType.TRADE_BALANCE);

                if (contentCheck.isPass() != true){
                    if(contentCheck.getMessage()!=null && !"".equals(contentCheck.getMessage())){
                        map.put(Constants.CODE,Constants.ERROR_CODE_400);
                        map.put(Constants.MSG,"本次操作被中止:"+contentCheck.getMessage());
                        return map;
                    }else{
                        map.put(Constants.CODE,Constants.ERROR_CODE_400);
                        map.put(Constants.MSG,"本次操作被中止:金额错误");
                        return map;
                    }
                }

			/* 返回处理后的投注类容。。主要是去掉投注类容的追加 */
                content = contentCheck.getContent();
            } catch (Exception e) {
                e.printStackTrace();
            }

            List<Map> lotteryTermMap = dgMapper.findByLotteryTypeAndTerm(lotteryType, term);

            if (lotteryTermMap == null || lotteryTermMap.size() <= 0) {
                map.put(Constants.CODE, Constants.ERROR_CODE_400);
                map.put(Constants.MSG, Constants.ERROR_MSG_400);
                return map;
            }
            LotteryTerm buyTerm = new LotteryTerm();
            buyTerm.setIsAble(CommonStatus.getItem((Integer) lotteryTermMap.get(0).get("is_able")));
            buyTerm.setStatus(LotteryTermStatus.getItem((Integer) lotteryTermMap.get(0).get("status")));
            buyTerm.setLotteryType(LotteryType.getItem((Integer) lotteryTermMap.get(0).get("lottery_type")));
            buyTerm.setLotMgrIsAble(CommonStatus.getItem((Integer) lotteryTermMap.get(0).get("lot_mgr_is_able")));
            buyTerm.setEndDateTime((Date) lotteryTermMap.get(0).get("end_date_time"));
            if (buyTerm.termIsClose(TradeType.getItem(tradeType))) {
                map.put(Constants.CODE, Constants.ERROR_CODE_409);
                map.put(Constants.MSG, Constants.ERROR_MSG_409);
                return map;
            }

            // 判断是否已经关闭销售(增加奥运预投功能后增加或者条件)
            if (buyTerm.getStatus().getValue() != LotteryTermStatus.OPEN.getValue()
                    && buyTerm.getStatus().getValue() != LotteryTermStatus.BEFORE_OPEN_SALE.getValue()
                    && !LotteryType.JCLQList.contains(buyTerm.getLotteryType())
                    && !LotteryType.JCZQList.contains(buyTerm.getLotteryType())) {
                map.put(Constants.CODE, Constants.ERROR_CODE_411);
                map.put(Constants.MSG, Constants.ERROR_MSG_411);
                return map;
            }

            if (new Date().after(buyTerm.getEndDateTime())) {
                map.put(Constants.CODE, Constants.ERROR_CODE_411);
                map.put(Constants.MSG, Constants.ERROR_MSG_411);
                return map;
            }


            //方案
            LotteryPlan2WithBLOBs lotteryPlan = new LotteryPlan2WithBLOBs();
            lotteryPlan.setAddAttribute(contentCheck.getIsAttribute());
            lotteryPlan.setPlayType(2);
            lotteryPlan.setLotteryType(lotteryType);
            lotteryPlan.setMemberId(member2DTO.getId());
            lotteryPlan.setAccount(member2DTO.getAccount());
            lotteryPlan.setSumamount(amount);
            lotteryPlan.setAmount(amount);
            lotteryPlan.setMultiple(multiple);
            lotteryPlan.setClicks(0);
            lotteryPlan.setCreateDateTime(new Date());
            lotteryPlan.setExperience(0);
            lotteryPlan.setIsSuperMan(1);
            lotteryPlan.setPart(1);
            lotteryPlan.setPerAmount(amount);
            lotteryPlan.setReservePart(0);
            lotteryPlan.setFounderPart(1);
            lotteryPlan.setSoldPart(1);
            lotteryPlan.setPlanDesc("");
            lotteryPlan.setPlanStatus(PlanStatus.PAY_FINISH.getValue());
            lotteryPlan.setIsAbleTicketing(CommonStatus.YES.getValue());
            lotteryPlan.setPlanTicketStatus(PlanTicketStatus.NO_PROCESS.getValue());
            lotteryPlan.setPlanType(PlanType.DG.getValue());// 代购
            lotteryPlan.setPosttaxPrize(0d);
            lotteryPlan.setPretaxPrize(0d);
            lotteryPlan.setPrizeContent("");
            lotteryPlan.setPublicStatus(publicStatus);// 代购的方案是否公开
            lotteryPlan.setPlatform(1);
            lotteryPlan.setContent(content);
            lotteryPlan.setSelectType(SelectType.getItem(2).getValue());
            lotteryPlan.setIsUploadContent(0);
            lotteryPlan.setTerm(term);
            lotteryPlan.setTradeType(tradeType);
            lotteryPlan.setWinStatus(WinStatus.NOT_RESULT.getValue());
            lotteryPlan.setOutPlanNo(null);
            lotteryPlan.setCommision(0);
            lotteryPlan.setJoinCount(0);
            lotteryPlan.setOpenFinish(0);
            lotteryPlan.setAcceptTime(new Date());
            lotteryPlan.setDealDateTime(dealDateTime);
            lotteryPlan.setMaxSp(0d);
            lotteryPlan.setVerifyMd5(DbDataVerify.getLotteryPlanVerify(lotteryPlan));
            lotteryPlan2Mapper.insertSelective(lotteryPlan);

            //订单
            LotteryPlanOrder2 lotteryPlanOrder = new LotteryPlanOrder2();
            lotteryPlanOrder.setPlanNo(lotteryPlan.getPlanNo());
            lotteryPlanOrder.setAccount(member2DTO.getAccount());
            lotteryPlanOrder.setAmount(amount);
            lotteryPlanOrder.setBuyType(BuyType.SELF_BUY.getValue());
            lotteryPlanOrder.setCreateDateTime(new Date());
            lotteryPlanOrder.setExperience(new Integer(0));
            if (tradeType == TradeType.TRADE_BALANCE.getValue()) {
                lotteryPlanOrder.setScore(new Integer(amount * Constants.CONSUME_PRESENT_RATE));
            } else {
                lotteryPlanOrder.setScore(new Integer(0));
            }
            lotteryPlanOrder.setMemberId(member2DTO.getId());
            lotteryPlanOrder.setPosttaxPrize(0d);
            lotteryPlanOrder.setPart(1);
            lotteryPlanOrder.setPrizeSettleStatus(1);
            lotteryPlanOrder.setStatus(PlanOrderStatus.PAYED.getValue());
            lotteryPlanOrder.setWalletType(walletType);
            lotteryPlanOrder.setVerifyMd5(DbDataVerify.getLotteryPlanOrder2Verify(lotteryPlanOrder));
            lotteryPlanOrder.setFollowingType(MemberFollowingType.NONE.getValue());
            lotteryPlanOrder.setPlatform(1);
            lotteryPlanOrder2Mapper.insertSelective(lotteryPlanOrder);


            //钱包金额修改
            //判断彩金卡是否使用
            if (0==Integer.parseInt(dgMap.get("cardMoney").toString())) {
                if (memberWallet2.getAbleBalance()-memberWallet2.getTakeCashQuota()<amount){
                    memberWallet2.setTakeCashQuota(memberWallet2.getAbleBalance()-amount);
                }
                memberWallet2.setAbleBalance(memberWallet2.getAbleBalance() - amount);
                memberWallet2.setHeapBalance(memberWallet2.getHeapBalance()+amount);
            }else {
                //根据id去查询彩金卡的使用额度
                BigDecimal big = memberWalletLine2Mapper.findCardFullMoneyById(dgMap.get("cardId"));
                if (amount<Double.valueOf(big.toPlainString())) {
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, "当前金额小于彩金卡使用额度");
                    return map;
                }else {
                    Double cardMoney = Double.valueOf(dgMap.get("cardMoney").toString());
                    //把使用彩金卡的金额加入钱包
                    if (memberWallet2.getAbleBalance()+cardMoney-memberWallet2.getTakeCashQuota()<amount){
                        memberWallet2.setTakeCashQuota(memberWallet2.getAbleBalance()+cardMoney-amount);
                    }
                    memberWallet2.setAbleBalance(memberWallet2.getAbleBalance() - amount + cardMoney);
                    memberWallet2.setHeapBalance(memberWallet2.getHeapBalance() + amount - amount + Double.valueOf(dgMap.get("cardMoney").toString()));
                    //生成钱包流水
                    MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
                    memberWalletLine2.setPlanNo(lotteryPlan.getPlanNo());
                    memberWalletLine2.setOrderNo(lotteryPlanOrder.getOrderNo());
                    memberWalletLine2.setAccount(memberWallet2.getAccount());
                    memberWalletLine2.setMemberId(memberWallet2.getMemberId());
                    memberWalletLine2.setTransType(-1001);// 独立扣款科目，负数值存为正
                    memberWalletLine2.setWalletType(1);
                    memberWalletLine2.setAmount(cardMoney);
                    memberWalletLine2.setLotteryType(lotteryType);
                    memberWalletLine2.setCreateDateTime(new Date());
                    memberWalletLine2.setStatus(0);
                    memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
                    memberWalletLine2.setSourceId(member2DTO.getSourceId());
                    memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance() + cardMoney);
                    memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
                    memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
                    memberWalletLine2.setRemark("彩金卡抵扣");
                    memberWalletLine2.setPrizeBalance(memberWallet2.getPrizeBalance());
                    memberWalletLine2Mapper.insertSelective(memberWalletLine2);
                    //修改这张 彩金卡
                    memberWalletLine2Mapper.updateCard(dgMap.get("cardId"), new Date());
                }
            }

            memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);

            //钱包流水
            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setPlanNo(lotteryPlan.getPlanNo());
            memberWalletLine2.setOrderNo(lotteryPlanOrder.getOrderNo());
            memberWalletLine2.setAccount(memberWallet2.getAccount());
            memberWalletLine2.setMemberId(memberWallet2.getMemberId());
            memberWalletLine2.setTransType(30);
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setAmount((double)amount);
            memberWalletLine2.setLotteryType(lotteryType);
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2.setSourceId(member2DTO.getSourceId());
            memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLine2.setRemark("购买彩票");
            memberWalletLine2.setPrizeBalance(memberWallet2.getPrizeBalance());
            memberWalletLine2Mapper.insertSelective(memberWalletLine2);

            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(Constants.CODE,Constants.ERROR_CODE_414);
            map.put(Constants.MSG,Constants.ERROR_MSG_414);
            return map;
        }
    }

    public Integer getAutoCopyPlanStatusForLess5() {
        return dgMapper.getAutoCopyPlanStatusForLess5();
    }

    public Integer getAutoCopyPlanStatusForMore5() {
        return dgMapper.getAutoCopyPlanStatusForMore5();
    }

    public void setAutoCopyPlanStatusForLess5(int status) {
        dgMapper.setAutoCopyPlanStatusForLess5(status);
    }

    public void setAutoCopyPlanStatusForMore5(int status) {
        dgMapper.setAutoCopyPlanStatusForMore5(status);
    }

    public int getChaiPiaoCount() {
        return dgMapper.getChaiPiaoCount();
    }

    @Override
    public void updateLastCheckBingoTime(Date date) {
        dgMapper.updateLastCheckBingoTime(date);
    }

    @Override
    public void updateLastReturnPrizeTime(Date date) {
        dgMapper.updateLastReturnPrizeTime(date);
    }

    private Integer getPlayType(String[] passType) {
        Integer playType = null;
        if (passType.length==1){
            if (passType[0].equals("P2_1")){
                //2串1
                playType=118;
            }else if(passType[0].equals("P3_1")){
                //3串1
                playType=119;
            }else if(passType[0].equals("P4_1")){
                //4串1
                playType=120;
            }else if(passType[0].equals("P5_1")){
                //5串1
                playType=121;
            }else if(passType[0].equals("P6_1")){
                //6串1
                playType=122;
            }else if(passType[0].equals("P7_1")){
                //7串1
                playType=123;
            }else if(passType[0].equals("P8_1")){
                //8串1
                playType=124;
            }else if(passType[0].equals("P1")){
                //单关
                playType=117;
            }
        }else if (passType.length>1){
            //自由过关
            playType=116;
        }
        return playType;
    }

    private ContentCheck checkplan(Integer lotteryType, Integer amount, String content, TradeType tradeType) {
        ContentCheck check = new ContentCheck();
        if (lotteryType==304){

        }
        return null;
    }

    public ContentCheck basketDGCheck(Integer lotteryType, Integer amount, String content, TradeType tradeType){
        //篮球单关
        Date firstTime = null;
        if (content == null || "".equals(content)){
            logger.info("方案内容不能为空");
            return null;
        }
        BasketBallBetContent betContent = CommonUtils.Object4Json(content, BasketBallBetContent.class, BasketBallMatchItem.class);
        List<BasketBallMatchItem> matchItems = betContent.getMatchItems();
        List<SportteryPassType> passType = betContent.getPassTypes();
        if (matchItems.isEmpty()){
            logger.info("您没有选择任何场次");
            return null;
        }
        if (passType.isEmpty()){
            logger.info("您没有选择过关方式");
            return null;
        }
        if (betContent.getMultiple() < 1){
            logger.info("倍数不允许小于1");
            return null;
        }
        List<SportteryBasketMatch2> dbMatchs = sportteryBasketMatch2Mapper.findMatchByStatus(MatchStatus.ONSALE.ordinal());
        Map<String, SportteryBasketMatch2> tempMatchs = new HashMap<String, SportteryBasketMatch2>();// 根据截止时间重新构建一个
        for (SportteryBasketMatch2 match : dbMatchs) {// 将数据库中的对阵遍历出来，组装MAP，与投注页面对阵比较
            tempMatchs.put(match.getInttime() + "_" + match.getLineid(), match);
        }
        for (BasketBallMatchItem item : matchItems) {
            String key = item.getIntTime() + "_" + item.getLineId();
            SportteryBasketMatch2 m = tempMatchs.get(key);
            if (m == null) {
                logger.info("您选择的场次中有已经截止的场次");
                return null;
            } else {// 放入比赛时间，最早的
                if (firstTime == null || firstTime.getTime() > m.getMatchtime().getTime()) {
                    firstTime = m.getMatchtime();
                }
            }
        }

        PlayType p = null;
        if (betContent.getPassTypes().size() > 1 && !betContent.getPassTypes().contains(SportteryPassType.P1)) {// 检查自由过关的设胆
            logger.info("过关方式错误");
            return null;
        } else {// 检查多选过关设胆
            SportteryPassType tempT = betContent.getPassTypes().get(0);
            p = tempT.getType();
        }
//            double tempAmount = getBetAmount(content, SelectType.CHOOSE_SELF, betContent.getMultiple());
// 检查选项是否合法
        for (BasketBallMatchItem matchItem : matchItems) {
            for (SportteryOption option : matchItem.getOptions()) {
                if (StringTools.isNullOrBlank(option.getValue()) || StringTools.isNullOrBlank(option.getType())) {
                    logger.info("选项出错");
                }
                LotteryType tmpType=LotteryType.getItem(Integer.parseInt(option.getType()));
                if (!LotteryType.JCLQList.contains(tmpType)){
                    logger.info("混投选项出错");
                }
                Integer betMoney=option.getBetMoney();
                if(betMoney==null || betMoney <=0 || betMoney%2==1){
                    logger.info("投注金额出错");
                }
            }
        }

        LotteryPlan2WithBLOBs plan = new LotteryPlan2WithBLOBs();
        plan.setContent(content);
        ContentCheck check = new ContentCheck();
        check.setFirstTime(firstTime);
        check.setMultiple(betContent.getMultiple());
        check.setPass(true);
        check.setContent(content);
        check.setPlayType(p);
        return check;
    }

    public ContentCheck checkPlan(String content, double amount,TradeType tradeType) throws Exception {
        String[] ts = content.split("\\-");
        String add = ts[1];
        int needAddCount = 0;
        content = ts[0];
        ContentCheck result = new ContentCheck();

        int amountTest = 0;
        String temp = "";
        int flag = 0;
        int type = 0;
        int playType = 0;
        int f=0;
        int counttest=0;  //单注数
        String[] contentDiv = content.split("\\%");
        int mutiple = Integer.parseInt(contentDiv[1]);
        String[] contentGroup = contentDiv[0].split("\\~");
        for (String str : contentGroup) {
            String s[] = str.split("\\:");
            if (!temp.equals(s[0]))
                flag++;

            temp = s[0];
            type = Integer.parseInt(s[0]);
            playType = Integer.parseInt(s[0]);
            f++;
            try {
                PlayType dlt=(PlayType) PlayType.DltMap.get(playType);
                if(dlt==null){
                    result.setPass(false);
                    result.setMessage("第"+f+"注的子玩法不存在");
                    return result;
                }
            } catch (Exception e) {
                result.setPass(false);
                result.setMessage("第"+f+"注的子玩法不存在");
                return result;
            }
            if (playType == PlayType.DS.getValue()) {
                String[] lines = s[1].split("\\^");

                //验证内容
                result=resultCountext(f,lines[0],playType);
                if(!result.isPass()){
                    return result;
                }
                amountTest += lines.length;
                counttest=lines.length;
                if (add.equals("0")) {
                    needAddCount += lines.length;
                }
                for (int i = 0; i < lines.length; i++) {
                    if (lines[i].length() != 20) {
                        amountTest = -99999999;
                    }
                }
            } else if (playType == PlayType.FS.getValue() || playType == PlayType.DDSHJX.getValue()) {
                //验证内容
                result=resultCountext(f,s[1],playType);
                if(!result.isPass()){
                    return result;
                }
                int count = combination(s[1].split("\\|")[0].split("\\,").length, 5) * combination(s[1].split("\\|")[1].split("\\,").length, 2);
                amountTest += count;
                if (add.equals("0")) {
                    needAddCount += count;
                }
                counttest=count;
            } else if (playType == PlayType.DT.getValue()) {
                //验证内容
                result=resultCountext(f,s[1],playType);
                if(!result.isPass()){
                    return result;
                }
                String red = s[1].split("\\|")[0];
                String blue = s[1].split("\\|")[1];
                int danCount = 0;
                int tuoCount=0;
                if(red.split("#").length==2){
                    if (!"".equals(red.split("#")[0])) {
                        danCount = red.split("#")[0].split("\\,").length;
                    }
                    tuoCount = red.split("#")[1].split("\\,").length;
                }else{
                    tuoCount = red.split("#")[0].split("\\,").length;
                }

                int blueDanCount = 0;
                int blueTuoCount=0;
                if(blue.split("#").length==2){
                    if (!"".equals(blue.split("#")[0])) {
                        blueDanCount = blue.split("#")[0].split("\\,").length;
                    }
                    blueTuoCount = blue.split("#")[1].split("\\,").length;
                }else{
                    blueTuoCount = blue.split("#")[0].split("\\,").length;
                }
                int count = combination(tuoCount, 5 - danCount) * combination(blueTuoCount, 2 - blueDanCount);
                amountTest += count;
                if (add.equals("0")) {
                    needAddCount += count;
                }
                counttest=count;
            } else if (playType == PlayType.SXL_FS.getValue()) {
                //验证内容
                result=checkSXL(f,s[1]);
                if(!result.isPass()){
                    return result;
                }

                amountTest += combination(s[1].split("\\,").length, 2);
            } else if (playType == PlayType.SXL_DS.getValue()) {
                String[] lines = s[1].split("\\^");
                amountTest += lines.length;
            } else if (playType == PlayType.XZJZ_Z5B4.getValue() || playType == PlayType.XZJZ_Z5B3.getValue() || playType == PlayType.XZJZ_Z4B4.getValue()) {
                //验证内容
                result=resultCountext(f,s[1],playType);
                if(!result.isPass()){
                    return result;
                }

                List<String> list = DltShrinkTemplate.getSpiralContent(s[1],playType);
                int count = list.size();
                amountTest += count;
                if (add.equals("0")) {
                    needAddCount += count;
                }
                counttest=count;
            }

            if(counttest >10000){
                result.setPass(false);
                result.setMessage("第"+f+"注单张彩票金额不能超过2万元！");
                return result;
            }
            counttest=0;
        }

        if (amountTest * TradeType.getTradeAmount(tradeType) * mutiple + needAddCount * mutiple != amount || amount <= 0) {
            result.setPass(false);
            result.setMessage("传入金额错误");
        } else {
            result.setPass(true);
            result.setMultiple(mutiple);
            result.setIsAttribute(add);
            result.setContent(content);
            result.setCount(amountTest);
        }
        if (flag > 1)
            playType = 0;

        result.setPlayType(PlayType.getItem(playType));
        return result;
    }

    public ContentCheck resultCountext(int i,String lines,int playType){
        ContentCheck  result = new ContentCheck();
        String[] codes = lines.split("\\|");

        //格式判断
        if(codes.length != 2) {
            result.setPass(false);
            result.setMessage("第" + i  + "行号码格式错误!");
            return result;
        }

        //前区个数判断
        String[] pres = codes[0].replaceAll("\\#","\\,").split("\\,");//处理胆拖的分隔符#
        if(pres.length < 5){
            result.setPass(false);
            result.setMessage("第" + i  + "行前区号码个数不足!");
            return result;
        }

        //后区个数判断
        String[] poss = codes[1].replaceAll("\\#","\\,").split("\\,");//处理胆拖的分隔符#
        if(poss.length < 2){
            result.setPass(false);
            result.setMessage("第" + i  + "行后区号码个数不足!");
            return result;
        }


        //前区范围,数字,重复判断
        HashMap<Integer,Integer> redMap = new HashMap<Integer,Integer>();
        for(int k = 0; k < pres.length; k++) {
            try {
                if(pres[k].length() != 2) {
                    result.setPass(false);
                    result.setMessage("第" +  i + "行前区号码必须为两位格式,如:01");
                    return result;
                }

                Integer code = Integer.parseInt(pres[k]);
                if (code < 1 || code > 35) {
                    result.setPass(false);
                    result.setMessage("第" +  i + "行前区号码必须大于等于1并小于等于35!");
                    return result;
                }
                redMap.put(code, code);
            } catch (Exception e) {
                LogUtil.error(e);
                result.setPass(false);
                result.setMessage("第" + i  + "行前区号码必须为数字!");
                return result;
            }
        }
        if(redMap.size() != pres.length) {
            result.setPass(false);
            result.setMessage("第" + i  + "行前区号码有重复!");
            return result;
        }

        //后区范围,数字,重复判断
        HashMap<Integer,Integer> blueMap = new HashMap<Integer,Integer>();
        for(int k = 0; k < poss.length; k++) {
            try {
                if(poss[k].length() != 2) {
                    result.setPass(false);
                    result.setMessage("第" +  i + "行后区号码必须为两位格式,如:01");
                    return result;
                }

                Integer code = Integer.parseInt(poss[k]);
                if(code < 1 || code > 12){
                    result.setPass(false);
                    result.setMessage("第" +  i + "行后区号码必须大于等于1并小于等于12!");
                    return result;
                }
                blueMap.put(code, code);
            } catch (Exception e) {
                LogUtil.error(e);
                result.setPass(false);
                result.setMessage("第" + i  + "行后区号码必须为数字!");
                return result;
            }
        }
        if(blueMap.size() != poss.length) {
            result.setPass(false);
            result.setMessage("第" + i  + "行后区有重复号码!");
            return result;
        }

        //胆拖玩法特别处理
        if(playType == PlayType.DT.getValue()){
            String[] preDantuo = codes[0].split("\\#");
            String[] posDantuo = codes[1].split("\\#");
            if(preDantuo.length != 2 && posDantuo.length != 2) { //前后区必须一个有胆码
                result.setPass(false);
                result.setMessage("第" + i  + "行胆拖格式错误!");
                return result;
            }

            //前区
            int preDanCount = 0;
            int preTuoCount = 0;
            if(preDantuo.length==2){
                preDanCount = preDantuo[0].split("\\,").length;
                preTuoCount = preDantuo[1].split("\\,").length;
            }else{
                preTuoCount = preDantuo[0].split("\\,").length;
            }
            if(preDanCount > 5){
                result.setPass(false);
                result.setMessage("第" + i + "行前区胆码个数必须小于5!");
                return result;
            }

            if(preTuoCount < 1){
                result.setPass(false);
                result.setMessage("第" + i + "行前区拖码个数必须大于等于1!");
                return result;
            }

            //后区
            int posDanCount=0;
            int posTuoCount=0;
            if(posDantuo.length==2){
                posDanCount = posDantuo[0].split("\\,").length;
                posTuoCount = posDantuo[1].split("\\,").length;
            }else{
                posTuoCount = posDantuo[0].split("\\,").length;
            }

            if(posTuoCount < 1){
                result.setPass(false);
                result.setMessage("第" + i + "行后区拖码个数必须大于等于1!");
                return result;
            }
        }

        //旋转矩阵玩法特别处理
        if(playType == PlayType.XZJZ_Z5B4.getValue() || playType == PlayType.XZJZ_Z5B3.getValue() || playType == PlayType.XZJZ_Z4B4.getValue()) {
            int minCount = 6;
            if(playType == PlayType.XZJZ_Z5B4.getValue()) {
                minCount = 7;
            }
            if(playType == PlayType.XZJZ_Z5B3.getValue()) {
                minCount = 10;
            }
            if(playType == PlayType.XZJZ_Z4B4.getValue()) {
                minCount = 6;
            }

            if(pres.length < minCount || pres.length > 20) {
                result.setPass(false);
                result.setMessage("第" + i + "行旋转矩阵前区号码个数必须大于等于"+ minCount +"并小于等于20!");
                return result;
            }
            if(poss.length < 2 || poss.length > 12) {
                result.setPass(false);
                result.setMessage("第" + i + "行旋转矩阵后区号码个数必须大于等于2并小于等于12!");
                return result;
            }
        }

        result.setPass(true);
        return result;
    }

    public int combination(int m, int n)// m为下标，n为上标
    {
        if (m < 0 || n < 0 || m < n)
            return -1;
        // 数据不符合要求，返回错误信息
        n = n < (m - n) ? n : m - n;// C(m,n)=C(m,m-n)
        if (n == 0)
            return 1;
        int result = m;// C(m,1);
        for (int i = 2, j = result - 1; i <= n; i++, j--) {
            result = result * j / i;// 得到C(m,i)
        }
        return result;
    }

    /**
     * 生肖乐号码格式检查
     * @param i         第几行
     * @param lines     行内容
     * @return 返回检查器
     */
    public ContentCheck checkSXL(int i,String lines){
        ContentCheck  result = new ContentCheck();

        //后区个数判断
        String[] poss = lines.split("\\,");
        if(poss.length < 2){
            result.setPass(false);
            result.setMessage("第" + i  + "行生肖乐号码个数不足!");
            return result;
        }

        //后区范围,数字,重复判断
        HashMap<Integer,Integer> blueMap = new HashMap<Integer,Integer>();
        for(int k = 0; k < poss.length; k++) {
            try {
                if(poss[k].length() != 2) {
                    result.setPass(false);
                    result.setMessage("第" +  i + "行生肖乐号码必须为两位格式,如:01");
                    return result;
                }

                Integer code = Integer.parseInt(poss[k]);
                if(code < 1 || code > 12){
                    result.setPass(false);
                    result.setMessage("第" +  i + "行生肖乐号码必须大于等于1并小于等于12!");
                    return result;
                }
                blueMap.put(code, code);
            } catch (Exception e) {
                LogUtil.error(e);
                result.setPass(false);
                result.setMessage("第" + i  + "行生肖乐号码必须为数字!");
                return result;
            }
        }
        if(blueMap.size() != poss.length) {
            result.setPass(false);
            result.setMessage("第" + i  + "行生肖乐有重复号码!");
            return result;
        }

        result.setPass(true);
        return result;
    }

}
