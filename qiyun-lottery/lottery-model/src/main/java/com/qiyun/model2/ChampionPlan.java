package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChampionPlan implements Serializable {
    private Integer id;

    private String orderNo;

    private Integer type;

    private Integer multiple;

    private Integer amount;

    private Integer perAmount;

    private Integer bingoStatus;

    private BigDecimal bingoMoney;

    private String account;

    private Date createTime;

    private Integer ticketStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPerAmount() {
        return perAmount;
    }

    public void setPerAmount(Integer perAmount) {
        this.perAmount = perAmount;
    }

    public Integer getBingoStatus() {
        return bingoStatus;
    }

    public void setBingoStatus(Integer bingoStatus) {
        this.bingoStatus = bingoStatus;
    }

    public BigDecimal getBingoMoney() {
        return bingoMoney;
    }

    public void setBingoMoney(BigDecimal bingoMoney) {
        this.bingoMoney = bingoMoney;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}