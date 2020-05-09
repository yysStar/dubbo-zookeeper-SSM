package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatchBetMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MatchBetMappingExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLotteryNameIsNull() {
            addCriterion("lottery_name is null");
            return (Criteria) this;
        }

        public Criteria andLotteryNameIsNotNull() {
            addCriterion("lottery_name is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryNameEqualTo(String value) {
            addCriterion("lottery_name =", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotEqualTo(String value) {
            addCriterion("lottery_name <>", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameGreaterThan(String value) {
            addCriterion("lottery_name >", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_name >=", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLessThan(String value) {
            addCriterion("lottery_name <", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLessThanOrEqualTo(String value) {
            addCriterion("lottery_name <=", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLike(String value) {
            addCriterion("lottery_name like", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotLike(String value) {
            addCriterion("lottery_name not like", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameIn(List<String> values) {
            addCriterion("lottery_name in", values, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotIn(List<String> values) {
            addCriterion("lottery_name not in", values, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameBetween(String value1, String value2) {
            addCriterion("lottery_name between", value1, value2, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotBetween(String value1, String value2) {
            addCriterion("lottery_name not between", value1, value2, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andIsSueNumIsNull() {
            addCriterion("is_sue_num is null");
            return (Criteria) this;
        }

        public Criteria andIsSueNumIsNotNull() {
            addCriterion("is_sue_num is not null");
            return (Criteria) this;
        }

        public Criteria andIsSueNumEqualTo(String value) {
            addCriterion("is_sue_num =", value, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumNotEqualTo(String value) {
            addCriterion("is_sue_num <>", value, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumGreaterThan(String value) {
            addCriterion("is_sue_num >", value, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumGreaterThanOrEqualTo(String value) {
            addCriterion("is_sue_num >=", value, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumLessThan(String value) {
            addCriterion("is_sue_num <", value, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumLessThanOrEqualTo(String value) {
            addCriterion("is_sue_num <=", value, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumLike(String value) {
            addCriterion("is_sue_num like", value, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumNotLike(String value) {
            addCriterion("is_sue_num not like", value, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumIn(List<String> values) {
            addCriterion("is_sue_num in", values, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumNotIn(List<String> values) {
            addCriterion("is_sue_num not in", values, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumBetween(String value1, String value2) {
            addCriterion("is_sue_num between", value1, value2, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIsSueNumNotBetween(String value1, String value2) {
            addCriterion("is_sue_num not between", value1, value2, "isSueNum");
            return (Criteria) this;
        }

        public Criteria andIdBetIsNull() {
            addCriterion("id_bet is null");
            return (Criteria) this;
        }

        public Criteria andIdBetIsNotNull() {
            addCriterion("id_bet is not null");
            return (Criteria) this;
        }

        public Criteria andIdBetEqualTo(String value) {
            addCriterion("id_bet =", value, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetNotEqualTo(String value) {
            addCriterion("id_bet <>", value, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetGreaterThan(String value) {
            addCriterion("id_bet >", value, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetGreaterThanOrEqualTo(String value) {
            addCriterion("id_bet >=", value, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetLessThan(String value) {
            addCriterion("id_bet <", value, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetLessThanOrEqualTo(String value) {
            addCriterion("id_bet <=", value, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetLike(String value) {
            addCriterion("id_bet like", value, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetNotLike(String value) {
            addCriterion("id_bet not like", value, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetIn(List<String> values) {
            addCriterion("id_bet in", values, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetNotIn(List<String> values) {
            addCriterion("id_bet not in", values, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetBetween(String value1, String value2) {
            addCriterion("id_bet between", value1, value2, "idBet");
            return (Criteria) this;
        }

        public Criteria andIdBetNotBetween(String value1, String value2) {
            addCriterion("id_bet not between", value1, value2, "idBet");
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

        public Criteria andSportIsNull() {
            addCriterion("sport is null");
            return (Criteria) this;
        }

        public Criteria andSportIsNotNull() {
            addCriterion("sport is not null");
            return (Criteria) this;
        }

        public Criteria andSportEqualTo(String value) {
            addCriterion("sport =", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotEqualTo(String value) {
            addCriterion("sport <>", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportGreaterThan(String value) {
            addCriterion("sport >", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportGreaterThanOrEqualTo(String value) {
            addCriterion("sport >=", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportLessThan(String value) {
            addCriterion("sport <", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportLessThanOrEqualTo(String value) {
            addCriterion("sport <=", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportLike(String value) {
            addCriterion("sport like", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotLike(String value) {
            addCriterion("sport not like", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportIn(List<String> values) {
            addCriterion("sport in", values, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotIn(List<String> values) {
            addCriterion("sport not in", values, "sport");
            return (Criteria) this;
        }

        public Criteria andSportBetween(String value1, String value2) {
            addCriterion("sport between", value1, value2, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotBetween(String value1, String value2) {
            addCriterion("sport not between", value1, value2, "sport");
            return (Criteria) this;
        }

        public Criteria andHomeIsNull() {
            addCriterion("home is null");
            return (Criteria) this;
        }

        public Criteria andHomeIsNotNull() {
            addCriterion("home is not null");
            return (Criteria) this;
        }

        public Criteria andHomeEqualTo(String value) {
            addCriterion("home =", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeNotEqualTo(String value) {
            addCriterion("home <>", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeGreaterThan(String value) {
            addCriterion("home >", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeGreaterThanOrEqualTo(String value) {
            addCriterion("home >=", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeLessThan(String value) {
            addCriterion("home <", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeLessThanOrEqualTo(String value) {
            addCriterion("home <=", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeLike(String value) {
            addCriterion("home like", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeNotLike(String value) {
            addCriterion("home not like", value, "home");
            return (Criteria) this;
        }

        public Criteria andHomeIn(List<String> values) {
            addCriterion("home in", values, "home");
            return (Criteria) this;
        }

        public Criteria andHomeNotIn(List<String> values) {
            addCriterion("home not in", values, "home");
            return (Criteria) this;
        }

        public Criteria andHomeBetween(String value1, String value2) {
            addCriterion("home between", value1, value2, "home");
            return (Criteria) this;
        }

        public Criteria andHomeNotBetween(String value1, String value2) {
            addCriterion("home not between", value1, value2, "home");
            return (Criteria) this;
        }

        public Criteria andAwayIsNull() {
            addCriterion("away is null");
            return (Criteria) this;
        }

        public Criteria andAwayIsNotNull() {
            addCriterion("away is not null");
            return (Criteria) this;
        }

        public Criteria andAwayEqualTo(String value) {
            addCriterion("away =", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayNotEqualTo(String value) {
            addCriterion("away <>", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayGreaterThan(String value) {
            addCriterion("away >", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayGreaterThanOrEqualTo(String value) {
            addCriterion("away >=", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayLessThan(String value) {
            addCriterion("away <", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayLessThanOrEqualTo(String value) {
            addCriterion("away <=", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayLike(String value) {
            addCriterion("away like", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayNotLike(String value) {
            addCriterion("away not like", value, "away");
            return (Criteria) this;
        }

        public Criteria andAwayIn(List<String> values) {
            addCriterion("away in", values, "away");
            return (Criteria) this;
        }

        public Criteria andAwayNotIn(List<String> values) {
            addCriterion("away not in", values, "away");
            return (Criteria) this;
        }

        public Criteria andAwayBetween(String value1, String value2) {
            addCriterion("away between", value1, value2, "away");
            return (Criteria) this;
        }

        public Criteria andAwayNotBetween(String value1, String value2) {
            addCriterion("away not between", value1, value2, "away");
            return (Criteria) this;
        }

        public Criteria andHomeIdIsNull() {
            addCriterion("home_id is null");
            return (Criteria) this;
        }

        public Criteria andHomeIdIsNotNull() {
            addCriterion("home_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomeIdEqualTo(String value) {
            addCriterion("home_id =", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotEqualTo(String value) {
            addCriterion("home_id <>", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdGreaterThan(String value) {
            addCriterion("home_id >", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdGreaterThanOrEqualTo(String value) {
            addCriterion("home_id >=", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLessThan(String value) {
            addCriterion("home_id <", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLessThanOrEqualTo(String value) {
            addCriterion("home_id <=", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdLike(String value) {
            addCriterion("home_id like", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotLike(String value) {
            addCriterion("home_id not like", value, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdIn(List<String> values) {
            addCriterion("home_id in", values, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotIn(List<String> values) {
            addCriterion("home_id not in", values, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdBetween(String value1, String value2) {
            addCriterion("home_id between", value1, value2, "homeId");
            return (Criteria) this;
        }

        public Criteria andHomeIdNotBetween(String value1, String value2) {
            addCriterion("home_id not between", value1, value2, "homeId");
            return (Criteria) this;
        }

        public Criteria andAwayIdIsNull() {
            addCriterion("away_id is null");
            return (Criteria) this;
        }

        public Criteria andAwayIdIsNotNull() {
            addCriterion("away_id is not null");
            return (Criteria) this;
        }

        public Criteria andAwayIdEqualTo(String value) {
            addCriterion("away_id =", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdNotEqualTo(String value) {
            addCriterion("away_id <>", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdGreaterThan(String value) {
            addCriterion("away_id >", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdGreaterThanOrEqualTo(String value) {
            addCriterion("away_id >=", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdLessThan(String value) {
            addCriterion("away_id <", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdLessThanOrEqualTo(String value) {
            addCriterion("away_id <=", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdLike(String value) {
            addCriterion("away_id like", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdNotLike(String value) {
            addCriterion("away_id not like", value, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdIn(List<String> values) {
            addCriterion("away_id in", values, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdNotIn(List<String> values) {
            addCriterion("away_id not in", values, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdBetween(String value1, String value2) {
            addCriterion("away_id between", value1, value2, "awayId");
            return (Criteria) this;
        }

        public Criteria andAwayIdNotBetween(String value1, String value2) {
            addCriterion("away_id not between", value1, value2, "awayId");
            return (Criteria) this;
        }

        public Criteria andTurnIsNull() {
            addCriterion("turn is null");
            return (Criteria) this;
        }

        public Criteria andTurnIsNotNull() {
            addCriterion("turn is not null");
            return (Criteria) this;
        }

        public Criteria andTurnEqualTo(String value) {
            addCriterion("turn =", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnNotEqualTo(String value) {
            addCriterion("turn <>", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnGreaterThan(String value) {
            addCriterion("turn >", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnGreaterThanOrEqualTo(String value) {
            addCriterion("turn >=", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnLessThan(String value) {
            addCriterion("turn <", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnLessThanOrEqualTo(String value) {
            addCriterion("turn <=", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnLike(String value) {
            addCriterion("turn like", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnNotLike(String value) {
            addCriterion("turn not like", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnIn(List<String> values) {
            addCriterion("turn in", values, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnNotIn(List<String> values) {
            addCriterion("turn not in", values, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnBetween(String value1, String value2) {
            addCriterion("turn between", value1, value2, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnNotBetween(String value1, String value2) {
            addCriterion("turn not between", value1, value2, "turn");
            return (Criteria) this;
        }

        public Criteria andLeagueIsNull() {
            addCriterion("league is null");
            return (Criteria) this;
        }

        public Criteria andLeagueIsNotNull() {
            addCriterion("league is not null");
            return (Criteria) this;
        }

        public Criteria andLeagueEqualTo(String value) {
            addCriterion("league =", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueNotEqualTo(String value) {
            addCriterion("league <>", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueGreaterThan(String value) {
            addCriterion("league >", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueGreaterThanOrEqualTo(String value) {
            addCriterion("league >=", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueLessThan(String value) {
            addCriterion("league <", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueLessThanOrEqualTo(String value) {
            addCriterion("league <=", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueLike(String value) {
            addCriterion("league like", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueNotLike(String value) {
            addCriterion("league not like", value, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueIn(List<String> values) {
            addCriterion("league in", values, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueNotIn(List<String> values) {
            addCriterion("league not in", values, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueBetween(String value1, String value2) {
            addCriterion("league between", value1, value2, "league");
            return (Criteria) this;
        }

        public Criteria andLeagueNotBetween(String value1, String value2) {
            addCriterion("league not between", value1, value2, "league");
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