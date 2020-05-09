package com.qiyun.model.football;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.football.AbstractGyjFootballTeam;

/**
 * GyjFootballTeam entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class GyjFootballTeam extends AbstractGyjFootballTeam implements java.io.Serializable {
	private  Double sportterySp;

	public Double getSportterySp() {
		return sportterySp;
	}

	public void setSportterySp(Double sportterySp) {
		this.sportterySp = sportterySp;
	}

	/** default constructor */
	public GyjFootballTeam() {
	}

	/** minimal constructor */
	public GyjFootballTeam(String teamName, String teamGroup, Integer isHot, Integer seq, Integer status) {
		super(teamName, teamGroup, isHot, seq, status);
	}

	/** full constructor */
	public GyjFootballTeam(String teamName, String teamGroup, Integer isHot, Integer seq, Integer status, String term,
						   LotteryType lotteryType, String teamId, String pm) {
		super(teamName, teamGroup, isHot, seq, status, term, lotteryType,teamId,pm);
	}
	
	public String getMapKey(){
		return getLotteryType().getValue()+"_"+getSeq();
		
	}
	

}
