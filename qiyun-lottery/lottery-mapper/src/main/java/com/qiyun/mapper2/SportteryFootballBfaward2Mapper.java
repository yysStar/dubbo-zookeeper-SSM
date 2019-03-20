package com.qiyun.mapper2;

import com.qiyun.model.football.MatchAwardOfBF;
import com.qiyun.model2.SportteryFootballBfaward2;
import com.qiyun.model2.SportteryFootballBfaward2Example;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SportteryFootballBfaward2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballBfaward2 record);

    int insertSelective(SportteryFootballBfaward2 record);

    List<SportteryFootballBfaward2> selectByExample(SportteryFootballBfaward2Example example);

    SportteryFootballBfaward2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballBfaward2 record);

    int updateByPrimaryKey(SportteryFootballBfaward2 record);

    List<MatchAwardOfBF> selectByIntTime(Integer intTime);

    List<MatchAwardOfBF> selectByIntTimes(@Param("intTimes") List<Integer> intTimes);

    List<Map> findbfInfo(String matchId);
}