package com.qiyun.status;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class ChaseStatus extends IntegerBeanLabelItem {

	protected ChaseStatus(String name, int value) {
		super(ChaseStatus.class.getName(), name, value);
	}

	public static ChaseStatus getItem(int value) {
		return (ChaseStatus) ChaseStatus.getResult(ChaseStatus.class.getName(), value);
	}

	public static final ChaseStatus ALL = new ChaseStatus("所有", -1);

	public static final ChaseStatus CHASING = new ChaseStatus("未完成", 1);

	public static final ChaseStatus CHASE_CANCEL = new ChaseStatus("已撤消", 2);

	public static final ChaseStatus CHASE_END = new ChaseStatus("已完成", 3);

	public static List list = new ArrayList();

	static {
		list.add(ALL);
		list.add(CHASING);
		list.add(CHASE_CANCEL);
		list.add(CHASE_END);
	}
}
