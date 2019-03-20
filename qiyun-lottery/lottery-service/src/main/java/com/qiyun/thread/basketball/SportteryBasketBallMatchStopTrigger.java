package com.qiyun.thread.basketball;

import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.utils.TimeTools;

import java.util.Date;

public final class SportteryBasketBallMatchStopTrigger extends SportteryMatchStopTrigger<BasketBallMatch> {
	private final static String NAME="SportteryBasketBallMatchStopTrigger";

	public String getName() {return NAME;}
	
	@Override
	public Class<BasketBallMatch> getXClass() {
		return BasketBallMatch.class;
	}

	// 取得彩种名称
	protected String getLotteryName() {
		return "竞彩篮球";
	}
	
	protected Date getEndSaleTime(Date matchTime, int aheadMilli) {// 计算实际的截止时间
		return TimeTools.getBbEndSaleTime(matchTime, aheadMilli);
	}
}
