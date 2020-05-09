package com.qiyun.model2;

import java.util.Date;

public class MemberMasterMapping {
    private Integer id;

    private Integer account;

    private Boolean isMaster;

    private Boolean isHighgrade;

    private Date createDatetime;

    private Date updateDatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
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
}