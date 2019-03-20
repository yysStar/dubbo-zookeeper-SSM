package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {
    private Integer id;

    private String type;

    private Integer click;

    private Date createDateTime;

    private String createTime;

    private Date showDateTime;

    private Integer isShow;

    private String title;

    private String shortTitle;

    private String keyword;

    private Integer contentType;

    private String link;

    private Integer sort;

    private String newsSource;

    private String summary;

    private String label;

    private String editor;

    private String picture;

    private String content;

}