package com.qiyun.model;

public class TotalPrizeBean {

	private String account;
	private Integer lotteryType;
	private Double prize;
	private Double addPrize;
	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getPrize() {
		return prize;
	}

	public void setPrize(Double prize) {
		this.prize = prize;
	}

	public Integer getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(Integer lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Double getAddPrize() {
		return addPrize;
	}

	public void setAddPrize(Double addPrize) {
		this.addPrize = addPrize;
	}
	

}
