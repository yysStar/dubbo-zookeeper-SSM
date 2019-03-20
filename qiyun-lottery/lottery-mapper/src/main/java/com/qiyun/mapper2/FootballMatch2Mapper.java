package com.qiyun.mapper2;

import com.qiyun.model.FootballMatch;
import com.qiyun.model2.FootballMatch2;
import com.qiyun.model2.FootballMatch2Example;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface FootballMatch2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballMatch2 record);

    int insertSelective(FootballMatch2 record);

    List<FootballMatch2> selectByExample(FootballMatch2Example example);

    FootballMatch2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballMatch2 record);

    int updateByPrimaryKey(FootballMatch2 record);

    List<FootballMatch> findByOddId(String oddId);

    List<FootballMatch> findFootballMatchIdByIntTimes(List<Integer> intTimes);
}