package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class MemberInfo2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberInfo2Query() {
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

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNull() {
            addCriterion("bank_card is null");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNotNull() {
            addCriterion("bank_card is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardEqualTo(String value) {
            addCriterion("bank_card =", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotEqualTo(String value) {
            addCriterion("bank_card <>", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThan(String value) {
            addCriterion("bank_card >", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card >=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThan(String value) {
            addCriterion("bank_card <", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThanOrEqualTo(String value) {
            addCriterion("bank_card <=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLike(String value) {
            addCriterion("bank_card like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotLike(String value) {
            addCriterion("bank_card not like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardIn(List<String> values) {
            addCriterion("bank_card in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotIn(List<String> values) {
            addCriterion("bank_card not in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardBetween(String value1, String value2) {
            addCriterion("bank_card between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotBetween(String value1, String value2) {
            addCriterion("bank_card not between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankPartIsNull() {
            addCriterion("bank_part is null");
            return (Criteria) this;
        }

        public Criteria andBankPartIsNotNull() {
            addCriterion("bank_part is not null");
            return (Criteria) this;
        }

        public Criteria andBankPartEqualTo(String value) {
            addCriterion("bank_part =", value, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartNotEqualTo(String value) {
            addCriterion("bank_part <>", value, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartGreaterThan(String value) {
            addCriterion("bank_part >", value, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartGreaterThanOrEqualTo(String value) {
            addCriterion("bank_part >=", value, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartLessThan(String value) {
            addCriterion("bank_part <", value, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartLessThanOrEqualTo(String value) {
            addCriterion("bank_part <=", value, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartLike(String value) {
            addCriterion("bank_part like", value, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartNotLike(String value) {
            addCriterion("bank_part not like", value, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartIn(List<String> values) {
            addCriterion("bank_part in", values, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartNotIn(List<String> values) {
            addCriterion("bank_part not in", values, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartBetween(String value1, String value2) {
            addCriterion("bank_part between", value1, value2, "bankPart");
            return (Criteria) this;
        }

        public Criteria andBankPartNotBetween(String value1, String value2) {
            addCriterion("bank_part not between", value1, value2, "bankPart");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserIsNull() {
            addCriterion("IS_DNAPAY_USER is null");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserIsNotNull() {
            addCriterion("IS_DNAPAY_USER is not null");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserEqualTo(Integer value) {
            addCriterion("IS_DNAPAY_USER =", value, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserNotEqualTo(Integer value) {
            addCriterion("IS_DNAPAY_USER <>", value, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserGreaterThan(Integer value) {
            addCriterion("IS_DNAPAY_USER >", value, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_DNAPAY_USER >=", value, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserLessThan(Integer value) {
            addCriterion("IS_DNAPAY_USER <", value, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserLessThanOrEqualTo(Integer value) {
            addCriterion("IS_DNAPAY_USER <=", value, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserIn(List<Integer> values) {
            addCriterion("IS_DNAPAY_USER in", values, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserNotIn(List<Integer> values) {
            addCriterion("IS_DNAPAY_USER not in", values, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserBetween(Integer value1, Integer value2) {
            addCriterion("IS_DNAPAY_USER between", value1, value2, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsDnapayUserNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_DNAPAY_USER not between", value1, value2, "isDnapayUser");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpIsNull() {
            addCriterion("IS_UMPAY_OKP is null");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpIsNotNull() {
            addCriterion("IS_UMPAY_OKP is not null");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpEqualTo(Integer value) {
            addCriterion("IS_UMPAY_OKP =", value, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpNotEqualTo(Integer value) {
            addCriterion("IS_UMPAY_OKP <>", value, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpGreaterThan(Integer value) {
            addCriterion("IS_UMPAY_OKP >", value, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_UMPAY_OKP >=", value, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpLessThan(Integer value) {
            addCriterion("IS_UMPAY_OKP <", value, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpLessThanOrEqualTo(Integer value) {
            addCriterion("IS_UMPAY_OKP <=", value, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpIn(List<Integer> values) {
            addCriterion("IS_UMPAY_OKP in", values, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpNotIn(List<Integer> values) {
            addCriterion("IS_UMPAY_OKP not in", values, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpBetween(Integer value1, Integer value2) {
            addCriterion("IS_UMPAY_OKP between", value1, value2, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsUmpayOkpNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_UMPAY_OKP not between", value1, value2, "isUmpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpIsNull() {
            addCriterion("IS_LIANLIANPAY_OKP is null");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpIsNotNull() {
            addCriterion("IS_LIANLIANPAY_OKP is not null");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpEqualTo(Integer value) {
            addCriterion("IS_LIANLIANPAY_OKP =", value, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpNotEqualTo(Integer value) {
            addCriterion("IS_LIANLIANPAY_OKP <>", value, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpGreaterThan(Integer value) {
            addCriterion("IS_LIANLIANPAY_OKP >", value, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_LIANLIANPAY_OKP >=", value, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpLessThan(Integer value) {
            addCriterion("IS_LIANLIANPAY_OKP <", value, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpLessThanOrEqualTo(Integer value) {
            addCriterion("IS_LIANLIANPAY_OKP <=", value, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpIn(List<Integer> values) {
            addCriterion("IS_LIANLIANPAY_OKP in", values, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpNotIn(List<Integer> values) {
            addCriterion("IS_LIANLIANPAY_OKP not in", values, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpBetween(Integer value1, Integer value2) {
            addCriterion("IS_LIANLIANPAY_OKP between", value1, value2, "isLianlianpayOkp");
            return (Criteria) this;
        }

        public Criteria andIsLianlianpayOkpNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_LIANLIANPAY_OKP not between", value1, value2, "isLianlianpayOkp");
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