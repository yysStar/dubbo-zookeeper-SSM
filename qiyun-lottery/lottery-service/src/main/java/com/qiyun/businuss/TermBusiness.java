package com.qiyun.businuss;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.LotteryTerm;

import java.util.HashMap;

public interface TermBusiness {
	/**
	 * 获取开奖数据进行开奖
	 * @param term
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public HashMap getOpenInfoMapForCheckBingo(LotteryTerm term, LotteryType type) throws Exception ;
	/**
	 * 获取临时开奖数据进行过关统计
	 * @param term
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public HashMap getTempResultMapForUpdatePlanPrizeInfo(LotteryTerm term, LotteryType type) throws Exception ;
}
