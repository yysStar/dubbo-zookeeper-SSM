//package com.qiyun.serviceImpl;
//
//import com.qiyun.commonModel.LotteryType;
//import com.qiyun.grabber.football.DcArrange;
//import com.qiyun.grabber.football.RaceStatus;
//import com.qiyun.model.LotteryTypeProps;
//import com.qiyun.service.DcArrangeService;
//import com.qiyun.service.LotteryTypePropsService;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//public class DcArrangeServiceImpl implements DcArrangeService<DcArrange> {
//
//	private LotteryTypePropsService lotteryTypePropsService;
//
//	/**
//	 * 按彩种、期数，排序查询
//	 */
//	public List findForShow(final LotteryType lotteryType, final String term) {
//		return findForShow(lotteryType, term);
//	}
//
//	public void attachClean(DcArrange instance) {
//		dcArrangeDAO.attachClean(instance);
//	}
//
//	public void attachDirty(DcArrange instance) {
//		LotteryTypeProps props = this.lotteryTypePropsService.findById(LotteryType.DC_SFP.getValue());
//		if (instance.getStatus().getValue()== RaceStatus.CAN_BUY.getValue()&&new Date().getTime() >= DateTools.GetDCMatchEndTime(instance.getMatchTime(), props.getFsAheadTime()).getTime()) {
//			instance.setStatus(RaceStatus.STOP_BUY);
//		}
//		dcArrangeDAO.attachDirty(instance);
//	}
//
//	public void attachDirty(List<DcArrange> dcList) {
//		if (dcList != null && !dcList.isEmpty()) {
//			for (DcArrange dc : dcList) {
//				this.dcArrangeDAO.attachDirty(dc);
//			}
//		}
//	}
//
//	public void delete(DcArrange persistentInstance) {
//		dcArrangeDAO.delete(persistentInstance);
//	}
//
//	public List findAll() {
//		return dcArrangeDAO.findAll();
//	}
//
//	public List findByAwaryTream(Object awaryTream) {
//		return dcArrangeDAO.findByAwaryTream(awaryTream);
//	}
//
//	public List findByExample(DcArrange instance) {
//		return dcArrangeDAO.findByExample(instance);
//	}
//
//	public List findByHomeTeam(Object homeTeam) {
//		return dcArrangeDAO.findByHomeTeam(homeTeam);
//	}
//
//	public DcArrange findById(Integer id) {
//		return dcArrangeDAO.findById(id);
//	}
//
//	public List findByMatchTime(Object matchTime) {
//		return dcArrangeDAO.findByMatchTime(matchTime);
//	}
//
//	public List findByMatchName(Object matchName) {
//		return dcArrangeDAO.findByMatchName(matchName);
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		return dcArrangeDAO.findByProperty(propertyName, value);
//	}
//
//	public List findByProperty(final String propertyName,final Object value,final int offset,final int length) {
//		return dcArrangeDAO.findByProperty(propertyName, value,offset,length);
//	}
//
//	public int getByPropertyCount(String propertyName, Object value) {
//		return dcArrangeDAO.findByPropertyCount(propertyName, value);
//	}
//
//	public List findByTerm(Object term) {
//		return dcArrangeDAO.findByTerm(term);
//	}
//
//	public DcArrange merge(DcArrange detachedInstance) {
//		return dcArrangeDAO.merge(detachedInstance);
//	}
//
//	public void save(DcArrange transientInstance) {
//		dcArrangeDAO.save(transientInstance);
//	}
//
//	public void setDcArrangeDAO(DcArrangeDAO<DcArrange> dcArrangeDAO) {
//		this.dcArrangeDAO = dcArrangeDAO;
//	}
//
//	public List findByBoutIndexAndTerm(Object boutIndex, Object term) {
//		return dcArrangeDAO.findByBoutIndexAndTerm(boutIndex, term);
//	}
//
//	public void updateGameInfo(Integer gameId) {
//		dcArrangeDAO.updateGameInfo(gameId);
//
//	}
//
//	@SuppressWarnings("unchecked")
//	public void saveOutID(String term, Map<Integer, String> outIdMap) {
//		List<DcArrange> arrangeList = dcArrangeDAO.findForShow(LotteryType.DC_SFP, term);
//		for (DcArrange arrange : arrangeList) {
//			String outid = outIdMap.get(Integer.valueOf(arrange.getBoutIndex()));
//			arrange.setOutid(outid);
//			save(arrange);
//		}
//	}
//
//	public List<DcArrange> findByOutIDList(List<Integer> outIdList) {
//		return dcArrangeDAO.findByOutIDList(outIdList);
//	}
//
//	public long countDc() {
//		return dcArrangeDAO.countDc();
//	}
//
//	public List<DcArrange> findByPage(int offset, int length) {
//		return dcArrangeDAO.findByPage(offset, length);
//	}
//
//	public void setLotteryTypePropsService(LotteryTypePropsService lotteryTypePropsService) {
//		this.lotteryTypePropsService = lotteryTypePropsService;
//	}
//
//	public List findByDetachedCriteria(String term,RaceStatus status){
//		DetachedCriteria criteria = DetachedCriteria.forClass(DcArrange.class);
//		criteria.add(Restrictions.eq("term", term));
//		criteria.add(Restrictions.eq("status", status));
//		criteria.addOrder(Order.asc("matchTime"));
//		criteria.addOrder(Order.asc("id"));
//		List list = dcArrangeDAO.findByDetachedCriteria(criteria);
//		return list;
//	}
//	public List findByBoutIndexAndTermList(Collection<Integer> boutIndex, Object term) {
//		return dcArrangeDAO.findByBoutIndexAndTermList(boutIndex,term);
//	}
//
//	public DcArrange findLastMatchOperResultData() {
//		return dcArrangeDAO.findLastMatchOperResultData();
//	}
//
//
//}
