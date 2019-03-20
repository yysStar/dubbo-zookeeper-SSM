package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class MemberRate2 implements Serializable {
    private Integer id;

    private Integer memberId;

    private String account;

    private Integer lotteryType;

    private Date createDate;

    private Integer returnPointType;

    private Double jjDgRate;

    private Double jjHmRate;

    private Double fdDgRate;

    private Double fdHmRate;

    private Date rateCreateDate;

    private Date rateEndDate;

    private Integer isSetRate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getReturnPointType() {
        return returnPointType;
    }

    public void setReturnPointType(Integer returnPointType) {
        this.returnPointType = returnPointType;
    }

    public Double getJjDgRate() {
        return jjDgRate;
    }

    public void setJjDgRate(Double jjDgRate) {
        this.jjDgRate = jjDgRate;
    }

    public Double getJjHmRate() {
        return jjHmRate;
    }

    public void setJjHmRate(Double jjHmRate) {
        this.jjHmRate = jjHmRate;
    }

    public Double getFdDgRate() {
        return fdDgRate;
    }

    public void setFdDgRate(Double fdDgRate) {
        this.fdDgRate = fdDgRate;
    }

    public Double getFdHmRate() {
        return fdHmRate;
    }

    public void setFdHmRate(Double fdHmRate) {
        this.fdHmRate = fdHmRate;
    }

    public Date getRateCreateDate() {
        return rateCreateDate;
    }

    public void setRateCreateDate(Date rateCreateDate) {
        this.rateCreateDate = rateCreateDate;
    }

    public Date getRateEndDate() {
        return rateEndDate;
    }

    public void setRateEndDate(Date rateEndDate) {
        this.rateEndDate = rateEndDate;
    }

    public Integer getIsSetRate() {
        return isSetRate;
    }

    public void setIsSetRate(Integer isSetRate) {
        this.isSetRate = isSetRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", account=").append(account);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", createDate=").append(createDate);
        sb.append(", returnPointType=").append(returnPointType);
        sb.append(", jjDgRate=").append(jjDgRate);
        sb.append(", jjHmRate=").append(jjHmRate);
        sb.append(", fdDgRate=").append(fdDgRate);
        sb.append(", fdHmRate=").append(fdHmRate);
        sb.append(", rateCreateDate=").append(rateCreateDate);
        sb.append(", rateEndDate=").append(rateEndDate);
        sb.append(", isSetRate=").append(isSetRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}