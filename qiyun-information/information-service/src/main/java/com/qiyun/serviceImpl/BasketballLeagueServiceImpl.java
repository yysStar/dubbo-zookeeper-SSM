package com.qiyun.serviceImpl;

import com.qiyun.mapper2.BasketballLeagueMapper;
import com.qiyun.mapper2.BasketballLineupMapper;
import com.qiyun.model2.BasketballLeague;
import com.qiyun.model2.BasketballLineup;
import com.qiyun.model2.FootballEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketballLeagueServiceImpl {


    @Autowired
    private BasketballLeagueMapper basketballLeagueMapper;

    @Autowired
    private BasketballLineupMapper basketballLineupMapper;

    public BasketballLeague getById(int id) {
        return basketballLeagueMapper.selectByPrimaryKey(id);
    }

    public int insert(BasketballLeague footballTeam2) {
        return basketballLeagueMapper.insertSelective(footballTeam2);
    }

    public int update(BasketballLeague scoreliveFootballNowday) {
        return basketballLeagueMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }

    /**
     * 篮球赛前阵容、伤停、预测、赛前简报
     * @param id
     * @return
     */
    public BasketballLineup getById2(int id) {
        return basketballLineupMapper.selectByPrimaryKey(id);
    }

    public int insert2(BasketballLineup footballTeam2) {
        return basketballLineupMapper.insertSelective(footballTeam2);
    }

    public int update2(BasketballLineup scoreliveFootballNowday) {
        return basketballLineupMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }

}
