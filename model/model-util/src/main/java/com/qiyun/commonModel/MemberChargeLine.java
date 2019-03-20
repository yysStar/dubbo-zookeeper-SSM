package com.qiyun.commonModel;

import com.qiyun.common.CommonStatus;

import java.io.Serializable;
import java.util.Date;

public class MemberChargeLine implements Serializable {

    private String chargeNo;
    private String account;
    private Date createDateTime;
    private Date successDateTime;
    private Double amount;
    private CommonStatus status;
    private String payedNo;
    private String bank;
    //开户行地址
    private String bankPart;
    private ChargeType chargeType;
    private String bankCard;
    private PromotionStatus promotionStatus;//活动状态
    private ChargePromotionType chargePromotionType;

    private Integer planNo;

    /**
     * 充值用途(默认为充值)
     */
    private ChargeUseType chargeUseType = ChargeUseType.CHARGE;

    private Platform platform;

    // Constructors

    /** default constructor */
    public MemberChargeLine() {
    }

    /** minimal constructor */
    public MemberChargeLine(String chargeNo) {
        this.chargeNo = chargeNo;
    }

    /** full constructor */
    public MemberChargeLine(String chargeNo, String account, Date createDateTime, Date successDateTime, Double amount, CommonStatus status, String payedNo,
                                    String requestInfo, String responseInfo, String bank, ChargeType chargeType, String bankCard,PromotionStatus promotionStatusType, Integer planNo) {
        this.chargeNo = chargeNo;
        this.account = account;
        this.createDateTime = createDateTime;
        this.successDateTime = successDateTime;
        this.amount = amount;
        this.status = status;
        this.payedNo = payedNo;
        this.bank = bank;
        this.chargeType = chargeType;
        this.bankCard = bankCard;
        this.promotionStatus = promotionStatusType;
        this.planNo = planNo;
    }

    // Property accessors

    public String getChargeNo() {
        return this.chargeNo;
    }

    public void setChargeNo(String chargeNo) {
        this.chargeNo = chargeNo;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getCreateDateTime() {
        return this.createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getSuccessDateTime() {
        return this.successDateTime;
    }

    public void setSuccessDateTime(Date successDateTime) {
        this.successDateTime = successDateTime;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CommonStatus getStatus() {
        return this.status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    public String getPayedNo() {
        return this.payedNo;
    }

    public void setPayedNo(String payedNo) {
        this.payedNo = payedNo;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public ChargeType getChargeType() {
        return this.chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public PromotionStatus getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(PromotionStatus promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    public String getBankPart() {
        return bankPart;
    }

    public ChargePromotionType getChargePromotionType() {
        return chargePromotionType;
    }

    public void setChargePromotionType(ChargePromotionType chargePromotionType) {
        this.chargePromotionType = chargePromotionType;
    }

    public void setBankPart(String bankPart) {
        this.bankPart = bankPart;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public ChargeUseType getChargeUseType() {
        return chargeUseType;
    }

    public void setChargeUseType(ChargeUseType chargeUseType) {
        this.chargeUseType = chargeUseType;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
