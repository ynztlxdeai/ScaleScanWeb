package com.moyansz.scalescan.po.vo;

import com.moyansz.scalescan.po.Holoenterprise;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.po.vo
 * className:	        SecretkeysVo
 * author:	            Luoxiang
 * time:	            2017/5/11	8:53
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

public class SecretkeysVo {
    private Holoenterprise holoenterprise;

    private String activeCode;

    public Holoenterprise getHoloenterprise() {
        return holoenterprise;
    }

    public void setHoloenterprise(Holoenterprise holoenterprise) {
        this.holoenterprise = holoenterprise;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }
}
