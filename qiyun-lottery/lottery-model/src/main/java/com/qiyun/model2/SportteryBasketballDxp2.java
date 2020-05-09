package com.qiyun.model2;

import java.util.Date;

public class SportteryBasketballDxp2 {
    private Integer id;

    private Integer matchId;

    private String company;

    private Double big;

    private Integer bigChange;

    private Double pankou;

    private Integer pankouChange;

    private Double small;

    private Integer smallChange;

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

    public Double getBig() {
        return big;
    }

    public void setBig(Double big) {
        this.big = big;
    }

    public Integer getBigChange() {
        return bigChange;
    }

    public void setBigChange(Integer bigChange) {
        this.bigChange = bigChange;
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

    public Double getSmall() {
        return small;
    }

    public void setSmall(Double small) {
        this.small = small;
    }

    public Integer getSmallChange() {
        return smallChange;
    }

    public void setSmallChange(Integer smallChange) {
        this.smallChange = smallChange;
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