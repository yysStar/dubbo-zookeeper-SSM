package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SscTerm120Builder extends AbstractLotteryTermBuider {

    final int termNum=120;         //每天N期
    final int breakNum1=23;
    final int breakNum2=96;
    final int openInterval1=600;   //每期间隔10分钟
    final int openInterval2=300;   //每期间隔5分钟
    final int startSaleDelay=-120; //提前120秒开售下期
    final int stopSaleDelay1=openInterval1-120; //提前 120秒截止
    final int stopSaleDelay2=openInterval2-120; //提前 120秒截止
    final String dateFormat="yyyyMMdd";
    final String breakTime="10:01:00";
    final LotteryType lotteryType=LotteryType.SSC;

    /**
     *
     */
    public List<LotteryTerm2> build(String oldTerm,Date oldOpenDateTime,int buildCount) {

        int openInterval;
        int stopSaleDelay;
        String sterm;
        int shortTerm;
        int termLength=oldTerm.length();
        int dateLength=dateFormat.length();
        int shortTermL=termLength-dateLength;
        String[] ts=breakTime.split(":");
        int h=Integer.parseInt(ts[0]);
        int m=Integer.parseInt(ts[1]);
        int s=Integer.parseInt(ts[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldOpenDateTime);
        List<LotteryTerm2> retList = new ArrayList<LotteryTerm2>();
        for (int i = 1; i <= buildCount; i++) {
            Date startDateTime = null;
            Date endDateTime = null;
            Date terminalEndDateTime = null;
            Date openDateTime = null;
            shortTerm =Integer.parseInt(oldTerm.substring(dateLength, termLength));
            // 开始销售时间
            calendar.add(Calendar.SECOND, startSaleDelay);
            startDateTime = calendar.getTime();
            calendar.add(Calendar.SECOND, -startSaleDelay);

            if(breakNum1<shortTerm && shortTerm<breakNum2){
                openInterval=openInterval1;
                stopSaleDelay=stopSaleDelay1;
            }
            else{
                openInterval=openInterval2;
                stopSaleDelay=stopSaleDelay2;
            }

            // 开奖期次
            if (breakNum1 == shortTerm) {
                calendar.set(Calendar.HOUR_OF_DAY, h);
                calendar.set(Calendar.MINUTE, m);
                calendar.set(Calendar.SECOND, s);
                // 回到假定时间间隔的上一期
                calendar.add(Calendar.SECOND, -openInterval);
            }

            if (termNum == shortTerm) {
                // 休市处理
                endDateTime = getCloseTime(calendar);
                // 初始化
                shortTerm=0;
            }

            // 截止销售时间
            calendar.add(Calendar.SECOND, stopSaleDelay);
            endDateTime = calendar.getTime();
            calendar.add(Calendar.SECOND, -stopSaleDelay);

            // 开奖时间、截止出票时间
            calendar.add(Calendar.SECOND, openInterval);
            openDateTime = calendar.getTime();
            terminalEndDateTime = calendar.getTime();

            sterm=(shortTerm + 1)+"";
            while(sterm.length()<shortTermL){
                sterm="0"+sterm;
            }
            oldTerm = DateTools.dateToString(calendar.getTime(), dateFormat) + sterm;
            LotteryTerm2 lotteryTerm = createLotteryTerm(lotteryType,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }



}
