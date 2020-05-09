package com.qiyun.hibernate;

public class IntegerBeanLabelItem extends IntegerBeanLabel {

	protected IntegerBeanLabelItem(String className, String name, int value) {
		super(className, name, value);
	}

	/*
	 * public static IntegerBeanLabelItem IntegerBeanLabelItem(String name){
	 * IntegerBeanLabelItem result =(IntegerBeanLabelItem) get(name); if(result ==
	 * null ){ throw new RuntimeException("Result for Name = " + name + " not
	 * defind" ); } return result; }
	 */

	public static IntegerBeanLabelItem getResult(String className, int value) {
		IntegerBeanLabelItem result = (IntegerBeanLabelItem) get(className, value);
		if (result == null) {
			throw new RuntimeException("Result for Value = " + value + " not defind");
		}
		return result;
	}

}
