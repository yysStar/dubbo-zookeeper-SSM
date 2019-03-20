package com.qiyun.mapper2;

import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.football.MatchAwardOfRQSPF;
import com.qiyun.model2.SportteryFootballRqspfaward2;
import com.qiyun.model2.SportteryFootballRqspfaward2Example;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface SportteryFootballRqspfaward2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballRqspfaward2 record);

    int insertSelective(SportteryFootballRqspfaward2 record);

    List<SportteryFootballRqspfaward2> selectByExample(SportteryFootballRqspfaward2Example example);

    SportteryFootballRqspfaward2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballRqspfaward2 record);

    int updateByPrimaryKey(SportteryFootballRqspfaward2 record);

    List<MatchAwardOfRQSPF> selectByIntTime(Integer intTime);

    List<MatchAwardOfRQSPF> selectByIntTimes(@Param("intTimes") List<Integer> intTimes);

    List<MatchAwardOfRQSPF> selectAllAwardGroupByMatchId(@Param("matchIdList") List<Integer> matchIdList,
                                                         @Param("passMode") int passMode);
}