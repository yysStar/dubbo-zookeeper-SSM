package com.qiyun.service;

import com.qiyun.model2.ChampionPlanMatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChampionPlanMatchService {
    int insertSelective(ChampionPlanMatch championPlanMatch);

    List<ChampionPlanMatch> getByTeamId(int teamId);

    int update(ChampionPlanMatch planMatch);

    List<ChampionPlanMatch> getAll(Integer type);

    List<ChampionPlanMatch> getByPlanId(Integer id);
}
