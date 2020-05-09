package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class Commision2 implements Serializable {
    private Integer id;

    private Integer agentMemberId;

    private Integer lowerMemberId;

    private Double commision;

    private Date date;

    private Integer planNo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgentMemberId() {
        return agentMemberId;
    }

    public void setAgentMemberId(Integer agentMemberId) {
        this.agentMemberId = agentMemberId;
    }

    public Integer getLowerMemberId() {
        return lowerMemberId;
    }

    public void setLowerMemberId(Integer lowerMemberId) {
        this.lowerMemberId = lowerMemberId;
    }

    public Double getCommision() {
        return commision;
    }

    public void setCommision(Double commision) {
        this.commision = commision;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", agentMemberId=").append(agentMemberId);
        sb.append(", lowerMemberId=").append(lowerMemberId);
        sb.append(", commision=").append(commision);
        sb.append(", date=").append(date);
        sb.append(", planNo=").append(planNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}