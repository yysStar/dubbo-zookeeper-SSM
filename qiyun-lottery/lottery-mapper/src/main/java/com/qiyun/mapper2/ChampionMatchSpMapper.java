package com.qiyun.mapper2;

import com.qiyun.model2.ChampionMatchSp;
import com.qiyun.model2.ChampionMatchSpExample;

import java.util.List;

public interface ChampionMatchSpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChampionMatchSp record);

    int insertSelective(ChampionMatchSp record);

    List<ChampionMatchSp> selectByExample(ChampionMatchSpExample example);

    ChampionMatchSp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChampionMatchSp record);

    int updateByPrimaryKey(ChampionMatchSp record);
}