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
public class BasketballTeam2 implements Serializable {
    private Integer id;

    private Integer lsId;

    private String ashort;

    private String gb;

    private String big5;

    private String en;

    private String logo;

    private String url;

    private Integer locationId;

    private Integer matchAddrId;

    private String city;

    private String gymnasium;

    private Integer capacity;

    private Integer joinYear;

    private Integer firstTime;

    private String drillmaster;
}