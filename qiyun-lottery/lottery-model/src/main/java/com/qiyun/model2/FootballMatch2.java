package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FootballMatch2 {
    private Integer id;

    private String matchName;

    private Integer gameId;

    private String home;

    private Integer homeId;

    private String guest;

    private Integer guestId;

    private Date matchTime;

    private String matchDateStr;

    private String bfHalf;

    private String bfWhole;

    private String analysisId;

    private String oddId;

    private String homePm;

    private String guestPm;

    private String bfLevel;

    private String outAnalysisId;

    private Integer resultOfMatch;

    private Integer finalHomeScore;

    private Integer finalGuestScore;

    private Integer xyyHomeId;

    private Integer xyyGuestId;

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
}