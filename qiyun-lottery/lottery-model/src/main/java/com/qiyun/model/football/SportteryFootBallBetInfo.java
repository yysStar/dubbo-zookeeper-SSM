package com.qiyun.model.football;

import com.qiyun.chaiPiao.OddsTool;
import com.qiyun.grabber.football.FootballOp;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.util.LogUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SportteryFootBallBetInfo {

	private Integer id;
	private Integer matchId;
	private String homePercent;
	private Integer homePercentChange;
	private String drawPercent;
	private Integer drawPercentChange;
	private String guestPercent;
	private Integer guestPercentChange;
	private Integer homeBetCount;
	private Integer drawBetCount;
	private Integer guestBetCount;
	private Date time;

	public SportteryFootBallBetInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SportteryFootBallBetInfo(Integer id, Integer matchId, String homePercent, Integer homePercentChange, String drawPercent,
			Integer drawPercentChange, String guestPercent, Integer guestPercentChange, Integer homeBetCount, Integer drawBetCount,
			Integer guestBetCount, Date time) {
		super();
		this.id = id;
		this.matchId = matchId;
		this.homePercent = homePercent;
		this.homePercentChange = homePercentChange;
		this.drawPercent = drawPercent;
		this.drawPercentChange = drawPercentChange;
		this.guestPercent = guestPercent;
		this.guestPercentChange = guestPercentChange;
		this.homeBetCount = homeBetCount;
		this.drawBetCount = drawBetCount;
		this.guestBetCount = guestBetCount;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public String getHomePercent() {
		return homePercent;
	}

	public void setHomePercent(String homePercent) {
		this.homePercent = homePercent;
	}

	public Integer getHomePercentChange() {
		return homePercentChange;
	}

	public void setHomePercentChange(Integer homePercentChange) {
		this.homePercentChange = homePercentChange;
	}

	public String getDrawPercent() {
		return drawPercent;
	}

	public void setDrawPercent(String drawPercent) {
		this.drawPercent = drawPercent;
	}

	public Integer getDrawPercentChange() {
		return drawPercentChange;
	}

	public void setDrawPercentChange(Integer drawPercentChange) {
		this.drawPercentChange = drawPercentChange;
	}

	public String getGuestPercent() {
		return guestPercent;
	}

	public void setGuestPercent(String guestPercent) {
		this.guestPercent = guestPercent;
	}

	public Integer getGuestPercentChange() {
		return guestPercentChange;
	}

	public void setGuestPercentChange(Integer guestPercentChange) {
		this.guestPercentChange = guestPercentChange;
	}

	public Integer getHomeBetCount() {
		return homeBetCount;
	}

	public void setHomeBetCount(Integer homeBetCount) {
		this.homeBetCount = homeBetCount;
	}

	public Integer getDrawBetCount() {
		return drawBetCount;
	}

	public void setDrawBetCount(Integer drawBetCount) {
		this.drawBetCount = drawBetCount;
	}

	public Integer getGuestBetCount() {
		return guestBetCount;
	}

	public void setGuestBetCount(Integer guestBetCount) {
		this.guestBetCount = guestBetCount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getAllBetCount() {
		if (this.getDrawBetCount() == null || this.getGuestBetCount() == null || this.getHomeBetCount() == null) {
			return 0l;
		}
		return (long) (this.getDrawBetCount() + this.getGuestBetCount() + this.getHomeBetCount());
	}
	public Integer[] getBetCounts(){
		Integer[] betCounts=new Integer[3];
		betCounts[0]=this.getHomeBetCount();
		betCounts[1]=this.getDrawBetCount();
		betCounts[2]=this.getGuestBetCount();
		return betCounts;
		
	}
	/**
	 * 获取胜平负返还率
	 * 
	 * @param spfAward
	 *            胜平负奖金数组 顺序：胜，平，负
	 * @return 返还率数组 顺序：胜平负
	 */
	public Map<String, String> getReturnPrecent(MatchAwardOfSPF spfAward) {
		Map<String, String> returnPercentMap = new HashMap<String, String>();
		try {
			Double homePercent = Double.valueOf(this.getHomePercent().replace("%", ""));
			Double drawPercent = Double.valueOf(this.getDrawPercent().replace("%", ""));
			Double guestPercent = Double.valueOf(this.getGuestPercent().replace("%", ""));
			returnPercentMap.put(this.getMatchId() + "_hp", OddsTool.getSpfReturnPercent(spfAward.getHomeWinAward(), homePercent) + "%");
			returnPercentMap.put(this.getMatchId() + "_dp", OddsTool.getSpfReturnPercent(spfAward.getDrawAward(), drawPercent) + "%");
			returnPercentMap.put(this.getMatchId() + "_gp", OddsTool.getSpfReturnPercent(spfAward.getGuestWinAward(), guestPercent) + "%");
			return returnPercentMap;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 获取胜平负返还率
	 * 
	 * @param op
	 *            胜平负奖金数组 顺序：胜，平，负
	 * @return 返还率
	 */
	public Map<String, String> getReturnPrecent(FootballOp op) {
		Map<String, String> returnPercentMap = new HashMap<String, String>();
		try {
			Double homePercent = Double.valueOf(this.getHomePercent().replace("%", ""));
			Double drawPercent = Double.valueOf(this.getDrawPercent().replace("%", ""));
			Double guestPercent = Double.valueOf(this.getGuestPercent().replace("%", ""));
			returnPercentMap.put(this.getMatchId() + "_hp", OddsTool.getSpfReturnPercent(op.getHome(), homePercent) + "%");
			returnPercentMap.put(this.getMatchId() + "_dp", OddsTool.getSpfReturnPercent(op.getDraw(), drawPercent) + "%");
			returnPercentMap.put(this.getMatchId() + "_gp", OddsTool.getSpfReturnPercent(op.getGuest(), guestPercent) + "%");
			return returnPercentMap;
		} catch (Exception e) {
			LogUtil.error(e);
		}
		return null;
	}
	public static Map<String, String> getReturnPrecent(Map<Integer, SportteryFootBallBetInfo> betInfoMap,
													   Map<Integer, AbstractAward> awardMap) {
		Map<String, String> returnPercentMap = new HashMap<String, String>();
		for (Integer matchId : betInfoMap.keySet()) {
			SportteryFootBallBetInfo betInfo = betInfoMap.get(matchId);
			if (betInfo != null) {
				Map<String, String> tempMap=betInfo.getReturnPrecent((MatchAwardOfSPF) awardMap.get(matchId));
				if(tempMap!=null)
				returnPercentMap.putAll(tempMap);
			}
		}
		return returnPercentMap;
	}
	public static Map<String, String> getReturnPrecentByOp(Map<Integer, SportteryFootBallBetInfo> betInfoMap, Map<Integer, FootballOp> opMap) {
		Map<String, String> returnPercentMap = new HashMap<String, String>();
		for (Integer matchId : betInfoMap.keySet()) {
			SportteryFootBallBetInfo betInfo = betInfoMap.get(matchId);
			if (betInfo != null) {
				Map<String, String> tempMap=betInfo.getReturnPrecent(opMap.get(matchId));
				if(tempMap!=null)
				returnPercentMap.putAll(tempMap);
			}
		}
		return returnPercentMap;
	}
	public static Map<String, String> getReturnPrecent(Map<Integer, AbstractAward> spfAwardMap) {
		
		Map<String, String> returnPercentMap = new HashMap<String, String>();
		if(spfAwardMap!=null){
			for (Integer matchId : spfAwardMap.keySet()) {
				Map<String, String> betAwardMap = SportteryFootballBetPercent.getBetPrecent((MatchAwardOfSPF) spfAwardMap.get(matchId));
				returnPercentMap.putAll(betAwardMap);
			}
		}
		return returnPercentMap;
	}
}
