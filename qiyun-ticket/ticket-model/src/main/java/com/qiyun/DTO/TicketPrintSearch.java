package com.qiyun.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class TicketPrintSearch implements Serializable {

    private Integer id;
    private Integer planNo;
    private String startCreateTime; //发起时间
    private String endCreateTime;
    private String startDealTime; //截止时间
    private String endDealTime;
    private Integer lotteryType; //彩种
    private String passType; //玩法
    private Integer startAmount; //本金
    private Integer endAmount;
    private Integer startMultiple; //倍数
    private Integer endMultiple;
    private BigDecimal startBonus; //预测奖金
    private BigDecimal endBonus;
    private Integer status; //处理结果
    private Integer startResidueCount; //剩余张数
    private Integer endResidueCount;
    private Integer startCount; //总张数
    private Integer endCount;
    private String dlAccount;
    private String qdAccount;
    private Integer page = 1;
    private Integer pageSize = 10;

    public Integer getPage() {
        return page;
    }

    public String getDlAccount() {
        return dlAccount;
    }

    public void setDlAccount(String dlAccount) {
        this.dlAccount = dlAccount;
    }

    public String getQdAccount() {
        return qdAccount;
    }

    public void setQdAccount(String qdAccount) {
        this.qdAccount = qdAccount;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


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

    public String getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(String startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public String getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(String endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public String getStartDealTime() {
        return startDealTime;
    }

    public void setStartDealTime(String startDealTime) {
        this.startDealTime = startDealTime;
    }

    public String getEndDealTime() {
        return endDealTime;
    }

    public void setEndDealTime(String endDealTime) {
        this.endDealTime = endDealTime;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    public Integer getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(Integer startAmount) {
        this.startAmount = startAmount;
    }

    public Integer getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(Integer endAmount) {
        this.endAmount = endAmount;
    }

    public Integer getStartMultiple() {
        return startMultiple;
    }

    public void setStartMultiple(Integer startMultiple) {
        this.startMultiple = startMultiple;
    }

    public Integer getEndMultiple() {
        return endMultiple;
    }

    public void setEndMultiple(Integer endMultiple) {
        this.endMultiple = endMultiple;
    }

    public BigDecimal getStartBonus() {
        return startBonus;
    }

    public void setStartBonus(BigDecimal startBonus) {
        this.startBonus = startBonus;
    }

    public BigDecimal getEndBonus() {
        return endBonus;
    }

    public void setEndBonus(BigDecimal endBonus) {
        this.endBonus = endBonus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStartResidueCount() {
        return startResidueCount;
    }

    public void setStartResidueCount(Integer startResidueCount) {
        this.startResidueCount = startResidueCount;
    }

    public Integer getEndResidueCount() {
        return endResidueCount;
    }

    public void setEndResidueCount(Integer endResidueCount) {
        this.endResidueCount = endResidueCount;
    }

    public Integer getStartCount() {
        return startCount;
    }

    public void setStartCount(Integer startCount) {
        this.startCount = startCount;
    }

    public Integer getEndCount() {
        return endCount;
    }

    public void setEndCount(Integer endCount) {
        this.endCount = endCount;
    }
}
