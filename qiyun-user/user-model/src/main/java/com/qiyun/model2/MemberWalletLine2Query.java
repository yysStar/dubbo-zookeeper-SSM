package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberWalletLine2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberWalletLine2Query() {
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

        public Criteria andWalletLineNoIsNull() {
            addCriterion("wallet_Line_No is null");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoIsNotNull() {
            addCriterion("wallet_Line_No is not null");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoEqualTo(Integer value) {
            addCriterion("wallet_Line_No =", value, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoNotEqualTo(Integer value) {
            addCriterion("wallet_Line_No <>", value, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoGreaterThan(Integer value) {
            addCriterion("wallet_Line_No >", value, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_Line_No >=", value, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoLessThan(Integer value) {
            addCriterion("wallet_Line_No <", value, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_Line_No <=", value, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoIn(List<Integer> values) {
            addCriterion("wallet_Line_No in", values, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoNotIn(List<Integer> values) {
            addCriterion("wallet_Line_No not in", values, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoBetween(Integer value1, Integer value2) {
            addCriterion("wallet_Line_No between", value1, value2, "walletLineNo");
            return (Criteria) this;
        }

        public Criteria andWalletLineNoNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_Line_No not between", value1, value2, "walletLineNo");
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

        public Criteria andOperLineNoIsNull() {
            addCriterion("OPER_LINE_NO is null");
            return (Criteria) this;
        }

        public Criteria andOperLineNoIsNotNull() {
            addCriterion("OPER_LINE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOperLineNoEqualTo(Integer value) {
            addCriterion("OPER_LINE_NO =", value, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoNotEqualTo(Integer value) {
            addCriterion("OPER_LINE_NO <>", value, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoGreaterThan(Integer value) {
            addCriterion("OPER_LINE_NO >", value, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPER_LINE_NO >=", value, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoLessThan(Integer value) {
            addCriterion("OPER_LINE_NO <", value, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoLessThanOrEqualTo(Integer value) {
            addCriterion("OPER_LINE_NO <=", value, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoIn(List<Integer> values) {
            addCriterion("OPER_LINE_NO in", values, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoNotIn(List<Integer> values) {
            addCriterion("OPER_LINE_NO not in", values, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoBetween(Integer value1, Integer value2) {
            addCriterion("OPER_LINE_NO between", value1, value2, "operLineNo");
            return (Criteria) this;
        }

        public Criteria andOperLineNoNotBetween(Integer value1, Integer value2) {
            addCriterion("OPER_LINE_NO not between", value1, value2, "operLineNo");
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

        public Criteria andTransTypeIsNull() {
            addCriterion("TRANS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNotNull() {
            addCriterion("TRANS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeEqualTo(Integer value) {
            addCriterion("TRANS_TYPE =", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotEqualTo(Integer value) {
            addCriterion("TRANS_TYPE <>", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThan(Integer value) {
            addCriterion("TRANS_TYPE >", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANS_TYPE >=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThan(Integer value) {
            addCriterion("TRANS_TYPE <", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TRANS_TYPE <=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIn(List<Integer> values) {
            addCriterion("TRANS_TYPE in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotIn(List<Integer> values) {
            addCriterion("TRANS_TYPE not in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeBetween(Integer value1, Integer value2) {
            addCriterion("TRANS_TYPE between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANS_TYPE not between", value1, value2, "transType");
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

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
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

        public Criteria andSourceIdIsNull() {
            addCriterion("SOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("SOURCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Integer value) {
            addCriterion("SOURCE_ID =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Integer value) {
            addCriterion("SOURCE_ID <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Integer value) {
            addCriterion("SOURCE_ID >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_ID >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Integer value) {
            addCriterion("SOURCE_ID <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_ID <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Integer> values) {
            addCriterion("SOURCE_ID in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Integer> values) {
            addCriterion("SOURCE_ID not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_ID between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_ID not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceIsNull() {
            addCriterion("ABLE_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceIsNotNull() {
            addCriterion("ABLE_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceEqualTo(Double value) {
            addCriterion("ABLE_BALANCE =", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceNotEqualTo(Double value) {
            addCriterion("ABLE_BALANCE <>", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceGreaterThan(Double value) {
            addCriterion("ABLE_BALANCE >", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("ABLE_BALANCE >=", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceLessThan(Double value) {
            addCriterion("ABLE_BALANCE <", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceLessThanOrEqualTo(Double value) {
            addCriterion("ABLE_BALANCE <=", value, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceIn(List<Double> values) {
            addCriterion("ABLE_BALANCE in", values, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceNotIn(List<Double> values) {
            addCriterion("ABLE_BALANCE not in", values, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceBetween(Double value1, Double value2) {
            addCriterion("ABLE_BALANCE between", value1, value2, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andAbleBalanceNotBetween(Double value1, Double value2) {
            addCriterion("ABLE_BALANCE not between", value1, value2, "ableBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIsNull() {
            addCriterion("FREEZE_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIsNotNull() {
            addCriterion("FREEZE_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceEqualTo(Double value) {
            addCriterion("FREEZE_BALANCE =", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotEqualTo(Double value) {
            addCriterion("FREEZE_BALANCE <>", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceGreaterThan(Double value) {
            addCriterion("FREEZE_BALANCE >", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("FREEZE_BALANCE >=", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceLessThan(Double value) {
            addCriterion("FREEZE_BALANCE <", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceLessThanOrEqualTo(Double value) {
            addCriterion("FREEZE_BALANCE <=", value, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceIn(List<Double> values) {
            addCriterion("FREEZE_BALANCE in", values, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotIn(List<Double> values) {
            addCriterion("FREEZE_BALANCE not in", values, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceBetween(Double value1, Double value2) {
            addCriterion("FREEZE_BALANCE between", value1, value2, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andFreezeBalanceNotBetween(Double value1, Double value2) {
            addCriterion("FREEZE_BALANCE not between", value1, value2, "freezeBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceIsNull() {
            addCriterion("HEAP_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceIsNotNull() {
            addCriterion("HEAP_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceEqualTo(Double value) {
            addCriterion("HEAP_BALANCE =", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceNotEqualTo(Double value) {
            addCriterion("HEAP_BALANCE <>", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceGreaterThan(Double value) {
            addCriterion("HEAP_BALANCE >", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("HEAP_BALANCE >=", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceLessThan(Double value) {
            addCriterion("HEAP_BALANCE <", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceLessThanOrEqualTo(Double value) {
            addCriterion("HEAP_BALANCE <=", value, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceIn(List<Double> values) {
            addCriterion("HEAP_BALANCE in", values, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceNotIn(List<Double> values) {
            addCriterion("HEAP_BALANCE not in", values, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceBetween(Double value1, Double value2) {
            addCriterion("HEAP_BALANCE between", value1, value2, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andHeapBalanceNotBetween(Double value1, Double value2) {
            addCriterion("HEAP_BALANCE not between", value1, value2, "heapBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceIsNull() {
            addCriterion("PRIZE_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceIsNotNull() {
            addCriterion("PRIZE_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceEqualTo(Double value) {
            addCriterion("PRIZE_BALANCE =", value, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceNotEqualTo(Double value) {
            addCriterion("PRIZE_BALANCE <>", value, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceGreaterThan(Double value) {
            addCriterion("PRIZE_BALANCE >", value, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("PRIZE_BALANCE >=", value, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceLessThan(Double value) {
            addCriterion("PRIZE_BALANCE <", value, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceLessThanOrEqualTo(Double value) {
            addCriterion("PRIZE_BALANCE <=", value, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceIn(List<Double> values) {
            addCriterion("PRIZE_BALANCE in", values, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceNotIn(List<Double> values) {
            addCriterion("PRIZE_BALANCE not in", values, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceBetween(Double value1, Double value2) {
            addCriterion("PRIZE_BALANCE between", value1, value2, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPrizeBalanceNotBetween(Double value1, Double value2) {
            addCriterion("PRIZE_BALANCE not between", value1, value2, "prizeBalance");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("PLATFORM is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("PLATFORM is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(Integer value) {
            addCriterion("PLATFORM =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(Integer value) {
            addCriterion("PLATFORM <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(Integer value) {
            addCriterion("PLATFORM >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLATFORM >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(Integer value) {
            addCriterion("PLATFORM <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("PLATFORM <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<Integer> values) {
            addCriterion("PLATFORM in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<Integer> values) {
            addCriterion("PLATFORM not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(Integer value1, Integer value2) {
            addCriterion("PLATFORM between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("PLATFORM not between", value1, value2, "platform");
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