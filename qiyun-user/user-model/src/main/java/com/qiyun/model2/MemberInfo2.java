package com.qiyun.model2;

import java.io.Serializable;

public class MemberInfo2 implements Serializable {
    private Integer memberId;

    private String account;

    private String bank;

    private String bankCard;

    private String bankPart;

    private Integer isDnapayUser;

    private Integer isUmpayOkp;

    private Integer isLianlianpayOkp;

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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public String getBankPart() {
        return bankPart;
    }

    public void setBankPart(String bankPart) {
        this.bankPart = bankPart == null ? null : bankPart.trim();
    }

    public Integer getIsDnapayUser() {
        return isDnapayUser;
    }

    public void setIsDnapayUser(Integer isDnapayUser) {
        this.isDnapayUser = isDnapayUser;
    }

    public Integer getIsUmpayOkp() {
        return isUmpayOkp;
    }

    public void setIsUmpayOkp(Integer isUmpayOkp) {
        this.isUmpayOkp = isUmpayOkp;
    }

    public Integer getIsLianlianpayOkp() {
        return isLianlianpayOkp;
    }

    public void setIsLianlianpayOkp(Integer isLianlianpayOkp) {
        this.isLianlianpayOkp = isLianlianpayOkp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append(", account=").append(account);
        sb.append(", bank=").append(bank);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", bankPart=").append(bankPart);
        sb.append(", isDnapayUser=").append(isDnapayUser);
        sb.append(", isUmpayOkp=").append(isUmpayOkp);
        sb.append(", isLianlianpayOkp=").append(isLianlianpayOkp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}