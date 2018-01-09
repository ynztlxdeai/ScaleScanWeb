package com.moyansz.scalescan.po;

public class Holosecretkeys {

    public static final Integer CATEGORY_NORMAL = 1;
    public static final Integer CATEGORY_ENTERPRISE = 2;

    private String secretkey;

    private Integer category;

    private Integer fkuserid;

    private Integer maxusers;

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey == null ? null : secretkey.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getFkuserid() {
        return fkuserid;
    }

    public void setFkuserid(Integer fkuserid) {
        this.fkuserid = fkuserid;
    }

    public Integer getMaxusers() {
        return maxusers;
    }

    public void setMaxusers(Integer maxusers) {
        this.maxusers = maxusers;
    }
}