package com.qiyun.model2;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SportteryFootballMatch implements Serializable {
    private Integer id;

    private Integer version;

    private String hometeam;

    private String gamecolor;

    private String guestteam;

    private Date matchtime;

    private Integer inttime;

    private Integer lineid;

    private String gamename;

    private String gameShortName;

    private Integer status;

    private Integer homescore;

    private Integer guestscore;

    private Integer concede;

    private Integer halfhomescore;

    private Integer halfguestscore;

    private Double resultawardoftotopass;

    private Double resultrqawardoftotopass;

    private Double resultawardofscorepass;

    private Double resultawardofsinglescore;

    private Double resultawardofhftotopass;

    private Integer outid;

    private Integer gameId;

    private Integer resultOfRule;

    private Integer prizeType;

    private Integer shownum;

    private Integer spfShownum;

    private Integer rqspfShownum;

    private Integer bfShownum;

    private Integer jqsShownum;

    private Integer bqcShownum;

    private Integer hasDelay;

    private Integer worldscene;


    private String SPF; //胜平负

    private String RQSPF;   //让球胜平负

    private String BF;  //比分

    private String ZJQ; //总进球

    private String BQC; //半全场

    private String XQ; //星期
}