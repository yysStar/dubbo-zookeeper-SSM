package com.qiyun.checkBingo;

import com.qiyun.commonModel.PlayType;
import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.utils.ArithUtil;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.NumberTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketBallHtBingoCheck extends SportteryBingoCheck<BasketBallTicketModel, BasketBallMatchItem> {

	
	public void execute(String content, PlayType playType, int multiple, HashMap<String, String> openResultMap) {
		BasketBallTicketModel ticketModel = CommonUtils.Object4TikectJson(content, getTClass(), getXClass());
		List<BasketBallMatchItem> matchItems = ticketModel.getMatchItems();
		if (ticketModel.getPassMode().equals(PassMode.PASS.ordinal())){// 处理过关
			boolean hit = true;// 先定义好，假设全部命中
			double resultAward = 1d;
			int cancelSum = 0;
			for (BasketBallMatchItem x : matchItems) {
				try {
					Map<String, String> matchResultMap = new HashMap<String, String>();
					String tempKey = x.getIntTime() + "_" + x.getLineId();
					String tempHomeScore = openResultMap.get(CommonUtils.homeScoreKey + tempKey);
					String tempGuestScore = openResultMap.get(CommonUtils.guestScoreKey + tempKey);
					//赛事取消的情况
					if (tempHomeScore.equals("-1")) {
						resultAward = ArithUtil.mul(resultAward,x.getOptions().size());
						cancelSum++;
					} else {
						matchResultMap.put(CommonUtils.homeScoreKey, tempHomeScore);
						matchResultMap.put(CommonUtils.guestScoreKey, tempGuestScore);
						List<SportteryOption> item = getPassOptionItem(x, matchResultMap);
						
						hit = item.size()<=0 ? false : true;
						if (hit == false)
							break;
						
						for(SportteryOption sportteryOptionHunTou : item){
							Double tempAward = Double.valueOf(sportteryOptionHunTou.getAward());
							resultAward =ArithUtil.mul(resultAward, tempAward);
						}
					}
				} catch (NullPointerException e) {
					hit = false;
					isOpenAble = false;
					break;
				}
			}
			if (hit) {
				resultAward = ArithUtil.mul(resultAward,2);// 乘以2
				resultAward=ArithUtil.sixRound(resultAward);
				Double tempAward =resultAward;
				int passCount = matchItems.size() - cancelSum;
				if (tempAward > 200000) {// 如果金额超过20万:一般都很难所以这里以金额做判断
					if (passCount <= 3) {
						tempAward = 200000d;
					} else if (4 <= passCount && passCount <= 5) {
						tempAward = tempAward > 500000 ? 500000d : tempAward;
					} else if (6 <= passCount) {
						tempAward = tempAward > 1000000 ? 1000000d : tempAward;
					}
				}
				// 税前奖金
				bingoPretaxTotal = NumberTools.round(ArithUtil.add(bingoPretaxTotal,ArithUtil.mul(tempAward , ticketModel.getMultiple())),2);
				// 税后
				if (tempAward > 10000 && passCount > 0){// 所有的赛事都取消不算税
					tempAward = ArithUtil.mul(tempAward, 0.8);
					tempAward=ArithUtil.round2Scale(tempAward);
				}
				bingoPosttaxTotal =NumberTools.round(ArithUtil.add(bingoPosttaxTotal,ArithUtil.mul(tempAward , ticketModel.getMultiple())),2);
				bingoHashMap.put(matchItems.size() + "串1", 1l);
				isBingo = true;
				prizeHashMap.put(matchItems.size() + "串1", bingoPosttaxTotal);// 过关的奖金加入
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SportteryOption> getPassOptionItem(BasketBallMatchItem matchItem, Map<String, String> resultMap) {
		Double RF = matchItem.getRF();
		Double DXF = matchItem.getDXF();
		resultMap.put(CommonUtils.handicapKey, RF.toString());
		resultMap.put(CommonUtils.bigSmallKey, DXF.toString());
		
		List<SportteryOption> oi = new ArrayList<SportteryOption>();
		List<SportteryOption> options = matchItem.getOptions();
		for(SportteryOption hunTou : options){
				OptionItem item = CommonUtils.getResultOptionItem(hunTou.getType(), resultMap);//结果
				SportteryOption sportteryOption = matchItem.wons(hunTou,item);
				if(sportteryOption != null){
					oi.add(sportteryOption);
				}
		}
		return oi;
	}
	
	@Override
	public OptionItem getPassOptionItem(String lotteryType, BasketBallMatchItem matchItem, Map<String, String> resultMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<BasketBallTicketModel> getTClass() {
		return BasketBallTicketModel.class;
	}

	@Override
	public Class<BasketBallMatchItem> getXClass() {
		return BasketBallMatchItem.class;
	}
	
}
