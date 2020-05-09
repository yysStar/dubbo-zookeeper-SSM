package com.qiyun.service.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.qiyun.api.LotteryApi;
import com.qiyun.bonus.AwardResultVo;
import com.qiyun.bonus.Sporttery3GMatchItem;
import com.qiyun.common.CommonStatus;
import com.qiyun.common.Result;
import com.qiyun.commonModel.PlayType;
import com.qiyun.commonModel.TradeType;
import com.qiyun.dto.*;
import com.qiyun.factory.AwardDetailYcFactory;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.mapper2.DgMapper;
import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallBetContent;
import com.qiyun.model.basketball.BasketBallMatchItem;

import com.qiyun.model2.*;


import com.qiyun.service.*;
import com.qiyun.task.ChaiPiaoTask;
import com.qiyun.tools.CLSmsSend;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.BigDecimalUtil;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import com.qiyun.util.LotteryUtils;
import com.qiyun.utils.*;
import com.qiyun.commonModel.LotteryType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("lotteryApi")
public class LotteryBiz implements LotteryApi {

    @Resource
    private CommisionService commisionService;

    @Resource
    private MemberAgentService memberAgentService;

    @Resource
    private MemberRateService memberRateService;

    @Resource
    private LotteryPlanAddPrizeService lotteryPlanAddPrizeService;

    @Resource
    private ReturnPrizeService returnPrizeService;

    @Resource
    private CheckBingoService checkBingoService;

    @Resource
    private LotteryLimitService lotteryLimitService;

    @Resource
    private LotteryTermService lotteryTermService;

    @Resource
    private MemberGradeService memberGradeService;

    @Resource
    private TicketFindNewService ticketFindNewService;

    @Resource
    private BlackForAddPrizeService blackForAddPrizeService;

    @Resource
    private AddPrizeService addPrizeService;

    @Resource
    private FocusMatchBbService focusMatchBbService;

    @Resource
    private FocusMatchFbService focusMatchFbService;

    @Resource
    private TicketService ticketService;

    @Resource
    private DGService dgService;

    @Resource
    private NewStar2Service newStar2Service;

    @Resource
    private MemberFollowMappingService memberFollowMappingService;

    @Resource
    private WinPromotionService winPromotionService;

    @Resource
    private PlanShowService planShowService;

    @Resource
    private SportteryBasketBallMatchService sportteryBasketBallMatchService;

    @Resource
    private SportteryFootballMatchService sportteryFootBallMatchService;

    @Resource
    private CopyLotteryPlanService copyLotteryService;

    @Resource
    private LotteryPlanService lotteryPlanService;

    @Resource
    private LotteryPlanOrderService lotteryPlanOrderService;

    @Resource
    private MemberWalletService memberWalletService;

    @Resource
    private MemberWalletLineService memberWalletLineService;

    @Resource
    private MemberService memberService;

    @Autowired
    private DgMapper dgMapper;

    @Autowired
    private AwardDetailYcFactory awardDetailYcFactory;

    @Autowired
    private ChaiPiaoTask chaiPiaoTask;

    public MemberWallet2DTO getMemberWallet(Member2DTO member2DTO) {
        return memberWalletService.getByMemberId(member2DTO.getId());
    }

