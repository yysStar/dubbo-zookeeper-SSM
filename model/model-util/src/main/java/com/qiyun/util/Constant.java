package com.qiyun.util;

import com.qiyun.model.Member;
import com.qiyun.tools.StringTools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class Constant {	
	//网站虚拟账号 通过InitServletl类加载
	public static String VirtualAccount = "";
	final static public String TOKEN = "token"; // token
	final static public int CONSUME_PRESENT_RATE = 10; // 消费赠送比率
	final static public int VIP_CONSUME_PRESENT_RATE = 20; // VIP消费赠送比率
	final static public int SCORE_TO_FUND_RATE = 2000; // 积分购基金的比率
	final static public int SCORE_TO_HF_RATE = 5000; // 积分购话费的比率
	final static public int SCORE_EXCHANGE_MONEY_RATE = 500;// 积分买套餐兑换现金比率
	final static public int SALARY_EXCHANGE_MONEY_RATE = 333;
	final static public String ADMIN_SESSION = "ADMIN_SESSION";	
	final static public String SELLER_SESSION = "SELLER_SESSION";	
	final static public String SELLER_PER_SESSION = "SELLER_PER_SESSION";	
	final static public String SELLER_ACCOUNT_SESSION = "SELLER_ACCOUNT_SESSION";	
	final static public String AGENT_SESSION = "AGENT_SESSION";
	final static public String CPS_SESSION = "CPS_SESSION";
	final static public String VALID_CODE_RESULT = "VALID_CODE_RESULT";
	final static public String MEMBER_LOGIN_SESSION = "MEMBER_LOGIN_SESSION";
	final static public String MEMBERSCORE_LOGIN_SESSION = "MEMBERSCORE_LOGIN_SESSION";	
	final static public String MEMBERSCORE_LOGIN_PASSWORD = "MEMBERSCORE_LOGIN_PASSWORD";	
	final static public String MEMBER_TIPS_SESSION = "MEMBER_TIPS_SESSION";	
	final static public String MEMBER_GUIDE_SESSION = "MEMBER_GUIDE_SESSION";//首页引导标示    
	final static public String FILE_STATUS_SESSION = "FILE_STATUS_SESSION";
	final static public String FILE_PATH_SESSION = "FILE_PATH_SESSION";	
	final static public String TOKEN_SESSION="TOKEN_SESSION";
	final static public String USER_NAME_COOKIE = "user_name";//用户名cookie
	final static public String MEMBER_INFO_IS_COMPLETE = "is_complete";//用户信息是否完整
	final static public String MOBILE = "mobile";//手机号码	
	final static public int IsWhitelist = 1;//白名单	
	final static public String CERT_NO = "cert_no";//身份证	
	final static public String CARD = "card";//提款卡号	
	final static public String UNBOUND_ITEM = "unbound_item";//未绑定项	
	public static final Double MAX_MONEY = 100000d;// 最大兑换金额 10w
	public static final Double MIN_MONEY = 1d;// 最小兑换金额
	public static final Double RATE = 2000d;// 汇率
	final static public String LUCK_INTRODUCE_TIP_COOKIE = "luck_introduce_tip";	
	final static public String UNITE_REGISTER_KEY = "cllUnteLoginKey";//联合登陆加密key
	final static public String UNITE_REGISTER_OUT_ID = "UNITE_REGISTER_OUT_ID";//联合登陆out_id
	final static public String UNITE_REGISTER_REAL_NAME = "UNITE_REGISTER_REAL_NAME";//联合登陆真实姓名
	final static public String UNITE_REGISTER_CERT_NO = "UNITE_REGISTER_CERT_NO";//联合登陆身份证号码
	final static public String UNITE_REGISTER_MOBILE = "UNITE_REGISTER_MOBILE";//联合登陆手机号码
	final static public String UNITE_REGISTER_EMAIL = "UNITE_REGISTER_EMAIL";//联合登陆电子邮箱
	final static public String UNITE_REGISTER_GRADE = "UNITE_REGISTER_GRADE";//联合登陆用户等级
	final static public String EMPTY_XML_STRING = "<?xml version=\"1.0\" encoding=\"GBK\"?><message version=\"1.0\" id=\"\"></message>";
	final static public String HB_EMPTY_XML_STRINGCFG = "<?xml version=\"1.0\" encoding=\"utf-8\"?><message></message>";
	//江苏快3最大倍数限制
	final static public int K3_MUTIPLE_LIMIT = 999;
	//欲投合买方案购买额度限制
	final static public int PLAN_AMOUNT_LIMIT = 20000;
	//存储ihpone手机登陆用户信息
	public static  Map<String, HttpSession> IPHONE_USER_INFO_LIST = new LinkedHashMap<String, HttpSession>();
	//高频生成追号期数
	final static public int GP_CHASE_MAX_TERM = 1000;
	//低频生成追号期数
	final static public int DP_CHASE_MAX_TERM = 100;
	/**
	 * 积分比例(1元:200积分)
	 */
	public static final int SCORE_RATIO = 200;
	//签到积分值
	public static final int SIGN_SCORE_VALUE = 100;
	/**
	 * 定位跟随
	 */
	public static final int FOLLOW_TYPE_DW = 0;
	/**
	 * 不定位跟随
	 */
	public static final int FOLLOW_TYPE_BDW = 1;
    
	/**
	 * 组选跟随
	 */
	public static final int FOLLOW_TYPE_ZX = 2;
	
	public static final String JCLD_ACCOUNT="竞彩推荐";
	
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * MD5标准计算摘要
	 */
	public static String MD5digest(String inbuf) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(inbuf.getBytes(), 0, inbuf.length());
			return new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			LogUtil.error(e);
		}
		return null;
	}

	public static String virtualAccountSql(){
		String temp=VirtualAccount.replaceAll(",", "','");
		return temp.substring(2,temp.length()-2);
	}
	public static List<String> getVirtualAccounts() {
		String virtualAccountSql = Constant.VirtualAccount;
		virtualAccountSql = virtualAccountSql.substring(1,Constant.VirtualAccount.length()-1);
		return Arrays.asList(virtualAccountSql.split(","));
	}
	/**
	 * 判断是否虚拟账号  
	 * @param account
	 * @return
	 */
	public static boolean isVirtualAccount(String account){
		return Constant.VirtualAccount.indexOf("," + account + "," ) > -1;
	}
	
	
	/**
	 * 初始化ios（购彩/充值）页面登录环境
	 * @param  key;
	 * @param  map
	 */
	@SuppressWarnings("unchecked")
	public static void initIOSPageSession(String key,Map map){
		if(!StringTools.isNullOrBlank(key)){
			HttpSession session = Constant.IPHONE_USER_INFO_LIST.get(key); 
			if(session!=null){
				Member m=(Member)session.getAttribute(Constant.MEMBER_LOGIN_SESSION);
				map.put(Constant.MEMBER_LOGIN_SESSION, m);
				Constant.IPHONE_USER_INFO_LIST.remove(key);
			}
		}
	}
}