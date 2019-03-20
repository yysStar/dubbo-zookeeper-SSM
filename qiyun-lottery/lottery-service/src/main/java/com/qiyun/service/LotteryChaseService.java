package com.qiyun.service;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.TradeType;
import com.qiyun.grabber.LotteryChase;
import com.qiyun.lottery.ChaseSearch;
import com.qiyun.model.LotteryChaseTerm;
import com.qiyun.model.LotteryTerm;
import com.qiyun.status.ChaseStatus;

import java.util.Date;
import java.util.List;

public interface LotteryChaseService {

	public List findBySearch(final ChaseSearch search, final int offset, final int length);
	
	public List<LotteryChase> findByLotteryType(final LotteryType lotteryType);

	public int getCountBySearch(final ChaseSearch search);

	public List getSumBySearch(final ChaseSearch search);

	public List findForMember(final String account, final Date startDate, final Date endDate, final LotteryType lotteryType,
							  final ChaseStatus chaseStatus, final TradeType tradeType, final int offset, final int length);

	public int getCountForMember(final String account, final Date startDate, final Date endDate, final LotteryType lotteryType,
                                 final ChaseStatus chaseStatus, final TradeType tradeType);

	/**
	 * 追号套餐生成一条追号从表记录
	 * 
	 * @param lotteryType
	 * @param nextTerm
	 */
	public void chasePackageMakeChaseTerm(LotteryType lotteryType, String nextTerm);

	/**
	 * 追号购买处理
	 * 
	 * @param chaseTerm
	 * @param nowTerm
	 * @throws Exception
	 */
	public void doChase(LotteryChaseTerm chaseTerm, LotteryTerm nowTerm) throws Exception;

	/**
	 * 检查追号开始条件
	 * 
	 * @param nowTerm
	 * @param startCondition
	 * @return 符合条件返回true,不符合返回false
	 */
	public boolean checekChaseStartCondition(LotteryTerm nowTerm, String startCondition);

	public abstract void save(LotteryChase transientInstance);

	public abstract void delete(LotteryChase persistentInstance);

	public abstract LotteryChase findById(Integer id);

	public abstract List findByExample(LotteryChase instance);

	public abstract LotteryChase merge(LotteryChase detachedInstance);

	public abstract void attachDirty(LotteryChase instance);

	public abstract void attachClean(LotteryChase instance);
}
