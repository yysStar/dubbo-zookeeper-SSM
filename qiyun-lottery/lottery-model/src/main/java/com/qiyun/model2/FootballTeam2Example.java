package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class FootballTeam2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FootballTeam2Example() {
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

        public Criteria andDcIsNull() {
            addCriterion("dc is null");
            return (Criteria) this;
        }

        public Criteria andDcIsNotNull() {
            addCriterion("dc is not null");
            return (Criteria) this;
        }

        public Criteria andDcEqualTo(String value) {
            addCriterion("dc =", value, "dc");
            return (Criteria) this;
        }

        public Criteria andDcNotEqualTo(String value) {
            addCriterion("dc <>", value, "dc");
            return (Criteria) this;
        }

        public Criteria andDcGreaterThan(String value) {
            addCriterion("dc >", value, "dc");
            return (Criteria) this;
        }

        public Criteria andDcGreaterThanOrEqualTo(String value) {
            addCriterion("dc >=", value, "dc");
            return (Criteria) this;
        }

        public Criteria andDcLessThan(String value) {
            addCriterion("dc <", value, "dc");
            return (Criteria) this;
        }

        public Criteria andDcLessThanOrEqualTo(String value) {
            addCriterion("dc <=", value, "dc");
            return (Criteria) this;
        }

        public Criteria andDcLike(String value) {
            addCriterion("dc like", value, "dc");
            return (Criteria) this;
        }

        public Criteria andDcNotLike(String value) {
            addCriterion("dc not like", value, "dc");
            return (Criteria) this;
        }

        public Criteria andDcIn(List<String> values) {
            addCriterion("dc in", values, "dc");
            return (Criteria) this;
        }

        public Criteria andDcNotIn(List<String> values) {
            addCriterion("dc not in", values, "dc");
            return (Criteria) this;
        }

        public Criteria andDcBetween(String value1, String value2) {
            addCriterion("dc between", value1, value2, "dc");
            return (Criteria) this;
        }

        public Criteria andDcNotBetween(String value1, String value2) {
            addCriterion("dc not between", value1, value2, "dc");
            return (Criteria) this;
        }

        public Criteria andJcIsNull() {
            addCriterion("jc is null");
            return (Criteria) this;
        }

        public Criteria andJcIsNotNull() {
            addCriterion("jc is not null");
            return (Criteria) this;
        }

        public Criteria andJcEqualTo(String value) {
            addCriterion("jc =", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotEqualTo(String value) {
            addCriterion("jc <>", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcGreaterThan(String value) {
            addCriterion("jc >", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcGreaterThanOrEqualTo(String value) {
            addCriterion("jc >=", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLessThan(String value) {
            addCriterion("jc <", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLessThanOrEqualTo(String value) {
            addCriterion("jc <=", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLike(String value) {
            addCriterion("jc like", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotLike(String value) {
            addCriterion("jc not like", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcIn(List<String> values) {
            addCriterion("jc in", values, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotIn(List<String> values) {
            addCriterion("jc not in", values, "jc");
            return (Criteria) this;
        }

        public Criteria andJcBetween(String value1, String value2) {
            addCriterion("jc between", value1, value2, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotBetween(String value1, String value2) {
            addCriterion("jc not between", value1, value2, "jc");
            return (Criteria) this;
        }

        public Criteria andFbIsNull() {
            addCriterion("fb is null");
            return (Criteria) this;
        }

        public Criteria andFbIsNotNull() {
            addCriterion("fb is not null");
            return (Criteria) this;
        }

        public Criteria andFbEqualTo(String value) {
            addCriterion("fb =", value, "fb");
            return (Criteria) this;
        }

        public Criteria andFbNotEqualTo(String value) {
            addCriterion("fb <>", value, "fb");
            return (Criteria) this;
        }

        public Criteria andFbGreaterThan(String value) {
            addCriterion("fb >", value, "fb");
            return (Criteria) this;
        }

        public Criteria andFbGreaterThanOrEqualTo(String value) {
            addCriterion("fb >=", value, "fb");
            return (Criteria) this;
        }

        public Criteria andFbLessThan(String value) {
            addCriterion("fb <", value, "fb");
            return (Criteria) this;
        }

        public Criteria andFbLessThanOrEqualTo(String value) {
            addCriterion("fb <=", value, "fb");
            return (Criteria) this;
        }

        public Criteria andFbLike(String value) {
            addCriterion("fb like", value, "fb");
            return (Criteria) this;
        }

        public Criteria andFbNotLike(String value) {
            addCriterion("fb not like", value, "fb");
            return (Criteria) this;
        }

        public Criteria andFbIn(List<String> values) {
            addCriterion("fb in", values, "fb");
            return (Criteria) this;
        }

        public Criteria andFbNotIn(List<String> values) {
            addCriterion("fb not in", values, "fb");
            return (Criteria) this;
        }

        public Criteria andFbBetween(String value1, String value2) {
            addCriterion("fb between", value1, value2, "fb");
            return (Criteria) this;
        }

        public Criteria andFbNotBetween(String value1, String value2) {
            addCriterion("fb not between", value1, value2, "fb");
            return (Criteria) this;
        }

        public Criteria andDyjIsNull() {
            addCriterion("dyj is null");
            return (Criteria) this;
        }

        public Criteria andDyjIsNotNull() {
            addCriterion("dyj is not null");
            return (Criteria) this;
        }

        public Criteria andDyjEqualTo(String value) {
            addCriterion("dyj =", value, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjNotEqualTo(String value) {
            addCriterion("dyj <>", value, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjGreaterThan(String value) {
            addCriterion("dyj >", value, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjGreaterThanOrEqualTo(String value) {
            addCriterion("dyj >=", value, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjLessThan(String value) {
            addCriterion("dyj <", value, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjLessThanOrEqualTo(String value) {
            addCriterion("dyj <=", value, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjLike(String value) {
            addCriterion("dyj like", value, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjNotLike(String value) {
            addCriterion("dyj not like", value, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjIn(List<String> values) {
            addCriterion("dyj in", values, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjNotIn(List<String> values) {
            addCriterion("dyj not in", values, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjBetween(String value1, String value2) {
            addCriterion("dyj between", value1, value2, "dyj");
            return (Criteria) this;
        }

        public Criteria andDyjNotBetween(String value1, String value2) {
            addCriterion("dyj not between", value1, value2, "dyj");
            return (Criteria) this;
        }

        public Criteria andPmIsNull() {
            addCriterion("PM is null");
            return (Criteria) this;
        }

        public Criteria andPmIsNotNull() {
            addCriterion("PM is not null");
            return (Criteria) this;
        }

        public Criteria andPmEqualTo(Integer value) {
            addCriterion("PM =", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmNotEqualTo(Integer value) {
            addCriterion("PM <>", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmGreaterThan(Integer value) {
            addCriterion("PM >", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmGreaterThanOrEqualTo(Integer value) {
            addCriterion("PM >=", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmLessThan(Integer value) {
            addCriterion("PM <", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmLessThanOrEqualTo(Integer value) {
            addCriterion("PM <=", value, "pm");
            return (Criteria) this;
        }

        public Criteria andPmIn(List<Integer> values) {
            addCriterion("PM in", values, "pm");
            return (Criteria) this;
        }

        public Criteria andPmNotIn(List<Integer> values) {
            addCriterion("PM not in", values, "pm");
            return (Criteria) this;
        }

        public Criteria andPmBetween(Integer value1, Integer value2) {
            addCriterion("PM between", value1, value2, "pm");
            return (Criteria) this;
        }

        public Criteria andPmNotBetween(Integer value1, Integer value2) {
            addCriterion("PM not between", value1, value2, "pm");
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