package com.qiyun.openResult;

import com.qiyun.model.LotteryTerm;

//获取开奖号码接口 zf   2012-7-15
public interface Snatcher {
	public LotteryTerm getOpenResult(LotteryTerm term);
}
