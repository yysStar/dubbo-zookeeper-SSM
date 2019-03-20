package com.qiyun.event;

import java.util.Map;

/**
 * 事件接口
 * @author ysh
 *
 */
public interface Event {
	public static final String PROPS="props"; 
	
	public static final String LOTTERY_TYPE="lotteryType";
	
	public static final String NOW_TERM="nowTerm";
	
	public static final String NEXT_TERM="nextTerm";
	//是否为修复操作
	public static final String IS_REPAIR="IS_REPAIR";
	//相关处理彩种列表（胜负彩，单场这类多彩种公用同一彩期的玩法使用）
	public static final String RefLotteryTypeList = "refLotteryTypeList";
	
	
	/**
	 * 执行事件
	 * 
	 * @param request
	 * @return 执行结果
	 */
	@SuppressWarnings("unchecked")
	public Map execute(Map request);

	/**
	 * 获取当前事件约定执行的时刻
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public long getScheduledTime(Map request);

	/**
	 * 获取下一个事件
	 * 
	 * @return
	 */
	public Event getNextEvent();
	
	/**
	 * 设置下一个事件
	 * 
	 * @return
	 */
	public void setNextEvent(Event nextEvent);

	/**
	 * 获取事件名
	 * 
	 * @return
	 */
	public String getEventName();
}
