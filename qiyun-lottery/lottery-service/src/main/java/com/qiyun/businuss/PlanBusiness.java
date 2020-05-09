package com.qiyun.businuss;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.lottery.LotteryPlan;
import com.qiyun.lottery.LotteryPlanSaved;
import com.qiyun.type.SelectType;
import com.qiyun.vo.HmNewListBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PlanBusiness {
	/**
	 * 不包括已开奖方案
	 */
	public final static Boolean UNINCLUDE_OPENEDPLAN=false;
	/**
	 * 包括已开奖未派奖方案
	 */
	public final static Boolean INCLUDE_OPENEDPLAN=true;
	// 合买截止的业务处理，包括方案撤销，公司补单，保底处理等
	public void hmStopProcess(LotteryType lt, String term, SelectType st, Platform platform);

	// 对单方案进行合买截止处理
	public void hmPlanStopProcess(LotteryPlan plan, boolean bool, Platform platform) throws Exception;
	
	// 对合买成功或流单方案统计处理
	public void hmHmLevelProcess(int lotteryType, String term);
	
	// 对合买成功或流单方案统计处理(修复线程)
	public void hmHmLevelProcess(int offset, final int length);
	
	// 对合买个人页面跟单方案统计处理
	public List hmFollowingCountProcess(String account, List levelList, int modeNum);
	
	// 对合买红人页面方案统计处理
	public List hmRedPersonProcess(String sql, int offset, final int length);
	
	// 未派奖的方案进行开奖
	public List<LotteryPlan> checkBingo(HashMap<String, String> openResultMap, Boolean isOpenAgain);
	
	// 对虚拟号未派奖的方案进行开奖(上线测试使用)
	public List<LotteryPlan> virtualCheckBingo(HashMap<String, String> openResultMap, Boolean isOpenAgain);
	
	// 为开奖方案进行开奖
	public List<LotteryPlan> checkBingo(HashMap<String, String> openResultMap);
	
	// 流单开奖
	public List<LotteryPlan> checkFailurePlanBingo(HashMap<String, String> openResultMap);
    
	/**
	 * <p>保存方案开奖</p>
	 * @param openResultMap HashMap<String, String>
	 * @return List<LotteryPlanSaved>
	 */
	public List<LotteryPlanSaved> checkSavedPlanBingo(HashMap<String, String> openResultMap);
	
	//更新方案过关统计
	public void refreshPlanPrizeInfo(Map<String, String> openResultMap) ;
	
	// 派奖
	public void returnPrize(String planNo, String amount, Platform platform);
	
	// 派积分
	public void returnScore(String planNo, String amount, Platform platform);
	
	/**
	 * <p>积分投注方案派奖</p>
	 * @param planNo Integer
	 */
    public void returnPrizeForScore(Integer planNo);
	
	//后台追号批量删除处理
	public void cancelLotteryZhAll(Integer lotteryType, Platform platform) throws Exception;
	
	/***
	 * 统计合买个人页面数据流单数据
	 * @param bean
	 * @param account
	 * @return HmNewListBean
	 */
	public HmNewListBean countLoseHelp(HmNewListBean bean, String account);
	
	/***
	 * 统计代购个人数据
	 * @param bean
	 * @param account
	 * @return HmNewListBean
	 */
	public HmNewListBean countDgHelp(HmNewListBean bean, String account);
	
	/***
	 * 统计合买个人页面数据合买数据
	 * @param bean
	 * @param account
	 * @return HmNewListBean
	 */
	public HmNewListBean countHmHelp(HmNewListBean bean, String account);

	/**
	 * 未支付方案开奖
	 * @param openResultMap
	 */
	public void checkNotPayPlanBingo(HashMap<String, String> openResultMap);
	
	/**
	 * 积分购买方案开奖
	 * @param openResultMap
	 */
	public List<LotteryPlan> checkScorePayPlanBingo(HashMap<String, String> openResultMap);
	
}