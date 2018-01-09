package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.List;

public class HoloentcustExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HoloentcustExample() {
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

        public Criteria andHuseridIsNull() {
            addCriterion("hUserID is null");
            return (Criteria) this;
        }

        public Criteria andHuseridIsNotNull() {
            addCriterion("hUserID is not null");
            return (Criteria) this;
        }

        public Criteria andHuseridEqualTo(Integer value) {
            addCriterion("hUserID =", value, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridNotEqualTo(Integer value) {
            addCriterion("hUserID <>", value, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridGreaterThan(Integer value) {
            addCriterion("hUserID >", value, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("hUserID >=", value, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridLessThan(Integer value) {
            addCriterion("hUserID <", value, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridLessThanOrEqualTo(Integer value) {
            addCriterion("hUserID <=", value, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridIn(List<Integer> values) {
            addCriterion("hUserID in", values, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridNotIn(List<Integer> values) {
            addCriterion("hUserID not in", values, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridBetween(Integer value1, Integer value2) {
            addCriterion("hUserID between", value1, value2, "huserid");
            return (Criteria) this;
        }

        public Criteria andHuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("hUserID not between", value1, value2, "huserid");
            return (Criteria) this;
        }

        public Criteria andHstarIsNull() {
            addCriterion("hStar is null");
            return (Criteria) this;
        }

        public Criteria andHstarIsNotNull() {
            addCriterion("hStar is not null");
            return (Criteria) this;
        }

        public Criteria andHstarEqualTo(Short value) {
            addCriterion("hStar =", value, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarNotEqualTo(Short value) {
            addCriterion("hStar <>", value, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarGreaterThan(Short value) {
            addCriterion("hStar >", value, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarGreaterThanOrEqualTo(Short value) {
            addCriterion("hStar >=", value, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarLessThan(Short value) {
            addCriterion("hStar <", value, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarLessThanOrEqualTo(Short value) {
            addCriterion("hStar <=", value, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarIn(List<Short> values) {
            addCriterion("hStar in", values, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarNotIn(List<Short> values) {
            addCriterion("hStar not in", values, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarBetween(Short value1, Short value2) {
            addCriterion("hStar between", value1, value2, "hstar");
            return (Criteria) this;
        }

        public Criteria andHstarNotBetween(Short value1, Short value2) {
            addCriterion("hStar not between", value1, value2, "hstar");
            return (Criteria) this;
        }

        public Criteria andHaccumulateIsNull() {
            addCriterion("hAccumulate is null");
            return (Criteria) this;
        }

        public Criteria andHaccumulateIsNotNull() {
            addCriterion("hAccumulate is not null");
            return (Criteria) this;
        }

        public Criteria andHaccumulateEqualTo(Float value) {
            addCriterion("hAccumulate =", value, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateNotEqualTo(Float value) {
            addCriterion("hAccumulate <>", value, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateGreaterThan(Float value) {
            addCriterion("hAccumulate >", value, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateGreaterThanOrEqualTo(Float value) {
            addCriterion("hAccumulate >=", value, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateLessThan(Float value) {
            addCriterion("hAccumulate <", value, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateLessThanOrEqualTo(Float value) {
            addCriterion("hAccumulate <=", value, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateIn(List<Float> values) {
            addCriterion("hAccumulate in", values, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateNotIn(List<Float> values) {
            addCriterion("hAccumulate not in", values, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateBetween(Float value1, Float value2) {
            addCriterion("hAccumulate between", value1, value2, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHaccumulateNotBetween(Float value1, Float value2) {
            addCriterion("hAccumulate not between", value1, value2, "haccumulate");
            return (Criteria) this;
        }

        public Criteria andHdepositIsNull() {
            addCriterion("hDeposit is null");
            return (Criteria) this;
        }

        public Criteria andHdepositIsNotNull() {
            addCriterion("hDeposit is not null");
            return (Criteria) this;
        }

        public Criteria andHdepositEqualTo(Float value) {
            addCriterion("hDeposit =", value, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositNotEqualTo(Float value) {
            addCriterion("hDeposit <>", value, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositGreaterThan(Float value) {
            addCriterion("hDeposit >", value, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositGreaterThanOrEqualTo(Float value) {
            addCriterion("hDeposit >=", value, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositLessThan(Float value) {
            addCriterion("hDeposit <", value, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositLessThanOrEqualTo(Float value) {
            addCriterion("hDeposit <=", value, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositIn(List<Float> values) {
            addCriterion("hDeposit in", values, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositNotIn(List<Float> values) {
            addCriterion("hDeposit not in", values, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositBetween(Float value1, Float value2) {
            addCriterion("hDeposit between", value1, value2, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHdepositNotBetween(Float value1, Float value2) {
            addCriterion("hDeposit not between", value1, value2, "hdeposit");
            return (Criteria) this;
        }

        public Criteria andHuserstarIsNull() {
            addCriterion("hUserStar is null");
            return (Criteria) this;
        }

        public Criteria andHuserstarIsNotNull() {
            addCriterion("hUserStar is not null");
            return (Criteria) this;
        }

        public Criteria andHuserstarEqualTo(Short value) {
            addCriterion("hUserStar =", value, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarNotEqualTo(Short value) {
            addCriterion("hUserStar <>", value, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarGreaterThan(Short value) {
            addCriterion("hUserStar >", value, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarGreaterThanOrEqualTo(Short value) {
            addCriterion("hUserStar >=", value, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarLessThan(Short value) {
            addCriterion("hUserStar <", value, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarLessThanOrEqualTo(Short value) {
            addCriterion("hUserStar <=", value, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarIn(List<Short> values) {
            addCriterion("hUserStar in", values, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarNotIn(List<Short> values) {
            addCriterion("hUserStar not in", values, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarBetween(Short value1, Short value2) {
            addCriterion("hUserStar between", value1, value2, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHuserstarNotBetween(Short value1, Short value2) {
            addCriterion("hUserStar not between", value1, value2, "huserstar");
            return (Criteria) this;
        }

        public Criteria andHcustidIsNull() {
            addCriterion("hCustID is null");
            return (Criteria) this;
        }

        public Criteria andHcustidIsNotNull() {
            addCriterion("hCustID is not null");
            return (Criteria) this;
        }

        public Criteria andHcustidEqualTo(Long value) {
            addCriterion("hCustID =", value, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidNotEqualTo(Long value) {
            addCriterion("hCustID <>", value, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidGreaterThan(Long value) {
            addCriterion("hCustID >", value, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidGreaterThanOrEqualTo(Long value) {
            addCriterion("hCustID >=", value, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidLessThan(Long value) {
            addCriterion("hCustID <", value, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidLessThanOrEqualTo(Long value) {
            addCriterion("hCustID <=", value, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidIn(List<Long> values) {
            addCriterion("hCustID in", values, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidNotIn(List<Long> values) {
            addCriterion("hCustID not in", values, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidBetween(Long value1, Long value2) {
            addCriterion("hCustID between", value1, value2, "hcustid");
            return (Criteria) this;
        }

        public Criteria andHcustidNotBetween(Long value1, Long value2) {
            addCriterion("hCustID not between", value1, value2, "hcustid");
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