package com.qiyun.model2;

public class LotteryPlanWithBLOBs extends LotteryPlan {
    private String prizeContent;

    private String content;

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
}