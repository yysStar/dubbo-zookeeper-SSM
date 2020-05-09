package com.qiyun.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoldCard2 implements Serializable {
    private Integer id;
    private String account;
    private String card_name;
    private BigDecimal full_amount;
    private Integer require_type;
    private BigDecimal money;
    private Date create_time;
    private Date deadline_time;
    private Integer status;
    private Date use_time;
    private String send_name;

    public GoldCard2() {
    }

    public GoldCard2(String account, String card_name, BigDecimal full_amount, Integer require_type, BigDecimal money, Date create_time, Date deadline_time, Integer status, Date use_time,String send_name) {

        this.account = account;
        this.card_name = card_name;
        this.full_amount = full_amount;
        this.require_type = require_type;
        this.money = money;
        this.create_time = create_time;
        this.deadline_time = deadline_time;
        this.status = status;
        this.use_time = use_time;
        this.send_name = send_name;
    }

    public String getSend_name() {
        return send_name;
    }

    public void setSend_name(String send_name) {
        this.send_name = send_name;
    }

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
        this.account = account;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public BigDecimal getFull_amount() {
        return full_amount;
    }

    public void setFull_amount(BigDecimal full_amount) {
        this.full_amount = full_amount;
    }

    public Integer getRequire_type() {
        return require_type;
    }

    public void setRequire_type(Integer require_type) {
        this.require_type = require_type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getDeadline_time() {
        return deadline_time;
    }

    public void setDeadline_time(Date deadline_time) {
        this.deadline_time = deadline_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUse_time() {
        return use_time;
    }

    public void setUse_time(Date use_time) {
        this.use_time = use_time;
    }

    @Override
    public String toString() {
        return "GoldCard2{" +
                "account='" + account + '\'' +
                ", card_name='" + card_name + '\'' +
                ", full_amount=" + full_amount +
                ", require_type=" + require_type +
                ", money=" + money +
                ", create_time=" + create_time +
                ", deadline_time=" + deadline_time +
                ", status=" + status +
                ", use_time=" + use_time +
                '}';
    }
}
