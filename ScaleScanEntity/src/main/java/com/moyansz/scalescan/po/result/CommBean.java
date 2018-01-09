package com.moyansz.scalescan.po.result;

/**
 * projectName: 	    Magic3DScan
 * packageName:	        com.moyansz.magic3d.domain.net
 * className:	        CommBean
 * author:	            Luoxiang
 * time:	            17-4-20	上午10:56
 * desc:	            常规数据模式
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    vincent
 * upDate:	            17-4-20
 * upDateDesc:	        TODO
 */


public class CommBean<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
