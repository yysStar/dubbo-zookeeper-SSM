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
public class BasketballScheduleResult implements Serializable {
    private Integer id;

    private String leagueId;

    private String leagueType;

    private String league;

    private BasketballLeague league2;

    private String sectionCount;

    private String color;

    private String time;

    private String time2;

    private String state;

    private Integer state2;

    private String remainTime;

    private String homeId;

    private String home;

    private BasketballTeam2 home2;

    private String awayId;

    private String away;

    private BasketballTeam2 away2;

    private String order1;

    private String order2;

    private String homeScore;

    private String awayScore;

    private String zd1;

    private String kd1;

    private String zd2;

    private String kd2;

    private String zd3;

    private String kd3;

    private String zd4;

    private String kd4;

    private String addTime;

    private String zd1ot;

    private String kd1ot;

    private String zd2ot;

    private String kd2ot;

    private String zd3ot;

    private String kd3ot;

    private String haveTechnical;

    private String tv;

    private String mark;

    private String zl;

    private String season;

    private String type;

    private String place;

    private String gameType;

    private String gameSubType;

}