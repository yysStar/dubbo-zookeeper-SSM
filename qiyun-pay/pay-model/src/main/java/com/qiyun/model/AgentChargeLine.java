package com.qiyun.model;

import java.io.Serializable;
import java.util.Date;

public class AgentChargeLine implements Serializable {
    private Integer id;

    private String agentAccount;

    /**
     * 用户名
     */
    private String account;

    /**
     * 昵称
     */
    private String username;

    private Double amount;

    private Date createTime;

    private Double creditLimit;

    private Double ableCreditBalance;

    private Double freezeCreditBalance;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgentAccount() {
        return agentAccount;
    }

    public void setAgentAccount(String agentAccount) {
        this.agentAccount = agentAccount == null ? null : agentAccount.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        sb.append(", id=").append(id);
        sb.append(", agentAccount=").append(agentAccount);
        sb.append(", account=").append(account);
        sb.append(", username=").append(username);
        sb.append(", amount=").append(amount);
        sb.append(", createTime=").append(createTime);
        sb.append(", creditLimit=").append(creditLimit);
        sb.append(", ableCreditBalance=").append(ableCreditBalance);
        sb.append(", freezeCreditBalance=").append(freezeCreditBalance);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}