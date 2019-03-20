package com.qiyun.utils;

import com.qiyun.util.LogUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

public class MathUtil {

	/**
	 * @作者:andy
	 * @描述:求组合C(n,r)
	 * @param n
	 * @param r
	 * @return
	 */
	final static public int getCombinationCount(int n, int r) {
		if (r > n)
			return 0;
		if (r < 0 || n < 0)
			return 0;
		return getFactorial(n).divide(getFactorial(r), BigDecimal.ROUND_HALF_DOWN).divide(getFactorial((n - r)), BigDecimal.ROUND_HALF_DOWN)
				.intValue();
	}

	/**
	 * @作者:andy
	 * @描述:求n的阶乘
	 * @return
	 */
	final static public BigDecimal getFactorial(int num) {
		BigDecimal sum = new BigDecimal(1.0);
		for (int i = 1; i <= num; i++) {
			BigDecimal a = new BigDecimal(new BigInteger(i + ""));
			sum = sum.multiply(a);
		}
		return sum;
	}

	/**
	 * @作者:andy
	 * @描述:随机取的01-36之间的数字
	 * @param n
	 *            取的个数
	 * @param area
	 *            区间
	 * @return
	 */
	final static public String getRandom(int area, int n) {
		Random rd1 = new Random();
		Set set = new HashSet();
		for (int i = 1; i < area; i++) {

			int num = rd1.nextInt(area);
			String strNum = "";
			if (num < 10) {
				if (num != 0) {
					strNum = "0" + num;
					set.add(strNum);
				}

			} else {
				strNum = "" + num;
				set.add(strNum);
			}
			if (set != null && set.size() >= n) {
				break;
			}
		}

		String str = "";// 返回拼的字符串
		Iterator it = set.iterator();
		int i = 0;
		while (it.hasNext()) {
			i++;
			if (i < n) {
				str += it.next() + ",";
			} else {
				str += it.next() + "";
			}

		}
		if(StringTools.isNullOrBlank(str)){
			str = "1";
		}
		return str;
	}

	/**
	 * 累加数组之和
	 * 
	 * @param array
	 * @return 返回累加数组之和
	 */
	public final static int getArraySum(String[] array) {
		int sum = 0;
		for (String n : array) {
			sum += Integer.parseInt(n);
		}
		return sum;
	}

	/**
	 * 找出一个数组中的最大值和最小值之差
	 * 
	 * @param array
	 * @return 返回最大值和最小值之差
	 */
	public final static int getArrayDev(String[] array) {
		int max = Integer.parseInt(array[0]);
		int min = Integer.parseInt(array[0]);
		for (int i = 1; i < array.length; i++) {
			if (Integer.parseInt(array[i]) > max) {
				max = Integer.parseInt(array[i]);
			}
			if (Integer.parseInt(array[i]) < min) {
				min = Integer.parseInt(array[i]);
			}
		}
		return (max - min);
	}

	/**
	 * 找出一个数组中的连号数 比如： {01,02,03,04,05} 表示五连号 {01,02,03,04,08} 表示四连号
	 * {01,02,03,06,08} 表示三连号 {01,02,04,06,08} 表示二连号 {01,03,05,07,09} 表示一连号（无连号）
	 * {01,02,05,06,07} 表示一个二连号和一个三连号 {01,02,05,06,08} 表示两个二连号
	 * 
	 * @param array
	 * @return 返回连号数
	 */
	public final static HashMap<Integer, Integer> getArrayLinkCounts(String[] array) {
		Arrays.sort(array);// 排序
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int link = 0;

		for (int i = 0; i < array.length; i++) {
			if (((i + 1) < array.length) && (Integer.parseInt(array[i]) + 1 == Integer.parseInt(array[i + 1]))) {
				link++;
			} else {
				if (map.containsKey(link + 1)) {
					map.put((link + 1), (map.get(link + 1) + 1));
				} else {
					if (link != 0) {
						map.put((link + 1), 1);
					}
				}
				link = 0;
			}
		}

		if (map.isEmpty()) {
			map.put(1, array.length);
		}

		return map;
	}
	
	public final static int getHeWei(String[] array) {
		//和尾
		String tempSum = String.valueOf(getArraySum(array));
		int sumLen = tempSum.length();
		if(sumLen > 1) {
			tempSum = tempSum.substring(sumLen-1,sumLen);
		}
		return Integer.parseInt(tempSum);
	}

	public static long gys(long a, long b) {
		if (a % b > Math.min(a, b) * 0.02)
			return gys(b, a % b);
		else
			return b;
	}

	public static long gbs(long a, long b) {
		long gys = gys(a, b);
		return a * b / gys;
	}
	
