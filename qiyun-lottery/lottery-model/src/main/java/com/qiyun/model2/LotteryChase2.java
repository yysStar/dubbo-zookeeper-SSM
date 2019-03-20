package com.qiyun.model2;

import java.util.Date;

public class LotteryChase2 {
    private Integer chaseNo;

    private String account;

    private Integer lotteryType;

    private Integer chaseType;

    private Integer amount;

    private Integer status;

    private Integer walletType;

    private Integer selectType;

    private Integer playType;

    private Integer multiple;

    private String addAttribute;

    private String verifyMd5;

    private Date createDateTime;

    private Integer isPackage;

    private Double packageAmount;

    private Integer totalTerm;

    private Integer soldTerm;

    private Double totalPrize;

    private String stopCondition;

    private String startCondition;

    private String gainCondition;

    private Integer genType;

    private Integer tradeType;

    private Integer platform;

    private String chaseContent;

    public Integer getChaseNo() {
        return chaseNo;
    }

    public void setChaseNo(Integer chaseNo) {
        this.chaseNo = chaseNo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public Integer getChaseType() {
        return chaseType;
    }

    public void setChaseType(Integer chaseType) {
        this.chaseType = chaseType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWalletType() {
        return walletType;
    }

    public void setWalletType(Integer walletType) {
        this.walletType = walletType;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public String getAddAttribute() {
        return addAttribute;
    }

    public void setAddAttribute(String addAttribute) {
        this.addAttribute = addAttribute == null ? null : addAttribute.trim();
    }

    public String getVerifyMd5() {
        return verifyMd5;
    }

    public void setVerifyMd5(String verifyMd5) {
        this.verifyMd5 = verifyMd5 == null ? null : verifyMd5.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getIsPackage() {
        return isPackage;
    }

    public void setIsPackage(Integer isPackage) {
        this.isPackage = isPackage;
    }

    public Double getPackageAmount() {
        return packageAmount;
    }

    public void setPackageAmount(Double packageAmount) {
        this.packageAmount = packageAmount;
    }

    public Integer getTotalTerm() {
        return totalTerm;
    }

    public void setTotalTerm(Integer totalTerm) {
        this.totalTerm = totalTerm;
    }

    public Integer getSoldTerm() {
        return soldTerm;
    }

    public void setSoldTerm(Integer soldTerm) {
        this.soldTerm = soldTerm;
    }

    public Double getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(Double totalPrize) {
        this.totalPrize = totalPrize;
    }

    public String getStopCondition() {
        return stopCondition;
    }

    public void setStopCondition(String stopCondition) {
        this.stopCondition = stopCondition == null ? null : stopCondition.trim();
    }

    public String getStartCondition() {
        return startCondition;
    }

    public void setStartCondition(String startCondition) {
        this.startCondition = startCondition == null ? null : startCondition.trim();
    }

    public String getGainCondition() {
        return gainCondition;
    }

    public void setGainCondition(String gainCondition) {
        this.gainCondition = gainCondition == null ? null : gainCondition.trim();
    }

    public Integer getGenType() {
        return genType;
    }

    public void setGenType(Integer genType) {
        this.genType = genType;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getChaseContent() {
        return chaseContent;
    }

    public void setChaseContent(String chaseContent) {
        this.chaseContent = chaseContent == null ? null : chaseContent.trim();
    }
}