package com.qiyun.mapper2;

import com.qiyun.model2.LotteryType2;
import com.qiyun.model2.LotteryType2Example;
import java.util.List;

public interface LotteryType2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LotteryType2 record);

    int insertSelective(LotteryType2 record);

    List<LotteryType2> selectByExample(LotteryType2Example example);

    LotteryType2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LotteryType2 record);

    int updateByPrimaryKey(LotteryType2 record);

    /**
     * @param planNo
     * @return
     */
    int getTypeByPlanNo(int planNo);
}