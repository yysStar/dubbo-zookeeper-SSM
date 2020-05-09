package com.qiyun.model2;

import java.io.Serializable;

public class MemberRate2WithBLOBs extends MemberRate2 implements Serializable {
    private String dgRate;

    private String hmRate;

    private String applyRemark;

    private static final long serialVersionUID = 1L;

    public String getDgRate() {
        return dgRate;
    }

    public void setDgRate(String dgRate) {
        this.dgRate = dgRate == null ? null : dgRate.trim();
    }

    public String getHmRate() {
        return hmRate;
    }

    public void setHmRate(String hmRate) {
        this.hmRate = hmRate == null ? null : hmRate.trim();
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark == null ? null : applyRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dgRate=").append(dgRate);
        sb.append(", hmRate=").append(hmRate);
        sb.append(", applyRemark=").append(applyRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}