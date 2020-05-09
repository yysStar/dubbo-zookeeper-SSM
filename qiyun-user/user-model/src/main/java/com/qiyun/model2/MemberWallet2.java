package com.qiyun.model2;

import java.io.Serializable;

public class MemberWallet2 implements Serializable {
    private Integer id;

    private Integer memberId;

    /**
     * 用户名
     */
    private String account;

    /**
     * 可用金额
     */
    private Double ableBalance;

    private Double takeCashQuota;

    /**
     * 冻结金融
     */
    private Double freezeBalance;

    private Double heapBalance;

    private Double heapPrize;

    private String verifyMd5;

    private Integer walletType;

    private Double prizeBalance;

    private Double creditLimit;

    private Double ableCreditBalance;

    private Double freezeCreditBalance;

    private Double redPacketBalance;

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

    public Double getAbleBalance() {
        return ableBalance;
    }

    public void setAbleBalance(Double ableBalance) {
        this.ableBalance = ableBalance;
    }

    public Double getTakeCashQuota() {
        return takeCashQuota;
    }

    public void setTakeCashQuota(Double takeCashQuota) {
        this.takeCashQuota = takeCashQuota;
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

    public Double getHeapPrize() {
        return heapPrize;
    }

    public void setHeapPrize(Double heapPrize) {
        this.heapPrize = heapPrize;
    }

    public String getVerifyMd5() {
        return verifyMd5;
    }

    public void setVerifyMd5(String verifyMd5) {
        this.verifyMd5 = verifyMd5 == null ? null : verifyMd5.trim();
    }

    public Integer getWalletType() {
        return walletType;
    }

    public void setWalletType(Integer walletType) {
        this.walletType = walletType;
    }

    public Double getPrizeBalance() {
        return prizeBalance;
    }

    public void setPrizeBalance(Double prizeBalance) {
        this.prizeBalance = prizeBalance;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getAbleCreditBalance() {
        return ableCreditBalance;
    }

    public void setAbleCreditBalance(Double ableCreditBalance) {
        this.ableCreditBalance = ableCreditBalance;
    }

    public Double getFreezeCreditBalance() {
        return freezeCreditBalance;
    }

    public void setFreezeCreditBalance(Double freezeCreditBalance) {
        this.freezeCreditBalance = freezeCreditBalance;
    }

    public Double getRedPacketBalance() {
        return redPacketBalance;
    }

    public void setRedPacketBalance(Double redPacketBalance) {
        this.redPacketBalance = redPacketBalance;
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
        sb.append(", ableBalance=").append(ableBalance);
        sb.append(", takeCashQuota=").append(takeCashQuota);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", heapBalance=").append(heapBalance);
        sb.append(", heapPrize=").append(heapPrize);
        sb.append(", verifyMd5=").append(verifyMd5);
        sb.append(", walletType=").append(walletType);
        sb.append(", prizeBalance=").append(prizeBalance);
        sb.append(", creditLimit=").append(creditLimit);
        sb.append(", ableCreditBalance=").append(ableCreditBalance);
        sb.append(", freezeCreditBalance=").append(freezeCreditBalance);
        sb.append(", redPacketBalance=").append(redPacketBalance);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}