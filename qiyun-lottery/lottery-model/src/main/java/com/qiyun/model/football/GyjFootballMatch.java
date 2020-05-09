package com.qiyun.model.football;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.football.AbstractGyjFootballMatch;

/**
 * GyjFootballMatch entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class GyjFootballMatch extends AbstractGyjFootballMatch implements java.io.Serializable {
	
	public static final Integer OTHER_RESULT=50;//冠亚军结果为"其他"的ID号 

	// Constructors

	/** default constructor */
	public GyjFootballMatch() {
	}

	/** full constructor */
	public GyjFootballMatch(String gjTeam, String yjTeam, Integer status, String term, Integer seq,
							LotteryType lotteryType, Double award) {
		super(gjTeam, yjTeam, status, term, seq, lotteryType, award);
	}

	private Integer gyImgId;
	private Integer yjImgId;
	private String  vsTeam;//和开奖结果一直 冠军-亚军

	public String getVsTeam() {
		String str=getGjTeam()+"-"+getYjTeam();
		if(getSeq().intValue()==OTHER_RESULT.intValue()){
			str="其他";
		}
		return str;
	}


	public Integer getGyImgId() {
		return gyImgId;
	}

	public void setGyImgId(Integer gyImgId) {
		this.gyImgId = gyImgId;
	}

	public Integer getYjImgId() {
		return yjImgId;
	}

	public void setYjImgId(Integer yjImgId) {
		this.yjImgId = yjImgId;
	}
	

}
