package com.qiyun.model2;

public class TicketLottreyMapping2 {
    private Integer id;

    private Integer ticketId;

    private Integer lotteryTypeId;

    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getLotteryTypeId() {
        return lotteryTypeId;
    }

    public void setLotteryTypeId(Integer lotteryTypeId) {
        this.lotteryTypeId = lotteryTypeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}