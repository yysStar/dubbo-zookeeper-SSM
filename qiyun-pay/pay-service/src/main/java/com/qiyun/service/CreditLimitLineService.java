package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.CreditLimitLine2DTO;

public interface CreditLimitLineService {

    Result insert(CreditLimitLine2DTO creditLimitLine2DTO);

    Result getCreditLimitLine(int page, int pageSize, String account, String loginAccount);
}
