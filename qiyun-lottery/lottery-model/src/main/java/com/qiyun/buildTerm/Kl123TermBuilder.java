package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Kl123TermBuilder extends AbstractLotteryTermBuider {
    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldOpenDateTime);
        List<LotteryTerm2> retList = new ArrayList<LotteryTerm2>();
        for (int i = 1; i <= buildCount; i++) {
            Date startDateTime = null;
            Date endDateTime = null;
            Date terminalEndDateTime = null;
            Date openDateTime = null;

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            if (!(hour == 21 && minute == 45)) {
                // 开始销售时间
                calendar.add(Calendar.MINUTE, -3);
                calendar.add(Calendar.SECOND, -30);
                startDateTime = calendar.getTime();

                // 关闭销售时间
                calendar.add(Calendar.MINUTE, 10);
                endDateTime = calendar.getTime();

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 3);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 0);
                calendar.add(Calendar.SECOND, 30);
                openDateTime = calendar.getTime();

                oldTerm = "" + (Integer.parseInt(oldTerm) + 1);

            } else {

                // 开始销售时间
                calendar.add(Calendar.MINUTE, -3);
                calendar.add(Calendar.SECOND, -30);
                startDateTime = calendar.getTime();

                // 关闭销售时间
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 52);
                // calendar.set(Calendar.SECOND, 0);
                endDateTime = calendar.getTime();

                //休市处理
                endDateTime = getCloseTime(calendar);

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 3);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 0);
                calendar.add(Calendar.SECOND, 30);
                openDateTime = calendar.getTime();

                oldTerm = "" + (Integer.parseInt(oldTerm) + 1);
            }

            LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.KL123,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }

}
