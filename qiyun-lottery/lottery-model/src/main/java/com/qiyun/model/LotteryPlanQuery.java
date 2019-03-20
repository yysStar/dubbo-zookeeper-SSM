package com.qiyun.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LotteryPlanQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryPlanQuery() {
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

        public Criteria andPlanTypeIsNull() {
            addCriterion("PLAN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("PLAN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(Integer value) {
            addCriterion("PLAN_TYPE =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(Integer value) {
            addCriterion("PLAN_TYPE <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(Integer value) {
            addCriterion("PLAN_TYPE >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAN_TYPE >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(Integer value) {
            addCriterion("PLAN_TYPE <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PLAN_TYPE <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<Integer> values) {
            addCriterion("PLAN_TYPE in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<Integer> values) {
            addCriterion("PLAN_TYPE not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_TYPE between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_TYPE not between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeIsNull() {
            addCriterion("SELECT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSelectTypeIsNotNull() {
            addCriterion("SELECT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSelectTypeEqualTo(Integer value) {
            addCriterion("SELECT_TYPE =", value, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeNotEqualTo(Integer value) {
            addCriterion("SELECT_TYPE <>", value, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeGreaterThan(Integer value) {
            addCriterion("SELECT_TYPE >", value, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SELECT_TYPE >=", value, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeLessThan(Integer value) {
            addCriterion("SELECT_TYPE <", value, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SELECT_TYPE <=", value, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeIn(List<Integer> values) {
            addCriterion("SELECT_TYPE in", values, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeNotIn(List<Integer> values) {
            addCriterion("SELECT_TYPE not in", values, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeBetween(Integer value1, Integer value2) {
            addCriterion("SELECT_TYPE between", value1, value2, "selectType");
            return (Criteria) this;
        }

        public Criteria andSelectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SELECT_TYPE not between", value1, value2, "selectType");
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

        public Criteria andPerAmountIsNull() {
            addCriterion("PER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPerAmountIsNotNull() {
            addCriterion("PER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPerAmountEqualTo(Integer value) {
            addCriterion("PER_AMOUNT =", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotEqualTo(Integer value) {
            addCriterion("PER_AMOUNT <>", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountGreaterThan(Integer value) {
            addCriterion("PER_AMOUNT >", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PER_AMOUNT >=", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountLessThan(Integer value) {
            addCriterion("PER_AMOUNT <", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountLessThanOrEqualTo(Integer value) {
            addCriterion("PER_AMOUNT <=", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountIn(List<Integer> values) {
            addCriterion("PER_AMOUNT in", values, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotIn(List<Integer> values) {
            addCriterion("PER_AMOUNT not in", values, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountBetween(Integer value1, Integer value2) {
            addCriterion("PER_AMOUNT between", value1, value2, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("PER_AMOUNT not between", value1, value2, "perAmount");
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

        public Criteria andSoldPartIsNull() {
            addCriterion("SOLD_PART is null");
            return (Criteria) this;
        }

        public Criteria andSoldPartIsNotNull() {
            addCriterion("SOLD_PART is not null");
            return (Criteria) this;
        }

        public Criteria andSoldPartEqualTo(Integer value) {
            addCriterion("SOLD_PART =", value, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartNotEqualTo(Integer value) {
            addCriterion("SOLD_PART <>", value, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartGreaterThan(Integer value) {
            addCriterion("SOLD_PART >", value, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOLD_PART >=", value, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartLessThan(Integer value) {
            addCriterion("SOLD_PART <", value, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartLessThanOrEqualTo(Integer value) {
            addCriterion("SOLD_PART <=", value, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartIn(List<Integer> values) {
            addCriterion("SOLD_PART in", values, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartNotIn(List<Integer> values) {
            addCriterion("SOLD_PART not in", values, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartBetween(Integer value1, Integer value2) {
            addCriterion("SOLD_PART between", value1, value2, "soldPart");
            return (Criteria) this;
        }

        public Criteria andSoldPartNotBetween(Integer value1, Integer value2) {
            addCriterion("SOLD_PART not between", value1, value2, "soldPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartIsNull() {
            addCriterion("FOUNDER_PART is null");
            return (Criteria) this;
        }

        public Criteria andFounderPartIsNotNull() {
            addCriterion("FOUNDER_PART is not null");
            return (Criteria) this;
        }

        public Criteria andFounderPartEqualTo(Integer value) {
            addCriterion("FOUNDER_PART =", value, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartNotEqualTo(Integer value) {
            addCriterion("FOUNDER_PART <>", value, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartGreaterThan(Integer value) {
            addCriterion("FOUNDER_PART >", value, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartGreaterThanOrEqualTo(Integer value) {
            addCriterion("FOUNDER_PART >=", value, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartLessThan(Integer value) {
            addCriterion("FOUNDER_PART <", value, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartLessThanOrEqualTo(Integer value) {
            addCriterion("FOUNDER_PART <=", value, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartIn(List<Integer> values) {
            addCriterion("FOUNDER_PART in", values, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartNotIn(List<Integer> values) {
            addCriterion("FOUNDER_PART not in", values, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartBetween(Integer value1, Integer value2) {
            addCriterion("FOUNDER_PART between", value1, value2, "founderPart");
            return (Criteria) this;
        }

        public Criteria andFounderPartNotBetween(Integer value1, Integer value2) {
            addCriterion("FOUNDER_PART not between", value1, value2, "founderPart");
            return (Criteria) this;
        }

        public Criteria andReservePartIsNull() {
            addCriterion("RESERVE_PART is null");
            return (Criteria) this;
        }

        public Criteria andReservePartIsNotNull() {
            addCriterion("RESERVE_PART is not null");
            return (Criteria) this;
        }

        public Criteria andReservePartEqualTo(Integer value) {
            addCriterion("RESERVE_PART =", value, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartNotEqualTo(Integer value) {
            addCriterion("RESERVE_PART <>", value, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartGreaterThan(Integer value) {
            addCriterion("RESERVE_PART >", value, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESERVE_PART >=", value, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartLessThan(Integer value) {
            addCriterion("RESERVE_PART <", value, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartLessThanOrEqualTo(Integer value) {
            addCriterion("RESERVE_PART <=", value, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartIn(List<Integer> values) {
            addCriterion("RESERVE_PART in", values, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartNotIn(List<Integer> values) {
            addCriterion("RESERVE_PART not in", values, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartBetween(Integer value1, Integer value2) {
            addCriterion("RESERVE_PART between", value1, value2, "reservePart");
            return (Criteria) this;
        }

        public Criteria andReservePartNotBetween(Integer value1, Integer value2) {
            addCriterion("RESERVE_PART not between", value1, value2, "reservePart");
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

        public Criteria andPlanStatusIsNull() {
            addCriterion("PLAN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNotNull() {
            addCriterion("PLAN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusEqualTo(Integer value) {
            addCriterion("PLAN_STATUS =", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotEqualTo(Integer value) {
            addCriterion("PLAN_STATUS <>", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThan(Integer value) {
            addCriterion("PLAN_STATUS >", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAN_STATUS >=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThan(Integer value) {
            addCriterion("PLAN_STATUS <", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThanOrEqualTo(Integer value) {
            addCriterion("PLAN_STATUS <=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIn(List<Integer> values) {
            addCriterion("PLAN_STATUS in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotIn(List<Integer> values) {
            addCriterion("PLAN_STATUS not in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_STATUS between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_STATUS not between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeIsNull() {
            addCriterion("PRINT_TICKET_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeIsNotNull() {
            addCriterion("PRINT_TICKET_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeEqualTo(Date value) {
            addCriterion("PRINT_TICKET_DATE_TIME =", value, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeNotEqualTo(Date value) {
            addCriterion("PRINT_TICKET_DATE_TIME <>", value, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeGreaterThan(Date value) {
            addCriterion("PRINT_TICKET_DATE_TIME >", value, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PRINT_TICKET_DATE_TIME >=", value, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeLessThan(Date value) {
            addCriterion("PRINT_TICKET_DATE_TIME <", value, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("PRINT_TICKET_DATE_TIME <=", value, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeIn(List<Date> values) {
            addCriterion("PRINT_TICKET_DATE_TIME in", values, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeNotIn(List<Date> values) {
            addCriterion("PRINT_TICKET_DATE_TIME not in", values, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeBetween(Date value1, Date value2) {
            addCriterion("PRINT_TICKET_DATE_TIME between", value1, value2, "printTicketDateTime");
            return (Criteria) this;
        }

        public Criteria andPrintTicketDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("PRINT_TICKET_DATE_TIME not between", value1, value2, "printTicketDateTime");
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

        public Criteria andPretaxPrizeIsNull() {
            addCriterion("PRETAX_PRIZE is null");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeIsNotNull() {
            addCriterion("PRETAX_PRIZE is not null");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeEqualTo(BigDecimal value) {
            addCriterion("PRETAX_PRIZE =", value, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeNotEqualTo(BigDecimal value) {
            addCriterion("PRETAX_PRIZE <>", value, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeGreaterThan(BigDecimal value) {
            addCriterion("PRETAX_PRIZE >", value, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRETAX_PRIZE >=", value, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeLessThan(BigDecimal value) {
            addCriterion("PRETAX_PRIZE <", value, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRETAX_PRIZE <=", value, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeIn(List<BigDecimal> values) {
            addCriterion("PRETAX_PRIZE in", values, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeNotIn(List<BigDecimal> values) {
            addCriterion("PRETAX_PRIZE not in", values, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRETAX_PRIZE between", value1, value2, "pretaxPrize");
            return (Criteria) this;
        }

        public Criteria andPretaxPrizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRETAX_PRIZE not between", value1, value2, "pretaxPrize");
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

        public Criteria andPosttaxPrizeEqualTo(BigDecimal value) {
            addCriterion("POSTTAX_PRIZE =", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeNotEqualTo(BigDecimal value) {
            addCriterion("POSTTAX_PRIZE <>", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeGreaterThan(BigDecimal value) {
            addCriterion("POSTTAX_PRIZE >", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("POSTTAX_PRIZE >=", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeLessThan(BigDecimal value) {
            addCriterion("POSTTAX_PRIZE <", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("POSTTAX_PRIZE <=", value, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeIn(List<BigDecimal> values) {
            addCriterion("POSTTAX_PRIZE in", values, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeNotIn(List<BigDecimal> values) {
            addCriterion("POSTTAX_PRIZE not in", values, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POSTTAX_PRIZE between", value1, value2, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andPosttaxPrizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POSTTAX_PRIZE not between", value1, value2, "posttaxPrize");
            return (Criteria) this;
        }

        public Criteria andClicksIsNull() {
            addCriterion("CLICKS is null");
            return (Criteria) this;
        }

        public Criteria andClicksIsNotNull() {
            addCriterion("CLICKS is not null");
            return (Criteria) this;
        }

        public Criteria andClicksEqualTo(Integer value) {
            addCriterion("CLICKS =", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotEqualTo(Integer value) {
            addCriterion("CLICKS <>", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThan(Integer value) {
            addCriterion("CLICKS >", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLICKS >=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThan(Integer value) {
            addCriterion("CLICKS <", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThanOrEqualTo(Integer value) {
            addCriterion("CLICKS <=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksIn(List<Integer> values) {
            addCriterion("CLICKS in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotIn(List<Integer> values) {
            addCriterion("CLICKS not in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksBetween(Integer value1, Integer value2) {
            addCriterion("CLICKS between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotBetween(Integer value1, Integer value2) {
            addCriterion("CLICKS not between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andPlanDescIsNull() {
            addCriterion("PLAN_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPlanDescIsNotNull() {
            addCriterion("PLAN_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDescEqualTo(String value) {
            addCriterion("PLAN_DESC =", value, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescNotEqualTo(String value) {
            addCriterion("PLAN_DESC <>", value, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescGreaterThan(String value) {
            addCriterion("PLAN_DESC >", value, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_DESC >=", value, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescLessThan(String value) {
            addCriterion("PLAN_DESC <", value, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescLessThanOrEqualTo(String value) {
            addCriterion("PLAN_DESC <=", value, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescLike(String value) {
            addCriterion("PLAN_DESC like", value, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescNotLike(String value) {
            addCriterion("PLAN_DESC not like", value, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescIn(List<String> values) {
            addCriterion("PLAN_DESC in", values, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescNotIn(List<String> values) {
            addCriterion("PLAN_DESC not in", values, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescBetween(String value1, String value2) {
            addCriterion("PLAN_DESC between", value1, value2, "planDesc");
            return (Criteria) this;
        }

        public Criteria andPlanDescNotBetween(String value1, String value2) {
            addCriterion("PLAN_DESC not between", value1, value2, "planDesc");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentIsNull() {
            addCriterion("IS_UPLOAD_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentIsNotNull() {
            addCriterion("IS_UPLOAD_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentEqualTo(Integer value) {
            addCriterion("IS_UPLOAD_CONTENT =", value, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentNotEqualTo(Integer value) {
            addCriterion("IS_UPLOAD_CONTENT <>", value, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentGreaterThan(Integer value) {
            addCriterion("IS_UPLOAD_CONTENT >", value, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_UPLOAD_CONTENT >=", value, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentLessThan(Integer value) {
            addCriterion("IS_UPLOAD_CONTENT <", value, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentLessThanOrEqualTo(Integer value) {
            addCriterion("IS_UPLOAD_CONTENT <=", value, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentIn(List<Integer> values) {
            addCriterion("IS_UPLOAD_CONTENT in", values, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentNotIn(List<Integer> values) {
            addCriterion("IS_UPLOAD_CONTENT not in", values, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentBetween(Integer value1, Integer value2) {
            addCriterion("IS_UPLOAD_CONTENT between", value1, value2, "isUploadContent");
            return (Criteria) this;
        }

        public Criteria andIsUploadContentNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_UPLOAD_CONTENT not between", value1, value2, "isUploadContent");
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

        public Criteria andIsSuperManIsNull() {
            addCriterion("IS_SUPER_MAN is null");
            return (Criteria) this;
        }

        public Criteria andIsSuperManIsNotNull() {
            addCriterion("IS_SUPER_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuperManEqualTo(Integer value) {
            addCriterion("IS_SUPER_MAN =", value, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManNotEqualTo(Integer value) {
            addCriterion("IS_SUPER_MAN <>", value, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManGreaterThan(Integer value) {
            addCriterion("IS_SUPER_MAN >", value, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_SUPER_MAN >=", value, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManLessThan(Integer value) {
            addCriterion("IS_SUPER_MAN <", value, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManLessThanOrEqualTo(Integer value) {
            addCriterion("IS_SUPER_MAN <=", value, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManIn(List<Integer> values) {
            addCriterion("IS_SUPER_MAN in", values, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManNotIn(List<Integer> values) {
            addCriterion("IS_SUPER_MAN not in", values, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManBetween(Integer value1, Integer value2) {
            addCriterion("IS_SUPER_MAN between", value1, value2, "isSuperMan");
            return (Criteria) this;
        }

        public Criteria andIsSuperManNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_SUPER_MAN not between", value1, value2, "isSuperMan");
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

        public Criteria andIsTopIsNull() {
            addCriterion("IS_TOP is null");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNotNull() {
            addCriterion("IS_TOP is not null");
            return (Criteria) this;
        }

        public Criteria andIsTopEqualTo(Integer value) {
            addCriterion("IS_TOP =", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotEqualTo(Integer value) {
            addCriterion("IS_TOP <>", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThan(Integer value) {
            addCriterion("IS_TOP >", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_TOP >=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThan(Integer value) {
            addCriterion("IS_TOP <", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThanOrEqualTo(Integer value) {
            addCriterion("IS_TOP <=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopIn(List<Integer> values) {
            addCriterion("IS_TOP in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotIn(List<Integer> values) {
            addCriterion("IS_TOP not in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopBetween(Integer value1, Integer value2) {
            addCriterion("IS_TOP between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_TOP not between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("MODEL is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(Integer value) {
            addCriterion("MODEL =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(Integer value) {
            addCriterion("MODEL <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(Integer value) {
            addCriterion("MODEL >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODEL >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(Integer value) {
            addCriterion("MODEL <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(Integer value) {
            addCriterion("MODEL <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<Integer> values) {
            addCriterion("MODEL in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<Integer> values) {
            addCriterion("MODEL not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(Integer value1, Integer value2) {
            addCriterion("MODEL between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(Integer value1, Integer value2) {
            addCriterion("MODEL not between", value1, value2, "model");
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

        public Criteria andPublicStatusIsNull() {
            addCriterion("PUBLIC_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPublicStatusIsNotNull() {
            addCriterion("PUBLIC_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPublicStatusEqualTo(Integer value) {
            addCriterion("PUBLIC_STATUS =", value, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusNotEqualTo(Integer value) {
            addCriterion("PUBLIC_STATUS <>", value, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusGreaterThan(Integer value) {
            addCriterion("PUBLIC_STATUS >", value, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUBLIC_STATUS >=", value, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusLessThan(Integer value) {
            addCriterion("PUBLIC_STATUS <", value, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusLessThanOrEqualTo(Integer value) {
            addCriterion("PUBLIC_STATUS <=", value, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusIn(List<Integer> values) {
            addCriterion("PUBLIC_STATUS in", values, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusNotIn(List<Integer> values) {
            addCriterion("PUBLIC_STATUS not in", values, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusBetween(Integer value1, Integer value2) {
            addCriterion("PUBLIC_STATUS between", value1, value2, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andPublicStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PUBLIC_STATUS not between", value1, value2, "publicStatus");
            return (Criteria) this;
        }

        public Criteria andCommisionIsNull() {
            addCriterion("COMMISION is null");
            return (Criteria) this;
        }

        public Criteria andCommisionIsNotNull() {
            addCriterion("COMMISION is not null");
            return (Criteria) this;
        }

        public Criteria andCommisionEqualTo(Integer value) {
            addCriterion("COMMISION =", value, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionNotEqualTo(Integer value) {
            addCriterion("COMMISION <>", value, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionGreaterThan(Integer value) {
            addCriterion("COMMISION >", value, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMISION >=", value, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionLessThan(Integer value) {
            addCriterion("COMMISION <", value, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionLessThanOrEqualTo(Integer value) {
            addCriterion("COMMISION <=", value, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionIn(List<Integer> values) {
            addCriterion("COMMISION in", values, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionNotIn(List<Integer> values) {
            addCriterion("COMMISION not in", values, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionBetween(Integer value1, Integer value2) {
            addCriterion("COMMISION between", value1, value2, "commision");
            return (Criteria) this;
        }

        public Criteria andCommisionNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMISION not between", value1, value2, "commision");
            return (Criteria) this;
        }

        public Criteria andGenTypeIsNull() {
            addCriterion("GEN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andGenTypeIsNotNull() {
            addCriterion("GEN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andGenTypeEqualTo(Integer value) {
            addCriterion("GEN_TYPE =", value, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeNotEqualTo(Integer value) {
            addCriterion("GEN_TYPE <>", value, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeGreaterThan(Integer value) {
            addCriterion("GEN_TYPE >", value, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("GEN_TYPE >=", value, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeLessThan(Integer value) {
            addCriterion("GEN_TYPE <", value, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeLessThanOrEqualTo(Integer value) {
            addCriterion("GEN_TYPE <=", value, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeIn(List<Integer> values) {
            addCriterion("GEN_TYPE in", values, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeNotIn(List<Integer> values) {
            addCriterion("GEN_TYPE not in", values, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeBetween(Integer value1, Integer value2) {
            addCriterion("GEN_TYPE between", value1, value2, "genType");
            return (Criteria) this;
        }

        public Criteria andGenTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("GEN_TYPE not between", value1, value2, "genType");
            return (Criteria) this;
        }

        public Criteria andBookCountIsNull() {
            addCriterion("BOOK_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andBookCountIsNotNull() {
            addCriterion("BOOK_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBookCountEqualTo(Integer value) {
            addCriterion("BOOK_COUNT =", value, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountNotEqualTo(Integer value) {
            addCriterion("BOOK_COUNT <>", value, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountGreaterThan(Integer value) {
            addCriterion("BOOK_COUNT >", value, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOOK_COUNT >=", value, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountLessThan(Integer value) {
            addCriterion("BOOK_COUNT <", value, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountLessThanOrEqualTo(Integer value) {
            addCriterion("BOOK_COUNT <=", value, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountIn(List<Integer> values) {
            addCriterion("BOOK_COUNT in", values, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountNotIn(List<Integer> values) {
            addCriterion("BOOK_COUNT not in", values, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_COUNT between", value1, value2, "bookCount");
            return (Criteria) this;
        }

        public Criteria andBookCountNotBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_COUNT not between", value1, value2, "bookCount");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusIsNull() {
            addCriterion("PLAN_TICKET_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusIsNotNull() {
            addCriterion("PLAN_TICKET_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusEqualTo(Integer value) {
            addCriterion("PLAN_TICKET_STATUS =", value, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusNotEqualTo(Integer value) {
            addCriterion("PLAN_TICKET_STATUS <>", value, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusGreaterThan(Integer value) {
            addCriterion("PLAN_TICKET_STATUS >", value, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAN_TICKET_STATUS >=", value, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusLessThan(Integer value) {
            addCriterion("PLAN_TICKET_STATUS <", value, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusLessThanOrEqualTo(Integer value) {
            addCriterion("PLAN_TICKET_STATUS <=", value, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusIn(List<Integer> values) {
            addCriterion("PLAN_TICKET_STATUS in", values, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusNotIn(List<Integer> values) {
            addCriterion("PLAN_TICKET_STATUS not in", values, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_TICKET_STATUS between", value1, value2, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTicketStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_TICKET_STATUS not between", value1, value2, "planTicketStatus");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingIsNull() {
            addCriterion("IS_ABLE_TICKETING is null");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingIsNotNull() {
            addCriterion("IS_ABLE_TICKETING is not null");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingEqualTo(Integer value) {
            addCriterion("IS_ABLE_TICKETING =", value, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingNotEqualTo(Integer value) {
            addCriterion("IS_ABLE_TICKETING <>", value, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingGreaterThan(Integer value) {
            addCriterion("IS_ABLE_TICKETING >", value, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_ABLE_TICKETING >=", value, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingLessThan(Integer value) {
            addCriterion("IS_ABLE_TICKETING <", value, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingLessThanOrEqualTo(Integer value) {
            addCriterion("IS_ABLE_TICKETING <=", value, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingIn(List<Integer> values) {
            addCriterion("IS_ABLE_TICKETING in", values, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingNotIn(List<Integer> values) {
            addCriterion("IS_ABLE_TICKETING not in", values, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingBetween(Integer value1, Integer value2) {
            addCriterion("IS_ABLE_TICKETING between", value1, value2, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andIsAbleTicketingNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_ABLE_TICKETING not between", value1, value2, "isAbleTicketing");
            return (Criteria) this;
        }

        public Criteria andAddPrizeIsNull() {
            addCriterion("add_prize is null");
            return (Criteria) this;
        }

        public Criteria andAddPrizeIsNotNull() {
            addCriterion("add_prize is not null");
            return (Criteria) this;
        }

        public Criteria andAddPrizeEqualTo(BigDecimal value) {
            addCriterion("add_prize =", value, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeNotEqualTo(BigDecimal value) {
            addCriterion("add_prize <>", value, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeGreaterThan(BigDecimal value) {
            addCriterion("add_prize >", value, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("add_prize >=", value, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeLessThan(BigDecimal value) {
            addCriterion("add_prize <", value, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("add_prize <=", value, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeIn(List<BigDecimal> values) {
            addCriterion("add_prize in", values, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeNotIn(List<BigDecimal> values) {
            addCriterion("add_prize not in", values, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("add_prize between", value1, value2, "addPrize");
            return (Criteria) this;
        }

        public Criteria andAddPrizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("add_prize not between", value1, value2, "addPrize");
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

        public Criteria andPlanHmOgIsNull() {
            addCriterion("PLAN_HM_OG is null");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgIsNotNull() {
            addCriterion("PLAN_HM_OG is not null");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgEqualTo(Integer value) {
            addCriterion("PLAN_HM_OG =", value, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgNotEqualTo(Integer value) {
            addCriterion("PLAN_HM_OG <>", value, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgGreaterThan(Integer value) {
            addCriterion("PLAN_HM_OG >", value, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAN_HM_OG >=", value, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgLessThan(Integer value) {
            addCriterion("PLAN_HM_OG <", value, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgLessThanOrEqualTo(Integer value) {
            addCriterion("PLAN_HM_OG <=", value, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgIn(List<Integer> values) {
            addCriterion("PLAN_HM_OG in", values, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgNotIn(List<Integer> values) {
            addCriterion("PLAN_HM_OG not in", values, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_HM_OG between", value1, value2, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andPlanHmOgNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_HM_OG not between", value1, value2, "planHmOg");
            return (Criteria) this;
        }

        public Criteria andOpenFinishIsNull() {
            addCriterion("OPEN_FINISH is null");
            return (Criteria) this;
        }

        public Criteria andOpenFinishIsNotNull() {
            addCriterion("OPEN_FINISH is not null");
            return (Criteria) this;
        }

        public Criteria andOpenFinishEqualTo(Integer value) {
            addCriterion("OPEN_FINISH =", value, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishNotEqualTo(Integer value) {
            addCriterion("OPEN_FINISH <>", value, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishGreaterThan(Integer value) {
            addCriterion("OPEN_FINISH >", value, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPEN_FINISH >=", value, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishLessThan(Integer value) {
            addCriterion("OPEN_FINISH <", value, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishLessThanOrEqualTo(Integer value) {
            addCriterion("OPEN_FINISH <=", value, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishIn(List<Integer> values) {
            addCriterion("OPEN_FINISH in", values, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishNotIn(List<Integer> values) {
            addCriterion("OPEN_FINISH not in", values, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishBetween(Integer value1, Integer value2) {
            addCriterion("OPEN_FINISH between", value1, value2, "openFinish");
            return (Criteria) this;
        }

        public Criteria andOpenFinishNotBetween(Integer value1, Integer value2) {
            addCriterion("OPEN_FINISH not between", value1, value2, "openFinish");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeIsNull() {
            addCriterion("AUTOMATIC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeIsNotNull() {
            addCriterion("AUTOMATIC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeEqualTo(String value) {
            addCriterion("AUTOMATIC_TYPE =", value, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeNotEqualTo(String value) {
            addCriterion("AUTOMATIC_TYPE <>", value, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeGreaterThan(String value) {
            addCriterion("AUTOMATIC_TYPE >", value, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeGreaterThanOrEqualTo(String value) {
            addCriterion("AUTOMATIC_TYPE >=", value, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeLessThan(String value) {
            addCriterion("AUTOMATIC_TYPE <", value, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeLessThanOrEqualTo(String value) {
            addCriterion("AUTOMATIC_TYPE <=", value, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeLike(String value) {
            addCriterion("AUTOMATIC_TYPE like", value, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeNotLike(String value) {
            addCriterion("AUTOMATIC_TYPE not like", value, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeIn(List<String> values) {
            addCriterion("AUTOMATIC_TYPE in", values, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeNotIn(List<String> values) {
            addCriterion("AUTOMATIC_TYPE not in", values, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeBetween(String value1, String value2) {
            addCriterion("AUTOMATIC_TYPE between", value1, value2, "automaticType");
            return (Criteria) this;
        }

        public Criteria andAutomaticTypeNotBetween(String value1, String value2) {
            addCriterion("AUTOMATIC_TYPE not between", value1, value2, "automaticType");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoIsNull() {
            addCriterion("out_plan_no is null");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoIsNotNull() {
            addCriterion("out_plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoEqualTo(String value) {
            addCriterion("out_plan_no =", value, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoNotEqualTo(String value) {
            addCriterion("out_plan_no <>", value, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoGreaterThan(String value) {
            addCriterion("out_plan_no >", value, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_plan_no >=", value, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoLessThan(String value) {
            addCriterion("out_plan_no <", value, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoLessThanOrEqualTo(String value) {
            addCriterion("out_plan_no <=", value, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoLike(String value) {
            addCriterion("out_plan_no like", value, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoNotLike(String value) {
            addCriterion("out_plan_no not like", value, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoIn(List<String> values) {
            addCriterion("out_plan_no in", values, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoNotIn(List<String> values) {
            addCriterion("out_plan_no not in", values, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoBetween(String value1, String value2) {
            addCriterion("out_plan_no between", value1, value2, "outPlanNo");
            return (Criteria) this;
        }

        public Criteria andOutPlanNoNotBetween(String value1, String value2) {
            addCriterion("out_plan_no not between", value1, value2, "outPlanNo");
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

        public Criteria andJoinCountIsNull() {
            addCriterion("JOIN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andJoinCountIsNotNull() {
            addCriterion("JOIN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andJoinCountEqualTo(Integer value) {
            addCriterion("JOIN_COUNT =", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotEqualTo(Integer value) {
            addCriterion("JOIN_COUNT <>", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountGreaterThan(Integer value) {
            addCriterion("JOIN_COUNT >", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOIN_COUNT >=", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountLessThan(Integer value) {
            addCriterion("JOIN_COUNT <", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountLessThanOrEqualTo(Integer value) {
            addCriterion("JOIN_COUNT <=", value, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountIn(List<Integer> values) {
            addCriterion("JOIN_COUNT in", values, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotIn(List<Integer> values) {
            addCriterion("JOIN_COUNT not in", values, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountBetween(Integer value1, Integer value2) {
            addCriterion("JOIN_COUNT between", value1, value2, "joinCount");
            return (Criteria) this;
        }

        public Criteria andJoinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("JOIN_COUNT not between", value1, value2, "joinCount");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeIsNull() {
            addCriterion("RETURN_PRIZE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeIsNotNull() {
            addCriterion("RETURN_PRIZE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeEqualTo(Date value) {
            addCriterion("RETURN_PRIZE_TIME =", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeNotEqualTo(Date value) {
            addCriterion("RETURN_PRIZE_TIME <>", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeGreaterThan(Date value) {
            addCriterion("RETURN_PRIZE_TIME >", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RETURN_PRIZE_TIME >=", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeLessThan(Date value) {
            addCriterion("RETURN_PRIZE_TIME <", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeLessThanOrEqualTo(Date value) {
            addCriterion("RETURN_PRIZE_TIME <=", value, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeIn(List<Date> values) {
            addCriterion("RETURN_PRIZE_TIME in", values, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeNotIn(List<Date> values) {
            addCriterion("RETURN_PRIZE_TIME not in", values, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeBetween(Date value1, Date value2) {
            addCriterion("RETURN_PRIZE_TIME between", value1, value2, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andReturnPrizeTimeNotBetween(Date value1, Date value2) {
            addCriterion("RETURN_PRIZE_TIME not between", value1, value2, "returnPrizeTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeIsNull() {
            addCriterion("PAY_FINISH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeIsNotNull() {
            addCriterion("PAY_FINISH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeEqualTo(Date value) {
            addCriterion("PAY_FINISH_TIME =", value, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeNotEqualTo(Date value) {
            addCriterion("PAY_FINISH_TIME <>", value, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeGreaterThan(Date value) {
            addCriterion("PAY_FINISH_TIME >", value, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PAY_FINISH_TIME >=", value, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeLessThan(Date value) {
            addCriterion("PAY_FINISH_TIME <", value, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("PAY_FINISH_TIME <=", value, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeIn(List<Date> values) {
            addCriterion("PAY_FINISH_TIME in", values, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeNotIn(List<Date> values) {
            addCriterion("PAY_FINISH_TIME not in", values, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeBetween(Date value1, Date value2) {
            addCriterion("PAY_FINISH_TIME between", value1, value2, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andPayFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("PAY_FINISH_TIME not between", value1, value2, "payFinishTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNull() {
            addCriterion("ACCEPT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("ACCEPT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterion("ACCEPT_TIME =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterion("ACCEPT_TIME <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterion("ACCEPT_TIME >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ACCEPT_TIME >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterion("ACCEPT_TIME <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterion("ACCEPT_TIME <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterion("ACCEPT_TIME in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterion("ACCEPT_TIME not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterion("ACCEPT_TIME between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterion("ACCEPT_TIME not between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeIsNull() {
            addCriterion("REFUND_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeIsNotNull() {
            addCriterion("REFUND_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeEqualTo(Date value) {
            addCriterion("REFUND_START_TIME =", value, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeNotEqualTo(Date value) {
            addCriterion("REFUND_START_TIME <>", value, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeGreaterThan(Date value) {
            addCriterion("REFUND_START_TIME >", value, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REFUND_START_TIME >=", value, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeLessThan(Date value) {
            addCriterion("REFUND_START_TIME <", value, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("REFUND_START_TIME <=", value, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeIn(List<Date> values) {
            addCriterion("REFUND_START_TIME in", values, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeNotIn(List<Date> values) {
            addCriterion("REFUND_START_TIME not in", values, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeBetween(Date value1, Date value2) {
            addCriterion("REFUND_START_TIME between", value1, value2, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andRefundStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("REFUND_START_TIME not between", value1, value2, "refundStartTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNull() {
            addCriterion("ARRIVAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNotNull() {
            addCriterion("ARRIVAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeEqualTo(Date value) {
            addCriterion("ARRIVAL_TIME =", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotEqualTo(Date value) {
            addCriterion("ARRIVAL_TIME <>", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThan(Date value) {
            addCriterion("ARRIVAL_TIME >", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ARRIVAL_TIME >=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThan(Date value) {
            addCriterion("ARRIVAL_TIME <", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThanOrEqualTo(Date value) {
            addCriterion("ARRIVAL_TIME <=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIn(List<Date> values) {
            addCriterion("ARRIVAL_TIME in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotIn(List<Date> values) {
            addCriterion("ARRIVAL_TIME not in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeBetween(Date value1, Date value2) {
            addCriterion("ARRIVAL_TIME between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotBetween(Date value1, Date value2) {
            addCriterion("ARRIVAL_TIME not between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("TRADE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("TRADE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(Integer value) {
            addCriterion("TRADE_TYPE =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(Integer value) {
            addCriterion("TRADE_TYPE <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(Integer value) {
            addCriterion("TRADE_TYPE >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRADE_TYPE >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(Integer value) {
            addCriterion("TRADE_TYPE <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TRADE_TYPE <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<Integer> values) {
            addCriterion("TRADE_TYPE in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<Integer> values) {
            addCriterion("TRADE_TYPE not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_TYPE between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_TYPE not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryIsNull() {
            addCriterion("account_documentary is null");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryIsNotNull() {
            addCriterion("account_documentary is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryEqualTo(String value) {
            addCriterion("account_documentary =", value, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryNotEqualTo(String value) {
            addCriterion("account_documentary <>", value, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryGreaterThan(String value) {
            addCriterion("account_documentary >", value, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryGreaterThanOrEqualTo(String value) {
            addCriterion("account_documentary >=", value, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryLessThan(String value) {
            addCriterion("account_documentary <", value, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryLessThanOrEqualTo(String value) {
            addCriterion("account_documentary <=", value, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryLike(String value) {
            addCriterion("account_documentary like", value, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryNotLike(String value) {
            addCriterion("account_documentary not like", value, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryIn(List<String> values) {
            addCriterion("account_documentary in", values, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryNotIn(List<String> values) {
            addCriterion("account_documentary not in", values, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryBetween(String value1, String value2) {
            addCriterion("account_documentary between", value1, value2, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andAccountDocumentaryNotBetween(String value1, String value2) {
            addCriterion("account_documentary not between", value1, value2, "accountDocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryIsNull() {
            addCriterion("planNo_copyDocumentary is null");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryIsNotNull() {
            addCriterion("planNo_copyDocumentary is not null");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryEqualTo(Integer value) {
            addCriterion("planNo_copyDocumentary =", value, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryNotEqualTo(Integer value) {
            addCriterion("planNo_copyDocumentary <>", value, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryGreaterThan(Integer value) {
            addCriterion("planNo_copyDocumentary >", value, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("planNo_copyDocumentary >=", value, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryLessThan(Integer value) {
            addCriterion("planNo_copyDocumentary <", value, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryLessThanOrEqualTo(Integer value) {
            addCriterion("planNo_copyDocumentary <=", value, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryIn(List<Integer> values) {
            addCriterion("planNo_copyDocumentary in", values, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryNotIn(List<Integer> values) {
            addCriterion("planNo_copyDocumentary not in", values, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryBetween(Integer value1, Integer value2) {
            addCriterion("planNo_copyDocumentary between", value1, value2, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andPlannoCopydocumentaryNotBetween(Integer value1, Integer value2) {
            addCriterion("planNo_copyDocumentary not between", value1, value2, "plannoCopydocumentary");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountIsNull() {
            addCriterion("haploid_amount is null");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountIsNotNull() {
            addCriterion("haploid_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountEqualTo(Integer value) {
            addCriterion("haploid_amount =", value, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountNotEqualTo(Integer value) {
            addCriterion("haploid_amount <>", value, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountGreaterThan(Integer value) {
            addCriterion("haploid_amount >", value, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("haploid_amount >=", value, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountLessThan(Integer value) {
            addCriterion("haploid_amount <", value, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountLessThanOrEqualTo(Integer value) {
            addCriterion("haploid_amount <=", value, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountIn(List<Integer> values) {
            addCriterion("haploid_amount in", values, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountNotIn(List<Integer> values) {
            addCriterion("haploid_amount not in", values, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountBetween(Integer value1, Integer value2) {
            addCriterion("haploid_amount between", value1, value2, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andHaploidAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("haploid_amount not between", value1, value2, "haploidAmount");
            return (Criteria) this;
        }

        public Criteria andSumamountIsNull() {
            addCriterion("sumAmount is null");
            return (Criteria) this;
        }

        public Criteria andSumamountIsNotNull() {
            addCriterion("sumAmount is not null");
            return (Criteria) this;
        }

        public Criteria andSumamountEqualTo(Integer value) {
            addCriterion("sumAmount =", value, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountNotEqualTo(Integer value) {
            addCriterion("sumAmount <>", value, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountGreaterThan(Integer value) {
            addCriterion("sumAmount >", value, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sumAmount >=", value, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountLessThan(Integer value) {
            addCriterion("sumAmount <", value, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountLessThanOrEqualTo(Integer value) {
            addCriterion("sumAmount <=", value, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountIn(List<Integer> values) {
            addCriterion("sumAmount in", values, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountNotIn(List<Integer> values) {
            addCriterion("sumAmount not in", values, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountBetween(Integer value1, Integer value2) {
            addCriterion("sumAmount between", value1, value2, "sumamount");
            return (Criteria) this;
        }

        public Criteria andSumamountNotBetween(Integer value1, Integer value2) {
            addCriterion("sumAmount not between", value1, value2, "sumamount");
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

        public Criteria andGoldEqualTo(BigDecimal value) {
            addCriterion("gold =", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotEqualTo(BigDecimal value) {
            addCriterion("gold <>", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThan(BigDecimal value) {
            addCriterion("gold >", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gold >=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThan(BigDecimal value) {
            addCriterion("gold <", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gold <=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldIn(List<BigDecimal> values) {
            addCriterion("gold in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotIn(List<BigDecimal> values) {
            addCriterion("gold not in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andSumGoldEqualTo(BigDecimal value) {
            addCriterion("sum_gold =", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldNotEqualTo(BigDecimal value) {
            addCriterion("sum_gold <>", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldGreaterThan(BigDecimal value) {
            addCriterion("sum_gold >", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sum_gold >=", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldLessThan(BigDecimal value) {
            addCriterion("sum_gold <", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sum_gold <=", value, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldIn(List<BigDecimal> values) {
            addCriterion("sum_gold in", values, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldNotIn(List<BigDecimal> values) {
            addCriterion("sum_gold not in", values, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sum_gold between", value1, value2, "sumGold");
            return (Criteria) this;
        }

        public Criteria andSumGoldNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andWebSiteGoldEqualTo(BigDecimal value) {
            addCriterion("web_site_gold =", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldNotEqualTo(BigDecimal value) {
            addCriterion("web_site_gold <>", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldGreaterThan(BigDecimal value) {
            addCriterion("web_site_gold >", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("web_site_gold >=", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldLessThan(BigDecimal value) {
            addCriterion("web_site_gold <", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("web_site_gold <=", value, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldIn(List<BigDecimal> values) {
            addCriterion("web_site_gold in", values, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldNotIn(List<BigDecimal> values) {
            addCriterion("web_site_gold not in", values, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("web_site_gold between", value1, value2, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andWebSiteGoldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("web_site_gold not between", value1, value2, "webSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldIsNull() {
            addCriterion("sum_web_site_gold is null");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldIsNotNull() {
            addCriterion("sum_web_site_gold is not null");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldEqualTo(BigDecimal value) {
            addCriterion("sum_web_site_gold =", value, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldNotEqualTo(BigDecimal value) {
            addCriterion("sum_web_site_gold <>", value, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldGreaterThan(BigDecimal value) {
            addCriterion("sum_web_site_gold >", value, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sum_web_site_gold >=", value, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldLessThan(BigDecimal value) {
            addCriterion("sum_web_site_gold <", value, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sum_web_site_gold <=", value, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldIn(List<BigDecimal> values) {
            addCriterion("sum_web_site_gold in", values, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldNotIn(List<BigDecimal> values) {
            addCriterion("sum_web_site_gold not in", values, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sum_web_site_gold between", value1, value2, "sumWebSiteGold");
            return (Criteria) this;
        }

        public Criteria andSumWebSiteGoldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sum_web_site_gold not between", value1, value2, "sumWebSiteGold");
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