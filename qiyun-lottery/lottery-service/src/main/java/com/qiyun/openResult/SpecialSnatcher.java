package com.qiyun.openResult;

import com.qiyun.commonModel.LotteryType;

/** 特殊网站开奖抓取 **/
public class SpecialSnatcher {
	
	/** 高频 **/
	public static String GetResultForHigh(LotteryType lotteryType, String term){
		String result = null;
		if(lotteryType.equals(LotteryType.POKER3)){
			result= SpecialSnatcherSDTiCai.GetPoker3(term);
		}
		
		return result;
	}

}
