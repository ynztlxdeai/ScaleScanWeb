package com.moyansz.scalescan.po.vo;

import com.moyansz.scalescan.po.Holoenterprise;
import com.moyansz.scalescan.po.Holosecretkeys;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.po.vo
 * className:	        LoginInfo
 * author:	            Luoxiang
 * time:	            2017/5/10	10:32
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/10
 * upDateDesc:	        TODO
 */

public class LoginInfo {
    /**
     * 用户登录服务器的session
     * 登录后以后的请求必须带上该session
     * 一下接口除外
     case "/enterprise/regist":
     case "/enterprise/forgetPwd":
     case "/enterprise/login":
     case "/enterprise/checkPhone":
     */
    private String uuid;

    private Holoenterprise holoenterprise;

    /**
     * 用户是否激活
     * 没有激活的用户在使用3D扫描的时候 需要先激活
     */
    private boolean isActive;

    private Holosecretkeys holosecretkeys;

    private boolean isRealyActive;

    public boolean isRealyActive() {
        return isRealyActive;
    }

    public void setRealyActive(boolean realyActive) {
        isRealyActive = realyActive;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Holoenterprise getHoloenterprise() {
        return holoenterprise;
    }

    public LoginInfo setHoloenterprise(Holoenterprise holoenterprise) {
        this.holoenterprise = holoenterprise;
        return this;
    }

    public Holosecretkeys getHolosecretkeys() {
        return holosecretkeys;
    }

    public LoginInfo setHolosecretkeys(Holosecretkeys holosecretkeys) {
        this.holosecretkeys = holosecretkeys;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
