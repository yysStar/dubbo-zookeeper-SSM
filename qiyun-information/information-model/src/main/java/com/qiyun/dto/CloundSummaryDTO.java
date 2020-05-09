package com.qiyun.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CloundSummaryDTO implements Serializable {

    /**
     * 用户账户
     */
    private String account;

    /**
     * 充值云朵
     */
    private String Recharge = "0";

    /**
     * 提现云朵
     */
    private String Withdraw = "0";

    /**
     * 购买推荐云朵数
     */
    private String BuyRecommend = "0";

    /**
     * 不中退款云朵数
     */
    private String RecommendRefund = "0";

    /**
     * 打赏云朵数
     */
    private String Reward = "0";

    /**
     * 被购加款云朵数
     */
    private String RecommendIncome = "0";

    /**
     * 被打赏云朵数
     */
    private String RewardIncome = "0";

    /**
     * 快速审核扣款云朵数
     */
    private String QuickReviw = "0";

    /**
     * 当前云朵数
     */
    private int Clound = 0;
}
