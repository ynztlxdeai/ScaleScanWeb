package com.moyansz.scalescan.po.constants;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.po.constants
 * className:	        ConstantsErrorMsg
 * author:	            Luoxiang
 * time:	            2017/5/11	9:07
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

public interface ConstantsErrorMsg {
    String SUCCESS = "成功";

    String PHONE_ERROR = "手机号码不正确";

    String LOGIN_TIME_OUT = "登录已过期请重新登录";

    String REGIST_ERROR = "注册失败";

    String PWD_FORMAT_ERROR = "密码格式不正确,输入6-16位";

    String MODIFY_PWD_ERROR = "更改密码失败";

    String PHONE_OR_PWD_ERROR = "手机号或者密码错误";

    String PHONE_UNREGIST  = "手机号未注册";

    String USERNAME_FORMAT_ERROR = "用户名格式不正确,太长或空";

    String UPDATE_USERNAME_ERROR = "用户名更新失败";

    String DESC_FORMAT_ERROR = "个性签名格式错误,太长或空";

    String UPDATE_DESC_ERROR = "个性签名更新失败";

    String ACTIVE_CODE_ERROR = "激活码不正确";

    String PASSID_ERROR = "身份校验失败";

    String UPLOAD_MODLE_ERROR = "上传模型失败";

    String ACTIVE_CODE_BE_USED = "激活码已经被使用";

    String UPLOAD_PIC_ERROR = "头像上传失败";

    String FILE_NAME_FORMAT_ERROR = "文件名格式错误";

    String FILE_NOT_EXISTS = "文件不存在";

    String USER_EXISTS = "用户已存在";

    String FEED_BACK_ERROR = "反馈记录失败";

    String OLD_NEW_PWD_SAME = "新旧密码不能相同";
}
