package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class BasketballTeamRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasketballTeamRankExample() {
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

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(String value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(String value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(String value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(String value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(String value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(String value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLike(String value) {
            addCriterion("team_id like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotLike(String value) {
            addCriterion("team_id not like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<String> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<String> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(String value1, String value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(String value1, String value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonIsNull() {
            addCriterion("match_season is null");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonIsNotNull() {
            addCriterion("match_season is not null");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonEqualTo(String value) {
            addCriterion("match_season =", value, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonNotEqualTo(String value) {
            addCriterion("match_season <>", value, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonGreaterThan(String value) {
            addCriterion("match_season >", value, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonGreaterThanOrEqualTo(String value) {
            addCriterion("match_season >=", value, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonLessThan(String value) {
            addCriterion("match_season <", value, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonLessThanOrEqualTo(String value) {
            addCriterion("match_season <=", value, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonLike(String value) {
            addCriterion("match_season like", value, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonNotLike(String value) {
            addCriterion("match_season not like", value, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonIn(List<String> values) {
            addCriterion("match_season in", values, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonNotIn(List<String> values) {
            addCriterion("match_season not in", values, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonBetween(String value1, String value2) {
            addCriterion("match_season between", value1, value2, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andMatchSeasonNotBetween(String value1, String value2) {
            addCriterion("match_season not between", value1, value2, "matchSeason");
            return (Criteria) this;
        }

        public Criteria andHomeWinIsNull() {
            addCriterion("home_win is null");
            return (Criteria) this;
        }

        public Criteria andHomeWinIsNotNull() {
            addCriterion("home_win is not null");
            return (Criteria) this;
        }

        public Criteria andHomeWinEqualTo(String value) {
            addCriterion("home_win =", value, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinNotEqualTo(String value) {
            addCriterion("home_win <>", value, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinGreaterThan(String value) {
            addCriterion("home_win >", value, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinGreaterThanOrEqualTo(String value) {
            addCriterion("home_win >=", value, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinLessThan(String value) {
            addCriterion("home_win <", value, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinLessThanOrEqualTo(String value) {
            addCriterion("home_win <=", value, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinLike(String value) {
            addCriterion("home_win like", value, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinNotLike(String value) {
            addCriterion("home_win not like", value, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinIn(List<String> values) {
            addCriterion("home_win in", values, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinNotIn(List<String> values) {
            addCriterion("home_win not in", values, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinBetween(String value1, String value2) {
            addCriterion("home_win between", value1, value2, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeWinNotBetween(String value1, String value2) {
            addCriterion("home_win not between", value1, value2, "homeWin");
            return (Criteria) this;
        }

        public Criteria andHomeLossIsNull() {
            addCriterion("home_loss is null");
            return (Criteria) this;
        }

        public Criteria andHomeLossIsNotNull() {
            addCriterion("home_loss is not null");
            return (Criteria) this;
        }

        public Criteria andHomeLossEqualTo(String value) {
            addCriterion("home_loss =", value, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossNotEqualTo(String value) {
            addCriterion("home_loss <>", value, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossGreaterThan(String value) {
            addCriterion("home_loss >", value, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossGreaterThanOrEqualTo(String value) {
            addCriterion("home_loss >=", value, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossLessThan(String value) {
            addCriterion("home_loss <", value, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossLessThanOrEqualTo(String value) {
            addCriterion("home_loss <=", value, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossLike(String value) {
            addCriterion("home_loss like", value, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossNotLike(String value) {
            addCriterion("home_loss not like", value, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossIn(List<String> values) {
            addCriterion("home_loss in", values, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossNotIn(List<String> values) {
            addCriterion("home_loss not in", values, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossBetween(String value1, String value2) {
            addCriterion("home_loss between", value1, value2, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andHomeLossNotBetween(String value1, String value2) {
            addCriterion("home_loss not between", value1, value2, "homeLoss");
            return (Criteria) this;
        }

        public Criteria andAwayWinIsNull() {
            addCriterion("away_win is null");
            return (Criteria) this;
        }

        public Criteria andAwayWinIsNotNull() {
            addCriterion("away_win is not null");
            return (Criteria) this;
        }

        public Criteria andAwayWinEqualTo(String value) {
            addCriterion("away_win =", value, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinNotEqualTo(String value) {
            addCriterion("away_win <>", value, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinGreaterThan(String value) {
            addCriterion("away_win >", value, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinGreaterThanOrEqualTo(String value) {
            addCriterion("away_win >=", value, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinLessThan(String value) {
            addCriterion("away_win <", value, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinLessThanOrEqualTo(String value) {
            addCriterion("away_win <=", value, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinLike(String value) {
            addCriterion("away_win like", value, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinNotLike(String value) {
            addCriterion("away_win not like", value, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinIn(List<String> values) {
            addCriterion("away_win in", values, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinNotIn(List<String> values) {
            addCriterion("away_win not in", values, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinBetween(String value1, String value2) {
            addCriterion("away_win between", value1, value2, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayWinNotBetween(String value1, String value2) {
            addCriterion("away_win not between", value1, value2, "awayWin");
            return (Criteria) this;
        }

        public Criteria andAwayLossIsNull() {
            addCriterion("away_loss is null");
            return (Criteria) this;
        }

        public Criteria andAwayLossIsNotNull() {
            addCriterion("away_loss is not null");
            return (Criteria) this;
        }

        public Criteria andAwayLossEqualTo(String value) {
            addCriterion("away_loss =", value, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossNotEqualTo(String value) {
            addCriterion("away_loss <>", value, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossGreaterThan(String value) {
            addCriterion("away_loss >", value, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossGreaterThanOrEqualTo(String value) {
            addCriterion("away_loss >=", value, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossLessThan(String value) {
            addCriterion("away_loss <", value, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossLessThanOrEqualTo(String value) {
            addCriterion("away_loss <=", value, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossLike(String value) {
            addCriterion("away_loss like", value, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossNotLike(String value) {
            addCriterion("away_loss not like", value, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossIn(List<String> values) {
            addCriterion("away_loss in", values, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossNotIn(List<String> values) {
            addCriterion("away_loss not in", values, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossBetween(String value1, String value2) {
            addCriterion("away_loss between", value1, value2, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andAwayLossNotBetween(String value1, String value2) {
            addCriterion("away_loss not between", value1, value2, "awayLoss");
            return (Criteria) this;
        }

        public Criteria andWinScaleIsNull() {
            addCriterion("win_scale is null");
            return (Criteria) this;
        }

        public Criteria andWinScaleIsNotNull() {
            addCriterion("win_scale is not null");
            return (Criteria) this;
        }

        public Criteria andWinScaleEqualTo(String value) {
            addCriterion("win_scale =", value, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleNotEqualTo(String value) {
            addCriterion("win_scale <>", value, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleGreaterThan(String value) {
            addCriterion("win_scale >", value, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleGreaterThanOrEqualTo(String value) {
            addCriterion("win_scale >=", value, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleLessThan(String value) {
            addCriterion("win_scale <", value, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleLessThanOrEqualTo(String value) {
            addCriterion("win_scale <=", value, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleLike(String value) {
            addCriterion("win_scale like", value, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleNotLike(String value) {
            addCriterion("win_scale not like", value, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleIn(List<String> values) {
            addCriterion("win_scale in", values, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleNotIn(List<String> values) {
            addCriterion("win_scale not in", values, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleBetween(String value1, String value2) {
            addCriterion("win_scale between", value1, value2, "winScale");
            return (Criteria) this;
        }

        public Criteria andWinScaleNotBetween(String value1, String value2) {
            addCriterion("win_scale not between", value1, value2, "winScale");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andHomeOrderIsNull() {
            addCriterion("home_order is null");
            return (Criteria) this;
        }

        public Criteria andHomeOrderIsNotNull() {
            addCriterion("home_order is not null");
            return (Criteria) this;
        }

        public Criteria andHomeOrderEqualTo(String value) {
            addCriterion("home_order =", value, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderNotEqualTo(String value) {
            addCriterion("home_order <>", value, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderGreaterThan(String value) {
            addCriterion("home_order >", value, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderGreaterThanOrEqualTo(String value) {
            addCriterion("home_order >=", value, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderLessThan(String value) {
            addCriterion("home_order <", value, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderLessThanOrEqualTo(String value) {
            addCriterion("home_order <=", value, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderLike(String value) {
            addCriterion("home_order like", value, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderNotLike(String value) {
            addCriterion("home_order not like", value, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderIn(List<String> values) {
            addCriterion("home_order in", values, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderNotIn(List<String> values) {
            addCriterion("home_order not in", values, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderBetween(String value1, String value2) {
            addCriterion("home_order between", value1, value2, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andHomeOrderNotBetween(String value1, String value2) {
            addCriterion("home_order not between", value1, value2, "homeOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderIsNull() {
            addCriterion("away_order is null");
            return (Criteria) this;
        }

        public Criteria andAwayOrderIsNotNull() {
            addCriterion("away_order is not null");
            return (Criteria) this;
        }

        public Criteria andAwayOrderEqualTo(String value) {
            addCriterion("away_order =", value, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderNotEqualTo(String value) {
            addCriterion("away_order <>", value, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderGreaterThan(String value) {
            addCriterion("away_order >", value, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderGreaterThanOrEqualTo(String value) {
            addCriterion("away_order >=", value, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderLessThan(String value) {
            addCriterion("away_order <", value, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderLessThanOrEqualTo(String value) {
            addCriterion("away_order <=", value, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderLike(String value) {
            addCriterion("away_order like", value, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderNotLike(String value) {
            addCriterion("away_order not like", value, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderIn(List<String> values) {
            addCriterion("away_order in", values, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderNotIn(List<String> values) {
            addCriterion("away_order not in", values, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderBetween(String value1, String value2) {
            addCriterion("away_order between", value1, value2, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andAwayOrderNotBetween(String value1, String value2) {
            addCriterion("away_order not between", value1, value2, "awayOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderIsNull() {
            addCriterion("total_order is null");
            return (Criteria) this;
        }

        public Criteria andTotalOrderIsNotNull() {
            addCriterion("total_order is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOrderEqualTo(String value) {
            addCriterion("total_order =", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderNotEqualTo(String value) {
            addCriterion("total_order <>", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderGreaterThan(String value) {
            addCriterion("total_order >", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderGreaterThanOrEqualTo(String value) {
            addCriterion("total_order >=", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderLessThan(String value) {
            addCriterion("total_order <", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderLessThanOrEqualTo(String value) {
            addCriterion("total_order <=", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderLike(String value) {
            addCriterion("total_order like", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderNotLike(String value) {
            addCriterion("total_order not like", value, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderIn(List<String> values) {
            addCriterion("total_order in", values, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderNotIn(List<String> values) {
            addCriterion("total_order not in", values, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderBetween(String value1, String value2) {
            addCriterion("total_order between", value1, value2, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andTotalOrderNotBetween(String value1, String value2) {
            addCriterion("total_order not between", value1, value2, "totalOrder");
            return (Criteria) this;
        }

        public Criteria andHomeScoreIsNull() {
            addCriterion("home_score is null");
            return (Criteria) this;
        }

        public Criteria andHomeScoreIsNotNull() {
            addCriterion("home_score is not null");
            return (Criteria) this;
        }

        public Criteria andHomeScoreEqualTo(String value) {
            addCriterion("home_score =", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreNotEqualTo(String value) {
            addCriterion("home_score <>", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreGreaterThan(String value) {
            addCriterion("home_score >", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreGreaterThanOrEqualTo(String value) {
            addCriterion("home_score >=", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreLessThan(String value) {
            addCriterion("home_score <", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreLessThanOrEqualTo(String value) {
            addCriterion("home_score <=", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreLike(String value) {
            addCriterion("home_score like", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreNotLike(String value) {
            addCriterion("home_score not like", value, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreIn(List<String> values) {
            addCriterion("home_score in", values, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreNotIn(List<String> values) {
            addCriterion("home_score not in", values, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreBetween(String value1, String value2) {
            addCriterion("home_score between", value1, value2, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeScoreNotBetween(String value1, String value2) {
            addCriterion("home_score not between", value1, value2, "homeScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreIsNull() {
            addCriterion("home_loss_score is null");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreIsNotNull() {
            addCriterion("home_loss_score is not null");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreEqualTo(String value) {
            addCriterion("home_loss_score =", value, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreNotEqualTo(String value) {
            addCriterion("home_loss_score <>", value, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreGreaterThan(String value) {
            addCriterion("home_loss_score >", value, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreGreaterThanOrEqualTo(String value) {
            addCriterion("home_loss_score >=", value, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreLessThan(String value) {
            addCriterion("home_loss_score <", value, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreLessThanOrEqualTo(String value) {
            addCriterion("home_loss_score <=", value, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreLike(String value) {
            addCriterion("home_loss_score like", value, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreNotLike(String value) {
            addCriterion("home_loss_score not like", value, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreIn(List<String> values) {
            addCriterion("home_loss_score in", values, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreNotIn(List<String> values) {
            addCriterion("home_loss_score not in", values, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreBetween(String value1, String value2) {
            addCriterion("home_loss_score between", value1, value2, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andHomeLossScoreNotBetween(String value1, String value2) {
            addCriterion("home_loss_score not between", value1, value2, "homeLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreIsNull() {
            addCriterion("away_score is null");
            return (Criteria) this;
        }

        public Criteria andAwayScoreIsNotNull() {
            addCriterion("away_score is not null");
            return (Criteria) this;
        }

        public Criteria andAwayScoreEqualTo(String value) {
            addCriterion("away_score =", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreNotEqualTo(String value) {
            addCriterion("away_score <>", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreGreaterThan(String value) {
            addCriterion("away_score >", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreGreaterThanOrEqualTo(String value) {
            addCriterion("away_score >=", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreLessThan(String value) {
            addCriterion("away_score <", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreLessThanOrEqualTo(String value) {
            addCriterion("away_score <=", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreLike(String value) {
            addCriterion("away_score like", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreNotLike(String value) {
            addCriterion("away_score not like", value, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreIn(List<String> values) {
            addCriterion("away_score in", values, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreNotIn(List<String> values) {
            addCriterion("away_score not in", values, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreBetween(String value1, String value2) {
            addCriterion("away_score between", value1, value2, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayScoreNotBetween(String value1, String value2) {
            addCriterion("away_score not between", value1, value2, "awayScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreIsNull() {
            addCriterion("away_loss_score is null");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreIsNotNull() {
            addCriterion("away_loss_score is not null");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreEqualTo(String value) {
            addCriterion("away_loss_score =", value, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreNotEqualTo(String value) {
            addCriterion("away_loss_score <>", value, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreGreaterThan(String value) {
            addCriterion("away_loss_score >", value, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreGreaterThanOrEqualTo(String value) {
            addCriterion("away_loss_score >=", value, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreLessThan(String value) {
            addCriterion("away_loss_score <", value, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreLessThanOrEqualTo(String value) {
            addCriterion("away_loss_score <=", value, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreLike(String value) {
            addCriterion("away_loss_score like", value, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreNotLike(String value) {
            addCriterion("away_loss_score not like", value, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreIn(List<String> values) {
            addCriterion("away_loss_score in", values, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreNotIn(List<String> values) {
            addCriterion("away_loss_score not in", values, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreBetween(String value1, String value2) {
            addCriterion("away_loss_score between", value1, value2, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andAwayLossScoreNotBetween(String value1, String value2) {
            addCriterion("away_loss_score not between", value1, value2, "awayLossScore");
            return (Criteria) this;
        }

        public Criteria andNear10WinIsNull() {
            addCriterion("near10_win is null");
            return (Criteria) this;
        }

        public Criteria andNear10WinIsNotNull() {
            addCriterion("near10_win is not null");
            return (Criteria) this;
        }

        public Criteria andNear10WinEqualTo(String value) {
            addCriterion("near10_win =", value, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinNotEqualTo(String value) {
            addCriterion("near10_win <>", value, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinGreaterThan(String value) {
            addCriterion("near10_win >", value, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinGreaterThanOrEqualTo(String value) {
            addCriterion("near10_win >=", value, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinLessThan(String value) {
            addCriterion("near10_win <", value, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinLessThanOrEqualTo(String value) {
            addCriterion("near10_win <=", value, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinLike(String value) {
            addCriterion("near10_win like", value, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinNotLike(String value) {
            addCriterion("near10_win not like", value, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinIn(List<String> values) {
            addCriterion("near10_win in", values, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinNotIn(List<String> values) {
            addCriterion("near10_win not in", values, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinBetween(String value1, String value2) {
            addCriterion("near10_win between", value1, value2, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10WinNotBetween(String value1, String value2) {
            addCriterion("near10_win not between", value1, value2, "near10Win");
            return (Criteria) this;
        }

        public Criteria andNear10LossIsNull() {
            addCriterion("near10_loss is null");
            return (Criteria) this;
        }

        public Criteria andNear10LossIsNotNull() {
            addCriterion("near10_loss is not null");
            return (Criteria) this;
        }

        public Criteria andNear10LossEqualTo(String value) {
            addCriterion("near10_loss =", value, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossNotEqualTo(String value) {
            addCriterion("near10_loss <>", value, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossGreaterThan(String value) {
            addCriterion("near10_loss >", value, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossGreaterThanOrEqualTo(String value) {
            addCriterion("near10_loss >=", value, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossLessThan(String value) {
            addCriterion("near10_loss <", value, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossLessThanOrEqualTo(String value) {
            addCriterion("near10_loss <=", value, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossLike(String value) {
            addCriterion("near10_loss like", value, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossNotLike(String value) {
            addCriterion("near10_loss not like", value, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossIn(List<String> values) {
            addCriterion("near10_loss in", values, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossNotIn(List<String> values) {
            addCriterion("near10_loss not in", values, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossBetween(String value1, String value2) {
            addCriterion("near10_loss between", value1, value2, "near10Loss");
            return (Criteria) this;
        }

        public Criteria andNear10LossNotBetween(String value1, String value2) {
            addCriterion("near10_loss not between", value1, value2, "near10Loss");
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