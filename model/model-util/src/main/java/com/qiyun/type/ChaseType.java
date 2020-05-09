package com.qiyun.type;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class ChaseType extends IntegerBeanLabelItem {

	protected ChaseType(String name, int value) {
		super(ChaseType.class.getName(), name, value);
	}

	public static ChaseType getItem(int value) {
		return (ChaseType) ChaseType.getResult(ChaseType.class.getName(), value);
	}

	public static final ChaseType ALL = new ChaseType("所有", -1);
	public static final ChaseType SELF_CHOOSE = new ChaseType("自选追号", 1);

	public static final ChaseType MACHINE_CHOOSE = new ChaseType("机选追号", 2);

	public static final ChaseType DIANDAN_CHOOSE = new ChaseType("定胆追号", 3);
	public static List list = new ArrayList();

	static {
		list.add(ALL);
		list.add(SELF_CHOOSE);
		list.add(MACHINE_CHOOSE);
		list.add(DIANDAN_CHOOSE);
	}
}
