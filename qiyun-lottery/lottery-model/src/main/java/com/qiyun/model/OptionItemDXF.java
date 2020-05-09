package com.qiyun.model;

public enum OptionItemDXF implements OptionItem {
	BIG("大", "3", "01"), SMALL("小", "0", "02");

	private final String text;
	private final String value;
	private final String bozhongValue;

	private OptionItemDXF(String text, String value, String bozhongValue) {
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

	public static OptionItemDXF getItemByValue(String value) {
		OptionItemDXF[] values = OptionItemDXF.values();
		for (OptionItemDXF item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemDXF getItemByBozhongValue(String value) {
		OptionItemDXF[] values = OptionItemDXF.values();
		for (OptionItemDXF item : values) {
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
