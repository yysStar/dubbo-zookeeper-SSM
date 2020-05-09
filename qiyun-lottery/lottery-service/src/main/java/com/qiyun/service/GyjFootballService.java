package com.qiyun.service;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.football.GyjAward;
import com.qiyun.model.football.GyjFootballMatch;
import com.qiyun.model.football.GyjFootballTeam;

import java.util.List;

public interface GyjFootballService {

	
	public void saveOrUpdate(Object entry);

	public List<GyjFootballTeam> findTeamListByLotTypeAndTerm(String term, LotteryType lotteryType);

	public List<GyjAward> findLastUpdataGyjAwardByLotTypeAndTerm(String term, LotteryType lotteryType);

//	public void setGyjFootballAwardDao(GyjFootballAwardDao gyjFootballAwardDao);
//
//	public void setGyjFootballTeamDao(GyjFootballTeamDao gyjFootballTeamDao);
	
	public List<GyjFootballTeam> findTeamByStatus(int status, LotteryType lotteryType);
	
	public List<GyjFootballMatch> findGyjMatchList(String term, LotteryType lotteryType);
	
	public List<GyjFootballMatch> findOnSaleGyjMatch(int status, LotteryType lotteryType);
	

}
