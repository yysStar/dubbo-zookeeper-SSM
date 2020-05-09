package com.qiyun.model;

import java.util.HashMap;
import java.util.Map;

import com.qiyun.commonModel.LotteryType;

public enum OptionItemHT implements OptionItem {

	WIN("主胜", "3", "01"), LOSE("客胜", "0", "00"), WIN_RF("让分主胜", "3", "01"), LOSE_RF("让分客胜", "0", "00"), BIG("大", "3", "01"), SMALL("小", "0", "02"), HW1TO5(
			"主胜1-5", "0", "51"), HW6TO10("主胜6-10", "1", "52"), HW11TO15("主胜11-15", "2", "53"), HW16TO20("主胜16-20", "3", "54"), HW21TO25("主胜21-25",
			"4", "55"), HW26("主胜26+", "5", "56"), GW1TO5("客胜1-5", "6", "01"), GW6TO10("客胜6-10", "7", "02"), GW11TO15("客胜11-15", "8", "03"), GW16TO20(
			"客胜16-20", "9", "04"), GW21TO25("客胜21-25", "10", "05"), GW26("客胜26+", "11", "06");
	private final String text;
	private final String value;
	private final String bozhongValue;
	public static final Map<String, OptionItemHT> RFSFMAP = new HashMap<String, OptionItemHT>();
	
	public static final Map<String, OptionItemHT> SFMAP = new HashMap<String, OptionItemHT>();
	
	public static final Map<String, OptionItemHT> DXFMAP = new HashMap<String, OptionItemHT>();
	
	public static final Map<String, OptionItemHT> SFCMAP = new HashMap<String, OptionItemHT>();
	static{
		RFSFMAP.put("3", WIN_RF);
		RFSFMAP.put("0", LOSE_RF);
		SFMAP.put("3", WIN);
		SFMAP.put("0", LOSE);
		DXFMAP.put("3", BIG);
		DXFMAP.put("0", SMALL);
		SFCMAP.put("0", HW1TO5);
		SFCMAP.put("1", HW6TO10);
		SFCMAP.put("2", HW11TO15);
		SFCMAP.put("3", HW16TO20);
		SFCMAP.put("4", HW21TO25);
		SFCMAP.put("5", HW26);
		SFCMAP.put("6", GW1TO5);
		SFCMAP.put("7", GW6TO10);
		SFCMAP.put("8", GW11TO15);
		SFCMAP.put("9", GW16TO20);
		SFCMAP.put("10", GW21TO25);
		SFCMAP.put("11", GW26);
	}

	private OptionItemHT(String text, String value, String bozhongValue) {
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

	public static OptionItemHT getItemByValue(String lotteryType, String value) {
		OptionItemHT[] values = OptionItemHT.values();
		for (OptionItemHT item : values) {
			if (item.value.equals(value)) {
				// 验证是让球胜平负,还是胜平负
				if (lotteryType.equals(LotteryType.JC_LQ_RFSF.getValue()+"")) {
					item=RFSFMAP.get(value);
				} else if (lotteryType.equals(LotteryType.JC_LQ_SF.getValue()+"")) {
					item=SFMAP.get(value);
				}else if (lotteryType.equals(LotteryType.JC_LQ_DXF.getValue()+"")) {
					item=DXFMAP.get(value);
				}else if (lotteryType.equals(LotteryType.JC_LQ_SFC.getValue()+"")) {
					item=SFCMAP.get(value);
				}else{
					throw new RuntimeException("彩种类型错误");
				}
				return item;
			}
		}
		throw new RuntimeException("选项获取错误");
	}

	public static OptionItemHT getItemByBozhongValue(String value) {
		OptionItemHT[] values = OptionItemHT.values();
		for (OptionItemHT item : values) {
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
