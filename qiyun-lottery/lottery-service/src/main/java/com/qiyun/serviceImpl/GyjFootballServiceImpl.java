//package com.qiyun.serviceImpl;
//
//import com.qiyun.commonModel.LotteryType;
//import com.qiyun.model.football.GyjAward;
//import com.qiyun.model.football.GyjFootballMatch;
//import com.qiyun.model.football.GyjFootballTeam;
//import com.qiyun.service.GyjFootballService;
//
//import java.util.List;
//
//public class GyjFootballServiceImpl implements GyjFootballService {
//	GyjFootballAwardDao gyjFootballAwardDao;
//
//	GyjFootballTeamDao gyjFootballTeamDao;
//
//
//	public void saveOrUpdate(Object entry) {
//		gyjFootballTeamDao.saveOrUpdate(entry);
//	}
//
//	public List<GyjFootballTeam> findTeamListByLotTypeAndTerm(String term, LotteryType lotteryType) {
//		return gyjFootballTeamDao.findTeamListByLotTypeAndTerm(term, lotteryType);
//	}
//
//	public List<GyjAward> findLastUpdataGyjAwardByLotTypeAndTerm(String term, LotteryType lotteryType) {
//		return gyjFootballAwardDao.findLastUpdataGyjAwardByLotTypeAndTerm(term, lotteryType);
//
//	}
//	public List<GyjFootballTeam> findTeamByStatus(int status,LotteryType lotteryType) {
//		return gyjFootballTeamDao.findTeamByStatus(status,lotteryType);
//	}
//
//	public void setGyjFootballAwardDao(GyjFootballAwardDao gyjFootballAwardDao) {
//		this.gyjFootballAwardDao = gyjFootballAwardDao;
//	}
//
//	public void setGyjFootballTeamDao(GyjFootballTeamDao gyjFootballTeamDao) {
//		this.gyjFootballTeamDao = gyjFootballTeamDao;
//	}
//
//	public List<GyjFootballTeam> findListByLotTypeAndTermByGroup(String term, LotteryType lotteryType) {
//		return gyjFootballTeamDao.findListByLotTypeAndTermByGroup(term, lotteryType);
//	}
//
//	public List<GyjFootballMatch> findGyjMatchList(String term, LotteryType lotteryType) {
//
//		return gyjFootballTeamDao.findGyjMatchList(term, lotteryType);
//	}
//
//	public List<GyjFootballMatch> findOnSaleGyjMatch(int status, LotteryType lotteryType) {
//		return gyjFootballTeamDao.findOnSaleGyjMatch(status, lotteryType);
//	}
//
//
//}
