package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.*;

public class QlcTermBuilder extends AbstractLotteryTermBuider {

    private static HashMap<Integer, Integer> nextOpenDates = null;

    static {
        nextOpenDates = new HashMap<Integer, Integer>();
        nextOpenDates.put(2, 2);
        nextOpenDates.put(4, 2);
        nextOpenDates.put(6, 3);
    }

    /**
     * oldTerm: 当前期 oldOpenDateTime:当前期开奖时间 buildCount:生成后面的彩期数量 暂时没有考虑到过年的因素
     */
    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldOpenDateTime);
        List<LotteryTerm2> retList = new ArrayList<LotteryTerm2>();
        for (int i = 1; i <= buildCount; i++) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int nextDays = nextOpenDates.get(dayOfWeek);
            // 开始销售时间
            calendar.set(Calendar.HOUR_OF_DAY, 19);
            calendar.set(Calendar.MINUTE, 45);
            Date startDateTime = calendar.getTime();

            // 关闭销售时间
            calendar.add(Calendar.DAY_OF_MONTH, nextDays);
            calendar.set(Calendar.HOUR_OF_DAY, 19);
            calendar.set(Calendar.MINUTE, 45);
            Date endDateTime = calendar.getTime();

            //休市处理
            endDateTime = getCloseTime(calendar,nextOpenDates);

            calendar.set(Calendar.HOUR_OF_DAY, 20);
            calendar.set(Calendar.MINUTE, 00);
            Date terminalEndDateTime = calendar.getTime();

            // 开奖时间
            calendar.set(Calendar.HOUR_OF_DAY, 21);
            calendar.set(Calendar.MINUTE, 30);
            Date openDateTime = calendar.getTime();

            int yearLen = 4;
            String termYear = oldTerm.substring(0, yearLen);
            String yearStr = DateTools.dateToString(openDateTime, "yyyy");
            if (termYear.equals(yearStr)) {
                oldTerm = "" + (Integer.parseInt(oldTerm) + 1);
            } else {
                oldTerm = yearStr + "001";
            }

            LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.QLC,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }


}
