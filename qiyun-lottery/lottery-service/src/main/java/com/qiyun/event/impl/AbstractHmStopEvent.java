package com.qiyun.event.impl;

import com.qiyun.businuss.PlanBusiness;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.event.Event;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTypeProps;
import com.qiyun.type.SelectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 合买截止事件抽象实现类
 * @author ysh
 *
 */
public abstract class AbstractHmStopEvent extends AbstractEvent {
	static final String EVENT_NAME="合买截止事件";
	private PlanBusiness planBusiness;

	/**
	 * 合买截止改为只处理单式合买截至事件，复式合买放到彩期截止事件去处理
	 * @author zf
	 * @since 2011-4-21
	 */
	@SuppressWarnings("unchecked")
	public Map execute(Map request) {
		LotteryType lotteryType = (LotteryType) request.get(LOTTERY_TYPE);
		LotteryTerm term = (LotteryTerm) request.get(NOW_TERM);
		List refLotteryTypeList = (List)request.get(Event.RefLotteryTypeList);
		
		//待处理彩种列表
		List<String> ltList = new ArrayList<String>();
		ltList.add(lotteryType.getValue()+"");
		//如果相关彩种list不为null, 则加入到待处理彩种列表中
		if(refLotteryTypeList != null) ltList.addAll(refLotteryTypeList);
		
		//开始处理
		for(String lt : ltList){
			// 开始执行单式合买结束事件 暂停
//			planBusiness.hmStopProcess(LotteryType.getItem(Integer.valueOf(lt)), term.getTerm(), SelectType.ALL, Platform.WWW);
		}
			
		return request;
	}
	
	public long getScheduledTime(Map request) {
		LotteryTerm lotteryTerm = (LotteryTerm) request.get(NOW_TERM);
		LotteryTypeProps props=(LotteryTypeProps) request.get(PROPS);
		if(props!=null){
			return lotteryTerm.getEndDateTime().getTime() - props.getDsAheadTime();
		}
		return lotteryTerm.getEndDateTime().getTime();
	}

	public void setPlanBusiness(PlanBusiness planBusiness) {
		this.planBusiness = planBusiness;
	}
	
	public String getEventName() {
		return EVENT_NAME;
	}
}