    public Result copyLotteryPlan(String GDAccount,Integer planNo, Integer multiple,Integer amount,Integer cardId/*彩金卡id*/,Double cardMoney) {
        Result result = new Result();

        LotteryPlan2WithBLOBs byPlanNo = lotteryPlanService.getByPlanNo(planNo);
        if (byPlanNo==null){
            result.setSuccess(false);
            result.setMsg("找不到方案");
            return result;
        }
        if (byPlanNo.getIsSuperMan()!=1){
            result.setSuccess(false);
            result.setMsg("不能跟复制的单");
            return result;
        }
        Member2DTO member2DTO = memberService.getByAccount(GDAccount);
        if (member2DTO==null){
            result.setSuccess(false);
            result.setMsg("找不到会员");
            return result;
        }
        if (member2DTO.getAccount().equals(byPlanNo.getAccount())){
            result.setSuccess(false);
            result.setMsg("请不要跟自己的单");
            return result;
        }

        MemberWallet2DTO memberWallet = memberWalletService.getByMemberId(member2DTO.getId());
        if (memberWallet==null){
            result.setSuccess(false);
            result.setMsg("找不到会员钱包");
            return result;
        }
        if (memberWallet.getAbleBalance() + cardMoney < amount){
            result.setSuccess(false);
            result.setMsg("余额不足");
            return result;
        }

        if (cardMoney!=0) {
            BigDecimal big = memberWalletLineService.findCardFullMoneyById(cardId);
            if (amount < Double.valueOf(big.toPlainString())) {
                result.setSuccess(false);
                result.setMsg("当前金额小于彩金卡使用额度");
                return result;
            }
        }

        Integer lotteryType = byPlanNo.getLotteryType();

        //判断是否在投注时间
        int dgStatus = dgService.getDGStatus();
        if (dgStatus==0){
            result.setSuccess(false);
            result.setMsg("很晚了，注意休息!");
            return result;
        }

        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String intTime2 = sdf1.format(date);
        if ("09:00:00".compareTo(sdf2.format(date)) >= 0){
            //9点前算前一天
            long time = date.getTime() - 1000 * 60 * 60 *24;
            intTime2 = sdf1.format(new Date(time));
        }
        int dealTime = dgService.getDealTime();
        List<SportteryFootballMatch2> list = sportteryFootBallMatchService.getWorldCupByIntTime(Integer.parseInt(intTime2));
        if(LotteryUtils.isNotWorkTimeByWorldCup(list,dealTime)){
            result.setSuccess(false);
            result.setMsg("很晚了，注意休息!");
            return result;
        }

        Date dealDateTime = byPlanNo.getDealDateTime();
        if (date.after(dealDateTime)){
            result.setSuccess(false);
            result.setMsg("该赛事已截止!");
            return result;
        }

        String typeStr = "";
        if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
            typeStr = "篮球";
        }else if(LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))) {
            typeStr = "足球";
        }
        String content = byPlanNo.getContent();
        Integer planStatus = byPlanNo.getPlanStatus();
        if (planStatus!=3 && planStatus!=4 && planStatus!=8) {
            result.setSuccess(false);
            result.setMsg("该方案票务无效");
            return result;
        }
        if(content != null) {
            JSONObject jsonObject = JSONObject.fromObject(content);
            if (jsonObject!=null) {
                JSONArray matchItems = jsonObject.optJSONArray("matchItems");
                if (matchItems!=null) {
                    for (Object matchItem : matchItems) {
                        JSONObject match = (JSONObject) matchItem;
                        Integer intTime = Integer.parseInt(match.getString("intTime"));
                        Integer lineId = match.getInt("lineId");
                        if ("篮球".equals(typeStr)) {
                            SportteryBasketMatch2 sportteryBasketMatch2 = sportteryBasketBallMatchService.getByIntTimeAndLineId(intTime,lineId);
                            if (sportteryBasketMatch2==null){
                                result.setSuccess(false);
                                return result;
                            }
                            if (sportteryBasketMatch2.getStatus()!=0) {
                                result.setSuccess(false);
                                result.setMsg("该场次不在销售状态");
                                return result;
                            }
                        }else if("足球".equals(typeStr)) {
                            SportteryFootballMatch2 sportteryFootballMatch2 = sportteryFootBallMatchService.getByIntTimeAndLineId(intTime,lineId);
                            if (sportteryFootballMatch2==null){
                                result.setSuccess(false);
                                return result;
                            }
                            if (sportteryFootballMatch2.getStatus()!=0) {
                                result.setSuccess(false);
                                result.setMsg("该场次不在销售状态");
                                return result;
                            }
                        }
                    }
                }
            }
        }

        byPlanNo.setSumamount(byPlanNo.getSumamount()+amount);
        if (byPlanNo.getBookCount()==null) {
            byPlanNo.setBookCount(1);
        }else{
            byPlanNo.setBookCount(byPlanNo.getBookCount() + 1);
        }
        lotteryPlanService.update(byPlanNo);

        CopyLotteryPlan2DTO copyLotteryPlan2DTO = new CopyLotteryPlan2DTO();
        copyLotteryPlan2DTO.setCopyLotteryplanName(GDAccount);
        copyLotteryPlan2DTO.setCopyLotteryplanNo(planNo);
        copyLotteryPlan2DTO.setCopyLotteryplanPlanname(byPlanNo.getAccount());
        copyLotteryPlan2DTO.setCopyLotteryplanAmount(amount);
        copyLotteryPlan2DTO.setCopyLotteryplanContent(byPlanNo.getContent());
        copyLotteryPlan2DTO.setCopyLotteryplanMultiple(multiple);
        copyLotteryPlan2DTO.setCopyLotteryplanPosttaxprize(0);
        copyLotteryPlan2DTO.setCopyLotteryplanPlantype(byPlanNo.getPlanType());
        copyLotteryPlan2DTO.setCopyLotteryplanCreateDateTime(byPlanNo.getCreateDateTime());
        copyLotteryPlan2DTO.setCopyLotteryplanLotterytype(byPlanNo.getLotteryType());
        copyLotteryPlan2DTO.setCopyLotteryplanTerm(byPlanNo.getTerm());
        copyLotteryPlan2DTO.setCopyLotteryplanAddprize(0d);
        copyLotteryPlan2DTO.setCopyLotteryplanSelecttype(byPlanNo.getSelectType());
        copyLotteryPlan2DTO.setCopyLotteryplanPublicstatus(byPlanNo.getPublicStatus());
        copyLotteryPlan2DTO.setCopyLotteryplandesc(byPlanNo.getPlanDesc());
        result = copyLotteryService.insert(copyLotteryPlan2DTO);
        if (!result.isSuccess()){
            return result;
        }

        String newContent = updateContent(byPlanNo.getContent(),typeStr);
        String dlAccount = "";
        String qdAccount = "";
        Map<String, Object> dlAndQdAccount = getDlAndQdAccount(member2DTO);
        if ((Integer)dlAndQdAccount.get(Constants.CODE)==200){
            dlAccount = dlAndQdAccount.get("dlAccount")==null?null:dlAndQdAccount.get("dlAccount").toString();
            qdAccount = dlAndQdAccount.get("qdAccount")==null?null:dlAndQdAccount.get("qdAccount").toString();
        }
        LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs = new LotteryPlan2WithBLOBs();
        lotteryPlan2WithBLOBs.setLotteryType(byPlanNo.getLotteryType());
        lotteryPlan2WithBLOBs.setTerm(byPlanNo.getTerm());
        lotteryPlan2WithBLOBs.setPlanType(1);
        lotteryPlan2WithBLOBs.setSelectType(2);
        lotteryPlan2WithBLOBs.setMemberId(member2DTO.getId());
        lotteryPlan2WithBLOBs.setAccount(member2DTO.getAccount());
        lotteryPlan2WithBLOBs.setCreateDateTime(new Date());
        lotteryPlan2WithBLOBs.setAmount(amount);
        lotteryPlan2WithBLOBs.setPerAmount(amount);
        lotteryPlan2WithBLOBs.setPart(byPlanNo.getPart());
        lotteryPlan2WithBLOBs.setSoldPart(1);
        lotteryPlan2WithBLOBs.setFounderPart(1);
        lotteryPlan2WithBLOBs.setReservePart(0);
        lotteryPlan2WithBLOBs.setDealDateTime(byPlanNo.getDealDateTime());
        lotteryPlan2WithBLOBs.setMultiple(multiple);
        lotteryPlan2WithBLOBs.setPlanStatus(3);
        lotteryPlan2WithBLOBs.setWinStatus(1);
        lotteryPlan2WithBLOBs.setPretaxPrize(0d);
        lotteryPlan2WithBLOBs.setPosttaxPrize(0d);
        lotteryPlan2WithBLOBs.setClicks(0);
        lotteryPlan2WithBLOBs.setContent(newContent);
        lotteryPlan2WithBLOBs.setIsUploadContent(0);
        lotteryPlan2WithBLOBs.setExperience(0);
        lotteryPlan2WithBLOBs.setIsSuperMan(0);
        lotteryPlan2WithBLOBs.setPlayType(byPlanNo.getPlayType());
        lotteryPlan2WithBLOBs.setVerifyMd5(DbDataVerify.getLotteryPlan2Verify(lotteryPlan2WithBLOBs));
        lotteryPlan2WithBLOBs.setPublicStatus(3);
        lotteryPlan2WithBLOBs.setCommision(0);
        lotteryPlan2WithBLOBs.setPlanTicketStatus(1);
        lotteryPlan2WithBLOBs.setIsAbleTicketing(0);
        lotteryPlan2WithBLOBs.setAccountDocumentary(byPlanNo.getAccount());
        lotteryPlan2WithBLOBs.setPlannoCopydocumentary(byPlanNo.getPlanNo());
        lotteryPlan2WithBLOBs.setAutomaticType("0");
        lotteryPlan2WithBLOBs.setSumamount(0);
        lotteryPlan2WithBLOBs.setTradeType(0);
        lotteryPlan2WithBLOBs.setHaploidAmount(amount/multiple);
        lotteryPlan2WithBLOBs.setMaxSp(byPlanNo.getMaxSp());
        lotteryPlan2WithBLOBs.setDlAccount(dlAccount);
        lotteryPlan2WithBLOBs.setQdAccount(qdAccount);
        Double a = multiple*1.0/byPlanNo.getMultiple();
        lotteryPlan2WithBLOBs.setMinBonus(byPlanNo.getMinBonus()==null?BigDecimalUtil.round(0):BigDecimalUtil.round(byPlanNo.getMinBonus().doubleValue()*a));
        lotteryPlan2WithBLOBs.setMaxBonus(byPlanNo.getMaxBonus()==null?BigDecimalUtil.round(0):BigDecimalUtil.round(byPlanNo.getMaxBonus().doubleValue()*a));
        result = lotteryPlanService.insert(lotteryPlan2WithBLOBs);
        if (!result.isSuccess()){
            return result;
        }
        LotteryPlan2WithBLOBs data = (LotteryPlan2WithBLOBs) result.getData();
        LotteryPlanOrder2DTO lotteryPlanOrder2DTO = new LotteryPlanOrder2DTO();
        lotteryPlanOrder2DTO.setPlanNo(data.getPlanNo());
        lotteryPlanOrder2DTO.setAccount(data.getAccount());
        lotteryPlanOrder2DTO.setBuyType(1);
        lotteryPlanOrder2DTO.setCreateDateTime(new Date());
        lotteryPlanOrder2DTO.setStatus(2);
        lotteryPlanOrder2DTO.setPart(1);
        lotteryPlanOrder2DTO.setAmount(amount);
        lotteryPlanOrder2DTO.setPosttaxPrize(0d);
        lotteryPlanOrder2DTO.setPrizeSettleStatus(1);
        lotteryPlanOrder2DTO.setScore(amount*10);
        lotteryPlanOrder2DTO.setExperience(0);
        lotteryPlanOrder2DTO.setVerifyMd5(DbDataVerify.getLotteryPlanOrder2DTOVerify(lotteryPlanOrder2DTO));
        lotteryPlanOrder2DTO.setMemberId(data.getMemberId());
        lotteryPlanOrder2DTO.setWalletType(1);
        lotteryPlanOrder2DTO.setFollowingType(10);
        lotteryPlanOrder2DTO.setGold(0d);
        lotteryPlanOrder2DTO.setSumGold(0d);
        lotteryPlanOrder2DTO.setWebSiteGold(0d);
        result = lotteryPlanOrderService.insert(lotteryPlanOrder2DTO);
        if (!result.isSuccess()){
            return result;
        }



        if (0==cardMoney) {
            if (memberWallet.getAbleBalance()-memberWallet.getTakeCashQuota()<amount){
                memberWallet.setTakeCashQuota(NumberTools.round(memberWallet.getAbleBalance()-amount,2));
            }
            memberWallet.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance() - amount,2));
            memberWallet.setHeapBalance(NumberTools.round(memberWallet.getHeapBalance()+amount,2));
        }else {
            //把使用彩金卡的金额加入钱包
            if (memberWallet.getAbleBalance()+cardMoney-memberWallet.getTakeCashQuota()<amount){
                memberWallet.setTakeCashQuota(NumberTools.round(memberWallet.getAbleBalance()+cardMoney-amount,2));
            }
            memberWallet.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance() - amount + cardMoney,2));
            memberWallet.setHeapBalance(NumberTools.round(memberWallet.getHeapBalance() + amount - amount + cardMoney,2));
            //生成钱包流水
            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setPlanNo(lotteryPlanOrder2DTO.getPlanNo());
            memberWalletLine2.setOrderNo(lotteryPlanOrder2DTO.getOrderNo());
            memberWalletLine2.setAccount(memberWallet.getAccount());
            memberWalletLine2.setMemberId(memberWallet.getMemberId());
            memberWalletLine2.setTransType(-1001);// 独立扣款科目，负数值存为正
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setAmount(cardMoney);
            memberWalletLine2.setLotteryType(lotteryType);
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2.setSourceId(member2DTO.getSourceId());
            memberWalletLine2.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance() + cardMoney,2));
            memberWalletLine2.setFreezeBalance(memberWallet.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet.getHeapBalance());
            memberWalletLine2.setRemark("彩金卡抵扣");
            memberWalletLine2.setPrizeBalance(memberWallet.getPrizeBalance());
            memberWalletLineService.insert(memberWalletLine2);
            //修改这张 彩金卡
            memberWalletLineService.updateCard(cardId, new Date());
        }
        LotteryPlanOrder2 data1 = (LotteryPlanOrder2) result.getData();
        MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
        memberWalletLine2.setPlanNo(lotteryPlanOrder2DTO.getPlanNo());
        memberWalletLine2.setOrderNo(data1.getOrderNo());
        memberWalletLine2.setAccount(memberWallet.getAccount());
        memberWalletLine2.setMemberId(memberWallet.getMemberId());
        memberWalletLine2.setTransType(2061);
        memberWalletLine2.setWalletType(1);
        memberWalletLine2.setAmount((double)amount);
        memberWalletLine2.setLotteryType(lotteryPlan2WithBLOBs.getLotteryType());
        memberWalletLine2.setCreateDateTime(new Date());
        memberWalletLine2.setStatus(0);
        memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
        memberWalletLine2.setSourceId(member2DTO.getSourceId());
        memberWalletLine2.setAbleBalance(memberWallet.getAbleBalance());
        memberWalletLine2.setFreezeBalance(memberWallet.getFreezeBalance());
        memberWalletLine2.setHeapBalance(memberWallet.getHeapBalance());
        memberWalletLine2.setRemark("复制跟单");
        memberWalletLine2.setPrizeBalance(memberWallet.getPrizeBalance());
        result = memberWalletLineService.insert(memberWalletLine2);
        if (!result.isSuccess()){
            return result;
        }
        result = memberWalletService.update(memberWallet);
        if (result.isSuccess()){
            result.setMsg("跟单成功");
        }
        return result;
    }

    private String updateContent(String content,String type) {
        JSONObject contentObject = JSONObject.fromObject(content);
        if ("篮球".equals(type)){
            JSONArray matchItems = contentObject.optJSONArray("matchItems");
            for (int j = 0; j < matchItems.size(); j++) {
                JSONObject matchItemObj = JSONObject.fromObject(matchItems.get(j));
                int intTime = matchItemObj.optInt("intTime");
                int lineId = matchItemObj.optInt("lineId");
                Map sfcs = sportteryBasketBallMatchService.getSfcAward(1,intTime,lineId);
                List<Map> dxfAward = sportteryBasketBallMatchService.getbasketAward(1,intTime,lineId,3);
                List<Map> rfAward = sportteryBasketBallMatchService.getbasketAward(1,intTime,lineId,2);
                List<Map> sfAward = sportteryBasketBallMatchService.getbasketAward(1,intTime,lineId,0);
                JSONObject fbValueStrMap = matchItemObj.optJSONObject("fbValueStrMap");
                Set set = fbValueStrMap.keySet();
                for (Object key : set) {
                    Object o = fbValueStrMap.get(key);
                    JSONArray plays = JSONArray.fromObject(o);
                    for (int i = 0; i < plays.size(); i++) {
                        JSONArray playObj = JSONArray.fromObject(plays.get(i));
                        String basketAward = ContentUtils.getBasketAward(playObj.get(0).toString(), sfcs, (dxfAward==null||dxfAward.size()<=0)?null:dxfAward.get(0), (rfAward==null||rfAward.size()<=0)?null:rfAward.get(0), (sfAward==null||sfAward.size()<=0)?null:sfAward.get(0));
                        playObj.set(1,basketAward);
                        System.out.println(playObj.toString());
                        plays.set(i,playObj);
                    }
                    System.out.println(plays.toString());
                    fbValueStrMap.put(key,plays);
                }
                System.out.println(fbValueStrMap.toString());

                JSONArray optionsArr = matchItemObj.optJSONArray("options");
                for (int z = 0; z < optionsArr.size(); z++) {
                    JSONObject optionObj = JSONObject.fromObject(optionsArr.get(z));
                    if (optionObj.optString("type").equals("31")){
                        optionObj.put("rf",Double.parseDouble(rfAward.get(0).get("handicap").toString()));
                        optionObj.put("RF",Double.parseDouble(rfAward.get(0).get("handicap").toString()));
                        matchItemObj.put("RF",Double.parseDouble(rfAward.get(0).get("handicap").toString()));
                    }else if (optionObj.optString("type").equals("33")){
                        matchItemObj.put("DXF",Double.parseDouble(dxfAward.get(0).get("baseBigOrSmall").toString()));
                        optionObj.put("DXF",Double.parseDouble(dxfAward.get(0).get("baseBigOrSmall").toString()));
                    }
                    String typeValueStr = optionObj.optString("typeValueStr");
                    String basketAward = ContentUtils.getBasketAward(typeValueStr, sfcs, (dxfAward==null||dxfAward.size()<=0)?null:dxfAward.get(0), (rfAward==null||rfAward.size()<=0)?null:rfAward.get(0), (sfAward==null||sfAward.size()<=0)?null:sfAward.get(0));
                    optionObj.put("award",Double.parseDouble(basketAward));
                    optionsArr.set(z,optionObj);
                }
                matchItemObj.put("options",optionsArr);
                matchItems.set(j,matchItemObj);
            }
            contentObject.put("matchItems",matchItems);
        }else if ("足球".equals(type)){
            JSONArray matchItems = contentObject.optJSONArray("matchItems");
            for (int j = 0; j < matchItems.size(); j++) {
                JSONObject matchItemObj = JSONObject.fromObject(matchItems.get(j));
                int intTime = matchItemObj.optInt("intTime");
                int lineId = matchItemObj.optInt("lineId");
                List<Map> spfAward = sportteryFootBallMatchService.getSpfAward(intTime,lineId);
                List<Map> rqspfAward = sportteryFootBallMatchService.getRqspfAward(intTime,lineId);
                List<Map> bqcAward = sportteryFootBallMatchService.getBqcAward(intTime,lineId);
                List<Map> bfAward = sportteryFootBallMatchService.getBfAward(intTime,lineId);
                List<Map> jqsAward = sportteryFootBallMatchService.getJqsAward(intTime,lineId);
                SportteryFootballMatch2 byIntTimeAndLineId = sportteryFootBallMatchService.getByIntTimeAndLineId(intTime, lineId);
//                Map<String, List<String[]>> fbValueStrMap = matchItem.getFbValueStrMap();
                JSONObject fbValueStrMap = matchItemObj.optJSONObject("fbValueStrMap");
                Set set = fbValueStrMap.keySet();
                for (Object key : set) {
                    Object o = fbValueStrMap.get(key);
                    JSONArray plays = JSONArray.fromObject(o);
                    for (int i = 0; i < plays.size(); i++) {
                        JSONArray playObj = JSONArray.fromObject(plays.get(i));
                        String footBallAward = ContentUtils.getFootBallAward(key.toString(), (spfAward==null||spfAward.size()<=0)?null:spfAward.get(0), (rqspfAward==null||rqspfAward.size()<=0)?null:rqspfAward.get(0), (bqcAward==null||bqcAward.size()<=0)?null:bqcAward.get(0), (bfAward==null||bfAward.size()<=0)?null:bfAward.get(0), (jqsAward==null||jqsAward.size()<=0)?null:jqsAward.get(0), playObj.get(0).toString());
                        playObj.set(1,footBallAward);
                        System.out.println(playObj.toString());
                        plays.set(i,playObj);
                    }
                    System.out.println(plays.toString());
                    fbValueStrMap.put(key,plays);
                }
                System.out.println(fbValueStrMap.toString());

                JSONArray optionsArr = matchItemObj.optJSONArray("options");
                for (int z = 0; z < optionsArr.size(); z++) {
                    JSONObject optionObj = JSONObject.fromObject(optionsArr.get(z));
                    String type1 = optionObj.optString("type");
                    String play = ContentUtils.getPlay(type1);
                    if (type1.equals("34")){
                        optionObj.put("rqs",byIntTimeAndLineId.getConcede());
                    }
                    String footBallAward = ContentUtils.getFootBallAward(play, (spfAward==null||spfAward.size()<=0)?null:spfAward.get(0), (rqspfAward==null||rqspfAward.size()<=0)?null:rqspfAward.get(0), (bqcAward==null||bqcAward.size()<=0)?null:bqcAward.get(0), (bfAward==null||bfAward.size()<=0)?null:bfAward.get(0), (jqsAward==null||jqsAward.size()<=0)?null:jqsAward.get(0), optionObj.optString("typeValueStr"));
                    optionObj.put("award",Double.parseDouble(footBallAward));
                    optionsArr.set(z,optionObj);
                }
                matchItemObj.put("options",optionsArr);
                matchItems.set(j,matchItemObj);
            }
            contentObject.put("matchItems",matchItems);
        }
        return contentObject.toString();
    }

    public Map<String,Object> querySuperLotteryPlan(int page, int pageSize, String type,String username,Member2DTO member2DTO,int sortType,Integer isFocus) {
        Map<String,Object> map = new HashMap<String,Object>();
        long time = new Date().getTime();
        List<Map> list = lotteryPlanService.querySuperLotteryPlan(page,pageSize,type,username,sortType,isFocus,member2DTO.getAccount());
        System.out.println((new Date().getTime()-time)/1000d);
        for (Map map1 : list) {
            int tzCountByAccount = lotteryPlanOrderService.getTZCountByAccount(map1.get("account").toString());
            int zjCountByAccount = lotteryPlanOrderService.getZJCountByAccount(map1.get("account").toString());
            map1.put("winRate",tzCountByAccount+"中"+zjCountByAccount);
            map1.put("playType",PlayType.getItem((Integer) map1.get("playType")).getName());
            map1.put("picture","qyun88.oss-cn-hangzhou.aliyuncs.com/member/"+map1.get("picture"));
            List<MemberFollowMapping2> memberFollowMapping2s = memberFollowMappingService.getByaccountAndFansAccount(map1.get("account").toString(),member2DTO.getAccount());
            if (memberFollowMapping2s==null || memberFollowMapping2s.size()<=0){
                map1.put("isFollow",false);
            }else{
                map1.put("isFollow",true);
            }
            if (member2DTO.getAccount().equals(map1.get("account").toString())){
                map1.put("isSelf",true);
            }else{
                map1.put("isSelf",false);
            }
            Integer evenRed = lotteryPlanService.getEvenRedByAccount(map1.get("account").toString());
            map1.put("evenRed",evenRed);
        }
        PageInfo pageInfo = new PageInfo(list);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);
        return map;

        /*for (LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs : list) {
            String account = lotteryPlan2WithBLOBs.getAccount();
            Member2DTO byAccount = memberService.getByAccount(account);
            if (byAccount.getType()==1){
                lotteryPlan2WithBLOBs.setSumamount(lotteryPlan2WithBLOBs.getSumamount()-lotteryPlan2WithBLOBs.getAmount()+lotteryPlan2WithBLOBs.getAmount()*byAccount.getMultiple());
                lotteryPlan2WithBLOBs.setAmount(lotteryPlan2WithBLOBs.getAmount()*byAccount.getMultiple());
            }
        }
        if (sortType==1) {
            Collections.sort(list);
        }
        List<Map<String,Object>> lotteryPlan2DTOS = new ArrayList<Map<String,Object>>();
        for (LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs : list) {
            *//*Integer lotteryType = lotteryPlan2WithBLOBs.getLotteryType();
            String typeStr = "";
            if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
                typeStr = "篮球";
            }else if(LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))) {
                typeStr = "足球";
            }
            String content = lotteryPlan2WithBLOBs.getContent();
            if(content != null) {
                JSONObject jsonObject = JSONObject.fromObject(content);
                if (jsonObject!=null) {
                    JSONArray matchItems = jsonObject.optJSONArray("matchItems");
                    if (matchItems!=null) {
                        boolean flag = true;
                        for (Object matchItem : matchItems) {
                            JSONObject match = (JSONObject) matchItem;
                            Integer intTime = Integer.parseInt(match.getString("intTime"));
                            Integer lineId = match.getInt("lineId");
                            if ("篮球".equals(typeStr)) {
                                SportteryBasketMatch2 sportteryBasketMatch2 = sportteryBasketBallMatchService.getByIntTimeAndLineId(intTime,lineId);
                                if (sportteryBasketMatch2==null){
                                    result.setSuccess(false);
                                    return result;
                                }
                                if (sportteryBasketMatch2.getStatus()!=0) {
                                    flag = false;
                                    break;
                                }
                            }else if("足球".equals(typeStr)) {
                                SportteryFootballMatch2 sportteryFootballMatch2 = sportteryFootBallMatchService.getByIntTimeAndLineId(intTime,lineId);
                                if (sportteryFootballMatch2==null){
                                    result.setSuccess(false);
                                    return result;
                                }
                                if (sportteryFootballMatch2.getStatus()!=0) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (!flag){
                            continue;
                        }
                    }
                }
            }*//*
            Member2DTO byAccount = memberService.getByAccount(lotteryPlan2WithBLOBs.getAccount());
            Map<String,Object> respMap = new HashMap<String, Object>();

            respMap.put("account",lotteryPlan2WithBLOBs.getAccount());
            respMap.put("amount", lotteryPlan2WithBLOBs.getAmount());
            respMap.put("bookCount",lotteryPlan2WithBLOBs.getBookCount()==null?0:lotteryPlan2WithBLOBs.getBookCount());
            respMap.put("dealDateTime",new SimpleDateFormat("yyyy-MM-dd HH:mm").format(lotteryPlan2WithBLOBs.getDealDateTime()));
            if (byAccount.getType()==1) {
                respMap.put("haploidAmount", lotteryPlan2WithBLOBs.getAmount() / lotteryPlan2WithBLOBs.getMultiple() / byAccount.getMultiple());
            }else{
                respMap.put("haploidAmount", lotteryPlan2WithBLOBs.getAmount() / lotteryPlan2WithBLOBs.getMultiple());
            }
            respMap.put("lotteryType",LotteryType.getItem(lotteryPlan2WithBLOBs.getLotteryType()).getName());
            respMap.put("pictureUrl",byAccount.getPictureUrl());
            respMap.put("planNo",lotteryPlan2WithBLOBs.getPlanNo());
            respMap.put("playType", PlayType.getItem(lotteryPlan2WithBLOBs.getPlayType()).getName());
            respMap.put("username",byAccount.getUsername());
            respMap.put("sumAmount", lotteryPlan2WithBLOBs.getSumamount());
            respMap.put("planDesc",lotteryPlan2WithBLOBs.getPlanDesc());

            int tzCountByAccount = lotteryPlanOrderService.getTZCountByAccount(lotteryPlan2WithBLOBs.getAccount());
            int zjCountByAccount = lotteryPlanOrderService.getZJCountByAccount(lotteryPlan2WithBLOBs.getAccount());
            respMap.put("winRate",tzCountByAccount+"中"+zjCountByAccount);

            List<MemberFollowMapping2> memberFollowMapping2s = memberFollowMappingService.getByaccountAndFansAccount(lotteryPlan2WithBLOBs.getAccount(),member2DTO.getAccount());
            if (memberFollowMapping2s==null || memberFollowMapping2s.size()<=0){
                respMap.put("isFollow",false);
            }else{
                respMap.put("isFollow",true);
            }
            if (member2DTO.getAccount().equals(lotteryPlan2WithBLOBs.getAccount())){
                respMap.put("isSelf",true);
            }else{
                respMap.put("isSelf",false);
            }
            lotteryPlan2DTOS.add(respMap);
        }

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,lotteryPlan2DTOS);
        map.put(Constants.TOTAL_COUNT,pageInfo.getTotal());
        return map;*/
    }

    public Result getPlanForUserCenter(int planType,Integer lotteryType, Integer planStatus, Integer winStatus, int page, int pageSize,Member2DTO member2DTO) {
        return lotteryPlanOrderService.getPlanForUserCenter(planType,lotteryType,planStatus,winStatus,page,pageSize,member2DTO.getAccount());
    }

    public Result getTRAmount(int planType,int lotteryType, int planStatus, int winStatus, Member2DTO member2DTO) {
        return lotteryPlanOrderService.getTRAmount(planType,lotteryType,planStatus,winStatus,member2DTO.getAccount());
    }

    public Result getZJAmount(int planType,int lotteryType, int planStatus, int winStatus, Member2DTO member2DTO) {
        return lotteryPlanOrderService.getZJAmount(planType,lotteryType,planStatus,winStatus,member2DTO.getAccount());
    }

    public Result getPlanDetail(Integer planNo,Member2DTO member2DTO) {
        return lotteryPlanService.getPlanDetail(planNo,member2DTO);
    }

    public Result hisIndex(String account) {
        Result result = new Result();
        try {
            double zjAmount = lotteryPlanOrderService.getZJAmountByAccount(account);
            int winCount = lotteryPlanOrderService.getZJCountByAccount(account);
            int tZCount = lotteryPlanOrderService.getTZCountByAccount(account);
            Member2DTO byAccount = memberService.getByAccount(account);
            if (byAccount==null){
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }
            Map<String,Object> map = new HashMap<String,Object>();
            if (byAccount.getType()==1){
                map.put("winAmount",zjAmount*byAccount.getMultiple());
            }else{
                map.put("winAmount",zjAmount);
            }
            map.put("winCount",winCount);
            if (winCount==0){
                map.put("winRate",0);
            }else{
                BigDecimal bd = new BigDecimal(winCount*1.0/(tZCount)*100);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                map.put("winRate",bd.toString()+"%");
            }
            result.setData(map);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg("他人主页出错");
            return result;
        }
    }

    public Result getCopyPlanList(Integer planNo) {
        return lotteryPlanService.getCopyPlanList(planNo);
    }

    public Result getPlanMatchDetail(int planNo, String account) {
        Result result = new Result();
        List<MatchDeatilDTO> matchDeatilDTOs = new ArrayList<MatchDeatilDTO>();
        LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs = lotteryPlanService.getByPlanNo(planNo);
        if (lotteryPlan2WithBLOBs==null){
            result.setSuccess(false);
            result.setMsg("找不到方案");
            return result;
        }
        Integer publicStatus = lotteryPlan2WithBLOBs.getPublicStatus();
        Integer lotteryType = lotteryPlan2WithBLOBs.getLotteryType();
        String typeStr = "";
        if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
            typeStr = "篮球";
        }else if(LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))) {
            typeStr = "足球";
        }

        String content = lotteryPlan2WithBLOBs.getContent();
        if(StringUtils.isNullOrBlank(content)) {
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        JSONObject jsonObject = JSONObject.fromObject(content);
        if (jsonObject==null) {
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        JSONArray matchItems = jsonObject.optJSONArray("matchItems");
        if (matchItems==null) {
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
        for (Object matchItem : matchItems) {
            Map<String,Object> map = new HashMap<String,Object>();
            JSONObject match = (JSONObject) matchItem;
            Integer intTime = Integer.parseInt(match.getString("intTime"));
            Integer lineId = match.getInt("lineId");
            String lineIdStr = "";
            MatchDeatilDTO matchDeatilDTO = new MatchDeatilDTO();
            try {
                Date parse = dateFormater.parse(intTime + "");
                String weekOfDate = DateUtil.getWeekForDate(parse);
                if (lineId<10){
                    lineIdStr = "00"+lineId;
                }else if (lineId<100){
                    lineIdStr = "0"+lineId;
                }else{
                    lineIdStr = ""+lineId;
                }
                matchDeatilDTO.setMatchId(weekOfDate+" "+lineIdStr);
                matchDeatilDTO.setType(typeStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date matchtime = null;

            //赛果
            if ("篮球".equals(typeStr)) {
                SportteryBasketMatch2 sportteryBasketMatch2 = sportteryBasketBallMatchService.getByIntTimeAndLineId(intTime,lineId);
                if (sportteryBasketMatch2==null){
                    result.setSuccess(false);
                    result.setMsg("数据错误");
                    return result;
                }
                matchDeatilDTO.setHomeTeam(sportteryBasketMatch2.getHomename());
                matchDeatilDTO.setGuestTeam(sportteryBasketMatch2.getGuestname());
                matchDeatilDTO.setHomeScore(sportteryBasketMatch2.getHomescore());
                matchDeatilDTO.setGuestScore(sportteryBasketMatch2.getGuestscore());
                matchtime = sportteryBasketMatch2.getMatchtime();
            }else if("足球".equals(typeStr)) {
                SportteryFootballMatch2 sportteryFootballMatch2 = sportteryFootBallMatchService.getByIntTimeAndLineId(intTime,lineId);
                if (sportteryFootballMatch2==null){
                    result.setSuccess(false);
                    result.setMsg("数据错误");
                    return result;
                }
                matchDeatilDTO.setHomeTeam(sportteryFootballMatch2.getHometeam());
                matchDeatilDTO.setGuestTeam(sportteryFootballMatch2.getGuestteam());
                matchDeatilDTO.setHomeScore(sportteryFootballMatch2.getHomescore());
                matchDeatilDTO.setGuestScore(sportteryFootballMatch2.getGuestscore());
                matchDeatilDTO.setHalfhomescore(sportteryFootballMatch2.getHalfhomescore());
                matchDeatilDTO.setHalfguestscore(sportteryFootballMatch2.getHalfguestscore());
                matchtime = sportteryFootballMatch2.getMatchtime();
            }

            int dealTime = dgService.getDealTime();
            //玩法
            //选项
            JSONArray jsonArray = match.optJSONArray("options");
            List<Map<String,String>> option = new ArrayList<Map<String, String>>();
            for (Object o : jsonArray) {
                boolean isPublic = false;
                if (!lotteryPlan2WithBLOBs.getAccount().equals(account)) {
                    //查看他人
                    if (publicStatus == 3 && new Date().getTime() > (lotteryPlan2WithBLOBs.getDealDateTime().getTime()+60000*dealTime)) {
                        isPublic = true;
                    }
                }else{
                    //查看自己
                    if (lotteryPlan2WithBLOBs.getIsSuperMan()==1) {
                        //自购
                        isPublic = true;
                    }else{
                        //跟单
                        if (new Date().getTime()>(lotteryPlan2WithBLOBs.getDealDateTime().getTime()+60000*dealTime)){
                            isPublic = true;
                        }
                    }
                }
                Map<String,String> optionMap = new HashMap<String, String>();
                JSONObject oo = (JSONObject) o;
                optionMap.put("rqs",oo.optString("rqs"));
                optionMap.put("dxf",oo.optString("dxf"));
                optionMap.put("rf",oo.optString("rf"));
                optionMap.put("option",oo.optString("typeValueStr"));
                optionMap.put("award",oo.optString("award"));
                optionMap.put("playType",LotteryType.getItem(oo.optInt("type")).getName());
                optionMap.put("public",isPublic+"");
                String resultStr = null;
                String optionStr = null;
                if (matchDeatilDTO.getHomeScore() ==null || matchDeatilDTO.getGuestScore()==null){
                    optionMap.put("result",null);
                }else{
                    if ("篮球".equals(typeStr)) {
                        resultStr = CommonUtils.getResultForBasketBall(oo.optInt("type"), matchDeatilDTO.getHomeScore(), matchDeatilDTO.getGuestScore(), oo.optDouble("rf"), oo.optDouble("dxf"));
                        switch (oo.optInt("type")){
                            case 30: {  //胜负
                                optionStr = oo.optString("typeValueStr");
                                break;
                            }
                            case 31: {  //让分胜负
                                optionStr = oo.optString("typeValueStr");
                                break;
                            }
                            case 32: {  //胜分差
                                optionStr = oo.optString("typeValueStr");
                                break;
                            }
                            case 33: {  //大小分
                                optionStr = oo.optString("typeValueStr");
                                break;
                            }
                        }
                    }else if("足球".equals(typeStr)) {
                        resultStr = CommonUtils.getResultForFootBall(oo.optInt("type"), matchDeatilDTO.getHomeScore(), matchDeatilDTO.getGuestScore(), matchDeatilDTO.getHalfhomescore(), matchDeatilDTO.getHalfguestscore(), oo.optInt("rqs"));
                        switch (oo.optInt("type")){
                            case 34: {  //让球胜平负
                                optionStr = "("+oo.optString("rqs")+")"+oo.optString("typeValueStr");
                                break;
                            }
                            case 35: {  //比分
                                optionStr = oo.optString("typeValueStr");
                            }
                            case 36: {  //进球数
                                optionStr = oo.optString("typeValueStr");
                            }
                            case 37: {  //半全场
                                optionStr = oo.optString("typeValueStr");
                            }
                            case 41: {  //胜平负
                                optionStr = oo.optString("typeValueStr");
                            }
                        }
                    }
                    if(resultStr.equals(optionStr)){
                        optionMap.put("isWin",1+"");
                    }else {
                        optionMap.put("isWin",0+"");
                    }
                }
                optionMap.put("result",resultStr);
                if(optionMap.get("result")==null){
                    optionMap.put("isWin",0+"");
                }
                option.add(optionMap);
            }
            matchDeatilDTO.setOptions(option);

            matchDeatilDTOs.add(matchDeatilDTO);
        }


        result.setSuccess(true);
        result.setData(matchDeatilDTOs);
        return result;
    }

    public Map<String,Object> showPlan(int planNo, String title, Member2DTO member2DTO) {
        Map<String,Object> map = new HashMap<String,Object>();

        LotteryPlanOrder2 lotteryPlanOrder2 = lotteryPlanOrderService.getByPlanNo(planNo);
        if (lotteryPlanOrder2.getPrizeSettleStatus()!=0){
            map.put(Constants.CODE,Constants.ERROR_CODE_403);
            map.put(Constants.MSG,Constants.ERROR_MSG_403);
            return map;
        }

        List<PlanShow2> list = planShowService.getByPlanNoAndType(planNo,0);
        if (list!=null && list.size()>0){
            map.put(Constants.CODE,Constants.ERROR_CODE_402);
            map.put(Constants.MSG,Constants.ERROR_MSG_402);
            return map;
        }
        List<PlanShow2> list2 = planShowService.getByPlanNoAndType(planNo,1);
        if (list2!=null && list.size()>0){
            map.put(Constants.CODE,Constants.ERROR_CODE_402);
            map.put(Constants.MSG,Constants.ERROR_MSG_402);
            return map;
        }

        return planShowService.showPlan(planNo,title,member2DTO);
    }

    public Map<String, Object> passShowPlanApply(int id, int type) {
        return planShowService.passShowPlanApply(id,type);
    }

    public Map<String, Object> updatePlanShowStatus(int id, int status) {
        return planShowService.updatePlanShowStatus(id,status);
    }

    public Map<String, Object> getPlanShow(String account, Integer planNo, Integer type, Integer status, Integer page, Integer pageSize) {
        if (!StringUtils.isNullOrBlank(account) && !"sj".equals(account.substring(0,2))){
            Member2 member2 = memberService.getByUsername(account);
            if (member2==null){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            account = member2.getAccount();
        }
        return planShowService.getPlanShow(account,planNo,type,status,page,pageSize);
    }

    public Map<String, Object> getPlanShow2(int page, int pageSize,String account) {
        return planShowService.getPlanShow2(page,pageSize,account);
    }

    public List<Member2ForSumprize> xyHall(int page, int pageSize, int day) {
        return lotteryPlanService.xyHall(page,pageSize,day);
    }

    public Map<String, Object> addWinPromotion(String account,String title, String content) {
        Map<String,Object> map = new HashMap<String,Object>();
        Member2DTO byAccount = memberService.getByAccount(account);
        Member2 byUsername = memberService.getByUsername(account);
        if (byAccount==null && byUsername==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_416);
            map.put(Constants.MSG,Constants.ERROR_MSG_416);
            return map;
        }

        WinPromotion2 winPromotion2 = new WinPromotion2();
        winPromotion2.setAccount(account);
        winPromotion2.setTitle(title);
        winPromotion2.setContent(content);
        winPromotion2.setCreateTime(new Date());
        winPromotion2.setStatus(1);
        return winPromotionService.addWinPromotion(winPromotion2);
    }

    public Map<String,Object> updateWinPromotionStatus(WinPromotion2 winPromotion2) {
        return  winPromotionService.updateWinPromotionStatus(winPromotion2);
    }

    public Map<String, Object> getWinPromotion(Integer status,int page,int pageSize) {
        return winPromotionService.getWinPromotion(status,page,pageSize);
    }

    public Map<String, Object> getMostPopular(int page, int pageSize) {
        return memberFollowMappingService.getMostPopular(page,pageSize);
    }

    public List<EvenTheRedMemberDTO> getEvenTheRedList(int page, int pageSize,int day) {
        return lotteryPlanService.getEvenTheRedList(page,pageSize,day);
    }

    public Map<String, Object> getBetList(int page, int pageSize, int day) {
        return lotteryPlanOrderService.getBetList(page,pageSize,day);
    }

    public Map<String, Object> getAShortRed(int page, int pageSize, int day) {
        return lotteryPlanOrderService.getAShortRed(page,pageSize,day);
    }

    public Map<String, Object> addNewStar(String[] accounts) {
        Map<String,Object> map = new HashMap<String,Object>();
        if (accounts!=null && accounts.length>0){
            for (int i = 0; i < accounts.length; i++) {
                if (!"sj".equals(accounts[i].substring(0,2))){
                    Member2 byUsername = memberService.getByUsername(accounts[i]);
                    if (byUsername==null){
                        map.put(Constants.CODE,Constants.ERROR_CODE_400);
                        map.put(Constants.MSG,Constants.ERROR_MSG_400);
                        return map;
                    }
                    accounts[i] = byUsername.getAccount();
                }else{
                    Member2DTO byAccount = memberService.getByAccount(accounts[i]);
                    if (byAccount==null){
                        map.put(Constants.CODE,Constants.ERROR_CODE_400);
                        map.put(Constants.MSG,Constants.ERROR_MSG_400);
                        return map;
                    }
                }
            }
        }

        return newStar2Service.addNewStar(accounts);
    }

    public Map<String, Object> getNewStar(int dan) {
        return newStar2Service.getNewStar(dan);
    }

    public Map<String, Object> autoCopyPlan(Integer planNo, Integer time, Integer count) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Member2> member2s = memberService.getVirtualMember();
        if (count>member2s.size()){
            map.put(Constants.CODE,Constants.ERROR_CODE_405);
            map.put(Constants.MSG,Constants.ERROR_MSG_405);
            return map;
        }
        Random r = new Random();
        List<Member2> list = new ArrayList<Member2>();
        for (int i = 0; i < count; i++) {
            int index = r.nextInt(member2s.size());
            list.add(member2s.remove(index));
        }
        LotteryPlan2WithBLOBs byPlanNo = lotteryPlanService.getByPlanNo(planNo);
        if (byPlanNo==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        Member2DTO byAccount = memberService.getByAccount(byPlanNo.getAccount());
        if (byAccount.getType()!=1){
            map.put(Constants.CODE,Constants.ERROR_CODE_406);
            map.put(Constants.MSG,Constants.ERROR_MSG_406);
            return map;
        }

        Timer timer = new Timer(true);
        timer.schedule(new AutoCopyLotteryTask(list, byPlanNo, planNo, time),0);


        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    class AutoCopyLotteryTask extends TimerTask {

        private List<Member2> list;

        private LotteryPlan2WithBLOBs byPlanNo;

        private Integer planNo;

        private Integer time;

        public AutoCopyLotteryTask(List<Member2> list, LotteryPlan2WithBLOBs byPlanNo, Integer planNo, Integer time) {
            this.list = list;
            this.byPlanNo = byPlanNo;
            this.planNo = planNo;
            this.time = time;
        }

        public void run() {
            for (Member2 member2 : list) {
                try {
                    Thread.sleep(time*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MemberWallet2DTO byMemberId = memberWalletService.getByMemberId(member2.getId());

                byMemberId.setAbleBalance((double) (byPlanNo.getAmount() / byPlanNo.getMultiple()));
                memberWalletService.update(byMemberId);
                copyLotteryPlan(member2.getAccount(), planNo, 1, byPlanNo.getAmount() / byPlanNo.getMultiple(),0,0d);
            }
        }
    }

    public List<BasketBallMatchDTO> getBasketBallMatch(int isFocus) {
        List<BasketBallMatchDTO> list = sportteryBasketBallMatchService.getBasketBallMatch(isFocus);
        return list;
    }

    public List<Map<String,Object>> findFootballMixureInfo(int isFocus) {
        List<Map<String,Object>> maps = sportteryFootBallMatchService.findFootballMixureInfo(isFocus);
        return maps;
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void  updateFootBallMatch(){
        List<Map<String, Object>> noFocus = sportteryFootBallMatchService.findFootballMixureInfo(0);
        List<Map<String, Object>> focus = sportteryFootBallMatchService.findFootballMixureInfo(1);
        Jedis jedis = RedisUtil.getJedis();
        String nf = "";
        if (noFocus!=null && noFocus.size()>0){
            nf = JSONArray.fromObject(noFocus).toString();
        }
        String f = "";
        if (focus!=null && focus.size()>0){
            f = JSONArray.fromObject(focus).toString();
        }
        jedis.set(Constants.FOOTBALL_MATCH,nf);
        jedis.set(Constants.FOOTBALL_MATCH_FOCUS,f);
        jedis.close();
    }
    @Scheduled(fixedDelay = 60 * 1000)
    public void updateBasketBallMatch() {
        List<BasketBallMatchDTO> noFocus = sportteryBasketBallMatchService.getBasketBallMatch(0);
        List<BasketBallMatchDTO> focus = sportteryBasketBallMatchService.getBasketBallMatch(1);
        Jedis jedis = RedisUtil.getJedis();
        String nf = "";
        if (noFocus!=null && noFocus.size()>0){
            nf = JSONArray.fromObject(noFocus).toString();
        }
        String f = "";
        if (focus!=null && focus.size()>0){
            f = JSONArray.fromObject(focus).toString();
        }
        jedis.set(Constants.BASKETBALL_MATCH,nf);
        jedis.set(Constants.BASKETBALL_MATCH_FOCUS,f);
        jedis.close();
    }

    public Map<String, Object> getPlanDetailForManager(int planNo) {
        Map<String,Object> map = new HashMap<String,Object>();
        LotteryPlan2WithBLOBs plan = lotteryPlanService.getByPlanNo(planNo);
        if (plan==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        LotteryPlanOrder2 planOrder = lotteryPlanOrderService.getByPlanNo(planNo);
        if (planOrder==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        Member2DTO member = memberService.getByAccount(plan.getAccount());
        if (member==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        map.put("account",member.getAccount());
        map.put("username",member.getUsername());
        map.put("createDateTime",plan.getCreateDateTime());
        map.put("dealDateTime",plan.getDealDateTime());
        map.put("posttaxPrize",plan.getPosttaxPrize());
        map.put("pretaxPrize",plan.getPretaxPrize());
        map.put("winStatus",WinStatus.getItem(plan.getWinStatus()).getName());
        map.put("amount",plan.getAmount());
        map.put("planOrderStatus",PlanOrderStatus.getItem(planOrder.getStatus()).getName());
        map.put("lotteryType",LotteryType.getItem(plan.getLotteryType()).getName());
        map.put("planStatus",PlanStatus.getItem(plan.getPlanStatus()).getName());
        map.put("term",plan.getTerm());
        map.put("multiple",plan.getMultiple());
        map.put("isSuper",plan.getIsSuperMan());
        map.put("public",PublicStatus.getItem(plan.getPublicStatus()).getName());
        map.put("printTicketDateTime",plan.getPrintTicketDateTime());
        map.put("openResultTime",plan.getOpenResultTime());
        map.put("arrivalTime",plan.getArrivalTime());
        List<String> planTicketDetail = getPlanTicketDetail(planNo);
        map.put("ticketDetail",planTicketDetail);

        Result result = getPlanMatchDetail(planNo, "");
        map.put("matchDetail",result.getData());

        return map;
    }

    @Override
    public List<String> getPlanTicketDetail(int planNo) {
        List<Ticket2WithBLOBs> ticketList = ticketService.getByPlanNo(planNo);
        List<String> list = new LinkedList<String>();
        for (Ticket2WithBLOBs ticket : ticketList) {
            JSONObject content = JSONObject.fromObject(ticket.getContent());
            JSONArray matchItems = content.optJSONArray("matchItems");
            String passType = content.optString("passType");
            StringBuffer sb = new StringBuffer();
            sb.append(LotteryUtils.getPassType(passType)).append(":");
            for (Object matchItem : matchItems) {
                JSONObject matchItemObj = JSONObject.fromObject(matchItem);
                String intTime = matchItemObj.optString("intTime");
                String lineId = matchItemObj.optString("lineId");
                JSONArray options = matchItemObj.optJSONArray("options");
                String typeValueStr = JSONObject.fromObject(options.get(0)).optString("typeValueStr");
                String award = JSONObject.fromObject(options.get(0)).optString("award");
                Integer type = JSONObject.fromObject(options.get(0)).optInt("type");
                String week = DateUtil.getWeekForDateByIntTime(intTime);
                String typeStr = LotteryType.getItem(type).getName().substring(4);
                sb.append(week).append(lineId).append("(").append(typeStr).append("-").append(typeValueStr).append(award).append(")");
            }
            sb.append("-").append(ticket.getMultiple()).append("倍");
            list.add(sb.toString());
        }
        return list;
    }

    public Map<String, Object> findFootballMixureMoreInfo(String matchId) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
           Map<String, Object> map = sportteryFootBallMatchService.findFootballMixureMoreInfo(matchId);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, map);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> copyPlan(Integer planNo) {
        Map<String,Object> map = new HashMap<String,Object>();
        LotteryPlan2WithBLOBs plan = lotteryPlanService.getByPlanNo(planNo);
        if (plan==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }

        TicketFindNew2 ticketFindNew2 = ticketFindNewService.getByPlanNo(planNo);
        if (ticketFindNew2==null || ticketFindNew2.getCopyStatus()!=1){
            map.put(Constants.CODE,Constants.ERROR_CODE_426);
            map.put(Constants.MSG,Constants.ERROR_MSG_426);
            return map;
        }

        Integer lotteryType = plan.getLotteryType();
        Date dealDateTime = plan.getDealDateTime();

        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        String d1 = sdf1.format(date);
        //判断是否在投注时间
        int dgStatus = dgService.getDGStatus();
        if (dgStatus==0){
            map.put(Constants.CODE,Constants.ERROR_CODE_407);
            map.put(Constants.MSG,Constants.ERROR_MSG_407);
            return map;
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String intTime2 = sdf1.format(date);
        if ("09:00:00".compareTo(sdf2.format(date)) >= 0){
            //9点前算前一天
            long time = date.getTime() - 1000 * 60 * 60 *24;
            intTime2 = sdf1.format(new Date(time));
        }
        int dealTime = dgService.getDealTime();
        List<SportteryFootballMatch2> list = sportteryFootBallMatchService.getWorldCupByIntTime(Integer.parseInt(intTime2));
        if(LotteryUtils.isNotWorkTimeByWorldCup(list,dealTime)){
            map.put(Constants.CODE,Constants.ERROR_CODE_407);
            map.put(Constants.MSG,Constants.ERROR_MSG_407);
            return map;
        }
        //判断是否超过截止时间
        if (new Date().getTime() > dealDateTime.getTime()+dealTime*60000){
            map.put(Constants.CODE,Constants.ERROR_CODE_418);
            map.put(Constants.MSG,Constants.ERROR_MSG_418);
            return map;
        }

        String typeStr = "";
        if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
            typeStr = "篮球";
        }else if(LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))) {
            typeStr = "足球";
        }
        String content = plan.getContent();
        if(content != null) {
            JSONObject jsonObject = JSONObject.fromObject(content);
            if (jsonObject!=null) {
                JSONArray matchItems = jsonObject.optJSONArray("matchItems");
                if (matchItems!=null) {
                    for (Object matchItem : matchItems) {
                        JSONObject match = (JSONObject) matchItem;
                        Integer intTime = Integer.parseInt(match.getString("intTime"));
                        Integer lineId = match.getInt("lineId");
                        if ("篮球".equals(typeStr)) {
                            SportteryBasketMatch2 sportteryBasketMatch2 = sportteryBasketBallMatchService.getByIntTimeAndLineId(intTime,lineId);
                            if (sportteryBasketMatch2==null){
                                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                                return map;
                            }
                            if (sportteryBasketMatch2.getStatus()!=0) {
                                map.put(Constants.CODE,Constants.ERROR_CODE_409);
                                map.put(Constants.MSG,Constants.ERROR_MSG_409);
                                return map;
                            }
                        }else if("足球".equals(typeStr)) {
                            SportteryFootballMatch2 sportteryFootballMatch2 = sportteryFootBallMatchService.getByIntTimeAndLineId(intTime,lineId);
                            if (sportteryFootballMatch2==null){
                                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                                return map;
                            }
                            if (sportteryFootballMatch2.getStatus()!=0) {
                                map.put(Constants.CODE,Constants.ERROR_CODE_409);
                                map.put(Constants.MSG,Constants.ERROR_MSG_409);
                                return map;
                            }
                        }
                    }
                }
            }
        }

        Member2DTO member2DTO = memberService.getByAccount("sj878466008");
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("member2DTO",member2DTO);
        reqMap.put("term",plan.getTerm());
        reqMap.put("content",updateContent(plan.getContent(),typeStr));
        reqMap.put("amount",plan.getAmount());
        reqMap.put("publicStatus",3);
        reqMap.put("tradeType",plan.getTradeType());
        reqMap.put("multiple",plan.getMultiple());
        reqMap.put("isFocus",0);
        reqMap.put("lotteryType",plan.getLotteryType());
        reqMap.put("maxSp",plan.getMaxSp());
        reqMap.put("dealDateTime",plan.getDealDateTime());
        reqMap.put("playType",plan.getPlayType());
        reqMap.put("isCopy",1);
        reqMap.put("copyPlanNo",planNo);
        reqMap.put("cardMoney",0);
        map = dgService.dg(reqMap);

        return map;
    }

    public Map<String, Object> getIsFocusPlan(Integer planNo) {
        return lotteryPlanService.getIsFocusPlan(planNo);
    }

    public Map<String, Object> setMemberTicket(String accountStr, int status) {
        Map<String,Object> map = new HashMap<String,Object>();
        String account ;
        if ("sj".equals(accountStr.substring(0,2))){
            Member2DTO byAccount = memberService.getByAccount(accountStr);
            if (byAccount==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            account = byAccount.getAccount();
        }else{
            Member2 byUsername = memberService.getByUsername(accountStr);
            if (byUsername==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            account = byUsername.getAccount();
        }
        MemberGrade2 byAccount = memberGradeService.getByAccount(account);
        if (byAccount==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        byAccount.setIsProviderTicket(status);
        memberGradeService.update(byAccount);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getMemberTicket(int page, int pageSize) {
        return memberGradeService.getMemberTicket(page,pageSize);
    }

    public void openDG(int status) {
        dgService.updateDG(status);
    }

    public Map<String, Object> updateDGByStatus(Date time, int status) {
        Map<String,Object> map = new HashMap<String,Object>();
        Timer timer = new Timer(true);
        timer.schedule(new UpdateDGTask(status),
                time.getTime() - System.currentTimeMillis());
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> superLottoDG(Map<String, Object> map) {
        Map<String,Object> respMap = new HashMap<String,Object>();
        String content = map.get("content").toString();
        Integer publicStatus = (Integer) map.get("publicStatus");
        Member2DTO member2DTO = (Member2DTO) map.get("member2DTO");

        JSONObject contentObj = JSONObject.fromObject(content);
        int amount = contentObj.optInt("amount");
        int multiple = contentObj.optInt("multiple");
        String term = contentObj.optString("term");
        if (!StringUtils.isNullOrBlank(term)){
            term = term.replace("期", "");
        }
        int lotteryType = contentObj.optInt("lotteryType");
        String planContent = contentObj.optString("content");
        planContent = planContent.substring(0, planContent.length() - 1) + "%" + multiple;
        String isAdd = contentObj.optString("isAdd");
        planContent = planContent + "-" + isAdd;// 大乐透加奖
        int buyType = contentObj.optInt("buyType");



        LotteryTerm2 lotteryTerm2= lotteryTermService.getByLotteryAndTerm(lotteryType,term);
        if (lotteryTerm2==null){
            respMap.put(Constants.CODE,Constants.ERROR_CODE_400);
            respMap.put(Constants.MSG,Constants.ERROR_MSG_400);
        }
        // 余额购买或积分投注
        Map<String,Object> dgMap = new HashMap<String,Object>();
        dgMap.put("term",term);
        dgMap.put("tradeType", TradeType.TRADE_BALANCE.getValue());
        dgMap.put("amount",amount);
        dgMap.put("lotteryType",lotteryType);
        dgMap.put("member2DTO",member2DTO);
        dgMap.put("content",planContent);
        dgMap.put("multiple",multiple);
        dgMap.put("publicStatus",publicStatus);
        dgMap.put("cardId",map.get("cardId"));
        dgMap.put("cardMoney",map.get("cardMoney"));
        dgMap.put("dealDateTime",lotteryTerm2.getEndDateTime());
        return dgService.superLottoDG(dgMap);
    }

    public Map<String, Object> getPlanByNoPay(String account,int page,int pageSize) {
        return lotteryPlanService.getPlanByNoPay(account,page,pageSize);
    }

    public Map<String, Object> dgForNoPay(Member2DTO member2DTO, Double amount, Integer planNo, Integer cardId, double cardMoney) {
        Map<String,Object> map = new HashMap<String,Object>();
        LotteryPlan2WithBLOBs lotteryPlan = lotteryPlanService.getByPlanNo(planNo);
        if (lotteryPlan==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        if (lotteryPlan.getPlanStatus()!=1){
            map.put(Constants.CODE,Constants.ERROR_CODE_434);
            map.put(Constants.MSG,Constants.ERROR_MSG_434);
            return map;
        }
        if (!lotteryPlan.getAccount().equals(member2DTO.getAccount())){
            map.put(Constants.CODE,Constants.ERROR_CODE_436);
            map.put(Constants.MSG,Constants.ERROR_MSG_436);
            return map;
        }
        if (amount!=(double)lotteryPlan.getAmount()){
            map.put(Constants.CODE,Constants.ERROR_CODE_437);
            map.put(Constants.MSG,Constants.ERROR_MSG_437);
            return map;
        }
        MemberWallet2DTO memberWallet = memberWalletService.getByMemberId(member2DTO.getId());
        if (memberWallet.getAbleBalance()+cardMoney < amount){
            map.put(Constants.CODE,Constants.ERROR_CODE_417);
            map.put(Constants.MSG,Constants.ERROR_MSG_417);
            return map;
        }

        //根据id去查询彩金卡的使用额度
        if (cardMoney!=0) {
            BigDecimal big = memberWalletLineService.findCardFullMoneyById(cardId);
            if (amount < Double.valueOf(big.toPlainString())) {
                map.put(Constants.CODE, Constants.ERROR_CODE_435);
                map.put(Constants.MSG,Constants.ERROR_MSG_435);
                return map;
            }
        }

        Date date = new Date();
        if (date.after(lotteryPlan.getDealDateTime())){

        }
        //判断是否在投注时间
        int isDG = dgService.getDGStatus();
        if (isDG==0){
            map.put(Constants.CODE,Constants.ERROR_CODE_407);
            map.put(Constants.MSG,Constants.ERROR_MSG_407);
            return map;
        }

        //判断是否在投注时间
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        String d1 = sdf1.format(date);
        int dealTime = dgService.getDealTime();
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String intTime = sdf1.format(date);
        if ("09:00:00".compareTo(sdf2.format(date)) >= 0){
            //9点前算前一天
            long time = date.getTime() - 1000 * 60 * 60 *24;
            intTime = sdf1.format(new Date(time));
        }
        List<SportteryFootballMatch2> list = sportteryFootBallMatchService.getWorldCupByIntTime(Integer.parseInt(intTime));
        if(LotteryUtils.isNotWorkTimeByWorldCup(list,dealTime)){
            map.put(Constants.CODE,Constants.ERROR_CODE_407);
            map.put(Constants.MSG,Constants.ERROR_MSG_407);
            return map;
        }

        //判断方案赛事是否有截止
        Integer lotteryType = lotteryPlan.getLotteryType();
        String typeStr = "";
        if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
            typeStr = "篮球";
        }else if(LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))) {
            typeStr = "足球";
        }
        String content = lotteryPlan.getContent();
        if(content != null) {
            JSONObject jsonObject = JSONObject.fromObject(content);
            if (jsonObject!=null) {
                JSONArray matchItems = jsonObject.optJSONArray("matchItems");
                if (matchItems!=null) {
                    for (Object matchItem : matchItems) {
                        JSONObject match = (JSONObject) matchItem;
                        Integer intTime2 = Integer.parseInt(match.getString("intTime"));
                        Integer lineId = match.getInt("lineId");
                        if ("篮球".equals(typeStr)) {
                            SportteryBasketMatch2 sportteryBasketMatch2 = sportteryBasketBallMatchService.getByIntTimeAndLineId(intTime2,lineId);
                            if (sportteryBasketMatch2==null){
                                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                                return map;
                            }
                            if (sportteryBasketMatch2.getStatus()!=0) {
                                map.put(Constants.CODE,Constants.ERROR_CODE_418);
                                map.put(Constants.MSG,Constants.ERROR_MSG_418);
                                return map;
                            }
                        }else if("足球".equals(typeStr)) {
                            SportteryFootballMatch2 sportteryFootballMatch2 = sportteryFootBallMatchService.getByIntTimeAndLineId(intTime2,lineId);
                            if (sportteryFootballMatch2==null){
                                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                                return map;
                            }
                            if (sportteryFootballMatch2.getStatus()!=0) {
                                map.put(Constants.CODE,Constants.ERROR_CODE_418);
                                map.put(Constants.MSG,Constants.ERROR_MSG_418);
                                return map;
                            }
                        }
                    }
                }
            }
        }

        lotteryPlan.setIsAbleTicketing(0);
        lotteryPlan.setPlanStatus(3);
        lotteryPlanService.update(lotteryPlan);

        LotteryPlanOrder2 lotteryPlanOrder = lotteryPlanOrderService.getByPlanNo(planNo);
        lotteryPlanOrder.setStatus(2);
        lotteryPlanOrderService.update(lotteryPlanOrder);

        if (0==cardMoney) {
            if (memberWallet.getAbleBalance()-memberWallet.getTakeCashQuota()<amount){
                memberWallet.setTakeCashQuota(NumberTools.round(memberWallet.getAbleBalance()-amount,2));
            }
            memberWallet.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance() - amount,2));
            memberWallet.setHeapBalance(NumberTools.round(memberWallet.getHeapBalance()+amount,2));
        }else {
            //把使用彩金卡的金额加入钱包
            if (memberWallet.getAbleBalance()+cardMoney-memberWallet.getTakeCashQuota()<amount){
                memberWallet.setTakeCashQuota(NumberTools.round(memberWallet.getAbleBalance()+cardMoney-amount,2));
            }
            memberWallet.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance() - amount + cardMoney,2));
            memberWallet.setHeapBalance(NumberTools.round(memberWallet.getHeapBalance() + amount - amount + cardMoney,2));
            //生成钱包流水
            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setPlanNo(lotteryPlanOrder.getPlanNo());
            memberWalletLine2.setOrderNo(lotteryPlanOrder.getOrderNo());
            memberWalletLine2.setAccount(memberWallet.getAccount());
            memberWalletLine2.setMemberId(memberWallet.getMemberId());
            memberWalletLine2.setTransType(-1001);// 独立扣款科目，负数值存为正
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setAmount(cardMoney);
            memberWalletLine2.setLotteryType(lotteryType);
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2.setSourceId(member2DTO.getSourceId());
            memberWalletLine2.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance() + cardMoney,2));
            memberWalletLine2.setFreezeBalance(NumberTools.round(memberWallet.getFreezeBalance(),2));
            memberWalletLine2.setHeapBalance(NumberTools.round(memberWallet.getHeapBalance(),2));
            memberWalletLine2.setRemark("彩金卡抵扣");
            memberWalletLine2.setPrizeBalance(memberWallet.getPrizeBalance());
            memberWalletLineService.insert(memberWalletLine2);
            //修改这张 彩金卡
            memberWalletLineService.updateCard(cardId, new Date());
        }
        memberWalletService.update(memberWallet);
        MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
        memberWalletLine2.setPlanNo(lotteryPlanOrder.getPlanNo());
        memberWalletLine2.setOrderNo(lotteryPlanOrder.getOrderNo());
        memberWalletLine2.setAccount(memberWallet.getAccount());
        memberWalletLine2.setMemberId(memberWallet.getMemberId());
        memberWalletLine2.setTransType(WalletTransType.CONSUME.getValue());
        memberWalletLine2.setWalletType(1);
        memberWalletLine2.setAmount((double)amount);
        memberWalletLine2.setLotteryType(lotteryPlan.getLotteryType());
        memberWalletLine2.setCreateDateTime(new Date());
        memberWalletLine2.setStatus(0);
        memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
        memberWalletLine2.setSourceId(member2DTO.getSourceId());
        memberWalletLine2.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance(),2));
        memberWalletLine2.setFreezeBalance(NumberTools.round(memberWallet.getFreezeBalance(),2));
        memberWalletLine2.setHeapBalance(NumberTools.round(memberWallet.getHeapBalance(),2));
        memberWalletLine2.setRemark("购买彩票");
        memberWalletLine2.setPrizeBalance(memberWallet.getPrizeBalance());
        memberWalletLineService.insert(memberWalletLine2);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getNumberTerm() {
        Map<String,Object> map = new HashMap<String,Object>();
        LotteryTerm2 lotteryTerm2 = lotteryTermService.getNumberTerm(1);
        if (lotteryTerm2!=null){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,lotteryTerm2.getTerm());
        }else{
            map.put(Constants.CODE,Constants.ERROR_CODE_440);
            map.put(Constants.MSG,Constants.ERROR_MSG_440);
        }
        return map;
    }

    public Map<String, Object> getAutoCopyPlanStatus(int type) {
        Integer status;
        if (type==1){
            status = dgService.getAutoCopyPlanStatusForLess5();
        }else if (type==2){
            status = dgService.getAutoCopyPlanStatusForMore5();
        }else{
            status = null;
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,status);
        return map;
    }

    public Map<String, Object> setAutoCopyPlanStatus(int type, int status) {
        Map<String,Object> reqMap = new HashMap<String,Object>();
        if (type==1){
            dgService.setAutoCopyPlanStatusForLess5(status);
        }else{
            dgService.setAutoCopyPlanStatusForMore5(status);
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> updatePlanDesc(Integer planNo, String desc) {
        Map<String,Object> map = new HashMap<String,Object>();
        LotteryPlan2WithBLOBs byPlanNo = lotteryPlanService.getByPlanNo(planNo);
        byPlanNo.setPlanDesc(desc);
        lotteryPlanService.update(byPlanNo);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> addLotteryLimit(String content, Integer lotteryType, String passType) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String[] intTimeLineIds = content.split("~");
            Date dealTime = new Date();
            Date now = dealTime;
            for (String intTimeLineId : intTimeLineIds) {
                String[] split = intTimeLineId.split("_");
                if (lotteryType==38){
                    //足球
                    SportteryFootballMatch2 footballMatch2 = sportteryFootBallMatchService.getByIntTimeAndLineId(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                    if (footballMatch2==null || footballMatch2.getStatus()!=0){
                        map.put(Constants.CODE,Constants.ERROR_CODE_442);
                        map.put(Constants.MSG,Constants.ERROR_MSG_442);
                        return map;
                    }
                    Date matchtime = footballMatch2.getMatchtime();
                    if (dealTime.getTime()==now.getTime()){
                        dealTime = matchtime;
                    }else{
                        if (matchtime.before(dealTime)){
                            dealTime = matchtime;
                        }
                    }

                }else{
                    //篮球
                    SportteryBasketMatch2 basketMatch2 = sportteryBasketBallMatchService.getByIntTimeAndLineId(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                    if (basketMatch2==null || basketMatch2.getStatus()!=0){
                        map.put(Constants.CODE,Constants.ERROR_CODE_442);
                        map.put(Constants.MSG,Constants.ERROR_MSG_442);
                        return map;
                    }
                    Date matchtime = basketMatch2.getMatchtime();
                    if (dealTime.getTime()==now.getTime()){
                        dealTime = matchtime;
                    }else{
                        if (matchtime.before(dealTime)){
                            dealTime = matchtime;
                        }
                    }
                }
            }
            LotteryLimit2 lotteryLimit2 = new LotteryLimit2();
            lotteryLimit2.setContent(content);
            lotteryLimit2.setCreateTime(new Date());
            lotteryLimit2.setLotteryType(lotteryType);
            lotteryLimit2.setPassType(passType);
            lotteryLimit2.setStatus(1);
            lotteryLimit2.setDealTime(dealTime);
            lotteryLimitService.addLotteryLimit(lotteryLimit2);
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> getLotteryLimit(int page, int pageSize) {
        List<LotteryLimit2> lotteryLimitByStatus = lotteryLimitService.getLotteryLimit(page, pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,new PageInfo<LotteryLimit2>(lotteryLimitByStatus));
        return map;
    }

    public Map<String, Object> updateLotteryLimitStatus(Integer id, Integer status) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            LotteryLimit2 lotteryLimit2 = lotteryLimitService.getById(id);
            if (lotteryLimit2==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            lotteryLimit2.setStatus(status);
            lotteryLimitService.update(lotteryLimit2);
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> selectLotteryPlan(Map<String, Object> map) {
        return lotteryPlanService.selectLotteryPlanByMap(map);

    }

    public Map<String, Object> planBack(Integer planNo) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            LotteryPlan2WithBLOBs plan = lotteryPlanService.getByPlanNo(planNo);
            if (plan==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            if (plan.getPlanStatus()!=3 && plan.getPlanStatus()!=4){
                map.put(Constants.CODE,Constants.ERROR_CODE_444);
                map.put(Constants.MSG,Constants.ERROR_MSG_444);
                return map;
            }
            if (plan.getWinStatus()!=1){
                map.put(Constants.CODE,Constants.ERROR_CODE_444);
                map.put(Constants.MSG,Constants.ERROR_MSG_444);
                return map;
            }
            //修改方案状态
            plan.setPlanStatus(PlanStatus.TICKET_GQ.getValue());
            plan.setPlanTicketStatus(PlanTicketStatus.TICKET_FAIL.getValue());
            plan.setJoinCount(0);
            plan.setPrintTicketDateTime(new Date());
            plan.setArrivalTime(new Date());//退款到帐时间
            lotteryPlanService.update(plan);

            //修改票状态
            ticketService.updateTicketByPlanBack(planNo);

            //寻票状态更新
            TicketFindNew2 ticketFindNew = ticketFindNewService.getByPlanNo(planNo);
            if (ticketFindNew!=null){
                ticketFindNew.setTicketStatus(plan.getPlanStatus());
                ticketFindNewService.update(ticketFindNew);
            }

            //彩金卡
            MemberWalletLine2 cardLine = memberWalletLineService.getByPlanNoAndRemark(planNo,"彩金卡抵扣");

            //全额退款
            MemberWallet2 memberWallet2 = memberWalletService.getByAccount(plan.getAccount());
            if (memberWallet2==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            if (cardLine==null) {
                memberWallet2.setAbleBalance(memberWallet2.getAbleBalance()+plan.getAmount());
            }else{
                memberWallet2.setAbleBalance(memberWallet2.getAbleBalance()+plan.getAmount()-cardLine.getAmount());
            }
            memberWallet2.setHeapBalance(memberWallet2.getHeapBalance()-plan.getAmount());
            memberWalletService.update2(memberWallet2);

            Member2DTO member = memberService.getByAccount(plan.getAccount());

            //退款流水
            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setPlanNo(planNo);
            memberWalletLine2.setAccount(plan.getAccount());
            memberWalletLine2.setMemberId(member.getId());
            memberWalletLine2.setTransType(WalletTransType.RETURN.getValue());
            memberWalletLine2.setWalletType(1);
            if (cardLine==null) {
                memberWalletLine2.setAmount((double)plan.getAmount());
            }else{
                memberWalletLine2.setAmount((double)plan.getAmount()-cardLine.getAmount());
            }

            memberWalletLine2.setLotteryType(plan.getLotteryType());
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2.setSourceId(member.getSourceId());
            memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLine2.setRemark("退单退款:"+planNo);
            memberWalletLineService.insert(memberWalletLine2);

            //扣取消费赠送
            MemberWalletLine2 present = memberWalletLineService.getByAccountAndPlanNoAndTransType(memberWallet2.getAccount(),planNo,WalletTransType.CONSUME_PRESENT.getValue());
            if (present!=null){
                memberWallet2.setAbleBalance(NumberTools.round(memberWallet2.getAbleBalance()-present.getAmount(),2));
                memberWallet2.setTakeCashQuota(NumberTools.round(memberWallet2.getTakeCashQuota()-present.getAmount(),2));
                memberWalletService.update2(memberWallet2);

                //增加流水
                MemberWalletLine2 removeWalletLine = new MemberWalletLine2();
                removeWalletLine.setPlanNo(planNo);
                removeWalletLine.setAccount(member.getAccount());
                removeWalletLine.setMemberId(member.getId());
                removeWalletLine.setTransType(WalletTransType.GIVE_REMOVE.getValue());
                removeWalletLine.setWalletType(1);
                removeWalletLine.setAmount(present.getAmount());
                removeWalletLine.setLotteryType(plan.getLotteryType());
                removeWalletLine.setCreateDateTime(new Date());
                removeWalletLine.setStatus(0);
                removeWalletLine.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(removeWalletLine));
                removeWalletLine.setSourceId(member.getSourceId());
                removeWalletLine.setAbleBalance(memberWallet2.getAbleBalance());
                removeWalletLine.setFreezeBalance(memberWallet2.getFreezeBalance());
                removeWalletLine.setHeapBalance(memberWallet2.getHeapBalance());
                removeWalletLine.setRemark("消费赠送扣除:"+planNo);
                memberWalletLineService.insert(removeWalletLine);
            }

            //扣取代理/渠道佣金
            List<Commision2> commisions = commisionService.getByPlanNo(planNo);
            if (commisions!=null && commisions.size()>0){
                for (Commision2 commision : commisions) {
                    //钱包修改
                    MemberWallet2DTO dlWalletDTO = memberWalletService.getByMemberId(commision.getAgentMemberId());
                    MemberWallet2 dlWallet = new MemberWallet2();
                    dlWallet.setId(dlWalletDTO.getId());
                    dlWallet.setAbleBalance(NumberTools.round(dlWalletDTO.getAbleBalance()-commision.getCommision(),2));
                    dlWallet.setTakeCashQuota(NumberTools.round(dlWalletDTO.getTakeCashQuota()-commision.getCommision(),2));
                    memberWalletService.update2(dlWallet);

                    Member2DTO dlMember = memberService.getByAccount(dlWalletDTO.getAccount());

                    //增加流水
                    MemberWalletLine2 dlWalletLine = new MemberWalletLine2();
                    dlWalletLine.setPlanNo(planNo);
                    dlWalletLine.setAccount(dlMember.getAccount());
                    dlWalletLine.setMemberId(dlMember.getId());
                    dlWalletLine.setTransType(WalletTransType.GOLD_REMOVE.getValue());
                    dlWalletLine.setWalletType(1);
                    dlWalletLine.setAmount(commision.getCommision());
                    dlWalletLine.setLotteryType(plan.getLotteryType());
                    dlWalletLine.setCreateDateTime(new Date());
                    dlWalletLine.setStatus(0);
                    dlWalletLine.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(dlWalletLine));
                    dlWalletLine.setSourceId(dlMember.getSourceId());
                    dlWalletLine.setAbleBalance(dlWallet.getAbleBalance());
                    dlWalletLine.setFreezeBalance(dlWalletDTO.getFreezeBalance());
                    dlWalletLine.setHeapBalance(dlWalletDTO.getHeapBalance());
                    dlWalletLine.setRemark("佣金扣除:"+planNo);
                    memberWalletLineService.insert(dlWalletLine);
                }
            }
            //短信
            String content = "您购买的方案编号:"+planNo+"未能出票成功，现已退款。如有疑问，请联系客服！";
            if (!"0".equals(CLSmsSend.send(member.getMobile(), content))){
                map.put(Constants.CODE,Constants.ERROR_CODE_447);
                map.put(Constants.MSG,Constants.ERROR_MSG_447);
                return map;
            }
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_445);
            map.put(Constants.MSG,Constants.ERROR_MSG_445);
            return map;
        }
    }

    public Map<String, Object> updatePlanStatus(Integer planNo) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            List<Ticket2WithBLOBs> tickets = ticketService.getByPlanNo(planNo);
            if (tickets==null || tickets.size()<=0){
                map.put(Constants.CODE,Constants.ERROR_CODE_446);
                map.put(Constants.MSG,Constants.ERROR_MSG_446);
                return map;
            }
            //更改票状态
            ticketService.updateStatusByPlanNo(planNo,4);

            LotteryPlan2WithBLOBs plan = lotteryPlanService.getByPlanNo(planNo);
            if (plan==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            //更改方案状态
            plan.setPlanStatus(4);
            plan.setPlanTicketStatus(4);
            plan.setPrintTicketDateTime(new Date());
            lotteryPlanService.update(plan);

            //返点
            setCommision(plan);
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public void setCommision(LotteryPlan2WithBLOBs lotteryPlan) {
        double khReturn = 0.0;
        double khRate = 0.0;
        double upReturn = 0.0;
        double upRate = 0.0;
        double qdReturn = 0.0;
        double qdRate = 0.0;
        Member2DTO khMember = null;
        Member2DTO upMember = null;
        Member2DTO qdMember = null;
        LotteryPlanOrder2 planOrder = lotteryPlanOrderService.getByPlanNo(lotteryPlan.getPlanNo());
        Integer lotType;
        if(LotteryType.JCLQList.contains(LotteryType.getItem(lotteryPlan.getLotteryType()))){//竞彩篮球
            lotType = LotteryType.JC_LQ.getValue();
        }else if(LotteryType.JCZQList.contains(LotteryType.getItem(lotteryPlan.getLotteryType()))){//竞彩足球
            lotType = LotteryType.JC_ZQ.getValue();
        }else{
            lotType = lotteryPlan.getLotteryType();
        }

        khMember = memberService.getByAccount(lotteryPlan.getAccount());
        if (khMember == null) {
            return;
        }
        //客户返点
        MemberRate2 khMemberRate = memberRateService.getByMemberIdAndLotteryType(khMember.getId(),lotType);
        if (khMemberRate!=null && khMemberRate.getFdDgRate()!=null && khMemberRate.getFdDgRate()!=0){
            khRate = khMemberRate.getFdDgRate()/100;
            khReturn = NumberTools.round(lotteryPlan.getAmount()*khRate,2);
        }
        //判断这个方案是不是焦点赛事
        LotteryPlanAddPrize2 lotteryPlanAddPrize = lotteryPlanAddPrizeService.getByPlanNo(lotteryPlan.getPlanNo());
        if (lotteryPlanAddPrize != null && lotteryPlanAddPrize.getPlanNo() != null && lotteryPlanAddPrize.getPlanNo() != 0) {
            khReturn = 0.0;
        }
        if (khReturn>0){
            //客户返点
            if (khMember==null){
                return;
            }
            MemberWallet2DTO khWallet = memberWalletService.getByMemberId(khMember.getId());
            if (khWallet==null){
                return;
            }
            khWallet.setAbleBalance(NumberTools.round(khWallet.getAbleBalance()+khReturn,2));
            khWallet.setTakeCashQuota(NumberTools.round(khWallet.getTakeCashQuota()+khReturn,2));
            memberWalletService.update(khWallet);

            addMemberWalletLine(khMember,khWallet,lotteryPlan,planOrder,khReturn,1004,"消费赠送:"+lotteryPlan.getPlanNo());
        }

        if (!StringUtils.isNullOrBlank(khMember.getProvider())){
            //客户上级返点
            MemberAgent2 upAgent = memberAgentService.getAgentByMemberId(khMember.getSourceId());
            if (upAgent==null){
                return;
            }
            upMember = memberService.getByAccount(upAgent.getAccount());
            if (upMember==null){
                return;
            }
            MemberRate2 upMemberRate = memberRateService.getByMemberIdAndLotteryType(upMember.getId(), lotType);
            if (upMemberRate!=null && upMemberRate.getFdDgRate()!=null && upMemberRate.getFdDgRate()!=0){
                upRate = upMemberRate.getFdDgRate()/100;
                if (upRate<khRate){
                    return;
                }
                upReturn = NumberTools.round(lotteryPlan.getAmount()*(upRate-khRate),2);
            }

            if (upReturn>0){
                if (upMember==null){
                    return;
                }
                MemberWallet2DTO upWallet = memberWalletService.getByMemberId(upMember.getId());
                if (upWallet==null){
                    return;
                }
                upWallet.setAbleBalance(NumberTools.round(upWallet.getAbleBalance()+upReturn,2));
                upWallet.setTakeCashQuota(NumberTools.round(upWallet.getTakeCashQuota()+upReturn,2));
                memberWalletService.update(upWallet);
                addMemberWalletLine(upMember,upWallet,lotteryPlan,planOrder,upReturn,1056,"佣金："+lotteryPlan.getPlanNo());
                Commision2 commision2 = new Commision2();
                commision2.setPlanNo(lotteryPlan.getPlanNo());
                commision2.setAgentMemberId(upMember.getId());
                commision2.setLowerMemberId(khMember.getId());
                commision2.setCommision(upReturn);
                commision2.setDate(new Date());
                commisionService.insert(commision2);
            }

            if (!StringUtils.isNullOrBlank(upMember.getProvider())){
                //渠道返点
                MemberAgent2 qdAgent = memberAgentService.getAgentByMemberId(upMember.getSourceId());
                if (qdAgent==null){
                    return;
                }
                qdMember = memberService.getByAccount(qdAgent.getAccount());
                if (qdMember==null){
                    return;
                }
                MemberRate2 qdMemberRate = memberRateService.getByMemberIdAndLotteryType(qdMember.getId(), lotType);
                if (qdMemberRate!=null && qdMemberRate.getFdDgRate()!=null && qdMemberRate.getFdDgRate()!=0){
                    qdRate = qdMemberRate.getFdDgRate()/100;
                    if (qdRate<upRate){
                        return;
                    }
                    qdReturn = NumberTools.round(lotteryPlan.getAmount()*(qdRate-upRate),2);
                }
                if (qdReturn>0){
                    if (qdMember==null){
                        return;
                    }
                    MemberWallet2DTO qdWallet = memberWalletService.getByMemberId(qdMember.getId());
                    if (qdWallet==null){
                        return;
                    }
                    qdWallet.setAbleBalance(NumberTools.round(qdWallet.getAbleBalance()+upReturn,2));
                    qdWallet.setTakeCashQuota(NumberTools.round(qdWallet.getTakeCashQuota()+upReturn,2));
                    memberWalletService.update(qdWallet);
                    addMemberWalletLine(qdMember,qdWallet,lotteryPlan,planOrder,qdReturn,1056,"佣金："+lotteryPlan.getPlanNo());
                    Commision2 commision2 = new Commision2();
                    commision2.setPlanNo(lotteryPlan.getPlanNo());
                    commision2.setAgentMemberId(qdMember.getId());
                    commision2.setLowerMemberId(upMember.getId());
                    commision2.setCommision(qdReturn);
                    commision2.setDate(new Date());
                    commisionService.insert(commision2);
                }
            }
        }
    }

    public Map<String, Object> updateLotteryTypeIsSale(String lotteryType, Integer status) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if (lotteryType.equals("38")){
                //足球
                lotteryTermService.updateTermIsAbleForFootBall(status);
            }else if (lotteryType.equals("39")){
                //篮球
                lotteryTermService.updateTermIsAbleForBasketBall(status);
            }
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> bonusPrediction(Map<String,Object> reqMap) {
        Map<String,Object> map = new HashMap<String,Object>();
        Integer multiple = (Integer) reqMap.get("multiple");
        AwardResultVo resultVo = awardYc(reqMap);
        Double[] awardScope = resultVo.getAwardScope();
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(awardScope[0]*2*multiple);
        doubles.add(awardScope[1]*2*multiple);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,Joiner.on("~").join(doubles));
        return map;
    }

    @Override
    public Map<String, Object> getPlanByMatch(Integer intTime, Integer lineId) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<LotteryPlan2WithBLOBs> list = lotteryPlanService.getByPlanStatus(PlanStatus.TICKET_OUT.getValue());
        if (list==null || list.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,list);
            return map;
        }
        List<Integer> arr = new ArrayList<Integer>();
        for (LotteryPlan2WithBLOBs plan : list) {
            boolean flag = false;
            JSONArray matchItems = JSONObject.fromObject(plan.getContent()).optJSONArray("matchItems");
            for (Object matchItemObj : matchItems) {
                JSONObject matchItem = JSONObject.fromObject(matchItemObj);
                String key = matchItem.optString("intTime")+matchItem.optString("lineId");
                if (key.equals(intTime+""+lineId)){
                    flag = true;
                    break;
                }
            }
            if (flag){
                arr.add(plan.getPlanNo());
            }
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,arr);
        return map;
    }

    public AwardResultVo awardYc(Map<String,Object> map){
        Integer lotType = (Integer) map.get("lotType");
        Integer multiple = (Integer) map.get("multiple");
        Integer amount = (Integer) map.get("amount");
        String[] passType = (String[]) map.get("passTypes");
        List<Sporttery3GMatchItem> items = (List<Sporttery3GMatchItem>) map.get("items");
        LotteryType lotteryType=LotteryType.getItem(lotType);
        List<PlayType> playTypeList=new ArrayList<PlayType>();
        if(LotteryType.JCZQList.contains(lotteryType)||LotteryType.JCLQList.contains(lotteryType) ){
            for (String str : passType) {
                com.qiyun.type.SportteryPassType pt= com.qiyun.type.SportteryPassType.valueOf(str);
                playTypeList.add(pt.getType());
            }
        }
        AwardResultVo resultVo=awardDetailYcFactory.execute(lotteryType, items, multiple, playTypeList,amount,false,true);
        return resultVo;
    }

    private void addMemberWalletLine(Member2DTO member2DTO, MemberWallet2DTO memberWallet2, LotteryPlan2WithBLOBs lotteryPlan, LotteryPlanOrder2 planOrder, double amount, int transType, String remark) {
        MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
        memberWalletLine2.setPlanNo(lotteryPlan.getPlanNo());
        memberWalletLine2.setOrderNo(planOrder.getOrderNo());
        memberWalletLine2.setAccount(memberWallet2.getAccount());
        memberWalletLine2.setMemberId(memberWallet2.getMemberId());
        memberWalletLine2.setTransType(transType);
        memberWalletLine2.setWalletType(1);
        memberWalletLine2.setAmount(amount);
        memberWalletLine2.setLotteryType(lotteryPlan.getLotteryType());
        memberWalletLine2.setCreateDateTime(new Date());
        memberWalletLine2.setStatus(0);
        memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
        memberWalletLine2.setSourceId(member2DTO.getSourceId());
        memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
        memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
        memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
        memberWalletLine2.setRemark(remark);
        memberWalletLine2.setPrizeBalance(memberWallet2.getPrizeBalance());
        memberWalletLineService.insert(memberWalletLine2);
    }

    public Map<String, Object> openResult(String lotteryTypes) {
        Map<String,Object> map = new HashMap<String,Object>();
        if (StringUtils.isNullOrBlank(lotteryTypes)){
            map.put(Constants.CODE,Constants.ERROR_CODE_448);
            map.put(Constants.MSG,Constants.ERROR_MSG_448);
            return map;
        }
        String[] split = lotteryTypes.split(",");
        List<Map<String,Object>> bingoPlanList = new ArrayList<Map<String,Object>>();
        for (String lotteryType : split) {
            LotteryTerm2 term = lotteryTermService.findCurrentTermByLotteryType(Integer.parseInt(lotteryType));

            synchronized (this) {
                HashMap<String, String> openInfoMap = checkBingoService.getOpenInfoMapForCheckBingo(term, LotteryType.getItem(Integer.parseInt(lotteryType)));
                List<LotteryPlan2WithBLOBs> lotteryPlan2WithBLOBs = checkBingoService.checkBingo(openInfoMap);
                for (LotteryPlan2WithBLOBs lotteryPlan2WithBLOB : lotteryPlan2WithBLOBs) {
                    Map<String,Object> plan = new HashMap<String,Object>();
                    plan.put("planNo",lotteryPlan2WithBLOB.getPlanNo());
                    plan.put("posttaxPrize",lotteryPlan2WithBLOB.getPosttaxPrize());
                    plan.put("account",lotteryPlan2WithBLOB.getAccount());
                    plan.put("amount",lotteryPlan2WithBLOB.getAmount());
                    plan.put("createDateTime",lotteryPlan2WithBLOB.getCreateDateTime());
                    plan.put("lotteryType",LotteryType.getItem(lotteryPlan2WithBLOB.getLotteryType()).getName());
                    bingoPlanList.add(plan);
                }
            }
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,bingoPlanList);
        return map;
    }

    public Map<String, Object> getWinPlanByType(String lotteryTypes) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if (StringUtils.isNullOrBlank(lotteryTypes)){
                map.put(Constants.CODE,Constants.ERROR_CODE_448);
                map.put(Constants.MSG,Constants.ERROR_MSG_448);
                return map;
            }
            String[] split = lotteryTypes.split(",");
            List<Map<String,Object>> bingoPlanList = new ArrayList<Map<String,Object>>();
            for (String lotteryType : split) {
                List<LotteryPlan2WithBLOBs> lotteryPlan2WithBLOBs = lotteryPlanService.getWinPlanByType(Integer.parseInt(lotteryType));
                for (LotteryPlan2WithBLOBs lotteryPlan2WithBLOB : lotteryPlan2WithBLOBs) {
                    Map<String,Object> plan = new HashMap<String,Object>();
                    plan.put("planNo",lotteryPlan2WithBLOB.getPlanNo());
                    plan.put("posttaxPrize",lotteryPlan2WithBLOB.getPosttaxPrize());
                    plan.put("account",lotteryPlan2WithBLOB.getAccount());
                    plan.put("amount",lotteryPlan2WithBLOB.getAmount());
                    plan.put("createDateTime",lotteryPlan2WithBLOB.getCreateDateTime());
                    plan.put("lotteryType",LotteryType.getItem(lotteryPlan2WithBLOB.getLotteryType()).getName());
                    bingoPlanList.add(plan);
                }
            }
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,bingoPlanList);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> returnPrize(String plans) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if (StringUtils.isNullOrBlank(plans)){
                map.put(Constants.CODE,Constants.ERROR_CODE_448);
                map.put(Constants.MSG,Constants.ERROR_MSG_448);
                return map;
            }
            String[] split = plans.split(",");
            for (String planNo : split) {
                returnPrizeService.returnPrize(Integer.parseInt(planNo));
            }
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> getBasketBallAdmin(Integer intTime) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            List<SportteryBasketMatch2> matchs = sportteryBasketBallMatchService.getByIntTime(intTime);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            if (matchs == null || matchs.size() <= 0) {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA, matchs);
                return map;
            }
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
            for (SportteryBasketMatch2 match : matchs) {
                Map<String, Object> respMap = new HashMap<String, Object>();
                Integer lineid = match.getLineid();

                try {
                    String weekOfDate = DateUtil.getWeekForDate(dateFormater.parse(intTime + ""));
                    String lineIdStr = null;
                    if (lineid < 10) {
                        lineIdStr = "00" + lineid;
                    } else if (lineid < 100) {
                        lineIdStr = "0" + lineid;
                    } else {
                        lineIdStr = "" + lineid;
                    }
                    respMap.put("matchId", weekOfDate + " " + lineIdStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                respMap.put("gameName", match.getGamename());
                respMap.put("matchTime", match.getMatchtime());
                respMap.put("homeTeam", match.getHomename());
                respMap.put("guestTeam", match.getGuestname());
                respMap.put("rf", match.getHandicap());
                respMap.put("bigOrSmall", match.getBasebigorsmall());
                respMap.put("homeScore", match.getHomescore());
                respMap.put("guestScore", match.getGuestscore());
                respMap.put("status", match.getStatus());
                BasketBallMatchDTO basketBallMatchDTO = new BasketBallMatchDTO();
                basketBallMatchDTO.setShowNum(match.getShownum());
                respMap.put("selectStatus", basketBallMatchDTO.getSelectStatus());
                respMap.put("id", match.getId());
                list.add(respMap);
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, list);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> getFootBallAdmin(Integer intTime) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            List<SportteryFootballMatch2> matchs = sportteryFootBallMatchService.getByIntTime(intTime);
            if (matchs == null || matchs.size() <= 0) {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA, matchs);
                return map;
            }
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
            for (SportteryFootballMatch2 match : matchs) {
                Map<String, Object> respMap = new HashMap<String, Object>();
                Integer lineid = match.getLineid();

                try {
                    String weekOfDate = DateUtil.getWeekForDate(dateFormater.parse(intTime + ""));
                    String lineIdStr = null;
                    if (lineid < 10) {
                        lineIdStr = "00" + lineid;
                    } else if (lineid < 100) {
                        lineIdStr = "0" + lineid;
                    } else {
                        lineIdStr = "" + lineid;
                    }
                    respMap.put("matchId", weekOfDate + " " + lineIdStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                respMap.put("gameName", match.getGamename());
                respMap.put("matchTime", match.getMatchtime());
                respMap.put("homeTeam", match.getHometeam());
                respMap.put("guestTeam", match.getGuestteam());
                respMap.put("rq", match.getConcede());
                respMap.put("halfHomeScore", match.getHalfhomescore());
                respMap.put("halfGuestScore", match.getHalfguestscore());
                respMap.put("homeScore", match.getHomescore());
                respMap.put("guestScore", match.getGuestscore());
                respMap.put("status", match.getStatus());
                boolean[] showNums = FootBallIsShow.getSelectStatus(Integer.parseInt(match.getShownum() + ""));
                List arr = new ArrayList();
                for (Boolean b : showNums
                        ) {
                    arr.add(b);
                }
                respMap.put("selectStatus", arr);
                respMap.put("id", match.getId());
                list.add(respMap);
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, list);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> updateFootBallAdmin(SportteryFootballMatch2 footballMatch2) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            SportteryFootballMatch2 sportteryFootballMatch2 = sportteryFootBallMatchService.getById(footballMatch2.getId());
            sportteryFootballMatch2.setConcede(footballMatch2.getConcede());
            sportteryFootballMatch2.setHomescore(footballMatch2.getHomescore());
            sportteryFootballMatch2.setGuestscore(footballMatch2.getGuestscore());
            sportteryFootballMatch2.setHalfhomescore(footballMatch2.getHalfhomescore());
            sportteryFootballMatch2.setHalfguestscore(footballMatch2.getHalfguestscore());
            sportteryFootballMatch2.setStatus(footballMatch2.getStatus());
            sportteryFootBallMatchService.update(sportteryFootballMatch2);
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> updateBasketBallAdmin(SportteryBasketMatch2 basketMatch2) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            SportteryBasketMatch2 sportteryBasketMatch2 = sportteryBasketBallMatchService.getById(basketMatch2.getId());
            sportteryBasketMatch2.setStatus(basketMatch2.getStatus());
            sportteryBasketMatch2.setHandicap(basketMatch2.getHandicap());
            sportteryBasketMatch2.setHomescore(basketMatch2.getHomescore());
            sportteryBasketMatch2.setGuestscore(basketMatch2.getGuestscore());
            sportteryBasketMatch2.setBasebigorsmall(basketMatch2.getBasebigorsmall());
            sportteryBasketBallMatchService.update(sportteryBasketMatch2);
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,Constants.ERROR_MSG_425);
            return map;
        }
    }

    public Map<String, Object> getLotteryTypeIsSale() {
        Map<String,Object> map = new HashMap<String,Object>();
        List<LotteryTerm2> basketTerms = lotteryTermService.getBasketTerm();
        List<LotteryTerm2> footBallTerms = lotteryTermService.getFootBallTerm();
        if (basketTerms==null || basketTerms.size()<=0){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        if (footBallTerms==null || footBallTerms.size()<=0){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        String basketIsSale = "停售";
        String footBallIsSale = "停售";
        for (LotteryTerm2 basketTerm : basketTerms) {
            if (basketTerm.getIsAble()==0){
                basketIsSale = "开售";
                break;
            }
        }
        for (LotteryTerm2 footBallTerm : footBallTerms) {
            if (footBallTerm.getIsAble()==0){
                footBallIsSale = "开售";
                break;
            }
        }
        Map<String,Object> respMap = new HashMap<String,Object>();
        respMap.put("竞彩篮球",basketIsSale);
        respMap.put("竞彩足球",footBallIsSale);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,respMap);
        return map;
    }

    class UpdateDGTask extends TimerTask {
        private int status;

        public UpdateDGTask(int status) {
            this.status = status;
        }

        public void run() {
            dgService.updateDG(status);
        }
    }

    @Override
    public Integer getLotteryTerm(Integer lotteryType) {
        return dgService.getLotteryTerm(lotteryType);
    }

    public Map<String, Object> dg(Map<String, Object> reqMap) {
        Map<String,Object> map = new HashMap<String,Object>();
        Member2DTO member2DTO = (Member2DTO) reqMap.get("member2DTO");
        Integer lotteryType = Integer.parseInt(reqMap.get("lotteryType").toString());
        Integer tradeType = (Integer) reqMap.get("tradeType");
        Integer amount = (Integer) reqMap.get("amount");
        String isOnlyPlay = reqMap.get("isOnlyPlay").toString();
        String passMode = reqMap.get("passMode").toString();
        Integer publicStatus = (Integer) reqMap.get("publicStatus");
        Integer isFocus = (Integer) reqMap.get("isFocus");
        Integer multiple = Integer.parseInt(reqMap.get("multiple").toString());
        Integer betCount = (Integer) reqMap.get("betCount");
        Double maxSp = Double.parseDouble(reqMap.get("maxSp").toString());
        String[] passType = (String[]) reqMap.get("passType");
        String content = "";
        List<BasketBallMatchItem> matchItems = (List<BasketBallMatchItem>) reqMap.get("matchItems");
        List<FootBallMatchItem> ftmatchItems = (List<FootBallMatchItem>) reqMap.get("ftmatchItems");

        //获取彩期
        Integer term = dgService.getLotteryTerm(lotteryType);
        SportteryBetContentModel bc = null;
        if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
            bc = new BasketBallBetContent();
            bc.setMatchItems(matchItems);
        }else if(LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))) {
            bc = new FootBallBetContent();
            bc.setMatchItems(ftmatchItems);
        }
        bc.setIsOnlyPlay("true".equals(isOnlyPlay)?true:false);
        bc.setPassMode(PassMode.valueOf(passMode).ordinal());

        List<SportteryPassType> tempPt = new ArrayList<SportteryPassType>();
        for (String p : passType) {// 转化
            if (p != null && !"".equals(p)) {
                SportteryPassType temp = SportteryPassType.valueOf(p);
                tempPt.add(temp);
            }
        }
        bc.setPassTypes(tempPt);
        bc.setMultiple(multiple);

        String dlAccount = "";
        String qdAccount = "";
        //获取代理渠道用户名
        Map<String,Object> accountMap = getDlAndQdAccount(member2DTO);
        if ((Integer)accountMap.get(Constants.CODE)==200){
            dlAccount = accountMap.get("dlAccount")==null?"":accountMap.get("dlAccount").toString();
            qdAccount = accountMap.get("qdAccount")==null?"":accountMap.get("qdAccount").toString();
        }
        //检查是否能投注
        Map<String, Object> checkMap = checkMatch(lotteryType, passType, matchItems, ftmatchItems,bc,betCount);
        if ((Integer)checkMap.get(Constants.CODE)!=200){
            return checkMap;
        }
        List<Date> dates = (List<Date>) checkMap.get("dates");
        Date dealDateTime = null;
        for (int i = 0; i < dates.size(); i++) {
            if (i==0){
                dealDateTime = dates.get(0);
            }
            if (dates.get(i).before(dealDateTime)){
                dealDateTime = dates.get(i);
            }
        }
        JSONObject jsonObject = JSONObject.fromObject(bc);
        content = jsonObject.toString();
        // 余额购买或积分投注
        Map<String,Object> dgMap = new HashMap<String,Object>();
        dgMap.put("term",term);
        dgMap.put("tradeType",tradeType);
        dgMap.put("amount",amount);
        dgMap.put("lotteryType",lotteryType);
        dgMap.put("member2DTO",member2DTO);
        dgMap.put("content",content);
        dgMap.put("multiple",multiple);
        dgMap.put("publicStatus",publicStatus);
        dgMap.put("maxSp",maxSp);
        dgMap.put("isCopy",0);
        dgMap.put("matchItems",matchItems);
        dgMap.put("ftmatchItems",ftmatchItems);
        dgMap.put("dealDateTime",dealDateTime);
        dgMap.put("passType",passType);
        dgMap.put("isFocus",isFocus);
        dgMap.put("cardId",reqMap.get("cardId"));
        dgMap.put("cardMoney",reqMap.get("cardMoney"));
        dgMap.put("planDesc",reqMap.get("planDesc"));
        dgMap.put("minBonus",reqMap.get("minBonus"));
        dgMap.put("maxBonus",reqMap.get("maxBonus"));
        dgMap.put("dlAccount",dlAccount);
        dgMap.put("qdAccount",qdAccount);
        map = dgService.dg(dgMap);

        return map;
    }

    public Map<String,Object> getDlAndQdAccount(Member2DTO member2DTO) {
        String dlAccount = "";
        String qdAccount = "";
        Map<String,Object> map = new HashMap<String,Object>();
        if (member2DTO.getSourceId()!=0) {
            Member2 dlMember = memberService.getById(member2DTO.getSourceId());
            if (dlMember==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            MemberAgent2 dlMemberAgent = memberAgentService.getAgentByMemberId(dlMember.getId());
            if (dlMemberAgent==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            if (dlMemberAgent.getAgentType()==0){
                //渠道
                qdAccount = dlMember.getAccount();
            }else if (dlMemberAgent.getAgentType()==1){
                dlAccount = dlMember.getAccount();
                //代理
                if (dlMember.getSourceId()!=0){
                    Member2 qdMember = memberService.getById(dlMember.getSourceId());
                    if (qdMember==null){
                        map.put(Constants.CODE,Constants.ERROR_CODE_400);
                        map.put(Constants.MSG,Constants.ERROR_MSG_400);
                        return map;
                    }
                    MemberAgent2 qdMemberAgent = memberAgentService.getAgentByMemberId(qdMember.getId());
                    if (qdMemberAgent.getAgentType()==0){
                        //渠道
                        qdAccount = qdMemberAgent.getAccount();
                    }
                }
            }
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put("dlAccount",dlAccount);
        map.put("qdAccount",qdAccount);
        return map;
    }

    public Map<String,Object> checkMatch(int lotteryType,String[] passType,List<BasketBallMatchItem> matchItems,List<FootBallMatchItem> ftmatchItems,SportteryBetContentModel bc,Integer betCount){
        Map<String,Object> map = new HashMap<String,Object>();
        Integer term = dgService.getLotteryTerm(lotteryType);
        //判断是否在投注时间
//        List<BasketBallMatch> list =sportteryBasketBallMatchService.getNBAbyDate(Integer.parseInt(d1));
        if(LotteryUtils.isNotWorkTime(LotteryType.getItem(lotteryType),null)){
            map.put(Constants.CODE,Constants.ERROR_CODE_407);
            map.put(Constants.MSG,Constants.ERROR_MSG_407);
            return map;
        }
        //判断是否在投注时间
        int isDG = dgService.getDGStatus();
        if (isDG==0){
            map.put(Constants.CODE,Constants.ERROR_CODE_409);
            map.put(Constants.MSG,Constants.ERROR_MSG_409);
            return map;
        }
        //世界杯期间
        /*SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String intTime = sdf1.format(date);
        if ("09:00:00".compareTo(sdf2.format(date)) >= 0){
            //9点前算前一天
            long time = date.getTime() - 1000 * 60 * 60 *24;
            intTime = sdf1.format(new Date(time));
        }
        List<SportteryFootballMatch2> list = sportteryFootBallMatchService.getWorldCupByIntTime(Integer.parseInt(intTime));
        if(DateUtils.isNotWorkTimeByWorldCup(list,dealTime)){
            map.put(Constants.CODE,Constants.ERROR_CODE_407);
            map.put(Constants.MSG,Constants.ERROR_MSG_407);
            return map;
        }*/
        List<Date> dates = new ArrayList<Date>();
        int dealTime = dgService.getDealTime();
        if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
            //判断是否有比赛截止
            for (BasketBallMatchItem matchItem : matchItems) {
                SportteryBasketMatch2 byIntTimeAndLineId = sportteryBasketBallMatchService.getByIntTimeAndLineId(matchItem.getIntTime(), matchItem.getLineId());
//                Date time = TimeTools.getBbEndSaleTime(byIntTimeAndLineId.getMatchtime(), 60000 * dealTime);
//                Date time = TimeTools.getEndSaleTimeByWorldCup(byIntTimeAndLineId.getMatchtime(), 60000 * dealTime,byIntTimeAndLineId.getGamename());
                Date time = TimeTools.getBasketBallDealTime(byIntTimeAndLineId.getMatchtime(), 60000 * dealTime);
                if (byIntTimeAndLineId.getStatus()!=0){
                    map.put(Constants.CODE,Constants.ERROR_CODE_418);
                    map.put(Constants.MSG,Constants.ERROR_MSG_418);
                    return map;
                }
                if (new Date().getTime() > time.getTime()){
                    map.put(Constants.CODE,Constants.ERROR_CODE_413);
                    map.put(Constants.MSG,Constants.ERROR_MSG_413);
                    return map;
                }
                dates.add(time);
            }
        } else if(LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))){
            //判断是否有比赛截止
            for (FootBallMatchItem ftmatchItem : ftmatchItems) {
                SportteryFootballMatch2 byIntTimeAndLineId = sportteryFootBallMatchService.getByIntTimeAndLineId(ftmatchItem.getIntTime(), ftmatchItem.getLineId());
//                Date time = TimeTools.getFbEndSaleTime(byIntTimeAndLineId.getMatchtime(), 60000 * dealTime);
//                Date time = TimeTools.getEndSaleTimeByWorldCup(byIntTimeAndLineId.getMatchtime(), 60000 * dealTime,byIntTimeAndLineId.getGamename());
                Date time = TimeTools.getFootBallDealTime(byIntTimeAndLineId.getMatchtime(), 60000 * dealTime);
                if (byIntTimeAndLineId.getStatus()!=0){
                    map.put(Constants.CODE,Constants.ERROR_CODE_418);
                    map.put(Constants.MSG,Constants.ERROR_MSG_418);
                    return map;
                }
                if (new Date().getTime() > time.getTime()){
                    map.put(Constants.CODE,Constants.ERROR_CODE_413);
                    map.put(Constants.MSG,Constants.ERROR_MSG_413);
                    return map;
                }
                dates.add(time);
            }
        }
        //判断是否限售
        List<LotteryLimit2> lotteryLimits = null;
        if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
            lotteryLimits = lotteryLimitService.getValidLimitByType(39);
        }else if (LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))){
            lotteryLimits = lotteryLimitService.getValidLimitByType(38);
        }
        if (lotteryLimits!=null && lotteryLimits.size()>0){
            for (LotteryLimit2 lotteryLimit : lotteryLimits) {
                String[] split = lotteryLimit.getPassType().split(",");
                List<String> strings = Arrays.asList(split);
                boolean flag = false;
                //判断是否包含串法
                for (String s : passType) {
                    if (strings.contains(s)){
                        flag = true;
                    }
                }
                if (flag){
                    String[] limitContents = lotteryLimit.getContent().split("~");
                    if (limitContents.length>0){
                        int count = 0;
                        for (String limitContent : limitContents) {
                            String[] split1 = limitContent.split("_");
                            if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))) {
                                whileA:
                                for (BasketBallMatchItem matchItem : matchItems) {
                                    //遍历该场比赛选项
                                    for (SportteryOption sportteryOption : matchItem.getOptions()) {
                                        if (Integer.parseInt(split1[0]) == matchItem.getIntTime()
                                                && Integer.parseInt(split1[1]) == matchItem.getLineId()
                                                && split1[2].equals(sportteryOption.getTypeValueStr())){
                                            //包含限售
                                            count++;
                                            break whileA;
                                        }
                                    }
                                }
                            }else if (LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))){
                                whileB:
                                for (FootBallMatchItem ftmatchItem : ftmatchItems) {
                                    //遍历该场比赛选项
                                    for (SportteryOption sportteryOption : ftmatchItem.getOptions()) {
                                        String typeValueStr = sportteryOption.getTypeValueStr();
                                        if (sportteryOption.getRqs()!=0){
                                            typeValueStr = "让球"+typeValueStr;
                                        }
                                        if (Integer.parseInt(split1[0]) == ftmatchItem.getIntTime()
                                                && Integer.parseInt(split1[1]) == ftmatchItem.getLineId()
                                                && split1[2].equals(typeValueStr)){
                                            //包含限售
                                            count++;
                                            break whileB;
                                        }
                                    }
                                }
                            }

                        }
                        if (count==limitContents.length){
                            //限售
                            map.put(Constants.CODE,Constants.ERROR_CODE_443);
                            map.put(Constants.MSG,Constants.ERROR_MSG_443);
                            return map;
                        }
                    }
                }
            }
        }

        List<Map> lotteryTermMap = dgMapper.findByLotteryTypeAndTerm(lotteryType, term+"");

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
        if (buyTerm.termIsClose(TradeType.TRADE_BALANCE)) {
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

        //注数检查
        int bcUnit = 0;
        if(LotteryType.JC_HT_LIST.contains(LotteryType.getItem(lotteryType))){
            bcUnit = bc.countHtUnit();
        }else{
            bcUnit = bc.countUnit();
        }

        if (bcUnit != betCount.intValue()){
            map.put(Constants.CODE,Constants.ERROR_CODE_408);
            map.put(Constants.MSG,Constants.ERROR_MSG_408);
            return map;
        }

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put("dates",dates);
        return map;
    }

    public Map<String, Object> getTicketDetail(Integer planNo,Member2DTO member2DTO) {
        return ticketService.getTicketDetail(planNo,member2DTO);
    }

    public Map<String, Object> setBbFocusMatch(Integer[] ids) {
        Map<String,Object> map = new HashMap<String,Object>();

        if (ids==null || ids.length<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }

        for (Integer id : ids) {
            FocusMatchBb2 focusMatchBb2 = new FocusMatchBb2();
            focusMatchBb2.setMatchId(id);
            focusMatchBb2.setStatus(1);
            focusMatchBbService.insert(focusMatchBb2);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> setFbFocusMatch(Integer[] ids) {
        Map<String,Object> map = new HashMap<String,Object>();

        if (ids==null || ids.length<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }

        for (Integer id : ids) {
            FocusMatchFb2 focusMatchFb2 = new FocusMatchFb2();
            focusMatchFb2.setMatchId(id);
            focusMatchFb2.setStatus(1);
            focusMatchFbService.insert(focusMatchFb2);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> setAddPrize(Integer lotteryType, double rate, double minAmount, Integer[] playTypes) {
        AddPrize2 addPrize2 = new AddPrize2();
        String playType = "";
        if (playTypes!=null && playTypes.length>0){
            for (int i = 0; i < playTypes.length; i++) {
                playType += playTypes[i];
                if (i!=playTypes.length-1){
                    playType += ",";
                }
            }
        }
        addPrize2.setLotteryType(lotteryType);
        addPrize2.setRate(rate);
        addPrize2.setMinAmount(minAmount);
        addPrize2.setPlayTypes(playType);
        return addPrizeService.addOrUpdate(addPrize2);
    }

    public Map<String,Object> setAddPrizeBlackOrWhite(Integer[] ids, Integer type) {
        return blackForAddPrizeService.setAddPrizeBlackOrWhite(ids,type);
    }

    public Map<String,Object> getAddPrizeBlack(String account, int page, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        if (!StringUtils.isNullOrBlank(account)){
            if ("sj".equals(account.substring(0,2))) {
                Member2DTO byAccount = memberService.getByAccount(account);
                if (byAccount==null){
                    map.put(Constants.CODE,Constants.ERROR_CODE_400);
                    map.put(Constants.MSG,Constants.ERROR_MSG_400);
                    return map;
                }
            }else{
                Member2 byUsername = memberService.getByUsername(account);
                if (byUsername==null){
                    map.put(Constants.CODE,Constants.ERROR_CODE_400);
                    map.put(Constants.MSG,Constants.ERROR_MSG_400);
                    return map;
                }
                account = byUsername.getAccount();
            }

        }else {
            account = null;
        }
        return blackForAddPrizeService.getAddPrizeBlack(account,page,pageSize);
    }

    public Map<String, Object> getMatchDealTime() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,dgService.getDealTime());
        return map;
    }

    public Map<String, Object> updateMatchDealTime(Integer dealTime) {
        return dgService.updateMatchDealTime(dealTime);
    }

    public Map<String, Object> getMaxAddPrize() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,dgService.getMaxAddPrize());
        return map;
    }

    public Map<String, Object> updateMaxAddPrize(double maxAddPrize) {
        return dgService.updateMaxAddPrize(maxAddPrize);
    }

    public Map<String,Object> getAddPirzeConfigList(int page, int pageSize) {
        return addPrizeService.getAddPirzeConfigList(page,pageSize);
    }

    public Map<String, Object> updateAddPirzeConfig(Integer lotteryType, double rate, double minAmount, int[] playTypes) {
        return addPrizeService.updateAddPirzeConfig(lotteryType,rate,minAmount,playTypes);
    }

    public Map<String, Object> updateBbFocusMatchStatus(Integer id) {
        return focusMatchBbService.updateBbFocusMatchStatus(id);
    }

    public Map<String, Object> updateFbFocusMatchStatus(Integer id) {
        return focusMatchFbService.updateFbFocusMatchStatus(id);
    }

    @Override
    public void addSalesCount(LotteryPlan2WithBLOBs lotteryPlan) {
        memberService.addSalesCount(lotteryPlan);
    }
}
