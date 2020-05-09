package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LotteryPlanOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryPlanOrderExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNull() {
            addCriterion("PLAN_NO is null");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNotNull() {
            addCriterion("PLAN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNoEqualTo(Integer value) {
            addCriterion("PLAN_NO =", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotEqualTo(Integer value) {
            addCriterion("PLAN_NO <>", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThan(Integer value) {
            addCriterion("PLAN_NO >", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAN_NO >=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThan(Integer value) {
            addCriterion("PLAN_NO <", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThanOrEqualTo(Integer value) {
            addCriterion("PLAN_NO <=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoIn(List<Integer> values) {
            addCriterion("PLAN_NO in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotIn(List<Integer> values) {
            addCriterion("PLAN_NO not in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_NO between", value1, value2, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_NO not between", value1, value2, "planNo");
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

        public Criteria andBuyTypeIsNull() {
            addCriterion("BUY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIsNotNull() {
            addCriterion("BUY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTypeEqualTo(Integer value) {
            addCriterion("BUY_TYPE =", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotEqualTo(Integer value) {
            addCriterion("BUY_TYPE <>", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeGreaterThan(Integer value) {
            addCriterion("BUY_TYPE >", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUY_TYPE >=", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLessThan(Integer value) {
            addCriterion("BUY_TYPE <", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("BUY_TYPE <=", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIn(List<Integer> values) {
            addCriterion("BUY_TYPE in", values, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotIn(List<Integer> values) {
            addCriterion("BUY_TYPE not in", values, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeBetween(Integer value1, Integer value2) {
            addCriterion("BUY_TYPE between", value1, value2, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("BUY_TYPE not between", value1, value2, "buyType");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPartIsNull() {
            addCriterion("PART is null");
            return (Criteria) this;
        }

        public Criteria andPartIsNotNull() {
            addCriterion("PART is not null");
            return (Criteria) this;
        }

        public Criteria andPartEqualTo(Integer value) {
            addCriterion("PART =", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartNotEqualTo(Integer value) {
            addCriterion("PART <>", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartGreaterThan(Integer value) {
            addCriterion("PART >", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartGreaterThanOrEqualTo(Integer value) {
            addCriterion("PART >=", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartLessThan(Integer value) {
            addCriterion("PART <", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartLessThanOrEqualTo(Integer value) {
            addCriterion("PART <=", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartIn(List<Integer> values) {
            addCriterion("PART in", values, "part");
            return (Criteria) this;
        }

        public Criteria andPartNotIn(List<Integer> values) {
            addCriterion("PART not in", values, "part");
            return (Criteria) this;
        }

        public Criteria andPartBetween(Integer value1, Integer value2) {
            addCriterion("PART between", value1, value2, "part");
            return (Criteria) this;
        }

        public Criteria andPartNotBetween(Integer value1, Integer value2) {
            addCriterion("PART not between", value1, value2, "part");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeIsNull() {
            addCriterion("POSTTAX_PRIZE is null");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeIsNotNull() {
            addCriterion("POSTTAX_PRIZE is not null");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeEqualTo(Double value) {
            addCriterion("POSTTAX_PRIZE =", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeNotEqualTo(Double value) {
            addCriterion("POSTTAX_PRIZE <>", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeGreaterThan(Double value) {
            addCriterion("POSTTAX_PRIZE >", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeGreaterThanOrEqualTo(Double value) {
            addCriterion("POSTTAX_PRIZE >=", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeLessThan(Double value) {
            addCriterion("POSTTAX_PRIZE <", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeLessThanOrEqualTo(Double value) {
            addCriterion("POSTTAX_PRIZE <=", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeIn(List<Double> values) {
            addCriterion("POSTTAX_PRIZE in", values, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeNotIn(List<Double> values) {
            addCriterion("POSTTAX_PRIZE not in", values, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeBetween(Double value1, Double value2) {
            addCriterion("POSTTAX_PRIZE between", value1, value2, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeNotBetween(Double value1, Double value2) {
            addCriterion("POSTTAX_PRIZE not between", value1, value2, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusIsNull() {
            addCriterion("PRIZE_SETTLE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusIsNotNull() {
            addCriterion("PRIZE_SETTLE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusEqualTo(Integer value) {
            addCriterion("PRIZE_SETTLE_STATUS =", value, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusNotEqualTo(Integer value) {
            addCriterion("PRIZE_SETTLE_STATUS <>", value, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusGreaterThan(Integer value) {
            addCriterion("PRIZE_SETTLE_STATUS >", value, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIZE_SETTLE_STATUS >=", value, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusLessThan(Integer value) {
            addCriterion("PRIZE_SETTLE_STATUS <", value, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("PRIZE_SETTLE_STATUS <=", value, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusIn(List<Integer> values) {
            addCriterion("PRIZE_SETTLE_STATUS in", values, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusNotIn(List<Integer> values) {
            addCriterion("PRIZE_SETTLE_STATUS not in", values, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusBetween(Integer value1, Integer value2) {
            addCriterion("PRIZE_SETTLE_STATUS between", value1, value2, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIZE_SETTLE_STATUS not between", value1, value2, "prizeSettleStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeIsNull() {
            addCriterion("PRIZE_SETTLE_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeIsNotNull() {
            addCriterion("PRIZE_SETTLE_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeEqualTo(Date value) {
            addCriterion("PRIZE_SETTLE_DATE_TIME =", value, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeNotEqualTo(Date value) {
            addCriterion("PRIZE_SETTLE_DATE_TIME <>", value, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeGreaterThan(Date value) {
            addCriterion("PRIZE_SETTLE_DATE_TIME >", value, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PRIZE_SETTLE_DATE_TIME >=", value, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeLessThan(Date value) {
            addCriterion("PRIZE_SETTLE_DATE_TIME <", value, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("PRIZE_SETTLE_DATE_TIME <=", value, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeIn(List<Date> values) {
            addCriterion("PRIZE_SETTLE_DATE_TIME in", values, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeNotIn(List<Date> values) {
            addCriterion("PRIZE_SETTLE_DATE_TIME not in", values, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeBetween(Date value1, Date value2) {
            addCriterion("PRIZE_SETTLE_DATE_TIME between", value1, value2, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andPrizeSettleDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("PRIZE_SETTLE_DATE_TIME not between", value1, value2, "prizeSettleDateTime");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("SCORE is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("SCORE =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("SCORE <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("SCORE >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCORE >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("SCORE <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("SCORE <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("SCORE in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("SCORE not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("SCORE between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("SCORE not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("EXPERIENCE is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("EXPERIENCE is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(Integer value) {
            addCriterion("EXPERIENCE =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(Integer value) {
            addCriterion("EXPERIENCE <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(Integer value) {
            addCriterion("EXPERIENCE >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPERIENCE >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(Integer value) {
            addCriterion("EXPERIENCE <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(Integer value) {
            addCriterion("EXPERIENCE <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<Integer> values) {
            addCriterion("EXPERIENCE in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<Integer> values) {
            addCriterion("EXPERIENCE not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(Integer value1, Integer value2) {
            addCriterion("EXPERIENCE between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPERIENCE not between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5IsNull() {
            addCriterion("VERIFY_MD5 is null");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5IsNotNull() {
            addCriterion("VERIFY_MD5 is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5EqualTo(String value) {
            addCriterion("VERIFY_MD5 =", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5NotEqualTo(String value) {
            addCriterion("VERIFY_MD5 <>", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5GreaterThan(String value) {
            addCriterion("VERIFY_MD5 >", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5GreaterThanOrEqualTo(String value) {
            addCriterion("VERIFY_MD5 >=", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5LessThan(String value) {
            addCriterion("VERIFY_MD5 <", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5LessThanOrEqualTo(String value) {
            addCriterion("VERIFY_MD5 <=", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5Like(String value) {
            addCriterion("VERIFY_MD5 like", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5NotLike(String value) {
            addCriterion("VERIFY_MD5 not like", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5In(List<String> values) {
            addCriterion("VERIFY_MD5 in", values, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5NotIn(List<String> values) {
            addCriterion("VERIFY_MD5 not in", values, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5Between(String value1, String value2) {
            addCriterion("VERIFY_MD5 between", value1, value2, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5NotBetween(String value1, String value2) {
            addCriterion("VERIFY_MD5 not between", value1, value2, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeIsNull() {
            addCriterion("RETURN_AMOUNT_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeIsNotNull() {
            addCriterion("RETURN_AMOUNT_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeEqualTo(Date value) {
            addCriterion("RETURN_AMOUNT_DATE_TIME =", value, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeNotEqualTo(Date value) {
            addCriterion("RETURN_AMOUNT_DATE_TIME <>", value, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeGreaterThan(Date value) {
            addCriterion("RETURN_AMOUNT_DATE_TIME >", value, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RETURN_AMOUNT_DATE_TIME >=", value, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeLessThan(Date value) {
            addCriterion("RETURN_AMOUNT_DATE_TIME <", value, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("RETURN_AMOUNT_DATE_TIME <=", value, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeIn(List<Date> values) {
            addCriterion("RETURN_AMOUNT_DATE_TIME in", values, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeNotIn(List<Date> values) {
            addCriterion("RETURN_AMOUNT_DATE_TIME not in", values, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeBetween(Date value1, Date value2) {
            addCriterion("RETURN_AMOUNT_DATE_TIME between", value1, value2, "returnAmountDateTime");
            return (Criteria) this;
        }

        public Criteria andReturnAmountDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("RETURN_AMOUNT_DATE_TIME not between", value1, value2, "returnAmountDateTime");
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

        public Criteria andWalletTypeIsNull() {
            addCriterion("WALLET_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWalletTypeIsNotNull() {
            addCriterion("WALLET_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWalletTypeEqualTo(Integer value) {
            addCriterion("WALLET_TYPE =", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeNotEqualTo(Integer value) {
            addCriterion("WALLET_TYPE <>", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeGreaterThan(Integer value) {
            addCriterion("WALLET_TYPE >", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("WALLET_TYPE >=", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeLessThan(Integer value) {
            addCriterion("WALLET_TYPE <", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeLessThanOrEqualTo(Integer value) {
            addCriterion("WALLET_TYPE <=", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeIn(List<Integer> values) {
            addCriterion("WALLET_TYPE in", values, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeNotIn(List<Integer> values) {
            addCriterion("WALLET_TYPE not in", values, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeBetween(Integer value1, Integer value2) {
            addCriterion("WALLET_TYPE between", value1, value2, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("WALLET_TYPE not between", value1, value2, "walletType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeIsNull() {
            addCriterion("following_type is null");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeIsNotNull() {
            addCriterion("following_type is not null");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeEqualTo(Integer value) {
            addCriterion("following_type =", value, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeNotEqualTo(Integer value) {
            addCriterion("following_type <>", value, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeGreaterThan(Integer value) {
            addCriterion("following_type >", value, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("following_type >=", value, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeLessThan(Integer value) {
            addCriterion("following_type <", value, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeLessThanOrEqualTo(Integer value) {
            addCriterion("following_type <=", value, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeIn(List<Integer> values) {
            addCriterion("following_type in", values, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeNotIn(List<Integer> values) {
            addCriterion("following_type not in", values, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeBetween(Integer value1, Integer value2) {
            addCriterion("following_type between", value1, value2, "followingType");
            return (Criteria) this;
        }

        public Criteria andFollowingTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("following_type not between", value1, value2, "followingType");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(Integer value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(Integer value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(Integer value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(Integer value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<Integer> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<Integer> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(Integer value1, Integer value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("platform not between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andGoldIsNull() {
            addCriterion("gold is null");
            return (Criteria) this;
        }

        public Criteria andGoldIsNotNull() {
            addCriterion("gold is not null");
            return (Criteria) this;
        }

        public Criteria andGoldEqualTo(Double value) {
            addCriterion("gold =", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotEqualTo(Double value) {
            addCriterion("gold <>", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThan(Double value) {
            addCriterion("gold >", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThanOrEqualTo(Double value) {
            addCriterion("gold >=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThan(Double value) {
            addCriterion("gold <", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThanOrEqualTo(Double value) {
            addCriterion("gold <=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldIn(List<Double> values) {
            addCriterion("gold in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotIn(List<Double> values) {
            addCriterion("gold not in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldBetween(Double value1, Double value2) {
            addCriterion("gold between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotBetween(Double value1, Double value2) {
            addCriterion("gold not between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andSumGoldIsNull() {
            addCriterion("sum_gold is null");
            return (Criteria) this;
        }

        public Criteria andSumGoldIsNotNull() {
            addCriterion("sum_gold is not null");
            return (Criteria) this;
        }

        public Criteria andSumGoldEqualTo(Double value) {
            addCriterion("sum_gold =", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldNotEqualTo(Double value) {
            addCriterion("sum_gold <>", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldGreaterThan(Double value) {
            addCriterion("sum_gold >", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldGreaterThanOrEqualTo(Double value) {
            addCriterion("sum_gold >=", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldLessThan(Double value) {
            addCriterion("sum_gold <", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldLessThanOrEqualTo(Double value) {
            addCriterion("sum_gold <=", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldIn(List<Double> values) {
            addCriterion("sum_gold in", values, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldNotIn(List<Double> values) {
            addCriterion("sum_gold not in", values, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldBetween(Double value1, Double value2) {
            addCriterion("sum_gold between", value1, value2, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldNotBetween(Double value1, Double value2) {
            addCriterion("sum_gold not between", value1, value2, "sumGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldIsNull() {
            addCriterion("web_site_gold is null");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldIsNotNull() {
            addCriterion("web_site_gold is not null");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldEqualTo(Double value) {
            addCriterion("web_site_gold =", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldNotEqualTo(Double value) {
            addCriterion("web_site_gold <>", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldGreaterThan(Double value) {
            addCriterion("web_site_gold >", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldGreaterThanOrEqualTo(Double value) {
            addCriterion("web_site_gold >=", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldLessThan(Double value) {
            addCriterion("web_site_gold <", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldLessThanOrEqualTo(Double value) {
            addCriterion("web_site_gold <=", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldIn(List<Double> values) {
            addCriterion("web_site_gold in", values, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldNotIn(List<Double> values) {
            addCriterion("web_site_gold not in", values, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldBetween(Double value1, Double value2) {
            addCriterion("web_site_gold between", value1, value2, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldNotBetween(Double value1, Double value2) {
            addCriterion("web_site_gold not between", value1, value2, "webSiteGold");
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