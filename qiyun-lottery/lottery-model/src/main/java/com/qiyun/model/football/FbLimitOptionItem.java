package com.qiyun.model.football;

import java.util.HashSet;
import java.util.Set;

public enum FbLimitOptionItem {
	/** 让球胜平负 */
	WIN_RQ("3", "让球胜", 34, 0),

	DRAW_RQ("1", "让球平", 34, 1),

	LOSE_RQ("0", "让球负", 34, 2),
	/** 胜平负 */
	WIN("3", "胜", 41, 0), DRAW("1", "平", 41, 1), LOSE("0", "负", 41, 2),

	/** 0进球 */
	S0("0", "0", 36, 0),

	/** 1进球 */
	S1("1", "1", 36, 1),

	/** 2进球 */
	S2("2", "2", 36, 2),

	/** 3进球 */
	S3("3", "3", 36, 3),

	/** 4进球 */
	S4("4", "4", 36, 4),

	/** 5进球 */
	S5("5", "5", 36, 5),

	/** 6进球 */
	S6("6", "6", 36, 6),

	/** 7个以上进球 */
	S7("7", "7+", 36, 7),
	/** 胜胜 */
	WIN_WIN("33", "胜胜", 37, 0),

	/** 胜平 */
	WIN_DRAW("31", "胜平", 37, 1),

	/** 胜负 */
	WIN_LOSE("30", "胜负", 37, 2),

	/** 平胜 */
	DRAW_WIN("13", "平胜", 37, 3),

	/** 平平 */
	DRAW_DRAW("11", "平平", 37, 4),

	/** 平负 */
	DRAW_LOSE("10", "平负", 37, 5),

	/** 负胜 */
	LOSE_WIN("03", "负胜", 37, 6),

	/** 负平 */
	LOSE_DRAW("01", "负平", 37, 7),

	/** 负负 */
	LOSE_LOSE("00", "负负", 37, 8),

	/** 1:0 */
	WIN10("10", "1:0", 35, 0),

	/** 2:0 */
	WIN20("20", "2:0", 35, 1),

	/** 2:1 */
	WIN21("21", "2:1", 35, 2),

	/** 3:0 */
	WIN30("30", "3:0", 35, 3),

	/** 3:1 */
	WIN31("31", "3:1", 35, 4),

	/** 3:2 */
	WIN32("32", "3:2", 35, 5),

	/** 4:0 */
	WIN40("40", "4:0", 35, 6),

	/** 4:1 */
	WIN41("41", "4:1", 35, 7),

	/** 4:2 */
	WIN42("42", "4:2", 35, 8),

	/** 5:0 */
	WIN50("50", "5:0", 35, 9),

	/** 5:1 */
	WIN51("51", "5:1", 35, 10),

	/** 5:2 */
	WIN52("52", "5:2", 35, 11),

	/** 胜其它 */
	WIN_OTHER("WW", "胜其它", 35, 12),

	/** 0:0 */
	DRAW00("00", "0:0", 35, 13),

	/** 1:1 */
	DRAW11("11", "1:1", 35, 14),

	/** 2:2 */
	DRAW22("22", "2:2", 35, 15),

	/** 3:3 */
	DRAW33("33", "3:3", 35, 16),

	/** 0:0 */
	DRAW_OTHER("DD", "平其它", 35, 17),

	/** 0:1 */
	LOSE01("01", "0:1", 35, 18),

	/** 0:2 */
	LOSE02("02", "0:2", 35, 19),

	/** 1:2 */
	LOSE12("12", "1:2", 35, 20),

	/** 0:3 */
	LOSE03("03", "0:3", 35, 21),

	/** 1:3 */
	LOSE13("13", "1:3", 35, 22),

	/** 2:3 */
	LOSE23("23", "2:3", 35, 23),

	/** 0:4 */
	LOSE04("04", "0:4", 35, 24),

	/** 1:4 */
	LOSE14("14", "1:4", 35, 25),

	/** 2:4 */
	LOSE24("24", "2:4", 35, 26),

	/** 0:5 */
	LOSE05("05", "0:5", 35, 27),

	/** 1:5 */
	LOSE15("15", "1:5", 35, 28),

	/** 2:5 */
	LOSE25("25", "2:5", 35, 29),

	/** 负其它 */
	LOSE_OTHER("LL", "负其它", 35, 30);

	private final String text;

	private final String value;

	private final Integer lotteryType;

	private final Integer bit;// bit 不能大于31

	private FbLimitOptionItem(String value, String text, Integer lotteryType, Integer bit) {
		this.value = value;
		this.text = text;
		this.lotteryType = lotteryType;
		this.bit = bit;
	}

	public static FbLimitOptionItem findByText(String text) {
		FbLimitOptionItem[] items = FbLimitOptionItem.values();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getText().equals(text)) {
				return items[i];
			}
		}
		return null;
	}

	public static Set<FbLimitOptionItem> getSpfItems() {
		Set<FbLimitOptionItem> set = new HashSet<FbLimitOptionItem>();
		set.add(WIN);
		set.add(DRAW);
		set.add(LOSE);
		return set;
	}

	public static Set<FbLimitOptionItem> getRqspfItems() {
		Set<FbLimitOptionItem> set = new HashSet<FbLimitOptionItem>();
		set.add(WIN_RQ);
		set.add(DRAW_RQ);
		set.add(LOSE_RQ);
		return set;
	}

	public static Set<FbLimitOptionItem> getJqsItems() {
		Set<FbLimitOptionItem> set = new HashSet<FbLimitOptionItem>();
		set.add(S0);
		set.add(S1);
		set.add(S2);
		set.add(S3);
		set.add(S4);
		set.add(S5);
		set.add(S6);
		set.add(S7);
		return set;
	}

	public static Set<FbLimitOptionItem> getBqcItems() {
		Set<FbLimitOptionItem> set = new HashSet<FbLimitOptionItem>();
		set.add(WIN_WIN);
		set.add(WIN_DRAW);
		set.add(WIN_LOSE);
		set.add(DRAW_WIN);
		set.add(DRAW_DRAW);
		set.add(DRAW_LOSE);
		set.add(LOSE_WIN);
		set.add(LOSE_DRAW);
		set.add(LOSE_LOSE);
		return set;
	}

	public static Set<FbLimitOptionItem> getBfItems() {
		Set<FbLimitOptionItem> set = new HashSet<FbLimitOptionItem>();
		set.add(WIN10);
		set.add(WIN20);
		set.add(WIN21);
		set.add(WIN30);
		set.add(WIN31);
		set.add(WIN32);
		set.add(WIN40);
		set.add(WIN41);
		set.add(WIN42);
		set.add(WIN50);
		set.add(WIN51);
		set.add(WIN52);
		set.add(WIN_OTHER);
		set.add(DRAW00);
		set.add(DRAW11);
		set.add(DRAW22);
		set.add(DRAW33);
		set.add(DRAW_OTHER);
		set.add(LOSE01);
		set.add(LOSE02);
		set.add(LOSE12);
		set.add(LOSE03);
		set.add(LOSE13);
		set.add(LOSE23);
		set.add(LOSE04);
		set.add(LOSE14);
		set.add(LOSE24);
		set.add(LOSE05);
		set.add(LOSE15);
		set.add(LOSE25);
		set.add(LOSE_OTHER);
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

	/**
	 * bit <= 31
	 * 
	 * @return
	 */
	public Integer getBit() {
		return bit;
	}
	
	public Integer getOrdinal(){
		return this.ordinal();
	}
}
