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
public class FootballScheduleResult implements Serializable {
    private Integer id;

    private String color;

    private String league;

    private FootballLeague league2;

    private String time;

    private String time2;

    private String subLeague;

    private String state;

    private Integer state2;

    private String home;

    private FootballTeam2 home2;

    private String away;

    private FootballTeam2 away2;

    private String homeScore;

    private String awayScore;

    private String bc1;

    private String bc2;

    private String red1;

    private String red2;

    private String order1;

    private String order2;

    private String explain;

    private String groupName;

    private String area;

    private String weatherIco;

    private String weather;

    private String temperature;

    private String season;

    private String group;

    private String zl;

    private String subLeagueId;

    private String yellow;

    private String explain2;

}