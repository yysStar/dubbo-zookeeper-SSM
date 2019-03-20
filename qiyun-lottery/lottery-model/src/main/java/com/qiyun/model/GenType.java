package com.qiyun.model;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("unchecked")
public class GenType extends IntegerBeanLabelItem {

	protected GenType(String name, int value) {
		super(GenType.class.getName(), name, value);
	}

	public static GenType getItem(int value) {
		try {
			return (GenType) GenType.getResult(GenType.class.getName(), value);
		}catch(Exception e){
			return null;
		}
	}

	public static final GenType ALL = new GenType("全部", -1);

	public static final GenType TC = new GenType("套餐", 1);

	public static final GenType ZH = new GenType("追号", 2);

	public static final GenType ZG = new GenType("再次购买", 3);
	
	public static final GenType ZJW = new GenType("中奖王过滤", 4);
	
	public static final GenType ZJWZH=new GenType("中奖王追号",6);
	
	public static final GenType DGP=new GenType("单关配",8);
	
	public static final GenType SX=new GenType("双选",9);
	
	public static final GenType ZS_FILTER=new GenType("智能过滤",10);
	
	public static final GenType JJYH = new GenType("奖金优化",11);
	
	public static final GenType GROUP_FILTER = new GenType("分组过滤",12);
	
	public static final GenType STANDARD_FILTER = new GenType("标准过滤",13);
	
	public static final GenType HT2C1 = new GenType("亚盘",14);
	
	public static final GenType EXPERT_TIPS = new GenType("名家内幕", 15);

	public static final GenType TWO_TEN = new GenType("2元10注", 16);
	
	public static final GenType BIGUSER = new GenType("单式投注", 19);
	public static final GenType DCZS = new GenType("单场制胜", 20);
	public static final GenType WORLDCUP_DG = new GenType("单挑王", 21);
	public static final GenType QIANGDAN = new GenType("移动端抢单",24);
	
	public static List LIST_ZH = new ArrayList();

	static {
		LIST_ZH.add(ZH);
		LIST_ZH.add(ZJWZH);
	}

}
