package com.qiyun.common;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @源文件名： IntegerBeanLabel.java
 * @版本信息： v1.00
 * @生成日期： 2008-1-22
 * @作者: huion
 * @描述: 参考:http://www.hibernate.org/288.html Copyright(C) 2008 huacai Ltd. All
 *      rights reserved.
 */
public class IntegerBeanLabel implements Serializable {

	protected static Map<String, Map> nameMap = new HashMap<String, Map>(15);
	protected static Map<String, Map> valueMap = new HashMap<String, Map>(15);

	protected int value;
	protected transient String name;
	protected String className;

	protected IntegerBeanLabel(String className, String name, int value) {
		this.className = className;
		this.value = value;
		this.name = name;
		add();
	}

	protected void add() {
		if (nameMap.containsKey(className)) {
			((Map) nameMap.get(className)).put(this.name, this);
			((Map) valueMap.get(className)).put(new Integer(this.value), this);

			// nameMap.put(this.name, this);
			// valueMap.put(new Integer(this.value), this);
		} else {
			Map nameMaps = new HashMap();
			Map valueMaps = new HashMap();
			nameMaps.put(this.name, this);
			valueMaps.put(new Integer(this.value), this);
			nameMap.put(className, nameMaps);
			valueMap.put(className, valueMaps);
		}

	}

	public static IntegerBeanLabel get(String className, String name) {
		return (IntegerBeanLabel) nameMap.get(className).get(name);
	}

	public static IntegerBeanLabel get(String className, int value) {
		return (IntegerBeanLabel) valueMap.get(className).get(new Integer(value));
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	protected Object readResolve() throws ObjectStreamException {
		return get(this.className, this.value);
	}

}
