package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SslTermBuilder extends AbstractLotteryTermBuider {


    /**
     * oldTerm: 当前期 oldOpenDateTime:当前期开奖时间 buildCount:生成后面的彩期数量 暂时没有考虑到过年的因素
     */
    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldOpenDateTime);
        List<LotteryTerm2> retList = new ArrayList<LotteryTerm2>();
        for (int i = 1; i <= buildCount; i++) {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            if (hour > 9 && hour < 21 || (hour == 21 && minute == 3)) {
                // 开始销售时间
                calendar.add(Calendar.MINUTE, -9);
                calendar.add(Calendar.SECOND, -30);
                Date startDateTime = calendar.getTime();

                // 关闭销售时间
                calendar.add(Calendar.MINUTE, 30);
                Date endDateTime = calendar.getTime();

                //休市处理
                endDateTime = getCloseTime(calendar);

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 1);
                Date terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 8);
                calendar.add(Calendar.SECOND, 30);
                Date openDateTime = calendar.getTime();

                // 开奖期次
                if (Integer.parseInt(oldTerm.substring(8, 10)) < 23) {
                    String sterm = "";
                    if ((Integer.parseInt(oldTerm.substring(8, 10)) + 1) > 9) {
                        sterm = "" + (Integer.parseInt(oldTerm.substring(8, 10)) + 1);
                    } else {
                        sterm = "0" + (Integer.parseInt(oldTerm.substring(8, 10)) + 1);
                    }
                    oldTerm = "" + DateTools.dateToString(calendar.getTime(), "yyyyMMdd") + sterm;
                } else {
                    oldTerm = DateTools.dateToString(calendar.getTime(), "yyyyMMdd");
                    oldTerm += "01";
                }

                LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.SSL,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
                retList.add(lotteryTerm);

            } else {
                if (hour <= 10) {
                    calendar.set(Calendar.HOUR_OF_DAY, 10);
                    calendar.set(Calendar.MINUTE, 3);
                    calendar.set(Calendar.SECOND, 30);
                } else {
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                    calendar.set(Calendar.HOUR_OF_DAY, 10);
                    calendar.set(Calendar.MINUTE, 3);
                    calendar.set(Calendar.SECOND, 30);
                }
            }
        }
        return retList;
    }


}
