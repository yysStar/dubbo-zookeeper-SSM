package com.qiyun.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberWalletLine2 implements Serializable {
    private Integer walletLineNo;

    private Integer planNo;

    private Integer orderNo;

    private Integer operLineNo;

    private String account;

    private Integer memberId;

    private Integer transType;

    private Integer walletType;

    private Double amount;

    private Integer lotteryType;

    private Date createDateTime;

    private Integer status;

    private String verifyMd5;

    private Integer sourceId;

    private Double ableBalance;

    private Double freezeBalance;

    private Double heapBalance;

    private Double prizeBalance;

    private Integer platform;

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

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public Integer getWalletType() {
        return walletType;
    }

    public void setWalletType(Integer walletType) {
        this.walletType = walletType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
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

    public String getVerifyMd5() {
        return verifyMd5;
    }

    public void setVerifyMd5(String verifyMd5) {
        this.verifyMd5 = verifyMd5 == null ? null : verifyMd5.trim();
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
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

    public Double getPrizeBalance() {
        return prizeBalance;
    }

    public void setPrizeBalance(Double prizeBalance) {
        this.prizeBalance = prizeBalance;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
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
        sb.append(", account=").append(account);
        sb.append(", memberId=").append(memberId);
        sb.append(", transType=").append(transType);
        sb.append(", walletType=").append(walletType);
        sb.append(", amount=").append(amount);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", status=").append(status);
        sb.append(", verifyMd5=").append(verifyMd5);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", ableBalance=").append(ableBalance);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", heapBalance=").append(heapBalance);
        sb.append(", prizeBalance=").append(prizeBalance);
        sb.append(", platform=").append(platform);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}