package com.qiyun.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MemberWalletDTO implements Serializable{
    private Integer memberId;

    /**
     * 用户名
     */
    private String account;

    /**
     * 可用金额
     */
    private BigDecimal usableMoney;

    /**
     * 冻结金额
     */
    private BigDecimal freezeMoney;

    /**
     * 提现配额
     */
    private BigDecimal cashQuota;

    /**
     * 历史消费金额
     */
    private BigDecimal historyMoney;

    /**
     * 历史中奖余额
     */
    private BigDecimal historyPrize;

    /**
     * MD5验证码
     */
    private String verifyMd5;

    /**
     * 钱包种类
     */
    private Integer walletType;

    private Double creditLimit;

    private Double ableCreditBalance;

    private Double freezeCreditBalance;

    private static final long serialVersionUID = 1L;

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

    public BigDecimal getUsableMoney() {
        return usableMoney;
    }

    public void setUsableMoney(BigDecimal usableMoney) {
        this.usableMoney = usableMoney;
    }

    public BigDecimal getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(BigDecimal freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public BigDecimal getCashQuota() {
        return cashQuota;
    }

    public void setCashQuota(BigDecimal cashQuota) {
        this.cashQuota = cashQuota;
    }

    public BigDecimal getHistoryMoney() {
        return historyMoney;
    }

    public void setHistoryMoney(BigDecimal historyMoney) {
        this.historyMoney = historyMoney;
    }

    public BigDecimal getHistoryPrize() {
        return historyPrize;
    }

    public void setHistoryPrize(BigDecimal historyPrize) {
        this.historyPrize = historyPrize;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append(", account=").append(account);
        sb.append(", usableMoney=").append(usableMoney);
        sb.append(", freezeMoney=").append(freezeMoney);
        sb.append(", cashQuota=").append(cashQuota);
        sb.append(", historyMoney=").append(historyMoney);
        sb.append(", historyPrize=").append(historyPrize);
        sb.append(", verifyMd5=").append(verifyMd5);
        sb.append(", walletType=").append(walletType);
        sb.append(", creditLimit=").append(creditLimit);
        sb.append(", ableCreditBalance=").append(ableCreditBalance);
        sb.append(", freezeCreditBalance=").append(freezeCreditBalance);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
