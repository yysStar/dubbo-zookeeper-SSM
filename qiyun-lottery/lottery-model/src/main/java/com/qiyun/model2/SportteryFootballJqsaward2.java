package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportteryFootballJqsaward2 {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    public Integer getInttime() {
        return inttime;
    }

    public void setInttime(Integer inttime) {
        this.inttime = inttime;
    }

    public Integer getLineid() {
        return lineid;
    }

    public void setLineid(Integer lineid) {
        this.lineid = lineid;
    }

    public Date getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(Date matchtime) {
        this.matchtime = matchtime;
    }

    public Integer getPassmode() {
        return passmode;
    }

    public void setPassmode(Integer passmode) {
        this.passmode = passmode;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Double getS0Award() {
        return s0Award;
    }

    public void setS0Award(Double s0Award) {
        this.s0Award = s0Award;
    }

    public Double getS1Award() {
        return s1Award;
    }

    public void setS1Award(Double s1Award) {
        this.s1Award = s1Award;
    }

    public Double getS2Award() {
        return s2Award;
    }

    public void setS2Award(Double s2Award) {
        this.s2Award = s2Award;
    }

    public Double getS3Award() {
        return s3Award;
    }

    public void setS3Award(Double s3Award) {
        this.s3Award = s3Award;
    }

    public Double getS4Award() {
        return s4Award;
    }

    public void setS4Award(Double s4Award) {
        this.s4Award = s4Award;
    }

    public Double getS5Award() {
        return s5Award;
    }

    public void setS5Award(Double s5Award) {
        this.s5Award = s5Award;
    }

    public Double getS6Award() {
        return s6Award;
    }

    public void setS6Award(Double s6Award) {
        this.s6Award = s6Award;
    }

    public Double getS7Award() {
        return s7Award;
    }

    public void setS7Award(Double s7Award) {
        this.s7Award = s7Award;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}