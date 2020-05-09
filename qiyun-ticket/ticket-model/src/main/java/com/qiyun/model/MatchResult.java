package com.qiyun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchResult {
    private String id;

    private Integer type;

    private Integer cancel;

    private String day;

    private Integer weekId;

    private String teamId;

    private Integer letPoint;

    private Integer basePoint;

    private String result;

    private String halfResult;

    private BigDecimal b0;

    private BigDecimal b1;

    private BigDecimal b2;

    private BigDecimal b3;

    private BigDecimal b4;

    private BigDecimal b5;

    private BigDecimal b6;

    private BigDecimal b7;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCancel() {
        return cancel;
    }

    public void setCancel(Integer cancel) {
        this.cancel = cancel;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public Integer getWeekId() {
        return weekId;
    }

    public void setWeekId(Integer weekId) {
        this.weekId = weekId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public Integer getLetPoint() {
        return letPoint;
    }

    public void setLetPoint(Integer letPoint) {
        this.letPoint = letPoint;
    }

    public Integer getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Integer basePoint) {
        this.basePoint = basePoint;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getHalfResult() {
        return halfResult;
    }

    public void setHalfResult(String halfResult) {
        this.halfResult = halfResult == null ? null : halfResult.trim();
    }

    public BigDecimal getB0() {
        return b0;
    }

    public void setB0(BigDecimal b0) {
        this.b0 = b0;
    }

    public BigDecimal getB1() {
        return b1;
    }

    public void setB1(BigDecimal b1) {
        this.b1 = b1;
    }

    public BigDecimal getB2() {
        return b2;
    }

    public void setB2(BigDecimal b2) {
        this.b2 = b2;
    }

    public BigDecimal getB3() {
        return b3;
    }

    public void setB3(BigDecimal b3) {
        this.b3 = b3;
    }

    public BigDecimal getB4() {
        return b4;
    }

    public void setB4(BigDecimal b4) {
        this.b4 = b4;
    }

    public BigDecimal getB5() {
        return b5;
    }

    public void setB5(BigDecimal b5) {
        this.b5 = b5;
    }

    public BigDecimal getB6() {
        return b6;
    }

    public void setB6(BigDecimal b6) {
        this.b6 = b6;
    }

    public BigDecimal getB7() {
        return b7;
    }

    public void setB7(BigDecimal b7) {
        this.b7 = b7;
    }
}