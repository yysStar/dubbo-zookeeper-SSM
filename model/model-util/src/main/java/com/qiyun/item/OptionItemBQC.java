package com.qiyun.item;


public enum OptionItemBQC implements OptionItem {
	/** 胜胜 */
	WIN_WIN("33", "胜胜", "33"),

	/** 胜平 */
	WIN_DRAW("31", "胜平", "31"),

	/** 胜负 */
	WIN_LOSE("30", "胜负", "30"),

	/** 平胜 */
	DRAW_WIN("13", "平胜", "13"),

	/** 平平 */
	DRAW_DRAW("11", "平平", "11"),

	/** 平负 */
	DRAW_LOSE("10", "平负", "10"),

	/** 负胜 */
	LOSE_WIN("03", "负胜", "03"),

	/** 负平 */
	LOSE_DRAW("01", "负平", "01"),

	/** 负负 */
	LOSE_LOSE("00", "负负", "00");

	private final String text;

	private final String value;

	private final String bozhongValue;

	private OptionItemBQC(String value, String text, String bozhongValue) {
		this.value = value;
		this.text = text;
		this.bozhongValue = bozhongValue;
	}

	public String getText() {
		return text;
	}

	public String getValue() {
		return value;
	}

	public static OptionItemBQC getItemByValue(String value) {
		OptionItemBQC[] values = OptionItemBQC.values();
		for (OptionItemBQC item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemBQC getItemByBozhongValue(String value) {
		OptionItemBQC[] values = OptionItemBQC.values();
		for (OptionItemBQC item : values) {
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
}
