package com.qiyun.model;

import com.qiyun.commonModel.TradeType;

import java.util.HashMap;


public class ContentFactory {

	private HashMap<String, ParserBuilder> parserFactoryMap;

	/**
	 * 功能：解析Factory类型
	 * 
	 * @throws Exception
	 */
	public ContentCheck initFactory(int lotteryType, double amount, String content,TradeType tradeType) throws Exception {
		return parserFactoryMap.get(lotteryType+"").checkPlan(content, amount, tradeType);
	}

	public HashMap<String, ParserBuilder> getParserFactoryMap() {
		return parserFactoryMap;
	}

	public void setParserFactoryMap(HashMap<String, ParserBuilder> parserFactoryMap) {
		this.parserFactoryMap = parserFactoryMap;
	}

}
