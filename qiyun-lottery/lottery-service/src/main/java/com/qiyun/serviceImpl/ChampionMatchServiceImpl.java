package com.qiyun.serviceImpl;

import com.qiyun.mapper2.ChampionMatchMapper;
import com.qiyun.model2.ChampionMatch;
import com.qiyun.service.ChampionMatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("championMatchService")
public class ChampionMatchServiceImpl implements ChampionMatchService {
    @Resource
    private ChampionMatchMapper championMatchMapper;

    public int insertSelective(ChampionMatch championMatch){
        return championMatchMapper.insertSelective(championMatch);
    }

    public ChampionMatch getById(int id) {
        return championMatchMapper.selectByPrimaryKey(id);
    }

    public List<ChampionMatch> getAll() {
        return championMatchMapper.selectAll();
    }

    public int update(ChampionMatch championMatch) {
        return championMatchMapper.updateByPrimaryKeySelective(championMatch);
    }
}