	public static List<Integer> getAvgMulList(List<Double> prizeList,Integer count){
		if(count==null||count.intValue()==0){
			count=prizeList.size()*10;
		}
		Double maxPrize = Collections.max(prizeList);
		List<Double> baseList = new ArrayList<Double>();
		Double baseSum = 0.0d;
		for (Double prize : prizeList) {
			Double base = maxPrize / prize;
			baseList.add(base);
			baseSum += base;
		}
		List<Integer> multList=new ArrayList<Integer>();
		for(int i=0,length=baseList.size();i<length;i++){
			Double base=baseList.get(i);
			multList.add(Long.valueOf(Math.round(base/baseSum*count)).intValue());
		}
		return multList;
	}
	/**
	 * 是否素数
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		if (x < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(x); i++){
			if (x % i == 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 是否素数(包含1)
	 * @param x
	 * @return
	 */
	public static boolean isPrimeContain1(int x) {
		if (x < 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(x); i++){
			if (x % i == 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 奇数个数
	 * @param array
	 */
	public final static int getArrayOdd(String[] array) {
		int odd = 0;
		for (int i = 0; i < array.length; i++) {
			if (Integer.parseInt(array[i])%2!=0) {
				odd++;
			}	
		}
		return odd;
	}
	/**
	 * 偶数个数
	 * @param array
	 */
	public final static int getArrayEven(String[] array) {
		int even = 0;
		for (int i = 0; i < array.length; i++) {
			if (Integer.parseInt(array[i])%2==0) {
				even++;
			}	
		}
		return even;
	}
	/**
	 * 大数个数
	 * @param array
	 * @param centerPoint
	 */
	public final static int getArrayBig(String[] array,int centerPoint) {
		int big = 0;
		for (int i = 0; i < array.length; i++) {
			if (Integer.parseInt(array[i]) >= centerPoint) {
				big++;
			}	
		}
		return big;
	}
	/**
	 * 小数个数
	 * @param array
	 * @param centerPoint
	 */
	public final static int getArraySmall(String[] array,int centerPoint) {
		int small = 0;
		for (int i = 0; i < array.length; i++) {
			if (Integer.parseInt(array[i]) <= centerPoint) {
				small++;
			}	
		}
		return small;
	}
	/**
	 * 开奖号码第n位用|替换，主要用于双色球，大乐透
	 * @param strObj 开奖号
	 * @param pos 替换位置
	 * @param replacetext 替换字符
	 * @return
	 */
	public static String replacePos(String strObj, int pos, String replacetext) {
	   String  str = strObj.substring(0, pos-1) + replacetext + strObj.substring(pos, strObj.length());
	   return str;
	}
	
	/**
	 * 开奖时间转换星期
	 * @param pTime 开奖时间
	 * @return
	 */
	public static int weekDecide(String pTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		 Calendar c = Calendar.getInstance();  
		 try {
			c.setTime(format.parse(pTime));
		} catch (ParseException e) {
			LogUtil.error(e);
		}  
		 int dayForWeek = 0;  
		 if(c.get(Calendar.DAY_OF_WEEK) == 1){  
		  dayForWeek = 7;  
		 }else{  
		  dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;  
		 }  
		 return dayForWeek;
	}
	
	//判断是否为数字
	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(str).matches();
	}
	
	public static   double   roundDouble(double   val,   int   precision)   { 
		double   factor   =   Math.pow(10,   precision); 
		return   Math.floor(val   *   factor   +   0.5)   /   factor; 
	} 
	
	/**
	 * 验证3个数是否相同
	 * @param codes
	 * @return
	 */
	public static boolean isSTH(String[] codes){
		if(codes[0].equals(codes[1]) && codes[1].equals(codes[2]) && codes[0].equals(codes[2]))
			return true;
		return false;
	}
	
	/**
	 * 验证3个数是否有二个相同
	 * @param codes
	 * @return
	 */
	public static boolean isZ3(String[] codes){
		if(isSTH(codes))
			return false;
		if(codes[0].equals(codes[1]) || codes[1].equals(codes[2]) || codes[0].equals(codes[2]))
			return true;
		return false;
	}

	/**
	 * 生成一个随机数List 列（max=20 startNum = 1000 生成1001~1020 之间的list数据）
	 * @param max 最大值 
	 * @param startNum 开始的号吗  
	 * @return
	 */
	public static List<String> generateRandomNum(int max,int startNum){
		// 2.生成幸运号码
		List<String> initNumPoolsList = new ArrayList<String>(max);
		for (int i = 1; i <= max; i++) {
			initNumPoolsList.add((startNum+i)+"");
		}
        // 3.生成随机号码;		
		List<String> randomList = new ArrayList<String>(max);
		
		while(initNumPoolsList.size()>0){
			int maxValue = initNumPoolsList.size();
			Random random = new Random();
			random.setSeed(System.currentTimeMillis());
			int index = random.nextInt(maxValue);
			randomList.add(initNumPoolsList.get(index));
			initNumPoolsList.remove(index);
		}
		return randomList;
	}
	
	/**
	 * 
	 * @param start 开始号码
	 * @param end 结束号码
	 * @param length 长度
	 * @return
	 */
	public static List<String> generateRandomNum(int start,int end,int length){
		// 2.生成幸运号码
		List<String> initNumPoolsList = new ArrayList<String>();
		for (int i = start; i <= end; i++) {
			initNumPoolsList.add(i+"");
		}
        // 3.生成随机号码;		
		List<String> randomList = new ArrayList<String>();
		
		while(randomList.size() < length){
			int maxValue = initNumPoolsList.size();
			Random random = new Random();
			random.setSeed(System.currentTimeMillis()+random.nextInt(maxValue));
			int index = random.nextInt(maxValue);
			randomList.add(initNumPoolsList.get(index));
			initNumPoolsList.remove(index);
		}
		return randomList;
	}
}
