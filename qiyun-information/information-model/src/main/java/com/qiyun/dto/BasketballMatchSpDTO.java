package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BasketballMatchSpDTO implements Serializable {
    //主赢或大分sp
    private Double winSp;
    //主负或小分sp
    private Double loseSp;
    //篮球让分
    private Double handicap;
    //篮球大小分
    private Double baseBigOrSmall;
    //玩法，0为胜负，2为让分胜负，3为大小分
    private Double playType;
}
