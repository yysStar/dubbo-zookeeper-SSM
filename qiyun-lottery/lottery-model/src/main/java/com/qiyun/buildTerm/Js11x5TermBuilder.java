package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Js11x5TermBuilder extends AbstractLotteryTermBuider {
    final int termNum=82;         //每天N期
    final int openInterval=600;   //每期前隔10分钟
    final int startSaleDelay=-180; //提前60秒开售下期
    final int stopSaleDelay=openInterval-180; //提前 120秒截止
    final String dateFormat="yyMMdd";
    final String startTime="08:36:10";
    final LotteryType lotteryType=LotteryType.JS11X5;

    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        return this.genBuild(lotteryType,startSaleDelay, stopSaleDelay, openInterval,
                termNum, startTime,dateFormat,oldTerm,oldOpenDateTime, buildCount);
    }
}
