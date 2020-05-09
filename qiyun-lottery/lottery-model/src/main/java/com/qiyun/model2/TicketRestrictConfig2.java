package com.qiyun.model2;

import java.io.Serializable;

public class TicketRestrictConfig2 implements Serializable {
    /**
     * 鏄惁鑷喘  1鏄� 0涓嶆槸
     */
    private Integer isSuper;

    private Double amount;

    private Double bonus;

    /**
     * 鏄惁鏈夋晥 1鏈夋晥 0鏃犳晥
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Integer isSuper) {
        this.isSuper = isSuper;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", isSuper=").append(isSuper);
        sb.append(", amount=").append(amount);
        sb.append(", bonus=").append(bonus);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}