package com.qiyun.tools;

/**
 * 身份证工具类
 * @author liuxd
 *
 */

public class CertNoUtil {
	/**
	 * 
	 * 修补15位居民身份证号码为18位
	 * @param personIDCode
	 * @return
	 */

	public static String fixPersonIDCode(String personIDCode){
		if (personIDCode == null || personIDCode.trim().length() != 15) {
			return personIDCode;
		}
		String id17 = personIDCode.substring(0, 6) + "19" + personIDCode.substring(6, 15); // 15为身份证补\'19\'
		// char[] code =
		// {\'1\',\'0\',\'X\',\'9\',\'8\',\'7\',\'6\',\'5\',\'4\',\'3\',\'2\'};
		// //11个
		char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' }; // 11个
		int[] factor = { 0, 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7 }; // 18个;
		int[] idcd = new int[18];
		int i;
		int j;
		int sum;
		int remainder;
		for (i = 1; i < 18; i++){
			j = 17 - i;
			idcd[i] = Integer.parseInt(id17.substring(j, j + 1));
		}
		sum = 0;
		for (i = 1; i < 18; i++){
			sum = sum + idcd[i] * factor[i];
		}
		remainder = sum % 11;
		String lastCheckBit = String.valueOf(code[remainder]);
		return id17 + lastCheckBit;
	}

	/**
	 * 
	 * 判断是否是有效的18位或15位居民身份证号码
	 * @param identityId:18位或15位居民身份证号码
	 * @return：true： 有效的18位或15位居民身份证号码
	 */
	public static boolean isIdentityId(String identityId) {
		if (isEmpty(identityId))
			return false;
		try {
			if (identityId.length() == 18) {
				String identityId15 = identityId.substring(0, 6) + identityId.substring(8, 17);
				if (fixPersonIDCode(identityId15).equalsIgnoreCase(identityId)) {
					return true;
				} else {
					return false;
				}
			} else if (identityId.length() == 15) {
				try {
					Long.parseLong(identityId);
					return true;
				} catch (Exception ex) {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * 返回身份证上的生日  格式:1980-01-01
	 * @param certNo
	 * @return
	 */
	public static String getBirthDate(String certNo){
		String date = "";
		if(certNo.length() == 15){
			certNo = fixPersonIDCode(certNo);
		}
		if (certNo.length() == 18){
			date = getBirthYear(certNo)+"-"+getBirthMonth(certNo)+"-"+getBirthDay(certNo);
		}
		return date;
	}
	
	/**
	 * 返回身份证上的生日的年  格式:1980
	 * @param certNo
	 * @return
	 */
	public static String getBirthYear(String certNo){
		String year = "";
		if(certNo.length() == 15){
			certNo = fixPersonIDCode(certNo);
		}
		if (certNo.length() == 18){
			year = certNo.substring(6, 10);
		}
		return year;
	}
	
	/**
	 * 返回身份证上的生日的月  格式:01
	 * @param certNo
	 * @return
	 */
	public static String getBirthMonth(String certNo){
		String month = "";
		if(certNo.length() == 15){
			certNo = fixPersonIDCode(certNo);
		}
		if (certNo.length() == 18){
			month = certNo.substring(10, 12);
		}
		return month;
	}
	/**
	 * 返回身份证上的生日的日  格式:01
	 * @param certNo
	 * @return
	 */
	public static String getBirthDay(String certNo){
		String day = "";
		if(certNo.length() == 15){
			certNo = fixPersonIDCode(certNo);
		}
		if (certNo.length() == 18){
			day = certNo.substring(12, 14);
		}
		return day;
	}

	/**
	 * 
	 * 判断是否为空串""
	 */
	public static boolean isEmpty(String sValue) {
		if (sValue == null)
			return true;

		return sValue.trim().equals("") ? true : false;

	}
}
