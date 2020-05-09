package com.qiyun.dto;

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
public class ScoreliveFootballNowTimeDTO implements Serializable {

    //比赛id
    private String id;

    //比赛状态  0:未开，1:上半场，2:中场，3:下半场，4:加时，5:点球，-1:完场，-10取消，-11:待定，-12:腰斩，-13:中断，-14:推迟
    private String state;

    //主队比分
    private String homeScore;

    //客队比分
    private String awayScore;

    //主队上半场比分
    private String bc1;

    //客队上半场比分
    private String bc2;

    //主队红牌
    private String red1;

    //客队红牌
    private String red2;

    //比赛时间  小时:分数，例：20:30
    private String time;

    //【开场时间】上半场为上半场开场时间,下半场为开下半场开场时间。js日期时间格式，月份从0开始编号。
    private String time2;

    //比赛日期 月-日
    private String time3;

    //赛程说明   若需用到，最好是用正则表达式将 <a>...</a>这些内容过滤
    private String explain;

    /**
     * 【比赛说明2】例：CCTV5 上海体育 北京体育;|2;|4;3|90,2-1;3-3;1,2-1;1-3;2
     * 含义如下：
     * 【CCTV5 上海体育 北京体育】事件中的电视台信息。
     * 【2；】先开球 (1：主，2：客);
     * 【4;3】角球数 主num;客num
     * 【90,2-1】90分钟 主得分-客得分
     * 【3-3】两回合 主得分-客得分
     * 【1,2-1】1：（1: 120分钟/含常规时间；2: 加时/不含常规时间；3: 加时中/含常规时间），2-1：主得分-客得分
     * 【1-3】点球 主进球数-客进球数
     * 【2】胜出（1：主，2：客）
     */
    private String explain2;

    //是否有阵容  1:有，0/空:无
    private String lineup;

    //主队黄牌
    private String yellow1;

    //客队黄牌
    private String yellow2;

    //主队角球
    private String corner1;

    //客队角球
    private String corner2;

}