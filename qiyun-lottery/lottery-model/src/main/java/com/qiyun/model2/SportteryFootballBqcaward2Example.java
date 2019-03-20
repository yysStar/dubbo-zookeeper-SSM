package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportteryFootballBqcaward2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportteryFootballBqcaward2Example() {
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

        public Criteria andWinWinAwardIsNull() {
            addCriterion("win_win_award is null");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardIsNotNull() {
            addCriterion("win_win_award is not null");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardEqualTo(Double value) {
            addCriterion("win_win_award =", value, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardNotEqualTo(Double value) {
            addCriterion("win_win_award <>", value, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardGreaterThan(Double value) {
            addCriterion("win_win_award >", value, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("win_win_award >=", value, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardLessThan(Double value) {
            addCriterion("win_win_award <", value, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardLessThanOrEqualTo(Double value) {
            addCriterion("win_win_award <=", value, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardIn(List<Double> values) {
            addCriterion("win_win_award in", values, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardNotIn(List<Double> values) {
            addCriterion("win_win_award not in", values, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardBetween(Double value1, Double value2) {
            addCriterion("win_win_award between", value1, value2, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinWinAwardNotBetween(Double value1, Double value2) {
            addCriterion("win_win_award not between", value1, value2, "winWinAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardIsNull() {
            addCriterion("win_draw_award is null");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardIsNotNull() {
            addCriterion("win_draw_award is not null");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardEqualTo(Double value) {
            addCriterion("win_draw_award =", value, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardNotEqualTo(Double value) {
            addCriterion("win_draw_award <>", value, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardGreaterThan(Double value) {
            addCriterion("win_draw_award >", value, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("win_draw_award >=", value, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardLessThan(Double value) {
            addCriterion("win_draw_award <", value, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardLessThanOrEqualTo(Double value) {
            addCriterion("win_draw_award <=", value, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardIn(List<Double> values) {
            addCriterion("win_draw_award in", values, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardNotIn(List<Double> values) {
            addCriterion("win_draw_award not in", values, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardBetween(Double value1, Double value2) {
            addCriterion("win_draw_award between", value1, value2, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinDrawAwardNotBetween(Double value1, Double value2) {
            addCriterion("win_draw_award not between", value1, value2, "winDrawAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardIsNull() {
            addCriterion("win_lose_award is null");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardIsNotNull() {
            addCriterion("win_lose_award is not null");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardEqualTo(Double value) {
            addCriterion("win_lose_award =", value, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardNotEqualTo(Double value) {
            addCriterion("win_lose_award <>", value, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardGreaterThan(Double value) {
            addCriterion("win_lose_award >", value, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("win_lose_award >=", value, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardLessThan(Double value) {
            addCriterion("win_lose_award <", value, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardLessThanOrEqualTo(Double value) {
            addCriterion("win_lose_award <=", value, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardIn(List<Double> values) {
            addCriterion("win_lose_award in", values, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardNotIn(List<Double> values) {
            addCriterion("win_lose_award not in", values, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardBetween(Double value1, Double value2) {
            addCriterion("win_lose_award between", value1, value2, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andWinLoseAwardNotBetween(Double value1, Double value2) {
            addCriterion("win_lose_award not between", value1, value2, "winLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardIsNull() {
            addCriterion("draw_win_award is null");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardIsNotNull() {
            addCriterion("draw_win_award is not null");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardEqualTo(Double value) {
            addCriterion("draw_win_award =", value, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardNotEqualTo(Double value) {
            addCriterion("draw_win_award <>", value, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardGreaterThan(Double value) {
            addCriterion("draw_win_award >", value, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("draw_win_award >=", value, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardLessThan(Double value) {
            addCriterion("draw_win_award <", value, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardLessThanOrEqualTo(Double value) {
            addCriterion("draw_win_award <=", value, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardIn(List<Double> values) {
            addCriterion("draw_win_award in", values, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardNotIn(List<Double> values) {
            addCriterion("draw_win_award not in", values, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardBetween(Double value1, Double value2) {
            addCriterion("draw_win_award between", value1, value2, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawWinAwardNotBetween(Double value1, Double value2) {
            addCriterion("draw_win_award not between", value1, value2, "drawWinAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardIsNull() {
            addCriterion("draw_draw_award is null");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardIsNotNull() {
            addCriterion("draw_draw_award is not null");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardEqualTo(Double value) {
            addCriterion("draw_draw_award =", value, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardNotEqualTo(Double value) {
            addCriterion("draw_draw_award <>", value, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardGreaterThan(Double value) {
            addCriterion("draw_draw_award >", value, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("draw_draw_award >=", value, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardLessThan(Double value) {
            addCriterion("draw_draw_award <", value, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardLessThanOrEqualTo(Double value) {
            addCriterion("draw_draw_award <=", value, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardIn(List<Double> values) {
            addCriterion("draw_draw_award in", values, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardNotIn(List<Double> values) {
            addCriterion("draw_draw_award not in", values, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardBetween(Double value1, Double value2) {
            addCriterion("draw_draw_award between", value1, value2, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawDrawAwardNotBetween(Double value1, Double value2) {
            addCriterion("draw_draw_award not between", value1, value2, "drawDrawAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardIsNull() {
            addCriterion("draw_lose_award is null");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardIsNotNull() {
            addCriterion("draw_lose_award is not null");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardEqualTo(Double value) {
            addCriterion("draw_lose_award =", value, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardNotEqualTo(Double value) {
            addCriterion("draw_lose_award <>", value, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardGreaterThan(Double value) {
            addCriterion("draw_lose_award >", value, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("draw_lose_award >=", value, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardLessThan(Double value) {
            addCriterion("draw_lose_award <", value, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardLessThanOrEqualTo(Double value) {
            addCriterion("draw_lose_award <=", value, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardIn(List<Double> values) {
            addCriterion("draw_lose_award in", values, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardNotIn(List<Double> values) {
            addCriterion("draw_lose_award not in", values, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardBetween(Double value1, Double value2) {
            addCriterion("draw_lose_award between", value1, value2, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andDrawLoseAwardNotBetween(Double value1, Double value2) {
            addCriterion("draw_lose_award not between", value1, value2, "drawLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardIsNull() {
            addCriterion("lose_win_award is null");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardIsNotNull() {
            addCriterion("lose_win_award is not null");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardEqualTo(Double value) {
            addCriterion("lose_win_award =", value, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardNotEqualTo(Double value) {
            addCriterion("lose_win_award <>", value, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardGreaterThan(Double value) {
            addCriterion("lose_win_award >", value, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("lose_win_award >=", value, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardLessThan(Double value) {
            addCriterion("lose_win_award <", value, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardLessThanOrEqualTo(Double value) {
            addCriterion("lose_win_award <=", value, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardIn(List<Double> values) {
            addCriterion("lose_win_award in", values, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardNotIn(List<Double> values) {
            addCriterion("lose_win_award not in", values, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardBetween(Double value1, Double value2) {
            addCriterion("lose_win_award between", value1, value2, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseWinAwardNotBetween(Double value1, Double value2) {
            addCriterion("lose_win_award not between", value1, value2, "loseWinAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardIsNull() {
            addCriterion("lose_draw_award is null");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardIsNotNull() {
            addCriterion("lose_draw_award is not null");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardEqualTo(Double value) {
            addCriterion("lose_draw_award =", value, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardNotEqualTo(Double value) {
            addCriterion("lose_draw_award <>", value, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardGreaterThan(Double value) {
            addCriterion("lose_draw_award >", value, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("lose_draw_award >=", value, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardLessThan(Double value) {
            addCriterion("lose_draw_award <", value, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardLessThanOrEqualTo(Double value) {
            addCriterion("lose_draw_award <=", value, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardIn(List<Double> values) {
            addCriterion("lose_draw_award in", values, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardNotIn(List<Double> values) {
            addCriterion("lose_draw_award not in", values, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardBetween(Double value1, Double value2) {
            addCriterion("lose_draw_award between", value1, value2, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseDrawAwardNotBetween(Double value1, Double value2) {
            addCriterion("lose_draw_award not between", value1, value2, "loseDrawAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardIsNull() {
            addCriterion("lose_lose_award is null");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardIsNotNull() {
            addCriterion("lose_lose_award is not null");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardEqualTo(Double value) {
            addCriterion("lose_lose_award =", value, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardNotEqualTo(Double value) {
            addCriterion("lose_lose_award <>", value, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardGreaterThan(Double value) {
            addCriterion("lose_lose_award >", value, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("lose_lose_award >=", value, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardLessThan(Double value) {
            addCriterion("lose_lose_award <", value, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardLessThanOrEqualTo(Double value) {
            addCriterion("lose_lose_award <=", value, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardIn(List<Double> values) {
            addCriterion("lose_lose_award in", values, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardNotIn(List<Double> values) {
            addCriterion("lose_lose_award not in", values, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardBetween(Double value1, Double value2) {
            addCriterion("lose_lose_award between", value1, value2, "loseLoseAward");
            return (Criteria) this;
        }

        public Criteria andLoseLoseAwardNotBetween(Double value1, Double value2) {
            addCriterion("lose_lose_award not between", value1, value2, "loseLoseAward");
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