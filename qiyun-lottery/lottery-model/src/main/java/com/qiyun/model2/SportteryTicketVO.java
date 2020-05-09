package com.qiyun.model2;

import com.qiyun.grabber.model.AbstactMatch;
import com.qiyun.model.MatchItem;
import com.qiyun.ticket.Ticket;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SportteryTicketVO implements Serializable {

    private List<? extends MatchItem> matchItemList;
    private List<? extends AbstactMatch> matchList;
    private double amount = 2;// 一注金额
    private String option;//
    private Map<String, List<String>> optionMap;// key=intTime+lineId,value=List
    //[0]lotteryType [1]-投注选项如"胜"'[2]-sp [3]-场次号如:周三001  [4]-进球数 [5]-让分 [6]-大小分
    private String voKeys;// vo主键.判断两个vo是否相同拆票
    private Object passType;// 过关方式
    private Integer betCount = 1;// 注数 1
    private Double totalPrice; // 总奖金
    private Double singlePrice; // 单倍奖金
    private Integer multiple;// 倍数
    private boolean isOpenPrize = false;// 是否开奖
    private boolean isBingo = false;// 是否中奖
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Map<String, List<String>> getOptionMap() {
        return optionMap;
    }

    public void setOptionMap(Map<String, List<String>> optionMap) {
        this.optionMap = optionMap;
    }

    public Integer getBetCount() {
        return betCount;
    }

    public void setBetCount(Integer betCount) {
        this.betCount = betCount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public List<? extends MatchItem> getMatchItemList() {
        return matchItemList;
    }

    public void setMatchItemList(List<? extends MatchItem> matchItemList) {
        this.matchItemList = matchItemList;
    }

    public String getVoKeys() {
        return voKeys;
    }

    public void setVoKeys(String voKeys) {
        this.voKeys = voKeys;
    }

    public boolean getIsOpenPrize() {
        return isOpenPrize;
    }

    public void setIsOpenPrize(boolean isOpenPrize) {
        this.isOpenPrize = isOpenPrize;
    }

    public boolean getIsBingo() {
        return isBingo;
    }

    public void setIsBingo(boolean isBingo) {
        this.isBingo = isBingo;
    }

    public Object getPassType() {
        return passType;
    }

    public void setPassType(Object passType) {
        this.passType = passType;
    }

    public List<? extends AbstactMatch> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<? extends AbstactMatch> matchList) {
        this.matchList = matchList;
    }

}
