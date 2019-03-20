package com.qiyun.model2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecommendMatchMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecommendMatchMappingExample() {
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

        public Criteria andRecomPlanIdIsNull() {
            addCriterion("recom_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdIsNotNull() {
            addCriterion("recom_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdEqualTo(Integer value) {
            addCriterion("recom_plan_id =", value, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdNotEqualTo(Integer value) {
            addCriterion("recom_plan_id <>", value, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdGreaterThan(Integer value) {
            addCriterion("recom_plan_id >", value, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recom_plan_id >=", value, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdLessThan(Integer value) {
            addCriterion("recom_plan_id <", value, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("recom_plan_id <=", value, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdIn(List<Integer> values) {
            addCriterion("recom_plan_id in", values, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdNotIn(List<Integer> values) {
            addCriterion("recom_plan_id not in", values, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("recom_plan_id between", value1, value2, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andRecomPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recom_plan_id not between", value1, value2, "recomPlanId");
            return (Criteria) this;
        }

        public Criteria andIntTimeIsNull() {
            addCriterion("int_time is null");
            return (Criteria) this;
        }

        public Criteria andIntTimeIsNotNull() {
            addCriterion("int_time is not null");
            return (Criteria) this;
        }

        public Criteria andIntTimeEqualTo(Integer value) {
            addCriterion("int_time =", value, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeNotEqualTo(Integer value) {
            addCriterion("int_time <>", value, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeGreaterThan(Integer value) {
            addCriterion("int_time >", value, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("int_time >=", value, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeLessThan(Integer value) {
            addCriterion("int_time <", value, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeLessThanOrEqualTo(Integer value) {
            addCriterion("int_time <=", value, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeIn(List<Integer> values) {
            addCriterion("int_time in", values, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeNotIn(List<Integer> values) {
            addCriterion("int_time not in", values, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeBetween(Integer value1, Integer value2) {
            addCriterion("int_time between", value1, value2, "intTime");
            return (Criteria) this;
        }

        public Criteria andIntTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("int_time not between", value1, value2, "intTime");
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

        public Criteria andHomeTeamIsNull() {
            addCriterion("home_team is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIsNotNull() {
            addCriterion("home_team is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeamEqualTo(String value) {
            addCriterion("home_team =", value, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamNotEqualTo(String value) {
            addCriterion("home_team <>", value, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamGreaterThan(String value) {
            addCriterion("home_team >", value, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamGreaterThanOrEqualTo(String value) {
            addCriterion("home_team >=", value, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamLessThan(String value) {
            addCriterion("home_team <", value, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamLessThanOrEqualTo(String value) {
            addCriterion("home_team <=", value, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamLike(String value) {
            addCriterion("home_team like", value, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamNotLike(String value) {
            addCriterion("home_team not like", value, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamIn(List<String> values) {
            addCriterion("home_team in", values, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamNotIn(List<String> values) {
            addCriterion("home_team not in", values, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamBetween(String value1, String value2) {
            addCriterion("home_team between", value1, value2, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andHomeTeamNotBetween(String value1, String value2) {
            addCriterion("home_team not between", value1, value2, "homeTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamIsNull() {
            addCriterion("guest_team is null");
            return (Criteria) this;
        }

        public Criteria andGuestTeamIsNotNull() {
            addCriterion("guest_team is not null");
            return (Criteria) this;
        }

        public Criteria andGuestTeamEqualTo(String value) {
            addCriterion("guest_team =", value, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamNotEqualTo(String value) {
            addCriterion("guest_team <>", value, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamGreaterThan(String value) {
            addCriterion("guest_team >", value, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamGreaterThanOrEqualTo(String value) {
            addCriterion("guest_team >=", value, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamLessThan(String value) {
            addCriterion("guest_team <", value, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamLessThanOrEqualTo(String value) {
            addCriterion("guest_team <=", value, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamLike(String value) {
            addCriterion("guest_team like", value, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamNotLike(String value) {
            addCriterion("guest_team not like", value, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamIn(List<String> values) {
            addCriterion("guest_team in", values, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamNotIn(List<String> values) {
            addCriterion("guest_team not in", values, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamBetween(String value1, String value2) {
            addCriterion("guest_team between", value1, value2, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andGuestTeamNotBetween(String value1, String value2) {
            addCriterion("guest_team not between", value1, value2, "guestTeam");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIsNull() {
            addCriterion("match_time is null");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIsNotNull() {
            addCriterion("match_time is not null");
            return (Criteria) this;
        }

        public Criteria andMatchTimeEqualTo(Date value) {
            addCriterion("match_time =", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotEqualTo(Date value) {
            addCriterion("match_time <>", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeGreaterThan(Date value) {
            addCriterion("match_time >", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("match_time >=", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLessThan(Date value) {
            addCriterion("match_time <", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLessThanOrEqualTo(Date value) {
            addCriterion("match_time <=", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIn(List<Date> values) {
            addCriterion("match_time in", values, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotIn(List<Date> values) {
            addCriterion("match_time not in", values, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeBetween(Date value1, Date value2) {
            addCriterion("match_time between", value1, value2, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotBetween(Date value1, Date value2) {
            addCriterion("match_time not between", value1, value2, "matchTime");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andSpIsNull() {
            addCriterion("sp is null");
            return (Criteria) this;
        }

        public Criteria andSpIsNotNull() {
            addCriterion("sp is not null");
            return (Criteria) this;
        }

        public Criteria andSpEqualTo(BigDecimal value) {
            addCriterion("sp =", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotEqualTo(BigDecimal value) {
            addCriterion("sp <>", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpGreaterThan(BigDecimal value) {
            addCriterion("sp >", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sp >=", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpLessThan(BigDecimal value) {
            addCriterion("sp <", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sp <=", value, "sp");
            return (Criteria) this;
        }

        public Criteria andSpIn(List<BigDecimal> values) {
            addCriterion("sp in", values, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotIn(List<BigDecimal> values) {
            addCriterion("sp not in", values, "sp");
            return (Criteria) this;
        }

        public Criteria andSpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sp between", value1, value2, "sp");
            return (Criteria) this;
        }

        public Criteria andSpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sp not between", value1, value2, "sp");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Integer value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Integer value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Integer value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Integer value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Integer value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Integer> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Integer> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Integer value1, Integer value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Integer value1, Integer value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andBaseBigSmallIsNull() {
            addCriterion("base_big_small is null");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallIsNotNull() {
            addCriterion("base_big_small is not null");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallEqualTo(BigDecimal value) {
            addCriterion("base_big_small =", value, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallNotEqualTo(BigDecimal value) {
            addCriterion("base_big_small <>", value, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallGreaterThan(BigDecimal value) {
            addCriterion("base_big_small >", value, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("base_big_small >=", value, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallLessThan(BigDecimal value) {
            addCriterion("base_big_small <", value, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallLessThanOrEqualTo(BigDecimal value) {
            addCriterion("base_big_small <=", value, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallIn(List<BigDecimal> values) {
            addCriterion("base_big_small in", values, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallNotIn(List<BigDecimal> values) {
            addCriterion("base_big_small not in", values, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_big_small between", value1, value2, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBaseBigSmallNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_big_small not between", value1, value2, "baseBigSmall");
            return (Criteria) this;
        }

        public Criteria andBingoStatusIsNull() {
            addCriterion("bingo_status is null");
            return (Criteria) this;
        }

        public Criteria andBingoStatusIsNotNull() {
            addCriterion("bingo_status is not null");
            return (Criteria) this;
        }

        public Criteria andBingoStatusEqualTo(Integer value) {
            addCriterion("bingo_status =", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusNotEqualTo(Integer value) {
            addCriterion("bingo_status <>", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusGreaterThan(Integer value) {
            addCriterion("bingo_status >", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bingo_status >=", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusLessThan(Integer value) {
            addCriterion("bingo_status <", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bingo_status <=", value, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusIn(List<Integer> values) {
            addCriterion("bingo_status in", values, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusNotIn(List<Integer> values) {
            addCriterion("bingo_status not in", values, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusBetween(Integer value1, Integer value2) {
            addCriterion("bingo_status between", value1, value2, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andBingoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bingo_status not between", value1, value2, "bingoStatus");
            return (Criteria) this;
        }

        public Criteria andGameNameIsNull() {
            addCriterion("game_name is null");
            return (Criteria) this;
        }

        public Criteria andGameNameIsNotNull() {
            addCriterion("game_name is not null");
            return (Criteria) this;
        }

        public Criteria andGameNameEqualTo(String value) {
            addCriterion("game_name =", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotEqualTo(String value) {
            addCriterion("game_name <>", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameGreaterThan(String value) {
            addCriterion("game_name >", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameGreaterThanOrEqualTo(String value) {
            addCriterion("game_name >=", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLessThan(String value) {
            addCriterion("game_name <", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLessThanOrEqualTo(String value) {
            addCriterion("game_name <=", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLike(String value) {
            addCriterion("game_name like", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotLike(String value) {
            addCriterion("game_name not like", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameIn(List<String> values) {
            addCriterion("game_name in", values, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotIn(List<String> values) {
            addCriterion("game_name not in", values, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameBetween(String value1, String value2) {
            addCriterion("game_name between", value1, value2, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotBetween(String value1, String value2) {
            addCriterion("game_name not between", value1, value2, "gameName");
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