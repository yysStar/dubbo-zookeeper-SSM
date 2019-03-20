package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;
import com.qiyun.utils.StringTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GxklsfTermBuilder extends AbstractLotteryTermBuider {

    int terminalDelay = 60; // sec
    int openDelay = 90; // sec
    int startSaleDelay = terminalDelay + openDelay; // 开奖时间前x sec开售下期

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

            if (!(oldTerm.substring(7).equals("50"))) {
                // 开始销售时间
                calendar.add(Calendar.SECOND, -startSaleDelay);
                startDateTime = calendar.getTime();

                // 关闭销售时间
                calendar.add(Calendar.MINUTE, 15);
                endDateTime = calendar.getTime();

                // 切换销售时间
                calendar.add(Calendar.SECOND, terminalDelay);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.SECOND, openDelay);
                openDateTime = calendar.getTime();

                oldTerm = "" + (Integer.parseInt(oldTerm) + 1);

            } else {
                // 开始销售时间
                calendar.add(Calendar.SECOND, -startSaleDelay);
                startDateTime = calendar.getTime();

                // 关闭销售时间
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 9);
                calendar.set(Calendar.SECOND, 0);
                endDateTime = calendar.getTime();

                //休市处理
                endDateTime = getCloseTime(calendar);

                // 切换销售时间
                calendar.add(Calendar.SECOND, terminalDelay);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.SECOND, openDelay);
                openDateTime = calendar.getTime();

                if(CLOSE_DATE.before(calendar.getTime())) {
                    oldTerm = DateTools.dateToString(calendar.getTime(), "yyyy")
                            + StringTools.getStringFillZero((calendar.get(Calendar.DAY_OF_YEAR) - 7) + "", 3);
                } else {
                    oldTerm = DateTools.dateToString(calendar.getTime(), "yyyy")
                            + StringTools.getStringFillZero((calendar.get(Calendar.DAY_OF_YEAR)) + "", 3);
                }
                oldTerm += "01";

            }

            LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.GXKLSF,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }

}
