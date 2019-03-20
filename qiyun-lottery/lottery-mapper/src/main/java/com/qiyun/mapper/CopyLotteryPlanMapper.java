package com.qiyun.mapper;

import com.qiyun.model.CopyLotteryPlan;
import com.qiyun.model.CopyLotteryPlanQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CopyLotteryPlanMapper {
    int countByExample(CopyLotteryPlanQuery example);

    int deleteByExample(CopyLotteryPlanQuery example);

    int deleteByPrimaryKey(Integer copyLotteryplanId);

    int insert(CopyLotteryPlan record);

    int insertSelective(CopyLotteryPlan record);

    List<CopyLotteryPlan> selectByExampleWithBLOBs(CopyLotteryPlanQuery example);

    List<CopyLotteryPlan> selectByExample(CopyLotteryPlanQuery example);

    CopyLotteryPlan selectByPrimaryKey(Integer copyLotteryplanId);

    int updateByExampleSelective(@Param("record") CopyLotteryPlan record, @Param("example") CopyLotteryPlanQuery example);

    int updateByExampleWithBLOBs(@Param("record") CopyLotteryPlan record, @Param("example") CopyLotteryPlanQuery example);

    int updateByExample(@Param("record") CopyLotteryPlan record, @Param("example") CopyLotteryPlanQuery example);

    int updateByPrimaryKeySelective(CopyLotteryPlan record);

    int updateByPrimaryKeyWithBLOBs(CopyLotteryPlan record);

    int updateByPrimaryKey(CopyLotteryPlan record);
}