package com.qiyun.lottery;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;
import com.qiyun.util.NumberTools;
import com.qiyun.utils.ArithUtil;

/**
 * HmCount entity.
 * @
 * @author MyEclipse Persistence Tools
 */
public class HmCount extends AbstractHmCount implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// Constructors
	/** default constructor */
	public HmCount() {
	}

	/**
	 * 加上一块金砖
	 */
	public void addOneGoldBrick() {
		this.setGoldBrick(1);
	}

	/**
	 * 加上一块金砖
	 */
	public void addOneGoldDiamond() {
		this.setGoldDiamond(1);
	}

	/**
	 * 加上一块金砖
	 */
	public void addOneGoldCrown() {
		this.setGoldCrown(1);
	}

	/**
	 * 加上一块金砖
	 */
	public void addOneCrown() {
		this.setCrown(1);
	}

	/**
	 * 减去一块金砖
	 */
	public void minusOneGoldBrick() {
		if (this.goldBrick > 0) {
			this.goldBrick--;
		} else if (this.goldBrick == 0 && (this.goldDiamond > 0 || this.goldCrown > 0 || this.crown > 0)) {
			this.goldBrick = 4;
			minusOneGoldDiamond();
		} else {
			LogUtil.info("帐户:" + this.getAccount() + "  减去一块[金砖]失败!");
		}
	}

	/**
	 * 减去一块钻石
	 */
	public void minusOneGoldDiamond() {
		if (this.goldDiamond > 0) {
			this.goldDiamond--;
			LogUtil.info("帐户:" + this.getAccount() + "  减去一块[钻石]!");
		} else if (this.goldDiamond == 0 && (this.goldCrown > 0 || this.crown > 0)) {
			this.goldDiamond = 4;
			minusOneGoldCrown();
		} else {
			LogUtil.info("帐户:" + this.getAccount() + "  减去一块[钻石]失败!");
		}
	}

	/**
	 * 减去一块银冠
	 */
	public void minusOneGoldCrown() {
		if (this.goldCrown > 0) {
			this.goldCrown--;
			LogUtil.info("帐户:" + this.getAccount() + "  减去一块[银冠]");
		} else if (this.goldCrown == 0 && this.crown > 0) {
			this.goldCrown = 4;
			minusOneCrown();
		} else {
			LogUtil.info("帐户:" + this.getAccount() + "  减去一块[银冠]失败!");
		}
	}

	/**
	 * 减去一块皇冠
	 */
	public void minusOneCrown() {
		if (this.crown > 0) {
			this.crown--;
			LogUtil.info("帐户:" + this.getAccount() + "  减去一块[皇冠]");
		} else {
			LogUtil.info("帐户:" + this.getAccount() + "  减去一块[皇冠]失败!");
		}
	}

	/**
	 * 增加中奖次数
	 */
	public void addWinCount() {
		this.winCount++;
	}

	/**
	 * 减去中奖次数
	 */
	public void minusWinCount() {
		if (this.winCount <= 0) {
			LogUtil.info("中奖次数操作异常!不能为负数");
			return;
		}
		this.winCount--;
	}

	/**
	 * 增加购彩总金额
	 */
	public void addTotalBuyAmount(long amount) {
		this.totalBuyAmount += amount;
	}

	/**
	 * 减少购彩总金额
	 */
	public void minusTotalBuyAmount(long amount) {
		if (amount > this.totalBuyAmount) {
			LogUtil.info("购彩总金额操作异常! totalBuyAmount：" + totalBuyAmount + "   amount：" + amount);
			return;
		}
		this.totalBuyAmount -= amount;
	}

	/**
	 * 增加中奖总金额
	 */
	public void addTotalWinAmount(double amount) {
		this.totalWinAmount = ArithUtil.add(totalWinAmount, amount);
	}

	/**
	 * 减少中奖总金额
	 */
	public void minusTotalWinAmount(double amount) {
		if (amount > this.totalBuyAmount) {
			LogUtil.info("购彩总金额操作异常! totalBuyAmount：" + totalBuyAmount + "   amount：" + amount);
			return;
		}
		this.totalWinAmount = ArithUtil.div(totalWinAmount, amount, 2);
	}

	/**
	 * 增加发单次数
	 */
	public void addPlanCount() {
		this.planCount++;
	}

	/**
	 * 减少发单次数
	 */
	public void minusPlanCount() {
		if (planCount <= 0) {
			LogUtil.info("减少发单操作异常!");
			return;
		}
		this.planCount--;
	}

	/**
	 * 增加跟单人数
	 */
	public void addOnePeople() {
		this.followPeople++;
	}

	/**
	 * 减少跟单人数
	 */
	public void minusOnePeople() {
		if (followPeople <= 0) {
			LogUtil.info("减少跟单人数操作异常!");
			return;
		}
		this.followPeople--;
	}

	/**
	 * 清空所有跟单人
	 */
	public void clearFollowsPeople() {
		this.followPeople = 0;
	}

	public LotteryType getLottery() {
		LotteryType type = LotteryType.getItem(getLotteryType().intValue());
		return type;
	}

	public int getLotteryTypeValue() {
		LotteryType type = LotteryType.getItem(getLotteryType().intValue());
		if (LotteryType.JCLQList.contains(type)) {
			return LotteryType.JC_LQ_SF.getValue();
		} else if (LotteryType.JCZQList.contains(type) || type == LotteryType.JC_ZQ_ALTERNATIVE || type == LotteryType.JC_ZQ_GYJ) {
			return LotteryType.JC_ZQ.getValue();
		}
		return 0;
	}

	/**
	 * 返回中奖率
	 * 
	 * @return
	 */
	public String getAveragePayoff() {
		if (planCount == 0)
			planCount = 1;
		double v = ArithUtil.div(winCount, planCount);
		String str = NumberTools.doubleToPercent(v);
		if (StringTools.isNullOrBlank(str))
			str = "0";
		return str;
	}

	public void addAwardLevelCount(boolean isAdd, AwardLevel awardLevel) {
		if (isAdd) {
			this.awardLevelCount++;
			return;
		}
		this.setAwardLevel(awardLevel);
		this.awardLevelCount = 1;
	}

	public String getLevelShowStr() {
		// "已获得1皇冠 1银冠 1钻石 1金砖"
		StringBuilder content = new StringBuilder("已获得");
		if (this.crown > 0) {
			content.append(crown).append("皇冠 ");
		}
		if (this.goldCrown > 0) {
			content.append(goldCrown).append("银冠 ");
		}
		if (this.goldDiamond > 0) {
			content.append(goldDiamond).append("钻石 ");
		}
		if (this.goldBrick > 0) {
			content.append(goldBrick).append("金砖 ");
		}
		if (content.length() == 3)
			return null;
		return content.toString();
	}
	
	@Override
	public String toString() {
		return "帐号:"+this.getAccount()+" 跟单人数:"+this.getFollowPeople()+"  皇冠:"+this.getCrown()
		+"  银冠:"+this.getGoldCrown()+"  钻石:"+this.getGoldDiamond()+"  金砖:"+this.getGoldBrick()+"  总购彩金额:"+this.totalBuyAmount+" 中奖总金额:"+this.totalWinAmount
		+" 中奖次数:"+this.winCount+" 发单数:"+this.planCount+" 大奖等级:"+this.getAwardLevel().getName()+" 大奖等级次数:"+this.awardLevelCount;
	}
}
