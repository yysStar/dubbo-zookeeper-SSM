package com.qiyun.businuss.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qiyun.businuss.TermBusiness;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.PrizeBean;
import com.qiyun.model.PrizeCommon;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model.football.GyjFootballMatch;
import com.qiyun.model.football.GyjFootballTeam;
import com.qiyun.service.BasketBetService;
import com.qiyun.service.FootBallService;
import com.qiyun.service.GyjFootballService;
import com.qiyun.utils.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class TermBusinessImpl implements TermBusiness {
	@Autowired
	private BasketBetService basketBallService;
	@Autowired
	private FootBallService footBallService;
	@Autowired
	private GyjFootballService gyjFootballService;

	private static final int OPEN_DAY = 30;//保存最近开奖天数
	
	public HashMap getOpenInfoMapForCheckBingo(LotteryTerm term, LotteryType type) throws Exception {
		int lotteryTypeValue = type.getValue();
		HashMap<String, String> openResultMap = new HashMap<String, String>();
		openResultMap.put("lotteryType", lotteryTypeValue + "");
		openResultMap.put("term", term.getTerm());
	
		if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryTypeValue))) {// 竞彩篮球
			// 查出最近三十天的开奖的数据
			Map<String, Integer> timeMap = CommonUtils.getBgTimeAndEdTime(OPEN_DAY);
			Integer bgintTime = timeMap.get(CommonUtils.beginIntTimeKey);
			Integer edintTime = timeMap.get(CommonUtils.endIntTimeKey);
			List<BasketBallMatch> matchList = this.basketBallService.findMatchListBetweenIntTimes(bgintTime, edintTime);
			List<BasketBallMatch> tempmatchList = new ArrayList<BasketBallMatch>();
			for (BasketBallMatch match : matchList) {//
				if (match.getStatus().intValue() != MatchStatus.ONSALE.ordinal()) {
					tempmatchList.add(match);
				}
			}
			matchList = tempmatchList;
			// 无论是什么玩法，将所需要的参数全部设置进去
			for (BasketBallMatch bm : matchList) {
				String tempKey = bm.getIntTime() + "_" + bm.getLineId();
				Integer homeScore = bm.getHomeScore();
				Integer guestScore = bm.getGuestScore();
				if (homeScore == null || guestScore == null) {
					if (bm.getStatus().equals(2)) {// 取消的赛事
						openResultMap.put(CommonUtils.homeScoreKey + tempKey, "-1"); //和竞彩足球保持一致
						openResultMap.put(CommonUtils.guestScoreKey + tempKey, "-1");
						openResultMap.put(CommonUtils.handicapKey + tempKey, "0");
						openResultMap.put(CommonUtils.bigSmallKey + tempKey, "0");
						openResultMap.put(CommonUtils.resultSFKey + tempKey, "1");
						openResultMap.put(CommonUtils.resultSFCKey + tempKey, "1");
						openResultMap.put(CommonUtils.resultRFSFKey + tempKey, "1");
						openResultMap.put(CommonUtils.resultDXFKey + tempKey, "1");
					} else {
						continue;
					}
				} else {
					String Handicap = "0";
					if (bm.getSingle_handicap() != null)
						Handicap = bm.getSingle_handicap().toString();// 让分
					Double SFResult = bm.getResultOfSF() == null ? 0d : bm.getResultOfSF();
					Double RFSFResult = bm.getResultOfRFSF() == null ? 0d : bm.getResultOfRFSF();
					Double DXFResult = bm.getResultOfDXF() == null ? 0d : bm.getResultOfDXF();
					Double SFCResult = bm.getResultOfSFC() == null ? 0d : bm.getResultOfSFC();
					Double bigSmallBase = bm.getSingle_baseBigOrSmall() == null ? 0d : bm.getSingle_baseBigOrSmall();// 大小分基数
					openResultMap.put(CommonUtils.homeScoreKey + tempKey, homeScore.toString());
					openResultMap.put(CommonUtils.guestScoreKey + tempKey, guestScore.toString());
					openResultMap.put(CommonUtils.handicapKey + tempKey, Handicap);
					openResultMap.put(CommonUtils.bigSmallKey + tempKey, bigSmallBase.toString());
					openResultMap.put(CommonUtils.resultSFKey + tempKey, SFResult.toString());
					openResultMap.put(CommonUtils.resultSFCKey + tempKey, SFCResult.toString());
					openResultMap.put(CommonUtils.resultRFSFKey + tempKey, RFSFResult.toString());
					openResultMap.put(CommonUtils.resultDXFKey + tempKey, DXFResult.toString());
				}
			}
		} else if (LotteryType.JCZQList.contains(LotteryType.getItem(lotteryTypeValue))) {// 竞彩足球
			// 查出最近三十天的开奖的数据
			Map<String, Integer> timeMap = CommonUtils.getBgTimeAndEdTime(OPEN_DAY);
			Integer bgintTime = timeMap.get(CommonUtils.beginIntTimeKey);
			Integer edintTime = timeMap.get(CommonUtils.endIntTimeKey);
			List<FootBallMatch> matchList = this.footBallService.findMatchListBetweenIntTimes(bgintTime, edintTime);
			List<FootBallMatch> tempmatchList = new ArrayList<FootBallMatch>();
			for (FootBallMatch match : matchList) {//
				if (match.getStatus().intValue() != MatchStatus.ONSALE.ordinal()) {
					tempmatchList.add(match);
				}
			}
			matchList = tempmatchList;
			// 无论是什么玩法，将所需要的参数全部设置进去
			for (FootBallMatch bm : matchList) {
				String tempKey = bm.getIntTime() + "_" + bm.getLineId();
				Integer homeScore = bm.getHomeScore();
				Integer guestScore = bm.getGuestScore();
				Integer halfhomeScore = bm.getHalfHomeScore();
				Integer halfGuestScore = bm.getHalfGuestScore();
				if (bm.getStatus().equals(2)) {//  取消的赛事
					openResultMap.put(CommonUtils.homeScoreKey + tempKey, "-1");
					openResultMap.put(CommonUtils.guestScoreKey + tempKey, "-1");
					openResultMap.put(CommonUtils.resultHalfHomeScore + tempKey, "-1");
					openResultMap.put(CommonUtils.resultHalfGuestScore + tempKey, "-1");
					openResultMap.put(CommonUtils.resultRQSPFKey + tempKey, "1");
					openResultMap.put(CommonUtils.resultSPFKey + tempKey, "1");
					openResultMap.put(CommonUtils.resultBFKey + tempKey, "1");
					openResultMap.put(CommonUtils.resultJQSKey + tempKey, "1");
					openResultMap.put(CommonUtils.resultBQCKey + tempKey, "1");
					openResultMap.put(CommonUtils.CONCEDEKEY + tempKey, "0");
				} else {
					if (homeScore == null || guestScore == null) {
						continue;
					} else {
						String Handicap = "0";
						if (bm.getConcede() != null)
							Handicap = bm.getConcede().toString();// 让球
						Double SPFResult = bm.getResultAwardOfTotoPass() == null ? 0d : bm.getResultAwardOfTotoPass();
						Double RQSPFResult = bm.getResultRQAwardOfTotoPass() == null ? 0d : bm.getResultRQAwardOfTotoPass();
						Double BFResult = bm.getResultAwardOfSingleScore() == null ? 0d : bm.getResultAwardOfSingleScore();
						Double JQSResult = bm.getResultAwardOfScorePass() == null ? 0d : bm.getResultAwardOfScorePass();
						Double BQCResult = bm.getResultAwardOfHfTotoPass() == null ? 0d : bm.getResultAwardOfHfTotoPass();
	
						openResultMap.put(CommonUtils.resultHalfHomeScore + tempKey, halfhomeScore.toString());
						openResultMap.put(CommonUtils.resultHalfGuestScore + tempKey, halfGuestScore.toString());
						openResultMap.put(CommonUtils.CONCEDEKEY + tempKey, Handicap);
						openResultMap.put(CommonUtils.homeScoreKey + tempKey, homeScore.toString());
						openResultMap.put(CommonUtils.guestScoreKey + tempKey, guestScore.toString());
						openResultMap.put(CommonUtils.resultRQSPFKey + tempKey, RQSPFResult.toString());
						openResultMap.put(CommonUtils.resultSPFKey + tempKey, SPFResult.toString());
						openResultMap.put(CommonUtils.resultBFKey + tempKey, BFResult.toString());
						openResultMap.put(CommonUtils.resultJQSKey + tempKey, JQSResult.toString());
						openResultMap.put(CommonUtils.resultBQCKey + tempKey, BQCResult.toString());
					}
				}
			}
		}else if(LotteryType.GYJ_LIST.contains(type)){
			List<GyjFootballMatch> teamList=gyjFootballService.findGyjMatchList(term.getTerm(), type);
			String result=term.getResult();
			if (StringUtils.isEmpty(result)) {
				throw new Exception("开奖结果未录入!");
			}
			String[] datas=result.split("\\-");
			String result2=datas[1]+"-"+datas[0];//冠亚军不分次序 所以有2种结果
					
			Map<String,GyjFootballMatch> teamMap=new HashMap<String, GyjFootballMatch>();
			for (GyjFootballMatch team : teamList) {
				teamMap.put(team.getVsTeam(), team);
			}
			
			//冠亚军不分次序
			if (teamMap.containsKey(result)) {
				openResultMap.put("result", teamMap.get(result).getSeq()+"");
			}else if (teamMap.containsKey(result2)){
				openResultMap.put("result", teamMap.get(result2).getSeq()+"");
			}  else{
				openResultMap.put("result", GyjFootballMatch.OTHER_RESULT+"");//冠亚军为 "其他"
				
			}
			
		}else if(LotteryType.GJ_LIST.contains(type)){
			List<GyjFootballTeam> teamList=gyjFootballService.findTeamListByLotTypeAndTerm(term.getTerm(), type);
			String result=term.getResult().trim();
			if (StringUtils.isEmpty(result)) {
				throw new Exception("开奖结果未录入!");
			}
			Map<String,GyjFootballTeam> teamMap=new HashMap<String, GyjFootballTeam>();
			for (GyjFootballTeam team : teamList) {
				teamMap.put(team.getTeamName(), team);
			}
			if (!teamMap.containsKey(result)) {
				throw new Exception("得奖球队不存在!");
			}else{
				openResultMap.put("result", teamMap.get(result).getSeq()+"");
			}
		}
		if(!LotteryType.GYJ_ZQ_LIST.contains(type) && 
			!LotteryType.JCZQList.contains(LotteryType.getItem(lotteryTypeValue)) && 
			!LotteryType.JCLQList.contains(LotteryType.getItem(lotteryTypeValue)) &&
			!LotteryType.DCZQList.contains(LotteryType.getItem(lotteryTypeValue))) {
			if (term.getResult()==null || term.getResult().equals("")) {
				throw new Exception("开奖结果未录入!");
			}
			
			openResultMap.put("result", term.getResult());
			// 将奖金描述解析成 List<PrizeBean>
			List<PrizeBean> beanList = PrizeCommon.buildToList(type.getValue(), term.getResultDetail());
			if (beanList == null || beanList.size() == 0) {
				throw new Exception("奖金解析失败，请联系管理员!");
			}
			if (term.getResultDetail() == null || term.getResultDetail().equals("")) {
				throw new Exception("开奖奖金未录入!");
			}
			// 奖List<PrizeBean>注入到openResultMap,以供开奖
			for (int i = 0; i < beanList.size(); i++) {
				PrizeBean bean = beanList.get(i);
				openResultMap.put(bean.getPrizeName(), bean.getAmount());
			}
		}
		return openResultMap;
	}

	@SuppressWarnings("unchecked")
	public HashMap getTempResultMapForUpdatePlanPrizeInfo(LotteryTerm term, LotteryType type) throws Exception {
		HashMap<String, String> openResultMap = new HashMap<String, String>();
		openResultMap.put("lotteryType", type.getValue() + "");
		openResultMap.put("term", term.getTerm());
		if ( !LotteryType.JCZQList.contains(type) && !LotteryType.JCLQList.contains(type) && !LotteryType.DCZQList.contains(type)) {
			if (term.getResult() == null || term.getResult().equals("")) {
				throw new Exception("开奖结果未录入!");
			}
			openResultMap.put("result", term.getResult());
			// 将奖金描述解析成 List<PrizeBean>
			List<PrizeBean> beanList = PrizeCommon.buildToList(type.getValue(), term.getResultDetail());
			if (beanList == null || beanList.size() == 0) {
				throw new Exception("奖金解析失败，请联系管理员!");
			}
			if (term.getResultDetail() == null || term.getResultDetail().equals("")) {
				throw new Exception("开奖奖金未录入!");
			}
			// 奖List<PrizeBean>注入到openResultMap,以供开奖
			for (int i = 0; i < beanList.size(); i++) {
				PrizeBean bean = beanList.get(i);
				openResultMap.put(bean.getPrizeName(), bean.getAmount());
			}
		}
		return openResultMap;
	}

}
