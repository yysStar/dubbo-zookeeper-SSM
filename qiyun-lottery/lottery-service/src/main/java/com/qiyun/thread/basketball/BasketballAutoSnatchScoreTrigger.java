package com.qiyun.thread.basketball;

import com.qiyun.builder.AnalysisBuilderFactory;
import com.qiyun.businuss.PlanBusiness;
import com.qiyun.businuss.TermBusiness;
import com.qiyun.commonModel.ErrorType;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.PlatformEnum;
import com.qiyun.intface.SwapFileCallBack;
import com.qiyun.level.LevelFactory;
import com.qiyun.manager.SystemErrorManager;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTypeProps;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.service.*;
import com.qiyun.thread.base.BaseDaemonTaskTrigger;
import com.qiyun.thread.base.DaemonTaskRunnable;
import com.qiyun.thread.base.MyDaemon;
import com.qiyun.tools.BeanTools;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.TimeTools;
import com.qiyun.utils.basketball.SnatchBasketBallDataUtil;
import com.qiyun.utils.basketball.SportteryGrabberUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class BasketballAutoSnatchScoreTrigger extends BaseDaemonTaskTrigger {
	private final static String NAME="BasketballAutoSnatchScore";

	public String getName() {return NAME;}
	private final static Integer SUB_TASK_ID=0;
	
	private static final int NO_CHANGE=0;
	private static final int FIRST_CHANGE=1;
	private static final int CHANGE_AGAIN=2;

	@Autowired
	private BasketBallService basketBallService;
	@Autowired
	private LotteryTypePropsService lotteryTypePropsService;
	@Resource
	private LotteryTermService lotteryTermService;
	@Resource
	private CheckBingoService checkBingoService;

	private TermBusiness termBusiness;
	private PlanBusiness planBusiness;
//	@Autowired
//	private LotteryTermService lotteryTermService;
//	@Autowired
//	private LotteryPlanService lotteryPlanService;
//	private AnalysisBuilderFactory analysisBuilderFactory;
//	private LevelFactory levelFactory;

	private List<BasketBallMatch> jcldList=new ArrayList<BasketBallMatch>(); //比分变化,竞彩靓胆重新开奖
	    
	private DaemonTaskRunnable runable;

	@Override
	public void onStart(MyDaemon v){
		super.onStart(v);
		runable= new BasketballAutoSnatchScoreRunnable();
	}

	public void onTrigger() {
		if(!this.subTaskEnable(SUB_TASK_ID))return;
		this.execute(SUB_TASK_ID,runable);		
		delay(getInterval());
	}
	
	
	private class BasketballAutoSnatchScoreRunnable extends DaemonTaskRunnable{
		@Override
		protected void process() {
			LogUtil.info("----------竞彩篮球自动维护线程开始-----------");
			jcldList.clear();
			Date startDate=new Date();
			try {
				// 如果数据有变动尝试开奖
				int status=updateJcMatchData();
				if (status!=NO_CHANGE) {
					/*for (LotteryType type : LotteryType.JCLQList) {
						LotteryTerm2 term = lotteryTermService.findCurrentTermByLotteryType(type.getValue());
						//开奖
						checkBingo(term, LotteryType.getItem(type.getValue()));
					}*/
				}
				if(!jcldList.isEmpty()){
//					sportteryRecommendService.bbCheckBingoAgain(jcldList);
				}
			} catch (Exception e) {
				LogUtil.error(e);
			} finally {
				Date endDate=new Date();
				LogUtil.info("----------竞彩篮球自动维护线程结束.耗时"
						+ DateTools.getTwoTime(startDate, endDate)+"s-----------");
			}
		}		
	}

	private List<LotteryPlan2WithBLOBs> checkBingo(LotteryTerm2 term, LotteryType type) {
		List<LotteryPlan2WithBLOBs> bingoPlanList = new ArrayList<LotteryPlan2WithBLOBs>();
		synchronized (this) {
			HashMap<String, String> openInfoMap = checkBingoService.getOpenInfoMapForCheckBingo(term, type);
			bingoPlanList = checkBingoService.checkBingo(openInfoMap);
		}
		return bingoPlanList;
	}
	
	private int updateJcMatchData() {
		LogUtil.info("----------竞彩篮球自动维护线程抓取赛果开始-----------");
		int status = NO_CHANGE;
		// 向后偏移多少天(包括今天)。例如 2代表处理今天，昨天2天的数据（改为3天）
		final int dayOffsetLimit = 4;
		try {
			Date nowDate = new Date();
			Date endDate=DateTools.getDateByOffsetDay(nowDate,1);
			Set<Integer> intTimeSet = new HashSet<Integer>();
			Map<String, BasketBallMatch> caikeWanBeanMap = new HashMap<String, BasketBallMatch>();
			Map<String, BasketBallMatch> okBeanMap = new HashMap<String, BasketBallMatch>();
			Map<String, BasketBallMatch> caikeAwardMap = new HashMap<String, BasketBallMatch>();
			Map<String, BasketBallMatch> caikePassPankouMap = new HashMap<String, BasketBallMatch>();
			String[] resultFieldNames = new String[] { "resultOfSF", "resultOfRFSF","resultOfSFC", "resultOfDXF",
					"homeScore", "guestScore", "single_handicap", "single_baseBigOrSmall",
					"handicap", "baseBigOrSmall" };
			// 抓取时间偏移量内的数据(彩客竞彩官网的赛事开奖赔率)以备数据更新时使用
			for (int offset = 0; offset < dayOffsetLimit; offset++) {
				Date tempDate = DateTools.getDateByOffsetDay(nowDate, -offset);
				Integer intTime = Integer.valueOf(DateTools.dateToString(tempDate, "yyyyMMdd"));
				intTimeSet.add(intTime);
				
			}
			// 抓取彩客的赛果比分
			List<BasketBallMatch> caikeMatchList = SportteryGrabberUtil.getMatchResultList(PlatformEnum.BASKETBALL.name());
			for (BasketBallMatch bbm : caikeMatchList) {
				caikeWanBeanMap.put(bbm.getMapKey(), bbm);
			}
			
			// 抓取澳客的赛果比分
			List<BasketBallMatch> bballList = SnatchBasketBallDataUtil.getOkoooJclqMatch(nowDate, endDate);
			for (BasketBallMatch bbm : bballList) {
				okBeanMap.put(bbm.getMapKey(), bbm);
			}
			//彩客的单关sp
			List<BasketBallMatch> awardMatchLiawardMatchList = SportteryGrabberUtil.getMatchResultAwardList(PlatformEnum.BASKETBALL.name());
			for (BasketBallMatch bbm : awardMatchLiawardMatchList) {
				caikeAwardMap.put(bbm.getMapKey(), bbm);
			}
			
			//彩客的过关盘口
			List<BasketBallMatch> passPanKouList=SportteryGrabberUtil.getMatchResultPassPankouList(PlatformEnum.BASKETBALL.name());
			for (BasketBallMatch bbm : passPanKouList) {
				caikePassPankouMap.put(bbm.getMapKey(), bbm);
			}
			// 获取数据库中时间偏移量内的场次对阵
			List<BasketBallMatch> dbMatchList = basketBallService.getMatchListByIntTime(intTimeSet);
			LotteryTypeProps props = lotteryTypePropsService.findById(LotteryType.JC_LQ_SF.getValue());
			int aheadMilli = props.getFsAheadTime();
			
			for (BasketBallMatch dbMatch : dbMatchList) {
				if(dbMatch.getStatus()== MatchStatus.DELAY.ordinal()){
					continue;//延期不抓取赛果
				}
				// 抓取比分
				try {
					if (dbMatch.getScore() == null || "".equals(dbMatch.getScore().trim())) {
						String caikeScore = "";
						String okScore = "";
						BasketBallMatch caikeBbm = caikeWanBeanMap.get(dbMatch.getMapKey());
						BasketBallMatch okBbm = okBeanMap.get(dbMatch.getMapKey());
						BasketBallMatch caikeAwardMatch = caikeAwardMap.get(dbMatch.getMapKey());
						BasketBallMatch passPankouMatch = caikePassPankouMap.get(dbMatch.getMapKey());
						
						if(caikeBbm != null && caikeBbm.getHomeScore() != null && caikeBbm.getGuestScore() != null){
							caikeScore = caikeBbm.getHomeScore()+"_"+caikeBbm.getGuestScore();
						}
						
						if(okBbm != null && okBbm.getHomeScore() != null && okBbm.getGuestScore() != null){
							okScore = okBbm.getHomeScore()+"_"+okBbm.getGuestScore();
						}
						
						if (caikeBbm != null && okBbm != null && !"".equals(caikeScore) && !"".equals(okScore) && caikeScore.equals(okScore)) {
							
							dbMatch.setHomeScore(okBbm.getHomeScore());
							dbMatch.setGuestScore(okBbm.getGuestScore());
							if (caikeAwardMatch != null) {
								// 赔率
								dbMatch.setSingle_baseBigOrSmall(caikeAwardMatch.getSingle_baseBigOrSmall());
								dbMatch.setSingle_handicap(caikeAwardMatch.getSingle_handicap());
								dbMatch.setResultOfRFSF(caikeAwardMatch.getResultOfRFSF());
								dbMatch.setResultOfDXF(caikeAwardMatch.getResultOfDXF());
								dbMatch.setResultOfSF(caikeAwardMatch.getResultOfSF());
								dbMatch.setResultOfSFC(caikeAwardMatch.getResultOfSFC());
								if(passPankouMatch!=null){//更新比赛完后的 盘口信息..用于计算最终的比赛结果
									dbMatch.setBaseBigOrSmall(passPankouMatch.getBaseBigOrSmall());
									dbMatch.setHandicap(passPankouMatch.getHandicap());
								}
								
							}
							
							if(status<FIRST_CHANGE){
								status=FIRST_CHANGE;
							}
						}
					} else {//数据库有对应的比分
						BasketBallMatch caikeAwardMatch = caikeAwardMap.get(dbMatch.getMapKey());
						BasketBallMatch caikeBbm=caikeWanBeanMap.get(dbMatch.getMapKey());
						BasketBallMatch passPankouMatch = caikePassPankouMap.get(dbMatch.getMapKey());
						String dbScore = "";
						String caikeScore="";
						
						if(caikeBbm != null && caikeBbm.getHomeScore() != null && caikeBbm.getGuestScore() != null){
							caikeScore = caikeBbm.getHomeScore()+"_"+caikeBbm.getGuestScore();
						}
						
						
						if(dbMatch != null && dbMatch.getHomeScore() != null && dbMatch.getGuestScore() != null){
							dbScore = dbMatch.getHomeScore()+"_"+dbMatch.getGuestScore();
						}
						
						if(caikeBbm != null && !"".equals(caikeScore) && !"".equals(dbScore) && !caikeScore.equals(dbScore)){//数据库比分与新捉取的比分不一致
							
							String oldHomeScore = dbMatch.getHomeScore()+":"+dbMatch.getGuestScore();
							String newHomeScore = caikeBbm.getHomeScore()+":"+caikeBbm.getGuestScore();
							
							dbMatch.setHomeScore(caikeBbm.getHomeScore());
							dbMatch.setGuestScore(caikeBbm.getGuestScore());
							
							if (caikeAwardMatch != null) {
								// 赔率
								dbMatch.setSingle_baseBigOrSmall(caikeAwardMatch.getSingle_baseBigOrSmall());
								dbMatch.setSingle_handicap(caikeAwardMatch.getSingle_handicap());
								dbMatch.setResultOfRFSF(caikeAwardMatch.getResultOfRFSF());
								dbMatch.setResultOfDXF(caikeAwardMatch.getResultOfDXF());
								dbMatch.setResultOfSF(caikeAwardMatch.getResultOfSF());
								dbMatch.setResultOfSFC(caikeAwardMatch.getResultOfSFC());
								
								if(passPankouMatch!=null){//更新比赛完后的 盘口信息..用于计算最终的比赛结果
									dbMatch.setBaseBigOrSmall(passPankouMatch.getBaseBigOrSmall());
									dbMatch.setHandicap(passPankouMatch.getHandicap());
								}
							}
							
							SystemErrorManager.addError(ErrorType.彩果抓取, LotteryType.JC_LQ_SF, "", "", "", 0.0,
									dbMatch.getMapKey()+"比分进行了调整："+oldHomeScore+"调整后:"+newHomeScore,
									null);
							status = CHANGE_AGAIN;
							jcldList.add(dbMatch);
						}
					}
				} catch (Exception e) {
					LogUtil.error(e);
				}
				// 抓取赛事单关赔率
				try {
					BasketBallMatch caikeAwardMatch = caikeAwardMap.get(dbMatch.getMapKey());
					BasketBallMatch passPankouMatch = caikePassPankouMap.get(dbMatch.getMapKey());

					if (caikeAwardMatch != null) {
						if(passPankouMatch!=null){
							caikeAwardMatch.setBaseBigOrSmall(passPankouMatch.getBaseBigOrSmall());
							caikeAwardMatch.setHandicap(passPankouMatch.getHandicap());// 用于下面的对比是否change
						}
						boolean isChanged = BeanTools.compareBean(dbMatch, caikeAwardMatch, resultFieldNames,
								new SwapFileCallBack());
						//赔率有改变，且比分改变的等级比第一次改变的等级低
						if(isChanged&&status<FIRST_CHANGE){
							dbMatch.setSingle_baseBigOrSmall(caikeAwardMatch.getSingle_baseBigOrSmall());
							dbMatch.setSingle_handicap(caikeAwardMatch.getSingle_handicap());
							dbMatch.setResultOfRFSF(caikeAwardMatch.getResultOfRFSF());
							dbMatch.setResultOfDXF(caikeAwardMatch.getResultOfDXF());
							dbMatch.setResultOfSF(caikeAwardMatch.getResultOfSF());
							dbMatch.setResultOfSFC(caikeAwardMatch.getResultOfSFC());
							
							if(passPankouMatch!=null){//更新比赛完后的 盘口信息..用于计算最终的比赛结果
								dbMatch.setBaseBigOrSmall(passPankouMatch.getBaseBigOrSmall());
								dbMatch.setHandicap(passPankouMatch.getHandicap());
							}
							status=FIRST_CHANGE;
						}
						
					}
					if (dbMatch.getStatus() == MatchStatus.ONSALE.ordinal() && TimeTools.getBbEndSaleTime(dbMatch.getMatchTime(), aheadMilli).getTime() <= nowDate.getTime()) {
						dbMatch.setStatus(MatchStatus.SALEEND.ordinal()); // 截止
						basketBallService.attachDirty(dbMatch);
					}
				} catch (Exception e) {
					LogUtil.error(e);
				}
			}
			if (status!=NO_CHANGE) {
				basketBallService.attachDirty(dbMatchList);
			}
		} catch (Exception e) {
			LogUtil.error(e);
		}
		LogUtil.info("----------竞彩篮球自动维护线程抓取赛果结束-----------");
		return status;
	}

//	@SuppressWarnings("unchecked")
//	private List<LotteryPlan> checkBingo(LotteryTerm term, LotteryType type, boolean isOpenAgain) {
//		if(isOpenAgain){
//			LogUtil.info("-----------------竞彩自动维护线程赛果调整，重新开奖： 彩种：" + type.getName() + "开始");
//		}else{
//			LogUtil.info("-----------------竞彩自动维护线程自动开奖： 彩种：" + type.getName() + "开始");
//		}
//
//		List<LotteryPlan> bingoPlanList = new ArrayList<LotteryPlan>();
//		// 自动开奖
//		Boolean openFlag = CheckBingoAction.flags.get(type);
//		if (openFlag) {
//			return bingoPlanList;
//		}
//		Object openLock = CheckBingoAction.locks.get(type);
//		synchronized (openLock) {
//			CheckBingoAction.flags.put(type, true);
//			try {
//				if (term == null) {
//					return bingoPlanList;
//				}
//				HashMap openInfoMap = termBusiness.getOpenInfoMapForCheckBingo(term, type);
//				bingoPlanList = planBusiness.checkBingo(openInfoMap,isOpenAgain);
//				// 生成分析数据,包括开奖号列表xml,具体哪些彩种生成由配置决定
//				try {
//					LogUtil.info(type.getName() + " 第" + term.getTerm() + "期 ，开始生成分析数据...");
//					analysisBuilderFactory.builder(type.getValue(),term.getTerm());
//					LogUtil.info(type.getName() + " 第" + term.getTerm() + "期 ，生成分析完成");
//				} catch (Exception e) {
//					LogUtil.error(e);
//					throw new Exception(type.getName() + " 第" + term.getTerm() + "期 生成开奖期的分析数据失败!");
//				}
//			} catch (Exception e) {
//				LogUtil.error(e);
//			} finally {
//				CheckBingoAction.flags.put(type, false);
//			}
//		}
//		LogUtil.info("-----------------竞彩自动维护线程自动开奖： 彩种：" + type.getName() + "结束");
//		return bingoPlanList;
//	}
//	private void returnPrize(LotteryTerm term, LotteryType type) {
//		LogUtil.info("-----------------竞彩自动维护线程自动派奖： 彩种：" + type.getName() + "开始");
//		// 自动派奖
//		Object returnPrizeLock = ReturnPrizeAction.doReturnLock;
//		synchronized (returnPrizeLock) {
//			try {
//				Calendar cal=Calendar.getInstance();
//				cal.add(Calendar.MINUTE, -20);
//				//查找20分前(已中奖|部分已中|部分派奖)方案
//				List<LotteryPlan> bingoPlanList=lotteryPlanService.findForReturnPrizePlanByLotteryTypeAndTerm(type, term.getTerm(), null, cal.getTime());
//				if(bingoPlanList.isEmpty()){
//					throw new Exception(type.getName()+":"+term.getTerm()+"期当前无需派奖方案");
//				}
//				LogUtil.info("-----------------彩种：" + type.getName() + " 派奖方案数" + bingoPlanList.size());
//
//				for (LotteryPlan bingoPlan : bingoPlanList) {
//					planBusiness.returnPrize(bingoPlan.getPlanNo().toString(), bingoPlan.getPosttaxPrize().toString(), Platform.WWW);
//				}
//
//				try {
//					// 统计战绩等级
//					final Integer typeValue = type.getValue();
//					final String termText = term.getTerm();
//					Runnable task = new Runnable() {
//						public void run() {
//							levelFactory.level(typeValue, termText);
//						}
//					};
//					MyDaemon.execute(task);
//				} catch (Exception e) {
//					LogUtil.error(e);
//				}
//			} catch (Exception e) {
//				LogUtil.error(e);
//			}
//		}
//		LogUtil.info("-----------------竞彩自动维护线程自动派奖： 彩种：" + type.getName() + "结束");
//		return;
//	}
    
	/**
	 * <p>流单开奖</p>
	 * @param term LotteryTerm
	 * @param type LotteryType
	 */
	@SuppressWarnings("unchecked")
	private void checkFailurePlanBingo(LotteryTerm term, LotteryType type) {
		LogUtil.info("-----------------竞彩自动维护线程自动流单开奖： 彩种：" + type.getName() + "开始");
		try {
			if (term == null) {
				return;
			}
			HashMap<String, String> openResultMap = termBusiness.getOpenInfoMapForCheckBingo(term, type);
			planBusiness.checkFailurePlanBingo(openResultMap);
		} catch (Exception e) {

		}
		LogUtil.info("-----------------竞彩自动维护线程自动流单开奖： 彩种：" + type.getName() + "结束");
	}
	
	/**
	 * <p>其它方案开奖</p>
	 * @param term LotteryTerm
	 * @param type LotteryType
	 */
	@SuppressWarnings("unchecked")
	private void checkOtherPlanBingo(LotteryTerm term, LotteryType type) {
		LogUtil.info("-----------------竞彩自动维护线程(保存方案&未支付方案)开奖： 彩种：" + type.getName() + "开始");
		try {
			if (term == null) {
				return;
			}
			HashMap<String, String> openResultMap = termBusiness.getOpenInfoMapForCheckBingo(term, type);
			//针对保存方案开奖
			planBusiness.checkSavedPlanBingo(openResultMap);
			//针对未支付方案开奖
			planBusiness.checkNotPayPlanBingo(openResultMap);
		} catch (Exception e) {
            
		}
		LogUtil.info("-----------------竞彩自动维护线程(保存方案&未支付方案)开奖： 彩种：" + type.getName() + "结束");
	}

}
