package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyTotalRedRacketDTO implements Serializable {
    //发包人账号昵称
    private String account;
    private String name;
    //总金额
    private BigDecimal totalMoney;
    private String picture;
}
