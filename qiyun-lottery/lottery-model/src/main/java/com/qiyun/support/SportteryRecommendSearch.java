package com.qiyun.support;

import java.util.List;

/**
 * <p>竞彩靓胆查询条件</p>
 * @author wqs
 */
public class SportteryRecommendSearch
{
	private String term;
	/**
	 * 彩种
	 */
	private Integer lotteryType;
	
	/**
	 * 专家id
	 */
	private Integer expertId;
	
	/**
	 * 联赛名称
	 */
	private List<String> matchNameList;
	
	private List<SportteryRecommendStatus> statusList;
	
	private Integer buyFree;
	
	private Integer buyType;
	
	

	public Integer getLotteryType() {
		if(lotteryType!=null && lotteryType==-1){
			lotteryType=null;
		}
		return lotteryType;
	}

	public void setLotteryType(Integer lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Integer getExpertId() {
		if(expertId!=null && expertId==-1){
			expertId=null;
		}
		return expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public List<SportteryRecommendStatus> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<SportteryRecommendStatus> statusList) {
		this.statusList = statusList;
	}

	public List<String> getMatchNameList() {
		return matchNameList;
	}

	public void setMatchNameList(List<String> matchNameList) {
		this.matchNameList = matchNameList;
	}

	public Integer getBuyFree() {
		return buyFree;
	}

	public void setBuyFree(Integer buyFree) {
		this.buyFree = buyFree;
	}

	public Integer getBuyType() {
		return buyType;
	}

	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
	}
	
}
