package com.qiyun.item;


public enum OptionItemSF implements OptionItem {

	WIN("主胜", "3", "01"), LOSE("客胜", "0", "00");

	private final String text;
	private final String value;
	private final String bozhongValue;

	private OptionItemSF(String text, String value, String bozhongValue) {
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

	public static OptionItemSF getItemByValue(String value) {
		OptionItemSF[] values = OptionItemSF.values();
		for (OptionItemSF item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemSF getItemByBozhongValue(String value) {
		OptionItemSF[] values = OptionItemSF.values();
		for (OptionItemSF item : values) {
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
