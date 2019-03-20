package com.qiyun.checkBingo;

import com.qiyun.model.OptionItem;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.utils.CommonUtils;

import java.util.Map;


public class BasketBallBingoCheck extends SportteryBingoCheck<BasketBallTicketModel, BasketBallMatchItem> {

	@Override
	public Class<BasketBallTicketModel> getTClass() {
		return BasketBallTicketModel.class;
	}

	@Override
	public Class<BasketBallMatchItem> getXClass() {
		return BasketBallMatchItem.class;
	}

	@Override
	public OptionItem getPassOptionItem(String lotteryType, BasketBallMatchItem matchItem, Map<String, String> resultMap) {
		Double RF = matchItem.getRF();
		Double DXF = matchItem.getDXF();
		resultMap.put(CommonUtils.handicapKey, RF.toString());
		resultMap.put(CommonUtils.bigSmallKey, DXF.toString());
		return CommonUtils.getResultOptionItem(lotteryType, resultMap);
	}

}
