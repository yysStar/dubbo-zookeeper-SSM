package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;

import java.util.Date;
import java.util.List;

public class JLK3TermBuider extends AbstractLotteryTermBuider {
    final int termNum=87;         //每天87期
    final int openInterval=540;   //每期前隔9分钟
    final int startSaleDelay=-120; //提前60秒开售下期
    final int stopSaleDelay=openInterval-120; //提前 120秒截止
    final String dateFormat="yyMMdd";
    final String startTime="08:29:00";
    final LotteryType lotteryType=LotteryType.JL_K3;

    /**
     * oldTerm: 当前期 oldOpenDateTime:当前期开奖时间 buildCount:生成后面的彩期数量 暂时没有考虑到过年的因素
     */
    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        return this.genBuild(lotteryType,startSaleDelay, stopSaleDelay, openInterval,
                termNum, startTime,dateFormat,oldTerm,oldOpenDateTime, buildCount);
    }


}
