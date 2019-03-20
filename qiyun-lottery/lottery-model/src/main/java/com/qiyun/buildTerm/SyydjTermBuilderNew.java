package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @源文件名： SyydjTermBuilder.java
 * @版本信息： v1.00
 * @生成日期： 2008-3-14
 * @作者: cloud
 * @描述: 时时乐期数生成器new 12分钟一期之前是15分钟一期,由52期调整为65期
 *      第1期销售时间从前日21时55分00秒至当日9时05分00秒，第65期销售时间从当日21时43分00秒至当日21时53分00秒；
 *      Copyright(C) 2008 huacai Ltd. All rights reserved.
 *
 *      update info: 10分钟一期之前是12分钟一期,由65期调整为78期
 *      			 第1期销售时间从前日21时56分00秒至当日9时05分00秒，第78期销售时间从当日21时45分30秒至当日21时55分00秒；
 *      update info: 10分钟一期,由78期调整为87期
 *      			 第1期销售时间从前日21时56分00秒至当日9时05分00秒，第78期销售时间从当日21时45分30秒至当日21时55分00秒；
 *      update date: 2011-10-9
 *      update author: sxh
 *
 */
public class SyydjTermBuilderNew extends AbstractLotteryTermBuider {

    int terminalDelay = 120; // s
    int openDelay = 30; // s
    int startSaleDelay = terminalDelay + openDelay; // 开奖时间前x分钟开售下期
    int stopSaleDelay = 600; // 销售期 10分钟

    /**
     * oldTerm: 当前期 oldOpenDateTime:当前期开奖时间 buildCount:生成后面的彩期数量 暂时没有考虑到过年的因素
     */
    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldOpenDateTime);
        List<LotteryTerm2> retList = new ArrayList<LotteryTerm2>();
        for (int i = 1; i <= buildCount; i++) {
            Date startDateTime = null;
            Date endDateTime = null;
            Date terminalEndDateTime = null;
            Date openDateTime = null;

            // 开始销售时间
            calendar.add(Calendar.SECOND, -startSaleDelay);
            startDateTime = calendar.getTime();

            // 开奖期次
            if (Integer.parseInt(oldTerm.substring(6, 8)) < 87) {
                // 关闭销售时间
                calendar.add(Calendar.SECOND, stopSaleDelay);
                endDateTime = calendar.getTime();

                // 切换销售时间
                calendar.add(Calendar.SECOND, terminalDelay);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.SECOND, openDelay);
                openDateTime = calendar.getTime();

                String sterm = "";
                if ((Integer.parseInt(oldTerm.substring(6, 8)) + 1) > 9) {
                    sterm = "" + (Integer.parseInt(oldTerm.substring(6, 8)) + 1);
                } else {
                    sterm = "0" + (Integer.parseInt(oldTerm.substring(6, 8)) + 1);
                }
                oldTerm = "" + DateTools.dateToString(calendar.getTime(), "yyMMdd") + sterm;
            } else {

                // 关闭销售时间
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 8);
                calendar.set(Calendar.MINUTE, 33); // 09:03 我们提前1分钟截止
                // 接口是提前1分钟截止 (官方9:05截止)
                calendar.set(Calendar.SECOND, 0);
                endDateTime = calendar.getTime();

                //休市处理
                endDateTime = getCloseTime(calendar);

                // 切换销售时间
                calendar.add(Calendar.SECOND, terminalDelay); // 09:05
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.SECOND, openDelay); // 截止后30秒出号
                openDateTime = calendar.getTime();

                oldTerm = DateTools.dateToString(calendar.getTime(), "yyMMdd");
                oldTerm += "01";
            }

            LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.SYYDJ,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }



}
