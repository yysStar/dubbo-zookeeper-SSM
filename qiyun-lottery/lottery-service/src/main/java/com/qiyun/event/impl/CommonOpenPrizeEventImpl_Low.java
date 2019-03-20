package com.qiyun.event.impl;

import com.qiyun.model.LotteryTerm;

/**
 * 低频彩开奖事件
 * @author zf 2012-7-15
 *
 */
public class CommonOpenPrizeEventImpl_Low extends AbstractOpenPrizeEvent {

	
	/**
	 * 彩期一直取不到开奖号，在新一期截止前预留给追号操作生成方案的时间
	 * @return
	 */
	@Override
	public long estimateChaseExecuteTime(){
		//低频重置为5小时
		return 5*3600*1000; 
	}
	
	@Override
	public void beforeOpenPrize(LotteryTerm term , LotteryTerm nextTerm, Boolean isRepair) {
	}
	
	@Override
	public void afterOpenPrize(LotteryTerm term, LotteryTerm nextTerm, Boolean isRepair) {
	}

}
