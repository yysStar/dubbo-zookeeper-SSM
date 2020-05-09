package com.qiyun.model;

import java.util.List;

/**
 * 过滤条件
 * 
 * @author tiger
 * 
 */
public class Conditions {
	private Integer winMinValue;
	private Integer winMaxValue;
	private Integer loseMinValue;
	private Integer loseMaxValue;
	private Integer commonMaxFaultCount;
	private Integer commonMinFaultCount;
	private Integer commonMinFault;
	private Integer commonMaxFault;
	private Boolean winCanFault;
	private Boolean loseCanFault;
	private Boolean hitCanFault;
	private String[] hitConditions;
	private Integer totalMinFault;
	private Integer totalMaxFault;
	private Double minReturnPercent;
	private Double maxReturnPercent;

	private List<String> groupInfos;

	public Integer getWinMinValue() {
		return winMinValue;
	}

	public void setWinMinValue(Integer winMinValue) {
		this.winMinValue = winMinValue;
	}

	public Integer getWinMaxValue() {
		return winMaxValue;
	}

	public void setWinMaxValue(Integer winMaxValue) {
		this.winMaxValue = winMaxValue;
	}

	public Integer getLoseMinValue() {
		return loseMinValue;
	}

	public void setLoseMinValue(Integer loseMinValue) {
		this.loseMinValue = loseMinValue;
	}

	public Integer getLoseMaxValue() {
		return loseMaxValue;
	}

	public void setLoseMaxValue(Integer loseMaxValue) {
		this.loseMaxValue = loseMaxValue;
	}

	public Integer getCommonMaxFaultCount() {
		return commonMaxFaultCount;
	}

	public void setCommonMaxFaultCount(Integer commonMaxFaultCount) {
		this.commonMaxFaultCount = commonMaxFaultCount;
	}

	public Integer getCommonMinFaultCount() {
		return commonMinFaultCount;
	}

	public void setCommonMinFaultCount(Integer commonMinFaultCount) {
		this.commonMinFaultCount = commonMinFaultCount;
	}

	public Boolean getWinCanFault() {
		return winCanFault;
	}

	public void setWinCanFault(Boolean winCanFault) {
		this.winCanFault = winCanFault;
	}

	public Boolean getLoseCanFault() {
		return loseCanFault;
	}

	public void setLoseCanFault(Boolean loseCanFault) {
		this.loseCanFault = loseCanFault;
	}

	public Integer getCommonMinFault() {
		return commonMinFault;
	}

	public void setCommonMinFault(Integer commonMinFault) {
		this.commonMinFault = commonMinFault;
	}

	public Integer getCommonMaxFault() {
		return commonMaxFault;
	}

	public void setCommonMaxFault(Integer commonMaxFault) {
		this.commonMaxFault = commonMaxFault;
	}

	public String[] getHitConditions() {
		return hitConditions;
	}

	public void setHitConditions(String[] hitConditions) {
		this.hitConditions = hitConditions;
	}

	public Integer getTotalMinFault() {
		return totalMinFault;
	}

	public void setTotalMinFault(Integer totalMinFault) {
		this.totalMinFault = totalMinFault;
	}

	public Integer getTotalMaxFault() {
		return totalMaxFault;
	}

	public void setTotalMaxFault(Integer totalMaxFault) {
		this.totalMaxFault = totalMaxFault;
	}

	public Boolean getHitCanFault() {
		return hitCanFault;
	}

	public void setHitCanFault(Boolean hitCanFault) {
		this.hitCanFault = hitCanFault;
	}

	public List<String> getGroupInfos() {
		return groupInfos;
	}

	public void setGroupInfos(List<String> groupInfos) {
		this.groupInfos = groupInfos;
	}

	public Double getMinReturnPercent() {
		return minReturnPercent;
	}

	public void setMinReturnPercent(Double minReturnPercent) {
		this.minReturnPercent = minReturnPercent;
	}

	public Double getMaxReturnPercent() {
		return maxReturnPercent;
	}

	public void setMaxReturnPercent(Double maxReturnPercent) {
		this.maxReturnPercent = maxReturnPercent;
	}

}
