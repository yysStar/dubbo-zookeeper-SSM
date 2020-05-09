package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class BasketballTeam2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasketballTeam2Example() {
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

        public Criteria andLsIdIsNull() {
            addCriterion("ls_id is null");
            return (Criteria) this;
        }

        public Criteria andLsIdIsNotNull() {
            addCriterion("ls_id is not null");
            return (Criteria) this;
        }

        public Criteria andLsIdEqualTo(Integer value) {
            addCriterion("ls_id =", value, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdNotEqualTo(Integer value) {
            addCriterion("ls_id <>", value, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdGreaterThan(Integer value) {
            addCriterion("ls_id >", value, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ls_id >=", value, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdLessThan(Integer value) {
            addCriterion("ls_id <", value, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdLessThanOrEqualTo(Integer value) {
            addCriterion("ls_id <=", value, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdIn(List<Integer> values) {
            addCriterion("ls_id in", values, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdNotIn(List<Integer> values) {
            addCriterion("ls_id not in", values, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdBetween(Integer value1, Integer value2) {
            addCriterion("ls_id between", value1, value2, "lsId");
            return (Criteria) this;
        }

        public Criteria andLsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ls_id not between", value1, value2, "lsId");
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

        public Criteria andBig5IsNull() {
            addCriterion("big5 is null");
            return (Criteria) this;
        }

        public Criteria andBig5IsNotNull() {
            addCriterion("big5 is not null");
            return (Criteria) this;
        }

        public Criteria andBig5EqualTo(String value) {
            addCriterion("big5 =", value, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5NotEqualTo(String value) {
            addCriterion("big5 <>", value, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5GreaterThan(String value) {
            addCriterion("big5 >", value, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5GreaterThanOrEqualTo(String value) {
            addCriterion("big5 >=", value, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5LessThan(String value) {
            addCriterion("big5 <", value, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5LessThanOrEqualTo(String value) {
            addCriterion("big5 <=", value, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5Like(String value) {
            addCriterion("big5 like", value, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5NotLike(String value) {
            addCriterion("big5 not like", value, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5In(List<String> values) {
            addCriterion("big5 in", values, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5NotIn(List<String> values) {
            addCriterion("big5 not in", values, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5Between(String value1, String value2) {
            addCriterion("big5 between", value1, value2, "big5");
            return (Criteria) this;
        }

        public Criteria andBig5NotBetween(String value1, String value2) {
            addCriterion("big5 not between", value1, value2, "big5");
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

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNull() {
            addCriterion("location_id is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("location_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Integer value) {
            addCriterion("location_id =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Integer value) {
            addCriterion("location_id <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Integer value) {
            addCriterion("location_id >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_id >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Integer value) {
            addCriterion("location_id <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Integer value) {
            addCriterion("location_id <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Integer> values) {
            addCriterion("location_id in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Integer> values) {
            addCriterion("location_id not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Integer value1, Integer value2) {
            addCriterion("location_id between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("location_id not between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdIsNull() {
            addCriterion("match_addr_id is null");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdIsNotNull() {
            addCriterion("match_addr_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdEqualTo(Integer value) {
            addCriterion("match_addr_id =", value, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdNotEqualTo(Integer value) {
            addCriterion("match_addr_id <>", value, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdGreaterThan(Integer value) {
            addCriterion("match_addr_id >", value, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("match_addr_id >=", value, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdLessThan(Integer value) {
            addCriterion("match_addr_id <", value, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdLessThanOrEqualTo(Integer value) {
            addCriterion("match_addr_id <=", value, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdIn(List<Integer> values) {
            addCriterion("match_addr_id in", values, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdNotIn(List<Integer> values) {
            addCriterion("match_addr_id not in", values, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdBetween(Integer value1, Integer value2) {
            addCriterion("match_addr_id between", value1, value2, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andMatchAddrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("match_addr_id not between", value1, value2, "matchAddrId");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andGymnasiumIsNull() {
            addCriterion("gymnasium is null");
            return (Criteria) this;
        }

        public Criteria andGymnasiumIsNotNull() {
            addCriterion("gymnasium is not null");
            return (Criteria) this;
        }

        public Criteria andGymnasiumEqualTo(String value) {
            addCriterion("gymnasium =", value, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumNotEqualTo(String value) {
            addCriterion("gymnasium <>", value, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumGreaterThan(String value) {
            addCriterion("gymnasium >", value, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumGreaterThanOrEqualTo(String value) {
            addCriterion("gymnasium >=", value, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumLessThan(String value) {
            addCriterion("gymnasium <", value, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumLessThanOrEqualTo(String value) {
            addCriterion("gymnasium <=", value, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumLike(String value) {
            addCriterion("gymnasium like", value, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumNotLike(String value) {
            addCriterion("gymnasium not like", value, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumIn(List<String> values) {
            addCriterion("gymnasium in", values, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumNotIn(List<String> values) {
            addCriterion("gymnasium not in", values, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumBetween(String value1, String value2) {
            addCriterion("gymnasium between", value1, value2, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andGymnasiumNotBetween(String value1, String value2) {
            addCriterion("gymnasium not between", value1, value2, "gymnasium");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(Integer value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(Integer value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(Integer value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(Integer value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<Integer> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<Integer> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(Integer value1, Integer value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andJoinYearIsNull() {
            addCriterion("join_year is null");
            return (Criteria) this;
        }

        public Criteria andJoinYearIsNotNull() {
            addCriterion("join_year is not null");
            return (Criteria) this;
        }

        public Criteria andJoinYearEqualTo(Integer value) {
            addCriterion("join_year =", value, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearNotEqualTo(Integer value) {
            addCriterion("join_year <>", value, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearGreaterThan(Integer value) {
            addCriterion("join_year >", value, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_year >=", value, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearLessThan(Integer value) {
            addCriterion("join_year <", value, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearLessThanOrEqualTo(Integer value) {
            addCriterion("join_year <=", value, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearIn(List<Integer> values) {
            addCriterion("join_year in", values, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearNotIn(List<Integer> values) {
            addCriterion("join_year not in", values, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearBetween(Integer value1, Integer value2) {
            addCriterion("join_year between", value1, value2, "joinYear");
            return (Criteria) this;
        }

        public Criteria andJoinYearNotBetween(Integer value1, Integer value2) {
            addCriterion("join_year not between", value1, value2, "joinYear");
            return (Criteria) this;
        }

        public Criteria andFirstTimeIsNull() {
            addCriterion("first_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstTimeIsNotNull() {
            addCriterion("first_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTimeEqualTo(Integer value) {
            addCriterion("first_time =", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeNotEqualTo(Integer value) {
            addCriterion("first_time <>", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeGreaterThan(Integer value) {
            addCriterion("first_time >", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_time >=", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeLessThan(Integer value) {
            addCriterion("first_time <", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeLessThanOrEqualTo(Integer value) {
            addCriterion("first_time <=", value, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeIn(List<Integer> values) {
            addCriterion("first_time in", values, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeNotIn(List<Integer> values) {
            addCriterion("first_time not in", values, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeBetween(Integer value1, Integer value2) {
            addCriterion("first_time between", value1, value2, "firstTime");
            return (Criteria) this;
        }

        public Criteria andFirstTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("first_time not between", value1, value2, "firstTime");
            return (Criteria) this;
        }

        public Criteria andDrillmasterIsNull() {
            addCriterion("drillmaster is null");
            return (Criteria) this;
        }

        public Criteria andDrillmasterIsNotNull() {
            addCriterion("drillmaster is not null");
            return (Criteria) this;
        }

        public Criteria andDrillmasterEqualTo(String value) {
            addCriterion("drillmaster =", value, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterNotEqualTo(String value) {
            addCriterion("drillmaster <>", value, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterGreaterThan(String value) {
            addCriterion("drillmaster >", value, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterGreaterThanOrEqualTo(String value) {
            addCriterion("drillmaster >=", value, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterLessThan(String value) {
            addCriterion("drillmaster <", value, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterLessThanOrEqualTo(String value) {
            addCriterion("drillmaster <=", value, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterLike(String value) {
            addCriterion("drillmaster like", value, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterNotLike(String value) {
            addCriterion("drillmaster not like", value, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterIn(List<String> values) {
            addCriterion("drillmaster in", values, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterNotIn(List<String> values) {
            addCriterion("drillmaster not in", values, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterBetween(String value1, String value2) {
            addCriterion("drillmaster between", value1, value2, "drillmaster");
            return (Criteria) this;
        }

        public Criteria andDrillmasterNotBetween(String value1, String value2) {
            addCriterion("drillmaster not between", value1, value2, "drillmaster");
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