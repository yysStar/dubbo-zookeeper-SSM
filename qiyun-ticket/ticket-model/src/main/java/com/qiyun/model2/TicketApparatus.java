package com.qiyun.model2;

import java.io.Serializable;
import java.math.BigDecimal;

public class TicketApparatus implements Serializable {
    private String id;

    /**
     * 浣欓
     */
    private BigDecimal ableBalance;

    /**
     * 鍘嗗彶浠锋閲戦
     */
    private BigDecimal heapAddBalance;

    /**
     * 鍘嗗彶涓
     */
    private BigDecimal bonus;

    /**
     * 鐘舵��  0缁翠慨  1姝ｅ父
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public BigDecimal getAbleBalance() {
        return ableBalance;
    }

    public void setAbleBalance(BigDecimal ableBalance) {
        this.ableBalance = ableBalance;
    }

    public BigDecimal getHeapAddBalance() {
        return heapAddBalance;
    }

    public void setHeapAddBalance(BigDecimal heapAddBalance) {
        this.heapAddBalance = heapAddBalance;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
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
        sb.append(", id=").append(id);
        sb.append(", ableBalance=").append(ableBalance);
        sb.append(", heapAddBalance=").append(heapAddBalance);
        sb.append(", bonus=").append(bonus);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}