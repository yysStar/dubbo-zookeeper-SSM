package com.qiyun.DTO;

public class MatchTicketDTO {
    // 投注号码（方案）
    private String anteCode;
    // 票号生成规则为（代理商编号+递增流水号）
    private String orderId;
    // 玩法的名称
    private String lotId;
    // 投注方式
    private String playType;
    // 当前票的购买金额,单位为元
    private String lotMoney;
    // 该票的倍投数, 默认为1 倍
    private String lotMulti;
    // 购彩人信息
    private UserProfileDTO userProfilel;

    public String getAnteCode() {
        return anteCode;
    }

    public void setAnteCode(String anteCode) {
        this.anteCode = anteCode;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public UserProfileDTO getUserProfilel() {
        return userProfilel;
    }

    public void setUserProfilel(UserProfileDTO userProfilel) {
        this.userProfilel = userProfilel;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getLotMoney() {
        return lotMoney;
    }

    public void setLotMoney(String lotMoney) {
        this.lotMoney = lotMoney;
    }

    public String getLotMulti() {
        return lotMulti;
    }

    public void setLotMulti(String lotMulti) {
        this.lotMulti = lotMulti;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
