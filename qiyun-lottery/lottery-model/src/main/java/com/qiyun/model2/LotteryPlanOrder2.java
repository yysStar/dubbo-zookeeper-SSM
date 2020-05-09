package com.qiyun.model2;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LotteryPlanOrder2 implements Serializable {
    private Integer orderNo;

    private Integer planNo;

    private String account;

    private Integer buyType;

    private Date createDateTime;

    private Integer status;

    private Integer part;

    private Integer amount;

    private Double posttaxPrize;

    private Integer prizeSettleStatus;

    private Date prizeSettleDateTime;

    private Integer score;

    private Integer experience;

    private String verifyMd5;

    private Date returnAmountDateTime;

    private Integer memberId;

    private Integer walletType;

    private Integer followingType;

    private Integer platform;

    private Double gold;

    private Double sumGold;

    private Double webSiteGold;

    private static final long serialVersionUID = 1L;

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPart() {
        return part;
    }

    public void setPart(Integer part) {
        this.part = part;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPosttaxPrize() {
        return posttaxPrize;
    }

    public void setPosttaxPrize(Double posttaxPrize) {
        this.posttaxPrize = posttaxPrize;
    }

    public Integer getPrizeSettleStatus() {
        return prizeSettleStatus;
    }

    public void setPrizeSettleStatus(Integer prizeSettleStatus) {
        this.prizeSettleStatus = prizeSettleStatus;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getPrizeSettleDateTime() {
        return prizeSettleDateTime;
    }

    public void setPrizeSettleDateTime(Date prizeSettleDateTime) {
        this.prizeSettleDateTime = prizeSettleDateTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getVerifyMd5() {
        return verifyMd5;
    }

    public void setVerifyMd5(String verifyMd5) {
        this.verifyMd5 = verifyMd5 == null ? null : verifyMd5.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getReturnAmountDateTime() {
        return returnAmountDateTime;
    }

    public void setReturnAmountDateTime(Date returnAmountDateTime) {
        this.returnAmountDateTime = returnAmountDateTime;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getWalletType() {
        return walletType;
    }

    public void setWalletType(Integer walletType) {
        this.walletType = walletType;
    }

    public Integer getFollowingType() {
        return followingType;
    }

    public void setFollowingType(Integer followingType) {
        this.followingType = followingType;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Double getGold() {
        return gold;
    }

    public void setGold(Double gold) {
        this.gold = gold;
    }

    public Double getSumGold() {
        return sumGold;
    }

    public void setSumGold(Double sumGold) {
        this.sumGold = sumGold;
    }

    public Double getWebSiteGold() {
        return webSiteGold;
    }

    public void setWebSiteGold(Double webSiteGold) {
        this.webSiteGold = webSiteGold;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderNo=").append(orderNo);
        sb.append(", planNo=").append(planNo);
        sb.append(", account=").append(account);
        sb.append(", buyType=").append(buyType);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", status=").append(status);
        sb.append(", part=").append(part);
        sb.append(", amount=").append(amount);
        sb.append(", posttaxPrize=").append(posttaxPrize);
        sb.append(", prizeSettleStatus=").append(prizeSettleStatus);
        sb.append(", prizeSettleDateTime=").append(prizeSettleDateTime);
        sb.append(", score=").append(score);
        sb.append(", experience=").append(experience);
        sb.append(", verifyMd5=").append(verifyMd5);
        sb.append(", returnAmountDateTime=").append(returnAmountDateTime);
        sb.append(", memberId=").append(memberId);
        sb.append(", walletType=").append(walletType);
        sb.append(", followingType=").append(followingType);
        sb.append(", platform=").append(platform);
        sb.append(", gold=").append(gold);
        sb.append(", sumGold=").append(sumGold);
        sb.append(", webSiteGold=").append(webSiteGold);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}