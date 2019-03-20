package com.qiyun.model;

/**
 * 投注过关方式
 */
public enum PassMode {
	/** 单关 */
	SINGLE("单关"),

	/** 过关 */
	PASS("过关");

	private final String text;

	private PassMode(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
