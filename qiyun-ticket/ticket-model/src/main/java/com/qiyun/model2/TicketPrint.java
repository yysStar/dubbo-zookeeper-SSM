package com.qiyun.model2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TicketPrint implements Serializable {
    private Integer id;

    /**
     * 鐢ㄦ埛鍚�
     */
    private String account;

    /**
     * 鏂规缂栧彿
     */
    private Integer planNo;

    /**
     * 涓叉硶
     */
    private String passtype;

    /**
     * 鎬婚噾棰�
     */
    private Integer amount;

    /**
     * 鍊嶆暟
     */
    private Integer multiple;

    /**
     * 寮犳暟
     */
    private Integer count;

    /**
     * 棰勬祴濂栭噾
     */
    private BigDecimal bonus;

    /**
     * 鐘舵�� 0寰呮墦 1宸插畬鎴� 2姝ｅ湪鎵� 3鎾ら攢
     */
    private Integer status;

    /**
     * 鍓╀綑寮犳暟
     */
    private Integer residueCount;

    /**
     * 鎵撶エ鏈哄櫒id
     */
    private String printId;

    /**
     * 鎵撶エ浜�
     */
    private String printAccount;

    /**
     * 鍒涘缓鏃堕棿
     */
    private Date createTime;

    /**
     * 鎺ㄩ�佹椂闂�
     */
    private Date pushTime;

    /**
     * 瀹屾垚鏃堕棿
     */
    private Date finishTime;

    /**
     * 鎴鏃堕棿
     */
    private Date dealTime;

    /**
     * 鏄惁浼樺厛 1鏄� 0鍚�
     */
    private Integer weight;

    /**
     * 褰╃
     */
    private Integer lotteryType;

    /**
     * 浠ｇ悊鐢ㄦ埛鍚�
     */
    private String dlAccount;

    /**
     * 娓犻亾鐢ㄦ埛鍚�
     */
    private String qdAccount;

    /**
     * 閫夐」
     */
    private String content;

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

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public String getPasstype() {
        return passtype;
    }

    public void setPasstype(String passtype) {
        this.passtype = passtype == null ? null : passtype.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getResidueCount() {
        return residueCount;
    }

    public void setResidueCount(Integer residueCount) {
        this.residueCount = residueCount;
    }

    public String getPrintId() {
        return printId;
    }

    public void setPrintId(String printId) {
        this.printId = printId == null ? null : printId.trim();
    }

    public String getPrintAccount() {
        return printAccount;
    }

    public void setPrintAccount(String printAccount) {
        this.printAccount = printAccount == null ? null : printAccount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getDlAccount() {
        return dlAccount;
    }

    public void setDlAccount(String dlAccount) {
        this.dlAccount = dlAccount == null ? null : dlAccount.trim();
    }

    public String getQdAccount() {
        return qdAccount;
    }

    public void setQdAccount(String qdAccount) {
        this.qdAccount = qdAccount == null ? null : qdAccount.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", planNo=").append(planNo);
        sb.append(", passtype=").append(passtype);
        sb.append(", amount=").append(amount);
        sb.append(", multiple=").append(multiple);
        sb.append(", count=").append(count);
        sb.append(", bonus=").append(bonus);
        sb.append(", status=").append(status);
        sb.append(", residueCount=").append(residueCount);
        sb.append(", printId=").append(printId);
        sb.append(", printAccount=").append(printAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", pushTime=").append(pushTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", weight=").append(weight);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", dlAccount=").append(dlAccount);
        sb.append(", qdAccount=").append(qdAccount);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}