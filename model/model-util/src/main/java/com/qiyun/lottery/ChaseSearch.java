package com.qiyun.lottery;

import com.qiyun.commonModel.TradeType;
import com.qiyun.tools.DateTools;

import java.util.Date;

public class ChaseSearch {

	private String account;
	private int lotteryType = -1;
	private int chaseNo;
	private int chaseType = -1;
	private int status = -1;
	private int planNo;
	private String startDate;
	private String endDate;
	private int isPackage = -1;  //是否追号套餐
	private int totalTerm = -1;	 //追号总期数
	private TradeType tradeType;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(int lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Integer getChaseNo() {
		return chaseNo;
	}

	public void setChaseNo(Integer chaseNo) {
		this.chaseNo = chaseNo;
	}

	public int getChaseType() {
		return chaseType;
	}

	public void setChaseType(int chaseType) {
		this.chaseType = chaseType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate1() {
		if (this.startDate != null && !"".equals(startDate)) {
			return DateTools.StringToDate(startDate + " 00:00:00");
		}
		return null;
	}

	public Date getEndDate1() {
		if (this.endDate != null && !"".equals(endDate)) {
			return DateTools.StringToDate(endDate + " 23:59:59");
		}
		return null;
	}

	public int getIsPackage() {
		return isPackage;
	}

	public void setIsPackage(int isPackage) {
		this.isPackage = isPackage;
	}

	public int getTotalTerm() {
		return totalTerm;
	}

	public void setTotalTerm(int totalTerm) {
		this.totalTerm = totalTerm;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
}
