package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class SportteryBasketMatch2 implements Serializable {
    private Integer id;

    private Integer version;

    private String gamename;

    private String gamecolor;

    private Date matchtime;

    private Integer inttime;

    private Integer status;

    private Integer shownum;

    private String homename;

    private String homeShortName;

    private String guestname;

    private String guestShortName;

    private Integer lineid;

    private String fristsection;

    private String secondsection;

    private String thirdsection;

    private String fourthsection;

    private Double resultofsf;

    private Double resultofsfc;

    private Double resultofdxf;

    private Double resultofrfsf;

    private Double handicap;

    private Double basebigorsmall;

    private Double singleHandicap;

    private Double singleBasebigorsmall;

    private Integer homescore;

    private Integer guestscore;

    private String outid;

    private Integer dxfQ2Scene;

    private String analysisId;

    private Integer hasDelay;

    private Integer sfShownum;

    private Integer rfsfShownum;

    private Integer dxfShownum;

    private Integer sfcShownum;

    private Integer gameId;

    private String gameShortName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public String getGamecolor() {
        return gamecolor;
    }

    public void setGamecolor(String gamecolor) {
        this.gamecolor = gamecolor == null ? null : gamecolor.trim();
    }

    public Date getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(Date matchtime) {
        this.matchtime = matchtime;
    }

    public Integer getInttime() {
        return inttime;
    }

    public void setInttime(Integer inttime) {
        this.inttime = inttime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShownum() {
        return shownum;
    }

    public void setShownum(Integer shownum) {
        this.shownum = shownum;
    }

    public String getHomename() {
        return homename;
    }

    public void setHomename(String homename) {
        this.homename = homename == null ? null : homename.trim();
    }

    public String getHomeShortName() {
        return homeShortName;
    }

    public void setHomeShortName(String homeShortName) {
        this.homeShortName = homeShortName == null ? null : homeShortName.trim();
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname == null ? null : guestname.trim();
    }

    public String getGuestShortName() {
        return guestShortName;
    }

    public void setGuestShortName(String guestShortName) {
        this.guestShortName = guestShortName == null ? null : guestShortName.trim();
    }

    public Integer getLineid() {
        return lineid;
    }

    public void setLineid(Integer lineid) {
        this.lineid = lineid;
    }

    public String getFristsection() {
        return fristsection;
    }

    public void setFristsection(String fristsection) {
        this.fristsection = fristsection == null ? null : fristsection.trim();
    }

    public String getSecondsection() {
        return secondsection;
    }

    public void setSecondsection(String secondsection) {
        this.secondsection = secondsection == null ? null : secondsection.trim();
    }

    public String getThirdsection() {
        return thirdsection;
    }

    public void setThirdsection(String thirdsection) {
        this.thirdsection = thirdsection == null ? null : thirdsection.trim();
    }

    public String getFourthsection() {
        return fourthsection;
    }

    public void setFourthsection(String fourthsection) {
        this.fourthsection = fourthsection == null ? null : fourthsection.trim();
    }

    public Double getResultofsf() {
        return resultofsf;
    }

    public void setResultofsf(Double resultofsf) {
        this.resultofsf = resultofsf;
    }

    public Double getResultofsfc() {
        return resultofsfc;
    }

    public void setResultofsfc(Double resultofsfc) {
        this.resultofsfc = resultofsfc;
    }

    public Double getResultofdxf() {
        return resultofdxf;
    }

    public void setResultofdxf(Double resultofdxf) {
        this.resultofdxf = resultofdxf;
    }

    public Double getResultofrfsf() {
        return resultofrfsf;
    }

    public void setResultofrfsf(Double resultofrfsf) {
        this.resultofrfsf = resultofrfsf;
    }

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
    }

    public Double getBasebigorsmall() {
        return basebigorsmall;
    }

    public void setBasebigorsmall(Double basebigorsmall) {
        this.basebigorsmall = basebigorsmall;
    }

    public Double getSingleHandicap() {
        return singleHandicap;
    }

    public void setSingleHandicap(Double singleHandicap) {
        this.singleHandicap = singleHandicap;
    }

    public Double getSingleBasebigorsmall() {
        return singleBasebigorsmall;
    }

    public void setSingleBasebigorsmall(Double singleBasebigorsmall) {
        this.singleBasebigorsmall = singleBasebigorsmall;
    }

    public Integer getHomescore() {
        return homescore;
    }

    public void setHomescore(Integer homescore) {
        this.homescore = homescore;
    }

    public Integer getGuestscore() {
        return guestscore;
    }

    public void setGuestscore(Integer guestscore) {
        this.guestscore = guestscore;
    }

    public String getOutid() {
        return outid;
    }

    public void setOutid(String outid) {
        this.outid = outid == null ? null : outid.trim();
    }

    public Integer getDxfQ2Scene() {
        return dxfQ2Scene;
    }

    public void setDxfQ2Scene(Integer dxfQ2Scene) {
        this.dxfQ2Scene = dxfQ2Scene;
    }

    public String getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(String analysisId) {
        this.analysisId = analysisId == null ? null : analysisId.trim();
    }

    public Integer getHasDelay() {
        return hasDelay;
    }

    public void setHasDelay(Integer hasDelay) {
        this.hasDelay = hasDelay;
    }

    public Integer getSfShownum() {
        return sfShownum;
    }

    public void setSfShownum(Integer sfShownum) {
        this.sfShownum = sfShownum;
    }

    public Integer getRfsfShownum() {
        return rfsfShownum;
    }

    public void setRfsfShownum(Integer rfsfShownum) {
        this.rfsfShownum = rfsfShownum;
    }

    public Integer getDxfShownum() {
        return dxfShownum;
    }

    public void setDxfShownum(Integer dxfShownum) {
        this.dxfShownum = dxfShownum;
    }

    public Integer getSfcShownum() {
        return sfcShownum;
    }

    public void setSfcShownum(Integer sfcShownum) {
        this.sfcShownum = sfcShownum;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameShortName() {
        return gameShortName;
    }

    public void setGameShortName(String gameShortName) {
        this.gameShortName = gameShortName == null ? null : gameShortName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", gamename=").append(gamename);
        sb.append(", gamecolor=").append(gamecolor);
        sb.append(", matchtime=").append(matchtime);
        sb.append(", inttime=").append(inttime);
        sb.append(", status=").append(status);
        sb.append(", shownum=").append(shownum);
        sb.append(", homename=").append(homename);
        sb.append(", homeShortName=").append(homeShortName);
        sb.append(", guestname=").append(guestname);
        sb.append(", guestShortName=").append(guestShortName);
        sb.append(", lineid=").append(lineid);
        sb.append(", fristsection=").append(fristsection);
        sb.append(", secondsection=").append(secondsection);
        sb.append(", thirdsection=").append(thirdsection);
        sb.append(", fourthsection=").append(fourthsection);
        sb.append(", resultofsf=").append(resultofsf);
        sb.append(", resultofsfc=").append(resultofsfc);
        sb.append(", resultofdxf=").append(resultofdxf);
        sb.append(", resultofrfsf=").append(resultofrfsf);
        sb.append(", handicap=").append(handicap);
        sb.append(", basebigorsmall=").append(basebigorsmall);
        sb.append(", singleHandicap=").append(singleHandicap);
        sb.append(", singleBasebigorsmall=").append(singleBasebigorsmall);
        sb.append(", homescore=").append(homescore);
        sb.append(", guestscore=").append(guestscore);
        sb.append(", outid=").append(outid);
        sb.append(", dxfQ2Scene=").append(dxfQ2Scene);
        sb.append(", analysisId=").append(analysisId);
        sb.append(", hasDelay=").append(hasDelay);
        sb.append(", sfShownum=").append(sfShownum);
        sb.append(", rfsfShownum=").append(rfsfShownum);
        sb.append(", dxfShownum=").append(dxfShownum);
        sb.append(", sfcShownum=").append(sfcShownum);
        sb.append(", gameId=").append(gameId);
        sb.append(", gameShortName=").append(gameShortName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}