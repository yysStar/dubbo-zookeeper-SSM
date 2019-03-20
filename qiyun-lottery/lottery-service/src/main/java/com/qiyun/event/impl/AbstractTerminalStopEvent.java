package com.qiyun.event.impl;

import com.qiyun.businuss.PlanBusiness;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.event.Event;
import com.qiyun.model.LotteryTerm;
import com.qiyun.service.LotteryPlanService;
import com.qiyun.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 终端截止事件抽象实现类
 * @author ysh
 *
 */
public abstract class AbstractTerminalStopEvent extends AbstractEvent {
	static final String EVENT_NAME="终端截止事件";

	private LotteryPlanService lotteryPlanService;
	private PlanBusiness planBusiness;

	@SuppressWarnings("unchecked")
	public Map execute(Map request) {
		LotteryType lotteryType = (LotteryType) request.get(LOTTERY_TYPE);
		LotteryTerm term = (LotteryTerm) request.get(NOW_TERM);
		List refLotteryTypeList = (List)request.get(Event.RefLotteryTypeList);
		
		LogUtil.info("*********" + lotteryType.getName() + " " + term.getTerm() + " 终端截止事件启动*********");
		
		//待处理彩种列表
		List<String> ltList = new ArrayList<String>();
		ltList.add(lotteryType.getValue()+"");
		//如果相关彩种list不为null, 则加入到待处理彩种列表中
		if(refLotteryTypeList != null) ltList.addAll(refLotteryTypeList);
		
//		//开始处理
//		for(String lotType : ltList){
//			// 开始执行单式合买结束事件
//			Integer lt = Integer.parseInt(lotType);
//			//planBusiness.hmStopProcess(LotteryType.getItem(lt), term.getTerm(), SelectType.UPLOAD);
//			////CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//			List unPrintPlanList = lotteryPlanService.findUnPrintPlanByLotteryTypeAndTerm(LotteryType.getItem(lt), term.getTerm());
//			LogUtil.info(LotteryType.getItem(lt).getName() + "找到没有出票的方案， 数量为:" + unPrintPlanList.size());
//
//			//-----------------------------先对出票中的进行一次检票，防止检票10s的空档期--------------------
//			for (int i = 0; i < unPrintPlanList.size(); i++) {
//				try {
//					LotteryPlan plan = (LotteryPlan) unPrintPlanList.get(i);
//					this.lotteryPlanService.jianPiao(plan, Platform.WWW);
//				} catch (Exception e) {
//					LogUtil.error(e);
//				}
//			}
//
//			// //-----------------------------对传统数字彩招募中合买进行补单--------------------
//			//传统数字彩招募中合买截止时间未处理的补单，在这进行合买补单
//			if(LotteryType.CTSZCList.contains(LotteryType.getItem(lt))){
//				// 找出招幕中的合买单
//				List<LotteryPlan> hmList = this.lotteryPlanService.findHmPlanForFailure(LotteryType.getItem(lt), PlanType.HM, SelectType.ALL, term.getTerm());
//				LogUtil.info(LotteryType.getItem(lt).getName() + " " + term + "找到招幕中的单，数量为:" + hmList.size());
//
//				for (int i = 0; i < hmList.size(); i++) {
//					LotteryPlan plan = (LotteryPlan) hmList.get(i);
//					try {
//						planBusiness.hmPlanStopProcess(plan, true, Platform.WWW);
//					} catch (Exception e) {
//						LogUtil.error(e);
//						try {
//							String message = LotteryType.getItem(lt).getName() + " " + term + "合买结束异常，方案:" + plan.getPlanNo() + " " + e.getMessage();
//							LogUtil.info(message);
//						} catch (Exception ee) {
//							LogUtil.error(ee);
//						}
//					}
//				}
//			}
//
//			// ---------------------------------处理退单--------------------------------------
//			// 重查未出票定单
//			unPrintPlanList = lotteryPlanService.findUnPrintPlanByLotteryTypeAndTerm(LotteryType.getItem(lt), term.getTerm());
//			LogUtil.info(LotteryType.getItem(lt).getName() + "重查未出票定单，找到没有出票的方案，数量为:" + unPrintPlanList.size());
//			for (int i = 0; i < unPrintPlanList.size(); i++) {
//				LotteryPlan plan = (LotteryPlan) unPrintPlanList.get(i);
//				try {
//					lotteryPlanService.abortUnPrintPlan(plan, Platform.WWW);
//				} catch (Exception e) {
//					LogUtil.error(e);
//					String message = LotteryType.getItem(lt).getName() + "处理未出票退款异常，方案编号:" + plan.getPlanNo();
//					LogUtil.info(message);
//				}
//			}
//		}
		
		
		return request;
	}

	public String getEventName() {
		return EVENT_NAME;
	}
	
	public long getScheduledTime(Map request) {
		LotteryTerm term = (LotteryTerm) request.get(NOW_TERM);
		return term.getTerminalEndDateTime().getTime() + 20*1000;
	}
	
	public void setLotteryPlanService(LotteryPlanService lotteryPlanService) {
		this.lotteryPlanService = lotteryPlanService;
	}
	
	public void setPlanBusiness(PlanBusiness planBusiness) {
		this.planBusiness = planBusiness;
	}

}
