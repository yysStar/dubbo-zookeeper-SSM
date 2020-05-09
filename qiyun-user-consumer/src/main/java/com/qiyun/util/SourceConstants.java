package com.qiyun.util;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *来源常量配置
 */
public class SourceConstants {
	
	final static public String PROVIDER_OAUTH_WECHAT = "Wechat"; //微信联合登陆来源
	final static public String PROVIDER_OAUTH_QQ = "QQ"; //腾讯QQ联合登陆来源
	final static public String PROVIDER_REGISTER_EMAIL = "emailReg"; //emailReg注册来源
	final static public String PROVIDER_REGISTER_WEIXIN = "WEIXIN";//微信

	//用户注册地址与注册来源Map
	 public static final Map<String,String> HOST_PROVIDER_MAP = new HashMap<String, String>();
	
	
	/**
	 * 跟据域名确定注册来源
	 * @param provider 来源默认值
	 * @param request
	 * @return
	 */
	public static String getProvider(String provider,HttpServletRequest request){
		String host = request.getHeader("Host");
		if(HOST_PROVIDER_MAP.containsKey(host))
			provider = HOST_PROVIDER_MAP.get(host);
		return provider;			
	}

}
