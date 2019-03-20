package com.qiyun.mapper2;

import com.qiyun.model2.CopyLotteryPlan;
import com.qiyun.model2.CopyLotteryPlanExample;
import java.util.List;

public interface CopyLotteryPlanMapper {
    int deleteByPrimaryKey(Integer copyLotteryplanId);

    int insert(CopyLotteryPlan record);

    int insertSelective(CopyLotteryPlan record);

    List<CopyLotteryPlan> selectByExampleWithBLOBs(CopyLotteryPlanExample example);

    List<CopyLotteryPlan> selectByExample(CopyLotteryPlanExample example);

    CopyLotteryPlan selectByPrimaryKey(Integer copyLotteryplanId);

    int updateByPrimaryKeySelective(CopyLotteryPlan record);

    int updateByPrimaryKeyWithBLOBs(CopyLotteryPlan record);

    int updateByPrimaryKey(CopyLotteryPlan record);
}