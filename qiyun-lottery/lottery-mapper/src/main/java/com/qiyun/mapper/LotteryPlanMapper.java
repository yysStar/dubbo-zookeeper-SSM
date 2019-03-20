package com.qiyun.mapper;

import com.qiyun.model.LotteryPlan;
import com.qiyun.model.LotteryPlanQuery;
import com.qiyun.model.LotteryPlanWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LotteryPlanMapper {
    int countByExample(LotteryPlanQuery example);

    int deleteByExample(LotteryPlanQuery example);

    int deleteByPrimaryKey(Integer planNo);

    int insert(LotteryPlanWithBLOBs record);

    int insertSelective(LotteryPlanWithBLOBs record);

    List<LotteryPlanWithBLOBs> selectByExampleWithBLOBs(LotteryPlanQuery example);

    List<LotteryPlan> selectByExample(LotteryPlanQuery example);

    LotteryPlanWithBLOBs selectByPrimaryKey(Integer planNo);

    int updateByExampleSelective(@Param("record") LotteryPlanWithBLOBs record, @Param("example") LotteryPlanQuery example);

    int updateByExampleWithBLOBs(@Param("record") LotteryPlanWithBLOBs record, @Param("example") LotteryPlanQuery example);

    int updateByExample(@Param("record") LotteryPlan record, @Param("example") LotteryPlanQuery example);

    int updateByPrimaryKeySelective(LotteryPlanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LotteryPlanWithBLOBs record);

    int updateByPrimaryKey(LotteryPlan record);
}