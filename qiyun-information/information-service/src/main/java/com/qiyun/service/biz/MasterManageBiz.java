package com.qiyun.service.biz;

import com.github.pagehelper.PageInfo;
import com.qiyun.api.MasterManageApi;
import com.qiyun.dto.CloundSummaryDTO;
import com.qiyun.dto.RecommendPlanDTO;
import com.qiyun.dto.WithdrawCashDTO;
import com.qiyun.mapper2.MemberMasterMappingMapper;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.type.TransType;
import com.qiyun.util.Constants;
//import com.qiyun.util.TransType;
//import com.qiyun.util.WalletTransType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("masterManageApi")
public class MasterManageBiz implements MasterManageApi {
    @Autowired
    private MemberMasterMappingService memberMasterMappingService;
    @Autowired
    private RecommendPlanService recommendPlanService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberTaskBeginService memberTaskBeginService;
    @Autowired
    private MemberCloudsService memberCloudsService;
    @Autowired
    private MemberMasterMappingMapper memberMasterMappingMapper;

    /**
     * 获取云朵汇总列表
     * @param account
     * @param startTime
     * @param endTime
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getCloundSummaryList(String account, String startTime, String endTime, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
//        String account2 = "";
        try {
            if(account==null||account.equals("")){ //没有传用户名
                List<CloundSummaryDTO> cloundSummaryList1 = memberMasterMappingService.getCloundSummaryList1(startTime, endTime, offset, pageSize);
                PageInfo<CloundSummaryDTO> pageInfo = new PageInfo<CloundSummaryDTO>(cloundSummaryList1);
                List<String>accounts = memberMasterMappingMapper.getIds();
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA,cloundSummaryList1);
                map.put("total",accounts.size());
                return map;
            }else{
//                if(!account.startsWith("sj")){
//                    account2 = memberMasterMappingService.getAccountByusername(account);
//                }
                List<CloundSummaryDTO> cloundSummaryList2 = memberMasterMappingService.getCloundSummaryList2(account,startTime, endTime, offset, pageSize);
//                PageInfo<CloundSummaryDTO> pageInfo = new PageInfo<CloundSummaryDTO>(cloundSummaryList2);
                List<String>accounts = memberMasterMappingMapper.getIds();  //查询出所要查的的account
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA,cloundSummaryList2);
                map.put("total",accounts.size());
                return map;
            }
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询云朵汇总列表出错");
            return map;
        }
    }

    /**
     * 获取快速审核扣款列表
     * @param account
     * @param startTime
     * @param endTime
     * @return
     */
    public Map<String, Object> getQuickReviwList(String account, String startTime, String endTime, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<MemberCloudsLine> getQuickReviwList = memberMasterMappingService.getQuickReviwList(account,startTime,endTime,offset,pageSize);
            if(getQuickReviwList==null||getQuickReviwList.size()==0){
                map.put(Constants.CODE, Constants.ERROR_CODE_623);
                map.put(Constants.MSG, Constants.ERROR_MSG_623);
                return map;
            }
            PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(getQuickReviwList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询打赏收入列表出错");
            return map;
        }
    }

    /**
     * 获取打赏收入列表
     *
     * @param account
     * @param startTime
     * @param endTime
     * @return
     */
    public Map<String, Object> getRewardIncomeList(String account, String startTime, String endTime, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<MemberCloudsLine> getRewardIncomeList = memberMasterMappingService.getRewardIncomeList(account,startTime,endTime,offset,pageSize);
            if(getRewardIncomeList==null||getRewardIncomeList.size()==0){
                map.put(Constants.CODE, Constants.ERROR_CODE_622);
                map.put(Constants.MSG, Constants.ERROR_MSG_622);
                return map;
            }
            PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(getRewardIncomeList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询打赏收入列表出错");
            return map;
        }
    }

    /**
     * 获取推荐收入列表
     *
     * @param account
     * @param startTime
     * @param endTime
     * @return
     */
    public Map<String, Object> getRecommendIncomeList(String account, String startTime, String endTime, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<MemberCloudsLine> getRecommendIncomeList = memberMasterMappingService.getRecommendIncomeList(account,startTime,endTime,offset,pageSize);
            if(getRecommendIncomeList==null||getRecommendIncomeList.size()==0){
                map.put(Constants.CODE, Constants.ERROR_CODE_621);
                map.put(Constants.MSG, Constants.ERROR_MSG_621);
                return map;
            }
            PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(getRecommendIncomeList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询被购加款列表出错");
            return map;
        }
    }

