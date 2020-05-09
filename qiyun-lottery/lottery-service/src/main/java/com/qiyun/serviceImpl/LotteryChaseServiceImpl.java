package com.qiyun.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.TradeType;
import com.qiyun.grabber.LotteryChase;
import com.qiyun.lottery.ChaseSearch;
import com.qiyun.mapper2.LotteryChase2Mapper;
import com.qiyun.model.LotteryChaseTerm;
import com.qiyun.model.LotteryTerm;
import com.qiyun.service.LotteryChaseService;
import com.qiyun.status.ChaseStatus;
import net.sf.json.JSONObject;

import javax.annotation.Resource;

public class LotteryChaseServiceImpl implements LotteryChaseService {
	@Resource
	private LotteryChase2Mapper lotteryChase2Mapper;

	public List findBySearch(ChaseSearch search, int offset, int length) {
		return null;
	}

	public List<LotteryChase> findByLotteryType(LotteryType lotteryType) {
		return null;
	}

	public int getCountBySearch(ChaseSearch search) {
		return 0;
	}

	public List getSumBySearch(ChaseSearch search) {
		return null;
	}

	public List findForMember(String account, Date startDate, Date endDate, LotteryType lotteryType, ChaseStatus chaseStatus, TradeType tradeType, int offset, int length) {
		return null;
	}

	public int getCountForMember(String account, Date startDate, Date endDate, LotteryType lotteryType, ChaseStatus chaseStatus, TradeType tradeType) {
		return 0;
	}

	public void chasePackageMakeChaseTerm(LotteryType lotteryType, String nextTerm) {
		List<LotteryChase> list = lotteryChase2Mapper.findChasePackageList(lotteryType);
		if(list.size()>0){

		}
	}

	public void doChase(LotteryChaseTerm chaseTerm, LotteryTerm nowTerm) throws Exception {

	}

	public boolean checekChaseStartCondition(LotteryTerm nowTerm, String startCondition) {
		return false;
	}

	public void save(LotteryChase transientInstance) {

	}

	public void delete(LotteryChase persistentInstance) {

	}

	public LotteryChase findById(Integer id) {
		return null;
	}

	public List findByExample(LotteryChase instance) {
		return null;
	}

	public LotteryChase merge(LotteryChase detachedInstance) {
		return null;
	}

	public void attachDirty(LotteryChase instance) {

	}

