package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryBasketballFcaward2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryBasketballFcaward2Example() {
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

        public Criteria andMatchidIsNull() {
            addCriterion("matchId is null");
            return (Criteria) this;
        }

        public Criteria andMatchidIsNotNull() {
            addCriterion("matchId is not null");
            return (Criteria) this;
        }

        public Criteria andMatchidEqualTo(Integer value) {
            addCriterion("matchId =", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotEqualTo(Integer value) {
            addCriterion("matchId <>", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThan(Integer value) {
            addCriterion("matchId >", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThanOrEqualTo(Integer value) {
            addCriterion("matchId >=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThan(Integer value) {
            addCriterion("matchId <", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThanOrEqualTo(Integer value) {
            addCriterion("matchId <=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidIn(List<Integer> values) {
            addCriterion("matchId in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotIn(List<Integer> values) {
            addCriterion("matchId not in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidBetween(Integer value1, Integer value2) {
            addCriterion("matchId between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotBetween(Integer value1, Integer value2) {
            addCriterion("matchId not between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andInttimeIsNull() {
            addCriterion("intTime is null");
            return (Criteria) this;
        }

        public Criteria andInttimeIsNotNull() {
            addCriterion("intTime is not null");
            return (Criteria) this;
        }

        public Criteria andInttimeEqualTo(Integer value) {
            addCriterion("intTime =", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotEqualTo(Integer value) {
            addCriterion("intTime <>", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeGreaterThan(Integer value) {
            addCriterion("intTime >", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("intTime >=", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeLessThan(Integer value) {
            addCriterion("intTime <", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeLessThanOrEqualTo(Integer value) {
            addCriterion("intTime <=", value, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeIn(List<Integer> values) {
            addCriterion("intTime in", values, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotIn(List<Integer> values) {
            addCriterion("intTime not in", values, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeBetween(Integer value1, Integer value2) {
            addCriterion("intTime between", value1, value2, "inttime");
            return (Criteria) this;
        }

        public Criteria andInttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("intTime not between", value1, value2, "inttime");
            return (Criteria) this;
        }

        public Criteria andLineidIsNull() {
            addCriterion("lineId is null");
            return (Criteria) this;
        }

        public Criteria andLineidIsNotNull() {
            addCriterion("lineId is not null");
            return (Criteria) this;
        }

        public Criteria andLineidEqualTo(Integer value) {
            addCriterion("lineId =", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotEqualTo(Integer value) {
            addCriterion("lineId <>", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThan(Integer value) {
            addCriterion("lineId >", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lineId >=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThan(Integer value) {
            addCriterion("lineId <", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThanOrEqualTo(Integer value) {
            addCriterion("lineId <=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidIn(List<Integer> values) {
            addCriterion("lineId in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotIn(List<Integer> values) {
            addCriterion("lineId not in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidBetween(Integer value1, Integer value2) {
            addCriterion("lineId between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotBetween(Integer value1, Integer value2) {
            addCriterion("lineId not between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andPassmodeIsNull() {
            addCriterion("passMode is null");
            return (Criteria) this;
        }

        public Criteria andPassmodeIsNotNull() {
            addCriterion("passMode is not null");
            return (Criteria) this;
        }

        public Criteria andPassmodeEqualTo(Integer value) {
            addCriterion("passMode =", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeNotEqualTo(Integer value) {
            addCriterion("passMode <>", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeGreaterThan(Integer value) {
            addCriterion("passMode >", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("passMode >=", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeLessThan(Integer value) {
            addCriterion("passMode <", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeLessThanOrEqualTo(Integer value) {
            addCriterion("passMode <=", value, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeIn(List<Integer> values) {
            addCriterion("passMode in", values, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeNotIn(List<Integer> values) {
            addCriterion("passMode not in", values, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeBetween(Integer value1, Integer value2) {
            addCriterion("passMode between", value1, value2, "passmode");
            return (Criteria) this;
        }

        public Criteria andPassmodeNotBetween(Integer value1, Integer value2) {
            addCriterion("passMode not between", value1, value2, "passmode");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5IsNull() {
            addCriterion("HWawardOf1to5 is null");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5IsNotNull() {
            addCriterion("HWawardOf1to5 is not null");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5EqualTo(Double value) {
            addCriterion("HWawardOf1to5 =", value, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5NotEqualTo(Double value) {
            addCriterion("HWawardOf1to5 <>", value, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5GreaterThan(Double value) {
            addCriterion("HWawardOf1to5 >", value, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5GreaterThanOrEqualTo(Double value) {
            addCriterion("HWawardOf1to5 >=", value, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5LessThan(Double value) {
            addCriterion("HWawardOf1to5 <", value, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5LessThanOrEqualTo(Double value) {
            addCriterion("HWawardOf1to5 <=", value, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5In(List<Double> values) {
            addCriterion("HWawardOf1to5 in", values, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5NotIn(List<Double> values) {
            addCriterion("HWawardOf1to5 not in", values, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5Between(Double value1, Double value2) {
            addCriterion("HWawardOf1to5 between", value1, value2, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof1to5NotBetween(Double value1, Double value2) {
            addCriterion("HWawardOf1to5 not between", value1, value2, "hwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10IsNull() {
            addCriterion("HWawardOf6TO10 is null");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10IsNotNull() {
            addCriterion("HWawardOf6TO10 is not null");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10EqualTo(Double value) {
            addCriterion("HWawardOf6TO10 =", value, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10NotEqualTo(Double value) {
            addCriterion("HWawardOf6TO10 <>", value, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10GreaterThan(Double value) {
            addCriterion("HWawardOf6TO10 >", value, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10GreaterThanOrEqualTo(Double value) {
            addCriterion("HWawardOf6TO10 >=", value, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10LessThan(Double value) {
            addCriterion("HWawardOf6TO10 <", value, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10LessThanOrEqualTo(Double value) {
            addCriterion("HWawardOf6TO10 <=", value, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10In(List<Double> values) {
            addCriterion("HWawardOf6TO10 in", values, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10NotIn(List<Double> values) {
            addCriterion("HWawardOf6TO10 not in", values, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10Between(Double value1, Double value2) {
            addCriterion("HWawardOf6TO10 between", value1, value2, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof6to10NotBetween(Double value1, Double value2) {
            addCriterion("HWawardOf6TO10 not between", value1, value2, "hwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15IsNull() {
            addCriterion("HWawardOf11TO15 is null");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15IsNotNull() {
            addCriterion("HWawardOf11TO15 is not null");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15EqualTo(Double value) {
            addCriterion("HWawardOf11TO15 =", value, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15NotEqualTo(Double value) {
            addCriterion("HWawardOf11TO15 <>", value, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15GreaterThan(Double value) {
            addCriterion("HWawardOf11TO15 >", value, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15GreaterThanOrEqualTo(Double value) {
            addCriterion("HWawardOf11TO15 >=", value, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15LessThan(Double value) {
            addCriterion("HWawardOf11TO15 <", value, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15LessThanOrEqualTo(Double value) {
            addCriterion("HWawardOf11TO15 <=", value, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15In(List<Double> values) {
            addCriterion("HWawardOf11TO15 in", values, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15NotIn(List<Double> values) {
            addCriterion("HWawardOf11TO15 not in", values, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15Between(Double value1, Double value2) {
            addCriterion("HWawardOf11TO15 between", value1, value2, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof11to15NotBetween(Double value1, Double value2) {
            addCriterion("HWawardOf11TO15 not between", value1, value2, "hwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20IsNull() {
            addCriterion("HWawardOf16TO20 is null");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20IsNotNull() {
            addCriterion("HWawardOf16TO20 is not null");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20EqualTo(Double value) {
            addCriterion("HWawardOf16TO20 =", value, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20NotEqualTo(Double value) {
            addCriterion("HWawardOf16TO20 <>", value, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20GreaterThan(Double value) {
            addCriterion("HWawardOf16TO20 >", value, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20GreaterThanOrEqualTo(Double value) {
            addCriterion("HWawardOf16TO20 >=", value, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20LessThan(Double value) {
            addCriterion("HWawardOf16TO20 <", value, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20LessThanOrEqualTo(Double value) {
            addCriterion("HWawardOf16TO20 <=", value, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20In(List<Double> values) {
            addCriterion("HWawardOf16TO20 in", values, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20NotIn(List<Double> values) {
            addCriterion("HWawardOf16TO20 not in", values, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20Between(Double value1, Double value2) {
            addCriterion("HWawardOf16TO20 between", value1, value2, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof16to20NotBetween(Double value1, Double value2) {
            addCriterion("HWawardOf16TO20 not between", value1, value2, "hwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25IsNull() {
            addCriterion("HWawardOf21TO25 is null");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25IsNotNull() {
            addCriterion("HWawardOf21TO25 is not null");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25EqualTo(Double value) {
            addCriterion("HWawardOf21TO25 =", value, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25NotEqualTo(Double value) {
            addCriterion("HWawardOf21TO25 <>", value, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25GreaterThan(Double value) {
            addCriterion("HWawardOf21TO25 >", value, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25GreaterThanOrEqualTo(Double value) {
            addCriterion("HWawardOf21TO25 >=", value, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25LessThan(Double value) {
            addCriterion("HWawardOf21TO25 <", value, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25LessThanOrEqualTo(Double value) {
            addCriterion("HWawardOf21TO25 <=", value, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25In(List<Double> values) {
            addCriterion("HWawardOf21TO25 in", values, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25NotIn(List<Double> values) {
            addCriterion("HWawardOf21TO25 not in", values, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25Between(Double value1, Double value2) {
            addCriterion("HWawardOf21TO25 between", value1, value2, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof21to25NotBetween(Double value1, Double value2) {
            addCriterion("HWawardOf21TO25 not between", value1, value2, "hwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andHwawardof26IsNull() {
            addCriterion("HWawardOf26 is null");
            return (Criteria) this;
        }

        public Criteria andHwawardof26IsNotNull() {
            addCriterion("HWawardOf26 is not null");
            return (Criteria) this;
        }

        public Criteria andHwawardof26EqualTo(Double value) {
            addCriterion("HWawardOf26 =", value, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26NotEqualTo(Double value) {
            addCriterion("HWawardOf26 <>", value, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26GreaterThan(Double value) {
            addCriterion("HWawardOf26 >", value, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26GreaterThanOrEqualTo(Double value) {
            addCriterion("HWawardOf26 >=", value, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26LessThan(Double value) {
            addCriterion("HWawardOf26 <", value, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26LessThanOrEqualTo(Double value) {
            addCriterion("HWawardOf26 <=", value, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26In(List<Double> values) {
            addCriterion("HWawardOf26 in", values, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26NotIn(List<Double> values) {
            addCriterion("HWawardOf26 not in", values, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26Between(Double value1, Double value2) {
            addCriterion("HWawardOf26 between", value1, value2, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andHwawardof26NotBetween(Double value1, Double value2) {
            addCriterion("HWawardOf26 not between", value1, value2, "hwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5IsNull() {
            addCriterion("GWawardOf1TO5 is null");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5IsNotNull() {
            addCriterion("GWawardOf1TO5 is not null");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5EqualTo(Double value) {
            addCriterion("GWawardOf1TO5 =", value, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5NotEqualTo(Double value) {
            addCriterion("GWawardOf1TO5 <>", value, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5GreaterThan(Double value) {
            addCriterion("GWawardOf1TO5 >", value, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5GreaterThanOrEqualTo(Double value) {
            addCriterion("GWawardOf1TO5 >=", value, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5LessThan(Double value) {
            addCriterion("GWawardOf1TO5 <", value, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5LessThanOrEqualTo(Double value) {
            addCriterion("GWawardOf1TO5 <=", value, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5In(List<Double> values) {
            addCriterion("GWawardOf1TO5 in", values, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5NotIn(List<Double> values) {
            addCriterion("GWawardOf1TO5 not in", values, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5Between(Double value1, Double value2) {
            addCriterion("GWawardOf1TO5 between", value1, value2, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof1to5NotBetween(Double value1, Double value2) {
            addCriterion("GWawardOf1TO5 not between", value1, value2, "gwawardof1to5");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10IsNull() {
            addCriterion("GWawardOf6TO10 is null");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10IsNotNull() {
            addCriterion("GWawardOf6TO10 is not null");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10EqualTo(Double value) {
            addCriterion("GWawardOf6TO10 =", value, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10NotEqualTo(Double value) {
            addCriterion("GWawardOf6TO10 <>", value, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10GreaterThan(Double value) {
            addCriterion("GWawardOf6TO10 >", value, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10GreaterThanOrEqualTo(Double value) {
            addCriterion("GWawardOf6TO10 >=", value, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10LessThan(Double value) {
            addCriterion("GWawardOf6TO10 <", value, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10LessThanOrEqualTo(Double value) {
            addCriterion("GWawardOf6TO10 <=", value, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10In(List<Double> values) {
            addCriterion("GWawardOf6TO10 in", values, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10NotIn(List<Double> values) {
            addCriterion("GWawardOf6TO10 not in", values, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10Between(Double value1, Double value2) {
            addCriterion("GWawardOf6TO10 between", value1, value2, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof6to10NotBetween(Double value1, Double value2) {
            addCriterion("GWawardOf6TO10 not between", value1, value2, "gwawardof6to10");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15IsNull() {
            addCriterion("GWawardOf11TO15 is null");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15IsNotNull() {
            addCriterion("GWawardOf11TO15 is not null");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15EqualTo(Double value) {
            addCriterion("GWawardOf11TO15 =", value, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15NotEqualTo(Double value) {
            addCriterion("GWawardOf11TO15 <>", value, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15GreaterThan(Double value) {
            addCriterion("GWawardOf11TO15 >", value, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15GreaterThanOrEqualTo(Double value) {
            addCriterion("GWawardOf11TO15 >=", value, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15LessThan(Double value) {
            addCriterion("GWawardOf11TO15 <", value, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15LessThanOrEqualTo(Double value) {
            addCriterion("GWawardOf11TO15 <=", value, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15In(List<Double> values) {
            addCriterion("GWawardOf11TO15 in", values, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15NotIn(List<Double> values) {
            addCriterion("GWawardOf11TO15 not in", values, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15Between(Double value1, Double value2) {
            addCriterion("GWawardOf11TO15 between", value1, value2, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof11to15NotBetween(Double value1, Double value2) {
            addCriterion("GWawardOf11TO15 not between", value1, value2, "gwawardof11to15");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20IsNull() {
            addCriterion("GWawardOf16TO20 is null");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20IsNotNull() {
            addCriterion("GWawardOf16TO20 is not null");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20EqualTo(Double value) {
            addCriterion("GWawardOf16TO20 =", value, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20NotEqualTo(Double value) {
            addCriterion("GWawardOf16TO20 <>", value, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20GreaterThan(Double value) {
            addCriterion("GWawardOf16TO20 >", value, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20GreaterThanOrEqualTo(Double value) {
            addCriterion("GWawardOf16TO20 >=", value, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20LessThan(Double value) {
            addCriterion("GWawardOf16TO20 <", value, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20LessThanOrEqualTo(Double value) {
            addCriterion("GWawardOf16TO20 <=", value, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20In(List<Double> values) {
            addCriterion("GWawardOf16TO20 in", values, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20NotIn(List<Double> values) {
            addCriterion("GWawardOf16TO20 not in", values, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20Between(Double value1, Double value2) {
            addCriterion("GWawardOf16TO20 between", value1, value2, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof16to20NotBetween(Double value1, Double value2) {
            addCriterion("GWawardOf16TO20 not between", value1, value2, "gwawardof16to20");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25IsNull() {
            addCriterion("GWawardOf21TO25 is null");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25IsNotNull() {
            addCriterion("GWawardOf21TO25 is not null");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25EqualTo(Double value) {
            addCriterion("GWawardOf21TO25 =", value, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25NotEqualTo(Double value) {
            addCriterion("GWawardOf21TO25 <>", value, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25GreaterThan(Double value) {
            addCriterion("GWawardOf21TO25 >", value, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25GreaterThanOrEqualTo(Double value) {
            addCriterion("GWawardOf21TO25 >=", value, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25LessThan(Double value) {
            addCriterion("GWawardOf21TO25 <", value, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25LessThanOrEqualTo(Double value) {
            addCriterion("GWawardOf21TO25 <=", value, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25In(List<Double> values) {
            addCriterion("GWawardOf21TO25 in", values, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25NotIn(List<Double> values) {
            addCriterion("GWawardOf21TO25 not in", values, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25Between(Double value1, Double value2) {
            addCriterion("GWawardOf21TO25 between", value1, value2, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof21to25NotBetween(Double value1, Double value2) {
            addCriterion("GWawardOf21TO25 not between", value1, value2, "gwawardof21to25");
            return (Criteria) this;
        }

        public Criteria andGwawardof26IsNull() {
            addCriterion("GWawardOf26 is null");
            return (Criteria) this;
        }

        public Criteria andGwawardof26IsNotNull() {
            addCriterion("GWawardOf26 is not null");
            return (Criteria) this;
        }

        public Criteria andGwawardof26EqualTo(Double value) {
            addCriterion("GWawardOf26 =", value, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26NotEqualTo(Double value) {
            addCriterion("GWawardOf26 <>", value, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26GreaterThan(Double value) {
            addCriterion("GWawardOf26 >", value, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26GreaterThanOrEqualTo(Double value) {
            addCriterion("GWawardOf26 >=", value, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26LessThan(Double value) {
            addCriterion("GWawardOf26 <", value, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26LessThanOrEqualTo(Double value) {
            addCriterion("GWawardOf26 <=", value, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26In(List<Double> values) {
            addCriterion("GWawardOf26 in", values, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26NotIn(List<Double> values) {
            addCriterion("GWawardOf26 not in", values, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26Between(Double value1, Double value2) {
            addCriterion("GWawardOf26 between", value1, value2, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andGwawardof26NotBetween(Double value1, Double value2) {
            addCriterion("GWawardOf26 not between", value1, value2, "gwawardof26");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNull() {
            addCriterion("lastUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNotNull() {
            addCriterion("lastUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeEqualTo(Date value) {
            addCriterion("lastUpdateTime =", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotEqualTo(Date value) {
            addCriterion("lastUpdateTime <>", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThan(Date value) {
            addCriterion("lastUpdateTime >", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastUpdateTime >=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThan(Date value) {
            addCriterion("lastUpdateTime <", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("lastUpdateTime <=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIn(List<Date> values) {
            addCriterion("lastUpdateTime in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotIn(List<Date> values) {
            addCriterion("lastUpdateTime not in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("lastUpdateTime between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("lastUpdateTime not between", value1, value2, "lastupdatetime");
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