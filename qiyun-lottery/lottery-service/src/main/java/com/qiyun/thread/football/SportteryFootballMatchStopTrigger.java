package com.qiyun.thread.football;

import com.qiyun.model.football.FootBallMatch;
import com.qiyun.thread.basketball.SportteryMatchStopTrigger;
import com.qiyun.utils.TimeTools;

import java.util.Date;

public final class SportteryFootballMatchStopTrigger extends SportteryMatchStopTrigger<FootBallMatch> {
	private final static String NAME="SportteryFootballMatchStopTrigger";
	public String getName() {return NAME;}

	// 取得彩种名称
	protected String getLotteryName() {return "竞彩足球";	}

//	// 取得招募中的订单
//	protected List<LotteryPlan> getHmzmz() {
//		String term = "201001";
//		List<LotteryPlan> hmList = new ArrayList<LotteryPlan>();
//		for(LotteryType lottyerType:LotteryType.JCZQList){
//			hmList.addAll(lotteryPlanService.findHmPlanForFailure(lottyerType, PlanType.HM, SelectType.ALL, term));
//		}
//		return hmList;
//	}

	@Override
	protected Class<FootBallMatch> getXClass() {
		return FootBallMatch.class;
	}
//	@Override
//	protected LotteryTypeProps getLotteryTypeProps() {
//		return lotteryTypePropsService.findById(LotteryType.JC_ZQ_RQSPF.getValue());
//	}
	protected  Date getEndSaleTime(Date matchTime, int aheadMilli) {// 计算实际的截止时间
		return TimeTools.getFbEndSaleTime(matchTime, aheadMilli);
	}
}
