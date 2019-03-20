package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlanDTO implements Serializable {
    /**
     * 方案号
     */
    private int planNo;
    /**
     * 玩法
     */
    private String lotteryType;
    /**
     * 投注总金额
     */
    private int allBuyMoney;
    /**
     * 发起金额
     */
    private int amount;
    /**
     * 总金额
     */
    private int sumAmount;
    /**
     * 单倍金额
     */
    private int unitPrice;
    /**
     * 参与人数
     */
    private int peopleNum;
    /**
     * 奖金
     */
    private BigDecimal bingoMoney;
    /**
     * 点赞数
     */
    private int likeCount;
}
