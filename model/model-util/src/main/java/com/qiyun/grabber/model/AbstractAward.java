package com.qiyun.grabber.model;

import com.qiyun.item.OptionItem;

import java.io.Serializable;
import java.util.Date;


public abstract class AbstractAward implements Serializable {

	private static final long serialVersionUID = 1290310498203448683L;
	/** ID值* */
	private Integer id;
	/** 对阵ID* */
	private Integer matchId;
	/** 比赛时间的整形类型* */
	private Integer intTime;
	/** 比赛时间的lineId* */
	private Integer lineId;
	/** 比赛时间* */
	private Date matchTime;
	/** 过关方式的下标* */
	private Integer passMode;
	/** 主队名（用作比较不保存）**/
	private String homeTeam;
	
	private Date lastUpdateTime;
	
	private Date createDate;

	public Integer getIntTime() {
		return intTime;
	}

	public void setIntTime(Integer intTime) {
		this.intTime = intTime;
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public Integer getPassMode() {
		return passMode;
	}

	public void setPassMode(Integer passMode) {
		this.passMode = passMode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public abstract void setAwardArr(Double[] awardArr);

	public abstract Double[] getAwardArr();

	public abstract double getAward(String optionsValue);
	
	public Double getAwardByOption(OptionItem option) {
		Double award = null;
		try {
			award = getAwardArr()[option.getOrdinal()];
		} catch (Exception e) {
		}
		return award;
	}
	
	public boolean checkAwardIsChange(AbstractAward award){
		if(award==null){
			return false;
		}
		Double[] awardArr=award.getAwardArr();
		Double[] thisAwardArr=getAwardArr();
		if(thisAwardArr.length!=awardArr.length){
			throw new RuntimeException("数组长度错误，不能比较");
		}
		for(int i=0;i<thisAwardArr.length;i++){
			if(!thisAwardArr[i].equals(0)&&awardArr[i].equals(0d)){
				return false;
			}else if(!thisAwardArr[i].equals(awardArr[i])){
				return true;
			}
		}
		return false;
	}

	public Date getCreateDate() {
		if(createDate==null){
			createDate=getLastUpdateTime();
		}
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
