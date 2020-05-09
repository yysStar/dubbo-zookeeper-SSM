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
public class BasketballLeague implements Serializable {
    private Integer id;

    private String color;

    private String ashort;

    private String gb;

    private String big;

    private String en;

    private String type;

    private String currMatchseason;

    private String countryId;

    private String country;

    private String currYear;

    private String currMonth;

    private String sclassKind;

    private String sclassTime;

}