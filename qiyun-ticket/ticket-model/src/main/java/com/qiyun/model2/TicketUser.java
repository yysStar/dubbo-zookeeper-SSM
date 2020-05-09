package com.qiyun.model2;

import java.io.Serializable;
import java.math.BigDecimal;

public class TicketUser implements Serializable {
    private Integer id;

    /**
     * 鐢ㄦ埛鍚�
     */
    private String account;

    /**
     * 鐘舵��  0涓嬬嚎 1涓婄嚎 2涓存椂浼戞伅 
     */
    private Integer type;

    /**
     * 鎺ㄩ�佸紶鏁�
     */
    private Integer pushCount;

    /**
     * 鎾ら攢寮犳暟
     */
    private Integer revocationCount;

    /**
     * 澶勭悊寮犳暟
     */
    private Integer disposeCount;

    /**
     * 鍔犳閲戦
     */
    private BigDecimal addBalance;

    /**
     * 鎺ㄩ�侀噾棰�
     */
    private BigDecimal pushAmount;

    /**
     * 鎾ら攢閲戦
     */
    private BigDecimal revocationAmount;

    /**
     * 澶勭悊閲戦
     */
    private BigDecimal disposeAmount;

    /**
     * 涓閲戦
     */
    private BigDecimal bingoAmount;

    /**
     * 褰撳墠绁╥d
     */
    private Integer ticketId;

    /**
     * 褰撳墠鎵撶エ鏈篿d
     */
    private String ticketApparatusId;

    /**
     * 鐘舵�� 0鏃犳晥 1鏈夋晥
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPushCount() {
        return pushCount;
    }

    public void setPushCount(Integer pushCount) {
        this.pushCount = pushCount;
    }

    public Integer getRevocationCount() {
        return revocationCount;
    }

    public void setRevocationCount(Integer revocationCount) {
        this.revocationCount = revocationCount;
    }

    public Integer getDisposeCount() {
        return disposeCount;
    }

    public void setDisposeCount(Integer disposeCount) {
        this.disposeCount = disposeCount;
    }

    public BigDecimal getAddBalance() {
        return addBalance;
    }

    public void setAddBalance(BigDecimal addBalance) {
        this.addBalance = addBalance;
    }

    public BigDecimal getPushAmount() {
        return pushAmount;
    }

    public void setPushAmount(BigDecimal pushAmount) {
        this.pushAmount = pushAmount;
    }

    public BigDecimal getRevocationAmount() {
        return revocationAmount;
    }

    public void setRevocationAmount(BigDecimal revocationAmount) {
        this.revocationAmount = revocationAmount;
    }

    public BigDecimal getDisposeAmount() {
        return disposeAmount;
    }

    public void setDisposeAmount(BigDecimal disposeAmount) {
        this.disposeAmount = disposeAmount;
    }

    public BigDecimal getBingoAmount() {
        return bingoAmount;
    }

    public void setBingoAmount(BigDecimal bingoAmount) {
        this.bingoAmount = bingoAmount;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketApparatusId() {
        return ticketApparatusId;
    }

    public void setTicketApparatusId(String ticketApparatusId) {
        this.ticketApparatusId = ticketApparatusId == null ? null : ticketApparatusId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", type=").append(type);
        sb.append(", pushCount=").append(pushCount);
        sb.append(", revocationCount=").append(revocationCount);
        sb.append(", disposeCount=").append(disposeCount);
        sb.append(", addBalance=").append(addBalance);
        sb.append(", pushAmount=").append(pushAmount);
        sb.append(", revocationAmount=").append(revocationAmount);
        sb.append(", disposeAmount=").append(disposeAmount);
        sb.append(", bingoAmount=").append(bingoAmount);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", ticketApparatusId=").append(ticketApparatusId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}