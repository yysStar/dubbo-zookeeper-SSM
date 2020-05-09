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
public class LotteryPlanLike implements Serializable {
    private Integer id;

    private Integer planNo;

    private String account;

    private Date likeTime;

    private Integer status;

}