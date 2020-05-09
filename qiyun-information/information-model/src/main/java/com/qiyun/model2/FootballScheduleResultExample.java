package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class FootballScheduleResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FootballScheduleResultExample() {
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

        public Criteria andSubLeagueIsNull() {
            addCriterion("sub_league is null");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIsNotNull() {
            addCriterion("sub_league is not null");
            return (Criteria) this;
        }

        public Criteria andSubLeagueEqualTo(String value) {
            addCriterion("sub_league =", value, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueNotEqualTo(String value) {
            addCriterion("sub_league <>", value, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueGreaterThan(String value) {
            addCriterion("sub_league >", value, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueGreaterThanOrEqualTo(String value) {
            addCriterion("sub_league >=", value, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueLessThan(String value) {
            addCriterion("sub_league <", value, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueLessThanOrEqualTo(String value) {
            addCriterion("sub_league <=", value, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueLike(String value) {
            addCriterion("sub_league like", value, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueNotLike(String value) {
            addCriterion("sub_league not like", value, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIn(List<String> values) {
            addCriterion("sub_league in", values, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueNotIn(List<String> values) {
            addCriterion("sub_league not in", values, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueBetween(String value1, String value2) {
            addCriterion("sub_league between", value1, value2, "subLeague");
            return (Criteria) this;
        }

        public Criteria andSubLeagueNotBetween(String value1, String value2) {
            addCriterion("sub_league not between", value1, value2, "subLeague");
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

        public Criteria andBc1IsNull() {
            addCriterion("bc1 is null");
            return (Criteria) this;
        }

        public Criteria andBc1IsNotNull() {
            addCriterion("bc1 is not null");
            return (Criteria) this;
        }

        public Criteria andBc1EqualTo(String value) {
            addCriterion("bc1 =", value, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1NotEqualTo(String value) {
            addCriterion("bc1 <>", value, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1GreaterThan(String value) {
            addCriterion("bc1 >", value, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1GreaterThanOrEqualTo(String value) {
            addCriterion("bc1 >=", value, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1LessThan(String value) {
            addCriterion("bc1 <", value, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1LessThanOrEqualTo(String value) {
            addCriterion("bc1 <=", value, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1Like(String value) {
            addCriterion("bc1 like", value, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1NotLike(String value) {
            addCriterion("bc1 not like", value, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1In(List<String> values) {
            addCriterion("bc1 in", values, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1NotIn(List<String> values) {
            addCriterion("bc1 not in", values, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1Between(String value1, String value2) {
            addCriterion("bc1 between", value1, value2, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc1NotBetween(String value1, String value2) {
            addCriterion("bc1 not between", value1, value2, "bc1");
            return (Criteria) this;
        }

        public Criteria andBc2IsNull() {
            addCriterion("bc2 is null");
            return (Criteria) this;
        }

        public Criteria andBc2IsNotNull() {
            addCriterion("bc2 is not null");
            return (Criteria) this;
        }

        public Criteria andBc2EqualTo(String value) {
            addCriterion("bc2 =", value, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2NotEqualTo(String value) {
            addCriterion("bc2 <>", value, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2GreaterThan(String value) {
            addCriterion("bc2 >", value, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2GreaterThanOrEqualTo(String value) {
            addCriterion("bc2 >=", value, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2LessThan(String value) {
            addCriterion("bc2 <", value, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2LessThanOrEqualTo(String value) {
            addCriterion("bc2 <=", value, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2Like(String value) {
            addCriterion("bc2 like", value, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2NotLike(String value) {
            addCriterion("bc2 not like", value, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2In(List<String> values) {
            addCriterion("bc2 in", values, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2NotIn(List<String> values) {
            addCriterion("bc2 not in", values, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2Between(String value1, String value2) {
            addCriterion("bc2 between", value1, value2, "bc2");
            return (Criteria) this;
        }

        public Criteria andBc2NotBetween(String value1, String value2) {
            addCriterion("bc2 not between", value1, value2, "bc2");
            return (Criteria) this;
        }

        public Criteria andRed1IsNull() {
            addCriterion("red1 is null");
            return (Criteria) this;
        }

        public Criteria andRed1IsNotNull() {
            addCriterion("red1 is not null");
            return (Criteria) this;
        }

        public Criteria andRed1EqualTo(String value) {
            addCriterion("red1 =", value, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1NotEqualTo(String value) {
            addCriterion("red1 <>", value, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1GreaterThan(String value) {
            addCriterion("red1 >", value, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1GreaterThanOrEqualTo(String value) {
            addCriterion("red1 >=", value, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1LessThan(String value) {
            addCriterion("red1 <", value, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1LessThanOrEqualTo(String value) {
            addCriterion("red1 <=", value, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1Like(String value) {
            addCriterion("red1 like", value, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1NotLike(String value) {
            addCriterion("red1 not like", value, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1In(List<String> values) {
            addCriterion("red1 in", values, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1NotIn(List<String> values) {
            addCriterion("red1 not in", values, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1Between(String value1, String value2) {
            addCriterion("red1 between", value1, value2, "red1");
            return (Criteria) this;
        }

        public Criteria andRed1NotBetween(String value1, String value2) {
            addCriterion("red1 not between", value1, value2, "red1");
            return (Criteria) this;
        }

        public Criteria andRed2IsNull() {
            addCriterion("red2 is null");
            return (Criteria) this;
        }

        public Criteria andRed2IsNotNull() {
            addCriterion("red2 is not null");
            return (Criteria) this;
        }

        public Criteria andRed2EqualTo(String value) {
            addCriterion("red2 =", value, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2NotEqualTo(String value) {
            addCriterion("red2 <>", value, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2GreaterThan(String value) {
            addCriterion("red2 >", value, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2GreaterThanOrEqualTo(String value) {
            addCriterion("red2 >=", value, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2LessThan(String value) {
            addCriterion("red2 <", value, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2LessThanOrEqualTo(String value) {
            addCriterion("red2 <=", value, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2Like(String value) {
            addCriterion("red2 like", value, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2NotLike(String value) {
            addCriterion("red2 not like", value, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2In(List<String> values) {
            addCriterion("red2 in", values, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2NotIn(List<String> values) {
            addCriterion("red2 not in", values, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2Between(String value1, String value2) {
            addCriterion("red2 between", value1, value2, "red2");
            return (Criteria) this;
        }

        public Criteria andRed2NotBetween(String value1, String value2) {
            addCriterion("red2 not between", value1, value2, "red2");
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

        public Criteria andExplainIsNull() {
            addCriterion("explain is null");
            return (Criteria) this;
        }

        public Criteria andExplainIsNotNull() {
            addCriterion("explain is not null");
            return (Criteria) this;
        }

        public Criteria andExplainEqualTo(String value) {
            addCriterion("explain =", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotEqualTo(String value) {
            addCriterion("explain <>", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThan(String value) {
            addCriterion("explain >", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThanOrEqualTo(String value) {
            addCriterion("explain >=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThan(String value) {
            addCriterion("explain <", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThanOrEqualTo(String value) {
            addCriterion("explain <=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLike(String value) {
            addCriterion("explain like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotLike(String value) {
            addCriterion("explain not like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainIn(List<String> values) {
            addCriterion("explain in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotIn(List<String> values) {
            addCriterion("explain not in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainBetween(String value1, String value2) {
            addCriterion("explain between", value1, value2, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotBetween(String value1, String value2) {
            addCriterion("explain not between", value1, value2, "explain");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoIsNull() {
            addCriterion("weather_ico is null");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoIsNotNull() {
            addCriterion("weather_ico is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoEqualTo(String value) {
            addCriterion("weather_ico =", value, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoNotEqualTo(String value) {
            addCriterion("weather_ico <>", value, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoGreaterThan(String value) {
            addCriterion("weather_ico >", value, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoGreaterThanOrEqualTo(String value) {
            addCriterion("weather_ico >=", value, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoLessThan(String value) {
            addCriterion("weather_ico <", value, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoLessThanOrEqualTo(String value) {
            addCriterion("weather_ico <=", value, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoLike(String value) {
            addCriterion("weather_ico like", value, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoNotLike(String value) {
            addCriterion("weather_ico not like", value, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoIn(List<String> values) {
            addCriterion("weather_ico in", values, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoNotIn(List<String> values) {
            addCriterion("weather_ico not in", values, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoBetween(String value1, String value2) {
            addCriterion("weather_ico between", value1, value2, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIcoNotBetween(String value1, String value2) {
            addCriterion("weather_ico not between", value1, value2, "weatherIco");
            return (Criteria) this;
        }

        public Criteria andWeatherIsNull() {
            addCriterion("weather is null");
            return (Criteria) this;
        }

        public Criteria andWeatherIsNotNull() {
            addCriterion("weather is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherEqualTo(String value) {
            addCriterion("weather =", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotEqualTo(String value) {
            addCriterion("weather <>", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherGreaterThan(String value) {
            addCriterion("weather >", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherGreaterThanOrEqualTo(String value) {
            addCriterion("weather >=", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLessThan(String value) {
            addCriterion("weather <", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLessThanOrEqualTo(String value) {
            addCriterion("weather <=", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLike(String value) {
            addCriterion("weather like", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotLike(String value) {
            addCriterion("weather not like", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherIn(List<String> values) {
            addCriterion("weather in", values, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotIn(List<String> values) {
            addCriterion("weather not in", values, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherBetween(String value1, String value2) {
            addCriterion("weather between", value1, value2, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotBetween(String value1, String value2) {
            addCriterion("weather not between", value1, value2, "weather");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<String> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<String> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
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

        public Criteria andGroupIsNull() {
            addCriterion("group is null");
            return (Criteria) this;
        }

        public Criteria andGroupIsNotNull() {
            addCriterion("group is not null");
            return (Criteria) this;
        }

        public Criteria andGroupEqualTo(String value) {
            addCriterion("group =", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupNotEqualTo(String value) {
            addCriterion("group <>", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupGreaterThan(String value) {
            addCriterion("group >", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupGreaterThanOrEqualTo(String value) {
            addCriterion("group >=", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupLessThan(String value) {
            addCriterion("group <", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupLessThanOrEqualTo(String value) {
            addCriterion("group <=", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupLike(String value) {
            addCriterion("group like", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupNotLike(String value) {
            addCriterion("group not like", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupIn(List<String> values) {
            addCriterion("group in", values, "group");
            return (Criteria) this;
        }

        public Criteria andGroupNotIn(List<String> values) {
            addCriterion("group not in", values, "group");
            return (Criteria) this;
        }

        public Criteria andGroupBetween(String value1, String value2) {
            addCriterion("group between", value1, value2, "group");
            return (Criteria) this;
        }

        public Criteria andGroupNotBetween(String value1, String value2) {
            addCriterion("group not between", value1, value2, "group");
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

        public Criteria andSubLeagueIdIsNull() {
            addCriterion("sub_league_id is null");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdIsNotNull() {
            addCriterion("sub_league_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdEqualTo(String value) {
            addCriterion("sub_league_id =", value, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdNotEqualTo(String value) {
            addCriterion("sub_league_id <>", value, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdGreaterThan(String value) {
            addCriterion("sub_league_id >", value, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_league_id >=", value, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdLessThan(String value) {
            addCriterion("sub_league_id <", value, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdLessThanOrEqualTo(String value) {
            addCriterion("sub_league_id <=", value, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdLike(String value) {
            addCriterion("sub_league_id like", value, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdNotLike(String value) {
            addCriterion("sub_league_id not like", value, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdIn(List<String> values) {
            addCriterion("sub_league_id in", values, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdNotIn(List<String> values) {
            addCriterion("sub_league_id not in", values, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdBetween(String value1, String value2) {
            addCriterion("sub_league_id between", value1, value2, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andSubLeagueIdNotBetween(String value1, String value2) {
            addCriterion("sub_league_id not between", value1, value2, "subLeagueId");
            return (Criteria) this;
        }

        public Criteria andYellowIsNull() {
            addCriterion("yellow is null");
            return (Criteria) this;
        }

        public Criteria andYellowIsNotNull() {
            addCriterion("yellow is not null");
            return (Criteria) this;
        }

        public Criteria andYellowEqualTo(String value) {
            addCriterion("yellow =", value, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowNotEqualTo(String value) {
            addCriterion("yellow <>", value, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowGreaterThan(String value) {
            addCriterion("yellow >", value, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowGreaterThanOrEqualTo(String value) {
            addCriterion("yellow >=", value, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowLessThan(String value) {
            addCriterion("yellow <", value, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowLessThanOrEqualTo(String value) {
            addCriterion("yellow <=", value, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowLike(String value) {
            addCriterion("yellow like", value, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowNotLike(String value) {
            addCriterion("yellow not like", value, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowIn(List<String> values) {
            addCriterion("yellow in", values, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowNotIn(List<String> values) {
            addCriterion("yellow not in", values, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowBetween(String value1, String value2) {
            addCriterion("yellow between", value1, value2, "yellow");
            return (Criteria) this;
        }

        public Criteria andYellowNotBetween(String value1, String value2) {
            addCriterion("yellow not between", value1, value2, "yellow");
            return (Criteria) this;
        }

        public Criteria andExplain2IsNull() {
            addCriterion("explain2 is null");
            return (Criteria) this;
        }

        public Criteria andExplain2IsNotNull() {
            addCriterion("explain2 is not null");
            return (Criteria) this;
        }

        public Criteria andExplain2EqualTo(String value) {
            addCriterion("explain2 =", value, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2NotEqualTo(String value) {
            addCriterion("explain2 <>", value, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2GreaterThan(String value) {
            addCriterion("explain2 >", value, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2GreaterThanOrEqualTo(String value) {
            addCriterion("explain2 >=", value, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2LessThan(String value) {
            addCriterion("explain2 <", value, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2LessThanOrEqualTo(String value) {
            addCriterion("explain2 <=", value, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2Like(String value) {
            addCriterion("explain2 like", value, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2NotLike(String value) {
            addCriterion("explain2 not like", value, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2In(List<String> values) {
            addCriterion("explain2 in", values, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2NotIn(List<String> values) {
            addCriterion("explain2 not in", values, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2Between(String value1, String value2) {
            addCriterion("explain2 between", value1, value2, "explain2");
            return (Criteria) this;
        }

        public Criteria andExplain2NotBetween(String value1, String value2) {
            addCriterion("explain2 not between", value1, value2, "explain2");
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