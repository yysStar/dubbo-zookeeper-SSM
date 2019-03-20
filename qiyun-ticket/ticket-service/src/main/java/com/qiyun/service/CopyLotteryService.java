package com.qiyun.service;

import com.github.pagehelper.PageInfo;
import com.qiyun.model2.CopyLotteryPlan;
import org.springframework.stereotype.Service;

@Service
public interface CopyLotteryService {
    //分页查询跟单详情
    public PageInfo<CopyLotteryPlan> getPageCopyLotterPlanList(int offset, int pageSize, int id);

}
