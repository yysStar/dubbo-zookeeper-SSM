package com.qiyun.mapper2;

import com.qiyun.model.BasketBallBase;
import com.qiyun.model2.BasketballBase2;
import com.qiyun.model2.BasketballBase2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasketballBase2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasketballBase2 record);

    int insertSelective(BasketballBase2 record);

    List<BasketballBase2> selectByExample(BasketballBase2Example example);

    BasketballBase2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasketballBase2 record);

    int updateByPrimaryKey(BasketballBase2 record);

    BasketBallBase selectByIntTimeLindId(@Param("intTime") Integer intTime,@Param("lineId") Integer lineId);
}