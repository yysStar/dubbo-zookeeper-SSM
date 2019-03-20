package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.CreditRefund2DTO;

public interface CreditRefundService {
    Result creditRefundApply(String account, double amount);

    Result passCreditRefundApply(String account, int id);

    CreditRefund2DTO getById(int id);

    Result refuseCreditRefundApply(String account, int id);

    Result getCreditRefund(int page, int pageSize, String account, int status, String loginAccount, String operator, String startTime, String endTime);
}
