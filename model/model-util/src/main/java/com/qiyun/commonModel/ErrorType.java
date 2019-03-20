package com.qiyun.commonModel;


import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 错误类别.
 * 
 * @author sxh 
 * @date   2011-11-30
 */
public class ErrorType extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = 1L;

	protected ErrorType(String name, int value) {
		super(ErrorType.class.getName(), name, value);
	}
	
	public static ErrorType getItem(int value) {
		return (ErrorType) ErrorType.getResult(ErrorType.class.getName(), value);
	}
	
	public final static ErrorType ALL = new ErrorType("全部", -1);
	//public final static ErrorType BINGO = new ErrorType("开奖", 1);
	//public final static ErrorType FAILURE_BINGO = new ErrorType("流单开奖", 2);
	//public final static ErrorType RETURN_PRIZE = new ErrorType("派奖", 3);
	//public final static ErrorType SNATCH_RESULT = new ErrorType("彩果抓取", 4);
	//public final static ErrorType SEND_TICKET = new ErrorType("送票", 5);
	
	//后端事件
	public final static ErrorType 彩期守护 = new ErrorType("彩期守护", 2000);
	public final static ErrorType 拆票 = new ErrorType("拆票", 2010);
	public final static ErrorType 送票 = new ErrorType("送票", 2020);
	public final static ErrorType 查票 = new ErrorType("查票", 2030);
	public final static ErrorType 检票 = new ErrorType("检票", 2040);
	public final static ErrorType 彩果抓取 = new ErrorType("彩果抓取", 2050);
	public final static ErrorType 开奖 = new ErrorType("开奖", 2060);
	public final static ErrorType 流单开奖 = new ErrorType("流单开奖", 2061);
	public final static ErrorType 保存方案开奖 = new ErrorType("保存方案开奖", 2062);
	public final static ErrorType 未支付方案开奖 = new ErrorType("保存方案开奖", 20623);
	public final static ErrorType 派奖 = new ErrorType("派奖", 2070);
	public final static ErrorType 积分投注派奖 = new ErrorType("积分投注派奖", 2071);
	public final static ErrorType 追号 = new ErrorType("追号", 2080);
	public final static ErrorType 对帐 = new ErrorType("对帐", 2090);	
	
	public final static ErrorType 微信警告 = new ErrorType("微信警告", 3000);	
	public final static ErrorType 微信维权 = new ErrorType("微信维权", 3010);
	
	public final static ErrorType 方案出票 = new ErrorType("方案出票", 3011);
	public final static ErrorType 数据=new ErrorType("数据",3012);

	//前端事件
	public final static ErrorType 注册 = new ErrorType("注册", 1000);
	public final static ErrorType 充值 = new ErrorType("充值", 1010);
	public final static ErrorType 购彩 = new ErrorType("购彩", 1020);
	public final static ErrorType 提现 = new ErrorType("提现", 1030);
	public final static ErrorType VIP提现 = new ErrorType("VIP提现", 1040);
	
	public static List<ErrorType> list = new ArrayList<ErrorType>();
	public static List<ErrorType> focusList = new ArrayList<ErrorType>();
	static {
		list.add(ErrorType.ALL);
		//后端事件
		list.add(ErrorType.彩期守护);
		list.add(ErrorType.拆票);
		list.add(ErrorType.送票);
		list.add(ErrorType.查票);
		list.add(ErrorType.检票);
		list.add(ErrorType.彩果抓取);
		list.add(ErrorType.开奖);
		list.add(ErrorType.流单开奖);
		list.add(ErrorType.保存方案开奖);
		list.add(ErrorType.未支付方案开奖);
		list.add(ErrorType.派奖);
		list.add(ErrorType.积分投注派奖);
		list.add(ErrorType.追号);
		list.add(ErrorType.方案出票);
		//前端事件
		list.add(ErrorType.注册);
		list.add(ErrorType.充值);
		list.add(ErrorType.购彩);
		list.add(ErrorType.提现);
		list.add(ErrorType.VIP提现);
		list.add(ErrorType.对帐);
		list.add(ErrorType.数据);
		list.add(ErrorType.对帐);
		list.add(ErrorType.数据);
		focusList.addAll(list);
		focusList.remove(ErrorType.流单开奖);
		
	}
}
