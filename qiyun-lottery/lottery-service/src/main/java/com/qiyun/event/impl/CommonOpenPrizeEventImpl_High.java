package com.qiyun.event.impl;

import com.qiyun.model.LotteryTerm;

/**
 *  高频通用开奖事件， 无前置，后置事件
 * @author zf
 *
 */
public class CommonOpenPrizeEventImpl_High extends AbstractOpenPrizeEvent{
	
	@Override
	public void beforeOpenPrize(LotteryTerm term , LotteryTerm nextTerm, Boolean isRepair) {
	}
	
	@Override
	public void afterOpenPrize(LotteryTerm term, LotteryTerm nextTerm, Boolean isRepair) {
	}
	
}
