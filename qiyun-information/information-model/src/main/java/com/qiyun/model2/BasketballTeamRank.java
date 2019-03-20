package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BasketballTeamRank implements Serializable {
    private String teamId;

    private String league;

    private String name;

    private String matchSeason;

    private String homeWin;

    private String homeLoss;

    private String awayWin;

    private String awayLoss;

    private String winScale;

    private String state;

    private String homeOrder;

    private String awayOrder;

    private String totalOrder;

    private String homeScore;

    private String homeLossScore;

    private String awayScore;

    private String awayLossScore;

    private String near10Win;

    private String near10Loss;
    //场次
    private Integer zcc;
    //胜-负
    private String zsf;
    //排名
    private Integer zpm;
    //得-失
    private String zds;
    //胜率
    private String zsl;
    //场次
    private Integer kcc;
    //胜-负
    private String ksf;
    //排名
    private Integer kpm;
    //得-失
    private String kds;
    //胜率
    private String ksl;
}