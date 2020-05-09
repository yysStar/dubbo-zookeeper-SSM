package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HnKlsfTermBuilder extends AbstractLotteryTermBuider {
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
            calendar.add(Calendar.MINUTE, -2);
            calendar.add(Calendar.SECOND, -10);
            startDateTime = calendar.getTime();

            // 开奖期次
            if (Integer.parseInt(oldTerm.substring(8, 11)) < 84) {
                // 关闭销售时间
                calendar.add(Calendar.MINUTE, 10);
                endDateTime = calendar.getTime();

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 2);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 0);
                calendar.add(Calendar.SECOND, 10);
                openDateTime = calendar.getTime();

                String sterm = "";
                if ((Integer.parseInt(oldTerm.substring(8, 11)) + 1) > 9) {
                    sterm = "0" + (Integer.parseInt(oldTerm.substring(8, 11)) + 1);
                } else {
                    sterm = "00" + (Integer.parseInt(oldTerm.substring(8, 11)) + 1);
                }
                oldTerm = "" + DateTools.dateToString(calendar.getTime(), "yyyyMMdd") + sterm;
            } else {

                // 关闭销售时间
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 8);
                calendar.set(Calendar.SECOND, 0);
                endDateTime = calendar.getTime();

                //休市处理
                endDateTime = getCloseTime(calendar);

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 2);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 0);
                calendar.add(Calendar.SECOND, 10);
                openDateTime = calendar.getTime();

                oldTerm = DateTools.dateToString(calendar.getTime(), "yyyyMMdd");
                oldTerm += "001";
            }

            LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.HN_KLSF, oldTerm, startDateTime, endDateTime, terminalEndDateTime, openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }
}
