package com.qiyun.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TicketBusiness implements Serializable {
    private Integer id;

    private String name;

    private Date createDatetime;

    private Date startDatetime;

    private Date endDatetime;

    private BigDecimal maxQuota;

    private Boolean isDefault;

    private BigDecimal preDeposit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public BigDecimal getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(BigDecimal maxQuota) {
        this.maxQuota = maxQuota;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public BigDecimal getPreDeposit() {
        return preDeposit;
    }

    public void setPreDeposit(BigDecimal preDeposit) {
        this.preDeposit = preDeposit;
    }
}