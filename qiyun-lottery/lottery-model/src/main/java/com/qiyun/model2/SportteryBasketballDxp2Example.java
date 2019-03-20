package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryBasketballDxp2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryBasketballDxp2Example() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMatchIdIsNull() {
            addCriterion("match_id is null");
            return (Criteria) this;
        }

        public Criteria andMatchIdIsNotNull() {
            addCriterion("match_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatchIdEqualTo(Integer value) {
            addCriterion("match_id =", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotEqualTo(Integer value) {
            addCriterion("match_id <>", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThan(Integer value) {
            addCriterion("match_id >", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("match_id >=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThan(Integer value) {
            addCriterion("match_id <", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThanOrEqualTo(Integer value) {
            addCriterion("match_id <=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdIn(List<Integer> values) {
            addCriterion("match_id in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotIn(List<Integer> values) {
            addCriterion("match_id not in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdBetween(Integer value1, Integer value2) {
            addCriterion("match_id between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("match_id not between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andBigIsNull() {
            addCriterion("big is null");
            return (Criteria) this;
        }

        public Criteria andBigIsNotNull() {
            addCriterion("big is not null");
            return (Criteria) this;
        }

        public Criteria andBigEqualTo(Double value) {
            addCriterion("big =", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotEqualTo(Double value) {
            addCriterion("big <>", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigGreaterThan(Double value) {
            addCriterion("big >", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigGreaterThanOrEqualTo(Double value) {
            addCriterion("big >=", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLessThan(Double value) {
            addCriterion("big <", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLessThanOrEqualTo(Double value) {
            addCriterion("big <=", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigIn(List<Double> values) {
            addCriterion("big in", values, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotIn(List<Double> values) {
            addCriterion("big not in", values, "big");
            return (Criteria) this;
        }

        public Criteria andBigBetween(Double value1, Double value2) {
            addCriterion("big between", value1, value2, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotBetween(Double value1, Double value2) {
            addCriterion("big not between", value1, value2, "big");
            return (Criteria) this;
        }

        public Criteria andBigChangeIsNull() {
            addCriterion("big_change is null");
            return (Criteria) this;
        }

        public Criteria andBigChangeIsNotNull() {
            addCriterion("big_change is not null");
            return (Criteria) this;
        }

        public Criteria andBigChangeEqualTo(Integer value) {
            addCriterion("big_change =", value, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeNotEqualTo(Integer value) {
            addCriterion("big_change <>", value, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeGreaterThan(Integer value) {
            addCriterion("big_change >", value, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("big_change >=", value, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeLessThan(Integer value) {
            addCriterion("big_change <", value, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeLessThanOrEqualTo(Integer value) {
            addCriterion("big_change <=", value, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeIn(List<Integer> values) {
            addCriterion("big_change in", values, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeNotIn(List<Integer> values) {
            addCriterion("big_change not in", values, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeBetween(Integer value1, Integer value2) {
            addCriterion("big_change between", value1, value2, "bigChange");
            return (Criteria) this;
        }

        public Criteria andBigChangeNotBetween(Integer value1, Integer value2) {
            addCriterion("big_change not between", value1, value2, "bigChange");
            return (Criteria) this;
        }

        public Criteria andPankouIsNull() {
            addCriterion("pankou is null");
            return (Criteria) this;
        }

        public Criteria andPankouIsNotNull() {
            addCriterion("pankou is not null");
            return (Criteria) this;
        }

        public Criteria andPankouEqualTo(Double value) {
            addCriterion("pankou =", value, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouNotEqualTo(Double value) {
            addCriterion("pankou <>", value, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouGreaterThan(Double value) {
            addCriterion("pankou >", value, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouGreaterThanOrEqualTo(Double value) {
            addCriterion("pankou >=", value, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouLessThan(Double value) {
            addCriterion("pankou <", value, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouLessThanOrEqualTo(Double value) {
            addCriterion("pankou <=", value, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouIn(List<Double> values) {
            addCriterion("pankou in", values, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouNotIn(List<Double> values) {
            addCriterion("pankou not in", values, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouBetween(Double value1, Double value2) {
            addCriterion("pankou between", value1, value2, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouNotBetween(Double value1, Double value2) {
            addCriterion("pankou not between", value1, value2, "pankou");
            return (Criteria) this;
        }

        public Criteria andPankouChangeIsNull() {
            addCriterion("pankou_change is null");
            return (Criteria) this;
        }

        public Criteria andPankouChangeIsNotNull() {
            addCriterion("pankou_change is not null");
            return (Criteria) this;
        }

        public Criteria andPankouChangeEqualTo(Integer value) {
            addCriterion("pankou_change =", value, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeNotEqualTo(Integer value) {
            addCriterion("pankou_change <>", value, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeGreaterThan(Integer value) {
            addCriterion("pankou_change >", value, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pankou_change >=", value, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeLessThan(Integer value) {
            addCriterion("pankou_change <", value, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeLessThanOrEqualTo(Integer value) {
            addCriterion("pankou_change <=", value, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeIn(List<Integer> values) {
            addCriterion("pankou_change in", values, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeNotIn(List<Integer> values) {
            addCriterion("pankou_change not in", values, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeBetween(Integer value1, Integer value2) {
            addCriterion("pankou_change between", value1, value2, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andPankouChangeNotBetween(Integer value1, Integer value2) {
            addCriterion("pankou_change not between", value1, value2, "pankouChange");
            return (Criteria) this;
        }

        public Criteria andSmallIsNull() {
            addCriterion("small is null");
            return (Criteria) this;
        }

        public Criteria andSmallIsNotNull() {
            addCriterion("small is not null");
            return (Criteria) this;
        }

        public Criteria andSmallEqualTo(Double value) {
            addCriterion("small =", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotEqualTo(Double value) {
            addCriterion("small <>", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallGreaterThan(Double value) {
            addCriterion("small >", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallGreaterThanOrEqualTo(Double value) {
            addCriterion("small >=", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallLessThan(Double value) {
            addCriterion("small <", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallLessThanOrEqualTo(Double value) {
            addCriterion("small <=", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallIn(List<Double> values) {
            addCriterion("small in", values, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotIn(List<Double> values) {
            addCriterion("small not in", values, "small");
            return (Criteria) this;
        }

        public Criteria andSmallBetween(Double value1, Double value2) {
            addCriterion("small between", value1, value2, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotBetween(Double value1, Double value2) {
            addCriterion("small not between", value1, value2, "small");
            return (Criteria) this;
        }

        public Criteria andSmallChangeIsNull() {
            addCriterion("small_change is null");
            return (Criteria) this;
        }

        public Criteria andSmallChangeIsNotNull() {
            addCriterion("small_change is not null");
            return (Criteria) this;
        }

        public Criteria andSmallChangeEqualTo(Integer value) {
            addCriterion("small_change =", value, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeNotEqualTo(Integer value) {
            addCriterion("small_change <>", value, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeGreaterThan(Integer value) {
            addCriterion("small_change >", value, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("small_change >=", value, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeLessThan(Integer value) {
            addCriterion("small_change <", value, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeLessThanOrEqualTo(Integer value) {
            addCriterion("small_change <=", value, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeIn(List<Integer> values) {
            addCriterion("small_change in", values, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeNotIn(List<Integer> values) {
            addCriterion("small_change not in", values, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeBetween(Integer value1, Integer value2) {
            addCriterion("small_change between", value1, value2, "smallChange");
            return (Criteria) this;
        }

        public Criteria andSmallChangeNotBetween(Integer value1, Integer value2) {
            addCriterion("small_change not between", value1, value2, "smallChange");
            return (Criteria) this;
        }

        public Criteria andIsFirstIsNull() {
            addCriterion("is_first is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstIsNotNull() {
            addCriterion("is_first is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstEqualTo(Integer value) {
            addCriterion("is_first =", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotEqualTo(Integer value) {
            addCriterion("is_first <>", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstGreaterThan(Integer value) {
            addCriterion("is_first >", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_first >=", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstLessThan(Integer value) {
            addCriterion("is_first <", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstLessThanOrEqualTo(Integer value) {
            addCriterion("is_first <=", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstIn(List<Integer> values) {
            addCriterion("is_first in", values, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotIn(List<Integer> values) {
            addCriterion("is_first not in", values, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstBetween(Integer value1, Integer value2) {
            addCriterion("is_first between", value1, value2, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotBetween(Integer value1, Integer value2) {
            addCriterion("is_first not between", value1, value2, "isFirst");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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