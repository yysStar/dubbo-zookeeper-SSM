package com.qiyun.model;

import java.io.Serializable;

public class MatchItemOption implements Serializable {
    private int DXF;
    private int RF;
    private Double award;
    private int betMoney;
    private int dxf;
    private int each;
    private int rf;
    private int rqs;
    private String subType;
    private String  type;
    private String typeValueStr;
    private String value;

    public int getDXF() {
        return DXF;
    }

    public void setDXF(int DXF) {
        this.DXF = DXF;
    }

    public int getRF() {
        return RF;
    }

    public void setRF(int RF) {
        this.RF = RF;
    }

    public Double getAward() {
        return award;
    }

    public void setAward(Double award) {
        this.award = award;
    }

    public int getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(int betMoney) {
        this.betMoney = betMoney;
    }

    public int getDxf() {
        return dxf;
    }

    public void setDxf(int dxf) {
        this.dxf = dxf;
    }

    public int getEach() {
        return each;
    }

    public void setEach(int each) {
        this.each = each;
    }

    public int getRf() {
        return rf;
    }

    public void setRf(int rf) {
        this.rf = rf;
    }

    public int getRqs() {
        return rqs;
    }

    public void setRqs(int rqs) {
        this.rqs = rqs;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeValueStr() {
        return typeValueStr;
    }

    public void setTypeValueStr(String typeValueStr) {
        this.typeValueStr = typeValueStr;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
