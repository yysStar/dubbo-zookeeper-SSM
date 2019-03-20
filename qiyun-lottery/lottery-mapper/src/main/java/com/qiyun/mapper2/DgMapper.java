package com.qiyun.mapper2;

import com.qiyun.model.LotteryTypeProps;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DgMapper {
    List<Map> findByLotteryTypeAndTerm(Integer lotteryType, String term);

    List<LotteryTypeProps> findPropsById(Integer lotteryType);

    Integer[] getLotteryTerm(Integer lotteryType);

    int getDealTime();

    void updateDealTime(Integer dealTime);

    double getMaxAddPrize();

    void updateMaxAddPrize(double maxAddPrize);

    void updateDG(int status);

    int getDGStatus();

    Integer getAutoCopyPlanStatusForLess5();

    Integer getAutoCopyPlanStatusForMore5();

    void setAutoCopyPlanStatusForLess5(int status);

    void setAutoCopyPlanStatusForMore5(int status);

    int getChaiPiaoCount();

    void updateLastCheckBingoTime(Date date);

    void updateLastReturnPrizeTime(Date date);
}
