package com.qiyun.grabber.football;

import com.qiyun.commonModel.LotteryType;

/**
 * AbstractSfpArrange generated by MyEclipse Persistence Tools
 */

public abstract class AbstractSfpArrange implements java.io.Serializable {

	// Fields

	private Integer id;
	// 彩种
	private LotteryType lotteryType;
	private String term;
	private String homeTeam;
	private String awaryTeam;
	private String matchName;
	private String matchDateTime;
	private Integer seq;
	private Integer outId;
	// Constructors

	/** default constructor */
	public AbstractSfpArrange() {
	}

	/** minimal constructor */
	public AbstractSfpArrange(Integer id, LotteryType lotteryType, String term) {
		this.id = id;
		this.term = term;
	}

	/** full constructor */
	public AbstractSfpArrange(Integer id, LotteryType lotteryType, String term, String homeTeam, String awaryTream, String matchName,
			String matchDateTime, Integer seq) {
		this.id = id;
		this.lotteryType = lotteryType;
		this.term = term;
		this.homeTeam = homeTeam;
		this.awaryTeam = awaryTream;
		this.matchName = matchName;
		this.matchDateTime = matchDateTime;
		this.seq = seq;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getHomeTeam() {
		return this.homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwaryTeam() {
		return this.awaryTeam;
	}

	public void setAwaryTeam(String awaryTream) {
		this.awaryTeam = awaryTream;
	}

	public String getMatchName() {
		return this.matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getMatchDateTime() {
		return this.matchDateTime;
	}

	public void setMatchDateTime(String matchDateTime) {
		this.matchDateTime = matchDateTime;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getOutId() {
		return outId;
	}

	public void setOutId(Integer outId) {
		this.outId = outId;
	}

}