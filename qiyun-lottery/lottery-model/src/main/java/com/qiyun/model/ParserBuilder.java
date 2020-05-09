package com.qiyun.model;


import com.qiyun.commonModel.TradeType;

public interface ParserBuilder {

	/**
	 * 功能：判断方案内容是否存在问题
	 * 
	 * @return
	 */
	public abstract ContentCheck checkPlan(String content, double amount, TradeType tradeType) throws Exception;

}