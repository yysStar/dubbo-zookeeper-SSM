package com.qiyun.model2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TicketOperationLine implements Serializable {
    private Integer id;

    /**
     * 鐢ㄦ埛鍚�
     */
    private String account;

    /**
     * 鍒涘缓鏃堕棿
     */
    private Date createTime;

    /**
     * 绫诲瀷
     */
    private Integer transType;

    /**
     * 閲戦
     */
    private BigDecimal amount;

    /**
     * 绁╥d
     */
    private Integer ticketId;

    /**
     * 绁ㄥ紶鏁�
     */
    private Integer ticketCount;

    /**
     * 鎵撶エ鏈篿d
     */
    private String ticketApparatusId;

    /**
     * 鎵撶エ鏈轰綑棰�
     */
    private BigDecimal ticketApparatusAbleBalance;

    /**
     * 澶囨敞
     */
    private String remark;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }

    public String getTicketApparatusId() {
        return ticketApparatusId;
    }

    public void setTicketApparatusId(String ticketApparatusId) {
        this.ticketApparatusId = ticketApparatusId == null ? null : ticketApparatusId.trim();
    }

    public BigDecimal getTicketApparatusAbleBalance() {
        return ticketApparatusAbleBalance;
    }

    public void setTicketApparatusAbleBalance(BigDecimal ticketApparatusAbleBalance) {
        this.ticketApparatusAbleBalance = ticketApparatusAbleBalance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", createTime=").append(createTime);
        sb.append(", transType=").append(transType);
        sb.append(", amount=").append(amount);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", ticketCount=").append(ticketCount);
        sb.append(", ticketApparatusId=").append(ticketApparatusId);
        sb.append(", ticketApparatusAbleBalance=").append(ticketApparatusAbleBalance);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}