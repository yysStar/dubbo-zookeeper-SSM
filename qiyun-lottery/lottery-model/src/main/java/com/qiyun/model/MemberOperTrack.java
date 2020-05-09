package com.qiyun.model;

import com.qiyun.grabber.model.AbstractMemberOperTrack;

import java.util.Date;

import com.qiyun.commonModel.LotteryType;


// Generated by MyEclipse Persistence Tools


/**
 * MemberOperTrack generated by MyEclipse Persistence Tools
 */
public class MemberOperTrack extends AbstractMemberOperTrack implements java.io.Serializable,Cloneable{

	// Constructors
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public MemberOperTrack() {
	}
	
	public MemberOperTrack(MemberOperType memberOperType,Platform platform,String account,LotteryType lotteryType,String terminalId){
		super(memberOperType, platform, account, lotteryType, terminalId);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		MemberOperTrack cloned = (MemberOperTrack) super.clone();  
		cloned.setPlatform(getPlatform());
		cloned.setOperType(getOperType());
		cloned.setLotteryType(getLotteryType());
		cloned.setCreateDateTime(new Date());
		return cloned;
	}
	
	public MemberOperTrack getClone(){
		MemberOperTrack clone = null;
		try {
			clone = (MemberOperTrack) this.clone();
		} catch (CloneNotSupportedException e) {
			clone = new MemberOperTrack();
			clone.setPlatform(getPlatform());
			clone.setOperType(getOperType());
			clone.setLotteryType(getLotteryType());
			clone.setCreateDateTime(new Date());
		}
		return clone;
	}
	
}
