package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.List;

public class HoloentgoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HoloentgoodsExample() {
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

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameIsNull() {
            addCriterion("hGoodsName is null");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameIsNotNull() {
            addCriterion("hGoodsName is not null");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameEqualTo(String value) {
            addCriterion("hGoodsName =", value, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameNotEqualTo(String value) {
            addCriterion("hGoodsName <>", value, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameGreaterThan(String value) {
            addCriterion("hGoodsName >", value, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("hGoodsName >=", value, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameLessThan(String value) {
            addCriterion("hGoodsName <", value, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameLessThanOrEqualTo(String value) {
            addCriterion("hGoodsName <=", value, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameLike(String value) {
            addCriterion("hGoodsName like", value, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameNotLike(String value) {
            addCriterion("hGoodsName not like", value, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameIn(List<String> values) {
            addCriterion("hGoodsName in", values, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameNotIn(List<String> values) {
            addCriterion("hGoodsName not in", values, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameBetween(String value1, String value2) {
            addCriterion("hGoodsName between", value1, value2, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodsnameNotBetween(String value1, String value2) {
            addCriterion("hGoodsName not between", value1, value2, "hgoodsname");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeIsNull() {
            addCriterion("hGoodsSize is null");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeIsNotNull() {
            addCriterion("hGoodsSize is not null");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeEqualTo(String value) {
            addCriterion("hGoodsSize =", value, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeNotEqualTo(String value) {
            addCriterion("hGoodsSize <>", value, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeGreaterThan(String value) {
            addCriterion("hGoodsSize >", value, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeGreaterThanOrEqualTo(String value) {
            addCriterion("hGoodsSize >=", value, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeLessThan(String value) {
            addCriterion("hGoodsSize <", value, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeLessThanOrEqualTo(String value) {
            addCriterion("hGoodsSize <=", value, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeLike(String value) {
            addCriterion("hGoodsSize like", value, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeNotLike(String value) {
            addCriterion("hGoodsSize not like", value, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeIn(List<String> values) {
            addCriterion("hGoodsSize in", values, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeNotIn(List<String> values) {
            addCriterion("hGoodsSize not in", values, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeBetween(String value1, String value2) {
            addCriterion("hGoodsSize between", value1, value2, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodssizeNotBetween(String value1, String value2) {
            addCriterion("hGoodsSize not between", value1, value2, "hgoodssize");
            return (Criteria) this;
        }

        public Criteria andHgoodspicIsNull() {
            addCriterion("hGoodsPic is null");
            return (Criteria) this;
        }

        public Criteria andHgoodspicIsNotNull() {
            addCriterion("hGoodsPic is not null");
            return (Criteria) this;
        }

        public Criteria andHgoodspicEqualTo(String value) {
            addCriterion("hGoodsPic =", value, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicNotEqualTo(String value) {
            addCriterion("hGoodsPic <>", value, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicGreaterThan(String value) {
            addCriterion("hGoodsPic >", value, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicGreaterThanOrEqualTo(String value) {
            addCriterion("hGoodsPic >=", value, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicLessThan(String value) {
            addCriterion("hGoodsPic <", value, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicLessThanOrEqualTo(String value) {
            addCriterion("hGoodsPic <=", value, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicLike(String value) {
            addCriterion("hGoodsPic like", value, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicNotLike(String value) {
            addCriterion("hGoodsPic not like", value, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicIn(List<String> values) {
            addCriterion("hGoodsPic in", values, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicNotIn(List<String> values) {
            addCriterion("hGoodsPic not in", values, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicBetween(String value1, String value2) {
            addCriterion("hGoodsPic between", value1, value2, "hgoodspic");
            return (Criteria) this;
        }

        public Criteria andHgoodspicNotBetween(String value1, String value2) {
            addCriterion("hGoodsPic not between", value1, value2, "hgoodspic");
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

        public Criteria andHwholesalepriceIsNull() {
            addCriterion("hWholeSalePrice is null");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceIsNotNull() {
            addCriterion("hWholeSalePrice is not null");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceEqualTo(Float value) {
            addCriterion("hWholeSalePrice =", value, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceNotEqualTo(Float value) {
            addCriterion("hWholeSalePrice <>", value, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceGreaterThan(Float value) {
            addCriterion("hWholeSalePrice >", value, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceGreaterThanOrEqualTo(Float value) {
            addCriterion("hWholeSalePrice >=", value, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceLessThan(Float value) {
            addCriterion("hWholeSalePrice <", value, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceLessThanOrEqualTo(Float value) {
            addCriterion("hWholeSalePrice <=", value, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceIn(List<Float> values) {
            addCriterion("hWholeSalePrice in", values, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceNotIn(List<Float> values) {
            addCriterion("hWholeSalePrice not in", values, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceBetween(Float value1, Float value2) {
            addCriterion("hWholeSalePrice between", value1, value2, "hwholesaleprice");
            return (Criteria) this;
        }

        public Criteria andHwholesalepriceNotBetween(Float value1, Float value2) {
            addCriterion("hWholeSalePrice not between", value1, value2, "hwholesaleprice");
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