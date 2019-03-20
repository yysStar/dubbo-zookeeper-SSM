package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryFootballMatch2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryFootballMatch2Query() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andHometeamIsNull() {
            addCriterion("homeTeam is null");
            return (Criteria) this;
        }

        public Criteria andHometeamIsNotNull() {
            addCriterion("homeTeam is not null");
            return (Criteria) this;
        }

        public Criteria andHometeamEqualTo(String value) {
            addCriterion("homeTeam =", value, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamNotEqualTo(String value) {
            addCriterion("homeTeam <>", value, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamGreaterThan(String value) {
            addCriterion("homeTeam >", value, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamGreaterThanOrEqualTo(String value) {
            addCriterion("homeTeam >=", value, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamLessThan(String value) {
            addCriterion("homeTeam <", value, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamLessThanOrEqualTo(String value) {
            addCriterion("homeTeam <=", value, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamLike(String value) {
            addCriterion("homeTeam like", value, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamNotLike(String value) {
            addCriterion("homeTeam not like", value, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamIn(List<String> values) {
            addCriterion("homeTeam in", values, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamNotIn(List<String> values) {
            addCriterion("homeTeam not in", values, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamBetween(String value1, String value2) {
            addCriterion("homeTeam between", value1, value2, "hometeam");
            return (Criteria) this;
        }

        public Criteria andHometeamNotBetween(String value1, String value2) {
            addCriterion("homeTeam not between", value1, value2, "hometeam");
            return (Criteria) this;
        }

        public Criteria andGamecolorIsNull() {
            addCriterion("gameColor is null");
            return (Criteria) this;
        }

        public Criteria andGamecolorIsNotNull() {
            addCriterion("gameColor is not null");
            return (Criteria) this;
        }

        public Criteria andGamecolorEqualTo(String value) {
            addCriterion("gameColor =", value, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorNotEqualTo(String value) {
            addCriterion("gameColor <>", value, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorGreaterThan(String value) {
            addCriterion("gameColor >", value, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorGreaterThanOrEqualTo(String value) {
            addCriterion("gameColor >=", value, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorLessThan(String value) {
            addCriterion("gameColor <", value, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorLessThanOrEqualTo(String value) {
            addCriterion("gameColor <=", value, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorLike(String value) {
            addCriterion("gameColor like", value, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorNotLike(String value) {
            addCriterion("gameColor not like", value, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorIn(List<String> values) {
            addCriterion("gameColor in", values, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorNotIn(List<String> values) {
            addCriterion("gameColor not in", values, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorBetween(String value1, String value2) {
            addCriterion("gameColor between", value1, value2, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGamecolorNotBetween(String value1, String value2) {
            addCriterion("gameColor not between", value1, value2, "gamecolor");
            return (Criteria) this;
        }

        public Criteria andGuestteamIsNull() {
            addCriterion("guestTeam is null");
            return (Criteria) this;
        }

        public Criteria andGuestteamIsNotNull() {
            addCriterion("guestTeam is not null");
            return (Criteria) this;
        }

        public Criteria andGuestteamEqualTo(String value) {
            addCriterion("guestTeam =", value, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamNotEqualTo(String value) {
            addCriterion("guestTeam <>", value, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamGreaterThan(String value) {
            addCriterion("guestTeam >", value, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamGreaterThanOrEqualTo(String value) {
            addCriterion("guestTeam >=", value, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamLessThan(String value) {
            addCriterion("guestTeam <", value, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamLessThanOrEqualTo(String value) {
            addCriterion("guestTeam <=", value, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamLike(String value) {
            addCriterion("guestTeam like", value, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamNotLike(String value) {
            addCriterion("guestTeam not like", value, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamIn(List<String> values) {
            addCriterion("guestTeam in", values, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamNotIn(List<String> values) {
            addCriterion("guestTeam not in", values, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamBetween(String value1, String value2) {
            addCriterion("guestTeam between", value1, value2, "guestteam");
            return (Criteria) this;
        }

        public Criteria andGuestteamNotBetween(String value1, String value2) {
            addCriterion("guestTeam not between", value1, value2, "guestteam");
            return (Criteria) this;
        }

        public Criteria andMatchtimeIsNull() {
            addCriterion("matchTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchtimeIsNotNull() {
            addCriterion("matchTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchtimeEqualTo(Date value) {
            addCriterion("matchTime =", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotEqualTo(Date value) {
            addCriterion("matchTime <>", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeGreaterThan(Date value) {
            addCriterion("matchTime >", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchTime >=", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeLessThan(Date value) {
            addCriterion("matchTime <", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeLessThanOrEqualTo(Date value) {
            addCriterion("matchTime <=", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeIn(List<Date> values) {
            addCriterion("matchTime in", values, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotIn(List<Date> values) {
            addCriterion("matchTime not in", values, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeBetween(Date value1, Date value2) {
            addCriterion("matchTime between", value1, value2, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotBetween(Date value1, Date value2) {
            addCriterion("matchTime not between", value1, value2, "matchtime");
            return (Criteria) this;
        }

        public Criteria andInttimeIsNull() {
            addCriterion("intTime is null");
            return (Criteria) this;
        }

        public Criteria andInttimeIsNotNull() {
            addCriterion("intTime is not null");
            return (Criteria) this;
        }

        public Criteria andInttimeEqualTo(Integer value) {
            addCriterion("intTime =", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotEqualTo(Integer value) {
            addCriterion("intTime <>", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeGreaterThan(Integer value) {
            addCriterion("intTime >", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("intTime >=", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeLessThan(Integer value) {
            addCriterion("intTime <", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeLessThanOrEqualTo(Integer value) {
            addCriterion("intTime <=", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeIn(List<Integer> values) {
            addCriterion("intTime in", values, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotIn(List<Integer> values) {
            addCriterion("intTime not in", values, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeBetween(Integer value1, Integer value2) {
            addCriterion("intTime between", value1, value2, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("intTime not between", value1, value2, "inttime");
            return (Criteria) this;
        }

        public Criteria andLineidIsNull() {
            addCriterion("lineId is null");
            return (Criteria) this;
        }

        public Criteria andLineidIsNotNull() {
            addCriterion("lineId is not null");
            return (Criteria) this;
        }

        public Criteria andLineidEqualTo(Integer value) {
            addCriterion("lineId =", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotEqualTo(Integer value) {
            addCriterion("lineId <>", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThan(Integer value) {
            addCriterion("lineId >", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lineId >=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThan(Integer value) {
            addCriterion("lineId <", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThanOrEqualTo(Integer value) {
            addCriterion("lineId <=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidIn(List<Integer> values) {
            addCriterion("lineId in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotIn(List<Integer> values) {
            addCriterion("lineId not in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidBetween(Integer value1, Integer value2) {
            addCriterion("lineId between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotBetween(Integer value1, Integer value2) {
            addCriterion("lineId not between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNull() {
            addCriterion("gameName is null");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNotNull() {
            addCriterion("gameName is not null");
            return (Criteria) this;
        }

        public Criteria andGamenameEqualTo(String value) {
            addCriterion("gameName =", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotEqualTo(String value) {
            addCriterion("gameName <>", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThan(String value) {
            addCriterion("gameName >", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThanOrEqualTo(String value) {
            addCriterion("gameName >=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThan(String value) {
            addCriterion("gameName <", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThanOrEqualTo(String value) {
            addCriterion("gameName <=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLike(String value) {
            addCriterion("gameName like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotLike(String value) {
            addCriterion("gameName not like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameIn(List<String> values) {
            addCriterion("gameName in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotIn(List<String> values) {
            addCriterion("gameName not in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameBetween(String value1, String value2) {
            addCriterion("gameName between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotBetween(String value1, String value2) {
            addCriterion("gameName not between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andGameShortNameIsNull() {
            addCriterion("GAME_SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGameShortNameIsNotNull() {
            addCriterion("GAME_SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGameShortNameEqualTo(String value) {
            addCriterion("GAME_SHORT_NAME =", value, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameNotEqualTo(String value) {
            addCriterion("GAME_SHORT_NAME <>", value, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameGreaterThan(String value) {
            addCriterion("GAME_SHORT_NAME >", value, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("GAME_SHORT_NAME >=", value, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameLessThan(String value) {
            addCriterion("GAME_SHORT_NAME <", value, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameLessThanOrEqualTo(String value) {
            addCriterion("GAME_SHORT_NAME <=", value, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameLike(String value) {
            addCriterion("GAME_SHORT_NAME like", value, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameNotLike(String value) {
            addCriterion("GAME_SHORT_NAME not like", value, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameIn(List<String> values) {
            addCriterion("GAME_SHORT_NAME in", values, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameNotIn(List<String> values) {
            addCriterion("GAME_SHORT_NAME not in", values, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameBetween(String value1, String value2) {
            addCriterion("GAME_SHORT_NAME between", value1, value2, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andGameShortNameNotBetween(String value1, String value2) {
            addCriterion("GAME_SHORT_NAME not between", value1, value2, "gameShortName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andHomescoreIsNull() {
            addCriterion("homeScore is null");
            return (Criteria) this;
        }

        public Criteria andHomescoreIsNotNull() {
            addCriterion("homeScore is not null");
            return (Criteria) this;
        }

        public Criteria andHomescoreEqualTo(Integer value) {
            addCriterion("homeScore =", value, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreNotEqualTo(Integer value) {
            addCriterion("homeScore <>", value, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreGreaterThan(Integer value) {
            addCriterion("homeScore >", value, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("homeScore >=", value, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreLessThan(Integer value) {
            addCriterion("homeScore <", value, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreLessThanOrEqualTo(Integer value) {
            addCriterion("homeScore <=", value, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreIn(List<Integer> values) {
            addCriterion("homeScore in", values, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreNotIn(List<Integer> values) {
            addCriterion("homeScore not in", values, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreBetween(Integer value1, Integer value2) {
            addCriterion("homeScore between", value1, value2, "homescore");
            return (Criteria) this;
        }

        public Criteria andHomescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("homeScore not between", value1, value2, "homescore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreIsNull() {
            addCriterion("guestScore is null");
            return (Criteria) this;
        }

        public Criteria andGuestscoreIsNotNull() {
            addCriterion("guestScore is not null");
            return (Criteria) this;
        }

        public Criteria andGuestscoreEqualTo(Integer value) {
            addCriterion("guestScore =", value, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreNotEqualTo(Integer value) {
            addCriterion("guestScore <>", value, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreGreaterThan(Integer value) {
            addCriterion("guestScore >", value, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("guestScore >=", value, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreLessThan(Integer value) {
            addCriterion("guestScore <", value, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreLessThanOrEqualTo(Integer value) {
            addCriterion("guestScore <=", value, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreIn(List<Integer> values) {
            addCriterion("guestScore in", values, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreNotIn(List<Integer> values) {
            addCriterion("guestScore not in", values, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreBetween(Integer value1, Integer value2) {
            addCriterion("guestScore between", value1, value2, "guestscore");
            return (Criteria) this;
        }

        public Criteria andGuestscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("guestScore not between", value1, value2, "guestscore");
            return (Criteria) this;
        }

        public Criteria andConcedeIsNull() {
            addCriterion("concede is null");
            return (Criteria) this;
        }

        public Criteria andConcedeIsNotNull() {
            addCriterion("concede is not null");
            return (Criteria) this;
        }

        public Criteria andConcedeEqualTo(Integer value) {
            addCriterion("concede =", value, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeNotEqualTo(Integer value) {
            addCriterion("concede <>", value, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeGreaterThan(Integer value) {
            addCriterion("concede >", value, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeGreaterThanOrEqualTo(Integer value) {
            addCriterion("concede >=", value, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeLessThan(Integer value) {
            addCriterion("concede <", value, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeLessThanOrEqualTo(Integer value) {
            addCriterion("concede <=", value, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeIn(List<Integer> values) {
            addCriterion("concede in", values, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeNotIn(List<Integer> values) {
            addCriterion("concede not in", values, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeBetween(Integer value1, Integer value2) {
            addCriterion("concede between", value1, value2, "concede");
            return (Criteria) this;
        }

        public Criteria andConcedeNotBetween(Integer value1, Integer value2) {
            addCriterion("concede not between", value1, value2, "concede");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreIsNull() {
            addCriterion("halfHomeScore is null");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreIsNotNull() {
            addCriterion("halfHomeScore is not null");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreEqualTo(Integer value) {
            addCriterion("halfHomeScore =", value, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreNotEqualTo(Integer value) {
            addCriterion("halfHomeScore <>", value, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreGreaterThan(Integer value) {
            addCriterion("halfHomeScore >", value, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("halfHomeScore >=", value, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreLessThan(Integer value) {
            addCriterion("halfHomeScore <", value, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreLessThanOrEqualTo(Integer value) {
            addCriterion("halfHomeScore <=", value, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreIn(List<Integer> values) {
            addCriterion("halfHomeScore in", values, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreNotIn(List<Integer> values) {
            addCriterion("halfHomeScore not in", values, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreBetween(Integer value1, Integer value2) {
            addCriterion("halfHomeScore between", value1, value2, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfhomescoreNotBetween(Integer value1, Integer value2) {
            addCriterion("halfHomeScore not between", value1, value2, "halfhomescore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreIsNull() {
            addCriterion("halfGuestScore is null");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreIsNotNull() {
            addCriterion("halfGuestScore is not null");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreEqualTo(Integer value) {
            addCriterion("halfGuestScore =", value, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreNotEqualTo(Integer value) {
            addCriterion("halfGuestScore <>", value, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreGreaterThan(Integer value) {
            addCriterion("halfGuestScore >", value, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("halfGuestScore >=", value, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreLessThan(Integer value) {
            addCriterion("halfGuestScore <", value, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreLessThanOrEqualTo(Integer value) {
            addCriterion("halfGuestScore <=", value, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreIn(List<Integer> values) {
            addCriterion("halfGuestScore in", values, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreNotIn(List<Integer> values) {
            addCriterion("halfGuestScore not in", values, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreBetween(Integer value1, Integer value2) {
            addCriterion("halfGuestScore between", value1, value2, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andHalfguestscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("halfGuestScore not between", value1, value2, "halfguestscore");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassIsNull() {
            addCriterion("resultAwardOfTotoPass is null");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassIsNotNull() {
            addCriterion("resultAwardOfTotoPass is not null");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassEqualTo(Double value) {
            addCriterion("resultAwardOfTotoPass =", value, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassNotEqualTo(Double value) {
            addCriterion("resultAwardOfTotoPass <>", value, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassGreaterThan(Double value) {
            addCriterion("resultAwardOfTotoPass >", value, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassGreaterThanOrEqualTo(Double value) {
            addCriterion("resultAwardOfTotoPass >=", value, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassLessThan(Double value) {
            addCriterion("resultAwardOfTotoPass <", value, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassLessThanOrEqualTo(Double value) {
            addCriterion("resultAwardOfTotoPass <=", value, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassIn(List<Double> values) {
            addCriterion("resultAwardOfTotoPass in", values, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassNotIn(List<Double> values) {
            addCriterion("resultAwardOfTotoPass not in", values, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassBetween(Double value1, Double value2) {
            addCriterion("resultAwardOfTotoPass between", value1, value2, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardoftotopassNotBetween(Double value1, Double value2) {
            addCriterion("resultAwardOfTotoPass not between", value1, value2, "resultawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassIsNull() {
            addCriterion("resultRQAwardOfTotoPass is null");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassIsNotNull() {
            addCriterion("resultRQAwardOfTotoPass is not null");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassEqualTo(Double value) {
            addCriterion("resultRQAwardOfTotoPass =", value, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassNotEqualTo(Double value) {
            addCriterion("resultRQAwardOfTotoPass <>", value, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassGreaterThan(Double value) {
            addCriterion("resultRQAwardOfTotoPass >", value, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassGreaterThanOrEqualTo(Double value) {
            addCriterion("resultRQAwardOfTotoPass >=", value, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassLessThan(Double value) {
            addCriterion("resultRQAwardOfTotoPass <", value, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassLessThanOrEqualTo(Double value) {
            addCriterion("resultRQAwardOfTotoPass <=", value, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassIn(List<Double> values) {
            addCriterion("resultRQAwardOfTotoPass in", values, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassNotIn(List<Double> values) {
            addCriterion("resultRQAwardOfTotoPass not in", values, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassBetween(Double value1, Double value2) {
            addCriterion("resultRQAwardOfTotoPass between", value1, value2, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultrqawardoftotopassNotBetween(Double value1, Double value2) {
            addCriterion("resultRQAwardOfTotoPass not between", value1, value2, "resultrqawardoftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassIsNull() {
            addCriterion("resultAwardOfScorePass is null");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassIsNotNull() {
            addCriterion("resultAwardOfScorePass is not null");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassEqualTo(Double value) {
            addCriterion("resultAwardOfScorePass =", value, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassNotEqualTo(Double value) {
            addCriterion("resultAwardOfScorePass <>", value, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassGreaterThan(Double value) {
            addCriterion("resultAwardOfScorePass >", value, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassGreaterThanOrEqualTo(Double value) {
            addCriterion("resultAwardOfScorePass >=", value, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassLessThan(Double value) {
            addCriterion("resultAwardOfScorePass <", value, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassLessThanOrEqualTo(Double value) {
            addCriterion("resultAwardOfScorePass <=", value, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassIn(List<Double> values) {
            addCriterion("resultAwardOfScorePass in", values, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassNotIn(List<Double> values) {
            addCriterion("resultAwardOfScorePass not in", values, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassBetween(Double value1, Double value2) {
            addCriterion("resultAwardOfScorePass between", value1, value2, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofscorepassNotBetween(Double value1, Double value2) {
            addCriterion("resultAwardOfScorePass not between", value1, value2, "resultawardofscorepass");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreIsNull() {
            addCriterion("resultAwardOfSingleScore is null");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreIsNotNull() {
            addCriterion("resultAwardOfSingleScore is not null");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreEqualTo(Double value) {
            addCriterion("resultAwardOfSingleScore =", value, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreNotEqualTo(Double value) {
            addCriterion("resultAwardOfSingleScore <>", value, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreGreaterThan(Double value) {
            addCriterion("resultAwardOfSingleScore >", value, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreGreaterThanOrEqualTo(Double value) {
            addCriterion("resultAwardOfSingleScore >=", value, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreLessThan(Double value) {
            addCriterion("resultAwardOfSingleScore <", value, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreLessThanOrEqualTo(Double value) {
            addCriterion("resultAwardOfSingleScore <=", value, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreIn(List<Double> values) {
            addCriterion("resultAwardOfSingleScore in", values, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreNotIn(List<Double> values) {
            addCriterion("resultAwardOfSingleScore not in", values, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreBetween(Double value1, Double value2) {
            addCriterion("resultAwardOfSingleScore between", value1, value2, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofsinglescoreNotBetween(Double value1, Double value2) {
            addCriterion("resultAwardOfSingleScore not between", value1, value2, "resultawardofsinglescore");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassIsNull() {
            addCriterion("resultAwardOfHfTotoPass is null");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassIsNotNull() {
            addCriterion("resultAwardOfHfTotoPass is not null");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassEqualTo(Double value) {
            addCriterion("resultAwardOfHfTotoPass =", value, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassNotEqualTo(Double value) {
            addCriterion("resultAwardOfHfTotoPass <>", value, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassGreaterThan(Double value) {
            addCriterion("resultAwardOfHfTotoPass >", value, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassGreaterThanOrEqualTo(Double value) {
            addCriterion("resultAwardOfHfTotoPass >=", value, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassLessThan(Double value) {
            addCriterion("resultAwardOfHfTotoPass <", value, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassLessThanOrEqualTo(Double value) {
            addCriterion("resultAwardOfHfTotoPass <=", value, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassIn(List<Double> values) {
            addCriterion("resultAwardOfHfTotoPass in", values, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassNotIn(List<Double> values) {
            addCriterion("resultAwardOfHfTotoPass not in", values, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassBetween(Double value1, Double value2) {
            addCriterion("resultAwardOfHfTotoPass between", value1, value2, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andResultawardofhftotopassNotBetween(Double value1, Double value2) {
            addCriterion("resultAwardOfHfTotoPass not between", value1, value2, "resultawardofhftotopass");
            return (Criteria) this;
        }

        public Criteria andOutidIsNull() {
            addCriterion("outId is null");
            return (Criteria) this;
        }

        public Criteria andOutidIsNotNull() {
            addCriterion("outId is not null");
            return (Criteria) this;
        }

        public Criteria andOutidEqualTo(Integer value) {
            addCriterion("outId =", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotEqualTo(Integer value) {
            addCriterion("outId <>", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidGreaterThan(Integer value) {
            addCriterion("outId >", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidGreaterThanOrEqualTo(Integer value) {
            addCriterion("outId >=", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLessThan(Integer value) {
            addCriterion("outId <", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLessThanOrEqualTo(Integer value) {
            addCriterion("outId <=", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidIn(List<Integer> values) {
            addCriterion("outId in", values, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotIn(List<Integer> values) {
            addCriterion("outId not in", values, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidBetween(Integer value1, Integer value2) {
            addCriterion("outId between", value1, value2, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotBetween(Integer value1, Integer value2) {
            addCriterion("outId not between", value1, value2, "outid");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNull() {
            addCriterion("GAME_ID is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("GAME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(Integer value) {
            addCriterion("GAME_ID =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(Integer value) {
            addCriterion("GAME_ID <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(Integer value) {
            addCriterion("GAME_ID >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GAME_ID >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(Integer value) {
            addCriterion("GAME_ID <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(Integer value) {
            addCriterion("GAME_ID <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<Integer> values) {
            addCriterion("GAME_ID in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<Integer> values) {
            addCriterion("GAME_ID not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(Integer value1, Integer value2) {
            addCriterion("GAME_ID between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GAME_ID not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleIsNull() {
            addCriterion("result_of_rule is null");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleIsNotNull() {
            addCriterion("result_of_rule is not null");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleEqualTo(Integer value) {
            addCriterion("result_of_rule =", value, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleNotEqualTo(Integer value) {
            addCriterion("result_of_rule <>", value, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleGreaterThan(Integer value) {
            addCriterion("result_of_rule >", value, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("result_of_rule >=", value, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleLessThan(Integer value) {
            addCriterion("result_of_rule <", value, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleLessThanOrEqualTo(Integer value) {
            addCriterion("result_of_rule <=", value, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleIn(List<Integer> values) {
            addCriterion("result_of_rule in", values, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleNotIn(List<Integer> values) {
            addCriterion("result_of_rule not in", values, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleBetween(Integer value1, Integer value2) {
            addCriterion("result_of_rule between", value1, value2, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andResultOfRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("result_of_rule not between", value1, value2, "resultOfRule");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNull() {
            addCriterion("PRIZE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNotNull() {
            addCriterion("PRIZE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeEqualTo(Integer value) {
            addCriterion("PRIZE_TYPE =", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotEqualTo(Integer value) {
            addCriterion("PRIZE_TYPE <>", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThan(Integer value) {
            addCriterion("PRIZE_TYPE >", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIZE_TYPE >=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThan(Integer value) {
            addCriterion("PRIZE_TYPE <", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PRIZE_TYPE <=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIn(List<Integer> values) {
            addCriterion("PRIZE_TYPE in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotIn(List<Integer> values) {
            addCriterion("PRIZE_TYPE not in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeBetween(Integer value1, Integer value2) {
            addCriterion("PRIZE_TYPE between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIZE_TYPE not between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andShownumIsNull() {
            addCriterion("showNum is null");
            return (Criteria) this;
        }

        public Criteria andShownumIsNotNull() {
            addCriterion("showNum is not null");
            return (Criteria) this;
        }

        public Criteria andShownumEqualTo(Integer value) {
            addCriterion("showNum =", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumNotEqualTo(Integer value) {
            addCriterion("showNum <>", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumGreaterThan(Integer value) {
            addCriterion("showNum >", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("showNum >=", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumLessThan(Integer value) {
            addCriterion("showNum <", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumLessThanOrEqualTo(Integer value) {
            addCriterion("showNum <=", value, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumIn(List<Integer> values) {
            addCriterion("showNum in", values, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumNotIn(List<Integer> values) {
            addCriterion("showNum not in", values, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumBetween(Integer value1, Integer value2) {
            addCriterion("showNum between", value1, value2, "shownum");
            return (Criteria) this;
        }

        public Criteria andShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("showNum not between", value1, value2, "shownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumIsNull() {
            addCriterion("SPF_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andSpfShownumIsNotNull() {
            addCriterion("SPF_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andSpfShownumEqualTo(Integer value) {
            addCriterion("SPF_SHOWNUM =", value, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumNotEqualTo(Integer value) {
            addCriterion("SPF_SHOWNUM <>", value, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumGreaterThan(Integer value) {
            addCriterion("SPF_SHOWNUM >", value, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SPF_SHOWNUM >=", value, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumLessThan(Integer value) {
            addCriterion("SPF_SHOWNUM <", value, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumLessThanOrEqualTo(Integer value) {
            addCriterion("SPF_SHOWNUM <=", value, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumIn(List<Integer> values) {
            addCriterion("SPF_SHOWNUM in", values, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumNotIn(List<Integer> values) {
            addCriterion("SPF_SHOWNUM not in", values, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumBetween(Integer value1, Integer value2) {
            addCriterion("SPF_SHOWNUM between", value1, value2, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andSpfShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("SPF_SHOWNUM not between", value1, value2, "spfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumIsNull() {
            addCriterion("RQSPF_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumIsNotNull() {
            addCriterion("RQSPF_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumEqualTo(Integer value) {
            addCriterion("RQSPF_SHOWNUM =", value, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumNotEqualTo(Integer value) {
            addCriterion("RQSPF_SHOWNUM <>", value, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumGreaterThan(Integer value) {
            addCriterion("RQSPF_SHOWNUM >", value, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("RQSPF_SHOWNUM >=", value, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumLessThan(Integer value) {
            addCriterion("RQSPF_SHOWNUM <", value, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumLessThanOrEqualTo(Integer value) {
            addCriterion("RQSPF_SHOWNUM <=", value, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumIn(List<Integer> values) {
            addCriterion("RQSPF_SHOWNUM in", values, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumNotIn(List<Integer> values) {
            addCriterion("RQSPF_SHOWNUM not in", values, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumBetween(Integer value1, Integer value2) {
            addCriterion("RQSPF_SHOWNUM between", value1, value2, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andRqspfShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("RQSPF_SHOWNUM not between", value1, value2, "rqspfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumIsNull() {
            addCriterion("BF_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andBfShownumIsNotNull() {
            addCriterion("BF_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andBfShownumEqualTo(Integer value) {
            addCriterion("BF_SHOWNUM =", value, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumNotEqualTo(Integer value) {
            addCriterion("BF_SHOWNUM <>", value, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumGreaterThan(Integer value) {
            addCriterion("BF_SHOWNUM >", value, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("BF_SHOWNUM >=", value, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumLessThan(Integer value) {
            addCriterion("BF_SHOWNUM <", value, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumLessThanOrEqualTo(Integer value) {
            addCriterion("BF_SHOWNUM <=", value, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumIn(List<Integer> values) {
            addCriterion("BF_SHOWNUM in", values, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumNotIn(List<Integer> values) {
            addCriterion("BF_SHOWNUM not in", values, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumBetween(Integer value1, Integer value2) {
            addCriterion("BF_SHOWNUM between", value1, value2, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andBfShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("BF_SHOWNUM not between", value1, value2, "bfShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumIsNull() {
            addCriterion("JQS_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andJqsShownumIsNotNull() {
            addCriterion("JQS_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andJqsShownumEqualTo(Integer value) {
            addCriterion("JQS_SHOWNUM =", value, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumNotEqualTo(Integer value) {
            addCriterion("JQS_SHOWNUM <>", value, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumGreaterThan(Integer value) {
            addCriterion("JQS_SHOWNUM >", value, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("JQS_SHOWNUM >=", value, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumLessThan(Integer value) {
            addCriterion("JQS_SHOWNUM <", value, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumLessThanOrEqualTo(Integer value) {
            addCriterion("JQS_SHOWNUM <=", value, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumIn(List<Integer> values) {
            addCriterion("JQS_SHOWNUM in", values, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumNotIn(List<Integer> values) {
            addCriterion("JQS_SHOWNUM not in", values, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumBetween(Integer value1, Integer value2) {
            addCriterion("JQS_SHOWNUM between", value1, value2, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andJqsShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("JQS_SHOWNUM not between", value1, value2, "jqsShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumIsNull() {
            addCriterion("BQC_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andBqcShownumIsNotNull() {
            addCriterion("BQC_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andBqcShownumEqualTo(Integer value) {
            addCriterion("BQC_SHOWNUM =", value, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumNotEqualTo(Integer value) {
            addCriterion("BQC_SHOWNUM <>", value, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumGreaterThan(Integer value) {
            addCriterion("BQC_SHOWNUM >", value, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("BQC_SHOWNUM >=", value, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumLessThan(Integer value) {
            addCriterion("BQC_SHOWNUM <", value, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumLessThanOrEqualTo(Integer value) {
            addCriterion("BQC_SHOWNUM <=", value, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumIn(List<Integer> values) {
            addCriterion("BQC_SHOWNUM in", values, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumNotIn(List<Integer> values) {
            addCriterion("BQC_SHOWNUM not in", values, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumBetween(Integer value1, Integer value2) {
            addCriterion("BQC_SHOWNUM between", value1, value2, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andBqcShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("BQC_SHOWNUM not between", value1, value2, "bqcShownum");
            return (Criteria) this;
        }

        public Criteria andHasDelayIsNull() {
            addCriterion("has_Delay is null");
            return (Criteria) this;
        }

        public Criteria andHasDelayIsNotNull() {
            addCriterion("has_Delay is not null");
            return (Criteria) this;
        }

        public Criteria andHasDelayEqualTo(Integer value) {
            addCriterion("has_Delay =", value, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayNotEqualTo(Integer value) {
            addCriterion("has_Delay <>", value, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayGreaterThan(Integer value) {
            addCriterion("has_Delay >", value, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_Delay >=", value, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayLessThan(Integer value) {
            addCriterion("has_Delay <", value, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayLessThanOrEqualTo(Integer value) {
            addCriterion("has_Delay <=", value, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayIn(List<Integer> values) {
            addCriterion("has_Delay in", values, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayNotIn(List<Integer> values) {
            addCriterion("has_Delay not in", values, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayBetween(Integer value1, Integer value2) {
            addCriterion("has_Delay between", value1, value2, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andHasDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("has_Delay not between", value1, value2, "hasDelay");
            return (Criteria) this;
        }

        public Criteria andWorldsceneIsNull() {
            addCriterion("WORLDSCENE is null");
            return (Criteria) this;
        }

        public Criteria andWorldsceneIsNotNull() {
            addCriterion("WORLDSCENE is not null");
            return (Criteria) this;
        }

        public Criteria andWorldsceneEqualTo(Integer value) {
            addCriterion("WORLDSCENE =", value, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneNotEqualTo(Integer value) {
            addCriterion("WORLDSCENE <>", value, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneGreaterThan(Integer value) {
            addCriterion("WORLDSCENE >", value, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORLDSCENE >=", value, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneLessThan(Integer value) {
            addCriterion("WORLDSCENE <", value, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneLessThanOrEqualTo(Integer value) {
            addCriterion("WORLDSCENE <=", value, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneIn(List<Integer> values) {
            addCriterion("WORLDSCENE in", values, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneNotIn(List<Integer> values) {
            addCriterion("WORLDSCENE not in", values, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneBetween(Integer value1, Integer value2) {
            addCriterion("WORLDSCENE between", value1, value2, "worldscene");
            return (Criteria) this;
        }

        public Criteria andWorldsceneNotBetween(Integer value1, Integer value2) {
            addCriterion("WORLDSCENE not between", value1, value2, "worldscene");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}