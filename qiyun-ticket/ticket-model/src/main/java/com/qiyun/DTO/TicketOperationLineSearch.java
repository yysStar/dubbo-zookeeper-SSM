package com.qiyun.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class TicketOperationLineSearch implements Serializable {
    private String account;
    private String ticketApparatusId;
    private BigDecimal startAmount;
    private BigDecimal endAmount;
    private Integer transType;
    private String startCreateTime;
    private String endCreateTime;
    private int page = 1;
    private int pageSize = 10;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTicketApparatusId() {
        return ticketApparatusId;
    }

    public void setTicketApparatusId(String ticketApparatusId) {
        this.ticketApparatusId = ticketApparatusId;
    }

    public BigDecimal getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(BigDecimal startAmount) {
        this.startAmount = startAmount;
    }

    public BigDecimal getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(BigDecimal endAmount) {
        this.endAmount = endAmount;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public String getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(String startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public String getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(String endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
