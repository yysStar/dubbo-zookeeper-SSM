package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
@Setter
@NoArgsConstructor
public class SuperGodDTO implements Serializable {
    /**
     * 昵称
     */
    private String name;
    /**
     * 账户名
     */
    private String account;
    /**
     * 头像图片
     */
    private String picture;
    /**
     * 关注人数
     */
    private int followNum;
    /**
     * 粉丝人数
     */
    private int fansNum;
    /**
     * 中奖总金额（近三月）
     */
    private BigDecimal bingoMoney;
    /**
     * 红单次数（近三月）
     */
    private int bingoNum;
    /**
     * 中奖率（近三月）
     */
    private BigDecimal winningRate;
    /**
     * 投注次数（近三月）
     */
    private int BuyNum;
    /**
     * 战绩（近10场战绩）
     */
    private String militaryExploits;
    /**
     * 回报率（近10场）
     */
    private BigDecimal rateOfReturn;
}
