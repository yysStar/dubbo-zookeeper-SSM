package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatchBetMapping implements Serializable {
    private String id;

    private String lotteryName;

    private String isSueNum;

    private String idBet;

    private Date time;

    private String sport;

    private String home;

    private String away;

    private String homeId;

    private String awayId;

    private String turn;

    private String league;

}