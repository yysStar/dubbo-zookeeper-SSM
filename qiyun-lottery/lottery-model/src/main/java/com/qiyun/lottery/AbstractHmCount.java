package com.qiyun.lottery;


import com.qiyun.util.NumberTools;

/**
 * AbstractHmCount entity provides the base persistence definition of the
 * HmCount entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractHmCount implements java.io.Serializable {

	// Fields

	private Long id;
	private String account;
	private Long lotteryType;
	protected int goldBrick;
	protected int goldDiamond;
	protected int goldCrown;
	protected int crown;
	//是否可以定制
	private boolean customize;//此字段不进行数据库存取

	protected long totalBuyAmount;// 总购彩金额(以方案总金额计算,不已购彩份数)
	protected double totalWinAmount;// 中奖总金额
	protected int winCount;// 中奖次数AwardLevel.java
	protected int followPeople;// 定制跟单人数
	protected int planCount;// 发单数
	private AwardLevel awardLevel;//中奖等级
	protected int awardLevelCount;//中奖等级次数
	// Constructors

	/** default constructor */
	public AbstractHmCount() {
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public Long getLotteryType() {
		return this.lotteryType;
	}

	public void setLotteryType(Long lotteryType) {
		this.lotteryType = lotteryType;
	}

	public int getGoldBrick() {
		return goldBrick;
	}

	protected void setGoldBrick(int goldBrick) {
		if (needUpgrade(this.goldBrick + goldBrick)) {// 进行升级
			this.goldBrick = 0;
			this.setGoldDiamond(1);
			return;
		}
		this.goldBrick += goldBrick;
	}

	public int getGoldDiamond() {
		return goldDiamond;
	}

	protected void setGoldDiamond(int goldDiamond) {
		if (needUpgrade(this.goldDiamond + goldDiamond)) {// 进行升级
			this.goldDiamond = 0;
			this.setGoldCrown(1);
			return;
		}
		this.goldDiamond += goldDiamond;
	}

	public int getGoldCrown() {
		return goldCrown;
	}

	protected void setGoldCrown(int goldCrown) {
		if (needUpgrade(this.goldCrown + goldCrown)) {// 进行升级
			this.goldCrown = 0;
			this.setCrown(1);
			return;
		}
		this.goldCrown += goldCrown;
	}

	public int getCrown() {
		return crown;
	}

	protected void setCrown(int crown) {
		this.crown += crown;
	}

	/**
	 * 是否需要升级
	 * 
	 * @param goldNum
	 * @return
	 */
	protected boolean needUpgrade(int goldNum) {
		if (goldNum >= 10)
			return true;
		return false;
	}

	public long getTotalBuyAmount() {
		return totalBuyAmount;
	}

	protected void setTotalBuyAmount(long totalBuyAmount) {
		this.totalBuyAmount += totalBuyAmount;
	}

	public int getWinCount() {
		return winCount;
	}

	protected void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public int getFollowPeople() {
		return followPeople;
	}

	public void setFollowPeople(int followPeople) {
		this.followPeople = followPeople;
	}

	public int getPlanCount() {
		return planCount;
	}

	protected void setPlanCount(int planCount) {
		this.planCount = planCount;
	}
	
	public String getTotalWinAmountStr(){
		return NumberTools.formatDouble(this.totalWinAmount, "#.##");
	}

	public double getTotalWinAmount() {
		return totalWinAmount;
	}

	public void setTotalWinAmount(double totalWinAmount) {
		this.totalWinAmount = totalWinAmount;
	}

	public AwardLevel getAwardLevel() {
		return awardLevel;
	}

	public void setAwardLevel(AwardLevel awardLevel) {
		this.awardLevel = awardLevel;
	}

	public int getAwardLevelCount() {
		return awardLevelCount;
	}

	public void setAwardLevelCount(int awardLevelCount) {
		this.awardLevelCount = awardLevelCount;
	}

	public boolean getCustomize() {
		return customize;
	}

	public void setCustomize(boolean customize) {
		this.customize = customize;
	}
	
}