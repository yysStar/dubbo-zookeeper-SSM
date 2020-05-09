package com.qiyun.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

/*
 * 数字类型转换类
 */
public class NumberTools {
	public static final String NUMBER_REG="^([-|\\+]?\\d+)(\\.\\d+)?$";
    private static final Integer DEF_DIV_SCALE = 2;   //默认精确2位小数


	/**
	 * 把数字转换成固定位数的字符串。不足的补0
	 * 
	 * @param number
	 * @param weishu
	 * @return
	 */
	public static String IntToString(Integer number, int weishu) {
		if (number == null) {
			number = new Integer(0);
		}
		StringBuffer result = new StringBuffer();
		String numberStr = number.toString();
		int temp = weishu - numberStr.length();
		if (temp < 0) {
			return "-1";
		} else {
			for (int i = 0; i < temp; i++) {
				result.append("0");
			}
		}
		result.append(number);
		return result.toString();
	}

	public static String doubleToString(Double number) {
		// 转换为1,000,000,000,000的形式输出
		NumberFormat formatter = new DecimalFormat("#,###,###,###,###");
		if (number != null)
			return formatter.format(number);
		else
			return "0";
	}
	public static String formatDouble(Double number,String format){
		NumberFormat formatter = new DecimalFormat(format);
		if (number != null)
			return formatter.format(number);
		else
			return "0";
	}
	
	public static Double formatDouble2(Double number,String format){
		return Double.parseDouble(formatDouble(number,format)) ;
	}
	
	public static String doubleToMoneyString(Double number) {
		// 转换为1,000,000,000,000的形式输出
		NumberFormat formatter = new DecimalFormat("###############.00");
		if (number != null){
			if(0 <= number && number < 1)
				return  0 + formatter.format(number);
			else	
				return formatter.format(number);
		}
		else
			return "0";
	}
	public static String doubleToString(Double number,boolean isGroup) {
		NumberFormat formatter = new DecimalFormat("###############");//不保留小数
		formatter.setGroupingUsed(isGroup);//是否分组
		if (number != null)
			return formatter.format(number);
		else
			return "0";
	}
	/**
	 * 货币格式字符串转换为double
	 * @param moneyStr	货币格式字符串
	 * @return
	 */
	public static Double moneySringToDouble(String moneyStr) {
		NumberFormat numberFormat1 = NumberFormat.getNumberInstance();
		Number numb1 = null;
		try {
			numb1 = numberFormat1.parse(moneyStr);
		} catch (ParseException e) {
			LogUtil.error(e);
		}
		return numb1.doubleValue();
	}

	public static Double formatDouble(Double number, int weishu) {
		int offset = 1;
		for (int i = 0; i < weishu; i++) {
			offset *= 10;
		}
		if (number != null)
			return (int) (number * offset) / (offset * 1.0d);
		else
			return 0d;
	}

	/*
	 * 数字转化为百分比格式
	 */
	public static String doubleToPercent(Double number, String fomatStr) {
		DecimalFormat format = null;
		format = (DecimalFormat) NumberFormat.getPercentInstance();
		format.applyPattern(fomatStr); // 0表示加的小数点,0.00表示两位小数点，
		if (number != null)
			return "" + format.format(number);
		else
			return "0%";
	}

	/*
	 * 数字转化为百分比格式
	 */
	public static String doubleToPercent(Double number) {
		return doubleToPercent(number, "0.00%");
	}

	public static int[] stringToNumArr(String source, String splitStr) {
		String[] tempArr = source.split(splitStr);
		int[] result = new int[tempArr.length];
		int len = tempArr.length;
		for (int i = 0; i < len; i++) {
			result[i] = Integer.valueOf(tempArr[i]);
		}
		return result;
	}

	public static List queryListTypeConvert(List list) {
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			for (int j = 0; j < obj.length; j++) {
				if (obj[j].getClass().getName().equals("java.math.BigDecimal")) {
					String s = String.valueOf(obj[j]);
					if (s.contains("."))
						obj[j] = ((BigDecimal) obj[j]).doubleValue();
					else
						obj[j] = ((BigDecimal) obj[j]).intValue();
				}
			}
			list.set(i, obj);
		}
		return list;
	}

	public static double String2Double(String doubleStr, double defaultValue) {
		if (isNum(doubleStr)) {
			return Double.parseDouble(doubleStr);
		} else {
			return defaultValue;
		}
	}

	public static boolean isNum(String str){
		if(str==null){
			return false;
		}
		return str.replaceAll("\\s", "").matches(NUMBER_REG);
	}	
	
	/*
	 * 四舍五入保留小数点后两位
	 */
	public static double bigDecimal(double d){
		BigDecimal b = new BigDecimal(d);
		return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
    /** 
     * 提供精确的加法运算。 
     * @param value1 被加数 
     * @param value2 加数 
     * @return 两个参数的和 
     */  
    public static Double add(Number value1, Number value2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));  
        BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));  
        return b1.add(b2).doubleValue();  
    }  
  
    /** 
     * 提供精确的减法运算。 
     *  
     * @param value1 
     *            被减数 
     * @param value2 
     *            减数 
     * @return 两个参数的差 
     */  
    public static double sub(Number value1, Number value2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));  
        BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));  
        return b1.subtract(b2).doubleValue();  
    }  
  
    /** 
     * 提供精确的乘法运算。 
     *  
     * @param value1 
     *            被乘数 
     * @param value2 
     *            乘数 
     * @return 两个参数的积 
     */  
    public static Double mul(Number value1, Number value2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));  
        BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));  
        return b1.multiply(b2).doubleValue();  
    }  
  
    /** 
     * 提供（相对）精确的除法运算，当发生除不尽的情况时， 精确到小数点以后10位，以后的数字四舍五入。 
     *  
     * @param dividend 
     *            被除数 
     * @param divisor 
     *            除数 
     * @return 两个参数的商 
     */  
    public static Double div(Double dividend, Double divisor) {  
        return div(dividend, divisor, DEF_DIV_SCALE);  
    }  
  
    /** 
     * 提供（相对）精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。 
     *  
     * @param dividend 
     *            被除数 
     * @param divisor 
     *            除数 
     * @param scale 
     *            表示表示需要精确到小数点以后几位。 
     * @return 两个参数的商 
     */  
    public static Double div(Double dividend, Double divisor, Integer scale) {  
        if (scale < 0) {  
            throw new IllegalArgumentException(  
                    "The scale must be a positive integer or zero");  
        }  
        BigDecimal b1 = new BigDecimal(Double.toString(dividend));  
        BigDecimal b2 = new BigDecimal(Double.toString(divisor));  
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();  
    }  
  
    /** 
     * 提供精确的小数位四舍五入处理。 
     *  
     * @param value 
     *            需要四舍五入的数字 
     * @param scale 
     *            小数点后保留几位 
     * @return 四舍五入后的结果 
     */  
    public static Double round(Double value, Integer scale) {
    	if (value==null){
    		return null;
		}
        if (scale < 0) {  
            throw new IllegalArgumentException(  
                    "The scale must be a positive integer or zero");  
        }  
        BigDecimal b = new BigDecimal(Double.toString(value));  
        BigDecimal one = new BigDecimal("1");  
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();  
    }
    
    /**
     * 使用java正则表达式去掉多余的.与0
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s){    
    	if(s.indexOf(".") > 0){    
	    	s = s.replaceAll("0+?$", "");//去掉多余的0     
	    	s = s.replaceAll("[.]$", "");//如最后一位是.则去掉     
    	}    
    	return s;    
    }


}
