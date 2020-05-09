package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.XxPayApply2DTO;
import com.qiyun.dto.XxPayApplyDTO;

public interface XxPayApplyService {
    Result addXxPayApply(XxPayApplyDTO xxPayApply);

    Result getPayApplyList(int page, int pageSize);

    XxPayApply2DTO getById(int id);

    Result passPayApply(int id);

    Result refuseApply(int id);
}
