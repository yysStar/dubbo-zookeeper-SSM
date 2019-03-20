package com.qiyun.model2;

import java.util.HashMap;
import java.util.Map;


import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.OptionItem;

public enum OptionItemHTZQ implements OptionItem {
	/** 让球胜平负 */
	// 顺序对应MatchAwardOfHT 的getAward顺序
	WIN_RQ("3", "让球胜", "03"),

	LOSE_RQ("0", "让球负", "00"),

	DRAW_RQ("1", "让球平", "01"),
	/** 胜平负 */
	WIN("3", "胜", "03"),

	LOSE("0", "负", "00"),

	DRAW("1", "平", "01"),
	/** 0进球 */
	S0("0", "0", "00"),

	/** 1进球 */
	S1("1", "1", "01"),

	/** 2进球 */
	S2("2", "2", "02"),

	/** 3进球 */
	S3("3", "3", "03"),

	/** 4进球 */
	S4("4", "4", "04"),

	/** 5进球 */
	S5("5", "5", "05"),

	/** 6进球 */
	S6("6", "6", "06"),

	/** 7个以上进球 */
	S7("7", "7+", "07"),
	/** 胜胜 */
	WIN_WIN("33", "胜胜", "33"),

	/** 胜平 */
	WIN_DRAW("31", "胜平", "31"),

	/** 胜负 */
	WIN_LOSE("30", "胜负", "30"),

	/** 平胜 */
	DRAW_WIN("13", "平胜", "13"),

	/** 平平 */
	DRAW_DRAW("11", "平平", "11"),

	/** 平负 */
	DRAW_LOSE("10", "平负", "10"),

	/** 负胜 */
	LOSE_WIN("03", "负胜", "03"),

	/** 负平 */
	LOSE_DRAW("01", "负平", "01"),

	/** 负负 */
	LOSE_LOSE("00", "负负", "00"),

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
	public static final Map<String, OptionItemHTZQ> SPFMAP = new HashMap<String, OptionItemHTZQ>();
	
	public static final Map<String, OptionItemHTZQ> RQSPFMAP = new HashMap<String, OptionItemHTZQ>();
	
	public static final Map<String, OptionItemHTZQ> BFMAP = new HashMap<String, OptionItemHTZQ>();
	
	public static final Map<String, OptionItemHTZQ> JQSMAP = new HashMap<String, OptionItemHTZQ>();
	
	public static final Map<String, OptionItemHTZQ> BQCMAP = new HashMap<String, OptionItemHTZQ>();
	static{
		SPFMAP.put("3", WIN);
		SPFMAP.put("1", DRAW);
		SPFMAP.put("0", LOSE);
		RQSPFMAP.put("3", WIN_RQ);
		RQSPFMAP.put("1", DRAW_RQ);
		RQSPFMAP.put("0", LOSE_RQ);
		JQSMAP.put("0",S0);
		JQSMAP.put("1",S1);
		JQSMAP.put("2",S2);
		JQSMAP.put("3",S3);
		JQSMAP.put("4",S4);
		JQSMAP.put("5",S5);
		JQSMAP.put("6",S6);
		JQSMAP.put("7",S7);
		BQCMAP.put("33", WIN_WIN);
		BQCMAP.put("31", WIN_DRAW);
		BQCMAP.put("30", WIN_LOSE);
		BQCMAP.put("13", DRAW_WIN);
		BQCMAP.put("11", DRAW_DRAW);
		BQCMAP.put("10", DRAW_LOSE);
		BQCMAP.put("03", LOSE_WIN);
		BQCMAP.put("01", LOSE_DRAW);
		BQCMAP.put("00", LOSE_LOSE);
		BFMAP.put("10",WIN10);
		BFMAP.put("20",WIN20);
		BFMAP.put("21",WIN21);
		BFMAP.put("30",WIN30);
		BFMAP.put("31",WIN31);
		BFMAP.put("32",WIN32);
		BFMAP.put("40",WIN40);
		BFMAP.put("41",WIN41);
		BFMAP.put("42",WIN42);
		BFMAP.put("50",WIN50);
		BFMAP.put("51",WIN51);
		BFMAP.put("52",WIN52);
		BFMAP.put("WW",WIN_OTHER);
		BFMAP.put("00",DRAW00);
		BFMAP.put("11",DRAW11);
		BFMAP.put("22",DRAW22);
		BFMAP.put("33",DRAW33);
		BFMAP.put("DD",DRAW_OTHER);
		BFMAP.put("01",LOSE01);
		BFMAP.put("02",LOSE02);
		BFMAP.put("12",LOSE12);
		BFMAP.put("03",LOSE03);
		BFMAP.put("13",LOSE13);
		BFMAP.put("23",LOSE23);
		BFMAP.put("04",LOSE04);
		BFMAP.put("14",LOSE14);
		BFMAP.put("24",LOSE24);
		BFMAP.put("05",LOSE05);
		BFMAP.put("15",LOSE15);
		BFMAP.put("25",LOSE25);
		BFMAP.put("LL" ,LOSE_OTHER);
	}
	private OptionItemHTZQ(String value, String text, String bozhongValue) {
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


	public static OptionItemHTZQ getItemByValue(String lotteryType, String value) {
		OptionItemHTZQ[] values = OptionItemHTZQ.values();
		for (OptionItemHTZQ item : values) {
			if (item.value.equals(value)) {
				// 验证是让球胜平负,还是胜平负
				if (lotteryType.equals(LotteryType.JC_ZQ_SPF.getValue()+"")) {
					item=SPFMAP.get(value);
				} else if (lotteryType.equals(LotteryType.JC_ZQ_RQSPF.getValue()+"")) {
					item=RQSPFMAP.get(value);
				}else if (lotteryType.equals(LotteryType.JC_ZQ_BF.getValue()+"")) {
					item=BFMAP.get(value);
				}else if (lotteryType.equals(LotteryType.JC_ZQ_JQS.getValue()+"")) {
					item=JQSMAP.get(value);
				}else if (lotteryType.equals(LotteryType.JC_ZQ_BQC.getValue()+"")) {
					item=BQCMAP.get(value);
				}else{
					throw new RuntimeException("彩种类型错误");
				}
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
