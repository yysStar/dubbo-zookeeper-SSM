package com.qiyun.handle;

import com.qiyun.builder.ChaseTermBuilder;
import com.qiyun.builder.TermInfoBuilder;
import com.qiyun.common.CommonStatus;
import com.qiyun.commonModel.ErrorType;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.event.Event;
import com.qiyun.event.impl.AbstractEvent;
import com.qiyun.manager.SystemErrorManager;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTermStatus;
import com.qiyun.model.LotteryTypeProps;
import com.qiyun.service.LotteryTermService;
import com.qiyun.service.LotteryTypePropsService;
import com.qiyun.tools.DateTools;
import com.qiyun.util.Constant;
import com.qiyun.util.LogUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHandle extends Thread implements Handle {
	private final String threadName = "彩期守护线程";
	private LotteryTermService lotteryTermService;
	private LotteryTypePropsService lotteryTypePropsService;
	private ChaseTermBuilder chaseTermBuilder;
	private TermInfoBuilder termInfoBuilder;
	private LotteryType lotteryType;
	//相关处理彩种列表（胜负彩，单场这类多彩种公用同一彩期的玩法使用）
	private List<Integer> refLotteryTypeList;
	private boolean isRun = true;
	protected Event hmStopEvent;
	protected Event openPrizeEvent;
	protected Event termStopEvent;
	protected Event terminalStopEvent;
	protected Event nextEvent;
	// 事件运行的环境参数
	private Map request;
	private long beforeRunWaitTime = 1000;

	public void onEnd() {
		this.isRun = false;
	}

	public void run() {
		this.setName(threadName+":"+lotteryType.getName() );
		LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 启动前开始休眠" + (beforeRunWaitTime / 1000) + "秒------");
		try {sleep(beforeRunWaitTime);} catch (Exception e) {}
		while (true) {
			// 初始化数据库的彩期及运行环境
			if (isRun) {
				try{onStart();}catch(Exception e){LogUtil.error(e);}
			}			
			try{				
				while (isRun) {
					LotteryTerm currentTerm = (LotteryTerm) request.get(Event.NOW_TERM);
					//如果当前期为空，说明彩期数据异常，则退出运行循环，重新初始化
					if(currentTerm == null)throw new Exception("没有当前彩期");
					long runTime = nextEvent.getScheduledTime(request);
					long waitTime = runTime - System.currentTimeMillis();
					//LogUtil.info("---------:%s 第%s将于%tr%n执行%s",threadName,lotteryType.getName(),currentTerm.getTerm(),new Date(runTime),nextEvent.getEventName());
					LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 第" + currentTerm.getTerm() + "将于" + DateTools.dateToString(new Date(runTime), "MM-dd HH:mm:ss") + "执行" + nextEvent.getEventName());
					if (waitTime > 0) {
						try {
							LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 第" + currentTerm.getTerm() + "将于" + waitTime / 1000 + "秒后("
									+ DateTools.dateToString(new Date(runTime), "MM-dd HH:mm:ss") + ")执行" + nextEvent.getEventName() + this.nextEvent);
							synchronized (this) {
								this.wait(waitTime);
							}
						} catch (Exception e) {
							LogUtil.error(e);
						}
					}
					LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 第" + currentTerm.getTerm() + "执行 " + nextEvent.getEventName() + nextEvent);
					request = nextEvent.execute(request);
					nextEvent = nextEvent.getNextEvent();
				}				
			} catch (Exception e) {
				//发警告
				SystemErrorManager.addError(ErrorType.彩期守护, lotteryType, "", "", "", 0.0,"彩期守护线程出错！" + e.getMessage() + " ,将延迟1分钟重新加载",e);
				LogUtil.error("---------" + threadName + ":" +  lotteryType.getName() + "期数守护线程中断 :" + e.getMessage() + " . 将延迟1分钟重新加载----",e);
			}
			
			try {sleep(60 * 1000); } catch (Exception e) {LogUtil.error(e);}
			
			if ( !isRun ) {
				// 被重新唤醒，是不运行状态，退出线程
				break;
			}
		}
		LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 退出！");
	}
	
	abstract void initWorkFlow();

	@SuppressWarnings("unchecked")
	public  void onStart() {
		LogUtil.info(threadName + ":" + lotteryType.getName() + " 开始初始化...");
		//初始化request
		request = new HashMap();
		LogUtil.info("-------" + threadName + ":" + lotteryType.getName() + hmStopEvent);
		LogUtil.info("-------" + threadName + ":" + lotteryType.getName() + termStopEvent);
		LogUtil.info("-------" + threadName + ":" + lotteryType.getName() + terminalStopEvent);
		LogUtil.info("-------" + threadName + ":" + lotteryType.getName() + openPrizeEvent);		
		// 设置事件处理流程
		initWorkFlow();
		// 查找玩法属性
		LotteryTypeProps props = lotteryTypePropsService.findById(lotteryType.getValue());
		// 根据时间获取当前期
		Calendar calendar = Calendar.getInstance();
		LotteryTerm actualCurrentTerm = lotteryTermService.findCurrentTermByDate(lotteryType, calendar.getTime());
		//上期终端截止事件是否运行标记 （兼容足彩彩期监控处理 zf 2012-07-22）
		boolean isLastTerminalRun = true;
		//上期开奖事件是否运行标记 （兼容足彩彩期监控处理 zf 2012-07-22）
		boolean isLastOpenPrizeRun = true;
		// 进行事件补漏操作
		LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 进行事件补漏操作...");
		//查找彩期已截止，但未派奖彩期
		List<LotteryTerm> overdueAnduncompleteTerm = lotteryTermService.findOverdueByDateAndUnReturnPrizeTerm(lotteryType);
		/** 调试使用
		if(lotteryType.getValue()==LotteryType.PL5.getValue()){
			LogUtil.info("排5");
		}
		if(overdueAnduncompleteTerm==null) overdueAnduncompleteTerm=new ArrayList<LotteryTerm>();
		LotteryTerm lastTerm= lotteryTermService.findCurrentTermByLotteryType(lotteryType);
		if(lastTerm!=null && !overdueAnduncompleteTerm.contains(lastTerm)){
			lastTerm = lotteryTermService.findPreByLotteryTypeAndTerm(lotteryType,lastTerm.getTerm());
			overdueAnduncompleteTerm.add(lastTerm);
		}
		*/
		for (LotteryTerm tempCurrentTerm : overdueAnduncompleteTerm) {			
			isLastTerminalRun = true;
			isLastOpenPrizeRun = true;			
			request = new HashMap();
			request.put(Event.LOTTERY_TYPE, lotteryType);
			request.put(Event.RefLotteryTypeList,refLotteryTypeList);
			request.put(Event.PROPS, props);
			request.put(Event.NOW_TERM, tempCurrentTerm);
			// 提示事件处理，本次为修复操作（开奖事件将不做数据分析和彩期静态化等操作）
			request.put(Event.IS_REPAIR, true);
			LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " " + tempCurrentTerm.getTerm() + " 开始补漏操作*********");
			hmStopEvent.execute(request);
			termStopEvent.execute(request);
			if(terminalStopEvent.getScheduledTime(request) < System.currentTimeMillis()){
				//如果本期的终端截止时间到了
				terminalStopEvent.execute(request);				
				//如果开奖事奖不为空且已过期就补做 （足彩类不配置开奖事件处理器）
				if(openPrizeEvent != null && openPrizeEvent.getScheduledTime(request) <= System.currentTimeMillis()){
					openPrizeEvent.execute(request);
				}else{
					isLastOpenPrizeRun = false;
				}				
			}else{
				//如果本期终端时间未截止
				isLastTerminalRun = false;
			}
			//关闭修复标记
			request.put(Event.IS_REPAIR, false);
		}
		LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 事件补漏操作完成！");
		
		// 准备下一事件执行的参数  ( 算法重构，兼容足彩 zf 2012-7-22 )
		//request = new HashMap(request); 
		
		if( !isLastTerminalRun  ){
			//如果有一期终端截止事件未运行，则下一事件而为终端截止事件
			nextEvent = terminalStopEvent;
		}else{
			if( !isLastOpenPrizeRun ){
				//如果有一期开奖事件未运行，则下一事件而为开奖事件,
				if( openPrizeEvent != null){
					nextEvent = openPrizeEvent;
				}else{
					//开奖事件为空，则为足彩,下一事件为合买截止
					request.put(Event.NOW_TERM, actualCurrentTerm);
					request.put(Event.NEXT_TERM, null);
					nextEvent = hmStopEvent;
				}
			}else{
				request = new HashMap();
				request.put(Event.LOTTERY_TYPE, lotteryType);
				request.put(Event.RefLotteryTypeList,refLotteryTypeList);
				request.put(Event.PROPS, props);
				
				request.put(Event.NOW_TERM, actualCurrentTerm);
				request.put(Event.NEXT_TERM, null);
				nextEvent = hmStopEvent;
			}
		}
		
		/*
		request = new HashMap();
		request.put(Event.LOTTERY_TYPE, lotteryType);
		request.put(Event.PROPS, props);

		// 如果上一期生命周期已经结束，从当前合买截止事件开始运行
		if (actualPreTerm != null && actualPreTerm.getStatus().getValue() == LotteryTermStatus.RETURN_PRIZE.getValue()) {
			request.put(Event.NOW_TERM, actualCurrentTerm);
			nextEvent = hmStopEvent;
		} else {
			// 默认上期终端事件未执行
			request.put(Event.NOW_TERM, actualPreTerm);
			request.put(Event.NEXT_TERM, actualCurrentTerm);
			nextEvent = terminalStopEvent;
		}
		//*/
		

		// 设置当前期标志
		if(actualCurrentTerm != null){
			// 可能因为事件补漏操作或者彩期状态本来已经混乱 ,所以根据时间初始化彩期状态
			// 清除所有当前期
			lotteryTermService.initCurrentFlag(lotteryType);
			LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 当前期为：" + actualCurrentTerm.getTerm());
			actualCurrentTerm.setStatus(LotteryTermStatus.OPEN);
			actualCurrentTerm.setIsCurrentTerm(CommonStatus.YES);
			lotteryTermService.attachDirty(actualCurrentTerm);
			//彩期信息静态化
			try {
				LogUtil.info(lotteryType.getName() + " 第"+ actualCurrentTerm.getTerm() + "期 ，开始生成彩期信息静态化数据");
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put(TermInfoBuilder.LOTTERY_TYPE, lotteryType.getValue() + "");
				termInfoBuilder.make(map);
				LogUtil.info(lotteryType.getName() + " 第"+ actualCurrentTerm.getTerm() + "期 ，已经完成彩期信息静态化数据");
			} catch (Exception e) {
				LogUtil.error(lotteryType.getName() + " 第"+ actualCurrentTerm.getTerm() +"期生成彩期信息静态化异常",e);
			}			
			//生成追号彩期列表数据
			try {
				int chaseCount =LotteryType.CTSZCList.contains(lotteryType)? Constant.DP_CHASE_MAX_TERM:Constant.GP_CHASE_MAX_TERM;
				List list = this.lotteryTermService.findAfterByLotteryTypeAndTerm(lotteryType, actualCurrentTerm.getTerm(), chaseCount);

				HashMap<String, Object> buildMap = new HashMap<String, Object>();
				buildMap.put(ChaseTermBuilder.DATE, list);
				buildMap.put(ChaseTermBuilder.LOTTERY_TYPE, lotteryType.getValue() + "");
				chaseTermBuilder.make(buildMap);
			} catch (Exception e) {
				LogUtil.error(e);
			}
		}
		LogUtil.info("---------" + threadName + ":" + lotteryType.getName() + " 初始化完成！");
		return;
	}

	
	
	
	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	public void setLotteryType(int v) {
		this.lotteryType = LotteryType.getItem(v);
	}

	public void setHmStopEvent(Event v) {
		this.hmStopEvent = v;
	}

	public void setOpenPrizeEvent(Event v) {
		this.openPrizeEvent = v;
	}

	public void setTermStopEvent(Event v) {
		this.termStopEvent = v;
	}

	public void setTerminalStopEvent(Event v) {
		this.terminalStopEvent = v;
	}

	public void setOpenPrizeEvent(AbstractEvent v) {
		this.openPrizeEvent = v;
	}

	public void setTermStopEvent(AbstractEvent v) {
		this.termStopEvent = v;
	}

	public void setTerminalStopEvent(AbstractEvent v) {
		this.terminalStopEvent = v;
	}

	public void setBeforeRunWaitTime(long v) {
		this.beforeRunWaitTime = v;
	}

	public void setLotteryTermService(LotteryTermService v) {
		this.lotteryTermService = v;
	}

	public void setLotteryTypePropsService(LotteryTypePropsService v) {
		this.lotteryTypePropsService = v;
	}

	public void setRefLotteryTypeList(List<Integer> v) {
		this.refLotteryTypeList = v;
	}

	public void setChaseTermBuilder(ChaseTermBuilder v) {
		this.chaseTermBuilder = v;
	}

	public void setTermInfoBuilder(TermInfoBuilder v) {
		this.termInfoBuilder = v;
	}

}
