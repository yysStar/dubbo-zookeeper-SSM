package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class FootballLeagueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FootballLeagueExample() {
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

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andGbShortIsNull() {
            addCriterion("gb_short is null");
            return (Criteria) this;
        }

        public Criteria andGbShortIsNotNull() {
            addCriterion("gb_short is not null");
            return (Criteria) this;
        }

        public Criteria andGbShortEqualTo(String value) {
            addCriterion("gb_short =", value, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortNotEqualTo(String value) {
            addCriterion("gb_short <>", value, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortGreaterThan(String value) {
            addCriterion("gb_short >", value, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortGreaterThanOrEqualTo(String value) {
            addCriterion("gb_short >=", value, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortLessThan(String value) {
            addCriterion("gb_short <", value, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortLessThanOrEqualTo(String value) {
            addCriterion("gb_short <=", value, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortLike(String value) {
            addCriterion("gb_short like", value, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortNotLike(String value) {
            addCriterion("gb_short not like", value, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortIn(List<String> values) {
            addCriterion("gb_short in", values, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortNotIn(List<String> values) {
            addCriterion("gb_short not in", values, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortBetween(String value1, String value2) {
            addCriterion("gb_short between", value1, value2, "gbShort");
            return (Criteria) this;
        }

        public Criteria andGbShortNotBetween(String value1, String value2) {
            addCriterion("gb_short not between", value1, value2, "gbShort");
            return (Criteria) this;
        }

        public Criteria andBigShortIsNull() {
            addCriterion("big_short is null");
            return (Criteria) this;
        }

        public Criteria andBigShortIsNotNull() {
            addCriterion("big_short is not null");
            return (Criteria) this;
        }

        public Criteria andBigShortEqualTo(String value) {
            addCriterion("big_short =", value, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortNotEqualTo(String value) {
            addCriterion("big_short <>", value, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortGreaterThan(String value) {
            addCriterion("big_short >", value, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortGreaterThanOrEqualTo(String value) {
            addCriterion("big_short >=", value, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortLessThan(String value) {
            addCriterion("big_short <", value, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortLessThanOrEqualTo(String value) {
            addCriterion("big_short <=", value, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortLike(String value) {
            addCriterion("big_short like", value, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortNotLike(String value) {
            addCriterion("big_short not like", value, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortIn(List<String> values) {
            addCriterion("big_short in", values, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortNotIn(List<String> values) {
            addCriterion("big_short not in", values, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortBetween(String value1, String value2) {
            addCriterion("big_short between", value1, value2, "bigShort");
            return (Criteria) this;
        }

        public Criteria andBigShortNotBetween(String value1, String value2) {
            addCriterion("big_short not between", value1, value2, "bigShort");
            return (Criteria) this;
        }

        public Criteria andEnShortIsNull() {
            addCriterion("en_short is null");
            return (Criteria) this;
        }

        public Criteria andEnShortIsNotNull() {
            addCriterion("en_short is not null");
            return (Criteria) this;
        }

        public Criteria andEnShortEqualTo(String value) {
            addCriterion("en_short =", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortNotEqualTo(String value) {
            addCriterion("en_short <>", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortGreaterThan(String value) {
            addCriterion("en_short >", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortGreaterThanOrEqualTo(String value) {
            addCriterion("en_short >=", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortLessThan(String value) {
            addCriterion("en_short <", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortLessThanOrEqualTo(String value) {
            addCriterion("en_short <=", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortLike(String value) {
            addCriterion("en_short like", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortNotLike(String value) {
            addCriterion("en_short not like", value, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortIn(List<String> values) {
            addCriterion("en_short in", values, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortNotIn(List<String> values) {
            addCriterion("en_short not in", values, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortBetween(String value1, String value2) {
            addCriterion("en_short between", value1, value2, "enShort");
            return (Criteria) this;
        }

        public Criteria andEnShortNotBetween(String value1, String value2) {
            addCriterion("en_short not between", value1, value2, "enShort");
            return (Criteria) this;
        }

        public Criteria andGbIsNull() {
            addCriterion("gb is null");
            return (Criteria) this;
        }

        public Criteria andGbIsNotNull() {
            addCriterion("gb is not null");
            return (Criteria) this;
        }

        public Criteria andGbEqualTo(String value) {
            addCriterion("gb =", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbNotEqualTo(String value) {
            addCriterion("gb <>", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbGreaterThan(String value) {
            addCriterion("gb >", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbGreaterThanOrEqualTo(String value) {
            addCriterion("gb >=", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbLessThan(String value) {
            addCriterion("gb <", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbLessThanOrEqualTo(String value) {
            addCriterion("gb <=", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbLike(String value) {
            addCriterion("gb like", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbNotLike(String value) {
            addCriterion("gb not like", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbIn(List<String> values) {
            addCriterion("gb in", values, "gb");
            return (Criteria) this;
        }

        public Criteria andGbNotIn(List<String> values) {
            addCriterion("gb not in", values, "gb");
            return (Criteria) this;
        }

        public Criteria andGbBetween(String value1, String value2) {
            addCriterion("gb between", value1, value2, "gb");
            return (Criteria) this;
        }

        public Criteria andGbNotBetween(String value1, String value2) {
            addCriterion("gb not between", value1, value2, "gb");
            return (Criteria) this;
        }

        public Criteria andBigIsNull() {
            addCriterion("big is null");
            return (Criteria) this;
        }

        public Criteria andBigIsNotNull() {
            addCriterion("big is not null");
            return (Criteria) this;
        }

        public Criteria andBigEqualTo(String value) {
            addCriterion("big =", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotEqualTo(String value) {
            addCriterion("big <>", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigGreaterThan(String value) {
            addCriterion("big >", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigGreaterThanOrEqualTo(String value) {
            addCriterion("big >=", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLessThan(String value) {
            addCriterion("big <", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLessThanOrEqualTo(String value) {
            addCriterion("big <=", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLike(String value) {
            addCriterion("big like", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotLike(String value) {
            addCriterion("big not like", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigIn(List<String> values) {
            addCriterion("big in", values, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotIn(List<String> values) {
            addCriterion("big not in", values, "big");
            return (Criteria) this;
        }

        public Criteria andBigBetween(String value1, String value2) {
            addCriterion("big between", value1, value2, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotBetween(String value1, String value2) {
            addCriterion("big not between", value1, value2, "big");
            return (Criteria) this;
        }

        public Criteria andEnIsNull() {
            addCriterion("en is null");
            return (Criteria) this;
        }

        public Criteria andEnIsNotNull() {
            addCriterion("en is not null");
            return (Criteria) this;
        }

        public Criteria andEnEqualTo(String value) {
            addCriterion("en =", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnNotEqualTo(String value) {
            addCriterion("en <>", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnGreaterThan(String value) {
            addCriterion("en >", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnGreaterThanOrEqualTo(String value) {
            addCriterion("en >=", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnLessThan(String value) {
            addCriterion("en <", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnLessThanOrEqualTo(String value) {
            addCriterion("en <=", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnLike(String value) {
            addCriterion("en like", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnNotLike(String value) {
            addCriterion("en not like", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnIn(List<String> values) {
            addCriterion("en in", values, "en");
            return (Criteria) this;
        }

        public Criteria andEnNotIn(List<String> values) {
            addCriterion("en not in", values, "en");
            return (Criteria) this;
        }

        public Criteria andEnBetween(String value1, String value2) {
            addCriterion("en between", value1, value2, "en");
            return (Criteria) this;
        }

        public Criteria andEnNotBetween(String value1, String value2) {
            addCriterion("en not between", value1, value2, "en");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSubsclassIsNull() {
            addCriterion("subSclass is null");
            return (Criteria) this;
        }

        public Criteria andSubsclassIsNotNull() {
            addCriterion("subSclass is not null");
            return (Criteria) this;
        }

        public Criteria andSubsclassEqualTo(String value) {
            addCriterion("subSclass =", value, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassNotEqualTo(String value) {
            addCriterion("subSclass <>", value, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassGreaterThan(String value) {
            addCriterion("subSclass >", value, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassGreaterThanOrEqualTo(String value) {
            addCriterion("subSclass >=", value, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassLessThan(String value) {
            addCriterion("subSclass <", value, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassLessThanOrEqualTo(String value) {
            addCriterion("subSclass <=", value, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassLike(String value) {
            addCriterion("subSclass like", value, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassNotLike(String value) {
            addCriterion("subSclass not like", value, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassIn(List<String> values) {
            addCriterion("subSclass in", values, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassNotIn(List<String> values) {
            addCriterion("subSclass not in", values, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassBetween(String value1, String value2) {
            addCriterion("subSclass between", value1, value2, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSubsclassNotBetween(String value1, String value2) {
            addCriterion("subSclass not between", value1, value2, "subsclass");
            return (Criteria) this;
        }

        public Criteria andSumRoundIsNull() {
            addCriterion("sum_round is null");
            return (Criteria) this;
        }

        public Criteria andSumRoundIsNotNull() {
            addCriterion("sum_round is not null");
            return (Criteria) this;
        }

        public Criteria andSumRoundEqualTo(String value) {
            addCriterion("sum_round =", value, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundNotEqualTo(String value) {
            addCriterion("sum_round <>", value, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundGreaterThan(String value) {
            addCriterion("sum_round >", value, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundGreaterThanOrEqualTo(String value) {
            addCriterion("sum_round >=", value, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundLessThan(String value) {
            addCriterion("sum_round <", value, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundLessThanOrEqualTo(String value) {
            addCriterion("sum_round <=", value, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundLike(String value) {
            addCriterion("sum_round like", value, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundNotLike(String value) {
            addCriterion("sum_round not like", value, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundIn(List<String> values) {
            addCriterion("sum_round in", values, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundNotIn(List<String> values) {
            addCriterion("sum_round not in", values, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundBetween(String value1, String value2) {
            addCriterion("sum_round between", value1, value2, "sumRound");
            return (Criteria) this;
        }

        public Criteria andSumRoundNotBetween(String value1, String value2) {
            addCriterion("sum_round not between", value1, value2, "sumRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundIsNull() {
            addCriterion("curr_round is null");
            return (Criteria) this;
        }

        public Criteria andCurrRoundIsNotNull() {
            addCriterion("curr_round is not null");
            return (Criteria) this;
        }

        public Criteria andCurrRoundEqualTo(String value) {
            addCriterion("curr_round =", value, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundNotEqualTo(String value) {
            addCriterion("curr_round <>", value, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundGreaterThan(String value) {
            addCriterion("curr_round >", value, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundGreaterThanOrEqualTo(String value) {
            addCriterion("curr_round >=", value, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundLessThan(String value) {
            addCriterion("curr_round <", value, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundLessThanOrEqualTo(String value) {
            addCriterion("curr_round <=", value, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundLike(String value) {
            addCriterion("curr_round like", value, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundNotLike(String value) {
            addCriterion("curr_round not like", value, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundIn(List<String> values) {
            addCriterion("curr_round in", values, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundNotIn(List<String> values) {
            addCriterion("curr_round not in", values, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundBetween(String value1, String value2) {
            addCriterion("curr_round between", value1, value2, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrRoundNotBetween(String value1, String value2) {
            addCriterion("curr_round not between", value1, value2, "currRound");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonIsNull() {
            addCriterion("curr_match_season is null");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonIsNotNull() {
            addCriterion("curr_match_season is not null");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonEqualTo(String value) {
            addCriterion("curr_match_season =", value, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonNotEqualTo(String value) {
            addCriterion("curr_match_season <>", value, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonGreaterThan(String value) {
            addCriterion("curr_match_season >", value, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonGreaterThanOrEqualTo(String value) {
            addCriterion("curr_match_season >=", value, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonLessThan(String value) {
            addCriterion("curr_match_season <", value, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonLessThanOrEqualTo(String value) {
            addCriterion("curr_match_season <=", value, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonLike(String value) {
            addCriterion("curr_match_season like", value, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonNotLike(String value) {
            addCriterion("curr_match_season not like", value, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonIn(List<String> values) {
            addCriterion("curr_match_season in", values, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonNotIn(List<String> values) {
            addCriterion("curr_match_season not in", values, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonBetween(String value1, String value2) {
            addCriterion("curr_match_season between", value1, value2, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchSeasonNotBetween(String value1, String value2) {
            addCriterion("curr_match_season not between", value1, value2, "currMatchSeason");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNull() {
            addCriterion("country_id is null");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNotNull() {
            addCriterion("country_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountryIdEqualTo(String value) {
            addCriterion("country_id =", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotEqualTo(String value) {
            addCriterion("country_id <>", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThan(String value) {
            addCriterion("country_id >", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThanOrEqualTo(String value) {
            addCriterion("country_id >=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThan(String value) {
            addCriterion("country_id <", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThanOrEqualTo(String value) {
            addCriterion("country_id <=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLike(String value) {
            addCriterion("country_id like", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotLike(String value) {
            addCriterion("country_id not like", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdIn(List<String> values) {
            addCriterion("country_id in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotIn(List<String> values) {
            addCriterion("country_id not in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdBetween(String value1, String value2) {
            addCriterion("country_id between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotBetween(String value1, String value2) {
            addCriterion("country_id not between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andCountryEnIsNull() {
            addCriterion("country_en is null");
            return (Criteria) this;
        }

        public Criteria andCountryEnIsNotNull() {
            addCriterion("country_en is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEnEqualTo(String value) {
            addCriterion("country_en =", value, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnNotEqualTo(String value) {
            addCriterion("country_en <>", value, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnGreaterThan(String value) {
            addCriterion("country_en >", value, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnGreaterThanOrEqualTo(String value) {
            addCriterion("country_en >=", value, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnLessThan(String value) {
            addCriterion("country_en <", value, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnLessThanOrEqualTo(String value) {
            addCriterion("country_en <=", value, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnLike(String value) {
            addCriterion("country_en like", value, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnNotLike(String value) {
            addCriterion("country_en not like", value, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnIn(List<String> values) {
            addCriterion("country_en in", values, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnNotIn(List<String> values) {
            addCriterion("country_en not in", values, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnBetween(String value1, String value2) {
            addCriterion("country_en between", value1, value2, "countryEn");
            return (Criteria) this;
        }

        public Criteria andCountryEnNotBetween(String value1, String value2) {
            addCriterion("country_en not between", value1, value2, "countryEn");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoIsNull() {
            addCriterion("countr_logo is null");
            return (Criteria) this;
        }

        public Criteria andCountrLogoIsNotNull() {
            addCriterion("countr_logo is not null");
            return (Criteria) this;
        }

        public Criteria andCountrLogoEqualTo(String value) {
            addCriterion("countr_logo =", value, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoNotEqualTo(String value) {
            addCriterion("countr_logo <>", value, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoGreaterThan(String value) {
            addCriterion("countr_logo >", value, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoGreaterThanOrEqualTo(String value) {
            addCriterion("countr_logo >=", value, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoLessThan(String value) {
            addCriterion("countr_logo <", value, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoLessThanOrEqualTo(String value) {
            addCriterion("countr_logo <=", value, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoLike(String value) {
            addCriterion("countr_logo like", value, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoNotLike(String value) {
            addCriterion("countr_logo not like", value, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoIn(List<String> values) {
            addCriterion("countr_logo in", values, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoNotIn(List<String> values) {
            addCriterion("countr_logo not in", values, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoBetween(String value1, String value2) {
            addCriterion("countr_logo between", value1, value2, "countrLogo");
            return (Criteria) this;
        }

        public Criteria andCountrLogoNotBetween(String value1, String value2) {
            addCriterion("countr_logo not between", value1, value2, "countrLogo");
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