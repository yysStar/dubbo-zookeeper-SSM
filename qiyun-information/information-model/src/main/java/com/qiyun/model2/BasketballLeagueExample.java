package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class BasketballLeagueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasketballLeagueExample() {
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

        public Criteria andShortIsNull() {
            addCriterion("short is null");
            return (Criteria) this;
        }

        public Criteria andShortIsNotNull() {
            addCriterion("short is not null");
            return (Criteria) this;
        }

        public Criteria andShortEqualTo(String value) {
            addCriterion("short =", value, "short");
            return (Criteria) this;
        }

        public Criteria andShortNotEqualTo(String value) {
            addCriterion("short <>", value, "short");
            return (Criteria) this;
        }

        public Criteria andShortGreaterThan(String value) {
            addCriterion("short >", value, "short");
            return (Criteria) this;
        }

        public Criteria andShortGreaterThanOrEqualTo(String value) {
            addCriterion("short >=", value, "short");
            return (Criteria) this;
        }

        public Criteria andShortLessThan(String value) {
            addCriterion("short <", value, "short");
            return (Criteria) this;
        }

        public Criteria andShortLessThanOrEqualTo(String value) {
            addCriterion("short <=", value, "short");
            return (Criteria) this;
        }

        public Criteria andShortLike(String value) {
            addCriterion("short like", value, "short");
            return (Criteria) this;
        }

        public Criteria andShortNotLike(String value) {
            addCriterion("short not like", value, "short");
            return (Criteria) this;
        }

        public Criteria andShortIn(List<String> values) {
            addCriterion("short in", values, "short");
            return (Criteria) this;
        }

        public Criteria andShortNotIn(List<String> values) {
            addCriterion("short not in", values, "short");
            return (Criteria) this;
        }

        public Criteria andShortBetween(String value1, String value2) {
            addCriterion("short between", value1, value2, "short");
            return (Criteria) this;
        }

        public Criteria andShortNotBetween(String value1, String value2) {
            addCriterion("short not between", value1, value2, "short");
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

        public Criteria andCurrMatchseasonIsNull() {
            addCriterion("curr_matchSeason is null");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonIsNotNull() {
            addCriterion("curr_matchSeason is not null");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonEqualTo(String value) {
            addCriterion("curr_matchSeason =", value, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonNotEqualTo(String value) {
            addCriterion("curr_matchSeason <>", value, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonGreaterThan(String value) {
            addCriterion("curr_matchSeason >", value, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonGreaterThanOrEqualTo(String value) {
            addCriterion("curr_matchSeason >=", value, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonLessThan(String value) {
            addCriterion("curr_matchSeason <", value, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonLessThanOrEqualTo(String value) {
            addCriterion("curr_matchSeason <=", value, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonLike(String value) {
            addCriterion("curr_matchSeason like", value, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonNotLike(String value) {
            addCriterion("curr_matchSeason not like", value, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonIn(List<String> values) {
            addCriterion("curr_matchSeason in", values, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonNotIn(List<String> values) {
            addCriterion("curr_matchSeason not in", values, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonBetween(String value1, String value2) {
            addCriterion("curr_matchSeason between", value1, value2, "currMatchseason");
            return (Criteria) this;
        }

        public Criteria andCurrMatchseasonNotBetween(String value1, String value2) {
            addCriterion("curr_matchSeason not between", value1, value2, "currMatchseason");
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

        public Criteria andCurrYearIsNull() {
            addCriterion("curr_year is null");
            return (Criteria) this;
        }

        public Criteria andCurrYearIsNotNull() {
            addCriterion("curr_year is not null");
            return (Criteria) this;
        }

        public Criteria andCurrYearEqualTo(String value) {
            addCriterion("curr_year =", value, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearNotEqualTo(String value) {
            addCriterion("curr_year <>", value, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearGreaterThan(String value) {
            addCriterion("curr_year >", value, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearGreaterThanOrEqualTo(String value) {
            addCriterion("curr_year >=", value, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearLessThan(String value) {
            addCriterion("curr_year <", value, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearLessThanOrEqualTo(String value) {
            addCriterion("curr_year <=", value, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearLike(String value) {
            addCriterion("curr_year like", value, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearNotLike(String value) {
            addCriterion("curr_year not like", value, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearIn(List<String> values) {
            addCriterion("curr_year in", values, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearNotIn(List<String> values) {
            addCriterion("curr_year not in", values, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearBetween(String value1, String value2) {
            addCriterion("curr_year between", value1, value2, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrYearNotBetween(String value1, String value2) {
            addCriterion("curr_year not between", value1, value2, "currYear");
            return (Criteria) this;
        }

        public Criteria andCurrMonthIsNull() {
            addCriterion("curr_month is null");
            return (Criteria) this;
        }

        public Criteria andCurrMonthIsNotNull() {
            addCriterion("curr_month is not null");
            return (Criteria) this;
        }

        public Criteria andCurrMonthEqualTo(String value) {
            addCriterion("curr_month =", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthNotEqualTo(String value) {
            addCriterion("curr_month <>", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthGreaterThan(String value) {
            addCriterion("curr_month >", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthGreaterThanOrEqualTo(String value) {
            addCriterion("curr_month >=", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthLessThan(String value) {
            addCriterion("curr_month <", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthLessThanOrEqualTo(String value) {
            addCriterion("curr_month <=", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthLike(String value) {
            addCriterion("curr_month like", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthNotLike(String value) {
            addCriterion("curr_month not like", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthIn(List<String> values) {
            addCriterion("curr_month in", values, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthNotIn(List<String> values) {
            addCriterion("curr_month not in", values, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthBetween(String value1, String value2) {
            addCriterion("curr_month between", value1, value2, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthNotBetween(String value1, String value2) {
            addCriterion("curr_month not between", value1, value2, "currMonth");
            return (Criteria) this;
        }

        public Criteria andSclassKindIsNull() {
            addCriterion("sclass_kind is null");
            return (Criteria) this;
        }

        public Criteria andSclassKindIsNotNull() {
            addCriterion("sclass_kind is not null");
            return (Criteria) this;
        }

        public Criteria andSclassKindEqualTo(String value) {
            addCriterion("sclass_kind =", value, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindNotEqualTo(String value) {
            addCriterion("sclass_kind <>", value, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindGreaterThan(String value) {
            addCriterion("sclass_kind >", value, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindGreaterThanOrEqualTo(String value) {
            addCriterion("sclass_kind >=", value, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindLessThan(String value) {
            addCriterion("sclass_kind <", value, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindLessThanOrEqualTo(String value) {
            addCriterion("sclass_kind <=", value, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindLike(String value) {
            addCriterion("sclass_kind like", value, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindNotLike(String value) {
            addCriterion("sclass_kind not like", value, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindIn(List<String> values) {
            addCriterion("sclass_kind in", values, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindNotIn(List<String> values) {
            addCriterion("sclass_kind not in", values, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindBetween(String value1, String value2) {
            addCriterion("sclass_kind between", value1, value2, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassKindNotBetween(String value1, String value2) {
            addCriterion("sclass_kind not between", value1, value2, "sclassKind");
            return (Criteria) this;
        }

        public Criteria andSclassTimeIsNull() {
            addCriterion("sclass_time is null");
            return (Criteria) this;
        }

        public Criteria andSclassTimeIsNotNull() {
            addCriterion("sclass_time is not null");
            return (Criteria) this;
        }

        public Criteria andSclassTimeEqualTo(String value) {
            addCriterion("sclass_time =", value, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeNotEqualTo(String value) {
            addCriterion("sclass_time <>", value, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeGreaterThan(String value) {
            addCriterion("sclass_time >", value, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sclass_time >=", value, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeLessThan(String value) {
            addCriterion("sclass_time <", value, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeLessThanOrEqualTo(String value) {
            addCriterion("sclass_time <=", value, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeLike(String value) {
            addCriterion("sclass_time like", value, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeNotLike(String value) {
            addCriterion("sclass_time not like", value, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeIn(List<String> values) {
            addCriterion("sclass_time in", values, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeNotIn(List<String> values) {
            addCriterion("sclass_time not in", values, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeBetween(String value1, String value2) {
            addCriterion("sclass_time between", value1, value2, "sclassTime");
            return (Criteria) this;
        }

        public Criteria andSclassTimeNotBetween(String value1, String value2) {
            addCriterion("sclass_time not between", value1, value2, "sclassTime");
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