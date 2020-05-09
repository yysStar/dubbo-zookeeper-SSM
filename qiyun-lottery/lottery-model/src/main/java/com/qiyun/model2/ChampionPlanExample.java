package com.qiyun.model2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChampionPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChampionPlanExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
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

        public Criteria andMultipleIsNull() {
            addCriterion("multiple is null");
            return (Criteria) this;
        }

        public Criteria andMultipleIsNotNull() {
            addCriterion("multiple is not null");
            return (Criteria) this;
        }

        public Criteria andMultipleEqualTo(Integer value) {
            addCriterion("multiple =", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotEqualTo(Integer value) {
            addCriterion("multiple <>", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThan(Integer value) {
            addCriterion("multiple >", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThanOrEqualTo(Integer value) {
            addCriterion("multiple >=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThan(Integer value) {
            addCriterion("multiple <", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThanOrEqualTo(Integer value) {
            addCriterion("multiple <=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleIn(List<Integer> values) {
            addCriterion("multiple in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotIn(List<Integer> values) {
            addCriterion("multiple not in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleBetween(Integer value1, Integer value2) {
            addCriterion("multiple between", value1, value2, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotBetween(Integer value1, Integer value2) {
            addCriterion("multiple not between", value1, value2, "multiple");
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

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andPerAmountIsNull() {
            addCriterion("per_amount is null");
            return (Criteria) this;
        }

        public Criteria andPerAmountIsNotNull() {
            addCriterion("per_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPerAmountEqualTo(Integer value) {
            addCriterion("per_amount =", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotEqualTo(Integer value) {
            addCriterion("per_amount <>", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountGreaterThan(Integer value) {
            addCriterion("per_amount >", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("per_amount >=", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountLessThan(Integer value) {
            addCriterion("per_amount <", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountLessThanOrEqualTo(Integer value) {
            addCriterion("per_amount <=", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountIn(List<Integer> values) {
            addCriterion("per_amount in", values, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotIn(List<Integer> values) {
            addCriterion("per_amount not in", values, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountBetween(Integer value1, Integer value2) {
            addCriterion("per_amount between", value1, value2, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("per_amount not between", value1, value2, "perAmount");
            return (Criteria) this;
        }

        public Criteria andBingoStatusIsNull() {
            addCriterion("bingo_status is null");
            return (Criteria) this;
        }

        public Criteria andBingoStatusIsNotNull() {
            addCriterion("bingo_status is not null");
            return (Criteria) this;
        }

        public Criteria andBingoStatusEqualTo(Integer value) {
            addCriterion("bingo_status =", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusNotEqualTo(Integer value) {
            addCriterion("bingo_status <>", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusGreaterThan(Integer value) {
            addCriterion("bingo_status >", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bingo_status >=", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusLessThan(Integer value) {
            addCriterion("bingo_status <", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bingo_status <=", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusIn(List<Integer> values) {
            addCriterion("bingo_status in", values, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusNotIn(List<Integer> values) {
            addCriterion("bingo_status not in", values, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusBetween(Integer value1, Integer value2) {
            addCriterion("bingo_status between", value1, value2, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bingo_status not between", value1, value2, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyIsNull() {
            addCriterion("bingo_money is null");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyIsNotNull() {
            addCriterion("bingo_money is not null");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyEqualTo(BigDecimal value) {
            addCriterion("bingo_money =", value, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyNotEqualTo(BigDecimal value) {
            addCriterion("bingo_money <>", value, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyGreaterThan(BigDecimal value) {
            addCriterion("bingo_money >", value, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bingo_money >=", value, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyLessThan(BigDecimal value) {
            addCriterion("bingo_money <", value, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bingo_money <=", value, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyIn(List<BigDecimal> values) {
            addCriterion("bingo_money in", values, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyNotIn(List<BigDecimal> values) {
            addCriterion("bingo_money not in", values, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bingo_money between", value1, value2, "bingoMoney");
            return (Criteria) this;
        }

        public Criteria andBingoMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bingo_money not between", value1, value2, "bingoMoney");
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

        public Criteria andTicketStatusIsNull() {
            addCriterion("ticket_status is null");
            return (Criteria) this;
        }

        public Criteria andTicketStatusIsNotNull() {
            addCriterion("ticket_status is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStatusEqualTo(Integer value) {
            addCriterion("ticket_status =", value, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusNotEqualTo(Integer value) {
            addCriterion("ticket_status <>", value, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusGreaterThan(Integer value) {
            addCriterion("ticket_status >", value, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_status >=", value, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusLessThan(Integer value) {
            addCriterion("ticket_status <", value, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_status <=", value, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusIn(List<Integer> values) {
            addCriterion("ticket_status in", values, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusNotIn(List<Integer> values) {
            addCriterion("ticket_status not in", values, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusBetween(Integer value1, Integer value2) {
            addCriterion("ticket_status between", value1, value2, "ticketStatus");
            return (Criteria) this;
        }

        public Criteria andTicketStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_status not between", value1, value2, "ticketStatus");
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