package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class LotteryLimit2 implements Serializable {
    private Integer id;

    /**
     * 鍐呭
     */
    private String content;

    /**
     * 鐘舵�� 1鏈夋晥 0鏃犳晥
     */
    private Integer status;

    private Date createTime;

    /**
     * 褰╃  38瓒崇悆  39绡悆
     */
    private Integer lotteryType;

    /**
     * 涓叉硶
     */
    private String passType;

    /**
     * 璧涗簨鎴鏃堕棿
     */
    private Date dealTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType == null ? null : passType.trim();
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", passType=").append(passType);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}