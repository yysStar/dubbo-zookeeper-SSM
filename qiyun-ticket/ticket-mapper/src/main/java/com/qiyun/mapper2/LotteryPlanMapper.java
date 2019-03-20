package com.qiyun.mapper2;

import com.qiyun.model2.LotteryPlan;
import com.qiyun.model2.LotteryPlanExample;
import com.qiyun.model2.LotteryPlanWithBLOBs;
import java.util.List;

public interface LotteryPlanMapper {
    int deleteByPrimaryKey(Integer planNo);

    int insert(LotteryPlanWithBLOBs record);

    int insertSelective(LotteryPlanWithBLOBs record);

    List<LotteryPlanWithBLOBs> selectByExampleWithBLOBs(LotteryPlanExample example);

    List<LotteryPlan> selectByExample(LotteryPlanExample example);

    LotteryPlanWithBLOBs selectByPrimaryKey(Integer planNo);

    int updateByPrimaryKeySelective(LotteryPlanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LotteryPlanWithBLOBs record);

    int updateByPrimaryKey(LotteryPlan record);

    //查询方案详情
    String getPlanByPrimarykey(int id);
}