package com.qiyun.model2;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class FootBallMatch2 implements Serializable {
    private Integer id;

    /**
     * 足球联赛名
     */
    private String matchName;

    /**
     * 联赛id
     */
    private Integer gameId;

    /**
     * 主队名称
     */
    private String home;

    /**
     * 主队id
     */
    private Integer homeId;

    /**
     * 客队名称
     */
    private String guest;

    /**
     * 客队ID
     */
    private Integer guestId;

    /**
     * 比赛开始时间
     */
    private Date matchTime;

    /**
     * 比赛日期
     */
    private String matchDateStr;

    /**
     * 半场比分
     */
    private String bfHalf;

    /**
     * 全场比分
     */
    private String bfWhole;

    /**
     * 分析id
     */
    private String analysisId;

    /**
     * 赔率数据id
     */
    private String oddId;

    private String homePm;

    private String guestPm;

    private String bfLevel;

    private String outAnalysisId;

    private Integer resultOfMatch;

    /**
     * 主队得分
     */
    private Integer finalHomeScore;

    /**
     * 客队得分
     */
    private Integer finalGuestScore;

    private Integer xyyHomeId;

    private Integer xyyGuestId;

    private String weekStr;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName == null ? null : matchName.trim();
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home == null ? null : home.trim();
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest == null ? null : guest.trim();
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public String getMatchDateStr() {
        return matchDateStr;
    }

    public void setMatchDateStr(String matchDateStr) {
        this.matchDateStr = matchDateStr == null ? null : matchDateStr.trim();
    }

    public String getBfHalf() {
        return bfHalf;
    }

    public void setBfHalf(String bfHalf) {
        this.bfHalf = bfHalf == null ? null : bfHalf.trim();
    }

    public String getBfWhole() {
        return bfWhole;
    }

    public void setBfWhole(String bfWhole) {
        this.bfWhole = bfWhole == null ? null : bfWhole.trim();
    }

    public String getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(String analysisId) {
        this.analysisId = analysisId == null ? null : analysisId.trim();
    }

    public String getOddId() {
        return oddId;
    }

    public void setOddId(String oddId) {
        this.oddId = oddId == null ? null : oddId.trim();
    }

    public String getHomePm() {
        return homePm;
    }

    public void setHomePm(String homePm) {
        this.homePm = homePm == null ? null : homePm.trim();
    }

    public String getGuestPm() {
        return guestPm;
    }

    public void setGuestPm(String guestPm) {
        this.guestPm = guestPm == null ? null : guestPm.trim();
    }

    public String getBfLevel() {
        return bfLevel;
    }

    public void setBfLevel(String bfLevel) {
        this.bfLevel = bfLevel == null ? null : bfLevel.trim();
    }

    public String getOutAnalysisId() {
        return outAnalysisId;
    }

    public void setOutAnalysisId(String outAnalysisId) {
        this.outAnalysisId = outAnalysisId == null ? null : outAnalysisId.trim();
    }

    public Integer getResultOfMatch() {
        return resultOfMatch;
    }

    public void setResultOfMatch(Integer resultOfMatch) {
        this.resultOfMatch = resultOfMatch;
    }

    public Integer getFinalHomeScore() {
        return finalHomeScore;
    }

    public void setFinalHomeScore(Integer finalHomeScore) {
        this.finalHomeScore = finalHomeScore;
    }

    public Integer getFinalGuestScore() {
        return finalGuestScore;
    }

    public void setFinalGuestScore(Integer finalGuestScore) {
        this.finalGuestScore = finalGuestScore;
    }

    public Integer getXyyHomeId() {
        return xyyHomeId;
    }

    public void setXyyHomeId(Integer xyyHomeId) {
        this.xyyHomeId = xyyHomeId;
    }

    public Integer getXyyGuestId() {
        return xyyGuestId;
    }

    public void setXyyGuestId(Integer xyyGuestId) {
        this.xyyGuestId = xyyGuestId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", matchName=").append(matchName);
        sb.append(", gameId=").append(gameId);
        sb.append(", home=").append(home);
        sb.append(", homeId=").append(homeId);
        sb.append(", guest=").append(guest);
        sb.append(", guestId=").append(guestId);
        sb.append(", matchTime=").append(matchTime);
        sb.append(", matchDateStr=").append(matchDateStr);
        sb.append(", bfHalf=").append(bfHalf);
        sb.append(", bfWhole=").append(bfWhole);
        sb.append(", analysisId=").append(analysisId);
        sb.append(", oddId=").append(oddId);
        sb.append(", homePm=").append(homePm);
        sb.append(", guestPm=").append(guestPm);
        sb.append(", bfLevel=").append(bfLevel);
        sb.append(", outAnalysisId=").append(outAnalysisId);
        sb.append(", resultOfMatch=").append(resultOfMatch);
        sb.append(", finalHomeScore=").append(finalHomeScore);
        sb.append(", finalGuestScore=").append(finalGuestScore);
        sb.append(", xyyHomeId=").append(xyyHomeId);
        sb.append(", xyyGuestId=").append(xyyGuestId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}