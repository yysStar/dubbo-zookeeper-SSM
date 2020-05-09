package com.qiyun.grabber;

import com.qiyun.hibernate.IntegerBeanLabelItem;

public class ChaseTermCancelType extends IntegerBeanLabelItem {
	protected ChaseTermCancelType(String name, int value) {
		super(ChaseTermCancelType.class.getName(), name, value);
	}
	public static final ChaseTermCancelType SYSTEM_CANCEL  = new ChaseTermCancelType("系统撤销", 1);
	public static final ChaseTermCancelType CUSTOM_SERVICE_CANCEL  = new ChaseTermCancelType("客服撤销", 2);
	public static final ChaseTermCancelType USER_CANCEL  = new ChaseTermCancelType("客户撤销", 3);
}
