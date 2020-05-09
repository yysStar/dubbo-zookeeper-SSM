package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryBasketMatch2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryBasketMatch2Query() {
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

        public Criteria andHomenameIsNull() {
            addCriterion("homeName is null");
            return (Criteria) this;
        }

        public Criteria andHomenameIsNotNull() {
            addCriterion("homeName is not null");
            return (Criteria) this;
        }

        public Criteria andHomenameEqualTo(String value) {
            addCriterion("homeName =", value, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameNotEqualTo(String value) {
            addCriterion("homeName <>", value, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameGreaterThan(String value) {
            addCriterion("homeName >", value, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameGreaterThanOrEqualTo(String value) {
            addCriterion("homeName >=", value, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameLessThan(String value) {
            addCriterion("homeName <", value, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameLessThanOrEqualTo(String value) {
            addCriterion("homeName <=", value, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameLike(String value) {
            addCriterion("homeName like", value, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameNotLike(String value) {
            addCriterion("homeName not like", value, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameIn(List<String> values) {
            addCriterion("homeName in", values, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameNotIn(List<String> values) {
            addCriterion("homeName not in", values, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameBetween(String value1, String value2) {
            addCriterion("homeName between", value1, value2, "homename");
            return (Criteria) this;
        }

        public Criteria andHomenameNotBetween(String value1, String value2) {
            addCriterion("homeName not between", value1, value2, "homename");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameIsNull() {
            addCriterion("HOME_SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameIsNotNull() {
            addCriterion("HOME_SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameEqualTo(String value) {
            addCriterion("HOME_SHORT_NAME =", value, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameNotEqualTo(String value) {
            addCriterion("HOME_SHORT_NAME <>", value, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameGreaterThan(String value) {
            addCriterion("HOME_SHORT_NAME >", value, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("HOME_SHORT_NAME >=", value, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameLessThan(String value) {
            addCriterion("HOME_SHORT_NAME <", value, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameLessThanOrEqualTo(String value) {
            addCriterion("HOME_SHORT_NAME <=", value, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameLike(String value) {
            addCriterion("HOME_SHORT_NAME like", value, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameNotLike(String value) {
            addCriterion("HOME_SHORT_NAME not like", value, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameIn(List<String> values) {
            addCriterion("HOME_SHORT_NAME in", values, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameNotIn(List<String> values) {
            addCriterion("HOME_SHORT_NAME not in", values, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameBetween(String value1, String value2) {
            addCriterion("HOME_SHORT_NAME between", value1, value2, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andHomeShortNameNotBetween(String value1, String value2) {
            addCriterion("HOME_SHORT_NAME not between", value1, value2, "homeShortName");
            return (Criteria) this;
        }

        public Criteria andGuestnameIsNull() {
            addCriterion("guestName is null");
            return (Criteria) this;
        }

        public Criteria andGuestnameIsNotNull() {
            addCriterion("guestName is not null");
            return (Criteria) this;
        }

        public Criteria andGuestnameEqualTo(String value) {
            addCriterion("guestName =", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameNotEqualTo(String value) {
            addCriterion("guestName <>", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameGreaterThan(String value) {
            addCriterion("guestName >", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameGreaterThanOrEqualTo(String value) {
            addCriterion("guestName >=", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameLessThan(String value) {
            addCriterion("guestName <", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameLessThanOrEqualTo(String value) {
            addCriterion("guestName <=", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameLike(String value) {
            addCriterion("guestName like", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameNotLike(String value) {
            addCriterion("guestName not like", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameIn(List<String> values) {
            addCriterion("guestName in", values, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameNotIn(List<String> values) {
            addCriterion("guestName not in", values, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameBetween(String value1, String value2) {
            addCriterion("guestName between", value1, value2, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameNotBetween(String value1, String value2) {
            addCriterion("guestName not between", value1, value2, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameIsNull() {
            addCriterion("GUEST_SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameIsNotNull() {
            addCriterion("GUEST_SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameEqualTo(String value) {
            addCriterion("GUEST_SHORT_NAME =", value, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameNotEqualTo(String value) {
            addCriterion("GUEST_SHORT_NAME <>", value, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameGreaterThan(String value) {
            addCriterion("GUEST_SHORT_NAME >", value, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("GUEST_SHORT_NAME >=", value, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameLessThan(String value) {
            addCriterion("GUEST_SHORT_NAME <", value, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameLessThanOrEqualTo(String value) {
            addCriterion("GUEST_SHORT_NAME <=", value, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameLike(String value) {
            addCriterion("GUEST_SHORT_NAME like", value, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameNotLike(String value) {
            addCriterion("GUEST_SHORT_NAME not like", value, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameIn(List<String> values) {
            addCriterion("GUEST_SHORT_NAME in", values, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameNotIn(List<String> values) {
            addCriterion("GUEST_SHORT_NAME not in", values, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameBetween(String value1, String value2) {
            addCriterion("GUEST_SHORT_NAME between", value1, value2, "guestShortName");
            return (Criteria) this;
        }

        public Criteria andGuestShortNameNotBetween(String value1, String value2) {
            addCriterion("GUEST_SHORT_NAME not between", value1, value2, "guestShortName");
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

        public Criteria andFristsectionIsNull() {
            addCriterion("fristSection is null");
            return (Criteria) this;
        }

        public Criteria andFristsectionIsNotNull() {
            addCriterion("fristSection is not null");
            return (Criteria) this;
        }

        public Criteria andFristsectionEqualTo(String value) {
            addCriterion("fristSection =", value, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionNotEqualTo(String value) {
            addCriterion("fristSection <>", value, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionGreaterThan(String value) {
            addCriterion("fristSection >", value, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionGreaterThanOrEqualTo(String value) {
            addCriterion("fristSection >=", value, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionLessThan(String value) {
            addCriterion("fristSection <", value, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionLessThanOrEqualTo(String value) {
            addCriterion("fristSection <=", value, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionLike(String value) {
            addCriterion("fristSection like", value, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionNotLike(String value) {
            addCriterion("fristSection not like", value, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionIn(List<String> values) {
            addCriterion("fristSection in", values, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionNotIn(List<String> values) {
            addCriterion("fristSection not in", values, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionBetween(String value1, String value2) {
            addCriterion("fristSection between", value1, value2, "fristsection");
            return (Criteria) this;
        }

        public Criteria andFristsectionNotBetween(String value1, String value2) {
            addCriterion("fristSection not between", value1, value2, "fristsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionIsNull() {
            addCriterion("SecondSection is null");
            return (Criteria) this;
        }

        public Criteria andSecondsectionIsNotNull() {
            addCriterion("SecondSection is not null");
            return (Criteria) this;
        }

        public Criteria andSecondsectionEqualTo(String value) {
            addCriterion("SecondSection =", value, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionNotEqualTo(String value) {
            addCriterion("SecondSection <>", value, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionGreaterThan(String value) {
            addCriterion("SecondSection >", value, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionGreaterThanOrEqualTo(String value) {
            addCriterion("SecondSection >=", value, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionLessThan(String value) {
            addCriterion("SecondSection <", value, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionLessThanOrEqualTo(String value) {
            addCriterion("SecondSection <=", value, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionLike(String value) {
            addCriterion("SecondSection like", value, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionNotLike(String value) {
            addCriterion("SecondSection not like", value, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionIn(List<String> values) {
            addCriterion("SecondSection in", values, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionNotIn(List<String> values) {
            addCriterion("SecondSection not in", values, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionBetween(String value1, String value2) {
            addCriterion("SecondSection between", value1, value2, "secondsection");
            return (Criteria) this;
        }

        public Criteria andSecondsectionNotBetween(String value1, String value2) {
            addCriterion("SecondSection not between", value1, value2, "secondsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionIsNull() {
            addCriterion("thirdSection is null");
            return (Criteria) this;
        }

        public Criteria andThirdsectionIsNotNull() {
            addCriterion("thirdSection is not null");
            return (Criteria) this;
        }

        public Criteria andThirdsectionEqualTo(String value) {
            addCriterion("thirdSection =", value, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionNotEqualTo(String value) {
            addCriterion("thirdSection <>", value, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionGreaterThan(String value) {
            addCriterion("thirdSection >", value, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionGreaterThanOrEqualTo(String value) {
            addCriterion("thirdSection >=", value, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionLessThan(String value) {
            addCriterion("thirdSection <", value, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionLessThanOrEqualTo(String value) {
            addCriterion("thirdSection <=", value, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionLike(String value) {
            addCriterion("thirdSection like", value, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionNotLike(String value) {
            addCriterion("thirdSection not like", value, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionIn(List<String> values) {
            addCriterion("thirdSection in", values, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionNotIn(List<String> values) {
            addCriterion("thirdSection not in", values, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionBetween(String value1, String value2) {
            addCriterion("thirdSection between", value1, value2, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andThirdsectionNotBetween(String value1, String value2) {
            addCriterion("thirdSection not between", value1, value2, "thirdsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionIsNull() {
            addCriterion("fourthSection is null");
            return (Criteria) this;
        }

        public Criteria andFourthsectionIsNotNull() {
            addCriterion("fourthSection is not null");
            return (Criteria) this;
        }

        public Criteria andFourthsectionEqualTo(String value) {
            addCriterion("fourthSection =", value, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionNotEqualTo(String value) {
            addCriterion("fourthSection <>", value, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionGreaterThan(String value) {
            addCriterion("fourthSection >", value, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionGreaterThanOrEqualTo(String value) {
            addCriterion("fourthSection >=", value, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionLessThan(String value) {
            addCriterion("fourthSection <", value, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionLessThanOrEqualTo(String value) {
            addCriterion("fourthSection <=", value, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionLike(String value) {
            addCriterion("fourthSection like", value, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionNotLike(String value) {
            addCriterion("fourthSection not like", value, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionIn(List<String> values) {
            addCriterion("fourthSection in", values, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionNotIn(List<String> values) {
            addCriterion("fourthSection not in", values, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionBetween(String value1, String value2) {
            addCriterion("fourthSection between", value1, value2, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andFourthsectionNotBetween(String value1, String value2) {
            addCriterion("fourthSection not between", value1, value2, "fourthsection");
            return (Criteria) this;
        }

        public Criteria andResultofsfIsNull() {
            addCriterion("resultOfSF is null");
            return (Criteria) this;
        }

        public Criteria andResultofsfIsNotNull() {
            addCriterion("resultOfSF is not null");
            return (Criteria) this;
        }

        public Criteria andResultofsfEqualTo(Double value) {
            addCriterion("resultOfSF =", value, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfNotEqualTo(Double value) {
            addCriterion("resultOfSF <>", value, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfGreaterThan(Double value) {
            addCriterion("resultOfSF >", value, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfGreaterThanOrEqualTo(Double value) {
            addCriterion("resultOfSF >=", value, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfLessThan(Double value) {
            addCriterion("resultOfSF <", value, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfLessThanOrEqualTo(Double value) {
            addCriterion("resultOfSF <=", value, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfIn(List<Double> values) {
            addCriterion("resultOfSF in", values, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfNotIn(List<Double> values) {
            addCriterion("resultOfSF not in", values, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfBetween(Double value1, Double value2) {
            addCriterion("resultOfSF between", value1, value2, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfNotBetween(Double value1, Double value2) {
            addCriterion("resultOfSF not between", value1, value2, "resultofsf");
            return (Criteria) this;
        }

        public Criteria andResultofsfcIsNull() {
            addCriterion("resultOfSFC is null");
            return (Criteria) this;
        }

        public Criteria andResultofsfcIsNotNull() {
            addCriterion("resultOfSFC is not null");
            return (Criteria) this;
        }

        public Criteria andResultofsfcEqualTo(Double value) {
            addCriterion("resultOfSFC =", value, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcNotEqualTo(Double value) {
            addCriterion("resultOfSFC <>", value, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcGreaterThan(Double value) {
            addCriterion("resultOfSFC >", value, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcGreaterThanOrEqualTo(Double value) {
            addCriterion("resultOfSFC >=", value, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcLessThan(Double value) {
            addCriterion("resultOfSFC <", value, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcLessThanOrEqualTo(Double value) {
            addCriterion("resultOfSFC <=", value, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcIn(List<Double> values) {
            addCriterion("resultOfSFC in", values, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcNotIn(List<Double> values) {
            addCriterion("resultOfSFC not in", values, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcBetween(Double value1, Double value2) {
            addCriterion("resultOfSFC between", value1, value2, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofsfcNotBetween(Double value1, Double value2) {
            addCriterion("resultOfSFC not between", value1, value2, "resultofsfc");
            return (Criteria) this;
        }

        public Criteria andResultofdxfIsNull() {
            addCriterion("resultOfDXF is null");
            return (Criteria) this;
        }

        public Criteria andResultofdxfIsNotNull() {
            addCriterion("resultOfDXF is not null");
            return (Criteria) this;
        }

        public Criteria andResultofdxfEqualTo(Double value) {
            addCriterion("resultOfDXF =", value, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfNotEqualTo(Double value) {
            addCriterion("resultOfDXF <>", value, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfGreaterThan(Double value) {
            addCriterion("resultOfDXF >", value, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfGreaterThanOrEqualTo(Double value) {
            addCriterion("resultOfDXF >=", value, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfLessThan(Double value) {
            addCriterion("resultOfDXF <", value, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfLessThanOrEqualTo(Double value) {
            addCriterion("resultOfDXF <=", value, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfIn(List<Double> values) {
            addCriterion("resultOfDXF in", values, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfNotIn(List<Double> values) {
            addCriterion("resultOfDXF not in", values, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfBetween(Double value1, Double value2) {
            addCriterion("resultOfDXF between", value1, value2, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofdxfNotBetween(Double value1, Double value2) {
            addCriterion("resultOfDXF not between", value1, value2, "resultofdxf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfIsNull() {
            addCriterion("resultOfRFSF is null");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfIsNotNull() {
            addCriterion("resultOfRFSF is not null");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfEqualTo(Double value) {
            addCriterion("resultOfRFSF =", value, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfNotEqualTo(Double value) {
            addCriterion("resultOfRFSF <>", value, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfGreaterThan(Double value) {
            addCriterion("resultOfRFSF >", value, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfGreaterThanOrEqualTo(Double value) {
            addCriterion("resultOfRFSF >=", value, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfLessThan(Double value) {
            addCriterion("resultOfRFSF <", value, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfLessThanOrEqualTo(Double value) {
            addCriterion("resultOfRFSF <=", value, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfIn(List<Double> values) {
            addCriterion("resultOfRFSF in", values, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfNotIn(List<Double> values) {
            addCriterion("resultOfRFSF not in", values, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfBetween(Double value1, Double value2) {
            addCriterion("resultOfRFSF between", value1, value2, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andResultofrfsfNotBetween(Double value1, Double value2) {
            addCriterion("resultOfRFSF not between", value1, value2, "resultofrfsf");
            return (Criteria) this;
        }

        public Criteria andHandicapIsNull() {
            addCriterion("handicap is null");
            return (Criteria) this;
        }

        public Criteria andHandicapIsNotNull() {
            addCriterion("handicap is not null");
            return (Criteria) this;
        }

        public Criteria andHandicapEqualTo(Double value) {
            addCriterion("handicap =", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotEqualTo(Double value) {
            addCriterion("handicap <>", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapGreaterThan(Double value) {
            addCriterion("handicap >", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapGreaterThanOrEqualTo(Double value) {
            addCriterion("handicap >=", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLessThan(Double value) {
            addCriterion("handicap <", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLessThanOrEqualTo(Double value) {
            addCriterion("handicap <=", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapIn(List<Double> values) {
            addCriterion("handicap in", values, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotIn(List<Double> values) {
            addCriterion("handicap not in", values, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapBetween(Double value1, Double value2) {
            addCriterion("handicap between", value1, value2, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotBetween(Double value1, Double value2) {
            addCriterion("handicap not between", value1, value2, "handicap");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallIsNull() {
            addCriterion("baseBigOrSmall is null");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallIsNotNull() {
            addCriterion("baseBigOrSmall is not null");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallEqualTo(Double value) {
            addCriterion("baseBigOrSmall =", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallNotEqualTo(Double value) {
            addCriterion("baseBigOrSmall <>", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallGreaterThan(Double value) {
            addCriterion("baseBigOrSmall >", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallGreaterThanOrEqualTo(Double value) {
            addCriterion("baseBigOrSmall >=", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallLessThan(Double value) {
            addCriterion("baseBigOrSmall <", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallLessThanOrEqualTo(Double value) {
            addCriterion("baseBigOrSmall <=", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallIn(List<Double> values) {
            addCriterion("baseBigOrSmall in", values, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallNotIn(List<Double> values) {
            addCriterion("baseBigOrSmall not in", values, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallBetween(Double value1, Double value2) {
            addCriterion("baseBigOrSmall between", value1, value2, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallNotBetween(Double value1, Double value2) {
            addCriterion("baseBigOrSmall not between", value1, value2, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapIsNull() {
            addCriterion("single_handicap is null");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapIsNotNull() {
            addCriterion("single_handicap is not null");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapEqualTo(Double value) {
            addCriterion("single_handicap =", value, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapNotEqualTo(Double value) {
            addCriterion("single_handicap <>", value, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapGreaterThan(Double value) {
            addCriterion("single_handicap >", value, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapGreaterThanOrEqualTo(Double value) {
            addCriterion("single_handicap >=", value, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapLessThan(Double value) {
            addCriterion("single_handicap <", value, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapLessThanOrEqualTo(Double value) {
            addCriterion("single_handicap <=", value, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapIn(List<Double> values) {
            addCriterion("single_handicap in", values, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapNotIn(List<Double> values) {
            addCriterion("single_handicap not in", values, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapBetween(Double value1, Double value2) {
            addCriterion("single_handicap between", value1, value2, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleHandicapNotBetween(Double value1, Double value2) {
            addCriterion("single_handicap not between", value1, value2, "singleHandicap");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallIsNull() {
            addCriterion("single_baseBigOrSmall is null");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallIsNotNull() {
            addCriterion("single_baseBigOrSmall is not null");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallEqualTo(Double value) {
            addCriterion("single_baseBigOrSmall =", value, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallNotEqualTo(Double value) {
            addCriterion("single_baseBigOrSmall <>", value, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallGreaterThan(Double value) {
            addCriterion("single_baseBigOrSmall >", value, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallGreaterThanOrEqualTo(Double value) {
            addCriterion("single_baseBigOrSmall >=", value, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallLessThan(Double value) {
            addCriterion("single_baseBigOrSmall <", value, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallLessThanOrEqualTo(Double value) {
            addCriterion("single_baseBigOrSmall <=", value, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallIn(List<Double> values) {
            addCriterion("single_baseBigOrSmall in", values, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallNotIn(List<Double> values) {
            addCriterion("single_baseBigOrSmall not in", values, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallBetween(Double value1, Double value2) {
            addCriterion("single_baseBigOrSmall between", value1, value2, "singleBasebigorsmall");
            return (Criteria) this;
        }

        public Criteria andSingleBasebigorsmallNotBetween(Double value1, Double value2) {
            addCriterion("single_baseBigOrSmall not between", value1, value2, "singleBasebigorsmall");
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

        public Criteria andOutidIsNull() {
            addCriterion("outId is null");
            return (Criteria) this;
        }

        public Criteria andOutidIsNotNull() {
            addCriterion("outId is not null");
            return (Criteria) this;
        }

        public Criteria andOutidEqualTo(String value) {
            addCriterion("outId =", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotEqualTo(String value) {
            addCriterion("outId <>", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidGreaterThan(String value) {
            addCriterion("outId >", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidGreaterThanOrEqualTo(String value) {
            addCriterion("outId >=", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLessThan(String value) {
            addCriterion("outId <", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLessThanOrEqualTo(String value) {
            addCriterion("outId <=", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLike(String value) {
            addCriterion("outId like", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotLike(String value) {
            addCriterion("outId not like", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidIn(List<String> values) {
            addCriterion("outId in", values, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotIn(List<String> values) {
            addCriterion("outId not in", values, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidBetween(String value1, String value2) {
            addCriterion("outId between", value1, value2, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotBetween(String value1, String value2) {
            addCriterion("outId not between", value1, value2, "outid");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneIsNull() {
            addCriterion("DXF_Q2_SCENE is null");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneIsNotNull() {
            addCriterion("DXF_Q2_SCENE is not null");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneEqualTo(Integer value) {
            addCriterion("DXF_Q2_SCENE =", value, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneNotEqualTo(Integer value) {
            addCriterion("DXF_Q2_SCENE <>", value, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneGreaterThan(Integer value) {
            addCriterion("DXF_Q2_SCENE >", value, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneGreaterThanOrEqualTo(Integer value) {
            addCriterion("DXF_Q2_SCENE >=", value, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneLessThan(Integer value) {
            addCriterion("DXF_Q2_SCENE <", value, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneLessThanOrEqualTo(Integer value) {
            addCriterion("DXF_Q2_SCENE <=", value, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneIn(List<Integer> values) {
            addCriterion("DXF_Q2_SCENE in", values, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneNotIn(List<Integer> values) {
            addCriterion("DXF_Q2_SCENE not in", values, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneBetween(Integer value1, Integer value2) {
            addCriterion("DXF_Q2_SCENE between", value1, value2, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andDxfQ2SceneNotBetween(Integer value1, Integer value2) {
            addCriterion("DXF_Q2_SCENE not between", value1, value2, "dxfQ2Scene");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIsNull() {
            addCriterion("ANALYSIS_ID is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIsNotNull() {
            addCriterion("ANALYSIS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdEqualTo(String value) {
            addCriterion("ANALYSIS_ID =", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotEqualTo(String value) {
            addCriterion("ANALYSIS_ID <>", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdGreaterThan(String value) {
            addCriterion("ANALYSIS_ID >", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdGreaterThanOrEqualTo(String value) {
            addCriterion("ANALYSIS_ID >=", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLessThan(String value) {
            addCriterion("ANALYSIS_ID <", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLessThanOrEqualTo(String value) {
            addCriterion("ANALYSIS_ID <=", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLike(String value) {
            addCriterion("ANALYSIS_ID like", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotLike(String value) {
            addCriterion("ANALYSIS_ID not like", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIn(List<String> values) {
            addCriterion("ANALYSIS_ID in", values, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotIn(List<String> values) {
            addCriterion("ANALYSIS_ID not in", values, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdBetween(String value1, String value2) {
            addCriterion("ANALYSIS_ID between", value1, value2, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotBetween(String value1, String value2) {
            addCriterion("ANALYSIS_ID not between", value1, value2, "analysisId");
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

        public Criteria andSfShownumIsNull() {
            addCriterion("SF_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andSfShownumIsNotNull() {
            addCriterion("SF_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andSfShownumEqualTo(Integer value) {
            addCriterion("SF_SHOWNUM =", value, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumNotEqualTo(Integer value) {
            addCriterion("SF_SHOWNUM <>", value, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumGreaterThan(Integer value) {
            addCriterion("SF_SHOWNUM >", value, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SF_SHOWNUM >=", value, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumLessThan(Integer value) {
            addCriterion("SF_SHOWNUM <", value, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumLessThanOrEqualTo(Integer value) {
            addCriterion("SF_SHOWNUM <=", value, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumIn(List<Integer> values) {
            addCriterion("SF_SHOWNUM in", values, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumNotIn(List<Integer> values) {
            addCriterion("SF_SHOWNUM not in", values, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumBetween(Integer value1, Integer value2) {
            addCriterion("SF_SHOWNUM between", value1, value2, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andSfShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("SF_SHOWNUM not between", value1, value2, "sfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumIsNull() {
            addCriterion("RFSF_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumIsNotNull() {
            addCriterion("RFSF_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumEqualTo(Integer value) {
            addCriterion("RFSF_SHOWNUM =", value, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumNotEqualTo(Integer value) {
            addCriterion("RFSF_SHOWNUM <>", value, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumGreaterThan(Integer value) {
            addCriterion("RFSF_SHOWNUM >", value, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("RFSF_SHOWNUM >=", value, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumLessThan(Integer value) {
            addCriterion("RFSF_SHOWNUM <", value, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumLessThanOrEqualTo(Integer value) {
            addCriterion("RFSF_SHOWNUM <=", value, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumIn(List<Integer> values) {
            addCriterion("RFSF_SHOWNUM in", values, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumNotIn(List<Integer> values) {
            addCriterion("RFSF_SHOWNUM not in", values, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumBetween(Integer value1, Integer value2) {
            addCriterion("RFSF_SHOWNUM between", value1, value2, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andRfsfShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("RFSF_SHOWNUM not between", value1, value2, "rfsfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumIsNull() {
            addCriterion("DXF_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andDxfShownumIsNotNull() {
            addCriterion("DXF_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andDxfShownumEqualTo(Integer value) {
            addCriterion("DXF_SHOWNUM =", value, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumNotEqualTo(Integer value) {
            addCriterion("DXF_SHOWNUM <>", value, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumGreaterThan(Integer value) {
            addCriterion("DXF_SHOWNUM >", value, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("DXF_SHOWNUM >=", value, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumLessThan(Integer value) {
            addCriterion("DXF_SHOWNUM <", value, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumLessThanOrEqualTo(Integer value) {
            addCriterion("DXF_SHOWNUM <=", value, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumIn(List<Integer> values) {
            addCriterion("DXF_SHOWNUM in", values, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumNotIn(List<Integer> values) {
            addCriterion("DXF_SHOWNUM not in", values, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumBetween(Integer value1, Integer value2) {
            addCriterion("DXF_SHOWNUM between", value1, value2, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andDxfShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("DXF_SHOWNUM not between", value1, value2, "dxfShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumIsNull() {
            addCriterion("SFC_SHOWNUM is null");
            return (Criteria) this;
        }

        public Criteria andSfcShownumIsNotNull() {
            addCriterion("SFC_SHOWNUM is not null");
            return (Criteria) this;
        }

        public Criteria andSfcShownumEqualTo(Integer value) {
            addCriterion("SFC_SHOWNUM =", value, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumNotEqualTo(Integer value) {
            addCriterion("SFC_SHOWNUM <>", value, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumGreaterThan(Integer value) {
            addCriterion("SFC_SHOWNUM >", value, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFC_SHOWNUM >=", value, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumLessThan(Integer value) {
            addCriterion("SFC_SHOWNUM <", value, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumLessThanOrEqualTo(Integer value) {
            addCriterion("SFC_SHOWNUM <=", value, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumIn(List<Integer> values) {
            addCriterion("SFC_SHOWNUM in", values, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumNotIn(List<Integer> values) {
            addCriterion("SFC_SHOWNUM not in", values, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumBetween(Integer value1, Integer value2) {
            addCriterion("SFC_SHOWNUM between", value1, value2, "sfcShownum");
            return (Criteria) this;
        }

        public Criteria andSfcShownumNotBetween(Integer value1, Integer value2) {
            addCriterion("SFC_SHOWNUM not between", value1, value2, "sfcShownum");
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