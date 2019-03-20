package com.qiyun.service;

import com.qiyun.common.Result;

import java.util.Map;

public interface DayOneDanService {
    Map<String, Object> getDayOneDanByNumber(int number);

    Map<String, Object> like(String hostHolder, String account);

    Map<String, Object> disLike(String hostHolder, String account);

    Map<String, Object> getIsLike(String hostHolder, String account);

    Map<String, Object> createDayOneDan1(String playType, String matchId, String homeTeam, String guestTeam, String recommend, Double sp, String analyze, String author);

    Map<String, Object> createDayOneDan2(String playType, String matchId, String homeTeam, String guestTeam, String recommend, Double sp, String analyze, String author);

    Map<String, Object> shDOD(String sid);

    Map<String, Object> bhDOD(String sid);
}
