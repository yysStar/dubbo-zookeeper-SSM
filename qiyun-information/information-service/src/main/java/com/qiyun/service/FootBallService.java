package com.qiyun.service;

import com.qiyun.common.Result;

import java.util.Map;

public interface FootBallService {
    Result getFootBallOpenResult(String pageSize);

    Map<String, Object> getOneFootBallColor(int intTime);

    Map<String, Object> getFootballScheduleResult(String date,int offset,int pageSize);
}
