package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LotteryChase2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryChase2Example() {
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

        public Criteria andChaseNoIsNull() {
            addCriterion("CHASE_NO is null");
            return (Criteria) this;
        }

        public Criteria andChaseNoIsNotNull() {
            addCriterion("CHASE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andChaseNoEqualTo(Integer value) {
            addCriterion("CHASE_NO =", value, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoNotEqualTo(Integer value) {
            addCriterion("CHASE_NO <>", value, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoGreaterThan(Integer value) {
            addCriterion("CHASE_NO >", value, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHASE_NO >=", value, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoLessThan(Integer value) {
            addCriterion("CHASE_NO <", value, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoLessThanOrEqualTo(Integer value) {
            addCriterion("CHASE_NO <=", value, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoIn(List<Integer> values) {
            addCriterion("CHASE_NO in", values, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoNotIn(List<Integer> values) {
            addCriterion("CHASE_NO not in", values, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoBetween(Integer value1, Integer value2) {
            addCriterion("CHASE_NO between", value1, value2, "chaseNo");
            return (Criteria) this;
        }

        public Criteria andChaseNoNotBetween(Integer value1, Integer value2) {
            addCriterion("CHASE_NO not between", value1, value2, "chaseNo");
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

        public Criteria andChaseTypeIsNull() {
            addCriterion("CHASE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChaseTypeIsNotNull() {
            addCriterion("CHASE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChaseTypeEqualTo(Integer value) {
            addCriterion("CHASE_TYPE =", value, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeNotEqualTo(Integer value) {
            addCriterion("CHASE_TYPE <>", value, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeGreaterThan(Integer value) {
            addCriterion("CHASE_TYPE >", value, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHASE_TYPE >=", value, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeLessThan(Integer value) {
            addCriterion("CHASE_TYPE <", value, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("CHASE_TYPE <=", value, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeIn(List<Integer> values) {
            addCriterion("CHASE_TYPE in", values, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeNotIn(List<Integer> values) {
            addCriterion("CHASE_TYPE not in", values, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeBetween(Integer value1, Integer value2) {
            addCriterion("CHASE_TYPE between", value1, value2, "chaseType");
            return (Criteria) this;
        }

        public Criteria andChaseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("CHASE_TYPE not between", value1, value2, "chaseType");
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

        public Criteria andIsPackageIsNull() {
            addCriterion("IS_PACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andIsPackageIsNotNull() {
            addCriterion("IS_PACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andIsPackageEqualTo(Integer value) {
            addCriterion("IS_PACKAGE =", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotEqualTo(Integer value) {
            addCriterion("IS_PACKAGE <>", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageGreaterThan(Integer value) {
            addCriterion("IS_PACKAGE >", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_PACKAGE >=", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageLessThan(Integer value) {
            addCriterion("IS_PACKAGE <", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageLessThanOrEqualTo(Integer value) {
            addCriterion("IS_PACKAGE <=", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageIn(List<Integer> values) {
            addCriterion("IS_PACKAGE in", values, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotIn(List<Integer> values) {
            addCriterion("IS_PACKAGE not in", values, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageBetween(Integer value1, Integer value2) {
            addCriterion("IS_PACKAGE between", value1, value2, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_PACKAGE not between", value1, value2, "isPackage");
            return (Criteria) this;
        }

        public Criteria andPackageAmountIsNull() {
            addCriterion("PACKAGE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPackageAmountIsNotNull() {
            addCriterion("PACKAGE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPackageAmountEqualTo(Double value) {
            addCriterion("PACKAGE_AMOUNT =", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountNotEqualTo(Double value) {
            addCriterion("PACKAGE_AMOUNT <>", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountGreaterThan(Double value) {
            addCriterion("PACKAGE_AMOUNT >", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("PACKAGE_AMOUNT >=", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountLessThan(Double value) {
            addCriterion("PACKAGE_AMOUNT <", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountLessThanOrEqualTo(Double value) {
            addCriterion("PACKAGE_AMOUNT <=", value, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountIn(List<Double> values) {
            addCriterion("PACKAGE_AMOUNT in", values, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountNotIn(List<Double> values) {
            addCriterion("PACKAGE_AMOUNT not in", values, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountBetween(Double value1, Double value2) {
            addCriterion("PACKAGE_AMOUNT between", value1, value2, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andPackageAmountNotBetween(Double value1, Double value2) {
            addCriterion("PACKAGE_AMOUNT not between", value1, value2, "packageAmount");
            return (Criteria) this;
        }

        public Criteria andTotalTermIsNull() {
            addCriterion("TOTAL_TERM is null");
            return (Criteria) this;
        }

        public Criteria andTotalTermIsNotNull() {
            addCriterion("TOTAL_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTermEqualTo(Integer value) {
            addCriterion("TOTAL_TERM =", value, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermNotEqualTo(Integer value) {
            addCriterion("TOTAL_TERM <>", value, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermGreaterThan(Integer value) {
            addCriterion("TOTAL_TERM >", value, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_TERM >=", value, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermLessThan(Integer value) {
            addCriterion("TOTAL_TERM <", value, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermLessThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_TERM <=", value, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermIn(List<Integer> values) {
            addCriterion("TOTAL_TERM in", values, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermNotIn(List<Integer> values) {
            addCriterion("TOTAL_TERM not in", values, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_TERM between", value1, value2, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andTotalTermNotBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_TERM not between", value1, value2, "totalTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermIsNull() {
            addCriterion("SOLD_TERM is null");
            return (Criteria) this;
        }

        public Criteria andSoldTermIsNotNull() {
            addCriterion("SOLD_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andSoldTermEqualTo(Integer value) {
            addCriterion("SOLD_TERM =", value, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermNotEqualTo(Integer value) {
            addCriterion("SOLD_TERM <>", value, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermGreaterThan(Integer value) {
            addCriterion("SOLD_TERM >", value, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOLD_TERM >=", value, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermLessThan(Integer value) {
            addCriterion("SOLD_TERM <", value, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermLessThanOrEqualTo(Integer value) {
            addCriterion("SOLD_TERM <=", value, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermIn(List<Integer> values) {
            addCriterion("SOLD_TERM in", values, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermNotIn(List<Integer> values) {
            addCriterion("SOLD_TERM not in", values, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermBetween(Integer value1, Integer value2) {
            addCriterion("SOLD_TERM between", value1, value2, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andSoldTermNotBetween(Integer value1, Integer value2) {
            addCriterion("SOLD_TERM not between", value1, value2, "soldTerm");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeIsNull() {
            addCriterion("TOTAL_PRIZE is null");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeIsNotNull() {
            addCriterion("TOTAL_PRIZE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeEqualTo(Double value) {
            addCriterion("TOTAL_PRIZE =", value, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeNotEqualTo(Double value) {
            addCriterion("TOTAL_PRIZE <>", value, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeGreaterThan(Double value) {
            addCriterion("TOTAL_PRIZE >", value, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_PRIZE >=", value, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeLessThan(Double value) {
            addCriterion("TOTAL_PRIZE <", value, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_PRIZE <=", value, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeIn(List<Double> values) {
            addCriterion("TOTAL_PRIZE in", values, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeNotIn(List<Double> values) {
            addCriterion("TOTAL_PRIZE not in", values, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeBetween(Double value1, Double value2) {
            addCriterion("TOTAL_PRIZE between", value1, value2, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andTotalPrizeNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_PRIZE not between", value1, value2, "totalPrize");
            return (Criteria) this;
        }

        public Criteria andStopConditionIsNull() {
            addCriterion("STOP_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andStopConditionIsNotNull() {
            addCriterion("STOP_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andStopConditionEqualTo(String value) {
            addCriterion("STOP_CONDITION =", value, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionNotEqualTo(String value) {
            addCriterion("STOP_CONDITION <>", value, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionGreaterThan(String value) {
            addCriterion("STOP_CONDITION >", value, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionGreaterThanOrEqualTo(String value) {
            addCriterion("STOP_CONDITION >=", value, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionLessThan(String value) {
            addCriterion("STOP_CONDITION <", value, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionLessThanOrEqualTo(String value) {
            addCriterion("STOP_CONDITION <=", value, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionLike(String value) {
            addCriterion("STOP_CONDITION like", value, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionNotLike(String value) {
            addCriterion("STOP_CONDITION not like", value, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionIn(List<String> values) {
            addCriterion("STOP_CONDITION in", values, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionNotIn(List<String> values) {
            addCriterion("STOP_CONDITION not in", values, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionBetween(String value1, String value2) {
            addCriterion("STOP_CONDITION between", value1, value2, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStopConditionNotBetween(String value1, String value2) {
            addCriterion("STOP_CONDITION not between", value1, value2, "stopCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionIsNull() {
            addCriterion("START_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andStartConditionIsNotNull() {
            addCriterion("START_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andStartConditionEqualTo(String value) {
            addCriterion("START_CONDITION =", value, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionNotEqualTo(String value) {
            addCriterion("START_CONDITION <>", value, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionGreaterThan(String value) {
            addCriterion("START_CONDITION >", value, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionGreaterThanOrEqualTo(String value) {
            addCriterion("START_CONDITION >=", value, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionLessThan(String value) {
            addCriterion("START_CONDITION <", value, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionLessThanOrEqualTo(String value) {
            addCriterion("START_CONDITION <=", value, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionLike(String value) {
            addCriterion("START_CONDITION like", value, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionNotLike(String value) {
            addCriterion("START_CONDITION not like", value, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionIn(List<String> values) {
            addCriterion("START_CONDITION in", values, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionNotIn(List<String> values) {
            addCriterion("START_CONDITION not in", values, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionBetween(String value1, String value2) {
            addCriterion("START_CONDITION between", value1, value2, "startCondition");
            return (Criteria) this;
        }

        public Criteria andStartConditionNotBetween(String value1, String value2) {
            addCriterion("START_CONDITION not between", value1, value2, "startCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionIsNull() {
            addCriterion("GAIN_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andGainConditionIsNotNull() {
            addCriterion("GAIN_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andGainConditionEqualTo(String value) {
            addCriterion("GAIN_CONDITION =", value, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionNotEqualTo(String value) {
            addCriterion("GAIN_CONDITION <>", value, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionGreaterThan(String value) {
            addCriterion("GAIN_CONDITION >", value, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionGreaterThanOrEqualTo(String value) {
            addCriterion("GAIN_CONDITION >=", value, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionLessThan(String value) {
            addCriterion("GAIN_CONDITION <", value, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionLessThanOrEqualTo(String value) {
            addCriterion("GAIN_CONDITION <=", value, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionLike(String value) {
            addCriterion("GAIN_CONDITION like", value, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionNotLike(String value) {
            addCriterion("GAIN_CONDITION not like", value, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionIn(List<String> values) {
            addCriterion("GAIN_CONDITION in", values, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionNotIn(List<String> values) {
            addCriterion("GAIN_CONDITION not in", values, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionBetween(String value1, String value2) {
            addCriterion("GAIN_CONDITION between", value1, value2, "gainCondition");
            return (Criteria) this;
        }

        public Criteria andGainConditionNotBetween(String value1, String value2) {
            addCriterion("GAIN_CONDITION not between", value1, value2, "gainCondition");
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