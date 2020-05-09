package com.qiyun.service.biz;

import com.github.pagehelper.PageInfo;
import com.qiyun.DTO.MatchTicketDTO;
import com.qiyun.DTO.UserProfileDTO;
import com.qiyun.api.ChampionApi;
import com.qiyun.dto.ChampionPlanDTO;
import com.qiyun.dto.ChampionPlanDetailsDTO;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.httpUtil.JsonUtil;
import com.qiyun.model.TicketRestrict;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.tools.TicketTools;
import com.qiyun.util.Constants;
import com.qiyun.util.TicketUtil;
import com.qiyun.utils.DbDataVerify;
import com.qiyun.utils.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("championApi")
public class ChampionBiz implements ChampionApi {
    @Autowired
    private ChampionMatchService championMatchService;
    @Autowired
    private ChampionMatchUpService championMatchUpService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberGrade2Service memberGrade2Service;
    @Autowired
    private TicketRestrictService ticketRestrictService;
    @Autowired
    private ChampionPlanService championPlanService;
    @Autowired
    private ChampionPlanMatchService championPlanMatchService;
    @Autowired
    private MemberWalletService memberWalletService;
    @Autowired
    private MemberWalletLineService memberWalletLineService;

    /**
     * 冠军赛事列表
     * @return
     */
    public Map<String, Object> getMatchList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ChampionMatch> list = championMatchService.getAll();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, list);
        return map;
    }

    /**
     * 冠亚军赛事列表
     * @return
     */
    public Map<String, Object> getMatchUpList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ChampionMatchUp> list = championMatchUpService.getAll();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, list);
        return map;
    }

    /**
     * 冠亚军投注
     * @return
     */
    public Map<String, Object> betChampion(String account, int type, List<Integer> matchList, int multiple) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member = memberService.getByAccount(account);
        if(member == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        int matchs = matchList.size();
        if(matchs == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_13);
            return map;
        }
        //票务玩法
        String lotId = "";
        //获取最大SP
        BigDecimal maxSp = new BigDecimal(0);
        if(type == 1){ //冠军
            for(int i = 0; i < matchList.size(); i++){ //获取最大SP
                ChampionMatch championMatch = championMatchService.getById(matchList.get(i));
                if(!"开售".equals(championMatch.getSellStatus())){
                    map.put(Constants.CODE, Constants.ERROR_CODE_6);
                    map.put(Constants.MSG, Constants.ERROR_MSG_6_13);
                    return map;
                }
                if(i == 0){
                    maxSp = championMatch.getSp();
                } else if(championMatch.getSp().compareTo(maxSp) > 0){
                    maxSp = championMatch.getSp();
                }
                //冠军票务玩法
                lotId = "N1";
            }
        } else { //冠亚军
            for(int i = 0; i < matchList.size(); i++){ //获取最大SP
                ChampionMatchUp championMatchUp = championMatchUpService.getById(matchList.get(i));
                if(!"开售".equals(championMatchUp.getSellStatus())){
                    map.put(Constants.CODE, Constants.ERROR_CODE_6);
                    map.put(Constants.MSG, Constants.ERROR_MSG_6_13);
                    return map;
                }
                if(i == 0){
                    maxSp = championMatchUp.getSp();
                } else if(championMatchUp.getSp().compareTo(maxSp) > 0){
                    maxSp = championMatchUp.getSp();
                }
                //冠亚军票务玩法
                lotId = "N12";
            }
        }
        int perAmount = matchs * 2;
        int amount = matchs * 2 * multiple;
        MemberWallet2DTO memberWallet = memberWalletService.getByMemberId(member.getId());
        if(new BigDecimal(memberWallet.getAbleBalance()).compareTo(new BigDecimal(amount)) < 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_601);
            map.put(Constants.MSG, Constants.ERROR_MSG_601);
            return map;
        }
        int ticketStatus = 0;
        String orderId = "";
        if(isTicket(amount, account, maxSp)){ //是否出票
            //出票配置
            JSONObject reqJo = new JSONObject();
            JSONObject resJo = null;
            UserProfileDTO userProfileDTO = getUserProfile(member);
            List<MatchTicketDTO> matchTicketDTOS = new ArrayList<MatchTicketDTO>();
            MatchTicketDTO matchTicketDTO = new MatchTicketDTO();
            //按通彩易麦要求生成内部票号
            String a = TicketUtil.getTcymAgentID();
            String b = JsonUtil.OrderID;
            orderId = JsonUtil.getTcymId(a, b);
            StringBuffer sbf = new StringBuffer();
            sbf.append("01*");
            int i = 1;
            for(Integer matchId : matchList){
                if(i == matchs){
                    sbf.append(JsonUtil.getAnteCode(matchId) + "^");
                } else {
                    sbf.append(JsonUtil.getAnteCode(matchId) + ",");
                    i++;
                }
            }
            matchTicketDTO.setPlayType("0");//冠亚军默认玩法为0
            matchTicketDTO.setLotId(lotId);
            matchTicketDTO.setAnteCode(sbf.toString());
            matchTicketDTO.setLotMulti(multiple + "");
            matchTicketDTO.setOrderId(orderId);
            matchTicketDTO.setLotMoney(amount + "");
            matchTicketDTO.setUserProfilel(userProfileDTO);
            matchTicketDTOS.add(matchTicketDTO);
            reqJo.put("matchTicketList", matchTicketDTOS);
            //请求通彩易麦接口
            String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicket);//接口编号
            resJo = JSONObject.fromObject(s);
            if(resJo == null){
                map.put(Constants.CODE, Constants.ERROR_CODE_6);
                map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
                return map;
            }
            JSONObject body = resJo.optJSONObject("body");
            JSONObject ActionResult = body.optJSONObject("ActionResult");
            if("0000".equals(ActionResult.optString("@wCode"))){//票务出票
                ticketStatus = 1;
            } else { //出票失败
                ticketStatus = 3;
                map.put(Constants.CODE, Constants.ERROR_CODE_6);
                map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
                map.put(Constants.DATA, i);
            }
        } else { // 不出票，设置出票中（定时任务3分钟自动成功）
            ticketStatus = 1;
        }
        //生成冠亚军投注订单
        ChampionPlan championPlan = ChampionPlan.builder().account(account).amount(amount)
                .createTime(new Date()).multiple(multiple).ticketStatus(ticketStatus).orderNo(orderId)
                .perAmount(perAmount).type(type).build();
        int i = championPlanService.insertSelective(championPlan);
        if(ticketStatus == 1){
            memberWallet.setAbleBalance(
                    new BigDecimal(memberWallet.getAbleBalance()).subtract(new BigDecimal(amount)).doubleValue());
            memberWalletService.update(memberWallet);
            MemberWalletLine2 line = MemberWalletLine2.builder().planNo(i).account(account)
                    .memberId(memberWallet.getMemberId()).transType(30).walletType(1)
                    .amount((double) amount).heapBalance(memberWallet.getHeapBalance())
                    .freezeBalance(memberWallet.getFreezeBalance()).sourceId(member.getSourceId())
                    .ableBalance(memberWallet.getAbleBalance()).prizeBalance(memberWallet.getPrizeBalance())
                    .status(0).remark("冠亚军购彩").createDateTime(new Date())
                    .build();
            if(type == 1){
                line.setLotteryType(46);
            } else {
                line.setLotteryType(47);
            }
            line.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(line));
            memberWalletLineService.insert(line);
        }
        for(Integer matchId : matchList){ //订单中选择的赛事
            if(type == 1){
                ChampionMatch championMatch = championMatchService.getById(matchId);
                ChampionPlanMatch championPlanMatch = ChampionPlanMatch.builder().planId(i)
                        .sp(championMatch.getSp()).teamId(championMatch.getTeamId()).build();
                championPlanMatchService.insertSelective(championPlanMatch);
            } else {
                ChampionMatchUp championMatchUp = championMatchUpService.getById(matchId);
                ChampionPlanMatch championPlanMatch = ChampionPlanMatch.builder().planId(i)
                        .sp(championMatchUp.getSp()).teamId(championMatchUp.getTeamId()).build();
                championPlanMatchService.insertSelective(championPlanMatch);
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, i);
        return map;
    }

    /**
     * 冠亚军投注（一场一单）
     * @return
     */
    public Map<String, Object> betChampion2(String account, int type, List<Integer> matchList, int multiple) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member = memberService.getByAccount(account);
        if(member == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        int matchs = matchList.size();
        if(matchs == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_13);
            return map;
        }
        //获取最大SP
        BigDecimal maxSp = new BigDecimal(0);
        if(type == 1){ //冠军
            for(int i = 0; i < matchList.size(); i++){ //获取最大SP
                ChampionMatch championMatch = championMatchService.getById(matchList.get(i));
                if(!"开售".equals(championMatch.getSellStatus())){
                    map.put(Constants.CODE, Constants.ERROR_CODE_6);
                    map.put(Constants.MSG, Constants.ERROR_MSG_6_13);
                    return map;
                }
                if(i == 0){
                    maxSp = championMatch.getSp();
                } else if(championMatch.getSp().compareTo(maxSp) > 0){
                    maxSp = championMatch.getSp();
                }
            }
        } else { //冠亚军
            for(int i = 0; i < matchList.size(); i++){ //获取最大SP
                ChampionMatchUp championMatchUp = championMatchUpService.getById(matchList.get(i));
                if(!"开售".equals(championMatchUp.getSellStatus())){
                    map.put(Constants.CODE, Constants.ERROR_CODE_6);
                    map.put(Constants.MSG, Constants.ERROR_MSG_6_13);
                    return map;
                }
                if(i == 0){
                    maxSp = championMatchUp.getSp();
                } else if(championMatchUp.getSp().compareTo(maxSp) > 0){
                    maxSp = championMatchUp.getSp();
                }
            }
        }
        int perAmount = matchs * 2;
        int amount = matchs * 2 * multiple;
        MemberWallet2DTO memberWallet = memberWalletService.getByMemberId(member.getId());
        if(new BigDecimal(memberWallet.getAbleBalance()).compareTo(new BigDecimal(amount)) < 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_601);
            map.put(Constants.MSG, Constants.ERROR_MSG_601);
            return map;
        }
        int ticketStatus = 0;
        String orderId = "";
        int i = 0;
        if(isTicket(amount, account, maxSp)){ //是否出票
            UserProfileDTO userProfileDTO = getUserProfile(member);
            //出票配置
            JSONObject resJo = null;
            //生成冠亚军投注订单
            ChampionPlan championPlan = ChampionPlan.builder().account(account).amount(amount)
                    .createTime(new Date()).multiple(multiple).ticketStatus(ticketStatus).orderNo("22222")
                    .perAmount(perAmount).type(type).build();
            i = championPlanService.insertSelective(championPlan);
            for(Integer matchId : matchList){
                //按通彩易麦要求生成内部票号
                String a = TicketUtil.getTcymAgentID();
                String b = JsonUtil.OrderID;
                orderId = JsonUtil.getTcymId(a, b);
                MatchTicketDTO matchTicketDTO = new MatchTicketDTO();
                matchTicketDTO.setPlayType("0");//冠亚军默认玩法为0
                matchTicketDTO.setLotMulti(multiple + "");
                matchTicketDTO.setOrderId(orderId);
                matchTicketDTO.setLotMoney(amount + "");
                matchTicketDTO.setUserProfilel(userProfileDTO);
                resJo = putTicket(matchId, matchTicketDTO, type);
                if(resJo == null){
                    map.put(Constants.CODE, Constants.ERROR_CODE_6);
                    map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
                    return map;
                }
                JSONObject body = resJo.optJSONObject("body");
                JSONObject ActionResult = body.optJSONObject("ActionResult");
                if("0000".equals(ActionResult.optString("@wCode"))){//票务出票
                    ticketStatus = 1;
                } else { //出票失败
                    ticketStatus = 3;
                    map.put(Constants.CODE, Constants.ERROR_CODE_6);
                    map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
                    map.put(Constants.DATA, i);
                }
                championPlan.setTicketStatus(ticketStatus);
                championPlanService.update(championPlan);
                //订单中选择的赛事
                addPlanMatch(matchId, i, type, orderId);
            }
        } else { // 不出票，设置出票中（定时任务3分钟自动成功）
            ticketStatus = 1;
            //生成冠亚军投注订单
            ChampionPlan championPlan = ChampionPlan.builder().account(account).amount(amount)
                    .createTime(new Date()).multiple(multiple).ticketStatus(ticketStatus).orderNo("")
                    .perAmount(perAmount).type(type).build();
            i = championPlanService.insertSelective(championPlan);
            for(Integer matchId : matchList) { //订单中选择的赛事
                addPlanMatch(matchId, i, type, "");
            }
        }
        if(ticketStatus == 1){
            memberWallet.setAbleBalance(
                    new BigDecimal(memberWallet.getAbleBalance()).subtract(new BigDecimal(amount)).doubleValue());
            memberWalletService.update(memberWallet);
            MemberWalletLine2 line = MemberWalletLine2.builder().planNo(i).account(account)
                    .memberId(memberWallet.getMemberId()).transType(30).walletType(1)
                    .amount((double) amount).heapBalance(memberWallet.getHeapBalance())
                    .freezeBalance(memberWallet.getFreezeBalance()).sourceId(member.getSourceId())
                    .ableBalance(memberWallet.getAbleBalance()).prizeBalance(memberWallet.getPrizeBalance())
                    .status(0).remark("冠亚军购彩").createDateTime(new Date())
                    .build();
            if(type == 1){
                line.setLotteryType(46);
            } else {
                line.setLotteryType(47);
            }
            line.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(line));
            memberWalletLineService.insert(line);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, i);
        return map;
    }

    /**
     * 添加订单中赛事列表
     * @param matchId
     * @param i
     * @param type
     * @param orderNo
     */
    private void addPlanMatch(Integer matchId, int i, int type, String orderNo) {
        //订单中选择的赛事
        if(type == 1){
            ChampionMatch championMatch = championMatchService.getById(matchId);
            ChampionPlanMatch championPlanMatch = ChampionPlanMatch.builder().planId(i)
                    .sp(championMatch.getSp()).teamId(championMatch.getTeamId())
                    .orderNo(orderNo).build();
            championPlanMatchService.insertSelective(championPlanMatch);
        } else {
            ChampionMatchUp championMatchUp = championMatchUpService.getById(matchId);
            ChampionPlanMatch championPlanMatch = ChampionPlanMatch.builder().planId(i)
                    .sp(championMatchUp.getSp()).teamId(championMatchUp.getTeamId())
                    .orderNo(orderNo).build();
            championPlanMatchService.insertSelective(championPlanMatch);
        }
    }

    private JSONObject putTicket(Integer matchId, MatchTicketDTO matchTicketDTO, int type) {
        JSONObject reqJo = new JSONObject();
        List<MatchTicketDTO> matchTicketDTOS = new ArrayList<MatchTicketDTO>();
        String lotId = "";
        if(type == 1){ //冠军票务玩法
            lotId = "N1";
        } else { //冠亚军票务玩法
            lotId = "N12";
        }
        matchTicketDTO.setLotId(lotId);
        matchTicketDTO.setAnteCode("01*" + JsonUtil.getAnteCode(matchId) + "^");
        matchTicketDTOS.add(matchTicketDTO);
        reqJo.put("matchTicketList", matchTicketDTOS);
        //请求通彩易麦接口
        String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicket);//接口编号
        if(StringUtils.isNullOrBlank(s)){
            return null;
        }
        JSONObject resJo = JSONObject.fromObject(s);
        return resJo;
    }

    /**
     * 我的冠亚军
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> planList(String account, int offset, int pageSize){
        Map<String, Object> map = new HashMap<String, Object>();
        List<ChampionPlanDTO> list = championPlanService.getListByAccount(account, offset, pageSize);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        PageInfo<ChampionPlanDTO> pageInfo = new PageInfo<ChampionPlanDTO>(list);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 中奖订单列表
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> planBingoList(String account, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ChampionPlanDTO> list = championPlanService.getBingoListByAccount(account, offset, pageSize);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        PageInfo<ChampionPlanDTO> pageInfo = new PageInfo<ChampionPlanDTO>(list);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 获取冠亚军订单详情
     * @param id
     * @return
     */
    public Map<String, Object> planDetails(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        ChampionPlanDetailsDTO details = championPlanService.getDetailsById(id);
        if(details.getBingoMoney() == null || details.getBingoMoney().compareTo(new BigDecimal(0)) == 0){
            details.setRateOfReturn(new BigDecimal(0));
        } else {
            details.setRateOfReturn(details.getBingoMoney()
                    .divide(new BigDecimal(details.getAmount()), 2, BigDecimal.ROUND_HALF_UP));
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, details);
        return map;
    }

    /**
     * 拦截判断是否出票
     * @param amount
     * @param account
     * @param maxSp
     * @return
     */
    private boolean isTicket(int amount, String account, BigDecimal maxSp) {
        Member2DTO member2 = memberService.getByAccount(account);
        if(member2.getType() == 2){
            return false;
        }
        MemberGrade2 memberGrade2 = memberGrade2Service.getByAccount(account);
        /**
         * VIP直接出票不用校验
         */
        if(memberGrade2 != null && memberGrade2.getIsVip() == 1){
            return true;
        }
        TicketRestrict ticketRestrict = ticketRestrictService.getByEffective();
        /**
         * 校验金额
         */
        if(ticketRestrict.getCredit().compareTo(new BigDecimal(amount)) > 0){//设置金额大于订单金额不出票
            return false;
        }
        /**
         * 校验SP
         */
        if(ticketRestrict.getSp().compareTo(maxSp) > 0){//设置SP大于订单最大SP不出票
            return false;
        }
        return true;
    }

    /**
     * 添加票务商需要的用户信息
     * @param member
     * @return
     */
    public static UserProfileDTO getUserProfile(Member2DTO member) {
        UserProfileDTO userProfile = new UserProfileDTO();
        userProfile.setUserName(TicketUtil.getTcymAgentID());
//        userProfile.setBonusPhone(member.getMobile());
        userProfile.setCardNumber(member.getCertNo());
        userProfile.setCardType(member.getCertType().toString());
//        userProfile.setMail(member.getEmail());
//        userProfile.setMobile(member.getMobile());
//        userProfile.setRealName(member.getName());
        return userProfile;
    }
}
