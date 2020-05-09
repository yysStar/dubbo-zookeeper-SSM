package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;

import java.util.Date;
import java.util.List;

public class CqKlsfTermBuilder extends AbstractLotteryTermBuider {
    final int termNum=97;         //每天N期
    final int breakNum=13;        //从13期开始断层（非间隔10分钟开奖）
    final int openInterval=600;   //每期前隔10分钟
    final int startSaleDelay=-120; //提前120秒开售下期
    final int stopSaleDelay=openInterval-120; //提前 120秒截止
    final String dateFormat="yyyyMMdd";
    final String breakTime="10:02:00";        //断层后首期开奖时间
    final LotteryType lotteryType=LotteryType.CQ_KLSF;

    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        return this.genBuild2(lotteryType,startSaleDelay, stopSaleDelay, openInterval,
                termNum,breakNum, breakTime,dateFormat,oldTerm,oldOpenDateTime, buildCount);
    }



}
