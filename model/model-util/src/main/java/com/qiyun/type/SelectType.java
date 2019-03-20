package com.qiyun.type;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class SelectType extends IntegerBeanLabelItem {

	protected SelectType(String name, int value) {
		super(SelectType.class.getName(), name, value);
	}

	public static SelectType getItem(int value) {
		return (SelectType) SelectType.getResult(SelectType.class.getName(), value);
	}

	public static final SelectType ALL = new SelectType("全部方式", -1);
	public static final SelectType UPLOAD = new SelectType("文件上传", 1);

	public static final SelectType CHOOSE_SELF = new SelectType("自选", 2);
	public static final SelectType IVR_CHOOSE = new SelectType("IVR语音投注", 3);
	public static List list = new ArrayList();

	static {
		list.add(UPLOAD);
		list.add(CHOOSE_SELF);
		list.add(IVR_CHOOSE);
	}
}
