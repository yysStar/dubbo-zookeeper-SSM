package com.qiyun.mapper2;

import com.qiyun.model.football.MatchAwardOfJQS;
import com.qiyun.model2.SportteryFootballJqsaward2;
import com.qiyun.model2.SportteryFootballJqsaward2Example;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SportteryFootballJqsaward2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballJqsaward2 record);

    int insertSelective(SportteryFootballJqsaward2 record);

    List<SportteryFootballJqsaward2> selectByExample(SportteryFootballJqsaward2Example example);

    SportteryFootballJqsaward2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballJqsaward2 record);

    int updateByPrimaryKey(SportteryFootballJqsaward2 record);

    List<MatchAwardOfJQS> selectByIntTime(Integer intTime);

    List<MatchAwardOfJQS> selectByIntTimes(@Param("intTimes") List<Integer> intTimes);

    List<Map> findjqInfo(String matchId);
}