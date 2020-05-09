package com.qiyun.mapper2;

import com.qiyun.model2.LotteryPlanAddPrize2;
import com.qiyun.model2.LotteryPlanAddPrize2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LotteryPlanAddPrize2Mapper {
    int countByExample(LotteryPlanAddPrize2Query example);

    int deleteByExample(LotteryPlanAddPrize2Query example);

    int deleteByPrimaryKey(Integer planNo);

    int insert(LotteryPlanAddPrize2 record);

    int insertSelective(LotteryPlanAddPrize2 record);

    List<LotteryPlanAddPrize2> selectByExample(LotteryPlanAddPrize2Query example);

    LotteryPlanAddPrize2 selectByPrimaryKey(Integer planNo);

    int updateByExampleSelective(@Param("record") LotteryPlanAddPrize2 record, @Param("example") LotteryPlanAddPrize2Query example);

    int updateByExample(@Param("record") LotteryPlanAddPrize2 record, @Param("example") LotteryPlanAddPrize2Query example);

    int updateByPrimaryKeySelective(LotteryPlanAddPrize2 record);

    int updateByPrimaryKey(LotteryPlanAddPrize2 record);
}