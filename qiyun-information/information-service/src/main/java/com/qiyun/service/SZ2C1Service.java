package com.qiyun.service;

import com.qiyun.common.Result;

import java.util.Map;

public interface SZ2C1Service {
    Map<String, Object> shSZ2C1(String sid);

    Map<String, Object> bhSZ2C1(String sid);

    Result getSZ2C1ByNumber(int number);

    Map<String, Object> createSZ2C11(String matchId1, String homeTeam1, String guestTeam1, String recommend1, String matchId2, String homeTeam2, String guestTeam2, String recommend2, Integer multiple, Double amount, String bonus, String author);

    Map<String, Object> createSZ2C12(String matchId1, String homeTeam1, String guestTeam1, String recommend1, String matchId2, String homeTeam2, String guestTeam2, String recommend2, Integer multiple, Double amount, String bonus, String author);
}
