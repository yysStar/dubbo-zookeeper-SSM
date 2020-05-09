package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class LotteryPlanAddPrize2 implements Serializable {
    private Integer planNo;

    private Double rate;

    private Date addPrizeTime;

    private static final long serialVersionUID = 1L;

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getAddPrizeTime() {
        return addPrizeTime;
    }

    public void setAddPrizeTime(Date addPrizeTime) {
        this.addPrizeTime = addPrizeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", planNo=").append(planNo);
        sb.append(", rate=").append(rate);
        sb.append(", addPrizeTime=").append(addPrizeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}