package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class BasketballTeam2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasketballTeam2Example() {
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

        public Criteria andFullTeamNameIsNull() {
            addCriterion("FULL_TEAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameIsNotNull() {
            addCriterion("FULL_TEAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameEqualTo(String value) {
            addCriterion("FULL_TEAM_NAME =", value, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameNotEqualTo(String value) {
            addCriterion("FULL_TEAM_NAME <>", value, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameGreaterThan(String value) {
            addCriterion("FULL_TEAM_NAME >", value, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("FULL_TEAM_NAME >=", value, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameLessThan(String value) {
            addCriterion("FULL_TEAM_NAME <", value, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameLessThanOrEqualTo(String value) {
            addCriterion("FULL_TEAM_NAME <=", value, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameLike(String value) {
            addCriterion("FULL_TEAM_NAME like", value, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameNotLike(String value) {
            addCriterion("FULL_TEAM_NAME not like", value, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameIn(List<String> values) {
            addCriterion("FULL_TEAM_NAME in", values, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameNotIn(List<String> values) {
            addCriterion("FULL_TEAM_NAME not in", values, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameBetween(String value1, String value2) {
            addCriterion("FULL_TEAM_NAME between", value1, value2, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andFullTeamNameNotBetween(String value1, String value2) {
            addCriterion("FULL_TEAM_NAME not between", value1, value2, "fullTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameIsNull() {
            addCriterion("SHORT_TEAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameIsNotNull() {
            addCriterion("SHORT_TEAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameEqualTo(String value) {
            addCriterion("SHORT_TEAM_NAME =", value, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameNotEqualTo(String value) {
            addCriterion("SHORT_TEAM_NAME <>", value, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameGreaterThan(String value) {
            addCriterion("SHORT_TEAM_NAME >", value, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHORT_TEAM_NAME >=", value, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameLessThan(String value) {
            addCriterion("SHORT_TEAM_NAME <", value, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameLessThanOrEqualTo(String value) {
            addCriterion("SHORT_TEAM_NAME <=", value, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameLike(String value) {
            addCriterion("SHORT_TEAM_NAME like", value, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameNotLike(String value) {
            addCriterion("SHORT_TEAM_NAME not like", value, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameIn(List<String> values) {
            addCriterion("SHORT_TEAM_NAME in", values, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameNotIn(List<String> values) {
            addCriterion("SHORT_TEAM_NAME not in", values, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameBetween(String value1, String value2) {
            addCriterion("SHORT_TEAM_NAME between", value1, value2, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andShortTeamNameNotBetween(String value1, String value2) {
            addCriterion("SHORT_TEAM_NAME not between", value1, value2, "shortTeamName");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
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