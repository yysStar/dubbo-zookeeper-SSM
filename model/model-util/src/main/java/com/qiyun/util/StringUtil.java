package com.qiyun.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

//import com.alibaba.citrus.service.requestcontext.parser.filter.HTMLInputFilter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class StringUtil {
	private static Random randGenNumber = null;
	private static Object initLockNumber = new Object();
	private static char[] numbersAndLettersNumber = null;
	private static final Logger LOGGER = Logger
            .getLogger(StringUtil.class);
	/**
	 * 过滤字符串中的乱码
	 * @param content
	 * @return
	 */
	public static String filterMessyCode(String content){
		if(CommonUtil.isEmpty(content)){
			return content;
		}
		String newStr = "";
		char[] chArray = content.trim().toCharArray();
		for(char entity : chArray){
			int ascCode = (int)entity;
			if(isChinese(entity) 
					|| (ascCode > 32 && ascCode < 123)){
				newStr += String.valueOf(entity);
			}
		}
		return newStr;
	}
	/**
	 * 随机生成用户名
	 * @param length
	 * @return
	 */
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
	/**
	 * 判断是否为中文字符串
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
		        || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
		        || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
		        || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
		        || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
		        || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
		    return true;
		}
		return false;
	}

    /**
     * 获取指定字符串的替换字符串
     * abbb-->****
     * @param content
     * @param replacement
     * @return
     */
    public static String getRepacement(String content, String replacement){
    	if(CommonUtil.isEmpty(content)){
			return content;
		}
		if(CommonUtil.isEmpty(replacement)){
			return content;
		}
		int length = content.length();
		String backStr = "";
		for(int i = 0; i < length; i ++){
			backStr += replacement;
		}
		return backStr;
    }
	/**
	 * 检测是否为数字
	 * @param str
	 * @return
	 */
	public static boolean checkNumber(String str){
		boolean index = false;
		if(CommonUtil.isEmpty(str)){
			return index;
		}
		Pattern regex = Pattern.compile("^[0-9]+$");
		Matcher matcher = regex.matcher(str);
		index = matcher.matches();
		return index;
	}
	/**
	 * 判断字符串是否为数字，包括小数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		boolean index = false;
		if(CommonUtil.isEmpty(str)){
			return index;
		}
		Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]+)?$");
		Matcher isNum = pattern.matcher(str);
		index = isNum.matches();
		return index;
	}
	
	/**
	 * 检测一定长度内的字符串
	 * @param str
	 * @param limit
	 * @return
	 */
	public static boolean checkLength(String str, Integer limit){
		boolean index  =  false;
		if(!CommonUtil.isEmpty(str) && str.length() < limit){
			index  =  true;
		}
		return index;
	};
	/**
	 * 把空字符转换成空串
	 * @param str
	 * @return
	 */
	public static String blanknull(String str){
		if(str!=null){
			return str;
		}else{
			return "";
		}
	}

	public static String handldStr(String str){
		if(!CommonUtil.isEmpty(str) && str.indexOf("\"") != -1){
			str = str.replaceAll("\"", "");
		}
		return str;
	}
	/**
	 * 将helloWorld转hello_world
	 *
	 * @param input
	 * @return
	 */
	public static String getSplitString(String input) {
		StringBuffer str = new StringBuffer();
		if (input != null) {
			for (int i = 0; i < input.length(); i++) {
				char a = input.charAt(i);
				if (i != 0 && (a >= 'A') && (a <= 'Z')) {
					a += 32;
					str.append("_");
				}
				str.append(a);
			}
		}
		return str.toString();
	}

	
	/**
	 * 获取一个字符串中的数字和字母
	 * @param str
	 * @return
	 */
	public static String getNumAndLetterByStr(String str){
		if(CommonUtil.isEmpty(str)){
			return null;
		}
		String regEx="[^a-z^A-Z^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(str);   
		return m.replaceAll("").trim();
	}
	/**
	 * 获取一个字符串中的整数或数字
	 * @param str
	 * @return
	 */
	public static String getNumByStr(String str){
		if(CommonUtil.isEmpty(str)){
			return null;
		}
		String regEx="([0-9]+[.][0-9]+)|([0-9]+)";
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(str); 
		if(m.find()){
			return m.group();
		}
		return null;
	}

	 /** 正则表达
     * 手机号码由11位数字组成，
     * 匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
	public static boolean isMobile(String str) {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
	/**
	 * 验证手机号码
	 * @param mobileNumber
	 * @return
	 */
	public static boolean checkMobileNumber(String mobileNumber){
		boolean flag = false;
		if(mobileNumber != null && !mobileNumber.equals("")){
			try{
				Pattern regex = Pattern.compile("^(((13[0-9])|(17[0-9])|(14[0-9])|(15([0-9]))|(18([0-9])))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
				Matcher matcher = regex.matcher(mobileNumber);
				flag = matcher.matches();
			}catch(Exception e){
				flag = false;
			}
		}
		return flag;
	}
	/**
	 * 从字符串中获取手机号码
	 * @param str
	 * @return
	 */
	public static String getMobileByStr(String str){
		if(CommonUtil.isEmpty(str)){
			return "";
		}
		str = replaceEmoji(str);
		String regEx="(1|861)(3|5|8)\\d{9}$*";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(str); 
		if(m.find()){
			return m.group();
		}
		return null;
	}
	/**
	 * 通过正则表达式获取制定的的字符串
	 * @param str
	 * @param regex
	 * @return
	 */
	public static String getStrByRegex(String str, String regex){
		if(CommonUtil.isEmpty(str)){
			return str;
		}
		if(CommonUtil.isEmpty(regex)){
			return str;
		}
		Pattern p = Pattern.compile(regex);   
		Matcher m = p.matcher(str); 
		if(m.find()){
			return m.group();
		}
		return null;
	}
	/**
	 * 获取一个字符串中的整数
	 * @param str
	 * @return
	 */
	public static String getNumZByStr(String str){
		return  getStrByRegex(str, "[0-9]+");
	}
	/**
	 * 返回最后一个字符串
	 * @param str
	 * @param regex
	 * @return
	 */
	public static String getEndStrByRegex(String str, String regex){
		if(CommonUtil.isEmpty(str)){
			return str;
		}
		if(CommonUtil.isEmpty(regex)){
			return str;
		}
		if(str.indexOf(regex) == -1){
			return str;
		}
		String[] strArray = str.split(regex);
		return strArray[strArray.length -1];
	}
	/**
	 * 2014年3月12日
	 * 注释：判断是否为emoji表情
	 */
	private static boolean isNotEmojiCharacter(char codePoint) {
		return  (codePoint == 0x0) ||
				(codePoint == 0x9) ||
				(codePoint == 0xA) ||
				(codePoint == 0xD) ||
				((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
				((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
				((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }
	/**
	 * 2014年3月13日
	 * 注释：过滤emoji表情
	 */
	public static String replaceEmoji(String str){
		if(str==null)return null;
		if(str.equals(""))return "";
		int len = str.length();
		StringBuilder buf = null;
		for(int i=0;i<len;i++){
			char point = str.charAt(i);
			if(isNotEmojiCharacter(point)){
				if(buf==null){
					buf = new StringBuilder(len);
				}
				buf.append(point);
			}else{
				//过滤emoji表情
			}
		}
		if(buf!=null){
			return buf.toString();
		}else{
			return "";
		}
	}
	/**
	 * 向1，2，3中添加4
	 * @param targetStr
	 * @param addStr
	 * @return
	 */
	public static String addString(String targetStr, String addStr, String regex){
		if(CommonUtil.isEmpty(targetStr) || CommonUtil.isEmpty(addStr)){
			return targetStr;
		}
		if(CommonUtil.isEmpty(regex)){
			regex = ",";
		}
		String[] strArray = targetStr.split(regex);
		for(String entity : strArray){
			if(entity.equals(addStr)){
				return targetStr;
			}
		}
		return targetStr + regex + addStr;
	};
	public static Set<Long> getLongListByStr(String targetStr, String regex){
		Set<Long> result = null;
		if(CommonUtil.isEmpty(targetStr)){
			return result;
		}
		String[] strArry = targetStr.split(regex);
		if(CommonUtil.isEmpty(strArry)){
			return null;
		}
		result = new HashSet<Long>();
		for(String entity : strArry){
			result.add(Long.valueOf(entity));
		}
		return result;
	}
	/**
     * String --> Double
     * @param value
     * @return
     */
    public static Double String2Double(String value){
        if(CommonUtil.isEmpty(value)){
           return 0d; 
        }
        try {
        	value = value.replaceAll(" ", "");
            return Double.valueOf(value);
        } catch (Exception e) {
            return 0d; 
        }
    }
	/**
     * String --> Long
     * @param value
     * @return
     */
    public static Long String2Long(String value){
        if(CommonUtil.isEmpty(value)){
           return  0L; 
        }
        try {
        	value = value.replaceAll(" ", "");
            return Long.valueOf(value);
        } catch (Exception e) {
            return 0L; 
        }
    }
	/**
     * String --> Double
     * @param value
     * @return
     */
    public static Float String2Float(String value){
        if(CommonUtil.isEmpty(value)){
           return null; 
        }
        try {
        	value = value.replaceAll(" ", "");
            return Float.valueOf(value);
        } catch (Exception e) {
        	LOGGER.error("String2Float==" + value);
            return null; 
        }
    }
    /**
     * String --> Integer
     * @param value
     * @return
     */
    public static Integer String2Integer(String value){
        if(CommonUtil.isEmpty(value)){
           return 0; 
        }
        try {
        	value = value.replaceAll(" ", "");
            return Integer.valueOf(value);
        } catch (Exception e) {
            return 0; 
        }
    }
    /**
     * 获取版本号对应的值
     * 1.2.10 --> 1*100 + 2*10 + 10*1 -- >130;
     * @param version
     * @return
     */
    public static Integer getVersionValue(String version){
    	if(!CommonUtil.isEmpty(version)){
    		//版本号规则
    		String regex = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
    		Pattern p = Pattern.compile(regex);   
    		Matcher m = p.matcher(version); 
    		if(m.find()){
    			version = version.replaceAll("\\.", "");
    			return Integer.valueOf(version);
    		}
    	}
    	return  null;
    }

	/**
	 * 字符串进行自然排序
	 * 3,2,5,1--->1,2,3,5
	 * @param content
	 * @return
	 */
	public static String naturalOrder(String content){
		if(CommonUtil.isEmpty(content)){
			return content;
		}
		String[] array = content.split(",");
		if(array.length > 1){
			Set<String> numberSet = new HashSet<String>();
			for(String number : array){
				numberSet.add(number);
			}
			content = "";
			for(String number : numberSet){
				content += number + ",";
			}
			content = content.substring(0, content.length() - 1);
		}
		return content;
	}

	/**
	 * 添加一个字符串的梯形排序
	 * @param content
	 * @return
	 */
	public static Set<String> addTSet(Set<String> set, String content){
		if(CommonUtil.isEmpty(content)
				|| content.length() == 0){
			return set;
		}
		for(int i = 0; i < content.length(); i ++ ){
			String addStr = content.substring(0, i + 1);
			set.add(addStr);
		}
		return set;
	}
	/**
	 * 过滤特殊符号
	 * @param keyword
	 * @return
	 */
	public static String filterSpecialSymbos(String keyword)	{
		if(CommonUtil.isEmpty(keyword)){
			return null;
		}
		// 清除掉所有特殊字符 
		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？·-―☎️]"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(keyword);
		return m.replaceAll("").trim();
	}

	/**
	 * 判断字符串是否全为英文
	 * @param word
	 * @return
	 * @author: daishidong
	 * @date: 2018年5月16日 下午4:40:05
	 */
	public static boolean isEnglish(String word) {
        boolean sign = true;
        for (int i = 0; i < word.length(); i++) {  
            if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')  
                    && !(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {  
                return false;  
            }  
        }  
        return sign;  
    }

//	/**
//	 * 2014年3月13日
//	 * 注释：过滤emoji表情
//	 */
//	public static String replace(String str){
//		str = replaceEmoji(str);
//		str = replaceHtmlSpecialChars(str);
//		if(!CommonUtil.isEmpty(str)){
//			str = str.replaceAll("&quot;", "\"");
//		}
//		return str;
//	}
	/**
	 * 计算字符长度（中文两个，英文一个）
	 * @param value
	 * @return
	 */
	public static int calStringLength(String value) {
		int valueLength = 0;
		String chinese = "[\u4e00-\u9fa5]";
		for (int i = 0; i < value.length(); i++) {
			String temp = value.substring(i, i + 1);
			if (temp.matches(chinese)) {
				valueLength += 2;
			} else {
				valueLength += 1;
			}
		}
		return valueLength;
	}
	/**
	 * 将数字转换为指定的字符串
	 * @param storeId
	 * @param count
	 * @return
	 */
	public static String numberToStr(Long storeId, int count) {
		if(CommonUtil.isEmpty(storeId)) {
			return null;
		}
		String str = String.valueOf(storeId);
		int addCount = count - str.length();
		if(addCount < 0) {
			return str;
		}
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < addCount; i++) {
			stringBuffer.append(0);
		}
		stringBuffer.append(str);
		return stringBuffer.toString();
	}
	public static String strToNumber(String str) {
		if(CommonUtil.isEmpty(str)) {
			return str;
		}
		while(str.startsWith("0")) {
			str = str.substring(str.length() - 1, str.length());
		}
		return str;
	}

	/**
	 * json字符串转jsonArray
	 * @param jsonString
	 * @return
	 */
	public static JSONArray jsonStrToJson(String jsonString){
		try {
			JSONArray array = JSONArray.parseArray(jsonString);
			return array;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * json字符串中获取Key的value
	 * @param jsonString json字符串
	 * @param key key名称
	 * @return
	 */
	public static String jsonStrGetKeyOne(String key,String jsonString){
		try {
			//过滤&quot;符号
			jsonString = StringEscapeUtils.unescapeHtml(jsonString);
			JSONArray array = JSONArray.parseArray(jsonString);
			String picUrl= array.getJSONObject(0).getString(key);
			return picUrl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 是否为身份证号
	 * @param ID 传入的身份证号
	 * @return
	 */
	public static boolean isID(String ID) {
		String regExp = "(^\\d{17}[0-9Xx]$)|(^\\d{15}$)";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(ID);
		return m.matches();
	}

	/**
	 * 是否包含特殊符号
	 * @param str
	 * @return
	 */
	public static boolean containSpecialSymbol(String str){
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？·-]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}
	public static void main(String[] args) {
//		List<TvPeriodGoodsRel> arrayList = new ArrayList<>();
//		TvPeriodGoodsRel tvPeriodGoodsRel = new TvPeriodGoodsRel();
//		tvPeriodGoodsRel.setGoodsId(1L);
//		arrayList.add(tvPeriodGoodsRel);
//		tvPeriodGoodsRel = new TvPeriodGoodsRel();
//		tvPeriodGoodsRel.setGoodsId(2L);
//		arrayList.add(tvPeriodGoodsRel);
//		String goodsIdJson = JSONObject.toJSONString(arrayList);
//		System.out.println(goodsIdJson);
//		List<TvPeriodGoodsRel> tvPeriodGoodsRelList = JSONObject.parseArray(goodsIdJson, TvPeriodGoodsRel.class);
//		for (TvPeriodGoodsRel tvPeriodGoodsRel2 : tvPeriodGoodsRelList) {
//			System.out.println(tvPeriodGoodsRel2.getGoodsId());
//		}
//		Long storeId = 2L;
//		System.out.println(numberToStr(storeId, 4));
//		String str = "0002";
//		System.out.println(strToNumber(str));
		String ID = "421122199307245";
//		System.out.println(isID(ID));
	}
	/**
	 * json字符串中获取Key的value集合
	 * <p>Title: jsonStrGetKeyList</p>   
	 * @param jsonString
	 * @param key
	 * @return
	 */
	public static List<String> jsonStrGetKeyList(String jsonString, String key) {
		List<String> list = new ArrayList<String>();
		if (!CommonUtil.isEmpty(jsonString)) {
			JSONArray array = null;
			try {
				array = JSONArray.parseArray(jsonString);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			if (!CommonUtil.isEmpty(array)) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject jsonObject = array.getJSONObject(i);
					String value = jsonObject.getString(key);
					list.add(value);
				}
			}
		}
		return list;
	}
}