	public void attachClean(LotteryChase instance) {

	}
//
//	public List findBySearch(final ChaseSearch search, final int offset, final int length) {
//		if (search.getPlanNo() != 0) {
//			LotteryChaseTerm term = (LotteryChaseTerm) this.lotteryChaseTermDAO.findByPlanNo(search.getPlanNo()).get(0);
//			search.setChaseNo(term.getChaseNo());
//		}
//		return this.lotteryChaseDAO.findBySearch(search, offset, length);
//	}
//
//	public List findByLotteryType(final LotteryType lotteryType) {
//		return this.lotteryChaseDAO.findByLotteryType(lotteryType);
//	}
//
//	public int getCountBySearch(final ChaseSearch search) {
//		if (search.getPlanNo() != 0) {
//			LotteryChaseTerm term = (LotteryChaseTerm) this.lotteryChaseTermDAO.findByPlanNo(search.getPlanNo()).get(0);
//			search.setChaseNo(term.getChaseNo());
//		}
//		return this.lotteryChaseDAO.getCountBySearch(search);
//	}
//
//	public List getSumBySearch(final ChaseSearch search) {
//		if (search.getPlanNo() != 0) {
//			LotteryChaseTerm term = (LotteryChaseTerm) this.lotteryChaseTermDAO.findByPlanNo(search.getPlanNo()).get(0);
//			search.setChaseNo(term.getChaseNo());
//		}
//		return this.lotteryChaseDAO.getSumBySearch(search);
//	}
//
//	public List findForMember(final String account, final Date startDate, final Date endDate, final LotteryType lotteryType,
//			final ChaseStatus chaseStatus, final TradeType tradeType, final int offset, final int length) {
//		return this.lotteryChaseDAO.findForMember(account, startDate, endDate, lotteryType, chaseStatus, tradeType, offset, length);
//	}
//
//	public int getCountForMember(final String account, final Date startDate, final Date endDate, final LotteryType lotteryType,
//			final ChaseStatus chaseStatus,final TradeType tradeType) {
//		return this.lotteryChaseDAO.getCountForMember(account, startDate, endDate, lotteryType, chaseStatus,tradeType);
//	}
//
//	public void chasePackageMakeChaseTerm(LotteryType lotteryType, String nextTerm) {
//		List list = lotteryChaseDAO.findChasePackageList(lotteryType);
//		for (int i = 0; i < list.size(); i++) {
//			LotteryChase lotteryChase = (LotteryChase) list.get(i);
//
//			// 检查是否产生了当期追号从表记录
//			LotteryChaseTerm chaseTerm = lotteryChaseTermDAO.findByChaseNoAndTerm(lotteryChase.getChaseNo(), nextTerm);
//			if (chaseTerm != null) {
//				continue;
//			}
//
//			LotteryChaseTerm lotteryChaseTerm = new LotteryChaseTerm();
//			lotteryChaseTerm.setTerm(nextTerm);
//			lotteryChaseTerm.setChaseNo(lotteryChase.getChaseNo());
//			lotteryChaseTerm.setLotteryType(lotteryType);
//			lotteryChaseTerm.setStatus(ChaseTermStatus.NOT_BEGIN);
//			lotteryChaseTerm.setMultiple(lotteryChase.getMultiple());
//			lotteryChaseTerm.setAmount(lotteryChase.getAmount() / lotteryChase.getTotalTerm());
//
//			lotteryChaseTermDAO.save(lotteryChaseTerm);
//		}
//	}
//
//	/**
//	 * 追号购买处理
//	 *
//	 * @param chaseTerm
//	 * @param nowTerm
//	 * @throws Exception
//	 */
//	public void doChase(LotteryChaseTerm chaseTerm, LotteryTerm nowTerm) throws Exception {
//		LotteryChase chase = this.lotteryChaseDAO.findByIdForUpdate(chaseTerm.getChaseNo());
//
//		if (nowTerm.termIsClose(chase.getTradeType())) {
//			throw new ServiceException("11", nowTerm.getTerm() + "暂停销售");
//		}
//
//		// 检查是否存在追号条件
//		String startCondition = chase.getStartCondition();
//		if (!StringTools.isNullOrBlank(startCondition)) {
//			if (checekChaseStartCondition(nowTerm, startCondition)) {
//				com.cailele.lottery.tools.LogUtil.info("检查追号开始条件结果符合，执行追号处理");
//			} else {
//				com.cailele.lottery.tools.LogUtil.info("检查追号开始条件暂不符合,不执行追号处理");
//				return;
//			}
//		}
//
//		Member member = (Member) this.memberDAO.findByAccount(chase.getAccount()).get(0);
//		com.cailele.lottery.tools.LogUtil.info("开始执行追号==>追号No:" + chaseTerm.getChaseNo() + " Account:" + member.getAccount());
//		chaseTerm = lotteryChaseTermDAO.findByIdForUpdate(chaseTerm.getId());
//		if (chaseTerm.getStatus().getValue() != ChaseTermStatus.NOT_BEGIN.getValue())
//			return;
//		// 判断追号项是否已过期
//		String termNo = chaseTerm.getTerm();
//		LotteryType lotteryType = chaseTerm.getLotteryType();
//		LotteryTerm term = lotteryTermDAO.findByLotteryTypeAndTerm(lotteryType,termNo);
//		long curTime = new Date().getTime();
//		long tsTime = term.getStartDateTime().getTime();
//		long teTime = term.getEndDateTime().getTime();
//
//		// 时间未到
//		if(curTime<tsTime)
//			return;
//		// 已过期，自动撤销
//		if(teTime<curTime ) {
//			getTradeService().abortChaseByChaseTerm(member, chaseTerm.getChaseNo(), chaseTerm.getId());
//		}
//		// 时间条件符合，进行追号
//		else if(teTime>=curTime && curTime>=tsTime){
//			LotteryPlan plan = new LotteryPlan();
//			plan.setAccount(chase.getAccount());
//			plan.setAmount(chaseTerm.getAmount());
//			plan.setClicks(new Integer(0));
//			if (chase.getChaseType().getValue() == ChaseType.MACHINE_CHOOSE.getValue()) {// 如是机选
//																							// 则需获取机选的内容
//				int betCount = chaseTerm.getAmount() / chaseTerm.getMultiple() / TradeType.getTradeAmount(chase.getTradeType());// 计算注数
//				String randContent = JxHepler.getMachineChooseContent(chaseTerm.getLotteryType().getValue(), betCount);
//				com.cailele.lottery.tools.LogUtil.info("此方案为机选追号,需要获取机选内容:" + randContent);
//				plan.setContent(randContent);
//			} else {
//				if(chaseTerm.getLotteryType() == LotteryType.JC_LQ_DXF){//对竞彩篮球追号内容拼装
//					int count = lotteryChaseTermDAO.getRemainCount(chaseTerm.getChaseNo(),ChaseTermStatus.SUCCESS);//得到已经成功追号的条数
//					List<BasketBallMatch> basketBallMatch = basketBallService.findByOnSaleMatchListByPlayTypeAndPassModeDXFQ2(
//							MatchStatus.ONSALE.ordinal(),2);//得到竞彩篮球前2对阵
//					String[] contens = chase.getChaseContent().split("~");
//					String conten = contens[count];
//
//					SportteryFileUploadLQContentModel model = CommonUtils.Object4Json(conten, SportteryFileUploadLQContentModel.class,
//							BasketBallMatchItem.class);
//
//					List<BasketBallMatchItem> planItemList = model.getMatchItems();
//
//			    	for (int i=0; i < planItemList.size(); i++) {
//			    		BasketBallMatchItem bbmi = planItemList.get(i);
//
//			    		if(basketBallMatch.get(i) != null){
//			    			BasketBallMatch bbm = basketBallMatch.get(i);
//
//			    			bbmi.setIntTime(bbm.getIntTime());
//			    			bbmi.setLineId(bbm.getLineId());
//			    		}
//					}
//
//			    	SportteryBetContentModel bc = new BasketBallBetContent();
//					bc.setMatchItems(planItemList);
//
//					bc.setPassMode(model.getPassMode());
//					List<SportteryPassType> tempPt = new ArrayList<SportteryPassType>();
//					SportteryPassType temp = SportteryPassType.valueOf("P2_1");
//					tempPt.add(temp);
//					bc.setPassTypes(model.getPassTypes());
//					bc.setMultiple(Integer.valueOf(model.getMultiple()));
//					JSONObject jsonObject = JSONObject.fromObject(bc);
//
//					com.cailele.lottery.tools.LogUtil.info("竞彩篮球前2拼装后内容:" + jsonObject.toString());
//
//					plan.setContent(jsonObject.toString());
//
//				}else{
//					String[] chasePeace = chase.getChaseContent().split("!");
//					if (chasePeace.length == 1) {
//						plan.setContent(chase.getChaseContent());
//					} else {
//						// plan.setContent(chasePeace[0]+"!"+chaseTerm.getMultiple());
//						/*
//						 * if(chaseTerm.getLotteryType().getValue() ==
//						 * LotteryType.DLT.getValue()){
//						 * plan.setContent(chasePeace[0]+"!"+chaseTerm.getMultiple());
//						 * }else{
//						 * plan.setContent(chasePeace[0]+"!"+chaseTerm.getMultiple()); }
//						 */
//						// 重新拼content
//						plan.setContent(chasePeace[0] + "!" + chaseTerm.getMultiple());
//					}
//				}
//			}
//
//			plan.setCreateDateTime(new Date());
//			plan.setDealDateTime(nowTerm.getTerminalEndDateTime());
//			plan.setExperience(new Integer(0));
//			plan.setFounderPart(new Integer(1));
//			plan.setIsSuperMan(new Integer(1));
//
//			// 上传文件处理
//			plan.setIsUploadContent(new Integer(0));
//			plan.setSelectType(chase.getSelectType());
//
//			plan.setPlayType(chase.getPlayType());
//			plan.setLotteryType(chaseTerm.getLotteryType());
//			plan.setMemberId(member.getId());// memberId
//			plan.setMultiple(chaseTerm.getMultiple());
//			plan.setPart(new Integer(1));
//			plan.setPerAmount(chaseTerm.getAmount());
//			plan.setPlanDesc("");
//			plan.setPlanStatus(PlanStatus.PAY_FINISH);
//			plan.setPlanType(PlanType.DG);
//
//			plan.setPosttaxPrize(new Double(0));
//			plan.setPretaxPrize(new Double(0));
//			plan.setPublicStatus(PublicStatus.NOT_PUBLIC);
//			plan.setReservePart(new Integer(0));
//			plan.setSoldPart(new Integer(1));
//			plan.setTerm(nowTerm.getTerm());
//			plan.setWinStatus(WinStatus.NOT_RESULT);
//			plan.setAddAttribute(chase.getAddAttribute());
//			plan.setVerifyMd5(DbDataVerify.getLotteryPlanVerify(plan));
//			plan.setIsAbleTicketing(CommonStatus.YES.getValue());
//			plan.setPlanTicketStatus(PlanTicketStatus.NO_PROCESS);
//			plan.setModel(chaseTerm.getChaseNo());
//			plan.setPlatform(chase.getPlatform());
//			plan.setTradeType(chase.getTradeType());
//			//判断购彩渠道（pc、中奖王、手机）
//			GenType gentypeIn=null;
//			if(chase.getGenType()!=null){
//				gentypeIn=GenType.getItem(chase.getGenType().getValue());
//			}else{
//				gentypeIn=GenType.ZH;
//			}
//			plan.setGenType(gentypeIn);
//			lotteryPlanDAO.save(plan);
//
//			LotteryPlanOrder planOrder = new LotteryPlanOrder();
//			planOrder.setAccount(member.getAccount());
//			planOrder.setAmount(plan.getAmount());
//			planOrder.setBuyType(BuyType.SELF_BUY);
//			planOrder.setCreateDateTime(new Date());
//			planOrder.setExperience(new Integer(0));
//			planOrder.setMemberId(member.getId());
//			planOrder.setPart(new Integer(1));
//			planOrder.setPlanNo(plan.getPlanNo());
//			planOrder.setPosttaxPrize(new Double(0));
//			if(TradeType.isBalanceTrade(chase.getTradeType())){
//				planOrder.setScore(new Integer(planOrder.getAmount().intValue() * 5));
//			}else{
//				planOrder.setScore(0);
//			}
//			planOrder.setStatus(PlanOrderStatus.PAYED);
//			planOrder.setPrizeSettleStatus(new Integer(1));
//			planOrder.setWalletType(chase.getWalletType());
//			planOrder.setVerifyMd5(DbDataVerify.getLotteryPlanOrderVerify(planOrder));
//			planOrder.setPlatform(chase.getPlatform());
//			lotteryPlanOrderDAO.save(planOrder);
//
//			// 如有优惠
//			Double totalAmount = new Double(chase.getAmount());
//			Double packageAmount = chase.getPackageAmount();
//			Integer totalTerm = chase.getTotalTerm();
//			if(TradeType.isBalanceTrade(chase.getTradeType())){
//				if (totalAmount.doubleValue() != packageAmount.doubleValue() && packageAmount.doubleValue() > 0d) {
//					Double eachCheapAmount = NumberTools.div(NumberTools.sub(totalAmount, packageAmount), (double)totalTerm);// 每期优惠的金额
//					Double unfreezeAmount = NumberTools.sub(planOrder.getAmount(),eachCheapAmount); //解冻金额 必须保存2位小数
//					if(totalTerm == chase.getSoldTerm() + 1){//最后一期
//						Double minusAmount = NumberTools.sub(NumberTools.mul(unfreezeAmount,totalTerm), packageAmount);//获取本单全部追号解冻金额差值
//						unfreezeAmount = NumberTools.sub(unfreezeAmount,minusAmount);//最后一期解冻金额
//						eachCheapAmount = NumberTools.sub(planOrder.getAmount(),unfreezeAmount);//最后一期优惠的金额
//					}
//					memberWalletService.increaseAble(member, eachCheapAmount, chaseTerm.getLotteryType().getValue(), plan.getPlanNo(), planOrder
//							.getOrderNo(), new Integer(0), chase.getWalletType().getValue(), WalletTransType.CHARE_PACKAGE_PRESENT.getValue(), member
//							.getSourceId(), "追号套餐赠送金额:" + eachCheapAmount + "元", chase.getPlatform());
//
//					memberWalletService.freezeToAble(member, chase.getWalletType().getValue(), unfreezeAmount, chaseTerm.getLotteryType().getValue(), plan.getPlanNo(), planOrder.getOrderNo(),
//							new Integer(0), member.getSourceId(), "追号套餐购彩解冻:" + unfreezeAmount + "元", chase.getPlatform());
//					memberWalletService.consume(member, new Double(planOrder.getAmount()), chaseTerm.getLotteryType().getValue(), plan.getPlanNo(), planOrder.getOrderNo(), new Integer(0), chase.getWalletType().getValue(), member.getSourceId(), "追号套餐购彩消费：" + planOrder.getAmount(), chase.getPlatform());
//				} else {
//					memberWalletService.freezeToConsume(member, chase.getWalletType().getValue(), planOrder.getAmount().doubleValue(), plan.getLotteryType().getValue(), plan.getPlanNo(), planOrder.getOrderNo(), new Integer(0), member
//						.getSourceId(), "追号方案:" + chaseTerm.getChaseNo(), chase.getPlatform());
//				}
//			}else{
//				//当前不用扣积分 一次性在提交时扣取
//			}
//			chaseTerm.setStatus(ChaseTermStatus.SUCCESS);
//			chaseTerm.setPlanNo(plan.getPlanNo());
//			if (!StringTools.isNullOrBlank(startCondition) || "0".equals(chaseTerm.getTerm())) {
//				chaseTerm.setTerm(nowTerm.getTerm());// 条件追号保存时期数为空
//														// 此处设置期数
//			}
//			lotteryChaseTermDAO.attachDirty(chaseTerm);
//			com.cailele.lottery.tools.LogUtil.info("开始执行追号==>追号No:" + chaseTerm.getChaseNo() + " Account:" + member.getAccount() + " PlanNo:"
//					+ plan.getPlanNo() + " OrderNo:" + planOrder.getOrderNo() + "<==结束");
//
//			// 更新已认购期数
//			chase.setSoldTerm(chase.getSoldTerm() + 1);// 每次加1
//			// 如果是最后一期追号 则更新追号主表的状态
//			//先查出取消的期数
//			List list = lotteryChaseTermDAO.findByForChaseStatus(chase.getChaseNo(), ChaseTermStatus.CANCEL);
//			int cancelTerm = list == null ? 0 : list.size();
//			if ((cancelTerm + chase.getSoldTerm().intValue()) == chase.getTotalTerm().intValue()) {
//				chase.setStatus(ChaseStatus.CHASE_END);
//			}
//			this.lotteryChaseDAO.attachDirty(chase);
//		}
//	}
//
//	/**
//	 * 检查追号开始条件
//	 *
//	 * @param nowTerm
//	 * @param startCondition
//	 * @return 符合条件返回true,不符合返回false
//	 */
//	public boolean checekChaseStartCondition(LotteryTerm nowTerm, String startCondition) {
//		// 获取上一期彩期
//		LotteryTerm perLotteryTerm = lotteryTermDAO.findPreByLotteryTypeAndTerm(nowTerm.getLotteryType(), nowTerm.getTerm());
//		com.cailele.lottery.tools.LogUtil.info("当前期数:" + nowTerm.getTerm() + " 上一期数:" + perLotteryTerm.getTerm());
//		// 检查追号开始条件
//		return startConditionCheckerFactory.check(nowTerm.getLotteryType().getValue(), perLotteryTerm, startCondition);
//	}
//
//	public void attachClean(LotteryChase instance) {
//		lotteryChaseDAO.attachClean(instance);
//	}
//
//	public void attachDirty(LotteryChase instance) {
//		lotteryChaseDAO.attachDirty(instance);
//	}
//
//	public void delete(LotteryChase persistentInstance) {
//		lotteryChaseDAO.delete(persistentInstance);
//	}
//
//	public List findByExample(LotteryChase instance) {
//		return lotteryChaseDAO.findByExample(instance);
//	}
//
//	public LotteryChase findById(Integer id) {
//		return lotteryChaseDAO.findById(id);
//	}
//
//	public LotteryChase merge(LotteryChase detachedInstance) {
//		return lotteryChaseDAO.merge(detachedInstance);
//	}
//
//	public void save(LotteryChase transientInstance) {
//		lotteryChaseDAO.save(transientInstance);
//	}
//
//	public void setLotteryChaseDAO(LotteryChaseDAO lotteryChaseDAO) {
//		this.lotteryChaseDAO = lotteryChaseDAO;
//	}
//
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
//
//	public void setLotteryPlanDAO(LotteryPlanDAO lotteryPlanDAO) {
//		this.lotteryPlanDAO = lotteryPlanDAO;
//	}
//
//	public void setLotteryPlanOrderDAO(LotteryPlanOrderDAO lotteryPlanOrderDAO) {
//		this.lotteryPlanOrderDAO = lotteryPlanOrderDAO;
//	}
//
//	public void setLotteryChaseTermDAO(LotteryChaseTermDAO lotteryChaseTermDAO) {
//		this.lotteryChaseTermDAO = lotteryChaseTermDAO;
//	}
//
//	public void setMemberWalletService(MemberWalletService memberWalletService) {
//		this.memberWalletService = memberWalletService;
//	}
//
//	public void setLotteryTermDAO(LotteryTermDAO lotteryTermDAO) {
//		this.lotteryTermDAO = lotteryTermDAO;
//	}
//
//	public void setStartConditionCheckerFactory(StartConditionCheckerFactory startConditionCheckerFactory) {
//		this.startConditionCheckerFactory = startConditionCheckerFactory;
//	}
//
//	public void setBasketBallService(BasketBetService basketBallService) {
//		this.basketBallService = basketBallService;
//	}

}
