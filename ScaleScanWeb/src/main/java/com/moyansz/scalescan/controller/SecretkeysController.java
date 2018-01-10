package com.moyansz.scalescan.controller;

import com.moyansz.scalescan.po.constants.ConstantsErrorCode;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.result.SecretkeysResult;
import com.moyansz.scalescan.po.vo.SecretkeysVo;
import com.moyansz.scalescan.service.SecretkeysService;

import org.codehaus.jackson.map.util.LRUMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;

import javax.annotation.Resource;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.controller
 * className:	        SecretkeysController
 * author:	            Luoxiang
 * time:	            2017/5/11	8:49
 * desc:	            用于控制激活列表
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

@Controller
@RequestMapping("/secretkeys")
public class SecretkeysController {

    @Resource
    private SecretkeysService secretkeysServiceImpl;

    /**
     * 暂时允许企业用户最大在线数100/机器
      */
    private static LRUMap<String , LinkedList<String>> listHashMap = new LRUMap<String , LinkedList<String>>(10 , 100);

    @RequestMapping("active")
    public @ResponseBody
    CommBean<SecretkeysResult> active(SecretkeysVo secretkeysVo){
        CommBean<SecretkeysResult> commBean = secretkeysServiceImpl.updateActive(secretkeysVo);
        if (commBean.getCode() == -1){
            LinkedList<String> linkedList = listHashMap.get(secretkeysVo.getActiveCode());
            if (linkedList != null){
                if ( linkedList.size() > commBean.getData().getMaxForEnterprises()){
                    linkedList.removeFirst();
                    linkedList.add(secretkeysVo.getHoloenterprise().getHmobilenum());
                }else {
                    if (!linkedList.contains(secretkeysVo.getHoloenterprise().getHmobilenum())){
                        linkedList.add(secretkeysVo.getHoloenterprise().getHmobilenum());
                    }
                }
            }else {
                linkedList = new LinkedList<>();
                linkedList.add(secretkeysVo.getHoloenterprise().getHmobilenum());
                listHashMap.put(secretkeysVo.getActiveCode() , linkedList);
            }
            commBean.setCode(ConstantsErrorCode.SUCCESS);
        }
        return commBean;
    }

    @RequestMapping("checkActived")
    public @ResponseBody
    CommBean checkActived(String activeCode , String hmobilenum){

        return secretkeysServiceImpl.checkActived(activeCode , hmobilenum , listHashMap);
    }

}
