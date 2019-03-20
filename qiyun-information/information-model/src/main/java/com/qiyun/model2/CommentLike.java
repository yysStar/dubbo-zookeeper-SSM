package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentLike implements Serializable {
    private Integer id;

    private Integer planId;

    private Integer commentFloor;

    private String linkeAccount;

    private Date time;

    private Integer type;

    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getCommentFloor() {
        return commentFloor;
    }

    public void setCommentFloor(Integer commentFloor) {
        this.commentFloor = commentFloor;
    }

    public String getLinkeAccount() {
        return linkeAccount;
    }

    public void setLinkeAccount(String linkeAccount) {
        this.linkeAccount = linkeAccount == null ? null : linkeAccount.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}