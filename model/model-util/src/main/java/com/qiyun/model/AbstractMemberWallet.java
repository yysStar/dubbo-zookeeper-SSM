package com.qiyun.model;

import com.qiyun.type.WalletType;

/**
 * AbstractMemberWallet generated by MyEclipse Persistence Tools
 */

public abstract class AbstractMemberWallet implements java.io.Serializable {

	// Fields
	// 无逻辑主键
	private Integer id;
	// 会员编号
	private Integer memberId;
	// 帐号
	private String account;
	// 可用余额
	private Double ableBalance;
	// 冻结余额
	private Double freezeBalance;
	//提现配额
	private Double takeCashQuota=0d;
	// 历史消费余额
	private Double heapBalance;
	// 历史中奖余额
	private Double heapPrize;
	// 验证码
	private String verifyMd5;
	// 钱包类型
	private WalletType walletType;
	
	private double creditLimit;
	
	private double ableCreditBalance;
	
	private double freezeCreditBalance;
	
	/**
	 * 奖金账户
	 */
	private Double prizeBalance = 0D;
    
	// Constructors
	
	

	/** default constructor */
	public AbstractMemberWallet() {
	}

	/** minimal constructor */
	public AbstractMemberWallet(String account, Double ableBalance, Double freezeBalance, Double heapBalance, Double heapPrize, String verifyMd5) {
		this.account = account;
		this.ableBalance = ableBalance;
		this.freezeBalance = freezeBalance;
		this.heapBalance = heapBalance;
		this.heapPrize = heapPrize;
		this.verifyMd5 = verifyMd5;
	}

	/** full constructor */
	public AbstractMemberWallet(Integer memberId, String account, Double ableBalance, Double freezeBalance, Double heapBalance, Double heapPrize,
			String verifyMd5, WalletType walletType) {
		this.memberId = memberId;
		this.account = account;
		this.ableBalance = ableBalance;
		this.freezeBalance = freezeBalance;
		this.heapBalance = heapBalance;
		this.heapPrize = heapPrize;
		this.verifyMd5 = verifyMd5;
		this.walletType = walletType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getAbleBalance() {
		return this.ableBalance;
	}

	public void setAbleBalance(Double ableBalance) {
		this.ableBalance = ableBalance;
	}

	public Double getTakeCashQuota() {
		return takeCashQuota;
	}

	public void setTakeCashQuota(Double takeCashQuota) {
		this.takeCashQuota = takeCashQuota;
	}

	public Double getFreezeBalance() {
		return this.freezeBalance;
	}

	public void setFreezeBalance(Double freezeBalance) {
		this.freezeBalance = freezeBalance;
	}

	public Double getHeapBalance() {
		return this.heapBalance;
	}

	public void setHeapBalance(Double heapBalance) {
		this.heapBalance = heapBalance;
	}

	public Double getHeapPrize() {
		return this.heapPrize;
	}

	public void setHeapPrize(Double heapPrize) {
		this.heapPrize = heapPrize;
	}

	public String getVerifyMd5() {
		return this.verifyMd5;
	}

	public void setVerifyMd5(String verifyMd5) {
		this.verifyMd5 = verifyMd5;
	}

	public WalletType getWalletType() {
		return this.walletType;
	}

	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}

	public Double getPrizeBalance() {
		return prizeBalance;
	}

	public void setPrizeBalance(Double prizeBalance) {
		this.prizeBalance = prizeBalance;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getAbleCreditBalance() {
		return ableCreditBalance;
	}

	public void setAbleCreditBalance(double ableCreditBalance) {
		this.ableCreditBalance = ableCreditBalance;
	}

	public double getFreezeCreditBalance() {
		return freezeCreditBalance;
	}

	public void setFreezeCreditBalance(double freezeCreditBalance) {
		this.freezeCreditBalance = freezeCreditBalance;
	}
	
}
