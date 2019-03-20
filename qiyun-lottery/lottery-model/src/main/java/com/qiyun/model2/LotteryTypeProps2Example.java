package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class LotteryTypeProps2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryTypeProps2Example() {
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

        public Criteria andCountInBatchIsNull() {
            addCriterion("COUNT_IN_BATCH is null");
            return (Criteria) this;
        }

        public Criteria andCountInBatchIsNotNull() {
            addCriterion("COUNT_IN_BATCH is not null");
            return (Criteria) this;
        }

        public Criteria andCountInBatchEqualTo(Integer value) {
            addCriterion("COUNT_IN_BATCH =", value, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchNotEqualTo(Integer value) {
            addCriterion("COUNT_IN_BATCH <>", value, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchGreaterThan(Integer value) {
            addCriterion("COUNT_IN_BATCH >", value, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchGreaterThanOrEqualTo(Integer value) {
            addCriterion("COUNT_IN_BATCH >=", value, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchLessThan(Integer value) {
            addCriterion("COUNT_IN_BATCH <", value, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchLessThanOrEqualTo(Integer value) {
            addCriterion("COUNT_IN_BATCH <=", value, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchIn(List<Integer> values) {
            addCriterion("COUNT_IN_BATCH in", values, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchNotIn(List<Integer> values) {
            addCriterion("COUNT_IN_BATCH not in", values, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchBetween(Integer value1, Integer value2) {
            addCriterion("COUNT_IN_BATCH between", value1, value2, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andCountInBatchNotBetween(Integer value1, Integer value2) {
            addCriterion("COUNT_IN_BATCH not between", value1, value2, "countInBatch");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeIsNull() {
            addCriterion("MAX_WAIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeIsNotNull() {
            addCriterion("MAX_WAIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeEqualTo(Integer value) {
            addCriterion("MAX_WAIT_TIME =", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeNotEqualTo(Integer value) {
            addCriterion("MAX_WAIT_TIME <>", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeGreaterThan(Integer value) {
            addCriterion("MAX_WAIT_TIME >", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_WAIT_TIME >=", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeLessThan(Integer value) {
            addCriterion("MAX_WAIT_TIME <", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_WAIT_TIME <=", value, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeIn(List<Integer> values) {
            addCriterion("MAX_WAIT_TIME in", values, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeNotIn(List<Integer> values) {
            addCriterion("MAX_WAIT_TIME not in", values, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeBetween(Integer value1, Integer value2) {
            addCriterion("MAX_WAIT_TIME between", value1, value2, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andMaxWaitTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_WAIT_TIME not between", value1, value2, "maxWaitTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeIsNull() {
            addCriterion("DS_AHEAD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeIsNotNull() {
            addCriterion("DS_AHEAD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeEqualTo(Integer value) {
            addCriterion("DS_AHEAD_TIME =", value, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeNotEqualTo(Integer value) {
            addCriterion("DS_AHEAD_TIME <>", value, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeGreaterThan(Integer value) {
            addCriterion("DS_AHEAD_TIME >", value, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DS_AHEAD_TIME >=", value, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeLessThan(Integer value) {
            addCriterion("DS_AHEAD_TIME <", value, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeLessThanOrEqualTo(Integer value) {
            addCriterion("DS_AHEAD_TIME <=", value, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeIn(List<Integer> values) {
            addCriterion("DS_AHEAD_TIME in", values, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeNotIn(List<Integer> values) {
            addCriterion("DS_AHEAD_TIME not in", values, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeBetween(Integer value1, Integer value2) {
            addCriterion("DS_AHEAD_TIME between", value1, value2, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andDsAheadTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("DS_AHEAD_TIME not between", value1, value2, "dsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeIsNull() {
            addCriterion("FS_AHEAD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeIsNotNull() {
            addCriterion("FS_AHEAD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeEqualTo(Integer value) {
            addCriterion("FS_AHEAD_TIME =", value, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeNotEqualTo(Integer value) {
            addCriterion("FS_AHEAD_TIME <>", value, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeGreaterThan(Integer value) {
            addCriterion("FS_AHEAD_TIME >", value, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FS_AHEAD_TIME >=", value, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeLessThan(Integer value) {
            addCriterion("FS_AHEAD_TIME <", value, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeLessThanOrEqualTo(Integer value) {
            addCriterion("FS_AHEAD_TIME <=", value, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeIn(List<Integer> values) {
            addCriterion("FS_AHEAD_TIME in", values, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeNotIn(List<Integer> values) {
            addCriterion("FS_AHEAD_TIME not in", values, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeBetween(Integer value1, Integer value2) {
            addCriterion("FS_AHEAD_TIME between", value1, value2, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andFsAheadTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("FS_AHEAD_TIME not between", value1, value2, "fsAheadTime");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("DISCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("DISCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("DISCOUNT =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("DISCOUNT <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("DISCOUNT >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("DISCOUNT >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("DISCOUNT <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("DISCOUNT <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("DISCOUNT in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("DISCOUNT not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("DISCOUNT between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("DISCOUNT not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Long value) {
            addCriterion("TOTAL =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Long value) {
            addCriterion("TOTAL <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Long value) {
            addCriterion("TOTAL >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Long value) {
            addCriterion("TOTAL <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Long> values) {
            addCriterion("TOTAL in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Long> values) {
            addCriterion("TOTAL not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Long value1, Long value2) {
            addCriterion("TOTAL between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("DESCRIBE =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("DESCRIBE <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("DESCRIBE >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIBE >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("DESCRIBE <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("DESCRIBE <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("DESCRIBE like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("DESCRIBE not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("DESCRIBE in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("DESCRIBE not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("DESCRIBE between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("DESCRIBE not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesIsNull() {
            addCriterion("IS_HOT_SALES is null");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesIsNotNull() {
            addCriterion("IS_HOT_SALES is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesEqualTo(Long value) {
            addCriterion("IS_HOT_SALES =", value, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesNotEqualTo(Long value) {
            addCriterion("IS_HOT_SALES <>", value, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesGreaterThan(Long value) {
            addCriterion("IS_HOT_SALES >", value, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesGreaterThanOrEqualTo(Long value) {
            addCriterion("IS_HOT_SALES >=", value, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesLessThan(Long value) {
            addCriterion("IS_HOT_SALES <", value, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesLessThanOrEqualTo(Long value) {
            addCriterion("IS_HOT_SALES <=", value, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesIn(List<Long> values) {
            addCriterion("IS_HOT_SALES in", values, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesNotIn(List<Long> values) {
            addCriterion("IS_HOT_SALES not in", values, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesBetween(Long value1, Long value2) {
            addCriterion("IS_HOT_SALES between", value1, value2, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andIsHotSalesNotBetween(Long value1, Long value2) {
            addCriterion("IS_HOT_SALES not between", value1, value2, "isHotSales");
            return (Criteria) this;
        }

        public Criteria andPresentationIsNull() {
            addCriterion("PRESENTATION is null");
            return (Criteria) this;
        }

        public Criteria andPresentationIsNotNull() {
            addCriterion("PRESENTATION is not null");
            return (Criteria) this;
        }

        public Criteria andPresentationEqualTo(String value) {
            addCriterion("PRESENTATION =", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationNotEqualTo(String value) {
            addCriterion("PRESENTATION <>", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationGreaterThan(String value) {
            addCriterion("PRESENTATION >", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationGreaterThanOrEqualTo(String value) {
            addCriterion("PRESENTATION >=", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationLessThan(String value) {
            addCriterion("PRESENTATION <", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationLessThanOrEqualTo(String value) {
            addCriterion("PRESENTATION <=", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationLike(String value) {
            addCriterion("PRESENTATION like", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationNotLike(String value) {
            addCriterion("PRESENTATION not like", value, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationIn(List<String> values) {
            addCriterion("PRESENTATION in", values, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationNotIn(List<String> values) {
            addCriterion("PRESENTATION not in", values, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationBetween(String value1, String value2) {
            addCriterion("PRESENTATION between", value1, value2, "presentation");
            return (Criteria) this;
        }

        public Criteria andPresentationNotBetween(String value1, String value2) {
            addCriterion("PRESENTATION not between", value1, value2, "presentation");
            return (Criteria) this;
        }

        public Criteria andPromotionIsNull() {
            addCriterion("PROMOTION is null");
            return (Criteria) this;
        }

        public Criteria andPromotionIsNotNull() {
            addCriterion("PROMOTION is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionEqualTo(Long value) {
            addCriterion("PROMOTION =", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionNotEqualTo(Long value) {
            addCriterion("PROMOTION <>", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionGreaterThan(Long value) {
            addCriterion("PROMOTION >", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionGreaterThanOrEqualTo(Long value) {
            addCriterion("PROMOTION >=", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionLessThan(Long value) {
            addCriterion("PROMOTION <", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionLessThanOrEqualTo(Long value) {
            addCriterion("PROMOTION <=", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionIn(List<Long> values) {
            addCriterion("PROMOTION in", values, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionNotIn(List<Long> values) {
            addCriterion("PROMOTION not in", values, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionBetween(Long value1, Long value2) {
            addCriterion("PROMOTION between", value1, value2, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionNotBetween(Long value1, Long value2) {
            addCriterion("PROMOTION not between", value1, value2, "promotion");
            return (Criteria) this;
        }

        public Criteria andDefaultSortIsNull() {
            addCriterion("DEFAULT_SORT is null");
            return (Criteria) this;
        }

        public Criteria andDefaultSortIsNotNull() {
            addCriterion("DEFAULT_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultSortEqualTo(Long value) {
            addCriterion("DEFAULT_SORT =", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortNotEqualTo(Long value) {
            addCriterion("DEFAULT_SORT <>", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortGreaterThan(Long value) {
            addCriterion("DEFAULT_SORT >", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortGreaterThanOrEqualTo(Long value) {
            addCriterion("DEFAULT_SORT >=", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortLessThan(Long value) {
            addCriterion("DEFAULT_SORT <", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortLessThanOrEqualTo(Long value) {
            addCriterion("DEFAULT_SORT <=", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortIn(List<Long> values) {
            addCriterion("DEFAULT_SORT in", values, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortNotIn(List<Long> values) {
            addCriterion("DEFAULT_SORT not in", values, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortBetween(Long value1, Long value2) {
            addCriterion("DEFAULT_SORT between", value1, value2, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortNotBetween(Long value1, Long value2) {
            addCriterion("DEFAULT_SORT not between", value1, value2, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andOnImpIsNull() {
            addCriterion("ON_IMP is null");
            return (Criteria) this;
        }

        public Criteria andOnImpIsNotNull() {
            addCriterion("ON_IMP is not null");
            return (Criteria) this;
        }

        public Criteria andOnImpEqualTo(String value) {
            addCriterion("ON_IMP =", value, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpNotEqualTo(String value) {
            addCriterion("ON_IMP <>", value, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpGreaterThan(String value) {
            addCriterion("ON_IMP >", value, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpGreaterThanOrEqualTo(String value) {
            addCriterion("ON_IMP >=", value, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpLessThan(String value) {
            addCriterion("ON_IMP <", value, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpLessThanOrEqualTo(String value) {
            addCriterion("ON_IMP <=", value, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpLike(String value) {
            addCriterion("ON_IMP like", value, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpNotLike(String value) {
            addCriterion("ON_IMP not like", value, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpIn(List<String> values) {
            addCriterion("ON_IMP in", values, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpNotIn(List<String> values) {
            addCriterion("ON_IMP not in", values, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpBetween(String value1, String value2) {
            addCriterion("ON_IMP between", value1, value2, "onImp");
            return (Criteria) this;
        }

        public Criteria andOnImpNotBetween(String value1, String value2) {
            addCriterion("ON_IMP not between", value1, value2, "onImp");
            return (Criteria) this;
        }

        public Criteria andStopImpIsNull() {
            addCriterion("STOP_IMP is null");
            return (Criteria) this;
        }

        public Criteria andStopImpIsNotNull() {
            addCriterion("STOP_IMP is not null");
            return (Criteria) this;
        }

        public Criteria andStopImpEqualTo(String value) {
            addCriterion("STOP_IMP =", value, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpNotEqualTo(String value) {
            addCriterion("STOP_IMP <>", value, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpGreaterThan(String value) {
            addCriterion("STOP_IMP >", value, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpGreaterThanOrEqualTo(String value) {
            addCriterion("STOP_IMP >=", value, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpLessThan(String value) {
            addCriterion("STOP_IMP <", value, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpLessThanOrEqualTo(String value) {
            addCriterion("STOP_IMP <=", value, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpLike(String value) {
            addCriterion("STOP_IMP like", value, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpNotLike(String value) {
            addCriterion("STOP_IMP not like", value, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpIn(List<String> values) {
            addCriterion("STOP_IMP in", values, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpNotIn(List<String> values) {
            addCriterion("STOP_IMP not in", values, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpBetween(String value1, String value2) {
            addCriterion("STOP_IMP between", value1, value2, "stopImp");
            return (Criteria) this;
        }

        public Criteria andStopImpNotBetween(String value1, String value2) {
            addCriterion("STOP_IMP not between", value1, value2, "stopImp");
            return (Criteria) this;
        }

        public Criteria andBuyLinkIsNull() {
            addCriterion("BUY_LINK is null");
            return (Criteria) this;
        }

        public Criteria andBuyLinkIsNotNull() {
            addCriterion("BUY_LINK is not null");
            return (Criteria) this;
        }

        public Criteria andBuyLinkEqualTo(String value) {
            addCriterion("BUY_LINK =", value, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkNotEqualTo(String value) {
            addCriterion("BUY_LINK <>", value, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkGreaterThan(String value) {
            addCriterion("BUY_LINK >", value, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkGreaterThanOrEqualTo(String value) {
            addCriterion("BUY_LINK >=", value, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkLessThan(String value) {
            addCriterion("BUY_LINK <", value, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkLessThanOrEqualTo(String value) {
            addCriterion("BUY_LINK <=", value, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkLike(String value) {
            addCriterion("BUY_LINK like", value, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkNotLike(String value) {
            addCriterion("BUY_LINK not like", value, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkIn(List<String> values) {
            addCriterion("BUY_LINK in", values, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkNotIn(List<String> values) {
            addCriterion("BUY_LINK not in", values, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkBetween(String value1, String value2) {
            addCriterion("BUY_LINK between", value1, value2, "buyLink");
            return (Criteria) this;
        }

        public Criteria andBuyLinkNotBetween(String value1, String value2) {
            addCriterion("BUY_LINK not between", value1, value2, "buyLink");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgIsNull() {
            addCriterion("LOTTERY_GUIDE_IMG is null");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgIsNotNull() {
            addCriterion("LOTTERY_GUIDE_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgEqualTo(String value) {
            addCriterion("LOTTERY_GUIDE_IMG =", value, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgNotEqualTo(String value) {
            addCriterion("LOTTERY_GUIDE_IMG <>", value, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgGreaterThan(String value) {
            addCriterion("LOTTERY_GUIDE_IMG >", value, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgGreaterThanOrEqualTo(String value) {
            addCriterion("LOTTERY_GUIDE_IMG >=", value, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgLessThan(String value) {
            addCriterion("LOTTERY_GUIDE_IMG <", value, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgLessThanOrEqualTo(String value) {
            addCriterion("LOTTERY_GUIDE_IMG <=", value, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgLike(String value) {
            addCriterion("LOTTERY_GUIDE_IMG like", value, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgNotLike(String value) {
            addCriterion("LOTTERY_GUIDE_IMG not like", value, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgIn(List<String> values) {
            addCriterion("LOTTERY_GUIDE_IMG in", values, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgNotIn(List<String> values) {
            addCriterion("LOTTERY_GUIDE_IMG not in", values, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgBetween(String value1, String value2) {
            addCriterion("LOTTERY_GUIDE_IMG between", value1, value2, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andLotteryGuideImgNotBetween(String value1, String value2) {
            addCriterion("LOTTERY_GUIDE_IMG not between", value1, value2, "lotteryGuideImg");
            return (Criteria) this;
        }

        public Criteria andStopCauseIsNull() {
            addCriterion("STOP_CAUSE is null");
            return (Criteria) this;
        }

        public Criteria andStopCauseIsNotNull() {
            addCriterion("STOP_CAUSE is not null");
            return (Criteria) this;
        }

        public Criteria andStopCauseEqualTo(String value) {
            addCriterion("STOP_CAUSE =", value, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseNotEqualTo(String value) {
            addCriterion("STOP_CAUSE <>", value, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseGreaterThan(String value) {
            addCriterion("STOP_CAUSE >", value, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseGreaterThanOrEqualTo(String value) {
            addCriterion("STOP_CAUSE >=", value, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseLessThan(String value) {
            addCriterion("STOP_CAUSE <", value, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseLessThanOrEqualTo(String value) {
            addCriterion("STOP_CAUSE <=", value, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseLike(String value) {
            addCriterion("STOP_CAUSE like", value, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseNotLike(String value) {
            addCriterion("STOP_CAUSE not like", value, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseIn(List<String> values) {
            addCriterion("STOP_CAUSE in", values, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseNotIn(List<String> values) {
            addCriterion("STOP_CAUSE not in", values, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseBetween(String value1, String value2) {
            addCriterion("STOP_CAUSE between", value1, value2, "stopCause");
            return (Criteria) this;
        }

        public Criteria andStopCauseNotBetween(String value1, String value2) {
            addCriterion("STOP_CAUSE not between", value1, value2, "stopCause");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryIsNull() {
            addCriterion("CMD_LOTTERY is null");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryIsNotNull() {
            addCriterion("CMD_LOTTERY is not null");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryEqualTo(String value) {
            addCriterion("CMD_LOTTERY =", value, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryNotEqualTo(String value) {
            addCriterion("CMD_LOTTERY <>", value, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryGreaterThan(String value) {
            addCriterion("CMD_LOTTERY >", value, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryGreaterThanOrEqualTo(String value) {
            addCriterion("CMD_LOTTERY >=", value, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryLessThan(String value) {
            addCriterion("CMD_LOTTERY <", value, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryLessThanOrEqualTo(String value) {
            addCriterion("CMD_LOTTERY <=", value, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryLike(String value) {
            addCriterion("CMD_LOTTERY like", value, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryNotLike(String value) {
            addCriterion("CMD_LOTTERY not like", value, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryIn(List<String> values) {
            addCriterion("CMD_LOTTERY in", values, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryNotIn(List<String> values) {
            addCriterion("CMD_LOTTERY not in", values, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryBetween(String value1, String value2) {
            addCriterion("CMD_LOTTERY between", value1, value2, "cmdLottery");
            return (Criteria) this;
        }

        public Criteria andCmdLotteryNotBetween(String value1, String value2) {
            addCriterion("CMD_LOTTERY not between", value1, value2, "cmdLottery");
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