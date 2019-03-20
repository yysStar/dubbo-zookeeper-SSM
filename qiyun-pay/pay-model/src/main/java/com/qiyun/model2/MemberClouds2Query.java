package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class MemberClouds2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberClouds2Query() {
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

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("ACCOUNT like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("ACCOUNT not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceIsNull() {
            addCriterion("CLOUDS_ABLE_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceIsNotNull() {
            addCriterion("CLOUDS_ABLE_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceEqualTo(Double value) {
            addCriterion("CLOUDS_ABLE_BALANCE =", value, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceNotEqualTo(Double value) {
            addCriterion("CLOUDS_ABLE_BALANCE <>", value, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceGreaterThan(Double value) {
            addCriterion("CLOUDS_ABLE_BALANCE >", value, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("CLOUDS_ABLE_BALANCE >=", value, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceLessThan(Double value) {
            addCriterion("CLOUDS_ABLE_BALANCE <", value, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceLessThanOrEqualTo(Double value) {
            addCriterion("CLOUDS_ABLE_BALANCE <=", value, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceIn(List<Double> values) {
            addCriterion("CLOUDS_ABLE_BALANCE in", values, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceNotIn(List<Double> values) {
            addCriterion("CLOUDS_ABLE_BALANCE not in", values, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceBetween(Double value1, Double value2) {
            addCriterion("CLOUDS_ABLE_BALANCE between", value1, value2, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andCloudsAbleBalanceNotBetween(Double value1, Double value2) {
            addCriterion("CLOUDS_ABLE_BALANCE not between", value1, value2, "cloudsAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaIsNull() {
            addCriterion("take_cash_quota is null");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaIsNotNull() {
            addCriterion("take_cash_quota is not null");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaEqualTo(Double value) {
            addCriterion("take_cash_quota =", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaNotEqualTo(Double value) {
            addCriterion("take_cash_quota <>", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaGreaterThan(Double value) {
            addCriterion("take_cash_quota >", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaGreaterThanOrEqualTo(Double value) {
            addCriterion("take_cash_quota >=", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaLessThan(Double value) {
            addCriterion("take_cash_quota <", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaLessThanOrEqualTo(Double value) {
            addCriterion("take_cash_quota <=", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaIn(List<Double> values) {
            addCriterion("take_cash_quota in", values, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaNotIn(List<Double> values) {
            addCriterion("take_cash_quota not in", values, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaBetween(Double value1, Double value2) {
            addCriterion("take_cash_quota between", value1, value2, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaNotBetween(Double value1, Double value2) {
            addCriterion("take_cash_quota not between", value1, value2, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIsNull() {
            addCriterion("FREEZE_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIsNotNull() {
            addCriterion("FREEZE_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceEqualTo(Double value) {
            addCriterion("FREEZE_BALANCE =", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotEqualTo(Double value) {
            addCriterion("FREEZE_BALANCE <>", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceGreaterThan(Double value) {
            addCriterion("FREEZE_BALANCE >", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("FREEZE_BALANCE >=", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceLessThan(Double value) {
            addCriterion("FREEZE_BALANCE <", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceLessThanOrEqualTo(Double value) {
            addCriterion("FREEZE_BALANCE <=", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIn(List<Double> values) {
            addCriterion("FREEZE_BALANCE in", values, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotIn(List<Double> values) {
            addCriterion("FREEZE_BALANCE not in", values, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceBetween(Double value1, Double value2) {
            addCriterion("FREEZE_BALANCE between", value1, value2, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotBetween(Double value1, Double value2) {
            addCriterion("FREEZE_BALANCE not between", value1, value2, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceIsNull() {
            addCriterion("HEAP_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceIsNotNull() {
            addCriterion("HEAP_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceEqualTo(Double value) {
            addCriterion("HEAP_BALANCE =", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceNotEqualTo(Double value) {
            addCriterion("HEAP_BALANCE <>", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceGreaterThan(Double value) {
            addCriterion("HEAP_BALANCE >", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("HEAP_BALANCE >=", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceLessThan(Double value) {
            addCriterion("HEAP_BALANCE <", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceLessThanOrEqualTo(Double value) {
            addCriterion("HEAP_BALANCE <=", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceIn(List<Double> values) {
            addCriterion("HEAP_BALANCE in", values, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceNotIn(List<Double> values) {
            addCriterion("HEAP_BALANCE not in", values, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceBetween(Double value1, Double value2) {
            addCriterion("HEAP_BALANCE between", value1, value2, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceNotBetween(Double value1, Double value2) {
            addCriterion("HEAP_BALANCE not between", value1, value2, "heapBalance");
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