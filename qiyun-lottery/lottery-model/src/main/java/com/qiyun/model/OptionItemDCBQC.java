package com.qiyun.model;


public enum OptionItemDCBQC implements OptionItem {
	/** 胜胜 */
	WIN_WIN("0", "胜胜", "33", "33"),

	/** 胜平 */
	WIN_DRAW("1", "胜平", "31", "31"),

	/** 胜负 */
	WIN_LOSE("2", "胜负", "30", "30"),

	/** 平胜 */
	DRAW_WIN("3", "平胜", "13", "13"),

	/** 平平 */
	DRAW_DRAW("4", "平平", "11", "11"),

	/** 平负 */
	DRAW_LOSE("5", "平负", "10", "10"),

	/** 负胜 */
	LOSE_WIN("6", "负胜", "03", "03"),

	/** 负平 */
	LOSE_DRAW("7", "负平", "01", "01"),

	/** 负负 */
	LOSE_LOSE("8", "负负", "00", "00");

	private final String text;

	private final String value;

	private final String bozhongValue;
	
	private final String dsOption;//单式上传显示值

	private OptionItemDCBQC(String value, String text, String bozhongValue,String dsOption) {
		this.value = value;
		this.text = text;
		this.bozhongValue = bozhongValue;
		this.dsOption=dsOption;
	}

	public String getText() {
		return text;
	}

	public String getValue() {
		return value;
	}

	public static OptionItemDCBQC getItemByValue(String value) {
		OptionItemDCBQC[] values = OptionItemDCBQC.values();
		for (OptionItemDCBQC item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemDCBQC getItemByBozhongValue(String value) {
		OptionItemDCBQC[] values = OptionItemDCBQC.values();
		for (OptionItemDCBQC item : values) {
			if (item.bozhongValue.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public int getOrdinal() {
		return this.ordinal();
	}

	/**
	 * @return the bozhongValue
	 */
	public String getBozhongValue() {
		return bozhongValue;
	}

	public String getDsOption() {
		return dsOption;
	}
}
