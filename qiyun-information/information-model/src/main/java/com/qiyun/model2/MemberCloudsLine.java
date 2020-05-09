package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberCloudsLine implements Serializable {
    private Integer walletLineNo;

    private Integer planNo;

    private Integer orderNo;

    private Integer operLineNo;

    private Integer transType;

    private String account;

    private Integer memberId;

    private Integer clouds;

    private Date createDateTime;

    private Integer ableBalance;

    private Integer freezeBalance;

    private Integer heapBalance;

    private String remark;

    public Integer getWalletLineNo() {
        return walletLineNo;
    }

    public void setWalletLineNo(Integer walletLineNo) {
        this.walletLineNo = walletLineNo;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOperLineNo() {
        return operLineNo;
    }

    public void setOperLineNo(Integer operLineNo) {
        this.operLineNo = operLineNo;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getAbleBalance() {
        return ableBalance;
    }

    public void setAbleBalance(Integer ableBalance) {
        this.ableBalance = ableBalance;
    }

    public Integer getFreezeBalance() {
        return freezeBalance;
    }

    public void setFreezeBalance(Integer freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    public Integer getHeapBalance() {
        return heapBalance;
    }

    public void setHeapBalance(Integer heapBalance) {
        this.heapBalance = heapBalance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}