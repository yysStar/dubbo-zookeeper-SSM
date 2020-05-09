package com.qiyun.item;

import com.qiyun.commonModel.LotteryType;

import java.util.HashMap;
import java.util.Map;

public enum OptionItemHT2C1 implements OptionItem {
	/** 让球胜平负 */
	// 顺序对应MatchAwardOfHT 的getAward顺序
	WIN_RQ("3", "主不败-让球胜", "03"),
	LOSE_RQ("0", "客不败-让球负", "00"),
	DRAW_RQ("1", "让球平-让球平", "01"),

	/** 胜平负 */
	WIN("3", "主胜-胜", "03"),
	LOSE("0", "客胜-负", "00"),
	DRAW("1", "平-平", "01");

	

	private final String text;

	private final String value;

	private final String bozhongValue;
	public static final Map<String, OptionItemHT2C1> SPFMAP = new HashMap<String, OptionItemHT2C1>();
	
	public static final Map<String, OptionItemHT2C1> RQSPFMAP = new HashMap<String, OptionItemHT2C1>();
	
	static{
		SPFMAP.put("3", WIN);
		SPFMAP.put("1", DRAW);
		SPFMAP.put("0", LOSE);
		RQSPFMAP.put("3", WIN_RQ);
		RQSPFMAP.put("1", DRAW_RQ);
		RQSPFMAP.put("0", LOSE_RQ);
	}
	private OptionItemHT2C1(String value, String text, String bozhongValue) {
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


	public static OptionItemHT2C1 getItemByValue(String lotteryType, String value) {
		OptionItemHT2C1[] values = OptionItemHT2C1.values();
		for (OptionItemHT2C1 item : values) {
			if (item.value.equals(value)) {
				// 验证是让球胜平负,还是胜平负
				if (lotteryType.equals(LotteryType.JC_ZQ_SPF.getValue()+"")) {
					item=SPFMAP.get(value);
				} else if (lotteryType.equals(LotteryType.JC_ZQ_RQSPF.getValue()+"")) {
					item=RQSPFMAP.get(value);
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
