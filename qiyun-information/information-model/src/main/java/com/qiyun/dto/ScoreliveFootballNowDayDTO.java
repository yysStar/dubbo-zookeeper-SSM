package com.qiyun.dto;

import com.qiyun.model2.FootballLeague;
import com.qiyun.model2.FootballTeam2;
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
public class ScoreliveFootballNowDayDTO implements Serializable {
    private Integer id;

    private String color;

    private Integer leagueId;

    private Integer kind;

    private Integer level;

    private FootballLeague league;

    private String subLeague;

    private Integer subLeagueId;

    private String time;

    private String time2;

    private FootballTeam2 home;

    private FootballTeam2 away;

    private Integer state;

    private Integer homeScore;

    private Integer awayScore;

    private Integer bc1;

    private Integer bc2;

    private Integer red1;

    private Integer red2;

    private Integer yellow1;

    private Integer yellow2;

    private String order1;

    private String order2;

    private String explain;

    private String zl;

    private String tv;

    private String lineup;

    private String explain2;

    private Integer corner1;

    private Integer corner2;

}