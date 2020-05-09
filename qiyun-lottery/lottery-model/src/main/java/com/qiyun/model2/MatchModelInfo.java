package com.qiyun.model2;

import java.io.Serializable;

public class MatchModelInfo implements Serializable {


    private String matchItemsStr; //篮球比赛详情 json字符串
    private String ftmatchItemsStr;//足球比赛详情 json字符串
    private String passMode;//过关方式
    private String isOnlyPlay; //混投单一玩法
    private String maxSp; //忽略
    private String planDesc; //发单宣言
    private Integer publicStatus = 3; //是否公开 默认截止公开
    private Integer amount; //金额
    private Integer multiple;//倍数
    private Integer tradeType; ////购买方式
    private Integer isFocus;//是否焦点赛事
    private Integer lotteryType; //彩种
    private Integer betCount;//住数
    private String isDs = "false";//是否单式 默认false
    private String passType;//"P2_1"
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MatchModelInfo(String matchItemsStr, String ftmatchItemsStr, String passMode, String isOnlyPlay, String maxSp, String planDesc, Integer publicStatus, Integer amount, Integer multiple, Integer tradeType, Integer isFocus, Integer lotteryType, Integer betCount, String isDs, String passType) {
        this.matchItemsStr = matchItemsStr;
        this.ftmatchItemsStr = ftmatchItemsStr;
        this.passMode = passMode;
        this.isOnlyPlay = isOnlyPlay;
        this.maxSp = maxSp;
        this.planDesc = planDesc;
        this.publicStatus = publicStatus;
        this.amount = amount;
        this.multiple = multiple;
        this.tradeType = tradeType;
        this.isFocus = isFocus;
        this.lotteryType = lotteryType;
        this.betCount = betCount;
        this.isDs = isDs;
        this.passType = passType;
    }

    public MatchModelInfo() {
    }

    public String getMatchItemsStr() {
        return matchItemsStr;
    }

    public void setMatchItemsStr(String matchItemsStr) {
        this.matchItemsStr = matchItemsStr;
    }

    public String getFtmatchItemsStr() {
        return ftmatchItemsStr;
    }

    public void setFtmatchItemsStr(String ftmatchItemsStr) {
        this.ftmatchItemsStr = ftmatchItemsStr;
    }

    public String getPassMode() {
        return passMode;
    }

    public void setPassMode(String passMode) {
        this.passMode = passMode;
    }

    public String getIsOnlyPlay() {
        return isOnlyPlay;
    }

    public void setIsOnlyPlay(String isOnlyPlay) {
        this.isOnlyPlay = isOnlyPlay;
    }

    public String getMaxSp() {
        return maxSp;
    }

    public void setMaxSp(String maxSp) {
        this.maxSp = maxSp;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc;
    }

    public Integer getPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(Integer publicStatus) {
        this.publicStatus = publicStatus;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(Integer isFocus) {
        this.isFocus = isFocus;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public Integer getBetCount() {
        return betCount;
    }

    public void setBetCount(Integer betCount) {
        this.betCount = betCount;
    }

    public String getIsDs() {
        return isDs;
    }

    public void setIsDs(String isDs) {
        this.isDs = isDs;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }
}
