package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FootballTeam2 {
    private Integer id;

    private String standardName;

    private String dc;

    private String jc;

    private String fb;

    private String dyj;

    private Integer pm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName == null ? null : standardName.trim();
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc == null ? null : dc.trim();
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc == null ? null : jc.trim();
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb == null ? null : fb.trim();
    }

    public String getDyj() {
        return dyj;
    }

    public void setDyj(String dyj) {
        this.dyj = dyj == null ? null : dyj.trim();
    }

    public Integer getPm() {
        return pm;
    }

    public void setPm(Integer pm) {
        this.pm = pm;
    }
}