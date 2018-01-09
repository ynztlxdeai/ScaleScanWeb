package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Holob2csendorderheadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Holob2csendorderheadExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andHsendidIsNull() {
            addCriterion("hSendID is null");
            return (Criteria) this;
        }

        public Criteria andHsendidIsNotNull() {
            addCriterion("hSendID is not null");
            return (Criteria) this;
        }

        public Criteria andHsendidEqualTo(Integer value) {
            addCriterion("hSendID =", value, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidNotEqualTo(Integer value) {
            addCriterion("hSendID <>", value, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidGreaterThan(Integer value) {
            addCriterion("hSendID >", value, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hSendID >=", value, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidLessThan(Integer value) {
            addCriterion("hSendID <", value, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidLessThanOrEqualTo(Integer value) {
            addCriterion("hSendID <=", value, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidIn(List<Integer> values) {
            addCriterion("hSendID in", values, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidNotIn(List<Integer> values) {
            addCriterion("hSendID not in", values, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidBetween(Integer value1, Integer value2) {
            addCriterion("hSendID between", value1, value2, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHsendidNotBetween(Integer value1, Integer value2) {
            addCriterion("hSendID not between", value1, value2, "hsendid");
            return (Criteria) this;
        }

        public Criteria andHorderidIsNull() {
            addCriterion("hOrderID is null");
            return (Criteria) this;
        }

        public Criteria andHorderidIsNotNull() {
            addCriterion("hOrderID is not null");
            return (Criteria) this;
        }

        public Criteria andHorderidEqualTo(Integer value) {
            addCriterion("hOrderID =", value, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidNotEqualTo(Integer value) {
            addCriterion("hOrderID <>", value, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidGreaterThan(Integer value) {
            addCriterion("hOrderID >", value, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hOrderID >=", value, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidLessThan(Integer value) {
            addCriterion("hOrderID <", value, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidLessThanOrEqualTo(Integer value) {
            addCriterion("hOrderID <=", value, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidIn(List<Integer> values) {
            addCriterion("hOrderID in", values, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidNotIn(List<Integer> values) {
            addCriterion("hOrderID not in", values, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidBetween(Integer value1, Integer value2) {
            addCriterion("hOrderID between", value1, value2, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderidNotBetween(Integer value1, Integer value2) {
            addCriterion("hOrderID not between", value1, value2, "horderid");
            return (Criteria) this;
        }

        public Criteria andHorderdateIsNull() {
            addCriterion("hOrderDate is null");
            return (Criteria) this;
        }

        public Criteria andHorderdateIsNotNull() {
            addCriterion("hOrderDate is not null");
            return (Criteria) this;
        }

        public Criteria andHorderdateEqualTo(Date value) {
            addCriterionForJDBCDate("hOrderDate =", value, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("hOrderDate <>", value, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateGreaterThan(Date value) {
            addCriterionForJDBCDate("hOrderDate >", value, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hOrderDate >=", value, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateLessThan(Date value) {
            addCriterionForJDBCDate("hOrderDate <", value, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hOrderDate <=", value, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateIn(List<Date> values) {
            addCriterionForJDBCDate("hOrderDate in", values, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("hOrderDate not in", values, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hOrderDate between", value1, value2, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHorderdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hOrderDate not between", value1, value2, "horderdate");
            return (Criteria) this;
        }

        public Criteria andHsendernameIsNull() {
            addCriterion("hSenderName is null");
            return (Criteria) this;
        }

        public Criteria andHsendernameIsNotNull() {
            addCriterion("hSenderName is not null");
            return (Criteria) this;
        }

        public Criteria andHsendernameEqualTo(String value) {
            addCriterion("hSenderName =", value, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameNotEqualTo(String value) {
            addCriterion("hSenderName <>", value, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameGreaterThan(String value) {
            addCriterion("hSenderName >", value, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameGreaterThanOrEqualTo(String value) {
            addCriterion("hSenderName >=", value, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameLessThan(String value) {
            addCriterion("hSenderName <", value, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameLessThanOrEqualTo(String value) {
            addCriterion("hSenderName <=", value, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameLike(String value) {
            addCriterion("hSenderName like", value, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameNotLike(String value) {
            addCriterion("hSenderName not like", value, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameIn(List<String> values) {
            addCriterion("hSenderName in", values, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameNotIn(List<String> values) {
            addCriterion("hSenderName not in", values, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameBetween(String value1, String value2) {
            addCriterion("hSenderName between", value1, value2, "hsendername");
            return (Criteria) this;
        }

        public Criteria andHsendernameNotBetween(String value1, String value2) {
            addCriterion("hSenderName not between", value1, value2, "hsendername");
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