package com.qiyun.serviceImpl;

import com.qiyun.mapper2.ScoreliveFootballNowdayMapper;
import com.qiyun.model2.ScoreliveFootballNowday;
import com.qiyun.service.ScoreLiveFootballNowDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreLiveFootballNowDayServiceImpl implements ScoreLiveFootballNowDayService {


    @Autowired
    private ScoreliveFootballNowdayMapper scoreliveFootballNowdayMapper;

    public ScoreliveFootballNowday getById(int id) {
        return scoreliveFootballNowdayMapper.selectByPrimaryKey(id);
    }

    public int insert(ScoreliveFootballNowday scoreliveFootballNowday) {
        return scoreliveFootballNowdayMapper.insertSelective(scoreliveFootballNowday);
    }

    public int update(ScoreliveFootballNowday scoreliveFootballNowday) {
        return scoreliveFootballNowdayMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }


}
