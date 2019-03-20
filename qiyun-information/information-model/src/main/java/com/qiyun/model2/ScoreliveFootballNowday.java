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
public class ScoreliveFootballNowday implements Serializable {
    private Integer id;

    private String color;

    private String leagueId;

    private String kind;

    private String level;

    private String league;

    private String subLeague;

    private String subLeagueId;

    private Date time;

    private String time2;

    private String home;

    private String away;

    private String state;

    private String homeScore;

    private String awayScore;

    private String bc1;

    private String bc2;

    private String red1;

    private String red2;

    private String yellow1;

    private String yellow2;

    private String order1;

    private String order2;

    private String explain;

    private String zl;

    private String tv;

    private String lineup;

    private String explain2;

    private String corner1;

    private String corner2;

}