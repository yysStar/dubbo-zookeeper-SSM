package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JxdlcTermBuilder extends AbstractLotteryTermBuider {
    final int termNum=84;         //每天N期
    final int openInterval=600;   //每期前隔10分钟
    final int startSaleDelay=-120; //提前60秒开售下期
    final int stopSaleDelay=openInterval-120; //提前 120秒截止
    final String dateFormat="yyyyMMdd";
    final String startTime="09:10:00";
    final LotteryType lotteryType=LotteryType.JXDLC;


    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        return this.genBuild(lotteryType,startSaleDelay, stopSaleDelay, openInterval,
                termNum, startTime,dateFormat,oldTerm,oldOpenDateTime, buildCount);
    }
}
