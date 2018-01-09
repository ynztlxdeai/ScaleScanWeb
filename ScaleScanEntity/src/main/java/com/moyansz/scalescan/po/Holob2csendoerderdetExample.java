package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.List;

public class Holob2csendoerderdetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Holob2csendoerderdetExample() {
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

        public Criteria andHsenddetidIsNull() {
            addCriterion("hSendDetID is null");
            return (Criteria) this;
        }

        public Criteria andHsenddetidIsNotNull() {
            addCriterion("hSendDetID is not null");
            return (Criteria) this;
        }

        public Criteria andHsenddetidEqualTo(Integer value) {
            addCriterion("hSendDetID =", value, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidNotEqualTo(Integer value) {
            addCriterion("hSendDetID <>", value, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidGreaterThan(Integer value) {
            addCriterion("hSendDetID >", value, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hSendDetID >=", value, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidLessThan(Integer value) {
            addCriterion("hSendDetID <", value, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidLessThanOrEqualTo(Integer value) {
            addCriterion("hSendDetID <=", value, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidIn(List<Integer> values) {
            addCriterion("hSendDetID in", values, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidNotIn(List<Integer> values) {
            addCriterion("hSendDetID not in", values, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidBetween(Integer value1, Integer value2) {
            addCriterion("hSendDetID between", value1, value2, "hsenddetid");
            return (Criteria) this;
        }

        public Criteria andHsenddetidNotBetween(Integer value1, Integer value2) {
            addCriterion("hSendDetID not between", value1, value2, "hsenddetid");
            return (Criteria) this;
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

        public Criteria andHgoodsidIsNull() {
            addCriterion("hGoodsID is null");
            return (Criteria) this;
        }

        public Criteria andHgoodsidIsNotNull() {
            addCriterion("hGoodsID is not null");
            return (Criteria) this;
        }

        public Criteria andHgoodsidEqualTo(Integer value) {
            addCriterion("hGoodsID =", value, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidNotEqualTo(Integer value) {
            addCriterion("hGoodsID <>", value, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidGreaterThan(Integer value) {
            addCriterion("hGoodsID >", value, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hGoodsID >=", value, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidLessThan(Integer value) {
            addCriterion("hGoodsID <", value, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("hGoodsID <=", value, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidIn(List<Integer> values) {
            addCriterion("hGoodsID in", values, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidNotIn(List<Integer> values) {
            addCriterion("hGoodsID not in", values, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidBetween(Integer value1, Integer value2) {
            addCriterion("hGoodsID between", value1, value2, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("hGoodsID not between", value1, value2, "hgoodsid");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumIsNull() {
            addCriterion("hGoodsNum is null");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumIsNotNull() {
            addCriterion("hGoodsNum is not null");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumEqualTo(Integer value) {
            addCriterion("hGoodsNum =", value, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumNotEqualTo(Integer value) {
            addCriterion("hGoodsNum <>", value, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumGreaterThan(Integer value) {
            addCriterion("hGoodsNum >", value, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("hGoodsNum >=", value, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumLessThan(Integer value) {
            addCriterion("hGoodsNum <", value, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumLessThanOrEqualTo(Integer value) {
            addCriterion("hGoodsNum <=", value, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumIn(List<Integer> values) {
            addCriterion("hGoodsNum in", values, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumNotIn(List<Integer> values) {
            addCriterion("hGoodsNum not in", values, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumBetween(Integer value1, Integer value2) {
            addCriterion("hGoodsNum between", value1, value2, "hgoodsnum");
            return (Criteria) this;
        }

        public Criteria andHgoodsnumNotBetween(Integer value1, Integer value2) {
            addCriterion("hGoodsNum not between", value1, value2, "hgoodsnum");
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