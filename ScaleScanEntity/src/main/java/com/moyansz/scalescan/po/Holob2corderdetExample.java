package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.List;

public class Holob2corderdetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Holob2corderdetExample() {
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

        public Criteria andHdetidIsNull() {
            addCriterion("hDetID is null");
            return (Criteria) this;
        }

        public Criteria andHdetidIsNotNull() {
            addCriterion("hDetID is not null");
            return (Criteria) this;
        }

        public Criteria andHdetidEqualTo(Integer value) {
            addCriterion("hDetID =", value, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidNotEqualTo(Integer value) {
            addCriterion("hDetID <>", value, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidGreaterThan(Integer value) {
            addCriterion("hDetID >", value, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hDetID >=", value, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidLessThan(Integer value) {
            addCriterion("hDetID <", value, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidLessThanOrEqualTo(Integer value) {
            addCriterion("hDetID <=", value, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidIn(List<Integer> values) {
            addCriterion("hDetID in", values, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidNotIn(List<Integer> values) {
            addCriterion("hDetID not in", values, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidBetween(Integer value1, Integer value2) {
            addCriterion("hDetID between", value1, value2, "hdetid");
            return (Criteria) this;
        }

        public Criteria andHdetidNotBetween(Integer value1, Integer value2) {
            addCriterion("hDetID not between", value1, value2, "hdetid");
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

        public Criteria andHsalepriceIsNull() {
            addCriterion("hSalePrice is null");
            return (Criteria) this;
        }

        public Criteria andHsalepriceIsNotNull() {
            addCriterion("hSalePrice is not null");
            return (Criteria) this;
        }

        public Criteria andHsalepriceEqualTo(Float value) {
            addCriterion("hSalePrice =", value, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceNotEqualTo(Float value) {
            addCriterion("hSalePrice <>", value, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceGreaterThan(Float value) {
            addCriterion("hSalePrice >", value, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceGreaterThanOrEqualTo(Float value) {
            addCriterion("hSalePrice >=", value, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceLessThan(Float value) {
            addCriterion("hSalePrice <", value, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceLessThanOrEqualTo(Float value) {
            addCriterion("hSalePrice <=", value, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceIn(List<Float> values) {
            addCriterion("hSalePrice in", values, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceNotIn(List<Float> values) {
            addCriterion("hSalePrice not in", values, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceBetween(Float value1, Float value2) {
            addCriterion("hSalePrice between", value1, value2, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHsalepriceNotBetween(Float value1, Float value2) {
            addCriterion("hSalePrice not between", value1, value2, "hsaleprice");
            return (Criteria) this;
        }

        public Criteria andHminortotIsNull() {
            addCriterion("hMinorTot is null");
            return (Criteria) this;
        }

        public Criteria andHminortotIsNotNull() {
            addCriterion("hMinorTot is not null");
            return (Criteria) this;
        }

        public Criteria andHminortotEqualTo(Float value) {
            addCriterion("hMinorTot =", value, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotNotEqualTo(Float value) {
            addCriterion("hMinorTot <>", value, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotGreaterThan(Float value) {
            addCriterion("hMinorTot >", value, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotGreaterThanOrEqualTo(Float value) {
            addCriterion("hMinorTot >=", value, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotLessThan(Float value) {
            addCriterion("hMinorTot <", value, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotLessThanOrEqualTo(Float value) {
            addCriterion("hMinorTot <=", value, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotIn(List<Float> values) {
            addCriterion("hMinorTot in", values, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotNotIn(List<Float> values) {
            addCriterion("hMinorTot not in", values, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotBetween(Float value1, Float value2) {
            addCriterion("hMinorTot between", value1, value2, "hminortot");
            return (Criteria) this;
        }

        public Criteria andHminortotNotBetween(Float value1, Float value2) {
            addCriterion("hMinorTot not between", value1, value2, "hminortot");
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