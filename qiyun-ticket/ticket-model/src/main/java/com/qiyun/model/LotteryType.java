package com.qiyun.model;

public class LotteryType {
    private Integer id;

    private String name;

    private Integer highId;

    private Integer ticketId;

    private Boolean isBottom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getHighId() {
        return highId;
    }

    public void setHighId(Integer highId) {
        this.highId = highId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Boolean getIsBottom() {
        return isBottom;
    }

    public void setIsBottom(Boolean isBottom) {
        this.isBottom = isBottom;
    }
}