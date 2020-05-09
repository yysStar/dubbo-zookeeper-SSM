package com.qiyun.dto;

import java.io.Serializable;

public class MemberClouds2DTO implements Serializable {
    private Integer id;

    /**
     * 用户名
     */
    private String account;

    /**
     * 可用云朵
     */
    private Double cloudsAbleBalance;

    private Double takeCashQuota;

    /**
     * 冻结云朵
     */
    private Double freezeBalance;

    /**
     * 历史消费
     */
    private Double heapBalance;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Double getCloudsAbleBalance() {
        return cloudsAbleBalance;
    }

    public void setCloudsAbleBalance(Double cloudsAbleBalance) {
        this.cloudsAbleBalance = cloudsAbleBalance;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", cloudsAbleBalance=").append(cloudsAbleBalance);
        sb.append(", takeCashQuota=").append(takeCashQuota);
        sb.append(", freezeBalance=").append(freezeBalance);
        sb.append(", heapBalance=").append(heapBalance);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
