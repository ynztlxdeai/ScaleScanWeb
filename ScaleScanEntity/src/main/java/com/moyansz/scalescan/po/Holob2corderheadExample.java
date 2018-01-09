package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Holob2corderheadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Holob2corderheadExample() {
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

        public Criteria andHordertotIsNull() {
            addCriterion("hOrderTot is null");
            return (Criteria) this;
        }

        public Criteria andHordertotIsNotNull() {
            addCriterion("hOrderTot is not null");
            return (Criteria) this;
        }

        public Criteria andHordertotEqualTo(Float value) {
            addCriterion("hOrderTot =", value, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotNotEqualTo(Float value) {
            addCriterion("hOrderTot <>", value, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotGreaterThan(Float value) {
            addCriterion("hOrderTot >", value, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotGreaterThanOrEqualTo(Float value) {
            addCriterion("hOrderTot >=", value, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotLessThan(Float value) {
            addCriterion("hOrderTot <", value, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotLessThanOrEqualTo(Float value) {
            addCriterion("hOrderTot <=", value, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotIn(List<Float> values) {
            addCriterion("hOrderTot in", values, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotNotIn(List<Float> values) {
            addCriterion("hOrderTot not in", values, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotBetween(Float value1, Float value2) {
            addCriterion("hOrderTot between", value1, value2, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHordertotNotBetween(Float value1, Float value2) {
            addCriterion("hOrderTot not between", value1, value2, "hordertot");
            return (Criteria) this;
        }

        public Criteria andHdecidedIsNull() {
            addCriterion("hDecided is null");
            return (Criteria) this;
        }

        public Criteria andHdecidedIsNotNull() {
            addCriterion("hDecided is not null");
            return (Criteria) this;
        }

        public Criteria andHdecidedEqualTo(Boolean value) {
            addCriterion("hDecided =", value, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedNotEqualTo(Boolean value) {
            addCriterion("hDecided <>", value, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedGreaterThan(Boolean value) {
            addCriterion("hDecided >", value, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hDecided >=", value, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedLessThan(Boolean value) {
            addCriterion("hDecided <", value, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedLessThanOrEqualTo(Boolean value) {
            addCriterion("hDecided <=", value, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedIn(List<Boolean> values) {
            addCriterion("hDecided in", values, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedNotIn(List<Boolean> values) {
            addCriterion("hDecided not in", values, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedBetween(Boolean value1, Boolean value2) {
            addCriterion("hDecided between", value1, value2, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHdecidedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hDecided not between", value1, value2, "hdecided");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidIsNull() {
            addCriterion("hMoneyPaid is null");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidIsNotNull() {
            addCriterion("hMoneyPaid is not null");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidEqualTo(Float value) {
            addCriterion("hMoneyPaid =", value, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidNotEqualTo(Float value) {
            addCriterion("hMoneyPaid <>", value, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidGreaterThan(Float value) {
            addCriterion("hMoneyPaid >", value, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidGreaterThanOrEqualTo(Float value) {
            addCriterion("hMoneyPaid >=", value, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidLessThan(Float value) {
            addCriterion("hMoneyPaid <", value, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidLessThanOrEqualTo(Float value) {
            addCriterion("hMoneyPaid <=", value, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidIn(List<Float> values) {
            addCriterion("hMoneyPaid in", values, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidNotIn(List<Float> values) {
            addCriterion("hMoneyPaid not in", values, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidBetween(Float value1, Float value2) {
            addCriterion("hMoneyPaid between", value1, value2, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHmoneypaidNotBetween(Float value1, Float value2) {
            addCriterion("hMoneyPaid not between", value1, value2, "hmoneypaid");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerIsNull() {
            addCriterion("hPayingManner is null");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerIsNotNull() {
            addCriterion("hPayingManner is not null");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerEqualTo(Short value) {
            addCriterion("hPayingManner =", value, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerNotEqualTo(Short value) {
            addCriterion("hPayingManner <>", value, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerGreaterThan(Short value) {
            addCriterion("hPayingManner >", value, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerGreaterThanOrEqualTo(Short value) {
            addCriterion("hPayingManner >=", value, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerLessThan(Short value) {
            addCriterion("hPayingManner <", value, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerLessThanOrEqualTo(Short value) {
            addCriterion("hPayingManner <=", value, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerIn(List<Short> values) {
            addCriterion("hPayingManner in", values, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerNotIn(List<Short> values) {
            addCriterion("hPayingManner not in", values, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerBetween(Short value1, Short value2) {
            addCriterion("hPayingManner between", value1, value2, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHpayingmannerNotBetween(Short value1, Short value2) {
            addCriterion("hPayingManner not between", value1, value2, "hpayingmanner");
            return (Criteria) this;
        }

        public Criteria andHbuyeridIsNull() {
            addCriterion("hBuyerID is null");
            return (Criteria) this;
        }

        public Criteria andHbuyeridIsNotNull() {
            addCriterion("hBuyerID is not null");
            return (Criteria) this;
        }

        public Criteria andHbuyeridEqualTo(Long value) {
            addCriterion("hBuyerID =", value, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridNotEqualTo(Long value) {
            addCriterion("hBuyerID <>", value, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridGreaterThan(Long value) {
            addCriterion("hBuyerID >", value, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridGreaterThanOrEqualTo(Long value) {
            addCriterion("hBuyerID >=", value, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridLessThan(Long value) {
            addCriterion("hBuyerID <", value, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridLessThanOrEqualTo(Long value) {
            addCriterion("hBuyerID <=", value, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridIn(List<Long> values) {
            addCriterion("hBuyerID in", values, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridNotIn(List<Long> values) {
            addCriterion("hBuyerID not in", values, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridBetween(Long value1, Long value2) {
            addCriterion("hBuyerID between", value1, value2, "hbuyerid");
            return (Criteria) this;
        }

        public Criteria andHbuyeridNotBetween(Long value1, Long value2) {
            addCriterion("hBuyerID not between", value1, value2, "hbuyerid");
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