package com.qiyun.mapper2;

import com.qiyun.dto.ChampionPlanMatchDTO;
import com.qiyun.model2.ChampionPlanMatch;
import com.qiyun.model2.ChampionPlanMatchExample;
import java.util.List;

public interface ChampionPlanMatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChampionPlanMatch record);

    int insertSelective(ChampionPlanMatch record);

    List<ChampionPlanMatch> selectByExample(ChampionPlanMatchExample example);

    ChampionPlanMatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChampionPlanMatch record);

    int updateByPrimaryKey(ChampionPlanMatch record);

    List<ChampionPlanMatchDTO> selectMatchByPlanId(Integer planId);

    List<ChampionPlanMatchDTO> selectMatchUpByPlanId(Integer planId);

    List<ChampionPlanMatch> selectByTeamId(Integer teamId);

    List<ChampionPlanMatch> selectAll(Integer type);

    List<ChampionPlanMatch> selectByPlanId(Integer planId);
}