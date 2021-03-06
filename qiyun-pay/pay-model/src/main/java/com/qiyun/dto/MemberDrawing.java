package com.qiyun.dto;

import java.util.Date;

/**
 * AbstractMemberDrawing generated by MyEclipse Persistence Tools
 */

public  class MemberDrawing implements java.io.Serializable {

	// Fields

	private String id;
	private String bank;
	private String partBank;
	private String bankCard;
	private Float amount;
	private String account;
	private int status;
	private Date createDateTime;//创建时间
	private Date dealDateTime; // 客服审核时间
	private Date financeDealDateTime; // 财务审核时间
	private Date sendDateTime;//汇款时间
	private String remark;//驳回原因
	private Date failedDateTime;//银行退款时间
	private Float drawingFee;//真实手续费
	private Float privilegeDrawingFee;//优惠手续费(公司负担)
	private Float showDrawingFee;//显示手续费(用户支付)
	private int feePayerBelong;//手续费负担方
	private Date confirmDateTime;//交易到账时间
	private String transferBatchNo;//汇款批次号
	private String alipayNo; // 支付宝内部提现流水号
	
	private Integer planNo;
	
	/**
	 * 提款类型(默认为提款)
	 */
	private int drawingType = 0;
	
	/**
	 * 退款原因
	 */
	private int returnRemark;
	
	private int platform;
	
	// Constructors


	public MemberDrawing() {
	}

	public MemberDrawing(String id, String bank, String partBank, String bankCard, Float amount, String account, int status, Date createDateTime, Date dealDateTime, Date financeDealDateTime, Date sendDateTime, String remark, Date failedDateTime, Float drawingFee, Float privilegeDrawingFee, Float showDrawingFee, int feePayerBelong, Date confirmDateTime, String transferBatchNo, String alipayNo, Integer planNo, int drawingType, int returnRemark, int platform) {
		this.id = id;
		this.bank = bank;
		this.partBank = partBank;
		this.bankCard = bankCard;
		this.amount = amount;
		this.account = account;
		this.status = status;
		this.createDateTime = createDateTime;
		this.dealDateTime = dealDateTime;
		this.financeDealDateTime = financeDealDateTime;
		this.sendDateTime = sendDateTime;
		this.remark = remark;
		this.failedDateTime = failedDateTime;
		this.drawingFee = drawingFee;
		this.privilegeDrawingFee = privilegeDrawingFee;
		this.showDrawingFee = showDrawingFee;
		this.feePayerBelong = feePayerBelong;
		this.confirmDateTime = confirmDateTime;
		this.transferBatchNo = transferBatchNo;
		this.alipayNo = alipayNo;
		this.planNo = planNo;
		this.drawingType = drawingType;
		this.returnRemark = returnRemark;
		this.platform = platform;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPartBank() {
		return partBank;
	}

	public void setPartBank(String partBank) {
		this.partBank = partBank;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getDealDateTime() {
		return dealDateTime;
	}

	public void setDealDateTime(Date dealDateTime) {
		this.dealDateTime = dealDateTime;
	}

	public Date getFinanceDealDateTime() {
		return financeDealDateTime;
	}

	public void setFinanceDealDateTime(Date financeDealDateTime) {
		this.financeDealDateTime = financeDealDateTime;
	}

	public Date getSendDateTime() {
		return sendDateTime;
	}

	public void setSendDateTime(Date sendDateTime) {
		this.sendDateTime = sendDateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getFailedDateTime() {
		return failedDateTime;
	}

	public void setFailedDateTime(Date failedDateTime) {
		this.failedDateTime = failedDateTime;
	}

	public Float getDrawingFee() {
		return drawingFee;
	}

	public void setDrawingFee(Float drawingFee) {
		this.drawingFee = drawingFee;
	}

	public Float getPrivilegeDrawingFee() {
		return privilegeDrawingFee;
	}

	public void setPrivilegeDrawingFee(Float privilegeDrawingFee) {
		this.privilegeDrawingFee = privilegeDrawingFee;
	}

	public Float getShowDrawingFee() {
		return showDrawingFee;
	}

	public void setShowDrawingFee(Float showDrawingFee) {
		this.showDrawingFee = showDrawingFee;
	}

	public int getFeePayerBelong() {
		return feePayerBelong;
	}

	public void setFeePayerBelong(int feePayerBelong) {
		this.feePayerBelong = feePayerBelong;
	}

	public Date getConfirmDateTime() {
		return confirmDateTime;
	}

	public void setConfirmDateTime(Date confirmDateTime) {
		this.confirmDateTime = confirmDateTime;
	}

	public String getTransferBatchNo() {
		return transferBatchNo;
	}

	public void setTransferBatchNo(String transferBatchNo) {
		this.transferBatchNo = transferBatchNo;
	}

	public String getAlipayNo() {
		return alipayNo;
	}

	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	public Integer getPlanNo() {
		return planNo;
	}

	public void setPlanNo(Integer planNo) {
		this.planNo = planNo;
	}

	public int getDrawingType() {
		return drawingType;
	}

	public void setDrawingType(int drawingType) {
		this.drawingType = drawingType;
	}

	public int getReturnRemark() {
		return returnRemark;
	}

	public void setReturnRemark(int returnRemark) {
		this.returnRemark = returnRemark;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}
}