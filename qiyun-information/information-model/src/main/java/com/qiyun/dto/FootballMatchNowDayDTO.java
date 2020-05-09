package com.qiyun.dto;


import com.qiyun.model2.FootballLeague;
import com.qiyun.model2.FootballTeam2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FootballMatchNowDayDTO implements Serializable {

    //比赛id
    private Integer id;

    //场次 如：周一001
    private String session;

    //比赛时间 如7:00
    private String time;

    //主队信息
    private FootballTeam2 home;

    //主队比分
    private String homeScore;

    //客队信息
    private FootballTeam2 away;

    //客队比分
    private String awayScore;

    //足球联赛信息
    private String footballLeague;

    //状态  0:未开，1:上半场，2:中场，3:下半场，4:加时，5:点球，-1:完场，-10取消，-11:待定，-12:腰斩，-13:中断，-14:推迟
    private String state;



}
