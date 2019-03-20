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
public class SportteryFootlballJqsaward implements Serializable {
    private Integer id;

    private Integer matchid;

    private Integer inttime;

    private Integer lineid;

    private Date matchtime;

    private Integer passmode;

    private Date lastupdatetime;

    private Double s0Award;

    private Double s1Award;

    private Double s2Award;

    private Double s3Award;

    private Double s4Award;

    private Double s5Award;

    private Double s6Award;

    private Double s7Award;

    private Date createDate;

}