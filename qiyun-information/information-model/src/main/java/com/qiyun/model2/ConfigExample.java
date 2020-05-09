package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class ConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConfigExample() {
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

        public Criteria andMaxAddPrizeIsNull() {
            addCriterion("max_add_prize is null");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeIsNotNull() {
            addCriterion("max_add_prize is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeEqualTo(Double value) {
            addCriterion("max_add_prize =", value, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeNotEqualTo(Double value) {
            addCriterion("max_add_prize <>", value, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeGreaterThan(Double value) {
            addCriterion("max_add_prize >", value, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeGreaterThanOrEqualTo(Double value) {
            addCriterion("max_add_prize >=", value, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeLessThan(Double value) {
            addCriterion("max_add_prize <", value, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeLessThanOrEqualTo(Double value) {
            addCriterion("max_add_prize <=", value, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeIn(List<Double> values) {
            addCriterion("max_add_prize in", values, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeNotIn(List<Double> values) {
            addCriterion("max_add_prize not in", values, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeBetween(Double value1, Double value2) {
            addCriterion("max_add_prize between", value1, value2, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMaxAddPrizeNotBetween(Double value1, Double value2) {
            addCriterion("max_add_prize not between", value1, value2, "maxAddPrize");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeIsNull() {
            addCriterion("match_deal_time is null");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeIsNotNull() {
            addCriterion("match_deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeEqualTo(Integer value) {
            addCriterion("match_deal_time =", value, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeNotEqualTo(Integer value) {
            addCriterion("match_deal_time <>", value, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeGreaterThan(Integer value) {
            addCriterion("match_deal_time >", value, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("match_deal_time >=", value, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeLessThan(Integer value) {
            addCriterion("match_deal_time <", value, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeLessThanOrEqualTo(Integer value) {
            addCriterion("match_deal_time <=", value, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeIn(List<Integer> values) {
            addCriterion("match_deal_time in", values, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeNotIn(List<Integer> values) {
            addCriterion("match_deal_time not in", values, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeBetween(Integer value1, Integer value2) {
            addCriterion("match_deal_time between", value1, value2, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andMatchDealTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("match_deal_time not between", value1, value2, "matchDealTime");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5IsNull() {
            addCriterion("auto_copy_for_less5 is null");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5IsNotNull() {
            addCriterion("auto_copy_for_less5 is not null");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5EqualTo(Integer value) {
            addCriterion("auto_copy_for_less5 =", value, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5NotEqualTo(Integer value) {
            addCriterion("auto_copy_for_less5 <>", value, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5GreaterThan(Integer value) {
            addCriterion("auto_copy_for_less5 >", value, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5GreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_copy_for_less5 >=", value, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5LessThan(Integer value) {
            addCriterion("auto_copy_for_less5 <", value, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5LessThanOrEqualTo(Integer value) {
            addCriterion("auto_copy_for_less5 <=", value, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5In(List<Integer> values) {
            addCriterion("auto_copy_for_less5 in", values, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5NotIn(List<Integer> values) {
            addCriterion("auto_copy_for_less5 not in", values, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5Between(Integer value1, Integer value2) {
            addCriterion("auto_copy_for_less5 between", value1, value2, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForLess5NotBetween(Integer value1, Integer value2) {
            addCriterion("auto_copy_for_less5 not between", value1, value2, "autoCopyForLess5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5IsNull() {
            addCriterion("auto_copy_for_more5 is null");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5IsNotNull() {
            addCriterion("auto_copy_for_more5 is not null");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5EqualTo(Integer value) {
            addCriterion("auto_copy_for_more5 =", value, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5NotEqualTo(Integer value) {
            addCriterion("auto_copy_for_more5 <>", value, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5GreaterThan(Integer value) {
            addCriterion("auto_copy_for_more5 >", value, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5GreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_copy_for_more5 >=", value, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5LessThan(Integer value) {
            addCriterion("auto_copy_for_more5 <", value, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5LessThanOrEqualTo(Integer value) {
            addCriterion("auto_copy_for_more5 <=", value, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5In(List<Integer> values) {
            addCriterion("auto_copy_for_more5 in", values, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5NotIn(List<Integer> values) {
            addCriterion("auto_copy_for_more5 not in", values, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5Between(Integer value1, Integer value2) {
            addCriterion("auto_copy_for_more5 between", value1, value2, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andAutoCopyForMore5NotBetween(Integer value1, Integer value2) {
            addCriterion("auto_copy_for_more5 not between", value1, value2, "autoCopyForMore5");
            return (Criteria) this;
        }

        public Criteria andIsDgIsNull() {
            addCriterion("is_dg is null");
            return (Criteria) this;
        }

        public Criteria andIsDgIsNotNull() {
            addCriterion("is_dg is not null");
            return (Criteria) this;
        }

        public Criteria andIsDgEqualTo(Integer value) {
            addCriterion("is_dg =", value, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgNotEqualTo(Integer value) {
            addCriterion("is_dg <>", value, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgGreaterThan(Integer value) {
            addCriterion("is_dg >", value, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_dg >=", value, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgLessThan(Integer value) {
            addCriterion("is_dg <", value, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgLessThanOrEqualTo(Integer value) {
            addCriterion("is_dg <=", value, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgIn(List<Integer> values) {
            addCriterion("is_dg in", values, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgNotIn(List<Integer> values) {
            addCriterion("is_dg not in", values, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgBetween(Integer value1, Integer value2) {
            addCriterion("is_dg between", value1, value2, "isDg");
            return (Criteria) this;
        }

        public Criteria andIsDgNotBetween(Integer value1, Integer value2) {
            addCriterion("is_dg not between", value1, value2, "isDg");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountIsNull() {
            addCriterion("chai_piao_count is null");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountIsNotNull() {
            addCriterion("chai_piao_count is not null");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountEqualTo(Integer value) {
            addCriterion("chai_piao_count =", value, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountNotEqualTo(Integer value) {
            addCriterion("chai_piao_count <>", value, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountGreaterThan(Integer value) {
            addCriterion("chai_piao_count >", value, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("chai_piao_count >=", value, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountLessThan(Integer value) {
            addCriterion("chai_piao_count <", value, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountLessThanOrEqualTo(Integer value) {
            addCriterion("chai_piao_count <=", value, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountIn(List<Integer> values) {
            addCriterion("chai_piao_count in", values, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountNotIn(List<Integer> values) {
            addCriterion("chai_piao_count not in", values, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountBetween(Integer value1, Integer value2) {
            addCriterion("chai_piao_count between", value1, value2, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andChaiPiaoCountNotBetween(Integer value1, Integer value2) {
            addCriterion("chai_piao_count not between", value1, value2, "chaiPiaoCount");
            return (Criteria) this;
        }

        public Criteria andSpSourceIsNull() {
            addCriterion("sp_source is null");
            return (Criteria) this;
        }

        public Criteria andSpSourceIsNotNull() {
            addCriterion("sp_source is not null");
            return (Criteria) this;
        }

        public Criteria andSpSourceEqualTo(Integer value) {
            addCriterion("sp_source =", value, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceNotEqualTo(Integer value) {
            addCriterion("sp_source <>", value, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceGreaterThan(Integer value) {
            addCriterion("sp_source >", value, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_source >=", value, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceLessThan(Integer value) {
            addCriterion("sp_source <", value, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceLessThanOrEqualTo(Integer value) {
            addCriterion("sp_source <=", value, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceIn(List<Integer> values) {
            addCriterion("sp_source in", values, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceNotIn(List<Integer> values) {
            addCriterion("sp_source not in", values, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceBetween(Integer value1, Integer value2) {
            addCriterion("sp_source between", value1, value2, "spSource");
            return (Criteria) this;
        }

        public Criteria andSpSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_source not between", value1, value2, "spSource");
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