package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class FootballGameNameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FootballGameNameExample() {
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

        public Criteria andStandardNameIsNull() {
            addCriterion("STANDARD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStandardNameIsNotNull() {
            addCriterion("STANDARD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStandardNameEqualTo(String value) {
            addCriterion("STANDARD_NAME =", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameNotEqualTo(String value) {
            addCriterion("STANDARD_NAME <>", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameGreaterThan(String value) {
            addCriterion("STANDARD_NAME >", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameGreaterThanOrEqualTo(String value) {
            addCriterion("STANDARD_NAME >=", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameLessThan(String value) {
            addCriterion("STANDARD_NAME <", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameLessThanOrEqualTo(String value) {
            addCriterion("STANDARD_NAME <=", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameLike(String value) {
            addCriterion("STANDARD_NAME like", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameNotLike(String value) {
            addCriterion("STANDARD_NAME not like", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameIn(List<String> values) {
            addCriterion("STANDARD_NAME in", values, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameNotIn(List<String> values) {
            addCriterion("STANDARD_NAME not in", values, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameBetween(String value1, String value2) {
            addCriterion("STANDARD_NAME between", value1, value2, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameNotBetween(String value1, String value2) {
            addCriterion("STANDARD_NAME not between", value1, value2, "standardName");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("SHORT_NAME =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("SHORT_NAME <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("SHORT_NAME >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHORT_NAME >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("SHORT_NAME <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("SHORT_NAME <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("SHORT_NAME like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("SHORT_NAME not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("SHORT_NAME in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("SHORT_NAME not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("SHORT_NAME between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("SHORT_NAME not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andGameColorIsNull() {
            addCriterion("GAME_COLOR is null");
            return (Criteria) this;
        }

        public Criteria andGameColorIsNotNull() {
            addCriterion("GAME_COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andGameColorEqualTo(String value) {
            addCriterion("GAME_COLOR =", value, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorNotEqualTo(String value) {
            addCriterion("GAME_COLOR <>", value, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorGreaterThan(String value) {
            addCriterion("GAME_COLOR >", value, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorGreaterThanOrEqualTo(String value) {
            addCriterion("GAME_COLOR >=", value, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorLessThan(String value) {
            addCriterion("GAME_COLOR <", value, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorLessThanOrEqualTo(String value) {
            addCriterion("GAME_COLOR <=", value, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorLike(String value) {
            addCriterion("GAME_COLOR like", value, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorNotLike(String value) {
            addCriterion("GAME_COLOR not like", value, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorIn(List<String> values) {
            addCriterion("GAME_COLOR in", values, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorNotIn(List<String> values) {
            addCriterion("GAME_COLOR not in", values, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorBetween(String value1, String value2) {
            addCriterion("GAME_COLOR between", value1, value2, "gameColor");
            return (Criteria) this;
        }

        public Criteria andGameColorNotBetween(String value1, String value2) {
            addCriterion("GAME_COLOR not between", value1, value2, "gameColor");
            return (Criteria) this;
        }

        public Criteria andJcNameIsNull() {
            addCriterion("JC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andJcNameIsNotNull() {
            addCriterion("JC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andJcNameEqualTo(String value) {
            addCriterion("JC_NAME =", value, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameNotEqualTo(String value) {
            addCriterion("JC_NAME <>", value, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameGreaterThan(String value) {
            addCriterion("JC_NAME >", value, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameGreaterThanOrEqualTo(String value) {
            addCriterion("JC_NAME >=", value, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameLessThan(String value) {
            addCriterion("JC_NAME <", value, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameLessThanOrEqualTo(String value) {
            addCriterion("JC_NAME <=", value, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameLike(String value) {
            addCriterion("JC_NAME like", value, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameNotLike(String value) {
            addCriterion("JC_NAME not like", value, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameIn(List<String> values) {
            addCriterion("JC_NAME in", values, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameNotIn(List<String> values) {
            addCriterion("JC_NAME not in", values, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameBetween(String value1, String value2) {
            addCriterion("JC_NAME between", value1, value2, "jcName");
            return (Criteria) this;
        }

        public Criteria andJcNameNotBetween(String value1, String value2) {
            addCriterion("JC_NAME not between", value1, value2, "jcName");
            return (Criteria) this;
        }

        public Criteria andDcNameIsNull() {
            addCriterion("DC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDcNameIsNotNull() {
            addCriterion("DC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDcNameEqualTo(String value) {
            addCriterion("DC_NAME =", value, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameNotEqualTo(String value) {
            addCriterion("DC_NAME <>", value, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameGreaterThan(String value) {
            addCriterion("DC_NAME >", value, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameGreaterThanOrEqualTo(String value) {
            addCriterion("DC_NAME >=", value, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameLessThan(String value) {
            addCriterion("DC_NAME <", value, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameLessThanOrEqualTo(String value) {
            addCriterion("DC_NAME <=", value, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameLike(String value) {
            addCriterion("DC_NAME like", value, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameNotLike(String value) {
            addCriterion("DC_NAME not like", value, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameIn(List<String> values) {
            addCriterion("DC_NAME in", values, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameNotIn(List<String> values) {
            addCriterion("DC_NAME not in", values, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameBetween(String value1, String value2) {
            addCriterion("DC_NAME between", value1, value2, "dcName");
            return (Criteria) this;
        }

        public Criteria andDcNameNotBetween(String value1, String value2) {
            addCriterion("DC_NAME not between", value1, value2, "dcName");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("MARK is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("MARK is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("MARK =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("MARK <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("MARK >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("MARK >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("MARK <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("MARK <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("MARK like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("MARK not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("MARK in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("MARK not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("MARK between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("MARK not between", value1, value2, "mark");
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