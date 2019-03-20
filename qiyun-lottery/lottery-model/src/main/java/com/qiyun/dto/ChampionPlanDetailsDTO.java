package com.qiyun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 订单详情
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChampionPlanDetailsDTO extends ChampionPlanDTO {
    /**
     * 用户头像
     */
    private String picture;
    /**
     * 昵称
     */
    private String userName;
    /**
     * 回报率
     */
    private BigDecimal rateOfReturn;
}
