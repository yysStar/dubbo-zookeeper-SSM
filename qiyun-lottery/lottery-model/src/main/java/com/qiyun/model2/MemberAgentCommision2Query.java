package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberAgentCommision2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberAgentCommision2Query() {
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

        public Criteria andMemberAgentIdIsNull() {
            addCriterion("MEMBER_AGENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdIsNotNull() {
            addCriterion("MEMBER_AGENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdEqualTo(Integer value) {
            addCriterion("MEMBER_AGENT_ID =", value, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdNotEqualTo(Integer value) {
            addCriterion("MEMBER_AGENT_ID <>", value, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdGreaterThan(Integer value) {
            addCriterion("MEMBER_AGENT_ID >", value, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEMBER_AGENT_ID >=", value, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdLessThan(Integer value) {
            addCriterion("MEMBER_AGENT_ID <", value, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("MEMBER_AGENT_ID <=", value, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdIn(List<Integer> values) {
            addCriterion("MEMBER_AGENT_ID in", values, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdNotIn(List<Integer> values) {
            addCriterion("MEMBER_AGENT_ID not in", values, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("MEMBER_AGENT_ID between", value1, value2, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MEMBER_AGENT_ID not between", value1, value2, "memberAgentId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdIsNull() {
            addCriterion("MEMBER_LOWER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdIsNotNull() {
            addCriterion("MEMBER_LOWER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdEqualTo(Integer value) {
            addCriterion("MEMBER_LOWER_ID =", value, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdNotEqualTo(Integer value) {
            addCriterion("MEMBER_LOWER_ID <>", value, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdGreaterThan(Integer value) {
            addCriterion("MEMBER_LOWER_ID >", value, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEMBER_LOWER_ID >=", value, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdLessThan(Integer value) {
            addCriterion("MEMBER_LOWER_ID <", value, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdLessThanOrEqualTo(Integer value) {
            addCriterion("MEMBER_LOWER_ID <=", value, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdIn(List<Integer> values) {
            addCriterion("MEMBER_LOWER_ID in", values, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdNotIn(List<Integer> values) {
            addCriterion("MEMBER_LOWER_ID not in", values, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdBetween(Integer value1, Integer value2) {
            addCriterion("MEMBER_LOWER_ID between", value1, value2, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andMemberLowerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MEMBER_LOWER_ID not between", value1, value2, "memberLowerId");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionIsNull() {
            addCriterion("AGENT_COMMISION is null");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionIsNotNull() {
            addCriterion("AGENT_COMMISION is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionEqualTo(Double value) {
            addCriterion("AGENT_COMMISION =", value, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionNotEqualTo(Double value) {
            addCriterion("AGENT_COMMISION <>", value, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionGreaterThan(Double value) {
            addCriterion("AGENT_COMMISION >", value, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionGreaterThanOrEqualTo(Double value) {
            addCriterion("AGENT_COMMISION >=", value, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionLessThan(Double value) {
            addCriterion("AGENT_COMMISION <", value, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionLessThanOrEqualTo(Double value) {
            addCriterion("AGENT_COMMISION <=", value, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionIn(List<Double> values) {
            addCriterion("AGENT_COMMISION in", values, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionNotIn(List<Double> values) {
            addCriterion("AGENT_COMMISION not in", values, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionBetween(Double value1, Double value2) {
            addCriterion("AGENT_COMMISION between", value1, value2, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andAgentCommisionNotBetween(Double value1, Double value2) {
            addCriterion("AGENT_COMMISION not between", value1, value2, "agentCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionIsNull() {
            addCriterion("LOWER_COMMISION is null");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionIsNotNull() {
            addCriterion("LOWER_COMMISION is not null");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionEqualTo(Double value) {
            addCriterion("LOWER_COMMISION =", value, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionNotEqualTo(Double value) {
            addCriterion("LOWER_COMMISION <>", value, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionGreaterThan(Double value) {
            addCriterion("LOWER_COMMISION >", value, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionGreaterThanOrEqualTo(Double value) {
            addCriterion("LOWER_COMMISION >=", value, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionLessThan(Double value) {
            addCriterion("LOWER_COMMISION <", value, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionLessThanOrEqualTo(Double value) {
            addCriterion("LOWER_COMMISION <=", value, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionIn(List<Double> values) {
            addCriterion("LOWER_COMMISION in", values, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionNotIn(List<Double> values) {
            addCriterion("LOWER_COMMISION not in", values, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionBetween(Double value1, Double value2) {
            addCriterion("LOWER_COMMISION between", value1, value2, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andLowerCommisionNotBetween(Double value1, Double value2) {
            addCriterion("LOWER_COMMISION not between", value1, value2, "lowerCommision");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNull() {
            addCriterion("PLAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("PLAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Integer value) {
            addCriterion("PLAN_ID =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Integer value) {
            addCriterion("PLAN_ID <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Integer value) {
            addCriterion("PLAN_ID >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAN_ID >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Integer value) {
            addCriterion("PLAN_ID <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("PLAN_ID <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Integer> values) {
            addCriterion("PLAN_ID in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Integer> values) {
            addCriterion("PLAN_ID not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_ID between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_ID not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andAgentRateIsNull() {
            addCriterion("AGENT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andAgentRateIsNotNull() {
            addCriterion("AGENT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andAgentRateEqualTo(Double value) {
            addCriterion("AGENT_RATE =", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotEqualTo(Double value) {
            addCriterion("AGENT_RATE <>", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateGreaterThan(Double value) {
            addCriterion("AGENT_RATE >", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateGreaterThanOrEqualTo(Double value) {
            addCriterion("AGENT_RATE >=", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateLessThan(Double value) {
            addCriterion("AGENT_RATE <", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateLessThanOrEqualTo(Double value) {
            addCriterion("AGENT_RATE <=", value, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateIn(List<Double> values) {
            addCriterion("AGENT_RATE in", values, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotIn(List<Double> values) {
            addCriterion("AGENT_RATE not in", values, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateBetween(Double value1, Double value2) {
            addCriterion("AGENT_RATE between", value1, value2, "agentRate");
            return (Criteria) this;
        }

        public Criteria andAgentRateNotBetween(Double value1, Double value2) {
            addCriterion("AGENT_RATE not between", value1, value2, "agentRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateIsNull() {
            addCriterion("LOWER_RATE is null");
            return (Criteria) this;
        }

        public Criteria andLowerRateIsNotNull() {
            addCriterion("LOWER_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andLowerRateEqualTo(Double value) {
            addCriterion("LOWER_RATE =", value, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateNotEqualTo(Double value) {
            addCriterion("LOWER_RATE <>", value, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateGreaterThan(Double value) {
            addCriterion("LOWER_RATE >", value, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateGreaterThanOrEqualTo(Double value) {
            addCriterion("LOWER_RATE >=", value, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateLessThan(Double value) {
            addCriterion("LOWER_RATE <", value, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateLessThanOrEqualTo(Double value) {
            addCriterion("LOWER_RATE <=", value, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateIn(List<Double> values) {
            addCriterion("LOWER_RATE in", values, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateNotIn(List<Double> values) {
            addCriterion("LOWER_RATE not in", values, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateBetween(Double value1, Double value2) {
            addCriterion("LOWER_RATE between", value1, value2, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andLowerRateNotBetween(Double value1, Double value2) {
            addCriterion("LOWER_RATE not between", value1, value2, "lowerRate");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNull() {
            addCriterion("CREATE_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNotNull() {
            addCriterion("CREATE_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME =", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME <>", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThan(Date value) {
            addCriterion("CREATE_DATE_TIME >", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME >=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThan(Date value) {
            addCriterion("CREATE_DATE_TIME <", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME <=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIn(List<Date> values) {
            addCriterion("CREATE_DATE_TIME in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_DATE_TIME not in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE_TIME between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE_TIME not between", value1, value2, "createDateTime");
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