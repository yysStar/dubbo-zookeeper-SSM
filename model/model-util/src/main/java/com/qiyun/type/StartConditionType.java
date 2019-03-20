package com.qiyun.type;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 追号开始条件类别
 * 
 * @author sxh 2011-5-17
 */
public class StartConditionType extends IntegerBeanLabelItem {
	protected StartConditionType(String name, int value) {
		super(StartConditionType.class.getName(), name, value);
	}

	public static StartConditionType getItem(int value) {
		return (StartConditionType) StartConditionType.getResult(StartConditionType.class.getName(), value);
	}

	public static final StartConditionType BY_MISS = new StartConditionType("按遗漏", 1);
	public static final StartConditionType BY_FLOW = new StartConditionType("按跟随", 2);

	public static List list = new ArrayList();

	static {
		list.add(BY_MISS);
		list.add(BY_FLOW);
	}
}
