package com.qiyun.DTO;

import com.qiyun.model.MatchItem;

import java.io.Serializable;
import java.util.List;

public class LotteryPlanDTO implements Serializable {
    private boolean isOnlyPlay;
    private boolean shedan;
    private List<MatchItem> matchItems;

    public boolean isOnlyPlay() {
        return isOnlyPlay;
    }

    public void setOnlyPlay(boolean onlyPlay) {
        isOnlyPlay = onlyPlay;
    }

    public boolean isShedan() {
        return shedan;
    }

    public void setShedan(boolean shedan) {
        this.shedan = shedan;
    }

    public List<MatchItem> getMatchItems() {
        return matchItems;
    }

    public void setMatchItems(List<MatchItem> matchItems) {
        this.matchItems = matchItems;
    }
}
