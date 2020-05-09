package com.qiyun.service;

import com.qiyun.model2.LotteryPlan;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.LotteryPlanAddPrize2;
import com.qiyun.model2.LotteryPlanWithBLOBs;

import java.util.List;
import java.util.Map;

public interface LotteryPlanService {
    public Map<String, Object> getSporttery(int planNo);

    public LotteryPlanWithBLOBs selectByPrimaryKey(int planNo);

    LotteryPlanWithBLOBs getByPlanNo(int planNo);

    int updatePlanTicketStatus(LotteryPlanWithBLOBs lotteryPlan);

    List<LotteryPlan> selectLotteryPlans(int value, int i, String term);

    void updateLotteryPlan(LotteryPlan lotteryPlan);

    void update(LotteryPlanWithBLOBs plan);

}
