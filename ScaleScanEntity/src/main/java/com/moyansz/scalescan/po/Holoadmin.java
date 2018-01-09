package com.moyansz.scalescan.po;

public class Holoadmin {
    private Integer aid;

    private String adminuser;

    private String adminpwd;

    private String adminsecret;

    private Integer permission;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAdminuser() {
        return adminuser;
    }

    public void setAdminuser(String adminuser) {
        this.adminuser = adminuser == null ? null : adminuser.trim();
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd == null ? null : adminpwd.trim();
    }

    public String getAdminsecret() {
        return adminsecret;
    }

    public void setAdminsecret(String adminsecret) {
        this.adminsecret = adminsecret == null ? null : adminsecret.trim();
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}