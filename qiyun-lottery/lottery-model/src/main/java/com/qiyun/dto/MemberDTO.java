package com.qiyun.dto;

import com.qiyun.utils.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class MemberDTO implements Serializable {
    /**
     * 会员编号
     */
    private Integer id;

    /**
     * 账户名
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 凭证类型：1为身份证
     */
    private Short certType;

    /**
     * 凭证号
     */
    private String certNo;

    /**
     * 密码（MD5）加密
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 账号状态，0为正常
     */
    private Boolean status;

    /**
     * 注册时间
     */
    private Date registerDatetime;

    /**
     * 是否为是白名单账号，0-不是，1-是
     */
    private Boolean isWhitelist;

    /**
     * 最后登录时间
     */
    private Date lastLoginDatetime;

    /**
     * 来源编号（渠道或代理id）
     */
    private Integer sourceId;

    /**
     * 推荐人id
     */
    private Integer recommender;

    /**
     * 签名验证
     */
    private String sign;

    /**
     * 提供者：QD-渠道，DL-代理
     */
    private String provider;

    /**
     * 头像图片
     */
    private String picture;

    /**
     * 级别
     */
    private Short rank;

    /**
     * 经验值
     */
    private Integer exprerience;

    /**
     * 名片
     */
    private Integer card;

    /**
     * 手机是否通过验证，1为通过
     */
    private Boolean isMobileAuthed;

    /**
     * 邮箱是否通过验证，1为通过
     */
    private Boolean isEmailAuthed;

    /**
     * 登录错误次数
     */
    private Integer errorCount;

    /**
     * 记录登录错误的时间
     */
    private Date errorDate;

    /**
     * 是否充值,1为已充值
     */
    private Boolean isCharge;

    /**
     * 大客户key
     */
    private String digest;

    /**
     * 支付方式
     */
    private String payWays;

    /**
     * 支付宝账号
     */
    private String zfbAccount;

    /**
     * 微信账号
     */
    private String wxAccount;

    private String username;

    /**
     * 类型  0普通会员  1彩研人员  2机器人
     */
    private Integer type;

    /**
     * 彩研人员倍数
     */
    private Integer multiple;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getCertType() {
        return certType;
    }

    public void setCertType(Short certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(Date registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public Boolean getIsWhitelist() {
        return isWhitelist;
    }

    public void setIsWhitelist(Boolean isWhitelist) {
        this.isWhitelist = isWhitelist;
    }

    public Date getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Date lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public Integer getSourceId() {
        return sourceId;
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
        this.sign = sign == null ? null : sign.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public Integer getExprerience() {
        return exprerience;
    }

    public void setExprerience(Integer exprerience) {
        this.exprerience = exprerience;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public Boolean getIsMobileAuthed() {
        return isMobileAuthed;
    }

    public void setIsMobileAuthed(Boolean isMobileAuthed) {
        this.isMobileAuthed = isMobileAuthed;
    }

    public Boolean getIsEmailAuthed() {
        return isEmailAuthed;
    }

    public void setIsEmailAuthed(Boolean isEmailAuthed) {
        this.isEmailAuthed = isEmailAuthed;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }

    public Boolean getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Boolean isCharge) {
        this.isCharge = isCharge;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public String getPayWays() {
        return payWays;
    }

    public void setPayWays(String payWays) {
        this.payWays = payWays == null ? null : payWays.trim();
    }

    public String getZfbAccount() {
        return zfbAccount;
    }

    public void setZfbAccount(String zfbAccount) {
        this.zfbAccount = zfbAccount == null ? null : zfbAccount.trim();
    }

    public String getWxAccount() {
        return wxAccount;
    }

    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount == null ? null : wxAccount.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", certType=").append(certType);
        sb.append(", certNo=").append(certNo);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", status=").append(status);
        sb.append(", registerDatetime=").append(registerDatetime);
        sb.append(", isWhitelist=").append(isWhitelist);
        sb.append(", lastLoginDatetime=").append(lastLoginDatetime);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", recommender=").append(recommender);
        sb.append(", sign=").append(sign);
        sb.append(", provider=").append(provider);
        sb.append(", picture=").append(picture);
        sb.append(", rank=").append(rank);
        sb.append(", exprerience=").append(exprerience);
        sb.append(", card=").append(card);
        sb.append(", isMobileAuthed=").append(isMobileAuthed);
        sb.append(", isEmailAuthed=").append(isEmailAuthed);
        sb.append(", errorCount=").append(errorCount);
        sb.append(", errorDate=").append(errorDate);
        sb.append(", isCharge=").append(isCharge);
        sb.append(", digest=").append(digest);
        sb.append(", payWays=").append(payWays);
        sb.append(", zfbAccount=").append(zfbAccount);
        sb.append(", wxAccount=").append(wxAccount);
        sb.append(", username=").append(username);
        sb.append(", type=").append(type);
        sb.append(", multiple=").append(multiple);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    public String getPictureUrl() {
        if (!StringUtils.isNullOrBlank(getPicture())) {
            return "qyun88.oss-cn-hangzhou.aliyuncs.com/member/" + this.getPicture();
        }
        return null;
    }
}
