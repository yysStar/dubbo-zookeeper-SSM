package com.qiyun.service;

import com.qiyun.model2.LotteryPlan2WithBLOBs;
import org.springframework.stereotype.Service;

@Service
public interface ReturnPrizeService {
    void returnPrize(Integer planNo);
}
