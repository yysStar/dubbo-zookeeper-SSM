package com.qiyun.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* *
 *类名：PayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付接口使用，只是提供一个参考。
 */

public class PayConfig {
	
	static Properties prop;

	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 商户号
     public static String merId;
	// 商户的私钥
	public static String key;
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 字符编码格式 目前支持 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";
	
	public static String trans_url = "";
	
	
	static{
		try {
			prop = new Properties();
			InputStream in = PayConfig.class.getClassLoader().getResourceAsStream("/config/payconfig.properties");
			prop.load(in);
			key = prop.getProperty("KEY");
			merId = prop.getProperty("MERID");
			input_charset = prop.getProperty("INPUT_CHARSET");
			sign_type = prop.getProperty("SIGN_TYPE");
			trans_url = prop.getProperty("TRANS_URL");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
