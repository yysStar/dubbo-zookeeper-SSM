package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class MemberCloudsLine2 implements Serializable {
    private Integer walletLineNo;

    private Integer planNo;

    private Integer orderNo;

    private Integer operLineNo;

    private Integer transType;

    private String account;

    private Integer memberId;

    private Integer clouds;

    private Date createDateTime;

    private Double ableBalance;

    private Double freezeBalance;

    private Double heapBalance;

    private String remark;

    private static final long serialVersionUID = 1L;

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

    public Double getAbleBalance() {
        return ableBalance;
    }

    public void setAbleBalance(Double ableBalance) {
        this.ableBalance = ableBalance;
    }

    public Double getFreezeBalance() {
        return freezeBalance;
    }

    public void setFreezeBalance(Double freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    public Double getHeapBalance() {
        return heapBalance;
    }

    public void setHeapBalance(Double heapBalance) {
        this.heapBalance = heapBalance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", walletLineNo=").append(walletLineNo);
        sb.append(", planNo=").append(planNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", operLineNo=").append(operLineNo);
        sb.append(", transType=").append(transType);
        sb.append(", account=").append(account);
        sb.append(", memberId=").append(memberId);
        sb.append(", clouds=").append(clouds);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", ableBalance=").append(ableBalance);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", heapBalance=").append(heapBalance);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}