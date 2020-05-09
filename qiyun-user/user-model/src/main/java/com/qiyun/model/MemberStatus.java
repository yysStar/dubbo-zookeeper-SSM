package com.qiyun.model;

public class MemberStatus extends IntegerBeanLabelItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1410849485815957495L;

	protected MemberStatus(String name, int value) {
		super(MemberStatus.class.getName(), name, value);
	}

	public static MemberStatus getItem(int value) {
		return (MemberStatus) MemberStatus.getResult(MemberStatus.class.getName(), value);
	}

	public static final MemberStatus LOCK = new MemberStatus("锁定", 1);

	public static final MemberStatus UNLOCK = new MemberStatus("正常", 0);

}
