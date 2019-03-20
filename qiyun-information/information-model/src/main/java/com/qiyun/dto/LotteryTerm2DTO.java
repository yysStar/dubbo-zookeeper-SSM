package com.qiyun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LotteryTerm2DTO implements Serializable {
    private Integer id;

    private Integer lotteryType;

    private String lotteryTypeStr;

    private String term;

    private String outTerm;

    private Date openDateTime;

    private Date startDateTime;

    private Date endDateTime;

    private Date terminalEndDateTime;

    private Integer isAble;

    private Integer lotMgrIsAble;

    private Integer isCurrentTerm;

    private Integer isBooking;

    private Integer status;

    private String result;

    private String totalAmount;

    private String awardPool;

    private String testMachineCode;

    private String resultDetail;

    private static final long serialVersionUID = 1L;

    public String getLotteryTypeStr() {
        return lotteryTypeStr;
    }

    public void setLotteryTypeStr(String lotteryTypeStr) {
        this.lotteryTypeStr = lotteryTypeStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public String getOutTerm() {
        return outTerm;
    }

    public void setOutTerm(String outTerm) {
        this.outTerm = outTerm == null ? null : outTerm.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(Date openDateTime) {
        this.openDateTime = openDateTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getTerminalEndDateTime() {
        return terminalEndDateTime;
    }

    public void setTerminalEndDateTime(Date terminalEndDateTime) {
        this.terminalEndDateTime = terminalEndDateTime;
    }

    public Integer getIsAble() {
        return isAble;
    }

    public void setIsAble(Integer isAble) {
        this.isAble = isAble;
    }

    public Integer getLotMgrIsAble() {
        return lotMgrIsAble;
    }

    public void setLotMgrIsAble(Integer lotMgrIsAble) {
        this.lotMgrIsAble = lotMgrIsAble;
    }

    public Integer getIsCurrentTerm() {
        return isCurrentTerm;
    }

    public void setIsCurrentTerm(Integer isCurrentTerm) {
        this.isCurrentTerm = isCurrentTerm;
    }

    public Integer getIsBooking() {
        return isBooking;
    }

    public void setIsBooking(Integer isBooking) {
        this.isBooking = isBooking;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount == null ? null : totalAmount.trim();
    }

    public String getAwardPool() {
        return awardPool;
    }

    public void setAwardPool(String awardPool) {
        this.awardPool = awardPool == null ? null : awardPool.trim();
    }

    public String getTestMachineCode() {
        return testMachineCode;
    }

    public void setTestMachineCode(String testMachineCode) {
        this.testMachineCode = testMachineCode == null ? null : testMachineCode.trim();
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail == null ? null : resultDetail.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", lotteryTypeStr=").append(lotteryTypeStr);
        sb.append(", term=").append(term);
        sb.append(", outTerm=").append(outTerm);
        sb.append(", openDateTime=").append(openDateTime);
        sb.append(", startDateTime=").append(startDateTime);
        sb.append(", endDateTime=").append(endDateTime);
        sb.append(", terminalEndDateTime=").append(terminalEndDateTime);
        sb.append(", isAble=").append(isAble);
        sb.append(", lotMgrIsAble=").append(lotMgrIsAble);
        sb.append(", isCurrentTerm=").append(isCurrentTerm);
        sb.append(", isBooking=").append(isBooking);
        sb.append(", status=").append(status);
        sb.append(", result=").append(result);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", awardPool=").append(awardPool);
        sb.append(", testMachineCode=").append(testMachineCode);
        sb.append(", resultDetail=").append(resultDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
