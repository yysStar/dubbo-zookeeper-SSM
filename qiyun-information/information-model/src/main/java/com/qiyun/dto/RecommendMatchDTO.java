package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RecommendMatchDTO implements Serializable {
    //赛事id
    int matchId;
    //比赛投注日期
    int intTime;
    //场次id
    int lineId;
    //比赛开始时间
    Date matchTime;
    //赛事名称
    private String gameName;
    //主队
    private String homeName;
    //客队
    private String guestName;
    //让球让分数
    private BigDecimal score;
    //推荐结果sp
    private BigDecimal sp;
    //推荐结果， 0-负，小,1-平,3-胜，大
    private Integer result;
    //类型，1为足球，2为篮球
    private Integer type;
    //大小分
    private BigDecimal baseBigSmall;
}
