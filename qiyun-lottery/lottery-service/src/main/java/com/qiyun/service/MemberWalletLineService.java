package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.model2.MemberWalletLine2;

import java.math.BigDecimal;
import java.util.Date;

public interface MemberWalletLineService {
    Result insert(MemberWalletLine2 memberWalletLine2);

    int updateCard(Integer cardId, Date date);

    BigDecimal findCardFullMoneyById(Integer cardId);

    MemberWalletLine2 getByPlanNoAndRemark(Integer planNo, String remark);

    MemberWalletLine2 getByAccountAndPlanNoAndTransType(String account, Integer planNo, int value);
}
