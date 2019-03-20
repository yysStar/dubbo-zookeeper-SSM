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
public class SportteryFootballBqcaward implements Serializable {
    private Integer id;

    private Integer matchid;

    private Integer inttime;

    private Integer lineid;

    private Date matchtime;

    private Integer passmode;

    private Date lastupdatetime;

    private Double winWinAward;

    private Double winDrawAward;

    private Double winLoseAward;

    private Double drawWinAward;

    private Double drawDrawAward;

    private Double drawLoseAward;

    private Double loseWinAward;

    private Double loseDrawAward;

    private Double loseLoseAward;

    private Date createDate;

}