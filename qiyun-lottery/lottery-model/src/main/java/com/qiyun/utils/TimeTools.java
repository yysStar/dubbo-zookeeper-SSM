package com.qiyun.utils;

import com.qiyun.tools.DateTools;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeTools {


	public static Date getBasketBallDealTime(Date matchTime, int deal) {
		Date realDealTime ;
		Calendar c = Calendar.getInstance();
		c.setTime(matchTime);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.MONDAY){ //周日周一
			if (hour<1 || (hour==1 && minute==0)){
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}else if (hour<9 || (hour==9 && minute==0)){
				c.set(Calendar.HOUR_OF_DAY, 1);
				c.set(Calendar.MINUTE, 0);
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}else{
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}
		}else{
			if (hour<9 || (hour==1 && minute==0)){
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}else{
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}
		}
		return realDealTime;
	}

	public static Date getFootBallDealTime(Date matchTime, int deal) {
		Date realDealTime ;
		Calendar c = Calendar.getInstance();
		c.setTime(matchTime);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.MONDAY){ //周日周一
			if (hour<1 || (hour==1 && minute==0)){
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}else if (hour<9 || (hour==9 && minute==0)){
				c.set(Calendar.HOUR_OF_DAY, 1);
				c.set(Calendar.MINUTE, 0);
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}else{
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}
		}else{
			if (hour<9 || (hour==1 && minute==0)){
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}else{
				c.add(Calendar.MILLISECOND, -deal);
				realDealTime = c.getTime();
			}
		}
		return realDealTime;
	}

	public static Date getEndSaleTimeByWorldCup(Date matchtime, int deal, String gamename) {
		/*if ("世界杯".equals(gamename)){
			return new Date(matchtime.getTime()-deal);
		}else {
			Calendar c = Calendar.getInstance();
			c.setTime(matchtime);
			// 计算提前量之后的时间
			c.add(Calendar.MILLISECOND, -deal);
			Date realEndTime = c.getTime();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			if (hour < 9 ) {
				c.add(Calendar.DAY_OF_MONTH, -1);
				c.set(Calendar.HOUR_OF_DAY, 23);
				c.set(Calendar.MINUTE, 59);
				c.set(Calendar.SECOND, 59);

				c.add(Calendar.MILLISECOND, -deal);//23:49:59
				c.add(Calendar.MILLISECOND,1000);//加一秒 凑整 23:50:00
				realEndTime = c.getTime();
				return realEndTime;
			}else{
				return new Date(matchtime.getTime()-deal);
			}
		}*/
		return new Date(matchtime.getTime()-deal);
	}
	
	// 竞彩足球计算赛事截止时间
	public static Date getFbEndSaleTime(Date matchTime, int aheadMilli) {// 计算实际的截止时间
		Calendar c = Calendar.getInstance();
		c.setTime(matchTime);
		// 计算提前量之后的时间
		c.add(Calendar.MILLISECOND, -aheadMilli);
		Date realEndTime = c.getTime();
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		// 如果截止小于9点，并在周日或周一早上，要调整到1:00截止，其它时间调整到前一天23点截止
		// 如果截止时间大于23:00点，周六或周日不做处理，其它日期要调整到23点截止
		if (hour < 9 || (hour==9 && minute<=6)) {
			if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.MONDAY) {
				if ((hour > 0 || (hour == 0 && minute >= 60 - aheadMilli / 1000 / 60))) {
					// 截止时间>=（1点 - 提前量）
					c.set(Calendar.HOUR_OF_DAY, 1);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
					
					c.add(Calendar.MILLISECOND, -aheadMilli);
					realEndTime = c.getTime();
					
				} else {
					// 时间<（1点 - 提前量） ，保持原样(按比赛时间减提前量计算)
					//return realEndTime;
				}
			} else {
				c.add(Calendar.DAY_OF_MONTH, -1);
				c.set(Calendar.HOUR_OF_DAY, 23);
				c.set(Calendar.MINUTE, 59);
				c.set(Calendar.SECOND, 59);
				
				c.add(Calendar.MILLISECOND, -aheadMilli);//23:49:59
				c.add(Calendar.MILLISECOND,1000);//加一秒 凑整 23:50:00
				realEndTime = c.getTime();
			}
			
		} else if (hour >= 24 || (hour >= 23 && minute >= 60 - aheadMilli / 1000 / 60)) {

			if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
				// do nothing!!!
				//return realEndTime;
			} else {
				c.set(Calendar.HOUR_OF_DAY, 23);
				c.set(Calendar.MINUTE, 59);
				c.set(Calendar.SECOND, 59);
				realEndTime = c.getTime();
				c.add(Calendar.MILLISECOND, -aheadMilli);//23:49:59
				c.add(Calendar.MILLISECOND,1000);//加一秒 凑整 23:50:00
				realEndTime = c.getTime();

			}

		}

		//春节特殊处理
		//如果截止时间在 1-21 22:52  到 1-29 0:00之间的，调整到1-21 22:52截止
		Date start_ = DateTools.StringToDate("2012-01-21 22:52:00") ;
		Date end_ = DateTools.StringToDate("2012-01-29 00:00:00") ;
		if(realEndTime.getTime() > start_.getTime() && realEndTime.getTime() <end_.getTime() ){
			realEndTime = start_;
		}
		//欧洲杯比赛日特殊处理
		//如果截止时间在 06-09 00:00  到 07-02 02:45之间的，且有欧洲杯赛事顺延到 次日02:45截止 
		//06-21,06-26,06-27,06-30,07-1凌晨00:00至凌晨02:45的比赛不延迟(该日凌晨无欧洲杯赛事)
		Date euroCupStart = DateTools.StringToDate("2012-06-08 23:59:00") ;
		Date euroCupEnd = DateTools.StringToDate("2012-07-02 09:00:00") ;
		Map<Integer,Integer> unHandleDays = new HashMap<Integer,Integer>();
		unHandleDays.put(21,21);
		unHandleDays.put(26,26);
		unHandleDays.put(27,27);
		unHandleDays.put(30,30);
		unHandleDays.put(1,1);
		c.setTime(matchTime);
		if(matchTime.getTime()> euroCupStart.getTime() && matchTime.getTime() <euroCupEnd.getTime() ){
			if((c.get(Calendar.HOUR_OF_DAY)<2||(c.get(Calendar.HOUR_OF_DAY)==2&&c.get(Calendar.MINUTE)<=45))){
				if(unHandleDays.get(c.get(Calendar.DAY_OF_MONTH))==null){
					c.add(Calendar.MILLISECOND, -aheadMilli);
					realEndTime = c.getTime();
				}
			}else if(c.get(Calendar.HOUR_OF_DAY)<9||(c.get(Calendar.HOUR_OF_DAY)==9&&c.get(Calendar.MINUTE)<8)){
				if(unHandleDays.get(c.get(Calendar.DAY_OF_MONTH))==null){
					c.set(Calendar.HOUR_OF_DAY,2);
					c.set(Calendar.MINUTE, 45);
					c.set(Calendar.SECOND, 0);
					c.add(Calendar.MILLISECOND, -aheadMilli);
					realEndTime = c.getTime();
				}
			}
		}
