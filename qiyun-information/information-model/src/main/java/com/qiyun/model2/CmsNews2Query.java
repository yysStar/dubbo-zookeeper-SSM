package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsNews2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmsNews2Query() {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andShortTitleIsNull() {
            addCriterion("SHORT_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andShortTitleIsNotNull() {
            addCriterion("SHORT_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andShortTitleEqualTo(String value) {
            addCriterion("SHORT_TITLE =", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleNotEqualTo(String value) {
            addCriterion("SHORT_TITLE <>", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleGreaterThan(String value) {
            addCriterion("SHORT_TITLE >", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleGreaterThanOrEqualTo(String value) {
            addCriterion("SHORT_TITLE >=", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleLessThan(String value) {
            addCriterion("SHORT_TITLE <", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleLessThanOrEqualTo(String value) {
            addCriterion("SHORT_TITLE <=", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleLike(String value) {
            addCriterion("SHORT_TITLE like", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleNotLike(String value) {
            addCriterion("SHORT_TITLE not like", value, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleIn(List<String> values) {
            addCriterion("SHORT_TITLE in", values, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleNotIn(List<String> values) {
            addCriterion("SHORT_TITLE not in", values, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleBetween(String value1, String value2) {
            addCriterion("SHORT_TITLE between", value1, value2, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andShortTitleNotBetween(String value1, String value2) {
            addCriterion("SHORT_TITLE not between", value1, value2, "shortTitle");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionIsNull() {
            addCriterion("HTML_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionIsNotNull() {
            addCriterion("HTML_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionEqualTo(String value) {
            addCriterion("HTML_DESCRIPTION =", value, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionNotEqualTo(String value) {
            addCriterion("HTML_DESCRIPTION <>", value, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionGreaterThan(String value) {
            addCriterion("HTML_DESCRIPTION >", value, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("HTML_DESCRIPTION >=", value, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionLessThan(String value) {
            addCriterion("HTML_DESCRIPTION <", value, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionLessThanOrEqualTo(String value) {
            addCriterion("HTML_DESCRIPTION <=", value, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionLike(String value) {
            addCriterion("HTML_DESCRIPTION like", value, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionNotLike(String value) {
            addCriterion("HTML_DESCRIPTION not like", value, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionIn(List<String> values) {
            addCriterion("HTML_DESCRIPTION in", values, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionNotIn(List<String> values) {
            addCriterion("HTML_DESCRIPTION not in", values, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionBetween(String value1, String value2) {
            addCriterion("HTML_DESCRIPTION between", value1, value2, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andHtmlDescriptionNotBetween(String value1, String value2) {
            addCriterion("HTML_DESCRIPTION not between", value1, value2, "htmlDescription");
            return (Criteria) this;
        }

        public Criteria andClickIsNull() {
            addCriterion("CLICK is null");
            return (Criteria) this;
        }

        public Criteria andClickIsNotNull() {
            addCriterion("CLICK is not null");
            return (Criteria) this;
        }

        public Criteria andClickEqualTo(Integer value) {
            addCriterion("CLICK =", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotEqualTo(Integer value) {
            addCriterion("CLICK <>", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickGreaterThan(Integer value) {
            addCriterion("CLICK >", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLICK >=", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickLessThan(Integer value) {
            addCriterion("CLICK <", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickLessThanOrEqualTo(Integer value) {
            addCriterion("CLICK <=", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickIn(List<Integer> values) {
            addCriterion("CLICK in", values, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotIn(List<Integer> values) {
            addCriterion("CLICK not in", values, "click");
            return (Criteria) this;
        }

        public Criteria andClickBetween(Integer value1, Integer value2) {
            addCriterion("CLICK between", value1, value2, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotBetween(Integer value1, Integer value2) {
            addCriterion("CLICK not between", value1, value2, "click");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("KEYWORD is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("KEYWORD is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("KEYWORD =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("KEYWORD <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("KEYWORD >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("KEYWORD >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("KEYWORD <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("KEYWORD <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("KEYWORD like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("KEYWORD not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("KEYWORD in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("KEYWORD not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("KEYWORD between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("KEYWORD not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andEditorIsNull() {
            addCriterion("EDITOR is null");
            return (Criteria) this;
        }

        public Criteria andEditorIsNotNull() {
            addCriterion("EDITOR is not null");
            return (Criteria) this;
        }

        public Criteria andEditorEqualTo(String value) {
            addCriterion("EDITOR =", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotEqualTo(String value) {
            addCriterion("EDITOR <>", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThan(String value) {
            addCriterion("EDITOR >", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThanOrEqualTo(String value) {
            addCriterion("EDITOR >=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThan(String value) {
            addCriterion("EDITOR <", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThanOrEqualTo(String value) {
            addCriterion("EDITOR <=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLike(String value) {
            addCriterion("EDITOR like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotLike(String value) {
            addCriterion("EDITOR not like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorIn(List<String> values) {
            addCriterion("EDITOR in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotIn(List<String> values) {
            addCriterion("EDITOR not in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorBetween(String value1, String value2) {
            addCriterion("EDITOR between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotBetween(String value1, String value2) {
            addCriterion("EDITOR not between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andIsHeadIsNull() {
            addCriterion("IS_HEAD is null");
            return (Criteria) this;
        }

        public Criteria andIsHeadIsNotNull() {
            addCriterion("IS_HEAD is not null");
            return (Criteria) this;
        }

        public Criteria andIsHeadEqualTo(Integer value) {
            addCriterion("IS_HEAD =", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadNotEqualTo(Integer value) {
            addCriterion("IS_HEAD <>", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadGreaterThan(Integer value) {
            addCriterion("IS_HEAD >", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_HEAD >=", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadLessThan(Integer value) {
            addCriterion("IS_HEAD <", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadLessThanOrEqualTo(Integer value) {
            addCriterion("IS_HEAD <=", value, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadIn(List<Integer> values) {
            addCriterion("IS_HEAD in", values, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadNotIn(List<Integer> values) {
            addCriterion("IS_HEAD not in", values, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadBetween(Integer value1, Integer value2) {
            addCriterion("IS_HEAD between", value1, value2, "isHead");
            return (Criteria) this;
        }

        public Criteria andIsHeadNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_HEAD not between", value1, value2, "isHead");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNull() {
            addCriterion("CREATE_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNotNull() {
            addCriterion("CREATE_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME =", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME <>", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThan(Date value) {
            addCriterion("CREATE_DATE_TIME >", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME >=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThan(Date value) {
            addCriterion("CREATE_DATE_TIME <", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE_TIME <=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIn(List<Date> values) {
            addCriterion("CREATE_DATE_TIME in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_DATE_TIME not in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE_TIME between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE_TIME not between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("CONTENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("CONTENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(Integer value) {
            addCriterion("CONTENT_TYPE =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(Integer value) {
            addCriterion("CONTENT_TYPE <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(Integer value) {
            addCriterion("CONTENT_TYPE >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CONTENT_TYPE >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(Integer value) {
            addCriterion("CONTENT_TYPE <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("CONTENT_TYPE <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<Integer> values) {
            addCriterion("CONTENT_TYPE in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<Integer> values) {
            addCriterion("CONTENT_TYPE not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(Integer value1, Integer value2) {
            addCriterion("CONTENT_TYPE between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("CONTENT_TYPE not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("LINK is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("LINK is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("LINK =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("LINK <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("LINK >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("LINK >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("LINK <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("LINK <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("LINK like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("LINK not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("LINK in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("LINK not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("LINK between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("LINK not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Integer value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Integer value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Integer value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Integer value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Integer> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Integer> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNull() {
            addCriterion("LOTTERY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNotNull() {
            addCriterion("LOTTERY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeEqualTo(Integer value) {
            addCriterion("LOTTERY_TYPE =", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotEqualTo(Integer value) {
            addCriterion("LOTTERY_TYPE <>", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThan(Integer value) {
            addCriterion("LOTTERY_TYPE >", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOTTERY_TYPE >=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThan(Integer value) {
            addCriterion("LOTTERY_TYPE <", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOTTERY_TYPE <=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIn(List<Integer> values) {
            addCriterion("LOTTERY_TYPE in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotIn(List<Integer> values) {
            addCriterion("LOTTERY_TYPE not in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOTTERY_TYPE between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOTTERY_TYPE not between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNull() {
            addCriterion("PLAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNotNull() {
            addCriterion("PLAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeEqualTo(Integer value) {
            addCriterion("PLAY_TYPE =", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotEqualTo(Integer value) {
            addCriterion("PLAY_TYPE <>", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThan(Integer value) {
            addCriterion("PLAY_TYPE >", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAY_TYPE >=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThan(Integer value) {
            addCriterion("PLAY_TYPE <", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PLAY_TYPE <=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIn(List<Integer> values) {
            addCriterion("PLAY_TYPE in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotIn(List<Integer> values) {
            addCriterion("PLAY_TYPE not in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_TYPE between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_TYPE not between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("ACCOUNT like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("ACCOUNT not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("COLOR is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("COLOR =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("COLOR <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("COLOR >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("COLOR >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("COLOR <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("COLOR <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("COLOR like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("COLOR not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("COLOR in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("COLOR not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("COLOR between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("COLOR not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("TAG is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("TAG is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("TAG =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("TAG <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("TAG >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("TAG >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("TAG <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("TAG <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("TAG like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("TAG not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("TAG in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("TAG not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("TAG between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("TAG not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordIsNull() {
            addCriterion("HTML_KEYWORD is null");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordIsNotNull() {
            addCriterion("HTML_KEYWORD is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordEqualTo(String value) {
            addCriterion("HTML_KEYWORD =", value, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordNotEqualTo(String value) {
            addCriterion("HTML_KEYWORD <>", value, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordGreaterThan(String value) {
            addCriterion("HTML_KEYWORD >", value, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("HTML_KEYWORD >=", value, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordLessThan(String value) {
            addCriterion("HTML_KEYWORD <", value, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordLessThanOrEqualTo(String value) {
            addCriterion("HTML_KEYWORD <=", value, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordLike(String value) {
            addCriterion("HTML_KEYWORD like", value, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordNotLike(String value) {
            addCriterion("HTML_KEYWORD not like", value, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordIn(List<String> values) {
            addCriterion("HTML_KEYWORD in", values, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordNotIn(List<String> values) {
            addCriterion("HTML_KEYWORD not in", values, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordBetween(String value1, String value2) {
            addCriterion("HTML_KEYWORD between", value1, value2, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andHtmlKeywordNotBetween(String value1, String value2) {
            addCriterion("HTML_KEYWORD not between", value1, value2, "htmlKeyword");
            return (Criteria) this;
        }

        public Criteria andDigsIsNull() {
            addCriterion("digs is null");
            return (Criteria) this;
        }

        public Criteria andDigsIsNotNull() {
            addCriterion("digs is not null");
            return (Criteria) this;
        }

        public Criteria andDigsEqualTo(Integer value) {
            addCriterion("digs =", value, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsNotEqualTo(Integer value) {
            addCriterion("digs <>", value, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsGreaterThan(Integer value) {
            addCriterion("digs >", value, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsGreaterThanOrEqualTo(Integer value) {
            addCriterion("digs >=", value, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsLessThan(Integer value) {
            addCriterion("digs <", value, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsLessThanOrEqualTo(Integer value) {
            addCriterion("digs <=", value, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsIn(List<Integer> values) {
            addCriterion("digs in", values, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsNotIn(List<Integer> values) {
            addCriterion("digs not in", values, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsBetween(Integer value1, Integer value2) {
            addCriterion("digs between", value1, value2, "digs");
            return (Criteria) this;
        }

        public Criteria andDigsNotBetween(Integer value1, Integer value2) {
            addCriterion("digs not between", value1, value2, "digs");
            return (Criteria) this;
        }

        public Criteria andUndigsIsNull() {
            addCriterion("undigs is null");
            return (Criteria) this;
        }

        public Criteria andUndigsIsNotNull() {
            addCriterion("undigs is not null");
            return (Criteria) this;
        }

        public Criteria andUndigsEqualTo(Integer value) {
            addCriterion("undigs =", value, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsNotEqualTo(Integer value) {
            addCriterion("undigs <>", value, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsGreaterThan(Integer value) {
            addCriterion("undigs >", value, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsGreaterThanOrEqualTo(Integer value) {
            addCriterion("undigs >=", value, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsLessThan(Integer value) {
            addCriterion("undigs <", value, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsLessThanOrEqualTo(Integer value) {
            addCriterion("undigs <=", value, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsIn(List<Integer> values) {
            addCriterion("undigs in", values, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsNotIn(List<Integer> values) {
            addCriterion("undigs not in", values, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsBetween(Integer value1, Integer value2) {
            addCriterion("undigs between", value1, value2, "undigs");
            return (Criteria) this;
        }

        public Criteria andUndigsNotBetween(Integer value1, Integer value2) {
            addCriterion("undigs not between", value1, value2, "undigs");
            return (Criteria) this;
        }

        public Criteria andNewsSourceIsNull() {
            addCriterion("news_source is null");
            return (Criteria) this;
        }

        public Criteria andNewsSourceIsNotNull() {
            addCriterion("news_source is not null");
            return (Criteria) this;
        }

        public Criteria andNewsSourceEqualTo(String value) {
            addCriterion("news_source =", value, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceNotEqualTo(String value) {
            addCriterion("news_source <>", value, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceGreaterThan(String value) {
            addCriterion("news_source >", value, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceGreaterThanOrEqualTo(String value) {
            addCriterion("news_source >=", value, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceLessThan(String value) {
            addCriterion("news_source <", value, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceLessThanOrEqualTo(String value) {
            addCriterion("news_source <=", value, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceLike(String value) {
            addCriterion("news_source like", value, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceNotLike(String value) {
            addCriterion("news_source not like", value, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceIn(List<String> values) {
            addCriterion("news_source in", values, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceNotIn(List<String> values) {
            addCriterion("news_source not in", values, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceBetween(String value1, String value2) {
            addCriterion("news_source between", value1, value2, "newsSource");
            return (Criteria) this;
        }

        public Criteria andNewsSourceNotBetween(String value1, String value2) {
            addCriterion("news_source not between", value1, value2, "newsSource");
            return (Criteria) this;
        }

        public Criteria andIfRemarkIsNull() {
            addCriterion("IF_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andIfRemarkIsNotNull() {
            addCriterion("IF_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andIfRemarkEqualTo(Integer value) {
            addCriterion("IF_REMARK =", value, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkNotEqualTo(Integer value) {
            addCriterion("IF_REMARK <>", value, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkGreaterThan(Integer value) {
            addCriterion("IF_REMARK >", value, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("IF_REMARK >=", value, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkLessThan(Integer value) {
            addCriterion("IF_REMARK <", value, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkLessThanOrEqualTo(Integer value) {
            addCriterion("IF_REMARK <=", value, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkIn(List<Integer> values) {
            addCriterion("IF_REMARK in", values, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkNotIn(List<Integer> values) {
            addCriterion("IF_REMARK not in", values, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkBetween(Integer value1, Integer value2) {
            addCriterion("IF_REMARK between", value1, value2, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andIfRemarkNotBetween(Integer value1, Integer value2) {
            addCriterion("IF_REMARK not between", value1, value2, "ifRemark");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNull() {
            addCriterion("EXPERT_ID is null");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNotNull() {
            addCriterion("EXPERT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExpertIdEqualTo(Integer value) {
            addCriterion("EXPERT_ID =", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotEqualTo(Integer value) {
            addCriterion("EXPERT_ID <>", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThan(Integer value) {
            addCriterion("EXPERT_ID >", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPERT_ID >=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThan(Integer value) {
            addCriterion("EXPERT_ID <", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThanOrEqualTo(Integer value) {
            addCriterion("EXPERT_ID <=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdIn(List<Integer> values) {
            addCriterion("EXPERT_ID in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotIn(List<Integer> values) {
            addCriterion("EXPERT_ID not in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdBetween(Integer value1, Integer value2) {
            addCriterion("EXPERT_ID between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPERT_ID not between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andCommendTitleIsNull() {
            addCriterion("COMMEND_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andCommendTitleIsNotNull() {
            addCriterion("COMMEND_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andCommendTitleEqualTo(String value) {
            addCriterion("COMMEND_TITLE =", value, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleNotEqualTo(String value) {
            addCriterion("COMMEND_TITLE <>", value, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleGreaterThan(String value) {
            addCriterion("COMMEND_TITLE >", value, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleGreaterThanOrEqualTo(String value) {
            addCriterion("COMMEND_TITLE >=", value, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleLessThan(String value) {
            addCriterion("COMMEND_TITLE <", value, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleLessThanOrEqualTo(String value) {
            addCriterion("COMMEND_TITLE <=", value, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleLike(String value) {
            addCriterion("COMMEND_TITLE like", value, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleNotLike(String value) {
            addCriterion("COMMEND_TITLE not like", value, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleIn(List<String> values) {
            addCriterion("COMMEND_TITLE in", values, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleNotIn(List<String> values) {
            addCriterion("COMMEND_TITLE not in", values, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleBetween(String value1, String value2) {
            addCriterion("COMMEND_TITLE between", value1, value2, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andCommendTitleNotBetween(String value1, String value2) {
            addCriterion("COMMEND_TITLE not between", value1, value2, "commendTitle");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNull() {
            addCriterion("VIDEO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNotNull() {
            addCriterion("VIDEO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andVideoNameEqualTo(String value) {
            addCriterion("VIDEO_NAME =", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotEqualTo(String value) {
            addCriterion("VIDEO_NAME <>", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThan(String value) {
            addCriterion("VIDEO_NAME >", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_NAME >=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThan(String value) {
            addCriterion("VIDEO_NAME <", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_NAME <=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLike(String value) {
            addCriterion("VIDEO_NAME like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotLike(String value) {
            addCriterion("VIDEO_NAME not like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameIn(List<String> values) {
            addCriterion("VIDEO_NAME in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotIn(List<String> values) {
            addCriterion("VIDEO_NAME not in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameBetween(String value1, String value2) {
            addCriterion("VIDEO_NAME between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotBetween(String value1, String value2) {
            addCriterion("VIDEO_NAME not between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoPathIsNull() {
            addCriterion("VIDEO_PATH is null");
            return (Criteria) this;
        }

        public Criteria andVideoPathIsNotNull() {
            addCriterion("VIDEO_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andVideoPathEqualTo(String value) {
            addCriterion("VIDEO_PATH =", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathNotEqualTo(String value) {
            addCriterion("VIDEO_PATH <>", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathGreaterThan(String value) {
            addCriterion("VIDEO_PATH >", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_PATH >=", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathLessThan(String value) {
            addCriterion("VIDEO_PATH <", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_PATH <=", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathLike(String value) {
            addCriterion("VIDEO_PATH like", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathNotLike(String value) {
            addCriterion("VIDEO_PATH not like", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathIn(List<String> values) {
            addCriterion("VIDEO_PATH in", values, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathNotIn(List<String> values) {
            addCriterion("VIDEO_PATH not in", values, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathBetween(String value1, String value2) {
            addCriterion("VIDEO_PATH between", value1, value2, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathNotBetween(String value1, String value2) {
            addCriterion("VIDEO_PATH not between", value1, value2, "videoPath");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeIsNull() {
            addCriterion("IS_LOTTERY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeIsNotNull() {
            addCriterion("IS_LOTTERY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeEqualTo(Integer value) {
            addCriterion("IS_LOTTERY_TYPE =", value, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeNotEqualTo(Integer value) {
            addCriterion("IS_LOTTERY_TYPE <>", value, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeGreaterThan(Integer value) {
            addCriterion("IS_LOTTERY_TYPE >", value, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_LOTTERY_TYPE >=", value, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeLessThan(Integer value) {
            addCriterion("IS_LOTTERY_TYPE <", value, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("IS_LOTTERY_TYPE <=", value, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeIn(List<Integer> values) {
            addCriterion("IS_LOTTERY_TYPE in", values, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeNotIn(List<Integer> values) {
            addCriterion("IS_LOTTERY_TYPE not in", values, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeBetween(Integer value1, Integer value2) {
            addCriterion("IS_LOTTERY_TYPE between", value1, value2, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsLotteryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_LOTTERY_TYPE not between", value1, value2, "isLotteryType");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadIsNull() {
            addCriterion("IS_FIRST_HEAD is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadIsNotNull() {
            addCriterion("IS_FIRST_HEAD is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadEqualTo(Integer value) {
            addCriterion("IS_FIRST_HEAD =", value, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadNotEqualTo(Integer value) {
            addCriterion("IS_FIRST_HEAD <>", value, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadGreaterThan(Integer value) {
            addCriterion("IS_FIRST_HEAD >", value, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_FIRST_HEAD >=", value, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadLessThan(Integer value) {
            addCriterion("IS_FIRST_HEAD <", value, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadLessThanOrEqualTo(Integer value) {
            addCriterion("IS_FIRST_HEAD <=", value, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadIn(List<Integer> values) {
            addCriterion("IS_FIRST_HEAD in", values, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadNotIn(List<Integer> values) {
            addCriterion("IS_FIRST_HEAD not in", values, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadBetween(Integer value1, Integer value2) {
            addCriterion("IS_FIRST_HEAD between", value1, value2, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsFirstHeadNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_FIRST_HEAD not between", value1, value2, "isFirstHead");
            return (Criteria) this;
        }

        public Criteria andIsPriorityIsNull() {
            addCriterion("IS_PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andIsPriorityIsNotNull() {
            addCriterion("IS_PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andIsPriorityEqualTo(Integer value) {
            addCriterion("IS_PRIORITY =", value, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityNotEqualTo(Integer value) {
            addCriterion("IS_PRIORITY <>", value, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityGreaterThan(Integer value) {
            addCriterion("IS_PRIORITY >", value, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_PRIORITY >=", value, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityLessThan(Integer value) {
            addCriterion("IS_PRIORITY <", value, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("IS_PRIORITY <=", value, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityIn(List<Integer> values) {
            addCriterion("IS_PRIORITY in", values, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityNotIn(List<Integer> values) {
            addCriterion("IS_PRIORITY not in", values, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityBetween(Integer value1, Integer value2) {
            addCriterion("IS_PRIORITY between", value1, value2, "isPriority");
            return (Criteria) this;
        }

        public Criteria andIsPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_PRIORITY not between", value1, value2, "isPriority");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeIsNull() {
            addCriterion("SHOW_DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeIsNotNull() {
            addCriterion("SHOW_DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeEqualTo(Date value) {
            addCriterion("SHOW_DATE_TIME =", value, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeNotEqualTo(Date value) {
            addCriterion("SHOW_DATE_TIME <>", value, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeGreaterThan(Date value) {
            addCriterion("SHOW_DATE_TIME >", value, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SHOW_DATE_TIME >=", value, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeLessThan(Date value) {
            addCriterion("SHOW_DATE_TIME <", value, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("SHOW_DATE_TIME <=", value, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeIn(List<Date> values) {
            addCriterion("SHOW_DATE_TIME in", values, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeNotIn(List<Date> values) {
            addCriterion("SHOW_DATE_TIME not in", values, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeBetween(Date value1, Date value2) {
            addCriterion("SHOW_DATE_TIME between", value1, value2, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andShowDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("SHOW_DATE_TIME not between", value1, value2, "showDateTime");
            return (Criteria) this;
        }

        public Criteria andIfDynamicIsNull() {
            addCriterion("IF_DYNAMIC is null");
            return (Criteria) this;
        }

        public Criteria andIfDynamicIsNotNull() {
            addCriterion("IF_DYNAMIC is not null");
            return (Criteria) this;
        }

        public Criteria andIfDynamicEqualTo(Integer value) {
            addCriterion("IF_DYNAMIC =", value, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicNotEqualTo(Integer value) {
            addCriterion("IF_DYNAMIC <>", value, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicGreaterThan(Integer value) {
            addCriterion("IF_DYNAMIC >", value, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicGreaterThanOrEqualTo(Integer value) {
            addCriterion("IF_DYNAMIC >=", value, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicLessThan(Integer value) {
            addCriterion("IF_DYNAMIC <", value, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicLessThanOrEqualTo(Integer value) {
            addCriterion("IF_DYNAMIC <=", value, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicIn(List<Integer> values) {
            addCriterion("IF_DYNAMIC in", values, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicNotIn(List<Integer> values) {
            addCriterion("IF_DYNAMIC not in", values, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicBetween(Integer value1, Integer value2) {
            addCriterion("IF_DYNAMIC between", value1, value2, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andIfDynamicNotBetween(Integer value1, Integer value2) {
            addCriterion("IF_DYNAMIC not between", value1, value2, "ifDynamic");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleIsNull() {
            addCriterion("HOTSPOT_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleIsNotNull() {
            addCriterion("HOTSPOT_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleEqualTo(String value) {
            addCriterion("HOTSPOT_TITLE =", value, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleNotEqualTo(String value) {
            addCriterion("HOTSPOT_TITLE <>", value, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleGreaterThan(String value) {
            addCriterion("HOTSPOT_TITLE >", value, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleGreaterThanOrEqualTo(String value) {
            addCriterion("HOTSPOT_TITLE >=", value, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleLessThan(String value) {
            addCriterion("HOTSPOT_TITLE <", value, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleLessThanOrEqualTo(String value) {
            addCriterion("HOTSPOT_TITLE <=", value, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleLike(String value) {
            addCriterion("HOTSPOT_TITLE like", value, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleNotLike(String value) {
            addCriterion("HOTSPOT_TITLE not like", value, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleIn(List<String> values) {
            addCriterion("HOTSPOT_TITLE in", values, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleNotIn(List<String> values) {
            addCriterion("HOTSPOT_TITLE not in", values, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleBetween(String value1, String value2) {
            addCriterion("HOTSPOT_TITLE between", value1, value2, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andHotspotTitleNotBetween(String value1, String value2) {
            addCriterion("HOTSPOT_TITLE not between", value1, value2, "hotspotTitle");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("IS_SHOW is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("IS_SHOW is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("IS_SHOW =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("IS_SHOW <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("IS_SHOW >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_SHOW >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("IS_SHOW <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("IS_SHOW <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Integer> values) {
            addCriterion("IS_SHOW in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Integer> values) {
            addCriterion("IS_SHOW not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("IS_SHOW between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_SHOW not between", value1, value2, "isShow");
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