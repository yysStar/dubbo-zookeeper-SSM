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
public class Comment implements Serializable {
    private Integer id;

    private Integer planNo;

    private String planAccount;

    private String planUsername;

    private String planPicture;

    private String account;

    private String username;

    private String picture;

    private Integer status;

    private Integer floor;

    private Date commentTime;

    private Date replyTime;

    private Integer likeCount;

    private Integer isRead;

}