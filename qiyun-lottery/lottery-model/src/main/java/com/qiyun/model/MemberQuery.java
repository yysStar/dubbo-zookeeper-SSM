package com.qiyun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberQuery() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("cert_type is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("cert_type is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(Short value) {
            addCriterion("cert_type =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(Short value) {
            addCriterion("cert_type <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(Short value) {
            addCriterion("cert_type >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("cert_type >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(Short value) {
            addCriterion("cert_type <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(Short value) {
            addCriterion("cert_type <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<Short> values) {
            addCriterion("cert_type in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<Short> values) {
            addCriterion("cert_type not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(Short value1, Short value2) {
            addCriterion("cert_type between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(Short value1, Short value2) {
            addCriterion("cert_type not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNull() {
            addCriterion("cert_no is null");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNotNull() {
            addCriterion("cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andCertNoEqualTo(String value) {
            addCriterion("cert_no =", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotEqualTo(String value) {
            addCriterion("cert_no <>", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThan(String value) {
            addCriterion("cert_no >", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("cert_no >=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThan(String value) {
            addCriterion("cert_no <", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThanOrEqualTo(String value) {
            addCriterion("cert_no <=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLike(String value) {
            addCriterion("cert_no like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotLike(String value) {
            addCriterion("cert_no not like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIn(List<String> values) {
            addCriterion("cert_no in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotIn(List<String> values) {
            addCriterion("cert_no not in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoBetween(String value1, String value2) {
            addCriterion("cert_no between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotBetween(String value1, String value2) {
            addCriterion("cert_no not between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
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

        public Criteria andRegisterDatetimeIsNull() {
            addCriterion("register_datetime is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeIsNotNull() {
            addCriterion("register_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeEqualTo(Date value) {
            addCriterion("register_datetime =", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotEqualTo(Date value) {
            addCriterion("register_datetime <>", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeGreaterThan(Date value) {
            addCriterion("register_datetime >", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_datetime >=", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeLessThan(Date value) {
            addCriterion("register_datetime <", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("register_datetime <=", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeIn(List<Date> values) {
            addCriterion("register_datetime in", values, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotIn(List<Date> values) {
            addCriterion("register_datetime not in", values, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeBetween(Date value1, Date value2) {
            addCriterion("register_datetime between", value1, value2, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("register_datetime not between", value1, value2, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistIsNull() {
            addCriterion("is_whitelist is null");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistIsNotNull() {
            addCriterion("is_whitelist is not null");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistEqualTo(Boolean value) {
            addCriterion("is_whitelist =", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistNotEqualTo(Boolean value) {
            addCriterion("is_whitelist <>", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistGreaterThan(Boolean value) {
            addCriterion("is_whitelist >", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_whitelist >=", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistLessThan(Boolean value) {
            addCriterion("is_whitelist <", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistLessThanOrEqualTo(Boolean value) {
            addCriterion("is_whitelist <=", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistIn(List<Boolean> values) {
            addCriterion("is_whitelist in", values, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistNotIn(List<Boolean> values) {
            addCriterion("is_whitelist not in", values, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistBetween(Boolean value1, Boolean value2) {
            addCriterion("is_whitelist between", value1, value2, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_whitelist not between", value1, value2, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeIsNull() {
            addCriterion("last_login_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeIsNotNull() {
            addCriterion("last_login_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeEqualTo(Date value) {
            addCriterion("last_login_datetime =", value, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeNotEqualTo(Date value) {
            addCriterion("last_login_datetime <>", value, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeGreaterThan(Date value) {
            addCriterion("last_login_datetime >", value, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_datetime >=", value, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeLessThan(Date value) {
            addCriterion("last_login_datetime <", value, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_datetime <=", value, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeIn(List<Date> values) {
            addCriterion("last_login_datetime in", values, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeNotIn(List<Date> values) {
            addCriterion("last_login_datetime not in", values, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeBetween(Date value1, Date value2) {
            addCriterion("last_login_datetime between", value1, value2, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_datetime not between", value1, value2, "lastLoginDatetime");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Integer value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Integer value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Integer value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Integer value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Integer> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Integer> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andRecommenderIsNull() {
            addCriterion("recommender is null");
            return (Criteria) this;
        }

        public Criteria andRecommenderIsNotNull() {
            addCriterion("recommender is not null");
            return (Criteria) this;
        }

        public Criteria andRecommenderEqualTo(Integer value) {
            addCriterion("recommender =", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotEqualTo(Integer value) {
            addCriterion("recommender <>", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderGreaterThan(Integer value) {
            addCriterion("recommender >", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommender >=", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderLessThan(Integer value) {
            addCriterion("recommender <", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderLessThanOrEqualTo(Integer value) {
            addCriterion("recommender <=", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderIn(List<Integer> values) {
            addCriterion("recommender in", values, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotIn(List<Integer> values) {
            addCriterion("recommender not in", values, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderBetween(Integer value1, Integer value2) {
            addCriterion("recommender between", value1, value2, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotBetween(Integer value1, Integer value2) {
            addCriterion("recommender not between", value1, value2, "recommender");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andProviderIsNull() {
            addCriterion("provider is null");
            return (Criteria) this;
        }

        public Criteria andProviderIsNotNull() {
            addCriterion("provider is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEqualTo(String value) {
            addCriterion("provider =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(String value) {
            addCriterion("provider <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(String value) {
            addCriterion("provider >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(String value) {
            addCriterion("provider >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(String value) {
            addCriterion("provider <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(String value) {
            addCriterion("provider <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLike(String value) {
            addCriterion("provider like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotLike(String value) {
            addCriterion("provider not like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(List<String> values) {
            addCriterion("provider in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(List<String> values) {
            addCriterion("provider not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(String value1, String value2) {
            addCriterion("provider between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(String value1, String value2) {
            addCriterion("provider not between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Short value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Short value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Short value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Short value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Short value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Short value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Short> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Short> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Short value1, Short value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Short value1, Short value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andExprerienceIsNull() {
            addCriterion("exprerience is null");
            return (Criteria) this;
        }

        public Criteria andExprerienceIsNotNull() {
            addCriterion("exprerience is not null");
            return (Criteria) this;
        }

        public Criteria andExprerienceEqualTo(Integer value) {
            addCriterion("exprerience =", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceNotEqualTo(Integer value) {
            addCriterion("exprerience <>", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceGreaterThan(Integer value) {
            addCriterion("exprerience >", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("exprerience >=", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceLessThan(Integer value) {
            addCriterion("exprerience <", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceLessThanOrEqualTo(Integer value) {
            addCriterion("exprerience <=", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceIn(List<Integer> values) {
            addCriterion("exprerience in", values, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceNotIn(List<Integer> values) {
            addCriterion("exprerience not in", values, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceBetween(Integer value1, Integer value2) {
            addCriterion("exprerience between", value1, value2, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceNotBetween(Integer value1, Integer value2) {
            addCriterion("exprerience not between", value1, value2, "exprerience");
            return (Criteria) this;
        }

        public Criteria andCardIsNull() {
            addCriterion("card is null");
            return (Criteria) this;
        }

        public Criteria andCardIsNotNull() {
            addCriterion("card is not null");
            return (Criteria) this;
        }

        public Criteria andCardEqualTo(Integer value) {
            addCriterion("card =", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotEqualTo(Integer value) {
            addCriterion("card <>", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardGreaterThan(Integer value) {
            addCriterion("card >", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("card >=", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardLessThan(Integer value) {
            addCriterion("card <", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardLessThanOrEqualTo(Integer value) {
            addCriterion("card <=", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardIn(List<Integer> values) {
            addCriterion("card in", values, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotIn(List<Integer> values) {
            addCriterion("card not in", values, "card");
            return (Criteria) this;
        }

        public Criteria andCardBetween(Integer value1, Integer value2) {
            addCriterion("card between", value1, value2, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotBetween(Integer value1, Integer value2) {
            addCriterion("card not between", value1, value2, "card");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedIsNull() {
            addCriterion("is_mobile_authed is null");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedIsNotNull() {
            addCriterion("is_mobile_authed is not null");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedEqualTo(Boolean value) {
            addCriterion("is_mobile_authed =", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedNotEqualTo(Boolean value) {
            addCriterion("is_mobile_authed <>", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedGreaterThan(Boolean value) {
            addCriterion("is_mobile_authed >", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_mobile_authed >=", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedLessThan(Boolean value) {
            addCriterion("is_mobile_authed <", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_mobile_authed <=", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedIn(List<Boolean> values) {
            addCriterion("is_mobile_authed in", values, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedNotIn(List<Boolean> values) {
            addCriterion("is_mobile_authed not in", values, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_mobile_authed between", value1, value2, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_mobile_authed not between", value1, value2, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedIsNull() {
            addCriterion("is_email_authed is null");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedIsNotNull() {
            addCriterion("is_email_authed is not null");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedEqualTo(Boolean value) {
            addCriterion("is_email_authed =", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedNotEqualTo(Boolean value) {
            addCriterion("is_email_authed <>", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedGreaterThan(Boolean value) {
            addCriterion("is_email_authed >", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_email_authed >=", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedLessThan(Boolean value) {
            addCriterion("is_email_authed <", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_email_authed <=", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedIn(List<Boolean> values) {
            addCriterion("is_email_authed in", values, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedNotIn(List<Boolean> values) {
            addCriterion("is_email_authed not in", values, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_email_authed between", value1, value2, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_email_authed not between", value1, value2, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andErrorCountIsNull() {
            addCriterion("error_count is null");
            return (Criteria) this;
        }

        public Criteria andErrorCountIsNotNull() {
            addCriterion("error_count is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCountEqualTo(Integer value) {
            addCriterion("error_count =", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotEqualTo(Integer value) {
            addCriterion("error_count <>", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountGreaterThan(Integer value) {
            addCriterion("error_count >", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_count >=", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountLessThan(Integer value) {
            addCriterion("error_count <", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountLessThanOrEqualTo(Integer value) {
            addCriterion("error_count <=", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountIn(List<Integer> values) {
            addCriterion("error_count in", values, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotIn(List<Integer> values) {
            addCriterion("error_count not in", values, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountBetween(Integer value1, Integer value2) {
            addCriterion("error_count between", value1, value2, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotBetween(Integer value1, Integer value2) {
            addCriterion("error_count not between", value1, value2, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorDateIsNull() {
            addCriterion("error_date is null");
            return (Criteria) this;
        }

        public Criteria andErrorDateIsNotNull() {
            addCriterion("error_date is not null");
            return (Criteria) this;
        }

        public Criteria andErrorDateEqualTo(Date value) {
            addCriterion("error_date =", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateNotEqualTo(Date value) {
            addCriterion("error_date <>", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateGreaterThan(Date value) {
            addCriterion("error_date >", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateGreaterThanOrEqualTo(Date value) {
            addCriterion("error_date >=", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateLessThan(Date value) {
            addCriterion("error_date <", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateLessThanOrEqualTo(Date value) {
            addCriterion("error_date <=", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateIn(List<Date> values) {
            addCriterion("error_date in", values, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateNotIn(List<Date> values) {
            addCriterion("error_date not in", values, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateBetween(Date value1, Date value2) {
            addCriterion("error_date between", value1, value2, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateNotBetween(Date value1, Date value2) {
            addCriterion("error_date not between", value1, value2, "errorDate");
            return (Criteria) this;
        }

        public Criteria andIsChargeIsNull() {
            addCriterion("is_charge is null");
            return (Criteria) this;
        }

        public Criteria andIsChargeIsNotNull() {
            addCriterion("is_charge is not null");
            return (Criteria) this;
        }

        public Criteria andIsChargeEqualTo(Boolean value) {
            addCriterion("is_charge =", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeNotEqualTo(Boolean value) {
            addCriterion("is_charge <>", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeGreaterThan(Boolean value) {
            addCriterion("is_charge >", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_charge >=", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeLessThan(Boolean value) {
            addCriterion("is_charge <", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_charge <=", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeIn(List<Boolean> values) {
            addCriterion("is_charge in", values, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeNotIn(List<Boolean> values) {
            addCriterion("is_charge not in", values, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_charge between", value1, value2, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_charge not between", value1, value2, "isCharge");
            return (Criteria) this;
        }

        public Criteria andDigestIsNull() {
            addCriterion("digest is null");
            return (Criteria) this;
        }

        public Criteria andDigestIsNotNull() {
            addCriterion("digest is not null");
            return (Criteria) this;
        }

        public Criteria andDigestEqualTo(String value) {
            addCriterion("digest =", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotEqualTo(String value) {
            addCriterion("digest <>", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThan(String value) {
            addCriterion("digest >", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThanOrEqualTo(String value) {
            addCriterion("digest >=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThan(String value) {
            addCriterion("digest <", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThanOrEqualTo(String value) {
            addCriterion("digest <=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLike(String value) {
            addCriterion("digest like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotLike(String value) {
            addCriterion("digest not like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestIn(List<String> values) {
            addCriterion("digest in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotIn(List<String> values) {
            addCriterion("digest not in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestBetween(String value1, String value2) {
            addCriterion("digest between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotBetween(String value1, String value2) {
            addCriterion("digest not between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andPayWaysIsNull() {
            addCriterion("pay_ways is null");
            return (Criteria) this;
        }

        public Criteria andPayWaysIsNotNull() {
            addCriterion("pay_ways is not null");
            return (Criteria) this;
        }

        public Criteria andPayWaysEqualTo(String value) {
            addCriterion("pay_ways =", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysNotEqualTo(String value) {
            addCriterion("pay_ways <>", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysGreaterThan(String value) {
            addCriterion("pay_ways >", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysGreaterThanOrEqualTo(String value) {
            addCriterion("pay_ways >=", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysLessThan(String value) {
            addCriterion("pay_ways <", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysLessThanOrEqualTo(String value) {
            addCriterion("pay_ways <=", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysLike(String value) {
            addCriterion("pay_ways like", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysNotLike(String value) {
            addCriterion("pay_ways not like", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysIn(List<String> values) {
            addCriterion("pay_ways in", values, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysNotIn(List<String> values) {
            addCriterion("pay_ways not in", values, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysBetween(String value1, String value2) {
            addCriterion("pay_ways between", value1, value2, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysNotBetween(String value1, String value2) {
            addCriterion("pay_ways not between", value1, value2, "payWays");
            return (Criteria) this;
        }

        public Criteria andZfbAccountIsNull() {
            addCriterion("zfb_account is null");
            return (Criteria) this;
        }

        public Criteria andZfbAccountIsNotNull() {
            addCriterion("zfb_account is not null");
            return (Criteria) this;
        }

        public Criteria andZfbAccountEqualTo(String value) {
            addCriterion("zfb_account =", value, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountNotEqualTo(String value) {
            addCriterion("zfb_account <>", value, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountGreaterThan(String value) {
            addCriterion("zfb_account >", value, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountGreaterThanOrEqualTo(String value) {
            addCriterion("zfb_account >=", value, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountLessThan(String value) {
            addCriterion("zfb_account <", value, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountLessThanOrEqualTo(String value) {
            addCriterion("zfb_account <=", value, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountLike(String value) {
            addCriterion("zfb_account like", value, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountNotLike(String value) {
            addCriterion("zfb_account not like", value, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountIn(List<String> values) {
            addCriterion("zfb_account in", values, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountNotIn(List<String> values) {
            addCriterion("zfb_account not in", values, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountBetween(String value1, String value2) {
            addCriterion("zfb_account between", value1, value2, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andZfbAccountNotBetween(String value1, String value2) {
            addCriterion("zfb_account not between", value1, value2, "zfbAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountIsNull() {
            addCriterion("wx_account is null");
            return (Criteria) this;
        }

        public Criteria andWxAccountIsNotNull() {
            addCriterion("wx_account is not null");
            return (Criteria) this;
        }

        public Criteria andWxAccountEqualTo(String value) {
            addCriterion("wx_account =", value, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountNotEqualTo(String value) {
            addCriterion("wx_account <>", value, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountGreaterThan(String value) {
            addCriterion("wx_account >", value, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountGreaterThanOrEqualTo(String value) {
            addCriterion("wx_account >=", value, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountLessThan(String value) {
            addCriterion("wx_account <", value, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountLessThanOrEqualTo(String value) {
            addCriterion("wx_account <=", value, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountLike(String value) {
            addCriterion("wx_account like", value, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountNotLike(String value) {
            addCriterion("wx_account not like", value, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountIn(List<String> values) {
            addCriterion("wx_account in", values, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountNotIn(List<String> values) {
            addCriterion("wx_account not in", values, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountBetween(String value1, String value2) {
            addCriterion("wx_account between", value1, value2, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andWxAccountNotBetween(String value1, String value2) {
            addCriterion("wx_account not between", value1, value2, "wxAccount");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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

        public Criteria andMultipleIsNull() {
            addCriterion("multiple is null");
            return (Criteria) this;
        }

        public Criteria andMultipleIsNotNull() {
            addCriterion("multiple is not null");
            return (Criteria) this;
        }

        public Criteria andMultipleEqualTo(Integer value) {
            addCriterion("multiple =", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotEqualTo(Integer value) {
            addCriterion("multiple <>", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThan(Integer value) {
            addCriterion("multiple >", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThanOrEqualTo(Integer value) {
            addCriterion("multiple >=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThan(Integer value) {
            addCriterion("multiple <", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThanOrEqualTo(Integer value) {
            addCriterion("multiple <=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleIn(List<Integer> values) {
            addCriterion("multiple in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotIn(List<Integer> values) {
            addCriterion("multiple not in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleBetween(Integer value1, Integer value2) {
            addCriterion("multiple between", value1, value2, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotBetween(Integer value1, Integer value2) {
            addCriterion("multiple not between", value1, value2, "multiple");
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