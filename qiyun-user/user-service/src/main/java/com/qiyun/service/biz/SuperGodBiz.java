package com.qiyun.service.biz;

import com.github.pagehelper.PageInfo;
import com.qiyun.api.SuperGodApi;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.MemberFansDTO;
import com.qiyun.dto.PlanDTO;
import com.qiyun.dto.SuperGodDTO;
import com.qiyun.model.MemberFollowMapping;
import com.qiyun.model2.LotteryPlanOrder;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberFollowMapping2;
import com.qiyun.service.LotteryPlanOrderService;
import com.qiyun.service.MemberFollowMappingService;
import com.qiyun.service.MemberService;
import com.qiyun.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("superGodApi")
public class SuperGodBiz implements SuperGodApi {
    private static Logger logger = LoggerFactory.getLogger(SuperGodApi.class);

    @Autowired
    private MemberFollowMappingService memberFollowMappingService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private LotteryPlanOrderService lotteryPlanOrderService;

    /**
     * 获取超级大神个人中心
     * @param account
     * @return
     */
    public Map<String, Object> getSuperGod(String account, String fansAccount) {
        Map<String,Object> map = new HashMap<String, Object>();
        SuperGodDTO superGodDTO = memberService.getSuperGod(account);
        if(superGodDTO==null){  //如果用户没有发过单子查询为空
            SuperGodDTO superGodDTON = memberService.getSuperGodN(account); //查询没有发过单子人的关注数和粉丝数
            SuperGodDTO superGodDTO2 = SuperGodDTO.builder().bingoMoney(new BigDecimal(0)).militaryExploits("0中0")
                    .rateOfReturn(new BigDecimal(0)).bingoNum(0).BuyNum(0).winningRate(new BigDecimal(0))
                    .account(superGodDTON.getAccount()).name(superGodDTON.getName()).picture(superGodDTON.getPicture())
                    .fansNum(superGodDTON.getFansNum()).followNum(superGodDTON.getFollowNum()).build();
            map.put(Constants.DATA, superGodDTO2);
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            boolean isSelf = false;
            if(account.equals(fansAccount)){
                isSelf = true;
            }
            map.put("isSelf", isSelf);
            return map;
        }
        Member2DTO member2 = memberService.getByAccount(account);
        if(member2.getType() == 1){ //彩研账户添加倍数
            superGodDTO.setBingoMoney(superGodDTO.getBingoMoney().multiply(new BigDecimal(member2.getMultiple())));
        }
        List<LotteryPlanOrder> list = lotteryPlanOrderService.getTenByAccount(account);
        double prizes = 0;
        double aMounts = 0;
        int i = 0;
        boolean isSelf = false;
        if(account.equals(fansAccount)){
            isSelf = true;
        }
        if(list.size() == 0){
            superGodDTO.setMilitaryExploits("0中0");
            superGodDTO.setRateOfReturn(new BigDecimal(0));
        }else {
            for (LotteryPlanOrder lotteryPlanOrder : list) {
                prizes = prizes + lotteryPlanOrder.getPosttaxPrize();
                aMounts = aMounts + lotteryPlanOrder.getAmount();
                if (lotteryPlanOrder.getPrizeSettleStatus().intValue() == 0) {
                    i++;
                }
            }
            if(list.size() < 10) {
                superGodDTO.setMilitaryExploits(list.size() + "中" + i);
            }else{
                superGodDTO.setMilitaryExploits("10中" + i);
            }
            double d = prizes/aMounts;
            superGodDTO.setRateOfReturn(new BigDecimal(d).setScale(2,BigDecimal.ROUND_HALF_UP));
        }
        if(!isSelf){
            MemberFollowMapping2 mapping = memberFollowMappingService.getByFansAccount(account, fansAccount);
            if(mapping == null || mapping.getIsCancel()){
                map.put("isFollow", false);
            } else {
                map.put("isFollow", true);
            }
        }
        map.put(Constants.DATA, superGodDTO);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put("isSelf", isSelf);
        return map;
    }

//    public static void main(String[] args) {
//        double a = 10.1234;
//        double b = 9.2231;
//        BigDecimal bigDecimal = new BigDecimal(a/b);
//        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_DOWN));
//    }

