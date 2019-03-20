package com.qiyun.model;


public enum OptionItemGYJ implements OptionItem {
	FIRST("冠军", "3", "3"), SECODE("亚军", "1", "1");

	private final String text;
	private final String value;
	private final String bozhongValue;

	private OptionItemGYJ(String text, String value, String bozhongValue) {
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

	public static String[] getAllValue() {
		OptionItemGYJ[] optionItems = OptionItemGYJ.values();
		String[] valueArr = new String[optionItems.length];
		for (int i = 0, length = optionItems.length; i < length; i++) {
			valueArr[i] = optionItems[i].getValue();
		}
		return valueArr;
	}

	public static OptionItemGYJ getItemByValue(String value) {
		OptionItemGYJ[] values = OptionItemGYJ.values();
		for (OptionItemGYJ item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemGYJ getItemByBozhongValue(String value) {
		OptionItemGYJ[] values = OptionItemGYJ.values();
		for (OptionItemGYJ item : values) {
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
