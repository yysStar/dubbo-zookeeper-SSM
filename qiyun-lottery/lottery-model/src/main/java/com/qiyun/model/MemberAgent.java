package com.qiyun.model;

import java.io.Serializable;
import java.util.Date;

public class MemberAgent implements Serializable {
    private Integer id;

    private Integer memberId;

    private String account;

    private String name;

    private String mobile;

    private Date createDateTime;

    /**
     * 是否有效，1为有效
     */
    private Integer status;

    /**
     * 0为渠道，1为代理
     */
    private Integer agentType;

    private Integer isSetRate;

    /**
     * 激活码,唯一性
     */
    private String activeCode;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }

    public Integer getIsSetRate() {
        return isSetRate;
    }

    public void setIsSetRate(Integer isSetRate) {
        this.isSetRate = isSetRate;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode == null ? null : activeCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", mobile=").append(mobile);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", status=").append(status);
        sb.append(", agentType=").append(agentType);
        sb.append(", isSetRate=").append(isSetRate);
        sb.append(", activeCode=").append(activeCode);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}