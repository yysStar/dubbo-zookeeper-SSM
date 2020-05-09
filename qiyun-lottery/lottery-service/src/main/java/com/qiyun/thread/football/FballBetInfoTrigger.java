package com.qiyun.thread.football;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.httpUtil.WebConstants;
import com.qiyun.lottery.MatchVo;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.PassMode;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model.football.SportteryFootBallBetInfo;
import com.qiyun.service.FootBallService;
import com.qiyun.service.FootballDataService;
import com.qiyun.serviceImpl.VelocityFactory;
import com.qiyun.thread.base.BaseDaemonTaskTrigger;
import com.qiyun.thread.base.DaemonTaskRunnable;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.FileTools;
import com.qiyun.utils.basketball.SportteryGrabberUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public final class FballBetInfoTrigger extends BaseDaemonTaskTrigger {
	private final static String NAME="足球比分生成任务触发器";

	public String getName() {return NAME;}
	private final static Integer SUB_TASK_ID=0;
	@Autowired
	private FootBallService footBallService;
	@Autowired
	private FootballDataService footballDataService;
	@Autowired
	private VelocityFactory velocityFactory;
	
	//private long sleepTime = 600000;
	public void onTrigger() {
		if(subTaskEnable(SUB_TASK_ID)){
			List<FootBallMatch> dbMatchList = this.footBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
			this.execute(SUB_TASK_ID, new FballBetInfoRunnable(dbMatchList));
		}		
		delay(getInterval());
	}
	
	private class FballBetInfoRunnable extends DaemonTaskRunnable {
		private List<FootBallMatch> dbMatchList;
		public FballBetInfoRunnable(List<FootBallMatch> dbMatchList){
			this.dbMatchList=dbMatchList;
		}
		
		@Override
		public void process() {
			buildAwardTzb(dbMatchList,  DateTools.getNowDateYYYY_MM_DD());
			buildHotMatchJs();
		}		
	}

	

	@SuppressWarnings("unchecked")
	private void buildAwardTzb(List<FootBallMatch> dbMatchList, String date) {
		Map<String, SportteryFootBallBetInfo> betInfoMap = new HashMap<String, SportteryFootBallBetInfo>();
		final String BET_COUNT_KEY = "hot_";
		Map<String, String> tzbMap = new HashMap<String, String>();
		int index = 2; // 3天内
		for (int i = index; i >= 0; i--) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(DateTools.stringToDate(date, "yyyy-MM-dd"));
			cal.add(Calendar.DAY_OF_YEAR, -i);
			String tempDate = DateTools.dateToString(cal.getTime(), "yyyy-MM-dd");
			Map<String, String> tempTzbMap = SportteryGrabberUtil.getFootBallAwardTzb(tempDate);
			tzbMap.putAll(tempTzbMap);
		}

		for (FootBallMatch match : dbMatchList) {
			String tempId = "tzb_" + match.getIntTime() + "_" + match.getLineIDText() + "_";
			try {
				List<SportteryFootBallBetInfo> tzbList = footballDataService.findTzbByMatchId(match.getId());

				String homePercent = tzbMap.get(tempId + 0);
				String drawPercent = tzbMap.get(tempId + 1);
				String guestPercent = tzbMap.get(tempId + 2);

				Integer homeBetCount = text2IntegerNoException(tzbMap.get(tempId + BET_COUNT_KEY + 0), 0);
				Integer drawBetCount = text2IntegerNoException(tzbMap.get(tempId + BET_COUNT_KEY + 1), 0);
				Integer guestBetCount = text2IntegerNoException(tzbMap.get(tempId + BET_COUNT_KEY + 2), 0);
				if (homePercent == null || drawPercent == null || guestPercent == null)
					continue;

				SportteryFootBallBetInfo betInfo = new SportteryFootBallBetInfo();
				betInfo.setMatchId(match.getId());
				betInfo.setHomePercent(homePercent);
				betInfo.setDrawPercent(drawPercent);
				betInfo.setGuestPercent(guestPercent);
				betInfo.setHomeBetCount(homeBetCount);
				betInfo.setDrawBetCount(drawBetCount);
				betInfo.setGuestBetCount(guestBetCount);
				betInfo.setTime(new Date());
				if (tzbList.isEmpty()) {
					betInfo.setHomePercentChange(0);
					betInfo.setDrawPercentChange(0);
					betInfo.setGuestPercentChange(0);
					betInfoMap.put(betInfo.getMatchId() + "betInfo", betInfo);
					footballDataService.attachDirty(betInfo);
				} else {
					boolean flag = false;
					SportteryFootBallBetInfo dbBetInfo = tzbList.get(0);
					int homePercentIsChange = getSWchange(text2DoubleNoException(homePercent.replace("%", ""), 0d), text2DoubleNoException(dbBetInfo
							.getHomePercent().replace("%", ""), 0d));
					flag = flag || homePercentIsChange != 0;
					int drawPercentIsChange = getSWchange(text2DoubleNoException(drawPercent.replace("%", ""), 0d), text2DoubleNoException(dbBetInfo
							.getDrawPercent().replace("%", ""), 0d));
					flag = flag || drawPercentIsChange != 0;
					int guestPercentIsChange = getSWchange(text2DoubleNoException(guestPercent.replace("%", ""), 0d), text2DoubleNoException(
							dbBetInfo.getGuestPercent().replace("%", ""), 0d));
					flag = flag || guestPercentIsChange != 0;
					Integer dbHomeCount = dbBetInfo.getHomeBetCount() == null ? 0 : dbBetInfo.getHomeBetCount();
					Integer dbDrawCount = dbBetInfo.getDrawBetCount() == null ? 0 : dbBetInfo.getDrawBetCount();
					Integer dbGuestCount = dbBetInfo.getGuestBetCount() == null ? 0 : dbBetInfo.getGuestBetCount();
					boolean betCountChange = homeBetCount > dbHomeCount;

					betCountChange |= drawBetCount > dbDrawCount;
					betCountChange |= guestBetCount > dbGuestCount;
					if (flag || betCountChange) {
						if (flag) {
							betInfo.setHomePercentChange(homePercentIsChange);
							betInfo.setDrawPercentChange(drawPercentIsChange);
							betInfo.setGuestPercentChange(guestPercentIsChange);
						} else {
							dbBetInfo.setHomeBetCount(homeBetCount);
							dbBetInfo.setDrawBetCount(drawBetCount);
							dbBetInfo.setGuestBetCount(guestBetCount);
							betInfo = dbBetInfo;
						}
						betInfoMap.put(betInfo.getMatchId() + "betInfo", betInfo);
						footballDataService.attachDirty(betInfo);
					}
				}
			} catch (Exception e) {
				LogUtil.error("抓取编号" + match.getShowLineID() + "出错",e);
			}
		}
		JSONObject infoJson = JSONObject.fromObject(betInfoMap);
		try {
			FileTools.setFileContent(infoJson.toString(), WebConstants.getWebPath() + "/static/JCFootBall/betInfo.json");
		} catch (Exception e) {

			LogUtil.error(e);
		}
	}

	
	private void buildHotMatchJs() {
		try{
			final int maxMatchCount=10;
			Map<Object, Object> map = new HashMap<Object, Object>();
			List<FootBallMatch> footBallMatchList = footBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
			Map<Integer, FootBallMatch> matchMap=new HashMap<Integer, FootBallMatch>();
			
			for(FootBallMatch match:footBallMatchList)matchMap.put(match.getId(), match);
			List<Integer> matchIds=new ArrayList<Integer>(matchMap.keySet());
			final Map<Integer, SportteryFootBallBetInfo> betInfoMap = footballDataService.findFootballBetInfoByMatchIds(matchIds);
			Collections.sort(matchIds, new Comparator<Integer>(){
				public int compare(Integer o1, Integer o2) {
					SportteryFootBallBetInfo betInfo1=betInfoMap.get(o1);
					SportteryFootBallBetInfo betInfo2=betInfoMap.get(o2);
					Long betCount1=betInfo1!=null?betInfo1.getAllBetCount():0;
					Long betCount2=betInfo2!=null?betInfo2.getAllBetCount():0;
					if(betCount1==null){
						betCount1=0l;
					}
					if (betCount2==null) {
						betCount2=0l;
					}
					if(betCount1>betCount2){
						return -1;
					}else if(betCount1<betCount2){
						return 1;
					}else{
						return 0;
					}
				}
			});
			Map<Integer, AbstractAward> awardMap=footBallService.findMatchAwardMap(matchIds,
					PassMode.PASS, LotteryType.JC_ZQ_SPF);
			List<MatchVo> voList=new ArrayList<MatchVo>();
			for(int i=0,len=matchIds.size();i<len&&i<maxMatchCount;i++){
				FootBallMatch match=matchMap.get(matchIds.get(i));
				AbstractAward award=awardMap.get(matchIds.get(i));
				SportteryFootBallBetInfo betInfo1=betInfoMap.get(matchIds.get(i));
				Long betCount=betInfo1!=null?betInfo1.getAllBetCount():0;
				MatchVo vo=new MatchVo(match,award,betCount);
				voList.add(vo);
			}
			map.put("matchList", voList);
			String content = velocityFactory.getStaticString("matchJs", map);
			FileTools.setFileContent(content, WebConstants.getWebPath()+"/js/match.js");
		} catch (Exception e) {
			LogUtil.error(e);
		}
	}


	private int getSWchange(Double d1, Double d2) {
		return d1 > d2 ? 1 : d1 < d2 ? -1 : 0;
	}

	private static Double text2DoubleNoException(String textDouble, Double defalutValue) {
		try {
			return Double.valueOf(textDouble);
		} catch (Exception e) {
			return defalutValue;
		}
	}

	private static Integer text2IntegerNoException(String textInteger, Integer defalutValue) {
		try {
			return Integer.valueOf(textInteger);
		} catch (Exception e) {
			return defalutValue;
		}
	}

}
