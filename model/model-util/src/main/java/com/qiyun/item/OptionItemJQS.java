package com.qiyun.item;


public enum OptionItemJQS implements OptionItem {
	/** 0进球 */
	S0("0", "0", "00"),

	/** 1进球 */
	S1("1", "1", "01"),

	/** 2进球 */
	S2("2", "2", "02"),

	/** 3进球 */
	S3("3", "3", "03"),

	/** 4进球 */
	S4("4", "4", "04"),

	/** 5进球 */
	S5("5", "5", "05"),

	/** 6进球 */
	S6("6", "6", "06"),

	/** 7个以上进球 */
	S7("7", "7+", "07");

	private final String text;

	private final String value;

	private final String bozhongValue;

	private OptionItemJQS(String value, String text, String bozhongValue) {
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

	public static OptionItemJQS getItemByValue(String value) {
		OptionItemJQS[] values = OptionItemJQS.values();
		for (OptionItemJQS item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemJQS getItemByBozhongValue(String value) {
		OptionItemJQS[] values = OptionItemJQS.values();
		for (OptionItemJQS item : values) {
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
