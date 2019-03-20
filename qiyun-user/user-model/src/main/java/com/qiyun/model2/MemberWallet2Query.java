package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class MemberWallet2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberWallet2Query() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
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

        public Criteria andTakeCashQuotaIsNull() {
            addCriterion("take_cash_quota is null");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaIsNotNull() {
            addCriterion("take_cash_quota is not null");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaEqualTo(Double value) {
            addCriterion("take_cash_quota =", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaNotEqualTo(Double value) {
            addCriterion("take_cash_quota <>", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaGreaterThan(Double value) {
            addCriterion("take_cash_quota >", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaGreaterThanOrEqualTo(Double value) {
            addCriterion("take_cash_quota >=", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaLessThan(Double value) {
            addCriterion("take_cash_quota <", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaLessThanOrEqualTo(Double value) {
            addCriterion("take_cash_quota <=", value, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaIn(List<Double> values) {
            addCriterion("take_cash_quota in", values, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaNotIn(List<Double> values) {
            addCriterion("take_cash_quota not in", values, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaBetween(Double value1, Double value2) {
            addCriterion("take_cash_quota between", value1, value2, "takeCashQuota");
            return (Criteria) this;
        }

        public Criteria andTakeCashQuotaNotBetween(Double value1, Double value2) {
            addCriterion("take_cash_quota not between", value1, value2, "takeCashQuota");
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

        public Criteria andHeapPrizeIsNull() {
            addCriterion("HEAP_PRIZE is null");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeIsNotNull() {
            addCriterion("HEAP_PRIZE is not null");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeEqualTo(Double value) {
            addCriterion("HEAP_PRIZE =", value, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeNotEqualTo(Double value) {
            addCriterion("HEAP_PRIZE <>", value, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeGreaterThan(Double value) {
            addCriterion("HEAP_PRIZE >", value, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeGreaterThanOrEqualTo(Double value) {
            addCriterion("HEAP_PRIZE >=", value, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeLessThan(Double value) {
            addCriterion("HEAP_PRIZE <", value, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeLessThanOrEqualTo(Double value) {
            addCriterion("HEAP_PRIZE <=", value, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeIn(List<Double> values) {
            addCriterion("HEAP_PRIZE in", values, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeNotIn(List<Double> values) {
            addCriterion("HEAP_PRIZE not in", values, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeBetween(Double value1, Double value2) {
            addCriterion("HEAP_PRIZE between", value1, value2, "heapPrize");
            return (Criteria) this;
        }

        public Criteria andHeapPrizeNotBetween(Double value1, Double value2) {
            addCriterion("HEAP_PRIZE not between", value1, value2, "heapPrize");
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

        public Criteria andCreditLimitIsNull() {
            addCriterion("credit_limit is null");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIsNotNull() {
            addCriterion("credit_limit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditLimitEqualTo(Double value) {
            addCriterion("credit_limit =", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotEqualTo(Double value) {
            addCriterion("credit_limit <>", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitGreaterThan(Double value) {
            addCriterion("credit_limit >", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitGreaterThanOrEqualTo(Double value) {
            addCriterion("credit_limit >=", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitLessThan(Double value) {
            addCriterion("credit_limit <", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitLessThanOrEqualTo(Double value) {
            addCriterion("credit_limit <=", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIn(List<Double> values) {
            addCriterion("credit_limit in", values, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotIn(List<Double> values) {
            addCriterion("credit_limit not in", values, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitBetween(Double value1, Double value2) {
            addCriterion("credit_limit between", value1, value2, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotBetween(Double value1, Double value2) {
            addCriterion("credit_limit not between", value1, value2, "creditLimit");
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