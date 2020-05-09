package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CopyLotteryPlan2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CopyLotteryPlan2Query() {
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

        public Criteria andCopyLotteryplanIdIsNull() {
            addCriterion("copy_lotteryplan_id is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdIsNotNull() {
            addCriterion("copy_lotteryplan_id is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_id =", value, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdNotEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_id <>", value, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdGreaterThan(Integer value) {
            addCriterion("copy_lotteryplan_id >", value, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_id >=", value, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdLessThan(Integer value) {
            addCriterion("copy_lotteryplan_id <", value, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdLessThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_id <=", value, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_id in", values, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdNotIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_id not in", values, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_id between", value1, value2, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_id not between", value1, value2, "copyLotteryplanId");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameIsNull() {
            addCriterion("copy_lotteryplan_name is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameIsNotNull() {
            addCriterion("copy_lotteryplan_name is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameEqualTo(String value) {
            addCriterion("copy_lotteryplan_name =", value, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameNotEqualTo(String value) {
            addCriterion("copy_lotteryplan_name <>", value, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameGreaterThan(String value) {
            addCriterion("copy_lotteryplan_name >", value, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameGreaterThanOrEqualTo(String value) {
            addCriterion("copy_lotteryplan_name >=", value, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameLessThan(String value) {
            addCriterion("copy_lotteryplan_name <", value, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameLessThanOrEqualTo(String value) {
            addCriterion("copy_lotteryplan_name <=", value, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameLike(String value) {
            addCriterion("copy_lotteryplan_name like", value, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameNotLike(String value) {
            addCriterion("copy_lotteryplan_name not like", value, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameIn(List<String> values) {
            addCriterion("copy_lotteryplan_name in", values, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameNotIn(List<String> values) {
            addCriterion("copy_lotteryplan_name not in", values, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameBetween(String value1, String value2) {
            addCriterion("copy_lotteryplan_name between", value1, value2, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNameNotBetween(String value1, String value2) {
            addCriterion("copy_lotteryplan_name not between", value1, value2, "copyLotteryplanName");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoIsNull() {
            addCriterion("copy_lotteryplan_no is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoIsNotNull() {
            addCriterion("copy_lotteryplan_no is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_no =", value, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoNotEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_no <>", value, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoGreaterThan(Integer value) {
            addCriterion("copy_lotteryplan_no >", value, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_no >=", value, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoLessThan(Integer value) {
            addCriterion("copy_lotteryplan_no <", value, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoLessThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_no <=", value, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_no in", values, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoNotIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_no not in", values, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_no between", value1, value2, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanNoNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_no not between", value1, value2, "copyLotteryplanNo");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameIsNull() {
            addCriterion("copy_lotteryplan_planName is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameIsNotNull() {
            addCriterion("copy_lotteryplan_planName is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameEqualTo(String value) {
            addCriterion("copy_lotteryplan_planName =", value, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameNotEqualTo(String value) {
            addCriterion("copy_lotteryplan_planName <>", value, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameGreaterThan(String value) {
            addCriterion("copy_lotteryplan_planName >", value, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameGreaterThanOrEqualTo(String value) {
            addCriterion("copy_lotteryplan_planName >=", value, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameLessThan(String value) {
            addCriterion("copy_lotteryplan_planName <", value, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameLessThanOrEqualTo(String value) {
            addCriterion("copy_lotteryplan_planName <=", value, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameLike(String value) {
            addCriterion("copy_lotteryplan_planName like", value, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameNotLike(String value) {
            addCriterion("copy_lotteryplan_planName not like", value, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameIn(List<String> values) {
            addCriterion("copy_lotteryplan_planName in", values, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameNotIn(List<String> values) {
            addCriterion("copy_lotteryplan_planName not in", values, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameBetween(String value1, String value2) {
            addCriterion("copy_lotteryplan_planName between", value1, value2, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlannameNotBetween(String value1, String value2) {
            addCriterion("copy_lotteryplan_planName not between", value1, value2, "copyLotteryplanPlanname");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountIsNull() {
            addCriterion("copy_lotteryplan_amount is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountIsNotNull() {
            addCriterion("copy_lotteryplan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_amount =", value, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountNotEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_amount <>", value, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountGreaterThan(Integer value) {
            addCriterion("copy_lotteryplan_amount >", value, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_amount >=", value, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountLessThan(Integer value) {
            addCriterion("copy_lotteryplan_amount <", value, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountLessThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_amount <=", value, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_amount in", values, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountNotIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_amount not in", values, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_amount between", value1, value2, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_amount not between", value1, value2, "copyLotteryplanAmount");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleIsNull() {
            addCriterion("copy_lotteryplan_multiple is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleIsNotNull() {
            addCriterion("copy_lotteryplan_multiple is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_multiple =", value, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleNotEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_multiple <>", value, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleGreaterThan(Integer value) {
            addCriterion("copy_lotteryplan_multiple >", value, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_multiple >=", value, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleLessThan(Integer value) {
            addCriterion("copy_lotteryplan_multiple <", value, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleLessThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_multiple <=", value, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_multiple in", values, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleNotIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_multiple not in", values, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_multiple between", value1, value2, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanMultipleNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_multiple not between", value1, value2, "copyLotteryplanMultiple");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeIsNull() {
            addCriterion("copy_lotteryplan_posttaxPrize is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeIsNotNull() {
            addCriterion("copy_lotteryplan_posttaxPrize is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_posttaxPrize =", value, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeNotEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_posttaxPrize <>", value, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeGreaterThan(Integer value) {
            addCriterion("copy_lotteryplan_posttaxPrize >", value, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_posttaxPrize >=", value, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeLessThan(Integer value) {
            addCriterion("copy_lotteryplan_posttaxPrize <", value, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeLessThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_posttaxPrize <=", value, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_posttaxPrize in", values, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeNotIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_posttaxPrize not in", values, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_posttaxPrize between", value1, value2, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPosttaxprizeNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_posttaxPrize not between", value1, value2, "copyLotteryplanPosttaxprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeIsNull() {
            addCriterion("copy_lotteryplan_planType is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeIsNotNull() {
            addCriterion("copy_lotteryplan_planType is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_planType =", value, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeNotEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_planType <>", value, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeGreaterThan(Integer value) {
            addCriterion("copy_lotteryplan_planType >", value, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_planType >=", value, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeLessThan(Integer value) {
            addCriterion("copy_lotteryplan_planType <", value, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeLessThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_planType <=", value, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_planType in", values, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeNotIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_planType not in", values, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_planType between", value1, value2, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlantypeNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_planType not between", value1, value2, "copyLotteryplanPlantype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeIsNull() {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeIsNotNull() {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeEqualTo(Date value) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME =", value, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeNotEqualTo(Date value) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME <>", value, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeGreaterThan(Date value) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME >", value, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME >=", value, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeLessThan(Date value) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME <", value, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME <=", value, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeIn(List<Date> values) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME in", values, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeNotIn(List<Date> values) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME not in", values, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME between", value1, value2, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("copy_lotteryplan_CREATE_DATE_TIME not between", value1, value2, "copyLotteryplanCreateDateTime");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeIsNull() {
            addCriterion("copy_lotteryplan_lotteryType is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeIsNotNull() {
            addCriterion("copy_lotteryplan_lotteryType is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_lotteryType =", value, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeNotEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_lotteryType <>", value, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeGreaterThan(Integer value) {
            addCriterion("copy_lotteryplan_lotteryType >", value, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_lotteryType >=", value, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeLessThan(Integer value) {
            addCriterion("copy_lotteryplan_lotteryType <", value, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeLessThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_lotteryType <=", value, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_lotteryType in", values, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeNotIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_lotteryType not in", values, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_lotteryType between", value1, value2, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanLotterytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_lotteryType not between", value1, value2, "copyLotteryplanLotterytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermIsNull() {
            addCriterion("copy_lotteryplan_term is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermIsNotNull() {
            addCriterion("copy_lotteryplan_term is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermEqualTo(String value) {
            addCriterion("copy_lotteryplan_term =", value, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermNotEqualTo(String value) {
            addCriterion("copy_lotteryplan_term <>", value, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermGreaterThan(String value) {
            addCriterion("copy_lotteryplan_term >", value, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermGreaterThanOrEqualTo(String value) {
            addCriterion("copy_lotteryplan_term >=", value, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermLessThan(String value) {
            addCriterion("copy_lotteryplan_term <", value, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermLessThanOrEqualTo(String value) {
            addCriterion("copy_lotteryplan_term <=", value, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermLike(String value) {
            addCriterion("copy_lotteryplan_term like", value, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermNotLike(String value) {
            addCriterion("copy_lotteryplan_term not like", value, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermIn(List<String> values) {
            addCriterion("copy_lotteryplan_term in", values, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermNotIn(List<String> values) {
            addCriterion("copy_lotteryplan_term not in", values, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermBetween(String value1, String value2) {
            addCriterion("copy_lotteryplan_term between", value1, value2, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanTermNotBetween(String value1, String value2) {
            addCriterion("copy_lotteryplan_term not between", value1, value2, "copyLotteryplanTerm");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeIsNull() {
            addCriterion("copy_lotteryplan_addPrize is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeIsNotNull() {
            addCriterion("copy_lotteryplan_addPrize is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeEqualTo(Double value) {
            addCriterion("copy_lotteryplan_addPrize =", value, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeNotEqualTo(Double value) {
            addCriterion("copy_lotteryplan_addPrize <>", value, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeGreaterThan(Double value) {
            addCriterion("copy_lotteryplan_addPrize >", value, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeGreaterThanOrEqualTo(Double value) {
            addCriterion("copy_lotteryplan_addPrize >=", value, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeLessThan(Double value) {
            addCriterion("copy_lotteryplan_addPrize <", value, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeLessThanOrEqualTo(Double value) {
            addCriterion("copy_lotteryplan_addPrize <=", value, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeIn(List<Double> values) {
            addCriterion("copy_lotteryplan_addPrize in", values, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeNotIn(List<Double> values) {
            addCriterion("copy_lotteryplan_addPrize not in", values, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeBetween(Double value1, Double value2) {
            addCriterion("copy_lotteryplan_addPrize between", value1, value2, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanAddprizeNotBetween(Double value1, Double value2) {
            addCriterion("copy_lotteryplan_addPrize not between", value1, value2, "copyLotteryplanAddprize");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeIsNull() {
            addCriterion("copy_lotteryplan_selectType is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeIsNotNull() {
            addCriterion("copy_lotteryplan_selectType is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_selectType =", value, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeNotEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_selectType <>", value, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeGreaterThan(Integer value) {
            addCriterion("copy_lotteryplan_selectType >", value, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_selectType >=", value, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeLessThan(Integer value) {
            addCriterion("copy_lotteryplan_selectType <", value, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeLessThanOrEqualTo(Integer value) {
            addCriterion("copy_lotteryplan_selectType <=", value, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_selectType in", values, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeNotIn(List<Integer> values) {
            addCriterion("copy_lotteryplan_selectType not in", values, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_selectType between", value1, value2, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanSelecttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_lotteryplan_selectType not between", value1, value2, "copyLotteryplanSelecttype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusIsNull() {
            addCriterion("copy_Lotteryplan_PublicStatus is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusIsNotNull() {
            addCriterion("copy_Lotteryplan_PublicStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusEqualTo(Integer value) {
            addCriterion("copy_Lotteryplan_PublicStatus =", value, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusNotEqualTo(Integer value) {
            addCriterion("copy_Lotteryplan_PublicStatus <>", value, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusGreaterThan(Integer value) {
            addCriterion("copy_Lotteryplan_PublicStatus >", value, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_Lotteryplan_PublicStatus >=", value, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusLessThan(Integer value) {
            addCriterion("copy_Lotteryplan_PublicStatus <", value, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusLessThanOrEqualTo(Integer value) {
            addCriterion("copy_Lotteryplan_PublicStatus <=", value, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusIn(List<Integer> values) {
            addCriterion("copy_Lotteryplan_PublicStatus in", values, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusNotIn(List<Integer> values) {
            addCriterion("copy_Lotteryplan_PublicStatus not in", values, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusBetween(Integer value1, Integer value2) {
            addCriterion("copy_Lotteryplan_PublicStatus between", value1, value2, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPublicstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_Lotteryplan_PublicStatus not between", value1, value2, "copyLotteryplanPublicstatus");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeIsNull() {
            addCriterion("copy_Lotteryplan_PlayType is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeIsNotNull() {
            addCriterion("copy_Lotteryplan_PlayType is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeEqualTo(Integer value) {
            addCriterion("copy_Lotteryplan_PlayType =", value, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeNotEqualTo(Integer value) {
            addCriterion("copy_Lotteryplan_PlayType <>", value, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeGreaterThan(Integer value) {
            addCriterion("copy_Lotteryplan_PlayType >", value, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy_Lotteryplan_PlayType >=", value, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeLessThan(Integer value) {
            addCriterion("copy_Lotteryplan_PlayType <", value, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeLessThanOrEqualTo(Integer value) {
            addCriterion("copy_Lotteryplan_PlayType <=", value, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeIn(List<Integer> values) {
            addCriterion("copy_Lotteryplan_PlayType in", values, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeNotIn(List<Integer> values) {
            addCriterion("copy_Lotteryplan_PlayType not in", values, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeBetween(Integer value1, Integer value2) {
            addCriterion("copy_Lotteryplan_PlayType between", value1, value2, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplanPlaytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("copy_Lotteryplan_PlayType not between", value1, value2, "copyLotteryplanPlaytype");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescIsNull() {
            addCriterion("copy_LotteryplanDesc is null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescIsNotNull() {
            addCriterion("copy_LotteryplanDesc is not null");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescEqualTo(String value) {
            addCriterion("copy_LotteryplanDesc =", value, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescNotEqualTo(String value) {
            addCriterion("copy_LotteryplanDesc <>", value, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescGreaterThan(String value) {
            addCriterion("copy_LotteryplanDesc >", value, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescGreaterThanOrEqualTo(String value) {
            addCriterion("copy_LotteryplanDesc >=", value, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescLessThan(String value) {
            addCriterion("copy_LotteryplanDesc <", value, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescLessThanOrEqualTo(String value) {
            addCriterion("copy_LotteryplanDesc <=", value, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescLike(String value) {
            addCriterion("copy_LotteryplanDesc like", value, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescNotLike(String value) {
            addCriterion("copy_LotteryplanDesc not like", value, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescIn(List<String> values) {
            addCriterion("copy_LotteryplanDesc in", values, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescNotIn(List<String> values) {
            addCriterion("copy_LotteryplanDesc not in", values, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescBetween(String value1, String value2) {
            addCriterion("copy_LotteryplanDesc between", value1, value2, "copyLotteryplandesc");
            return (Criteria) this;
        }

        public Criteria andCopyLotteryplandescNotBetween(String value1, String value2) {
            addCriterion("copy_LotteryplanDesc not between", value1, value2, "copyLotteryplandesc");
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