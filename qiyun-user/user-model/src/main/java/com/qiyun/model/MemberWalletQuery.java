package com.qiyun.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MemberWalletQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberWalletQuery() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
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

        public Criteria andUsableMoneyIsNull() {
            addCriterion("usable_money is null");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyIsNotNull() {
            addCriterion("usable_money is not null");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyEqualTo(BigDecimal value) {
            addCriterion("usable_money =", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotEqualTo(BigDecimal value) {
            addCriterion("usable_money <>", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyGreaterThan(BigDecimal value) {
            addCriterion("usable_money >", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("usable_money >=", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyLessThan(BigDecimal value) {
            addCriterion("usable_money <", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("usable_money <=", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyIn(List<BigDecimal> values) {
            addCriterion("usable_money in", values, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotIn(List<BigDecimal> values) {
            addCriterion("usable_money not in", values, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usable_money between", value1, value2, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usable_money not between", value1, value2, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyIsNull() {
            addCriterion("freeze_money is null");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyIsNotNull() {
            addCriterion("freeze_money is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyEqualTo(BigDecimal value) {
            addCriterion("freeze_money =", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("freeze_money <>", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyGreaterThan(BigDecimal value) {
            addCriterion("freeze_money >", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freeze_money >=", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyLessThan(BigDecimal value) {
            addCriterion("freeze_money <", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freeze_money <=", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyIn(List<BigDecimal> values) {
            addCriterion("freeze_money in", values, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("freeze_money not in", values, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freeze_money between", value1, value2, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freeze_money not between", value1, value2, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andCashQuotaIsNull() {
            addCriterion("cash_quota is null");
            return (Criteria) this;
        }

        public Criteria andCashQuotaIsNotNull() {
            addCriterion("cash_quota is not null");
            return (Criteria) this;
        }

        public Criteria andCashQuotaEqualTo(BigDecimal value) {
            addCriterion("cash_quota =", value, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaNotEqualTo(BigDecimal value) {
            addCriterion("cash_quota <>", value, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaGreaterThan(BigDecimal value) {
            addCriterion("cash_quota >", value, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_quota >=", value, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaLessThan(BigDecimal value) {
            addCriterion("cash_quota <", value, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_quota <=", value, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaIn(List<BigDecimal> values) {
            addCriterion("cash_quota in", values, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaNotIn(List<BigDecimal> values) {
            addCriterion("cash_quota not in", values, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_quota between", value1, value2, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andCashQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_quota not between", value1, value2, "cashQuota");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyIsNull() {
            addCriterion("history_money is null");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyIsNotNull() {
            addCriterion("history_money is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyEqualTo(BigDecimal value) {
            addCriterion("history_money =", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyNotEqualTo(BigDecimal value) {
            addCriterion("history_money <>", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyGreaterThan(BigDecimal value) {
            addCriterion("history_money >", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("history_money >=", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyLessThan(BigDecimal value) {
            addCriterion("history_money <", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("history_money <=", value, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyIn(List<BigDecimal> values) {
            addCriterion("history_money in", values, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyNotIn(List<BigDecimal> values) {
            addCriterion("history_money not in", values, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("history_money between", value1, value2, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("history_money not between", value1, value2, "historyMoney");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeIsNull() {
            addCriterion("history_prize is null");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeIsNotNull() {
            addCriterion("history_prize is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeEqualTo(BigDecimal value) {
            addCriterion("history_prize =", value, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeNotEqualTo(BigDecimal value) {
            addCriterion("history_prize <>", value, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeGreaterThan(BigDecimal value) {
            addCriterion("history_prize >", value, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("history_prize >=", value, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeLessThan(BigDecimal value) {
            addCriterion("history_prize <", value, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("history_prize <=", value, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeIn(List<BigDecimal> values) {
            addCriterion("history_prize in", values, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeNotIn(List<BigDecimal> values) {
            addCriterion("history_prize not in", values, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("history_prize between", value1, value2, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andHistoryPrizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("history_prize not between", value1, value2, "historyPrize");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5IsNull() {
            addCriterion("verify_MD5 is null");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5IsNotNull() {
            addCriterion("verify_MD5 is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5EqualTo(String value) {
            addCriterion("verify_MD5 =", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5NotEqualTo(String value) {
            addCriterion("verify_MD5 <>", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5GreaterThan(String value) {
            addCriterion("verify_MD5 >", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5GreaterThanOrEqualTo(String value) {
            addCriterion("verify_MD5 >=", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5LessThan(String value) {
            addCriterion("verify_MD5 <", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5LessThanOrEqualTo(String value) {
            addCriterion("verify_MD5 <=", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5Like(String value) {
            addCriterion("verify_MD5 like", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5NotLike(String value) {
            addCriterion("verify_MD5 not like", value, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5In(List<String> values) {
            addCriterion("verify_MD5 in", values, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5NotIn(List<String> values) {
            addCriterion("verify_MD5 not in", values, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5Between(String value1, String value2) {
            addCriterion("verify_MD5 between", value1, value2, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andVerifyMd5NotBetween(String value1, String value2) {
            addCriterion("verify_MD5 not between", value1, value2, "verifyMd5");
            return (Criteria) this;
        }

        public Criteria andWalletTypeIsNull() {
            addCriterion("wallet_type is null");
            return (Criteria) this;
        }

        public Criteria andWalletTypeIsNotNull() {
            addCriterion("wallet_type is not null");
            return (Criteria) this;
        }

        public Criteria andWalletTypeEqualTo(Integer value) {
            addCriterion("wallet_type =", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeNotEqualTo(Integer value) {
            addCriterion("wallet_type <>", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeGreaterThan(Integer value) {
            addCriterion("wallet_type >", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_type >=", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeLessThan(Integer value) {
            addCriterion("wallet_type <", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_type <=", value, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeIn(List<Integer> values) {
            addCriterion("wallet_type in", values, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeNotIn(List<Integer> values) {
            addCriterion("wallet_type not in", values, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeBetween(Integer value1, Integer value2) {
            addCriterion("wallet_type between", value1, value2, "walletType");
            return (Criteria) this;
        }

        public Criteria andWalletTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_type not between", value1, value2, "walletType");
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