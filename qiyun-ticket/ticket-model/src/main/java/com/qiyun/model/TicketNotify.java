package com.qiyun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketNotify {
    private Integer id;

    private String orderId;

    private String lotId;

    private String ticketSerialNo;

    private String printSerialNo;

    private String stationId;

    private BigDecimal fixedBonus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId == null ? null : lotId.trim();
    }

    public String getTicketSerialNo() {
        return ticketSerialNo;
    }

    public void setTicketSerialNo(String ticketSerialNo) {
        this.ticketSerialNo = ticketSerialNo == null ? null : ticketSerialNo.trim();
    }

    public String getPrintSerialNo() {
        return printSerialNo;
    }

    public void setPrintSerialNo(String printSerialNo) {
        this.printSerialNo = printSerialNo == null ? null : printSerialNo.trim();
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    public BigDecimal getFixedBonus() {
        return fixedBonus;
    }

    public void setFixedBonus(BigDecimal fixedBonus) {
        this.fixedBonus = fixedBonus;
    }
}