package com.qiyun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qiyun.model.MatchShowStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasketBallMatchDTO implements Serializable,Comparable<BasketBallMatchDTO> {
    private int id;
    private String matchId; //编号
    private String matchName; //赛事
    private Integer intTime;
    private Integer lineId;
    private Date matchTime; //比赛时间
    private Date matchDealTime; //比赛时间
    private String HomeTeam; //主队
    private String GuestTeam; //客队
    private double awardOfHomeWin; //主胜sp
    private double awardOfGuestWin; //客胜sp
    private double awardOfRfHomeWin; //让分主胜sp
    private double awardOfRfGuestWin; //让分客胜sp
    private double rf; //让分数
    private double dxf; //大小分
    private double awardOfDxfForBig; //大分sp
    private double awardOfDxfForSmall; //小分sp
    private double awardOfSfcForHome5;
    private double awardOfSfcForHome10;
    private double awardOfSfcForHome15;
    private double awardOfSfcForHome20;
    private double awardOfSfcForHome25;
    private double awardOfSfcForHome26;
    private double awardOfSfcForGuest5;
    private double awardOfSfcForGuest10;
    private double awardOfSfcForGuest15;
    private double awardOfSfcForGuest20;
    private double awardOfSfcForGuest25;
    private double awardOfSfcForGuest26;


    private Integer showNum = 0;
    private boolean selectStatus[] = new boolean[8];
    private List<String> showStatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getShowNum() {
        return showNum;
    }

    public void setShowNum(Integer showNum) {
        this.showNum = showNum;
    }

    public void setSelectStatus(boolean[] selectStatus) {
        this.selectStatus = selectStatus;
    }

    public List<String> getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(List<String> showStatus) {
        this.showStatus = showStatus;
    }

    public boolean[] getSelectStatus() {
        MatchShowStatus status[] = MatchShowStatus.values();
        for (int i = 0; i < status.length; i++) {
            int value = 1 << status[i].getValue();
            if ((this.showNum & value) > 0) {
                selectStatus[i] = true;
            } else {
                selectStatus[i] = false;
            }
        }
        return selectStatus;
    }
    /**
     * 玩法是否在售
     *
     * @param fb
     * @return true 开售/false停售
     */
    public boolean getStatusIsSale(MatchShowStatus fb){
        MatchShowStatus status[] = MatchShowStatus.values();
        boolean[] selectStatus =getSelectStatus();
        boolean flag=false;
        for(int i=0;i<status.length;i++){
            if(status[i]==fb){
                flag=selectStatus[i];
                break;
            }
        }
        return flag;
    }

    public List<MatchShowStatus> getMatchShowStatus() {
        List<MatchShowStatus> matchShowStatusList = new ArrayList<MatchShowStatus>();
        if (getShowStatus() != null) {
            for (String s : getShowStatus()) {
                if (s != null) {
                    MatchShowStatus tempstatus = MatchShowStatus.valueOf(s);
                    matchShowStatusList.add(tempstatus);
                }
            }
        }
        return matchShowStatusList;
    }

    public Integer getShowStatusNum() {
        int show = 0;
        if (getShowStatus() != null && !getShowStatus().isEmpty()) {
            for (MatchShowStatus status : getMatchShowStatus()) {
                if (status != null){
                    show |= 1 << status.getValue();
                }
            }
        }
        return show;
    }
    /**
     * 全部开售状态
     * @return
     */
    public Integer getShowStatusNumAll() {
        int show = 0;
        MatchShowStatus status[] = MatchShowStatus.values();
        for (int i = 0; i < status.length; i++) {
            if (status != null){
                show |= 1 << status[i].getValue();
            }
        }
        return show;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getMatchDealTime() {
        return matchDealTime;
    }

    public void setMatchDealTime(Date matchDealTime) {
        this.matchDealTime = matchDealTime;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Integer getIntTime() {
        return intTime;
    }

    public void setIntTime(Integer intTime) {
        this.intTime = intTime;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public String getHomeTeam() {
        return HomeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        HomeTeam = homeTeam;
    }

    public String getGuestTeam() {
        return GuestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        GuestTeam = guestTeam;
    }

    public double getAwardOfHomeWin() {
        return awardOfHomeWin;
    }

    public void setAwardOfHomeWin(double awardOfHomeWin) {
        this.awardOfHomeWin = awardOfHomeWin;
    }

    public double getAwardOfGuestWin() {
        return awardOfGuestWin;
    }

    public void setAwardOfGuestWin(double awardOfGuestWin) {
        this.awardOfGuestWin = awardOfGuestWin;
    }

    public double getAwardOfRfHomeWin() {
        return awardOfRfHomeWin;
    }

    public void setAwardOfRfHomeWin(double awardOfRfHomeWin) {
        this.awardOfRfHomeWin = awardOfRfHomeWin;
    }

    public double getAwardOfRfGuestWin() {
        return awardOfRfGuestWin;
    }

    public void setAwardOfRfGuestWin(double awardOfRfGuestWin) {
        this.awardOfRfGuestWin = awardOfRfGuestWin;
    }

    public double getRf() {
        return rf;
    }

    public void setRf(double rf) {
        this.rf = rf;
    }

    public double getDxf() {
        return dxf;
    }

    public void setDxf(double dxf) {
        this.dxf = dxf;
    }

    public double getAwardOfDxfForBig() {
        return awardOfDxfForBig;
    }

    public void setAwardOfDxfForBig(double awardOfDxfForBig) {
        this.awardOfDxfForBig = awardOfDxfForBig;
    }

    public double getAwardOfDxfForSmall() {
        return awardOfDxfForSmall;
    }

    public void setAwardOfDxfForSmall(double awardOfDxfForSmall) {
        this.awardOfDxfForSmall = awardOfDxfForSmall;
    }

    public double getAwardOfSfcForHome5() {
        return awardOfSfcForHome5;
    }

    public void setAwardOfSfcForHome5(double awardOfSfcForHome5) {
        this.awardOfSfcForHome5 = awardOfSfcForHome5;
    }

    public double getAwardOfSfcForHome10() {
        return awardOfSfcForHome10;
    }

    public void setAwardOfSfcForHome10(double awardOfSfcForHome10) {
        this.awardOfSfcForHome10 = awardOfSfcForHome10;
    }

    public double getAwardOfSfcForHome15() {
        return awardOfSfcForHome15;
    }

    public void setAwardOfSfcForHome15(double awardOfSfcForHome15) {
        this.awardOfSfcForHome15 = awardOfSfcForHome15;
    }

    public double getAwardOfSfcForHome20() {
        return awardOfSfcForHome20;
    }

    public void setAwardOfSfcForHome20(double awardOfSfcForHome20) {
        this.awardOfSfcForHome20 = awardOfSfcForHome20;
    }

    public double getAwardOfSfcForHome25() {
        return awardOfSfcForHome25;
    }

    public void setAwardOfSfcForHome25(double awardOfSfcForHome25) {
        this.awardOfSfcForHome25 = awardOfSfcForHome25;
    }

    public double getAwardOfSfcForHome26() {
        return awardOfSfcForHome26;
    }

    public void setAwardOfSfcForHome26(double awardOfSfcForHome26) {
        this.awardOfSfcForHome26 = awardOfSfcForHome26;
    }

    public double getAwardOfSfcForGuest5() {
        return awardOfSfcForGuest5;
    }

    public void setAwardOfSfcForGuest5(double awardOfSfcForGuest5) {
        this.awardOfSfcForGuest5 = awardOfSfcForGuest5;
    }

    public double getAwardOfSfcForGuest10() {
        return awardOfSfcForGuest10;
    }

    public void setAwardOfSfcForGuest10(double awardOfSfcForGuest10) {
        this.awardOfSfcForGuest10 = awardOfSfcForGuest10;
    }

    public double getAwardOfSfcForGuest15() {
        return awardOfSfcForGuest15;
    }

    public void setAwardOfSfcForGuest15(double awardOfSfcForGuest15) {
        this.awardOfSfcForGuest15 = awardOfSfcForGuest15;
    }

    public double getAwardOfSfcForGuest20() {
        return awardOfSfcForGuest20;
    }

    public void setAwardOfSfcForGuest20(double awardOfSfcForGuest20) {
        this.awardOfSfcForGuest20 = awardOfSfcForGuest20;
    }

    public double getAwardOfSfcForGuest25() {
        return awardOfSfcForGuest25;
    }

    public void setAwardOfSfcForGuest25(double awardOfSfcForGuest25) {
        this.awardOfSfcForGuest25 = awardOfSfcForGuest25;
    }

    public double getAwardOfSfcForGuest26() {
        return awardOfSfcForGuest26;
    }

    public void setAwardOfSfcForGuest26(double awardOfSfcForGuest26) {
        this.awardOfSfcForGuest26 = awardOfSfcForGuest26;
    }

    public int compareTo(BasketBallMatchDTO o) {
        int i = this.getIntTime() - o.getIntTime();//先按照intTime排序
        if(i == 0){
            return this.getLineId() - o.getLineId();//如果intTime相等了再用lineId进行排序
        }
        return i;
    }
}
