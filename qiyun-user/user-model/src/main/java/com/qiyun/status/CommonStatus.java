package com.qiyun.status;

import com.qiyun.util.IntegerBeanLabel;

import java.util.ArrayList;
import java.util.List;

public class CommonStatus extends IntegerBeanLabel {
	private static final long serialVersionUID = 1L;

	protected CommonStatus(String name, int value) {
		super(CommonStatus.class.getName(), name, value);
	}

	public static CommonStatus getItem(int value) {
		return (CommonStatus) CommonStatus.getResult(CommonStatus.class.getName(), value);
	}

	public static final CommonStatus ALL = new CommonStatus("全部", -1);
	public static final CommonStatus YES = new CommonStatus("是", 0);
	public static final CommonStatus NO = new CommonStatus("否", 1);

	public static final List<CommonStatus> list = new ArrayList<CommonStatus>();

	static{
		list.add(ALL);
		list.add(YES);
		list.add(NO);
	}
}
