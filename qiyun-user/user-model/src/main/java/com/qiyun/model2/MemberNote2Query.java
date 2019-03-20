package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class MemberNote2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberNote2Query() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("member_id like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("member_id not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemeberTelIsNull() {
            addCriterion("memeber_tel is null");
            return (Criteria) this;
        }

        public Criteria andMemeberTelIsNotNull() {
            addCriterion("memeber_tel is not null");
            return (Criteria) this;
        }

        public Criteria andMemeberTelEqualTo(String value) {
            addCriterion("memeber_tel =", value, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelNotEqualTo(String value) {
            addCriterion("memeber_tel <>", value, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelGreaterThan(String value) {
            addCriterion("memeber_tel >", value, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelGreaterThanOrEqualTo(String value) {
            addCriterion("memeber_tel >=", value, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelLessThan(String value) {
            addCriterion("memeber_tel <", value, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelLessThanOrEqualTo(String value) {
            addCriterion("memeber_tel <=", value, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelLike(String value) {
            addCriterion("memeber_tel like", value, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelNotLike(String value) {
            addCriterion("memeber_tel not like", value, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelIn(List<String> values) {
            addCriterion("memeber_tel in", values, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelNotIn(List<String> values) {
            addCriterion("memeber_tel not in", values, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelBetween(String value1, String value2) {
            addCriterion("memeber_tel between", value1, value2, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemeberTelNotBetween(String value1, String value2) {
            addCriterion("memeber_tel not between", value1, value2, "memeberTel");
            return (Criteria) this;
        }

        public Criteria andMemberZxbIsNull() {
            addCriterion("member_zxb is null");
            return (Criteria) this;
        }

        public Criteria andMemberZxbIsNotNull() {
            addCriterion("member_zxb is not null");
            return (Criteria) this;
        }

        public Criteria andMemberZxbEqualTo(String value) {
            addCriterion("member_zxb =", value, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbNotEqualTo(String value) {
            addCriterion("member_zxb <>", value, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbGreaterThan(String value) {
            addCriterion("member_zxb >", value, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbGreaterThanOrEqualTo(String value) {
            addCriterion("member_zxb >=", value, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbLessThan(String value) {
            addCriterion("member_zxb <", value, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbLessThanOrEqualTo(String value) {
            addCriterion("member_zxb <=", value, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbLike(String value) {
            addCriterion("member_zxb like", value, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbNotLike(String value) {
            addCriterion("member_zxb not like", value, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbIn(List<String> values) {
            addCriterion("member_zxb in", values, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbNotIn(List<String> values) {
            addCriterion("member_zxb not in", values, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbBetween(String value1, String value2) {
            addCriterion("member_zxb between", value1, value2, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberZxbNotBetween(String value1, String value2) {
            addCriterion("member_zxb not between", value1, value2, "memberZxb");
            return (Criteria) this;
        }

        public Criteria andMemberWxIsNull() {
            addCriterion("member_wx is null");
            return (Criteria) this;
        }

        public Criteria andMemberWxIsNotNull() {
            addCriterion("member_wx is not null");
            return (Criteria) this;
        }

        public Criteria andMemberWxEqualTo(String value) {
            addCriterion("member_wx =", value, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxNotEqualTo(String value) {
            addCriterion("member_wx <>", value, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxGreaterThan(String value) {
            addCriterion("member_wx >", value, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxGreaterThanOrEqualTo(String value) {
            addCriterion("member_wx >=", value, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxLessThan(String value) {
            addCriterion("member_wx <", value, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxLessThanOrEqualTo(String value) {
            addCriterion("member_wx <=", value, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxLike(String value) {
            addCriterion("member_wx like", value, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxNotLike(String value) {
            addCriterion("member_wx not like", value, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxIn(List<String> values) {
            addCriterion("member_wx in", values, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxNotIn(List<String> values) {
            addCriterion("member_wx not in", values, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxBetween(String value1, String value2) {
            addCriterion("member_wx between", value1, value2, "memberWx");
            return (Criteria) this;
        }

        public Criteria andMemberWxNotBetween(String value1, String value2) {
            addCriterion("member_wx not between", value1, value2, "memberWx");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andIsKeyIsNull() {
            addCriterion("is_key is null");
            return (Criteria) this;
        }

        public Criteria andIsKeyIsNotNull() {
            addCriterion("is_key is not null");
            return (Criteria) this;
        }

        public Criteria andIsKeyEqualTo(Integer value) {
            addCriterion("is_key =", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotEqualTo(Integer value) {
            addCriterion("is_key <>", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyGreaterThan(Integer value) {
            addCriterion("is_key >", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_key >=", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLessThan(Integer value) {
            addCriterion("is_key <", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLessThanOrEqualTo(Integer value) {
            addCriterion("is_key <=", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyIn(List<Integer> values) {
            addCriterion("is_key in", values, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotIn(List<Integer> values) {
            addCriterion("is_key not in", values, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyBetween(Integer value1, Integer value2) {
            addCriterion("is_key between", value1, value2, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_key not between", value1, value2, "isKey");
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