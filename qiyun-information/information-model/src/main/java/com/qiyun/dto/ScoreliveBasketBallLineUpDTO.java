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
public class ScoreliveBasketBallLineUpDTO implements Serializable {

    //赛事id
    private String id;

    //主队主选球员
    private String homeLineup;

    //主队备选球员
    private String homeBackup;

    //客队主选球员
    private String awayLineup;

    //客队备选球员
    private String awayBackup;

    //赛前简报
    private String analyzes;

    //伤停
    private String injury;

    //主队近六场输赢
    private String homeNear6;

    //主队近六场让分盘路
    private String homeOdds;

    //主队近六场大小球盘路
    private String homeOU;

    //客队近六场输赢
    private String awayNear6;

    //客队近六场让分盘路
    private String awayOdds;

    //客队近六场大小球盘路
    private String awayOU;

    //信心指数
    private String confidence;

    //对赛往绩
    private String vs;

    //说明
    private String Explain;

    //主队主选球员-简体
    private String homeLineupGb;

    //主队备选球员-简体
    private String homeBackupGb;

    //客队主选球员-简体
    private String awayLineupGb;

    //客队备选球员-简体
    private String awayBackupGb;

    //赛前简报-简体
    private String analyzesGb;

    //伤停-简体
    private String injuryGb;

    //信心指数-简体
    private String confidenceGb;

    //对赛往绩-简体
    private String vsGb;

    //说明-简体
    private String explainGb;

}
