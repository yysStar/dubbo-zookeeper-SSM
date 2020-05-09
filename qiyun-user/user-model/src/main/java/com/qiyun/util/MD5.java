package com.qiyun.util;

import java.security.MessageDigest;

public class MD5 {

	public static String encode(String inStr) {
		return encode(inStr, "gbk");
	}

	public static String encode(String inStr, String enco) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			LogUtil.error(e);
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		try {
			byteArray = inStr.getBytes(enco);
		} catch (Exception e) {
			return "";
		}

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
	public static String encodeUtf8(String inStr) {
		return encode(inStr, "utf-8");
	}

}
