package com.qiyun.model;


public enum OptionItemDCRQSPF implements OptionItem {
	WIN("胜", "3", "03","3"), DRAW("平", "1", "01","1"), LOSE("负", "0", "00","0");

	private final String text;
	private final String value;
	private final String bozhongValue;
	private final String dsOption;//单式上传显示值

	private OptionItemDCRQSPF(String text, String value, String bozhongValue,String dsOption) {
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

	public static String[] getAllValue() {
		OptionItemDCRQSPF[] optionItems = OptionItemDCRQSPF.values();
		String[] valueArr = new String[optionItems.length];
		for (int i = 0, length = optionItems.length; i < length; i++) {
			valueArr[i] = optionItems[i].getValue();
		}
		return valueArr;
	}

	public static OptionItemDCRQSPF getItemByValue(String value) {
		OptionItemDCRQSPF[] values = OptionItemDCRQSPF.values();
		for (OptionItemDCRQSPF item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemDCRQSPF getItemByBozhongValue(String value) {
		OptionItemDCRQSPF[] values = OptionItemDCRQSPF.values();
		for (OptionItemDCRQSPF item : values) {
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
