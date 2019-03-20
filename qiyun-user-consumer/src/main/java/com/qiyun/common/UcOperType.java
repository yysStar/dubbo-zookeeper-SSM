package com.qiyun.common;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>用户中心操作类型</p>
 * @author tangfeng
 */
public class UcOperType extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = 1L;
	
	public static final UcOperType RESET_PWD = new UcOperType("重置登录密码", 1);
	
	public static final UcOperType BIND_MOBILE = new UcOperType("绑定手机", 2);
	
	public static final UcOperType VERIFY_MOBILE = new UcOperType("验证手机", 3);
	
	public static final UcOperType UPDATE_MOBILE = new UcOperType("修改手机", 4);
	
	public static final UcOperType BIND_EMAIL = new UcOperType("绑定邮箱", 5);
	
	public static final UcOperType VERIFY_EMAIL = new UcOperType("验证邮箱", 6);
	
	public static final UcOperType UPDATE_EMAIL = new UcOperType("修改邮箱", 7);
	
	public static final UcOperType UPDATE_PROBLEM = new UcOperType("修改密保问题", 8);
	
	public static final UcOperType SET_PWD = new UcOperType("设置登录密码", 9);
	
	public static final UcOperType UPDATE_PWD = new UcOperType("修改登录密码", 10);
	
	public static final UcOperType ACTIVE_MOBILE = new UcOperType("激活手机", 11);
	
	public static final UcOperType ACTIVE_EMAIL = new UcOperType("激活邮箱", 12);
	
	public static final UcOperType FIND_PASSWORD_BY_SMS = new UcOperType("手机短信找回密码", 13);
	
	public static final UcOperType GET_APPS_BY_SMS = new UcOperType("短信获取客户端地址", 14);
	
	public static List<UcOperType> list = new ArrayList<UcOperType>();
	
	static {
		list.add(RESET_PWD);
		list.add(BIND_MOBILE);
		list.add(VERIFY_MOBILE);
		list.add(UPDATE_MOBILE);
		list.add(BIND_EMAIL);
		list.add(VERIFY_EMAIL);
		list.add(UPDATE_EMAIL);
		list.add(UPDATE_PROBLEM);
		list.add(SET_PWD);
		list.add(UPDATE_PWD);
		list.add(ACTIVE_MOBILE);
		list.add(ACTIVE_EMAIL);
		list.add(FIND_PASSWORD_BY_SMS);
		list.add(GET_APPS_BY_SMS);
	}
	
	protected UcOperType(String name, int value) {
		super(UcOperType.class.getName(), name, value);
	}
	
	public static UcOperType getItem(int value) {
		return (UcOperType) getResult(UcOperType.class.getName(), value);
	}
	
	public static List<Integer> getListForInteger(List<UcOperType> operTypeList) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (UcOperType operType : operTypeList) {
			list.add(operType.getValue());
		}
		
		return list;
	}
	
	public static boolean contains(int operType) {
		return getListForInteger(list).contains(operType);
	}
}
