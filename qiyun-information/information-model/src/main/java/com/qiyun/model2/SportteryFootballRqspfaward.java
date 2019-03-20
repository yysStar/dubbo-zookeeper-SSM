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
public class SportteryFootballRqspfaward implements Serializable {
    private Integer id;

    private Double homewinaward;

    private Double guestwinaward;

    private Double drawaward;

    private Integer homechange;

    private Integer drawchange;

    private Integer guestchange;

    private Integer matchid;

    private Integer inttime;

    private Integer lineid;

    private Date matchtime;

    private Integer passmode;

    private Date lastupdatetime;

    private Date createDate;

    private Double homeRate;

    private Double drawRate;

    private Double guestRate;

}