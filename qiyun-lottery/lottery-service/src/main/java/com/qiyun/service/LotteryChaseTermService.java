package com.qiyun.service;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.LotteryChaseTerm;
import com.qiyun.status.ChaseTermStatus;

import java.util.List;

public interface LotteryChaseTermService {

	/**
	 * 按彩种找出有开始条件的追号列表
	 * 
	 * @param lotteryType
	 * @param term
	 * @return
	 */
	public List<LotteryChaseTerm> findChaseTermConditionList(final LotteryType lotteryType, final String term);

	/**
	 * 按彩种和彩期找出追号列表
	 * 
	 * @param lotteryType
	 * @param term
	 * @return
	 */
	public List findByForChase(final LotteryType lotteryType, final String term);
	
	/**
	 * 按彩种和彩期找出追号列表
	 * 
	 * @param lotteryType
	 * @param term
	 * @param status
	 * @return
	 */
	public List findByForChase(final LotteryType lotteryType, final String term, final ChaseTermStatus status);
	
	/**
	 * 合并追号编号找出追号列表
	 * 
	 * @param lotteryType
	 * @param term
	 * @return
	 */
	public List findByForChaseOn(final LotteryType lotteryType, final String term);
	
	/**
	 * 根据追号方案状态查询追号列表
	 * 
	 * @param chaseNo
	 * @param status
	 * @return
	 */
	public List findByForChaseStatus(final Integer chaseNo, final ChaseTermStatus status);
	
	
	/**
	 * 根据追号方案号查询追号最新的撤销方案
	 * 
	 * @param chaseNo
	 * @param status
	 * @return
	 */
	public LotteryChaseTerm findByForChaseStatusCancel(final Integer chaseNo, final ChaseTermStatus status);

	public List findByChaseNo(Object chaseNo);

	public abstract void save(LotteryChaseTerm transientInstance);

	public abstract void delete(LotteryChaseTerm persistentInstance);

	public abstract LotteryChaseTerm findById(Integer id);

	public abstract List findByExample(LotteryChaseTerm instance);

	public abstract LotteryChaseTerm merge(LotteryChaseTerm detachedInstance);

	public abstract void attachDirty(LotteryChaseTerm instance);

	public abstract void attachClean(LotteryChaseTerm instance);
}
