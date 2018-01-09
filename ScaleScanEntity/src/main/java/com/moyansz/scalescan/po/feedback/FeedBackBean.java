package com.moyansz.scalescan.po.feedback;

/**
 * projectName: 	    ScaleScanWeb
 * packageName:	        com.moyansz.scalescan.po.feedback
 * className:	        FeedBackBean
 * author:	            Luoxiang
 * time:	            2017/6/29	15:48
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/6/29
 * upDateDesc:	        TODO
 */


public class FeedBackBean {
    //联系电话
    private String phone;
    //反馈内容
    private String content;
    //联系方式
    private String contract;
    //父级路径 存图用
    private String parentPath;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }
}
