package com.moyansz.scalescan.service;

import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.result.SecretkeysResult;
import com.moyansz.scalescan.po.vo.SecretkeysVo;

import org.codehaus.jackson.map.util.LRUMap;

import java.util.LinkedList;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.service
 * className:	        SecretkeysService
 * author:	            Luoxiang
 * time:	            2017/5/11	8:57
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

public interface SecretkeysService {
    CommBean<SecretkeysResult> updateActive(SecretkeysVo secretkeysVo);

    CommBean checkActived(String activeCode, String hmobilenum,LRUMap<String , LinkedList<String>> listHashMap);
}
