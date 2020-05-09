package com.qiyun.type;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class PackageType extends IntegerBeanLabelItem {

	protected PackageType(String name, int value) {
		super(PackageType.class.getName(), name, value);
	}

	public static PackageType getItem(int value) {
		return (PackageType) PackageType.getResult(PackageType.class.getName(), value);
	}

	public static final PackageType ALL = new PackageType("所有", -1);
	public static final PackageType NOT_PACKAGE = new PackageType("非套餐", 0);
	public static final PackageType PACKAGE = new PackageType("套餐", 1);

	public static List list = new ArrayList();

	static {
		list.add(ALL);
		list.add(NOT_PACKAGE);
		list.add(PACKAGE);
	}

}
