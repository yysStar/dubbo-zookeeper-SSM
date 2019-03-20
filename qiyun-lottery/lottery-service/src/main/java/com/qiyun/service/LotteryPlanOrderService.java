package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.LotteryPlanOrder2DTO;
import com.qiyun.model2.LotteryPlanOrder2;

import java.util.Map;

public interface LotteryPlanOrderService {

    Result insert(LotteryPlanOrder2DTO lotteryPlanOrder2DTO);

    Result getPlanForUserCenter(int planType,Integer lotteryType, Integer planStatus, Integer winStatus, int page, int pageSize,String account);

    Result getTRAmount(int planType,int lotteryType, int planStatus, int winStatus, String account);

    Result getZJAmount(int planType,int lotteryType, int planStatus, int winStatus, String account);

    double getZJAmountByAccount(String account);

    int getZJCountByAccount(String account);

    int getTZCountByAccount(String account);

    LotteryPlanOrder2 getByPlanNo(int planNo);

    Map<String,Object> getEvenTheRedList(int page, int pageSize, int day);

    Map<String,Object> getBetList(int page, int pageSize, int day);

    Map<String,Object> getAShortRed(int page, int pageSize, int day);

    void update(LotteryPlanOrder2 lotteryPlanOrder);

    Double getTotalAddPrizeByDay(String account);
}
