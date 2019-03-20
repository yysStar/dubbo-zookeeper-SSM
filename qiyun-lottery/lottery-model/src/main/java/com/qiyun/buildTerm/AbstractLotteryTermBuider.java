package com.qiyun.buildTerm;


import com.qiyun.commonModel.LotteryTermStatus;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.status.CommonStatus;
import com.qiyun.tools.DateTools;

import java.util.*;

public abstract class AbstractLotteryTermBuider implements LotteryTermBuider {
    protected static Date START_DATE = LotteryTermHelper.START_DATE;//休市开始时间
    protected static Date CLOSE_DATE = LotteryTermHelper.CLOSE_DATE;//休市结束时间
    protected static int CLOSE_DAYS = LotteryTermHelper.CLOSE_DAYS;//休市天数

    /**
     * @param lotteryType 		彩种
     * @param startSaleDelay 	开始销售延迟（相对上期开奖时间）
     * @param stopSaleDelay  	截止销售延迟（相对上期开奖时间）
     * @param openInterval	   	开奖时间间隔
     * @param termNum		   	每日期数
     * @param startTime		   	每日首期开奖时间
     * @param dateFormat	   	期号日期格式化
     * @param oldTerm	    	上期号期号
     * @param oldOpenDateTime   上期开奖时间
     * @param buildCount	            生成期数
     * @return
     */
    public List<LotteryTerm2> genBuild(
            LotteryType lotteryType,
            int startSaleDelay,
            int stopSaleDelay,
            int openInterval,
            int termNum,
            String startTime,
            String dateFormat,
            String oldTerm,
            Date oldOpenDateTime,
            int buildCount
    ) {

        return this.genBuild2(lotteryType,startSaleDelay, stopSaleDelay, openInterval,
                termNum,termNum, startTime,dateFormat,oldTerm,oldOpenDateTime, buildCount);

    }

    /**
     * @param lotteryType 		彩种
     * @param startSaleDelay 	开始销售延迟（相对上期开奖时间）
     * @param stopSaleDelay  	截止销售延迟（相对上期开奖时间）
     * @param openInterval	   	开奖时间间隔
     * @param termNum		   	每日期数
     * @param breakNum		   	断层前期数
     * @param breakTime		   	断层后首期开奖时间
     * @param dateFormat	   	期号日期格式化
     * @param oldTerm	    	上期号期号
     * @param oldOpenDateTime   上期开奖时间
     * @param buildCount	            生成期数
     * @return
     */
    public List<LotteryTerm2> genBuild2(
            LotteryType lotteryType,
            int startSaleDelay,
            int stopSaleDelay,
            int openInterval,
            int termNum,
            int breakNum,
            String breakTime,
            String dateFormat,
            String oldTerm,
            Date oldOpenDateTime,
            int buildCount
    ) {

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
            // 开奖期次
            if (breakNum == shortTerm) {
                // 首期开奖时间(当天最后一期断层时日期+1)
                if(breakNum==termNum){
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                }
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



    //构建一个LotteryTerm对象
    public LotteryTerm2 createLotteryTerm(LotteryType lotteryType,String term,Date startDateTime,Date endDateTime,Date terminalEndDateTime,Date openDateTime) {
        LotteryTerm2 lotteryTerm = new LotteryTerm2();

        lotteryTerm.setLotteryType(lotteryType.getValue());
        lotteryTerm.setTerm(term);
        lotteryTerm.setStatus(LotteryTermStatus.BEFORE_OPEN_SALE.getValue());

        lotteryTerm.setIsAble(CommonStatus.YES.getValue());//具体停开售状态生成后再更新，详见LotteryTermServiceImpl.buildTerm方法实现
        lotteryTerm.setLotMgrIsAble(CommonStatus.YES.getValue());
        lotteryTerm.setIsCurrentTerm(CommonStatus.NO.getValue());

        lotteryTerm.setAwardPool("0");
        lotteryTerm.setStartDateTime(startDateTime);
        lotteryTerm.setEndDateTime(endDateTime);
        lotteryTerm.setTerminalEndDateTime(terminalEndDateTime);
        lotteryTerm.setOpenDateTime(openDateTime);

        lotteryTerm.setResult("");
        lotteryTerm.setResultDetail("");

        return lotteryTerm;
    }

    //获取彩种休市时间
    public Date getCloseTime(Calendar calendar) {
        if(START_DATE.before(calendar.getTime()) && CLOSE_DATE.after(calendar.getTime())) {//休市处理
            calendar.add(Calendar.DATE, CLOSE_DAYS);
        }
        return calendar.getTime();
    }

    //获取彩种休市时间
    public Date getCloseTime(Calendar calendar,Map<Integer, Integer> nextOpenDates) {
        while(START_DATE.before(calendar.getTime()) && CLOSE_DATE.after(calendar.getTime())){//休市处理
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int nextDays = nextOpenDates.get(dayOfWeek);
            calendar.add(Calendar.DAY_OF_MONTH, nextDays);
        }
        return calendar.getTime();
    }

}
