package com.qiyun.mapper2;

import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.football.MatchAwardOfRQSPF;
import com.qiyun.model.football.MatchAwardOfSPF;
import com.qiyun.model2.SportteryFootballSpfaward2;
import com.qiyun.model2.SportteryFootballSpfaward2Example;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface SportteryFootballSpfaward2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballSpfaward2 record);

    int insertSelective(SportteryFootballSpfaward2 record);

    List<SportteryFootballSpfaward2> selectByExample(SportteryFootballSpfaward2Example example);

    SportteryFootballSpfaward2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballSpfaward2 record);

    int updateByPrimaryKey(SportteryFootballSpfaward2 record);

    List<MatchAwardOfSPF> selectByIntTime(Integer intTime);

    List<MatchAwardOfSPF> selectByIntTimes(@Param("intTimes") List<Integer> intTimes);

    List<MatchAwardOfSPF> selectAllAwardGroupByMatchId(@Param("matchIdList") List<Integer> matchIdList,
                                                       @Param("passMode") int passMode);
}