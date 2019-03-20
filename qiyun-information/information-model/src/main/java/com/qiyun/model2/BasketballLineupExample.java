package com.qiyun.model2;

import java.util.ArrayList;
import java.util.List;

public class BasketballLineupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasketballLineupExample() {
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

        public Criteria andHomeLineupIsNull() {
            addCriterion("home_lineup is null");
            return (Criteria) this;
        }

        public Criteria andHomeLineupIsNotNull() {
            addCriterion("home_lineup is not null");
            return (Criteria) this;
        }

        public Criteria andHomeLineupEqualTo(String value) {
            addCriterion("home_lineup =", value, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupNotEqualTo(String value) {
            addCriterion("home_lineup <>", value, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGreaterThan(String value) {
            addCriterion("home_lineup >", value, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGreaterThanOrEqualTo(String value) {
            addCriterion("home_lineup >=", value, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupLessThan(String value) {
            addCriterion("home_lineup <", value, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupLessThanOrEqualTo(String value) {
            addCriterion("home_lineup <=", value, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupLike(String value) {
            addCriterion("home_lineup like", value, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupNotLike(String value) {
            addCriterion("home_lineup not like", value, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupIn(List<String> values) {
            addCriterion("home_lineup in", values, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupNotIn(List<String> values) {
            addCriterion("home_lineup not in", values, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupBetween(String value1, String value2) {
            addCriterion("home_lineup between", value1, value2, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeLineupNotBetween(String value1, String value2) {
            addCriterion("home_lineup not between", value1, value2, "homeLineup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupIsNull() {
            addCriterion("home_backup is null");
            return (Criteria) this;
        }

        public Criteria andHomeBackupIsNotNull() {
            addCriterion("home_backup is not null");
            return (Criteria) this;
        }

        public Criteria andHomeBackupEqualTo(String value) {
            addCriterion("home_backup =", value, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupNotEqualTo(String value) {
            addCriterion("home_backup <>", value, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGreaterThan(String value) {
            addCriterion("home_backup >", value, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGreaterThanOrEqualTo(String value) {
            addCriterion("home_backup >=", value, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupLessThan(String value) {
            addCriterion("home_backup <", value, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupLessThanOrEqualTo(String value) {
            addCriterion("home_backup <=", value, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupLike(String value) {
            addCriterion("home_backup like", value, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupNotLike(String value) {
            addCriterion("home_backup not like", value, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupIn(List<String> values) {
            addCriterion("home_backup in", values, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupNotIn(List<String> values) {
            addCriterion("home_backup not in", values, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupBetween(String value1, String value2) {
            addCriterion("home_backup between", value1, value2, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andHomeBackupNotBetween(String value1, String value2) {
            addCriterion("home_backup not between", value1, value2, "homeBackup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupIsNull() {
            addCriterion("away_lineup is null");
            return (Criteria) this;
        }

        public Criteria andAwayLineupIsNotNull() {
            addCriterion("away_lineup is not null");
            return (Criteria) this;
        }

        public Criteria andAwayLineupEqualTo(String value) {
            addCriterion("away_lineup =", value, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupNotEqualTo(String value) {
            addCriterion("away_lineup <>", value, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGreaterThan(String value) {
            addCriterion("away_lineup >", value, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGreaterThanOrEqualTo(String value) {
            addCriterion("away_lineup >=", value, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupLessThan(String value) {
            addCriterion("away_lineup <", value, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupLessThanOrEqualTo(String value) {
            addCriterion("away_lineup <=", value, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupLike(String value) {
            addCriterion("away_lineup like", value, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupNotLike(String value) {
            addCriterion("away_lineup not like", value, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupIn(List<String> values) {
            addCriterion("away_lineup in", values, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupNotIn(List<String> values) {
            addCriterion("away_lineup not in", values, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupBetween(String value1, String value2) {
            addCriterion("away_lineup between", value1, value2, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayLineupNotBetween(String value1, String value2) {
            addCriterion("away_lineup not between", value1, value2, "awayLineup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupIsNull() {
            addCriterion("away_backup is null");
            return (Criteria) this;
        }

        public Criteria andAwayBackupIsNotNull() {
            addCriterion("away_backup is not null");
            return (Criteria) this;
        }

        public Criteria andAwayBackupEqualTo(String value) {
            addCriterion("away_backup =", value, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupNotEqualTo(String value) {
            addCriterion("away_backup <>", value, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGreaterThan(String value) {
            addCriterion("away_backup >", value, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGreaterThanOrEqualTo(String value) {
            addCriterion("away_backup >=", value, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupLessThan(String value) {
            addCriterion("away_backup <", value, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupLessThanOrEqualTo(String value) {
            addCriterion("away_backup <=", value, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupLike(String value) {
            addCriterion("away_backup like", value, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupNotLike(String value) {
            addCriterion("away_backup not like", value, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupIn(List<String> values) {
            addCriterion("away_backup in", values, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupNotIn(List<String> values) {
            addCriterion("away_backup not in", values, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupBetween(String value1, String value2) {
            addCriterion("away_backup between", value1, value2, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAwayBackupNotBetween(String value1, String value2) {
            addCriterion("away_backup not between", value1, value2, "awayBackup");
            return (Criteria) this;
        }

        public Criteria andAnalyzesIsNull() {
            addCriterion("analyzes is null");
            return (Criteria) this;
        }

        public Criteria andAnalyzesIsNotNull() {
            addCriterion("analyzes is not null");
            return (Criteria) this;
        }

        public Criteria andAnalyzesEqualTo(String value) {
            addCriterion("analyzes =", value, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesNotEqualTo(String value) {
            addCriterion("analyzes <>", value, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGreaterThan(String value) {
            addCriterion("analyzes >", value, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGreaterThanOrEqualTo(String value) {
            addCriterion("analyzes >=", value, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesLessThan(String value) {
            addCriterion("analyzes <", value, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesLessThanOrEqualTo(String value) {
            addCriterion("analyzes <=", value, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesLike(String value) {
            addCriterion("analyzes like", value, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesNotLike(String value) {
            addCriterion("analyzes not like", value, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesIn(List<String> values) {
            addCriterion("analyzes in", values, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesNotIn(List<String> values) {
            addCriterion("analyzes not in", values, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesBetween(String value1, String value2) {
            addCriterion("analyzes between", value1, value2, "analyzes");
            return (Criteria) this;
        }

        public Criteria andAnalyzesNotBetween(String value1, String value2) {
            addCriterion("analyzes not between", value1, value2, "analyzes");
            return (Criteria) this;
        }

        public Criteria andInjuryIsNull() {
            addCriterion("injury is null");
            return (Criteria) this;
        }

        public Criteria andInjuryIsNotNull() {
            addCriterion("injury is not null");
            return (Criteria) this;
        }

        public Criteria andInjuryEqualTo(String value) {
            addCriterion("injury =", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotEqualTo(String value) {
            addCriterion("injury <>", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryGreaterThan(String value) {
            addCriterion("injury >", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryGreaterThanOrEqualTo(String value) {
            addCriterion("injury >=", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryLessThan(String value) {
            addCriterion("injury <", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryLessThanOrEqualTo(String value) {
            addCriterion("injury <=", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryLike(String value) {
            addCriterion("injury like", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotLike(String value) {
            addCriterion("injury not like", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryIn(List<String> values) {
            addCriterion("injury in", values, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotIn(List<String> values) {
            addCriterion("injury not in", values, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryBetween(String value1, String value2) {
            addCriterion("injury between", value1, value2, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotBetween(String value1, String value2) {
            addCriterion("injury not between", value1, value2, "injury");
            return (Criteria) this;
        }

        public Criteria andHomeNear6IsNull() {
            addCriterion("home_Near6 is null");
            return (Criteria) this;
        }

        public Criteria andHomeNear6IsNotNull() {
            addCriterion("home_Near6 is not null");
            return (Criteria) this;
        }

        public Criteria andHomeNear6EqualTo(String value) {
            addCriterion("home_Near6 =", value, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6NotEqualTo(String value) {
            addCriterion("home_Near6 <>", value, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6GreaterThan(String value) {
            addCriterion("home_Near6 >", value, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6GreaterThanOrEqualTo(String value) {
            addCriterion("home_Near6 >=", value, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6LessThan(String value) {
            addCriterion("home_Near6 <", value, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6LessThanOrEqualTo(String value) {
            addCriterion("home_Near6 <=", value, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6Like(String value) {
            addCriterion("home_Near6 like", value, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6NotLike(String value) {
            addCriterion("home_Near6 not like", value, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6In(List<String> values) {
            addCriterion("home_Near6 in", values, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6NotIn(List<String> values) {
            addCriterion("home_Near6 not in", values, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6Between(String value1, String value2) {
            addCriterion("home_Near6 between", value1, value2, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeNear6NotBetween(String value1, String value2) {
            addCriterion("home_Near6 not between", value1, value2, "homeNear6");
            return (Criteria) this;
        }

        public Criteria andHomeOddsIsNull() {
            addCriterion("home_odds is null");
            return (Criteria) this;
        }

        public Criteria andHomeOddsIsNotNull() {
            addCriterion("home_odds is not null");
            return (Criteria) this;
        }

        public Criteria andHomeOddsEqualTo(String value) {
            addCriterion("home_odds =", value, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsNotEqualTo(String value) {
            addCriterion("home_odds <>", value, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsGreaterThan(String value) {
            addCriterion("home_odds >", value, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsGreaterThanOrEqualTo(String value) {
            addCriterion("home_odds >=", value, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsLessThan(String value) {
            addCriterion("home_odds <", value, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsLessThanOrEqualTo(String value) {
            addCriterion("home_odds <=", value, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsLike(String value) {
            addCriterion("home_odds like", value, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsNotLike(String value) {
            addCriterion("home_odds not like", value, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsIn(List<String> values) {
            addCriterion("home_odds in", values, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsNotIn(List<String> values) {
            addCriterion("home_odds not in", values, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsBetween(String value1, String value2) {
            addCriterion("home_odds between", value1, value2, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOddsNotBetween(String value1, String value2) {
            addCriterion("home_odds not between", value1, value2, "homeOdds");
            return (Criteria) this;
        }

        public Criteria andHomeOuIsNull() {
            addCriterion("home_ou is null");
            return (Criteria) this;
        }

        public Criteria andHomeOuIsNotNull() {
            addCriterion("home_ou is not null");
            return (Criteria) this;
        }

        public Criteria andHomeOuEqualTo(String value) {
            addCriterion("home_ou =", value, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuNotEqualTo(String value) {
            addCriterion("home_ou <>", value, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuGreaterThan(String value) {
            addCriterion("home_ou >", value, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuGreaterThanOrEqualTo(String value) {
            addCriterion("home_ou >=", value, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuLessThan(String value) {
            addCriterion("home_ou <", value, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuLessThanOrEqualTo(String value) {
            addCriterion("home_ou <=", value, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuLike(String value) {
            addCriterion("home_ou like", value, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuNotLike(String value) {
            addCriterion("home_ou not like", value, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuIn(List<String> values) {
            addCriterion("home_ou in", values, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuNotIn(List<String> values) {
            addCriterion("home_ou not in", values, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuBetween(String value1, String value2) {
            addCriterion("home_ou between", value1, value2, "homeOu");
            return (Criteria) this;
        }

        public Criteria andHomeOuNotBetween(String value1, String value2) {
            addCriterion("home_ou not between", value1, value2, "homeOu");
            return (Criteria) this;
        }

        public Criteria andAwayNear6IsNull() {
            addCriterion("away_near6 is null");
            return (Criteria) this;
        }

        public Criteria andAwayNear6IsNotNull() {
            addCriterion("away_near6 is not null");
            return (Criteria) this;
        }

        public Criteria andAwayNear6EqualTo(String value) {
            addCriterion("away_near6 =", value, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6NotEqualTo(String value) {
            addCriterion("away_near6 <>", value, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6GreaterThan(String value) {
            addCriterion("away_near6 >", value, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6GreaterThanOrEqualTo(String value) {
            addCriterion("away_near6 >=", value, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6LessThan(String value) {
            addCriterion("away_near6 <", value, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6LessThanOrEqualTo(String value) {
            addCriterion("away_near6 <=", value, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6Like(String value) {
            addCriterion("away_near6 like", value, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6NotLike(String value) {
            addCriterion("away_near6 not like", value, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6In(List<String> values) {
            addCriterion("away_near6 in", values, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6NotIn(List<String> values) {
            addCriterion("away_near6 not in", values, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6Between(String value1, String value2) {
            addCriterion("away_near6 between", value1, value2, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayNear6NotBetween(String value1, String value2) {
            addCriterion("away_near6 not between", value1, value2, "awayNear6");
            return (Criteria) this;
        }

        public Criteria andAwayOddsIsNull() {
            addCriterion("away_odds is null");
            return (Criteria) this;
        }

        public Criteria andAwayOddsIsNotNull() {
            addCriterion("away_odds is not null");
            return (Criteria) this;
        }

        public Criteria andAwayOddsEqualTo(String value) {
            addCriterion("away_odds =", value, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsNotEqualTo(String value) {
            addCriterion("away_odds <>", value, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsGreaterThan(String value) {
            addCriterion("away_odds >", value, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsGreaterThanOrEqualTo(String value) {
            addCriterion("away_odds >=", value, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsLessThan(String value) {
            addCriterion("away_odds <", value, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsLessThanOrEqualTo(String value) {
            addCriterion("away_odds <=", value, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsLike(String value) {
            addCriterion("away_odds like", value, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsNotLike(String value) {
            addCriterion("away_odds not like", value, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsIn(List<String> values) {
            addCriterion("away_odds in", values, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsNotIn(List<String> values) {
            addCriterion("away_odds not in", values, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsBetween(String value1, String value2) {
            addCriterion("away_odds between", value1, value2, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOddsNotBetween(String value1, String value2) {
            addCriterion("away_odds not between", value1, value2, "awayOdds");
            return (Criteria) this;
        }

        public Criteria andAwayOuIsNull() {
            addCriterion("away_ou is null");
            return (Criteria) this;
        }

        public Criteria andAwayOuIsNotNull() {
            addCriterion("away_ou is not null");
            return (Criteria) this;
        }

        public Criteria andAwayOuEqualTo(String value) {
            addCriterion("away_ou =", value, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuNotEqualTo(String value) {
            addCriterion("away_ou <>", value, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuGreaterThan(String value) {
            addCriterion("away_ou >", value, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuGreaterThanOrEqualTo(String value) {
            addCriterion("away_ou >=", value, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuLessThan(String value) {
            addCriterion("away_ou <", value, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuLessThanOrEqualTo(String value) {
            addCriterion("away_ou <=", value, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuLike(String value) {
            addCriterion("away_ou like", value, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuNotLike(String value) {
            addCriterion("away_ou not like", value, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuIn(List<String> values) {
            addCriterion("away_ou in", values, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuNotIn(List<String> values) {
            addCriterion("away_ou not in", values, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuBetween(String value1, String value2) {
            addCriterion("away_ou between", value1, value2, "awayOu");
            return (Criteria) this;
        }

        public Criteria andAwayOuNotBetween(String value1, String value2) {
            addCriterion("away_ou not between", value1, value2, "awayOu");
            return (Criteria) this;
        }

        public Criteria andConfidenceIsNull() {
            addCriterion("confidence is null");
            return (Criteria) this;
        }

        public Criteria andConfidenceIsNotNull() {
            addCriterion("confidence is not null");
            return (Criteria) this;
        }

        public Criteria andConfidenceEqualTo(String value) {
            addCriterion("confidence =", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotEqualTo(String value) {
            addCriterion("confidence <>", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceGreaterThan(String value) {
            addCriterion("confidence >", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceGreaterThanOrEqualTo(String value) {
            addCriterion("confidence >=", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLessThan(String value) {
            addCriterion("confidence <", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLessThanOrEqualTo(String value) {
            addCriterion("confidence <=", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLike(String value) {
            addCriterion("confidence like", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotLike(String value) {
            addCriterion("confidence not like", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceIn(List<String> values) {
            addCriterion("confidence in", values, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotIn(List<String> values) {
            addCriterion("confidence not in", values, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceBetween(String value1, String value2) {
            addCriterion("confidence between", value1, value2, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotBetween(String value1, String value2) {
            addCriterion("confidence not between", value1, value2, "confidence");
            return (Criteria) this;
        }

        public Criteria andVsIsNull() {
            addCriterion("vs is null");
            return (Criteria) this;
        }

        public Criteria andVsIsNotNull() {
            addCriterion("vs is not null");
            return (Criteria) this;
        }

        public Criteria andVsEqualTo(String value) {
            addCriterion("vs =", value, "vs");
            return (Criteria) this;
        }

        public Criteria andVsNotEqualTo(String value) {
            addCriterion("vs <>", value, "vs");
            return (Criteria) this;
        }

        public Criteria andVsGreaterThan(String value) {
            addCriterion("vs >", value, "vs");
            return (Criteria) this;
        }

        public Criteria andVsGreaterThanOrEqualTo(String value) {
            addCriterion("vs >=", value, "vs");
            return (Criteria) this;
        }

        public Criteria andVsLessThan(String value) {
            addCriterion("vs <", value, "vs");
            return (Criteria) this;
        }

        public Criteria andVsLessThanOrEqualTo(String value) {
            addCriterion("vs <=", value, "vs");
            return (Criteria) this;
        }

        public Criteria andVsLike(String value) {
            addCriterion("vs like", value, "vs");
            return (Criteria) this;
        }

        public Criteria andVsNotLike(String value) {
            addCriterion("vs not like", value, "vs");
            return (Criteria) this;
        }

        public Criteria andVsIn(List<String> values) {
            addCriterion("vs in", values, "vs");
            return (Criteria) this;
        }

        public Criteria andVsNotIn(List<String> values) {
            addCriterion("vs not in", values, "vs");
            return (Criteria) this;
        }

        public Criteria andVsBetween(String value1, String value2) {
            addCriterion("vs between", value1, value2, "vs");
            return (Criteria) this;
        }

        public Criteria andVsNotBetween(String value1, String value2) {
            addCriterion("vs not between", value1, value2, "vs");
            return (Criteria) this;
        }

        public Criteria andExplainIsNull() {
            addCriterion("explain is null");
            return (Criteria) this;
        }

        public Criteria andExplainIsNotNull() {
            addCriterion("explain is not null");
            return (Criteria) this;
        }

        public Criteria andExplainEqualTo(String value) {
            addCriterion("explain =", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotEqualTo(String value) {
            addCriterion("explain <>", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThan(String value) {
            addCriterion("explain >", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThanOrEqualTo(String value) {
            addCriterion("explain >=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThan(String value) {
            addCriterion("explain <", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThanOrEqualTo(String value) {
            addCriterion("explain <=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLike(String value) {
            addCriterion("explain like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotLike(String value) {
            addCriterion("explain not like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainIn(List<String> values) {
            addCriterion("explain in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotIn(List<String> values) {
            addCriterion("explain not in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainBetween(String value1, String value2) {
            addCriterion("explain between", value1, value2, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotBetween(String value1, String value2) {
            addCriterion("explain not between", value1, value2, "explain");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbIsNull() {
            addCriterion("home_lineup_gb is null");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbIsNotNull() {
            addCriterion("home_lineup_gb is not null");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbEqualTo(String value) {
            addCriterion("home_lineup_gb =", value, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbNotEqualTo(String value) {
            addCriterion("home_lineup_gb <>", value, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbGreaterThan(String value) {
            addCriterion("home_lineup_gb >", value, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbGreaterThanOrEqualTo(String value) {
            addCriterion("home_lineup_gb >=", value, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbLessThan(String value) {
            addCriterion("home_lineup_gb <", value, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbLessThanOrEqualTo(String value) {
            addCriterion("home_lineup_gb <=", value, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbLike(String value) {
            addCriterion("home_lineup_gb like", value, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbNotLike(String value) {
            addCriterion("home_lineup_gb not like", value, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbIn(List<String> values) {
            addCriterion("home_lineup_gb in", values, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbNotIn(List<String> values) {
            addCriterion("home_lineup_gb not in", values, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbBetween(String value1, String value2) {
            addCriterion("home_lineup_gb between", value1, value2, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeLineupGbNotBetween(String value1, String value2) {
            addCriterion("home_lineup_gb not between", value1, value2, "homeLineupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbIsNull() {
            addCriterion("home_backup_gb is null");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbIsNotNull() {
            addCriterion("home_backup_gb is not null");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbEqualTo(String value) {
            addCriterion("home_backup_gb =", value, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbNotEqualTo(String value) {
            addCriterion("home_backup_gb <>", value, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbGreaterThan(String value) {
            addCriterion("home_backup_gb >", value, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbGreaterThanOrEqualTo(String value) {
            addCriterion("home_backup_gb >=", value, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbLessThan(String value) {
            addCriterion("home_backup_gb <", value, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbLessThanOrEqualTo(String value) {
            addCriterion("home_backup_gb <=", value, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbLike(String value) {
            addCriterion("home_backup_gb like", value, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbNotLike(String value) {
            addCriterion("home_backup_gb not like", value, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbIn(List<String> values) {
            addCriterion("home_backup_gb in", values, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbNotIn(List<String> values) {
            addCriterion("home_backup_gb not in", values, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbBetween(String value1, String value2) {
            addCriterion("home_backup_gb between", value1, value2, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andHomeBackupGbNotBetween(String value1, String value2) {
            addCriterion("home_backup_gb not between", value1, value2, "homeBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbIsNull() {
            addCriterion("away_lineup_gb is null");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbIsNotNull() {
            addCriterion("away_lineup_gb is not null");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbEqualTo(String value) {
            addCriterion("away_lineup_gb =", value, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbNotEqualTo(String value) {
            addCriterion("away_lineup_gb <>", value, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbGreaterThan(String value) {
            addCriterion("away_lineup_gb >", value, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbGreaterThanOrEqualTo(String value) {
            addCriterion("away_lineup_gb >=", value, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbLessThan(String value) {
            addCriterion("away_lineup_gb <", value, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbLessThanOrEqualTo(String value) {
            addCriterion("away_lineup_gb <=", value, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbLike(String value) {
            addCriterion("away_lineup_gb like", value, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbNotLike(String value) {
            addCriterion("away_lineup_gb not like", value, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbIn(List<String> values) {
            addCriterion("away_lineup_gb in", values, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbNotIn(List<String> values) {
            addCriterion("away_lineup_gb not in", values, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbBetween(String value1, String value2) {
            addCriterion("away_lineup_gb between", value1, value2, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayLineupGbNotBetween(String value1, String value2) {
            addCriterion("away_lineup_gb not between", value1, value2, "awayLineupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbIsNull() {
            addCriterion("away_backup_gb is null");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbIsNotNull() {
            addCriterion("away_backup_gb is not null");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbEqualTo(String value) {
            addCriterion("away_backup_gb =", value, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbNotEqualTo(String value) {
            addCriterion("away_backup_gb <>", value, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbGreaterThan(String value) {
            addCriterion("away_backup_gb >", value, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbGreaterThanOrEqualTo(String value) {
            addCriterion("away_backup_gb >=", value, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbLessThan(String value) {
            addCriterion("away_backup_gb <", value, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbLessThanOrEqualTo(String value) {
            addCriterion("away_backup_gb <=", value, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbLike(String value) {
            addCriterion("away_backup_gb like", value, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbNotLike(String value) {
            addCriterion("away_backup_gb not like", value, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbIn(List<String> values) {
            addCriterion("away_backup_gb in", values, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbNotIn(List<String> values) {
            addCriterion("away_backup_gb not in", values, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbBetween(String value1, String value2) {
            addCriterion("away_backup_gb between", value1, value2, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAwayBackupGbNotBetween(String value1, String value2) {
            addCriterion("away_backup_gb not between", value1, value2, "awayBackupGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbIsNull() {
            addCriterion("analyzes_gb is null");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbIsNotNull() {
            addCriterion("analyzes_gb is not null");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbEqualTo(String value) {
            addCriterion("analyzes_gb =", value, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbNotEqualTo(String value) {
            addCriterion("analyzes_gb <>", value, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbGreaterThan(String value) {
            addCriterion("analyzes_gb >", value, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbGreaterThanOrEqualTo(String value) {
            addCriterion("analyzes_gb >=", value, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbLessThan(String value) {
            addCriterion("analyzes_gb <", value, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbLessThanOrEqualTo(String value) {
            addCriterion("analyzes_gb <=", value, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbLike(String value) {
            addCriterion("analyzes_gb like", value, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbNotLike(String value) {
            addCriterion("analyzes_gb not like", value, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbIn(List<String> values) {
            addCriterion("analyzes_gb in", values, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbNotIn(List<String> values) {
            addCriterion("analyzes_gb not in", values, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbBetween(String value1, String value2) {
            addCriterion("analyzes_gb between", value1, value2, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andAnalyzesGbNotBetween(String value1, String value2) {
            addCriterion("analyzes_gb not between", value1, value2, "analyzesGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbIsNull() {
            addCriterion("injury_gb is null");
            return (Criteria) this;
        }

        public Criteria andInjuryGbIsNotNull() {
            addCriterion("injury_gb is not null");
            return (Criteria) this;
        }

        public Criteria andInjuryGbEqualTo(String value) {
            addCriterion("injury_gb =", value, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbNotEqualTo(String value) {
            addCriterion("injury_gb <>", value, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbGreaterThan(String value) {
            addCriterion("injury_gb >", value, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbGreaterThanOrEqualTo(String value) {
            addCriterion("injury_gb >=", value, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbLessThan(String value) {
            addCriterion("injury_gb <", value, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbLessThanOrEqualTo(String value) {
            addCriterion("injury_gb <=", value, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbLike(String value) {
            addCriterion("injury_gb like", value, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbNotLike(String value) {
            addCriterion("injury_gb not like", value, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbIn(List<String> values) {
            addCriterion("injury_gb in", values, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbNotIn(List<String> values) {
            addCriterion("injury_gb not in", values, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbBetween(String value1, String value2) {
            addCriterion("injury_gb between", value1, value2, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andInjuryGbNotBetween(String value1, String value2) {
            addCriterion("injury_gb not between", value1, value2, "injuryGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbIsNull() {
            addCriterion("confidence_gb is null");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbIsNotNull() {
            addCriterion("confidence_gb is not null");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbEqualTo(String value) {
            addCriterion("confidence_gb =", value, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbNotEqualTo(String value) {
            addCriterion("confidence_gb <>", value, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbGreaterThan(String value) {
            addCriterion("confidence_gb >", value, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbGreaterThanOrEqualTo(String value) {
            addCriterion("confidence_gb >=", value, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbLessThan(String value) {
            addCriterion("confidence_gb <", value, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbLessThanOrEqualTo(String value) {
            addCriterion("confidence_gb <=", value, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbLike(String value) {
            addCriterion("confidence_gb like", value, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbNotLike(String value) {
            addCriterion("confidence_gb not like", value, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbIn(List<String> values) {
            addCriterion("confidence_gb in", values, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbNotIn(List<String> values) {
            addCriterion("confidence_gb not in", values, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbBetween(String value1, String value2) {
            addCriterion("confidence_gb between", value1, value2, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andConfidenceGbNotBetween(String value1, String value2) {
            addCriterion("confidence_gb not between", value1, value2, "confidenceGb");
            return (Criteria) this;
        }

        public Criteria andVsGbIsNull() {
            addCriterion("vs_gb is null");
            return (Criteria) this;
        }

        public Criteria andVsGbIsNotNull() {
            addCriterion("vs_gb is not null");
            return (Criteria) this;
        }

        public Criteria andVsGbEqualTo(String value) {
            addCriterion("vs_gb =", value, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbNotEqualTo(String value) {
            addCriterion("vs_gb <>", value, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbGreaterThan(String value) {
            addCriterion("vs_gb >", value, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbGreaterThanOrEqualTo(String value) {
            addCriterion("vs_gb >=", value, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbLessThan(String value) {
            addCriterion("vs_gb <", value, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbLessThanOrEqualTo(String value) {
            addCriterion("vs_gb <=", value, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbLike(String value) {
            addCriterion("vs_gb like", value, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbNotLike(String value) {
            addCriterion("vs_gb not like", value, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbIn(List<String> values) {
            addCriterion("vs_gb in", values, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbNotIn(List<String> values) {
            addCriterion("vs_gb not in", values, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbBetween(String value1, String value2) {
            addCriterion("vs_gb between", value1, value2, "vsGb");
            return (Criteria) this;
        }

        public Criteria andVsGbNotBetween(String value1, String value2) {
            addCriterion("vs_gb not between", value1, value2, "vsGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbIsNull() {
            addCriterion("explain_gb is null");
            return (Criteria) this;
        }

        public Criteria andExplainGbIsNotNull() {
            addCriterion("explain_gb is not null");
            return (Criteria) this;
        }

        public Criteria andExplainGbEqualTo(String value) {
            addCriterion("explain_gb =", value, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbNotEqualTo(String value) {
            addCriterion("explain_gb <>", value, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbGreaterThan(String value) {
            addCriterion("explain_gb >", value, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbGreaterThanOrEqualTo(String value) {
            addCriterion("explain_gb >=", value, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbLessThan(String value) {
            addCriterion("explain_gb <", value, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbLessThanOrEqualTo(String value) {
            addCriterion("explain_gb <=", value, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbLike(String value) {
            addCriterion("explain_gb like", value, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbNotLike(String value) {
            addCriterion("explain_gb not like", value, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbIn(List<String> values) {
            addCriterion("explain_gb in", values, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbNotIn(List<String> values) {
            addCriterion("explain_gb not in", values, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbBetween(String value1, String value2) {
            addCriterion("explain_gb between", value1, value2, "explainGb");
            return (Criteria) this;
        }

        public Criteria andExplainGbNotBetween(String value1, String value2) {
            addCriterion("explain_gb not between", value1, value2, "explainGb");
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