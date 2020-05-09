//package com.qiyun.businuss.impl;
//
//import com.qiyun.businuss.PlanBusiness;
//import com.qiyun.commonModel.LotteryType;
//import com.qiyun.commonModel.Platform;
//import com.qiyun.lottery.LotteryPlan;
//import com.qiyun.model.PlanType;
//import com.qiyun.model.SelectType;
//import com.qiyun.service.LotteryPlanService;
//import com.qiyun.service.MemberService;
//import com.qiyun.util.LogUtil;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 方案的相关业务类，不带事务，业务处理调用service层，不允许调用dao
// * 每个方法对同一批参数必须可重复调用，循环处理多个方案时，保证单个方案异常不影响后续方案处理
// *
// * @author zf
// * @since 2011-04-22
// *
// */
//public class PlanBusinessImpl implements PlanBusiness {
//	private LotteryPlanService lotteryPlanService;
//	private LotteryPlanSavedService lotteryPlanSavedService;
//	private MemberRightService memberRightService;
//	private CoalitionFollowingService coalitionFollowingService;
//	private LotteryPersonService lotteryPersonService;
//	private LotteryChaseService lotteryChaseService;
//	private LotteryChaseTermService lotteryChaseTermService;
//	private MemberService memberService;
//	private TradeService tradeService;
//	private SmsNotify smsNotify;
//
//	/*
//	 * 对彩种指定彩期的招募中的合买单截止处理
//	 */
//	public void hmStopProcess(LotteryType lt, String term, SelectType st, Platform platform) {
//		LogUtil.info("*********" + lt.getName() + " " + term + " 开始执行 " + st.getName() + "合买截止处理........");
//		if(lt.getValue()==4){
//			LogUtil.info("p5");
//		}
//		// 找出招幕中的合买单
//		List<LotteryPlan> hmList = this.lotteryPlanService.findHmPlanForFailure(lt, PlanType.HM, st, term);
//		LogUtil.info(lt.getName() + " " + term + "找到招幕中的单，数量为:" + hmList.size());
//		boolean bool = true;
//
//		if(LotteryType.CTSZCList.contains(lt)){//传统数字彩不在这里合买进行补单操作，在终端截止事件中进行合买补单
//			bool = false;
//		}
//		for (int i = 0; i < hmList.size(); i++) {
//			LotteryPlan plan = (LotteryPlan) hmList.get(i);
//
//			try {
//				hmPlanStopProcess(plan, bool, platform);
//
//			} catch (Exception e) {
//				try {
//					String message = lt.getName() + " " + term + "合买结束异常，方案:" + plan.getPlanNo() + " " + e.getMessage();
//					LogUtil.error(message,e);
//				} catch (Exception ee) {
//					LogUtil.error(ee);
//				}
//			}
//
//			LogUtil.info("*********" + lt.getName() + " " + term + " 执行  " + st.getName() + " 合买截止完成。");
//
//		}
//	}
//
//	public void hmPlanStopProcess(LotteryPlan plan, boolean bool, Platform platform) throws Exception {
//
//		// 如果是竞彩和单场，deal_date_time 保存的是最早那场比赛的停售时间，通过这个时间判断是否要进行处理
//		if ( LotteryType.JCZQList.contains(plan.getLotteryType())|| LotteryType.JCLQList.contains(plan.getLotteryType())) {
//			// 如果当前时间未超过网站截止时间,不处理
//			if (new Date().getTime() < plan.getDealDateTime().getTime()) {
//				LogUtil.info(plan.getLotteryType().getName() + " " + plan.getTerm() + " 方案:" + plan.getPlanNo() + " 未超过截止时间，不处理");
//				return;
//			}
//		}
//
//		// 通过是否可出票标志来判断是否退单
//		if (plan.getIsAbleTicketing() == CommonStatus.YES.getValue()) {
//			if(bool){
//				// 如果是可出票的方案，说明是 （认购+保底）>=90% 及其它需要保证出票的方案
//				LogUtil.info(plan.getLotteryType().getName() + " " + plan.getTerm() + "处理合买结束事件，方案:" + plan.getPlanNo() + "，成单处理...");
//
//				// 如果（认购+保底）< 100% ，需要网站进行补单
//				if (plan.getReservePart() + plan.getSoldPart() < plan.getPart()) {
//					// 剩余的份数，网站用会员帐户参与合买，进行补单。
//					lotteryPlanService.planHMAutoFill(plan);
//				}
//
//				// 执行保底成功操作
//				lotteryPlanService.dealPlanBdSuccess(plan, platform);
//			}
//		} else {// 执行流单操作
//			LogUtil.info(plan.getLotteryType().getName() + " " + plan.getTerm() + "处理合买结束事件，方案:" + plan.getPlanNo() + "，流单处理...");
//			try{
//				lotteryPlanService.dealPlanBdFailure(plan, platform);
//			}catch(Exception e){
//				LogUtil.error(e);
//				throw e;
//			}
//
//		}
//	}
//
//
//	public void hmHmLevelProcess(int lotteryType, String term) {
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		List<LotteryPlan> countList = lotteryPlanService.findHmLotteryPlanCountList(lotteryType, term);//统计所有合买中奖与流单的数据(过滤附加表已有数据)
//		if (countList != null && countList.size() > 0) {
//			for (LotteryPlan plan : countList) {
//					lotteryPlanService.countHmLevel(plan);
//			}
//		}
//	}
//
//	/**
//	 * 修复线程使用 其它地方不调用
//	 */
//	public void hmHmLevelProcess(int offset, int length) {
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		List<LotteryPlan> countList = lotteryPlanService.findHmLotteryPlanCountList(offset, length);//修复线程统计所有合买中奖与流单的数据
//
//		if (countList != null && countList.size() > 0) {
//			for (LotteryPlan plan : countList) {
//				LogUtil.info("----- 方案:" + plan.getPlanNo() + " 开始计算战绩");
//				HmCountPlayNo hmCountPlayNo = lotteryPlanService.findByHmCountPlayNoId(Long.valueOf(plan.getPlanNo()));// 查找中奖方案之前是否开过奖
//				if (hmCountPlayNo == null) {// 判断重复派奖防止countList有遗留数据
//					lotteryPlanService.countHmLevel(plan);
//				}
//			}
//		}
//	}
//
//	public List hmFollowingCountProcess(String account, List levelList, int modeNum) {
//		//被定制
//		//1查找用户的红人彩种
//		List followersCountList = new ArrayList();
//		Map<String, Object> paraMap = new HashMap<String, Object>();
//		paraMap.put("account", account);
//		paraMap.put("member_type", MemberType.JOIN.getValue());	//合买红人
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		List<MemberRight> memberRightList = memberRightService.findByCondition(paraMap);
//		if(memberRightList != null){
//			for(MemberRight memberRight : memberRightList){
//				paraMap.clear();
//				paraMap.put("initiator_account", account);
//				paraMap.put("lottery_type", memberRight.getLotteryType().getValue());
//				paraMap.put("status", 0);
//				//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//				int hemaiSumOfFollowers = coalitionFollowingService.getFollowersCount(paraMap);
//				FollowersCount count = new FollowersCount();
//				count.setAccount(account);
//				count.setFollowersCount(hemaiSumOfFollowers);
//				count.setLotteryType(memberRight.getLotteryType());
//
//				/******统计 合买中奖金额 流单中奖金额(只对点取自动跟单模块后才进行统计减低系统开销) ******/
//				if (modeNum == 2) {
//
//					//组装参数
//					Map<String, Object> paramMap = new HashMap<String, Object>();
//					paramMap.put("account", account);
//					paramMap.put("lotteryType", memberRight.getLotteryType().getValue());
//					//查询金额
//					//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//					Number hmSucceedAmount = (Number) lotteryPersonService.findForHmSumList(paramMap,HelperHmNewList.LOTTERY_TYPE_SUCCEED + "and t.account = :account and t.lottery_type=:lotteryType").get(0);
//					//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//					Number failureAmount = (Number) lotteryPersonService.findForHmSumList(paramMap,HelperHmNewList.LOTTERY_TYPE_FAILUER + "and t.account = :account and t.lottery_type=:lotteryType").get(0);
//					//设值
//					count.setHmSucceedAmount(hmSucceedAmount != null ? hmSucceedAmount.intValue() : 0);
//					count.setHmFailureAmount(failureAmount != null ? hmSucceedAmount.intValue() : 0);
//					count.setLotteryTypePicture(HelperHmNewList.getItem(memberRight.getLotteryType().getValue()).getName());
//					if (levelList != null && levelList.size() > 0) {
//						for (int i = 0; i < levelList.size(); i++) {
//							MedalLevelBean medalLevelBean = (MedalLevelBean) levelList.get(i);
//							if (medalLevelBean.getLotteryType().getValue() == memberRight.getLotteryType().getValue()) {
//								//当前接口不要用
//								/*HmNewListBean.setLevel(bean,mb);
//								count.setCup(medalLevelBean.getCup());
//								count.setBrand(medalLevelBean.getBrand());
//								count.setSeat(medalLevelBean.getSeat());*/
//							}
//						}
//					}
//				}
//				followersCountList.add(count);
//			}
//		}
//		return followersCountList;
//	}
//
//	public List hmRedPersonProcess(String sql, int offset, int length) {
//		List resultList = new ArrayList();
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		List redPersonList = lotteryPersonService.findHmRedPerson(null, sql, offset, length);
//
//		for (int i = 0; i < redPersonList.size(); i++) {
//			Object[] o = (Object[]) redPersonList.get(i);
//			HmNewListBean bean = new HmNewListBean();
//
//			bean.setAccount(o[0].toString());
//
//			String str = "select * from(select t.lottery_type,t.term,t.plan_no,t.plan_status from LOTTERY_PLAN t where t.plan_type = 2 " +
//			"and t.account=:account order by CREATE_DATE_TIME desc ) where  rownum <= 1";
//
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			paramMap.put("account", o[0]);
//			//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//			List hmList = lotteryPersonService.findForHmSumList(paramMap,str);
//
//			if(hmList!=null && hmList.size()>0){
//				Object[] oj = (Object[]) hmList.get(0);
//				bean.setLotteryType(LotteryType.getItem(((Number) oj[0]).intValue()));
//				bean.setTerm(!oj[1].toString().equals("")?oj[1].toString()+"期":"");
//				bean.setPlanNo(Integer.valueOf(oj[2].toString()));
//				bean.setPlanStatusString(PlanStatus.getItem(Integer.valueOf(oj[3].toString())).getName());
//			}
//
//
//			//合买统计
//			//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//			Object[] sum = (Object[])lotteryPersonService.findForHmSumList(paramMap,HelperHmNewList.COUNT_SUM1 +":account").get(0);
//
//			bean.setCountSum(Integer.valueOf(sum[0].toString()));//种奖次数
//			bean.setPretaxPrizeInt(sum[1]!=null?((Number) sum[1]).intValue():0);//种奖奖金
//			//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//			bean.setAlready(lotteryPersonService.getForHmList(paramMap,HelperHmNewList.ALREADY_SUM +":account"));//发单次数
//			if((double)bean.getCountSum() == 0.0 && (double)bean.getAlready() == 0.0){
//				bean.setSucceedSum(0);
//			}else{
//				bean.setSucceedSum(MathUtil.roundDouble((double)bean.getCountSum()/(double)bean.getAlready()*100,2));
//			}
//
//			resultList.add(bean);
//		}
//
//		return resultList;
//	}
//
//	/**
//	 * 开奖业务
//	 * @param openResultMap
//	 * @param isOpenAgain 是否重新开奖
//	 * @return
//	 */
//	public List<LotteryPlan> checkBingo(HashMap<String, String> openResultMap,Boolean isOpenAgain) {
//		List<LotteryPlan> bingoList = new ArrayList<LotteryPlan>();
//		//获取参数
//		String term = openResultMap.get("term");
//		String lotteryType = openResultMap.get("lotteryType");
//		Long startTime = System.currentTimeMillis();
//		try {
//			List<LotteryPlan> planList = null;
//			if(isOpenAgain){
//				//查找已经出票&奖金为0&没派奖的定单
//				planList = lotteryPlanService.findByTicketOutAndNotReturnPrized(lotteryType + "", term);
//			}else{
//				//查找已经出票&(未开奖|部分开奖|部分未中|部分派奖) 的方案
//				planList = lotteryPlanService.findByTicketOutAndNotOpenPrized(lotteryType, term);
//			}
//			//LogUtil.info("-----------------彩种：" + lotteryType + " 进行开奖： " + openResultMap + "方案数：" + planList.size());
//			LogUtil.info("-----------------彩种：" + lotteryType + " 方案数：" + planList.size());
//
//			for (int p = 0; p < planList.size(); p++) {
//				LotteryPlan lotteryPlan = planList.get(p);
//				LogUtil.info("-------对"+lotteryPlan.getPlanNo()+"方案进行开奖-----");
//				try {
//					if(Integer.parseInt(lotteryType) == LotteryType.JXSSC.getValue()) {//江西时时彩
//						openResultMap.put("amount", lotteryPlan.getAmount()+"");
//					}
//					if(Integer.parseInt(lotteryType) == LotteryType.GD11X5.getValue() || Integer.parseInt(lotteryType) == LotteryType.SYYDJ.getValue()) {//广东11x5 || 山东11选5
//						openResultMap.put("account", lotteryPlan.getAccount()+"");
//					}
//
//					//开奖
//					if (lotteryPlanService.planCheckBingo(openResultMap, lotteryPlan)) {
//						bingoList.add(lotteryPlan);
//					}
//				}catch (Exception e) {
//					LogUtil.error("定单：" + lotteryPlan.getPlanNo() + " 开奖失败.",e);
//					LotteryType lotType=LotteryType.getItem(Integer.parseInt(lotteryType));
//						SystemErrorManager.addError(ErrorType.开奖, lotteryPlan.getLotteryType(), lotteryPlan.getTerm(), ""+lotteryPlan.getPlanNo(), lotteryPlan.getAccount(), lotteryPlan.getAmount().doubleValue()
//							,"第 " + lotteryPlan.getTerm() + " 期,方案：" + lotteryPlan.getPlanNo() + " 开奖失败！" + e.getMessage()
//							,e);
//					//SystemErrorManager.addError(lotteryPlan.getPlanNo()+"",LotteryType.getItem(Integer.parseInt(lotteryType)),ErrorType.BINGO, "定单：" + lotteryPlan.getPlanNo() + " 开奖失败",e);
//				}
//
//				//处理双色球优惠的奖励 add 2011-08-18  2011-11-1已取消
//				/*if(lotteryType == LotteryType.SSQ.getValue()) {
//					lotteryPlanService.updateCheapBingo(bingoList);
//				}*/
//			}
//		} catch (Exception e) {
//			LogUtil.error(e);
//			LotteryType lotType=LotteryType.getItem(Integer.parseInt(lotteryType));
//				//保存开奖错误
//				SystemErrorManager.addError(ErrorType.开奖,lotType , term, "", "", 0.0
//						,"第 " + term + " 期, 开奖失败！" + e.getMessage()
//						,e);
//
//				//SystemErrorManager.addError(term,LotteryType.getItem(Integer.parseInt(lotteryType)),ErrorType.BINGO,term+"期运行开奖失败",e);
//		}
//
//		Long endTime = System.currentTimeMillis();
//		com.cailele.lottery.tools.LogUtil.info("开奖处理--共花:" + (endTime - startTime) + "ms");
//
//		return bingoList;
//	}
//
//	/**
//	 * 虚拟账号开奖业务
//	 * @param openResultMap
//	 * @param isOpenAgain 是否重新开奖
//	 * @return
//	 */
//	public List<LotteryPlan> virtualCheckBingo(HashMap<String, String> openResultMap,Boolean isOpenAgain) {
//		List<LotteryPlan> bingoList = new ArrayList<LotteryPlan>();
//
//		//获取参数
//		String term = openResultMap.get("term");
//		String lotteryType = openResultMap.get("lotteryType");
//
//		Long startTime = System.currentTimeMillis();
//
//		try {
//			List<LotteryPlan> planList = null;
//			if(isOpenAgain){
//				//查找已经出票&奖金为0&没派奖的定单
//				planList = lotteryPlanService.findByTicketOutAndNotReturnPrized(lotteryType + "", term);
//			}else{
//				//查找已经出票&没开奖的定单
//				planList = lotteryPlanService.findByTicketOutAndNotOpenPrized(lotteryType, term);
//			}
//			//LogUtil.info("-----------------彩种：" + lotteryType + " 进行开奖： " + openResultMap + "方案数：" + planList.size());
//			LogUtil.info("-----------------彩种：" + lotteryType + " 方案数：" + planList.size());
//
//			for (int p = 0; p < planList.size(); p++) {
//				LotteryPlan lotteryPlan = planList.get(p);
//				//代购的虚拟账号进行开奖
//				if (Constant.isVirtualAccount(lotteryPlan.getAccount())&&
//						PlanType.DG.getValue() == lotteryPlan.getPlanType().getValue()) {
//
//					LogUtil.info("-------对" + lotteryPlan.getPlanNo() + "虚拟账号方案进行开奖-----");
//					try {
//						if (Integer.parseInt(lotteryType) == LotteryType.JXSSC.getValue()) {// 江西时时彩
//							openResultMap.put("amount", lotteryPlan.getAmount() + "");
//						}
//						if (Integer.parseInt(lotteryType) == LotteryType.GD11X5.getValue()
//							|| Integer.parseInt(lotteryType) == LotteryType.SYYDJ.getValue()) {// 广东11x5 || 山东11选5
//							openResultMap.put("account", lotteryPlan.getAccount() + "");
//						}
//
//						// 开奖
//						if (lotteryPlanService.planCheckBingo(openResultMap, lotteryPlan)) {
//							bingoList.add(lotteryPlan);
//						}
//					} catch (Exception e) {
//						LogUtil.error("定单：" + lotteryPlan.getPlanNo() + " 开奖失败.",e);
//						LotteryType lotType = LotteryType.getItem(Integer.parseInt(lotteryType));
//						SystemErrorManager.addError(ErrorType.开奖, lotteryPlan.getLotteryType(), lotteryPlan.getTerm(), "" + lotteryPlan.getPlanNo(),
//								lotteryPlan.getAccount(), lotteryPlan.getAmount().doubleValue(), "第 " + lotteryPlan.getTerm() + " 期,方案："
//										+ lotteryPlan.getPlanNo() + " 开奖失败！" + e.getMessage(), e);
//						// SystemErrorManager.addError(lotteryPlan.getPlanNo()+"",LotteryType.getItem(Integer.parseInt(lotteryType)),ErrorType.BINGO,
//						// "定单：" + lotteryPlan.getPlanNo() + " 开奖失败",e);
//					}
//
//				}
//
//				//处理双色球优惠的奖励 add 2011-08-18  2011-11-1已取消
//				/*if(lotteryType == LotteryType.SSQ.getValue()) {
//					lotteryPlanService.updateCheapBingo(bingoList);
//				}*/
//			}
//		} catch (Exception e) {
//			LogUtil.error(e);
//			LotteryType lotType=LotteryType.getItem(Integer.parseInt(lotteryType));
//				//保存开奖错误
//				SystemErrorManager.addError(ErrorType.开奖,lotType , term, "", "", 0.0
//						,"第 " + term + " 期, 开奖失败！" + e.getMessage()
//						,e);
//
//				//SystemErrorManager.addError(term,LotteryType.getItem(Integer.parseInt(lotteryType)),ErrorType.BINGO,term+"期运行开奖失败",e);
//		}
//
//		Long endTime = System.currentTimeMillis();
//		com.cailele.lottery.tools.LogUtil.info("开奖处理--共花:" + (endTime - startTime) + "ms");
//
//		return bingoList;
//	}
//
//	/**
//	 * 默认对未开奖方案进行开奖操作
//	 */
//	public List<LotteryPlan> checkBingo(HashMap<String, String> openResultMap){
//		return checkBingo(openResultMap,PlanBusiness.UNINCLUDE_OPENEDPLAN);
//	}
//
//	/**
//	 * <p>流单开奖</p>
//	 * @param openResultMap HashMap<String, String>
//	 * @return List<LotteryPlan>
//	 */
//	public List<LotteryPlan> checkFailurePlanBingo(HashMap<String, String> openResultMap) {
//		List<LotteryPlan> bingoList = new ArrayList<LotteryPlan>();
//
//		//获取参数
//		String term = openResultMap.get("term");
//		String lotteryType = openResultMap.get("lotteryType");
//
//		Long startTime = System.currentTimeMillis();
//
//		try {
//			//查找流单或未出票作废的方案
//			List<LotteryPlan> planList = lotteryPlanService.findFailurePlan(LotteryType.getItem(Integer.parseInt(lotteryType)), term);
//			//LogUtil.info("-----------------彩种：" + lotteryType + " 进行流单开奖： " + openResultMap + "方案数：" + planList.size());
//			LogUtil.info("-----------------彩种：" + lotteryType + " 流单方案数：" + planList.size());
//
//			for (int p = 0; p < planList.size(); p++) {
//				LotteryPlan lotteryPlan = planList.get(p);
//
//				try {
//					//开奖
//					if (lotteryPlan.getSelectType().getValue() != SelectType.UPLOAD.getValue() || lotteryPlan.getIsUploadContent() == 0) {//流单方案，可能未上传方案内容
//						if (lotteryPlanService.planCheckBingo(openResultMap, lotteryPlan)) {
//							bingoList.add(lotteryPlan);
//						}
//					}
//				}catch (Exception e) {
//					LogUtil.error("流单：" + lotteryPlan.getPlanNo() + " 开奖失败.",e);
//
//					//保存流单开奖错误
//
//					SystemErrorManager.addError(ErrorType.流单开奖, LotteryType.getItem(Integer.parseInt(lotteryType)), lotteryPlan.getTerm(), ""+lotteryPlan.getPlanNo(), lotteryPlan.getAccount(), lotteryPlan.getAmount().doubleValue()
//							,"第 " + lotteryPlan.getTerm() + " 期,方案：" + lotteryPlan.getPlanNo() + " 流单开奖失败！" + e.getMessage()
//							,e);
//					//SystemErrorManager.addError(lotteryPlan.getPlanNo()+"",LotteryType.getItem(Integer.parseInt(lotteryType)),ErrorType.FAILURE_BINGO, "流单：" + lotteryPlan.getPlanNo() + " 开奖失败",e);
//				}
//			}
//		} catch (Exception e) {
//			LogUtil.error(e);
//			//保存流单开奖错误
//			SystemErrorManager.addError(ErrorType.流单开奖, LotteryType.getItem(Integer.parseInt(lotteryType)), term, "", "", 0.0
//					,"第 " + term + " 期, 流单开奖失败！" + e.getMessage()
//					,e);
//			//SystemErrorManager.addError(term,LotteryType.getItem(Integer.parseInt(lotteryType)),ErrorType.FAILURE_BINGO,term+"期运行流单开奖失败",e);
//		}
//
//		Long endTime = System.currentTimeMillis();
//		com.cailele.lottery.tools.LogUtil.info("流单开奖处理--共花:" + (endTime - startTime) + "ms");
//
//		return bingoList;
//	}
//
//	/**
//	 * <p>保存方案开奖</p>
//	 * @param openResultMap HashMap<String, String>
//	 * @return List<LotteryPlanSaved>
//	 */
//	public List<LotteryPlanSaved> checkSavedPlanBingo(HashMap<String, String> openResultMap) {
//		List<LotteryPlanSaved> bingoList = new ArrayList<LotteryPlanSaved>();
//
//		// 获取参数
//		String term = openResultMap.get("term");
//		String lotteryType = openResultMap.get("lotteryType");
//		Long startTime = System.currentTimeMillis();
//
//		try {
//			// 查找待开奖方案
//			List<LotteryPlanSaved> planList = lotteryPlanSavedService.findSavedPlan(LotteryType.getItem(Integer.parseInt(lotteryType)), term);
//			LogUtil.info("-----------------彩种：" + lotteryType + " 保存方案数：" + planList.size());
//
//			for (int i = 0; i < planList.size(); i++) {
//				LotteryPlanSaved lotteryPlan = planList.get(i);
//
//				try {
//					// 开奖
//					if (lotteryPlanSavedService.planCheckBingo(openResultMap, lotteryPlan)) {
//						bingoList.add(lotteryPlan);
//					}
//				} catch (Exception e) {
//					LogUtil.error("保存方案：" + lotteryPlan.getId() + " 开奖失败.",e);
//					SystemErrorManager.addError(ErrorType.保存方案开奖, LotteryType.getItem(Integer.parseInt(lotteryType)), lotteryPlan.getTerm(), "" + lotteryPlan.getId(), "", lotteryPlan.getAmount().doubleValue(),
//							"第 " + lotteryPlan.getTerm() + "期,方案：" + lotteryPlan.getId() + " 保存方案开奖失败！" + e.getMessage(), e);
//				}
//			}
//		} catch (Exception e) {
//			LogUtil.error(e);
//			SystemErrorManager.addError(ErrorType.保存方案开奖, LotteryType.getItem(Integer.parseInt(lotteryType)), term, "", "", 0.0,
//					"第 " + term + "期, 保存方案开奖失败！" + e.getMessage(), e);
//		}
//
//		Long endTime = System.currentTimeMillis();
//		LogUtil.info("保存方案开奖处理--共花:" + (endTime - startTime) + "ms");
//		return bingoList;
//	}
//
//	/**
//	 * <p>未支付方案开奖</p>
//	 * @param openResultMap HashMap<String, String>
//	 * @return List<LotteryPlanSaved>
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public void checkNotPayPlanBingo(HashMap<String, String> openResultMap) {
//		List<LotteryPlan> bingoList = new ArrayList<LotteryPlan>();
//
//		// 获取参数
//		String term = openResultMap.get("term");
//		String lotteryType = openResultMap.get("lotteryType");
//		Long startTime = System.currentTimeMillis();
//
//		try {
//			// 查找待开奖方案
//			LotteryPlan planSearch = new LotteryPlan();
//			planSearch.setLotteryType(LotteryType.getItem(Integer.parseInt(lotteryType)));
//			planSearch.setTerm(term);
//			planSearch.setPlanStatus(PlanStatus.NOT_PAY);
//			planSearch.setWinStatus(WinStatus.NOT_RESULT);
//
//			List<LotteryPlan> planList = lotteryPlanService.findByExample(planSearch);
//
//			LogUtil.info("-----------------彩种：" + lotteryType + " 未支付方案数：" + planList.size());
//
//			for (int i = 0; i < planList.size(); i++) {
//				LotteryPlan lotteryPlan = planList.get(i);
//
//				try {
//					// 开奖
//					if (lotteryPlanService.notPayPlanCheckBingo(openResultMap, lotteryPlan)) {
//						bingoList.add(lotteryPlan);
//					}
//				} catch (Exception e) {
//					LogUtil.error("未支付方案：" + lotteryPlan.getPlanNo() + " 开奖失败.",e);
//					SystemErrorManager.addError(ErrorType.未支付方案开奖, LotteryType.getItem(Integer.parseInt(lotteryType)), lotteryPlan.getTerm(), "" + lotteryPlan.getPlanNo(), "", lotteryPlan.getAmount().doubleValue(),
//							"第 " + lotteryPlan.getTerm() + "期,方案：" + lotteryPlan.getPlanNo() + " 未支付方案开奖失败！" + e.getMessage(), e);
//				}
//			}
//		} catch (Exception e) {
//			LogUtil.error(e);
//			SystemErrorManager.addError(ErrorType.未支付方案开奖, LotteryType.getItem(Integer.parseInt(lotteryType)), term, "", "", 0.0,
//					"第 " + term + "期, 未支付方案开奖失败！" + e.getMessage(), e);
//		}
//
//		Long endTime = System.currentTimeMillis();
//		LogUtil.info("未支付方案开奖处理--共花:" + (endTime - startTime) + "ms");
//	}
//
//	/**
//	 * <p>积分方案开奖</p>
//	 * @param openResultMap HashMap<String, String>
//	 * @return List<LotteryPlanSaved>
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public  List<LotteryPlan> checkScorePayPlanBingo(HashMap<String, String> openResultMap) {
//		List<LotteryPlan> bingoList = new ArrayList<LotteryPlan>();
//
//		// 获取参数
//		String term = openResultMap.get("term");
//		String lotteryType = openResultMap.get("lotteryType");
//		Long startTime = System.currentTimeMillis();
//
//		try {
//			// 查找待开奖方案
//			PlanSearch planSearch = new PlanSearch();
//			planSearch.setLotteryType(Integer.parseInt(lotteryType));
//			planSearch.setTerm(term);
//			planSearch.setPlanStatus(PlanStatus.TICKET_OUT.getValue());
//			planSearch.setWinStatus(WinStatus.NOT_RESULT.getValue());
//			planSearch.setTradeType(TradeType.SCORE_BET);
//
//			List<LotteryPlan> planList = lotteryPlanService.findBySearch(planSearch,-1,-1);
//
//			LogUtil.info("-----------------彩种：" + lotteryType + " 积分方案数：" + planList.size());
//
//			for (int i = 0; i < planList.size(); i++) {
//				LotteryPlan lotteryPlan = planList.get(i);
//
//				try {
//					// 开奖
//					if (lotteryPlanService.scoreCheckPlanCheckBingo(openResultMap, lotteryPlan)) {
//						bingoList.add(lotteryPlan);
//					}
//				} catch (Exception e) {
//					LogUtil.error("未支付方案：" + lotteryPlan.getPlanNo() + " 开奖失败.",e);
//					SystemErrorManager.addError(ErrorType.未支付方案开奖, LotteryType.getItem(Integer.parseInt(lotteryType)), lotteryPlan.getTerm(), "" + lotteryPlan.getPlanNo(), "", lotteryPlan.getAmount().doubleValue(),
//							"第 " + lotteryPlan.getTerm() + "期,方案：" + lotteryPlan.getPlanNo() + " 未支付方案开奖失败！" + e.getMessage(), e);
//				}
//			}
//		} catch (Exception e) {
//			LogUtil.error(e);
//			SystemErrorManager.addError(ErrorType.未支付方案开奖, LotteryType.getItem(Integer.parseInt(lotteryType)), term, "", "", 0.0,
//					"第 " + term + "期, 未支付方案开奖失败！" + e.getMessage(), e);
//		}
//
//		Long endTime = System.currentTimeMillis();
//		LogUtil.info("未支付方案开奖处理--共花:" + (endTime - startTime) + "ms");
//		return bingoList;
//	}
//
//	@SuppressWarnings("unchecked")
//	public void refreshPlanPrizeInfo(Map<String, String>  openResultMap) {
//		//获取参数
//		String term = openResultMap.get("term");
//		String lotteryType = openResultMap.get("lotteryType");
//		PlanSearch search=new PlanSearch();
//		search.setTerm(term);
//		search.setLotteryType(Integer.parseInt(lotteryType));
//		int total=lotteryPlanService.getCountBySearch(search);
//		List<LotteryPlan> pl = lotteryPlanService.findBySearch(search, 0, total);
//		for(int p =0; p< pl.size(); p++) {
//			try{
//				LotteryPlan lotteryPlan = pl.get(p);
//				lotteryPlanService.refreshPlanPrizeInfo((HashMap<String, String>) openResultMap, lotteryPlan);
//			}catch (Exception e) {
//				LogUtil.error(e);
//			}
//		}
//	}
//
//	public void returnPrize(String planNo, String amount, Platform platform) {
//		try {
//			lotteryPlanService.returnPrize(planNo, amount, platform);
//		}catch (Exception e) {
//			LotteryPlan plan=lotteryPlanService.findById(Integer.valueOf(planNo));
//			LogUtil.error("定单：" + planNo + " 派奖失败.",e);
//
//			//保存派奖错误
//			SystemErrorManager.addError(ErrorType.派奖, plan.getLotteryType(), plan.getTerm(), ""+plan.getPlanNo(), plan.getAccount(), Double.valueOf(amount)
//					,"第 " + plan.getTerm() + " 期,方案：" + plan.getPlanNo() + " 奖金："+amount+" 派奖失败！" + e.getMessage()
//					,e);
//		}
//	}
//
//
//	public void returnScore(String planNo, String amount, Platform platform) {
//
//		try {
//			//派积分
//			lotteryPlanService.returnScore(planNo, amount, platform);
//		}catch (Exception e) {
//			LotteryPlan plan=lotteryPlanService.findById(Integer.valueOf(planNo));
//
//			LogUtil.error("定单：" + planNo + " 派奖失败.",e);
//
//			//保存派奖错误
//			SystemErrorManager.addError(ErrorType.派奖, plan.getLotteryType(), plan.getTerm(), ""+plan.getPlanNo(), plan.getAccount(), Double.valueOf(amount)
//					,"第 " + plan.getTerm() + " 期,方案：" + plan.getPlanNo() + " 奖金："+amount+" 派奖失败！" + e.getMessage()
//					,e);
//			//SystemErrorManager.addError(plan.getPlanNo()+"",plan.getLotteryType(),ErrorType.RETURN_PRIZE,"定单：" + planNo + " 派奖失败", e);
//		}
//	}
//
//	/**
//	 * <p>积分投注方案派奖</p>
//	 * @param planNo Integer
//	 */
//    public void returnPrizeForScore(Integer planNo) {
//		try {
//			lotteryPlanSavedService.returnPrizeForScore(planNo);
//		} catch (Exception e) {
//			LotteryPlanSaved plan = lotteryPlanSavedService.findById(planNo);
//
//			LogUtil.error("积分投注方案：" + planNo + " 派奖失败.",e);
//
//			SystemErrorManager.addError(ErrorType.积分投注派奖, plan.getLotteryType(), plan.getTerm(), "" + plan.getId(), "", plan.getPosttaxPrize(),
//					"第 " + plan.getTerm() + "期,积分投注方案：" + plan.getId() + " 奖金：" + plan.getPosttaxPrize().intValue() + " 派奖失败！" + e.getMessage(), e);
//		}
//	}
//
//	public void cancelLotteryZhAll(Integer lotteryType, Platform platform) throws Exception {
//
//		List<LotteryChase> chaseList = this.lotteryChaseService.findByLotteryType(LotteryType.getItem(lotteryType));
//
//		for(LotteryChase lotteryChase : chaseList){
//			try {
//				Member member = memberService.findByAccount(lotteryChase.getAccount());
//				MemberOperTrack memberOperTrack = new MemberOperTrack(MemberOperType.CHASE_CANCEL,platform,lotteryChase.getAccount(),LotteryType.getItem(lotteryType),lotteryChase.getChaseNo().toString());
//				tradeService.abortChase(member, lotteryChase.getChaseNo(), "127.0.0.1", 0L,ChaseTermCancelType.CUSTOM_SERVICE_CANCEL, platform,memberOperTrack);
//				LotteryChaseTerm lotteryChaseTerm = lotteryChaseTermService.findByForChaseStatusCancel(lotteryChase.getChaseNo(),ChaseTermStatus.CANCEL);
//
//				if(TradeType.isBalanceTrade(lotteryChase.getTradeType())){//余额追号计划才发送短信
//					if (smsNotify.mobileVerify(member.getMobile())) {
//						try {
//							smsNotify.send(member.getMobile(), lotteryChaseTerm.getLotteryType().getName()+"暂停销售，您的追号计划从"+lotteryChaseTerm.getTerm()+"期撤销！");
//							LogUtil.info("追号方案为:"+lotteryChase.getChaseNo()+"向用户"+lotteryChase.getAccount()+"发送取消短信成功！");
//						} catch(Exception e) {
//							LogUtil.info("追号方案为:"+lotteryChase.getChaseNo()+"向用户"+lotteryChase.getAccount()+"发送取消短信失败！");
//						}
//					}
//				}
//			}catch(Exception e) {
//				LogUtil.info("追号方案:"+lotteryChase.getChaseNo()+"撤销失败");
//			}
//		}
//	}
//
//	public HmNewListBean countLoseHelp(HmNewListBean bean,String account){
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("account", account);
//
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		Object[] sum = (Object[]) lotteryPersonService.findForHmSumList(paramMap,HelperHmNewList.FLOWCOUNT_SUM1+":account").get(0);
//		bean.setLoseCountSum(Integer.valueOf(sum[0].toString()));//种奖次数
//		bean.setLosePretaxPrizeInt(sum[1]!=null?((Number) sum[1]).intValue():0);//种奖奖金
//
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		int count = lotteryPersonService.getForHmList(paramMap,HelperHmNewList.FLOWALREADY_SUM+":account");
//		bean.setLoseAlready(count);//发单次数
//		if((double)bean.getLoseCountSum() == 0.0 && (double)bean.getLoseAlready() == 0.0){
//			bean.setLoseSucceedSum(0);
//		}else{
//			bean.setLoseSucceedSum(MathUtil.roundDouble((double)bean.getLoseCountSum()/(double)bean.getLoseAlready()*100,2));
//		}
//		return bean;
//	}
//
//	public HmNewListBean countDgHelp(HmNewListBean bean,String account){
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("account", account);
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		Object[] sum = (Object[]) lotteryPersonService.findForHmSumList(paramMap,HelperHmNewList.COUNT_SUM_DG+":account").get(0);
//
//		bean.setCountSum(Integer.valueOf(sum[0].toString()));//中奖次数
//		bean.setPretaxPrizeInt(sum[1]!=null?((Double) sum[1]).intValue():0);//中奖奖金
//
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		int count = lotteryPersonService.getForHmList(paramMap,HelperHmNewList.ALREADY_SUM+":account");
//		bean.setAlready(count);//发单次数
//		if((double)bean.getCountSum() == 0.0 && (double)bean.getAlready() == 0.0){
//			bean.setSucceedSum(0);
//		}else{
//			bean.setSucceedSum(MathUtil.roundDouble((double)bean.getCountSum()/(double)bean.getAlready()*100,2));
//		}
//		return bean;
//	}
//
//	public HmNewListBean countHmHelp(HmNewListBean bean,String account){
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("account", account);
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		Object[] sum = (Object[]) lotteryPersonService.findForHmSumList(paramMap,HelperHmNewList.COUNT_SUM1+":account").get(0);
//
//		bean.setCountSum(Integer.valueOf(sum[0].toString()));//种奖次数
//		bean.setPretaxPrizeInt(sum[1]!=null?((Double) sum[1]).intValue():0);//种奖奖金
//
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		int count = lotteryPersonService.getForHmList(paramMap,HelperHmNewList.ALREADY_SUM+":account");
//		bean.setAlready(count);//发单次数
//		if((double)bean.getCountSum() == 0.0 && (double)bean.getAlready() == 0.0){
//			bean.setSucceedSum(0);
//		}else{
//			bean.setSucceedSum(MathUtil.roundDouble((double)bean.getCountSum()/(double)bean.getAlready()*100,2));
//		}
//		return bean;
//	}
//
//	public void setLotteryPlanService(LotteryPlanService lotteryPlanService) {
//		this.lotteryPlanService = lotteryPlanService;
//	}
//
//	public void setSmsNotify(SmsNotify smsNotify) {
//		this.smsNotify = smsNotify;
//	}
//
//	public void setMemberRightService(MemberRightService memberRightService) {
//		this.memberRightService = memberRightService;
//	}
//
//	public void setCoalitionFollowingService(
//			CoalitionFollowingService coalitionFollowingService) {
//		this.coalitionFollowingService = coalitionFollowingService;
//	}
//
//	public void setLotteryPersonService(LotteryPersonService lotteryPersonService) {
//		this.lotteryPersonService = lotteryPersonService;
//	}
//
//	public void setLotteryChaseService(LotteryChaseService lotteryChaseService) {
//		this.lotteryChaseService = lotteryChaseService;
//	}
//
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
//
//	public void setTradeService(TradeService tradeService) {
//		this.tradeService = tradeService;
//	}
//
//	public void setLotteryChaseTermService(LotteryChaseTermService lotteryChaseTermService) {
//		this.lotteryChaseTermService = lotteryChaseTermService;
//	}
//
//	public List<HmCount> findHmCountListByEntity(HmCount hmCount) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setLotteryPlanSavedService(LotteryPlanSavedService lotteryPlanSavedService) {
//		this.lotteryPlanSavedService = lotteryPlanSavedService;
//	}
//
//}
