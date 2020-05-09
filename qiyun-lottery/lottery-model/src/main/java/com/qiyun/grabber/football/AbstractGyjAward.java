package com.qiyun.grabber.football;

/**
 * AbstractGyjAward entity provides the base persistence definition of the
 * GyjAward entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractGyjAward implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer teamId;
	private String history;
	private Double sportteryAward;
	private Double riboAward;
	private Double liboAward;
	private Double weilianAward;
	private Double aomenAward;
	private Double tenbetAward;
	private String teamName;

	// Constructors

	/** default constructor */
	public AbstractGyjAward() {
	}

	/** minimal constructor */
	public AbstractGyjAward(Integer teamId, String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}

	/** full constructor */
	public AbstractGyjAward(Integer teamId, String history, Double sportteryAward, Double riboAward, Double liboAward, Double weilianAward, Double aomenAward,
			Double tenbetAward, String teamName) {
		this.teamId = teamId;
		this.history = history;
		this.sportteryAward = sportteryAward;
		this.riboAward = riboAward;
		this.liboAward = liboAward;
		this.weilianAward = weilianAward;
		this.aomenAward = aomenAward;
		this.tenbetAward = tenbetAward;
		this.teamName = teamName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getHistory() {
		return this.history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Double getSportteryAward() {
		return this.sportteryAward;
	}

	public void setSportteryAward(Double sportteryAward) {
		this.sportteryAward = sportteryAward;
	}

	public Double getRiboAward() {
		return this.riboAward;
	}

	public void setRiboAward(Double riboAward) {
		this.riboAward = riboAward;
	}

	public Double getLiboAward() {
		return this.liboAward;
	}

	public void setLiboAward(Double liboAward) {
		this.liboAward = liboAward;
	}

	public Double getWeilianAward() {
		return this.weilianAward;
	}

	public void setWeilianAward(Double weilianAward) {
		this.weilianAward = weilianAward;
	}

	public Double getAomenAward() {
		return this.aomenAward;
	}

	public void setAomenAward(Double aomenAward) {
		this.aomenAward = aomenAward;
	}

	public Double getTenbetAward() {
		return this.tenbetAward;
	}

	public void setTenbetAward(Double tenbetAward) {
		this.tenbetAward = tenbetAward;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}