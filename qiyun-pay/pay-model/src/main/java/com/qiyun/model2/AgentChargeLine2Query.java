package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgentChargeLine2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AgentChargeLine2Query() {
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

        public Criteria andAgentAccountIsNull() {
            addCriterion("agent_account is null");
            return (Criteria) this;
        }

        public Criteria andAgentAccountIsNotNull() {
            addCriterion("agent_account is not null");
            return (Criteria) this;
        }

        public Criteria andAgentAccountEqualTo(String value) {
            addCriterion("agent_account =", value, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountNotEqualTo(String value) {
            addCriterion("agent_account <>", value, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountGreaterThan(String value) {
            addCriterion("agent_account >", value, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountGreaterThanOrEqualTo(String value) {
            addCriterion("agent_account >=", value, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountLessThan(String value) {
            addCriterion("agent_account <", value, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountLessThanOrEqualTo(String value) {
            addCriterion("agent_account <=", value, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountLike(String value) {
            addCriterion("agent_account like", value, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountNotLike(String value) {
            addCriterion("agent_account not like", value, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountIn(List<String> values) {
            addCriterion("agent_account in", values, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountNotIn(List<String> values) {
            addCriterion("agent_account not in", values, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountBetween(String value1, String value2) {
            addCriterion("agent_account between", value1, value2, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAgentAccountNotBetween(String value1, String value2) {
            addCriterion("agent_account not between", value1, value2, "agentAccount");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIsNull() {
            addCriterion("credit_limit_ is null");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIsNotNull() {
            addCriterion("credit_limit_ is not null");
            return (Criteria) this;
        }

        public Criteria andCreditLimitEqualTo(Double value) {
            addCriterion("credit_limit_ =", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotEqualTo(Double value) {
            addCriterion("credit_limit_ <>", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitGreaterThan(Double value) {
            addCriterion("credit_limit_ >", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitGreaterThanOrEqualTo(Double value) {
            addCriterion("credit_limit_ >=", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitLessThan(Double value) {
            addCriterion("credit_limit_ <", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitLessThanOrEqualTo(Double value) {
            addCriterion("credit_limit_ <=", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIn(List<Double> values) {
            addCriterion("credit_limit_ in", values, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotIn(List<Double> values) {
            addCriterion("credit_limit_ not in", values, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitBetween(Double value1, Double value2) {
            addCriterion("credit_limit_ between", value1, value2, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotBetween(Double value1, Double value2) {
            addCriterion("credit_limit_ not between", value1, value2, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceIsNull() {
            addCriterion("able_credit_balance is null");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceIsNotNull() {
            addCriterion("able_credit_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceEqualTo(Double value) {
            addCriterion("able_credit_balance =", value, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceNotEqualTo(Double value) {
            addCriterion("able_credit_balance <>", value, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceGreaterThan(Double value) {
            addCriterion("able_credit_balance >", value, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("able_credit_balance >=", value, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceLessThan(Double value) {
            addCriterion("able_credit_balance <", value, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceLessThanOrEqualTo(Double value) {
            addCriterion("able_credit_balance <=", value, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceIn(List<Double> values) {
            addCriterion("able_credit_balance in", values, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceNotIn(List<Double> values) {
            addCriterion("able_credit_balance not in", values, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceBetween(Double value1, Double value2) {
            addCriterion("able_credit_balance between", value1, value2, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andAbleCreditBalanceNotBetween(Double value1, Double value2) {
            addCriterion("able_credit_balance not between", value1, value2, "ableCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceIsNull() {
            addCriterion("freeze_credit_balance is null");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceIsNotNull() {
            addCriterion("freeze_credit_balance is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceEqualTo(Double value) {
            addCriterion("freeze_credit_balance =", value, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceNotEqualTo(Double value) {
            addCriterion("freeze_credit_balance <>", value, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceGreaterThan(Double value) {
            addCriterion("freeze_credit_balance >", value, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("freeze_credit_balance >=", value, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceLessThan(Double value) {
            addCriterion("freeze_credit_balance <", value, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceLessThanOrEqualTo(Double value) {
            addCriterion("freeze_credit_balance <=", value, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceIn(List<Double> values) {
            addCriterion("freeze_credit_balance in", values, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceNotIn(List<Double> values) {
            addCriterion("freeze_credit_balance not in", values, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceBetween(Double value1, Double value2) {
            addCriterion("freeze_credit_balance between", value1, value2, "freezeCreditBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeCreditBalanceNotBetween(Double value1, Double value2) {
            addCriterion("freeze_credit_balance not between", value1, value2, "freezeCreditBalance");
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