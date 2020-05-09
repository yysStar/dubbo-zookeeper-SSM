package com.qiyun.item;


public enum OptionItemDCJQS implements OptionItem {
	/** 0进球 */
	S0("0", "0", "00","0"),

	/** 1进球 */
	S1("1", "1", "01","1"),

	/** 2进球 */
	S2("2", "2", "02","2"),

	/** 3进球 */
	S3("3", "3", "03","3"),

	/** 4进球 */
	S4("4", "4", "04","4"),

	/** 5进球 */
	S5("5", "5", "05","5"),

	/** 6进球 */
	S6("6", "6", "06","6"),

	/** 7个以上进球 */
	S7("7", "7+", "07","7");

	private final String text;

	private final String value;

	private final String bozhongValue;
	
	private final String dsOption;//单式上传显示值

	private OptionItemDCJQS(String value, String text, String bozhongValue,String dsOption) {
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

	public static OptionItemDCJQS getItemByValue(String value) {
		OptionItemDCJQS[] values = OptionItemDCJQS.values();
		for (OptionItemDCJQS item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemDCJQS getItemByBozhongValue(String value) {
		OptionItemDCJQS[] values = OptionItemDCJQS.values();
		for (OptionItemDCJQS item : values) {
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
