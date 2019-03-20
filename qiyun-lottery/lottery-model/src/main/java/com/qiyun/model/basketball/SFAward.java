package com.qiyun.model.basketball;

import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.util.NumberTools;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SFAward extends AbstractAward {

	private static final long serialVersionUID = -2669391498938073804L;
	private Double winOrBigAward;
	private Double loseOrSmallAward;
	private Integer winOrBigChange;
	private Integer loseOrSmallChange;
	/** 让分基数过关* */
	private Double handicap;
	private Integer handicapChange;
	private Date handUpdateTime;
	/** 大小分基数过关* */
	private Double baseBigOrSmall;
	private Integer bsChange;
	private Date bsUpdateTime;
	// 玩法枚举的下标
	private Integer playType;
	
	public SFAward(){
		this.playType=playType;
	}
	public SFAward(Integer playType){
		this.playType=playType;
	}
	public SFAward(Integer playType,Double handicap,Double baseBigOrSmall){
		this.playType=playType;
		this.handicap=handicap;
		this.baseBigOrSmall=baseBigOrSmall;
	}

	public Double getWinOrBigAward() {
		return winOrBigAward;
	}

	public void setWinOrBigAward(Double winOrBigAward) {
		this.winOrBigAward = winOrBigAward;
	}

	public Double getLoseOrSmallAward() {
		return loseOrSmallAward;
	}

	public void setLoseOrSmallAward(Double loseOrSmallAward) {
		this.loseOrSmallAward = loseOrSmallAward;
	}

	public double getAward(String optionsValue) {
		if("3".equals(optionsValue)) {
			return winOrBigAward;
		} else if("0".equals(optionsValue)) {
			return loseOrSmallAward;
		}
		return 0.0;
	}
	
	public Integer getPlayType() {
		return playType;
	}

	public void setPlayType(Integer playType) {
		this.playType = playType;
	}

	public Double getHandicap() {
		return handicap;
	}

	public void setHandicap(Double handicap) {
		this.handicap = handicap;
	}

	public Integer getHandicapChange() {
		return handicapChange;
	}

	public void setHandicapChange(Integer handicapChange) {
		this.handicapChange = handicapChange;
	}

	public Integer getLoseOrSmallChange() {
		return loseOrSmallChange;
	}

	public void setLoseOrSmallChange(Integer loseOrSmallChange) {
		this.loseOrSmallChange = loseOrSmallChange;
	}

	public Integer getWinOrBigChange() {
		return winOrBigChange;
	}

	public void setWinOrBigChange(Integer winOrBigChange) {
		this.winOrBigChange = winOrBigChange;
	}

	public Date getHandUpdateTime() {
		return handUpdateTime;
	}

	public void setHandUpdateTime(Date handUpdateTime) {
		this.handUpdateTime = handUpdateTime;
	}

	public Double getBaseBigOrSmall() {
		return baseBigOrSmall;
	}

	public void setBaseBigOrSmall(Double baseBigOrSmall) {
		this.baseBigOrSmall = baseBigOrSmall;
	}

	public Integer getBsChange() {
		return bsChange;
	}

	public void setBsChange(Integer bsChange) {
		this.bsChange = bsChange;
	}

	public Date getBsUpdateTime() {
		return bsUpdateTime;
	}

	public void setBsUpdateTime(Date bsUpdateTime) {
		this.bsUpdateTime = bsUpdateTime;
	}

	public String getHandicapDeal() {
		if (handicap == null) {
			return null;
		} else if (handicap > 0) {
			return "+" + handicap;
		} else {
			return handicap + "";
		}
	}

	@Override
	public Double[] getAwardArr() {
		Double[] awards = { winOrBigAward, loseOrSmallAward };
		return awards;
	}

	@Override
	public void setAwardArr(Double[] awardArr) {
		Double tempWinOrBigAward = awardArr[0] == null ? 0.00 : awardArr[0];
		Double tempLoserOrSmallAward = awardArr[1] == null ? 0.00 : awardArr[1];
		this.setWinOrBigAward(tempWinOrBigAward);
		this.setLoseOrSmallAward(tempLoserOrSmallAward);
	}

	public String getWinOrBigTzb() {
		if (winOrBigAward == null) {
			return null;
		} else {
			return getTzb(winOrBigAward);
		}
	}

	public String getLoseOrSmallTzb() {
		if (loseOrSmallAward == null) {
			return null;
		} else {
			return getTzb(loseOrSmallAward);
		}
	}

	public String getTzb(Double tempAward) {
		Double tz = 0.0;
		if (tempAward >= 2) {
			tz = 1.36 / tempAward;
		} else if (tempAward < 2 && tempAward > 0) {
			tz = (1 - 1.36) / tempAward;
		}
		return NumberTools.doubleToPercent(tz, "0.0%");
	}

	public Map<String, String> getTzbJsonMap() {
		Map<String, String> jsonMap = new HashMap<String, String>();
		String[] tzbArr = { getWinOrBigTzb(), getLoseOrSmallTzb() };
		for (int i = 0; i < tzbArr.length; i++) {
			jsonMap.put("tzb_" + getIntTime() + "_" + getLineId() + "_" + i, tzbArr[i]);
		}
		return jsonMap;
	}

	public Map<String, String> getJsonMap() {
		Map<String, String> jsonMap = new HashMap<String, String>();
		Double[] awards = getAwardArr();
		Integer[] awardC = { getWinOrBigChange(), getLoseOrSmallChange() };
		for (int i = 0; i < awards.length; i++) {
			jsonMap.put("award_" + getIntTime() + "_" + getLineId() + "_" + i, awards[i] + "");
			jsonMap.put("award_" + getIntTime() + "_" + getLineId() + "_" + i + "C", awardC[i] + "");
		}
		if (getPassMode() == 1 && getPlayType() == 2) {
			jsonMap.put(getIntTime() + "_" + getLineId() + "_handicap", getHandicap().toString());
			jsonMap.put(getIntTime() + "_" + getLineId() + "_handicapC", getHandicapChange().toString());
		}
		if (getPassMode() == 1 && getPlayType() == 3) {
			jsonMap.put(getIntTime() + "_" + getLineId() + "_baseBigOrSmall", getBaseBigOrSmall().toString());
			jsonMap.put(getIntTime() + "_" + getLineId() + "_baseBigOrSmallC", getBsChange().toString());
		}
		return jsonMap;
	}
}
