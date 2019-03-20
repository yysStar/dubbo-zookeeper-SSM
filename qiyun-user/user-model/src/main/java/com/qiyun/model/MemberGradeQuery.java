package com.qiyun.model;

import java.util.ArrayList;
import java.util.List;

public class MemberGradeQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberGradeQuery() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("MEMBER_ID =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("MEMBER_ID <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("MEMBER_ID >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEMBER_ID >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("MEMBER_ID <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("MEMBER_ID <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("MEMBER_ID in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("MEMBER_ID not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("MEMBER_ID between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MEMBER_ID not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberAccountIsNull() {
            addCriterion("MEMBER_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andMemberAccountIsNotNull() {
            addCriterion("MEMBER_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andMemberAccountEqualTo(String value) {
            addCriterion("MEMBER_ACCOUNT =", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountNotEqualTo(String value) {
            addCriterion("MEMBER_ACCOUNT <>", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountGreaterThan(String value) {
            addCriterion("MEMBER_ACCOUNT >", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_ACCOUNT >=", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountLessThan(String value) {
            addCriterion("MEMBER_ACCOUNT <", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_ACCOUNT <=", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountLike(String value) {
            addCriterion("MEMBER_ACCOUNT like", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountNotLike(String value) {
            addCriterion("MEMBER_ACCOUNT not like", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountIn(List<String> values) {
            addCriterion("MEMBER_ACCOUNT in", values, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountNotIn(List<String> values) {
            addCriterion("MEMBER_ACCOUNT not in", values, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountBetween(String value1, String value2) {
            addCriterion("MEMBER_ACCOUNT between", value1, value2, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountNotBetween(String value1, String value2) {
            addCriterion("MEMBER_ACCOUNT not between", value1, value2, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointIsNull() {
            addCriterion("IS_RETURN_POINT is null");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointIsNotNull() {
            addCriterion("IS_RETURN_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointEqualTo(Integer value) {
            addCriterion("IS_RETURN_POINT =", value, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointNotEqualTo(Integer value) {
            addCriterion("IS_RETURN_POINT <>", value, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointGreaterThan(Integer value) {
            addCriterion("IS_RETURN_POINT >", value, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_RETURN_POINT >=", value, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointLessThan(Integer value) {
            addCriterion("IS_RETURN_POINT <", value, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointLessThanOrEqualTo(Integer value) {
            addCriterion("IS_RETURN_POINT <=", value, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointIn(List<Integer> values) {
            addCriterion("IS_RETURN_POINT in", values, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointNotIn(List<Integer> values) {
            addCriterion("IS_RETURN_POINT not in", values, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointBetween(Integer value1, Integer value2) {
            addCriterion("IS_RETURN_POINT between", value1, value2, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsReturnPointNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_RETURN_POINT not between", value1, value2, "isReturnPoint");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNull() {
            addCriterion("IS_VIP is null");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNotNull() {
            addCriterion("IS_VIP is not null");
            return (Criteria) this;
        }

        public Criteria andIsVipEqualTo(Integer value) {
            addCriterion("IS_VIP =", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotEqualTo(Integer value) {
            addCriterion("IS_VIP <>", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThan(Integer value) {
            addCriterion("IS_VIP >", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_VIP >=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThan(Integer value) {
            addCriterion("IS_VIP <", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThanOrEqualTo(Integer value) {
            addCriterion("IS_VIP <=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipIn(List<Integer> values) {
            addCriterion("IS_VIP in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotIn(List<Integer> values) {
            addCriterion("IS_VIP not in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipBetween(Integer value1, Integer value2) {
            addCriterion("IS_VIP between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_VIP not between", value1, value2, "isVip");
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