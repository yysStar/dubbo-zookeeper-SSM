package com.qiyun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScoreliveBasketBallNowTimeDTO implements Serializable {

    //比赛id
    private String id;

    //比赛状态  【状态】0:未开赛，1:一节，2:二节，3:三节，4:四节，5:1'OT，6:2'OT，7:3'OT，-1:完场, -2:待定，-3:中断，-4:取消，-5:推迟，50中场
    private String state;

    //小节剩余时间
    private String remainTime;

    //主队得分
    private String homeScore;

    //客队得分
    private String awayScore;

    //主队第一节比分
    private String zd1;

    //客队第一节比分
    private String kd1;

    //主队第二节比分
    private String zd2;

    //客队第二节比分
    private String kd2;

    //主队第三节比分
    private String zd3;

    //客队第三节比分
    private String kd3;

    //主队第四节比分
    private String zd4;

    //客队第四节比分
    private String kd4;

    //加时数
    private String addTime;

    //备注1  直播内容
    private String mark1;

    //分节数  2或4
    private String sectionCount;

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

    //备注2
    private String mark2;

    //是否有技术统计
    private String haveTechnical;

    //赔率：主胜赔率,客胜赔率
    private String pl;

}