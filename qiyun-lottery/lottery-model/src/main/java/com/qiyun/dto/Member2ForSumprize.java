package com.qiyun.dto;


import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.utils.StringUtils;

import java.io.Serializable;

public class Member2ForSumprize implements Serializable,Comparable<Member2ForSumprize> {
    private String account;
    private String username;
    private double sumPrize;
    private String picture;

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

    public double getSumPrize() {
        return sumPrize;
    }

    public void setSumPrize(double sumPrize) {
        this.sumPrize = sumPrize;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureUrl(){
        if (!StringUtils.isNullOrBlank(getPicture())) {
            return "qyun88.oss-cn-hangzhou.aliyuncs.com/member/"+this.getPicture();
        }
        return null;
    }

    public int compareTo(Member2ForSumprize o) {
        int i = (int) (o.getSumPrize() - this.getSumPrize());
        return i;
    }
}
