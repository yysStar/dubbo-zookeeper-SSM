package com.qiyun.model;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class MemberReturnPoint extends IntegerBeanLabelItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -673842902790013796L;
	
	protected MemberReturnPoint(String name, int value) {
		super(MemberReturnPoint.class.getName(), name, value);
	}

	public static MemberReturnPoint getItem(int value) {
		return (MemberReturnPoint) MemberReturnPoint.getResult(MemberReturnPoint.class.getName(), value);
	}

	public static final MemberReturnPoint ALL = new MemberReturnPoint("全选", -1);
	public static final MemberReturnPoint NO_RETURN_POINT = new MemberReturnPoint("非返点用户", 0);
	public static final MemberReturnPoint YES_RETURN_POINT = new MemberReturnPoint("返点用户", 1);
	
	public static List list = new ArrayList();

	static {
		list.add(ALL);
		list.add(NO_RETURN_POINT);
		list.add(YES_RETURN_POINT);
	}
}
