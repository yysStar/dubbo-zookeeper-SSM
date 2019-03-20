package com.qiyun.model2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChampionMatchUpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChampionMatchUpExample() {
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

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andSpIsNull() {
            addCriterion("sp is null");
            return (Criteria) this;
        }

        public Criteria andSpIsNotNull() {
            addCriterion("sp is not null");
            return (Criteria) this;
        }

        public Criteria andSpEqualTo(BigDecimal value) {
            addCriterion("sp =", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotEqualTo(BigDecimal value) {
            addCriterion("sp <>", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpGreaterThan(BigDecimal value) {
            addCriterion("sp >", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sp >=", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpLessThan(BigDecimal value) {
            addCriterion("sp <", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sp <=", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpIn(List<BigDecimal> values) {
            addCriterion("sp in", values, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotIn(List<BigDecimal> values) {
            addCriterion("sp not in", values, "sp");
            return (Criteria) this;
        }

        public Criteria andSpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sp between", value1, value2, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sp not between", value1, value2, "sp");
            return (Criteria) this;
        }

        public Criteria andSupportRateIsNull() {
            addCriterion("support_rate is null");
            return (Criteria) this;
        }

        public Criteria andSupportRateIsNotNull() {
            addCriterion("support_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSupportRateEqualTo(String value) {
            addCriterion("support_rate =", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotEqualTo(String value) {
            addCriterion("support_rate <>", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateGreaterThan(String value) {
            addCriterion("support_rate >", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateGreaterThanOrEqualTo(String value) {
            addCriterion("support_rate >=", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateLessThan(String value) {
            addCriterion("support_rate <", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateLessThanOrEqualTo(String value) {
            addCriterion("support_rate <=", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateLike(String value) {
            addCriterion("support_rate like", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotLike(String value) {
            addCriterion("support_rate not like", value, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateIn(List<String> values) {
            addCriterion("support_rate in", values, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotIn(List<String> values) {
            addCriterion("support_rate not in", values, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateBetween(String value1, String value2) {
            addCriterion("support_rate between", value1, value2, "supportRate");
            return (Criteria) this;
        }

        public Criteria andSupportRateNotBetween(String value1, String value2) {
            addCriterion("support_rate not between", value1, value2, "supportRate");
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

        public Criteria andTeamIdEqualTo(Integer value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Integer value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Integer value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Integer value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Integer> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Integer> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andNationalFlagIsNull() {
            addCriterion("national_flag is null");
            return (Criteria) this;
        }

        public Criteria andNationalFlagIsNotNull() {
            addCriterion("national_flag is not null");
            return (Criteria) this;
        }

        public Criteria andNationalFlagEqualTo(String value) {
            addCriterion("national_flag =", value, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagNotEqualTo(String value) {
            addCriterion("national_flag <>", value, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagGreaterThan(String value) {
            addCriterion("national_flag >", value, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagGreaterThanOrEqualTo(String value) {
            addCriterion("national_flag >=", value, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagLessThan(String value) {
            addCriterion("national_flag <", value, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagLessThanOrEqualTo(String value) {
            addCriterion("national_flag <=", value, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagLike(String value) {
            addCriterion("national_flag like", value, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagNotLike(String value) {
            addCriterion("national_flag not like", value, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagIn(List<String> values) {
            addCriterion("national_flag in", values, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagNotIn(List<String> values) {
            addCriterion("national_flag not in", values, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagBetween(String value1, String value2) {
            addCriterion("national_flag between", value1, value2, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andNationalFlagNotBetween(String value1, String value2) {
            addCriterion("national_flag not between", value1, value2, "nationalFlag");
            return (Criteria) this;
        }

        public Criteria andSellStatusIsNull() {
            addCriterion("sell_status is null");
            return (Criteria) this;
        }

        public Criteria andSellStatusIsNotNull() {
            addCriterion("sell_status is not null");
            return (Criteria) this;
        }

        public Criteria andSellStatusEqualTo(String value) {
            addCriterion("sell_status =", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotEqualTo(String value) {
            addCriterion("sell_status <>", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusGreaterThan(String value) {
            addCriterion("sell_status >", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sell_status >=", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusLessThan(String value) {
            addCriterion("sell_status <", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusLessThanOrEqualTo(String value) {
            addCriterion("sell_status <=", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusLike(String value) {
            addCriterion("sell_status like", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotLike(String value) {
            addCriterion("sell_status not like", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusIn(List<String> values) {
            addCriterion("sell_status in", values, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotIn(List<String> values) {
            addCriterion("sell_status not in", values, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusBetween(String value1, String value2) {
            addCriterion("sell_status between", value1, value2, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotBetween(String value1, String value2) {
            addCriterion("sell_status not between", value1, value2, "sellStatus");
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