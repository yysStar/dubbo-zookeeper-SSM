package com.qiyun.commonModel;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 错误状态.
 * 
 * @author sxh 
 * @date   2011-11-30
 */
public class ErrorStatus extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = 1L;

	protected ErrorStatus(String name, int value) {
		super(ErrorStatus.class.getName(), name, value);
	}
	
	public static ErrorStatus getItem(int value) {
		return (ErrorStatus) ErrorType.getResult(ErrorStatus.class.getName(), value);
	}
	
	public final static ErrorStatus ALL = new ErrorStatus("全部", -1);
	public final static ErrorStatus UNTREAT = new ErrorStatus("未处理", 1);
	public final static ErrorStatus TREATED = new ErrorStatus("已处理", 3);
	
	public static List<ErrorStatus> list = new ArrayList<ErrorStatus>();
	
	static {
		list.add(ErrorStatus.ALL);
		list.add(ErrorStatus.UNTREAT);
		list.add(ErrorStatus.TREATED);
	}
}
