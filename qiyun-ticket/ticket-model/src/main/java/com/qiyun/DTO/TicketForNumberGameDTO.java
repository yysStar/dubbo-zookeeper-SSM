package com.qiyun.DTO;

public class TicketForNumberGameDTO {
    private String orderID;
    private String playType;
    private String LotMoney;
    private String LotMulti;
    private UserProfileDTO userProfile;
    private String[] authCode;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public String getLotMoney() {
        return LotMoney;
    }

    public void setLotMoney(String lotMoney) {
        LotMoney = lotMoney;
    }

    public String getLotMulti() {
        return LotMulti;
    }

    public void setLotMulti(String lotMulti) {
        LotMulti = lotMulti;
    }

    public UserProfileDTO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDTO userProfile) {
        this.userProfile = userProfile;
    }

    public String[] getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String[] authCode) {
        this.authCode = authCode;
    }
}
