package com.qiyun.service;

import com.qiyun.dto.CloundSummaryDTO;
import com.qiyun.model2.MemberCloudsLine;
import com.qiyun.model2.MemberMasterMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberMasterMappingService {

    MemberMasterMapping getByAccount(String account);

    int insertSelective(MemberMasterMapping mapping);

    int updateSelective(MemberMasterMapping mapping);

    String getAccountByusername(String username);

    //充值记录
    List<MemberCloudsLine> getRechargeList(String account,List<Integer>list,String startTime,String endTime, int offset, int pageSize);

    //提现记录
    List<MemberCloudsLine> getWithdrawList(String account,String startTime,String endTime, int offset, int pageSize);

    //购买推荐记录
    List<MemberCloudsLine> getBuyRecommendList(String account,String startTime,String endTime, int offset, int pageSize);

    //推荐退款记录
    List<MemberCloudsLine> getRecommendRefundList(String account,String startTime,String endTime, int offset, int pageSize);

    //打赏记录
    List<MemberCloudsLine> getRewardList(String account,String startTime,String endTime, int offset, int pageSize);

    //被购加款记录
    List<MemberCloudsLine> getRecommendIncomeList(String account,String startTime,String endTime, int offset, int pageSize);

    //打赏收入记录
    List<MemberCloudsLine> getRewardIncomeList(String account,String startTime,String endTime, int offset, int pageSize);

    //快速审核扣款记录
    List<MemberCloudsLine> getQuickReviwList(String account,String startTime,String endTime, int offset, int pageSize);

    //获取云朵汇总表--没有传account
    List<CloundSummaryDTO> getCloundSummaryList1(String startTime, String endTime, int offset, int pageSize);

    //获取云朵汇总表--传account
    List<CloundSummaryDTO> getCloundSummaryList2(String account, String startTime, String endTime, int offset, int pageSize);
}
