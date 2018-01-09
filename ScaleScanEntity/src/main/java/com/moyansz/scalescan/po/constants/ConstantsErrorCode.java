package com.moyansz.scalescan.po.constants;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.po.constants
 * className:	        ConstantsErrorCode
 * author:	            Luoxiang
 * time:	            2017/5/11	9:07
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

public interface ConstantsErrorCode {

    int SUCCESS = 0;

    int PHONE_ERROR = 1;

    int LOGIN_TIME_OUT = 2;

    int REGIST_ERROR = 3;

    int PWD_FORMAT_ERROR = 4;

    int MODIFY_PWD_ERROR = 5;

    int PHONE_OR_PWD_ERROR = 6;

    int PHONE_UNREGIST = 7;

    int USERNAME_FORMAT_ERROR = 8;

    int UPDATE_USERNAME_ERROR = 9;

    int DESC_FORMAT_ERROR = 10;

    int UPDATE_DESC_ERROR = 11;

    int ACTIVE_CODE_ERROR = 12;

    int PASSID_ERROR = 13;

    int UPLOAD_MODLE_ERROR = 14;

    int ACTIVE_CODE_BE_USED = 15;

    int UPLOAD_PIC_ERROR = 16;

    int FILE_NAME_FORMAT_ERROR = 17;

    int FILE_NOT_EXISTS =18;

    int USER_EXISTS = 19;

    int FEED_BACK_ERROR = 20;

    int OLD_NEW_PWD_SAME = 21;
}
