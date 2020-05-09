package com.qiyun.service.Impl;

import com.qiyun.mapper2.ChampionMatchUpMapper;
import com.qiyun.model2.ChampionMatchUp;
import com.qiyun.service.ChampionMatchUpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("championMatchUpService")
public class ChampionMatchUpServiceImpl implements ChampionMatchUpService {
    @Resource
    private ChampionMatchUpMapper championMatchUpMapper;

    public int insertSelective(ChampionMatchUp championMatch) {
        return championMatchUpMapper.insertSelective(championMatch);
    }

    public ChampionMatchUp getById(int id) {
        return championMatchUpMapper.selectByPrimaryKey(id);
    }

    public List<ChampionMatchUp> getAll() {
        return championMatchUpMapper.selectAll();
    }

    public int update(ChampionMatchUp championMatch) {
        return championMatchUpMapper.updateByPrimaryKeySelective(championMatch);
    }
}
