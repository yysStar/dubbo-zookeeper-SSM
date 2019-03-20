package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportteryFootballBqcaward2 {
    private Integer id;

    private Integer matchid;

    private Integer inttime;

    private Integer lineid;

    private Date matchtime;

    private Integer passmode;

    private Date lastupdatetime;

    private Double winWinAward;

    private Double winDrawAward;

    private Double winLoseAward;

    private Double drawWinAward;

    private Double drawDrawAward;

    private Double drawLoseAward;

    private Double loseWinAward;

    private Double loseDrawAward;

    private Double loseLoseAward;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
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

    public Date getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(Date matchtime) {
        this.matchtime = matchtime;
    }

    public Integer getPassmode() {
        return passmode;
    }

    public void setPassmode(Integer passmode) {
        this.passmode = passmode;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Double getWinWinAward() {
        return winWinAward;
    }

    public void setWinWinAward(Double winWinAward) {
        this.winWinAward = winWinAward;
    }

    public Double getWinDrawAward() {
        return winDrawAward;
    }

    public void setWinDrawAward(Double winDrawAward) {
        this.winDrawAward = winDrawAward;
    }

    public Double getWinLoseAward() {
        return winLoseAward;
    }

    public void setWinLoseAward(Double winLoseAward) {
        this.winLoseAward = winLoseAward;
    }

    public Double getDrawWinAward() {
        return drawWinAward;
    }

    public void setDrawWinAward(Double drawWinAward) {
        this.drawWinAward = drawWinAward;
    }

    public Double getDrawDrawAward() {
        return drawDrawAward;
    }

    public void setDrawDrawAward(Double drawDrawAward) {
        this.drawDrawAward = drawDrawAward;
    }

    public Double getDrawLoseAward() {
        return drawLoseAward;
    }

    public void setDrawLoseAward(Double drawLoseAward) {
        this.drawLoseAward = drawLoseAward;
    }

    public Double getLoseWinAward() {
        return loseWinAward;
    }

    public void setLoseWinAward(Double loseWinAward) {
        this.loseWinAward = loseWinAward;
    }

    public Double getLoseDrawAward() {
        return loseDrawAward;
    }

    public void setLoseDrawAward(Double loseDrawAward) {
        this.loseDrawAward = loseDrawAward;
    }

    public Double getLoseLoseAward() {
        return loseLoseAward;
    }

    public void setLoseLoseAward(Double loseLoseAward) {
        this.loseLoseAward = loseLoseAward;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}