//		realEndTime = new Date(realEndTime.getTime() - 300000);
//		return realEndTime;
		return realEndTime;
	}

	// 竞彩篮球球计算赛事截止时间
	public static Date getBbEndSaleTime(Date matchTime, int aheadMilli) {// 计算实际的截止时间
		Calendar c = Calendar.getInstance();
		c.setTime(matchTime);
		// 计算提前量之后的时间
		c.add(Calendar.MILLISECOND, -aheadMilli);
		Date realEndTime = c.getTime();

		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		// 周3，周4早上是7：30截止
		// 如果截止小于9点，并在周日或周一早上，要调整到1:00截止，，其它时间调整到前一天23点截止
		// 如果截止时间大于23:00点，周六或周日不做处理，其它日期要调整到23点截止
		if (hour < 9) {
			if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.MONDAY) {// 周日、周1
				if ((hour > 0 || (hour == 0 && minute >= 60 - aheadMilli / 1000 / 60))) {
					// 截止时间>=（1点 - 提前量）
					c.set(Calendar.HOUR_OF_DAY, 1);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);

					c.add(Calendar.MILLISECOND, -aheadMilli);
					realEndTime = c.getTime();
					
				} else {
					// 时间<（1点 - 提前量） ，保持原样(按比赛时间减提前量计算)
					//return realEndTime;
				}
			} else if ((dayOfWeek == Calendar.WEDNESDAY || dayOfWeek == Calendar.THURSDAY) && (hour >= 8 || (hour == 7 && minute >= 30))) {
				// 周3、4 && 7:30后的 (9点前),保持原样, 7:30以前的归到前一天23：00
				//return realEndTime;

			} else {
				// 当天无法出票的，移动到前一天 23 点
				c.add(Calendar.DAY_OF_MONTH, -1);
				c.set(Calendar.HOUR_OF_DAY, 23);
				c.set(Calendar.MINUTE, 59);
				c.set(Calendar.SECOND, 59);
				
				c.add(Calendar.MILLISECOND, -aheadMilli);//23:49:59
				c.add(Calendar.MILLISECOND,1000);//加一秒 凑整 23:50:00
				realEndTime = c.getTime();
				
			}
			
		} else if (hour >= 24 || (hour == 23 && minute >= 60 - aheadMilli / 1000 / 60)) {

			if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
				// do nothing!!!
				//return realEndTime;
			} else {
				c.set(Calendar.HOUR_OF_DAY, 23);
				c.set(Calendar.MINUTE, 59);
				c.set(Calendar.SECOND, 59);
				realEndTime = c.getTime();
				c.add(Calendar.MILLISECOND, -aheadMilli);//23:49:59
				c.add(Calendar.MILLISECOND,1000);//加一秒 凑整 23:50:00
				realEndTime = c.getTime();

			}
		}
		//春节特殊处理
		//如果截止时间在 1-21 22:52  到 1-29 0:00之间的，调整到1-21 22:52截止
		Date start_ = DateTools.StringToDate("2012-01-21 22:52:00") ;
		Date end_ = DateTools.StringToDate("2012-01-29 00:00:00") ;
		if(realEndTime.getTime() > start_.getTime() && realEndTime.getTime() <end_.getTime() ){
			realEndTime = start_;
		}
