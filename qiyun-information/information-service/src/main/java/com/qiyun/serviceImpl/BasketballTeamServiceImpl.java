package com.qiyun.serviceImpl;

import com.qiyun.mapper2.BasketballLineupMapper;
import com.qiyun.mapper2.BasketballTeam2Mapper;
import com.qiyun.mapper2.BasketballTeamRankMapper;
import com.qiyun.mapper2.FootballTeam2Mapper;
import com.qiyun.model2.BasketballLineup;
import com.qiyun.model2.BasketballTeam2;
import com.qiyun.model2.BasketballTeamRank;
import com.qiyun.model2.FootballTeam2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketballTeamServiceImpl {

    @Autowired
    private BasketballTeam2Mapper basketballTeam2Mapper;

    @Autowired
    private BasketballTeamRankMapper basketballTeamRankMapper;



    public BasketballTeam2 getById(int id) {
        return basketballTeam2Mapper.selectByPrimaryKey(id);
    }

    public int insert(BasketballTeam2 footballTeam2) {
        return basketballTeam2Mapper.insertSelective(footballTeam2);
    }

    public int update(BasketballTeam2 scoreliveFootballNowday) {
        return basketballTeam2Mapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }

    public BasketballTeamRank getBasketballRankById(String id) {
        return basketballTeamRankMapper.selectByPrimaryKey(id);
    }

    public int insert(BasketballTeamRank footballTeam2) {
        return basketballTeamRankMapper.insertSelective(footballTeam2);
    }

    public int update(BasketballTeamRank scoreliveFootballNowday) {
        return basketballTeamRankMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }

}
