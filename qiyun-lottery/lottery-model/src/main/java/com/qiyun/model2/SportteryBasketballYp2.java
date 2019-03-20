package com.qiyun.model2;

import java.util.Date;

public class SportteryBasketballYp2 {
    private Integer id;

    private Integer matchId;

    private String company;

    private Double home;

    private Integer homeChange;

    private Double pankou;

    private Integer pankouChange;

    private Double guest;

    private Integer guestChange;

    private Integer isFirst;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Double getHome() {
        return home;
    }

    public void setHome(Double home) {
        this.home = home;
    }

    public Integer getHomeChange() {
        return homeChange;
    }

    public void setHomeChange(Integer homeChange) {
        this.homeChange = homeChange;
    }

    public Double getPankou() {
        return pankou;
    }

    public void setPankou(Double pankou) {
        this.pankou = pankou;
    }

    public Integer getPankouChange() {
        return pankouChange;
    }

    public void setPankouChange(Integer pankouChange) {
        this.pankouChange = pankouChange;
    }

    public Double getGuest() {
        return guest;
    }

    public void setGuest(Double guest) {
        this.guest = guest;
    }

    public Integer getGuestChange() {
        return guestChange;
    }

    public void setGuestChange(Integer guestChange) {
        this.guestChange = guestChange;
    }

    public Integer getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Integer isFirst) {
        this.isFirst = isFirst;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}