package com.qiyun.tools;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

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
	
	/**
	 * 字符串补字符
	 * @param origStr 源字符
	 * @param repStr 要补的字符
	 * @param before 在字符前补还是后面补, true从前面开始补
	 * @param strTotallength 补完后的字符总个数
	 * @return
	 */
	public static String appendStr(String origStr,String repStr,boolean before,int strTotallength){
		StringBuilder sb = new StringBuilder();
		strTotallength = strTotallength - origStr.length();
		for(int i = 0 ;i<strTotallength;i++){
			sb.append(repStr);
		}
		if(before)
			sb.append(origStr);
		else{
			sb.insert(0, origStr);
		}
		return sb.toString();
	}

	/**
	 * [3,1,3,0,1]->3|1|3|0|1
	 *
	 * @param strArr
	 * @return
	 */
	public static String formatArr2Or(Collection<String> strArr) {
		return formatArr(strArr, "|");
	}

	public static String formatArr(Collection<String> strArr, String separator) {
		if (strArr == null) {
			return null;
		}
		StringBuffer resultBuffer = new StringBuffer();
		for (String temp : strArr) {
			resultBuffer.append(separator).append(temp);
		}
		String result = (resultBuffer.length() < 1) ? "" : resultBuffer.substring(separator.length());
		return result;
	}

	/**
	 * 判断是否为整数
	 *
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	public static String getSecStr(String src, int start, int end) {
		if (src == null)
			return "";
		StringBuffer des = new StringBuffer();
		for (int i = 0; i < src.length(); i++) {
			if (i >= start && i < end) {
				des.append("*");
			} else {
				des.append(src.charAt(i));
			}

		}
		return des.toString();
	}

}