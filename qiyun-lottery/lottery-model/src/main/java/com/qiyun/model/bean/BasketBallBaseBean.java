package com.qiyun.model.bean;

/**
 * 
 * 用于封装篮彩500W数据
 * 
 */
public class BasketBallBaseBean extends MatchBaseBean {
	/** 第一节比分* */
	private String firstSection;
	/** 第二节比分* */
	private String secondSection;
	/** 第三节比分* */
	private String thirdSection;
	/** 第四节比分* */
	private String fourthSection;
	/** 加时比分* */
	private String addSection;

	private Integer intTime;
	private Integer lineId;
	private String shortHome;
	private String shortGuest;
	private String shortMatchName;//赛事缩写


	public String getSecondSection() {
		return secondSection;
	}

	public void setSecondSection(String secondSection) {
		this.secondSection = secondSection;
	}

	public String getThirdSection() {
		return thirdSection;
	}

	public void setThirdSection(String thirdSection) {
		this.thirdSection = thirdSection;
	}

	public String getFourthSection() {
		return fourthSection;
	}

	public void setFourthSection(String fourthSection) {
		this.fourthSection = fourthSection;
	}

	public String getAddSection() {
		return addSection;
	}

	public void setAddSection(String addSection) {
		this.addSection = addSection;
	}

	public Integer getIntTime() {
		return intTime;
	}

	public void setIntTime(Integer intTime) {
		this.intTime = intTime;
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public String getShortHome() {
		return shortHome;
	}

	public void setShortHome(String shortHome) {
		this.shortHome = shortHome;
	}

	public String getShortGuest() {
		return shortGuest;
	}

	public void setShortGuest(String shortGuest) {
		this.shortGuest = shortGuest;
	}

	public String getShortMatchName() {
		return shortMatchName;
	}

	public void setShortMatchName(String shortMatchName) {
		this.shortMatchName = shortMatchName;
	}

	public String getFirstSection() {
		return firstSection;
	}

	public void setFirstSection(String firstSection) {
		this.firstSection = firstSection;
	}

}