    /**
     * 添加关注
     * @param account
     * @param fansAccount
     * @return
     */
    public Map<String, Object> followMember(String account, String fansAccount) {
        Map<String,Object> map = new HashMap<String, Object>();
        MemberFollowMapping2 mapping = memberFollowMappingService.getByFansAccount(account, fansAccount);
        if(mapping != null){
            if(mapping.getIsCancel()) {
                mapping.setIsCancel(false);
                mapping.setUpdateDatetime(new Date());
                memberFollowMappingService.update(mapping);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG,Constants.SUCCESS_MSG);
                map.put("id", mapping.getId());
                return map;
            }else{
                map.put(Constants.CODE, Constants.ERROR_CODE_8);
                map.put(Constants.MSG, Constants.ERROR_MSG_8_1);
                return map;
            }
        }
        MemberFollowMapping memberFollowMapping = MemberFollowMapping.builder().account(account)
                .createDatetime(new Date()).fansAccount(fansAccount).build();
        int i = memberFollowMappingService.insertSelective(memberFollowMapping);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put("id",i);
        return map;
    }

    /**
     * 取消关注
     * @param account
     * @param fansAccount
     * @return
     */
    public Map<String, Object> cancelFollow(String account, String fansAccount) {
        Map<String,Object> map = new HashMap<String, Object>();
        MemberFollowMapping2 mapping = memberFollowMappingService.getByFansAccount(account, fansAccount);
        if(mapping == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_8);
            map.put(Constants.MSG, Constants.ERROR_MSG_8_2);
            return map;
        }
        if(mapping.getIsCancel()){
            map.put(Constants.CODE, Constants.ERROR_CODE_8);
            map.put(Constants.MSG, Constants.ERROR_MSG_8_3);
            return map;
        }
        mapping.setIsCancel(true);
        mapping.setUpdateDatetime(new Date());
        memberFollowMappingService.update(mapping);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 关注列表
     * @param fansAccount
     * @return
     */
    public Map<String, Object> followList(String fansAccount, int offset, int pageSize) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<MemberFansDTO> list = memberFollowMappingService.getFollowList(fansAccount, offset, pageSize);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        PageInfo<MemberFansDTO> page = new PageInfo(list);
        map.put(Constants.DATA, page);
        return map;
    }

    /**
     * 粉丝列表
     * @param account
     * @return
     */
    public Map<String, Object> fansList(String account, int offset, int pageSize) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<MemberFansDTO> list = memberFollowMappingService.getFansList(account, offset, pageSize);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        PageInfo<MemberFansDTO> page = new PageInfo(list);
        map.put(Constants.DATA, page);
        return map;
    }

    /**
     * 方案列表
     * @param account
     * @param type
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> planList(String account, boolean isSelf, int type, int offset, int pageSize) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<PlanDTO> list = new ArrayList<PlanDTO>();
        switch (type){
            case 1: // 进行中
                list = lotteryPlanOrderService.getPlayingPlan(account, isSelf, offset, pageSize);
                break;
            case 2: // 红单
                list = lotteryPlanOrderService.getBingoPlan(account, isSelf, offset, pageSize);
                break;
            case 3: // 晒单
                list = lotteryPlanOrderService.getShowPlan(account, isSelf, offset, pageSize);
                break;
            case 4: // 历史订单
                list = lotteryPlanOrderService.getFinishPlan(account, isSelf, offset, pageSize);
                break;
            default:
                map.put(Constants.CODE, Constants.ERROR_CODE_1);
                map.put(Constants.MSG, Constants.ERROR_MSG_1);
                return map;
        }
//        if(isSelf) {
//            PageInfo<PlanDTO> page = new PageInfo(list);
//            map.put(Constants.DATA, list);
//        } else {
//            map.put(Constants.DATA, page);
//        }
        for(PlanDTO planDTO : list){
            Member2DTO member2 = memberService.getByAccount(account);
            if(member2.getType() == 1){ //彩研账户添加倍数
                planDTO.setAllBuyMoney(planDTO.getAmount()* member2.getMultiple()+(planDTO.getSumAmount()-planDTO.getAmount()));
                planDTO.setBingoMoney(planDTO.getBingoMoney().multiply(new BigDecimal(member2.getMultiple())));
            }

        }
        PageInfo<PlanDTO> page = new PageInfo(list);
        map.put(Constants.DATA, page);
        map.put("isSelf", isSelf);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }
}
