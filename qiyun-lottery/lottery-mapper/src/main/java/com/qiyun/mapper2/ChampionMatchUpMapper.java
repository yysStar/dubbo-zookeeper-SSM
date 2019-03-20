package com.qiyun.mapper2;

import com.qiyun.model2.ChampionMatchUp;
import com.qiyun.model2.ChampionMatchUpExample;

import java.util.List;

public interface ChampionMatchUpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChampionMatchUp record);

    int insertSelective(ChampionMatchUp record);

    List<ChampionMatchUp> selectByExample(ChampionMatchUpExample example);

    ChampionMatchUp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChampionMatchUp record);

    int updateByPrimaryKey(ChampionMatchUp record);

    List<ChampionMatchUp> selectAll();
}