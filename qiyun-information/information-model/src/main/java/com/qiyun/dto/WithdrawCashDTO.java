package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class WithdrawCashDTO implements Serializable {
    /**
     * 昵称
     */
    private String userName;
    /**
     * 账户名
     */
    private String account;
    /**
     * 提现云朵数
     */
    private int clouds;
    /**
     * 提现金额
     */
    BigDecimal money;
    /**
     * 提现人头像
     */
    private String picture;
}
