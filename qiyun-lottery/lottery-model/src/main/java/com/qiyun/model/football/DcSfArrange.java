package com.qiyun.model.football;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.qiyun.check.DcSfggBingoCheck;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.football.AbstractDcArrange;
import com.qiyun.grabber.football.RaceStatus;
import com.qiyun.model.FootballMatch;
import com.qiyun.util.NumberTools;
import org.apache.commons.lang.StringUtils;

public class DcSfArrange extends AbstractDcArrange implements java.io.Serializable {

	
	private String projectName;//比赛项目 足球/篮球/冰球
	
	private String seasonInfo;//赛事信息如季后赛
	
	private Double concede;// 让球
	
	private static final long serialVersionUID = 1L;
	private String shortGameName;
	private String shortHomeTeam;
	private String shortGuestTeam;
	private Date endTime; // 需要主动set值
	private Boolean showPm;// 需要主动set值
	private FootballMatch footballInfo;// 足球资料库表 需要主动set 值
	public  static Map<String, String> gameNameMap;
	static{
		gameNameMap = new HashMap<String, String>();
		gameNameMap.put("篮球-美职","NBA");
		gameNameMap.put("冰球-美职","NHL");
		gameNameMap.put("橄榄球-美职","NF");
		gameNameMap.put("棒球-美职","MLB");
	}
	// private int spfResult;

	public DcSfArrange() {
	}

	public DcSfArrange(Integer id, String term) {
		super(id, term);
	}

	public DcSfArrange(Integer id, String term, LotteryType lotteryType, String boutIndex, String matchName, String homeTeam,
					   String awaryTeam, String wholeScore, String matchDate, String extendInfo, String halfScore, RaceStatus status) {
		super(id, term, lotteryType, boutIndex, matchName, homeTeam,  awaryTeam, wholeScore, matchDate, extendInfo, halfScore, status);
	}

	public int getSfResult() {
		try {
		    return DcSfggBingoCheck.getResultByBF(getHalfScore(), getWholeScore(), getConcede()+"");
		} catch (Exception e) {
			return -1;
		}
	}
	

	public Double getSfggSpDouble() {
		return NumberTools.String2Double(NumberTools.formatDouble(NumberTools.String2Double(getSfggSp(), 0), "#.00"), 0);
	}


	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getShortGameName() {
		if (StringUtils.isNotEmpty(getGameShortName())) {
			shortGameName = getGameShortName().replace("　", "");
		} else {
			String key=getProjectName().trim()+"-"+getMatchName().trim();
			if(gameNameMap.containsKey(key)){
				shortGameName=gameNameMap.get(key);
			}else{
				shortGameName = getMatchName().replace("　", "");
			}
		}
		return shortGameName;
	}
	

	public String getShortHomeTeam() {
		if (getHomeTeam().length() > 4) {
			shortHomeTeam = getHomeTeam().substring(0, 4);
		} else {
			shortHomeTeam = getHomeTeam();
		}
		return shortHomeTeam;
	}

	public String getShortGuestTeam() {
		if (getAwaryTeam().length() > 4) {
			shortGuestTeam = getAwaryTeam().substring(0, 4);
		} else {
			shortGuestTeam = getAwaryTeam();
		}
		return shortGuestTeam;
	}

	public Boolean getShowPm() {
		return showPm;
	}

	public void setShowPm(Boolean showPm) {
		this.showPm = showPm;
	}

	public FootballMatch getFootballInfo() {
		return footballInfo;
	}

	public void setFootballInfo(FootballMatch footballInfo) {
		this.footballInfo = footballInfo;
	}



	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSeasonInfo() {
		return seasonInfo;
	}

	public void setSeasonInfo(String seasonInfo) {
		this.seasonInfo = seasonInfo;
	}

	public Double getConcede() {
		return concede;
	}

	public void setConcede(Double concede) {
		this.concede = concede;
		setComConcede(concede);
	}

	public Integer getSfggResult() {
		try {
			int result = DcSfggBingoCheck.getResultByBF(getHalfScore(), getWholeScore(), getConcede() + "");
			return result;
		} catch (Exception e) {
			return null;
		}
	}


}
