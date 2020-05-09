package com.qiyun.tools;

import com.qiyun.intface.CompareCallBack;
import com.qiyun.util.LogUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BeanTools {
	/**
	 * 比较两个对象的某些属性进行比较，根据比较结果判定是否调用回调方法。
	 * 注意当obj1属性不为null,obj2属性为null时判断结果为不需调用回调方法。
	 * @param obj1
	 * @param obj2
	 * @param compareFieldNames
	 * @param callBack
	 * @return 是否调用过回调方法
	 */
	public static Boolean compareBean(Object obj1, Object obj2, String[] compareFieldNames,Boolean isNotFillWithNull,
									  CompareCallBack callBack) {
		Class c1 = obj1.getClass();
		Class c2 = obj2.getClass();
		boolean isCallBack=false;
		if (!c1.getName().equals(c2.getName())) {
			throw new RuntimeException("Object class is different");
		}
		if (compareFieldNames == null || compareFieldNames.length == 0)
			compareFieldNames = converterListToArray(getAllFieldNames(obj1));
		for (String fieldName : compareFieldNames) {
			//当属性值不一致时需进行回调
			boolean isNeedCallBack=!compareField(c1, obj1, obj2, fieldName,isNotFillWithNull);
			isCallBack=isCallBack|isNeedCallBack;
			if (isNeedCallBack) {
				callBack.callBack(obj1, obj2, fieldName);
			}
		}
		return isCallBack;
	}
	public static Boolean compareBean(Object obj1, Object obj2, String[] compareFieldNames, CompareCallBack callBack) {
		return compareBean(obj1, obj2,compareFieldNames,true, callBack);
	}
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static List<String> getAllFieldNames(Object obj) {
		Class c1 = obj.getClass();
		return getClassFieldName(c1);
	}

	public static List<String> getClassFieldName(Class clz) {
		List<String> fieldNames = getFieldNames(clz.getDeclaredFields());
		if (clz.getSuperclass() != null) {
			fieldNames.addAll(getClassFieldName(clz.getSuperclass()));
		}
		return fieldNames;
	}

	public static List<String> getFieldNames(Field[] fields) {
		List<String> fieldsNameList = new ArrayList<String>();
		for (Field tempField : fields) {
			fieldsNameList.add(tempField.getName());
		}
		return fieldsNameList;
	}

	/**
	 * 
	 * 转换器ListToArray
	 * 
	 * @param list
	 * @return
	 */
	public static String[] converterListToArray(List<String> list) {

		String[] array = null;

		if (list.size() >= 1) {
			array = new String[list.size()];
			list.toArray(array);

		}

		return array;
	}

	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @param fieldName
	 * @return
	 */
	public static boolean compareField(Class c1, Object obj1, Object obj2, String fieldName) {
		return compareField(c1, obj1, obj2, fieldName,true);
	}
	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @param fieldName
	 * @return
	 */
	public static boolean compareField(Class c1, Object obj1, Object obj2, String fieldName,Boolean isNotFillWithNull ) {
		Field field;
		try {
			field = c1.getDeclaredField(fieldName);
			field.setAccessible(true);
			Object v1 = field.get(obj1);
			Object v2 = field.get(obj2);
			//与null进行比较，
			if(isNotFillWithNull&&v2==null){
				return true;
			}
			if (v1 == null) {
				return false;
			}
			return v1.equals(v2);
		} catch (SecurityException e) {
			LogUtil.error(e);
		} catch (NoSuchFieldException e) {
			if (c1.getSuperclass() != null) {
				return compareField(c1.getSuperclass(), obj1, obj2, fieldName,isNotFillWithNull);
			} else {
				LogUtil.error(e);
			}
		} catch (IllegalArgumentException e) {
			LogUtil.error(e);
		} catch (IllegalAccessException e) {
			LogUtil.error(e);
		}
		return true;
	}
	public static Object compareBean(Object obj1, Object obj2, CompareCallBack callBack) {
		return compareBean(obj1, obj2, null, callBack);
	}

	public static Boolean compareBeanExcluFile(Object obj1, Object obj2, String[] excluNames,Boolean isNotFillWithNull,
											   CompareCallBack callBack) {
		List<String> allFieldNames = getAllFieldNames(obj1);
		for (String excliFieldName : excluNames) {
			int index = allFieldNames.indexOf(excliFieldName);
			if (index != -1) {
				allFieldNames.remove(index);
			}
		}
		return compareBean(obj1, obj2, converterListToArray(allFieldNames),isNotFillWithNull, callBack);
	}
	public static Boolean compareBeanExcluFile(Object obj1, Object obj2, String[] excluNames,
											   CompareCallBack callBack) {
		return compareBeanExcluFile(obj1, obj2, excluNames, true, callBack);
	}
}
