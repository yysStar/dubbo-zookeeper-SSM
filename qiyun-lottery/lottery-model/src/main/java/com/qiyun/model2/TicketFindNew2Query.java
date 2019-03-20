package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketFindNew2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketFindNew2Query() {
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

        public Criteria andPlanNoIsNull() {
            addCriterion("plan_no is null");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNotNull() {
            addCriterion("plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNoEqualTo(Integer value) {
            addCriterion("plan_no =", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotEqualTo(Integer value) {
            addCriterion("plan_no <>", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThan(Integer value) {
            addCriterion("plan_no >", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_no >=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThan(Integer value) {
            addCriterion("plan_no <", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThanOrEqualTo(Integer value) {
            addCriterion("plan_no <=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoIn(List<Integer> values) {
            addCriterion("plan_no in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotIn(List<Integer> values) {
            addCriterion("plan_no not in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoBetween(Integer value1, Integer value2) {
            addCriterion("plan_no between", value1, value2, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_no not between", value1, value2, "planNo");
            return (Criteria) this;
        }

        public Criteria andFindTimeIsNull() {
            addCriterion("find_time is null");
            return (Criteria) this;
        }

        public Criteria andFindTimeIsNotNull() {
            addCriterion("find_time is not null");
            return (Criteria) this;
        }

        public Criteria andFindTimeEqualTo(Date value) {
            addCriterion("find_time =", value, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeNotEqualTo(Date value) {
            addCriterion("find_time <>", value, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeGreaterThan(Date value) {
            addCriterion("find_time >", value, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("find_time >=", value, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeLessThan(Date value) {
            addCriterion("find_time <", value, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeLessThanOrEqualTo(Date value) {
            addCriterion("find_time <=", value, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeIn(List<Date> values) {
            addCriterion("find_time in", values, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeNotIn(List<Date> values) {
            addCriterion("find_time not in", values, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeBetween(Date value1, Date value2) {
            addCriterion("find_time between", value1, value2, "findTime");
            return (Criteria) this;
        }

        public Criteria andFindTimeNotBetween(Date value1, Date value2) {
            addCriterion("find_time not between", value1, value2, "findTime");
            return (Criteria) this;
        }

        public Criteria andKhAccountIsNull() {
            addCriterion("kh_account is null");
            return (Criteria) this;
        }

        public Criteria andKhAccountIsNotNull() {
            addCriterion("kh_account is not null");
            return (Criteria) this;
        }

        public Criteria andKhAccountEqualTo(String value) {
            addCriterion("kh_account =", value, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountNotEqualTo(String value) {
            addCriterion("kh_account <>", value, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountGreaterThan(String value) {
            addCriterion("kh_account >", value, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountGreaterThanOrEqualTo(String value) {
            addCriterion("kh_account >=", value, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountLessThan(String value) {
            addCriterion("kh_account <", value, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountLessThanOrEqualTo(String value) {
            addCriterion("kh_account <=", value, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountLike(String value) {
            addCriterion("kh_account like", value, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountNotLike(String value) {
            addCriterion("kh_account not like", value, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountIn(List<String> values) {
            addCriterion("kh_account in", values, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountNotIn(List<String> values) {
            addCriterion("kh_account not in", values, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountBetween(String value1, String value2) {
            addCriterion("kh_account between", value1, value2, "khAccount");
            return (Criteria) this;
        }

        public Criteria andKhAccountNotBetween(String value1, String value2) {
            addCriterion("kh_account not between", value1, value2, "khAccount");
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

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoIsNull() {
            addCriterion("copy_plan_no is null");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoIsNotNull() {
            addCriterion("copy_plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoEqualTo(Integer value) {
            addCriterion("copy_plan_no =", value, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoNotEqualTo(Integer value) {
            addCriterion("copy_plan_no <>", value, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoGreaterThan(Integer value) {
            addCriterion("copy_plan_no >", value, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_plan_no >=", value, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoLessThan(Integer value) {
            addCriterion("copy_plan_no <", value, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoLessThanOrEqualTo(Integer value) {
            addCriterion("copy_plan_no <=", value, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoIn(List<Integer> values) {
            addCriterion("copy_plan_no in", values, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoNotIn(List<Integer> values) {
            addCriterion("copy_plan_no not in", values, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoBetween(Integer value1, Integer value2) {
            addCriterion("copy_plan_no between", value1, value2, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andCopyPlanNoNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_plan_no not between", value1, value2, "copyPlanNo");
            return (Criteria) this;
        }

        public Criteria andXpAccountIsNull() {
            addCriterion("xp_account is null");
            return (Criteria) this;
        }

        public Criteria andXpAccountIsNotNull() {
            addCriterion("xp_account is not null");
            return (Criteria) this;
        }

        public Criteria andXpAccountEqualTo(String value) {
            addCriterion("xp_account =", value, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountNotEqualTo(String value) {
            addCriterion("xp_account <>", value, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountGreaterThan(String value) {
            addCriterion("xp_account >", value, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountGreaterThanOrEqualTo(String value) {
            addCriterion("xp_account >=", value, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountLessThan(String value) {
            addCriterion("xp_account <", value, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountLessThanOrEqualTo(String value) {
            addCriterion("xp_account <=", value, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountLike(String value) {
            addCriterion("xp_account like", value, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountNotLike(String value) {
            addCriterion("xp_account not like", value, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountIn(List<String> values) {
            addCriterion("xp_account in", values, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountNotIn(List<String> values) {
            addCriterion("xp_account not in", values, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountBetween(String value1, String value2) {
            addCriterion("xp_account between", value1, value2, "xpAccount");
            return (Criteria) this;
        }

        public Criteria andXpAccountNotBetween(String value1, String value2) {
            addCriterion("xp_account not between", value1, value2, "xpAccount");
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

        public Criteria andCopyStatusIsNull() {
            addCriterion("copy_status is null");
            return (Criteria) this;
        }

        public Criteria andCopyStatusIsNotNull() {
            addCriterion("copy_status is not null");
            return (Criteria) this;
        }

        public Criteria andCopyStatusEqualTo(Integer value) {
            addCriterion("copy_status =", value, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusNotEqualTo(Integer value) {
            addCriterion("copy_status <>", value, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusGreaterThan(Integer value) {
            addCriterion("copy_status >", value, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_status >=", value, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusLessThan(Integer value) {
            addCriterion("copy_status <", value, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("copy_status <=", value, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusIn(List<Integer> values) {
            addCriterion("copy_status in", values, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusNotIn(List<Integer> values) {
            addCriterion("copy_status not in", values, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusBetween(Integer value1, Integer value2) {
            addCriterion("copy_status between", value1, value2, "copyStatus");
            return (Criteria) this;
        }

        public Criteria andCopyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_status not between", value1, value2, "copyStatus");
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