package com.qiyun.service.Impl;

import com.qiyun.mapper2.LotteryPlanAddPrize2Mapper;
import com.qiyun.model2.LotteryPlanAddPrize2;
import com.qiyun.service.LotteryPlanAddPrizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LotteryPlanAddPrizeServiceImpl implements LotteryPlanAddPrizeService {

    @Resource
    private LotteryPlanAddPrize2Mapper lotteryPlanAddPrize2Mapper;

    public LotteryPlanAddPrize2 findLotteryPlanAddPrize(Integer planNo) {

        return lotteryPlanAddPrize2Mapper.selectByPrimaryKey(planNo);
    }
}
