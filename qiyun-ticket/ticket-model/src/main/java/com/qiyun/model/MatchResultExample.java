package com.qiyun.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MatchResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MatchResultExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCancelIsNull() {
            addCriterion("cancel is null");
            return (Criteria) this;
        }

        public Criteria andCancelIsNotNull() {
            addCriterion("cancel is not null");
            return (Criteria) this;
        }

        public Criteria andCancelEqualTo(Integer value) {
            addCriterion("cancel =", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelNotEqualTo(Integer value) {
            addCriterion("cancel <>", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelGreaterThan(Integer value) {
            addCriterion("cancel >", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelGreaterThanOrEqualTo(Integer value) {
            addCriterion("cancel >=", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelLessThan(Integer value) {
            addCriterion("cancel <", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelLessThanOrEqualTo(Integer value) {
            addCriterion("cancel <=", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelIn(List<Integer> values) {
            addCriterion("cancel in", values, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelNotIn(List<Integer> values) {
            addCriterion("cancel not in", values, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelBetween(Integer value1, Integer value2) {
            addCriterion("cancel between", value1, value2, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelNotBetween(Integer value1, Integer value2) {
            addCriterion("cancel not between", value1, value2, "cancel");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(String value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(String value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(String value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(String value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(String value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(String value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLike(String value) {
            addCriterion("day like", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotLike(String value) {
            addCriterion("day not like", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<String> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<String> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(String value1, String value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(String value1, String value2) {
            addCriterion("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andWeekIdIsNull() {
            addCriterion("week_id is null");
            return (Criteria) this;
        }

        public Criteria andWeekIdIsNotNull() {
            addCriterion("week_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeekIdEqualTo(Integer value) {
            addCriterion("week_id =", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotEqualTo(Integer value) {
            addCriterion("week_id <>", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdGreaterThan(Integer value) {
            addCriterion("week_id >", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_id >=", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdLessThan(Integer value) {
            addCriterion("week_id <", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdLessThanOrEqualTo(Integer value) {
            addCriterion("week_id <=", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdIn(List<Integer> values) {
            addCriterion("week_id in", values, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotIn(List<Integer> values) {
            addCriterion("week_id not in", values, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdBetween(Integer value1, Integer value2) {
            addCriterion("week_id between", value1, value2, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotBetween(Integer value1, Integer value2) {
            addCriterion("week_id not between", value1, value2, "weekId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(String value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(String value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(String value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(String value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(String value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(String value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLike(String value) {
            addCriterion("team_id like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotLike(String value) {
            addCriterion("team_id not like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<String> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<String> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(String value1, String value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(String value1, String value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andLetPointIsNull() {
            addCriterion("let_point is null");
            return (Criteria) this;
        }

        public Criteria andLetPointIsNotNull() {
            addCriterion("let_point is not null");
            return (Criteria) this;
        }

        public Criteria andLetPointEqualTo(Integer value) {
            addCriterion("let_point =", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointNotEqualTo(Integer value) {
            addCriterion("let_point <>", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointGreaterThan(Integer value) {
            addCriterion("let_point >", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("let_point >=", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointLessThan(Integer value) {
            addCriterion("let_point <", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointLessThanOrEqualTo(Integer value) {
            addCriterion("let_point <=", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointIn(List<Integer> values) {
            addCriterion("let_point in", values, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointNotIn(List<Integer> values) {
            addCriterion("let_point not in", values, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointBetween(Integer value1, Integer value2) {
            addCriterion("let_point between", value1, value2, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointNotBetween(Integer value1, Integer value2) {
            addCriterion("let_point not between", value1, value2, "letPoint");
            return (Criteria) this;
        }

        public Criteria andBasePointIsNull() {
            addCriterion("base_point is null");
            return (Criteria) this;
        }

        public Criteria andBasePointIsNotNull() {
            addCriterion("base_point is not null");
            return (Criteria) this;
        }

        public Criteria andBasePointEqualTo(Integer value) {
            addCriterion("base_point =", value, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointNotEqualTo(Integer value) {
            addCriterion("base_point <>", value, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointGreaterThan(Integer value) {
            addCriterion("base_point >", value, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_point >=", value, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointLessThan(Integer value) {
            addCriterion("base_point <", value, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointLessThanOrEqualTo(Integer value) {
            addCriterion("base_point <=", value, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointIn(List<Integer> values) {
            addCriterion("base_point in", values, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointNotIn(List<Integer> values) {
            addCriterion("base_point not in", values, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointBetween(Integer value1, Integer value2) {
            addCriterion("base_point between", value1, value2, "basePoint");
            return (Criteria) this;
        }

        public Criteria andBasePointNotBetween(Integer value1, Integer value2) {
            addCriterion("base_point not between", value1, value2, "basePoint");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andHalfResultIsNull() {
            addCriterion("half_result is null");
            return (Criteria) this;
        }

        public Criteria andHalfResultIsNotNull() {
            addCriterion("half_result is not null");
            return (Criteria) this;
        }

        public Criteria andHalfResultEqualTo(String value) {
            addCriterion("half_result =", value, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultNotEqualTo(String value) {
            addCriterion("half_result <>", value, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultGreaterThan(String value) {
            addCriterion("half_result >", value, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultGreaterThanOrEqualTo(String value) {
            addCriterion("half_result >=", value, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultLessThan(String value) {
            addCriterion("half_result <", value, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultLessThanOrEqualTo(String value) {
            addCriterion("half_result <=", value, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultLike(String value) {
            addCriterion("half_result like", value, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultNotLike(String value) {
            addCriterion("half_result not like", value, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultIn(List<String> values) {
            addCriterion("half_result in", values, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultNotIn(List<String> values) {
            addCriterion("half_result not in", values, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultBetween(String value1, String value2) {
            addCriterion("half_result between", value1, value2, "halfResult");
            return (Criteria) this;
        }

        public Criteria andHalfResultNotBetween(String value1, String value2) {
            addCriterion("half_result not between", value1, value2, "halfResult");
            return (Criteria) this;
        }

        public Criteria andB0IsNull() {
            addCriterion("b0 is null");
            return (Criteria) this;
        }

        public Criteria andB0IsNotNull() {
            addCriterion("b0 is not null");
            return (Criteria) this;
        }

        public Criteria andB0EqualTo(BigDecimal value) {
            addCriterion("b0 =", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0NotEqualTo(BigDecimal value) {
            addCriterion("b0 <>", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0GreaterThan(BigDecimal value) {
            addCriterion("b0 >", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b0 >=", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0LessThan(BigDecimal value) {
            addCriterion("b0 <", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0LessThanOrEqualTo(BigDecimal value) {
            addCriterion("b0 <=", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0In(List<BigDecimal> values) {
            addCriterion("b0 in", values, "b0");
            return (Criteria) this;
        }

        public Criteria andB0NotIn(List<BigDecimal> values) {
            addCriterion("b0 not in", values, "b0");
            return (Criteria) this;
        }

        public Criteria andB0Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("b0 between", value1, value2, "b0");
            return (Criteria) this;
        }

        public Criteria andB0NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b0 not between", value1, value2, "b0");
            return (Criteria) this;
        }

        public Criteria andB1IsNull() {
            addCriterion("b1 is null");
            return (Criteria) this;
        }

        public Criteria andB1IsNotNull() {
            addCriterion("b1 is not null");
            return (Criteria) this;
        }

        public Criteria andB1EqualTo(BigDecimal value) {
            addCriterion("b1 =", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotEqualTo(BigDecimal value) {
            addCriterion("b1 <>", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1GreaterThan(BigDecimal value) {
            addCriterion("b1 >", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b1 >=", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1LessThan(BigDecimal value) {
            addCriterion("b1 <", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("b1 <=", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1In(List<BigDecimal> values) {
            addCriterion("b1 in", values, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotIn(List<BigDecimal> values) {
            addCriterion("b1 not in", values, "b1");
            return (Criteria) this;
        }

        public Criteria andB1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("b1 between", value1, value2, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b1 not between", value1, value2, "b1");
            return (Criteria) this;
        }

        public Criteria andB2IsNull() {
            addCriterion("b2 is null");
            return (Criteria) this;
        }

        public Criteria andB2IsNotNull() {
            addCriterion("b2 is not null");
            return (Criteria) this;
        }

        public Criteria andB2EqualTo(BigDecimal value) {
            addCriterion("b2 =", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotEqualTo(BigDecimal value) {
            addCriterion("b2 <>", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2GreaterThan(BigDecimal value) {
            addCriterion("b2 >", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b2 >=", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2LessThan(BigDecimal value) {
            addCriterion("b2 <", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("b2 <=", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2In(List<BigDecimal> values) {
            addCriterion("b2 in", values, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotIn(List<BigDecimal> values) {
            addCriterion("b2 not in", values, "b2");
            return (Criteria) this;
        }

        public Criteria andB2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("b2 between", value1, value2, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b2 not between", value1, value2, "b2");
            return (Criteria) this;
        }

        public Criteria andB3IsNull() {
            addCriterion("b3 is null");
            return (Criteria) this;
        }

        public Criteria andB3IsNotNull() {
            addCriterion("b3 is not null");
            return (Criteria) this;
        }

        public Criteria andB3EqualTo(BigDecimal value) {
            addCriterion("b3 =", value, "b3");
            return (Criteria) this;
        }

        public Criteria andB3NotEqualTo(BigDecimal value) {
            addCriterion("b3 <>", value, "b3");
            return (Criteria) this;
        }

        public Criteria andB3GreaterThan(BigDecimal value) {
            addCriterion("b3 >", value, "b3");
            return (Criteria) this;
        }

        public Criteria andB3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b3 >=", value, "b3");
            return (Criteria) this;
        }

        public Criteria andB3LessThan(BigDecimal value) {
            addCriterion("b3 <", value, "b3");
            return (Criteria) this;
        }

        public Criteria andB3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("b3 <=", value, "b3");
            return (Criteria) this;
        }

        public Criteria andB3In(List<BigDecimal> values) {
            addCriterion("b3 in", values, "b3");
            return (Criteria) this;
        }

        public Criteria andB3NotIn(List<BigDecimal> values) {
            addCriterion("b3 not in", values, "b3");
            return (Criteria) this;
        }

        public Criteria andB3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("b3 between", value1, value2, "b3");
            return (Criteria) this;
        }

        public Criteria andB3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b3 not between", value1, value2, "b3");
            return (Criteria) this;
        }

        public Criteria andB4IsNull() {
            addCriterion("b4 is null");
            return (Criteria) this;
        }

        public Criteria andB4IsNotNull() {
            addCriterion("b4 is not null");
            return (Criteria) this;
        }

        public Criteria andB4EqualTo(BigDecimal value) {
            addCriterion("b4 =", value, "b4");
            return (Criteria) this;
        }

        public Criteria andB4NotEqualTo(BigDecimal value) {
            addCriterion("b4 <>", value, "b4");
            return (Criteria) this;
        }

        public Criteria andB4GreaterThan(BigDecimal value) {
            addCriterion("b4 >", value, "b4");
            return (Criteria) this;
        }

        public Criteria andB4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b4 >=", value, "b4");
            return (Criteria) this;
        }

        public Criteria andB4LessThan(BigDecimal value) {
            addCriterion("b4 <", value, "b4");
            return (Criteria) this;
        }

        public Criteria andB4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("b4 <=", value, "b4");
            return (Criteria) this;
        }

        public Criteria andB4In(List<BigDecimal> values) {
            addCriterion("b4 in", values, "b4");
            return (Criteria) this;
        }

        public Criteria andB4NotIn(List<BigDecimal> values) {
            addCriterion("b4 not in", values, "b4");
            return (Criteria) this;
        }

        public Criteria andB4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("b4 between", value1, value2, "b4");
            return (Criteria) this;
        }

        public Criteria andB4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b4 not between", value1, value2, "b4");
            return (Criteria) this;
        }

        public Criteria andB5IsNull() {
            addCriterion("b5 is null");
            return (Criteria) this;
        }

        public Criteria andB5IsNotNull() {
            addCriterion("b5 is not null");
            return (Criteria) this;
        }

        public Criteria andB5EqualTo(BigDecimal value) {
            addCriterion("b5 =", value, "b5");
            return (Criteria) this;
        }

        public Criteria andB5NotEqualTo(BigDecimal value) {
            addCriterion("b5 <>", value, "b5");
            return (Criteria) this;
        }

        public Criteria andB5GreaterThan(BigDecimal value) {
            addCriterion("b5 >", value, "b5");
            return (Criteria) this;
        }

        public Criteria andB5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b5 >=", value, "b5");
            return (Criteria) this;
        }

        public Criteria andB5LessThan(BigDecimal value) {
            addCriterion("b5 <", value, "b5");
            return (Criteria) this;
        }

        public Criteria andB5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("b5 <=", value, "b5");
            return (Criteria) this;
        }

        public Criteria andB5In(List<BigDecimal> values) {
            addCriterion("b5 in", values, "b5");
            return (Criteria) this;
        }

        public Criteria andB5NotIn(List<BigDecimal> values) {
            addCriterion("b5 not in", values, "b5");
            return (Criteria) this;
        }

        public Criteria andB5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("b5 between", value1, value2, "b5");
            return (Criteria) this;
        }

        public Criteria andB5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b5 not between", value1, value2, "b5");
            return (Criteria) this;
        }

        public Criteria andB6IsNull() {
            addCriterion("b6 is null");
            return (Criteria) this;
        }

        public Criteria andB6IsNotNull() {
            addCriterion("b6 is not null");
            return (Criteria) this;
        }

        public Criteria andB6EqualTo(BigDecimal value) {
            addCriterion("b6 =", value, "b6");
            return (Criteria) this;
        }

        public Criteria andB6NotEqualTo(BigDecimal value) {
            addCriterion("b6 <>", value, "b6");
            return (Criteria) this;
        }

        public Criteria andB6GreaterThan(BigDecimal value) {
            addCriterion("b6 >", value, "b6");
            return (Criteria) this;
        }

        public Criteria andB6GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b6 >=", value, "b6");
            return (Criteria) this;
        }

        public Criteria andB6LessThan(BigDecimal value) {
            addCriterion("b6 <", value, "b6");
            return (Criteria) this;
        }

        public Criteria andB6LessThanOrEqualTo(BigDecimal value) {
            addCriterion("b6 <=", value, "b6");
            return (Criteria) this;
        }

        public Criteria andB6In(List<BigDecimal> values) {
            addCriterion("b6 in", values, "b6");
            return (Criteria) this;
        }

        public Criteria andB6NotIn(List<BigDecimal> values) {
            addCriterion("b6 not in", values, "b6");
            return (Criteria) this;
        }

        public Criteria andB6Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("b6 between", value1, value2, "b6");
            return (Criteria) this;
        }

        public Criteria andB6NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b6 not between", value1, value2, "b6");
            return (Criteria) this;
        }

        public Criteria andB7IsNull() {
            addCriterion("b7 is null");
            return (Criteria) this;
        }

        public Criteria andB7IsNotNull() {
            addCriterion("b7 is not null");
            return (Criteria) this;
        }

        public Criteria andB7EqualTo(BigDecimal value) {
            addCriterion("b7 =", value, "b7");
            return (Criteria) this;
        }

        public Criteria andB7NotEqualTo(BigDecimal value) {
            addCriterion("b7 <>", value, "b7");
            return (Criteria) this;
        }

        public Criteria andB7GreaterThan(BigDecimal value) {
            addCriterion("b7 >", value, "b7");
            return (Criteria) this;
        }

        public Criteria andB7GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b7 >=", value, "b7");
            return (Criteria) this;
        }

        public Criteria andB7LessThan(BigDecimal value) {
            addCriterion("b7 <", value, "b7");
            return (Criteria) this;
        }

        public Criteria andB7LessThanOrEqualTo(BigDecimal value) {
            addCriterion("b7 <=", value, "b7");
            return (Criteria) this;
        }

        public Criteria andB7In(List<BigDecimal> values) {
            addCriterion("b7 in", values, "b7");
            return (Criteria) this;
        }

        public Criteria andB7NotIn(List<BigDecimal> values) {
            addCriterion("b7 not in", values, "b7");
            return (Criteria) this;
        }

        public Criteria andB7Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("b7 between", value1, value2, "b7");
            return (Criteria) this;
        }

        public Criteria andB7NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b7 not between", value1, value2, "b7");
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