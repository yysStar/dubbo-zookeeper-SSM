package com.qiyun.dto;

import com.qiyun.utils.StringUtils;

import java.io.Serializable;

public class MostPopularMemberDTO implements Serializable {
    private String account;
    private String username;
    private String picture;
    private int fans;

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

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }
    public String getPictureUrl() {
        if (!StringUtils.isNullOrBlank(getPicture())) {
            return "qyun88.oss-cn-hangzhou.aliyuncs.com/member/" + this.getPicture();
        }
        return null;
    }
}
