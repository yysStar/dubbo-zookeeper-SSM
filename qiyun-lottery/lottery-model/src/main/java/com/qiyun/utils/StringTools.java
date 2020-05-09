package com.qiyun.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.qiyun.util.LogUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class StringTools {

	/**
	 * 产生随机字符串
	 */
	private static Random randGen = null;
	private static char[] numbersAndLetters = null;
	private static Object initLock = new Object();

	private static Random randGenNumber = null;
	private static char[] numbersAndLettersNumber = null;
	private static Object initLockNumber = new Object();

	// 判断字符串是否空或null
	public static boolean isNullOrBlank(String s) {
		if (s == null || s.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static final String randomString(int length) {

		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
				}
			}
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(62)];
		}
		return new String(randBuffer);
	}

	public static final String randomNumberString(int length) {

		if (length < 1) {
			return null;
		}
		if (randGenNumber == null) {
			synchronized (initLockNumber) {
				if (randGenNumber == null) {
					randGenNumber = new Random();
					numbersAndLettersNumber = ("0123456789").toCharArray();
				}
			}
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLettersNumber[randGenNumber.nextInt(10)];
		}
		return new String(randBuffer);
	}

	final static public String getStringFillZero(String str, int length) {
		if (str.length() == length) {
			return str;
		}
		int fillLength = length - str.length();
		for (int i = 0; i < fillLength; i++) {
			str = "0" + str;
		}
		return str;
	}

	final static public boolean isValueIdTokenString(String tokenString, String split, String value) {
		String[] str = tokenString.split(split);
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @作者:andy
	 * @描述:解析http头里的参数值
	 * @param header
	 * @return
	 */
	final static public HashMap<String, String> getParametersByHttpHead(String header) {

		String data = header.substring(header.indexOf("?") + 1, header.indexOf(" HTTP"));
		return getParametersByContents(data);
	}

	/**
	 * @作者:andy
	 * @描述:解析 key=value&key=value的键值
	 * @param contents
	 * @return
	 */
	final static public HashMap<String, String> getParametersByContents(String contents) {
		HashMap<String, String> map = new HashMap<String, String>();
		String[] keyValues = contents.split("&");
		for (int i = 0; i < keyValues.length; i++) {
			String key = keyValues[i].substring(0, keyValues[i].indexOf("="));
			String value = keyValues[i].substring(keyValues[i].indexOf("=") + 1);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * @作者:andy
	 * @描述:解析 key=value&key=value的键值
	 * @param contents
	 * @return
	 */
	final static public HashMap<String, String> getParametersByContents(String contents, String charset) {
		HashMap<String, String> map = new HashMap<String, String>();
		String[] keyValues = contents.split("&");
		for (int i = 0; i < keyValues.length; i++) {
			String key = keyValues[i].substring(0, keyValues[i].indexOf("="));
			String value = keyValues[i].substring(keyValues[i].indexOf("=") + 1);

			if (charset != null && !"".equals(charset)) {
				try {
					value = URLDecoder.decode(value, charset);
				} catch (UnsupportedEncodingException e) {
					LogUtil.error(e);
				}
			}

			map.put(key, value);
		}
		return map;
	}

	/**
	 * @作者:andy
	 * @描述:将map转成key=value&key=value
	 * @return
	 */
	final static public String getStringByHashMap(Map map) {
		StringBuffer sb = new StringBuffer();
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = map.get(key);
			sb.append(key.toString()).append("=").append(value.toString()).append("&");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * @作者:wuxh
	 * @描述:将ActionContext 里而的Parameter map转成key=value&key=value
	 * @return
	 */
	final static public String getStringByActionHashMap(Map map) {
		StringBuffer sb = new StringBuffer();
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = map.get(key);
			if (value instanceof String[]) {
				String[] values = (String[]) value;

				StringBuffer subSb = new StringBuffer();
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						subSb.append(values[i]).append("|");
					}
					if (subSb.length() > 0) {
						subSb.deleteCharAt(subSb.length() - 1);
					}
				}
				sb.append(key.toString()).append("=").append(subSb.toString()).append("&");
			}

		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * @作者:andy
	 * @描述:将map转成key=value&key=value
	 * @return
	 */
	final static public String getStringByHashMap(HashMap<String, String> map, String chartset) throws Exception {
		StringBuffer sb = new StringBuffer();
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			String value = map.get(key);
			sb.append(key).append("=").append(URLEncoder.encode(value, chartset)).append("&");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 把给定的字符串转换为Base64编码
	 * 
	 * @param source
	 *            需要进行转换的字符串
	 * @return 转换后的结果，如果source为null，则返回null
	 */
	public static String EncodeBase64(String source) {
		if (source == null)
			return null;
		return new String(org.apache.commons.codec.binary.Base64.encodeBase64(source.getBytes()));
	}

	/**
	 * 把base64编码的字符串进行解码并返回原字符串
	 * 
	 * @param source
	 *            需要进行解码的Base64编码的字符串
	 * @return 解码后的原字符串，如果错误则返回null
	 */
	public static String DecodeBase64(String source) {
		if (source == null)
			return null;
		try {
			return new String(new BASE64Decoder().decodeBuffer(source));
		} catch (Exception ex) {
			return null;
		}
	}

	public static String[] split(String str, char delim) {

		if (str == null)
			return null;
		if (str.trim().equals(""))
			return new String[0];

		int count = 1;
		char c[] = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == delim) {
				count++;
			}
		}

		String s[] = new String[count];
		int index = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == delim) {
				s[index] = sb.toString();
				sb = new StringBuffer();
				index++;
			} else {
				sb.append(c[i]);
			}
		}
		s[index] = sb.toString();
		return s;
	}

	static public String decodeForwardUrl(String forwardUrl) {
		forwardUrl = StringTools.DecodeBase64(forwardUrl);

		/**
		 * 以下的代码是为了让转向地址携带的参数能正常传递 如号码格式里面的 % 这些字符必须经过URLEncode才能被正常解析
		 */
		String pre = "";
		String bak = forwardUrl.substring(forwardUrl.indexOf("?") + 1, forwardUrl.length());
		String area[] = bak.split("\\&");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < area.length; i++) {
			String[] peace = area[i].split("\\=");
			if (peace.length == 2) {
				try {
					sb.append(peace[0]).append("=").append(URLEncoder.encode(peace[1], "GBK")).append("&");
				} catch (UnsupportedEncodingException e) {
					LogUtil.error(e);
				}
			} else if (peace.length == 1) {
				// sb.append(peace[0]).append("=").append("").append("&");
			}

		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
			pre = forwardUrl.substring(0, forwardUrl.indexOf("?") + 1);
		} else {
			// 后面没有参数，不用带 ?
			if (forwardUrl.indexOf('?') != -1) {
				pre = forwardUrl.substring(0, forwardUrl.indexOf("?"));
			}

		}

		forwardUrl = pre + sb.toString();
		return forwardUrl;
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

	/**
	 * 判断是否为浮点数，包括double和float
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-+]?\\d+(\\.\\d+)?$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 将一个字符串转换为一个数组 例如将 0102030405 转换为 01,02,03,04,05的数组
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 返回一个数组
	 */
	public static String[] convertToStringArray(String str) {
		if (null == str || str.length() < 1)
			return new String[0];
		String[] codes = new String[str.length() / 2];
		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(i, i + 2);
			// com.cailele.lottery.tools.LogUtil.info(temp);
			codes[i / 2] = temp;
			i++;
		}
		return codes;
	}

	/**
	 * 将一个字符串转换为一个数组(单字符) 例如将 12345 转换为 1,2,3,4,5的数组
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 返回一个数组
	 */
	public static String[] convertToCharArray(String str) {
		if (null == str || str.length() < 1)
			return new String[0];
		String[] codes = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(i, i + 1);
			// com.cailele.lottery.tools.LogUtil.info(temp);
			codes[i] = temp;

		}
		return codes;
	}

	/**
	 * 将一个数组转为带分隔符的串
	 */
	public static String convertArrayToString(Object[] arr, String splitStr) {
		String codes = "";
		for (Object a : arr) {
			codes += a.toString() + splitStr;
		}
		return codes.substring(0, codes.length() - 1);
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

	// 将16进制字符转为byte数数
	public static byte[] parseHexString(String src) {
		byte[] result = null;
		try {
			if (src.length() % 2 != 0)
				throw new Exception("串内容错误！");
			result = new byte[src.length() / 2];
			for (int i = 0; i < src.length() / 2; i++) {
				result[i] = (byte)Integer.parseInt(src.substring((i * 2), (i * 2 + 2)), 16);
			}

		} catch (Exception e) {
			LogUtil.error(e);
		}
		return result;

	}

	// 数据DES加密,java 默认mode = ECB ,key 为16进制字符
	public static String getDESEncrypt(String src, String key) throws Exception {
		// 转化key串为 byte[]
		byte[] k = StringTools.parseHexString(key);
		SecretKey deskey = new SecretKeySpec(k, "DES");
		// String Algorithm = "DES/CBC/PKCS5Padding"; //定义加密算法,可用
		// DES,DESede,Blowfish
		String Algorithm = "DES"; // java 默认mode = ECB
		Cipher c = Cipher.getInstance(Algorithm);
		c.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] raw = c.doFinal(src.getBytes());
		// 对加密后的数据进行BASE64编码
		BASE64Encoder encoder = new BASE64Encoder();
		String encMsg = encoder.encode(raw);
		return encMsg.replaceAll("\r", "").replaceAll("\n", "");
	}

	// 解析DES加密后的数据
	public static String getDESDecrypt(String encMsg, String key) throws Exception {
		if (encMsg == null || encMsg.length() <= 0) {
			throw new Exception("数据为空！");
		}
		// 对加密数据进行BASE64解码
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] raw = decoder.decodeBuffer(encMsg);
		// 转化key串为 byte[]
		byte[] k = StringTools.parseHexString(key);
		SecretKey deskey = new SecretKeySpec(k, "DES");

		String Algorithm = "DES"; // java 默认mode = ECB
		Cipher c = Cipher.getInstance(Algorithm);
		c.init(Cipher.DECRYPT_MODE, deskey);
		byte[] cipherByte = c.doFinal(raw);
		String srcMsg = new String(cipherByte);
		return srcMsg;
	}

	public static String getNumfromStr(String str) {
		Matcher m = Pattern.compile("[\\d.]+").matcher(str);
		m.find();
		String value = m.group();
		return value;
	}

	public static String getFloatfromStr(String str) {
		Matcher m = Pattern.compile("[\u4e00-\u9fa5]+").matcher(str);
		m.find();
		String value = m.group();
		return value;
	}
	
	/**
	 * 针对用户名打马赛克效果(规则:只截取第一个字符+后面固定增加3个星号)
	 * @param str 原字符 abcde
	 * @return str 返回处理后的字符a***
	 */
	public static String getSecurityStr(String str) {
		if (isNullOrBlank(str)) {
			return "";
		}
		String result = str.substring(0,1) + "***";
		return result;
	}

	/**
	 * 查询一个字符的出现次数
	 * @param str
	 * @param key
	 * @return
	 */
	public static int getStringShowTime(String str,String key){
        int count = 0;
        int index = 0;
        while((index=str.indexOf(key,index))!=-1){
            index = index+key.length();
            count++;
        }
        return count;
    }
	
	/** 计算字符串的长度，中文算二个 
	 * @return 字符串的长度
	 */  
	public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
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

	/**
	 * [3,1|0,3,0,1]->3,1|0,3,0,1
	 * 
	 * @param strArr
	 * @return
	 */
	public static String formatArr2And(Collection<String> strArr) {
		return formatArr(strArr, ",");
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
	
	public static String formatCode(String str,Integer place) {
		int len = str.length();
		return str.substring(len-place, len);
	}
	
	public static List<Integer> fromStringArrToIntegerArr(String[] stringArr) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i< stringArr.length; i++) {
			result.add(Integer.valueOf(stringArr[i]));
		}
		return result;
	}

	/**
	 * base64加密url参数
	 * @param param
	 * @return
	 */
	public static String base64ToURL(String param){
		String base = Base64.encode(param.getBytes());
		return base.replace('+', '_').replace('/', '-').replace('=', '*');
	}
	
	/**
	 * base64-encode加密url参数
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String base64EncodeToURL(String param) throws Exception{
		String base = Base64.encode(param.getBytes());
		base = URLEncoder.encode(base, "utf-8");
		return base;
	}
	
	/**
	 * base64解密url参数
	 * @param param
	 * @return
	 */
	public static String base64ToString(String param){
		String d = new String(Base64.decode(param.replace("share/", "").replace('_', '+').replace('*', '=').replace('-', '/')));
		return d;
	}
	
	/**
	 * base62-encoe解密url参数
	 * @param param
	 * @return
	 */
	public static String base64DecodeToURL(String param) throws Exception{
		String base = URLDecoder.decode(param,"utf-8");
		base = new String(Base64.decode(base));
		return base;
	}
	/**
	 * 打印对象的所有属性 (null 或 static 除外)
	 * @param obj
	 * @param clazz
	 * @return
	 */
	public static String reflectToString(Object obj,Class clazz) {
		if(clazz==null){
			return "";
		}
		StringBuilder sb=new StringBuilder("");
		Field[] fields=clazz.getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				Field field=fields[i];
				field.setAccessible(true);
					if(!Modifier.isStatic(field.getModifiers()) && field.get(obj)!=null){
						sb.append(field.getName()+"="+field.get(obj)+",");
					}
			}
		} catch (IllegalArgumentException e) {
			LogUtil.error(e);
		} catch (IllegalAccessException e) {
			LogUtil.error(e);
		}
		if(clazz.getGenericSuperclass()!=null){
			sb.append(reflectToString(obj,clazz.getSuperclass()));
		}
		return sb.toString();
	}
	
	
	/**
	 * 对投注号码排序，默认双位号码
	 * @param content
	 * @return 返回排序后的投注号码字符串
	 */
	public static String sortContent(String content){
		return sortContent(content,true);
	}
	/**
	 * 对投注号码排序
	 * @param content 投注号码字符串
	 * @param digit   位数
	 * @return 返回排序后的投注号码字符串
	 */
	public static String sortContent(String content,boolean digit){
		String[] bets = content.split("\\^");//多注
		String result = "";
		for(String bet : bets) {//循环每一注
			String [] con = convertToStringArray(bet);
			int [] arr = new int [con.length]; 
			for(int i = 0;i < con.length;i++){
				arr [i] = Integer.parseInt(con[i]);
			}
			Arrays.sort(arr);
	        DecimalFormat dfInt=new DecimalFormat("00");
	        String str = "";
			for(int s : arr){
				if(digit) {
					str +=  dfInt.format(s);
				} else {
					str +=  String.valueOf(s);
				}
			}
			result += str + "^";
		}
		if(result.endsWith("^")) {
			result = result.substring(0,result.length() - 1);
		}
		return result;
	}
	
	/**
	 * 功能：返回Map字典排序后的字符串k1=v1&k2=v2
	 * @param params
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static String mapToSortString(Map params) {
		List keys = new ArrayList(params.keySet());
		Collections.sort(keys);
		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = (String) params.get(key);

			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr ;
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
	 * 截取子字符 
	 * @return
	 */
	public static String subStringByBeginStrAndEndStr(String sourceStr,String beginStr,String endStr,boolean includeStart,boolean includeEnd){
		int beginIndex = sourceStr.indexOf(beginStr);
		int endIndex = sourceStr.indexOf(endStr);
		if(beginIndex == -1 || endIndex == -1)
			return "";
		else{
			if(!includeStart){
				beginIndex += beginStr.length();
			}
			if(includeEnd){
				endIndex += endStr.length();
			}
			return sourceStr.substring(beginIndex, endIndex);
		}
	}
	
	/**
	 * <p>判断字符串是否包含特殊字符</p>
	 * @param str String
	 * @return boolean
	 */
	public static boolean isConSpeCharacters(String str) {
		String tempStr = str.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*", "");
		
		if (tempStr.length() == 0) {
	        return false;
	    }
		
		return true;
	}
	
	/**
	 * 截取子字符(删除中间的文字)
	 * @return
	 */
	public static String removeMiddleStr(String source,String backIndexStr,int removeLength,int blackLength) {
		int index = source.indexOf(backIndexStr);
		if(index == -1)
			return source;
		String temp = "";
		for(int i = 0; i < blackLength; i++)
			temp += " ";
		
		return source.substring(0,index-removeLength) + temp + source.substring(index,source.length());
	}
	
	/**
	 * 验证字串中是否有相同的数据 有返回true 没有返回false
	 */
	public static boolean hasSameString(String[] arrStr){
		Set<String> set = new HashSet<String>();
		for(String str:arrStr){
			set.add(str);
		}
		return set.size() != arrStr.length;
	}
}
