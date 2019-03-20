package com.qiyun.model2;

import com.qiyun.model.SportteryPassType;

import java.io.Serializable;
import java.util.List;

public class SportteryAwardOptimizeModel <X extends MatchItemAwardOptimize> implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<X> matchItems;
    private Integer passMode;
    private List<SportteryPassType> passTypes;
    private int multiple;
    private Boolean isOnlyPlay;
    public List<X> getMatchItems() {
        return matchItems;
    }
    public void setMatchItems(List<X> matchItems) {
        this.matchItems = matchItems;
    }
    public Integer getPassMode() {
        return passMode;
    }
    public void setPassMode(Integer passMode) {
        this.passMode = passMode;
    }
    public List<SportteryPassType> getPassTypes() {
        return passTypes;
    }
    public void setPassTypes(List<SportteryPassType> passTypes) {
        this.passTypes = passTypes;
    }
    public int getMultiple() {
        return multiple;
    }
    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }
    public Boolean getIsOnlyPlay() {
        return isOnlyPlay;
    }
    public void setIsOnlyPlay(Boolean isOnlyPlay) {
        this.isOnlyPlay = isOnlyPlay;
    }

}
