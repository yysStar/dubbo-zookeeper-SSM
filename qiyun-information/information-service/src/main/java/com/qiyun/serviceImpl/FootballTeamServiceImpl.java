package com.qiyun.serviceImpl;

import com.qiyun.mapper2.FootballTeam2Mapper;
import com.qiyun.model2.FootballTeam2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballTeamServiceImpl {

    @Autowired
    private FootballTeam2Mapper footballTeam2Mapper;

    public FootballTeam2 getById(int id) {
        return footballTeam2Mapper.selectByPrimaryKey(id);
    }

    public int insert(FootballTeam2 footballTeam2) {
        return footballTeam2Mapper.insertSelective(footballTeam2);
    }

    public int update(FootballTeam2 scoreliveFootballNowday) {
        return footballTeam2Mapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }

}
