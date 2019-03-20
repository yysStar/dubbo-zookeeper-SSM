package com.qiyun.tools;

import java.util.Arrays;
import java.util.List;

public class StringTools {

	// 判断字符串是否空或null
	public static boolean isNullOrBlank(String s) {
		if (s == null || s.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字段串获取List
	 * @param s
	 * @return
	 */
	public static List<String> StringToList(String s){
		String str[] = s.split(",");
		return Arrays.asList(str);
	}

	public static String getPlayTypeByPassType(String p){
		if("P1".equals(p)) {
			return "500";
		} else if("P2_1".equals(p)){
			return "502";
		} else if("P3_1".equals(p)){
			return "503";
		} else if("P3_1".equals(p)){
			return "503";
		} else if("P4_1".equals(p)){
			return "504";
		} else if("P5_1".equals(p)){
			return "505";
		} else if("P6_1".equals(p)){
			return "506";
		} else if("P7_1".equals(p)){
			return "507";
		} else if("P8_1".equals(p)){
			return "508";
		}
		return null;
	}
}