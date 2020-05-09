package com.qiyun.status;

import com.qiyun.hibernate.IntegerBeanLabelItem;

public class ChaseTermStatus extends IntegerBeanLabelItem {

	protected ChaseTermStatus(String name, int value) {
		super(ChaseTermStatus.class.getName(), name, value);
	}

	public static final ChaseTermStatus NOT_BEGIN = new ChaseTermStatus("未开始", 1);

	public static final ChaseTermStatus CHASING = new ChaseTermStatus("出票中", 4);
	
	public static final ChaseTermStatus SUCCESS = new ChaseTermStatus("已出票", 2);
	
	public static final ChaseTermStatus TICKET_CANCEL = new ChaseTermStatus("未出票作废", 5);

	public static final ChaseTermStatus CANCEL = new ChaseTermStatus("已撤消", 3);

}
