package com.qiyun.service;

import com.qiyun.exception.ServiceException;
import com.qiyun.model.Member;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.support.SportteryRecommend;
import com.qiyun.support.SportteryRecommendSearch;
import com.qiyun.support.SportteryRecommendStatus;
import com.qiyun.support.SportteryRecommendVo;

import java.util.List;

public interface SportteryRecommendService {

	public SportteryRecommend findById(Integer id);

	public void saveOrUpdate(SportteryRecommend sportteryRecommend);
	
	public void saveOrUpdateAll(List<SportteryRecommend> recommendList);

	public void delete(SportteryRecommend sportteryRecommend);
	/**
	 * 对靓胆重新判断是否中奖
	 * @param matchList
	 */
	public void fbCheckBingoAgain(List<FootBallMatch> matchList);
	
	/**
	 * 对靓胆重新判断是否中奖
	 * @param matchList
	 */
	public void bbCheckBingoAgain(List<BasketBallMatch> matchList);

	/**
	 * 按优先级 和发布时间排序
	 * 
	 * @param search
	 * @param offset
	 * @param length
	 * @return
	 */
	public List<SportteryRecommend> findAll(SportteryRecommendSearch search, int offset, int length);
	
	/**
	 * 在售按优先级排序,停售按发布顺序排序
	 * 
	 * @param search
	 * @param offset
	 * @param length
	 * @return
	 */
	public List<SportteryRecommend> findSubjectAll(SportteryRecommendSearch search, int offset, Integer length);
	
	
	/**
	 * ID倒序排列
	 * 
	 * @param expertId
	 * @param offset
	 * @param length
	 * @return
	 */
	public List<SportteryRecommend> findAllByExpertId(Integer expertId, int offset, int length, Boolean isFree);

	public Integer getCountByExpertId(Integer expertId, Boolean isFree);

	public Integer getCount(SportteryRecommendSearch search);

	public List<SportteryRecommend> findOnSaleList(Boolean isFree);
	/**
	 * 最新的彩期
	 * @return
	 */
	public String findLastTerm(Boolean isFree);
	
	public List<SportteryRecommend> findAll(List<SportteryRecommendStatus> statusList, Boolean isFree);

	public List<SportteryRecommend> findHistoryList(String term, Boolean isFree);

	/**
	 * 统计每个专家的命中率
	 * 
	 * @return
	 */
	public List<SportteryRecommendVo> groupHitRate(Boolean isFree);

	/**
	 * 统计某个专家的命中率
	 * 
	 * @param expertId
	 * @return
	 */
	public List<SportteryRecommendVo> groupHitRate(Integer expertId, Boolean isFree) throws ServiceException;

	/**
	 * 查找靓胆走势
	 * 
	 * @param expertId
	 * @param length
	 * @return
	 */
	public List<SportteryRecommend> findTrendRecommend(Integer expertId, int length, Boolean isFree);
	
	/**
	 * 是否已经购买过靓胆
	 * @param account
	 * @param recommendId
	 * @return
	 */
	public boolean hasBuy(String account, int recommendId);
	
	/**
	 * 靓胆购买
	 * @param member
	 * @param recommendId
	 * @param buyConsume
	 * @param buyType
	 * @return 靓胆
	 */
	public SportteryRecommend buy(Member member, int recommendId, Integer buyConsume, Integer buyType) throws Exception ;

}
