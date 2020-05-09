package com.qiyun.item;

public enum OptionItemRFSF implements OptionItem {

	WIN("让分主胜", "3", "01"), LOSE("让分客胜", "0", "00");

	private final String text;
	private final String value;
	private final String bozhongValue;

	private OptionItemRFSF(String text, String value, String bozhongValue) {
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

	public static OptionItemRFSF getItemByValue(String value) {
		OptionItemRFSF[] values = OptionItemRFSF.values();
		for (OptionItemRFSF item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemRFSF getItemByBozhongValue(String value) {
		OptionItemRFSF[] values = OptionItemRFSF.values();
		for (OptionItemRFSF item : values) {
			if (item.bozhongValue.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static String[] getAllValue() {
		OptionItemRFSF[] optionItems = OptionItemRFSF.values();
		String[] valueArr = new String[optionItems.length];
		for (int i = 0, length = optionItems.length; i < length; i++) {
			valueArr[i] = optionItems[i].getValue();
		}
		return valueArr;
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
