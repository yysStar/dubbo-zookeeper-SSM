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
public class BasketballLiveExplain2 implements Serializable {

    private String remainTime;

    //主客标志  3中立  1主队信息  2客队信息
    private String Sign;

    private String homeScore;

    private String awayScore;

    //直播内容
    private String content;

    //记录id
    private String id;

    //节数
    private String js;

}
