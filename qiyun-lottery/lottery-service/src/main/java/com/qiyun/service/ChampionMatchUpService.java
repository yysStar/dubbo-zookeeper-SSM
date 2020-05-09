package com.qiyun.service;

import com.qiyun.model2.ChampionMatchUp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChampionMatchUpService {
    /**
     * 添加冠亚军赛事
     * @param championMatch
     * @return
     */
    int insertSelective(ChampionMatchUp championMatch);

    ChampionMatchUp getById(int id);

    List<ChampionMatchUp> getAll();

    int update(ChampionMatchUp championMatch);
}
