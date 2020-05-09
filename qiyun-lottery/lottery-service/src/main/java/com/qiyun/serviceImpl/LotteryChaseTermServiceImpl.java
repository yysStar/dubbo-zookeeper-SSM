package com.qiyun.serviceImpl;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.LotteryChase;
import com.qiyun.mapper2.LotteryChase2Mapper;
import com.qiyun.mapper2.LotteryChaseTerm2Mapper;
import com.qiyun.model.LotteryChaseTerm;
import com.qiyun.model2.LotteryChaseTerm2;
import com.qiyun.service.LotteryChaseTermService;
import com.qiyun.status.ChaseTermStatus;
import com.qiyun.util.LogUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class LotteryChaseTermServiceImpl implements LotteryChaseTermService {
	@Resource
	private LotteryChase2Mapper lotteryChase2Mapper;
	@Resource
	private LotteryChaseTerm2Mapper lotteryChaseTerm2Mapper;

//	/**
//	 * 按彩种找出有开始条件的追号列表
//	 *
//	 * @param lotteryType
//	 * @return
//	 */
//	public List<LotteryChaseTerm> findChaseTermConditionList(final LotteryType lotteryType, final String term) {
//		List<LotteryChaseTerm> result = new ArrayList<LotteryChaseTerm>();
//		List<LotteryChase> list = lotteryChase2Mapper.findChaseConditionList(lotteryType);
//		for (int i = 0; i < list.size(); i++) {
//			LotteryChase lotteryChase = list.get(i);
//			Integer chaseNo = lotteryChase.getChaseNo();
//
//			// 检查是否产生了当期追号从表记录
//			LotteryChaseTerm chaseTerm = lotteryChaseTerm2Mapper.findByChaseNoAndTerm(chaseNo, term);
//			if (chaseTerm != null) {
//				continue;
//			}
//
//			LotteryChaseTerm lotteryChaseTerm = lotteryChaseTerm2Mapper.findMinChaseTerm(lotteryType, chaseNo);
//			result.add(lotteryChaseTerm);
//		}
//		LogUtil.info(lotteryType.getName() + "找出有开始条件的追号列表:" + result.size() + "条");
//		return result;
//	}
//
//	/**
//	 * 按彩种和彩期找出追号列表
//	 *
//	 * @param lotteryType
//	 * @param term
//	 * @return
//	 */
//	public List findByForChase(final LotteryType lotteryType, final String term) {
//		List list = lotteryChaseTerm2Mapper.findByForChase(lotteryType, term);
//		if (list == null || list.isEmpty()) {
//			list = new ArrayList();
//		}
//
//		// 合并有开始条件的追号
//		List<LotteryChaseTerm> conditionList = findChaseTermConditionList(lotteryType, term);
//		for (int i = 0; i < conditionList.size(); i++) {
//			LotteryChaseTerm lotteryChaseTerm = conditionList.get(i);
//			list.add(lotteryChaseTerm);
//		}
//
//		return list;
//	}
//
//	/**
//	 * 按彩种和彩期找出追号列表
//	 *
//	 * @param lotteryType
//	 * @param term
//	 * @param status
//	 * @return
//	 */
//	public List findByForChase(final LotteryType lotteryType, final String term,final ChaseTermStatus status) {
//		List list = lotteryChaseTerm2Mapper.findByForChase(lotteryType, term, status);
//		if (list == null || list.isEmpty()) {
//			list = new ArrayList();
//		}
//		return list;
//	}
//
//	/**
//	 * 合并追号编号找出追号列表
//	 *
//	 * @param lotteryType
//	 * @param term
//	 * @return
//	 */
//	public List findByForChaseOn(final LotteryType lotteryType, final String term) {
//		List list = lotteryChaseTerm2Mapper.findByForChaseOn(lotteryType, term);
//		if (list == null || list.isEmpty()) {
//			list = new ArrayList();
//		}
//		return list;
//	}
//
//	/**
//	 * 根据追号方案状态查询追号列表
//	 *
//	 * @param chaseNo
//	 * @param status
//	 * @return
//	 */
//	public List findByForChaseStatus(final Integer chaseNo, final ChaseTermStatus status) {
//		return lotteryChaseTerm2Mapper.findByForChaseStatus(chaseNo, status);
//	}
//
//	/**
//	 * 根据追号方案号查询追号最新的撤销方案
//	 *
//	 * @param chaseNo
//	 * @param status
//	 * @return
//	 */
//	public LotteryChaseTerm findByForChaseStatusCancel(Integer chaseNo, ChaseTermStatus status) {
//		return lotteryChaseTerm2Mapper.findByForChaseStatusCancel(chaseNo, status);
//	}
//
//	public List findByChaseNo(Object chaseNo) {
//		return this.lotteryChaseTerm2Mapper.findByChaseNo(chaseNo);
//	}
//
//	public void attachClean(LotteryChaseTerm instance) {
//		lotteryChaseTerm2Mapper.attachClean(instance);
//	}
//
//	public void attachDirty(LotteryChaseTerm instance) {
//		lotteryChaseTerm2Mapper.attachDirty(instance);
//	}
//
//	public void delete(LotteryChaseTerm persistentInstance) {
//		lotteryChaseTerm2Mapper.delete(persistentInstance);
//	}
//
//	public List findByExample(LotteryChaseTerm instance) {
//		return lotteryChaseTerm2Mapper.findByExample(instance);
//	}
//
//	public LotteryChaseTerm findById(Integer id) {
//		return lotteryChaseTerm2Mapper.findById(id);
//	}
//
//	public LotteryChaseTerm merge(LotteryChaseTerm detachedInstance) {
//		return lotteryChaseTerm2Mapper.merge(detachedInstance);
//	}

	public List<LotteryChaseTerm> findChaseTermConditionList(LotteryType lotteryType, String term) {
		return null;
	}

	public List findByForChase(LotteryType lotteryType, String term) {
		return null;
	}

	public List findByForChase(LotteryType lotteryType, String term, ChaseTermStatus status) {
		return null;
	}

	public List findByForChaseOn(LotteryType lotteryType, String term) {
		return null;
	}

	public List findByForChaseStatus(Integer chaseNo, ChaseTermStatus status) {
		return null;
	}

	public LotteryChaseTerm findByForChaseStatusCancel(Integer chaseNo, ChaseTermStatus status) {
		return null;
	}

	public List findByChaseNo(Object chaseNo) {
		return null;
	}

	public void save(LotteryChaseTerm transientInstance) {
		LotteryChaseTerm2 term2 = TermTo2(transientInstance);
		lotteryChaseTerm2Mapper.insertSelective(term2);
	}

	public void delete(LotteryChaseTerm persistentInstance) {

	}

	public LotteryChaseTerm findById(Integer id) {
		return null;
	}

	public List findByExample(LotteryChaseTerm instance) {
		return null;
	}

	public LotteryChaseTerm merge(LotteryChaseTerm detachedInstance) {
		return null;
	}

	public void attachDirty(LotteryChaseTerm instance) {

	}

	public void attachClean(LotteryChaseTerm instance) {

	}

	private LotteryChaseTerm2 TermTo2(LotteryChaseTerm term){
		LotteryChaseTerm2 term2 = LotteryChaseTerm2.builder().amount(term.getAmount())
				.cancelDateTime(term.getCancelDateTime()).chaseNo(term.getChaseNo())
				.lotteryType(term.getLotteryType().getValue())
				.cancelType(term.getCancelType() == null? 0 : term.getCancelType().getValue())
				.multiple(term.getMultiple()).build();
		return term2;
	}

}
