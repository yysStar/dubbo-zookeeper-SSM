package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Member2Query() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("CERT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("CERT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(Integer value) {
            addCriterion("CERT_TYPE =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(Integer value) {
            addCriterion("CERT_TYPE <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(Integer value) {
            addCriterion("CERT_TYPE >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CERT_TYPE >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(Integer value) {
            addCriterion("CERT_TYPE <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(Integer value) {
            addCriterion("CERT_TYPE <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<Integer> values) {
            addCriterion("CERT_TYPE in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<Integer> values) {
            addCriterion("CERT_TYPE not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(Integer value1, Integer value2) {
            addCriterion("CERT_TYPE between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("CERT_TYPE not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNull() {
            addCriterion("CERT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNotNull() {
            addCriterion("CERT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCertNoEqualTo(String value) {
            addCriterion("CERT_NO =", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotEqualTo(String value) {
            addCriterion("CERT_NO <>", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThan(String value) {
            addCriterion("CERT_NO >", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NO >=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThan(String value) {
            addCriterion("CERT_NO <", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThanOrEqualTo(String value) {
            addCriterion("CERT_NO <=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLike(String value) {
            addCriterion("CERT_NO like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotLike(String value) {
            addCriterion("CERT_NO not like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIn(List<String> values) {
            addCriterion("CERT_NO in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotIn(List<String> values) {
            addCriterion("CERT_NO not in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoBetween(String value1, String value2) {
            addCriterion("CERT_NO between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotBetween(String value1, String value2) {
            addCriterion("CERT_NO not between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("RANK is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("RANK is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("RANK =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("RANK <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("RANK >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("RANK >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("RANK <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("RANK <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("RANK in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("RANK not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("RANK between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("RANK not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
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

        public Criteria andRegisterDateTimeIsNull() {
            addCriterion("REGISTER_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeIsNotNull() {
            addCriterion("REGISTER_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeEqualTo(Date value) {
            addCriterion("REGISTER_DATE_TIME =", value, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeNotEqualTo(Date value) {
            addCriterion("REGISTER_DATE_TIME <>", value, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeGreaterThan(Date value) {
            addCriterion("REGISTER_DATE_TIME >", value, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REGISTER_DATE_TIME >=", value, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeLessThan(Date value) {
            addCriterion("REGISTER_DATE_TIME <", value, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("REGISTER_DATE_TIME <=", value, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeIn(List<Date> values) {
            addCriterion("REGISTER_DATE_TIME in", values, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeNotIn(List<Date> values) {
            addCriterion("REGISTER_DATE_TIME not in", values, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeBetween(Date value1, Date value2) {
            addCriterion("REGISTER_DATE_TIME between", value1, value2, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("REGISTER_DATE_TIME not between", value1, value2, "registerDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeIsNull() {
            addCriterion("LAST_LOGIN_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeIsNotNull() {
            addCriterion("LAST_LOGIN_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeEqualTo(Date value) {
            addCriterion("LAST_LOGIN_DATE_TIME =", value, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeNotEqualTo(Date value) {
            addCriterion("LAST_LOGIN_DATE_TIME <>", value, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeGreaterThan(Date value) {
            addCriterion("LAST_LOGIN_DATE_TIME >", value, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_DATE_TIME >=", value, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeLessThan(Date value) {
            addCriterion("LAST_LOGIN_DATE_TIME <", value, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_DATE_TIME <=", value, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeIn(List<Date> values) {
            addCriterion("LAST_LOGIN_DATE_TIME in", values, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeNotIn(List<Date> values) {
            addCriterion("LAST_LOGIN_DATE_TIME not in", values, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_DATE_TIME between", value1, value2, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_DATE_TIME not between", value1, value2, "lastLoginDateTime");
            return (Criteria) this;
        }

        public Criteria andExprerienceIsNull() {
            addCriterion("EXPRERIENCE is null");
            return (Criteria) this;
        }

        public Criteria andExprerienceIsNotNull() {
            addCriterion("EXPRERIENCE is not null");
            return (Criteria) this;
        }

        public Criteria andExprerienceEqualTo(Integer value) {
            addCriterion("EXPRERIENCE =", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceNotEqualTo(Integer value) {
            addCriterion("EXPRERIENCE <>", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceGreaterThan(Integer value) {
            addCriterion("EXPRERIENCE >", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPRERIENCE >=", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceLessThan(Integer value) {
            addCriterion("EXPRERIENCE <", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceLessThanOrEqualTo(Integer value) {
            addCriterion("EXPRERIENCE <=", value, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceIn(List<Integer> values) {
            addCriterion("EXPRERIENCE in", values, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceNotIn(List<Integer> values) {
            addCriterion("EXPRERIENCE not in", values, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceBetween(Integer value1, Integer value2) {
            addCriterion("EXPRERIENCE between", value1, value2, "exprerience");
            return (Criteria) this;
        }

        public Criteria andExprerienceNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPRERIENCE not between", value1, value2, "exprerience");
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

        public Criteria andRecommenderIsNull() {
            addCriterion("RECOMMENDER is null");
            return (Criteria) this;
        }

        public Criteria andRecommenderIsNotNull() {
            addCriterion("RECOMMENDER is not null");
            return (Criteria) this;
        }

        public Criteria andRecommenderEqualTo(Integer value) {
            addCriterion("RECOMMENDER =", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotEqualTo(Integer value) {
            addCriterion("RECOMMENDER <>", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderGreaterThan(Integer value) {
            addCriterion("RECOMMENDER >", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECOMMENDER >=", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderLessThan(Integer value) {
            addCriterion("RECOMMENDER <", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderLessThanOrEqualTo(Integer value) {
            addCriterion("RECOMMENDER <=", value, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderIn(List<Integer> values) {
            addCriterion("RECOMMENDER in", values, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotIn(List<Integer> values) {
            addCriterion("RECOMMENDER not in", values, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderBetween(Integer value1, Integer value2) {
            addCriterion("RECOMMENDER between", value1, value2, "recommender");
            return (Criteria) this;
        }

        public Criteria andRecommenderNotBetween(Integer value1, Integer value2) {
            addCriterion("RECOMMENDER not between", value1, value2, "recommender");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("SIGN is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("SIGN =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("SIGN <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("SIGN >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("SIGN <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("SIGN <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("SIGN like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("SIGN not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("SIGN in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("SIGN not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("SIGN between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("SIGN not between", value1, value2, "sign");
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

        public Criteria andProviderEqualTo(String value) {
            addCriterion("PROVIDER =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(String value) {
            addCriterion("PROVIDER <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(String value) {
            addCriterion("PROVIDER >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(String value) {
            addCriterion("PROVIDER >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(String value) {
            addCriterion("PROVIDER <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(String value) {
            addCriterion("PROVIDER <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLike(String value) {
            addCriterion("PROVIDER like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotLike(String value) {
            addCriterion("PROVIDER not like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(List<String> values) {
            addCriterion("PROVIDER in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(List<String> values) {
            addCriterion("PROVIDER not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(String value1, String value2) {
            addCriterion("PROVIDER between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(String value1, String value2) {
            addCriterion("PROVIDER not between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("PICTURE is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("PICTURE is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("PICTURE =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("PICTURE <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("PICTURE >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("PICTURE >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("PICTURE <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("PICTURE <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("PICTURE like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("PICTURE not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("PICTURE in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("PICTURE not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("PICTURE between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("PICTURE not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andCardIsNull() {
            addCriterion("CARD is null");
            return (Criteria) this;
        }

        public Criteria andCardIsNotNull() {
            addCriterion("CARD is not null");
            return (Criteria) this;
        }

        public Criteria andCardEqualTo(Integer value) {
            addCriterion("CARD =", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotEqualTo(Integer value) {
            addCriterion("CARD <>", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardGreaterThan(Integer value) {
            addCriterion("CARD >", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("CARD >=", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardLessThan(Integer value) {
            addCriterion("CARD <", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardLessThanOrEqualTo(Integer value) {
            addCriterion("CARD <=", value, "card");
            return (Criteria) this;
        }

        public Criteria andCardIn(List<Integer> values) {
            addCriterion("CARD in", values, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotIn(List<Integer> values) {
            addCriterion("CARD not in", values, "card");
            return (Criteria) this;
        }

        public Criteria andCardBetween(Integer value1, Integer value2) {
            addCriterion("CARD between", value1, value2, "card");
            return (Criteria) this;
        }

        public Criteria andCardNotBetween(Integer value1, Integer value2) {
            addCriterion("CARD not between", value1, value2, "card");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedIsNull() {
            addCriterion("IS_MOBILE_AUTHED is null");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedIsNotNull() {
            addCriterion("IS_MOBILE_AUTHED is not null");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedEqualTo(Integer value) {
            addCriterion("IS_MOBILE_AUTHED =", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedNotEqualTo(Integer value) {
            addCriterion("IS_MOBILE_AUTHED <>", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedGreaterThan(Integer value) {
            addCriterion("IS_MOBILE_AUTHED >", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_MOBILE_AUTHED >=", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedLessThan(Integer value) {
            addCriterion("IS_MOBILE_AUTHED <", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedLessThanOrEqualTo(Integer value) {
            addCriterion("IS_MOBILE_AUTHED <=", value, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedIn(List<Integer> values) {
            addCriterion("IS_MOBILE_AUTHED in", values, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedNotIn(List<Integer> values) {
            addCriterion("IS_MOBILE_AUTHED not in", values, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedBetween(Integer value1, Integer value2) {
            addCriterion("IS_MOBILE_AUTHED between", value1, value2, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsMobileAuthedNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_MOBILE_AUTHED not between", value1, value2, "isMobileAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedIsNull() {
            addCriterion("IS_EMAIL_AUTHED is null");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedIsNotNull() {
            addCriterion("IS_EMAIL_AUTHED is not null");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedEqualTo(Integer value) {
            addCriterion("IS_EMAIL_AUTHED =", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedNotEqualTo(Integer value) {
            addCriterion("IS_EMAIL_AUTHED <>", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedGreaterThan(Integer value) {
            addCriterion("IS_EMAIL_AUTHED >", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_EMAIL_AUTHED >=", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedLessThan(Integer value) {
            addCriterion("IS_EMAIL_AUTHED <", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedLessThanOrEqualTo(Integer value) {
            addCriterion("IS_EMAIL_AUTHED <=", value, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedIn(List<Integer> values) {
            addCriterion("IS_EMAIL_AUTHED in", values, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedNotIn(List<Integer> values) {
            addCriterion("IS_EMAIL_AUTHED not in", values, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedBetween(Integer value1, Integer value2) {
            addCriterion("IS_EMAIL_AUTHED between", value1, value2, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andIsEmailAuthedNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_EMAIL_AUTHED not between", value1, value2, "isEmailAuthed");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateIsNull() {
            addCriterion("CERATE_PLAY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateIsNotNull() {
            addCriterion("CERATE_PLAY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateEqualTo(Date value) {
            addCriterion("CERATE_PLAY_DATE =", value, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateNotEqualTo(Date value) {
            addCriterion("CERATE_PLAY_DATE <>", value, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateGreaterThan(Date value) {
            addCriterion("CERATE_PLAY_DATE >", value, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CERATE_PLAY_DATE >=", value, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateLessThan(Date value) {
            addCriterion("CERATE_PLAY_DATE <", value, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateLessThanOrEqualTo(Date value) {
            addCriterion("CERATE_PLAY_DATE <=", value, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateIn(List<Date> values) {
            addCriterion("CERATE_PLAY_DATE in", values, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateNotIn(List<Date> values) {
            addCriterion("CERATE_PLAY_DATE not in", values, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateBetween(Date value1, Date value2) {
            addCriterion("CERATE_PLAY_DATE between", value1, value2, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andCeratePlayDateNotBetween(Date value1, Date value2) {
            addCriterion("CERATE_PLAY_DATE not between", value1, value2, "ceratePlayDate");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIsNull() {
            addCriterion("PLAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIsNotNull() {
            addCriterion("PLAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPlayStatusEqualTo(Integer value) {
            addCriterion("PLAY_STATUS =", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotEqualTo(Integer value) {
            addCriterion("PLAY_STATUS <>", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusGreaterThan(Integer value) {
            addCriterion("PLAY_STATUS >", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAY_STATUS >=", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusLessThan(Integer value) {
            addCriterion("PLAY_STATUS <", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("PLAY_STATUS <=", value, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusIn(List<Integer> values) {
            addCriterion("PLAY_STATUS in", values, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotIn(List<Integer> values) {
            addCriterion("PLAY_STATUS not in", values, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_STATUS between", value1, value2, "playStatus");
            return (Criteria) this;
        }

        public Criteria andPlayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_STATUS not between", value1, value2, "playStatus");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeIsNull() {
            addCriterion("USER_GRADE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeIsNotNull() {
            addCriterion("USER_GRADE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeEqualTo(Integer value) {
            addCriterion("USER_GRADE_TYPE =", value, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeNotEqualTo(Integer value) {
            addCriterion("USER_GRADE_TYPE <>", value, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeGreaterThan(Integer value) {
            addCriterion("USER_GRADE_TYPE >", value, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_GRADE_TYPE >=", value, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeLessThan(Integer value) {
            addCriterion("USER_GRADE_TYPE <", value, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("USER_GRADE_TYPE <=", value, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeIn(List<Integer> values) {
            addCriterion("USER_GRADE_TYPE in", values, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeNotIn(List<Integer> values) {
            addCriterion("USER_GRADE_TYPE not in", values, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeBetween(Integer value1, Integer value2) {
            addCriterion("USER_GRADE_TYPE between", value1, value2, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andUserGradeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_GRADE_TYPE not between", value1, value2, "userGradeType");
            return (Criteria) this;
        }

        public Criteria andErrorCountIsNull() {
            addCriterion("ERROR_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andErrorCountIsNotNull() {
            addCriterion("ERROR_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCountEqualTo(Integer value) {
            addCriterion("ERROR_COUNT =", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotEqualTo(Integer value) {
            addCriterion("ERROR_COUNT <>", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountGreaterThan(Integer value) {
            addCriterion("ERROR_COUNT >", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERROR_COUNT >=", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountLessThan(Integer value) {
            addCriterion("ERROR_COUNT <", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountLessThanOrEqualTo(Integer value) {
            addCriterion("ERROR_COUNT <=", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountIn(List<Integer> values) {
            addCriterion("ERROR_COUNT in", values, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotIn(List<Integer> values) {
            addCriterion("ERROR_COUNT not in", values, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_COUNT between", value1, value2, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_COUNT not between", value1, value2, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorDateIsNull() {
            addCriterion("ERROR_DATE is null");
            return (Criteria) this;
        }

        public Criteria andErrorDateIsNotNull() {
            addCriterion("ERROR_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorDateEqualTo(Date value) {
            addCriterion("ERROR_DATE =", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateNotEqualTo(Date value) {
            addCriterion("ERROR_DATE <>", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateGreaterThan(Date value) {
            addCriterion("ERROR_DATE >", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ERROR_DATE >=", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateLessThan(Date value) {
            addCriterion("ERROR_DATE <", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateLessThanOrEqualTo(Date value) {
            addCriterion("ERROR_DATE <=", value, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateIn(List<Date> values) {
            addCriterion("ERROR_DATE in", values, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateNotIn(List<Date> values) {
            addCriterion("ERROR_DATE not in", values, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateBetween(Date value1, Date value2) {
            addCriterion("ERROR_DATE between", value1, value2, "errorDate");
            return (Criteria) this;
        }

        public Criteria andErrorDateNotBetween(Date value1, Date value2) {
            addCriterion("ERROR_DATE not between", value1, value2, "errorDate");
            return (Criteria) this;
        }

        public Criteria andIsChargeIsNull() {
            addCriterion("IS_CHARGE is null");
            return (Criteria) this;
        }

        public Criteria andIsChargeIsNotNull() {
            addCriterion("IS_CHARGE is not null");
            return (Criteria) this;
        }

        public Criteria andIsChargeEqualTo(Integer value) {
            addCriterion("IS_CHARGE =", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeNotEqualTo(Integer value) {
            addCriterion("IS_CHARGE <>", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeGreaterThan(Integer value) {
            addCriterion("IS_CHARGE >", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_CHARGE >=", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeLessThan(Integer value) {
            addCriterion("IS_CHARGE <", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeLessThanOrEqualTo(Integer value) {
            addCriterion("IS_CHARGE <=", value, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeIn(List<Integer> values) {
            addCriterion("IS_CHARGE in", values, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeNotIn(List<Integer> values) {
            addCriterion("IS_CHARGE not in", values, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeBetween(Integer value1, Integer value2) {
            addCriterion("IS_CHARGE between", value1, value2, "isCharge");
            return (Criteria) this;
        }

        public Criteria andIsChargeNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_CHARGE not between", value1, value2, "isCharge");
            return (Criteria) this;
        }

        public Criteria andDigestIsNull() {
            addCriterion("DIGEST is null");
            return (Criteria) this;
        }

        public Criteria andDigestIsNotNull() {
            addCriterion("DIGEST is not null");
            return (Criteria) this;
        }

        public Criteria andDigestEqualTo(String value) {
            addCriterion("DIGEST =", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotEqualTo(String value) {
            addCriterion("DIGEST <>", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThan(String value) {
            addCriterion("DIGEST >", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThanOrEqualTo(String value) {
            addCriterion("DIGEST >=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThan(String value) {
            addCriterion("DIGEST <", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThanOrEqualTo(String value) {
            addCriterion("DIGEST <=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLike(String value) {
            addCriterion("DIGEST like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotLike(String value) {
            addCriterion("DIGEST not like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestIn(List<String> values) {
            addCriterion("DIGEST in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotIn(List<String> values) {
            addCriterion("DIGEST not in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestBetween(String value1, String value2) {
            addCriterion("DIGEST between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotBetween(String value1, String value2) {
            addCriterion("DIGEST not between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistIsNull() {
            addCriterion("IS_WHITELIST is null");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistIsNotNull() {
            addCriterion("IS_WHITELIST is not null");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistEqualTo(Integer value) {
            addCriterion("IS_WHITELIST =", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistNotEqualTo(Integer value) {
            addCriterion("IS_WHITELIST <>", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistGreaterThan(Integer value) {
            addCriterion("IS_WHITELIST >", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_WHITELIST >=", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistLessThan(Integer value) {
            addCriterion("IS_WHITELIST <", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistLessThanOrEqualTo(Integer value) {
            addCriterion("IS_WHITELIST <=", value, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistIn(List<Integer> values) {
            addCriterion("IS_WHITELIST in", values, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistNotIn(List<Integer> values) {
            addCriterion("IS_WHITELIST not in", values, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistBetween(Integer value1, Integer value2) {
            addCriterion("IS_WHITELIST between", value1, value2, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andIsWhitelistNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_WHITELIST not between", value1, value2, "isWhitelist");
            return (Criteria) this;
        }

        public Criteria andPayWaysIsNull() {
            addCriterion("PAY_WAYS is null");
            return (Criteria) this;
        }

        public Criteria andPayWaysIsNotNull() {
            addCriterion("PAY_WAYS is not null");
            return (Criteria) this;
        }

        public Criteria andPayWaysEqualTo(String value) {
            addCriterion("PAY_WAYS =", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysNotEqualTo(String value) {
            addCriterion("PAY_WAYS <>", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysGreaterThan(String value) {
            addCriterion("PAY_WAYS >", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_WAYS >=", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysLessThan(String value) {
            addCriterion("PAY_WAYS <", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysLessThanOrEqualTo(String value) {
            addCriterion("PAY_WAYS <=", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysLike(String value) {
            addCriterion("PAY_WAYS like", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysNotLike(String value) {
            addCriterion("PAY_WAYS not like", value, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysIn(List<String> values) {
            addCriterion("PAY_WAYS in", values, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysNotIn(List<String> values) {
            addCriterion("PAY_WAYS not in", values, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysBetween(String value1, String value2) {
            addCriterion("PAY_WAYS between", value1, value2, "payWays");
            return (Criteria) this;
        }

        public Criteria andPayWaysNotBetween(String value1, String value2) {
            addCriterion("PAY_WAYS not between", value1, value2, "payWays");
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