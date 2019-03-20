package com.qiyun.model.basketball;

public class BasketBallTeam {
	private Integer id;
	private String fullTeamName;
	private String shortTeamName;
	private String mark;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullTeamName() {
		return fullTeamName;
	}

	public void setFullTeamName(String fullTeamName) {
		this.fullTeamName = fullTeamName;
	}

	public String getShortTeamName() {
		return shortTeamName;
	}

	public void setShortTeamName(String shortTeamName) {
		this.shortTeamName = shortTeamName;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
