package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberRewardMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberRewardMappingExample() {
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

        public Criteria andRewarderIsNull() {
            addCriterion("rewarder is null");
            return (Criteria) this;
        }

        public Criteria andRewarderIsNotNull() {
            addCriterion("rewarder is not null");
            return (Criteria) this;
        }

        public Criteria andRewarderEqualTo(String value) {
            addCriterion("rewarder =", value, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderNotEqualTo(String value) {
            addCriterion("rewarder <>", value, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderGreaterThan(String value) {
            addCriterion("rewarder >", value, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderGreaterThanOrEqualTo(String value) {
            addCriterion("rewarder >=", value, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderLessThan(String value) {
            addCriterion("rewarder <", value, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderLessThanOrEqualTo(String value) {
            addCriterion("rewarder <=", value, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderLike(String value) {
            addCriterion("rewarder like", value, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderNotLike(String value) {
            addCriterion("rewarder not like", value, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderIn(List<String> values) {
            addCriterion("rewarder in", values, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderNotIn(List<String> values) {
            addCriterion("rewarder not in", values, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderBetween(String value1, String value2) {
            addCriterion("rewarder between", value1, value2, "rewarder");
            return (Criteria) this;
        }

        public Criteria andRewarderNotBetween(String value1, String value2) {
            addCriterion("rewarder not between", value1, value2, "rewarder");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andBeRewarderIsNull() {
            addCriterion("be_rewarder is null");
            return (Criteria) this;
        }

        public Criteria andBeRewarderIsNotNull() {
            addCriterion("be_rewarder is not null");
            return (Criteria) this;
        }

        public Criteria andBeRewarderEqualTo(String value) {
            addCriterion("be_rewarder =", value, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderNotEqualTo(String value) {
            addCriterion("be_rewarder <>", value, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderGreaterThan(String value) {
            addCriterion("be_rewarder >", value, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderGreaterThanOrEqualTo(String value) {
            addCriterion("be_rewarder >=", value, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderLessThan(String value) {
            addCriterion("be_rewarder <", value, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderLessThanOrEqualTo(String value) {
            addCriterion("be_rewarder <=", value, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderLike(String value) {
            addCriterion("be_rewarder like", value, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderNotLike(String value) {
            addCriterion("be_rewarder not like", value, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderIn(List<String> values) {
            addCriterion("be_rewarder in", values, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderNotIn(List<String> values) {
            addCriterion("be_rewarder not in", values, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderBetween(String value1, String value2) {
            addCriterion("be_rewarder between", value1, value2, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andBeRewarderNotBetween(String value1, String value2) {
            addCriterion("be_rewarder not between", value1, value2, "beRewarder");
            return (Criteria) this;
        }

        public Criteria andCloudNumIsNull() {
            addCriterion("cloud_num is null");
            return (Criteria) this;
        }

        public Criteria andCloudNumIsNotNull() {
            addCriterion("cloud_num is not null");
            return (Criteria) this;
        }

        public Criteria andCloudNumEqualTo(Integer value) {
            addCriterion("cloud_num =", value, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumNotEqualTo(Integer value) {
            addCriterion("cloud_num <>", value, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumGreaterThan(Integer value) {
            addCriterion("cloud_num >", value, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cloud_num >=", value, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumLessThan(Integer value) {
            addCriterion("cloud_num <", value, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumLessThanOrEqualTo(Integer value) {
            addCriterion("cloud_num <=", value, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumIn(List<Integer> values) {
            addCriterion("cloud_num in", values, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumNotIn(List<Integer> values) {
            addCriterion("cloud_num not in", values, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumBetween(Integer value1, Integer value2) {
            addCriterion("cloud_num between", value1, value2, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andCloudNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cloud_num not between", value1, value2, "cloudNum");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeIsNull() {
            addCriterion("reward_datetime is null");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeIsNotNull() {
            addCriterion("reward_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeEqualTo(Date value) {
            addCriterion("reward_datetime =", value, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeNotEqualTo(Date value) {
            addCriterion("reward_datetime <>", value, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeGreaterThan(Date value) {
            addCriterion("reward_datetime >", value, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reward_datetime >=", value, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeLessThan(Date value) {
            addCriterion("reward_datetime <", value, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("reward_datetime <=", value, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeIn(List<Date> values) {
            addCriterion("reward_datetime in", values, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeNotIn(List<Date> values) {
            addCriterion("reward_datetime not in", values, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeBetween(Date value1, Date value2) {
            addCriterion("reward_datetime between", value1, value2, "rewardDatetime");
            return (Criteria) this;
        }

        public Criteria andRewardDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("reward_datetime not between", value1, value2, "rewardDatetime");
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