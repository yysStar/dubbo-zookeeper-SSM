package com.qiyun.item;


public enum OptionItemDCSXDS implements OptionItem {
	// 上单，上双，下单，下双
	upOdd("上单", "0", "0","0"), upEven("上双", "1", "1","1"), downOdd("下单", "2", "2","2"), downEven("下双", "3", "3","3");

	private final String text;
	private final String value;
	private final String bozhongValue;
	private final String dsOption;// 单式上传显示值

	private OptionItemDCSXDS(String text, String value, String bozhongValue,String dsOption) {
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
		OptionItemDCSXDS[] optionItems = OptionItemDCSXDS.values();
		String[] valueArr = new String[optionItems.length];
		for (int i = 0, length = optionItems.length; i < length; i++) {
			valueArr[i] = optionItems[i].getValue();
		}
		return valueArr;
	}

	public static OptionItemDCSXDS getItemByValue(String value) {
		OptionItemDCSXDS[] values = OptionItemDCSXDS.values();
		for (OptionItemDCSXDS item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemDCSXDS getItemByBozhongValue(String value) {
		OptionItemDCSXDS[] values = OptionItemDCSXDS.values();
		for (OptionItemDCSXDS item : values) {
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
