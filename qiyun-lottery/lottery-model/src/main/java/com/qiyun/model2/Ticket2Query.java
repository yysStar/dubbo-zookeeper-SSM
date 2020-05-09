package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Ticket2Query() {
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

        public Criteria andTermIsNull() {
            addCriterion("TERM is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("TERM is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(String value) {
            addCriterion("TERM =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(String value) {
            addCriterion("TERM <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(String value) {
            addCriterion("TERM >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(String value) {
            addCriterion("TERM >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(String value) {
            addCriterion("TERM <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(String value) {
            addCriterion("TERM <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLike(String value) {
            addCriterion("TERM like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotLike(String value) {
            addCriterion("TERM not like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<String> values) {
            addCriterion("TERM in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<String> values) {
            addCriterion("TERM not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(String value1, String value2) {
            addCriterion("TERM between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(String value1, String value2) {
            addCriterion("TERM not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNull() {
            addCriterion("LOTTERY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNotNull() {
            addCriterion("LOTTERY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeEqualTo(Integer value) {
            addCriterion("LOTTERY_TYPE =", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotEqualTo(Integer value) {
            addCriterion("LOTTERY_TYPE <>", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThan(Integer value) {
            addCriterion("LOTTERY_TYPE >", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOTTERY_TYPE >=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThan(Integer value) {
            addCriterion("LOTTERY_TYPE <", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOTTERY_TYPE <=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIn(List<Integer> values) {
            addCriterion("LOTTERY_TYPE in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotIn(List<Integer> values) {
            addCriterion("LOTTERY_TYPE not in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOTTERY_TYPE between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOTTERY_TYPE not between", value1, value2, "lotteryType");
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

        public Criteria andSendDateTimeIsNull() {
            addCriterion("SEND_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeIsNotNull() {
            addCriterion("SEND_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeEqualTo(Date value) {
            addCriterion("SEND_DATE_TIME =", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotEqualTo(Date value) {
            addCriterion("SEND_DATE_TIME <>", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeGreaterThan(Date value) {
            addCriterion("SEND_DATE_TIME >", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_DATE_TIME >=", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeLessThan(Date value) {
            addCriterion("SEND_DATE_TIME <", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("SEND_DATE_TIME <=", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeIn(List<Date> values) {
            addCriterion("SEND_DATE_TIME in", values, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotIn(List<Date> values) {
            addCriterion("SEND_DATE_TIME not in", values, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeBetween(Date value1, Date value2) {
            addCriterion("SEND_DATE_TIME between", value1, value2, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("SEND_DATE_TIME not between", value1, value2, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeIsNull() {
            addCriterion("PRINT_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeIsNotNull() {
            addCriterion("PRINT_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeEqualTo(Date value) {
            addCriterion("PRINT_DATE_TIME =", value, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeNotEqualTo(Date value) {
            addCriterion("PRINT_DATE_TIME <>", value, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeGreaterThan(Date value) {
            addCriterion("PRINT_DATE_TIME >", value, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PRINT_DATE_TIME >=", value, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeLessThan(Date value) {
            addCriterion("PRINT_DATE_TIME <", value, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("PRINT_DATE_TIME <=", value, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeIn(List<Date> values) {
            addCriterion("PRINT_DATE_TIME in", values, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeNotIn(List<Date> values) {
            addCriterion("PRINT_DATE_TIME not in", values, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeBetween(Date value1, Date value2) {
            addCriterion("PRINT_DATE_TIME between", value1, value2, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("PRINT_DATE_TIME not between", value1, value2, "printDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeIsNull() {
            addCriterion("DEAL_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeIsNotNull() {
            addCriterion("DEAL_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeEqualTo(Date value) {
            addCriterion("DEAL_DATE_TIME =", value, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeNotEqualTo(Date value) {
            addCriterion("DEAL_DATE_TIME <>", value, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeGreaterThan(Date value) {
            addCriterion("DEAL_DATE_TIME >", value, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DEAL_DATE_TIME >=", value, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeLessThan(Date value) {
            addCriterion("DEAL_DATE_TIME <", value, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("DEAL_DATE_TIME <=", value, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeIn(List<Date> values) {
            addCriterion("DEAL_DATE_TIME in", values, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeNotIn(List<Date> values) {
            addCriterion("DEAL_DATE_TIME not in", values, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeBetween(Date value1, Date value2) {
            addCriterion("DEAL_DATE_TIME between", value1, value2, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andDealDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("DEAL_DATE_TIME not between", value1, value2, "dealDateTime");
            return (Criteria) this;
        }

        public Criteria andMultipleIsNull() {
            addCriterion("MULTIPLE is null");
            return (Criteria) this;
        }

        public Criteria andMultipleIsNotNull() {
            addCriterion("MULTIPLE is not null");
            return (Criteria) this;
        }

        public Criteria andMultipleEqualTo(Integer value) {
            addCriterion("MULTIPLE =", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotEqualTo(Integer value) {
            addCriterion("MULTIPLE <>", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThan(Integer value) {
            addCriterion("MULTIPLE >", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThanOrEqualTo(Integer value) {
            addCriterion("MULTIPLE >=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThan(Integer value) {
            addCriterion("MULTIPLE <", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThanOrEqualTo(Integer value) {
            addCriterion("MULTIPLE <=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleIn(List<Integer> values) {
            addCriterion("MULTIPLE in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotIn(List<Integer> values) {
            addCriterion("MULTIPLE not in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleBetween(Integer value1, Integer value2) {
            addCriterion("MULTIPLE between", value1, value2, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotBetween(Integer value1, Integer value2) {
            addCriterion("MULTIPLE not between", value1, value2, "multiple");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNull() {
            addCriterion("PLAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNotNull() {
            addCriterion("PLAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeEqualTo(Integer value) {
            addCriterion("PLAY_TYPE =", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotEqualTo(Integer value) {
            addCriterion("PLAY_TYPE <>", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThan(Integer value) {
            addCriterion("PLAY_TYPE >", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAY_TYPE >=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThan(Integer value) {
            addCriterion("PLAY_TYPE <", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PLAY_TYPE <=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIn(List<Integer> values) {
            addCriterion("PLAY_TYPE in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotIn(List<Integer> values) {
            addCriterion("PLAY_TYPE not in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_TYPE between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_TYPE not between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andIsBingoIsNull() {
            addCriterion("IS_BINGO is null");
            return (Criteria) this;
        }

        public Criteria andIsBingoIsNotNull() {
            addCriterion("IS_BINGO is not null");
            return (Criteria) this;
        }

        public Criteria andIsBingoEqualTo(Integer value) {
            addCriterion("IS_BINGO =", value, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoNotEqualTo(Integer value) {
            addCriterion("IS_BINGO <>", value, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoGreaterThan(Integer value) {
            addCriterion("IS_BINGO >", value, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_BINGO >=", value, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoLessThan(Integer value) {
            addCriterion("IS_BINGO <", value, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoLessThanOrEqualTo(Integer value) {
            addCriterion("IS_BINGO <=", value, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoIn(List<Integer> values) {
            addCriterion("IS_BINGO in", values, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoNotIn(List<Integer> values) {
            addCriterion("IS_BINGO not in", values, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoBetween(Integer value1, Integer value2) {
            addCriterion("IS_BINGO between", value1, value2, "isBingo");
            return (Criteria) this;
        }

        public Criteria andIsBingoNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_BINGO not between", value1, value2, "isBingo");
            return (Criteria) this;
        }

        public Criteria andBingoAmountIsNull() {
            addCriterion("BINGO_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBingoAmountIsNotNull() {
            addCriterion("BINGO_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBingoAmountEqualTo(Double value) {
            addCriterion("BINGO_AMOUNT =", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountNotEqualTo(Double value) {
            addCriterion("BINGO_AMOUNT <>", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountGreaterThan(Double value) {
            addCriterion("BINGO_AMOUNT >", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("BINGO_AMOUNT >=", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountLessThan(Double value) {
            addCriterion("BINGO_AMOUNT <", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountLessThanOrEqualTo(Double value) {
            addCriterion("BINGO_AMOUNT <=", value, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountIn(List<Double> values) {
            addCriterion("BINGO_AMOUNT in", values, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountNotIn(List<Double> values) {
            addCriterion("BINGO_AMOUNT not in", values, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountBetween(Double value1, Double value2) {
            addCriterion("BINGO_AMOUNT between", value1, value2, "bingoAmount");
            return (Criteria) this;
        }

        public Criteria andBingoAmountNotBetween(Double value1, Double value2) {
            addCriterion("BINGO_AMOUNT not between", value1, value2, "bingoAmount");
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

        public Criteria andAddAttributeIsNull() {
            addCriterion("ADD_ATTRIBUTE is null");
            return (Criteria) this;
        }

        public Criteria andAddAttributeIsNotNull() {
            addCriterion("ADD_ATTRIBUTE is not null");
            return (Criteria) this;
        }

        public Criteria andAddAttributeEqualTo(String value) {
            addCriterion("ADD_ATTRIBUTE =", value, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeNotEqualTo(String value) {
            addCriterion("ADD_ATTRIBUTE <>", value, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeGreaterThan(String value) {
            addCriterion("ADD_ATTRIBUTE >", value, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_ATTRIBUTE >=", value, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeLessThan(String value) {
            addCriterion("ADD_ATTRIBUTE <", value, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeLessThanOrEqualTo(String value) {
            addCriterion("ADD_ATTRIBUTE <=", value, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeLike(String value) {
            addCriterion("ADD_ATTRIBUTE like", value, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeNotLike(String value) {
            addCriterion("ADD_ATTRIBUTE not like", value, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeIn(List<String> values) {
            addCriterion("ADD_ATTRIBUTE in", values, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeNotIn(List<String> values) {
            addCriterion("ADD_ATTRIBUTE not in", values, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeBetween(String value1, String value2) {
            addCriterion("ADD_ATTRIBUTE between", value1, value2, "addAttribute");
            return (Criteria) this;
        }

        public Criteria andAddAttributeNotBetween(String value1, String value2) {
            addCriterion("ADD_ATTRIBUTE not between", value1, value2, "addAttribute");
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

        public Criteria andOutIdIsNull() {
            addCriterion("OUT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOutIdIsNotNull() {
            addCriterion("OUT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOutIdEqualTo(String value) {
            addCriterion("OUT_ID =", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotEqualTo(String value) {
            addCriterion("OUT_ID <>", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdGreaterThan(String value) {
            addCriterion("OUT_ID >", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_ID >=", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLessThan(String value) {
            addCriterion("OUT_ID <", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLessThanOrEqualTo(String value) {
            addCriterion("OUT_ID <=", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLike(String value) {
            addCriterion("OUT_ID like", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotLike(String value) {
            addCriterion("OUT_ID not like", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdIn(List<String> values) {
            addCriterion("OUT_ID in", values, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotIn(List<String> values) {
            addCriterion("OUT_ID not in", values, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdBetween(String value1, String value2) {
            addCriterion("OUT_ID between", value1, value2, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotBetween(String value1, String value2) {
            addCriterion("OUT_ID not between", value1, value2, "outId");
            return (Criteria) this;
        }

        public Criteria andNoInBatchIsNull() {
            addCriterion("NO_IN_BATCH is null");
            return (Criteria) this;
        }

        public Criteria andNoInBatchIsNotNull() {
            addCriterion("NO_IN_BATCH is not null");
            return (Criteria) this;
        }

        public Criteria andNoInBatchEqualTo(Integer value) {
            addCriterion("NO_IN_BATCH =", value, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchNotEqualTo(Integer value) {
            addCriterion("NO_IN_BATCH <>", value, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchGreaterThan(Integer value) {
            addCriterion("NO_IN_BATCH >", value, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchGreaterThanOrEqualTo(Integer value) {
            addCriterion("NO_IN_BATCH >=", value, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchLessThan(Integer value) {
            addCriterion("NO_IN_BATCH <", value, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchLessThanOrEqualTo(Integer value) {
            addCriterion("NO_IN_BATCH <=", value, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchIn(List<Integer> values) {
            addCriterion("NO_IN_BATCH in", values, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchNotIn(List<Integer> values) {
            addCriterion("NO_IN_BATCH not in", values, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchBetween(Integer value1, Integer value2) {
            addCriterion("NO_IN_BATCH between", value1, value2, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andNoInBatchNotBetween(Integer value1, Integer value2) {
            addCriterion("NO_IN_BATCH not between", value1, value2, "noInBatch");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("BATCH_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("BATCH_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("BATCH_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("BATCH_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("BATCH_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("BATCH_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("BATCH_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("BATCH_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("BATCH_NO not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andIsConvertIsNull() {
            addCriterion("IS_CONVERT is null");
            return (Criteria) this;
        }

        public Criteria andIsConvertIsNotNull() {
            addCriterion("IS_CONVERT is not null");
            return (Criteria) this;
        }

        public Criteria andIsConvertEqualTo(Integer value) {
            addCriterion("IS_CONVERT =", value, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertNotEqualTo(Integer value) {
            addCriterion("IS_CONVERT <>", value, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertGreaterThan(Integer value) {
            addCriterion("IS_CONVERT >", value, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_CONVERT >=", value, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertLessThan(Integer value) {
            addCriterion("IS_CONVERT <", value, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertLessThanOrEqualTo(Integer value) {
            addCriterion("IS_CONVERT <=", value, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertIn(List<Integer> values) {
            addCriterion("IS_CONVERT in", values, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertNotIn(List<Integer> values) {
            addCriterion("IS_CONVERT not in", values, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertBetween(Integer value1, Integer value2) {
            addCriterion("IS_CONVERT between", value1, value2, "isConvert");
            return (Criteria) this;
        }

        public Criteria andIsConvertNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_CONVERT not between", value1, value2, "isConvert");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeIsNull() {
            addCriterion("CONVERT_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeIsNotNull() {
            addCriterion("CONVERT_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeEqualTo(Date value) {
            addCriterion("CONVERT_DATE_TIME =", value, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeNotEqualTo(Date value) {
            addCriterion("CONVERT_DATE_TIME <>", value, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeGreaterThan(Date value) {
            addCriterion("CONVERT_DATE_TIME >", value, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CONVERT_DATE_TIME >=", value, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeLessThan(Date value) {
            addCriterion("CONVERT_DATE_TIME <", value, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CONVERT_DATE_TIME <=", value, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeIn(List<Date> values) {
            addCriterion("CONVERT_DATE_TIME in", values, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeNotIn(List<Date> values) {
            addCriterion("CONVERT_DATE_TIME not in", values, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeBetween(Date value1, Date value2) {
            addCriterion("CONVERT_DATE_TIME between", value1, value2, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andConvertDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CONVERT_DATE_TIME not between", value1, value2, "convertDateTime");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNull() {
            addCriterion("SERIAL_NO is null");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNotNull() {
            addCriterion("SERIAL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNoEqualTo(String value) {
            addCriterion("SERIAL_NO =", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotEqualTo(String value) {
            addCriterion("SERIAL_NO <>", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThan(String value) {
            addCriterion("SERIAL_NO >", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("SERIAL_NO >=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThan(String value) {
            addCriterion("SERIAL_NO <", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThanOrEqualTo(String value) {
            addCriterion("SERIAL_NO <=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLike(String value) {
            addCriterion("SERIAL_NO like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotLike(String value) {
            addCriterion("SERIAL_NO not like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoIn(List<String> values) {
            addCriterion("SERIAL_NO in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotIn(List<String> values) {
            addCriterion("SERIAL_NO not in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoBetween(String value1, String value2) {
            addCriterion("SERIAL_NO between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotBetween(String value1, String value2) {
            addCriterion("SERIAL_NO not between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andProviderIsNull() {
            addCriterion("PROVIDER is null");
            return (Criteria) this;
        }

        public Criteria andProviderIsNotNull() {
            addCriterion("PROVIDER is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEqualTo(Integer value) {
            addCriterion("PROVIDER =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(Integer value) {
            addCriterion("PROVIDER <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(Integer value) {
            addCriterion("PROVIDER >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROVIDER >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(Integer value) {
            addCriterion("PROVIDER <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(Integer value) {
            addCriterion("PROVIDER <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(List<Integer> values) {
            addCriterion("PROVIDER in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(List<Integer> values) {
            addCriterion("PROVIDER not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(Integer value1, Integer value2) {
            addCriterion("PROVIDER between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(Integer value1, Integer value2) {
            addCriterion("PROVIDER not between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNull() {
            addCriterion("ERROR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNotNull() {
            addCriterion("ERROR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeEqualTo(Integer value) {
            addCriterion("ERROR_CODE =", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotEqualTo(Integer value) {
            addCriterion("ERROR_CODE <>", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThan(Integer value) {
            addCriterion("ERROR_CODE >", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERROR_CODE >=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThan(Integer value) {
            addCriterion("ERROR_CODE <", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThanOrEqualTo(Integer value) {
            addCriterion("ERROR_CODE <=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIn(List<Integer> values) {
            addCriterion("ERROR_CODE in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotIn(List<Integer> values) {
            addCriterion("ERROR_CODE not in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_CODE between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_CODE not between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andWinStatusIsNull() {
            addCriterion("WIN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWinStatusIsNotNull() {
            addCriterion("WIN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWinStatusEqualTo(Integer value) {
            addCriterion("WIN_STATUS =", value, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusNotEqualTo(Integer value) {
            addCriterion("WIN_STATUS <>", value, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusGreaterThan(Integer value) {
            addCriterion("WIN_STATUS >", value, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("WIN_STATUS >=", value, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusLessThan(Integer value) {
            addCriterion("WIN_STATUS <", value, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusLessThanOrEqualTo(Integer value) {
            addCriterion("WIN_STATUS <=", value, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusIn(List<Integer> values) {
            addCriterion("WIN_STATUS in", values, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusNotIn(List<Integer> values) {
            addCriterion("WIN_STATUS not in", values, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusBetween(Integer value1, Integer value2) {
            addCriterion("WIN_STATUS between", value1, value2, "winStatus");
            return (Criteria) this;
        }

        public Criteria andWinStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("WIN_STATUS not between", value1, value2, "winStatus");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeIsNull() {
            addCriterion("open_result_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeIsNotNull() {
            addCriterion("open_result_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeEqualTo(Date value) {
            addCriterion("open_result_time =", value, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeNotEqualTo(Date value) {
            addCriterion("open_result_time <>", value, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeGreaterThan(Date value) {
            addCriterion("open_result_time >", value, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_result_time >=", value, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeLessThan(Date value) {
            addCriterion("open_result_time <", value, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_result_time <=", value, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeIn(List<Date> values) {
            addCriterion("open_result_time in", values, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeNotIn(List<Date> values) {
            addCriterion("open_result_time not in", values, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeBetween(Date value1, Date value2) {
            addCriterion("open_result_time between", value1, value2, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andOpenResultTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_result_time not between", value1, value2, "openResultTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeIsNull() {
            addCriterion("return_prize_time is null");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeIsNotNull() {
            addCriterion("return_prize_time is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeEqualTo(Date value) {
            addCriterion("return_prize_time =", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeNotEqualTo(Date value) {
            addCriterion("return_prize_time <>", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeGreaterThan(Date value) {
            addCriterion("return_prize_time >", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("return_prize_time >=", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeLessThan(Date value) {
            addCriterion("return_prize_time <", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeLessThanOrEqualTo(Date value) {
            addCriterion("return_prize_time <=", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeIn(List<Date> values) {
            addCriterion("return_prize_time in", values, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeNotIn(List<Date> values) {
            addCriterion("return_prize_time not in", values, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeBetween(Date value1, Date value2) {
            addCriterion("return_prize_time between", value1, value2, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeNotBetween(Date value1, Date value2) {
            addCriterion("return_prize_time not between", value1, value2, "returnPrizeTime");
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