package com.qiyun.service;

import com.qiyun.model2.LotteryPlanAddPrize2;
import org.springframework.stereotype.Service;

@Service
public interface LotteryPlanAddPrizeService {
    LotteryPlanAddPrize2 getByPlanNo(Integer planNo);

    void update(LotteryPlanAddPrize2 addPrize);
}
