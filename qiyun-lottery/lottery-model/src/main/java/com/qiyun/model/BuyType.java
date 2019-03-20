package com.qiyun.model;

import java.util.ArrayList;
import java.util.List;


public class BuyType extends IntegerBeanLabelItem {

	protected BuyType(String name, int value) {
		super(BuyType.class.getName(), name, value);
	}

	public static BuyType getItem(int value) {
		return (BuyType) BuyType.getResult(BuyType.class.getName(), value);
	}

	public static final BuyType SELF_BUY = new BuyType("认购", 1);

	public static final BuyType BAODI = new BuyType("保底", 2);

	public static List list = new ArrayList();

	static {
		list.add(SELF_BUY);
		list.add(BAODI);
	}

}
