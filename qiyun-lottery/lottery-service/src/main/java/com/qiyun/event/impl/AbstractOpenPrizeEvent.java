package com.qiyun.event.impl;

import com.qiyun.builder.AnalysisBuilderFactory;
import com.qiyun.builder.IndexInfoBuilder;
import com.qiyun.builder.TermInfoBuilder;
import com.qiyun.businuss.PlanBusiness;
import com.qiyun.businuss.TermBusiness;
import com.qiyun.commonModel.ErrorType;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.level.LevelFactory;
import com.qiyun.lottery.LotteryPlan;
import com.qiyun.manager.SystemErrorManager;
import com.qiyun.model.LotteryChaseTerm;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTermStatus;
import com.qiyun.openResult.OpenResultService;
import com.qiyun.service.LotteryChaseService;
import com.qiyun.service.LotteryChaseTermService;
import com.qiyun.service.LotteryPlanService;
import com.qiyun.service.LotteryTermService;
import com.qiyun.thread.LeCaiOpenResultThread;
import com.qiyun.thread.base.MyDaemon;
import com.qiyun.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开奖事件接口抽象实现类
 * 
 * @author ysh
 * 
 */
public abstract class AbstractOpenPrizeEvent extends AbstractEvent  {
	static final String EVENT_NAME="开奖事件"; 
	private LotteryTermService lotteryTermService;
	private AnalysisBuilderFactory analysisBuilderFactory;
	private LotteryPlanService lotteryPlanService;
	private LotteryChaseTermService lotteryChaseTermService;
	private LotteryChaseService lotteryChaseService;
	private TermInfoBuilder termInfoBuilder;
	private TermBusiness termBusiness;
	private PlanBusiness planBusiness;
	private IndexInfoBuilder indexInfoBuilder;
	@Autowired
	private OpenResultService openResultService;
	private LevelFactory levelFactory;
	protected LeCaiOpenResultThread leCaiOpenResultThread;
	
	/**
	 * 开奖前的附加操作 ： 如出票商的内部期号获取
	 * @param term
	 */
	abstract public void beforeOpenPrize(LotteryTerm term, LotteryTerm nextTerm, Boolean isRepair);
	
	/**
	 * 开奖后的附加操作，如彩期时间同步，时钟同步
	 * @param term
	 */
	abstract public void afterOpenPrize(LotteryTerm term, LotteryTerm nextTerm, Boolean isRepair);
	
	/**
	 * 彩期一直取不到开奖号，在新一期截止前预留给追号操作生成方案的时间
	 * @return
	 */
	public long estimateChaseExecuteTime(){
		//默认30秒
		return 30*1000; 
	}
	
