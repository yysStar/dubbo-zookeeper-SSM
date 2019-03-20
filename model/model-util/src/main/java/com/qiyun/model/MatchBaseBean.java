package com.qiyun.model;

import java.util.Date;

/**
 * 
 * 资料库bean 用于封装500w数据
 *
 */
public class MatchBaseBean {
	
	private Integer id;

	private String matchName;

	private String home;

	private Integer homeId;

	private String guest;

	private Integer guestId;

	private Date matchTime;

	private String matchDateStr;

	private String bfHalf;

	private String bfWhole;

	private String analysisId;

	private String oddId;
	
	private Integer gameId;
	
	private String gameColor;
	
	private String homePm;
	
	private String guestPm;
	
	private String matchKey;
	private String status;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public Integer getHomeId() {
		return homeId;
	}

	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public String getMatchDateStr() {
		return matchDateStr;
	}

	public void setMatchDateStr(String matchDateStr) {
		this.matchDateStr = matchDateStr;
	}

	public String getBfHalf() {
		return bfHalf;
	}

	public void setBfHalf(String bfHalf) {
		this.bfHalf = bfHalf;
	}

	public String getBfWhole() {
		return bfWhole;
	}

	public void setBfWhole(String bfWhole) {
		this.bfWhole = bfWhole;
	}

	public String getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(String analysisId) {
		this.analysisId = analysisId;
	}

	public String getOddId() {
		return oddId;
	}

	public void setOddId(String oddId) {
		this.oddId = oddId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameColor() {
		return gameColor;
	}

	public void setGameColor(String gameColor) {
		this.gameColor = gameColor;
	}

	public String getHomePm() {
		return homePm;
	}

	public void setHomePm(String homePm) {
		this.homePm = homePm;
	}

	public String getGuestPm() {
		return guestPm;
	}

	public void setGuestPm(String guestPm) {
		this.guestPm = guestPm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMatchKey() {
		return matchKey;
	}

	public void setMatchKey(String matchKey) {
		this.matchKey = matchKey;
	}
	public String getMatchScoreVerification(){
		return bfHalf+"_"+bfWhole;
	}
}
