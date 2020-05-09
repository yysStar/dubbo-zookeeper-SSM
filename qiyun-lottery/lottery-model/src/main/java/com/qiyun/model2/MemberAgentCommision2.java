package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class MemberAgentCommision2 implements Serializable {
    private Integer id;

    private Integer memberAgentId;

    private Integer memberLowerId;

    private Double agentCommision;

    private Double lowerCommision;

    private Integer planId;

    private Double agentRate;

    private Double lowerRate;

    private Date createDateTime;

    private String remark;

    private static final long serialVersionUID = 1L;

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
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberAgentId=").append(memberAgentId);
        sb.append(", memberLowerId=").append(memberLowerId);
        sb.append(", agentCommision=").append(agentCommision);
        sb.append(", lowerCommision=").append(lowerCommision);
        sb.append(", planId=").append(planId);
        sb.append(", agentRate=").append(agentRate);
        sb.append(", lowerRate=").append(lowerRate);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}