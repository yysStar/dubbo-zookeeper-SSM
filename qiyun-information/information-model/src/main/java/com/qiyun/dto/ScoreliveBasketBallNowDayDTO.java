package com.qiyun.dto;

import com.qiyun.model2.BasketballLeague;
import com.qiyun.model2.BasketballTeam2;
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
public class ScoreliveBasketBallNowDayDTO implements Serializable {

    //赛事id
    private String id;

    //联赛/杯赛ID
    private String leagueId;

    //类型
    private String type;

    //联赛信息
    private BasketballLeague league;

    //【分几节进行】2:上下半场，4：分4小节
    private String sectionCount;

    //颜色值
    private String color;

    //开赛时间
    private String time;

    //比赛状态  【状态】0:未开赛，1:一节，2:二节，3:三节，4:四节，5:1'OT，6:2'OT，7:3'OT，-1:完场, -2:待定，-3:中断，-4:取消，-5:推迟，50中场
    private String state;

    //小节剩余时间
    private String remainTime;

    //主队ID
    private String homeId;

    //主队信息
    private BasketballTeam2 home;

    //客队ID
    private String awayId;

    //客队信息
    private BasketballTeam2 away;

    //主队排名
    private String order1;

    //客队排名
    private String order2;

    //主队得分
    private String homeScore;

    //客队得分
    private String awayScore;

    //主队第一节比分（或上半场）
    private String zd1;

    //客队第一节比分（或上半场）
    private String kd1;

    //主队第二节比分
    private String zd2;

    //客队第二节比分
    private String kd2;

    //主队第三节比分（或下半场）
    private String zd3;

    //客队第三节比分（或下半场）
    private String kd3;

    //主队第四节比分
    private String zd4;

    //客队第四节比分
    private String kd4;

    //加时数   即几个加时
    private String addTime;

    //主队1'ot得分
    private String zd1ot;

    //客队1'ot得分
    private String kd1ot;

    //主队2'ot得分
    private String zd2ot;

    //客队2'ot得分
    private String kd2ot;

    //主队3ot得分
    private String zd3ot;

    //客队3'ot得分
    private String kd3ot;

    //是否有技术统计
    private String haveTechnical;

    //电视直播
    private String tv;

    //【备注】如：直播内容
    private String mark;

    //【是否中立场】1:中立场
    private String zl;

}