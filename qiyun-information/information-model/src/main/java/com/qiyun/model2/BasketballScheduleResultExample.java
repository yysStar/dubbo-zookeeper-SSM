package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class BasketballScheduleResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasketballScheduleResultExample() {
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

        public Criteria andLeagueIdIsNull() {
            addCriterion("league_id is null");
            return (Criteria) this;
        }

        public Criteria andLeagueIdIsNotNull() {
            addCriterion("league_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeagueIdEqualTo(String value) {
            addCriterion("league_id =", value, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdNotEqualTo(String value) {
            addCriterion("league_id <>", value, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdGreaterThan(String value) {
            addCriterion("league_id >", value, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdGreaterThanOrEqualTo(String value) {
            addCriterion("league_id >=", value, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdLessThan(String value) {
            addCriterion("league_id <", value, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdLessThanOrEqualTo(String value) {
            addCriterion("league_id <=", value, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdLike(String value) {
            addCriterion("league_id like", value, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdNotLike(String value) {
            addCriterion("league_id not like", value, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdIn(List<String> values) {
            addCriterion("league_id in", values, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdNotIn(List<String> values) {
            addCriterion("league_id not in", values, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdBetween(String value1, String value2) {
            addCriterion("league_id between", value1, value2, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueIdNotBetween(String value1, String value2) {
            addCriterion("league_id not between", value1, value2, "leagueId");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeIsNull() {
            addCriterion("league_type is null");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeIsNotNull() {
            addCriterion("league_type is not null");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeEqualTo(String value) {
            addCriterion("league_type =", value, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeNotEqualTo(String value) {
            addCriterion("league_type <>", value, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeGreaterThan(String value) {
            addCriterion("league_type >", value, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeGreaterThanOrEqualTo(String value) {
            addCriterion("league_type >=", value, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeLessThan(String value) {
            addCriterion("league_type <", value, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeLessThanOrEqualTo(String value) {
            addCriterion("league_type <=", value, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeLike(String value) {
            addCriterion("league_type like", value, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeNotLike(String value) {
            addCriterion("league_type not like", value, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeIn(List<String> values) {
            addCriterion("league_type in", values, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeNotIn(List<String> values) {
            addCriterion("league_type not in", values, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeBetween(String value1, String value2) {
            addCriterion("league_type between", value1, value2, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueTypeNotBetween(String value1, String value2) {
            addCriterion("league_type not between", value1, value2, "leagueType");
            return (Criteria) this;
        }

        public Criteria andLeagueIsNull() {
            addCriterion("league is null");
            return (Criteria) this;
        }

        public Criteria andLeagueIsNotNull() {
            addCriterion("league is not null");
            return (Criteria) this;
        }

        public Criteria andLeagueEqualTo(String value) {
            addCriterion("league =", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueNotEqualTo(String value) {
            addCriterion("league <>", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueGreaterThan(String value) {
            addCriterion("league >", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueGreaterThanOrEqualTo(String value) {
            addCriterion("league >=", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueLessThan(String value) {
            addCriterion("league <", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueLessThanOrEqualTo(String value) {
            addCriterion("league <=", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueLike(String value) {
            addCriterion("league like", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueNotLike(String value) {
            addCriterion("league not like", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueIn(List<String> values) {
            addCriterion("league in", values, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueNotIn(List<String> values) {
            addCriterion("league not in", values, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueBetween(String value1, String value2) {
            addCriterion("league between", value1, value2, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueNotBetween(String value1, String value2) {
            addCriterion("league not between", value1, value2, "league");
            return (Criteria) this;
        }

        public Criteria andSectionCountIsNull() {
            addCriterion("section_count is null");
            return (Criteria) this;
        }

        public Criteria andSectionCountIsNotNull() {
            addCriterion("section_count is not null");
            return (Criteria) this;
        }

        public Criteria andSectionCountEqualTo(String value) {
            addCriterion("section_count =", value, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountNotEqualTo(String value) {
            addCriterion("section_count <>", value, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountGreaterThan(String value) {
            addCriterion("section_count >", value, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountGreaterThanOrEqualTo(String value) {
            addCriterion("section_count >=", value, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountLessThan(String value) {
            addCriterion("section_count <", value, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountLessThanOrEqualTo(String value) {
            addCriterion("section_count <=", value, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountLike(String value) {
            addCriterion("section_count like", value, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountNotLike(String value) {
            addCriterion("section_count not like", value, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountIn(List<String> values) {
            addCriterion("section_count in", values, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountNotIn(List<String> values) {
            addCriterion("section_count not in", values, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountBetween(String value1, String value2) {
            addCriterion("section_count between", value1, value2, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andSectionCountNotBetween(String value1, String value2) {
            addCriterion("section_count not between", value1, value2, "sectionCount");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIsNull() {
            addCriterion("remain_time is null");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIsNotNull() {
            addCriterion("remain_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemainTimeEqualTo(String value) {
            addCriterion("remain_time =", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotEqualTo(String value) {
            addCriterion("remain_time <>", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeGreaterThan(String value) {
            addCriterion("remain_time >", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeGreaterThanOrEqualTo(String value) {
            addCriterion("remain_time >=", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeLessThan(String value) {
            addCriterion("remain_time <", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeLessThanOrEqualTo(String value) {
            addCriterion("remain_time <=", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeLike(String value) {
            addCriterion("remain_time like", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotLike(String value) {
            addCriterion("remain_time not like", value, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeIn(List<String> values) {
            addCriterion("remain_time in", values, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotIn(List<String> values) {
            addCriterion("remain_time not in", values, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeBetween(String value1, String value2) {
            addCriterion("remain_time between", value1, value2, "remainTime");
            return (Criteria) this;
        }

        public Criteria andRemainTimeNotBetween(String value1, String value2) {
            addCriterion("remain_time not between", value1, value2, "remainTime");
            return (Criteria) this;
        }

        public Criteria andHomeIdIsNull() {
            addCriterion("home_id is null");
            return (Criteria) this;
        }

        public Criteria andHomeIdIsNotNull() {
            addCriterion("home_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomeIdEqualTo(String value) {
            addCriterion("home_id =", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotEqualTo(String value) {
            addCriterion("home_id <>", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdGreaterThan(String value) {
            addCriterion("home_id >", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdGreaterThanOrEqualTo(String value) {
            addCriterion("home_id >=", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLessThan(String value) {
            addCriterion("home_id <", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLessThanOrEqualTo(String value) {
            addCriterion("home_id <=", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLike(String value) {
            addCriterion("home_id like", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotLike(String value) {
            addCriterion("home_id not like", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdIn(List<String> values) {
            addCriterion("home_id in", values, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotIn(List<String> values) {
            addCriterion("home_id not in", values, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdBetween(String value1, String value2) {
            addCriterion("home_id between", value1, value2, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotBetween(String value1, String value2) {
            addCriterion("home_id not between", value1, value2, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIsNull() {
            addCriterion("home is null");
            return (Criteria) this;
        }

        public Criteria andHomeIsNotNull() {
            addCriterion("home is not null");
            return (Criteria) this;
        }

        public Criteria andHomeEqualTo(String value) {
            addCriterion("home =", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeNotEqualTo(String value) {
            addCriterion("home <>", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeGreaterThan(String value) {
            addCriterion("home >", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeGreaterThanOrEqualTo(String value) {
            addCriterion("home >=", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeLessThan(String value) {
            addCriterion("home <", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeLessThanOrEqualTo(String value) {
            addCriterion("home <=", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeLike(String value) {
            addCriterion("home like", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeNotLike(String value) {
            addCriterion("home not like", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeIn(List<String> values) {
            addCriterion("home in", values, "home");
            return (Criteria) this;
        }

        public Criteria andHomeNotIn(List<String> values) {
            addCriterion("home not in", values, "home");
            return (Criteria) this;
        }

        public Criteria andHomeBetween(String value1, String value2) {
            addCriterion("home between", value1, value2, "home");
            return (Criteria) this;
        }

        public Criteria andHomeNotBetween(String value1, String value2) {
            addCriterion("home not between", value1, value2, "home");
            return (Criteria) this;
        }

        public Criteria andAwayIdIsNull() {
            addCriterion("away_id is null");
            return (Criteria) this;
        }

        public Criteria andAwayIdIsNotNull() {
            addCriterion("away_id is not null");
            return (Criteria) this;
        }

        public Criteria andAwayIdEqualTo(String value) {
            addCriterion("away_id =", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdNotEqualTo(String value) {
            addCriterion("away_id <>", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdGreaterThan(String value) {
            addCriterion("away_id >", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdGreaterThanOrEqualTo(String value) {
            addCriterion("away_id >=", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdLessThan(String value) {
            addCriterion("away_id <", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdLessThanOrEqualTo(String value) {
            addCriterion("away_id <=", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdLike(String value) {
            addCriterion("away_id like", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdNotLike(String value) {
            addCriterion("away_id not like", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdIn(List<String> values) {
            addCriterion("away_id in", values, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdNotIn(List<String> values) {
            addCriterion("away_id not in", values, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdBetween(String value1, String value2) {
            addCriterion("away_id between", value1, value2, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdNotBetween(String value1, String value2) {
            addCriterion("away_id not between", value1, value2, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIsNull() {
            addCriterion("away is null");
            return (Criteria) this;
        }

        public Criteria andAwayIsNotNull() {
            addCriterion("away is not null");
            return (Criteria) this;
        }

        public Criteria andAwayEqualTo(String value) {
            addCriterion("away =", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayNotEqualTo(String value) {
            addCriterion("away <>", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayGreaterThan(String value) {
            addCriterion("away >", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayGreaterThanOrEqualTo(String value) {
            addCriterion("away >=", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayLessThan(String value) {
            addCriterion("away <", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayLessThanOrEqualTo(String value) {
            addCriterion("away <=", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayLike(String value) {
            addCriterion("away like", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayNotLike(String value) {
            addCriterion("away not like", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayIn(List<String> values) {
            addCriterion("away in", values, "away");
            return (Criteria) this;
        }

        public Criteria andAwayNotIn(List<String> values) {
            addCriterion("away not in", values, "away");
            return (Criteria) this;
        }

        public Criteria andAwayBetween(String value1, String value2) {
            addCriterion("away between", value1, value2, "away");
            return (Criteria) this;
        }

        public Criteria andAwayNotBetween(String value1, String value2) {
            addCriterion("away not between", value1, value2, "away");
            return (Criteria) this;
        }

        public Criteria andOrder1IsNull() {
            addCriterion("order1 is null");
            return (Criteria) this;
        }

        public Criteria andOrder1IsNotNull() {
            addCriterion("order1 is not null");
            return (Criteria) this;
        }

        public Criteria andOrder1EqualTo(String value) {
            addCriterion("order1 =", value, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1NotEqualTo(String value) {
            addCriterion("order1 <>", value, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1GreaterThan(String value) {
            addCriterion("order1 >", value, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1GreaterThanOrEqualTo(String value) {
            addCriterion("order1 >=", value, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1LessThan(String value) {
            addCriterion("order1 <", value, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1LessThanOrEqualTo(String value) {
            addCriterion("order1 <=", value, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1Like(String value) {
            addCriterion("order1 like", value, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1NotLike(String value) {
            addCriterion("order1 not like", value, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1In(List<String> values) {
            addCriterion("order1 in", values, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1NotIn(List<String> values) {
            addCriterion("order1 not in", values, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1Between(String value1, String value2) {
            addCriterion("order1 between", value1, value2, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder1NotBetween(String value1, String value2) {
            addCriterion("order1 not between", value1, value2, "order1");
            return (Criteria) this;
        }

        public Criteria andOrder2IsNull() {
            addCriterion("order2 is null");
            return (Criteria) this;
        }

        public Criteria andOrder2IsNotNull() {
            addCriterion("order2 is not null");
            return (Criteria) this;
        }

        public Criteria andOrder2EqualTo(String value) {
            addCriterion("order2 =", value, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2NotEqualTo(String value) {
            addCriterion("order2 <>", value, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2GreaterThan(String value) {
            addCriterion("order2 >", value, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2GreaterThanOrEqualTo(String value) {
            addCriterion("order2 >=", value, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2LessThan(String value) {
            addCriterion("order2 <", value, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2LessThanOrEqualTo(String value) {
            addCriterion("order2 <=", value, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2Like(String value) {
            addCriterion("order2 like", value, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2NotLike(String value) {
            addCriterion("order2 not like", value, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2In(List<String> values) {
            addCriterion("order2 in", values, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2NotIn(List<String> values) {
            addCriterion("order2 not in", values, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2Between(String value1, String value2) {
            addCriterion("order2 between", value1, value2, "order2");
            return (Criteria) this;
        }

        public Criteria andOrder2NotBetween(String value1, String value2) {
            addCriterion("order2 not between", value1, value2, "order2");
            return (Criteria) this;
        }

        public Criteria andHomeScoreIsNull() {
            addCriterion("home_score is null");
            return (Criteria) this;
        }

        public Criteria andHomeScoreIsNotNull() {
            addCriterion("home_score is not null");
            return (Criteria) this;
        }

        public Criteria andHomeScoreEqualTo(String value) {
            addCriterion("home_score =", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreNotEqualTo(String value) {
            addCriterion("home_score <>", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreGreaterThan(String value) {
            addCriterion("home_score >", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreGreaterThanOrEqualTo(String value) {
            addCriterion("home_score >=", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreLessThan(String value) {
            addCriterion("home_score <", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreLessThanOrEqualTo(String value) {
            addCriterion("home_score <=", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreLike(String value) {
            addCriterion("home_score like", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreNotLike(String value) {
            addCriterion("home_score not like", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreIn(List<String> values) {
            addCriterion("home_score in", values, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreNotIn(List<String> values) {
            addCriterion("home_score not in", values, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreBetween(String value1, String value2) {
            addCriterion("home_score between", value1, value2, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreNotBetween(String value1, String value2) {
            addCriterion("home_score not between", value1, value2, "homeScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreIsNull() {
            addCriterion("away_score is null");
            return (Criteria) this;
        }

        public Criteria andAwayScoreIsNotNull() {
            addCriterion("away_score is not null");
            return (Criteria) this;
        }

        public Criteria andAwayScoreEqualTo(String value) {
            addCriterion("away_score =", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreNotEqualTo(String value) {
            addCriterion("away_score <>", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreGreaterThan(String value) {
            addCriterion("away_score >", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreGreaterThanOrEqualTo(String value) {
            addCriterion("away_score >=", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreLessThan(String value) {
            addCriterion("away_score <", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreLessThanOrEqualTo(String value) {
            addCriterion("away_score <=", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreLike(String value) {
            addCriterion("away_score like", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreNotLike(String value) {
            addCriterion("away_score not like", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreIn(List<String> values) {
            addCriterion("away_score in", values, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreNotIn(List<String> values) {
            addCriterion("away_score not in", values, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreBetween(String value1, String value2) {
            addCriterion("away_score between", value1, value2, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreNotBetween(String value1, String value2) {
            addCriterion("away_score not between", value1, value2, "awayScore");
            return (Criteria) this;
        }

        public Criteria andZd1IsNull() {
            addCriterion("zd1 is null");
            return (Criteria) this;
        }

        public Criteria andZd1IsNotNull() {
            addCriterion("zd1 is not null");
            return (Criteria) this;
        }

        public Criteria andZd1EqualTo(String value) {
            addCriterion("zd1 =", value, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1NotEqualTo(String value) {
            addCriterion("zd1 <>", value, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1GreaterThan(String value) {
            addCriterion("zd1 >", value, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1GreaterThanOrEqualTo(String value) {
            addCriterion("zd1 >=", value, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1LessThan(String value) {
            addCriterion("zd1 <", value, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1LessThanOrEqualTo(String value) {
            addCriterion("zd1 <=", value, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1Like(String value) {
            addCriterion("zd1 like", value, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1NotLike(String value) {
            addCriterion("zd1 not like", value, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1In(List<String> values) {
            addCriterion("zd1 in", values, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1NotIn(List<String> values) {
            addCriterion("zd1 not in", values, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1Between(String value1, String value2) {
            addCriterion("zd1 between", value1, value2, "zd1");
            return (Criteria) this;
        }

        public Criteria andZd1NotBetween(String value1, String value2) {
            addCriterion("zd1 not between", value1, value2, "zd1");
            return (Criteria) this;
        }

        public Criteria andKd1IsNull() {
            addCriterion("kd1 is null");
            return (Criteria) this;
        }

        public Criteria andKd1IsNotNull() {
            addCriterion("kd1 is not null");
            return (Criteria) this;
        }

        public Criteria andKd1EqualTo(String value) {
            addCriterion("kd1 =", value, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1NotEqualTo(String value) {
            addCriterion("kd1 <>", value, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1GreaterThan(String value) {
            addCriterion("kd1 >", value, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1GreaterThanOrEqualTo(String value) {
            addCriterion("kd1 >=", value, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1LessThan(String value) {
            addCriterion("kd1 <", value, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1LessThanOrEqualTo(String value) {
            addCriterion("kd1 <=", value, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1Like(String value) {
            addCriterion("kd1 like", value, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1NotLike(String value) {
            addCriterion("kd1 not like", value, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1In(List<String> values) {
            addCriterion("kd1 in", values, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1NotIn(List<String> values) {
            addCriterion("kd1 not in", values, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1Between(String value1, String value2) {
            addCriterion("kd1 between", value1, value2, "kd1");
            return (Criteria) this;
        }

        public Criteria andKd1NotBetween(String value1, String value2) {
            addCriterion("kd1 not between", value1, value2, "kd1");
            return (Criteria) this;
        }

        public Criteria andZd2IsNull() {
            addCriterion("zd2 is null");
            return (Criteria) this;
        }

        public Criteria andZd2IsNotNull() {
            addCriterion("zd2 is not null");
            return (Criteria) this;
        }

        public Criteria andZd2EqualTo(String value) {
            addCriterion("zd2 =", value, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2NotEqualTo(String value) {
            addCriterion("zd2 <>", value, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2GreaterThan(String value) {
            addCriterion("zd2 >", value, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2GreaterThanOrEqualTo(String value) {
            addCriterion("zd2 >=", value, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2LessThan(String value) {
            addCriterion("zd2 <", value, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2LessThanOrEqualTo(String value) {
            addCriterion("zd2 <=", value, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2Like(String value) {
            addCriterion("zd2 like", value, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2NotLike(String value) {
            addCriterion("zd2 not like", value, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2In(List<String> values) {
            addCriterion("zd2 in", values, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2NotIn(List<String> values) {
            addCriterion("zd2 not in", values, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2Between(String value1, String value2) {
            addCriterion("zd2 between", value1, value2, "zd2");
            return (Criteria) this;
        }

        public Criteria andZd2NotBetween(String value1, String value2) {
            addCriterion("zd2 not between", value1, value2, "zd2");
            return (Criteria) this;
        }

        public Criteria andKd2IsNull() {
            addCriterion("kd2 is null");
            return (Criteria) this;
        }

        public Criteria andKd2IsNotNull() {
            addCriterion("kd2 is not null");
            return (Criteria) this;
        }

        public Criteria andKd2EqualTo(String value) {
            addCriterion("kd2 =", value, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2NotEqualTo(String value) {
            addCriterion("kd2 <>", value, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2GreaterThan(String value) {
            addCriterion("kd2 >", value, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2GreaterThanOrEqualTo(String value) {
            addCriterion("kd2 >=", value, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2LessThan(String value) {
            addCriterion("kd2 <", value, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2LessThanOrEqualTo(String value) {
            addCriterion("kd2 <=", value, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2Like(String value) {
            addCriterion("kd2 like", value, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2NotLike(String value) {
            addCriterion("kd2 not like", value, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2In(List<String> values) {
            addCriterion("kd2 in", values, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2NotIn(List<String> values) {
            addCriterion("kd2 not in", values, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2Between(String value1, String value2) {
            addCriterion("kd2 between", value1, value2, "kd2");
            return (Criteria) this;
        }

        public Criteria andKd2NotBetween(String value1, String value2) {
            addCriterion("kd2 not between", value1, value2, "kd2");
            return (Criteria) this;
        }

        public Criteria andZd3IsNull() {
            addCriterion("zd3 is null");
            return (Criteria) this;
        }

        public Criteria andZd3IsNotNull() {
            addCriterion("zd3 is not null");
            return (Criteria) this;
        }

        public Criteria andZd3EqualTo(String value) {
            addCriterion("zd3 =", value, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3NotEqualTo(String value) {
            addCriterion("zd3 <>", value, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3GreaterThan(String value) {
            addCriterion("zd3 >", value, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3GreaterThanOrEqualTo(String value) {
            addCriterion("zd3 >=", value, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3LessThan(String value) {
            addCriterion("zd3 <", value, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3LessThanOrEqualTo(String value) {
            addCriterion("zd3 <=", value, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3Like(String value) {
            addCriterion("zd3 like", value, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3NotLike(String value) {
            addCriterion("zd3 not like", value, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3In(List<String> values) {
            addCriterion("zd3 in", values, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3NotIn(List<String> values) {
            addCriterion("zd3 not in", values, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3Between(String value1, String value2) {
            addCriterion("zd3 between", value1, value2, "zd3");
            return (Criteria) this;
        }

        public Criteria andZd3NotBetween(String value1, String value2) {
            addCriterion("zd3 not between", value1, value2, "zd3");
            return (Criteria) this;
        }

        public Criteria andKd3IsNull() {
            addCriterion("kd3 is null");
            return (Criteria) this;
        }

        public Criteria andKd3IsNotNull() {
            addCriterion("kd3 is not null");
            return (Criteria) this;
        }

        public Criteria andKd3EqualTo(String value) {
            addCriterion("kd3 =", value, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3NotEqualTo(String value) {
            addCriterion("kd3 <>", value, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3GreaterThan(String value) {
            addCriterion("kd3 >", value, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3GreaterThanOrEqualTo(String value) {
            addCriterion("kd3 >=", value, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3LessThan(String value) {
            addCriterion("kd3 <", value, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3LessThanOrEqualTo(String value) {
            addCriterion("kd3 <=", value, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3Like(String value) {
            addCriterion("kd3 like", value, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3NotLike(String value) {
            addCriterion("kd3 not like", value, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3In(List<String> values) {
            addCriterion("kd3 in", values, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3NotIn(List<String> values) {
            addCriterion("kd3 not in", values, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3Between(String value1, String value2) {
            addCriterion("kd3 between", value1, value2, "kd3");
            return (Criteria) this;
        }

        public Criteria andKd3NotBetween(String value1, String value2) {
            addCriterion("kd3 not between", value1, value2, "kd3");
            return (Criteria) this;
        }

        public Criteria andZd4IsNull() {
            addCriterion("zd4 is null");
            return (Criteria) this;
        }

        public Criteria andZd4IsNotNull() {
            addCriterion("zd4 is not null");
            return (Criteria) this;
        }

        public Criteria andZd4EqualTo(String value) {
            addCriterion("zd4 =", value, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4NotEqualTo(String value) {
            addCriterion("zd4 <>", value, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4GreaterThan(String value) {
            addCriterion("zd4 >", value, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4GreaterThanOrEqualTo(String value) {
            addCriterion("zd4 >=", value, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4LessThan(String value) {
            addCriterion("zd4 <", value, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4LessThanOrEqualTo(String value) {
            addCriterion("zd4 <=", value, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4Like(String value) {
            addCriterion("zd4 like", value, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4NotLike(String value) {
            addCriterion("zd4 not like", value, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4In(List<String> values) {
            addCriterion("zd4 in", values, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4NotIn(List<String> values) {
            addCriterion("zd4 not in", values, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4Between(String value1, String value2) {
            addCriterion("zd4 between", value1, value2, "zd4");
            return (Criteria) this;
        }

        public Criteria andZd4NotBetween(String value1, String value2) {
            addCriterion("zd4 not between", value1, value2, "zd4");
            return (Criteria) this;
        }

        public Criteria andKd4IsNull() {
            addCriterion("kd4 is null");
            return (Criteria) this;
        }

        public Criteria andKd4IsNotNull() {
            addCriterion("kd4 is not null");
            return (Criteria) this;
        }

        public Criteria andKd4EqualTo(String value) {
            addCriterion("kd4 =", value, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4NotEqualTo(String value) {
            addCriterion("kd4 <>", value, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4GreaterThan(String value) {
            addCriterion("kd4 >", value, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4GreaterThanOrEqualTo(String value) {
            addCriterion("kd4 >=", value, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4LessThan(String value) {
            addCriterion("kd4 <", value, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4LessThanOrEqualTo(String value) {
            addCriterion("kd4 <=", value, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4Like(String value) {
            addCriterion("kd4 like", value, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4NotLike(String value) {
            addCriterion("kd4 not like", value, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4In(List<String> values) {
            addCriterion("kd4 in", values, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4NotIn(List<String> values) {
            addCriterion("kd4 not in", values, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4Between(String value1, String value2) {
            addCriterion("kd4 between", value1, value2, "kd4");
            return (Criteria) this;
        }

        public Criteria andKd4NotBetween(String value1, String value2) {
            addCriterion("kd4 not between", value1, value2, "kd4");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(String value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(String value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(String value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(String value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(String value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(String value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLike(String value) {
            addCriterion("add_time like", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotLike(String value) {
            addCriterion("add_time not like", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<String> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<String> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(String value1, String value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(String value1, String value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andZd1otIsNull() {
            addCriterion("zd1ot is null");
            return (Criteria) this;
        }

        public Criteria andZd1otIsNotNull() {
            addCriterion("zd1ot is not null");
            return (Criteria) this;
        }

        public Criteria andZd1otEqualTo(String value) {
            addCriterion("zd1ot =", value, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otNotEqualTo(String value) {
            addCriterion("zd1ot <>", value, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otGreaterThan(String value) {
            addCriterion("zd1ot >", value, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otGreaterThanOrEqualTo(String value) {
            addCriterion("zd1ot >=", value, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otLessThan(String value) {
            addCriterion("zd1ot <", value, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otLessThanOrEqualTo(String value) {
            addCriterion("zd1ot <=", value, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otLike(String value) {
            addCriterion("zd1ot like", value, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otNotLike(String value) {
            addCriterion("zd1ot not like", value, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otIn(List<String> values) {
            addCriterion("zd1ot in", values, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otNotIn(List<String> values) {
            addCriterion("zd1ot not in", values, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otBetween(String value1, String value2) {
            addCriterion("zd1ot between", value1, value2, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andZd1otNotBetween(String value1, String value2) {
            addCriterion("zd1ot not between", value1, value2, "zd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otIsNull() {
            addCriterion("kd1ot is null");
            return (Criteria) this;
        }

        public Criteria andKd1otIsNotNull() {
            addCriterion("kd1ot is not null");
            return (Criteria) this;
        }

        public Criteria andKd1otEqualTo(String value) {
            addCriterion("kd1ot =", value, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otNotEqualTo(String value) {
            addCriterion("kd1ot <>", value, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otGreaterThan(String value) {
            addCriterion("kd1ot >", value, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otGreaterThanOrEqualTo(String value) {
            addCriterion("kd1ot >=", value, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otLessThan(String value) {
            addCriterion("kd1ot <", value, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otLessThanOrEqualTo(String value) {
            addCriterion("kd1ot <=", value, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otLike(String value) {
            addCriterion("kd1ot like", value, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otNotLike(String value) {
            addCriterion("kd1ot not like", value, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otIn(List<String> values) {
            addCriterion("kd1ot in", values, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otNotIn(List<String> values) {
            addCriterion("kd1ot not in", values, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otBetween(String value1, String value2) {
            addCriterion("kd1ot between", value1, value2, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andKd1otNotBetween(String value1, String value2) {
            addCriterion("kd1ot not between", value1, value2, "kd1ot");
            return (Criteria) this;
        }

        public Criteria andZd2otIsNull() {
            addCriterion("zd2ot is null");
            return (Criteria) this;
        }

        public Criteria andZd2otIsNotNull() {
            addCriterion("zd2ot is not null");
            return (Criteria) this;
        }

        public Criteria andZd2otEqualTo(String value) {
            addCriterion("zd2ot =", value, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otNotEqualTo(String value) {
            addCriterion("zd2ot <>", value, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otGreaterThan(String value) {
            addCriterion("zd2ot >", value, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otGreaterThanOrEqualTo(String value) {
            addCriterion("zd2ot >=", value, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otLessThan(String value) {
            addCriterion("zd2ot <", value, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otLessThanOrEqualTo(String value) {
            addCriterion("zd2ot <=", value, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otLike(String value) {
            addCriterion("zd2ot like", value, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otNotLike(String value) {
            addCriterion("zd2ot not like", value, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otIn(List<String> values) {
            addCriterion("zd2ot in", values, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otNotIn(List<String> values) {
            addCriterion("zd2ot not in", values, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otBetween(String value1, String value2) {
            addCriterion("zd2ot between", value1, value2, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andZd2otNotBetween(String value1, String value2) {
            addCriterion("zd2ot not between", value1, value2, "zd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otIsNull() {
            addCriterion("kd2ot is null");
            return (Criteria) this;
        }

        public Criteria andKd2otIsNotNull() {
            addCriterion("kd2ot is not null");
            return (Criteria) this;
        }

        public Criteria andKd2otEqualTo(String value) {
            addCriterion("kd2ot =", value, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otNotEqualTo(String value) {
            addCriterion("kd2ot <>", value, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otGreaterThan(String value) {
            addCriterion("kd2ot >", value, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otGreaterThanOrEqualTo(String value) {
            addCriterion("kd2ot >=", value, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otLessThan(String value) {
            addCriterion("kd2ot <", value, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otLessThanOrEqualTo(String value) {
            addCriterion("kd2ot <=", value, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otLike(String value) {
            addCriterion("kd2ot like", value, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otNotLike(String value) {
            addCriterion("kd2ot not like", value, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otIn(List<String> values) {
            addCriterion("kd2ot in", values, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otNotIn(List<String> values) {
            addCriterion("kd2ot not in", values, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otBetween(String value1, String value2) {
            addCriterion("kd2ot between", value1, value2, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andKd2otNotBetween(String value1, String value2) {
            addCriterion("kd2ot not between", value1, value2, "kd2ot");
            return (Criteria) this;
        }

        public Criteria andZd3otIsNull() {
            addCriterion("zd3ot is null");
            return (Criteria) this;
        }

        public Criteria andZd3otIsNotNull() {
            addCriterion("zd3ot is not null");
            return (Criteria) this;
        }

        public Criteria andZd3otEqualTo(String value) {
            addCriterion("zd3ot =", value, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otNotEqualTo(String value) {
            addCriterion("zd3ot <>", value, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otGreaterThan(String value) {
            addCriterion("zd3ot >", value, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otGreaterThanOrEqualTo(String value) {
            addCriterion("zd3ot >=", value, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otLessThan(String value) {
            addCriterion("zd3ot <", value, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otLessThanOrEqualTo(String value) {
            addCriterion("zd3ot <=", value, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otLike(String value) {
            addCriterion("zd3ot like", value, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otNotLike(String value) {
            addCriterion("zd3ot not like", value, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otIn(List<String> values) {
            addCriterion("zd3ot in", values, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otNotIn(List<String> values) {
            addCriterion("zd3ot not in", values, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otBetween(String value1, String value2) {
            addCriterion("zd3ot between", value1, value2, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andZd3otNotBetween(String value1, String value2) {
            addCriterion("zd3ot not between", value1, value2, "zd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otIsNull() {
            addCriterion("kd3ot is null");
            return (Criteria) this;
        }

        public Criteria andKd3otIsNotNull() {
            addCriterion("kd3ot is not null");
            return (Criteria) this;
        }

        public Criteria andKd3otEqualTo(String value) {
            addCriterion("kd3ot =", value, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otNotEqualTo(String value) {
            addCriterion("kd3ot <>", value, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otGreaterThan(String value) {
            addCriterion("kd3ot >", value, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otGreaterThanOrEqualTo(String value) {
            addCriterion("kd3ot >=", value, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otLessThan(String value) {
            addCriterion("kd3ot <", value, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otLessThanOrEqualTo(String value) {
            addCriterion("kd3ot <=", value, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otLike(String value) {
            addCriterion("kd3ot like", value, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otNotLike(String value) {
            addCriterion("kd3ot not like", value, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otIn(List<String> values) {
            addCriterion("kd3ot in", values, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otNotIn(List<String> values) {
            addCriterion("kd3ot not in", values, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otBetween(String value1, String value2) {
            addCriterion("kd3ot between", value1, value2, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andKd3otNotBetween(String value1, String value2) {
            addCriterion("kd3ot not between", value1, value2, "kd3ot");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalIsNull() {
            addCriterion("have_technical is null");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalIsNotNull() {
            addCriterion("have_technical is not null");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalEqualTo(String value) {
            addCriterion("have_technical =", value, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalNotEqualTo(String value) {
            addCriterion("have_technical <>", value, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalGreaterThan(String value) {
            addCriterion("have_technical >", value, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalGreaterThanOrEqualTo(String value) {
            addCriterion("have_technical >=", value, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalLessThan(String value) {
            addCriterion("have_technical <", value, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalLessThanOrEqualTo(String value) {
            addCriterion("have_technical <=", value, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalLike(String value) {
            addCriterion("have_technical like", value, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalNotLike(String value) {
            addCriterion("have_technical not like", value, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalIn(List<String> values) {
            addCriterion("have_technical in", values, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalNotIn(List<String> values) {
            addCriterion("have_technical not in", values, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalBetween(String value1, String value2) {
            addCriterion("have_technical between", value1, value2, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andHaveTechnicalNotBetween(String value1, String value2) {
            addCriterion("have_technical not between", value1, value2, "haveTechnical");
            return (Criteria) this;
        }

        public Criteria andTvIsNull() {
            addCriterion("tv is null");
            return (Criteria) this;
        }

        public Criteria andTvIsNotNull() {
            addCriterion("tv is not null");
            return (Criteria) this;
        }

        public Criteria andTvEqualTo(String value) {
            addCriterion("tv =", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvNotEqualTo(String value) {
            addCriterion("tv <>", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvGreaterThan(String value) {
            addCriterion("tv >", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvGreaterThanOrEqualTo(String value) {
            addCriterion("tv >=", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvLessThan(String value) {
            addCriterion("tv <", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvLessThanOrEqualTo(String value) {
            addCriterion("tv <=", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvLike(String value) {
            addCriterion("tv like", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvNotLike(String value) {
            addCriterion("tv not like", value, "tv");
            return (Criteria) this;
        }

        public Criteria andTvIn(List<String> values) {
            addCriterion("tv in", values, "tv");
            return (Criteria) this;
        }

        public Criteria andTvNotIn(List<String> values) {
            addCriterion("tv not in", values, "tv");
            return (Criteria) this;
        }

        public Criteria andTvBetween(String value1, String value2) {
            addCriterion("tv between", value1, value2, "tv");
            return (Criteria) this;
        }

        public Criteria andTvNotBetween(String value1, String value2) {
            addCriterion("tv not between", value1, value2, "tv");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andZlIsNull() {
            addCriterion("zl is null");
            return (Criteria) this;
        }

        public Criteria andZlIsNotNull() {
            addCriterion("zl is not null");
            return (Criteria) this;
        }

        public Criteria andZlEqualTo(String value) {
            addCriterion("zl =", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotEqualTo(String value) {
            addCriterion("zl <>", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlGreaterThan(String value) {
            addCriterion("zl >", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlGreaterThanOrEqualTo(String value) {
            addCriterion("zl >=", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLessThan(String value) {
            addCriterion("zl <", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLessThanOrEqualTo(String value) {
            addCriterion("zl <=", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLike(String value) {
            addCriterion("zl like", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotLike(String value) {
            addCriterion("zl not like", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlIn(List<String> values) {
            addCriterion("zl in", values, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotIn(List<String> values) {
            addCriterion("zl not in", values, "zl");
            return (Criteria) this;
        }

        public Criteria andZlBetween(String value1, String value2) {
            addCriterion("zl between", value1, value2, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotBetween(String value1, String value2) {
            addCriterion("zl not between", value1, value2, "zl");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNull() {
            addCriterion("season is null");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNotNull() {
            addCriterion("season is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonEqualTo(String value) {
            addCriterion("season =", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotEqualTo(String value) {
            addCriterion("season <>", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThan(String value) {
            addCriterion("season >", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThanOrEqualTo(String value) {
            addCriterion("season >=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThan(String value) {
            addCriterion("season <", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThanOrEqualTo(String value) {
            addCriterion("season <=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLike(String value) {
            addCriterion("season like", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotLike(String value) {
            addCriterion("season not like", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonIn(List<String> values) {
            addCriterion("season in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotIn(List<String> values) {
            addCriterion("season not in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonBetween(String value1, String value2) {
            addCriterion("season between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotBetween(String value1, String value2) {
            addCriterion("season not between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andGameTypeIsNull() {
            addCriterion("game_type is null");
            return (Criteria) this;
        }

        public Criteria andGameTypeIsNotNull() {
            addCriterion("game_type is not null");
            return (Criteria) this;
        }

        public Criteria andGameTypeEqualTo(String value) {
            addCriterion("game_type =", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotEqualTo(String value) {
            addCriterion("game_type <>", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThan(String value) {
            addCriterion("game_type >", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThanOrEqualTo(String value) {
            addCriterion("game_type >=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThan(String value) {
            addCriterion("game_type <", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThanOrEqualTo(String value) {
            addCriterion("game_type <=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLike(String value) {
            addCriterion("game_type like", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotLike(String value) {
            addCriterion("game_type not like", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeIn(List<String> values) {
            addCriterion("game_type in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotIn(List<String> values) {
            addCriterion("game_type not in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeBetween(String value1, String value2) {
            addCriterion("game_type between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotBetween(String value1, String value2) {
            addCriterion("game_type not between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeIsNull() {
            addCriterion("game_sub_type is null");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeIsNotNull() {
            addCriterion("game_sub_type is not null");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeEqualTo(String value) {
            addCriterion("game_sub_type =", value, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeNotEqualTo(String value) {
            addCriterion("game_sub_type <>", value, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeGreaterThan(String value) {
            addCriterion("game_sub_type >", value, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeGreaterThanOrEqualTo(String value) {
            addCriterion("game_sub_type >=", value, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeLessThan(String value) {
            addCriterion("game_sub_type <", value, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeLessThanOrEqualTo(String value) {
            addCriterion("game_sub_type <=", value, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeLike(String value) {
            addCriterion("game_sub_type like", value, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeNotLike(String value) {
            addCriterion("game_sub_type not like", value, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeIn(List<String> values) {
            addCriterion("game_sub_type in", values, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeNotIn(List<String> values) {
            addCriterion("game_sub_type not in", values, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeBetween(String value1, String value2) {
            addCriterion("game_sub_type between", value1, value2, "gameSubType");
            return (Criteria) this;
        }

        public Criteria andGameSubTypeNotBetween(String value1, String value2) {
            addCriterion("game_sub_type not between", value1, value2, "gameSubType");
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