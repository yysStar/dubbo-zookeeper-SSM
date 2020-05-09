package com.qiyun.mapper2;

import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model2.SportteryBasketMatch2;
import com.qiyun.model2.SportteryBasketMatch2Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SportteryBasketMatch2Mapper {
    int countByExample(SportteryBasketMatch2Query example);

    int deleteByExample(SportteryBasketMatch2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketMatch2 record);

    int insertSelective(SportteryBasketMatch2 record);

    List<SportteryBasketMatch2> selectByExample(SportteryBasketMatch2Query example);

    SportteryBasketMatch2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SportteryBasketMatch2 record, @Param("example") SportteryBasketMatch2Query example);

    int updateByExample(@Param("record") SportteryBasketMatch2 record, @Param("example") SportteryBasketMatch2Query example);

    int updateByPrimaryKeySelective(SportteryBasketMatch2 record);

    int updateByPrimaryKey(SportteryBasketMatch2 record);

    List<Map> getByGroupLineId(Integer intTime);

    List<Map> getSfcAwardByPassModelAndIntTimeAndLineId(int i, Integer intTime, Integer lineId);

    List<Map> getBasketBallAwardByPassModelAndIntTimeAndLineIdAndPlayType(int i, Integer intTime, Integer lineId, int i1);

    List<BasketBallMatch> getNBAbyDate(int d1);

    List<Object> findForBbHTAwardByIntTime(@Param("intTimes") List<String> intTimes,
                                           @Param("passMode") Integer passMode);

    List<SportteryBasketMatch2> findMatchByStatus(int ordinal);

    List<Map> getByGroupLineIdAndFocus(Integer intTime);

    List<BasketBallMatch> selectMatchListByIntTime(@Param("intTimes") List<Integer> intTimes);
	
    SportteryBasketMatch2 getByIntTimeAndLineId(Integer intTime, Integer lineId);
}