//		realEndTime = new Date(realEndTime.getTime() - 300000);
//		return realEndTime;
		return realEndTime;
	}

	public static boolean isFbInTime(Date d) {
		boolean res = true;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		String weekStr = DateTools.getWeekStr(calendar.getTime());
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);

		if (weekStr.equals("周六")) {
			if (hour < 8 || (hour == 8 && minute < 31)) {
				res = false;
			}
		} else if (weekStr.equals("周日")) {
			if (((hour == 0 && minute >= 57) || (hour > 0)) && (hour < 8 || (hour == 8 && minute < 31))) {
				res = false;
			}
		} else if (weekStr.equals("周一")) {
			if ((((hour == 0 && minute >= 57) || (hour > 0)) && (hour < 8 || (hour == 8 && minute < 31))) || (hour == 23 && minute >= 57)
					|| (hour > 22)) {
				res = false;
			}
		} else {
			if (((hour == 23 && minute >= 57) || (hour > 23)) || (hour < 8 || (hour == 8 && minute < 31))) {
				res = false;
			}
		}
		return res;
	}
	// 北京单场计算赛事截止时间
	public static Date getDCEndSaleTime(Date matchTime, int aheadMilli) {// 计算实际的截止时间
//		Calendar c = Calendar.getInstance();
//		c.setTime(matchTime);
//		// 计算提前量之后的时间
//		c.add(Calendar.MILLISECOND, -aheadMilli);
//		Date realEndTime = c.getTime();

//		return realEndTime;
		return DateTools.GetDCMatchEndTime(matchTime, aheadMilli);
	}
	public static boolean isBbInTime(Date d) {
		boolean res = true;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		String weekStr = DateTools.getWeekStr(calendar.getTime());
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);

		if (weekStr.equals("周六")) {
			if (hour < 8 || (hour == 8 && minute < 31)) {
				res = false;
			}
		} else if (weekStr.equals("周日")) {
			if (((hour == 0 && minute >= 57) || (hour > 0)) && (hour < 8 || (hour == 8 && minute < 31))) {
				res = false;
			}
		} else if (weekStr.equals("周一")) {
			if ((((hour == 0 && minute >= 57) || (hour > 0)) && (hour < 8 || (hour == 8 && minute < 31))) || (hour == 23 && minute >= 57)
					|| (hour > 23)) {
				res = false;
			}
		} else if (weekStr.equals("周三") || weekStr.equals("周四")) {
			if (((hour == 23 && minute >= 57) || (hour > 23)) || (hour < 7 || (hour == 7 && minute < 31))) {
				res = false;
			}
		} else {
			if (((hour == 23 && minute >= 57) || (hour > 23)) || (hour < 8 || (hour == 8 && minute < 31))) {
				res = false;
			}
		}
		return res;
	}


}
