package com.qiyun.dto;

import com.qiyun.utils.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class Member2DTO implements Serializable {
    private Integer id;

    private String account;

    private String name;

    private Integer certType;

    private String certNo;

    private String password;

    private Integer rank;

    private String email;

    private String mobile;

    private Integer status;

    private Date registerDateTime;

    private Date lastLoginDateTime;

    private Integer exprerience;

    private Integer sourceId;

    private Integer recommender;

    private String sign;

    private String provider;

    private String picture;

    private Integer card;

    private Integer isMobileAuthed;

    private Integer isEmailAuthed;

    private Date ceratePlayDate;

    private Integer playStatus;

    private Integer userGradeType;

    private Integer errorCount;

    private Date errorDate;

    private Integer isCharge;

    private String digest;

    private Integer isWhitelist;

    private String payWays;

    private String zfbAccount;

    private String wxAccount;

    private String username;

    /**
     * 类型 0普通会员 1彩研人员 2机器人
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

    public Integer getCertType() {
        return certType;
    }

    public void setCertType(Integer certType) {
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Date registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public Date getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(Date lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public Integer getExprerience() {
        return exprerience;
    }

    public void setExprerience(Integer exprerience) {
        this.exprerience = exprerience;
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

    public Date getCeratePlayDate() {
        return ceratePlayDate;
    }

    public void setCeratePlayDate(Date ceratePlayDate) {
        this.ceratePlayDate = ceratePlayDate;
    }

    public Integer getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(Integer playStatus) {
        this.playStatus = playStatus;
    }

    public Integer getUserGradeType() {
        return userGradeType;
    }

    public void setUserGradeType(Integer userGradeType) {
        this.userGradeType = userGradeType;
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
        this.digest = digest == null ? null : digest.trim();
    }

    public Integer getIsWhitelist() {
        return isWhitelist;
    }

    public void setIsWhitelist(Integer isWhitelist) {
        this.isWhitelist = isWhitelist;
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
        sb.append(", rank=").append(rank);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", status=").append(status);
        sb.append(", registerDateTime=").append(registerDateTime);
        sb.append(", lastLoginDateTime=").append(lastLoginDateTime);
        sb.append(", exprerience=").append(exprerience);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", recommender=").append(recommender);
        sb.append(", sign=").append(sign);
        sb.append(", provider=").append(provider);
        sb.append(", picture=").append(picture);
        sb.append(", card=").append(card);
        sb.append(", isMobileAuthed=").append(isMobileAuthed);
        sb.append(", isEmailAuthed=").append(isEmailAuthed);
        sb.append(", ceratePlayDate=").append(ceratePlayDate);
        sb.append(", playStatus=").append(playStatus);
        sb.append(", userGradeType=").append(userGradeType);
        sb.append(", errorCount=").append(errorCount);
        sb.append(", errorDate=").append(errorDate);
        sb.append(", isCharge=").append(isCharge);
        sb.append(", digest=").append(digest);
        sb.append(", isWhitelist=").append(isWhitelist);
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
