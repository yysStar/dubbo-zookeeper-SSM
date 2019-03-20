package com.qiyun.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LotteryTerm2Query {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryTerm2Query() {
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

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(String value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(String value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(String value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(String value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(String value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(String value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLike(String value) {
            addCriterion("term like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotLike(String value) {
            addCriterion("term not like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<String> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<String> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(String value1, String value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(String value1, String value2) {
            addCriterion("term not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andOutTermIsNull() {
            addCriterion("out_term is null");
            return (Criteria) this;
        }

        public Criteria andOutTermIsNotNull() {
            addCriterion("out_term is not null");
            return (Criteria) this;
        }

        public Criteria andOutTermEqualTo(String value) {
            addCriterion("out_term =", value, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermNotEqualTo(String value) {
            addCriterion("out_term <>", value, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermGreaterThan(String value) {
            addCriterion("out_term >", value, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermGreaterThanOrEqualTo(String value) {
            addCriterion("out_term >=", value, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermLessThan(String value) {
            addCriterion("out_term <", value, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermLessThanOrEqualTo(String value) {
            addCriterion("out_term <=", value, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermLike(String value) {
            addCriterion("out_term like", value, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermNotLike(String value) {
            addCriterion("out_term not like", value, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermIn(List<String> values) {
            addCriterion("out_term in", values, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermNotIn(List<String> values) {
            addCriterion("out_term not in", values, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermBetween(String value1, String value2) {
            addCriterion("out_term between", value1, value2, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOutTermNotBetween(String value1, String value2) {
            addCriterion("out_term not between", value1, value2, "outTerm");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeIsNull() {
            addCriterion("open_date_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeIsNotNull() {
            addCriterion("open_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeEqualTo(Date value) {
            addCriterion("open_date_time =", value, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeNotEqualTo(Date value) {
            addCriterion("open_date_time <>", value, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeGreaterThan(Date value) {
            addCriterion("open_date_time >", value, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_date_time >=", value, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeLessThan(Date value) {
            addCriterion("open_date_time <", value, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_date_time <=", value, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeIn(List<Date> values) {
            addCriterion("open_date_time in", values, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeNotIn(List<Date> values) {
            addCriterion("open_date_time not in", values, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeBetween(Date value1, Date value2) {
            addCriterion("open_date_time between", value1, value2, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andOpenDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_date_time not between", value1, value2, "openDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeIsNull() {
            addCriterion("start_date_time is null");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeIsNotNull() {
            addCriterion("start_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeEqualTo(Date value) {
            addCriterion("start_date_time =", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotEqualTo(Date value) {
            addCriterion("start_date_time <>", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeGreaterThan(Date value) {
            addCriterion("start_date_time >", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date_time >=", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeLessThan(Date value) {
            addCriterion("start_date_time <", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_date_time <=", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeIn(List<Date> values) {
            addCriterion("start_date_time in", values, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotIn(List<Date> values) {
            addCriterion("start_date_time not in", values, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeBetween(Date value1, Date value2) {
            addCriterion("start_date_time between", value1, value2, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_date_time not between", value1, value2, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIsNull() {
            addCriterion("end_date_time is null");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIsNotNull() {
            addCriterion("end_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeEqualTo(Date value) {
            addCriterion("end_date_time =", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotEqualTo(Date value) {
            addCriterion("end_date_time <>", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeGreaterThan(Date value) {
            addCriterion("end_date_time >", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date_time >=", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLessThan(Date value) {
            addCriterion("end_date_time <", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_date_time <=", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIn(List<Date> values) {
            addCriterion("end_date_time in", values, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotIn(List<Date> values) {
            addCriterion("end_date_time not in", values, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeBetween(Date value1, Date value2) {
            addCriterion("end_date_time between", value1, value2, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_date_time not between", value1, value2, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeIsNull() {
            addCriterion("terminal_end_date_time is null");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeIsNotNull() {
            addCriterion("terminal_end_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeEqualTo(Date value) {
            addCriterion("terminal_end_date_time =", value, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeNotEqualTo(Date value) {
            addCriterion("terminal_end_date_time <>", value, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeGreaterThan(Date value) {
            addCriterion("terminal_end_date_time >", value, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("terminal_end_date_time >=", value, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeLessThan(Date value) {
            addCriterion("terminal_end_date_time <", value, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("terminal_end_date_time <=", value, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeIn(List<Date> values) {
            addCriterion("terminal_end_date_time in", values, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeNotIn(List<Date> values) {
            addCriterion("terminal_end_date_time not in", values, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeBetween(Date value1, Date value2) {
            addCriterion("terminal_end_date_time between", value1, value2, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andTerminalEndDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("terminal_end_date_time not between", value1, value2, "terminalEndDateTime");
            return (Criteria) this;
        }

        public Criteria andIsAbleIsNull() {
            addCriterion("is_able is null");
            return (Criteria) this;
        }

        public Criteria andIsAbleIsNotNull() {
            addCriterion("is_able is not null");
            return (Criteria) this;
        }

        public Criteria andIsAbleEqualTo(Integer value) {
            addCriterion("is_able =", value, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleNotEqualTo(Integer value) {
            addCriterion("is_able <>", value, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleGreaterThan(Integer value) {
            addCriterion("is_able >", value, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_able >=", value, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleLessThan(Integer value) {
            addCriterion("is_able <", value, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleLessThanOrEqualTo(Integer value) {
            addCriterion("is_able <=", value, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleIn(List<Integer> values) {
            addCriterion("is_able in", values, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleNotIn(List<Integer> values) {
            addCriterion("is_able not in", values, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleBetween(Integer value1, Integer value2) {
            addCriterion("is_able between", value1, value2, "isAble");
            return (Criteria) this;
        }

        public Criteria andIsAbleNotBetween(Integer value1, Integer value2) {
            addCriterion("is_able not between", value1, value2, "isAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleIsNull() {
            addCriterion("lot_mgr_is_able is null");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleIsNotNull() {
            addCriterion("lot_mgr_is_able is not null");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleEqualTo(Integer value) {
            addCriterion("lot_mgr_is_able =", value, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleNotEqualTo(Integer value) {
            addCriterion("lot_mgr_is_able <>", value, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleGreaterThan(Integer value) {
            addCriterion("lot_mgr_is_able >", value, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleGreaterThanOrEqualTo(Integer value) {
            addCriterion("lot_mgr_is_able >=", value, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleLessThan(Integer value) {
            addCriterion("lot_mgr_is_able <", value, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleLessThanOrEqualTo(Integer value) {
            addCriterion("lot_mgr_is_able <=", value, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleIn(List<Integer> values) {
            addCriterion("lot_mgr_is_able in", values, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleNotIn(List<Integer> values) {
            addCriterion("lot_mgr_is_able not in", values, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleBetween(Integer value1, Integer value2) {
            addCriterion("lot_mgr_is_able between", value1, value2, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andLotMgrIsAbleNotBetween(Integer value1, Integer value2) {
            addCriterion("lot_mgr_is_able not between", value1, value2, "lotMgrIsAble");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermIsNull() {
            addCriterion("is_current_term is null");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermIsNotNull() {
            addCriterion("is_current_term is not null");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermEqualTo(Integer value) {
            addCriterion("is_current_term =", value, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermNotEqualTo(Integer value) {
            addCriterion("is_current_term <>", value, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermGreaterThan(Integer value) {
            addCriterion("is_current_term >", value, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_current_term >=", value, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermLessThan(Integer value) {
            addCriterion("is_current_term <", value, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermLessThanOrEqualTo(Integer value) {
            addCriterion("is_current_term <=", value, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermIn(List<Integer> values) {
            addCriterion("is_current_term in", values, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermNotIn(List<Integer> values) {
            addCriterion("is_current_term not in", values, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermBetween(Integer value1, Integer value2) {
            addCriterion("is_current_term between", value1, value2, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsCurrentTermNotBetween(Integer value1, Integer value2) {
            addCriterion("is_current_term not between", value1, value2, "isCurrentTerm");
            return (Criteria) this;
        }

        public Criteria andIsBookingIsNull() {
            addCriterion("is_booking is null");
            return (Criteria) this;
        }

        public Criteria andIsBookingIsNotNull() {
            addCriterion("is_booking is not null");
            return (Criteria) this;
        }

        public Criteria andIsBookingEqualTo(Integer value) {
            addCriterion("is_booking =", value, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingNotEqualTo(Integer value) {
            addCriterion("is_booking <>", value, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingGreaterThan(Integer value) {
            addCriterion("is_booking >", value, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_booking >=", value, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingLessThan(Integer value) {
            addCriterion("is_booking <", value, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingLessThanOrEqualTo(Integer value) {
            addCriterion("is_booking <=", value, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingIn(List<Integer> values) {
            addCriterion("is_booking in", values, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingNotIn(List<Integer> values) {
            addCriterion("is_booking not in", values, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingBetween(Integer value1, Integer value2) {
            addCriterion("is_booking between", value1, value2, "isBooking");
            return (Criteria) this;
        }

        public Criteria andIsBookingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_booking not between", value1, value2, "isBooking");
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

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(String value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(String value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(String value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(String value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(String value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(String value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLike(String value) {
            addCriterion("total_amount like", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotLike(String value) {
            addCriterion("total_amount not like", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<String> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<String> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(String value1, String value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(String value1, String value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andAwardPoolIsNull() {
            addCriterion("award_pool is null");
            return (Criteria) this;
        }

        public Criteria andAwardPoolIsNotNull() {
            addCriterion("award_pool is not null");
            return (Criteria) this;
        }

        public Criteria andAwardPoolEqualTo(String value) {
            addCriterion("award_pool =", value, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolNotEqualTo(String value) {
            addCriterion("award_pool <>", value, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolGreaterThan(String value) {
            addCriterion("award_pool >", value, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolGreaterThanOrEqualTo(String value) {
            addCriterion("award_pool >=", value, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolLessThan(String value) {
            addCriterion("award_pool <", value, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolLessThanOrEqualTo(String value) {
            addCriterion("award_pool <=", value, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolLike(String value) {
            addCriterion("award_pool like", value, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolNotLike(String value) {
            addCriterion("award_pool not like", value, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolIn(List<String> values) {
            addCriterion("award_pool in", values, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolNotIn(List<String> values) {
            addCriterion("award_pool not in", values, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolBetween(String value1, String value2) {
            addCriterion("award_pool between", value1, value2, "awardPool");
            return (Criteria) this;
        }

        public Criteria andAwardPoolNotBetween(String value1, String value2) {
            addCriterion("award_pool not between", value1, value2, "awardPool");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeIsNull() {
            addCriterion("test_machine_code is null");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeIsNotNull() {
            addCriterion("test_machine_code is not null");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeEqualTo(String value) {
            addCriterion("test_machine_code =", value, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeNotEqualTo(String value) {
            addCriterion("test_machine_code <>", value, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeGreaterThan(String value) {
            addCriterion("test_machine_code >", value, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeGreaterThanOrEqualTo(String value) {
            addCriterion("test_machine_code >=", value, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeLessThan(String value) {
            addCriterion("test_machine_code <", value, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeLessThanOrEqualTo(String value) {
            addCriterion("test_machine_code <=", value, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeLike(String value) {
            addCriterion("test_machine_code like", value, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeNotLike(String value) {
            addCriterion("test_machine_code not like", value, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeIn(List<String> values) {
            addCriterion("test_machine_code in", values, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeNotIn(List<String> values) {
            addCriterion("test_machine_code not in", values, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeBetween(String value1, String value2) {
            addCriterion("test_machine_code between", value1, value2, "testMachineCode");
            return (Criteria) this;
        }

        public Criteria andTestMachineCodeNotBetween(String value1, String value2) {
            addCriterion("test_machine_code not between", value1, value2, "testMachineCode");
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