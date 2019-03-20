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
public class FootballTeam2 implements Serializable {
    private Integer id;

    private Integer lsId;

    private String g;

    private String b;

    private String e;

    private String found;

    private String area;

    private String gym;

    private String capacity;

    private String flag;

    private String addr;

    private String url;

    private String master;

}