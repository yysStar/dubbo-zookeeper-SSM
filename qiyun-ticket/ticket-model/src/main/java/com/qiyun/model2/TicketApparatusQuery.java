package com.qiyun.model2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TicketApparatusQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketApparatusQuery() {
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

        public Criteria andAbleBalanceIsNull() {
            addCriterion("able_balance is null");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceIsNotNull() {
            addCriterion("able_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceEqualTo(BigDecimal value) {
            addCriterion("able_balance =", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceNotEqualTo(BigDecimal value) {
            addCriterion("able_balance <>", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceGreaterThan(BigDecimal value) {
            addCriterion("able_balance >", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("able_balance >=", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceLessThan(BigDecimal value) {
            addCriterion("able_balance <", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("able_balance <=", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceIn(List<BigDecimal> values) {
            addCriterion("able_balance in", values, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceNotIn(List<BigDecimal> values) {
            addCriterion("able_balance not in", values, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("able_balance between", value1, value2, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("able_balance not between", value1, value2, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceIsNull() {
            addCriterion("heap_add_balance is null");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceIsNotNull() {
            addCriterion("heap_add_balance is not null");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceEqualTo(BigDecimal value) {
            addCriterion("heap_add_balance =", value, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceNotEqualTo(BigDecimal value) {
            addCriterion("heap_add_balance <>", value, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceGreaterThan(BigDecimal value) {
            addCriterion("heap_add_balance >", value, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("heap_add_balance >=", value, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceLessThan(BigDecimal value) {
            addCriterion("heap_add_balance <", value, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("heap_add_balance <=", value, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceIn(List<BigDecimal> values) {
            addCriterion("heap_add_balance in", values, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceNotIn(List<BigDecimal> values) {
            addCriterion("heap_add_balance not in", values, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("heap_add_balance between", value1, value2, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andHeapAddBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("heap_add_balance not between", value1, value2, "heapAddBalance");
            return (Criteria) this;
        }

        public Criteria andBonusIsNull() {
            addCriterion("bonus is null");
            return (Criteria) this;
        }

        public Criteria andBonusIsNotNull() {
            addCriterion("bonus is not null");
            return (Criteria) this;
        }

        public Criteria andBonusEqualTo(BigDecimal value) {
            addCriterion("bonus =", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotEqualTo(BigDecimal value) {
            addCriterion("bonus <>", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThan(BigDecimal value) {
            addCriterion("bonus >", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus >=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThan(BigDecimal value) {
            addCriterion("bonus <", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus <=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusIn(List<BigDecimal> values) {
            addCriterion("bonus in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotIn(List<BigDecimal> values) {
            addCriterion("bonus not in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus not between", value1, value2, "bonus");
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