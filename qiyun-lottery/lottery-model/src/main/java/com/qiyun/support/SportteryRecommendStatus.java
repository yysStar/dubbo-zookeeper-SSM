package com.qiyun.support;



import com.qiyun.model.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class SportteryRecommendStatus extends IntegerBeanLabelItem {

	protected SportteryRecommendStatus(String name, int value) {
		super(SportteryRecommendStatus.class.getName(), name, value);
	}
	
	public static SportteryRecommendStatus getItem(int value) {
		return (SportteryRecommendStatus) SportteryRecommendStatus.getResult(SportteryRecommendStatus.class.getName(), value);
	}
	public final static SportteryRecommendStatus NENO = new SportteryRecommendStatus("全部", -1);
	public final static SportteryRecommendStatus ONSALE = new SportteryRecommendStatus("在售", 0);
	public final static SportteryRecommendStatus CANCLE = new SportteryRecommendStatus("取消", 1);
	public final static SportteryRecommendStatus SALEEND = new SportteryRecommendStatus("截止", 2);
	public final static SportteryRecommendStatus DELAY = new SportteryRecommendStatus("延期", 3);
	public final static SportteryRecommendStatus ERROR = new SportteryRecommendStatus("错误", 4);
	public final static SportteryRecommendStatus BINGO = new SportteryRecommendStatus("命中", 5);
	
	public static List<SportteryRecommendStatus> allList=new ArrayList<SportteryRecommendStatus>();
	static{
		allList.add(ONSALE);
//		allList.add(CANCLE);
		allList.add(SALEEND);
//		allList.add(DELAY);
		allList.add(ERROR);
		allList.add(BINGO);
	}
}
