package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryFootballJqsaward2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryFootballJqsaward2Example() {
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

        public Criteria andMatchtimeIsNull() {
            addCriterion("matchTime is null");
            return (Criteria) this;
        }

        public Criteria andMatchtimeIsNotNull() {
            addCriterion("matchTime is not null");
            return (Criteria) this;
        }

        public Criteria andMatchtimeEqualTo(Date value) {
            addCriterion("matchTime =", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotEqualTo(Date value) {
            addCriterion("matchTime <>", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeGreaterThan(Date value) {
            addCriterion("matchTime >", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("matchTime >=", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeLessThan(Date value) {
            addCriterion("matchTime <", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeLessThanOrEqualTo(Date value) {
            addCriterion("matchTime <=", value, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeIn(List<Date> values) {
            addCriterion("matchTime in", values, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotIn(List<Date> values) {
            addCriterion("matchTime not in", values, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeBetween(Date value1, Date value2) {
            addCriterion("matchTime between", value1, value2, "matchtime");
            return (Criteria) this;
        }

        public Criteria andMatchtimeNotBetween(Date value1, Date value2) {
            addCriterion("matchTime not between", value1, value2, "matchtime");
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

        public Criteria andS0AwardIsNull() {
            addCriterion("s0_award is null");
            return (Criteria) this;
        }

        public Criteria andS0AwardIsNotNull() {
            addCriterion("s0_award is not null");
            return (Criteria) this;
        }

        public Criteria andS0AwardEqualTo(Double value) {
            addCriterion("s0_award =", value, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardNotEqualTo(Double value) {
            addCriterion("s0_award <>", value, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardGreaterThan(Double value) {
            addCriterion("s0_award >", value, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s0_award >=", value, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardLessThan(Double value) {
            addCriterion("s0_award <", value, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardLessThanOrEqualTo(Double value) {
            addCriterion("s0_award <=", value, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardIn(List<Double> values) {
            addCriterion("s0_award in", values, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardNotIn(List<Double> values) {
            addCriterion("s0_award not in", values, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardBetween(Double value1, Double value2) {
            addCriterion("s0_award between", value1, value2, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS0AwardNotBetween(Double value1, Double value2) {
            addCriterion("s0_award not between", value1, value2, "s0Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardIsNull() {
            addCriterion("s1_award is null");
            return (Criteria) this;
        }

        public Criteria andS1AwardIsNotNull() {
            addCriterion("s1_award is not null");
            return (Criteria) this;
        }

        public Criteria andS1AwardEqualTo(Double value) {
            addCriterion("s1_award =", value, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardNotEqualTo(Double value) {
            addCriterion("s1_award <>", value, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardGreaterThan(Double value) {
            addCriterion("s1_award >", value, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s1_award >=", value, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardLessThan(Double value) {
            addCriterion("s1_award <", value, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardLessThanOrEqualTo(Double value) {
            addCriterion("s1_award <=", value, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardIn(List<Double> values) {
            addCriterion("s1_award in", values, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardNotIn(List<Double> values) {
            addCriterion("s1_award not in", values, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardBetween(Double value1, Double value2) {
            addCriterion("s1_award between", value1, value2, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS1AwardNotBetween(Double value1, Double value2) {
            addCriterion("s1_award not between", value1, value2, "s1Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardIsNull() {
            addCriterion("s2_award is null");
            return (Criteria) this;
        }

        public Criteria andS2AwardIsNotNull() {
            addCriterion("s2_award is not null");
            return (Criteria) this;
        }

        public Criteria andS2AwardEqualTo(Double value) {
            addCriterion("s2_award =", value, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardNotEqualTo(Double value) {
            addCriterion("s2_award <>", value, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardGreaterThan(Double value) {
            addCriterion("s2_award >", value, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s2_award >=", value, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardLessThan(Double value) {
            addCriterion("s2_award <", value, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardLessThanOrEqualTo(Double value) {
            addCriterion("s2_award <=", value, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardIn(List<Double> values) {
            addCriterion("s2_award in", values, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardNotIn(List<Double> values) {
            addCriterion("s2_award not in", values, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardBetween(Double value1, Double value2) {
            addCriterion("s2_award between", value1, value2, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS2AwardNotBetween(Double value1, Double value2) {
            addCriterion("s2_award not between", value1, value2, "s2Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardIsNull() {
            addCriterion("s3_award is null");
            return (Criteria) this;
        }

        public Criteria andS3AwardIsNotNull() {
            addCriterion("s3_award is not null");
            return (Criteria) this;
        }

        public Criteria andS3AwardEqualTo(Double value) {
            addCriterion("s3_award =", value, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardNotEqualTo(Double value) {
            addCriterion("s3_award <>", value, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardGreaterThan(Double value) {
            addCriterion("s3_award >", value, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s3_award >=", value, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardLessThan(Double value) {
            addCriterion("s3_award <", value, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardLessThanOrEqualTo(Double value) {
            addCriterion("s3_award <=", value, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardIn(List<Double> values) {
            addCriterion("s3_award in", values, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardNotIn(List<Double> values) {
            addCriterion("s3_award not in", values, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardBetween(Double value1, Double value2) {
            addCriterion("s3_award between", value1, value2, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS3AwardNotBetween(Double value1, Double value2) {
            addCriterion("s3_award not between", value1, value2, "s3Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardIsNull() {
            addCriterion("s4_award is null");
            return (Criteria) this;
        }

        public Criteria andS4AwardIsNotNull() {
            addCriterion("s4_award is not null");
            return (Criteria) this;
        }

        public Criteria andS4AwardEqualTo(Double value) {
            addCriterion("s4_award =", value, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardNotEqualTo(Double value) {
            addCriterion("s4_award <>", value, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardGreaterThan(Double value) {
            addCriterion("s4_award >", value, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s4_award >=", value, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardLessThan(Double value) {
            addCriterion("s4_award <", value, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardLessThanOrEqualTo(Double value) {
            addCriterion("s4_award <=", value, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardIn(List<Double> values) {
            addCriterion("s4_award in", values, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardNotIn(List<Double> values) {
            addCriterion("s4_award not in", values, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardBetween(Double value1, Double value2) {
            addCriterion("s4_award between", value1, value2, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS4AwardNotBetween(Double value1, Double value2) {
            addCriterion("s4_award not between", value1, value2, "s4Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardIsNull() {
            addCriterion("s5_award is null");
            return (Criteria) this;
        }

        public Criteria andS5AwardIsNotNull() {
            addCriterion("s5_award is not null");
            return (Criteria) this;
        }

        public Criteria andS5AwardEqualTo(Double value) {
            addCriterion("s5_award =", value, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardNotEqualTo(Double value) {
            addCriterion("s5_award <>", value, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardGreaterThan(Double value) {
            addCriterion("s5_award >", value, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s5_award >=", value, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardLessThan(Double value) {
            addCriterion("s5_award <", value, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardLessThanOrEqualTo(Double value) {
            addCriterion("s5_award <=", value, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardIn(List<Double> values) {
            addCriterion("s5_award in", values, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardNotIn(List<Double> values) {
            addCriterion("s5_award not in", values, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardBetween(Double value1, Double value2) {
            addCriterion("s5_award between", value1, value2, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS5AwardNotBetween(Double value1, Double value2) {
            addCriterion("s5_award not between", value1, value2, "s5Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardIsNull() {
            addCriterion("s6_award is null");
            return (Criteria) this;
        }

        public Criteria andS6AwardIsNotNull() {
            addCriterion("s6_award is not null");
            return (Criteria) this;
        }

        public Criteria andS6AwardEqualTo(Double value) {
            addCriterion("s6_award =", value, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardNotEqualTo(Double value) {
            addCriterion("s6_award <>", value, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardGreaterThan(Double value) {
            addCriterion("s6_award >", value, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s6_award >=", value, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardLessThan(Double value) {
            addCriterion("s6_award <", value, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardLessThanOrEqualTo(Double value) {
            addCriterion("s6_award <=", value, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardIn(List<Double> values) {
            addCriterion("s6_award in", values, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardNotIn(List<Double> values) {
            addCriterion("s6_award not in", values, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardBetween(Double value1, Double value2) {
            addCriterion("s6_award between", value1, value2, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS6AwardNotBetween(Double value1, Double value2) {
            addCriterion("s6_award not between", value1, value2, "s6Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardIsNull() {
            addCriterion("s7_award is null");
            return (Criteria) this;
        }

        public Criteria andS7AwardIsNotNull() {
            addCriterion("s7_award is not null");
            return (Criteria) this;
        }

        public Criteria andS7AwardEqualTo(Double value) {
            addCriterion("s7_award =", value, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardNotEqualTo(Double value) {
            addCriterion("s7_award <>", value, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardGreaterThan(Double value) {
            addCriterion("s7_award >", value, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s7_award >=", value, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardLessThan(Double value) {
            addCriterion("s7_award <", value, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardLessThanOrEqualTo(Double value) {
            addCriterion("s7_award <=", value, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardIn(List<Double> values) {
            addCriterion("s7_award in", values, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardNotIn(List<Double> values) {
            addCriterion("s7_award not in", values, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardBetween(Double value1, Double value2) {
            addCriterion("s7_award between", value1, value2, "s7Award");
            return (Criteria) this;
        }

        public Criteria andS7AwardNotBetween(Double value1, Double value2) {
            addCriterion("s7_award not between", value1, value2, "s7Award");
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