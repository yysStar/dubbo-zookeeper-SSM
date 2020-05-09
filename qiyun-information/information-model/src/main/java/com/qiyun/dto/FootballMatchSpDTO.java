package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FootballMatchSpDTO implements Serializable {
    //主赢sp
    private Double winSp;
    //平sp
    private Double drawSp;
    //主负sp
    private Double loseSp;
    //足球让球
    private int concede;
}
