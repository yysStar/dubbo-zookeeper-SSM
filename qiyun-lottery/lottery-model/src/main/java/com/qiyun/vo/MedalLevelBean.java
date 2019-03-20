package com.qiyun.vo;

import com.qiyun.commonModel.LotteryType;

/**
 * @author lqc
 * @describe 负责对合买大厅等级进行对象化操作 
 * @date 2011.5.26
 * @version 1.1  战绩系统改版
 */
public class MedalLevelBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	// 方案编号
	private Integer planNo;
	private int goldBrick;
	private int goldDiamond;
	private int goldCrown;
	private int crown;
	// 彩种
	private String lotType;
	// 彩期
	private String term;
	// 金额
	private Integer amount;
	// 税前奖金
	private Integer pretaxPrize;
	// 盈利金额
	private Integer gain;
	// 状态
	private String planStatus;
	// 彩种
	private LotteryType lotteryType;
	
	public String getLotType() {
		return lotType;
	}
	public void setLotType(String lotType) {
		this.lotType = lotType;
	}

	public String toString(){
		//return "cup:"+ cup +" seat:"+seat+" brand:"+brand;
		return "测试";
	}
	public Integer getPlanNo() {
		return planNo;
	}
	public void setPlanNo(Integer planNo) {
		this.planNo = planNo;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getPretaxPrize() {
		return pretaxPrize;
	}
	public void setPretaxPrize(Integer pretaxPrize) {
		this.pretaxPrize = pretaxPrize;
	}
	public Integer getGain() {
		return gain;
	}
	public void setGain(Integer gain) {
		this.gain = gain;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public LotteryType getLotteryType() {
		return lotteryType;
	}
	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	public int getGoldBrick() {
		return goldBrick;
	}
	public void setGoldBrick(int goldBrick) {
		this.goldBrick = goldBrick;
	}
	public int getGoldDiamond() {
		return goldDiamond;
	}
	public void setGoldDiamond(int goldDiamond) {
		this.goldDiamond = goldDiamond;
	}
	public int getGoldCrown() {
		return goldCrown;
	}
	public void setGoldCrown(int goldCrown) {
		this.goldCrown = goldCrown;
	}
	public int getCrown() {
		return crown;
	}
	public void setCrown(int crown) {
		this.crown = crown;
	}
}
