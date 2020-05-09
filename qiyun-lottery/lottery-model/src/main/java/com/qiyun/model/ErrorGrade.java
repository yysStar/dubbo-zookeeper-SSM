package com.qiyun.model;



import com.qiyun.commonModel.ErrorType;

import java.util.ArrayList;
import java.util.List;
import com.qiyun.hibernate.IntegerBeanLabelItem;

/**
 * 错误等级.
 * 
 * @author sxh 
 * @date   2011-11-30
 */
public class ErrorGrade extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = 1L;

	protected ErrorGrade(String name, int value) {
		super(ErrorGrade.class.getName(), name, value);
	}
	
	public static ErrorGrade getItem(int value) {
		return (ErrorGrade) ErrorType.getResult(ErrorGrade.class.getName(), value);
	}
	/**
	 * name:无 value:-1
	 */
	public final static ErrorGrade ALL = new ErrorGrade("无", -1);
	/**
	 * name:紧急 value:1
	 */
	public final static ErrorGrade URGENT = new ErrorGrade("紧急", 1);
	/**
	 * name:重要 value:2
	 */
	public final static ErrorGrade IMPORTANT = new ErrorGrade("重要", 2);
	/**
	 * name:普通 value:3
	 */
	public final static ErrorGrade GENERAL = new ErrorGrade("普通", 3);
	
	public static List<ErrorGrade> list = new ArrayList<ErrorGrade>();
	
	static {
		list.add(ErrorGrade.ALL);
		list.add(ErrorGrade.URGENT);
		list.add(ErrorGrade.IMPORTANT);
		list.add(ErrorGrade.GENERAL);
	}
}
