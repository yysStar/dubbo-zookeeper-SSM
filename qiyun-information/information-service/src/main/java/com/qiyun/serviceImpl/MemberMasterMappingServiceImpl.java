package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.CloundSummaryDTO;
import com.qiyun.mapper2.MemberMasterMappingMapper;
import com.qiyun.model2.MemberCloudsLine;
import com.qiyun.model2.MemberMasterMapping;
import com.qiyun.service.MemberMasterMappingService;
//import com.qiyun.util.TransType;

import com.qiyun.type.TransType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("memberMasterMappingService")
public class MemberMasterMappingServiceImpl implements MemberMasterMappingService {
    @Resource
    private MemberMasterMappingMapper memberMasterMappingMapper;

    public MemberMasterMapping getByAccount(String account) {
        return memberMasterMappingMapper.getByAccount(account);
    }

    public int insertSelective(MemberMasterMapping mapping){
        return memberMasterMappingMapper.insertSelective(mapping);
    }

    public int updateSelective(MemberMasterMapping mapping) {
        return memberMasterMappingMapper.updateByPrimaryKeySelective(mapping);
    }

    public String getAccountByusername(String username) {
        return memberMasterMappingMapper.getAccountByusername(username);
    }

    public List<MemberCloudsLine> getRechargeList(String account, List<Integer>list,String startTime,String endTime, int offset, int pageSize){
        if(account == ""){
            account = null;
        }
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.getRechargeList(account,list,startTime,endTime);
    }

    public List<MemberCloudsLine> getWithdrawList(String account,String startTime,String endTime, int offset, int pageSize){
        if(account == ""){
            account = null;
        }
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.getWithdrawList(account,startTime,endTime);
    }

    public List<MemberCloudsLine> getBuyRecommendList(String account,String startTime,String endTime, int offset, int pageSize){
        if(account == ""){
            account = null;
        }
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.getBuyRecommendList(account,startTime,endTime);
    }

    public List<MemberCloudsLine> getRecommendRefundList(String account,String startTime,String endTime, int offset, int pageSize){
        if(account == ""){
            account = null;
        }
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.getRecommendRefundList(account,startTime,endTime);
    }

    public List<MemberCloudsLine> getRewardList(String account,String startTime,String endTime, int offset, int pageSize){
        if(account == ""){
            account = null;
        }
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.getRewardList(account,startTime,endTime);
    }

    public List<MemberCloudsLine> getRecommendIncomeList(String account,String startTime,String endTime, int offset, int pageSize){
        if(account == ""){
            account = null;
        }
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.getRecommendIncomeList(account,startTime,endTime);
    }

    public List<MemberCloudsLine> getRewardIncomeList(String account,String startTime,String endTime, int offset, int pageSize){
        if(account == ""){
            account = null;
        }
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.getRewardIncomeList(account,startTime,endTime);
    }

    public List<MemberCloudsLine> getQuickReviwList(String account,String startTime,String endTime, int offset, int pageSize){
        if(account == ""){
            account = null;
        }
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.getQuickReviwList(account,startTime,endTime);
    }
    public List<CloundSummaryDTO> getCloundSummaryList2(String account, String startTime, String endTime, int offset, int pageSize) {
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        List<CloundSummaryDTO> cloundSummaryDTOList = new ArrayList<CloundSummaryDTO>();
        List<Integer> list = TransType.pays;    //充值类型列表
        PageHelper.startPage(offset, pageSize);
        List<String> accounts = memberMasterMappingMapper.getIds2(account);  //查询出所要查的的account
        for (String account2 : accounts) {
            CloundSummaryDTO cloundSummaryDTO = new CloundSummaryDTO();
            cloundSummaryDTO.setAccount(account2);
            Integer Recharge = memberMasterMappingMapper.getRechargeClound(list, account2, startTime, endTime);
            if (Recharge != null) { //如果充值云朵数不为空
                cloundSummaryDTO.setRecharge("+"+Recharge);
            }
            Integer Withdraw = memberMasterMappingMapper.getWithdrawClound(account2, startTime, endTime);
            if (Withdraw != null) { //如果提款云朵数不为空
                cloundSummaryDTO.setWithdraw("-"+Withdraw);
            }
            Integer BuyRecommend = memberMasterMappingMapper.getBuyRecommendClound(account2, startTime, endTime);
            if (BuyRecommend != null) { //如果购买推荐云朵数不为空
                cloundSummaryDTO.setBuyRecommend("-"+BuyRecommend);
            }
            Integer RecommendRefund = memberMasterMappingMapper.getRecommendRefundClound(account2, startTime, endTime);
            if (RecommendRefund != null) { //如果不中退款云朵数不为空
                cloundSummaryDTO.setRecommendRefund("+"+RecommendRefund);
            }
            Integer Reward = memberMasterMappingMapper.getRewardClound(account2, startTime, endTime);
            if (Reward != null) { //如果打赏云朵数不为空
                cloundSummaryDTO.setReward("-"+Reward);
            }
            Integer RecommendIncome = memberMasterMappingMapper.getRecommendIncomeClound(account2, startTime, endTime);
            if (RecommendIncome != null) { //如果被购加款云朵数不为空
                cloundSummaryDTO.setRecommendIncome("+"+RecommendIncome);
            }
            Integer RewardIncome = memberMasterMappingMapper.getRewardIncomeClound(account2, startTime, endTime);
            if (RewardIncome != null) { //如果打赏收入云朵数不为空
                cloundSummaryDTO.setRewardIncome("+"+RewardIncome);
            }
            Integer QuickReviw = memberMasterMappingMapper.getQuickReviwClound(account2, startTime, endTime);
            if (QuickReviw != null) { //如果快速审核扣款云朵数不为空
                cloundSummaryDTO.setQuickReviw("-"+QuickReviw);
            }
            Integer cloud = memberMasterMappingMapper.getCloud(account2);
            if (cloud != null) { //如果当前云朵数不为空
                cloundSummaryDTO.setClound(cloud);
            }
            cloundSummaryDTOList.add(cloundSummaryDTO);
        }
        return cloundSummaryDTOList;
    }

