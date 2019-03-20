package com.qiyun.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TicketNotifySpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketNotifySpExample() {
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

        public Criteria andMatchIdIsNull() {
            addCriterion("match_id is null");
            return (Criteria) this;
        }

        public Criteria andMatchIdIsNotNull() {
            addCriterion("match_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatchIdEqualTo(String value) {
            addCriterion("match_id =", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotEqualTo(String value) {
            addCriterion("match_id <>", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThan(String value) {
            addCriterion("match_id >", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("match_id >=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThan(String value) {
            addCriterion("match_id <", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThanOrEqualTo(String value) {
            addCriterion("match_id <=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLike(String value) {
            addCriterion("match_id like", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotLike(String value) {
            addCriterion("match_id not like", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdIn(List<String> values) {
            addCriterion("match_id in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotIn(List<String> values) {
            addCriterion("match_id not in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdBetween(String value1, String value2) {
            addCriterion("match_id between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotBetween(String value1, String value2) {
            addCriterion("match_id not between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andVsTypeIsNull() {
            addCriterion("vs_type is null");
            return (Criteria) this;
        }

        public Criteria andVsTypeIsNotNull() {
            addCriterion("vs_type is not null");
            return (Criteria) this;
        }

        public Criteria andVsTypeEqualTo(String value) {
            addCriterion("vs_type =", value, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeNotEqualTo(String value) {
            addCriterion("vs_type <>", value, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeGreaterThan(String value) {
            addCriterion("vs_type >", value, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("vs_type >=", value, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeLessThan(String value) {
            addCriterion("vs_type <", value, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeLessThanOrEqualTo(String value) {
            addCriterion("vs_type <=", value, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeLike(String value) {
            addCriterion("vs_type like", value, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeNotLike(String value) {
            addCriterion("vs_type not like", value, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeIn(List<String> values) {
            addCriterion("vs_type in", values, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeNotIn(List<String> values) {
            addCriterion("vs_type not in", values, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeBetween(String value1, String value2) {
            addCriterion("vs_type between", value1, value2, "vsType");
            return (Criteria) this;
        }

        public Criteria andVsTypeNotBetween(String value1, String value2) {
            addCriterion("vs_type not between", value1, value2, "vsType");
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

        public Criteria andLetPointEqualTo(String value) {
            addCriterion("let_point =", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointNotEqualTo(String value) {
            addCriterion("let_point <>", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointGreaterThan(String value) {
            addCriterion("let_point >", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointGreaterThanOrEqualTo(String value) {
            addCriterion("let_point >=", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointLessThan(String value) {
            addCriterion("let_point <", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointLessThanOrEqualTo(String value) {
            addCriterion("let_point <=", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointLike(String value) {
            addCriterion("let_point like", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointNotLike(String value) {
            addCriterion("let_point not like", value, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointIn(List<String> values) {
            addCriterion("let_point in", values, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointNotIn(List<String> values) {
            addCriterion("let_point not in", values, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointBetween(String value1, String value2) {
            addCriterion("let_point between", value1, value2, "letPoint");
            return (Criteria) this;
        }

        public Criteria andLetPointNotBetween(String value1, String value2) {
            addCriterion("let_point not between", value1, value2, "letPoint");
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