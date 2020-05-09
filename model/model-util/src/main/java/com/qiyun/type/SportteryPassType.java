package com.qiyun.type;

import com.qiyun.commonModel.PlayType;
import com.qiyun.util.MathUtils;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/** 此枚举方法中有采用移位* */
public enum SportteryPassType {
	/** 单关 */
	P1(1, new int[] { 1 }, PlayType.JC_1) {
	},
	/** 2串1 */
	P2_1(2, new int[] { 2 }, PlayType.JC_2_1) {
	},

	/** 3串1 */
	P3_1(3, new int[] { 3 }, PlayType.JC_3_1) {
	},
	/** 4串1 */
	P4_1(4, new int[] { 4 }, PlayType.JC_4_1) {
	},
	/** 5串1 */
	P5_1(5, new int[] { 5 }, PlayType.JC_5_1) {
	},
	/** 6串1 */
	P6_1(6, new int[] { 6 }, PlayType.JC_6_1) {
	},
	/** 7串1 */
	P7_1(7, new int[] { 7 }, PlayType.JC_7_1) {
	},
	/** 8串1 */
	P8_1(8, new int[] { 8 }, PlayType.JC_8_1) {
	},
	/** 竞彩前2 2串1 */
	Q2_P2_1(2, new int[] { 2 }, PlayType.JC_Q2_2_1) {
	},
	//世界杯单关
	WCUP_P2_1(2, new int[] { 2 }, PlayType.JC_WCUP_2_1){};
	// =========================================================================
	/** 单选注数 */
	private final int units;

	/** 选择的场次数目 */
	private final int matchCount;

	/** 过关的场次数目数组 */
	private final int[] passMatchs;

	/** 过关方式名称 */
	private final String text;

	/** 过关方式值，用一个二进制位表示 */
	private final int value;

	private final PlayType type;

	// =========================================================================
	/**
	 *            用二进制的第index位表示该过关方式
	 * @param matchCount
	 *            选择的场次数目
	 * @param passMatchs
	 *            过关的场次数目数组
	 * @param type
	 *            玩法类型
	 */
	private SportteryPassType(int matchCount, int[] passMatchs, PlayType type) {
		int index = this.ordinal();
		this.value = 1 << index;
		this.passMatchs = passMatchs;
		this.matchCount = matchCount;
		int units = 0;
		for (int passMatch : passMatchs) {
			units += MathUtils.comp(passMatch, this.matchCount);
		}
		this.units = units;
		this.type = type;
		if (this.matchCount == 1) {
			this.text = "单关";
		} else {
			this.text = this.matchCount + "x" + this.units;
		}
	}

	// =========================================================================

	public int getUnits() {
		return units;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int[] getPassMatchs() {
		return passMatchs;
	}

	public String getText() {
		return text;
	}

	public int getValue() {
		return value;
	}

	// =========================================================================

	/**
	 * 是否选择了该过关方式
	 * 
	 * @param mixPtValue
	 *            过关方式值（多个过关方式的组合值）
	 * @return 是或否
	 */
	public boolean isSelect(int mixPtValue) {
		return (mixPtValue & getValue()) != 0;
	}

	// =========================================================================
	/**
	 * 根据类型字符串获取过关方式类型
	 * 
	 * @param typeName
	 *            类型字符串
	 * @return 过关方式类型
	 */
	public static SportteryPassType valueOfType(String typeName) {
		if (StringUtils.isNotBlank(typeName)) {
			for (SportteryPassType spPassType : values()) {
				if (spPassType.toString().equalsIgnoreCase(typeName)) {
					return spPassType;
				}
			}
		}
		return null;
	}

	/**
	 * 根据比赛数目获取过关方式
	 * 
	 * @param matchCount
	 * @return
	 */
	public static SportteryPassType getSpPassTypeByMatchCount(int matchCount) {
		for (SportteryPassType spPassType : values()) {
			if (spPassType.getMatchCount() == matchCount) {
				return spPassType;
			}
		}
		return null;
	}

	/**
	 * 根据类型值获取过关方式类型
	 * 
	 * @param value
	 *            类型值
	 * @return 过关方式类型
	 */
	public static SportteryPassType getSpPassType(int value) {
		for (SportteryPassType spPassType : values()) {
			if (spPassType.value == value) {
				return spPassType;
			}
		}
		return null;
	}
	
	/**
	 * 根据类型值获取过关方式类型
	 * 
	 *            类型值
	 * @return 过关方式类型
	 */
	public static SportteryPassType getSpPassType(PlayType playType) {
		for (SportteryPassType spPassType : values()) {
			if (spPassType.getType() == playType) {
				return spPassType;
			}
		}
		return null;
	}

	/**
	 * 根据多个过关方式的组合值获取过关方式类型集合
	 * 
	 * @param mixPtValue
	 *            多个过关方式的组合值
	 * @return 过关方式类型集合
	 */
	public static Set<SportteryPassType> getSpPassTypes(int mixPtValue) {
		Set<SportteryPassType> sets = new LinkedHashSet<SportteryPassType>();
		for (SportteryPassType spPassType : values()) {
			if ((spPassType.value & mixPtValue) != 0) {
				sets.add(spPassType);
			}
		}
		return sets.isEmpty() ? null : sets;
	}

	/**
	 * 获取过关方式字符串
	 * 
	 * @param mixPtValue
	 *            多个过关方式的组合值
	 * @return 过关方式字符串
	 */
	public static String getPassTypeText(int mixPtValue) {
		StringBuffer sb = new StringBuffer();
		if (mixPtValue < 1 || mixPtValue > (1 << values().length)) {
			return null;
		}
		String separator = ",";
		for (SportteryPassType pt : values()) {
			if (pt.isSelect(mixPtValue)) {
				sb.append(pt.text).append(separator);
			}
		}
		if (sb.length() > 0) {
			sb.delete(sb.length() - separator.length(), sb.length());
		}
		return sb.toString();
	}

	public PlayType getType() {
		return type;
	}

}
