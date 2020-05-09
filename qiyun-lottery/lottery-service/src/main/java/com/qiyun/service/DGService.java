package com.qiyun.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public interface DGService {
    Map<String,Object> dg(Map<String, Object> dgMap);

    Integer getLotteryTerm(Integer lotteryType);

    int getDealTime();

    Map<String,Object> updateMatchDealTime(Integer dealTime);

    double getMaxAddPrize();

    Map<String,Object> updateMaxAddPrize(double maxAddPrize);

    void updateDG(int status);

    int getDGStatus();

    Map<String,Object> superLottoDG(Map<String, Object> map);

    Integer getAutoCopyPlanStatusForLess5();

    Integer getAutoCopyPlanStatusForMore5();

    void setAutoCopyPlanStatusForLess5(int status);

    void setAutoCopyPlanStatusForMore5(int status);

    int getChaiPiaoCount();

    void updateLastCheckBingoTime(Date date);

    void updateLastReturnPrizeTime(Date date);
}
