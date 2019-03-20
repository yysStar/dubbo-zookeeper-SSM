package com.qiyun.lottery;

import com.qiyun.tools.DateTools;

import java.util.Date;

/**
 * 方案一个进度点的model
 * 
 * @author Administrator
 * 
 */
public class PlanPointModel {
	private String text; // 文字说明
	private Date time; // 时间
	private boolean isFinsih; // 是否完成
	private String progress; // 进度条
	private boolean isPart;//是否部分开奖
	
	public PlanPointModel(){};
	public PlanPointModel(String text,Date time,boolean isFinish,String progress,boolean isPart){
		this.text=text;
		this.time=time;
		this.isFinsih=isFinish;
		this.progress=progress;
		this.isPart=isPart;
	}
	public String getTimeStr(){
		return time==null?"": DateTools.dateToString(time, "yyyy/MM/dd HH:mm:ss");
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}
	public boolean getIsFinsih() {
		return isFinsih;
	}
	public void setIsFinsih(boolean isFinsih) {
		this.isFinsih = isFinsih;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public boolean getIsPart() {
		return isPart;
	}
	public void setIsPart(boolean isPart) {
		this.isPart = isPart;
	}
}
