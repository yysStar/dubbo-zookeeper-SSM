package com.qiyun.model;

import java.util.Date;

public class MemberAgentCommision {
    //ID
    private Integer id;
    //代理ID
    private Integer memberAgentId;
    //下线ID
    private Integer memberLowerId;
    //代理佣金
    private Double agentCommision;
    //下线佣金
    private Double lowerCommision;
    //方案编号
    private Integer planId;
    //代理佣金比例
    private Double agentRate;
    //下线佣金比例
    private Double lowerRate;
    //创建时间
    private Date createDateTime;
    //备注
    private String remark;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMemberAgentId() {
        return memberAgentId;
    }
    public void setMemberAgentId(Integer memberAgentId) {
        this.memberAgentId = memberAgentId;
    }
    public Integer getMemberLowerId() {
        return memberLowerId;
    }
    public void setMemberLowerId(Integer memberLowerId) {
        this.memberLowerId = memberLowerId;
    }
    public Double getAgentCommision() {
        return agentCommision;
    }
    public void setAgentCommision(Double agentCommision) {
        this.agentCommision = agentCommision;
    }
    public Double getLowerCommision() {
        return lowerCommision;
    }
    public void setLowerCommision(Double lowerCommision) {
        this.lowerCommision = lowerCommision;
    }
    public Integer getPlanId() {
        return planId;
    }
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    public Double getAgentRate() {
        return agentRate;
    }
    public void setAgentRate(Double agentRate) {
        this.agentRate = agentRate;
    }
    public Double getLowerRate() {
        return lowerRate;
    }
    public void setLowerRate(Double lowerRate) {
        this.lowerRate = lowerRate;
    }
    public Date getCreateDateTime() {
        return createDateTime;
    }
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
