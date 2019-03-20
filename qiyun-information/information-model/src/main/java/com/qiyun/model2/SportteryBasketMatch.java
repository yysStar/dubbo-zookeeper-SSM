package com.qiyun.model2;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SportteryBasketMatch implements Serializable {
    private Integer id;

    private Integer version;

    private String gamename;

    private String gamecolor;

    private Date matchtime;

    private Integer inttime;

    private Integer status;

    private Integer shownum;

    private String homename;

    private String homeShortName;

    private String guestname;

    private String guestShortName;

    private Integer lineid;

    private String fristsection;

    private String secondsection;

    private String thirdsection;

    private String fourthsection;

    private Double resultofsf;

    private Double resultofsfc;

    private Double resultofdxf;

    private Double resultofrfsf;

    private Double handicap;

    private Double basebigorsmall;

    private Double singleHandicap;

    private Double singleBasebigorsmall;

    private Integer homescore;

    private Integer guestscore;

    private String outid;

    private Integer dxfQ2Scene;

    private String analysisId;

    private Integer hasDelay;

    private Integer sfShownum;

    private Integer rfsfShownum;

    private Integer dxfShownum;

    private Integer sfcShownum;

    private Integer gameId;

    private String gameShortName;

    /**
     * 胜负
     */
    private String SF;

    /**
     * 让分胜负
     */
    private String RFSF;

    /**
     * 大小分
     */
    private String DXF;

    /**
     * 胜分差
     */
    private String SFC;

    /**
     * 星期
     */
    private String XQ;
}