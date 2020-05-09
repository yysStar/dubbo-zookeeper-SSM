package com.qiyun.service;

import com.qiyun.model2.ChampionMatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChampionMatchService {
    /**
     * 添加冠军赛事
     * @param championMatch
     * @return
     */
    int insertSelective(ChampionMatch championMatch);

    ChampionMatch getById(int id);

    List<ChampionMatch> getAll();

    int update(ChampionMatch championMatch);
}
