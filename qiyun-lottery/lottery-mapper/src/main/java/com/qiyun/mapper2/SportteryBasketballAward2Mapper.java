package com.qiyun.mapper2;

import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.SFAward;
import com.qiyun.model2.SportteryBasketballAward2;
import com.qiyun.model2.SportteryBasketballAward2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportteryBasketballAward2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketballAward2 record);

    int insertSelective(SportteryBasketballAward2 record);

    List<SportteryBasketballAward2> selectByExample(SportteryBasketballAward2Example example);

    SportteryBasketballAward2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryBasketballAward2 record);

    int updateByPrimaryKey(SportteryBasketballAward2 record);

    List<SFAward> selectByIntTime(Integer intTime);

    List<SFAward> selectByIntTimes(@Param("intTimes") List<Integer> intTimes);

    List<SFAward> selectByIntTimeAndLineId(@Param("intTime") Integer intTime, @Param("lineId") Integer lineId,
                                     @Param("pm") Integer pm, @Param("playType") Integer playType);
}