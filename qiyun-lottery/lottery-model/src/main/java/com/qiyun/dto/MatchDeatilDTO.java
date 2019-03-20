package com.qiyun.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MatchDeatilDTO implements Serializable {
    private List<Map<String,String>> options;
    private String matchId;
    private String type;
    private String homeTeam;
    private String guestTeam;
    private Integer guestScore;
    private Integer homeScore;
    private Integer halfhomescore;
    private Integer halfguestscore;

    public List<Map<String, String>> getOptions() {
        return options;
    }

    public void setOptions(List<Map<String, String>> options) {
        this.options = options;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
    }

    public Integer getGuestScore() {
        return guestScore;
    }

    public void setGuestScore(Integer guestScore) {
        this.guestScore = guestScore;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getHalfhomescore() {
        return halfhomescore;
    }

    public void setHalfhomescore(Integer halfhomescore) {
        this.halfhomescore = halfhomescore;
    }

    public Integer getHalfguestscore() {
        return halfguestscore;
    }

    public void setHalfguestscore(Integer halfguestscore) {
        this.halfguestscore = halfguestscore;
    }
}
