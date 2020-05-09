package com.qiyun.tools;

import com.alibaba.fastjson.JSON;
import com.qiyun.sms.requset.SmsSendRequest;
import com.qiyun.sms.response.SmsSendResponse;
import com.qiyun.sms.smsUtil.ChuangLanSmsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author tianyh 
 * @date 2017年4月15日 下午3:26:25
 * @Title: ChuangLanSmsDemo
 * @ClassName: ChuangLanSmsDemo
 * @Description:创蓝普通短信发送
 */
public class CLSmsSend {
	private static final Logger log = LoggerFactory.getLogger(CLSmsSend.class);

	// 短信地址
	private static String url;
	// 编码
	private static String charset;
	// 用户平台API账号(非登录账号,示例:N1234567)
	private static String account;
	// 用户平台API密码(非登录密码)
	private static String pswd;
	// 状态报告
	private static String report;

	static {
		Properties prop = new Properties();
		InputStream in = CLSmsSend.class.getClassLoader().getResourceAsStream("sms-notify.properties");
		try {
			prop.load(in);
			url = prop.getProperty("sms2.url").trim();
			charset = prop.getProperty("sms2.charset").trim();
			account = prop.getProperty("sms2.userName").trim();
			pswd = prop.getProperty("sms2.password").trim();
			report = prop.getProperty("sms2.report").trim();
		} catch (Exception e) {
			log.error("-------------e",e);
		}
	}
	
	public static String send(String phone,String msg) throws Exception{
		String code = "";
		try {
			//发送短信内容给短信内容添加签名
			msg = msg;
			
			//获取到账号，密码，短信内容，手机号
			SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);
			
			//将账号，密码，短信内容，手机号 转换成json格式
			String requestJson = JSON.toJSONString(smsSingleRequest);
			
			//发送短信
			String response = ChuangLanSmsUtil.sendSmsByPost(url, requestJson, charset);
			
			//将返回的数据转换成json格式
			SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
			//获取到返回的状态码
			code = smsSingleResponse.getCode();

			log.info("返回的状态码是" + code +"客户手机号是"+ phone);
		} catch (Exception e) {
			log.info("短信发送失败" + code);
		}
		return code;
	}

//	public static void main(String[] args) {
//		try {
//			CLSmsSend.send("15869133169","测试");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
