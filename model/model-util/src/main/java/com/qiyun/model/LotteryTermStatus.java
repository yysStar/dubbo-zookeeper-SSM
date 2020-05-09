package com.qiyun.model;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;


public class LotteryTermStatus extends IntegerBeanLabelItem {

	protected LotteryTermStatus(String name, int value) {
		super(LotteryTermStatus.class.getName(), name, value);
	}
	
	public static LotteryTermStatus getItem(int value) {
		return (LotteryTermStatus) LotteryTermStatus.getResult(LotteryTermStatus.class.getName(), value);
	}
	
	public static final LotteryTermStatus CANCLED = new LotteryTermStatus("已取消", 0);
	public static final LotteryTermStatus BEFORE_OPEN_SALE = new LotteryTermStatus("未开启", 1);
	public static final LotteryTermStatus OPEN = new LotteryTermStatus("已开启", 2);
	public static final LotteryTermStatus CLOSE = new LotteryTermStatus("关闭", 3);
	public static final LotteryTermStatus OPEN_PRIZE = new LotteryTermStatus("已开奖", 4);
	public static final LotteryTermStatus RETURN_PRIZE = new LotteryTermStatus("已派奖", 5);
	public static final LotteryTermStatus FINISH = new LotteryTermStatus("已完结", 6);
	
	public static List list = new ArrayList();
	
	public static List<LotteryTermStatus> luckList=new ArrayList<LotteryTermStatus>();
	
	public static List<LotteryTermStatus> aleadyOpenPrize = new ArrayList<LotteryTermStatus>();//已开奖
	
	static{
		list.add(CANCLED);
		list.add(BEFORE_OPEN_SALE);
		list.add(OPEN);
		list.add(CLOSE);
		list.add(OPEN_PRIZE);
		list.add(RETURN_PRIZE);
		list.add(FINISH);
		
		luckList.add(CANCLED);
		luckList.add(BEFORE_OPEN_SALE);
		luckList.add(OPEN);
		luckList.add(CLOSE);
		luckList.add(FINISH);
		luckList.add(OPEN_PRIZE);
		luckList.add(RETURN_PRIZE);
		
		aleadyOpenPrize.add(OPEN_PRIZE);
		aleadyOpenPrize.add(RETURN_PRIZE);
	}

}
