package com.qiyun.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MatchItem implements Serializable {
    private Map<String,Object> fbValueStrMap;
    private String gyjTeam;
    private Date intTime;
    private boolean isSheDan;
    private int lineId;
    private List<LotteryType>lotteryTypeList;
    private List<MatchItemOption>options;

    public Map<String, Object> getFbValueStrMap() {
        return fbValueStrMap;
    }

    public void setFbValueStrMap(Map<String, Object> fbValueStrMap) {
        this.fbValueStrMap = fbValueStrMap;
    }

    public String getGyjTeam() {
        return gyjTeam;
    }

    public void setGyjTeam(String gyjTeam) {
        this.gyjTeam = gyjTeam;
    }

    public Date getIntTime() {
        return intTime;
    }

    public void setIntTime(Date intTime) {
        this.intTime = intTime;
    }

    public boolean isSheDan() {
        return isSheDan;
    }

    public void setSheDan(boolean sheDan) {
        isSheDan = sheDan;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public List<LotteryType> getLotteryTypeList() {
        return lotteryTypeList;
    }

    public void setLotteryTypeList(List<LotteryType> lotteryTypeList) {
        this.lotteryTypeList = lotteryTypeList;
    }

    public List<MatchItemOption> getOptions() {
        return options;
    }

    public void setOptions(List<MatchItemOption> options) {
        this.options = options;
    }
}
