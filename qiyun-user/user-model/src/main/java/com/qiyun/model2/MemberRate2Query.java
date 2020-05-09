package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberRate2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberRate2Query() {
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

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeIsNull() {
            addCriterion("RETURN_POINT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeIsNotNull() {
            addCriterion("RETURN_POINT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeEqualTo(Integer value) {
            addCriterion("RETURN_POINT_TYPE =", value, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeNotEqualTo(Integer value) {
            addCriterion("RETURN_POINT_TYPE <>", value, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeGreaterThan(Integer value) {
            addCriterion("RETURN_POINT_TYPE >", value, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETURN_POINT_TYPE >=", value, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeLessThan(Integer value) {
            addCriterion("RETURN_POINT_TYPE <", value, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeLessThanOrEqualTo(Integer value) {
            addCriterion("RETURN_POINT_TYPE <=", value, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeIn(List<Integer> values) {
            addCriterion("RETURN_POINT_TYPE in", values, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeNotIn(List<Integer> values) {
            addCriterion("RETURN_POINT_TYPE not in", values, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeBetween(Integer value1, Integer value2) {
            addCriterion("RETURN_POINT_TYPE between", value1, value2, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andReturnPointTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("RETURN_POINT_TYPE not between", value1, value2, "returnPointType");
            return (Criteria) this;
        }

        public Criteria andJjDgRateIsNull() {
            addCriterion("JJ_DG_RATE is null");
            return (Criteria) this;
        }

        public Criteria andJjDgRateIsNotNull() {
            addCriterion("JJ_DG_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andJjDgRateEqualTo(Double value) {
            addCriterion("JJ_DG_RATE =", value, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateNotEqualTo(Double value) {
            addCriterion("JJ_DG_RATE <>", value, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateGreaterThan(Double value) {
            addCriterion("JJ_DG_RATE >", value, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateGreaterThanOrEqualTo(Double value) {
            addCriterion("JJ_DG_RATE >=", value, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateLessThan(Double value) {
            addCriterion("JJ_DG_RATE <", value, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateLessThanOrEqualTo(Double value) {
            addCriterion("JJ_DG_RATE <=", value, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateIn(List<Double> values) {
            addCriterion("JJ_DG_RATE in", values, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateNotIn(List<Double> values) {
            addCriterion("JJ_DG_RATE not in", values, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateBetween(Double value1, Double value2) {
            addCriterion("JJ_DG_RATE between", value1, value2, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjDgRateNotBetween(Double value1, Double value2) {
            addCriterion("JJ_DG_RATE not between", value1, value2, "jjDgRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateIsNull() {
            addCriterion("JJ_HM_RATE is null");
            return (Criteria) this;
        }

        public Criteria andJjHmRateIsNotNull() {
            addCriterion("JJ_HM_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andJjHmRateEqualTo(Double value) {
            addCriterion("JJ_HM_RATE =", value, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateNotEqualTo(Double value) {
            addCriterion("JJ_HM_RATE <>", value, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateGreaterThan(Double value) {
            addCriterion("JJ_HM_RATE >", value, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateGreaterThanOrEqualTo(Double value) {
            addCriterion("JJ_HM_RATE >=", value, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateLessThan(Double value) {
            addCriterion("JJ_HM_RATE <", value, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateLessThanOrEqualTo(Double value) {
            addCriterion("JJ_HM_RATE <=", value, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateIn(List<Double> values) {
            addCriterion("JJ_HM_RATE in", values, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateNotIn(List<Double> values) {
            addCriterion("JJ_HM_RATE not in", values, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateBetween(Double value1, Double value2) {
            addCriterion("JJ_HM_RATE between", value1, value2, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andJjHmRateNotBetween(Double value1, Double value2) {
            addCriterion("JJ_HM_RATE not between", value1, value2, "jjHmRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateIsNull() {
            addCriterion("FD_DG_RATE is null");
            return (Criteria) this;
        }

        public Criteria andFdDgRateIsNotNull() {
            addCriterion("FD_DG_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andFdDgRateEqualTo(Double value) {
            addCriterion("FD_DG_RATE =", value, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateNotEqualTo(Double value) {
            addCriterion("FD_DG_RATE <>", value, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateGreaterThan(Double value) {
            addCriterion("FD_DG_RATE >", value, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateGreaterThanOrEqualTo(Double value) {
            addCriterion("FD_DG_RATE >=", value, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateLessThan(Double value) {
            addCriterion("FD_DG_RATE <", value, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateLessThanOrEqualTo(Double value) {
            addCriterion("FD_DG_RATE <=", value, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateIn(List<Double> values) {
            addCriterion("FD_DG_RATE in", values, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateNotIn(List<Double> values) {
            addCriterion("FD_DG_RATE not in", values, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateBetween(Double value1, Double value2) {
            addCriterion("FD_DG_RATE between", value1, value2, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdDgRateNotBetween(Double value1, Double value2) {
            addCriterion("FD_DG_RATE not between", value1, value2, "fdDgRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateIsNull() {
            addCriterion("FD_HM_RATE is null");
            return (Criteria) this;
        }

        public Criteria andFdHmRateIsNotNull() {
            addCriterion("FD_HM_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andFdHmRateEqualTo(Double value) {
            addCriterion("FD_HM_RATE =", value, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateNotEqualTo(Double value) {
            addCriterion("FD_HM_RATE <>", value, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateGreaterThan(Double value) {
            addCriterion("FD_HM_RATE >", value, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateGreaterThanOrEqualTo(Double value) {
            addCriterion("FD_HM_RATE >=", value, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateLessThan(Double value) {
            addCriterion("FD_HM_RATE <", value, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateLessThanOrEqualTo(Double value) {
            addCriterion("FD_HM_RATE <=", value, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateIn(List<Double> values) {
            addCriterion("FD_HM_RATE in", values, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateNotIn(List<Double> values) {
            addCriterion("FD_HM_RATE not in", values, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateBetween(Double value1, Double value2) {
            addCriterion("FD_HM_RATE between", value1, value2, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andFdHmRateNotBetween(Double value1, Double value2) {
            addCriterion("FD_HM_RATE not between", value1, value2, "fdHmRate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateIsNull() {
            addCriterion("RATE_CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateIsNotNull() {
            addCriterion("RATE_CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateEqualTo(Date value) {
            addCriterion("RATE_CREATE_DATE =", value, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateNotEqualTo(Date value) {
            addCriterion("RATE_CREATE_DATE <>", value, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateGreaterThan(Date value) {
            addCriterion("RATE_CREATE_DATE >", value, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("RATE_CREATE_DATE >=", value, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateLessThan(Date value) {
            addCriterion("RATE_CREATE_DATE <", value, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("RATE_CREATE_DATE <=", value, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateIn(List<Date> values) {
            addCriterion("RATE_CREATE_DATE in", values, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateNotIn(List<Date> values) {
            addCriterion("RATE_CREATE_DATE not in", values, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateBetween(Date value1, Date value2) {
            addCriterion("RATE_CREATE_DATE between", value1, value2, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("RATE_CREATE_DATE not between", value1, value2, "rateCreateDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateIsNull() {
            addCriterion("RATE_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRateEndDateIsNotNull() {
            addCriterion("RATE_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRateEndDateEqualTo(Date value) {
            addCriterion("RATE_END_DATE =", value, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateNotEqualTo(Date value) {
            addCriterion("RATE_END_DATE <>", value, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateGreaterThan(Date value) {
            addCriterion("RATE_END_DATE >", value, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("RATE_END_DATE >=", value, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateLessThan(Date value) {
            addCriterion("RATE_END_DATE <", value, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateLessThanOrEqualTo(Date value) {
            addCriterion("RATE_END_DATE <=", value, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateIn(List<Date> values) {
            addCriterion("RATE_END_DATE in", values, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateNotIn(List<Date> values) {
            addCriterion("RATE_END_DATE not in", values, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateBetween(Date value1, Date value2) {
            addCriterion("RATE_END_DATE between", value1, value2, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andRateEndDateNotBetween(Date value1, Date value2) {
            addCriterion("RATE_END_DATE not between", value1, value2, "rateEndDate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateIsNull() {
            addCriterion("IS_SET_RATE is null");
            return (Criteria) this;
        }

        public Criteria andIsSetRateIsNotNull() {
            addCriterion("IS_SET_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andIsSetRateEqualTo(Integer value) {
            addCriterion("IS_SET_RATE =", value, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateNotEqualTo(Integer value) {
            addCriterion("IS_SET_RATE <>", value, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateGreaterThan(Integer value) {
            addCriterion("IS_SET_RATE >", value, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_SET_RATE >=", value, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateLessThan(Integer value) {
            addCriterion("IS_SET_RATE <", value, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateLessThanOrEqualTo(Integer value) {
            addCriterion("IS_SET_RATE <=", value, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateIn(List<Integer> values) {
            addCriterion("IS_SET_RATE in", values, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateNotIn(List<Integer> values) {
            addCriterion("IS_SET_RATE not in", values, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateBetween(Integer value1, Integer value2) {
            addCriterion("IS_SET_RATE between", value1, value2, "isSetRate");
            return (Criteria) this;
        }

        public Criteria andIsSetRateNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_SET_RATE not between", value1, value2, "isSetRate");
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