package com.qiyun.thread.football;

import com.qiyun.builder.AnalysisBuilderFactory;
import com.qiyun.builder.IndexInfoBuilder;
import com.qiyun.businuss.PlanBusiness;
import com.qiyun.businuss.TermBusiness;
import com.qiyun.commonModel.ErrorType;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.PlatformEnum;
import com.qiyun.level.LevelFactory;
import com.qiyun.manager.SystemErrorManager;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTypeProps;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.service.*;
import com.qiyun.thread.base.BaseDaemonTaskTrigger;
import com.qiyun.thread.base.DaemonTaskRunnable;
import com.qiyun.thread.base.MyDaemon;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.TimeTools;
import com.qiyun.utils.basketball.SportteryGrabberUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SportteryFootballAutoSnatchScoreTrigger extends BaseDaemonTaskTrigger {
	private final static String NAME="竞彩足球自动维护任务触发器";

	public String getName() {return NAME;}
	private final static Integer SUB_TASK_ID=0;
	private static final int NO_CHANGE = 0;
	private static final int FIRST_CHANGE = 1;
	private static final int CHANGE_AGAIN = 2;

	@Autowired
	private FootBallService footBallService;
	@Autowired
	private FootballDataService footballDataService;
	@Autowired
	private LotteryTypePropsService lotteryTypePropsService;
	private TermBusiness termBusiness;
	private PlanBusiness planBusiness;
	@Autowired
	private LotteryTermService lotteryTermService;
	@Autowired
	private LotteryPlanService lotteryPlanService;
	@Resource
	private CheckBingoService checkBingoService;
	private AnalysisBuilderFactory analysisBuilderFactory;
	private LevelFactory levelFactory;
	private IndexInfoBuilder indexInfoBuilder;
	
	private List<FootBallMatch> jcldList=new ArrayList<FootBallMatch>(); //比分变化,竞彩靓胆重新开奖
	
	private DaemonTaskRunnable runable;

	@Override
	public void onStart(MyDaemon v){
		super.onStart(v);
		runable= new SportteryFootballAutoSnatchScoreRunnable();
	}

	public void onTrigger() {
		if(!this.subTaskEnable(SUB_TASK_ID))return;
		this.execute(SUB_TASK_ID,runable);		
		delay(getInterval());
	}
	
	private class SportteryFootballAutoSnatchScoreRunnable extends DaemonTaskRunnable{
		@Override
		protected void process() {
			LogUtil.info("----------竞彩足球自动维护线程开始-----------");
			jcldList.clear();
			Date startDate = new Date();
			try {
				// 如果数据有变动尝试开奖
				int status = updateJcMatchData();
				Boolean isOpenAgain = status == FIRST_CHANGE ?
						PlanBusiness.UNINCLUDE_OPENEDPLAN:PlanBusiness.INCLUDE_OPENEDPLAN;
				LogUtil.info("------开奖状态" + status);
				if (status!=NO_CHANGE) {
					/*for (LotteryType type : LotteryType.JCLQList) {
						LotteryTerm2 term = lotteryTermService.findCurrentTermByLotteryType(type.getValue());
						//开奖
						checkBingo(term, LotteryType.getItem(type.getValue()));
					}*/
				}
				if(!jcldList.isEmpty()){
//					sportteryRecommendService.fbCheckBingoAgain(jcldList);
				}
			} catch (Exception e) {
				LogUtil.error(e);
			} finally {
				LogUtil.info("----------竞彩足球自动维护线程结束.耗时" + DateTools.getTwoTime(startDate, new Date()) + "s-----------");
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
		LogUtil.info("----------竞彩自动维护线程抓取赛果开始-----------");
		int status = NO_CHANGE;
		// 向后偏移多少天(包括今天)。例如 4代表处理今天和后3天数据
		final int dayOffsetLimit = 2;
		try {
			Date date = new Date();
			Calendar t = Calendar.getInstance();
			t.add(Calendar.DATE, -dayOffsetLimit);
			Set<Integer> intTimeSet = new HashSet<Integer>();
			Map<String, FootBallMatch> ckMatchMap = new HashMap<String, FootBallMatch>();
			Map<String, FootBallMatch> webMatchMap = new HashMap<String, FootBallMatch>();
			Map<String, FootBallMatch> caikeAwardMap = new HashMap<String, FootBallMatch>();
			
			List<FootBallMatch> ckMatchList= SportteryGrabberUtil.getMatchResultList(PlatformEnum.FOOTBALL.name(),
					t.getTime(), date);
			for (FootBallMatch bean : ckMatchList) {
				ckMatchMap.put(bean.getMapKey(), bean);
			}
			
			// 抓取时间偏移量内的数据(五百万，爱彩票的即时比分，大赢家的即时比分及竞彩官网的赛事开奖赔率)以备数据更新时使用
			for (int offset = 0; offset < dayOffsetLimit; offset++) {
				Date tempDate = DateTools.getDateByOffsetDay(date, -offset);
				Integer intTime = Integer.valueOf(DateTools.dateToString(tempDate, "yyyyMMdd"));
				intTimeSet.add(intTime);				
				// 抓取竞彩官网的比分
				List<FootBallMatch> footBallList = SportteryGrabberUtil.getMatchResultList(
						PlatformEnum.FOOTBALL.name(), tempDate, tempDate);
				for (FootBallMatch bean : footBallList) {
					webMatchMap.put(bean.getMapKey(), bean);
				}
			}
			
			//彩客的单关sp
			List<FootBallMatch> awardMatchLiawardMatchList = SportteryGrabberUtil.getMatchResultAwardList(
					PlatformEnum.FOOTBALL.name());
			for (FootBallMatch bbm : awardMatchLiawardMatchList) {
				caikeAwardMap.put(bbm.getMapKey(), bbm);
			}
			
			// 获取数据库中时间偏移量内的场次对阵
			List<FootBallMatch> dbMatchList = footBallService.getMatchListByIntTime(intTimeSet);
			LotteryTypeProps props = lotteryTypePropsService.findById(LotteryType.JC_ZQ_RQSPF.getValue());
			int aheadMilli = props.getFsAheadTime();

			for (FootBallMatch dbMatch : dbMatchList) {
				if(dbMatch.getStatus()== MatchStatus.DELAY.ordinal())continue;// 延期赛事不保存赛果
				// 抓取比分
				try {
					//彩客和大赢家对比
					if (dbMatch.getScore() == null || "".equals(dbMatch.getScore().trim())) {
						FootBallMatch ckBean = ckMatchMap.get(dbMatch.getMapKey());
						// edit 2016-8-31
						// && dyjBean != null
						if (ckBean != null) {
							LogUtil.info(dbMatch.getMapKey() + " 彩客抓取页面比分" + ckBean.getScore());
							String ckHalfScore = ckBean.getHalfScore();
							String ckWholeScore = ckBean.getScore();
							String[] halfScore = ckHalfScore.split(":");
							String[] wholeScore = ckWholeScore.split(":");
							dbMatch.setHalfHomeScore(Integer.valueOf(halfScore[0]));
							dbMatch.setHalfGuestScore(Integer.valueOf(halfScore[1]));
							dbMatch.setHomeScore(Integer.valueOf(wholeScore[0]));
							dbMatch.setGuestScore(Integer.valueOf(wholeScore[1]));
							if (status < FIRST_CHANGE) status = FIRST_CHANGE;
						}
					} else {
						// 竞彩官网比分公布时间比五百万等网站的即时比分慢,但时间差不超过2小时
						FootBallMatch webMatch = webMatchMap.get(dbMatch.getMapKey());
						if (webMatch != null && webMatch.getHomeScore() != null) {
							int newHomeScore = webMatch.getHomeScore();
							int newGuestScore = webMatch.getGuestScore();
							int newHalfHomeScore = webMatch.getHalfHomeScore();
							int newHalfGuestScore = webMatch.getHalfGuestScore();

							int dbHomeScore = dbMatch.getHomeScore();
							int dbGuestScore = dbMatch.getGuestScore();
							int dbHalfHomeScore = dbMatch.getHalfHomeScore();
							int dbHalfGuestScore = dbMatch.getHalfGuestScore();
							if (newHomeScore != dbHomeScore || newGuestScore != dbGuestScore
									|| newHalfHomeScore != dbHalfHomeScore|| newHalfGuestScore != dbHalfGuestScore) {
								// 不通过确认
								dbMatch.setHalfHomeScore(newHalfHomeScore);
								dbMatch.setHalfGuestScore(newHalfGuestScore);
								dbMatch.setHomeScore(newHomeScore);
								dbMatch.setGuestScore(newGuestScore);
								String oldHalfScore = dbHalfHomeScore + "-" + dbHalfGuestScore;
								String newHalfScore = newHalfHomeScore + "-" + newHalfGuestScore;
								String oldScore = dbHomeScore + "-" + dbGuestScore;
								String newScore = newHomeScore + "-" + newGuestScore;
								SystemErrorManager
										.addError(ErrorType.彩果抓取, LotteryType.JC_ZQ_RQSPF, "", "", "", 0.0, dbMatch.getMapKey() + "比分进行了调整,调整前半场："
												+ oldHalfScore + "调整后半场:" + newHalfScore + "调整前全场：" + oldScore + "调整后全场:" + newScore, null);
								status = CHANGE_AGAIN;
								jcldList.add(dbMatch);
							}
						}
						
						FootBallMatch caikeAwardMatch = caikeAwardMap.get(dbMatch.getMapKey());
						if(caikeAwardMatch != null) {
							dbMatch.setResultRQAwardOfTotoPass(caikeAwardMatch.getResultRQAwardOfTotoPass());
							dbMatch.setResultAwardOfTotoPass(caikeAwardMatch.getResultAwardOfTotoPass());
							dbMatch.setResultAwardOfScorePass(caikeAwardMatch.getResultAwardOfScorePass());
							dbMatch.setResultAwardOfSingleScore(caikeAwardMatch.getResultAwardOfSingleScore());
							dbMatch.setResultAwardOfHfTotoPass(caikeAwardMatch.getResultAwardOfHfTotoPass());
						}
					}
				} catch (Exception e) {
					LogUtil.error(e);
				}
				// 抓取赛事单关赔率
				try {
//					FootBallMatch webMatch =ckMatchMap.get(dbMatch.getMapKey());
//					if (webMatch != null) {
//						boolean isChanged = BeanTools.compareBean(dbMatch, webMatch, resultFieldNames, new SwapFileCallBack());
//						// 赔率有改变，且比分改变的等级比第一次改变的等级低
//						if (isChanged && status < FIRST_CHANGE) {
//							status = FIRST_CHANGE;
//						}
//					}
//					status = FIRST_CHANGE;
					if (dbMatch.getStatus() == MatchStatus.ONSALE.ordinal()
							&& TimeTools.getFbEndSaleTime(dbMatch.getMatchTime(), aheadMilli).getTime() <= date.getTime()) {
						dbMatch.setStatus(MatchStatus.SALEEND.ordinal()); // 截止
					}
				} catch (Exception e) {
					LogUtil.error(e);
				}
			}
			if (status != NO_CHANGE) {
				footBallService.attachDirty(dbMatchList);
				// 修改足球资料库中的关联赛事比分属性 关联键不存在弃用
//				Map<Integer, FootballMatch> matchMap = footballDataService.findFootballMatchIdByIntTimes(intTimeSet);
//				for (FootBallMatch b : dbMatchList) {
//					FootballMatch fm = matchMap.get(b.getId());
//					if (fm != null) {
//						fm.setBfHalf(b.getHalfScore());
//						fm.setBfWhole(b.getScore());
//					}
//				}
//				footballDataService.attachDirty(matchMap.values());
			}
		} catch (Exception e) {
			LogUtil.error(e);
		}
		LogUtil.info("----------竞彩自动维护线程抓取赛果结束-----------");
		return status;
	}

	
//	@SuppressWarnings("unchecked")
//	private List<LotteryPlan> checkBingo(LotteryTerm term, LotteryType type, boolean isOpenAgain) {
//		if (isOpenAgain) LogUtil.info("-----------------竞彩自动维护线程赛果调整，重新开奖： 彩种：" + type.getName() + "开始");
//		else LogUtil.info("-----------------竞彩自动维护线程自动开奖： 彩种：" + type.getName() + "开始");
//		List<LotteryPlan> bingoPlanList = new ArrayList<LotteryPlan>();
//		// 自动开奖
//		Boolean openFlag = CheckBingoAction.flags.get(type);
//		if (openFlag) return bingoPlanList;
//		Object openLock = CheckBingoAction.locks.get(type);
//		synchronized (openLock) {
//			CheckBingoAction.flags.put(type, true);
//			try {
//				if (term == null) return bingoPlanList;
//				HashMap openInfoMap = termBusiness.getOpenInfoMapForCheckBingo(term, type);
//				bingoPlanList = planBusiness.checkBingo(openInfoMap, isOpenAgain);
//				try {
//					// 生成分析数据,包括开奖号列表xml,具体哪些彩种生成由配置决定
//					LogUtil.info(type.getName() + " 第" + term.getTerm() + "期 ，开始生成分析数据...");
//					analysisBuilderFactory.builder(type.getValue(), term.getTerm());
//					LogUtil.info(type.getName() + " 第" + term.getTerm() + "期 ，生成分析完成");
//
//					// 竞彩足球(不分玩法,只需要通知一次)
//					if(type==LotteryType.JC_ZQ_SPF){
//						LogUtil.info("=======通知生成竞彩足球开奖公告======");
//						indexInfoBuilder.make(type);
//						LogUtil.info("========通知生成竞彩足球开奖公告完成=====");
//						LogUtil.info("=======竞彩方案静态化======");
//						indexInfoBuilder.buildPlanHtml(LotteryType.getJJC_LIST());
//						LogUtil.info("=======竞彩方案静态化完成====");
//					}
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
//
//	@SuppressWarnings("unchecked")
//	private void returnPrize(LotteryTerm term, LotteryType type) {
//		LogUtil.info("-----------------竞彩自动维护线程自动派奖： 彩种：" + type.getName() + "开始");
//		// 自动派奖
//		Object returnPrizeLock = ReturnPrizeAction.doReturnLock;
//		synchronized (returnPrizeLock) {
//			try {
//				Calendar cal = Calendar.getInstance();
//				cal.add(Calendar.MINUTE, -20);
//				// 查找20分前(已中奖|部分已中|部分派奖)方案
//				List<LotteryPlan> bingoPlanList = lotteryPlanService.findForReturnPrizePlanByLotteryTypeAndTerm(type, term.getTerm(), null, cal.getTime());
//				if (bingoPlanList.isEmpty()) throw new Exception(type.getName() + ":" + term.getTerm() + "期当前无需派奖方案");
//				LogUtil.info("-----------------彩种：" + type.getName() + " 派奖方案数" + bingoPlanList.size());
//				for (LotteryPlan bingoPlan : bingoPlanList) {
//					if(TradeType.isBalanceTrade(bingoPlan.getTradeType())){
//						planBusiness.returnPrize(bingoPlan.getPlanNo().toString(), bingoPlan.getPosttaxPrize().toString(), Platform.WWW);
//					} else if(TradeType.isScroeTrade(bingoPlan.getTradeType())){
//						planBusiness.returnScore(bingoPlan.getPlanNo().toString(), String.valueOf(bingoPlan.getPosttaxPrize()), Platform.WWW);
//					}
//				}
//			} catch (Exception e) {
//				LogUtil.info(e.getMessage());
//			}
//			try {
//				/*
//				// 统计战绩等级
//				final Integer typeValue = type.getValue();
//				final String termText = term.getTerm();
//				Runnable task = new Runnable() {
//					public void run() {
//						levelFactory.level(typeValue, termText);
//					}
//				};
//				threadExec.execute(task);
//				*/
//				levelFactory.level(type.getValue(), term.getTerm());
//			} catch (Exception e) {
//				LogUtil.error(e);
//			}
//		}
//		LogUtil.info("-----------------竞彩自动维护线程自动派奖： 彩种：" + type.getName() + "结束");
//		return;
//	}
    
//	/**
//	 * <p>积分投注方案派奖，积分投注方案移植到方案表lottery_plan 2016-9-26</p>
//	 * @param term LotteryTerm
//	 * @param type LotteryType
//	 */
//	private void returnPrizeForScore(LotteryTerm term, LotteryType type) {
//		LogUtil.info("-----------------竞彩自动维护线程积分投注方案派奖： 彩种：" + type.getName() + "开始");
//		
//		Object returnPrizeLock = ReturnPrizeAction.doReturnLock;
//		synchronized (returnPrizeLock) {
//			try {
//				Calendar cal = Calendar.getInstance();
//				cal.add(Calendar.MINUTE, -20);
//				
//				// 查找20分钟前已中奖方案
//				List<LotteryPlanSaved> bingoPlanList = lotteryPlanSavedService.findReturnPrizePlan(type, term.getTerm(), null, cal.getTime());
//				
//				if (bingoPlanList.isEmpty()) {
//					throw new Exception(type.getName() + ":" + term.getTerm() + "期当前无派奖方案");
//				}
//				
//				LogUtil.info("-----------------彩种：" + type.getName() + " 派奖方案数" + bingoPlanList.size());
//				
//				for (LotteryPlanSaved bingoPlan : bingoPlanList) {
//					planBusiness.returnPrizeForScore(bingoPlan.getId());
//				}
//			} catch (Exception e) {
//				LogUtil.info(e.getMessage());
//			}
//		}
//		
//		LogUtil.info("-----------------竞彩自动维护线程积分投注方案派奖： 彩种：" + type.getName() + "结束");
//	}
	
	/**
	 * <p>流单开奖</p>
	 * @param term LotteryTerm
	 * @param type LotteryType
	 */
	@SuppressWarnings("unchecked")
	private void checkFailurePlanBingo(LotteryTerm term, LotteryType type) {
		if (term == null) return;
		LogUtil.info("-----------------竞彩自动维护线程自动流单开奖： 彩种：" + type.getName() + "开始");
		try {			
			HashMap<String, String> openResultMap = termBusiness.getOpenInfoMapForCheckBingo(term, type);
			planBusiness.checkFailurePlanBingo(openResultMap);
		} catch (Exception e) {
			LogUtil.error(e);
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
		if (term == null) return;
		LogUtil.info("-----------------竞彩自动维护线程(保存方案&未支付方案)开奖： 彩种：" + type.getName() + "开始");
		try {			
			HashMap<String, String> openResultMap = termBusiness.getOpenInfoMapForCheckBingo(term, type);
			//针对保存方案开奖(免费保存方案)
			planBusiness.checkSavedPlanBingo(openResultMap);
			//针对未支付方案开奖
			planBusiness.checkNotPayPlanBingo(openResultMap);
		} catch (Exception e) {
			LogUtil.error(e);
		}
		LogUtil.info("-----------------竞彩自动维护线程(保存方案&未支付方案)开奖： 彩种：" + type.getName() + "结束");
	}	
	/**
	 * <p>积分投注方案开奖</p>
	 * @param term LotteryTerm
	 * @param type LotteryType
	 */
	@SuppressWarnings("unchecked")
	private void checkScorePlanBingo(LotteryTerm term, LotteryType type) {
		if (term == null) return;
		LogUtil.info("-----------------竞彩自动维护线程(积分投注方案)开奖： 彩种：" + type.getName() + "开始");
		try {			
			HashMap<String, String> openResultMap = termBusiness.getOpenInfoMapForCheckBingo(term, type);
			//针对积分投注方案开奖
			planBusiness.checkScorePayPlanBingo(openResultMap);
		} catch (Exception e) {
			LogUtil.error(e);
		}
		LogUtil.info("-----------------竞彩自动维护线程(积分投注方案)开奖： 彩种：" + type.getName() + "结束");
	}
}
