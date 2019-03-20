package com.qiyun.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    private static Logger log = LoggerFactory.getLogger(DateUtil.class);
    private static final SimpleDateFormat format0 = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat format3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final SimpleDateFormat format4 = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss");
    private static final SimpleDateFormat format5 = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat format6 = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat format7 = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat format8 = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 获取两个日期字符串之间的日期集合
     * @param startTime:String
     * @param endTime:String
     * @return list:yyyy-MM-dd
     */
    public static List<String> getBetweenDate(String startTime, String endTime){
        // 声明保存日期集合
        List<String> list = new ArrayList<String>();
        try {
            // 转化成日期类型
            Date startDate = format8.parse(startTime);
            Date endDate = format8.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime()){
                // 把日期添加到集合
                list.add(format8.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static  String getWeekForDateByIntTime(String intTime) {
        try {
            Date parse = format1.parse(intTime);
            String weekForDate = getWeekForDate(parse);
            return weekForDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static  String getWeekForDate(Date date) {
        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * yyyy/MM/dd
     * @param date
     * @return
     */
    public static String dateToString7(Date date){
        String timestamp = format7.format(date);
        return timestamp;
    }

    /**
     * yyyy-MM-dd
     * @param date
     * @return
     */
    public static String dateToString6(Date date){
        String timestamp = format6.format(date);
        return timestamp;
    }

    public static Date StringToDate6(String timestamp){
        Date date = null;
        try {
            date = format6.parse(timestamp);
        } catch (Exception e){
            log.info("---------------时间转换错误：" + timestamp + e);
        }
        return date;
    }

    /**
     * HH:mm
     * @param date
     * @return
     */
    public static String dateToString5(Date date){
        String timestamp = format5.format(date);
        return timestamp;
    }

    /**
     * yyyyMMddHHmmss
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        String timestamp = format0.format(date);
        return timestamp;
    }

    /**
     * yyyyMMdd
     * @param timestamp
     * @return
     */
    public static Date StringToDate1(String timestamp){
        Date date = null;
        try {
            date = format0.parse(timestamp);
        } catch (Exception e){
            log.info("---------------时间转换错误：" + timestamp + e);
        }
        return date;
    }


    /**
     * yyyyMMdd
     * @param date
     * @return
     */
    public static String dateToStringg(Date date){
        String timestamp = format1.format(date);
        return timestamp;
    }

    /**
     * yyyyMMdd
     * @param timestamp
     * @return
     */
    public static Date StringToDate(String timestamp){
        Date date = null;
        try {
            date = format1.parse(timestamp);
        } catch (Exception e){
            log.info("---------------时间转换错误：" + timestamp + e);
        }
        return date;
    }

    /**
     * 获取当前日期int型
     * @return
     */
    public static int getIntTime(){
        String now = format1.format(new Date());
        return Integer.parseInt(now);
    }

    /**
     * 获取当前日期int型
     * @return
     */
    public static int getIntTime2(Date date){
        String now = format1.format(date);
        return Integer.parseInt(now);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * @param timestamp
     * @return
     */
    public static Date StringToDate2(String timestamp){
        Date date = null;
        try {
            date = format2.parse(timestamp);
        } catch (Exception e){
            log.info("---------------时间转换错误：" + timestamp + e);
        }
        return date;
    }

    /**
     * yyyyMMddHHmmss
     * @param date
     * @return
     */
    public static String dateToString2(Date date){
        String timestamp = format2.format(date);
        return timestamp;
    }

    /**
     * yyyy,MM,dd,HH,mm,ss
     * @param timestamp
     * @return
     */
    public static Date StringToDate4(String timestamp){
        Date date = null;
        try {
            date = format4.parse(timestamp);
        } catch (Exception e){
            log.info("---------------时间转换错误：" + timestamp + e);
        }
        return date;
    }

    /**
     * yyyy,MM,dd,HH,mm,ss
     * @param date
     * @return
     */
    public static String dateToString4(Date date){
        String timestamp = format4.format(date);
        return timestamp;
    }

    /**
     * 获取日期对应星期
     * @param date
     * @return
     */
    public static int getWeekOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date != null){
            calendar.setTime(date);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if(week > 1) {
                return week - 1;
            } else {
                return 7;
            }
        } else {
            return 0;
        }
    }
    public static String ifNull(String param){
        if (param==null){
            param="";
            return param;
        }
        return param;
    }


    /**
     * yyyy/MM/dd HH:mm:ss
     * @param timestamp
     * @return
     */
    public static Date StringToDate3(String timestamp){
        Date date = null;
        try {
            date = format3.parse(timestamp);
        } catch (Exception e){
            log.info("---------------时间转换错误：" + timestamp + e);
        }
        return date;
    }



    /**
     * 是否为可寻票时间
     * @param createDateTime
     * @param dealDateTime
     * @return
     */
    public static boolean isFindTime(Date createDateTime, Date dealDateTime){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createDateTime);
        calendar.add(calendar.MINUTE, 5);//下单5分钟之内
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dealDateTime);
        calendar2.add(calendar.MINUTE, -10);//截止前10分钟
        if(date.before(calendar.getTime()) && date.before(calendar2.getTime())){
            return true;
        }
        return false;
    }

    /**
     * 判断红包是否过期
     * @param createDateTime
     * @return
     */
    public static boolean isOverdue(Date createDateTime){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createDateTime);
        //获取红包过期时间
        calendar.add(calendar.HOUR_OF_DAY, 24);
        if(date.before(calendar.getTime())){
            return false;
        }
        return true; //已过期
    }

    /**
     * 获取时间
     */
    public static String getNowDateYYYYMMDDHHMMSSSS() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        return sdf.format(date);

    }


    /*
	 * 获取的比赛时间+1分钟
	 */
    public static Date getDateFormat(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, 1);
        return c.getTime();
    }

    /*
     * 获取前一个月的时间
     */
    public static Date getBeforeOneMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

    /**
     * 判断日期是否和(today日期的差)相同
     *
     * @param date
     * @param dateNum
     * today日期的差 ;1表示明天,0表示今天,-1表示昨天,-2表示前天,以此类推
     * @return
     */
    public static boolean isToday4Num(final Date date, int dateNum) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        final Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DAY_OF_YEAR, dateNum);
        return org.apache.commons.lang.time.DateUtils.isSameDay(cal1, cal2);
    }

    /**
     * 去掉月份或天多余的0 ======2018-01-03 ===>  2018-1-3
     *    yyyy-MM-dd
     */
    public static String simplify2(String date){
        int index1 =date.indexOf("-");
        int index2 =date.lastIndexOf("-");
        int month;
        int day;
        int year=Integer.parseInt(date.substring(0,index1));
        if(date.substring(index1+1,index1+2)=="0"){
            month=Integer.parseInt(date.substring(index1+2,index1+3));
        }else {
            month=Integer.parseInt(date.substring(index1+1,index1+3));
        }
        if(date.substring(index2+1,index2+2)=="0"){
            day=Integer.parseInt(date.substring(index2+2,index2+3));
        }else{
            day=Integer.parseInt(date.substring(index2+1,index2+3));
        }
        String date1=(year+"-"+month+"-"+day)+"";
        return  date1;
    }



    /**
     * 去掉月份或天多余的0 ======2018-01-03 ===>  2018-1-3
     *    yyyy/MM/dd HH:mm:ss
     */
    public static String simplify(String time){
        String[] split = time.split(" ");
        String date = split[0];
        int index1 =date.indexOf("/");
        int index2 =date.lastIndexOf("/");
        int month;
        int day;
        int year=Integer.parseInt(date.substring(0,index1));
        if(date.substring(index1+1,index1+2)=="0"){
            month=Integer.parseInt(date.substring(index1+2,index1+3));
        }else {
            month=Integer.parseInt(date.substring(index1+1,index1+3));
        }
        if(date.substring(index2+1,index2+2)=="0"){
            day=Integer.parseInt(date.substring(index2+2,index2+3));
        }else{
            day=Integer.parseInt(date.substring(index2+1,index2+3));
        }
        String date1=(year+"/"+month+"/"+day)+" "+split[1];
        return  date1;
    }


    /**
     * 去掉月份或天多余的0 ======2018-01-03 ===>  2018-1-3
     *    yyyy/MM/dd
     */
    public static String simplify3(String date){
        int index1 =date.indexOf("/");
        int index2 =date.lastIndexOf("/");
        int month;
        int day;
        int year=Integer.parseInt(date.substring(0,index1));
        if(date.substring(index1+1,index1+2)=="0"){
            month=Integer.parseInt(date.substring(index1+2,index1+3));
        }else {
            month=Integer.parseInt(date.substring(index1+1,index1+3));
        }
        if(date.substring(index2+1,index2+2)=="0"){
            day=Integer.parseInt(date.substring(index2+2,index2+3));
        }else{
            day=Integer.parseInt(date.substring(index2+1,index2+3));
        }
        String date1=(year+"/"+month+"/"+day)+"";
        return  date1;
    }
}
