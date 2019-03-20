package com.qiyun.model2;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentWithBLOBs extends Comment implements Serializable {
    private String connect;

    private String reply;

    private String time;

    private String isLike;

    private String rTime;

}