package com.qiyun.model2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketOperationLineQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketOperationLineQuery() {
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

        public Criteria andTransTypeIsNull() {
            addCriterion("trans_type is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNotNull() {
            addCriterion("trans_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeEqualTo(Integer value) {
            addCriterion("trans_type =", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotEqualTo(Integer value) {
            addCriterion("trans_type <>", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThan(Integer value) {
            addCriterion("trans_type >", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trans_type >=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThan(Integer value) {
            addCriterion("trans_type <", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThanOrEqualTo(Integer value) {
            addCriterion("trans_type <=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIn(List<Integer> values) {
            addCriterion("trans_type in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotIn(List<Integer> values) {
            addCriterion("trans_type not in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeBetween(Integer value1, Integer value2) {
            addCriterion("trans_type between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("trans_type not between", value1, value2, "transType");
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

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNull() {
            addCriterion("ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNotNull() {
            addCriterion("ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketIdEqualTo(Integer value) {
            addCriterion("ticket_id =", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotEqualTo(Integer value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThan(Integer value) {
            addCriterion("ticket_id >", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThan(Integer value) {
            addCriterion("ticket_id <", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIn(List<Integer> values) {
            addCriterion("ticket_id in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotIn(List<Integer> values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdBetween(Integer value1, Integer value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketCountIsNull() {
            addCriterion("ticket_count is null");
            return (Criteria) this;
        }

        public Criteria andTicketCountIsNotNull() {
            addCriterion("ticket_count is not null");
            return (Criteria) this;
        }

        public Criteria andTicketCountEqualTo(Integer value) {
            addCriterion("ticket_count =", value, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountNotEqualTo(Integer value) {
            addCriterion("ticket_count <>", value, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountGreaterThan(Integer value) {
            addCriterion("ticket_count >", value, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_count >=", value, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountLessThan(Integer value) {
            addCriterion("ticket_count <", value, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_count <=", value, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountIn(List<Integer> values) {
            addCriterion("ticket_count in", values, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountNotIn(List<Integer> values) {
            addCriterion("ticket_count not in", values, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountBetween(Integer value1, Integer value2) {
            addCriterion("ticket_count between", value1, value2, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_count not between", value1, value2, "ticketCount");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdIsNull() {
            addCriterion("ticket_apparatus_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdIsNotNull() {
            addCriterion("ticket_apparatus_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdEqualTo(String value) {
            addCriterion("ticket_apparatus_id =", value, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdNotEqualTo(String value) {
            addCriterion("ticket_apparatus_id <>", value, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdGreaterThan(String value) {
            addCriterion("ticket_apparatus_id >", value, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_apparatus_id >=", value, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdLessThan(String value) {
            addCriterion("ticket_apparatus_id <", value, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdLessThanOrEqualTo(String value) {
            addCriterion("ticket_apparatus_id <=", value, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdLike(String value) {
            addCriterion("ticket_apparatus_id like", value, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdNotLike(String value) {
            addCriterion("ticket_apparatus_id not like", value, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdIn(List<String> values) {
            addCriterion("ticket_apparatus_id in", values, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdNotIn(List<String> values) {
            addCriterion("ticket_apparatus_id not in", values, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdBetween(String value1, String value2) {
            addCriterion("ticket_apparatus_id between", value1, value2, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusIdNotBetween(String value1, String value2) {
            addCriterion("ticket_apparatus_id not between", value1, value2, "ticketApparatusId");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceIsNull() {
            addCriterion("ticket_apparatus_able_balance is null");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceIsNotNull() {
            addCriterion("ticket_apparatus_able_balance is not null");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceEqualTo(BigDecimal value) {
            addCriterion("ticket_apparatus_able_balance =", value, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceNotEqualTo(BigDecimal value) {
            addCriterion("ticket_apparatus_able_balance <>", value, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceGreaterThan(BigDecimal value) {
            addCriterion("ticket_apparatus_able_balance >", value, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ticket_apparatus_able_balance >=", value, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceLessThan(BigDecimal value) {
            addCriterion("ticket_apparatus_able_balance <", value, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ticket_apparatus_able_balance <=", value, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceIn(List<BigDecimal> values) {
            addCriterion("ticket_apparatus_able_balance in", values, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceNotIn(List<BigDecimal> values) {
            addCriterion("ticket_apparatus_able_balance not in", values, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ticket_apparatus_able_balance between", value1, value2, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andTicketApparatusAbleBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ticket_apparatus_able_balance not between", value1, value2, "ticketApparatusAbleBalance");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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