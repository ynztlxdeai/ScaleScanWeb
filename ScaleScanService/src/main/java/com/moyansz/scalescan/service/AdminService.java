package com.moyansz.scalescan.service;

import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.vo.back.HoloadminVo;

/**
 * projectName: 	    ScaleScanWeb
 * packageName:	        com.moyansz.scalescan.service
 * className:	        AdminService
 * author:	            Luoxiang
 * time:	            2017/6/19	14:49
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/6/19
 * upDateDesc:	        TODO
 */


public interface AdminService {
    CommBean login(HoloadminVo holoadminVo, String contextPath);

    CommBean createSecretCode(int number , int category , String path, String filePath);
}
