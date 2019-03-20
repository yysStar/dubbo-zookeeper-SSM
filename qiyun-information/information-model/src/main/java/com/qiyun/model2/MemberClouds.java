package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberClouds {
    private Integer id;

    private String account;

    private Integer cloudsAbleBalance;

    private Double takeCashQuota;

    private Integer freezeBalance;

    private Integer heapBalance;

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

    public Integer getCloudsAbleBalance() {
        return cloudsAbleBalance;
    }

    public void setCloudsAbleBalance(Integer cloudsAbleBalance) {
        this.cloudsAbleBalance = cloudsAbleBalance;
    }

    public Double getTakeCashQuota() {
        return takeCashQuota;
    }

    public void setTakeCashQuota(Double takeCashQuota) {
        this.takeCashQuota = takeCashQuota;
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
}