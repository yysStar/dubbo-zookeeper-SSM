package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberMasterMapping {
    private Integer id;

    private String account;

    private Boolean isMaster;

    private Boolean isHighgrade;

    private Date createDatetime;

    private Date updateDatetime;

    private Integer sort;

    private Boolean isFastExamine;

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

    public Boolean getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(Boolean isMaster) {
        this.isMaster = isMaster;
    }

    public Boolean getIsHighgrade() {
        return isHighgrade;
    }

    public void setIsHighgrade(Boolean isHighgrade) {
        this.isHighgrade = isHighgrade;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsFastExamine() {
        return isFastExamine;
    }

    public void setIsFastExamine(Boolean isFastExamine) {
        this.isFastExamine = isFastExamine;
    }
}