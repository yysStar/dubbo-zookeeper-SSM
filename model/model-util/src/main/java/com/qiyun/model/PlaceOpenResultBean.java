package com.qiyun.model;
/**
 * 地方彩种开奖Bean
 */
public class PlaceOpenResultBean {

	//彩种
	private String lottery;
	//期数
	private String term;
	//开奖号
	private String openResult;
	//开奖时间
	private String openTime;
	//兑奖截止日期时间
	private String endTime;
	//本期销量
	private String termSale;
	//奖池滚存
	private String award;
	//开奖详情
	private String openDetail;
	//和值
	private String hz;
	
	public String getLottery() {
		return lottery;
	}
	public void setLottery(String lottery) {
		this.lottery = lottery;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getOpenResult() {
		return openResult;
	}
	public void setOpenResult(String openResult) {
		this.openResult = openResult;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getTermSale() {
		return termSale;
	}
	public void setTermSale(String termSale) {
		this.termSale = termSale;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public String getOpenDetail() {
		return openDetail;
	}
	public void setOpenDetail(String openDetail) {
		this.openDetail = openDetail;
	}
	public String getHz() {
		return hz;
	}
	public void setHz(String hz) {
		this.hz = hz;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
