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
public class WinPromotionComment implements Serializable {
    private Integer id;

    private Integer propagandaId;

    private String account;

    private String username;

    private String picture;

    private Date commentTime;

    private Integer status;

    private Integer sort;

    private Integer likeCount;

    private Integer floor;

    private String connect;

    private String isLike;

    private String time;

}