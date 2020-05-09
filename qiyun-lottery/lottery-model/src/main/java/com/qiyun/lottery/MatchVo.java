package com.qiyun.lottery;

import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model.football.MatchAwardOfSPF;

public class MatchVo {
	private String gameName;
	private String homeName;
	private String guestName;
	private Integer hot;
	private Double homeWinAward;
	private Double guestWinAward;
	private Double drawAward;
	private boolean homeAwardIsUp;
	private boolean drawAwardIsUp;
	private boolean guestAwardIsUp;
	private String endDateString;
	public MatchVo() {
		super();
	}
	public MatchVo(FootBallMatch match, AbstractAward award, Long hot) {
		this.gameName=match.getGameName();
		this.homeName=match.getHomeTeam();
		this.guestName=match.getGuestTeam();
		this.hot=hot.intValue();
		this.homeWinAward=((MatchAwardOfSPF)award).getHomeWinAward();
		this.drawAward=((MatchAwardOfSPF)award).getDrawAward();
		this.guestWinAward=((MatchAwardOfSPF)award).getGuestWinAward();
	}
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getHomeName() {
		return homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Double getHomeWinAward() {
		return homeWinAward;
	}

	public void setHomeWinAward(Double homeWinAward) {
		this.homeWinAward = homeWinAward;
	}

	public Double getGuestWinAward() {
		return guestWinAward;
	}

	public void setGuestWinAward(Double guestWinAward) {
		this.guestWinAward = guestWinAward;
	}

	public Double getDrawAward() {
		return drawAward;
	}
	public void setDrawAward(Double drawAward) {
		this.drawAward = drawAward;
	}
	public boolean isHomeAwardIsUp() {
		return homeAwardIsUp;
	}

	public void setHomeAwardIsUp(boolean homeAwardIsUp) {
		this.homeAwardIsUp = homeAwardIsUp;
	}

	public boolean isDrawAwardIsUp() {
		return drawAwardIsUp;
	}

	public void setDrawAwardIsUp(boolean drawAwardIsUp) {
		this.drawAwardIsUp = drawAwardIsUp;
	}

	public boolean isGuestAwardIsUp() {
		return guestAwardIsUp;
	}

	public void setGuestAwardIsUp(boolean guestAwardIsUp) {
		this.guestAwardIsUp = guestAwardIsUp;
	}
	public String getEndDateString() {
		return endDateString;
	}
	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

}
