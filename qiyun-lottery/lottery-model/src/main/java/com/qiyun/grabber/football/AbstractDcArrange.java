package com.qiyun.grabber.football;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.tools.StringTools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractDcArrange implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private LotteryType lotteryType; // 彩种类型

	private String boutIndex;// 场次

	private String term;

	private String matchName;// 赛事
	
	private Date matchTime;// 开赛时间 具体比赛时间

	private String homeTeam;// 主队

	private String awaryTeam;// 客队

	private String wholeScore;// 全场比分

	private String matchDate;// 开赛日期 只指比赛时间 年月日

	private String extendInfo;

	private String halfScore;// 半场比分
	
	private Integer resultOfRule;//根据单场玩法的赛事胜平负

	// 第二期改为abstractFootballMatch的id,跟FootballMatch这张表关联起来
	private String outid;// 链接id

	private RaceStatus status;// 状态
	private String gameShortName;//赛事缩写名
	private String gameColor;//赛事背景颜色
	private Integer gameId;//赛事表的关联Id
	
	private String spSfp;// 开奖胜负彩SP值

	private String spSxds;// 开奖上下单双SP值

	private String spJqs;// 开奖进球彩SP值

	private String spBf;// 开奖比分SP值

	private String spBcsfp;// 开奖半全彩SP值
	
	private String sfggSp; //开奖胜负过关SP;
	
	private Double comConcede;//通用让球数,北单为Long 北单胜负为Double
	public AbstractDcArrange() {
	}

	public AbstractDcArrange(Integer id, String term) {
		this.id = id;
		this.term = term;
	}

	public AbstractDcArrange(Integer id, String term, LotteryType lotteryType, String boutIndex, String matchName, String homeTeam, 
			String awaryTeam, String wholeScore, String matchDate, String extendInfo, String halfScore, RaceStatus status) {
		this.id = id;
		this.term = term;
		this.lotteryType = lotteryType;
		this.boutIndex = boutIndex;
		this.matchName = matchName;
		this.homeTeam = homeTeam;
		this.awaryTeam = awaryTeam;
		this.wholeScore = wholeScore;
		this.matchDate = matchDate;
		this.extendInfo = extendInfo;
		this.halfScore = halfScore;
		this.status = status;
	}

	public String getAwaryTeam() {
		return awaryTeam;
	}

	public void setAwaryTeam(String awaryTeam) {
		this.awaryTeam = awaryTeam;
	}

	public String getBoutIndex() {
		return boutIndex;
	}

	public void setBoutIndex(String boutIndex) {
		this.boutIndex = boutIndex;
	}


	public String getExtendInfo() {
		return extendInfo;
	}

	public void setExtendInfo(String extendInfo) {
		this.extendInfo = extendInfo;
	}

	public String getHalfScore() {
		return halfScore;
	}

	public void setHalfScore(String halfScore) {
		this.halfScore = halfScore;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Integer getId() {
		return id;
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

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getWholeScore() {
		return wholeScore;
	}

	public void setWholeScore(String wholeScore) {
		this.wholeScore = wholeScore;
		if(!"".equals(this.wholeScore) && this.wholeScore != null){
			Pattern pattern = Pattern.compile("\\d+:\\d+");
			Matcher matcher = pattern.matcher(wholeScore);
			if(matcher.matches()){
				String[] tempArr = wholeScore.split(":");
				Integer homeScore = Integer.valueOf(tempArr[0]);
				Integer guestScore = Integer.valueOf(tempArr[1]);
				if(this.comConcede != null){
					Integer yingpanShu = (int) ((homeScore-guestScore)+this.comConcede);
					if(yingpanShu > 0){
						this.setResultOfRule(3);
					}else if (yingpanShu == 0){
						this.setResultOfRule(1);
					}else if (yingpanShu < 0){
						this.setResultOfRule(0);
					}
				}
			}
		}
	}
	


	public RaceStatus getStatus() {
		return status;
	}

	public void setStatus(RaceStatus status) {
		this.status = status;
	}

	public String getOutid() {
		return outid;
	}

	public void setOutid(String outid) {
		this.outid = outid;
	}

	public String getGameShortName() {
		if(StringTools.isNullOrBlank(gameShortName)){
			gameShortName=getMatchName();
		}
		return gameShortName;
	}

	public void setGameShortName(String gameShortName) {
		this.gameShortName = gameShortName;
	}

	public String getGameColor() {
		return gameColor;
	}

	public void setGameColor(String gameColor) {
		this.gameColor = gameColor;
	}

	public Integer getGameId() {
		return gameId;
	}

	public Integer getResultOfRule() {
		return resultOfRule;
	}

	public void setResultOfRule(Integer resultOfRule) {
		this.resultOfRule = resultOfRule;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public void setSpSfp(String spSfp) {
		this.spSfp = spSfp;
	}

	public void setSpSxds(String spSxds) {
		this.spSxds = spSxds;
	}

	public void setSpJqs(String spJqs) {
		this.spJqs = spJqs;
	}

	public void setSpBf(String spBf) {
		this.spBf = spBf;
	}

	public void setSpBcsfp(String spBcsfp) {
		this.spBcsfp = spBcsfp;
	}


	public String getSfggSp() {
		return sfggSp;
	}

	public void setSfggSp(String sfggSp) {
		this.sfggSp = sfggSp;
	}

	public String getSpSfp() {
		return spSfp;
	}

	public String getSpSxds() {
		return spSxds;
	}

	public String getSpJqs() {
		return spJqs;
	}

	public String getSpBf() {
		return spBf;
	}

	public String getSpBcsfp() {
		return spBcsfp;
	}

	public Double getComConcede() {
		return comConcede;
	}

	public void setComConcede(Double comConcede) {
		this.comConcede = comConcede;
	}
	
	public String getIntTime() {// showDate的int型
		return getShowDate().replace("-", "");
	}
	
	public String getShowDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String resultDate = sdf.format(getShowDateDate());
		return resultDate;
	}

	public Date getShowDateDate() {
		Date date = this.getMatchTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		if (hour < 10 || (hour == 10 && min == 0)) {
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			calendar.set(Calendar.DAY_OF_MONTH, day - 1);
		}
		return calendar.getTime();
	}
}
