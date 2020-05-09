package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryFootballBfawardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryFootballBfawardExample() {
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

        public Criteria andS10awardIsNull() {
            addCriterion("s10award is null");
            return (Criteria) this;
        }

        public Criteria andS10awardIsNotNull() {
            addCriterion("s10award is not null");
            return (Criteria) this;
        }

        public Criteria andS10awardEqualTo(Double value) {
            addCriterion("s10award =", value, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardNotEqualTo(Double value) {
            addCriterion("s10award <>", value, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardGreaterThan(Double value) {
            addCriterion("s10award >", value, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s10award >=", value, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardLessThan(Double value) {
            addCriterion("s10award <", value, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardLessThanOrEqualTo(Double value) {
            addCriterion("s10award <=", value, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardIn(List<Double> values) {
            addCriterion("s10award in", values, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardNotIn(List<Double> values) {
            addCriterion("s10award not in", values, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardBetween(Double value1, Double value2) {
            addCriterion("s10award between", value1, value2, "s10award");
            return (Criteria) this;
        }

        public Criteria andS10awardNotBetween(Double value1, Double value2) {
            addCriterion("s10award not between", value1, value2, "s10award");
            return (Criteria) this;
        }

        public Criteria andS20awardIsNull() {
            addCriterion("s20award is null");
            return (Criteria) this;
        }

        public Criteria andS20awardIsNotNull() {
            addCriterion("s20award is not null");
            return (Criteria) this;
        }

        public Criteria andS20awardEqualTo(Double value) {
            addCriterion("s20award =", value, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardNotEqualTo(Double value) {
            addCriterion("s20award <>", value, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardGreaterThan(Double value) {
            addCriterion("s20award >", value, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s20award >=", value, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardLessThan(Double value) {
            addCriterion("s20award <", value, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardLessThanOrEqualTo(Double value) {
            addCriterion("s20award <=", value, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardIn(List<Double> values) {
            addCriterion("s20award in", values, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardNotIn(List<Double> values) {
            addCriterion("s20award not in", values, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardBetween(Double value1, Double value2) {
            addCriterion("s20award between", value1, value2, "s20award");
            return (Criteria) this;
        }

        public Criteria andS20awardNotBetween(Double value1, Double value2) {
            addCriterion("s20award not between", value1, value2, "s20award");
            return (Criteria) this;
        }

        public Criteria andS21awardIsNull() {
            addCriterion("s21award is null");
            return (Criteria) this;
        }

        public Criteria andS21awardIsNotNull() {
            addCriterion("s21award is not null");
            return (Criteria) this;
        }

        public Criteria andS21awardEqualTo(Double value) {
            addCriterion("s21award =", value, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardNotEqualTo(Double value) {
            addCriterion("s21award <>", value, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardGreaterThan(Double value) {
            addCriterion("s21award >", value, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s21award >=", value, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardLessThan(Double value) {
            addCriterion("s21award <", value, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardLessThanOrEqualTo(Double value) {
            addCriterion("s21award <=", value, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardIn(List<Double> values) {
            addCriterion("s21award in", values, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardNotIn(List<Double> values) {
            addCriterion("s21award not in", values, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardBetween(Double value1, Double value2) {
            addCriterion("s21award between", value1, value2, "s21award");
            return (Criteria) this;
        }

        public Criteria andS21awardNotBetween(Double value1, Double value2) {
            addCriterion("s21award not between", value1, value2, "s21award");
            return (Criteria) this;
        }

        public Criteria andS30awardIsNull() {
            addCriterion("s30award is null");
            return (Criteria) this;
        }

        public Criteria andS30awardIsNotNull() {
            addCriterion("s30award is not null");
            return (Criteria) this;
        }

        public Criteria andS30awardEqualTo(Double value) {
            addCriterion("s30award =", value, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardNotEqualTo(Double value) {
            addCriterion("s30award <>", value, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardGreaterThan(Double value) {
            addCriterion("s30award >", value, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s30award >=", value, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardLessThan(Double value) {
            addCriterion("s30award <", value, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardLessThanOrEqualTo(Double value) {
            addCriterion("s30award <=", value, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardIn(List<Double> values) {
            addCriterion("s30award in", values, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardNotIn(List<Double> values) {
            addCriterion("s30award not in", values, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardBetween(Double value1, Double value2) {
            addCriterion("s30award between", value1, value2, "s30award");
            return (Criteria) this;
        }

        public Criteria andS30awardNotBetween(Double value1, Double value2) {
            addCriterion("s30award not between", value1, value2, "s30award");
            return (Criteria) this;
        }

        public Criteria andS31awardIsNull() {
            addCriterion("s31award is null");
            return (Criteria) this;
        }

        public Criteria andS31awardIsNotNull() {
            addCriterion("s31award is not null");
            return (Criteria) this;
        }

        public Criteria andS31awardEqualTo(Double value) {
            addCriterion("s31award =", value, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardNotEqualTo(Double value) {
            addCriterion("s31award <>", value, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardGreaterThan(Double value) {
            addCriterion("s31award >", value, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s31award >=", value, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardLessThan(Double value) {
            addCriterion("s31award <", value, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardLessThanOrEqualTo(Double value) {
            addCriterion("s31award <=", value, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardIn(List<Double> values) {
            addCriterion("s31award in", values, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardNotIn(List<Double> values) {
            addCriterion("s31award not in", values, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardBetween(Double value1, Double value2) {
            addCriterion("s31award between", value1, value2, "s31award");
            return (Criteria) this;
        }

        public Criteria andS31awardNotBetween(Double value1, Double value2) {
            addCriterion("s31award not between", value1, value2, "s31award");
            return (Criteria) this;
        }

        public Criteria andS32awardIsNull() {
            addCriterion("s32award is null");
            return (Criteria) this;
        }

        public Criteria andS32awardIsNotNull() {
            addCriterion("s32award is not null");
            return (Criteria) this;
        }

        public Criteria andS32awardEqualTo(Double value) {
            addCriterion("s32award =", value, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardNotEqualTo(Double value) {
            addCriterion("s32award <>", value, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardGreaterThan(Double value) {
            addCriterion("s32award >", value, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s32award >=", value, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardLessThan(Double value) {
            addCriterion("s32award <", value, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardLessThanOrEqualTo(Double value) {
            addCriterion("s32award <=", value, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardIn(List<Double> values) {
            addCriterion("s32award in", values, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardNotIn(List<Double> values) {
            addCriterion("s32award not in", values, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardBetween(Double value1, Double value2) {
            addCriterion("s32award between", value1, value2, "s32award");
            return (Criteria) this;
        }

        public Criteria andS32awardNotBetween(Double value1, Double value2) {
            addCriterion("s32award not between", value1, value2, "s32award");
            return (Criteria) this;
        }

        public Criteria andS40awardIsNull() {
            addCriterion("s40award is null");
            return (Criteria) this;
        }

        public Criteria andS40awardIsNotNull() {
            addCriterion("s40award is not null");
            return (Criteria) this;
        }

        public Criteria andS40awardEqualTo(Double value) {
            addCriterion("s40award =", value, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardNotEqualTo(Double value) {
            addCriterion("s40award <>", value, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardGreaterThan(Double value) {
            addCriterion("s40award >", value, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s40award >=", value, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardLessThan(Double value) {
            addCriterion("s40award <", value, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardLessThanOrEqualTo(Double value) {
            addCriterion("s40award <=", value, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardIn(List<Double> values) {
            addCriterion("s40award in", values, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardNotIn(List<Double> values) {
            addCriterion("s40award not in", values, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardBetween(Double value1, Double value2) {
            addCriterion("s40award between", value1, value2, "s40award");
            return (Criteria) this;
        }

        public Criteria andS40awardNotBetween(Double value1, Double value2) {
            addCriterion("s40award not between", value1, value2, "s40award");
            return (Criteria) this;
        }

        public Criteria andS41awardIsNull() {
            addCriterion("s41award is null");
            return (Criteria) this;
        }

        public Criteria andS41awardIsNotNull() {
            addCriterion("s41award is not null");
            return (Criteria) this;
        }

        public Criteria andS41awardEqualTo(Double value) {
            addCriterion("s41award =", value, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardNotEqualTo(Double value) {
            addCriterion("s41award <>", value, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardGreaterThan(Double value) {
            addCriterion("s41award >", value, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s41award >=", value, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardLessThan(Double value) {
            addCriterion("s41award <", value, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardLessThanOrEqualTo(Double value) {
            addCriterion("s41award <=", value, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardIn(List<Double> values) {
            addCriterion("s41award in", values, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardNotIn(List<Double> values) {
            addCriterion("s41award not in", values, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardBetween(Double value1, Double value2) {
            addCriterion("s41award between", value1, value2, "s41award");
            return (Criteria) this;
        }

        public Criteria andS41awardNotBetween(Double value1, Double value2) {
            addCriterion("s41award not between", value1, value2, "s41award");
            return (Criteria) this;
        }

        public Criteria andS42awardIsNull() {
            addCriterion("s42award is null");
            return (Criteria) this;
        }

        public Criteria andS42awardIsNotNull() {
            addCriterion("s42award is not null");
            return (Criteria) this;
        }

        public Criteria andS42awardEqualTo(Double value) {
            addCriterion("s42award =", value, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardNotEqualTo(Double value) {
            addCriterion("s42award <>", value, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardGreaterThan(Double value) {
            addCriterion("s42award >", value, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s42award >=", value, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardLessThan(Double value) {
            addCriterion("s42award <", value, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardLessThanOrEqualTo(Double value) {
            addCriterion("s42award <=", value, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardIn(List<Double> values) {
            addCriterion("s42award in", values, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardNotIn(List<Double> values) {
            addCriterion("s42award not in", values, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardBetween(Double value1, Double value2) {
            addCriterion("s42award between", value1, value2, "s42award");
            return (Criteria) this;
        }

        public Criteria andS42awardNotBetween(Double value1, Double value2) {
            addCriterion("s42award not between", value1, value2, "s42award");
            return (Criteria) this;
        }

        public Criteria andS50awardIsNull() {
            addCriterion("s50award is null");
            return (Criteria) this;
        }

        public Criteria andS50awardIsNotNull() {
            addCriterion("s50award is not null");
            return (Criteria) this;
        }

        public Criteria andS50awardEqualTo(Double value) {
            addCriterion("s50award =", value, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardNotEqualTo(Double value) {
            addCriterion("s50award <>", value, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardGreaterThan(Double value) {
            addCriterion("s50award >", value, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s50award >=", value, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardLessThan(Double value) {
            addCriterion("s50award <", value, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardLessThanOrEqualTo(Double value) {
            addCriterion("s50award <=", value, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardIn(List<Double> values) {
            addCriterion("s50award in", values, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardNotIn(List<Double> values) {
            addCriterion("s50award not in", values, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardBetween(Double value1, Double value2) {
            addCriterion("s50award between", value1, value2, "s50award");
            return (Criteria) this;
        }

        public Criteria andS50awardNotBetween(Double value1, Double value2) {
            addCriterion("s50award not between", value1, value2, "s50award");
            return (Criteria) this;
        }

        public Criteria andS51awardIsNull() {
            addCriterion("s51award is null");
            return (Criteria) this;
        }

        public Criteria andS51awardIsNotNull() {
            addCriterion("s51award is not null");
            return (Criteria) this;
        }

        public Criteria andS51awardEqualTo(Double value) {
            addCriterion("s51award =", value, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardNotEqualTo(Double value) {
            addCriterion("s51award <>", value, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardGreaterThan(Double value) {
            addCriterion("s51award >", value, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s51award >=", value, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardLessThan(Double value) {
            addCriterion("s51award <", value, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardLessThanOrEqualTo(Double value) {
            addCriterion("s51award <=", value, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardIn(List<Double> values) {
            addCriterion("s51award in", values, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardNotIn(List<Double> values) {
            addCriterion("s51award not in", values, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardBetween(Double value1, Double value2) {
            addCriterion("s51award between", value1, value2, "s51award");
            return (Criteria) this;
        }

        public Criteria andS51awardNotBetween(Double value1, Double value2) {
            addCriterion("s51award not between", value1, value2, "s51award");
            return (Criteria) this;
        }

        public Criteria andS52awardIsNull() {
            addCriterion("s52award is null");
            return (Criteria) this;
        }

        public Criteria andS52awardIsNotNull() {
            addCriterion("s52award is not null");
            return (Criteria) this;
        }

        public Criteria andS52awardEqualTo(Double value) {
            addCriterion("s52award =", value, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardNotEqualTo(Double value) {
            addCriterion("s52award <>", value, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardGreaterThan(Double value) {
            addCriterion("s52award >", value, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s52award >=", value, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardLessThan(Double value) {
            addCriterion("s52award <", value, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardLessThanOrEqualTo(Double value) {
            addCriterion("s52award <=", value, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardIn(List<Double> values) {
            addCriterion("s52award in", values, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardNotIn(List<Double> values) {
            addCriterion("s52award not in", values, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardBetween(Double value1, Double value2) {
            addCriterion("s52award between", value1, value2, "s52award");
            return (Criteria) this;
        }

        public Criteria andS52awardNotBetween(Double value1, Double value2) {
            addCriterion("s52award not between", value1, value2, "s52award");
            return (Criteria) this;
        }

        public Criteria andSWinAwardIsNull() {
            addCriterion("s_win_award is null");
            return (Criteria) this;
        }

        public Criteria andSWinAwardIsNotNull() {
            addCriterion("s_win_award is not null");
            return (Criteria) this;
        }

        public Criteria andSWinAwardEqualTo(Double value) {
            addCriterion("s_win_award =", value, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardNotEqualTo(Double value) {
            addCriterion("s_win_award <>", value, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardGreaterThan(Double value) {
            addCriterion("s_win_award >", value, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s_win_award >=", value, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardLessThan(Double value) {
            addCriterion("s_win_award <", value, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardLessThanOrEqualTo(Double value) {
            addCriterion("s_win_award <=", value, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardIn(List<Double> values) {
            addCriterion("s_win_award in", values, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardNotIn(List<Double> values) {
            addCriterion("s_win_award not in", values, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardBetween(Double value1, Double value2) {
            addCriterion("s_win_award between", value1, value2, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andSWinAwardNotBetween(Double value1, Double value2) {
            addCriterion("s_win_award not between", value1, value2, "sWinAward");
            return (Criteria) this;
        }

        public Criteria andS00awardIsNull() {
            addCriterion("s00award is null");
            return (Criteria) this;
        }

        public Criteria andS00awardIsNotNull() {
            addCriterion("s00award is not null");
            return (Criteria) this;
        }

        public Criteria andS00awardEqualTo(Double value) {
            addCriterion("s00award =", value, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardNotEqualTo(Double value) {
            addCriterion("s00award <>", value, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardGreaterThan(Double value) {
            addCriterion("s00award >", value, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s00award >=", value, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardLessThan(Double value) {
            addCriterion("s00award <", value, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardLessThanOrEqualTo(Double value) {
            addCriterion("s00award <=", value, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardIn(List<Double> values) {
            addCriterion("s00award in", values, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardNotIn(List<Double> values) {
            addCriterion("s00award not in", values, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardBetween(Double value1, Double value2) {
            addCriterion("s00award between", value1, value2, "s00award");
            return (Criteria) this;
        }

        public Criteria andS00awardNotBetween(Double value1, Double value2) {
            addCriterion("s00award not between", value1, value2, "s00award");
            return (Criteria) this;
        }

        public Criteria andS11awardIsNull() {
            addCriterion("s11award is null");
            return (Criteria) this;
        }

        public Criteria andS11awardIsNotNull() {
            addCriterion("s11award is not null");
            return (Criteria) this;
        }

        public Criteria andS11awardEqualTo(Double value) {
            addCriterion("s11award =", value, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardNotEqualTo(Double value) {
            addCriterion("s11award <>", value, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardGreaterThan(Double value) {
            addCriterion("s11award >", value, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s11award >=", value, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardLessThan(Double value) {
            addCriterion("s11award <", value, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardLessThanOrEqualTo(Double value) {
            addCriterion("s11award <=", value, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardIn(List<Double> values) {
            addCriterion("s11award in", values, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardNotIn(List<Double> values) {
            addCriterion("s11award not in", values, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardBetween(Double value1, Double value2) {
            addCriterion("s11award between", value1, value2, "s11award");
            return (Criteria) this;
        }

        public Criteria andS11awardNotBetween(Double value1, Double value2) {
            addCriterion("s11award not between", value1, value2, "s11award");
            return (Criteria) this;
        }

        public Criteria andS22awardIsNull() {
            addCriterion("s22award is null");
            return (Criteria) this;
        }

        public Criteria andS22awardIsNotNull() {
            addCriterion("s22award is not null");
            return (Criteria) this;
        }

        public Criteria andS22awardEqualTo(Double value) {
            addCriterion("s22award =", value, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardNotEqualTo(Double value) {
            addCriterion("s22award <>", value, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardGreaterThan(Double value) {
            addCriterion("s22award >", value, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s22award >=", value, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardLessThan(Double value) {
            addCriterion("s22award <", value, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardLessThanOrEqualTo(Double value) {
            addCriterion("s22award <=", value, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardIn(List<Double> values) {
            addCriterion("s22award in", values, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardNotIn(List<Double> values) {
            addCriterion("s22award not in", values, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardBetween(Double value1, Double value2) {
            addCriterion("s22award between", value1, value2, "s22award");
            return (Criteria) this;
        }

        public Criteria andS22awardNotBetween(Double value1, Double value2) {
            addCriterion("s22award not between", value1, value2, "s22award");
            return (Criteria) this;
        }

        public Criteria andS33awardIsNull() {
            addCriterion("s33award is null");
            return (Criteria) this;
        }

        public Criteria andS33awardIsNotNull() {
            addCriterion("s33award is not null");
            return (Criteria) this;
        }

        public Criteria andS33awardEqualTo(Double value) {
            addCriterion("s33award =", value, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardNotEqualTo(Double value) {
            addCriterion("s33award <>", value, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardGreaterThan(Double value) {
            addCriterion("s33award >", value, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s33award >=", value, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardLessThan(Double value) {
            addCriterion("s33award <", value, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardLessThanOrEqualTo(Double value) {
            addCriterion("s33award <=", value, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardIn(List<Double> values) {
            addCriterion("s33award in", values, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardNotIn(List<Double> values) {
            addCriterion("s33award not in", values, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardBetween(Double value1, Double value2) {
            addCriterion("s33award between", value1, value2, "s33award");
            return (Criteria) this;
        }

        public Criteria andS33awardNotBetween(Double value1, Double value2) {
            addCriterion("s33award not between", value1, value2, "s33award");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardIsNull() {
            addCriterion("s_draw_award is null");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardIsNotNull() {
            addCriterion("s_draw_award is not null");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardEqualTo(Double value) {
            addCriterion("s_draw_award =", value, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardNotEqualTo(Double value) {
            addCriterion("s_draw_award <>", value, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardGreaterThan(Double value) {
            addCriterion("s_draw_award >", value, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s_draw_award >=", value, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardLessThan(Double value) {
            addCriterion("s_draw_award <", value, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardLessThanOrEqualTo(Double value) {
            addCriterion("s_draw_award <=", value, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardIn(List<Double> values) {
            addCriterion("s_draw_award in", values, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardNotIn(List<Double> values) {
            addCriterion("s_draw_award not in", values, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardBetween(Double value1, Double value2) {
            addCriterion("s_draw_award between", value1, value2, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andSDrawAwardNotBetween(Double value1, Double value2) {
            addCriterion("s_draw_award not between", value1, value2, "sDrawAward");
            return (Criteria) this;
        }

        public Criteria andS01awardIsNull() {
            addCriterion("s01award is null");
            return (Criteria) this;
        }

        public Criteria andS01awardIsNotNull() {
            addCriterion("s01award is not null");
            return (Criteria) this;
        }

        public Criteria andS01awardEqualTo(Double value) {
            addCriterion("s01award =", value, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardNotEqualTo(Double value) {
            addCriterion("s01award <>", value, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardGreaterThan(Double value) {
            addCriterion("s01award >", value, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s01award >=", value, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardLessThan(Double value) {
            addCriterion("s01award <", value, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardLessThanOrEqualTo(Double value) {
            addCriterion("s01award <=", value, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardIn(List<Double> values) {
            addCriterion("s01award in", values, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardNotIn(List<Double> values) {
            addCriterion("s01award not in", values, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardBetween(Double value1, Double value2) {
            addCriterion("s01award between", value1, value2, "s01award");
            return (Criteria) this;
        }

        public Criteria andS01awardNotBetween(Double value1, Double value2) {
            addCriterion("s01award not between", value1, value2, "s01award");
            return (Criteria) this;
        }

        public Criteria andS02awardIsNull() {
            addCriterion("s02award is null");
            return (Criteria) this;
        }

        public Criteria andS02awardIsNotNull() {
            addCriterion("s02award is not null");
            return (Criteria) this;
        }

        public Criteria andS02awardEqualTo(Double value) {
            addCriterion("s02award =", value, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardNotEqualTo(Double value) {
            addCriterion("s02award <>", value, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardGreaterThan(Double value) {
            addCriterion("s02award >", value, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s02award >=", value, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardLessThan(Double value) {
            addCriterion("s02award <", value, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardLessThanOrEqualTo(Double value) {
            addCriterion("s02award <=", value, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardIn(List<Double> values) {
            addCriterion("s02award in", values, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardNotIn(List<Double> values) {
            addCriterion("s02award not in", values, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardBetween(Double value1, Double value2) {
            addCriterion("s02award between", value1, value2, "s02award");
            return (Criteria) this;
        }

        public Criteria andS02awardNotBetween(Double value1, Double value2) {
            addCriterion("s02award not between", value1, value2, "s02award");
            return (Criteria) this;
        }

        public Criteria andS12awardIsNull() {
            addCriterion("s12award is null");
            return (Criteria) this;
        }

        public Criteria andS12awardIsNotNull() {
            addCriterion("s12award is not null");
            return (Criteria) this;
        }

        public Criteria andS12awardEqualTo(Double value) {
            addCriterion("s12award =", value, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardNotEqualTo(Double value) {
            addCriterion("s12award <>", value, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardGreaterThan(Double value) {
            addCriterion("s12award >", value, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s12award >=", value, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardLessThan(Double value) {
            addCriterion("s12award <", value, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardLessThanOrEqualTo(Double value) {
            addCriterion("s12award <=", value, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardIn(List<Double> values) {
            addCriterion("s12award in", values, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardNotIn(List<Double> values) {
            addCriterion("s12award not in", values, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardBetween(Double value1, Double value2) {
            addCriterion("s12award between", value1, value2, "s12award");
            return (Criteria) this;
        }

        public Criteria andS12awardNotBetween(Double value1, Double value2) {
            addCriterion("s12award not between", value1, value2, "s12award");
            return (Criteria) this;
        }

        public Criteria andS03awardIsNull() {
            addCriterion("s03award is null");
            return (Criteria) this;
        }

        public Criteria andS03awardIsNotNull() {
            addCriterion("s03award is not null");
            return (Criteria) this;
        }

        public Criteria andS03awardEqualTo(Double value) {
            addCriterion("s03award =", value, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardNotEqualTo(Double value) {
            addCriterion("s03award <>", value, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardGreaterThan(Double value) {
            addCriterion("s03award >", value, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s03award >=", value, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardLessThan(Double value) {
            addCriterion("s03award <", value, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardLessThanOrEqualTo(Double value) {
            addCriterion("s03award <=", value, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardIn(List<Double> values) {
            addCriterion("s03award in", values, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardNotIn(List<Double> values) {
            addCriterion("s03award not in", values, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardBetween(Double value1, Double value2) {
            addCriterion("s03award between", value1, value2, "s03award");
            return (Criteria) this;
        }

        public Criteria andS03awardNotBetween(Double value1, Double value2) {
            addCriterion("s03award not between", value1, value2, "s03award");
            return (Criteria) this;
        }

        public Criteria andS13awardIsNull() {
            addCriterion("s13award is null");
            return (Criteria) this;
        }

        public Criteria andS13awardIsNotNull() {
            addCriterion("s13award is not null");
            return (Criteria) this;
        }

        public Criteria andS13awardEqualTo(Double value) {
            addCriterion("s13award =", value, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardNotEqualTo(Double value) {
            addCriterion("s13award <>", value, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardGreaterThan(Double value) {
            addCriterion("s13award >", value, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s13award >=", value, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardLessThan(Double value) {
            addCriterion("s13award <", value, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardLessThanOrEqualTo(Double value) {
            addCriterion("s13award <=", value, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardIn(List<Double> values) {
            addCriterion("s13award in", values, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardNotIn(List<Double> values) {
            addCriterion("s13award not in", values, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardBetween(Double value1, Double value2) {
            addCriterion("s13award between", value1, value2, "s13award");
            return (Criteria) this;
        }

        public Criteria andS13awardNotBetween(Double value1, Double value2) {
            addCriterion("s13award not between", value1, value2, "s13award");
            return (Criteria) this;
        }

        public Criteria andS23awardIsNull() {
            addCriterion("s23award is null");
            return (Criteria) this;
        }

        public Criteria andS23awardIsNotNull() {
            addCriterion("s23award is not null");
            return (Criteria) this;
        }

        public Criteria andS23awardEqualTo(Double value) {
            addCriterion("s23award =", value, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardNotEqualTo(Double value) {
            addCriterion("s23award <>", value, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardGreaterThan(Double value) {
            addCriterion("s23award >", value, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s23award >=", value, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardLessThan(Double value) {
            addCriterion("s23award <", value, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardLessThanOrEqualTo(Double value) {
            addCriterion("s23award <=", value, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardIn(List<Double> values) {
            addCriterion("s23award in", values, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardNotIn(List<Double> values) {
            addCriterion("s23award not in", values, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardBetween(Double value1, Double value2) {
            addCriterion("s23award between", value1, value2, "s23award");
            return (Criteria) this;
        }

        public Criteria andS23awardNotBetween(Double value1, Double value2) {
            addCriterion("s23award not between", value1, value2, "s23award");
            return (Criteria) this;
        }

        public Criteria andS04awardIsNull() {
            addCriterion("s04award is null");
            return (Criteria) this;
        }

        public Criteria andS04awardIsNotNull() {
            addCriterion("s04award is not null");
            return (Criteria) this;
        }

        public Criteria andS04awardEqualTo(Double value) {
            addCriterion("s04award =", value, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardNotEqualTo(Double value) {
            addCriterion("s04award <>", value, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardGreaterThan(Double value) {
            addCriterion("s04award >", value, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s04award >=", value, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardLessThan(Double value) {
            addCriterion("s04award <", value, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardLessThanOrEqualTo(Double value) {
            addCriterion("s04award <=", value, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardIn(List<Double> values) {
            addCriterion("s04award in", values, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardNotIn(List<Double> values) {
            addCriterion("s04award not in", values, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardBetween(Double value1, Double value2) {
            addCriterion("s04award between", value1, value2, "s04award");
            return (Criteria) this;
        }

        public Criteria andS04awardNotBetween(Double value1, Double value2) {
            addCriterion("s04award not between", value1, value2, "s04award");
            return (Criteria) this;
        }

        public Criteria andS14awardIsNull() {
            addCriterion("s14award is null");
            return (Criteria) this;
        }

        public Criteria andS14awardIsNotNull() {
            addCriterion("s14award is not null");
            return (Criteria) this;
        }

        public Criteria andS14awardEqualTo(Double value) {
            addCriterion("s14award =", value, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardNotEqualTo(Double value) {
            addCriterion("s14award <>", value, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardGreaterThan(Double value) {
            addCriterion("s14award >", value, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s14award >=", value, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardLessThan(Double value) {
            addCriterion("s14award <", value, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardLessThanOrEqualTo(Double value) {
            addCriterion("s14award <=", value, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardIn(List<Double> values) {
            addCriterion("s14award in", values, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardNotIn(List<Double> values) {
            addCriterion("s14award not in", values, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardBetween(Double value1, Double value2) {
            addCriterion("s14award between", value1, value2, "s14award");
            return (Criteria) this;
        }

        public Criteria andS14awardNotBetween(Double value1, Double value2) {
            addCriterion("s14award not between", value1, value2, "s14award");
            return (Criteria) this;
        }

        public Criteria andS24awardIsNull() {
            addCriterion("s24award is null");
            return (Criteria) this;
        }

        public Criteria andS24awardIsNotNull() {
            addCriterion("s24award is not null");
            return (Criteria) this;
        }

        public Criteria andS24awardEqualTo(Double value) {
            addCriterion("s24award =", value, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardNotEqualTo(Double value) {
            addCriterion("s24award <>", value, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardGreaterThan(Double value) {
            addCriterion("s24award >", value, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s24award >=", value, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardLessThan(Double value) {
            addCriterion("s24award <", value, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardLessThanOrEqualTo(Double value) {
            addCriterion("s24award <=", value, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardIn(List<Double> values) {
            addCriterion("s24award in", values, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardNotIn(List<Double> values) {
            addCriterion("s24award not in", values, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardBetween(Double value1, Double value2) {
            addCriterion("s24award between", value1, value2, "s24award");
            return (Criteria) this;
        }

        public Criteria andS24awardNotBetween(Double value1, Double value2) {
            addCriterion("s24award not between", value1, value2, "s24award");
            return (Criteria) this;
        }

        public Criteria andS05awardIsNull() {
            addCriterion("s05award is null");
            return (Criteria) this;
        }

        public Criteria andS05awardIsNotNull() {
            addCriterion("s05award is not null");
            return (Criteria) this;
        }

        public Criteria andS05awardEqualTo(Double value) {
            addCriterion("s05award =", value, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardNotEqualTo(Double value) {
            addCriterion("s05award <>", value, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardGreaterThan(Double value) {
            addCriterion("s05award >", value, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s05award >=", value, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardLessThan(Double value) {
            addCriterion("s05award <", value, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardLessThanOrEqualTo(Double value) {
            addCriterion("s05award <=", value, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardIn(List<Double> values) {
            addCriterion("s05award in", values, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardNotIn(List<Double> values) {
            addCriterion("s05award not in", values, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardBetween(Double value1, Double value2) {
            addCriterion("s05award between", value1, value2, "s05award");
            return (Criteria) this;
        }

        public Criteria andS05awardNotBetween(Double value1, Double value2) {
            addCriterion("s05award not between", value1, value2, "s05award");
            return (Criteria) this;
        }

        public Criteria andS15awardIsNull() {
            addCriterion("s15award is null");
            return (Criteria) this;
        }

        public Criteria andS15awardIsNotNull() {
            addCriterion("s15award is not null");
            return (Criteria) this;
        }

        public Criteria andS15awardEqualTo(Double value) {
            addCriterion("s15award =", value, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardNotEqualTo(Double value) {
            addCriterion("s15award <>", value, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardGreaterThan(Double value) {
            addCriterion("s15award >", value, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s15award >=", value, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardLessThan(Double value) {
            addCriterion("s15award <", value, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardLessThanOrEqualTo(Double value) {
            addCriterion("s15award <=", value, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardIn(List<Double> values) {
            addCriterion("s15award in", values, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardNotIn(List<Double> values) {
            addCriterion("s15award not in", values, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardBetween(Double value1, Double value2) {
            addCriterion("s15award between", value1, value2, "s15award");
            return (Criteria) this;
        }

        public Criteria andS15awardNotBetween(Double value1, Double value2) {
            addCriterion("s15award not between", value1, value2, "s15award");
            return (Criteria) this;
        }

        public Criteria andS25awardIsNull() {
            addCriterion("s25award is null");
            return (Criteria) this;
        }

        public Criteria andS25awardIsNotNull() {
            addCriterion("s25award is not null");
            return (Criteria) this;
        }

        public Criteria andS25awardEqualTo(Double value) {
            addCriterion("s25award =", value, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardNotEqualTo(Double value) {
            addCriterion("s25award <>", value, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardGreaterThan(Double value) {
            addCriterion("s25award >", value, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardGreaterThanOrEqualTo(Double value) {
            addCriterion("s25award >=", value, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardLessThan(Double value) {
            addCriterion("s25award <", value, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardLessThanOrEqualTo(Double value) {
            addCriterion("s25award <=", value, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardIn(List<Double> values) {
            addCriterion("s25award in", values, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardNotIn(List<Double> values) {
            addCriterion("s25award not in", values, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardBetween(Double value1, Double value2) {
            addCriterion("s25award between", value1, value2, "s25award");
            return (Criteria) this;
        }

        public Criteria andS25awardNotBetween(Double value1, Double value2) {
            addCriterion("s25award not between", value1, value2, "s25award");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardIsNull() {
            addCriterion("s_lose_award is null");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardIsNotNull() {
            addCriterion("s_lose_award is not null");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardEqualTo(Double value) {
            addCriterion("s_lose_award =", value, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardNotEqualTo(Double value) {
            addCriterion("s_lose_award <>", value, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardGreaterThan(Double value) {
            addCriterion("s_lose_award >", value, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("s_lose_award >=", value, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardLessThan(Double value) {
            addCriterion("s_lose_award <", value, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardLessThanOrEqualTo(Double value) {
            addCriterion("s_lose_award <=", value, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardIn(List<Double> values) {
            addCriterion("s_lose_award in", values, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardNotIn(List<Double> values) {
            addCriterion("s_lose_award not in", values, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardBetween(Double value1, Double value2) {
            addCriterion("s_lose_award between", value1, value2, "sLoseAward");
            return (Criteria) this;
        }

        public Criteria andSLoseAwardNotBetween(Double value1, Double value2) {
            addCriterion("s_lose_award not between", value1, value2, "sLoseAward");
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