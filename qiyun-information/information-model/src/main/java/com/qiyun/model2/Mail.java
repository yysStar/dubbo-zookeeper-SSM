package com.qiyun.model2;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Mail implements Serializable {
    private Integer id;

    private String title;

    private Integer type;

    private String target;

    private Date createDate;

    private String createTime;

    private String author;

    private Integer status;

    private String content;

}