package com.qiyun.dto;

import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.utils.StringUtils;

import java.io.Serializable;

public class EvenTheRedMemberDTO implements Serializable,Comparable<EvenTheRedMemberDTO> {
    private String account;
    private String username;
    private String picture;
    private int count;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public String getPictureUrl() {
        if (!StringUtils.isNullOrBlank(getPicture())) {
            return "qyun88.oss-cn-hangzhou.aliyuncs.com/member/" + this.getPicture();
        }
        return null;
    }

    public int compareTo(EvenTheRedMemberDTO o) {
        int i = o.getCount() - this.getCount();
        return i;
    }

    @Override
    public String toString() {
        return "EvenTheRedMemberDTO{" +
                "account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", picture='" + picture + '\'' +
                ", count=" + count +
                '}';
    }
}
