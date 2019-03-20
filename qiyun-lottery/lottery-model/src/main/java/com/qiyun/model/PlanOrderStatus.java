package com.qiyun.model;

import java.util.ArrayList;
import java.util.List;


public class PlanOrderStatus extends IntegerBeanLabelItem {

	protected PlanOrderStatus(String name, int value) {
		super(PlanOrderStatus.class.getName(), name, value);
	}

	public static PlanOrderStatus getItem(int value) {
		return (PlanOrderStatus) PlanOrderStatus.getResult(PlanOrderStatus.class.getName(), value);
	}

	public static final PlanOrderStatus NOT_PAY = new PlanOrderStatus("未支付", 1);

	public static final PlanOrderStatus PAYED = new PlanOrderStatus("已支付", 2);

	public static final PlanOrderStatus RETUREN_MONEY = new PlanOrderStatus("已退款", 3);

	public static final PlanOrderStatus PART_RETUREN_MONEY = new PlanOrderStatus("部分退款", 4);
	//新增状态
	public static final PlanOrderStatus REVIEW = new PlanOrderStatus("订单审核",5);
	public static List list = new ArrayList();

	static {
		list.add(NOT_PAY);
		list.add(PAYED);
		list.add(RETUREN_MONEY);
		list.add(PART_RETUREN_MONEY);
	}
}
