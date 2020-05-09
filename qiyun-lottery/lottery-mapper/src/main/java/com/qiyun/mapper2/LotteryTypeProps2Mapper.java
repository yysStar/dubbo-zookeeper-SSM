package com.qiyun.mapper2;

import com.qiyun.model2.LotteryTypeProps2;
import com.qiyun.model2.LotteryTypeProps2Example;
import java.util.List;

public interface LotteryTypeProps2Mapper {
    int deleteByPrimaryKey(Integer lotteryType);

    int insert(LotteryTypeProps2 record);

    int insertSelective(LotteryTypeProps2 record);

    List<LotteryTypeProps2> selectByExample(LotteryTypeProps2Example example);

    LotteryTypeProps2 selectByPrimaryKey(Integer lotteryType);

    int updateByPrimaryKeySelective(LotteryTypeProps2 record);

    int updateByPrimaryKey(LotteryTypeProps2 record);
}