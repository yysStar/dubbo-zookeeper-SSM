package com.qiyun.mapper;

import com.qiyun.model.LotteryPlanOrder;
import com.qiyun.model.LotteryPlanOrderQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LotteryPlanOrderMapper {
    int countByExample(LotteryPlanOrderQuery example);

    int deleteByExample(LotteryPlanOrderQuery example);

    int deleteByPrimaryKey(Integer orderNo);

    int insert(LotteryPlanOrder record);

    int insertSelective(LotteryPlanOrder record);

    List<LotteryPlanOrder> selectByExample(LotteryPlanOrderQuery example);

    LotteryPlanOrder selectByPrimaryKey(Integer orderNo);

    int updateByExampleSelective(@Param("record") LotteryPlanOrder record, @Param("example") LotteryPlanOrderQuery example);

    int updateByExample(@Param("record") LotteryPlanOrder record, @Param("example") LotteryPlanOrderQuery example);

    int updateByPrimaryKeySelective(LotteryPlanOrder record);

    int updateByPrimaryKey(LotteryPlanOrder record);
}