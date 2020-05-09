package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;

import java.util.Date;
import java.util.List;

public class Hlj11x5TermBuilder extends AbstractLotteryTermBuider {
    final int termNum=88;         //每天N期
    final int openInterval=600;   //每期前隔10分钟
    final int startSaleDelay=-120; //提前60秒开售下期
    final int stopSaleDelay=openInterval-120; //提前 120秒截止
    final String dateFormat="yyyyMMdd";
    final String startTime="08:05:00";
    final LotteryType lotteryType=LotteryType.HLJ11X5;

    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        return this.genBuild(lotteryType,startSaleDelay, stopSaleDelay, openInterval,
                termNum, startTime,dateFormat,oldTerm,oldOpenDateTime, buildCount);
    }

}
