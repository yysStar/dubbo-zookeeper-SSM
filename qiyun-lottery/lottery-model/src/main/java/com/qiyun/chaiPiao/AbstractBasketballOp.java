package com.qiyun.chaiPiao;

import java.util.Date;

public abstract class AbstractBasketballOp implements java.io.Serializable {

	// Fields

	private Integer id;

	private Integer matchId;
	
	private String company;
	
	private Double home;

	private Integer homeChange=0;

	private Double guest;

	private Integer guestChange=0;

	private Integer isFirst;

	private Date time;

	// Constructors

	/** default constructor */
	public AbstractBasketballOp() {
	}

	/** minimal constructor */
	public AbstractBasketballOp(Integer matchId) {
		this.matchId = matchId;
	}

	/** full constructor */
	public AbstractBasketballOp(Integer matchId, Double home, Integer homeChange, Double guest, Integer guestChange, Integer isFirst, Date time) {
		this.matchId = matchId;
		this.home = home;
		this.homeChange = homeChange;
		this.guest = guest;
		this.guestChange = guestChange;
		this.isFirst = isFirst;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Double getHome() {
		return this.home;
	}

	public void setHome(Double home) {
		this.home = home;
	}

	public Integer getHomeChange() {
		return this.homeChange;
	}

	public void setHomeChange(Integer homeChange) {
		this.homeChange = homeChange;
	}

	public Double getGuest() {
		return this.guest;
	}

	public void setGuest(Double guest) {
		this.guest = guest;
	}

	public Integer getGuestChange() {
		return this.guestChange;
	}

	public void setGuestChange(Integer guestChange) {
		this.guestChange = guestChange;
	}

	public Integer getIsFirst() {
		return this.isFirst;
	}

	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}