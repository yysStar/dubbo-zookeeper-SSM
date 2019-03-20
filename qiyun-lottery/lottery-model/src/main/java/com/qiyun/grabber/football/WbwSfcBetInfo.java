package com.qiyun.grabber.football;

public class WbwSfcBetInfo {
	private Integer id;
	private Integer matchId;
	private String term;
	private String boutIndex;
	//胜负彩投注比例
	private Integer sfcWinBetRate;
	private Integer sfcDrawBetRate;
	private Integer sfcLoseBetRate;
	//任9投注比例
	private Integer r9WinBetRate;
	private Integer r9DrawBetRate;
	private Integer r9LoseBetRate;
	//任9定胆比例
	private Integer winConfidence;
	private Integer drawConfidence;
	private Integer loseConfidence;
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
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getBoutIndex() {
		return boutIndex;
	}
	public void setBoutIndex(String boutIndex) {
		this.boutIndex = boutIndex;
	}
	public Integer getSfcWinBetRate() {
		return sfcWinBetRate;
	}
	public void setSfcWinBetRate(Integer sfcWinBetRate) {
		this.sfcWinBetRate = sfcWinBetRate;
	}
	public Integer getSfcDrawBetRate() {
		return sfcDrawBetRate;
	}
	public void setSfcDrawBetRate(Integer sfcDrawBetRate) {
		this.sfcDrawBetRate = sfcDrawBetRate;
	}
	public Integer getSfcLoseBetRate() {
		return sfcLoseBetRate;
	}
	public void setSfcLoseBetRate(Integer sfcLoseBetRate) {
		this.sfcLoseBetRate = sfcLoseBetRate;
	}
	public Integer getR9WinBetRate() {
		return r9WinBetRate;
	}
	public void setR9WinBetRate(Integer winBetRate) {
		r9WinBetRate = winBetRate;
	}
	public Integer getR9DrawBetRate() {
		return r9DrawBetRate;
	}
	public void setR9DrawBetRate(Integer drawBetRate) {
		r9DrawBetRate = drawBetRate;
	}
	public Integer getR9LoseBetRate() {
		return r9LoseBetRate;
	}
	public void setR9LoseBetRate(Integer loseBetRate) {
		r9LoseBetRate = loseBetRate;
	}
	public Integer getWinConfidence() {
		return winConfidence;
	}
	public void setWinConfidence(Integer winConfidence) {
		this.winConfidence = winConfidence;
	}
	public Integer getDrawConfidence() {
		return drawConfidence;
	}
	public void setDrawConfidence(Integer drawConfidence) {
		this.drawConfidence = drawConfidence;
	}
	public Integer getLoseConfidence() {
		return loseConfidence;
	}
	public void setLoseConfidence(Integer loseConfidence) {
		this.loseConfidence = loseConfidence;
	}
	public Integer[] getBetConfidences(){
		Integer[] betConfidences=new Integer[3];
		betConfidences[0]=this.getWinConfidence();
		betConfidences[1]=this.getDrawConfidence();
		betConfidences[2]=this.getLoseConfidence();
		return betConfidences;
	}
	public Double[] getBetRates(){
		Double[] betRates=new Double[3];
		betRates[0]=this.getSfcWinBetRate().doubleValue();
		betRates[1]=this.getSfcDrawBetRate().doubleValue();
		betRates[2]=this.getSfcLoseBetRate().doubleValue();
		return betRates;
	} 
	public Boolean getSfcAllBetRateIsZero() {
		Double[] betRates=getBetRates();
		for(Double rate:betRates){
			if(rate!=null&&!rate.equals(0d)){
				return false;
			}
		}
		return true;
	}
}
