package com.qiyun.grabber.football;



import com.qiyun.model.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class RaceStatus extends IntegerBeanLabelItem {
	protected RaceStatus(String name, int value) {
		super(RaceStatus.class.getName(), name, value);
	}

	public static final RaceStatus NO_BUY = new RaceStatus("未销售", 0);

	public static final RaceStatus CAN_BUY = new RaceStatus("可销售", 1);

	public static final RaceStatus STOP_BUY = new RaceStatus("已停售", 2);

	public static final RaceStatus OPEN_BUY = new RaceStatus("已开奖", 3);

	public static final RaceStatus RETURN_PRIZE = new RaceStatus("已派奖", 4);

	public static RaceStatus getItem(int value) {
		return (RaceStatus) RaceStatus.getResult(RaceStatus.class.getName(), value);
	}

	public static List list = new ArrayList();

	static {
		list.add(NO_BUY);
		list.add(CAN_BUY);
		list.add(STOP_BUY);
		list.add(OPEN_BUY);
		list.add(RETURN_PRIZE);

	}
}
