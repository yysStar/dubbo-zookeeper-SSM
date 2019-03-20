package com.qiyun.model2;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class CopyLotteryPlan2 implements Serializable {
    private Integer copyLotteryplanId;

    private String copyLotteryplanName;

    private Integer copyLotteryplanNo;

    private String copyLotteryplanPlanname;

    private Integer copyLotteryplanAmount;

    private Integer copyLotteryplanMultiple;

    private Integer copyLotteryplanPosttaxprize;

    private Integer copyLotteryplanPlantype;

    private Date copyLotteryplanCreateDateTime;

    private Integer copyLotteryplanLotterytype;

    private String copyLotteryplanTerm;

    private Double copyLotteryplanAddprize;

    private Integer copyLotteryplanSelecttype;

    private Integer copyLotteryplanPublicstatus;

    private Integer copyLotteryplanPlaytype;

    private String copyLotteryplandesc;

    private Integer planNo;

    private String copyLotteryplanContent;

    private static final long serialVersionUID = 1L;

    public Integer getCopyLotteryplanId() {
        return copyLotteryplanId;
    }

    public void setCopyLotteryplanId(Integer copyLotteryplanId) {
        this.copyLotteryplanId = copyLotteryplanId;
    }

    public String getCopyLotteryplanName() {
        return copyLotteryplanName;
    }

    public void setCopyLotteryplanName(String copyLotteryplanName) {
        this.copyLotteryplanName = copyLotteryplanName == null ? null : copyLotteryplanName.trim();
    }

    public Integer getCopyLotteryplanNo() {
        return copyLotteryplanNo;
    }

    public void setCopyLotteryplanNo(Integer copyLotteryplanNo) {
        this.copyLotteryplanNo = copyLotteryplanNo;
    }

    public String getCopyLotteryplanPlanname() {
        return copyLotteryplanPlanname;
    }

    public void setCopyLotteryplanPlanname(String copyLotteryplanPlanname) {
        this.copyLotteryplanPlanname = copyLotteryplanPlanname == null ? null : copyLotteryplanPlanname.trim();
    }

    public Integer getCopyLotteryplanAmount() {
        return copyLotteryplanAmount;
    }

    public void setCopyLotteryplanAmount(Integer copyLotteryplanAmount) {
        this.copyLotteryplanAmount = copyLotteryplanAmount;
    }

    public Integer getCopyLotteryplanMultiple() {
        return copyLotteryplanMultiple;
    }

    public void setCopyLotteryplanMultiple(Integer copyLotteryplanMultiple) {
        this.copyLotteryplanMultiple = copyLotteryplanMultiple;
    }

    public Integer getCopyLotteryplanPosttaxprize() {
        return copyLotteryplanPosttaxprize;
    }

    public void setCopyLotteryplanPosttaxprize(Integer copyLotteryplanPosttaxprize) {
        this.copyLotteryplanPosttaxprize = copyLotteryplanPosttaxprize;
    }

    public Integer getCopyLotteryplanPlantype() {
        return copyLotteryplanPlantype;
    }

    public void setCopyLotteryplanPlantype(Integer copyLotteryplanPlantype) {
        this.copyLotteryplanPlantype = copyLotteryplanPlantype;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCopyLotteryplanCreateDateTime() {
        return copyLotteryplanCreateDateTime;
    }

    public void setCopyLotteryplanCreateDateTime(Date copyLotteryplanCreateDateTime) {
        this.copyLotteryplanCreateDateTime = copyLotteryplanCreateDateTime;
    }

    public Integer getCopyLotteryplanLotterytype() {
        return copyLotteryplanLotterytype;
    }

    public void setCopyLotteryplanLotterytype(Integer copyLotteryplanLotterytype) {
        this.copyLotteryplanLotterytype = copyLotteryplanLotterytype;
    }

    public String getCopyLotteryplanTerm() {
        return copyLotteryplanTerm;
    }

    public void setCopyLotteryplanTerm(String copyLotteryplanTerm) {
        this.copyLotteryplanTerm = copyLotteryplanTerm == null ? null : copyLotteryplanTerm.trim();
    }

    public Double getCopyLotteryplanAddprize() {
        return copyLotteryplanAddprize;
    }

    public void setCopyLotteryplanAddprize(Double copyLotteryplanAddprize) {
        this.copyLotteryplanAddprize = copyLotteryplanAddprize;
    }

    public Integer getCopyLotteryplanSelecttype() {
        return copyLotteryplanSelecttype;
    }

    public void setCopyLotteryplanSelecttype(Integer copyLotteryplanSelecttype) {
        this.copyLotteryplanSelecttype = copyLotteryplanSelecttype;
    }

    public Integer getCopyLotteryplanPublicstatus() {
        return copyLotteryplanPublicstatus;
    }

    public void setCopyLotteryplanPublicstatus(Integer copyLotteryplanPublicstatus) {
        this.copyLotteryplanPublicstatus = copyLotteryplanPublicstatus;
    }

    public Integer getCopyLotteryplanPlaytype() {
        return copyLotteryplanPlaytype;
    }

    public void setCopyLotteryplanPlaytype(Integer copyLotteryplanPlaytype) {
        this.copyLotteryplanPlaytype = copyLotteryplanPlaytype;
    }

    public String getCopyLotteryplandesc() {
        return copyLotteryplandesc;
    }

    public void setCopyLotteryplandesc(String copyLotteryplandesc) {
        this.copyLotteryplandesc = copyLotteryplandesc == null ? null : copyLotteryplandesc.trim();
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public String getCopyLotteryplanContent() {
        return copyLotteryplanContent;
    }

    public void setCopyLotteryplanContent(String copyLotteryplanContent) {
        this.copyLotteryplanContent = copyLotteryplanContent == null ? null : copyLotteryplanContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", copyLotteryplanId=").append(copyLotteryplanId);
        sb.append(", copyLotteryplanName=").append(copyLotteryplanName);
        sb.append(", copyLotteryplanNo=").append(copyLotteryplanNo);
        sb.append(", copyLotteryplanPlanname=").append(copyLotteryplanPlanname);
        sb.append(", copyLotteryplanAmount=").append(copyLotteryplanAmount);
        sb.append(", copyLotteryplanMultiple=").append(copyLotteryplanMultiple);
        sb.append(", copyLotteryplanPosttaxprize=").append(copyLotteryplanPosttaxprize);
        sb.append(", copyLotteryplanPlantype=").append(copyLotteryplanPlantype);
        sb.append(", copyLotteryplanCreateDateTime=").append(copyLotteryplanCreateDateTime);
        sb.append(", copyLotteryplanLotterytype=").append(copyLotteryplanLotterytype);
        sb.append(", copyLotteryplanTerm=").append(copyLotteryplanTerm);
        sb.append(", copyLotteryplanAddprize=").append(copyLotteryplanAddprize);
        sb.append(", copyLotteryplanSelecttype=").append(copyLotteryplanSelecttype);
        sb.append(", copyLotteryplanPublicstatus=").append(copyLotteryplanPublicstatus);
        sb.append(", copyLotteryplanPlaytype=").append(copyLotteryplanPlaytype);
        sb.append(", copyLotteryplandesc=").append(copyLotteryplandesc);
        sb.append(", planNo=").append(planNo);
        sb.append(", copyLotteryplanContent=").append(copyLotteryplanContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}