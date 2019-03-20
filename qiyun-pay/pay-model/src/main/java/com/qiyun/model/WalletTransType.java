package com.qiyun.model;

import java.util.ArrayList;
import java.util.List;


public class WalletTransType extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 4374311954577256855L;

	protected WalletTransType(String name, int value) {
		super(WalletTransType.class.getName(), name, value);
	}

	public static WalletTransType getItem(int value) {
		return (WalletTransType) WalletTransType.getResult(WalletTransType.class.getName(), value);
	}

	public static final WalletTransType ALL = new WalletTransType("全部", -1);
	public static final WalletTransType CHARGE = new WalletTransType("网上充值", 0);
	public static final WalletTransType CASH_CHARGE = new WalletTransType("现金充值", 1000);
	public static final WalletTransType CHONGZHENG = new WalletTransType("冲正", -1000);//调账  // 独立扣款科目，负数值存为正
	public static final WalletTransType PRESENT = new WalletTransType("赠送", 1);
	public static final WalletTransType PRESENT_REMOVE = new WalletTransType("彩金扣除", -1001); // 独立扣款科目，负数值存为正
	public static final WalletTransType REG_PRESENT = new WalletTransType("注册赠送", 1001);
	public static final WalletTransType CHARGE_PRESENT = new WalletTransType("充值赠送", 1002);
	public static final WalletTransType CARD_PRESENT = new WalletTransType("彩金卡赠送", 1003);
	public static final WalletTransType CONSUME_PRESENT = new WalletTransType("消费赠送", 1004);
	public static final WalletTransType FUND_PRESENT = new WalletTransType("基金赠送", 1009);
	public static final WalletTransType HM_RAISE_PRESENT = new WalletTransType("合买发单赠送", 1010);
	public static final WalletTransType JIFEN_EXCHANGE = new WalletTransType("积分兑换", 1011);
	public static final WalletTransType CHARE_PACKAGE_PRESENT = new WalletTransType("追号套餐赠送", 1014);
	public static final WalletTransType AWARD_PRESENT = new WalletTransType("加奖赠送", 1015);
	public static final WalletTransType PRIVATE_PRESENT = new WalletTransType("公司账号充值", 1017);
	public static final WalletTransType AWARD_REPAIR_PRESENT = new WalletTransType("奖金补发", 1018);//调账
	public static final WalletTransType CHEAP_PRESENT = new WalletTransType("优惠赠送", 1020);
	public static final WalletTransType FUND_IN = new WalletTransType("基金款转入", 2001);
	public static final WalletTransType FUND_OUT = new WalletTransType("基金款转出", 2002);   // 独立扣款科目，负数值存为正
	public static final WalletTransType FUND_LIQUIDATE = new WalletTransType("基金清算", 2003);
	public static final WalletTransType CONSUME = new WalletTransType("消费", 30);				// 独立扣款科目，负数值存为正
	public static final WalletTransType TELEFEE_CHARGE = new WalletTransType("话费充值", 3001); // 独立扣款科目，负数值存为正
	public static final WalletTransType FREEZE = new WalletTransType("冻结", 31);
	public static final WalletTransType UN_FREEZE = new WalletTransType("解冻", 32);
	public static final WalletTransType RETURN = new WalletTransType("退款", 34);
	public static final WalletTransType RETURN_PRIZE = new WalletTransType("返奖", 35);
	public static final WalletTransType SUBSTRACT = new WalletTransType("提款", 36);		// 独立扣款科目，负数值存为正
	public static final WalletTransType BANKRETURN = new WalletTransType("银行退单", 37);
	public static final WalletTransType WCUP_DG_PRESENT = new WalletTransType("单挑王", 1031);
	public static final WalletTransType COMMISION = new WalletTransType("佣金",1056);
	public static final WalletTransType AMOUNT_EXCHANGE_SCORE = new WalletTransType("彩金兑积分", 2053);
	public static final WalletTransType BUY_RECOMMEND = new WalletTransType("购买靓胆", 2054);
	public static final WalletTransType RECOMMEND = new WalletTransType("靓胆推荐", 2055);
	public static final WalletTransType RECOMMEND_ADMIN_OUT = new WalletTransType("靓胆支出", 2056); //"竞彩专家" 靓胆支出
	public static final WalletTransType RECOMMEND_ADMIN_IN= new WalletTransType("靓胆收入", 2057);//"竞彩专家" 靓胆收入
	public static final WalletTransType XX_CHARGE= new WalletTransType("线下充值", 2058);
	public static final WalletTransType Gold= new WalletTransType("收佣", 2059);
	public static final WalletTransType PAY_Gold= new WalletTransType("付佣", 2060);
	public static final WalletTransType COPY_LOTTERY= new WalletTransType("复制跟单", 2061);
	public static final WalletTransType CREDIT_CHARGE= new WalletTransType("授信充值", 2062);
	public static final WalletTransType XFB_QQSCAN= new WalletTransType("QQ扫码充值", 2063); //信付宝QQ扫码
	public static final WalletTransType XFB_QQH5= new WalletTransType("QQH5充值", 2064); //信付宝QQH5
	public static final WalletTransType XFB_QUICK= new WalletTransType("快捷支付充值", 2065); //信付宝快捷支付
	public static final WalletTransType XFB_WY= new WalletTransType("网银充值", 2066); //信付宝网银
	public static final WalletTransType YB_QUICK= new WalletTransType("快捷支付充值", 2067); //易宝快捷支付
	public static final WalletTransType YB_ZFB= new WalletTransType("支付宝充值", 2068); //易宝支付宝
	public static final WalletTransType YB_WX= new WalletTransType("微信充值", 2069); //易宝微信
	public static final WalletTransType UN_ZFB= new WalletTransType("支付宝充值", 2070); //unPay支付宝
	public static final WalletTransType XY_WX= new WalletTransType("微信充值", 2071); //兴业微信
	public static final WalletTransType LL_QUICK= new WalletTransType("快捷支付充值", 2072); //连连快捷支付

	public static final WalletTransType AWARD_RED_PACKET= new WalletTransType("发红包", 41);
	public static final WalletTransType GRAB_RED_PACKET= new WalletTransType("抢红包", 42);
	public static final WalletTransType RETURN_RED_PACKET= new WalletTransType("退还红包", 43);

	public static List<WalletTransType> list = new ArrayList<WalletTransType>();
	public static List<WalletTransType> outTypeList = new ArrayList<WalletTransType>(); // 交易类型属于支出的
	public static List<WalletTransType> chargeTypeList = new ArrayList<WalletTransType>(); // 交易类型属于充值的
	public static List<WalletTransType> consumeTypeList = new ArrayList<WalletTransType>(); // 交易类型属于消费的
	public static List<WalletTransType> returnTypeList = new ArrayList<WalletTransType>(); // 交易类型属于退款的
	public static List<WalletTransType> prizeTypeList = new ArrayList<WalletTransType>(); // 交易类型属于奖金的
	public static List<WalletTransType> presentTypeList = new ArrayList<WalletTransType>(); // 交易类型属于赠送的
	public static List<WalletTransType> TikuanTypeList = new ArrayList<WalletTransType>(); // 交易类型属于提款的
	public static List<WalletTransType> TikuanReturnTypeList = new ArrayList<WalletTransType>(); // 交易类型属于提款退款的
	public static List<WalletTransType> otherList = new ArrayList<WalletTransType>(); // 其他
	public static List<WalletTransType> takeCashList=new ArrayList<WalletTransType>();//可提现的类型集合

	static {
		list.add(ALL);
		list.add(CHARGE);
		list.add(CASH_CHARGE);
		list.add(PRIVATE_PRESENT);
		list.add(PRESENT);
		list.add(REG_PRESENT);
		list.add(CHARGE_PRESENT);
		list.add(CARD_PRESENT);
		list.add(CONSUME_PRESENT);
		list.add(FUND_LIQUIDATE);
		list.add(FUND_PRESENT);
		list.add(HM_RAISE_PRESENT);
		list.add(JIFEN_EXCHANGE);
		list.add(CHARE_PACKAGE_PRESENT);
		list.add(AWARD_PRESENT);
		list.add(AWARD_REPAIR_PRESENT);
		list.add(CHEAP_PRESENT);
		list.add(WCUP_DG_PRESENT);
		list.add(CONSUME);
		list.add(TELEFEE_CHARGE);
		list.add(RETURN);
		list.add(RETURN_PRIZE);
		list.add(SUBSTRACT);
		list.add(BANKRETURN);
		list.add(CHONGZHENG);
		list.add(PRESENT_REMOVE);
		list.add(FUND_IN);
		list.add(FUND_OUT);
		list.add(FREEZE);
		list.add(UN_FREEZE);
		list.add(AMOUNT_EXCHANGE_SCORE);
		list.add(BUY_RECOMMEND);
		list.add(RECOMMEND);
		list.add(RECOMMEND_ADMIN_IN);
		list.add(RECOMMEND_ADMIN_OUT);
		//支出类型
		outTypeList.add(WalletTransType.CHONGZHENG);
		outTypeList.add(WalletTransType.PRESENT_REMOVE);
		outTypeList.add(WalletTransType.FUND_OUT);
		outTypeList.add(WalletTransType.TELEFEE_CHARGE);
		outTypeList.add(WalletTransType.FREEZE);
		outTypeList.add(WalletTransType.SUBSTRACT);
		outTypeList.add(WalletTransType.CONSUME);
		outTypeList.add(WalletTransType.AMOUNT_EXCHANGE_SCORE);
		outTypeList.add(WalletTransType.BUY_RECOMMEND);
		outTypeList.add(WalletTransType.COPY_LOTTERY);
		outTypeList.add(WalletTransType.AWARD_RED_PACKET);
		//充值的类型
		chargeTypeList.add(WalletTransType.CHARGE);
		chargeTypeList.add(WalletTransType.CASH_CHARGE);
		chargeTypeList.add(WalletTransType.PRIVATE_PRESENT);
		chargeTypeList.add(WalletTransType.XX_CHARGE);
		chargeTypeList.add(WalletTransType.CREDIT_CHARGE);
		chargeTypeList.add(WalletTransType.XFB_QQSCAN);
		chargeTypeList.add(WalletTransType.XFB_QQH5);
		chargeTypeList.add(WalletTransType.XFB_QUICK);
		chargeTypeList.add(WalletTransType.XFB_WY);
		chargeTypeList.add(WalletTransType.YB_QUICK);
		chargeTypeList.add(WalletTransType.YB_ZFB);
		chargeTypeList.add(WalletTransType.YB_WX);
		chargeTypeList.add(WalletTransType.UN_ZFB);
		chargeTypeList.add(WalletTransType.XY_WX);
		chargeTypeList.add(WalletTransType.LL_QUICK);
		//消费的类型
		consumeTypeList.add(WalletTransType.CONSUME);
		consumeTypeList.add(WalletTransType.TELEFEE_CHARGE);
		consumeTypeList.add(WalletTransType.COPY_LOTTERY);
		//退款的类型
		returnTypeList.add(WalletTransType.RETURN);
		returnTypeList.add(WalletTransType.FUND_LIQUIDATE);
		returnTypeList.add(WalletTransType.GRAB_RED_PACKET);
		//奖金的类型
		prizeTypeList.add(WalletTransType.RETURN_PRIZE);
		prizeTypeList.add(WalletTransType.AWARD_REPAIR_PRESENT);

		//赠送的类型
		presentTypeList.add(WalletTransType.PRESENT);
		presentTypeList.add(WalletTransType.REG_PRESENT);
		presentTypeList.add(WalletTransType.CHARGE_PRESENT);
		presentTypeList.add(WalletTransType.CARD_PRESENT);
		presentTypeList.add(WalletTransType.CONSUME_PRESENT);
		presentTypeList.add(WalletTransType.FUND_PRESENT);
		presentTypeList.add(WalletTransType.HM_RAISE_PRESENT);
		presentTypeList.add(WalletTransType.CHARE_PACKAGE_PRESENT);
		presentTypeList.add(WalletTransType.AWARD_PRESENT);
		presentTypeList.add(WalletTransType.WCUP_DG_PRESENT);
		presentTypeList.add(WalletTransType.CHEAP_PRESENT);
		presentTypeList.add(WalletTransType.GRAB_RED_PACKET);
		//提款的
		TikuanTypeList.add(WalletTransType.SUBSTRACT);
		//提款退单的
		TikuanReturnTypeList.add(WalletTransType.BANKRETURN);
		// 其他
		otherList.add(WalletTransType.CHONGZHENG);
		otherList.add(WalletTransType.PRESENT_REMOVE);
		otherList.add(WalletTransType.FUND_IN);
		otherList.add(WalletTransType.FUND_OUT);
		otherList.add(WalletTransType.FREEZE);
		otherList.add(WalletTransType.UN_FREEZE);
		otherList.add(WalletTransType.RECOMMEND);
		otherList.add(WalletTransType.RECOMMEND_ADMIN_OUT);
		otherList.add(WalletTransType.RECOMMEND_ADMIN_IN);
		otherList.add(WalletTransType.Gold);
		otherList.add(WalletTransType.PAY_Gold);
		//可提现的集合
		takeCashList.add(WalletTransType.COMMISION);
		takeCashList.add(WalletTransType.RETURN_PRIZE);
		takeCashList.add(WalletTransType.RECOMMEND_ADMIN_IN);
		takeCashList.add(WalletTransType.RECOMMEND);
		takeCashList.add(WalletTransType.Gold);
	}
}