    public List<CloundSummaryDTO> getCloundSummaryList1(String startTime, String endTime, int offset, int pageSize) {
        if (startTime == "") {
            startTime = null;
        }
        if (endTime == "") {
            endTime = null;
        }
        List<CloundSummaryDTO>cloundSummaryDTOList = new ArrayList<CloundSummaryDTO>();
        List<Integer>list = TransType.pays;    //充值类型列表
        PageHelper.startPage(offset, pageSize);
        List<String>accounts = memberMasterMappingMapper.getIds();  //查询出所要查的的account
        for (String account:accounts) {
            CloundSummaryDTO cloundSummaryDTO = new CloundSummaryDTO();
            cloundSummaryDTO.setAccount(account);
            Integer Recharge = memberMasterMappingMapper.getRechargeClound(list,account,startTime,endTime);
            if(Recharge!=null){ //如果充值云朵数不为空
                cloundSummaryDTO.setRecharge("+"+Recharge);
            }
            Integer Withdraw = memberMasterMappingMapper.getWithdrawClound(account,startTime,endTime);
            if(Withdraw!=null){ //如果提款云朵数不为空
                cloundSummaryDTO.setWithdraw("-"+Withdraw);
            }
            Integer BuyRecommend = memberMasterMappingMapper.getBuyRecommendClound(account,startTime,endTime);
            if(BuyRecommend!=null){ //如果购买推荐云朵数不为空
                cloundSummaryDTO.setBuyRecommend("-"+BuyRecommend);
            }
            Integer RecommendRefund = memberMasterMappingMapper.getRecommendRefundClound(account,startTime,endTime);
            if(RecommendRefund!=null){ //如果不中退款云朵数不为空
                cloundSummaryDTO.setRecommendRefund("+"+RecommendRefund);
            }
            Integer Reward = memberMasterMappingMapper.getRewardClound(account,startTime,endTime);
            if(Reward!=null){ //如果打赏云朵数不为空
                cloundSummaryDTO.setReward("-"+Reward);
            }
            Integer RecommendIncome = memberMasterMappingMapper.getRecommendIncomeClound(account,startTime,endTime);
            if(RecommendIncome!=null){ //如果被购加款云朵数不为空
                cloundSummaryDTO.setRecommendIncome("+"+RecommendIncome);
            }
            Integer RewardIncome = memberMasterMappingMapper.getRewardIncomeClound(account,startTime,endTime);
            if(RewardIncome!=null){ //如果打赏收入云朵数不为空
                cloundSummaryDTO.setRewardIncome("+"+RewardIncome);
            }
            Integer QuickReviw = memberMasterMappingMapper.getQuickReviwClound(account,startTime,endTime);
            if(QuickReviw!=null){ //如果快速审核扣款云朵数不为空
                cloundSummaryDTO.setQuickReviw("-"+QuickReviw);
            }
            Integer cloud = memberMasterMappingMapper.getCloud(account);
            if (cloud != null) { //如果当前云朵数不为空
                cloundSummaryDTO.setClound(cloud);
            }
            cloundSummaryDTOList.add(cloundSummaryDTO);
        }
        return cloundSummaryDTOList;
    }
}
