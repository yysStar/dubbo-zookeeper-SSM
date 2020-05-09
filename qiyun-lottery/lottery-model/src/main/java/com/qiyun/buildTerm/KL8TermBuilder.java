package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.util.LogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KL8TermBuilder extends AbstractLotteryTermBuider {

    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldOpenDateTime);
        List<LotteryTerm2> retList = new ArrayList<LotteryTerm2>();

        // 生成一天的彩期09:00--23:55 共179期
        // 下期开售整点开始
        // 投注开始时间提前60秒
        // 投注截止时间提前60秒
        // 开奖时间每期延后20秒

        Date startTime = null;
        Date endTime = null;
        Date nowTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            startTime = sdf.parse("9:00");
            endTime = sdf.parse("23:50");
        } catch (Exception e) {
            LogUtil.error(e);
        }

        for (int i = 1; i <= buildCount; i++) {
            Date startDateTime = null;
            Date endDateTime = null;
            Date terminalEndDateTime = null;
            Date openDateTime = null;

            // 开始销售时间
            calendar.add(Calendar.MINUTE, -1);
            calendar.add(Calendar.SECOND, -30);
            startDateTime = calendar.getTime();

            try {
                nowTime = sdf.parse(sdf.format(calendar.getTime()));
            } catch (Exception e) {
                LogUtil.error(e);
            }

            // 开奖期次
            if (nowTime.after(startTime) && nowTime.before(endTime)) {

                // 关闭销售时间
                calendar.add(Calendar.MINUTE, 5);
                calendar.add(Calendar.SECOND, 0);
                endDateTime = calendar.getTime();

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 1);
                calendar.add(Calendar.SECOND, 20);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 0);
                calendar.add(Calendar.SECOND, 10);
                openDateTime = calendar.getTime();

            } else {

                // 关闭销售时间
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 3);
                calendar.set(Calendar.SECOND, 40);
                endDateTime = calendar.getTime();

                //休市处理
                endDateTime = getCloseTime(calendar);

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 1);
                calendar.add(Calendar.SECOND, 20);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 0);
                calendar.add(Calendar.SECOND, 10);
                openDateTime = calendar.getTime();
            }

            oldTerm = String.valueOf(Integer.parseInt(oldTerm) + 1);

            LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.KL8, oldTerm, startDateTime, endDateTime, terminalEndDateTime, openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }
}
