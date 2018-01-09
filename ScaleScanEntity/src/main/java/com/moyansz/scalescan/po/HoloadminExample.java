package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.List;

public class HoloadminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HoloadminExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aId is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aId is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aId =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aId <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aId >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aId >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aId <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aId <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aId in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aId not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aId between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aId not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAdminuserIsNull() {
            addCriterion("adminUser is null");
            return (Criteria) this;
        }

        public Criteria andAdminuserIsNotNull() {
            addCriterion("adminUser is not null");
            return (Criteria) this;
        }

        public Criteria andAdminuserEqualTo(String value) {
            addCriterion("adminUser =", value, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserNotEqualTo(String value) {
            addCriterion("adminUser <>", value, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserGreaterThan(String value) {
            addCriterion("adminUser >", value, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserGreaterThanOrEqualTo(String value) {
            addCriterion("adminUser >=", value, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserLessThan(String value) {
            addCriterion("adminUser <", value, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserLessThanOrEqualTo(String value) {
            addCriterion("adminUser <=", value, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserLike(String value) {
            addCriterion("adminUser like", value, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserNotLike(String value) {
            addCriterion("adminUser not like", value, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserIn(List<String> values) {
            addCriterion("adminUser in", values, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserNotIn(List<String> values) {
            addCriterion("adminUser not in", values, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserBetween(String value1, String value2) {
            addCriterion("adminUser between", value1, value2, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminuserNotBetween(String value1, String value2) {
            addCriterion("adminUser not between", value1, value2, "adminuser");
            return (Criteria) this;
        }

        public Criteria andAdminpwdIsNull() {
            addCriterion("adminPwd is null");
            return (Criteria) this;
        }

        public Criteria andAdminpwdIsNotNull() {
            addCriterion("adminPwd is not null");
            return (Criteria) this;
        }

        public Criteria andAdminpwdEqualTo(String value) {
            addCriterion("adminPwd =", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdNotEqualTo(String value) {
            addCriterion("adminPwd <>", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdGreaterThan(String value) {
            addCriterion("adminPwd >", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdGreaterThanOrEqualTo(String value) {
            addCriterion("adminPwd >=", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdLessThan(String value) {
            addCriterion("adminPwd <", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdLessThanOrEqualTo(String value) {
            addCriterion("adminPwd <=", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdLike(String value) {
            addCriterion("adminPwd like", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdNotLike(String value) {
            addCriterion("adminPwd not like", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdIn(List<String> values) {
            addCriterion("adminPwd in", values, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdNotIn(List<String> values) {
            addCriterion("adminPwd not in", values, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdBetween(String value1, String value2) {
            addCriterion("adminPwd between", value1, value2, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdNotBetween(String value1, String value2) {
            addCriterion("adminPwd not between", value1, value2, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminsecretIsNull() {
            addCriterion("adminSecret is null");
            return (Criteria) this;
        }

        public Criteria andAdminsecretIsNotNull() {
            addCriterion("adminSecret is not null");
            return (Criteria) this;
        }

        public Criteria andAdminsecretEqualTo(String value) {
            addCriterion("adminSecret =", value, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretNotEqualTo(String value) {
            addCriterion("adminSecret <>", value, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretGreaterThan(String value) {
            addCriterion("adminSecret >", value, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretGreaterThanOrEqualTo(String value) {
            addCriterion("adminSecret >=", value, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretLessThan(String value) {
            addCriterion("adminSecret <", value, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretLessThanOrEqualTo(String value) {
            addCriterion("adminSecret <=", value, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretLike(String value) {
            addCriterion("adminSecret like", value, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretNotLike(String value) {
            addCriterion("adminSecret not like", value, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretIn(List<String> values) {
            addCriterion("adminSecret in", values, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretNotIn(List<String> values) {
            addCriterion("adminSecret not in", values, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretBetween(String value1, String value2) {
            addCriterion("adminSecret between", value1, value2, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andAdminsecretNotBetween(String value1, String value2) {
            addCriterion("adminSecret not between", value1, value2, "adminsecret");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNull() {
            addCriterion("permission is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNotNull() {
            addCriterion("permission is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionEqualTo(Integer value) {
            addCriterion("permission =", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotEqualTo(Integer value) {
            addCriterion("permission <>", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThan(Integer value) {
            addCriterion("permission >", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission >=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThan(Integer value) {
            addCriterion("permission <", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThanOrEqualTo(Integer value) {
            addCriterion("permission <=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionIn(List<Integer> values) {
            addCriterion("permission in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotIn(List<Integer> values) {
            addCriterion("permission not in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionBetween(Integer value1, Integer value2) {
            addCriterion("permission between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("permission not between", value1, value2, "permission");
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