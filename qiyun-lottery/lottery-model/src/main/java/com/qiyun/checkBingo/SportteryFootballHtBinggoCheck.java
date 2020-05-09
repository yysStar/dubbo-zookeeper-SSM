package com.qiyun.checkBingo;

import com.qiyun.commonModel.PlayType;
import com.qiyun.model.*;
import com.qiyun.utils.ArithUtil;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.NumberTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SportteryFootballHtBinggoCheck extends SportteryBingoCheck<FootballTicketModel, FootBallMatchItem> {

	public void execute(String content, PlayType playType, int multiple, HashMap<String, String> openResultMap) {
		FootballTicketModel ticketModel = CommonUtils.Object4TikectJson(content, getTClass(), getXClass());
		List<FootBallMatchItem> matchItems = ticketModel.getMatchItems();
		if (ticketModel.getPassType()== SportteryPassType.P1) {// 处理单关
			// 根据玩法取得比赛的选项
			Double resultAward = 0d;
			for (FootBallMatchItem x : matchItems) {
				Double tempAward = 0d;
				try {
					Map<String, String> matchResultMap = new HashMap<String, String>();
					String tempKey = x.getIntTime() + "_" + x.getLineId();
					String tempHomeScore = openResultMap.get(CommonUtils.homeScoreKey + tempKey);
					String tempGuestScore = openResultMap.get(CommonUtils.guestScoreKey + tempKey);
					String tempHalfHomeScore = openResultMap.get(CommonUtils.resultHalfHomeScore + tempKey);
					String tempHalfGuestScore = openResultMap.get(CommonUtils.resultHalfGuestScore + tempKey);
					String tempRq = openResultMap.get(CommonUtils.CONCEDEKEY + tempKey);

					matchResultMap.put(CommonUtils.homeScoreKey, tempHomeScore);
					matchResultMap.put(CommonUtils.guestScoreKey, tempGuestScore);
					matchResultMap.put(CommonUtils.resultHalfHomeScore, tempHalfHomeScore);
					matchResultMap.put(CommonUtils.resultHalfGuestScore, tempHalfGuestScore);
					matchResultMap.put(CommonUtils.CONCEDEKEY, tempRq);
					
					if (tempHomeScore.equals("-1")) {// 赛事取消
						tempAward = ArithUtil.mul(2, x.getOptions().size());
					} else {
						List<SportteryOption> item = getPassOptionItem(x, matchResultMap);
						boolean hit = item.size()<=0 ? false : true;
						if (hit == false)
							break;
						tempAward=ArithUtil.mul(item.get(0).getAward(), 2);  //单关会拆成单式票 所以只有一个
					}
					if (tempAward < 2)
						tempAward = 2d;// 不足两元补足两元
					resultAward =ArithUtil.add(resultAward, tempAward);
					isBingo = true;
					if (bingoHashMap.get("单关") != null)
						bingoHashMap.put("单关:", bingoHashMap.get("单关") + 1);
					else
						bingoHashMap.put("单关:", 1l);
				} catch (NullPointerException e) {
					isOpenAble = false;
					break;// 空指针异常，说明选择的赛事中有赛事还未结果
				}
			}
			resultAward=ArithUtil.sixRound(resultAward);
			resultAward=resultAward>100000?100000:resultAward;//单关固定奖 最高10w一张票
			// 计算奖金
			bingoPretaxTotal = NumberTools.round(ArithUtil.add(bingoPretaxTotal,ArithUtil.mul(resultAward , ticketModel.getMultiple())),2);
			if (resultAward > 10000) {// 税后
				resultAward = ArithUtil.mul(resultAward, 0.8);
				resultAward=ArithUtil.round2Scale(resultAward);
			}
			bingoPosttaxTotal =NumberTools.round(ArithUtil.add(bingoPosttaxTotal,ArithUtil.mul(resultAward , ticketModel.getMultiple())),2);
			prizeHashMap.put("单关:", bingoPosttaxTotal);// 单关的奖金加入
		}else if (ticketModel.getPassMode().equals(PassMode.PASS.ordinal())){// 处理过关
			boolean hit = true;// 先定义好，假设全部命中
			double resultAward = 1d;
			int cancelSum = 0;
			for (FootBallMatchItem x : matchItems) {
				try {
					Map<String, String> matchResultMap = new HashMap<String, String>();
					String tempKey = x.getIntTime() + "_" + x.getLineId();
					String tempHomeScore = openResultMap.get(CommonUtils.homeScoreKey + tempKey);
					String tempGuestScore = openResultMap.get(CommonUtils.guestScoreKey + tempKey);
					String tempHalfHomeScore = openResultMap.get(CommonUtils.resultHalfHomeScore + tempKey);
					String tempHalfGuestScore = openResultMap.get(CommonUtils.resultHalfGuestScore + tempKey);
					String tempRq = openResultMap.get(CommonUtils.CONCEDEKEY + tempKey);
					if (!tempHomeScore.equals("-1")) {
						matchResultMap.put(CommonUtils.homeScoreKey, tempHomeScore);
						matchResultMap.put(CommonUtils.guestScoreKey, tempGuestScore);
						matchResultMap.put(CommonUtils.resultHalfHomeScore, tempHalfHomeScore);
						matchResultMap.put(CommonUtils.resultHalfGuestScore, tempHalfGuestScore);
						matchResultMap.put(CommonUtils.CONCEDEKEY, tempRq);
						List<SportteryOption> item = getPassOptionItem(x, matchResultMap);
						
						hit = item.size()<=0 ? false : true;
						if (hit == false)
							break;
						
						for(SportteryOption sportteryOptionHunTou : item){
							Double tempAward = Double.valueOf(sportteryOptionHunTou.getAward());
							resultAward =ArithUtil.mul(resultAward, tempAward);
						}
						
					} else {// 赛事取消的情况
						resultAward =ArithUtil.mul(resultAward, x.getOptions().size());
						cancelSum++;
					}
				} catch (NullPointerException e) {
					hit = false;
					isOpenAble = false;
					break;
				}
			}
			if (hit) {
				resultAward =ArithUtil.mul(resultAward, 2);// 乘以2
				resultAward=ArithUtil.sixRound(resultAward);
				
				Double tempAward = resultAward;
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
				bingoPretaxTotal =NumberTools.round(ArithUtil.add(bingoPretaxTotal,ArithUtil.mul(tempAward , ticketModel.getMultiple())),2);
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
	public List<SportteryOption> getPassOptionItem(FootBallMatchItem matchItem, Map<String, String> resultMap) {
		List<SportteryOption> oi = new ArrayList<SportteryOption>();
		
		List<SportteryOption> options = matchItem.getOptions();
		for(SportteryOption hunTou : options){
				OptionItem item = CommonUtils.getZQResultOptionItem(hunTou.getType(), resultMap);//结果
				SportteryOption sportteryOption = matchItem.wons(hunTou,item);
				if(sportteryOption != null){
					oi.add(sportteryOption);
				}
		}
		return oi;
	}
	
	@Override
	public OptionItem getPassOptionItem(String lotteryType, FootBallMatchItem matchItem, Map<String, String> resultMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<FootballTicketModel> getTClass() {
		return FootballTicketModel.class;
	}

	@Override
	public Class<FootBallMatchItem> getXClass() {
		return FootBallMatchItem.class;
	}

}
