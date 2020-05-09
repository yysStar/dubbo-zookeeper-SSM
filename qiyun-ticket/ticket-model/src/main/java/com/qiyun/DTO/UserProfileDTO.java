package com.qiyun.DTO;

/**
 * 通彩易麦下单需要用户参数
 */
public class UserProfileDTO {
    // 用户名
    private String userName;
    // 证件类型
    private String cardType;
    // 邮箱
    private String mail;
    // 证件号
    private String cardNumber;
    // 手机号
    private String mobile;
    // 真实姓名
    private String realName;
    // 用户的大奖通知电话
    private String bonusPhone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBonusPhone() {
        return bonusPhone;
    }

    public void setBonusPhone(String bonusPhone) {
        this.bonusPhone = bonusPhone;
    }
}
