package com.moyansz.scalescan.po;

import java.util.Date;

public class Holomodlefile {
    private Integer id;

    private String modlepath;

    private Integer fkuserid;

    private Date uploadtime;

    private Integer category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModlepath() {
        return modlepath;
    }

    public void setModlepath(String modlepath) {
        this.modlepath = modlepath == null ? null : modlepath.trim();
    }

    public Integer getFkuserid() {
        return fkuserid;
    }

    public void setFkuserid(Integer fkuserid) {
        this.fkuserid = fkuserid;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}