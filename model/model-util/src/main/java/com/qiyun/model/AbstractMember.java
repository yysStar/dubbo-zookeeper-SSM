package com.qiyun.model;

import com.qiyun.common.CommonStatus;
import com.qiyun.status.MemberStatus;
import com.qiyun.util.Constant;

import java.util.Date;

/**
 * AbstractMember generated by MyEclipse Persistence Tools
 */

public abstract class AbstractMember implements java.io.Serializable {

	// Fields
	// 会员Id
	private Integer id;
	// 帐号
	private String account;
	// 姓名t
	private String name;
	// 证件类型
	private Integer certType;
	// 证件号码
	private String certNo;
	// 密码
	private String password;
	// 级别
	private Integer rank;
	// 电子邮箱
	private String email;
	// 电话号码
	private String mobile;
	// 状态
	private Integer status;
	// 注册时间
	private Date registerDateTime;
	// 最后登录时间
	private Date lastLoginDateTime;
	// 总的经验值
	private Integer exprerience;
	// 来源编号
	private Integer sourceId;
	// 推荐人帐号
	private Integer recommender;
	// 合作供应商
	private String provider;

	private String sign;
	// 用户头像
	private String picture;
	// 名片
	private Integer card;
	// 是否手机验证通过
	private Integer isMobileAuthed;
	
	// 是否邮箱验证通过
	private Integer isEmailAuthed;

	// 活动设置时间
	private Date ceratePlayDate;

	// 活动设置状态
	private Integer playStatus;
	// Constructors
	// 是否返点用户
	private Integer isReturnPoint;
	// 支付宝金账户
	private Integer userGradeType; // USER_GRADE_TYPE
	// 是否VIP
	private Integer isVIP;
	// 记录登录错误次数
	private Integer error_count;
	// 记录登录错误发生时间
	private Date error_date;
	//是否充值
	private Integer isCharge; //0未充值过 1充值过
	//大客户KEY
	private String digest;
	//是否虚拟账户   
	private Integer isVirtualAccount;//0 否 1 是 
	//是否多身份账户 比如同一个真实姓名注册多个账号
	private Integer isMultiIdentity;//0 否 1 是
	//支付方式
	private String payWays;
	//zfb账号
	private String zfbAccount;
	//wx账号
	private String wxAccount;
	
	private String username;
	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZfbAccount() {
		return zfbAccount;
	}

	public void setZfbAccount(String zfbAccount) {
		this.zfbAccount = zfbAccount;
	}

	public String getWxAccount() {
		return wxAccount;
	}

	public void setWxAccount(String wxAccount) {
		this.wxAccount = wxAccount;
	}

	public String getPayWays() {
		return payWays;
	}

	public void setPayWays(String payWays) {
		this.payWays = payWays;
	}

	/**
	 * 是否白名单用户(0是 1否     默认为1)
	 */
	private Integer isWhitelist = CommonStatus.NO.getValue();
	
	public Integer getError_count() {
		return error_count;
	}

	public void setError_count(Integer error_count) {
		this.error_count = error_count;
	}

	public Date getError_date() {
		return error_date;
	}

	public void setError_date(Date error_date) {
		this.error_date = error_date;
	}

	public Integer getPlayStatus() {
		return playStatus;
	}

	public void setPlayStatus(Integer playStatus) {
		this.playStatus = playStatus;
	}

	public Date getCeratePlayDate() {
		return ceratePlayDate;
	}

	public void setCeratePlayDate(Date ceratePlayDate) {
		this.ceratePlayDate = ceratePlayDate;
	}

	/** default constructor */
	public AbstractMember() {
	}

	/** minimal constructor */
	public AbstractMember(String account, String name, Integer certType, String certNo, String password, Integer rank, String email, String mobile,
			Integer status, Integer exprerience, Integer sourceId) {
		this.account = account;
		this.name = name;
		this.certType = certType;
		this.certNo = certNo;
		this.password = password;
		this.rank = rank;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.exprerience = exprerience;
		this.sourceId = sourceId;
	}

	/** full constructor */
	public AbstractMember(String account, String name, Integer certType, String certNo, String password, Integer rank, String email, String mobile,
			Integer status, Date registerDateTime, Date lastLoginDateTime, Integer exprerience, Integer sourceId, Integer recommender) {
		this.account = account;
		this.name = name;
		this.certType = certType;
		this.certNo = certNo;
		this.password = password;
		this.rank = rank;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.registerDateTime = registerDateTime;
		this.lastLoginDateTime = lastLoginDateTime;
		this.exprerience = exprerience;
		this.sourceId = sourceId;
		this.recommender = recommender;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCertType() {
		return this.certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return this.certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getStatus() {
		return this.status;
	}

	public String getStatusName() {
		return MemberStatus.getItem(status).getName();
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getRegisterDateTime() {
		return this.registerDateTime;
	}

	public void setRegisterDateTime(Date registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	public Date getLastLoginDateTime() {
		return this.lastLoginDateTime;
	}

	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public Integer getExprerience() {
		return this.exprerience;
	}

	public void setExprerience(Integer exprerience) {
		this.exprerience = exprerience;
	}

	public Integer getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getRecommender() {
		return recommender;
	}

	public void setRecommender(Integer recommender) {
		this.recommender = recommender;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getCard() {
		return card;
	}

	public void setCard(Integer card) {
		this.card = card;
	}

	public Integer getIsMobileAuthed() {
		return isMobileAuthed;
	}

	public void setIsMobileAuthed(Integer isMobileAuthed) {
		this.isMobileAuthed = isMobileAuthed;
	}

	public Integer getIsEmailAuthed() {
		return isEmailAuthed;
	}

	public void setIsEmailAuthed(Integer isEmailAuthed) {
		this.isEmailAuthed = isEmailAuthed;
	}

	public Integer getIsReturnPoint() {
		return isReturnPoint;
	}

	public void setIsReturnPoint(Integer isReturnPoint) {
		this.isReturnPoint = isReturnPoint;
	}

	public String getIsReturnPointName() {
		return MemberReturnPoint.getItem(isReturnPoint).getName();
	}

	public Integer getUserGradeType() {
		return userGradeType;
	}

	public void setUserGradeType(Integer userGradeType) {
		this.userGradeType = userGradeType;
	}

	public Integer getIsVIP() {
		return isVIP;
	}

	public void setIsVIP(Integer isVIP) {
		this.isVIP = isVIP;
	}

	public String getIsVIPName() {
		return MemberVIP.getItem(isVIP).getName();
	}

	public Integer getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(Integer isCharge) {
		this.isCharge = isCharge;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public Integer getIsVirtualAccount() {
		if(isVirtualAccount==null){
			isVirtualAccount= Constant.isVirtualAccount(getAccount())?1:0;
		}
		return isVirtualAccount;
	}


	public Integer getIsMultiIdentity() {
		return isMultiIdentity;
	}

	public void setIsMultiIdentity(Integer isMultiIdentity) {
		this.isMultiIdentity = isMultiIdentity;
	}

	public Integer getIsWhitelist() {
		return isWhitelist;
	}

	public void setIsWhitelist(Integer isWhitelist) {
		this.isWhitelist = isWhitelist;
	}
}