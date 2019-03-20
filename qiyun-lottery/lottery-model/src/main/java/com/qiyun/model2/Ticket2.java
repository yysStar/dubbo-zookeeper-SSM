package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class Ticket2 implements Serializable {
    private Integer id;

    private Integer planNo;

    private String term;

    private Integer lotteryType;

    private Integer amount;

    private Date createDateTime;

    private Date sendDateTime;

    private Date printDateTime;

    private Date dealDateTime;

    private Integer multiple;

    private Integer playType;

    private Integer isBingo;

    private Double bingoAmount;

    private Integer status;

    private String addAttribute;

    private String account;

    private String outId;

    private Integer noInBatch;

    private String batchNo;

    private Integer isConvert;

    private Date convertDateTime;

    private String serialNo;

    private Integer provider;

    private Integer errorCode;

    private Integer winStatus;

    private Date openResultTime;

    private Date returnPrizeTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(Date sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public Date getPrintDateTime() {
        return printDateTime;
    }

    public void setPrintDateTime(Date printDateTime) {
        this.printDateTime = printDateTime;
    }

    public Date getDealDateTime() {
        return dealDateTime;
    }

    public void setDealDateTime(Date dealDateTime) {
        this.dealDateTime = dealDateTime;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    public Integer getIsBingo() {
        return isBingo;
    }

    public void setIsBingo(Integer isBingo) {
        this.isBingo = isBingo;
    }

    public Double getBingoAmount() {
        return bingoAmount;
    }

    public void setBingoAmount(Double bingoAmount) {
        this.bingoAmount = bingoAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddAttribute() {
        return addAttribute;
    }

    public void setAddAttribute(String addAttribute) {
        this.addAttribute = addAttribute == null ? null : addAttribute.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId == null ? null : outId.trim();
    }

    public Integer getNoInBatch() {
        return noInBatch;
    }

    public void setNoInBatch(Integer noInBatch) {
        this.noInBatch = noInBatch;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Integer getIsConvert() {
        return isConvert;
    }

    public void setIsConvert(Integer isConvert) {
        this.isConvert = isConvert;
    }

    public Date getConvertDateTime() {
        return convertDateTime;
    }

    public void setConvertDateTime(Date convertDateTime) {
        this.convertDateTime = convertDateTime;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getWinStatus() {
        return winStatus;
    }

    public void setWinStatus(Integer winStatus) {
        this.winStatus = winStatus;
    }

    public Date getOpenResultTime() {
        return openResultTime;
    }

    public void setOpenResultTime(Date openResultTime) {
        this.openResultTime = openResultTime;
    }

    public Date getReturnPrizeTime() {
        return returnPrizeTime;
    }

    public void setReturnPrizeTime(Date returnPrizeTime) {
        this.returnPrizeTime = returnPrizeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", planNo=").append(planNo);
        sb.append(", term=").append(term);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", amount=").append(amount);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", sendDateTime=").append(sendDateTime);
        sb.append(", printDateTime=").append(printDateTime);
        sb.append(", dealDateTime=").append(dealDateTime);
        sb.append(", multiple=").append(multiple);
        sb.append(", playType=").append(playType);
        sb.append(", isBingo=").append(isBingo);
        sb.append(", bingoAmount=").append(bingoAmount);
        sb.append(", status=").append(status);
        sb.append(", addAttribute=").append(addAttribute);
        sb.append(", account=").append(account);
        sb.append(", outId=").append(outId);
        sb.append(", noInBatch=").append(noInBatch);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", isConvert=").append(isConvert);
        sb.append(", convertDateTime=").append(convertDateTime);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", provider=").append(provider);
        sb.append(", errorCode=").append(errorCode);
        sb.append(", winStatus=").append(winStatus);
        sb.append(", openResultTime=").append(openResultTime);
        sb.append(", returnPrizeTime=").append(returnPrizeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}