package com.qiyun.mapper2;

import com.qiyun.model2.ChampionMatch;
import com.qiyun.model2.ChampionMatchExample;

import java.util.List;

public interface ChampionMatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChampionMatch record);

    int insertSelective(ChampionMatch record);

    List<ChampionMatch> selectByExample(ChampionMatchExample example);

    ChampionMatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChampionMatch record);

    int updateByPrimaryKey(ChampionMatch record);

    List<ChampionMatch> selectAll();
}