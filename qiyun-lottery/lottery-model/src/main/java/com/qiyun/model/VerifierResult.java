package com.qiyun.model;

import java.util.List;

/**
 * @author andy 验证的返回封装类
 */
public class VerifierResult {

	// 金额
	private double amount;
	// 注数
	private int count;
	// 格式内容
	private String formatContent;
	// 验证结果消息
	private String message;
	// 是否通过
	private boolean isPass;
	
	private Integer playType;
	
	private List<Integer> playTypes;
	
	//篮球让分 与大小分
	private String RF;
	
	private String DXF;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFormatContent() {
		return formatContent;
	}

	public void setFormatContent(String formatContent) {
		this.formatContent = formatContent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isPass() {
		return isPass;
	}

	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}

	public Integer getPlayType() {
		return playType;
	}

	public void setPlayType(Integer playType) {
		this.playType = playType;
	}

	public String getRF() {
		return RF;
	}

	public void setRF(String rf) {
		RF = rf;
	}

	public String getDXF() {
		return DXF;
	}

	public void setDXF(String dxf) {
		DXF = dxf;
	}

	public List<Integer> getPlayTypes() {
		return playTypes;
	}

	public void setPlayTypes(List<Integer> playTypes) {
		this.playTypes = playTypes;
	}


	

}
