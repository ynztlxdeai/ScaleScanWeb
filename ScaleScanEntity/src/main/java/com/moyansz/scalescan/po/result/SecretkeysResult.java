package com.moyansz.scalescan.po.result;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.po.result
 * className:	        SecretkeysResult
 * author:	            Luoxiang
 * time:	            2017/5/11	19:07
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

public class SecretkeysResult {
    /**
     * 区分企业用户和普通用户
     */
    private int category;

    /**
     * 企业用户的最大数量
     */
    private int maxForEnterprises;


    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getMaxForEnterprises() {
        return maxForEnterprises;
    }

    public void setMaxForEnterprises(int maxForEnterprises) {
        this.maxForEnterprises = maxForEnterprises;
    }
}
