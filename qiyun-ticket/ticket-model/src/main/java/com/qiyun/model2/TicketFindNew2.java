package com.qiyun.model2;

import java.io.Serializable;
import java.util.Date;

public class TicketFindNew2 implements Serializable {
    /**
     * 缂栧彿
     */
    private Integer id;

    /**
     * 鏂规缂栧彿
     */
    private Integer planNo;

    /**
     * 瀵荤エ鏃堕棿
     */
    private Date findTime;

    /**
     * 瀹㈡埛鐢ㄦ埛鍚�
     */
    private String khAccount;

    /**
     * 瀵荤エ鎴愬姛杩樻槸椹冲洖锛�1涓烘垚鍔�  0椹冲洖
     */
    private Boolean status;

    /**
     * 鎶勫崟鏂规缂栧彿
     */
    private Integer copyPlanNo;

    /**
     * 瀵荤エ浜虹敤鎴峰悕
     */
    private String xpAccount;

    /**
     * 绫诲瀷  1浠ｇ悊瀵荤エ  2杩愯惀瀵荤エ 3楂樼骇鏉冮檺瀵荤エ
     */
    private Integer type;

    /**
     * 绁ㄧ姸鎬�
     */
    private Integer ticketStatus;

    /**
     * 鏄惁鍙妱鍗�  1鏄� 2鍚�
     */
    private Integer copyStatus;

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

    public Date getFindTime() {
        return findTime;
    }

    public void setFindTime(Date findTime) {
        this.findTime = findTime;
    }

    public String getKhAccount() {
        return khAccount;
    }

    public void setKhAccount(String khAccount) {
        this.khAccount = khAccount == null ? null : khAccount.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCopyPlanNo() {
        return copyPlanNo;
    }

    public void setCopyPlanNo(Integer copyPlanNo) {
        this.copyPlanNo = copyPlanNo;
    }

    public String getXpAccount() {
        return xpAccount;
    }

    public void setXpAccount(String xpAccount) {
        this.xpAccount = xpAccount == null ? null : xpAccount.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Integer getCopyStatus() {
        return copyStatus;
    }

    public void setCopyStatus(Integer copyStatus) {
        this.copyStatus = copyStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", planNo=").append(planNo);
        sb.append(", findTime=").append(findTime);
        sb.append(", khAccount=").append(khAccount);
        sb.append(", status=").append(status);
        sb.append(", copyPlanNo=").append(copyPlanNo);
        sb.append(", xpAccount=").append(xpAccount);
        sb.append(", type=").append(type);
        sb.append(", ticketStatus=").append(ticketStatus);
        sb.append(", copyStatus=").append(copyStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}