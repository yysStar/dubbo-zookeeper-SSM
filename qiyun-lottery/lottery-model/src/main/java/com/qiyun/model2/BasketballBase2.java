package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasketballBase2 {
    private Integer id;

    private String matchName;

    private Integer gameId;

    private String home;

    private Integer homeId;

    private String guest;

    private Integer guestId;

    private Date matchTime;

    private String matchDateStr;

    private String bfWhole;

    private String analysisId;

    private String oddId;

    private String homePm;

    private String guestPm;

    private Integer finalHomeScore;

    private Integer finalGuestScore;

    private String firstSection;

    private String secondSection;

    private String thirdSection;

    private String fourthSection;

    private String addSection;

    private Integer inttime;

    private Integer lineid;

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

    public String getFirstSection() {
        return firstSection;
    }

    public void setFirstSection(String firstSection) {
        this.firstSection = firstSection == null ? null : firstSection.trim();
    }

    public String getSecondSection() {
        return secondSection;
    }

    public void setSecondSection(String secondSection) {
        this.secondSection = secondSection == null ? null : secondSection.trim();
    }

    public String getThirdSection() {
        return thirdSection;
    }

    public void setThirdSection(String thirdSection) {
        this.thirdSection = thirdSection == null ? null : thirdSection.trim();
    }

    public String getFourthSection() {
        return fourthSection;
    }

    public void setFourthSection(String fourthSection) {
        this.fourthSection = fourthSection == null ? null : fourthSection.trim();
    }

    public String getAddSection() {
        return addSection;
    }

    public void setAddSection(String addSection) {
        this.addSection = addSection == null ? null : addSection.trim();
    }

    public Integer getInttime() {
        return inttime;
    }

    public void setInttime(Integer inttime) {
        this.inttime = inttime;
    }

    public Integer getLineid() {
        return lineid;
    }

    public void setLineid(Integer lineid) {
        this.lineid = lineid;
    }
}