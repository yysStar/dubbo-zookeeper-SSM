package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class MemberRewardMapping implements Serializable {
    private Integer id;

    private String rewarder;

    private String picture;

    private String beRewarder;

    private Integer cloudNum;

    private Date rewardDatetime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRewarder() {
        return rewarder;
    }

    public void setRewarder(String rewarder) {
        this.rewarder = rewarder == null ? null : rewarder.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getBeRewarder() {
        return beRewarder;
    }

    public void setBeRewarder(String beRewarder) {
        this.beRewarder = beRewarder == null ? null : beRewarder.trim();
    }

    public Integer getCloudNum() {
        return cloudNum;
    }

    public void setCloudNum(Integer cloudNum) {
        this.cloudNum = cloudNum;
    }

    public Date getRewardDatetime() {
        return rewardDatetime;
    }

    public void setRewardDatetime(Date rewardDatetime) {
        this.rewardDatetime = rewardDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}