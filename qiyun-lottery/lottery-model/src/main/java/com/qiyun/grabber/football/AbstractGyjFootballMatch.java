package com.qiyun.grabber.football;

import com.qiyun.commonModel.LotteryType;

/**
 * AbstractGyjFootballMatch entity provides the base persistence definition of
 * the GyjFootballMatch entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractGyjFootballMatch implements java.io.Serializable {

	// Fields

	private Integer id;
	private String gjTeam;
	private String yjTeam;
	private Integer status;
	private String term;
	private Integer seq;
	private LotteryType lotteryType;
	private Double award;

	// Constructors

	/** default constructor */
	public AbstractGyjFootballMatch() {
	}

	/** full constructor */
	public AbstractGyjFootballMatch(String gjTeam, String yjTeam, Integer status, String term, Integer seq, LotteryType lotteryType,Double award) {
		this.gjTeam = gjTeam;
		this.yjTeam = yjTeam;
		this.status = status;
		this.term = term;
		this.seq = seq;
		this.lotteryType = lotteryType;
		this.award=award;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGjTeam() {
		return this.gjTeam;
	}

	public void setGjTeam(String gjTeam) {
		this.gjTeam = gjTeam;
	}

	public String getYjTeam() {
		return this.yjTeam;
	}

	public void setYjTeam(String yjTeam) {
		this.yjTeam = yjTeam;
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

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public LotteryType getLotteryType() {
		return this.lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Double getAward() {
		return award;
	}

	public void setAward(Double award) {
		this.award = award;
	}

}