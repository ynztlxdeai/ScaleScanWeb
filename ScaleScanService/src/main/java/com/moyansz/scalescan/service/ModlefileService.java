package com.moyansz.scalescan.service;

import com.moyansz.scalescan.po.Holomodlefile;
import com.moyansz.scalescan.po.result.CommBean;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.service
 * className:	        ModlefileService
 * author:	            Luoxiang
 * time:	            2017/5/11	16:12
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

public interface ModlefileService {
    void insert(Holomodlefile modlefileVo);

    CommBean selectModle(String fileName);

    CommBean selectByNameAndUserid(String filename, Integer userid);
}
