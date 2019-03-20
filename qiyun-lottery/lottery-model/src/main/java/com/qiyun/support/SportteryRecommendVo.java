package com.qiyun.support;

import java.util.List;

public class SportteryRecommendVo {
	private Integer expertId; //专家号
	private Double hitRate; //命中率
	private List<SportteryRecommend> trendList; //走势

	public Integer getExpertId() {
		return expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}

	public Double getHitRate() {
		return hitRate;
	}
	
	public String getHitRatePercent() {
		String percent= ((Double)(getHitRate()*100)).intValue() +"%";
		return percent;
	}

	public void setHitRate(Double hitRate) {
		this.hitRate = hitRate;
	}

	public List<SportteryRecommend> getTrendList() {
		return trendList;
	}

	public void setTrendList(List<SportteryRecommend> trendList) {
		this.trendList = trendList;
	}

}
