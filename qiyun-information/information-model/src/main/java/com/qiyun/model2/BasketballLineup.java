package com.qiyun.model2;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BasketballLineup implements Serializable {
    private Integer id;

    private String homeLineup;


    private String homeBackup;


    private String awayLineup;


    private String awayBackup;


    private String analyzes;

    private String injury;


    private String homeNear6;

    private String homeOdds;

    private String homeOu;

    private String awayNear6;

    private String awayOdds;

    private String awayOu;

    private String confidence;

    private String vs;

    private String explain;

    private String homeLineupGb;

    private String homeLineupGb2;

    private String homeBackupGb;

    private String homeBackupGb2;

    private String awayLineupGb;

    private String awayLineupGb2;

    private String awayBackupGb;

    private String awayBackupGb2;

    private String analyzesGb;

    private String injuryGb;

    private String injuryGb2;

    private String confidenceGb;

    private String vsGb;

    private String vsGb2;

    private String explainGb;

}