package com.qiyun.common;

import com.qiyun.commonModel.PlayType;
import com.qiyun.type.SelectType;

public class DcPlanContentInfo {
	//方案类型
	private String planType;
	//过关方式
	private String passType;
	//场次数
	private Integer raceSize;
	public Integer getRaceSize() {
		return raceSize;
	}
	public void setRaceSize(Integer raceSize) {
		this.raceSize = raceSize;
	}
	public String getPassType() {
		return passType;
	}
	public void setPassType(String passType) {
		this.passType = passType;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public static DcPlanContentInfo getInstance(SelectType selectType, String content){
		DcPlanContentInfo info=new DcPlanContentInfo();
		String passTypes=content.split("!")[1].split("#")[0];
		if(passTypes.indexOf("^")!=-1){
			info.setPassType(PlayType.ZYGG.getName());
		}else{
			info.setPassType(PlayType.getItem(Integer.valueOf(passTypes)).getName());
		}
		if(selectType.getValue()==SelectType.UPLOAD.getValue()){
			info.setPlanType("单式");
			String[] races=content.split("#")[1].split("\\;")[0].split(",");
			info.setRaceSize(races.length);
		}else{
			info.setPlanType("复式");
			String[] races=content.split("#")[1].split("\\%")[0].split(";");
			info.setRaceSize(races.length);
		}
		return info;
	}
}
