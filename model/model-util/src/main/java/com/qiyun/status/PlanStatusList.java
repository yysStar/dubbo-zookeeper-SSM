package com.qiyun.status;

/**
 * 方案状态列表
 * @author wb
 *
 */
public class PlanStatusList {
	//状态内容
	private String statusName;
	//状态改变时间
	private String statusTime;
	//状态其它说明
	private String otherText;
	public PlanStatusList() {
	}

	public PlanStatusList(String statusName, String statusTime, String otherText) {
		super();
		this.statusName = statusName;
		this.statusTime = statusTime;
		this.otherText = otherText;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getOtherText() {
		return otherText;
	}

	public void setOtherText(String otherText) {
		this.otherText = otherText;
	}

	public String getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}
	
	public String toString(){
		return "statusName:"+statusName+" statusTime:"+statusTime+" otherText:"+otherText;
	}

}