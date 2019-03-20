package com.qiyun.item;


public enum OptionItemBF implements OptionItem {
	/** 1:0 */
	WIN10("10", "1:0", "10"),

	/** 2:0 */
	WIN20("20", "2:0", "20"),

	/** 2:1 */
	WIN21("21", "2:1", "21"),

	/** 3:0 */
	WIN30("30", "3:0", "30"),

	/** 3:1 */
	WIN31("31", "3:1", "31"),

	/** 3:2 */
	WIN32("32", "3:2", "32"),

	/** 4:0 */
	WIN40("40", "4:0", "40"),

	/** 4:1 */
	WIN41("41", "4:1", "41"),

	/** 4:2 */
	WIN42("42", "4:2", "42"),

	/** 5:0 */
	WIN50("50", "5:0", "50"),

	/** 5:1 */
	WIN51("51", "5:1", "51"),

	/** 5:2 */
	WIN52("52", "5:2", "52"),

	/** 胜其它 */
	WIN_OTHER("WW", "胜其它", "3A"),

	/** 0:0 */
	DRAW00("00", "0:0", "00"),

	/** 1:1 */
	DRAW11("11", "1:1", "11"),

	/** 2:2 */
	DRAW22("22", "2:2", "22"),

	/** 3:3 */
	DRAW33("33", "3:3", "33"),

	/** 0:0 */
	DRAW_OTHER("DD", "平其它", "1A"),

	/** 0:1 */
	LOSE01("01", "0:1", "01"),

	/** 0:2 */
	LOSE02("02", "0:2", "02"),

	/** 1:2 */
	LOSE12("12", "1:2", "12"),

	/** 0:3 */
	LOSE03("03", "0:3", "03"),

	/** 1:3 */
	LOSE13("13", "1:3", "13"),

	/** 2:3 */
	LOSE23("23", "2:3", "23"),

	/** 0:4 */
	LOSE04("04", "0:4", "04"),

	/** 1:4 */
	LOSE14("14", "1:4", "14"),

	/** 2:4 */
	LOSE24("24", "2:4", "24"),

	/** 0:5 */
	LOSE05("05", "0:5", "05"),

	/** 1:5 */
	LOSE15("15", "1:5", "15"),

	/** 2:5 */
	LOSE25("25", "2:5", "25"),

	/** 负其它 */
	LOSE_OTHER("LL", "负其它", "0A");

	private final String text;

	private final String value;

	private final String bozhongValue;

	public static final OptionItemBF[] WINS = { WIN10, WIN20, WIN21, WIN30, WIN31, WIN32, WIN40, WIN41, WIN42, WIN50, WIN51, WIN52, WIN_OTHER };
	public static final OptionItemBF[] DRAWS = { DRAW00, DRAW11, DRAW22, DRAW33, DRAW_OTHER };
	public static final OptionItemBF[] LOSES = { LOSE01, LOSE02, LOSE12, LOSE03, LOSE13, LOSE23, LOSE04, LOSE14, LOSE24, LOSE05, LOSE15, LOSE25,
			LOSE_OTHER };

	private OptionItemBF(String value, String text, String bozhongValue) {
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

	public static OptionItemBF getItemByValue(String value) {
		OptionItemBF[] values = OptionItemBF.values();
		for (OptionItemBF item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		value = value.trim();
		Integer f = Integer.parseInt(value.substring(0, 1));
		Integer l = Integer.parseInt(value.substring(1));
		if (f > l) {
			return OptionItemBF.WIN_OTHER;
		} else if (f == l) {
			return OptionItemBF.DRAW_OTHER;
		} else {
			return OptionItemBF.LOSE_OTHER;
		}
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
