package com.qiyun.item;

public enum OptionItemSFC implements OptionItem {

	HW1TO5("主胜1-5", "0", "51"), HW6TO10("主胜6-10", "1", "52"), HW11TO15("主胜11-15", "2", "53"), HW16TO20("主胜16-20", "3", "54"), HW21TO25("主胜21-25",
			"4", "55"), HW26("主胜26+", "5", "56"), GW1TO5("客胜1-5", "6", "01"), GW6TO10("客胜6-10", "7", "02"), GW11TO15("客胜11-15", "8", "03"), GW16TO20(
			"客胜16-20", "9", "04"), GW21TO25("客胜21-25", "10", "05"), GW26("客胜26+", "11", "06");

	private final String text;
	private final String value;
	private final String bozhongValue;

	private OptionItemSFC(String text, String value, String bozhongValue) {
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

	public static OptionItemSFC getItemByValue(String value) {
		OptionItemSFC[] values = OptionItemSFC.values();
		for (OptionItemSFC item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemSFC getItemByBozhongValue(String value) {
		OptionItemSFC[] values = OptionItemSFC.values();
		for (OptionItemSFC item : values) {
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
