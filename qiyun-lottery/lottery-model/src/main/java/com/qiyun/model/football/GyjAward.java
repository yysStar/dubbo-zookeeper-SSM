package com.qiyun.model.football;

import com.qiyun.grabber.football.AbstractGyjAward;

/**
 * GyjAward entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class GyjAward extends AbstractGyjAward implements java.io.Serializable {

	// Constructors
	public int isHot;
	public String teamGroup;

	/** default constructor */
	public GyjAward() {
	}

	/** minimal constructor */
	public GyjAward(Integer teamId, String teamName) {
		super(teamId, teamName);
	}

	/** full constructor */
	public GyjAward(Integer teamId, String history, Double sportteryAward, Double riboAward, Double liboAward, Double weilianAward,
			Double aomenAward, Double tenbetAward, String teamName) {
		super(teamId, history, sportteryAward, riboAward, liboAward, weilianAward, aomenAward, tenbetAward, teamName);
	}

	public int getIsHot() {
		return isHot;
	}

	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}

	public String getTeamGroup() {
		return teamGroup;
	}

	public void setTeamGroup(String teamGroup) {
		this.teamGroup = teamGroup;
	}

}
