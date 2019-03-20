package com.qiyun.lottery;

import com.qiyun.check.*;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.football.AbstractDcArrange;
import com.qiyun.grabber.football.RaceStatus;
import com.qiyun.model.FootballMatch;
import com.qiyun.tools.DateTools;
import com.qiyun.util.NumberTools;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;

public class DcArrange extends AbstractDcArrange implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private String shortGameName;
	private String shortHomeTeam;
	private String shortGuestTeam;
	private Date endTime; // 需要主动set值
	private Boolean showPm;// 需要主动set值
	private FootballMatch footballInfo;// 足球资料库表 需要主动set 值
	private Long concede;// 让球
	// private int spfResult;

	public DcArrange() {
	}

	public DcArrange(Integer id, String term) {
		super(id, term);
	}

	public DcArrange(Integer id, String term, LotteryType lotteryType, String boutIndex, String matchName, String homeTeam,
                     String awaryTeam, String wholeScore, String matchDate, String extendInfo, String halfScore, RaceStatus status) {
		super(id, term, lotteryType, boutIndex, matchName, homeTeam,  awaryTeam, wholeScore, matchDate, extendInfo, halfScore, status);
	}

	public int getSpfResult() {
		// 比赛取消
		if ("*".equals(getWholeScore())) {
			return 9999;
		}
		int homeScore = 0;
		int awaryScore = 0;
		try {
			String[] socreArea = getWholeScore().split(":");
			homeScore = Integer.valueOf(socreArea[0]);
			awaryScore = Integer.valueOf(socreArea[1]);
		} catch (Exception e) {
			return -1;
		}
		if (homeScore + getConcede() == awaryScore) {
			return 1;
		} else if (homeScore + getConcede() > awaryScore) {
			return 0;
		} else {
			return 2;
		}
	}

	public String getSpfspstr() {
		try {
			int select = DcSfpBingoCheck.getResultByBF(getHalfScore(), getWholeScore(), getConcede() + "");
			String resultStr = DcPlanActionVO.parseDcSelect(select, LotteryType.DC_SFP.getValue());
			return resultStr + "(" + getSpSfp() + ")";
		} catch (Exception e) {
			return null;
		}
	}

	public int getBfResult() {
		try {
			return DcBfBingoCheck.getResultByBF(getWholeScore());
		} catch (Exception e) {
			return -1;
		}
	}

	public String getBfspstr() {
		try {
			int select = DcBfBingoCheck.getResultByBF(getWholeScore());
			String resultStr = DcPlanActionVO.parseDcSelect(select, LotteryType.DC_BF.getValue());
			return resultStr + "(" + getSpBf() + ")";
		} catch (Exception e) {
			return null;
		}
	}

	public int getBqcResult() {
		try {
			return DcBqcBingoCheck.getResultByBF(getHalfScore(), getWholeScore(), getConcede() + "");
		} catch (Exception e) {
			return -1;
		}
	}

	public String getBcspstr() {
		try {
			int select = DcBqcBingoCheck.getResultByBF(getHalfScore(), getWholeScore(), getConcede() + "");
			String resultStr = DcPlanActionVO.parseDcSelect(select, LotteryType.DC_BCSFP.getValue());
			return resultStr + "(" + getSpBcsfp() + ")";
		} catch (Exception e) {
			return null;
		}
	}

	public int getJqsResult() {
		try {
			return DcJqsBingoCheck.getResultByBF(getHalfScore(), getWholeScore());
		} catch (Exception e) {
			return -1;
		}
	}

	public String getJqsspstr() {
		try {
			int select = DcJqsBingoCheck.getResultByBF(getHalfScore(), getWholeScore());
			String resultStr = DcPlanActionVO.parseDcSelect(select, LotteryType.DC_JQS.getValue());
			return resultStr + "(" + getSpJqs() + ")";
		} catch (Exception e) {
			return null;
		}
	}

	public int getSxdsResult() {
		try {
			return DcSxdsBingoCheck.getResultByBF(getWholeScore());
		} catch (Exception e) {
			return -1;
		}
	}

	public String getSxdsspstr() {
		try {
			int select = DcSxdsBingoCheck.getResultByBF(getWholeScore());
			String resultStr = DcPlanActionVO.parseDcSelect(select, LotteryType.DC_SXDS.getValue());
			return resultStr + "(" + getSpSxds() + ")";
		} catch (Exception e) {
			return null;
		}
	}


	public static String findRaceWithTermNameAndTime(String homeName, String guestName, Date matchTime, List<DcArrange> arrangeList) {
		for (DcArrange dc : arrangeList) {
			String jjcTimeStr = DateTools.dateToString(matchTime, "yy-MM-dd HH:mm");
			String dcTimeStr = DateTools.dateToString(dc.getMatchTime(), "yy-MM-dd HH:mm");
			String dcHomeNameF = dc.getHomeTeam().substring(0, 1);
			String dcGuestNameF = dc.getAwaryTeam().substring(0, 1);
			if (!jjcTimeStr.equals(dcTimeStr))
				continue;
			if (homeName.indexOf(dcHomeNameF) == -1 || guestName.indexOf(dcGuestNameF) == -1)
				continue;
			String infoDc = dc.getBoutIndex() + "_" + dc.getConcede();
			return infoDc;
		}
		return "";
	}

	

	public Double getSpSfpDouble() {
		return NumberTools.String2Double(NumberTools.formatDouble(NumberTools.String2Double(getSpSfp(), 0), "#.00"), 0);
	}

	public Double getSpBfDouble() {
		return NumberTools.String2Double(NumberTools.formatDouble(NumberTools.String2Double(getSpBf(), 0), "#.00"), 0);
	}

	public Double getSpBcsfpDouble() {
		return NumberTools.String2Double(NumberTools.formatDouble(NumberTools.String2Double(getSpBcsfp(), 0), "#.00"), 0);
	}

	public Double getSpJqsDouble() {
		return NumberTools.String2Double(NumberTools.formatDouble(NumberTools.String2Double(getSpJqs(), 0), "#.00"), 0);
	}

	public Double getSpSxdsDouble() {
		return NumberTools.String2Double(NumberTools.formatDouble(NumberTools.String2Double(getSpSxds(), 0), "#.00"), 0);
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
			shortGameName = getMatchName().replace("　", "");
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

	public Long getConcede() {
		return concede;
	}

	public void setConcede(Long concede) {
		this.concede = concede;
		setComConcede(Double.parseDouble(concede+""));
	}


}
