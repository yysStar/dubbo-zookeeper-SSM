package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PokerK3TermBuilder extends AbstractLotteryTermBuider {
    //1.第一期开始时间 昨天22:01:00
    //2.10分钟1期,全天79期
    //3.开奖时间x 秒
    //4.出票商提前截止时间.
    //5.又比出票商提前截止多久

    int terminalDelay = 150; // 终端延迟时间 出票商提前120s 再提前30s
    int openDelay = 20; // 开奖延迟 20s
    int startSaleDelay = terminalDelay + openDelay; // 开奖时间前x分钟开售下期
    int stopSaleDelay = 10 * 60; // 销售期 10分钟

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
            if (Integer.parseInt(oldTerm.substring(oldTerm.length() - 2, oldTerm.length())) < 88) {
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
                if ((Integer.parseInt(oldTerm.substring(oldTerm.length() - 2, oldTerm.length())) + 1) > 9) {
                    sterm = "" + (Integer.parseInt(oldTerm.substring(oldTerm.length() - 2, oldTerm.length())) + 1);
                } else {
                    sterm = "0" + (Integer.parseInt(oldTerm.substring(oldTerm.length() - 2, oldTerm.length())) + 1);
                }
                oldTerm = DateTools.dateToString(calendar.getTime(), "yyMMdd") + sterm;
            } else {

                // 关闭销售时间
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 8);
                calendar.set(Calendar.MINUTE, 27); // 08:57:50 我们提前30s截止
                // 接口是提前120s截止(09:00:20)
                calendar.set(Calendar.SECOND, 50);
                endDateTime = calendar.getTime();

                //休市处理
                endDateTime = getCloseTime(calendar);

                // 切换销售时间
                calendar.add(Calendar.SECOND, terminalDelay);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.SECOND, openDelay); // 截止后20s出号
                openDateTime = calendar.getTime();

                oldTerm = DateTools.dateToString(calendar.getTime(), "yyMMdd");

                oldTerm += "01";
            }

            LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.POKER3,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }
}
