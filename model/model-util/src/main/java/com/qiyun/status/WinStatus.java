package com.qiyun.status;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class WinStatus extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 1L;

	protected WinStatus(String name, int value) {
		super(WinStatus.class.getName(), name, value);
	}

	public static WinStatus getItem(int value) {
		return (WinStatus) WinStatus.getResult(WinStatus.class.getName(), value);
	}

	public static final WinStatus ALL = new WinStatus("全部类型", -1);
	public static final WinStatus NOT_RESULT = new WinStatus("未开奖", 1);//方案表&&TICKET表使用

	public static final WinStatus NOT_AWARD = new WinStatus("未中奖", 2);//方案表&&TICKET表使用

	public static final WinStatus AWARD = new WinStatus("已中奖", 3);//方案表&&TICKET表使用

	public static final WinStatus SEND_AWARD = new WinStatus("已派奖", 4);//方案表&&TICKET表使用
	
	public static final WinStatus PART_NOT_AWARD = new WinStatus("部分未中", 5); //方案表使用
	
	public static final WinStatus PART_AWARD = new WinStatus("部分已中", 6); //方案表使用
	
	public static final WinStatus PART_SEND = new WinStatus("部分派奖", 7);//方案表使用
	
	public static final WinStatus DRAWBACK = new WinStatus("已退款", 11);//方案表&&TICKET表使用

	public static List<WinStatus> list = new ArrayList<WinStatus>();
	
	public static List<WinStatus> aleadyOpenPrize = new ArrayList<WinStatus>();//已开奖

	public static List<WinStatus> AWARD_LIST = new ArrayList<WinStatus>();//已中奖
	
	public static List<WinStatus> PART_LIST=new ArrayList<WinStatus>();//部分开奖LIST
	
	public static List<WinStatus> SAVED_LIST = new ArrayList<WinStatus>(); // 免费保存后台显示列表
	
	public static List<WinStatus> SCORE_LIST = new ArrayList<WinStatus>(); // 积分投注后台显示列表
	
	static {
		list.add(ALL);
		list.add(NOT_RESULT);
		list.add(NOT_AWARD);
		list.add(AWARD);
		list.add(SEND_AWARD);
		list.add(DRAWBACK);
		list.add(PART_NOT_AWARD);
		list.add(PART_AWARD);
		list.add(PART_SEND);
		
		PART_LIST.add(PART_NOT_AWARD);
		PART_LIST.add(PART_AWARD);
		PART_LIST.add(PART_SEND);
		
		//已开奖状态
		aleadyOpenPrize.add(NOT_AWARD);
		aleadyOpenPrize.add(AWARD);
		aleadyOpenPrize.add(SEND_AWARD);
		aleadyOpenPrize.add(PART_NOT_AWARD);
		aleadyOpenPrize.add(PART_AWARD);
		aleadyOpenPrize.add(PART_SEND);
		
		AWARD_LIST.add(AWARD);
		AWARD_LIST.add(SEND_AWARD);
		AWARD_LIST.add(PART_SEND);
		
		// 免费保存后台显示列表
		SAVED_LIST.add(ALL);
		SAVED_LIST.add(NOT_RESULT);
		SAVED_LIST.add(NOT_AWARD);
		SAVED_LIST.add(AWARD);
		
		// 积分投注后台显示列表
		SCORE_LIST.add(ALL);
		SCORE_LIST.add(NOT_RESULT);
		SCORE_LIST.add(NOT_AWARD);
		SCORE_LIST.add(AWARD);
		SCORE_LIST.add(SEND_AWARD);
	}

}
