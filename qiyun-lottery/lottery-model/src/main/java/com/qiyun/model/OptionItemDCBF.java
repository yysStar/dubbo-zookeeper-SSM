package com.qiyun.model;


public enum OptionItemDCBF implements OptionItem {

	/** 1:0 */
	WIN10("1", "1:0", "10","10"),

	/** 2:0 */
	WIN20("2", "2:0", "20","20"),

	/** 2:1 */
	WIN21("3", "2:1", "21","21"),

	/** 3:0 */
	WIN30("4", "3:0", "30","30"),

	/** 3:1 */
	WIN31("5", "3:1", "31","31"),

	/** 3:2 */
	WIN32("6", "3:2", "32","32"),

	/** 4:0 */
	WIN40("7", "4:0", "40","40"),

	/** 4:1 */
	WIN41("8", "4:1", "41","41"),

	/** 4:2 */
	WIN42("9", "4:2", "42","42"),


	/** 胜其它 */
	WIN_OTHER("0", "胜其它", "WW","WW"),

	/** 0:0 */
	DRAW00("11", "0:0", "00","00"),

	/** 1:1 */
	DRAW11("12", "1:1", "11", "11"),

	/** 2:2 */
	DRAW22("13", "2:2", "22", "22"),

	/** 3:3 */
	DRAW33("14", "3:3", "33", "33"),

	/** 0:0 */
	DRAW_OTHER("10", "平其它", "1A", "DD"),

	/** 0:1 */
	LOSE01("16", "0:1", "01", "01"),

	/** 0:2 */
	LOSE02("17", "0:2", "02", "02"),

	/** 1:2 */
	LOSE12("18", "1:2", "12" , "12"),

	/** 0:3 */
	LOSE03("19", "0:3", "03", "03"),

	/** 1:3 */
	LOSE13("20", "1:3", "13", "13"),

	/** 2:3 */
	LOSE23("21", "2:3", "23", "23"),

	/** 0:4 */
	LOSE04("22", "0:4", "04", "04"),

	/** 1:4 */
	LOSE14("23", "1:4", "14", "14"),

	/** 2:4 */
	LOSE24("24", "2:4", "24", "24"),

	/** 负其它 */
	LOSE_OTHER("15", "负其它", "0A", "LL");

	private final String text;//

	private final String value;

	private final String bozhongValue;
	
	private final String dsOption;//单式上传显示值 

	public static final OptionItemDCBF[] WINS = { WIN10, WIN20, WIN21, WIN30, WIN31, WIN32, WIN40, WIN41, WIN42, WIN_OTHER };
	public static final OptionItemDCBF[] DRAWS = { DRAW00, DRAW11, DRAW22, DRAW33, DRAW_OTHER };
	public static final OptionItemDCBF[] LOSES = { LOSE01, LOSE02, LOSE12, LOSE03, LOSE13, LOSE23, LOSE04, LOSE14, LOSE24,
			LOSE_OTHER };

	private OptionItemDCBF(String value, String text, String bozhongValue,String dsOption) {
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
	
	public String getDsOption(){
		return dsOption;
	}

	public static OptionItemDCBF getItemByValue(String value) {
		OptionItemDCBF[] values = OptionItemDCBF.values();
		for (OptionItemDCBF item : values) {
			if (item.value.equals(value)) {
				return item;
			}
		}
		value = value.trim();
		Integer f = Integer.parseInt(value.substring(0, 1));
		Integer l = Integer.parseInt(value.substring(1));
		if (f > l) {
			return OptionItemDCBF.WIN_OTHER;
		} else if (f == l) {
			return OptionItemDCBF.DRAW_OTHER;
		} else {
			return OptionItemDCBF.LOSE_OTHER;
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
