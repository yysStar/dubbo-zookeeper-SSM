package com.qiyun.grabber.football;

import com.qiyun.commonModel.LotteryType;

/**
 * AbstractGyjFootballTeam entity provides the base persistence definition of
 * the GyjFootballTeam entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractGyjFootballTeam implements java.io.Serializable {

	// Fields

	private Integer id;
	private String teamName;
	private String teamGroup;
	private Integer isHot;
	private Integer seq;
	private String teamId;
	private Integer status;//GyjTeamStatus
	private String term;
	private LotteryType lotteryType;
	private String pm;

	// Constructors

	/** default constructor */
	public AbstractGyjFootballTeam() {
	}

	/** minimal constructor */
	public AbstractGyjFootballTeam(String teamName, String teamGroup, Integer isHot, Integer seq, Integer status) {
		this.teamName = teamName;
		this.teamGroup = teamGroup;
		this.isHot = isHot;
		this.seq = seq;
		this.status = status;
	}

	/** full constructor */
	public AbstractGyjFootballTeam(String teamName, String teamGroup, Integer isHot, Integer seq, Integer status, String term, LotteryType lotteryType,String teamId,String pm) {
		this.teamName = teamName;
		this.teamGroup = teamGroup;
		this.isHot = isHot;
		this.seq = seq;
		this.status = status;
		this.term = term;
		this.lotteryType = lotteryType;
		this.teamId=teamId;
		this.pm=pm;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamGroup() {
		return this.teamGroup;
	}

	public void setTeamGroup(String teamGroup) {
		this.teamGroup = teamGroup;
	}

	public Integer getIsHot() {
		return this.isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public LotteryType getLotteryType() {
		return this.lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}



}