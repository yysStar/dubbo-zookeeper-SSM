package com.qiyun.support;


import com.qiyun.model.IntegerBeanLabelItem;

public class ExpertType extends IntegerBeanLabelItem {

	protected ExpertType(String name, int value) {
		super(ExpertType.class.getName(), name, value);
	}
	
	public static ExpertType getItem(int value) {
		return (ExpertType) ExpertType.getResult(ExpertType.class.getName(), value);
	}
	public final static ExpertType NENO = new ExpertType("全部", -1);
	public final static ExpertType FREE = new ExpertType("免费专家", 1);
	public final static ExpertType NO_FREE = new ExpertType("收费专家", 2);

}
