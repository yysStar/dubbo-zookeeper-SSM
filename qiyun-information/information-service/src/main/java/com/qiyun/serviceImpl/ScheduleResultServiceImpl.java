package com.qiyun.serviceImpl;

import com.qiyun.mapper2.BasketballScheduleResultMapper;
import com.qiyun.mapper2.FootballScheduleResultMapper;
import com.qiyun.model2.BasketballScheduleResult;
import com.qiyun.model2.FootballScheduleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleResultServiceImpl {

    @Autowired
    private BasketballScheduleResultMapper basketballScheduleResultMapper;

    @Autowired
    private FootballScheduleResultMapper footballScheduleResultMapper;


    public BasketballScheduleResult getBasketballById(int id) {
        return basketballScheduleResultMapper.selectByPrimaryKey(id);
    }

    public int insertBasketball(BasketballScheduleResult scoreliveFootballNowday) {
        return basketballScheduleResultMapper.insertSelective(scoreliveFootballNowday);
    }

    public int updateBasketball(BasketballScheduleResult scoreliveFootballNowday) {
        return basketballScheduleResultMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }


    public FootballScheduleResult getFootballById(int id) {
        return footballScheduleResultMapper.selectByPrimaryKey(id);
    }

    public int insertFootball(FootballScheduleResult scoreliveFootballNowday) {
        return footballScheduleResultMapper.insertSelective(scoreliveFootballNowday);
    }

    public int updateFootball(FootballScheduleResult scoreliveFootballNowday) {
        return footballScheduleResultMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }
}
