package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendMatchMapping implements Serializable {
    private Integer id;

    private Integer recomPlanId;

    private Integer intTime;

    private Integer lineid;

    private String homeTeam;

    private String guestTeam;

    private Date matchTime;

    private BigDecimal score;

    private BigDecimal sp;

    private Integer result;

    private Integer type;

    private Integer matchId;

    private BigDecimal baseBigSmall;

    private Integer bingoStatus;

    private String gameName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecomPlanId() {
        return recomPlanId;
    }

    public void setRecomPlanId(Integer recomPlanId) {
        this.recomPlanId = recomPlanId;
    }

    public Integer getIntTime() {
        return intTime;
    }

    public void setIntTime(Integer intTime) {
        this.intTime = intTime;
    }

    public Integer getLineid() {
        return lineid;
    }

    public void setLineid(Integer lineid) {
        this.lineid = lineid;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam == null ? null : homeTeam.trim();
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam == null ? null : guestTeam.trim();
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getSp() {
        return sp;
    }

    public void setSp(BigDecimal sp) {
        this.sp = sp;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public BigDecimal getBaseBigSmall() {
        return baseBigSmall;
    }

    public void setBaseBigSmall(BigDecimal baseBigSmall) {
        this.baseBigSmall = baseBigSmall;
    }

    public Integer getBingoStatus() {
        return bingoStatus;
    }

    public void setBingoStatus(Integer bingoStatus) {
        this.bingoStatus = bingoStatus;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }
}