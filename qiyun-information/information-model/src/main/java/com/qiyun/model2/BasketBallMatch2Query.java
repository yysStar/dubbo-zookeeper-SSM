package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasketBallMatch2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasketBallMatch2Query() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMatchNameIsNull() {
            addCriterion("match_name is null");
            return (Criteria) this;
        }

        public Criteria andMatchNameIsNotNull() {
            addCriterion("match_name is not null");
            return (Criteria) this;
        }

        public Criteria andMatchNameEqualTo(String value) {
            addCriterion("match_name =", value, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameNotEqualTo(String value) {
            addCriterion("match_name <>", value, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameGreaterThan(String value) {
            addCriterion("match_name >", value, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameGreaterThanOrEqualTo(String value) {
            addCriterion("match_name >=", value, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameLessThan(String value) {
            addCriterion("match_name <", value, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameLessThanOrEqualTo(String value) {
            addCriterion("match_name <=", value, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameLike(String value) {
            addCriterion("match_name like", value, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameNotLike(String value) {
            addCriterion("match_name not like", value, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameIn(List<String> values) {
            addCriterion("match_name in", values, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameNotIn(List<String> values) {
            addCriterion("match_name not in", values, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameBetween(String value1, String value2) {
            addCriterion("match_name between", value1, value2, "matchName");
            return (Criteria) this;
        }

        public Criteria andMatchNameNotBetween(String value1, String value2) {
            addCriterion("match_name not between", value1, value2, "matchName");
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

        public Criteria andHomeIdIsNull() {
            addCriterion("home_id is null");
            return (Criteria) this;
        }

        public Criteria andHomeIdIsNotNull() {
            addCriterion("home_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomeIdEqualTo(Integer value) {
            addCriterion("home_id =", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotEqualTo(Integer value) {
            addCriterion("home_id <>", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdGreaterThan(Integer value) {
            addCriterion("home_id >", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_id >=", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLessThan(Integer value) {
            addCriterion("home_id <", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLessThanOrEqualTo(Integer value) {
            addCriterion("home_id <=", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdIn(List<Integer> values) {
            addCriterion("home_id in", values, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotIn(List<Integer> values) {
            addCriterion("home_id not in", values, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdBetween(Integer value1, Integer value2) {
            addCriterion("home_id between", value1, value2, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("home_id not between", value1, value2, "homeId");
            return (Criteria) this;
        }

        public Criteria andGuestIsNull() {
            addCriterion("guest is null");
            return (Criteria) this;
        }

        public Criteria andGuestIsNotNull() {
            addCriterion("guest is not null");
            return (Criteria) this;
        }

        public Criteria andGuestEqualTo(String value) {
            addCriterion("guest =", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotEqualTo(String value) {
            addCriterion("guest <>", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestGreaterThan(String value) {
            addCriterion("guest >", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestGreaterThanOrEqualTo(String value) {
            addCriterion("guest >=", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestLessThan(String value) {
            addCriterion("guest <", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestLessThanOrEqualTo(String value) {
            addCriterion("guest <=", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestLike(String value) {
            addCriterion("guest like", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotLike(String value) {
            addCriterion("guest not like", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestIn(List<String> values) {
            addCriterion("guest in", values, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotIn(List<String> values) {
            addCriterion("guest not in", values, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestBetween(String value1, String value2) {
            addCriterion("guest between", value1, value2, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotBetween(String value1, String value2) {
            addCriterion("guest not between", value1, value2, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestIdIsNull() {
            addCriterion("guest_id is null");
            return (Criteria) this;
        }

        public Criteria andGuestIdIsNotNull() {
            addCriterion("guest_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuestIdEqualTo(Integer value) {
            addCriterion("guest_id =", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotEqualTo(Integer value) {
            addCriterion("guest_id <>", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdGreaterThan(Integer value) {
            addCriterion("guest_id >", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guest_id >=", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdLessThan(Integer value) {
            addCriterion("guest_id <", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdLessThanOrEqualTo(Integer value) {
            addCriterion("guest_id <=", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdIn(List<Integer> values) {
            addCriterion("guest_id in", values, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotIn(List<Integer> values) {
            addCriterion("guest_id not in", values, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdBetween(Integer value1, Integer value2) {
            addCriterion("guest_id between", value1, value2, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guest_id not between", value1, value2, "guestId");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIsNull() {
            addCriterion("match_time is null");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIsNotNull() {
            addCriterion("match_time is not null");
            return (Criteria) this;
        }

        public Criteria andMatchTimeEqualTo(Date value) {
            addCriterion("match_time =", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotEqualTo(Date value) {
            addCriterion("match_time <>", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeGreaterThan(Date value) {
            addCriterion("match_time >", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("match_time >=", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLessThan(Date value) {
            addCriterion("match_time <", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLessThanOrEqualTo(Date value) {
            addCriterion("match_time <=", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIn(List<Date> values) {
            addCriterion("match_time in", values, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotIn(List<Date> values) {
            addCriterion("match_time not in", values, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeBetween(Date value1, Date value2) {
            addCriterion("match_time between", value1, value2, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotBetween(Date value1, Date value2) {
            addCriterion("match_time not between", value1, value2, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrIsNull() {
            addCriterion("match_date_str is null");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrIsNotNull() {
            addCriterion("match_date_str is not null");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrEqualTo(String value) {
            addCriterion("match_date_str =", value, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrNotEqualTo(String value) {
            addCriterion("match_date_str <>", value, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrGreaterThan(String value) {
            addCriterion("match_date_str >", value, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrGreaterThanOrEqualTo(String value) {
            addCriterion("match_date_str >=", value, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrLessThan(String value) {
            addCriterion("match_date_str <", value, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrLessThanOrEqualTo(String value) {
            addCriterion("match_date_str <=", value, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrLike(String value) {
            addCriterion("match_date_str like", value, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrNotLike(String value) {
            addCriterion("match_date_str not like", value, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrIn(List<String> values) {
            addCriterion("match_date_str in", values, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrNotIn(List<String> values) {
            addCriterion("match_date_str not in", values, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrBetween(String value1, String value2) {
            addCriterion("match_date_str between", value1, value2, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andMatchDateStrNotBetween(String value1, String value2) {
            addCriterion("match_date_str not between", value1, value2, "matchDateStr");
            return (Criteria) this;
        }

        public Criteria andBfWholeIsNull() {
            addCriterion("bf_whole is null");
            return (Criteria) this;
        }

        public Criteria andBfWholeIsNotNull() {
            addCriterion("bf_whole is not null");
            return (Criteria) this;
        }

        public Criteria andBfWholeEqualTo(String value) {
            addCriterion("bf_whole =", value, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeNotEqualTo(String value) {
            addCriterion("bf_whole <>", value, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeGreaterThan(String value) {
            addCriterion("bf_whole >", value, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeGreaterThanOrEqualTo(String value) {
            addCriterion("bf_whole >=", value, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeLessThan(String value) {
            addCriterion("bf_whole <", value, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeLessThanOrEqualTo(String value) {
            addCriterion("bf_whole <=", value, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeLike(String value) {
            addCriterion("bf_whole like", value, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeNotLike(String value) {
            addCriterion("bf_whole not like", value, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeIn(List<String> values) {
            addCriterion("bf_whole in", values, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeNotIn(List<String> values) {
            addCriterion("bf_whole not in", values, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeBetween(String value1, String value2) {
            addCriterion("bf_whole between", value1, value2, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andBfWholeNotBetween(String value1, String value2) {
            addCriterion("bf_whole not between", value1, value2, "bfWhole");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIsNull() {
            addCriterion("analysis_id is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIsNotNull() {
            addCriterion("analysis_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdEqualTo(String value) {
            addCriterion("analysis_id =", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotEqualTo(String value) {
            addCriterion("analysis_id <>", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdGreaterThan(String value) {
            addCriterion("analysis_id >", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdGreaterThanOrEqualTo(String value) {
            addCriterion("analysis_id >=", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLessThan(String value) {
            addCriterion("analysis_id <", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLessThanOrEqualTo(String value) {
            addCriterion("analysis_id <=", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLike(String value) {
            addCriterion("analysis_id like", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotLike(String value) {
            addCriterion("analysis_id not like", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIn(List<String> values) {
            addCriterion("analysis_id in", values, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotIn(List<String> values) {
            addCriterion("analysis_id not in", values, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdBetween(String value1, String value2) {
            addCriterion("analysis_id between", value1, value2, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotBetween(String value1, String value2) {
            addCriterion("analysis_id not between", value1, value2, "analysisId");
            return (Criteria) this;
        }

        public Criteria andOddIdIsNull() {
            addCriterion("odd_id is null");
            return (Criteria) this;
        }

        public Criteria andOddIdIsNotNull() {
            addCriterion("odd_id is not null");
            return (Criteria) this;
        }

        public Criteria andOddIdEqualTo(String value) {
            addCriterion("odd_id =", value, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdNotEqualTo(String value) {
            addCriterion("odd_id <>", value, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdGreaterThan(String value) {
            addCriterion("odd_id >", value, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdGreaterThanOrEqualTo(String value) {
            addCriterion("odd_id >=", value, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdLessThan(String value) {
            addCriterion("odd_id <", value, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdLessThanOrEqualTo(String value) {
            addCriterion("odd_id <=", value, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdLike(String value) {
            addCriterion("odd_id like", value, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdNotLike(String value) {
            addCriterion("odd_id not like", value, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdIn(List<String> values) {
            addCriterion("odd_id in", values, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdNotIn(List<String> values) {
            addCriterion("odd_id not in", values, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdBetween(String value1, String value2) {
            addCriterion("odd_id between", value1, value2, "oddId");
            return (Criteria) this;
        }

        public Criteria andOddIdNotBetween(String value1, String value2) {
            addCriterion("odd_id not between", value1, value2, "oddId");
            return (Criteria) this;
        }

        public Criteria andHomePmIsNull() {
            addCriterion("HOME_PM is null");
            return (Criteria) this;
        }

        public Criteria andHomePmIsNotNull() {
            addCriterion("HOME_PM is not null");
            return (Criteria) this;
        }

        public Criteria andHomePmEqualTo(String value) {
            addCriterion("HOME_PM =", value, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmNotEqualTo(String value) {
            addCriterion("HOME_PM <>", value, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmGreaterThan(String value) {
            addCriterion("HOME_PM >", value, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmGreaterThanOrEqualTo(String value) {
            addCriterion("HOME_PM >=", value, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmLessThan(String value) {
            addCriterion("HOME_PM <", value, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmLessThanOrEqualTo(String value) {
            addCriterion("HOME_PM <=", value, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmLike(String value) {
            addCriterion("HOME_PM like", value, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmNotLike(String value) {
            addCriterion("HOME_PM not like", value, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmIn(List<String> values) {
            addCriterion("HOME_PM in", values, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmNotIn(List<String> values) {
            addCriterion("HOME_PM not in", values, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmBetween(String value1, String value2) {
            addCriterion("HOME_PM between", value1, value2, "homePm");
            return (Criteria) this;
        }

        public Criteria andHomePmNotBetween(String value1, String value2) {
            addCriterion("HOME_PM not between", value1, value2, "homePm");
            return (Criteria) this;
        }

        public Criteria andGuestPmIsNull() {
            addCriterion("GUEST_PM is null");
            return (Criteria) this;
        }

        public Criteria andGuestPmIsNotNull() {
            addCriterion("GUEST_PM is not null");
            return (Criteria) this;
        }

        public Criteria andGuestPmEqualTo(String value) {
            addCriterion("GUEST_PM =", value, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmNotEqualTo(String value) {
            addCriterion("GUEST_PM <>", value, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmGreaterThan(String value) {
            addCriterion("GUEST_PM >", value, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmGreaterThanOrEqualTo(String value) {
            addCriterion("GUEST_PM >=", value, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmLessThan(String value) {
            addCriterion("GUEST_PM <", value, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmLessThanOrEqualTo(String value) {
            addCriterion("GUEST_PM <=", value, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmLike(String value) {
            addCriterion("GUEST_PM like", value, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmNotLike(String value) {
            addCriterion("GUEST_PM not like", value, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmIn(List<String> values) {
            addCriterion("GUEST_PM in", values, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmNotIn(List<String> values) {
            addCriterion("GUEST_PM not in", values, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmBetween(String value1, String value2) {
            addCriterion("GUEST_PM between", value1, value2, "guestPm");
            return (Criteria) this;
        }

        public Criteria andGuestPmNotBetween(String value1, String value2) {
            addCriterion("GUEST_PM not between", value1, value2, "guestPm");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreIsNull() {
            addCriterion("final_home_score is null");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreIsNotNull() {
            addCriterion("final_home_score is not null");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreEqualTo(Integer value) {
            addCriterion("final_home_score =", value, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreNotEqualTo(Integer value) {
            addCriterion("final_home_score <>", value, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreGreaterThan(Integer value) {
            addCriterion("final_home_score >", value, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("final_home_score >=", value, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreLessThan(Integer value) {
            addCriterion("final_home_score <", value, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreLessThanOrEqualTo(Integer value) {
            addCriterion("final_home_score <=", value, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreIn(List<Integer> values) {
            addCriterion("final_home_score in", values, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreNotIn(List<Integer> values) {
            addCriterion("final_home_score not in", values, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreBetween(Integer value1, Integer value2) {
            addCriterion("final_home_score between", value1, value2, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalHomeScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("final_home_score not between", value1, value2, "finalHomeScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreIsNull() {
            addCriterion("final_guest_score is null");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreIsNotNull() {
            addCriterion("final_guest_score is not null");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreEqualTo(Integer value) {
            addCriterion("final_guest_score =", value, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreNotEqualTo(Integer value) {
            addCriterion("final_guest_score <>", value, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreGreaterThan(Integer value) {
            addCriterion("final_guest_score >", value, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("final_guest_score >=", value, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreLessThan(Integer value) {
            addCriterion("final_guest_score <", value, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreLessThanOrEqualTo(Integer value) {
            addCriterion("final_guest_score <=", value, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreIn(List<Integer> values) {
            addCriterion("final_guest_score in", values, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreNotIn(List<Integer> values) {
            addCriterion("final_guest_score not in", values, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreBetween(Integer value1, Integer value2) {
            addCriterion("final_guest_score between", value1, value2, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFinalGuestScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("final_guest_score not between", value1, value2, "finalGuestScore");
            return (Criteria) this;
        }

        public Criteria andFirstSectionIsNull() {
            addCriterion("FIRST_SECTION is null");
            return (Criteria) this;
        }

        public Criteria andFirstSectionIsNotNull() {
            addCriterion("FIRST_SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSectionEqualTo(String value) {
            addCriterion("FIRST_SECTION =", value, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionNotEqualTo(String value) {
            addCriterion("FIRST_SECTION <>", value, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionGreaterThan(String value) {
            addCriterion("FIRST_SECTION >", value, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionGreaterThanOrEqualTo(String value) {
            addCriterion("FIRST_SECTION >=", value, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionLessThan(String value) {
            addCriterion("FIRST_SECTION <", value, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionLessThanOrEqualTo(String value) {
            addCriterion("FIRST_SECTION <=", value, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionLike(String value) {
            addCriterion("FIRST_SECTION like", value, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionNotLike(String value) {
            addCriterion("FIRST_SECTION not like", value, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionIn(List<String> values) {
            addCriterion("FIRST_SECTION in", values, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionNotIn(List<String> values) {
            addCriterion("FIRST_SECTION not in", values, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionBetween(String value1, String value2) {
            addCriterion("FIRST_SECTION between", value1, value2, "firstSection");
            return (Criteria) this;
        }

        public Criteria andFirstSectionNotBetween(String value1, String value2) {
            addCriterion("FIRST_SECTION not between", value1, value2, "firstSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionIsNull() {
            addCriterion("SECOND_SECTION is null");
            return (Criteria) this;
        }

        public Criteria andSecondSectionIsNotNull() {
            addCriterion("SECOND_SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andSecondSectionEqualTo(String value) {
            addCriterion("SECOND_SECTION =", value, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionNotEqualTo(String value) {
            addCriterion("SECOND_SECTION <>", value, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionGreaterThan(String value) {
            addCriterion("SECOND_SECTION >", value, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionGreaterThanOrEqualTo(String value) {
            addCriterion("SECOND_SECTION >=", value, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionLessThan(String value) {
            addCriterion("SECOND_SECTION <", value, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionLessThanOrEqualTo(String value) {
            addCriterion("SECOND_SECTION <=", value, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionLike(String value) {
            addCriterion("SECOND_SECTION like", value, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionNotLike(String value) {
            addCriterion("SECOND_SECTION not like", value, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionIn(List<String> values) {
            addCriterion("SECOND_SECTION in", values, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionNotIn(List<String> values) {
            addCriterion("SECOND_SECTION not in", values, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionBetween(String value1, String value2) {
            addCriterion("SECOND_SECTION between", value1, value2, "secondSection");
            return (Criteria) this;
        }

        public Criteria andSecondSectionNotBetween(String value1, String value2) {
            addCriterion("SECOND_SECTION not between", value1, value2, "secondSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionIsNull() {
            addCriterion("THIRD_SECTION is null");
            return (Criteria) this;
        }

        public Criteria andThirdSectionIsNotNull() {
            addCriterion("THIRD_SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andThirdSectionEqualTo(String value) {
            addCriterion("THIRD_SECTION =", value, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionNotEqualTo(String value) {
            addCriterion("THIRD_SECTION <>", value, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionGreaterThan(String value) {
            addCriterion("THIRD_SECTION >", value, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionGreaterThanOrEqualTo(String value) {
            addCriterion("THIRD_SECTION >=", value, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionLessThan(String value) {
            addCriterion("THIRD_SECTION <", value, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionLessThanOrEqualTo(String value) {
            addCriterion("THIRD_SECTION <=", value, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionLike(String value) {
            addCriterion("THIRD_SECTION like", value, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionNotLike(String value) {
            addCriterion("THIRD_SECTION not like", value, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionIn(List<String> values) {
            addCriterion("THIRD_SECTION in", values, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionNotIn(List<String> values) {
            addCriterion("THIRD_SECTION not in", values, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionBetween(String value1, String value2) {
            addCriterion("THIRD_SECTION between", value1, value2, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andThirdSectionNotBetween(String value1, String value2) {
            addCriterion("THIRD_SECTION not between", value1, value2, "thirdSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionIsNull() {
            addCriterion("FOURTH_SECTION is null");
            return (Criteria) this;
        }

        public Criteria andFourthSectionIsNotNull() {
            addCriterion("FOURTH_SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andFourthSectionEqualTo(String value) {
            addCriterion("FOURTH_SECTION =", value, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionNotEqualTo(String value) {
            addCriterion("FOURTH_SECTION <>", value, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionGreaterThan(String value) {
            addCriterion("FOURTH_SECTION >", value, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionGreaterThanOrEqualTo(String value) {
            addCriterion("FOURTH_SECTION >=", value, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionLessThan(String value) {
            addCriterion("FOURTH_SECTION <", value, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionLessThanOrEqualTo(String value) {
            addCriterion("FOURTH_SECTION <=", value, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionLike(String value) {
            addCriterion("FOURTH_SECTION like", value, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionNotLike(String value) {
            addCriterion("FOURTH_SECTION not like", value, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionIn(List<String> values) {
            addCriterion("FOURTH_SECTION in", values, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionNotIn(List<String> values) {
            addCriterion("FOURTH_SECTION not in", values, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionBetween(String value1, String value2) {
            addCriterion("FOURTH_SECTION between", value1, value2, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andFourthSectionNotBetween(String value1, String value2) {
            addCriterion("FOURTH_SECTION not between", value1, value2, "fourthSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionIsNull() {
            addCriterion("ADD_SECTION is null");
            return (Criteria) this;
        }

        public Criteria andAddSectionIsNotNull() {
            addCriterion("ADD_SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andAddSectionEqualTo(String value) {
            addCriterion("ADD_SECTION =", value, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionNotEqualTo(String value) {
            addCriterion("ADD_SECTION <>", value, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionGreaterThan(String value) {
            addCriterion("ADD_SECTION >", value, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_SECTION >=", value, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionLessThan(String value) {
            addCriterion("ADD_SECTION <", value, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionLessThanOrEqualTo(String value) {
            addCriterion("ADD_SECTION <=", value, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionLike(String value) {
            addCriterion("ADD_SECTION like", value, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionNotLike(String value) {
            addCriterion("ADD_SECTION not like", value, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionIn(List<String> values) {
            addCriterion("ADD_SECTION in", values, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionNotIn(List<String> values) {
            addCriterion("ADD_SECTION not in", values, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionBetween(String value1, String value2) {
            addCriterion("ADD_SECTION between", value1, value2, "addSection");
            return (Criteria) this;
        }

        public Criteria andAddSectionNotBetween(String value1, String value2) {
            addCriterion("ADD_SECTION not between", value1, value2, "addSection");
            return (Criteria) this;
        }

        public Criteria andInttimeIsNull() {
            addCriterion("INTTIME is null");
            return (Criteria) this;
        }

        public Criteria andInttimeIsNotNull() {
            addCriterion("INTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andInttimeEqualTo(Integer value) {
            addCriterion("INTTIME =", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotEqualTo(Integer value) {
            addCriterion("INTTIME <>", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeGreaterThan(Integer value) {
            addCriterion("INTTIME >", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("INTTIME >=", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeLessThan(Integer value) {
            addCriterion("INTTIME <", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeLessThanOrEqualTo(Integer value) {
            addCriterion("INTTIME <=", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeIn(List<Integer> values) {
            addCriterion("INTTIME in", values, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotIn(List<Integer> values) {
            addCriterion("INTTIME not in", values, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeBetween(Integer value1, Integer value2) {
            addCriterion("INTTIME between", value1, value2, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("INTTIME not between", value1, value2, "inttime");
            return (Criteria) this;
        }

        public Criteria andLineidIsNull() {
            addCriterion("LINEID is null");
            return (Criteria) this;
        }

        public Criteria andLineidIsNotNull() {
            addCriterion("LINEID is not null");
            return (Criteria) this;
        }

        public Criteria andLineidEqualTo(Integer value) {
            addCriterion("LINEID =", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotEqualTo(Integer value) {
            addCriterion("LINEID <>", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThan(Integer value) {
            addCriterion("LINEID >", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LINEID >=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThan(Integer value) {
            addCriterion("LINEID <", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThanOrEqualTo(Integer value) {
            addCriterion("LINEID <=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidIn(List<Integer> values) {
            addCriterion("LINEID in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotIn(List<Integer> values) {
            addCriterion("LINEID not in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidBetween(Integer value1, Integer value2) {
            addCriterion("LINEID between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotBetween(Integer value1, Integer value2) {
            addCriterion("LINEID not between", value1, value2, "lineid");
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