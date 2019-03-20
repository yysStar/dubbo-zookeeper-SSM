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
public class FootballLeague implements Serializable {
    private Integer id;

    private String color;

    private String gbShort;

    private String bigShort;

    private String enShort;

    private String gb;

    private String big;

    private String en;

    private String type;

    private String subsclass;

    private String sumRound;

    private String currRound;

    private String currMatchSeason;

    private String countryId;

    private String country;

    private Integer areaId;

    private String countryEn;

    private String logo;

    private String countrLogo;

}