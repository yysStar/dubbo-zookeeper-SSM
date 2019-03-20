package com.qiyun.lottery;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.football.AbstractDcArrange;
import com.qiyun.grabber.football.RaceStatus;

import java.util.Collection;
import java.util.List;

public interface DcArrangeService<T extends AbstractDcArrange> {

	/**
	 * 按彩种、期数，排序查询
	 */
	public List findForShow(final LotteryType lotteryType, final String term);
	public void updateGameInfo(Integer gameId);
	public abstract void save(T transientInstance);

	public abstract void delete(T persistentInstance);

	public abstract T findById(Integer id);

	public abstract List findByExample(T instance);

	public abstract List findByProperty(String propertyName, Object value);
	
	public abstract List findByProperty(final String propertyName, final Object value, final int offset, final int length);
	
	public abstract int getByPropertyCount(String propertyName, Object value);
	
	public abstract List findByOutIDList(List<Integer> outIdList);

	public abstract List findByTerm(Object term);

	public abstract List findByHomeTeam(Object homeTeam);

	public abstract List findByAwaryTream(Object awaryTream);

	public abstract List findByMatchName(Object matchName);

	public abstract List findByMatchTime(Object matchTime);

	public abstract List findByBoutIndexAndTerm(Object boutIndex, Object term);

	public abstract List findAll();

	public abstract T merge(T detachedInstance);

	public abstract void attachDirty(T instance);
	
	public abstract void attachDirty(List<T> dcList);

	public abstract void attachClean(T instance);
	public long countDc();
	public List<T> findByPage(int offset, int length);
	
	public abstract List findByBoutIndexAndTermList(Collection<Integer> boutIndex, Object term);


	public abstract List findByDetachedCriteria(String term, RaceStatus status);
	/**查询北单最新一场比赛结果*/
	public T findLastMatchOperResultData();

}
