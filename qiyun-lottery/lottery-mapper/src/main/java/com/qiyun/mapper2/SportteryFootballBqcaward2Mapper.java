package com.qiyun.mapper2;

import com.qiyun.model.football.MatchAwardOfBQC;
import com.qiyun.model2.SportteryFootballBqcaward2;
import com.qiyun.model2.SportteryFootballBqcaward2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportteryFootballBqcaward2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballBqcaward2 record);

    int insertSelective(SportteryFootballBqcaward2 record);

    List<SportteryFootballBqcaward2> selectByExample(SportteryFootballBqcaward2Example example);

    SportteryFootballBqcaward2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballBqcaward2 record);

    int updateByPrimaryKey(SportteryFootballBqcaward2 record);

    List<MatchAwardOfBQC> selectByIntTime(Integer intTime);

    List<MatchAwardOfBQC> selectByIntTimes(@Param("intTimes") List<Integer> intTimes);
}