	/**
	 * 获取开奖信息
	 * @param term
	 * @return 返回null代表获取不到开奖信息
	 */
	private LotteryTerm getOpenResult(LotteryTerm term){
		LotteryTerm result = null;
		try{
			result = openResultService.getOpenResult(term);
		}catch(Exception e){
			LogUtil.error("彩种:"+term.getLotteryType().getName()+" 第"+term.getTerm()+"期抓取开奖号码异常!"+e.getMessage(),e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map execute(Map request) {
		Boolean isRepair = (Boolean)request.get(IS_REPAIR);
		if(isRepair == null){
			isRepair = false;
		}
		LotteryType lotteryType = (LotteryType) request.get(LOTTERY_TYPE);
		// 准备事件需要的数据
		LotteryTerm term = (LotteryTerm) request.get(NOW_TERM);
		LotteryTerm nextTerm = (LotteryTerm) request.get(NEXT_TERM);
		LogUtil.info("*********" + lotteryType.getName() + " " + term.getTerm() + " 开奖事件启动*********");
		if(!isRepair )beforeOpenPrize(term, nextTerm, isRepair); //非修复操作的时候才处理		
		//----------------------------抓取乐彩开奖号码 start-------------------------------------
		if((lotteryType==LotteryType.PL3||lotteryType==LotteryType.PL5
				||lotteryType==LotteryType.SSQ||lotteryType==LotteryType.DLT
				||lotteryType==LotteryType.QXC||lotteryType==LotteryType.FC3D
				||lotteryType==LotteryType.QLC)&&leCaiOpenResultThread != null){
			try{
				leCaiOpenResultThread.setOpenningTerm(term);
				MyDaemon.execute(leCaiOpenResultThread);
			}catch(Exception e){
				LogUtil.error("抓取乐彩"+lotteryType.getName()+" 第"+term.getTerm()+"期开奖号码异常!"+e.getMessage(),e);
			}
		}		
		//准备开奖操作
		boolean isSuccess = false;
		long leftTime = 0;
		do {
			LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期开始查询开奖号码...");
			LotteryTerm queryTerm = getOpenResult(term);
			if (queryTerm != null
					&& queryTerm.getResult() != null
					&& queryTerm.getResult().length() > 0
					&& queryTerm.getResult().indexOf("255") == -1) {//255判断是防止重庆时时彩的开奖号码出现这种情况
				LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期查询开奖号码成功：" + queryTerm.getResult());
				isSuccess = true;
				term = lotteryTermService.findById(term.getId());
				term.setResult(queryTerm.getResult());
				term.setResultDetail(queryTerm.getResultDetail());
				term.setAwardPool(queryTerm.getAwardPool());
				term.setTotalAmount(queryTerm.getTotalAmount());
				term.setStatus(LotteryTermStatus.OPEN_PRIZE); // zf 20130706
				lotteryTermService.attachDirty(term);
				break;
			}else{
				LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期查询开奖号：未取到！！ ");				
				try {//停售期间调整低频抓取频率
					Thread.sleep((LotteryType.CTSZCList.contains(lotteryType)?60:5) * 1000);
				} catch (Exception e) {}
			}
			try {Thread.sleep(1000);} catch (Exception e) {}
			leftTime=nextTerm == null?0:(nextTerm.getEndDateTime().getTime()- System.currentTimeMillis() - estimateChaseExecuteTime());
		}
		// 下期截止前必须完成追号操作,所以留出足够的追号操作时间
		while (leftTime > 0);
		
		if(!isRepair){ //非修复操作的时候才处理
			// 彩期信息静态化	
			try {
				LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，开始生成彩期信息静态化数据");
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put(TermInfoBuilder.LOTTERY_TYPE, lotteryType.getValue() + "");
				termInfoBuilder.make(map);
				LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，已经完成彩期信息静态化数据");
			} catch (Exception e) {
				String message = lotteryType.getName() + "第" + term.getTerm() + "期生成彩期信息静态化异常";
				LogUtil.error(message,e);
			}
		}
		
//		// 开奖
//		if (isSuccess) {
//			LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，开始进行开奖>>>>");
//			List planList = new ArrayList();
//			List<LotteryPlan> scorePlanList = new ArrayList();
//			try {
//				HashMap openResultMap = termBusiness.getOpenInfoMapForCheckBingo(term, term.getLotteryType());
//				planList=planBusiness.checkBingo(openResultMap);
//				// 保存方案开奖
//				planBusiness.checkSavedPlanBingo(openResultMap);
//				//未支付方案开奖
//				planBusiness.checkNotPayPlanBingo(openResultMap);
//				//积分方案开奖
//				scorePlanList = planBusiness.checkScorePayPlanBingo(openResultMap);
//				//取得开奖号后就设置为开奖状态
//				//term = lotteryTermService.findById(term.getId());
//				//term.setStatus(LotteryTermStatus.OPEN_PRIZE);
//				//lotteryTermService.attachDirty(term);
//			} catch (Exception e) {
//				LogUtil.error(e);
//			}
//			for (int i = 0; i < planList.size(); i++) {
//				LotteryPlan lotteryPlan = (LotteryPlan) planList.get(i);
//				planBusiness.returnPrize(lotteryPlan.getPlanNo().toString(), String.valueOf(lotteryPlan.getPosttaxPrize()), Platform.WWW);
//			}
//			for (LotteryPlan plan:scorePlanList) {
//				planBusiness.returnScore(plan.getPlanNo().toString(), String.valueOf(plan.getPosttaxPrize()), Platform.WWW);
//			}
//			LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，结束开奖");
//		} else {
//			LogUtil.info(lotteryType.getName() + "查询" + term.getTerm() + "期开奖号：失败！！ ");
//			if(lotteryType.getValue() != LotteryType.GXKLSF.getValue() &&
//			   lotteryType.getValue() != LotteryType.KL8.getValue() &&
//			   lotteryType.getValue() != LotteryType.SSL.getValue() &&
//			   lotteryType.getValue() != LotteryType.HN_KLSF.getValue() ) {//广西快乐十分抓和快乐8,时时乐,湖南快乐十分，青海快3，取不到开奖号码,导致大量重复提示信息,现屏蔽
//				SystemErrorManager.addError(ErrorType.彩果抓取, lotteryType, term.getTerm(), "", "", 0.0,"查询" + term.getTerm() + "期开奖号：失败!",null);
//			}
//		}
		
		if(!isRepair ){ //非修复操作的时候才处理		
			// 生成分析数据(需放在追号处理之前，有些彩种需要根据分析数据来判断是否追号),具体哪些彩种生成由配置决定
//			try {
//				LogUtil.info(term.getLotteryType().getName() + " 第" + term.getTerm() + "期 ，开始生成分析数据...");
//				analysisBuilderFactory.builder(term.getLotteryType().getValue(),term.getTerm());
//				LogUtil.info(term.getLotteryType().getName() + " 第" + term.getTerm() + "期 ，生成分析完成");
//			} catch (Exception e) {
//				LogUtil.info(term.getLotteryType().getName() + " 第" + term.getTerm() + "期 生成开奖期的分析数据失败!");
//			}
		}
		
		//*追号处理
		//条件追号方案处理
//		if(nextTerm != null){
//			lotteryChaseService.chasePackageMakeChaseTerm(nextTerm.getLotteryType(), nextTerm.getTerm());
//			//普通追号方案处理
//			List chaseTermList = lotteryChaseTermService.findByForChase(lotteryType, nextTerm.getTerm());
//			LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期开奖完毕，有"+chaseTermList.size()+"条记录待执行追号==>");
//			for (int i = 0; i < chaseTermList.size(); i++) {
//				LotteryChaseTerm chaseTerm = (LotteryChaseTerm) chaseTermList.get(i);
//				LogUtil.info(lotteryType.getName() + "执行追号==>追号No:" + chaseTerm.getChaseNo());
//				try {
//					lotteryChaseService.doChase(chaseTerm, nextTerm);
//				} catch (Exception e) {
//					SystemErrorManager.addError(ErrorType.追号, lotteryType, nextTerm.getTerm(), ""+chaseTerm.getChaseNo(), "", chaseTerm.getAmount().doubleValue()
//							,"追号处理失败！追号方案：" + chaseTerm.getChaseNo() + " 第 " + nextTerm.getTerm() + " 期"
//							,null);
//				}
//			}
//		}
//		LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，结束追号处理");
		//追号处理完成 */		
		//取到开奖号才更新为已派奖
		if (isSuccess) {
			//更新彩期信息为已派奖
			term = lotteryTermService.findById(term.getId());
			term.setStatus(LotteryTermStatus.RETURN_PRIZE);
			lotteryTermService.attachDirty(term);
		}		
		
		if(!isRepair ){ //非修复操作的时候才处理			
			/*******生成今日中奖排行榜********/
//			try {
//				LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，开始生成中奖榜");
//				//涉及数据即时性,不能切换从库
//
//				Runnable todayPrizeTask = buildTodayPrizeInfo(lotteryType,term);
//				MyDaemon.execute(todayPrizeTask);
//				if (LotteryType.GPList.contains(lotteryType)) {//高频彩种才需要生成
//					lotteryPlanService.buildTodayPrizeInfo(lotteryType, "static/lottery/");
//				}
//
//				LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，结束生成中奖榜");
//			} catch (Exception e) {
//				LogUtil.error(e);
//			}
//			/*******生成首页所有最新开奖统计静态页面********/
//			LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，开始生成首页开奖统计页面");
//
//			Runnable indexInfoTask = buildIndexInfo(lotteryType);
//			MyDaemon.execute(indexInfoTask);
//			//indexInfoBuilder.make(lotteryType);
//
//			LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，结束生成首页开奖统计页面");
		}
		/*******等级统计工厂  修复与非修复都处理 因冲正功能已增加等级修复功能********/
//		LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，开始用户等级统计");
//		Runnable levelTask = createLevel(lotteryType.getValue(), term.getTerm());
//		MyDaemon.execute(levelTask);
//		if (!LotteryType.GPList.contains(lotteryType)) {//非高频彩种才需要统计
//			levelFactory.level(lotteryType.getValue(), term.getTerm());
//		}
//		LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，结束用户等级统计");
		// 开奖完成后要做的操作
		LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，开始开奖后处理");
		afterOpenPrize(term, nextTerm, isRepair);
		LogUtil.info(lotteryType.getName() + " 第" + term.getTerm() + "期 ，结束开奖后处理");		
		//重新设置事件运行环境
		request.put(NOW_TERM, nextTerm);
		return request;
	}
	
	private Runnable buildTodayPrizeInfo(final LotteryType lotteryType,final LotteryTerm term) {
		return new Runnable() {
			public void run() {
				if (LotteryType.GPList.contains(lotteryType)) {//高频彩种才需要生成
					lotteryPlanService.buildTodayPrizeInfo(lotteryType, "static/lottery/");
				}
			}
		};
	}
	
	private Runnable buildIndexInfo(final LotteryType lotteryType) {
		return new Runnable() {
			public void run() {
			//	if(indexInfoBuilder.getXmlList() != null && indexInfoBuilder.getXmlList().contains(lotteryType.getValue())) {//根据配置生成
					indexInfoBuilder.make(lotteryType);
			//	}
			}
		};
	}
	
	private Runnable createLevel(final int lotteryType,final String term) {
		return new Runnable() {
			public void run() {
				if (!LotteryType.GPList.contains(LotteryType.getItem(lotteryType))) {//非高频彩种才需要统计
					levelFactory.level(lotteryType, term);
				}
			}
		};
	}
	
	public String getEventName() {
		return EVENT_NAME;
	}

	public long getScheduledTime(Map request) {
		LotteryTerm term = (LotteryTerm) request.get(NOW_TERM);
		return term.getOpenDateTime().getTime();
	}
	
	public void setLotteryTermService(LotteryTermService lotteryTermService) {
		this.lotteryTermService = lotteryTermService;
	}

	

	public void setAnalysisBuilderFactory(AnalysisBuilderFactory analysisBuilderFactory) {
		this.analysisBuilderFactory = analysisBuilderFactory;
	}

	public void setLotteryPlanService(LotteryPlanService lotteryPlanService) {
		this.lotteryPlanService = lotteryPlanService;
	}

	public void setLotteryChaseTermService(LotteryChaseTermService lotteryChaseTermService) {
		this.lotteryChaseTermService = lotteryChaseTermService;
	}

	public void setLotteryChaseService(LotteryChaseService lotteryChaseService) {
		this.lotteryChaseService = lotteryChaseService;
	}

	public void setTermInfoBuilder(TermInfoBuilder termInfoBuilder) {
		this.termInfoBuilder = termInfoBuilder;
	}

	public void setPlanBusiness(PlanBusiness planBusiness) {
		this.planBusiness = planBusiness;
	}

	public void setTermBusiness(TermBusiness termBusiness) {
		this.termBusiness = termBusiness;
	}

	public void setIndexInfoBuilder(IndexInfoBuilder indexInfoBuilder) {
		this.indexInfoBuilder = indexInfoBuilder;
	}
	
	public void setOpenResultService(OpenResultService openResultService) {
		this.openResultService = openResultService;
	}

	
	public void setLevelFactory(LevelFactory levelFactory) {
		this.levelFactory = levelFactory;
	}

	public void setLeCaiOpenResultThread(LeCaiOpenResultThread leCaiOpenResultThread) {
		this.leCaiOpenResultThread = leCaiOpenResultThread;
	}
}
