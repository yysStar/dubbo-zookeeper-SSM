package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.tools.DateTools;
import com.qiyun.utils.StringTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KlsfTermBuilder extends AbstractLotteryTermBuider {


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
            calendar.add(Calendar.MINUTE, -3);
            calendar.add(Calendar.SECOND, -0);
            startDateTime = calendar.getTime();

            // 开奖期次
            if (Integer.parseInt(oldTerm.substring(8, 10)) < 84) {
                // 关闭销售时间
                calendar.add(Calendar.MINUTE, 10);
                endDateTime = calendar.getTime();

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 2);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 1);
                calendar.add(Calendar.SECOND, 0);
                openDateTime = calendar.getTime();

                String sterm = "";
                if ((Integer.parseInt(oldTerm.substring(8, 10)) + 1) > 9) {
                    sterm = "" + (Integer.parseInt(oldTerm.substring(8, 10)) + 1);
                } else {
                    sterm = "0" + (Integer.parseInt(oldTerm.substring(8, 10)) + 1);
                }
                oldTerm = "" + DateTools.dateToString(calendar.getTime(), "yyyyMMdd") + sterm;
            } else {

                // 关闭销售时间
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                //广东省福利彩票发行中心决定从2014年1月1日起，调整福彩“快乐十分”游戏的销售时间为8:30至22:30。
                //之后每年的11月1日至次年的4月30日，销售时间则调整为8:30至22:30，每年的5月1日至10月31日销售时间为9:00至23:00。
                //2015-10-19 已取消
//				if(calendar.get(Calendar.MONTH)>= Calendar.MAY && calendar.get(Calendar.MONTH)<= Calendar.OCTOBER){
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 8);
                calendar.set(Calendar.SECOND, 0);
//				}else{
//					calendar.set(Calendar.HOUR_OF_DAY, 8);
//					calendar.set(Calendar.MINUTE, 38);
//					calendar.set(Calendar.SECOND, 0);
//				}

                endDateTime = calendar.getTime();

                //休市处理
                endDateTime = getCloseTime(calendar);

                // 切换销售时间
                calendar.add(Calendar.MINUTE, 2);
                terminalEndDateTime = calendar.getTime();

                // 开奖时间
                calendar.add(Calendar.MINUTE, 1);
                calendar.add(Calendar.SECOND, 0);
                openDateTime = calendar.getTime();

                oldTerm = DateTools.dateToString(calendar.getTime(), "yyyyMMdd");
                oldTerm += "01";
            }

            LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.KLSF,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
            retList.add(lotteryTerm);
        }
        return retList;
    }

}
