package com.qiyun.util;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.SportteryFootballMatch2;
import com.qiyun.model.basketball.BasketBallMatch;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LotteryUtils {


    public static boolean isNotWorkTime(LotteryType lotteryType,
                                        List<BasketBallMatch> list){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		int hour = c.get(Calendar.HOUR_OF_DAY);
//		int m = c.get(Calendar.MINUTE);
        String d = sdf.format(date);
        if(LotteryType.JCLQList.contains(lotteryType)) {
            switch(dayForWeek) {
                case 1: //周一出票时间为 9:10--23:45
                    if(("00:45:00".compareTo(d) <= 0
                            && "09:10:00".compareTo(d) >= 0)
                            || "23:45:00".compareTo(d) <= 0) {
                        return true;
                    }
                    return false;
                case 7: //周日出票时间为 9:10--次日0:45
                    if("00:45:00".compareTo(d) <= 0
                            && "09:10:00".compareTo(d) >= 0) {
                        return true;
                    }
                    return false;
                case 6: //周六出票时间为 9:10--次日0:45
                    if("09:10:00".compareTo(d) >= 0) {
                        return true;
                    }
                    return false;
                case 3:
                case 4:
                    /*if(list.size() > 0) { //NBA比赛期间 7：45开始投注 7:45--23:45
                        if("07:45:00".compareTo(d) >= 0
                                || "23:45:00".compareTo(d) <= 0) {
                            return true;
                        }
                        return false;
                    } else { //无NBA比赛 9:10--23:45
                        if("09:10:00".compareTo(d) >= 0
                                || "23:45:00".compareTo(d) <= 0) {
                            return true;
                        }
                        return false;
                    }*/
                    if("09:10:00".compareTo(d) >= 0
                            || "23:45:00".compareTo(d) <= 0) {
                        return true;
                    }
                    return false;
                default: //其他正常为 9:10--23:45
                    if("09:10:00".compareTo(d) >= 0
                            || "23:45:00".compareTo(d) <= 0) {
                        return true;
                    }
                    return false;
            }
        } else if(LotteryType.JCZQList.contains(lotteryType)) {
            switch(dayForWeek) {
                case 1: //周一出票时间为 9:10--23:45
                    if(("00:45:00".compareTo(d) <= 0
                            && "09:10:00".compareTo(d) >= 0)
                            || "23:45:00".compareTo(d) <= 0) {
                        return true;
                    }
                    return false;
                case 7: //周日出票时间为 9:10--次日0:45
                    if("00:45:00".compareTo(d) <= 0
                            && "09:10:00".compareTo(d) >= 0) {
                        return true;
                    }
                    return false;
                case 6: //周六出票时间为 9:10--次日0:45
                    if("09:10:00".compareTo(d) >= 0) {
                        return true;
                    }
                    return false;
                default: //其他正常为 9:10--23:45
                    if("09:10:00".compareTo(d) >= 0
                            || "23:45:00".compareTo(d) <= 0) {
                        return true;
                    }
                    return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isNotWorkTimeByWorldCup(List<SportteryFootballMatch2> list,int dealTime){
        Calendar startDGTime = Calendar.getInstance();
        Calendar dealDGTime = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        startDGTime.setTime(date);
        dealDGTime.setTime(date);
        dealDGTime.set(Calendar.HOUR_OF_DAY, 24);
        dealDGTime.set(Calendar.SECOND, 0);
        dealDGTime.set(Calendar.MINUTE, 0);
        dealDGTime.set(Calendar.MILLISECOND, 0);

        startDGTime.set(Calendar.HOUR_OF_DAY, 9);
        startDGTime.set(Calendar.SECOND, 0);
        startDGTime.set(Calendar.MINUTE, 0);
        startDGTime.set(Calendar.MILLISECOND, 0);
        if ("09:00:00".compareTo(sdf.format(date)) >= 0){
            //24点过后  9点前算前一天
            startDGTime.add(Calendar.DAY_OF_YEAR,-1);//日期减1天
            dealDGTime.add(Calendar.DAY_OF_YEAR,-1);//日期减1天
        }
        if (list!=null && list.size()>0){
            //有世界杯
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
            SportteryFootballMatch2 match = list.get(0);
            int matchTime = Integer.parseInt(sdf2.format(match.getMatchtime()));
            Integer inttime = match.getInttime();
            if (matchTime>inttime.intValue()){
                //最后场比赛超过当天24点
                dealDGTime.setTime(match.getMatchtime());
            }
        }
        dealDGTime.add(Calendar.MINUTE, -dealTime);

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start:"+simpleDateFormat.format(startDGTime.getTime()));
        System.out.println("deal:"+simpleDateFormat.format(dealDGTime.getTime()));
        System.out.println("now:"+simpleDateFormat.format(now.getTime()));

        if (now.after(startDGTime) && now.before(dealDGTime)) {
            return false;
        } else {
            return true;
        }
    }

    public static String getPassType(String passType) {
        String type = "";
        if (passType.equals("P2_1")){
            type = "2串1";
        }else if (passType.equals("P3_1")){
            type = "3串1";
        }else if (passType.equals("P4_1")){
            type = "4串1";
        }else if (passType.equals("P5_1")){
            type = "5串1";
        }else if (passType.equals("P6_1")){
            type = "6串1";
        }else if (passType.equals("P7_1")){
            type = "7串1";
        }else if (passType.equals("P8_1")){
            type = "8串1";
        }else if (passType.equals("P1")){
            type = "单关";
        }
        return type;
    }

    public static String getLineId(int lineId) {
        DecimalFormat decimalFormat = new DecimalFormat("000");
        String format = decimalFormat.format(lineId);
        return format;
    }

}
