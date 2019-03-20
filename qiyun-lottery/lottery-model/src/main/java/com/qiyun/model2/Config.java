package com.qiyun.model2;

import java.util.Date;

public class Config {
    private Integer id;

    private Double maxAddPrize;

    private Integer matchDealTime;

    private Integer autoCopyForLess5;

    private Integer autoCopyForMore5;

    private Integer isDg;

    private Integer chaiPiaoCount;

    private Integer spSource;

    private Date lastCheckbingoTime;

    private Date lastReturnPrizeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMaxAddPrize() {
        return maxAddPrize;
    }

    public void setMaxAddPrize(Double maxAddPrize) {
        this.maxAddPrize = maxAddPrize;
    }

    public Integer getMatchDealTime() {
        return matchDealTime;
    }

    public void setMatchDealTime(Integer matchDealTime) {
        this.matchDealTime = matchDealTime;
    }

    public Integer getAutoCopyForLess5() {
        return autoCopyForLess5;
    }

    public void setAutoCopyForLess5(Integer autoCopyForLess5) {
        this.autoCopyForLess5 = autoCopyForLess5;
    }

    public Integer getAutoCopyForMore5() {
        return autoCopyForMore5;
    }

    public void setAutoCopyForMore5(Integer autoCopyForMore5) {
        this.autoCopyForMore5 = autoCopyForMore5;
    }

    public Integer getIsDg() {
        return isDg;
    }

    public void setIsDg(Integer isDg) {
        this.isDg = isDg;
    }

    public Integer getChaiPiaoCount() {
        return chaiPiaoCount;
    }

    public void setChaiPiaoCount(Integer chaiPiaoCount) {
        this.chaiPiaoCount = chaiPiaoCount;
    }

    public Integer getSpSource() {
        return spSource;
    }

    public void setSpSource(Integer spSource) {
        this.spSource = spSource;
    }

    public Date getLastCheckbingoTime() {
        return lastCheckbingoTime;
    }

    public void setLastCheckbingoTime(Date lastCheckbingoTime) {
        this.lastCheckbingoTime = lastCheckbingoTime;
    }

    public Date getLastReturnPrizeTime() {
        return lastReturnPrizeTime;
    }

    public void setLastReturnPrizeTime(Date lastReturnPrizeTime) {
        this.lastReturnPrizeTime = lastReturnPrizeTime;
    }
}