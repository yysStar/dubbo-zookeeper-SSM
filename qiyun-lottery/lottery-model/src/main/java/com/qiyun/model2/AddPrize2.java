package com.qiyun.model2;

import java.io.Serializable;

public class AddPrize2 implements Serializable {
    private Integer lotteryType;

    private Double rate;

    private Double minAmount;

    private String playTypes;

    private static final long serialVersionUID = 1L;

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public String getPlayTypes() {
        return playTypes;
    }

    public void setPlayTypes(String playTypes) {
        this.playTypes = playTypes == null ? null : playTypes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", rate=").append(rate);
        sb.append(", minAmount=").append(minAmount);
        sb.append(", playTypes=").append(playTypes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}