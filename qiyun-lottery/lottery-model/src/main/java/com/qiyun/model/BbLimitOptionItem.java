package com.qiyun.model;

import java.util.HashSet;
import java.util.Set;

public enum BbLimitOptionItem {
	WIN("主胜", "3", 30, 0), LOSE("客胜", "0", 30, 1), WIN_RF("让分主胜", "3", 31, 0), LOSE_RF("让分客胜", "0", 31, 1), BIG("大", "3", 33, 0), SMALL("小", "0", 33,
			1), HW1TO5("主胜1-5", "0", 32, 0), HW6TO10("主胜6-10", "1", 32, 1), HW11TO15("主胜11-15", "2", 32, 2), HW16TO20("主胜16-20", "3", 32, 3), HW21TO25(
			"主胜21-25", "4", 32, 4), HW26("主胜26+", "5", 32, 5), GW1TO5("客胜1-5", "6", 32, 6), GW6TO10("客胜6-10", "7", 32, 7), GW11TO15("客胜11-15", "8",
			32, 8), GW16TO20("客胜16-20", "9", 32, 9), GW21TO25("客胜21-25", "10", 32, 10), GW26("客胜26+", "11", 32, 11);

	private final String text;

	private final String value;

	private final Integer lotteryType;

	private final Integer bit;// bit位移个数 不能大于31

	private BbLimitOptionItem(String text, String value, Integer lotteryType, Integer bit) {
		this.value = value;
		this.text = text;
		this.lotteryType = lotteryType;
		this.bit = bit;
	}

	public static BbLimitOptionItem findByText(String text) {
		BbLimitOptionItem[] items = BbLimitOptionItem.values();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getText().equals(text)) {
				return items[i];
			}
		}
		return null;
	}

	public static Set<BbLimitOptionItem> getSFItems() {
		Set<BbLimitOptionItem> set = new HashSet<BbLimitOptionItem>();
		set.add(WIN);
		set.add(LOSE);
		return set;
	}

	public static Set<BbLimitOptionItem> getRFSFItems() {
		Set<BbLimitOptionItem> set = new HashSet<BbLimitOptionItem>();
		set.add(WIN_RF);
		set.add(LOSE_RF);
		return set;
	}

	public static Set<BbLimitOptionItem> getDXFItems() {
		Set<BbLimitOptionItem> set = new HashSet<BbLimitOptionItem>();
		set.add(BIG);
		set.add(SMALL);
		return set;
	}

	public static Set<BbLimitOptionItem> getSFCItems() {
		Set<BbLimitOptionItem> set = new HashSet<BbLimitOptionItem>();
		set.add(HW1TO5);
		set.add(HW6TO10);
		set.add(HW11TO15);
		set.add(HW16TO20);
		set.add(HW21TO25);
		set.add(HW26);

		set.add(GW1TO5);
		set.add(GW6TO10);
		set.add(GW11TO15);
		set.add(GW16TO20);
		set.add(GW21TO25);
		set.add(GW26);

		return set;
	}

	public String getText() {
		return text;
	}

	public String getValue() {
		return value;
	}

	public Integer getLotteryType() {
		return lotteryType;
	}

	public Integer getBit() {
		return bit;
	}
	
	public Integer getOrdinal(){
		return this.ordinal();
	}
}
