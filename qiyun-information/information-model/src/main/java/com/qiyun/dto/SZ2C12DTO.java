package com.qiyun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class SZ2C12DTO implements Serializable {
    private Integer id;

    private String matchId1;

    private String matchId2;

    private String homeTeam1;

    private String guestTeam1;

    private String recommend1;

    private String homeTeam2;

    private String guestTeam2;

    private String recommend2;

    private Integer multiple;

    private Double amount;

    private String bonus;

    private Integer result;

    private String author;

    private Integer number;

    private Date createDate;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchId1() {
        return matchId1;
    }

    public void setMatchId1(String matchId1) {
        this.matchId1 = matchId1 == null ? null : matchId1.trim();
    }

    public String getMatchId2() {
        return matchId2;
    }

    public void setMatchId2(String matchId2) {
        this.matchId2 = matchId2 == null ? null : matchId2.trim();
    }

    public String getHomeTeam1() {
        return homeTeam1;
    }

    public void setHomeTeam1(String homeTeam1) {
        this.homeTeam1 = homeTeam1 == null ? null : homeTeam1.trim();
    }

    public String getGuestTeam1() {
        return guestTeam1;
    }

    public void setGuestTeam1(String guestTeam1) {
        this.guestTeam1 = guestTeam1 == null ? null : guestTeam1.trim();
    }

    public String getRecommend1() {
        return recommend1;
    }

    public void setRecommend1(String recommend1) {
        this.recommend1 = recommend1 == null ? null : recommend1.trim();
    }

    public String getHomeTeam2() {
        return homeTeam2;
    }

    public void setHomeTeam2(String homeTeam2) {
        this.homeTeam2 = homeTeam2 == null ? null : homeTeam2.trim();
    }

    public String getGuestTeam2() {
        return guestTeam2;
    }

    public void setGuestTeam2(String guestTeam2) {
        this.guestTeam2 = guestTeam2 == null ? null : guestTeam2.trim();
    }

    public String getRecommend2() {
        return recommend2;
    }

    public void setRecommend2(String recommend2) {
        this.recommend2 = recommend2 == null ? null : recommend2.trim();
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus == null ? null : bonus.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", matchId1=").append(matchId1);
        sb.append(", matchId2=").append(matchId2);
        sb.append(", homeTeam1=").append(homeTeam1);
        sb.append(", guestTeam1=").append(guestTeam1);
        sb.append(", recommend1=").append(recommend1);
        sb.append(", homeTeam2=").append(homeTeam2);
        sb.append(", guestTeam2=").append(guestTeam2);
        sb.append(", recommend2=").append(recommend2);
        sb.append(", multiple=").append(multiple);
        sb.append(", amount=").append(amount);
        sb.append(", bonus=").append(bonus);
        sb.append(", result=").append(result);
        sb.append(", author=").append(author);
        sb.append(", number=").append(number);
        sb.append(", createDate=").append(createDate);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
