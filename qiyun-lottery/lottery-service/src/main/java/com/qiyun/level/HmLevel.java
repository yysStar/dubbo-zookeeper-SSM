package com.qiyun.level;

public interface HmLevel {

	/**
	 * 根据彩种，彩期统计等级。
	 * 
	 * @param lotteryType term
	 *            彩期表对象
	 * @return 如果符合条件返回true,不符合条件返回false.
	 */
	public boolean level(int lotteryType, String term);
}
