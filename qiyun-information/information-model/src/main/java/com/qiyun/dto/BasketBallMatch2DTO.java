package com.qiyun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BasketBallMatch2DTO implements Serializable{
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

    /**
     * 分析id
     */
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

    private String weekStr;

    public String getWeekStr() {
        return weekStr;
    }

    public void setWeekStr(String weekStr) {
        this.weekStr = weekStr;
    }

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

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
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
        sb.append(", bfWhole=").append(bfWhole);
        sb.append(", analysisId=").append(analysisId);
        sb.append(", oddId=").append(oddId);
        sb.append(", homePm=").append(homePm);
        sb.append(", guestPm=").append(guestPm);
        sb.append(", finalHomeScore=").append(finalHomeScore);
        sb.append(", finalGuestScore=").append(finalGuestScore);
        sb.append(", firstSection=").append(firstSection);
        sb.append(", secondSection=").append(secondSection);
        sb.append(", thirdSection=").append(thirdSection);
        sb.append(", fourthSection=").append(fourthSection);
        sb.append(", addSection=").append(addSection);
        sb.append(", inttime=").append(inttime);
        sb.append(", lineid=").append(lineid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
