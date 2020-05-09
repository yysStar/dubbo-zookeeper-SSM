package com.qiyun.mapper2;

import com.qiyun.model2.FootballLeague;
import com.qiyun.model2.FootballLeagueExample;
import java.util.List;

public interface FootballLeagueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballLeague record);

    int insertSelective(FootballLeague record);

    List<FootballLeague> selectByExample(FootballLeagueExample example);

    FootballLeague selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballLeague record);

    int updateByPrimaryKey(FootballLeague record);

    List<Integer>getNowDayLeague(String date);
}