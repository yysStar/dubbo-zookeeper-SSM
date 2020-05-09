package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SZ2C12Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SZ2C12Query() {
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

        public Criteria andMatchId1IsNull() {
            addCriterion("match_id1 is null");
            return (Criteria) this;
        }

        public Criteria andMatchId1IsNotNull() {
            addCriterion("match_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andMatchId1EqualTo(String value) {
            addCriterion("match_id1 =", value, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1NotEqualTo(String value) {
            addCriterion("match_id1 <>", value, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1GreaterThan(String value) {
            addCriterion("match_id1 >", value, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1GreaterThanOrEqualTo(String value) {
            addCriterion("match_id1 >=", value, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1LessThan(String value) {
            addCriterion("match_id1 <", value, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1LessThanOrEqualTo(String value) {
            addCriterion("match_id1 <=", value, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1Like(String value) {
            addCriterion("match_id1 like", value, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1NotLike(String value) {
            addCriterion("match_id1 not like", value, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1In(List<String> values) {
            addCriterion("match_id1 in", values, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1NotIn(List<String> values) {
            addCriterion("match_id1 not in", values, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1Between(String value1, String value2) {
            addCriterion("match_id1 between", value1, value2, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId1NotBetween(String value1, String value2) {
            addCriterion("match_id1 not between", value1, value2, "matchId1");
            return (Criteria) this;
        }

        public Criteria andMatchId2IsNull() {
            addCriterion("match_id2 is null");
            return (Criteria) this;
        }

        public Criteria andMatchId2IsNotNull() {
            addCriterion("match_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andMatchId2EqualTo(String value) {
            addCriterion("match_id2 =", value, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2NotEqualTo(String value) {
            addCriterion("match_id2 <>", value, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2GreaterThan(String value) {
            addCriterion("match_id2 >", value, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2GreaterThanOrEqualTo(String value) {
            addCriterion("match_id2 >=", value, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2LessThan(String value) {
            addCriterion("match_id2 <", value, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2LessThanOrEqualTo(String value) {
            addCriterion("match_id2 <=", value, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2Like(String value) {
            addCriterion("match_id2 like", value, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2NotLike(String value) {
            addCriterion("match_id2 not like", value, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2In(List<String> values) {
            addCriterion("match_id2 in", values, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2NotIn(List<String> values) {
            addCriterion("match_id2 not in", values, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2Between(String value1, String value2) {
            addCriterion("match_id2 between", value1, value2, "matchId2");
            return (Criteria) this;
        }

        public Criteria andMatchId2NotBetween(String value1, String value2) {
            addCriterion("match_id2 not between", value1, value2, "matchId2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1IsNull() {
            addCriterion("home_team1 is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1IsNotNull() {
            addCriterion("home_team1 is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1EqualTo(String value) {
            addCriterion("home_team1 =", value, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1NotEqualTo(String value) {
            addCriterion("home_team1 <>", value, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1GreaterThan(String value) {
            addCriterion("home_team1 >", value, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1GreaterThanOrEqualTo(String value) {
            addCriterion("home_team1 >=", value, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1LessThan(String value) {
            addCriterion("home_team1 <", value, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1LessThanOrEqualTo(String value) {
            addCriterion("home_team1 <=", value, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1Like(String value) {
            addCriterion("home_team1 like", value, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1NotLike(String value) {
            addCriterion("home_team1 not like", value, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1In(List<String> values) {
            addCriterion("home_team1 in", values, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1NotIn(List<String> values) {
            addCriterion("home_team1 not in", values, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1Between(String value1, String value2) {
            addCriterion("home_team1 between", value1, value2, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam1NotBetween(String value1, String value2) {
            addCriterion("home_team1 not between", value1, value2, "homeTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1IsNull() {
            addCriterion("guest_team1 is null");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1IsNotNull() {
            addCriterion("guest_team1 is not null");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1EqualTo(String value) {
            addCriterion("guest_team1 =", value, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1NotEqualTo(String value) {
            addCriterion("guest_team1 <>", value, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1GreaterThan(String value) {
            addCriterion("guest_team1 >", value, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1GreaterThanOrEqualTo(String value) {
            addCriterion("guest_team1 >=", value, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1LessThan(String value) {
            addCriterion("guest_team1 <", value, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1LessThanOrEqualTo(String value) {
            addCriterion("guest_team1 <=", value, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1Like(String value) {
            addCriterion("guest_team1 like", value, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1NotLike(String value) {
            addCriterion("guest_team1 not like", value, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1In(List<String> values) {
            addCriterion("guest_team1 in", values, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1NotIn(List<String> values) {
            addCriterion("guest_team1 not in", values, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1Between(String value1, String value2) {
            addCriterion("guest_team1 between", value1, value2, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andGuestTeam1NotBetween(String value1, String value2) {
            addCriterion("guest_team1 not between", value1, value2, "guestTeam1");
            return (Criteria) this;
        }

        public Criteria andRecommend1IsNull() {
            addCriterion("recommend1 is null");
            return (Criteria) this;
        }

        public Criteria andRecommend1IsNotNull() {
            addCriterion("recommend1 is not null");
            return (Criteria) this;
        }

        public Criteria andRecommend1EqualTo(String value) {
            addCriterion("recommend1 =", value, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1NotEqualTo(String value) {
            addCriterion("recommend1 <>", value, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1GreaterThan(String value) {
            addCriterion("recommend1 >", value, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1GreaterThanOrEqualTo(String value) {
            addCriterion("recommend1 >=", value, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1LessThan(String value) {
            addCriterion("recommend1 <", value, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1LessThanOrEqualTo(String value) {
            addCriterion("recommend1 <=", value, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1Like(String value) {
            addCriterion("recommend1 like", value, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1NotLike(String value) {
            addCriterion("recommend1 not like", value, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1In(List<String> values) {
            addCriterion("recommend1 in", values, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1NotIn(List<String> values) {
            addCriterion("recommend1 not in", values, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1Between(String value1, String value2) {
            addCriterion("recommend1 between", value1, value2, "recommend1");
            return (Criteria) this;
        }

        public Criteria andRecommend1NotBetween(String value1, String value2) {
            addCriterion("recommend1 not between", value1, value2, "recommend1");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2IsNull() {
            addCriterion("home_team2 is null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2IsNotNull() {
            addCriterion("home_team2 is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2EqualTo(String value) {
            addCriterion("home_team2 =", value, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2NotEqualTo(String value) {
            addCriterion("home_team2 <>", value, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2GreaterThan(String value) {
            addCriterion("home_team2 >", value, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2GreaterThanOrEqualTo(String value) {
            addCriterion("home_team2 >=", value, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2LessThan(String value) {
            addCriterion("home_team2 <", value, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2LessThanOrEqualTo(String value) {
            addCriterion("home_team2 <=", value, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2Like(String value) {
            addCriterion("home_team2 like", value, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2NotLike(String value) {
            addCriterion("home_team2 not like", value, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2In(List<String> values) {
            addCriterion("home_team2 in", values, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2NotIn(List<String> values) {
            addCriterion("home_team2 not in", values, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2Between(String value1, String value2) {
            addCriterion("home_team2 between", value1, value2, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andHomeTeam2NotBetween(String value1, String value2) {
            addCriterion("home_team2 not between", value1, value2, "homeTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2IsNull() {
            addCriterion("guest_team2 is null");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2IsNotNull() {
            addCriterion("guest_team2 is not null");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2EqualTo(String value) {
            addCriterion("guest_team2 =", value, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2NotEqualTo(String value) {
            addCriterion("guest_team2 <>", value, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2GreaterThan(String value) {
            addCriterion("guest_team2 >", value, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2GreaterThanOrEqualTo(String value) {
            addCriterion("guest_team2 >=", value, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2LessThan(String value) {
            addCriterion("guest_team2 <", value, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2LessThanOrEqualTo(String value) {
            addCriterion("guest_team2 <=", value, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2Like(String value) {
            addCriterion("guest_team2 like", value, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2NotLike(String value) {
            addCriterion("guest_team2 not like", value, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2In(List<String> values) {
            addCriterion("guest_team2 in", values, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2NotIn(List<String> values) {
            addCriterion("guest_team2 not in", values, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2Between(String value1, String value2) {
            addCriterion("guest_team2 between", value1, value2, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andGuestTeam2NotBetween(String value1, String value2) {
            addCriterion("guest_team2 not between", value1, value2, "guestTeam2");
            return (Criteria) this;
        }

        public Criteria andRecommend2IsNull() {
            addCriterion("recommend2 is null");
            return (Criteria) this;
        }

        public Criteria andRecommend2IsNotNull() {
            addCriterion("recommend2 is not null");
            return (Criteria) this;
        }

        public Criteria andRecommend2EqualTo(String value) {
            addCriterion("recommend2 =", value, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2NotEqualTo(String value) {
            addCriterion("recommend2 <>", value, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2GreaterThan(String value) {
            addCriterion("recommend2 >", value, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2GreaterThanOrEqualTo(String value) {
            addCriterion("recommend2 >=", value, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2LessThan(String value) {
            addCriterion("recommend2 <", value, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2LessThanOrEqualTo(String value) {
            addCriterion("recommend2 <=", value, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2Like(String value) {
            addCriterion("recommend2 like", value, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2NotLike(String value) {
            addCriterion("recommend2 not like", value, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2In(List<String> values) {
            addCriterion("recommend2 in", values, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2NotIn(List<String> values) {
            addCriterion("recommend2 not in", values, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2Between(String value1, String value2) {
            addCriterion("recommend2 between", value1, value2, "recommend2");
            return (Criteria) this;
        }

        public Criteria andRecommend2NotBetween(String value1, String value2) {
            addCriterion("recommend2 not between", value1, value2, "recommend2");
            return (Criteria) this;
        }

        public Criteria andMultipleIsNull() {
            addCriterion("multiple is null");
            return (Criteria) this;
        }

        public Criteria andMultipleIsNotNull() {
            addCriterion("multiple is not null");
            return (Criteria) this;
        }

        public Criteria andMultipleEqualTo(Integer value) {
            addCriterion("multiple =", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotEqualTo(Integer value) {
            addCriterion("multiple <>", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThan(Integer value) {
            addCriterion("multiple >", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThanOrEqualTo(Integer value) {
            addCriterion("multiple >=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThan(Integer value) {
            addCriterion("multiple <", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThanOrEqualTo(Integer value) {
            addCriterion("multiple <=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleIn(List<Integer> values) {
            addCriterion("multiple in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotIn(List<Integer> values) {
            addCriterion("multiple not in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleBetween(Integer value1, Integer value2) {
            addCriterion("multiple between", value1, value2, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotBetween(Integer value1, Integer value2) {
            addCriterion("multiple not between", value1, value2, "multiple");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andBonusIsNull() {
            addCriterion("bonus is null");
            return (Criteria) this;
        }

        public Criteria andBonusIsNotNull() {
            addCriterion("bonus is not null");
            return (Criteria) this;
        }

        public Criteria andBonusEqualTo(String value) {
            addCriterion("bonus =", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotEqualTo(String value) {
            addCriterion("bonus <>", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThan(String value) {
            addCriterion("bonus >", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThanOrEqualTo(String value) {
            addCriterion("bonus >=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThan(String value) {
            addCriterion("bonus <", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThanOrEqualTo(String value) {
            addCriterion("bonus <=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLike(String value) {
            addCriterion("bonus like", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotLike(String value) {
            addCriterion("bonus not like", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusIn(List<String> values) {
            addCriterion("bonus in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotIn(List<String> values) {
            addCriterion("bonus not in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusBetween(String value1, String value2) {
            addCriterion("bonus between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotBetween(String value1, String value2) {
            addCriterion("bonus not between", value1, value2, "bonus");
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

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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