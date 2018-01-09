package com.moyansz.scalescan.po;

import java.util.Date;

public class Holob2csendorderhead {
    private Integer hsendid;

    private Integer horderid;

    private Date horderdate;

    private String hsendername;

    public Integer getHsendid() {
        return hsendid;
    }

    public void setHsendid(Integer hsendid) {
        this.hsendid = hsendid;
    }

    public Integer getHorderid() {
        return horderid;
    }

    public void setHorderid(Integer horderid) {
        this.horderid = horderid;
    }

    public Date getHorderdate() {
        return horderdate;
    }

    public void setHorderdate(Date horderdate) {
        this.horderdate = horderdate;
    }

    public String getHsendername() {
        return hsendername;
    }

    public void setHsendername(String hsendername) {
        this.hsendername = hsendername == null ? null : hsendername.trim();
    }
}