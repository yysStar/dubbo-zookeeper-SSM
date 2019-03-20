package com.qiyun.model;

import java.util.ArrayList;
import java.util.List;


public class MemberOperType extends IntegerBeanLabelItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621003869402167413L;

	protected MemberOperType(String name, int value) {
		super(MemberOperType.class.getName(), name, value);
	}

	public static MemberOperType getItem(int value) {
		return (MemberOperType) MemberOperType.getResult(MemberOperType.class.getName(), value);
	}

	public static final MemberOperType ALL = new MemberOperType("全部", -1);

	public static final MemberOperType REGISTER = new MemberOperType("注册", 1);

	public static final MemberOperType LOGIN = new MemberOperType("登录", 2);

	public static final MemberOperType ADD_MONEY = new MemberOperType("充值", 3);

	public static final MemberOperType DGCHOOSE = new MemberOperType("代购选中方案", 4);

	public static final MemberOperType CONSUME = new MemberOperType("消费", 5);

	public static final MemberOperType RETURN_PRIZE = new MemberOperType("返奖", 6);

	public static final MemberOperType RETURN_MONEY = new MemberOperType("退款", 7);

	public static final MemberOperType HMCHOOSE = new MemberOperType("发起合买方案", 9);

	public static final MemberOperType CYCHOOSE = new MemberOperType("参与合买方案", 10);

	public static final MemberOperType ZHCHOOSE = new MemberOperType("追号", 11);

	public static final MemberOperType CHASE_CANCEL = new MemberOperType("取消追号", 12);

	public static final MemberOperType JOIN_CANCEL = new MemberOperType("参与合买撤单", 13);

	public static final MemberOperType MUTI_CANCEL = new MemberOperType("发起合买撤单", 14);

	public static final MemberOperType GET_MONEY = new MemberOperType("提款", 15);

	public static final MemberOperType GET_PASSWORD = new MemberOperType("取回密码", 16);

	public static final MemberOperType TRY_REGISTER = new MemberOperType("尝试注册", 17);

	public static final MemberOperType TRY_ADD_MONEY = new MemberOperType("尝试充值", 18);

	public static final MemberOperType VISTER = new MemberOperType("访问", 19);
	public static final MemberOperType RE_VISTER = new MemberOperType("回访", 20);
	public static final MemberOperType RE_ADD_MONEY = new MemberOperType("再充值", 21);

	public static final MemberOperType ADD_MONEYR_2CP = new MemberOperType("2彩票充值", 30);

	public static final MemberOperType CYJIJIN = new MemberOperType("参与合基金", 31);

	public static final MemberOperType CYORDER = new MemberOperType("参与订餐方案", 32);
	
	public static final MemberOperType USERUPDATE = new MemberOperType("用户修改", 33);
	
	public static final MemberOperType USERSAVE = new MemberOperType("用户创建", 34);
	
	public static final MemberOperType AUTO_FOLLOWING = new MemberOperType("自动跟单", 35);
	
	public static final MemberOperType FOLLOWING_CREATE = new MemberOperType("创建跟单", 36);
	
	public static final MemberOperType FOLLOWING_UPDATE = new MemberOperType("跟单条件修改", 37);
	
	public static final MemberOperType JOIN_EXPERT_PLAN = new MemberOperType("参与名家方案", 38);

	public static final MemberOperType FILTER_NUMBER = new MemberOperType("过滤选号", 40);
	
	public static final MemberOperType VERIFY_NUMBER = new MemberOperType("号码验证", 41);
	
	public static final MemberOperType Worthy_Attention_Number = new MemberOperType("值得关注的遗漏", 42);
	
	public static final MemberOperType CHARGE_GAME = new MemberOperType("充值挑战",43);
	
	public static final MemberOperType QIANG_DAN = new MemberOperType("移动端抢单",44);
	
	public static final MemberOperType UNION_BIND = new MemberOperType("联合登陆绑定", 45);
	
	public static final MemberOperType UNION_UNBIND = new MemberOperType("联合登陆解绑", 46);
    
	public static final MemberOperType ACTIVE_MOBILE = new MemberOperType("手机登录激活", 47);
	
	public static final MemberOperType ACTIVE_EMAIL = new MemberOperType("邮箱登录激活", 48);
	
	public static final MemberOperType AD_CLICK = new MemberOperType("广告点击", 49);
	
	public static final MemberOperType SAVE_PLAN = new MemberOperType("保存方案", 50);
	
	public static final MemberOperType SCORE_BET = new MemberOperType("积分投注", 51);
	
	public static final MemberOperType O2O_BET = new MemberOperType("彩票大管家投注", 52);
	
	public static final MemberOperType PAY_AGAIN = new MemberOperType("再次支付", 53);
	
	public static final MemberOperType TRY_LOGIN= new MemberOperType("尝试登陆", 54);
	
	public static final MemberOperType SAVE_ADDRESS= new MemberOperType("保存收货地址", 55);
	
	public static List<MemberOperType> list = new ArrayList<MemberOperType>();
	
	//跟单操作
	public static List<MemberOperType> followsList = new ArrayList<MemberOperType>();

	static {
		list.add(REGISTER);
		list.add(LOGIN);
		list.add(ADD_MONEY);
		list.add(DGCHOOSE);
		list.add(CONSUME);
		list.add(RETURN_PRIZE);
		list.add(RETURN_MONEY);
		list.add(HMCHOOSE);
		list.add(CYCHOOSE);
		list.add(ZHCHOOSE);
		list.add(CYJIJIN);
		list.add(CHASE_CANCEL);
		list.add(JOIN_CANCEL);
		list.add(MUTI_CANCEL);
		list.add(GET_MONEY);
		list.add(GET_PASSWORD);
		list.add(TRY_REGISTER);
		list.add(TRY_ADD_MONEY);
		list.add(VISTER);
		list.add(RE_VISTER);
		list.add(RE_ADD_MONEY);
		list.add(CYORDER);
		list.add(USERUPDATE);
		list.add(USERSAVE);
		list.add(AUTO_FOLLOWING);
		list.add(FOLLOWING_UPDATE);
		list.add(JOIN_EXPERT_PLAN);		
		list.add(FILTER_NUMBER);
		list.add(VERIFY_NUMBER);
		list.add(Worthy_Attention_Number);
		list.add(CHARGE_GAME);
		list.add(QIANG_DAN);
		list.add(UNION_BIND);
		list.add(UNION_UNBIND);
		list.add(AD_CLICK);
		list.add(SAVE_PLAN);
		list.add(SCORE_BET);
		list.add(O2O_BET);
		list.add(PAY_AGAIN);
		list.add(TRY_LOGIN);
		list.add(SAVE_ADDRESS);
		// list.add(VISTER_WAP);
		// list.add(VISTER_FAG);
		// list.add(TRY_REGISTER_WAP);
		// list.add(TRY_REGISTER_FAG);
		// list.add(TRY_ADD_MONEY_WAP);
		// list.add(TRY_ADD_MONEY_FAG);
		// list.add(REGISTER_WAP);
		// list.add(REGISTER_FAG);
		// list.add(ADD_MONEY_WAP);
		// list.add(ADD_MONEYR_FAG);
		
		followsList.add(AUTO_FOLLOWING);
		followsList.add(FOLLOWING_CREATE);
		followsList.add(FOLLOWING_UPDATE);
	}
}
