package com.qiyun.service;

import com.qiyun.common.Result;

import java.util.Map;

public interface LotteryTermService {
    Result getOpenResult();

    Map<String, Object> getDigitalColor(int type);

    Map<String, Object> getFrequencyColor(int type);

    Map<String, Object> getSportsColor();

    Map<String, Object> getTen(int type);

    Map<String, Object> getOneDigitalColor(int type,String term);

    Map<String, Object> setPL(int type, String result,String term);
}
