package com.qiyun.httpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

import com.qiyun.util.LogUtil;
import org.springframework.context.ApplicationContext;

public class WebConstants {
	
	/** 网站域名 **/
	public static String Domain = "wuyoushangcai.com";
	/** 网站访问协议:http、https **/
	public static String WebProtocol = "http";
	/** 公司名称hardCode,必须跟配置保存一致 **/
	public static String CLL = "cll";
	/** 上下文 **/
	public static ApplicationContext context = null;
	/** 该变量在系统系统动成功后，转变成真实路径 **/
	public static String RESOURCE_PATH = "/upload/resource/";
	/**  **/
	public static final String RESOURCE_URL = "/upload/resource";
	/** 网站头部内容 **/
	public static String TOP_CONTENT = "";
	/** 网站底部内容 **/
	public static String FOOT_CONTENT = "";
	/** 站点名 **/
	public static String WEB_SITE_NAME = "cll";
	/** 公司 **/
	public static String CORPORATION = "";
	/** 提款账号 **/
	public static String WITHDRAWALS_ACCOUNT = "";
	/** 隐藏特别用户 **/
	public static Set<String> HIDE_ACCOUNTS=new HashSet<String>(); 
	/** 网站程序根目录 **/
	private static String webPath=null;
	/** 网站程序根目录 **/
	public static String getWebPath(){
		if(webPath==null){
			webPath = WebConstants.class.getResource("/").getPath().replace("/WEB-INF/classes/", "/");
			try {
				webPath=URLDecoder.decode(webPath,"utf-8");
			} catch (UnsupportedEncodingException e) {
				LogUtil.error(e);
			}
		}
		return webPath;
	}
	/** Web站 **/
	public static String getDomainWww(){
		return WebProtocol+"://www."+Domain;
	}
	/** M站 **/
	public static String getDomainM(){
		return WebProtocol+"://m."+Domain;
	}
	
}
