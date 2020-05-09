package com.qiyun.service;

import com.qiyun.model2.ScoreliveFootballNowday;

public interface ScoreLiveFootballNowDayService {

    ScoreliveFootballNowday getById(int id);

    int insert(ScoreliveFootballNowday scoreliveFootballNowday);

    int update(ScoreliveFootballNowday scoreliveFootballNowday);
}
