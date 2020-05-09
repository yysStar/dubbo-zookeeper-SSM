package com.qiyun.model.football;



import com.qiyun.model.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuxd
 *竞彩足球 加奖类型
 */
@SuppressWarnings("serial")
public class FootBallAddPrizeType extends IntegerBeanLabelItem {

	protected FootBallAddPrizeType(String name, int value) {
		super(FootBallAddPrizeType.class.getName(), name, value);
	}

	public static FootBallAddPrizeType getItem(int value) {
		return (FootBallAddPrizeType) FootBallAddPrizeType.getResult(FootBallAddPrizeType.class.getName(), value);
	}
	
	public static List<FootBallAddPrizeType> list = new ArrayList<FootBallAddPrizeType>();

	//正常情况 不加奖
	public static final FootBallAddPrizeType normal = new FootBallAddPrizeType("不加奖", 0);	
	//2012欧战加奖
	public static final FootBallAddPrizeType _2012EuroAddPrize = new FootBallAddPrizeType("欧战加奖", 101);	//2012欧洲杯胜平负
	static{
		list.add(FootBallAddPrizeType._2012EuroAddPrize);
		list.add(FootBallAddPrizeType.normal);
	}
}
