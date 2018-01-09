package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.List;

public class HolosecretkeysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HolosecretkeysExample() {
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

        public Criteria andSecretkeyIsNull() {
            addCriterion("secretKey is null");
            return (Criteria) this;
        }

        public Criteria andSecretkeyIsNotNull() {
            addCriterion("secretKey is not null");
            return (Criteria) this;
        }

        public Criteria andSecretkeyEqualTo(String value) {
            addCriterion("secretKey =", value, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyNotEqualTo(String value) {
            addCriterion("secretKey <>", value, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyGreaterThan(String value) {
            addCriterion("secretKey >", value, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyGreaterThanOrEqualTo(String value) {
            addCriterion("secretKey >=", value, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyLessThan(String value) {
            addCriterion("secretKey <", value, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyLessThanOrEqualTo(String value) {
            addCriterion("secretKey <=", value, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyLike(String value) {
            addCriterion("secretKey like", value, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyNotLike(String value) {
            addCriterion("secretKey not like", value, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyIn(List<String> values) {
            addCriterion("secretKey in", values, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyNotIn(List<String> values) {
            addCriterion("secretKey not in", values, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyBetween(String value1, String value2) {
            addCriterion("secretKey between", value1, value2, "secretkey");
            return (Criteria) this;
        }

        public Criteria andSecretkeyNotBetween(String value1, String value2) {
            addCriterion("secretKey not between", value1, value2, "secretkey");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(Integer value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(Integer value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(Integer value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(Integer value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<Integer> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<Integer> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(Integer value1, Integer value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andFkuseridIsNull() {
            addCriterion("fkUserId is null");
            return (Criteria) this;
        }

        public Criteria andFkuseridIsNotNull() {
            addCriterion("fkUserId is not null");
            return (Criteria) this;
        }

        public Criteria andFkuseridEqualTo(Integer value) {
            addCriterion("fkUserId =", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridNotEqualTo(Integer value) {
            addCriterion("fkUserId <>", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridGreaterThan(Integer value) {
            addCriterion("fkUserId >", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fkUserId >=", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridLessThan(Integer value) {
            addCriterion("fkUserId <", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridLessThanOrEqualTo(Integer value) {
            addCriterion("fkUserId <=", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridIn(List<Integer> values) {
            addCriterion("fkUserId in", values, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridNotIn(List<Integer> values) {
            addCriterion("fkUserId not in", values, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridBetween(Integer value1, Integer value2) {
            addCriterion("fkUserId between", value1, value2, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("fkUserId not between", value1, value2, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andMaxusersIsNull() {
            addCriterion("maxusers is null");
            return (Criteria) this;
        }

        public Criteria andMaxusersIsNotNull() {
            addCriterion("maxusers is not null");
            return (Criteria) this;
        }

        public Criteria andMaxusersEqualTo(Integer value) {
            addCriterion("maxusers =", value, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersNotEqualTo(Integer value) {
            addCriterion("maxusers <>", value, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersGreaterThan(Integer value) {
            addCriterion("maxusers >", value, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxusers >=", value, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersLessThan(Integer value) {
            addCriterion("maxusers <", value, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersLessThanOrEqualTo(Integer value) {
            addCriterion("maxusers <=", value, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersIn(List<Integer> values) {
            addCriterion("maxusers in", values, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersNotIn(List<Integer> values) {
            addCriterion("maxusers not in", values, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersBetween(Integer value1, Integer value2) {
            addCriterion("maxusers between", value1, value2, "maxusers");
            return (Criteria) this;
        }

        public Criteria andMaxusersNotBetween(Integer value1, Integer value2) {
            addCriterion("maxusers not between", value1, value2, "maxusers");
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