package com.qiyun.model2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TicketUserQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketUserQuery() {
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

        public Criteria andPushCountIsNull() {
            addCriterion("push_count is null");
            return (Criteria) this;
        }

        public Criteria andPushCountIsNotNull() {
            addCriterion("push_count is not null");
            return (Criteria) this;
        }

        public Criteria andPushCountEqualTo(Integer value) {
            addCriterion("push_count =", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountNotEqualTo(Integer value) {
            addCriterion("push_count <>", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountGreaterThan(Integer value) {
            addCriterion("push_count >", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("push_count >=", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountLessThan(Integer value) {
            addCriterion("push_count <", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountLessThanOrEqualTo(Integer value) {
            addCriterion("push_count <=", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountIn(List<Integer> values) {
            addCriterion("push_count in", values, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountNotIn(List<Integer> values) {
            addCriterion("push_count not in", values, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountBetween(Integer value1, Integer value2) {
            addCriterion("push_count between", value1, value2, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountNotBetween(Integer value1, Integer value2) {
            addCriterion("push_count not between", value1, value2, "pushCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountIsNull() {
            addCriterion("revocation_count is null");
            return (Criteria) this;
        }

        public Criteria andRevocationCountIsNotNull() {
            addCriterion("revocation_count is not null");
            return (Criteria) this;
        }

        public Criteria andRevocationCountEqualTo(Integer value) {
            addCriterion("revocation_count =", value, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountNotEqualTo(Integer value) {
            addCriterion("revocation_count <>", value, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountGreaterThan(Integer value) {
            addCriterion("revocation_count >", value, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("revocation_count >=", value, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountLessThan(Integer value) {
            addCriterion("revocation_count <", value, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountLessThanOrEqualTo(Integer value) {
            addCriterion("revocation_count <=", value, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountIn(List<Integer> values) {
            addCriterion("revocation_count in", values, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountNotIn(List<Integer> values) {
            addCriterion("revocation_count not in", values, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountBetween(Integer value1, Integer value2) {
            addCriterion("revocation_count between", value1, value2, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andRevocationCountNotBetween(Integer value1, Integer value2) {
            addCriterion("revocation_count not between", value1, value2, "revocationCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountIsNull() {
            addCriterion("dispose_count is null");
            return (Criteria) this;
        }

        public Criteria andDisposeCountIsNotNull() {
            addCriterion("dispose_count is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeCountEqualTo(Integer value) {
            addCriterion("dispose_count =", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountNotEqualTo(Integer value) {
            addCriterion("dispose_count <>", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountGreaterThan(Integer value) {
            addCriterion("dispose_count >", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispose_count >=", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountLessThan(Integer value) {
            addCriterion("dispose_count <", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountLessThanOrEqualTo(Integer value) {
            addCriterion("dispose_count <=", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountIn(List<Integer> values) {
            addCriterion("dispose_count in", values, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountNotIn(List<Integer> values) {
            addCriterion("dispose_count not in", values, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountBetween(Integer value1, Integer value2) {
            addCriterion("dispose_count between", value1, value2, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("dispose_count not between", value1, value2, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andAddBalanceIsNull() {
            addCriterion("add_balance is null");
            return (Criteria) this;
        }

        public Criteria andAddBalanceIsNotNull() {
            addCriterion("add_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAddBalanceEqualTo(BigDecimal value) {
            addCriterion("add_balance =", value, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceNotEqualTo(BigDecimal value) {
            addCriterion("add_balance <>", value, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceGreaterThan(BigDecimal value) {
            addCriterion("add_balance >", value, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("add_balance >=", value, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceLessThan(BigDecimal value) {
            addCriterion("add_balance <", value, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("add_balance <=", value, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceIn(List<BigDecimal> values) {
            addCriterion("add_balance in", values, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceNotIn(List<BigDecimal> values) {
            addCriterion("add_balance not in", values, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("add_balance between", value1, value2, "addBalance");
            return (Criteria) this;
        }

        public Criteria andAddBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("add_balance not between", value1, value2, "addBalance");
            return (Criteria) this;
        }

        public Criteria andPushAmountIsNull() {
            addCriterion("push_amount is null");
            return (Criteria) this;
        }

        public Criteria andPushAmountIsNotNull() {
            addCriterion("push_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPushAmountEqualTo(BigDecimal value) {
            addCriterion("push_amount =", value, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountNotEqualTo(BigDecimal value) {
            addCriterion("push_amount <>", value, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountGreaterThan(BigDecimal value) {
            addCriterion("push_amount >", value, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("push_amount >=", value, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountLessThan(BigDecimal value) {
            addCriterion("push_amount <", value, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("push_amount <=", value, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountIn(List<BigDecimal> values) {
            addCriterion("push_amount in", values, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountNotIn(List<BigDecimal> values) {
            addCriterion("push_amount not in", values, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("push_amount between", value1, value2, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andPushAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("push_amount not between", value1, value2, "pushAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountIsNull() {
            addCriterion("revocation_amount is null");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountIsNotNull() {
            addCriterion("revocation_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountEqualTo(BigDecimal value) {
            addCriterion("revocation_amount =", value, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountNotEqualTo(BigDecimal value) {
            addCriterion("revocation_amount <>", value, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountGreaterThan(BigDecimal value) {
            addCriterion("revocation_amount >", value, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("revocation_amount >=", value, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountLessThan(BigDecimal value) {
            addCriterion("revocation_amount <", value, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("revocation_amount <=", value, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountIn(List<BigDecimal> values) {
            addCriterion("revocation_amount in", values, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountNotIn(List<BigDecimal> values) {
            addCriterion("revocation_amount not in", values, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revocation_amount between", value1, value2, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andRevocationAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revocation_amount not between", value1, value2, "revocationAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountIsNull() {
            addCriterion("dispose_amount is null");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountIsNotNull() {
            addCriterion("dispose_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountEqualTo(BigDecimal value) {
            addCriterion("dispose_amount =", value, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountNotEqualTo(BigDecimal value) {
            addCriterion("dispose_amount <>", value, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountGreaterThan(BigDecimal value) {
            addCriterion("dispose_amount >", value, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dispose_amount >=", value, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountLessThan(BigDecimal value) {
            addCriterion("dispose_amount <", value, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dispose_amount <=", value, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountIn(List<BigDecimal> values) {
            addCriterion("dispose_amount in", values, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountNotIn(List<BigDecimal> values) {
            addCriterion("dispose_amount not in", values, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dispose_amount between", value1, value2, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andDisposeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dispose_amount not between", value1, value2, "disposeAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountIsNull() {
            addCriterion("bingo_amount is null");
            return (Criteria) this;
        }

        public Criteria andBingoAmountIsNotNull() {
            addCriterion("bingo_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBingoAmountEqualTo(BigDecimal value) {
            addCriterion("bingo_amount =", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountNotEqualTo(BigDecimal value) {
            addCriterion("bingo_amount <>", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountGreaterThan(BigDecimal value) {
            addCriterion("bingo_amount >", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bingo_amount >=", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountLessThan(BigDecimal value) {
            addCriterion("bingo_amount <", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bingo_amount <=", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountIn(List<BigDecimal> values) {
            addCriterion("bingo_amount in", values, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountNotIn(List<BigDecimal> values) {
            addCriterion("bingo_amount not in", values, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bingo_amount between", value1, value2, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bingo_amount not between", value1, value2, "bingoAmount");
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