package com.qiyun.model2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketPrintQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketPrintQuery() {
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNull() {
            addCriterion("plan_no is null");
            return (Criteria) this;
        }

        public Criteria andPlanNoIsNotNull() {
            addCriterion("plan_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNoEqualTo(Integer value) {
            addCriterion("plan_no =", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotEqualTo(Integer value) {
            addCriterion("plan_no <>", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThan(Integer value) {
            addCriterion("plan_no >", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_no >=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThan(Integer value) {
            addCriterion("plan_no <", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoLessThanOrEqualTo(Integer value) {
            addCriterion("plan_no <=", value, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoIn(List<Integer> values) {
            addCriterion("plan_no in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotIn(List<Integer> values) {
            addCriterion("plan_no not in", values, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoBetween(Integer value1, Integer value2) {
            addCriterion("plan_no between", value1, value2, "planNo");
            return (Criteria) this;
        }

        public Criteria andPlanNoNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_no not between", value1, value2, "planNo");
            return (Criteria) this;
        }

        public Criteria andPasstypeIsNull() {
            addCriterion("passType is null");
            return (Criteria) this;
        }

        public Criteria andPasstypeIsNotNull() {
            addCriterion("passType is not null");
            return (Criteria) this;
        }

        public Criteria andPasstypeEqualTo(String value) {
            addCriterion("passType =", value, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeNotEqualTo(String value) {
            addCriterion("passType <>", value, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeGreaterThan(String value) {
            addCriterion("passType >", value, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeGreaterThanOrEqualTo(String value) {
            addCriterion("passType >=", value, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeLessThan(String value) {
            addCriterion("passType <", value, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeLessThanOrEqualTo(String value) {
            addCriterion("passType <=", value, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeLike(String value) {
            addCriterion("passType like", value, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeNotLike(String value) {
            addCriterion("passType not like", value, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeIn(List<String> values) {
            addCriterion("passType in", values, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeNotIn(List<String> values) {
            addCriterion("passType not in", values, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeBetween(String value1, String value2) {
            addCriterion("passType between", value1, value2, "passtype");
            return (Criteria) this;
        }

        public Criteria andPasstypeNotBetween(String value1, String value2) {
            addCriterion("passType not between", value1, value2, "passtype");
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

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
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

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
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

        public Criteria andBonusEqualTo(BigDecimal value) {
            addCriterion("bonus =", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotEqualTo(BigDecimal value) {
            addCriterion("bonus <>", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThan(BigDecimal value) {
            addCriterion("bonus >", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus >=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThan(BigDecimal value) {
            addCriterion("bonus <", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus <=", value, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusIn(List<BigDecimal> values) {
            addCriterion("bonus in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotIn(List<BigDecimal> values) {
            addCriterion("bonus not in", values, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus between", value1, value2, "bonus");
            return (Criteria) this;
        }

        public Criteria andBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus not between", value1, value2, "bonus");
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

        public Criteria andResidueCountIsNull() {
            addCriterion("residue_count is null");
            return (Criteria) this;
        }

        public Criteria andResidueCountIsNotNull() {
            addCriterion("residue_count is not null");
            return (Criteria) this;
        }

        public Criteria andResidueCountEqualTo(Integer value) {
            addCriterion("residue_count =", value, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountNotEqualTo(Integer value) {
            addCriterion("residue_count <>", value, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountGreaterThan(Integer value) {
            addCriterion("residue_count >", value, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("residue_count >=", value, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountLessThan(Integer value) {
            addCriterion("residue_count <", value, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountLessThanOrEqualTo(Integer value) {
            addCriterion("residue_count <=", value, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountIn(List<Integer> values) {
            addCriterion("residue_count in", values, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountNotIn(List<Integer> values) {
            addCriterion("residue_count not in", values, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountBetween(Integer value1, Integer value2) {
            addCriterion("residue_count between", value1, value2, "residueCount");
            return (Criteria) this;
        }

        public Criteria andResidueCountNotBetween(Integer value1, Integer value2) {
            addCriterion("residue_count not between", value1, value2, "residueCount");
            return (Criteria) this;
        }

        public Criteria andPrintIdIsNull() {
            addCriterion("print_id is null");
            return (Criteria) this;
        }

        public Criteria andPrintIdIsNotNull() {
            addCriterion("print_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrintIdEqualTo(String value) {
            addCriterion("print_id =", value, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdNotEqualTo(String value) {
            addCriterion("print_id <>", value, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdGreaterThan(String value) {
            addCriterion("print_id >", value, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdGreaterThanOrEqualTo(String value) {
            addCriterion("print_id >=", value, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdLessThan(String value) {
            addCriterion("print_id <", value, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdLessThanOrEqualTo(String value) {
            addCriterion("print_id <=", value, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdLike(String value) {
            addCriterion("print_id like", value, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdNotLike(String value) {
            addCriterion("print_id not like", value, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdIn(List<String> values) {
            addCriterion("print_id in", values, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdNotIn(List<String> values) {
            addCriterion("print_id not in", values, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdBetween(String value1, String value2) {
            addCriterion("print_id between", value1, value2, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintIdNotBetween(String value1, String value2) {
            addCriterion("print_id not between", value1, value2, "printId");
            return (Criteria) this;
        }

        public Criteria andPrintAccountIsNull() {
            addCriterion("print_account is null");
            return (Criteria) this;
        }

        public Criteria andPrintAccountIsNotNull() {
            addCriterion("print_account is not null");
            return (Criteria) this;
        }

        public Criteria andPrintAccountEqualTo(String value) {
            addCriterion("print_account =", value, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountNotEqualTo(String value) {
            addCriterion("print_account <>", value, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountGreaterThan(String value) {
            addCriterion("print_account >", value, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountGreaterThanOrEqualTo(String value) {
            addCriterion("print_account >=", value, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountLessThan(String value) {
            addCriterion("print_account <", value, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountLessThanOrEqualTo(String value) {
            addCriterion("print_account <=", value, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountLike(String value) {
            addCriterion("print_account like", value, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountNotLike(String value) {
            addCriterion("print_account not like", value, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountIn(List<String> values) {
            addCriterion("print_account in", values, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountNotIn(List<String> values) {
            addCriterion("print_account not in", values, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountBetween(String value1, String value2) {
            addCriterion("print_account between", value1, value2, "printAccount");
            return (Criteria) this;
        }

        public Criteria andPrintAccountNotBetween(String value1, String value2) {
            addCriterion("print_account not between", value1, value2, "printAccount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("push_time is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("push_time is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("push_time =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("push_time <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("push_time >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("push_time >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("push_time <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("push_time <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("push_time in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("push_time not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("push_time between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("push_time not between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNull() {
            addCriterion("lottery_type is null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNotNull() {
            addCriterion("lottery_type is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeEqualTo(Integer value) {
            addCriterion("lottery_type =", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotEqualTo(Integer value) {
            addCriterion("lottery_type <>", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThan(Integer value) {
            addCriterion("lottery_type >", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_type >=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThan(Integer value) {
            addCriterion("lottery_type <", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_type <=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIn(List<Integer> values) {
            addCriterion("lottery_type in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotIn(List<Integer> values) {
            addCriterion("lottery_type not in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeBetween(Integer value1, Integer value2) {
            addCriterion("lottery_type between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_type not between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andDlAccountIsNull() {
            addCriterion("dl_account is null");
            return (Criteria) this;
        }

        public Criteria andDlAccountIsNotNull() {
            addCriterion("dl_account is not null");
            return (Criteria) this;
        }

        public Criteria andDlAccountEqualTo(String value) {
            addCriterion("dl_account =", value, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountNotEqualTo(String value) {
            addCriterion("dl_account <>", value, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountGreaterThan(String value) {
            addCriterion("dl_account >", value, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountGreaterThanOrEqualTo(String value) {
            addCriterion("dl_account >=", value, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountLessThan(String value) {
            addCriterion("dl_account <", value, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountLessThanOrEqualTo(String value) {
            addCriterion("dl_account <=", value, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountLike(String value) {
            addCriterion("dl_account like", value, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountNotLike(String value) {
            addCriterion("dl_account not like", value, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountIn(List<String> values) {
            addCriterion("dl_account in", values, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountNotIn(List<String> values) {
            addCriterion("dl_account not in", values, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountBetween(String value1, String value2) {
            addCriterion("dl_account between", value1, value2, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andDlAccountNotBetween(String value1, String value2) {
            addCriterion("dl_account not between", value1, value2, "dlAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountIsNull() {
            addCriterion("qd_account is null");
            return (Criteria) this;
        }

        public Criteria andQdAccountIsNotNull() {
            addCriterion("qd_account is not null");
            return (Criteria) this;
        }

        public Criteria andQdAccountEqualTo(String value) {
            addCriterion("qd_account =", value, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountNotEqualTo(String value) {
            addCriterion("qd_account <>", value, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountGreaterThan(String value) {
            addCriterion("qd_account >", value, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountGreaterThanOrEqualTo(String value) {
            addCriterion("qd_account >=", value, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountLessThan(String value) {
            addCriterion("qd_account <", value, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountLessThanOrEqualTo(String value) {
            addCriterion("qd_account <=", value, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountLike(String value) {
            addCriterion("qd_account like", value, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountNotLike(String value) {
            addCriterion("qd_account not like", value, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountIn(List<String> values) {
            addCriterion("qd_account in", values, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountNotIn(List<String> values) {
            addCriterion("qd_account not in", values, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountBetween(String value1, String value2) {
            addCriterion("qd_account between", value1, value2, "qdAccount");
            return (Criteria) this;
        }

        public Criteria andQdAccountNotBetween(String value1, String value2) {
            addCriterion("qd_account not between", value1, value2, "qdAccount");
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