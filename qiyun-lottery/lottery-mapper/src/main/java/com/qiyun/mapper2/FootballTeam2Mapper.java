package com.qiyun.mapper2;

import com.qiyun.model.FootballTeam;
import com.qiyun.model2.FootballTeam2;
import com.qiyun.model2.FootballTeam2Example;
import java.util.List;

public interface FootballTeam2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballTeam2 record);

    int insertSelective(FootballTeam2 record);

    List<FootballTeam2> selectByExample(FootballTeam2Example example);

    FootballTeam2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballTeam2 record);

    int updateByPrimaryKey(FootballTeam2 record);

    List<FootballTeam> findByStandardName(String name);
}