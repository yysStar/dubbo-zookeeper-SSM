package com.qiyun.DTO;

import com.qiyun.model.TicketBusiness;

import java.io.Serializable;
import java.util.List;

public class LotteryBusinessDTO implements Serializable{
    //玩法id
    private int lotteryTypeId;
    //玩法名称
    private String lotteryTypeName;
    //默认票务商
    private String defaultBusiness;
    //玩法可用票务商列表
    private List<BusinessDTO> businessList;
//    private List<TicketBusiness> businessList;

    public int getLotteryTypeId() {
        return lotteryTypeId;
    }

    public void setLotteryTypeId(int lotteryTypeId) {
        this.lotteryTypeId = lotteryTypeId;
    }

    public String getLotteryTypeName() {
        return lotteryTypeName;
    }

    public void setLotteryTypeName(String lotteryTypeName) {
        this.lotteryTypeName = lotteryTypeName;
    }

    public String getDefaultBusiness() {
        return defaultBusiness;
    }

    public void setDefaultBusiness(String defaultBusiness) {
        this.defaultBusiness = defaultBusiness;
    }

//    public List<TicketBusiness> getBusinessList() {
//        return businessList;
//    }
//
//    public void setBusinessList(List<TicketBusiness> businessList) {
//        this.businessList = businessList;
//    }

    public List<BusinessDTO> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<BusinessDTO> businessList) {
        this.businessList = businessList;
    }
}
