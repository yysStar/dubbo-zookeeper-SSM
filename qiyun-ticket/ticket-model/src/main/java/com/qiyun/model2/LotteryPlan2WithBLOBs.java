package com.qiyun.model2;

import java.io.Serializable;

public class LotteryPlan2WithBLOBs extends LotteryPlan2 implements Serializable,Comparable<LotteryPlan2WithBLOBs> {
    private String prizeContent;

    private String content;

    private static final long serialVersionUID = 1L;

    public String getPrizeContent() {
        return prizeContent;
    }

    public void setPrizeContent(String prizeContent) {
        this.prizeContent = prizeContent == null ? null : prizeContent.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prizeContent=").append(prizeContent);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public int compareTo(LotteryPlan2WithBLOBs o) {
        int i = o.getAmount() - this.getAmount();
        return i;
    }
}