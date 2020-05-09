package com.qiyun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketFind {
    private Integer id;

    private Integer planNo;

    private Date findTime;

    private Boolean isFind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public Date getFindTime() {
        return findTime;
    }

    public void setFindTime(Date findTime) {
        this.findTime = findTime;
    }

    public Boolean getIsFind() {
        return isFind;
    }

    public void setIsFind(Boolean isFind) {
        this.isFind = isFind;
    }
}