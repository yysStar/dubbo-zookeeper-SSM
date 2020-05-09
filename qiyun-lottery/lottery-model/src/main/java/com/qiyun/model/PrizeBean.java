package com.qiyun.model;

public class PrizeBean {

	private int lotteryType;
	private String prizeName;
	private String count;
	private String amount;

	public int getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(int lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrizeNameLabel() {
		String resultNameLabel = PrizeListDef.get(this.lotteryType).get(this.prizeName);
		if (resultNameLabel != null) {
			return resultNameLabel;
		}
		return this.prizeName;
	}

}
