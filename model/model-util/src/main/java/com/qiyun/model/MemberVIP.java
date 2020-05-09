package com.qiyun.model;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class MemberVIP extends IntegerBeanLabelItem {
	private static final long serialVersionUID = -673842902790013796L;
	
	protected MemberVIP(String name, int value) {
		super(MemberVIP.class.getName(), name, value);
	}

	public static MemberVIP getItem(int value) {
		return (MemberVIP) MemberVIP.getResult(MemberVIP.class.getName(), value);
	}

	public static final MemberVIP ALL = new MemberVIP("全选", -1);
	public static final MemberVIP NO_VIP = new MemberVIP("普通用户", 0);
	public static final MemberVIP YES_VIP = new MemberVIP("VIP用户", 1);
	
	public static List list = new ArrayList();

	static {
		list.add(ALL);
		list.add(NO_VIP);
		list.add(YES_VIP);
	}
}
