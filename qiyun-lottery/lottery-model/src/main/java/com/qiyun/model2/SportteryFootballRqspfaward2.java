package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SportteryFootballRqspfaward2 {
    private Integer id;

    private Double homewinaward;

    private Double guestwinaward;

    private Double drawaward;

    private Integer homechange;

    private Integer drawchange;

    private Integer guestchange;

    private Integer matchid;

    private Integer inttime;

    private Integer lineid;

    private Date matchtime;

    private Integer passmode;

    private Date lastupdatetime;

    private Date createDate;

    private Double homeRate;

    private Double drawRate;

    private Double guestRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHomewinaward() {
        return homewinaward;
    }

    public void setHomewinaward(Double homewinaward) {
        this.homewinaward = homewinaward;
    }

    public Double getGuestwinaward() {
        return guestwinaward;
    }

    public void setGuestwinaward(Double guestwinaward) {
        this.guestwinaward = guestwinaward;
    }

    public Double getDrawaward() {
        return drawaward;
    }

    public void setDrawaward(Double drawaward) {
        this.drawaward = drawaward;
    }

    public Integer getHomechange() {
        return homechange;
    }

    public void setHomechange(Integer homechange) {
        this.homechange = homechange;
    }

    public Integer getDrawchange() {
        return drawchange;
    }

    public void setDrawchange(Integer drawchange) {
        this.drawchange = drawchange;
    }

    public Integer getGuestchange() {
        return guestchange;
    }

    public void setGuestchange(Integer guestchange) {
        this.guestchange = guestchange;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getHomeRate() {
        return homeRate;
    }

    public void setHomeRate(Double homeRate) {
        this.homeRate = homeRate;
    }

    public Double getDrawRate() {
        return drawRate;
    }

    public void setDrawRate(Double drawRate) {
        this.drawRate = drawRate;
    }

    public Double getGuestRate() {
        return guestRate;
    }

    public void setGuestRate(Double guestRate) {
        this.guestRate = guestRate;
    }
}