package com.qiyun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FootballEventDTO implements Serializable {

    //赛程ID
    private String id;

    //主客队标志
    //1:主队事件，0:客队事件
    private String mark;

    //【事件类型】1:入球，2:红牌，3:黄牌，7:点球，8:乌龙，9:两黄变红，11:换人，13:射失点球
    private String type;

    //【时间】分钟，例：25
    private String time;

    //【球员名字】可能为空
    private String name;

    //【球员ID】可能为空，可能是两个球员ID
    private String qId;

    //【简体球员名】可能为空
    private String gName;

}
