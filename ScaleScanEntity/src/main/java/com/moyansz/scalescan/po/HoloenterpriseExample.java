package com.moyansz.scalescan.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HoloenterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HoloenterpriseExample() {
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

        public Criteria andHusernameIsNull() {
            addCriterion("hUserName is null");
            return (Criteria) this;
        }

        public Criteria andHusernameIsNotNull() {
            addCriterion("hUserName is not null");
            return (Criteria) this;
        }

        public Criteria andHusernameEqualTo(String value) {
            addCriterion("hUserName =", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameNotEqualTo(String value) {
            addCriterion("hUserName <>", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameGreaterThan(String value) {
            addCriterion("hUserName >", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameGreaterThanOrEqualTo(String value) {
            addCriterion("hUserName >=", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameLessThan(String value) {
            addCriterion("hUserName <", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameLessThanOrEqualTo(String value) {
            addCriterion("hUserName <=", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameLike(String value) {
            addCriterion("hUserName like", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameNotLike(String value) {
            addCriterion("hUserName not like", value, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameIn(List<String> values) {
            addCriterion("hUserName in", values, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameNotIn(List<String> values) {
            addCriterion("hUserName not in", values, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameBetween(String value1, String value2) {
            addCriterion("hUserName between", value1, value2, "husername");
            return (Criteria) this;
        }

        public Criteria andHusernameNotBetween(String value1, String value2) {
            addCriterion("hUserName not between", value1, value2, "husername");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordIsNull() {
            addCriterion("hUserPassword is null");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordIsNotNull() {
            addCriterion("hUserPassword is not null");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordEqualTo(String value) {
            addCriterion("hUserPassword =", value, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordNotEqualTo(String value) {
            addCriterion("hUserPassword <>", value, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordGreaterThan(String value) {
            addCriterion("hUserPassword >", value, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("hUserPassword >=", value, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordLessThan(String value) {
            addCriterion("hUserPassword <", value, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordLessThanOrEqualTo(String value) {
            addCriterion("hUserPassword <=", value, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordLike(String value) {
            addCriterion("hUserPassword like", value, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordNotLike(String value) {
            addCriterion("hUserPassword not like", value, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordIn(List<String> values) {
            addCriterion("hUserPassword in", values, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordNotIn(List<String> values) {
            addCriterion("hUserPassword not in", values, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordBetween(String value1, String value2) {
            addCriterion("hUserPassword between", value1, value2, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHuserpasswordNotBetween(String value1, String value2) {
            addCriterion("hUserPassword not between", value1, value2, "huserpassword");
            return (Criteria) this;
        }

        public Criteria andHentnameIsNull() {
            addCriterion("hEntName is null");
            return (Criteria) this;
        }

        public Criteria andHentnameIsNotNull() {
            addCriterion("hEntName is not null");
            return (Criteria) this;
        }

        public Criteria andHentnameEqualTo(String value) {
            addCriterion("hEntName =", value, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameNotEqualTo(String value) {
            addCriterion("hEntName <>", value, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameGreaterThan(String value) {
            addCriterion("hEntName >", value, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameGreaterThanOrEqualTo(String value) {
            addCriterion("hEntName >=", value, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameLessThan(String value) {
            addCriterion("hEntName <", value, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameLessThanOrEqualTo(String value) {
            addCriterion("hEntName <=", value, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameLike(String value) {
            addCriterion("hEntName like", value, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameNotLike(String value) {
            addCriterion("hEntName not like", value, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameIn(List<String> values) {
            addCriterion("hEntName in", values, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameNotIn(List<String> values) {
            addCriterion("hEntName not in", values, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameBetween(String value1, String value2) {
            addCriterion("hEntName between", value1, value2, "hentname");
            return (Criteria) this;
        }

        public Criteria andHentnameNotBetween(String value1, String value2) {
            addCriterion("hEntName not between", value1, value2, "hentname");
            return (Criteria) this;
        }

        public Criteria andHcontactIsNull() {
            addCriterion("hContact is null");
            return (Criteria) this;
        }

        public Criteria andHcontactIsNotNull() {
            addCriterion("hContact is not null");
            return (Criteria) this;
        }

        public Criteria andHcontactEqualTo(String value) {
            addCriterion("hContact =", value, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactNotEqualTo(String value) {
            addCriterion("hContact <>", value, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactGreaterThan(String value) {
            addCriterion("hContact >", value, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactGreaterThanOrEqualTo(String value) {
            addCriterion("hContact >=", value, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactLessThan(String value) {
            addCriterion("hContact <", value, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactLessThanOrEqualTo(String value) {
            addCriterion("hContact <=", value, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactLike(String value) {
            addCriterion("hContact like", value, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactNotLike(String value) {
            addCriterion("hContact not like", value, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactIn(List<String> values) {
            addCriterion("hContact in", values, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactNotIn(List<String> values) {
            addCriterion("hContact not in", values, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactBetween(String value1, String value2) {
            addCriterion("hContact between", value1, value2, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHcontactNotBetween(String value1, String value2) {
            addCriterion("hContact not between", value1, value2, "hcontact");
            return (Criteria) this;
        }

        public Criteria andHphoneIsNull() {
            addCriterion("hPhone is null");
            return (Criteria) this;
        }

        public Criteria andHphoneIsNotNull() {
            addCriterion("hPhone is not null");
            return (Criteria) this;
        }

        public Criteria andHphoneEqualTo(String value) {
            addCriterion("hPhone =", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneNotEqualTo(String value) {
            addCriterion("hPhone <>", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneGreaterThan(String value) {
            addCriterion("hPhone >", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneGreaterThanOrEqualTo(String value) {
            addCriterion("hPhone >=", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneLessThan(String value) {
            addCriterion("hPhone <", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneLessThanOrEqualTo(String value) {
            addCriterion("hPhone <=", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneLike(String value) {
            addCriterion("hPhone like", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneNotLike(String value) {
            addCriterion("hPhone not like", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneIn(List<String> values) {
            addCriterion("hPhone in", values, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneNotIn(List<String> values) {
            addCriterion("hPhone not in", values, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneBetween(String value1, String value2) {
            addCriterion("hPhone between", value1, value2, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneNotBetween(String value1, String value2) {
            addCriterion("hPhone not between", value1, value2, "hphone");
            return (Criteria) this;
        }

        public Criteria andHprovinceIsNull() {
            addCriterion("hProvince is null");
            return (Criteria) this;
        }

        public Criteria andHprovinceIsNotNull() {
            addCriterion("hProvince is not null");
            return (Criteria) this;
        }

        public Criteria andHprovinceEqualTo(String value) {
            addCriterion("hProvince =", value, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceNotEqualTo(String value) {
            addCriterion("hProvince <>", value, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceGreaterThan(String value) {
            addCriterion("hProvince >", value, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("hProvince >=", value, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceLessThan(String value) {
            addCriterion("hProvince <", value, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceLessThanOrEqualTo(String value) {
            addCriterion("hProvince <=", value, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceLike(String value) {
            addCriterion("hProvince like", value, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceNotLike(String value) {
            addCriterion("hProvince not like", value, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceIn(List<String> values) {
            addCriterion("hProvince in", values, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceNotIn(List<String> values) {
            addCriterion("hProvince not in", values, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceBetween(String value1, String value2) {
            addCriterion("hProvince between", value1, value2, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHprovinceNotBetween(String value1, String value2) {
            addCriterion("hProvince not between", value1, value2, "hprovince");
            return (Criteria) this;
        }

        public Criteria andHcityIsNull() {
            addCriterion("hCity is null");
            return (Criteria) this;
        }

        public Criteria andHcityIsNotNull() {
            addCriterion("hCity is not null");
            return (Criteria) this;
        }

        public Criteria andHcityEqualTo(String value) {
            addCriterion("hCity =", value, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityNotEqualTo(String value) {
            addCriterion("hCity <>", value, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityGreaterThan(String value) {
            addCriterion("hCity >", value, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityGreaterThanOrEqualTo(String value) {
            addCriterion("hCity >=", value, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityLessThan(String value) {
            addCriterion("hCity <", value, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityLessThanOrEqualTo(String value) {
            addCriterion("hCity <=", value, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityLike(String value) {
            addCriterion("hCity like", value, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityNotLike(String value) {
            addCriterion("hCity not like", value, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityIn(List<String> values) {
            addCriterion("hCity in", values, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityNotIn(List<String> values) {
            addCriterion("hCity not in", values, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityBetween(String value1, String value2) {
            addCriterion("hCity between", value1, value2, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcityNotBetween(String value1, String value2) {
            addCriterion("hCity not between", value1, value2, "hcity");
            return (Criteria) this;
        }

        public Criteria andHcountIsNull() {
            addCriterion("hCount is null");
            return (Criteria) this;
        }

        public Criteria andHcountIsNotNull() {
            addCriterion("hCount is not null");
            return (Criteria) this;
        }

        public Criteria andHcountEqualTo(String value) {
            addCriterion("hCount =", value, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountNotEqualTo(String value) {
            addCriterion("hCount <>", value, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountGreaterThan(String value) {
            addCriterion("hCount >", value, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountGreaterThanOrEqualTo(String value) {
            addCriterion("hCount >=", value, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountLessThan(String value) {
            addCriterion("hCount <", value, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountLessThanOrEqualTo(String value) {
            addCriterion("hCount <=", value, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountLike(String value) {
            addCriterion("hCount like", value, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountNotLike(String value) {
            addCriterion("hCount not like", value, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountIn(List<String> values) {
            addCriterion("hCount in", values, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountNotIn(List<String> values) {
            addCriterion("hCount not in", values, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountBetween(String value1, String value2) {
            addCriterion("hCount between", value1, value2, "hcount");
            return (Criteria) this;
        }

        public Criteria andHcountNotBetween(String value1, String value2) {
            addCriterion("hCount not between", value1, value2, "hcount");
            return (Criteria) this;
        }

        public Criteria andHaddressIsNull() {
            addCriterion("hAddress is null");
            return (Criteria) this;
        }

        public Criteria andHaddressIsNotNull() {
            addCriterion("hAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHaddressEqualTo(String value) {
            addCriterion("hAddress =", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressNotEqualTo(String value) {
            addCriterion("hAddress <>", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressGreaterThan(String value) {
            addCriterion("hAddress >", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressGreaterThanOrEqualTo(String value) {
            addCriterion("hAddress >=", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressLessThan(String value) {
            addCriterion("hAddress <", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressLessThanOrEqualTo(String value) {
            addCriterion("hAddress <=", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressLike(String value) {
            addCriterion("hAddress like", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressNotLike(String value) {
            addCriterion("hAddress not like", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressIn(List<String> values) {
            addCriterion("hAddress in", values, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressNotIn(List<String> values) {
            addCriterion("hAddress not in", values, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressBetween(String value1, String value2) {
            addCriterion("hAddress between", value1, value2, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressNotBetween(String value1, String value2) {
            addCriterion("hAddress not between", value1, value2, "haddress");
            return (Criteria) this;
        }

        public Criteria andHcategoryIsNull() {
            addCriterion("hCategory is null");
            return (Criteria) this;
        }

        public Criteria andHcategoryIsNotNull() {
            addCriterion("hCategory is not null");
            return (Criteria) this;
        }

        public Criteria andHcategoryEqualTo(Short value) {
            addCriterion("hCategory =", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryNotEqualTo(Short value) {
            addCriterion("hCategory <>", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryGreaterThan(Short value) {
            addCriterion("hCategory >", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryGreaterThanOrEqualTo(Short value) {
            addCriterion("hCategory >=", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryLessThan(Short value) {
            addCriterion("hCategory <", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryLessThanOrEqualTo(Short value) {
            addCriterion("hCategory <=", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryIn(List<Short> values) {
            addCriterion("hCategory in", values, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryNotIn(List<Short> values) {
            addCriterion("hCategory not in", values, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryBetween(Short value1, Short value2) {
            addCriterion("hCategory between", value1, value2, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryNotBetween(Short value1, Short value2) {
            addCriterion("hCategory not between", value1, value2, "hcategory");
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

        public Criteria andHbankIsNull() {
            addCriterion("hBank is null");
            return (Criteria) this;
        }

        public Criteria andHbankIsNotNull() {
            addCriterion("hBank is not null");
            return (Criteria) this;
        }

        public Criteria andHbankEqualTo(String value) {
            addCriterion("hBank =", value, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankNotEqualTo(String value) {
            addCriterion("hBank <>", value, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankGreaterThan(String value) {
            addCriterion("hBank >", value, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankGreaterThanOrEqualTo(String value) {
            addCriterion("hBank >=", value, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankLessThan(String value) {
            addCriterion("hBank <", value, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankLessThanOrEqualTo(String value) {
            addCriterion("hBank <=", value, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankLike(String value) {
            addCriterion("hBank like", value, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankNotLike(String value) {
            addCriterion("hBank not like", value, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankIn(List<String> values) {
            addCriterion("hBank in", values, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankNotIn(List<String> values) {
            addCriterion("hBank not in", values, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankBetween(String value1, String value2) {
            addCriterion("hBank between", value1, value2, "hbank");
            return (Criteria) this;
        }

        public Criteria andHbankNotBetween(String value1, String value2) {
            addCriterion("hBank not between", value1, value2, "hbank");
            return (Criteria) this;
        }

        public Criteria andHaccountIsNull() {
            addCriterion("hAccount is null");
            return (Criteria) this;
        }

        public Criteria andHaccountIsNotNull() {
            addCriterion("hAccount is not null");
            return (Criteria) this;
        }

        public Criteria andHaccountEqualTo(String value) {
            addCriterion("hAccount =", value, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountNotEqualTo(String value) {
            addCriterion("hAccount <>", value, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountGreaterThan(String value) {
            addCriterion("hAccount >", value, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountGreaterThanOrEqualTo(String value) {
            addCriterion("hAccount >=", value, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountLessThan(String value) {
            addCriterion("hAccount <", value, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountLessThanOrEqualTo(String value) {
            addCriterion("hAccount <=", value, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountLike(String value) {
            addCriterion("hAccount like", value, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountNotLike(String value) {
            addCriterion("hAccount not like", value, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountIn(List<String> values) {
            addCriterion("hAccount in", values, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountNotIn(List<String> values) {
            addCriterion("hAccount not in", values, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountBetween(String value1, String value2) {
            addCriterion("hAccount between", value1, value2, "haccount");
            return (Criteria) this;
        }

        public Criteria andHaccountNotBetween(String value1, String value2) {
            addCriterion("hAccount not between", value1, value2, "haccount");
            return (Criteria) this;
        }

        public Criteria andHentdescIsNull() {
            addCriterion("hEntDesc is null");
            return (Criteria) this;
        }

        public Criteria andHentdescIsNotNull() {
            addCriterion("hEntDesc is not null");
            return (Criteria) this;
        }

        public Criteria andHentdescEqualTo(String value) {
            addCriterion("hEntDesc =", value, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescNotEqualTo(String value) {
            addCriterion("hEntDesc <>", value, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescGreaterThan(String value) {
            addCriterion("hEntDesc >", value, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescGreaterThanOrEqualTo(String value) {
            addCriterion("hEntDesc >=", value, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescLessThan(String value) {
            addCriterion("hEntDesc <", value, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescLessThanOrEqualTo(String value) {
            addCriterion("hEntDesc <=", value, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescLike(String value) {
            addCriterion("hEntDesc like", value, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescNotLike(String value) {
            addCriterion("hEntDesc not like", value, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescIn(List<String> values) {
            addCriterion("hEntDesc in", values, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescNotIn(List<String> values) {
            addCriterion("hEntDesc not in", values, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescBetween(String value1, String value2) {
            addCriterion("hEntDesc between", value1, value2, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentdescNotBetween(String value1, String value2) {
            addCriterion("hEntDesc not between", value1, value2, "hentdesc");
            return (Criteria) this;
        }

        public Criteria andHentpic1IsNull() {
            addCriterion("hEntPic1 is null");
            return (Criteria) this;
        }

        public Criteria andHentpic1IsNotNull() {
            addCriterion("hEntPic1 is not null");
            return (Criteria) this;
        }

        public Criteria andHentpic1EqualTo(String value) {
            addCriterion("hEntPic1 =", value, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1NotEqualTo(String value) {
            addCriterion("hEntPic1 <>", value, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1GreaterThan(String value) {
            addCriterion("hEntPic1 >", value, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1GreaterThanOrEqualTo(String value) {
            addCriterion("hEntPic1 >=", value, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1LessThan(String value) {
            addCriterion("hEntPic1 <", value, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1LessThanOrEqualTo(String value) {
            addCriterion("hEntPic1 <=", value, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1Like(String value) {
            addCriterion("hEntPic1 like", value, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1NotLike(String value) {
            addCriterion("hEntPic1 not like", value, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1In(List<String> values) {
            addCriterion("hEntPic1 in", values, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1NotIn(List<String> values) {
            addCriterion("hEntPic1 not in", values, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1Between(String value1, String value2) {
            addCriterion("hEntPic1 between", value1, value2, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic1NotBetween(String value1, String value2) {
            addCriterion("hEntPic1 not between", value1, value2, "hentpic1");
            return (Criteria) this;
        }

        public Criteria andHentpic2IsNull() {
            addCriterion("hEntPic2 is null");
            return (Criteria) this;
        }

        public Criteria andHentpic2IsNotNull() {
            addCriterion("hEntPic2 is not null");
            return (Criteria) this;
        }

        public Criteria andHentpic2EqualTo(String value) {
            addCriterion("hEntPic2 =", value, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2NotEqualTo(String value) {
            addCriterion("hEntPic2 <>", value, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2GreaterThan(String value) {
            addCriterion("hEntPic2 >", value, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2GreaterThanOrEqualTo(String value) {
            addCriterion("hEntPic2 >=", value, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2LessThan(String value) {
            addCriterion("hEntPic2 <", value, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2LessThanOrEqualTo(String value) {
            addCriterion("hEntPic2 <=", value, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2Like(String value) {
            addCriterion("hEntPic2 like", value, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2NotLike(String value) {
            addCriterion("hEntPic2 not like", value, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2In(List<String> values) {
            addCriterion("hEntPic2 in", values, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2NotIn(List<String> values) {
            addCriterion("hEntPic2 not in", values, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2Between(String value1, String value2) {
            addCriterion("hEntPic2 between", value1, value2, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic2NotBetween(String value1, String value2) {
            addCriterion("hEntPic2 not between", value1, value2, "hentpic2");
            return (Criteria) this;
        }

        public Criteria andHentpic3IsNull() {
            addCriterion("hEntPic3 is null");
            return (Criteria) this;
        }

        public Criteria andHentpic3IsNotNull() {
            addCriterion("hEntPic3 is not null");
            return (Criteria) this;
        }

        public Criteria andHentpic3EqualTo(String value) {
            addCriterion("hEntPic3 =", value, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3NotEqualTo(String value) {
            addCriterion("hEntPic3 <>", value, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3GreaterThan(String value) {
            addCriterion("hEntPic3 >", value, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3GreaterThanOrEqualTo(String value) {
            addCriterion("hEntPic3 >=", value, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3LessThan(String value) {
            addCriterion("hEntPic3 <", value, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3LessThanOrEqualTo(String value) {
            addCriterion("hEntPic3 <=", value, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3Like(String value) {
            addCriterion("hEntPic3 like", value, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3NotLike(String value) {
            addCriterion("hEntPic3 not like", value, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3In(List<String> values) {
            addCriterion("hEntPic3 in", values, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3NotIn(List<String> values) {
            addCriterion("hEntPic3 not in", values, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3Between(String value1, String value2) {
            addCriterion("hEntPic3 between", value1, value2, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic3NotBetween(String value1, String value2) {
            addCriterion("hEntPic3 not between", value1, value2, "hentpic3");
            return (Criteria) this;
        }

        public Criteria andHentpic4IsNull() {
            addCriterion("hEntPic4 is null");
            return (Criteria) this;
        }

        public Criteria andHentpic4IsNotNull() {
            addCriterion("hEntPic4 is not null");
            return (Criteria) this;
        }

        public Criteria andHentpic4EqualTo(String value) {
            addCriterion("hEntPic4 =", value, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4NotEqualTo(String value) {
            addCriterion("hEntPic4 <>", value, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4GreaterThan(String value) {
            addCriterion("hEntPic4 >", value, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4GreaterThanOrEqualTo(String value) {
            addCriterion("hEntPic4 >=", value, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4LessThan(String value) {
            addCriterion("hEntPic4 <", value, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4LessThanOrEqualTo(String value) {
            addCriterion("hEntPic4 <=", value, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4Like(String value) {
            addCriterion("hEntPic4 like", value, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4NotLike(String value) {
            addCriterion("hEntPic4 not like", value, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4In(List<String> values) {
            addCriterion("hEntPic4 in", values, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4NotIn(List<String> values) {
            addCriterion("hEntPic4 not in", values, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4Between(String value1, String value2) {
            addCriterion("hEntPic4 between", value1, value2, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic4NotBetween(String value1, String value2) {
            addCriterion("hEntPic4 not between", value1, value2, "hentpic4");
            return (Criteria) this;
        }

        public Criteria andHentpic5IsNull() {
            addCriterion("hEntPic5 is null");
            return (Criteria) this;
        }

        public Criteria andHentpic5IsNotNull() {
            addCriterion("hEntPic5 is not null");
            return (Criteria) this;
        }

        public Criteria andHentpic5EqualTo(String value) {
            addCriterion("hEntPic5 =", value, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5NotEqualTo(String value) {
            addCriterion("hEntPic5 <>", value, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5GreaterThan(String value) {
            addCriterion("hEntPic5 >", value, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5GreaterThanOrEqualTo(String value) {
            addCriterion("hEntPic5 >=", value, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5LessThan(String value) {
            addCriterion("hEntPic5 <", value, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5LessThanOrEqualTo(String value) {
            addCriterion("hEntPic5 <=", value, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5Like(String value) {
            addCriterion("hEntPic5 like", value, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5NotLike(String value) {
            addCriterion("hEntPic5 not like", value, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5In(List<String> values) {
            addCriterion("hEntPic5 in", values, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5NotIn(List<String> values) {
            addCriterion("hEntPic5 not in", values, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5Between(String value1, String value2) {
            addCriterion("hEntPic5 between", value1, value2, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHentpic5NotBetween(String value1, String value2) {
            addCriterion("hEntPic5 not between", value1, value2, "hentpic5");
            return (Criteria) this;
        }

        public Criteria andHmobilenumIsNull() {
            addCriterion("hMobileNum is null");
            return (Criteria) this;
        }

        public Criteria andHmobilenumIsNotNull() {
            addCriterion("hMobileNum is not null");
            return (Criteria) this;
        }

        public Criteria andHmobilenumEqualTo(String value) {
            addCriterion("hMobileNum =", value, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumNotEqualTo(String value) {
            addCriterion("hMobileNum <>", value, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumGreaterThan(String value) {
            addCriterion("hMobileNum >", value, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumGreaterThanOrEqualTo(String value) {
            addCriterion("hMobileNum >=", value, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumLessThan(String value) {
            addCriterion("hMobileNum <", value, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumLessThanOrEqualTo(String value) {
            addCriterion("hMobileNum <=", value, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumLike(String value) {
            addCriterion("hMobileNum like", value, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumNotLike(String value) {
            addCriterion("hMobileNum not like", value, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumIn(List<String> values) {
            addCriterion("hMobileNum in", values, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumNotIn(List<String> values) {
            addCriterion("hMobileNum not in", values, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumBetween(String value1, String value2) {
            addCriterion("hMobileNum between", value1, value2, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHmobilenumNotBetween(String value1, String value2) {
            addCriterion("hMobileNum not between", value1, value2, "hmobilenum");
            return (Criteria) this;
        }

        public Criteria andHouttimeIsNull() {
            addCriterion("hOutTime is null");
            return (Criteria) this;
        }

        public Criteria andHouttimeIsNotNull() {
            addCriterion("hOutTime is not null");
            return (Criteria) this;
        }

        public Criteria andHouttimeEqualTo(Float value) {
            addCriterion("hOutTime =", value, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeNotEqualTo(Float value) {
            addCriterion("hOutTime <>", value, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeGreaterThan(Float value) {
            addCriterion("hOutTime >", value, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeGreaterThanOrEqualTo(Float value) {
            addCriterion("hOutTime >=", value, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeLessThan(Float value) {
            addCriterion("hOutTime <", value, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeLessThanOrEqualTo(Float value) {
            addCriterion("hOutTime <=", value, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeIn(List<Float> values) {
            addCriterion("hOutTime in", values, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeNotIn(List<Float> values) {
            addCriterion("hOutTime not in", values, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeBetween(Float value1, Float value2) {
            addCriterion("hOutTime between", value1, value2, "houttime");
            return (Criteria) this;
        }

        public Criteria andHouttimeNotBetween(Float value1, Float value2) {
            addCriterion("hOutTime not between", value1, value2, "houttime");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeIsNull() {
            addCriterion("hSecurityCode is null");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeIsNotNull() {
            addCriterion("hSecurityCode is not null");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeEqualTo(String value) {
            addCriterion("hSecurityCode =", value, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeNotEqualTo(String value) {
            addCriterion("hSecurityCode <>", value, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeGreaterThan(String value) {
            addCriterion("hSecurityCode >", value, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeGreaterThanOrEqualTo(String value) {
            addCriterion("hSecurityCode >=", value, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeLessThan(String value) {
            addCriterion("hSecurityCode <", value, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeLessThanOrEqualTo(String value) {
            addCriterion("hSecurityCode <=", value, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeLike(String value) {
            addCriterion("hSecurityCode like", value, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeNotLike(String value) {
            addCriterion("hSecurityCode not like", value, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeIn(List<String> values) {
            addCriterion("hSecurityCode in", values, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeNotIn(List<String> values) {
            addCriterion("hSecurityCode not in", values, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeBetween(String value1, String value2) {
            addCriterion("hSecurityCode between", value1, value2, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHsecuritycodeNotBetween(String value1, String value2) {
            addCriterion("hSecurityCode not between", value1, value2, "hsecuritycode");
            return (Criteria) this;
        }

        public Criteria andHcardboredidIsNull() {
            addCriterion("hCardboredID is null");
            return (Criteria) this;
        }

        public Criteria andHcardboredidIsNotNull() {
            addCriterion("hCardboredID is not null");
            return (Criteria) this;
        }

        public Criteria andHcardboredidEqualTo(String value) {
            addCriterion("hCardboredID =", value, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidNotEqualTo(String value) {
            addCriterion("hCardboredID <>", value, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidGreaterThan(String value) {
            addCriterion("hCardboredID >", value, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidGreaterThanOrEqualTo(String value) {
            addCriterion("hCardboredID >=", value, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidLessThan(String value) {
            addCriterion("hCardboredID <", value, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidLessThanOrEqualTo(String value) {
            addCriterion("hCardboredID <=", value, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidLike(String value) {
            addCriterion("hCardboredID like", value, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidNotLike(String value) {
            addCriterion("hCardboredID not like", value, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidIn(List<String> values) {
            addCriterion("hCardboredID in", values, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidNotIn(List<String> values) {
            addCriterion("hCardboredID not in", values, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidBetween(String value1, String value2) {
            addCriterion("hCardboredID between", value1, value2, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHcardboredidNotBetween(String value1, String value2) {
            addCriterion("hCardboredID not between", value1, value2, "hcardboredid");
            return (Criteria) this;
        }

        public Criteria andHregisttimeIsNull() {
            addCriterion("hRegistTime is null");
            return (Criteria) this;
        }

        public Criteria andHregisttimeIsNotNull() {
            addCriterion("hRegistTime is not null");
            return (Criteria) this;
        }

        public Criteria andHregisttimeEqualTo(Date value) {
            addCriterionForJDBCDate("hRegistTime =", value, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("hRegistTime <>", value, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("hRegistTime >", value, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hRegistTime >=", value, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeLessThan(Date value) {
            addCriterionForJDBCDate("hRegistTime <", value, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hRegistTime <=", value, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeIn(List<Date> values) {
            addCriterionForJDBCDate("hRegistTime in", values, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("hRegistTime not in", values, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hRegistTime between", value1, value2, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHregisttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hRegistTime not between", value1, value2, "hregisttime");
            return (Criteria) this;
        }

        public Criteria andHcountryareaIsNull() {
            addCriterion("hCountryArea is null");
            return (Criteria) this;
        }

        public Criteria andHcountryareaIsNotNull() {
            addCriterion("hCountryArea is not null");
            return (Criteria) this;
        }

        public Criteria andHcountryareaEqualTo(String value) {
            addCriterion("hCountryArea =", value, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaNotEqualTo(String value) {
            addCriterion("hCountryArea <>", value, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaGreaterThan(String value) {
            addCriterion("hCountryArea >", value, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaGreaterThanOrEqualTo(String value) {
            addCriterion("hCountryArea >=", value, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaLessThan(String value) {
            addCriterion("hCountryArea <", value, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaLessThanOrEqualTo(String value) {
            addCriterion("hCountryArea <=", value, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaLike(String value) {
            addCriterion("hCountryArea like", value, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaNotLike(String value) {
            addCriterion("hCountryArea not like", value, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaIn(List<String> values) {
            addCriterion("hCountryArea in", values, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaNotIn(List<String> values) {
            addCriterion("hCountryArea not in", values, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaBetween(String value1, String value2) {
            addCriterion("hCountryArea between", value1, value2, "hcountryarea");
            return (Criteria) this;
        }

        public Criteria andHcountryareaNotBetween(String value1, String value2) {
            addCriterion("hCountryArea not between", value1, value2, "hcountryarea");
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