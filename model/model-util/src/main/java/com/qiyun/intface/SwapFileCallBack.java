package com.qiyun.intface;

import com.qiyun.util.LogUtil;

import java.lang.reflect.Field;

public class SwapFileCallBack implements CompareCallBack {

	public Object callBack(Object obj1, Object obj2, String fieldName) {
		Class c1 = obj1.getClass();
		Field field;
		try {
			field = c1.getDeclaredField(fieldName);
			field.setAccessible(true);
			Object v2 = field.get(obj2);
			field.set(obj1, v2);
			return obj1;
		} catch (SecurityException e) {
			LogUtil.error(e);
		} catch (NoSuchFieldException e) {
			if (c1.getSuperclass() != null) {
				callBack(c1.getSuperclass(), obj1, obj2, fieldName);
			} else {
				LogUtil.error(e);
			}
		} catch (IllegalArgumentException e) {
			LogUtil.error(e);
		} catch (IllegalAccessException e) {
			LogUtil.error(e);
		}
		return null;
	}

	public Object callBack(Class clz, Object obj1, Object obj2, String fieldName) {

		Field field;
		try {
			field = clz.getDeclaredField(fieldName);
			field.setAccessible(true);
			Object v2 = field.get(obj2);
			field.set(obj1, v2);
			return obj1;
		} catch (SecurityException e) {
			LogUtil.error(e);
		} catch (NoSuchFieldException e) {
			if (clz.getSuperclass() != null) {
				return callBack(clz.getSuperclass(), obj1, obj2, fieldName);
			} else {
				LogUtil.error(e);
			}
		} catch (IllegalArgumentException e) {
			LogUtil.error(e);
		} catch (IllegalAccessException e) {
			LogUtil.error(e);
		}
		return null;
	}
}
