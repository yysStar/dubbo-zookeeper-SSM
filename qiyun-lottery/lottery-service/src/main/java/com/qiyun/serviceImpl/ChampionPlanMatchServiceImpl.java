package com.qiyun.serviceImpl;

import com.qiyun.mapper2.ChampionPlanMatchMapper;
import com.qiyun.model2.ChampionPlanMatch;
import com.qiyun.service.ChampionPlanMatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("championPlanMatchService")
public class ChampionPlanMatchServiceImpl implements ChampionPlanMatchService {
    @Resource
    private ChampionPlanMatchMapper championPlanMatchMapper;

    public int insertSelective(ChampionPlanMatch championPlanMatch){
        return championPlanMatchMapper.insertSelective(championPlanMatch);
    }

    public List<ChampionPlanMatch> getByTeamId(int teamId) {
        return championPlanMatchMapper.selectByTeamId(teamId);
    }

    public int update(ChampionPlanMatch planMatch) {
        return championPlanMatchMapper.updateByPrimaryKeySelective(planMatch);
    }

    public List<ChampionPlanMatch> getAll(Integer type) {
        return championPlanMatchMapper.selectAll(type);
    }

    public List<ChampionPlanMatch> getByPlanId(Integer planId) {
        return championPlanMatchMapper.selectByPlanId(planId);
    }
}
