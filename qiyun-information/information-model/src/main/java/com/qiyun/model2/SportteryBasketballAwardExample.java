package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryBasketballAwardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryBasketballAwardExample() {
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

        public Criteria andAwardofwinorbigIsNull() {
            addCriterion("awardOfWinOrBig is null");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigIsNotNull() {
            addCriterion("awardOfWinOrBig is not null");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigEqualTo(Double value) {
            addCriterion("awardOfWinOrBig =", value, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigNotEqualTo(Double value) {
            addCriterion("awardOfWinOrBig <>", value, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigGreaterThan(Double value) {
            addCriterion("awardOfWinOrBig >", value, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigGreaterThanOrEqualTo(Double value) {
            addCriterion("awardOfWinOrBig >=", value, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigLessThan(Double value) {
            addCriterion("awardOfWinOrBig <", value, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigLessThanOrEqualTo(Double value) {
            addCriterion("awardOfWinOrBig <=", value, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigIn(List<Double> values) {
            addCriterion("awardOfWinOrBig in", values, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigNotIn(List<Double> values) {
            addCriterion("awardOfWinOrBig not in", values, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigBetween(Double value1, Double value2) {
            addCriterion("awardOfWinOrBig between", value1, value2, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofwinorbigNotBetween(Double value1, Double value2) {
            addCriterion("awardOfWinOrBig not between", value1, value2, "awardofwinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigIsNull() {
            addCriterion("change_winOrBig is null");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigIsNotNull() {
            addCriterion("change_winOrBig is not null");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigEqualTo(Integer value) {
            addCriterion("change_winOrBig =", value, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigNotEqualTo(Integer value) {
            addCriterion("change_winOrBig <>", value, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigGreaterThan(Integer value) {
            addCriterion("change_winOrBig >", value, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_winOrBig >=", value, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigLessThan(Integer value) {
            addCriterion("change_winOrBig <", value, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigLessThanOrEqualTo(Integer value) {
            addCriterion("change_winOrBig <=", value, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigIn(List<Integer> values) {
            addCriterion("change_winOrBig in", values, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigNotIn(List<Integer> values) {
            addCriterion("change_winOrBig not in", values, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigBetween(Integer value1, Integer value2) {
            addCriterion("change_winOrBig between", value1, value2, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andChangeWinorbigNotBetween(Integer value1, Integer value2) {
            addCriterion("change_winOrBig not between", value1, value2, "changeWinorbig");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallIsNull() {
            addCriterion("awardOfLoseOrSmall is null");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallIsNotNull() {
            addCriterion("awardOfLoseOrSmall is not null");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallEqualTo(Double value) {
            addCriterion("awardOfLoseOrSmall =", value, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallNotEqualTo(Double value) {
            addCriterion("awardOfLoseOrSmall <>", value, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallGreaterThan(Double value) {
            addCriterion("awardOfLoseOrSmall >", value, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallGreaterThanOrEqualTo(Double value) {
            addCriterion("awardOfLoseOrSmall >=", value, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallLessThan(Double value) {
            addCriterion("awardOfLoseOrSmall <", value, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallLessThanOrEqualTo(Double value) {
            addCriterion("awardOfLoseOrSmall <=", value, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallIn(List<Double> values) {
            addCriterion("awardOfLoseOrSmall in", values, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallNotIn(List<Double> values) {
            addCriterion("awardOfLoseOrSmall not in", values, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallBetween(Double value1, Double value2) {
            addCriterion("awardOfLoseOrSmall between", value1, value2, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andAwardofloseorsmallNotBetween(Double value1, Double value2) {
            addCriterion("awardOfLoseOrSmall not between", value1, value2, "awardofloseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallIsNull() {
            addCriterion("change_loseOrSmall is null");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallIsNotNull() {
            addCriterion("change_loseOrSmall is not null");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallEqualTo(Integer value) {
            addCriterion("change_loseOrSmall =", value, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallNotEqualTo(Integer value) {
            addCriterion("change_loseOrSmall <>", value, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallGreaterThan(Integer value) {
            addCriterion("change_loseOrSmall >", value, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_loseOrSmall >=", value, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallLessThan(Integer value) {
            addCriterion("change_loseOrSmall <", value, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallLessThanOrEqualTo(Integer value) {
            addCriterion("change_loseOrSmall <=", value, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallIn(List<Integer> values) {
            addCriterion("change_loseOrSmall in", values, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallNotIn(List<Integer> values) {
            addCriterion("change_loseOrSmall not in", values, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallBetween(Integer value1, Integer value2) {
            addCriterion("change_loseOrSmall between", value1, value2, "changeLoseorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeLoseorsmallNotBetween(Integer value1, Integer value2) {
            addCriterion("change_loseOrSmall not between", value1, value2, "changeLoseorsmall");
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

        public Criteria andHandicapIsNull() {
            addCriterion("handicap is null");
            return (Criteria) this;
        }

        public Criteria andHandicapIsNotNull() {
            addCriterion("handicap is not null");
            return (Criteria) this;
        }

        public Criteria andHandicapEqualTo(Double value) {
            addCriterion("handicap =", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotEqualTo(Double value) {
            addCriterion("handicap <>", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapGreaterThan(Double value) {
            addCriterion("handicap >", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapGreaterThanOrEqualTo(Double value) {
            addCriterion("handicap >=", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLessThan(Double value) {
            addCriterion("handicap <", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLessThanOrEqualTo(Double value) {
            addCriterion("handicap <=", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapIn(List<Double> values) {
            addCriterion("handicap in", values, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotIn(List<Double> values) {
            addCriterion("handicap not in", values, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapBetween(Double value1, Double value2) {
            addCriterion("handicap between", value1, value2, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotBetween(Double value1, Double value2) {
            addCriterion("handicap not between", value1, value2, "handicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapIsNull() {
            addCriterion("change_handicap is null");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapIsNotNull() {
            addCriterion("change_handicap is not null");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapEqualTo(Integer value) {
            addCriterion("change_handicap =", value, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapNotEqualTo(Integer value) {
            addCriterion("change_handicap <>", value, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapGreaterThan(Integer value) {
            addCriterion("change_handicap >", value, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_handicap >=", value, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapLessThan(Integer value) {
            addCriterion("change_handicap <", value, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapLessThanOrEqualTo(Integer value) {
            addCriterion("change_handicap <=", value, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapIn(List<Integer> values) {
            addCriterion("change_handicap in", values, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapNotIn(List<Integer> values) {
            addCriterion("change_handicap not in", values, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapBetween(Integer value1, Integer value2) {
            addCriterion("change_handicap between", value1, value2, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andChangeHandicapNotBetween(Integer value1, Integer value2) {
            addCriterion("change_handicap not between", value1, value2, "changeHandicap");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeIsNull() {
            addCriterion("handUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeIsNotNull() {
            addCriterion("handUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeEqualTo(Date value) {
            addCriterion("handUpdateTime =", value, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeNotEqualTo(Date value) {
            addCriterion("handUpdateTime <>", value, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeGreaterThan(Date value) {
            addCriterion("handUpdateTime >", value, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handUpdateTime >=", value, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeLessThan(Date value) {
            addCriterion("handUpdateTime <", value, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("handUpdateTime <=", value, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeIn(List<Date> values) {
            addCriterion("handUpdateTime in", values, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeNotIn(List<Date> values) {
            addCriterion("handUpdateTime not in", values, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeBetween(Date value1, Date value2) {
            addCriterion("handUpdateTime between", value1, value2, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andHandupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("handUpdateTime not between", value1, value2, "handupdatetime");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallIsNull() {
            addCriterion("baseBigOrSmall is null");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallIsNotNull() {
            addCriterion("baseBigOrSmall is not null");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallEqualTo(Double value) {
            addCriterion("baseBigOrSmall =", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallNotEqualTo(Double value) {
            addCriterion("baseBigOrSmall <>", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallGreaterThan(Double value) {
            addCriterion("baseBigOrSmall >", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallGreaterThanOrEqualTo(Double value) {
            addCriterion("baseBigOrSmall >=", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallLessThan(Double value) {
            addCriterion("baseBigOrSmall <", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallLessThanOrEqualTo(Double value) {
            addCriterion("baseBigOrSmall <=", value, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallIn(List<Double> values) {
            addCriterion("baseBigOrSmall in", values, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallNotIn(List<Double> values) {
            addCriterion("baseBigOrSmall not in", values, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallBetween(Double value1, Double value2) {
            addCriterion("baseBigOrSmall between", value1, value2, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andBasebigorsmallNotBetween(Double value1, Double value2) {
            addCriterion("baseBigOrSmall not between", value1, value2, "basebigorsmall");
            return (Criteria) this;
        }

        public Criteria andChangeBsIsNull() {
            addCriterion("change_bs is null");
            return (Criteria) this;
        }

        public Criteria andChangeBsIsNotNull() {
            addCriterion("change_bs is not null");
            return (Criteria) this;
        }

        public Criteria andChangeBsEqualTo(Integer value) {
            addCriterion("change_bs =", value, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsNotEqualTo(Integer value) {
            addCriterion("change_bs <>", value, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsGreaterThan(Integer value) {
            addCriterion("change_bs >", value, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_bs >=", value, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsLessThan(Integer value) {
            addCriterion("change_bs <", value, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsLessThanOrEqualTo(Integer value) {
            addCriterion("change_bs <=", value, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsIn(List<Integer> values) {
            addCriterion("change_bs in", values, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsNotIn(List<Integer> values) {
            addCriterion("change_bs not in", values, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsBetween(Integer value1, Integer value2) {
            addCriterion("change_bs between", value1, value2, "changeBs");
            return (Criteria) this;
        }

        public Criteria andChangeBsNotBetween(Integer value1, Integer value2) {
            addCriterion("change_bs not between", value1, value2, "changeBs");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeIsNull() {
            addCriterion("bsUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeIsNotNull() {
            addCriterion("bsUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeEqualTo(Date value) {
            addCriterion("bsUpdateTime =", value, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeNotEqualTo(Date value) {
            addCriterion("bsUpdateTime <>", value, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeGreaterThan(Date value) {
            addCriterion("bsUpdateTime >", value, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bsUpdateTime >=", value, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeLessThan(Date value) {
            addCriterion("bsUpdateTime <", value, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("bsUpdateTime <=", value, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeIn(List<Date> values) {
            addCriterion("bsUpdateTime in", values, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeNotIn(List<Date> values) {
            addCriterion("bsUpdateTime not in", values, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeBetween(Date value1, Date value2) {
            addCriterion("bsUpdateTime between", value1, value2, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andBsupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("bsUpdateTime not between", value1, value2, "bsupdatetime");
            return (Criteria) this;
        }

        public Criteria andPlaytypeIsNull() {
            addCriterion("playType is null");
            return (Criteria) this;
        }

        public Criteria andPlaytypeIsNotNull() {
            addCriterion("playType is not null");
            return (Criteria) this;
        }

        public Criteria andPlaytypeEqualTo(Integer value) {
            addCriterion("playType =", value, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeNotEqualTo(Integer value) {
            addCriterion("playType <>", value, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeGreaterThan(Integer value) {
            addCriterion("playType >", value, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("playType >=", value, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeLessThan(Integer value) {
            addCriterion("playType <", value, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeLessThanOrEqualTo(Integer value) {
            addCriterion("playType <=", value, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeIn(List<Integer> values) {
            addCriterion("playType in", values, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeNotIn(List<Integer> values) {
            addCriterion("playType not in", values, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeBetween(Integer value1, Integer value2) {
            addCriterion("playType between", value1, value2, "playtype");
            return (Criteria) this;
        }

        public Criteria andPlaytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("playType not between", value1, value2, "playtype");
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