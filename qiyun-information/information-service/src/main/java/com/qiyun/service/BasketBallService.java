package com.qiyun.service;

import com.qiyun.common.Result;

import java.util.Map;

public interface BasketBallService {
    Result getBasketBallOpenResult(String pageSize);

    Map<String, Object> getOneBasketBallColor(int intTime);

    Map<String, Object> getBaskballScheduleResult(String date,int offset,int pageSize);
}
