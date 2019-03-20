package com.qiyun.mapper2;

import com.qiyun.model2.CopyLotteryPlan2;
import com.qiyun.model2.CopyLotteryPlan2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CopyLotteryPlan2Mapper {
    int countByExample(CopyLotteryPlan2Query example);

    int deleteByExample(CopyLotteryPlan2Query example);

    int deleteByPrimaryKey(Integer copyLotteryplanId);

    int insert(CopyLotteryPlan2 record);

    int insertSelective(CopyLotteryPlan2 record);

    List<CopyLotteryPlan2> selectByExampleWithBLOBs(CopyLotteryPlan2Query example);

    List<CopyLotteryPlan2> selectByExample(CopyLotteryPlan2Query example);

    CopyLotteryPlan2 selectByPrimaryKey(Integer copyLotteryplanId);

    int updateByExampleSelective(@Param("record") CopyLotteryPlan2 record, @Param("example") CopyLotteryPlan2Query example);

    int updateByExampleWithBLOBs(@Param("record") CopyLotteryPlan2 record, @Param("example") CopyLotteryPlan2Query example);

    int updateByExample(@Param("record") CopyLotteryPlan2 record, @Param("example") CopyLotteryPlan2Query example);

    int updateByPrimaryKeySelective(CopyLotteryPlan2 record);

    int updateByPrimaryKeyWithBLOBs(CopyLotteryPlan2 record);

    int updateByPrimaryKey(CopyLotteryPlan2 record);
}