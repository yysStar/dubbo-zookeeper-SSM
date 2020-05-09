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
public class WinPromotionCommentLike implements Serializable {
    private Integer id;

    private Integer planId;

    private Integer commentFloor;

    private String linkeAccount;

    private Date time;

    private Integer type;

    private String mark;

}