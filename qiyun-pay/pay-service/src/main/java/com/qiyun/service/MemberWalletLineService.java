package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.model2.MemberWalletLine2;

public interface MemberWalletLineService {
    Result update(String prdOrdNo, String orderAmount);
    Result update2(String prdOrdNo, String orderAmount, String remark, int transType);

    Result passPayApply(String account, Double amount); //线下充值

    Result passPayApply2(String account, Double amount); //授信充值

    Result getMemberWalletLineByXx(String account,int page,int pageSize);

    int insertSelective(MemberWalletLine2 record);
}
