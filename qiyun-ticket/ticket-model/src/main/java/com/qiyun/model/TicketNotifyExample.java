package com.qiyun.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TicketNotifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketNotifyExample() {
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

        public Criteria andLotIdIsNull() {
            addCriterion("lot_id is null");
            return (Criteria) this;
        }

        public Criteria andLotIdIsNotNull() {
            addCriterion("lot_id is not null");
            return (Criteria) this;
        }

        public Criteria andLotIdEqualTo(String value) {
            addCriterion("lot_id =", value, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdNotEqualTo(String value) {
            addCriterion("lot_id <>", value, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdGreaterThan(String value) {
            addCriterion("lot_id >", value, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdGreaterThanOrEqualTo(String value) {
            addCriterion("lot_id >=", value, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdLessThan(String value) {
            addCriterion("lot_id <", value, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdLessThanOrEqualTo(String value) {
            addCriterion("lot_id <=", value, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdLike(String value) {
            addCriterion("lot_id like", value, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdNotLike(String value) {
            addCriterion("lot_id not like", value, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdIn(List<String> values) {
            addCriterion("lot_id in", values, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdNotIn(List<String> values) {
            addCriterion("lot_id not in", values, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdBetween(String value1, String value2) {
            addCriterion("lot_id between", value1, value2, "lotId");
            return (Criteria) this;
        }

        public Criteria andLotIdNotBetween(String value1, String value2) {
            addCriterion("lot_id not between", value1, value2, "lotId");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoIsNull() {
            addCriterion("ticket_serial_no is null");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoIsNotNull() {
            addCriterion("ticket_serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoEqualTo(String value) {
            addCriterion("ticket_serial_no =", value, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoNotEqualTo(String value) {
            addCriterion("ticket_serial_no <>", value, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoGreaterThan(String value) {
            addCriterion("ticket_serial_no >", value, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_serial_no >=", value, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoLessThan(String value) {
            addCriterion("ticket_serial_no <", value, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoLessThanOrEqualTo(String value) {
            addCriterion("ticket_serial_no <=", value, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoLike(String value) {
            addCriterion("ticket_serial_no like", value, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoNotLike(String value) {
            addCriterion("ticket_serial_no not like", value, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoIn(List<String> values) {
            addCriterion("ticket_serial_no in", values, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoNotIn(List<String> values) {
            addCriterion("ticket_serial_no not in", values, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoBetween(String value1, String value2) {
            addCriterion("ticket_serial_no between", value1, value2, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andTicketSerialNoNotBetween(String value1, String value2) {
            addCriterion("ticket_serial_no not between", value1, value2, "ticketSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoIsNull() {
            addCriterion("print_serial_no is null");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoIsNotNull() {
            addCriterion("print_serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoEqualTo(String value) {
            addCriterion("print_serial_no =", value, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoNotEqualTo(String value) {
            addCriterion("print_serial_no <>", value, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoGreaterThan(String value) {
            addCriterion("print_serial_no >", value, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("print_serial_no >=", value, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoLessThan(String value) {
            addCriterion("print_serial_no <", value, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoLessThanOrEqualTo(String value) {
            addCriterion("print_serial_no <=", value, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoLike(String value) {
            addCriterion("print_serial_no like", value, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoNotLike(String value) {
            addCriterion("print_serial_no not like", value, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoIn(List<String> values) {
            addCriterion("print_serial_no in", values, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoNotIn(List<String> values) {
            addCriterion("print_serial_no not in", values, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoBetween(String value1, String value2) {
            addCriterion("print_serial_no between", value1, value2, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andPrintSerialNoNotBetween(String value1, String value2) {
            addCriterion("print_serial_no not between", value1, value2, "printSerialNo");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNull() {
            addCriterion("station_id is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(String value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(String value) {
            addCriterion("station_id <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(String value) {
            addCriterion("station_id >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("station_id >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(String value) {
            addCriterion("station_id <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(String value) {
            addCriterion("station_id <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLike(String value) {
            addCriterion("station_id like", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotLike(String value) {
            addCriterion("station_id not like", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<String> values) {
            addCriterion("station_id in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<String> values) {
            addCriterion("station_id not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(String value1, String value2) {
            addCriterion("station_id between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(String value1, String value2) {
            addCriterion("station_id not between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andFixedBonusIsNull() {
            addCriterion("fixed_bonus is null");
            return (Criteria) this;
        }

        public Criteria andFixedBonusIsNotNull() {
            addCriterion("fixed_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andFixedBonusEqualTo(BigDecimal value) {
            addCriterion("fixed_bonus =", value, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusNotEqualTo(BigDecimal value) {
            addCriterion("fixed_bonus <>", value, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusGreaterThan(BigDecimal value) {
            addCriterion("fixed_bonus >", value, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fixed_bonus >=", value, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusLessThan(BigDecimal value) {
            addCriterion("fixed_bonus <", value, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fixed_bonus <=", value, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusIn(List<BigDecimal> values) {
            addCriterion("fixed_bonus in", values, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusNotIn(List<BigDecimal> values) {
            addCriterion("fixed_bonus not in", values, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fixed_bonus between", value1, value2, "fixedBonus");
            return (Criteria) this;
        }

        public Criteria andFixedBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fixed_bonus not between", value1, value2, "fixedBonus");
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