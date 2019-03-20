package com.qiyun.lottery;

import com.qiyun.commonModel.TradeType;
import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;

/**
 * 解析追号停止条件 前端调用显示
 * 
 * @author sxh 2011-6-23
 */
public class StopConditionParser {
	
	public final static String STOP_CHASE_BY_WIN = "0";//中奖后停止追号标记
	public final static String STOP_CHASE_BY_WIN_COUNT = "1";//中奖多少次停止追号标记
	public final static String PRIZE1_FLAG = "prize1";//一等奖
	public final static String PRIZE2_FLAG = "prize2,prize1";//二等奖
	
	public static String getStopConditionShow(String stopCondition,TradeType tradeType) {
		if (StringTools.isNullOrBlank(stopCondition)) {
			return "中奖后继续追号";
		}

		String info = stopCondition;

		try {
			String[] conditions = stopCondition.split("\\#");
			
			if(conditions.length == 1 && STOP_CHASE_BY_WIN.equals(conditions[0])) {
				info = "中奖后停止追号";	
			} else if(conditions.length == 2 && STOP_CHASE_BY_WIN.equals(conditions[0]) && Double.parseDouble(conditions[1]) >= 1) {
				if(TradeType.isBalanceTrade(tradeType)){
					info = "当累计奖金>=<font color='red'>"+ conditions[1] +"</font>元终止追号";					
				}else{
					info = "当累计中奖积分>=<font color='red'>"+ conditions[1] +"</font>终止追号";
				}
			} else if(conditions.length == 2 && STOP_CHASE_BY_WIN_COUNT.equals(conditions[0]) && Double.parseDouble(conditions[1]) >= 1) {
				info = "中奖<font color='red'>"+ conditions[1] +"</font>次停止追号";
			} else if (PRIZE1_FLAG.equals(stopCondition)) {
				info = "中<font color='red'>[一等奖]</font>停止追号";	
			} else if (PRIZE2_FLAG.equals(stopCondition)) {
				info = "中<font color='red'>[二等奖]</font>停止追号";	
			} else {
				info = "中奖后继续追号";
			}
		} catch (Exception e) {
			LogUtil.info("解析追号开始条件发生错误");
		}

		return info;
	}
}