    /**
     * 获取打赏记录列表
     * @return
     */
    public Map<String, Object> getRewardList(String account,String startTime,String endTime, int offset, int pageSize){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<MemberCloudsLine> getRewardList = memberMasterMappingService.getRewardList(account,startTime,endTime,offset,pageSize);
            if(getRewardList==null||getRewardList.size()==0){
                map.put(Constants.CODE, Constants.ERROR_CODE_620);
                map.put(Constants.MSG, Constants.ERROR_MSG_620);
                return map;
            }
            PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(getRewardList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询打赏列表出错");
            return map;
        }
    }

    /**
     * 获取推荐退款记录
     * @return
     */
    public Map<String, Object> getRecommendRefundList(String account,String startTime,String endTime, int offset, int pageSize){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<MemberCloudsLine> getRecommendRefundList = memberMasterMappingService.getRecommendRefundList(account,startTime,endTime,offset,pageSize);
            if(getRecommendRefundList==null||getRecommendRefundList.size()==0){
                map.put(Constants.CODE, Constants.ERROR_CODE_618);
                map.put(Constants.MSG, Constants.ERROR_MSG_618);
                return map;
            }
            PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(getRecommendRefundList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询推荐退款出错");
            return map;
        }
    }

    /**
     * 获取购买推荐记录
     * @return
     */
    public Map<String, Object> getBuyRecommendList(String account,String startTime,String endTime, int offset, int pageSize){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<MemberCloudsLine> getBuyRecommendList = memberMasterMappingService.getBuyRecommendList(account,startTime,endTime,offset,pageSize);
            if(getBuyRecommendList==null||getBuyRecommendList.size()==0){
                map.put(Constants.CODE, Constants.ERROR_CODE_617);
                map.put(Constants.MSG, Constants.ERROR_MSG_617);
                return map;
            }
            PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(getBuyRecommendList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询购买推荐出错");
            return map;
        }
    }

    /**
     * 获取提款记录
     *
     * @param account
     * @param startTime
     * @param endTime
     * @return
     */
    public Map<String, Object> getWithdrawList(String account, String startTime, String endTime, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<MemberCloudsLine> getWithdrawList = memberMasterMappingService.getWithdrawList(account,startTime,endTime,offset,pageSize);
            if(getWithdrawList==null||getWithdrawList.size()==0){
                map.put(Constants.CODE, Constants.ERROR_CODE_616);
                map.put(Constants.MSG, Constants.ERROR_MSG_616);
                return map;
            }
            PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(getWithdrawList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询提款明细出错");
            return map;
        }
    }

    /**
     * 获取充值云朵记录
     *
     * @param account
     * @return
     */
    public Map<String, Object> getRechargeList(String account,String startTime,String endTime, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
//        if(!account.startsWith("sj")){
//            account = memberMasterMappingService.getAccountByusername(account);
//        }
        try {
            List<Integer>lists = TransType.pays;    //充值类型列表
//                new ArrayList<Integer>(){{
//            add(0);add(1000);add(1017);add(2058);add(2062);add(2063);add(2064);add(2065);
//            add(2066);add(2067);add(2068);add(2069);add(2070);add(2071);add(2072);
//            add(2073);add(2074);add(2075);
//        }};
            List<MemberCloudsLine> getRechargeList = memberMasterMappingService.getRechargeList(account,lists,startTime,endTime,offset,pageSize);
            if(getRechargeList==null||getRechargeList.size()==0){
                map.put(Constants.CODE, Constants.ERROR_CODE_615);
                map.put(Constants.MSG, Constants.ERROR_MSG_615);
                return map;
            }
            PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(getRechargeList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }catch (RuntimeException e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "查询充值明细出错");
            return map;
        }
    }

    /**
     * 添加认证名人
     * @param account
     * @param sort
     * @return
     */

