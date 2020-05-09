package com.qiyun.lottery;

import com.qiyun.model.IntegerBeanLabelItem;

/**
 * 大奖级别
 * @author wb
 * @since 2015.04.09
 */
public class AwardLevel extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 1L;

	protected AwardLevel(String name, int value) {
		super(AwardLevel.class.getName(), name, value);
	}
	
	public static AwardLevel getItem(int value) {
		return (AwardLevel) AwardLevel.getResult(AwardLevel.class.getName(), value);
	}
	
	public final static AwardLevel GE = new AwardLevel("个万", 0);
	public final static AwardLevel SHI = new AwardLevel("十万", 1);
	public final static AwardLevel BAI = new AwardLevel("百万", 2);
	public final static AwardLevel QIAN = new AwardLevel("千万", 3);
}
