package com.qiyun.model.basketball;

import com.qiyun.chaiPiao.OddsTool;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 篮彩投注比-》胜负 让分胜负 大小球
 * 
 * @author zjf
 * 
 */
public class BasketballTzb implements java.io.Serializable {

	private static final long serialVersionUID = -384406459855349574L;

	private Integer id;

	private Integer matchId;

	private String home;

	private Integer homeChange;

	private String guest;

	private Integer guestChange;

	private Date time;

	private LotteryType lotteryType;

	private Integer betCount;

	public BasketballTzb() {
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public Integer getGuestChange() {
		return guestChange;
	}

	public void setGuestChange(Integer guestChange) {
		this.guestChange = guestChange;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public Integer getHomeChange() {
		return homeChange;
	}

	public void setHomeChange(Integer homeChange) {
		this.homeChange = homeChange;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Integer getBetCount() {
		return betCount;
	}

	public void setBetCount(Integer betCount) {
		this.betCount = betCount;
	}

	/**
	 * 获取胜平负返还率
	 * 
	 * @param spfAward
	 *            胜平负奖金数组 顺序：胜，平，负
	 * @return 返还率数组 顺序：胜平负
	 */
	public Map<String, String> getReturnPrecent(SFAward spfAward) {
		Map<String, String> returnPercentMap = new HashMap<String, String>();
		try {
			Double homePercent = Double.valueOf(this.getHome().replace("%", ""));
			Double guestPercent = Double.valueOf(this.getGuest().replace("%", ""));
			returnPercentMap.put(this.getMatchId() + "_hp", OddsTool.getSpfReturnPercent(spfAward.getWinOrBigAward(), homePercent) + "%");
			returnPercentMap.put(this.getMatchId() + "_gp", OddsTool.getSpfReturnPercent(spfAward.getLoseOrSmallAward(), guestPercent) + "%");
			return returnPercentMap;
		} catch (Exception e) {
			return null;
		}
	}

	public static Map<String, String> getReturnPrecent(Map<Integer, BasketballTzb> betInfoMap,
													   Map<Integer, AbstractAward> awardMap) {
		Map<String, String> returnPercentMap = new HashMap<String, String>();
		for (Integer matchId : betInfoMap.keySet()) {
			BasketballTzb betInfo = betInfoMap.get(matchId);
			SFAward sfAward = (SFAward) awardMap.get(matchId);
			if (betInfo != null && sfAward != null) {
				returnPercentMap.putAll(betInfo.getReturnPrecent(sfAward));
			}
		}
		return returnPercentMap;
	}
}