    public Map<String, Object> addMaster(String account, int sort) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2 member = memberService.getByAccount(account);
        if(member == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        MemberMasterMapping mapping = memberMasterMappingService.getByAccount(account);
        if(mapping == null){
            mapping = MemberMasterMapping.builder().account(account).createDatetime(new Date())
                    .sort(sort).isMaster(true).build();
            memberMasterMappingService.insertSelective(mapping);
        }else {
            if (mapping.getIsMaster()) { //重复添加判断
                map.put(Constants.CODE, Constants.ERROR_CODE_10);
                map.put(Constants.MSG, Constants.ERROR_MSG_10_1);
                return map;
            }
            if (mapping.getIsHighgrade()) { //从实战大神到认证名人
                mapping.setIsHighgrade(false);
            }
            mapping.setUpdateDatetime(new Date());
            mapping.setIsMaster(true);
            mapping.setSort(sort);
            memberMasterMappingService.updateSelective(mapping);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 添加实战大神
     * @param account
     * @param sort
     * @return
     */
    public Map<String, Object> addHighGrade(String account, int sort) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2 member = memberService.getByAccount(account);
        if(member == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        MemberMasterMapping mapping = memberMasterMappingService.getByAccount(account);
        if(mapping == null){
            mapping = MemberMasterMapping.builder().account(account).createDatetime(new Date())
                    .sort(sort).isHighgrade(true).build();
            memberMasterMappingService.insertSelective(mapping);
        }else {
            if (mapping.getIsHighgrade()) { //重复添加判断
                map.put(Constants.CODE, Constants.ERROR_CODE_10);
                map.put(Constants.MSG, Constants.ERROR_MSG_10_2);
                return map;
            }
            if (mapping.getIsMaster()) { //从认证名人到实战大神
                mapping.setIsMaster(false);
            }
            mapping.setUpdateDatetime(new Date());
            mapping.setIsHighgrade(true);
            mapping.setSort(sort);
            memberMasterMappingService.updateSelective(mapping);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 取消认证名人
     * @param account
     * @return
     */
    public Map<String, Object> cancelMaster(String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2 member = memberService.getByAccount(account);
        if(member == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        MemberMasterMapping mapping = memberMasterMappingService.getByAccount(account);
        if(mapping != null){
            if (mapping.getIsMaster()) { //取消认证名人
                mapping.setUpdateDatetime(new Date());
                mapping.setIsMaster(false);
                memberMasterMappingService.updateSelective(mapping);
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 取消实战大神
     * @param account
     * @return
     */
    public Map<String, Object> cancelHighGrade(String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2 member = memberService.getByAccount(account);
        if(member == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        MemberMasterMapping mapping = memberMasterMappingService.getByAccount(account);
        if(mapping != null){
            if (mapping.getIsHighgrade()) { //取消实战大神
                mapping.setUpdateDatetime(new Date());
                mapping.setIsHighgrade(false);
                memberMasterMappingService.updateSelective(mapping);
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 修改排序权重
     * @param account
     * @param sort
     * @return
     */
    public Map<String, Object> changeSort(String account, int sort) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2 member = memberService.getByAccount(account);
        if(member == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        MemberMasterMapping mapping = memberMasterMappingService.getByAccount(account);
        if(mapping == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_3);
            return map;
        }
        if(!mapping.getIsHighgrade() && !mapping.getIsMaster()){
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_4);
            return map;
        }
        mapping.setSort(sort);
        memberMasterMappingService.updateSelective(mapping);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 待审核列表
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> examineList(int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<RecommendPlanDTO> list = recommendPlanService.getExamineList(offset, pageSize);
        PageInfo<RecommendPlanDTO> pageInfo = new PageInfo<RecommendPlanDTO>(list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 审核
     * @param id
     * @param type
     * @return
     */
    public Map<String, Object> examine(int id, int type) {
        Map<String, Object> map = new HashMap<String, Object>();
        RecommendPlan recommendPlan = recommendPlanService.getRecommendPlanById(id);
        if(type == 1){
            recommendPlan.setExamineStatus(1);
        } else {
            recommendPlan.setExamineStatus(2);
            //审核失败不算在任务中，还可重新发布
            MemberTaskBegin memberTaskBegin = memberTaskBeginService.getById(recommendPlan.getTaskId());
            memberTaskBegin.setTaskNum(memberTaskBegin.getTaskNum() - 1);
            if(memberTaskBegin.getIsFinish() == 0){
                memberTaskBegin.setIsFinish(1);
            }
            memberTaskBeginService.update(memberTaskBegin);
        }
        recommendPlanService.updateRecommendPlan(recommendPlan);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 提现列表
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> withdrawCashList(int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<WithdrawCashDTO> cashList = memberCloudsService.getCashList(offset, pageSize);
        for(WithdrawCashDTO cashDTO : cashList) {
            BigDecimal scale = new BigDecimal(TransType.SCALE);
            BigDecimal money = new BigDecimal(cashDTO.getClouds())
                    .divide(scale, 2, BigDecimal.ROUND_DOWN);//去尾保留两位小数
            cashDTO.setMoney(money);
        }
        PageInfo<WithdrawCashDTO> pageInfo = new PageInfo(cashList);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 确认提现
     * @return
     */
    public Map<String, Object> withdrawCashConfirm(String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        MemberClouds memberClouds = memberCloudsService.getByAccount(account);
        memberClouds.setFreezeBalance(0);
        memberCloudsService.update(memberClouds);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }
}
