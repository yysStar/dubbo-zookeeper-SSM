package com.qiyun.serviceImpl;

import com.qiyun.mapper2.BasketballBase2Mapper;
import com.qiyun.mapper2.BasketballTeam2Mapper;
import com.qiyun.model.basketball.BasketBallTeam;
import com.qiyun.model2.BasketballTeam2;
import com.qiyun.service.BasketTeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("basketTeamService")
public class BasketTeamServiceImpl implements BasketTeamService {
    @Resource
    private BasketballTeam2Mapper basketballTeam2Mapper;

    public BasketBallTeam getTeamInfoByFullName(String name) {
        return basketballTeam2Mapper.selectByFullName(name);
    }

    public void saveIfChange(BasketBallTeam homeTeam) {
        BasketballTeam2 team = BasketballTeam2.builder().content(homeTeam.getContent())
                .fullTeamName(homeTeam.getFullTeamName()).mark(homeTeam.getMark())
                .shortTeamName(homeTeam.getShortTeamName()).build();
        if(homeTeam.getId() == null){
            basketballTeam2Mapper.insertSelective(team);
        }else{
            team.setId(homeTeam.getId());
            basketballTeam2Mapper.updateByPrimaryKeySelective(team);
        }
    }
}
