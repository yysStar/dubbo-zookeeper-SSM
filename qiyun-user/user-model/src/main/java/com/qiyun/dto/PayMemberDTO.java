package com.qiyun.dto;

import java.io.Serializable;

public class PayMemberDTO implements Serializable {
    private Integer id;
    private String account;
    private String name;
    private Integer sourceId;
    private String sourceAccount;
    private Integer type; // 0 渠道  1代理 2会员
    private Integer sourceType;
    private String payWays;

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
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getPayWays() {
        return payWays;
    }

    public void setPayWays(String payWays) {
        this.payWays = payWays;
    }
}
