package com.qiyun.lottery;

import com.qiyun.model.WinStatus;
import com.qiyun.util.LogUtil;

/**
 * @author lqc
 * @describe 负责对合买大厅等级进行匹配
 * @date 2011.5.26
 * @update 2015.4.1 wb
 * @version 2.0
 */
public class MedalLevelUtil {

	/**
	 * 出票方案
	 * 
	 * @param projectGain 方案盈利
	 * @return String
	 */
	public static RecordLevel getOutLevel(int projectGain) {
		if (projectGain >= 500000) {
			return RecordLevel.CROWN;
		} else if (projectGain >= 50000) {
			return RecordLevel.GOLD_CROWN;
		} else if (projectGain >= 5000) {
			return RecordLevel.GOLD_DIAMOND;
		} else if (projectGain >= 500) {
			return RecordLevel.GOLD_BRICK;
		}
		return null;
	}

	/**
	 * 得到方案等级
	 * 
	 * @param lotteryPlan 合买中奖方案
	 * @return String
	 */
	public static RecordLevel level(LotteryPlan lotteryPlan) {
		RecordLevel level = null;

		int projectMoney = lotteryPlan.getAmount();// projectMoney方案金额
		int projectGain = lotteryPlan.getPosttaxPrize().intValue() - projectMoney;// projectGain方案盈利

		if (projectGain >= 500) {// 中奖金额
			level = MedalLevelUtil.getOutLevel(projectGain);
		}
		LogUtil.info("----- 方案:" + lotteryPlan.getPlanNo() + " 方案金额:" + projectMoney + " 方案盈利:" + projectGain + " 方案等级:" + level);
		return level;
	}

	/**
	 * 封装等级对象
	 * 
	 * @param hmCount
	 *            hmCountList等级表记录，String level 等级
	 * @return HmCount
	 */
	public static HmCount hmCountSaveOrUpdate(HmCount hmCount, RecordLevel level) {
		if (hmCount != null) {
			addLevel(hmCount, level);
		} else {
			hmCount = new HmCount();
			addLevel(hmCount, level);
		}
		return hmCount;
	}

	private static void addLevel(HmCount hmCount, RecordLevel recordLevel) {
		if (RecordLevel.CROWN == recordLevel) {
			hmCount.addOneCrown();
		} else if (RecordLevel.GOLD_CROWN == recordLevel) {
			hmCount.addOneGoldCrown();
		} else if (RecordLevel.GOLD_DIAMOND == recordLevel) {
			hmCount.addOneGoldDiamond();
		} else if (RecordLevel.GOLD_BRICK == recordLevel) {
			hmCount.addOneGoldBrick();
		} else {
			LogUtil.info("战绩为空:" + hmCount.getId());
		}
	}

	/**
	 * 减少战绩数据
	 * 
	 * @param hmCount
	 * @param recordLevel
	 */
	private static void minusLevel(HmCount hmCount, RecordLevel recordLevel) {
		if (RecordLevel.CROWN == recordLevel) {
			hmCount.minusOneCrown();
		} else if (RecordLevel.GOLD_CROWN == recordLevel) {
			hmCount.minusOneGoldCrown();
		} else if (RecordLevel.GOLD_DIAMOND == recordLevel) {
			hmCount.minusOneGoldDiamond();
		} else if (RecordLevel.GOLD_BRICK == recordLevel) {
			hmCount.minusOneGoldBrick();
		} else {
			LogUtil.info("降低战绩为空:" + hmCount.getId());
		}
	}

	/**
	 * 增加对象的统计数据
	 * 
	 * @param hmCount
	 * @param plan
	 */
	public static void addStatisticsData(HmCount hmCount, LotteryPlan plan) {
		hmCount.addTotalBuyAmount(Long.valueOf(plan.getAmount()));
		hmCount.addTotalWinAmount(plan.getPretaxPrize());
		hmCount.addPlanCount();
		if (plan.getPretaxPrize() > 0 || plan.getWinStatus() == WinStatus.AWARD
				|| plan.getWinStatus() == WinStatus.SEND_AWARD)
			hmCount.addWinCount();
		updateAwardLevel(hmCount, plan);
	}

	/**
	 * 更新最新中奖等级
	 * 
	 * @param hmCount
	 */
	private static void updateAwardLevel(HmCount hmCount, LotteryPlan plan) {
		AwardLevel awardLevel = getAwardLevel(plan);
		if (awardLevel != null && hmCount.getAwardLevel() != null && hmCount.getAwardLevel().getValue() < awardLevel.getValue()) {
			hmCount.addAwardLevelCount(false, awardLevel);
		} else if (awardLevel != null && hmCount.getAwardLevel() != null && hmCount.getAwardLevel().getValue() == awardLevel.getValue()) {
			hmCount.addAwardLevelCount(true, awardLevel);
		} else if(hmCount.getAwardLevel() == null){
			hmCount.setAwardLevel(awardLevel);
		}
	}

	private static AwardLevel getAwardLevel(LotteryPlan plan) {
		AwardLevel awardLevel = AwardLevel.GE;
		double awardAmount = plan.getPretaxPrize();
		if (awardAmount >= 10000000) {
			awardLevel = AwardLevel.QIAN;
		} else if (awardAmount >= 1000000) {
			awardLevel = AwardLevel.BAI;
		} else if (awardAmount >= 100000) {
			awardLevel = AwardLevel.SHI;
		}
		return awardLevel;
	}

	/**
	 * 减去对象的统计数据(在重算奖金时扣除)
	 * 冲正时调用
	 * @param hmCount
	 * @param plan
	 */
	public static void returnStatisticsData(HmCount hmCount, LotteryPlan plan) {
		LogUtil.info("---------------------------战绩恢复开始------------------------");
		RecordLevel level = level(plan);
		LogUtil.info("方案中奖金额"+plan.getAmount()+" 方案中奖金额:"+plan.getPosttaxPrize());
		LogUtil.info(hmCount);
		hmCount.minusTotalBuyAmount(Long.valueOf(plan.getAmount()));
		hmCount.minusTotalWinAmount(plan.getPretaxPrize());
		hmCount.minusPlanCount();
		hmCount.minusWinCount();
		minusLevel(hmCount, level);
		AwardLevel awardLevel = getAwardLevel(plan);
		
		if(hmCount.getAwardLevel() == awardLevel){
			int count = hmCount.getAwardLevelCount();
			if(count > 1){
				count--;
				hmCount.setAwardLevelCount(count);
			}else{
				hmCount.setAwardLevel(AwardLevel.GE);
			}
		}
		LogUtil.info(hmCount);		
		LogUtil.info("---------------------------------战绩恢复结束------------------------------------");
	}
}
