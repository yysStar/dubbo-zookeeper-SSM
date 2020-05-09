package com.qiyun.buildTerm;

import com.qiyun.tools.DateTools;

import java.util.Calendar;
import java.util.Date;

public class LotteryTermHelper {
    public static Date START_DATE = DateTools.StringToDate("2017-01-27", "yyyy-MM-dd");//休市开始时间
    public static Date CLOSE_DATE = DateTools.StringToDate("2017-02-03", "yyyy-MM-dd");//休市结束时间
    public static int CLOSE_DAYS = 7;//休市天数

    //是否休市，如休市返回true,其他返回false
    public static boolean hasCloseTime(Calendar calendar) {
        if(START_DATE.before(calendar.getTime()) && CLOSE_DATE.after(calendar.getTime())) {//休市处理
            return true;
        }
        return false;
    }
}
