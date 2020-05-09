package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryFootballRqspfaward2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryFootballRqspfaward2Example() {
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

        public Criteria andHomewinawardIsNull() {
            addCriterion("homeWinAward is null");
            return (Criteria) this;
        }

        public Criteria andHomewinawardIsNotNull() {
            addCriterion("homeWinAward is not null");
            return (Criteria) this;
        }

        public Criteria andHomewinawardEqualTo(Double value) {
            addCriterion("homeWinAward =", value, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardNotEqualTo(Double value) {
            addCriterion("homeWinAward <>", value, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardGreaterThan(Double value) {
            addCriterion("homeWinAward >", value, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardGreaterThanOrEqualTo(Double value) {
            addCriterion("homeWinAward >=", value, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardLessThan(Double value) {
            addCriterion("homeWinAward <", value, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardLessThanOrEqualTo(Double value) {
            addCriterion("homeWinAward <=", value, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardIn(List<Double> values) {
            addCriterion("homeWinAward in", values, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardNotIn(List<Double> values) {
            addCriterion("homeWinAward not in", values, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardBetween(Double value1, Double value2) {
            addCriterion("homeWinAward between", value1, value2, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andHomewinawardNotBetween(Double value1, Double value2) {
            addCriterion("homeWinAward not between", value1, value2, "homewinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardIsNull() {
            addCriterion("guestWinAward is null");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardIsNotNull() {
            addCriterion("guestWinAward is not null");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardEqualTo(Double value) {
            addCriterion("guestWinAward =", value, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardNotEqualTo(Double value) {
            addCriterion("guestWinAward <>", value, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardGreaterThan(Double value) {
            addCriterion("guestWinAward >", value, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardGreaterThanOrEqualTo(Double value) {
            addCriterion("guestWinAward >=", value, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardLessThan(Double value) {
            addCriterion("guestWinAward <", value, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardLessThanOrEqualTo(Double value) {
            addCriterion("guestWinAward <=", value, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardIn(List<Double> values) {
            addCriterion("guestWinAward in", values, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardNotIn(List<Double> values) {
            addCriterion("guestWinAward not in", values, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardBetween(Double value1, Double value2) {
            addCriterion("guestWinAward between", value1, value2, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andGuestwinawardNotBetween(Double value1, Double value2) {
            addCriterion("guestWinAward not between", value1, value2, "guestwinaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardIsNull() {
            addCriterion("drawAward is null");
            return (Criteria) this;
        }

        public Criteria andDrawawardIsNotNull() {
            addCriterion("drawAward is not null");
            return (Criteria) this;
        }

        public Criteria andDrawawardEqualTo(Double value) {
            addCriterion("drawAward =", value, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardNotEqualTo(Double value) {
            addCriterion("drawAward <>", value, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardGreaterThan(Double value) {
            addCriterion("drawAward >", value, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardGreaterThanOrEqualTo(Double value) {
            addCriterion("drawAward >=", value, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardLessThan(Double value) {
            addCriterion("drawAward <", value, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardLessThanOrEqualTo(Double value) {
            addCriterion("drawAward <=", value, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardIn(List<Double> values) {
            addCriterion("drawAward in", values, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardNotIn(List<Double> values) {
            addCriterion("drawAward not in", values, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardBetween(Double value1, Double value2) {
            addCriterion("drawAward between", value1, value2, "drawaward");
            return (Criteria) this;
        }

        public Criteria andDrawawardNotBetween(Double value1, Double value2) {
            addCriterion("drawAward not between", value1, value2, "drawaward");
            return (Criteria) this;
        }

        public Criteria andHomechangeIsNull() {
            addCriterion("homeChange is null");
            return (Criteria) this;
        }

        public Criteria andHomechangeIsNotNull() {
            addCriterion("homeChange is not null");
            return (Criteria) this;
        }

        public Criteria andHomechangeEqualTo(Integer value) {
            addCriterion("homeChange =", value, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeNotEqualTo(Integer value) {
            addCriterion("homeChange <>", value, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeGreaterThan(Integer value) {
            addCriterion("homeChange >", value, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("homeChange >=", value, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeLessThan(Integer value) {
            addCriterion("homeChange <", value, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeLessThanOrEqualTo(Integer value) {
            addCriterion("homeChange <=", value, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeIn(List<Integer> values) {
            addCriterion("homeChange in", values, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeNotIn(List<Integer> values) {
            addCriterion("homeChange not in", values, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeBetween(Integer value1, Integer value2) {
            addCriterion("homeChange between", value1, value2, "homechange");
            return (Criteria) this;
        }

        public Criteria andHomechangeNotBetween(Integer value1, Integer value2) {
            addCriterion("homeChange not between", value1, value2, "homechange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeIsNull() {
            addCriterion("drawChange is null");
            return (Criteria) this;
        }

        public Criteria andDrawchangeIsNotNull() {
            addCriterion("drawChange is not null");
            return (Criteria) this;
        }

        public Criteria andDrawchangeEqualTo(Integer value) {
            addCriterion("drawChange =", value, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeNotEqualTo(Integer value) {
            addCriterion("drawChange <>", value, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeGreaterThan(Integer value) {
            addCriterion("drawChange >", value, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("drawChange >=", value, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeLessThan(Integer value) {
            addCriterion("drawChange <", value, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeLessThanOrEqualTo(Integer value) {
            addCriterion("drawChange <=", value, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeIn(List<Integer> values) {
            addCriterion("drawChange in", values, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeNotIn(List<Integer> values) {
            addCriterion("drawChange not in", values, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeBetween(Integer value1, Integer value2) {
            addCriterion("drawChange between", value1, value2, "drawchange");
            return (Criteria) this;
        }

        public Criteria andDrawchangeNotBetween(Integer value1, Integer value2) {
            addCriterion("drawChange not between", value1, value2, "drawchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeIsNull() {
            addCriterion("guestChange is null");
            return (Criteria) this;
        }

        public Criteria andGuestchangeIsNotNull() {
            addCriterion("guestChange is not null");
            return (Criteria) this;
        }

        public Criteria andGuestchangeEqualTo(Integer value) {
            addCriterion("guestChange =", value, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeNotEqualTo(Integer value) {
            addCriterion("guestChange <>", value, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeGreaterThan(Integer value) {
            addCriterion("guestChange >", value, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("guestChange >=", value, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeLessThan(Integer value) {
            addCriterion("guestChange <", value, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeLessThanOrEqualTo(Integer value) {
            addCriterion("guestChange <=", value, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeIn(List<Integer> values) {
            addCriterion("guestChange in", values, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeNotIn(List<Integer> values) {
            addCriterion("guestChange not in", values, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeBetween(Integer value1, Integer value2) {
            addCriterion("guestChange between", value1, value2, "guestchange");
            return (Criteria) this;
        }

        public Criteria andGuestchangeNotBetween(Integer value1, Integer value2) {
            addCriterion("guestChange not between", value1, value2, "guestchange");
            return (Criteria) this;
        }

        public Criteria andMatchidIsNull() {
            addCriterion("matchId is null");
            return (Criteria) this;
        }

        public Criteria andMatchidIsNotNull() {
            addCriterion("matchId is not null");
            return (Criteria) this;
        }

        public Criteria andMatchidEqualTo(Integer value) {
            addCriterion("matchId =", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotEqualTo(Integer value) {
            addCriterion("matchId <>", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThan(Integer value) {
            addCriterion("matchId >", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchId >=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThan(Integer value) {
            addCriterion("matchId <", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThanOrEqualTo(Integer value) {
            addCriterion("matchId <=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidIn(List<Integer> values) {
            addCriterion("matchId in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotIn(List<Integer> values) {
            addCriterion("matchId not in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidBetween(Integer value1, Integer value2) {
            addCriterion("matchId between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotBetween(Integer value1, Integer value2) {
            addCriterion("matchId not between", value1, value2, "matchid");
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

        public Criteria andPassmodeIsNull() {
            addCriterion("passMode is null");
            return (Criteria) this;
        }

        public Criteria andPassmodeIsNotNull() {
            addCriterion("passMode is not null");
            return (Criteria) this;
        }

        public Criteria andPassmodeEqualTo(Integer value) {
            addCriterion("passMode =", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeNotEqualTo(Integer value) {
            addCriterion("passMode <>", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeGreaterThan(Integer value) {
            addCriterion("passMode >", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("passMode >=", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeLessThan(Integer value) {
            addCriterion("passMode <", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeLessThanOrEqualTo(Integer value) {
            addCriterion("passMode <=", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeIn(List<Integer> values) {
            addCriterion("passMode in", values, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeNotIn(List<Integer> values) {
            addCriterion("passMode not in", values, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeBetween(Integer value1, Integer value2) {
            addCriterion("passMode between", value1, value2, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeNotBetween(Integer value1, Integer value2) {
            addCriterion("passMode not between", value1, value2, "passmode");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNull() {
            addCriterion("lastUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNotNull() {
            addCriterion("lastUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeEqualTo(Date value) {
            addCriterion("lastUpdateTime =", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotEqualTo(Date value) {
            addCriterion("lastUpdateTime <>", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThan(Date value) {
            addCriterion("lastUpdateTime >", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastUpdateTime >=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThan(Date value) {
            addCriterion("lastUpdateTime <", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("lastUpdateTime <=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIn(List<Date> values) {
            addCriterion("lastUpdateTime in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotIn(List<Date> values) {
            addCriterion("lastUpdateTime not in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("lastUpdateTime between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("lastUpdateTime not between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andHomeRateIsNull() {
            addCriterion("HOME_RATE is null");
            return (Criteria) this;
        }

        public Criteria andHomeRateIsNotNull() {
            addCriterion("HOME_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andHomeRateEqualTo(Double value) {
            addCriterion("HOME_RATE =", value, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateNotEqualTo(Double value) {
            addCriterion("HOME_RATE <>", value, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateGreaterThan(Double value) {
            addCriterion("HOME_RATE >", value, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateGreaterThanOrEqualTo(Double value) {
            addCriterion("HOME_RATE >=", value, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateLessThan(Double value) {
            addCriterion("HOME_RATE <", value, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateLessThanOrEqualTo(Double value) {
            addCriterion("HOME_RATE <=", value, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateIn(List<Double> values) {
            addCriterion("HOME_RATE in", values, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateNotIn(List<Double> values) {
            addCriterion("HOME_RATE not in", values, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateBetween(Double value1, Double value2) {
            addCriterion("HOME_RATE between", value1, value2, "homeRate");
            return (Criteria) this;
        }

        public Criteria andHomeRateNotBetween(Double value1, Double value2) {
            addCriterion("HOME_RATE not between", value1, value2, "homeRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateIsNull() {
            addCriterion("DRAW_RATE is null");
            return (Criteria) this;
        }

        public Criteria andDrawRateIsNotNull() {
            addCriterion("DRAW_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andDrawRateEqualTo(Double value) {
            addCriterion("DRAW_RATE =", value, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateNotEqualTo(Double value) {
            addCriterion("DRAW_RATE <>", value, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateGreaterThan(Double value) {
            addCriterion("DRAW_RATE >", value, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateGreaterThanOrEqualTo(Double value) {
            addCriterion("DRAW_RATE >=", value, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateLessThan(Double value) {
            addCriterion("DRAW_RATE <", value, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateLessThanOrEqualTo(Double value) {
            addCriterion("DRAW_RATE <=", value, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateIn(List<Double> values) {
            addCriterion("DRAW_RATE in", values, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateNotIn(List<Double> values) {
            addCriterion("DRAW_RATE not in", values, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateBetween(Double value1, Double value2) {
            addCriterion("DRAW_RATE between", value1, value2, "drawRate");
            return (Criteria) this;
        }

        public Criteria andDrawRateNotBetween(Double value1, Double value2) {
            addCriterion("DRAW_RATE not between", value1, value2, "drawRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateIsNull() {
            addCriterion("GUEST_RATE is null");
            return (Criteria) this;
        }

        public Criteria andGuestRateIsNotNull() {
            addCriterion("GUEST_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andGuestRateEqualTo(Double value) {
            addCriterion("GUEST_RATE =", value, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateNotEqualTo(Double value) {
            addCriterion("GUEST_RATE <>", value, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateGreaterThan(Double value) {
            addCriterion("GUEST_RATE >", value, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateGreaterThanOrEqualTo(Double value) {
            addCriterion("GUEST_RATE >=", value, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateLessThan(Double value) {
            addCriterion("GUEST_RATE <", value, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateLessThanOrEqualTo(Double value) {
            addCriterion("GUEST_RATE <=", value, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateIn(List<Double> values) {
            addCriterion("GUEST_RATE in", values, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateNotIn(List<Double> values) {
            addCriterion("GUEST_RATE not in", values, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateBetween(Double value1, Double value2) {
            addCriterion("GUEST_RATE between", value1, value2, "guestRate");
            return (Criteria) this;
        }

        public Criteria andGuestRateNotBetween(Double value1, Double value2) {
            addCriterion("GUEST_RATE not between", value1, value2, "guestRate");
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