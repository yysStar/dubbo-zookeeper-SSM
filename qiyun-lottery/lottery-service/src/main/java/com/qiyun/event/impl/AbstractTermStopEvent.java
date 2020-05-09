package com.qiyun.event.impl;

import com.qiyun.builder.ChaseTermBuilder;
import com.qiyun.builder.TermInfoBuilder;
import com.qiyun.businuss.PlanBusiness;
import com.qiyun.common.CommonStatus;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.event.Event;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTermStatus;
import com.qiyun.service.LotteryTermService;
import com.qiyun.type.SelectType;
import com.qiyun.util.Constant;
import com.qiyun.util.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 彩期截止事件抽象实现类
 * @author ysh
 *
 */
public abstract class AbstractTermStopEvent extends AbstractEvent {
	static final String EVENT_NAME="彩期停售事件";
	private LotteryTermService lotteryTermService;
	private ChaseTermBuilder chaseTermBuilder;
	private PlanBusiness planBusiness;
	private TermInfoBuilder termInfoBuilder;

	abstract public void updateTermCreatePlan(LotteryTerm term);

	@SuppressWarnings("unchecked")
	public Map execute(Map request) {
		LotteryType lotteryType = (LotteryType) request.get(LOTTERY_TYPE);
		LotteryTerm nowTerm = (LotteryTerm) request.get(NOW_TERM);
		List refLotteryTypeList = (List)request.get(Event.RefLotteryTypeList);
		
		LogUtil.info("*********" + lotteryType.getName() + " " + nowTerm.getTerm() + " 彩期停售事件启动*********");
		LotteryTerm nextTerm = this.lotteryTermService.findNextByLotteryTypeAndTerm(lotteryType, nowTerm.getTerm());
		if (nextTerm == null) {
			try {
				String message = lotteryType.getName() + "彩期切换异常，没有找�?" + nowTerm + "的下一期";
				LogUtil.info(message);
			} catch (Exception ee) {
				LogUtil.error(ee);
			}
		}

		//待处理彩种列表
		List<String> ltList = new ArrayList<String>();
		ltList.add(lotteryType.getValue()+"");
		//如果相关彩种list不为null, 则加入到待处理彩种列表中
		if(refLotteryTypeList != null) ltList.addAll(refLotteryTypeList);
		
		//开始处理
		for(String lt : ltList){
			// 开始执行所有合买结束事
//			planBusiness.hmStopProcess(LotteryType.getItem(Integer.valueOf(lt)), nowTerm.getTerm(), SelectType.ALL,
//					Platform.WWW);
		}
		
		//当前期彩期状态调整
		nowTerm = lotteryTermService.findById(nowTerm.getId());
		nowTerm.setStatus(LotteryTermStatus.CLOSE);
		this.lotteryTermService.attachDirty(nowTerm);
		
		if(nextTerm != null){
			//如果有下一期，才修改当前期标记
			nowTerm.setIsCurrentTerm(CommonStatus.NO);
			this.lotteryTermService.attachDirty(nowTerm);
			
			//下一期彩期状态调整
			nextTerm = lotteryTermService.findById(nextTerm.getId());
			nextTerm.setIsCurrentTerm(CommonStatus.YES);
			if(nextTerm.getStatus().getValue()<LotteryTermStatus.OPEN.getValue()){
				nextTerm.setStatus(LotteryTermStatus.OPEN);
			}
			this.lotteryTermService.attachDirty(nextTerm);
			
			//生成追号彩期列表数据
			try {
				int chaseCount = Constant.GP_CHASE_MAX_TERM;
				if(LotteryType.CTSZCList.contains(lotteryType)) {
					chaseCount = Constant.DP_CHASE_MAX_TERM;
				}
//				List list = this.lotteryTermService.findAfterByLotteryTypeAndTerm(lotteryType, nextTerm.getTerm(), chaseCount);
//				HashMap<String, Object> buildMap = new HashMap<String, Object>();
//				buildMap.put(ChaseTermBuilder.DATE, list);
//				buildMap.put(ChaseTermBuilder.LOTTERY_TYPE, lotteryType.getValue() + "");
//				chaseTermBuilder.make(buildMap);
			} catch (Exception e) {
				LogUtil.error(e);
			}

//			//彩期信息静态化
//			try {
//				LogUtil.info(lotteryType.getName() + " 第" + nextTerm.getTerm() + "期 ，开始生成彩期信息静态化数据");
//				HashMap<String, Object> map = new HashMap<String, Object>();
//				map.put(TermInfoBuilder.LOTTERY_TYPE, lotteryType.getValue() + "");
//				termInfoBuilder.make(map);
//				LogUtil.info(lotteryType.getName() + " 第" + nextTerm.getTerm() + "期 ，已经完成彩期信息静态化数据");
//			} catch (Exception e) {
//				String message = lotteryType.getName() + " 第" + nextTerm.getTerm() + "期生成彩期信息静态化异常";
//				LogUtil.error(message,e);
//			}
			try {
				updateTermCreatePlan(nextTerm);
			} catch (Exception e) {
				LogUtil.error(e);
			}
		}
		request.put(NEXT_TERM, nextTerm);
		return request;
	}
	
	public String getEventName() {
		return EVENT_NAME;
	}
	
	/**
	 * 将在当前期截止时执行
	 */
	@SuppressWarnings("unchecked")
	public long getScheduledTime(Map request) {
		LotteryTerm term = (LotteryTerm) request.get(NOW_TERM);
		return term.getEndDateTime().getTime();
	}

	public void setLotteryTermService(LotteryTermService lotteryTermService) {
		this.lotteryTermService = lotteryTermService;
	}

	public void setChaseTermBuilder(ChaseTermBuilder chaseTermBuilder) {
		this.chaseTermBuilder = chaseTermBuilder;
	}

	public void setPlanBusiness(PlanBusiness planBusiness) {
		this.planBusiness = planBusiness;
	}

	public void setTermInfoBuilder(TermInfoBuilder termInfoBuilder) {
		this.termInfoBuilder = termInfoBuilder;
	}
}
