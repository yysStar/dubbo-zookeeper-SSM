package com.qiyun.mapper2;

import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.SFCAward;
import com.qiyun.model2.SportteryBasketballFcaward2;
import com.qiyun.model2.SportteryBasketballFcaward2Example;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface SportteryBasketballFcaward2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketballFcaward2 record);

    int insertSelective(SportteryBasketballFcaward2 record);

    List<SportteryBasketballFcaward2> selectByExample(SportteryBasketballFcaward2Example example);

    SportteryBasketballFcaward2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryBasketballFcaward2 record);

    int updateByPrimaryKey(SportteryBasketballFcaward2 record);

    List<SFCAward> selectByIntTime(Integer intTime);

    List<SFCAward> selectByIntTimes(@Param("intTimes") List<Integer> intTimes);

    List<SFCAward> selectByIntTimeAndLineId(@Param("intTime") Integer intTime, @Param("lineId") Integer lineId,
                                      @Param("pm") Integer pm, @Param("playType") Integer playType);
}