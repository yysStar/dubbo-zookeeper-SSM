package com.qiyun.model;


public enum OptionItemRQSPF implements OptionItem {
	WIN("胜", "3", "03"), DRAW("平", "1", "01"), LOSE("负", "0", "00");

	private final String text;
	private final String value;
	private final String bozhongValue;

	private OptionItemRQSPF(String text, String value, String bozhongValue) {
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
		OptionItemRQSPF[] optionItems = OptionItemRQSPF.values();
		String[] valueArr = new String[optionItems.length];
		for (int i = 0, length = optionItems.length; i < length; i++) {
			valueArr[i] = optionItems[i].getValue();
		}
		return valueArr;
	}

	public static OptionItemRQSPF getItemByValue(String value) {
		OptionItemRQSPF[] values = OptionItemRQSPF.values();
		for (OptionItemRQSPF item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemRQSPF getItemByBozhongValue(String value) {
		OptionItemRQSPF[] values = OptionItemRQSPF.values();
		for (OptionItemRQSPF item : values) {
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
