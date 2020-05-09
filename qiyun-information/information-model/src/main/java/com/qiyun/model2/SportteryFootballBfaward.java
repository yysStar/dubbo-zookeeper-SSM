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
public class SportteryFootballBfaward implements Serializable {
    private Integer id;

    private Integer matchid;

    private Integer inttime;

    private Integer lineid;

    private Date matchtime;

    private Integer passmode;

    private Date lastupdatetime;

    private Double s10award;

    private Double s20award;

    private Double s21award;

    private Double s30award;

    private Double s31award;

    private Double s32award;

    private Double s40award;

    private Double s41award;

    private Double s42award;

    private Double s50award;

    private Double s51award;

    private Double s52award;

    private Double sWinAward;

    private Double s00award;

    private Double s11award;

    private Double s22award;

    private Double s33award;

    private Double sDrawAward;

    private Double s01award;

    private Double s02award;

    private Double s12award;

    private Double s03award;

    private Double s13award;

    private Double s23award;

    private Double s04award;

    private Double s14award;

    private Double s24award;

    private Double s05award;

    private Double s15award;

    private Double s25award;

    private Double sLoseAward;

    private Date createDate;

}