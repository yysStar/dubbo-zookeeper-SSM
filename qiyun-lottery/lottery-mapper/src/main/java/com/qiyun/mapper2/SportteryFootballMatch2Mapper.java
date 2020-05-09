package com.qiyun.mapper2;

import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model2.SportteryFootballMatch2;
import com.qiyun.model2.SportteryFootballMatch2Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SportteryFootballMatch2Mapper {
    int countByExample(SportteryFootballMatch2Query example);

    int deleteByExample(SportteryFootballMatch2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballMatch2 record);

    int insertSelective(SportteryFootballMatch2 record);

    List<SportteryFootballMatch2> selectByExample(SportteryFootballMatch2Query example);

    SportteryFootballMatch2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SportteryFootballMatch2 record, @Param("example") SportteryFootballMatch2Query example);

    int updateByExample(@Param("record") SportteryFootballMatch2 record, @Param("example") SportteryFootballMatch2Query example);

    int updateByPrimaryKeySelective(SportteryFootballMatch2 record);

    int updateByPrimaryKey(SportteryFootballMatch2 record);

    List<Map<String, Object>> findFootballMixureInfo(int intTime);

    List<Map> findRqspfSp(Map map);

    List<Map> findSpfSp(Map map);

    List<Map> findbfInfo(String matchId);

    List<Map> findjqInfo(String matchId);

    List<Map> findbcInfo(String matchId);

    List<Map<String,Object>> findFootballMixureInfoByFocus(int intTime);

    List<Map> getSpfAward(Integer intTime, Integer lineId);

    List<Map> getRqspfAward(Integer intTime, Integer lineId);

    List<Map> getBqcAward(Integer intTime, Integer lineId);

    List<Map> getBfAward(Integer intTime, Integer lineId);

    List<Map> getJqsAward(Integer intTime, Integer lineId);

    List<SportteryFootballMatch2> findMatchByStatus(int status);

    List<FootBallMatch> selectMatchListByIntTime(@Param("intTimes") List<Integer> intTimes);

    SportteryFootballMatch2 getByIntTimeAndLineId(Integer intTime, Integer lineId);

}