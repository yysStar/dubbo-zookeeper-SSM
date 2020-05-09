package com.qiyun.service;

import com.qiyun.dto.*;

import java.util.List;
import java.util.Map;

public interface ScoreLiveService {

    List<BasketballLiveExplain0> getBasketballLive(String xml);

    Map<String, Object> getFootballLive(String id);

    List<ScoreliveFootballNowTimeDTO> getFootballNowTime(String xml);

    Map<String, Object> getFootballNowDay(String xml,int offset,int pageSize);

    List<ScoreliveBasketBallNowTimeDTO> getBasketballballNowTime(String xml);

    Map<String, Object> getBasketballballNowDay(String xml,int offset,int pageSize);

    Map<String, Object> getFootballMatch(int offset,int pageSize,int type);

}
