package com.moyansz.scalescan.service.impl;

import com.moyansz.common.StringUtils;
import com.moyansz.scalescan.mapper.HolosecretkeysMapper;
import com.moyansz.scalescan.po.Holoenterprise;
import com.moyansz.scalescan.po.Holosecretkeys;
import com.moyansz.scalescan.po.HolosecretkeysExample;
import com.moyansz.scalescan.po.constants.ConstantsErrorCode;
import com.moyansz.scalescan.po.constants.ConstantsErrorMsg;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.result.SecretkeysResult;
import com.moyansz.scalescan.po.vo.SecretkeysVo;
import com.moyansz.scalescan.service.SecretkeysService;

import org.apache.http.util.TextUtils;
import org.codehaus.jackson.map.util.LRUMap;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

import javax.annotation.Resource;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.service.impl
 * className:	        SecretkeysServiceImpl
 * author:	            Luoxiang
 * time:	            2017/5/11	8:57
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

@Service
public class SecretkeysServiceImpl implements SecretkeysService {

    @Resource
    HolosecretkeysMapper holosecretkeysMapper;

    /**
     * 激活过的普通用户会在返回登录的返回值中确定激活
     * 不用在进行二维码扫描
     * @param secretkeysVo
     * @return
     */
    @Override
    public CommBean<SecretkeysResult> updateActive(SecretkeysVo secretkeysVo) {
        CommBean<SecretkeysResult> commBean = new CommBean();
        if (secretkeysVo.getHoloenterprise() == null){
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }
        SecretkeysResult secretkeysResult = new SecretkeysResult();
        commBean.setData(secretkeysResult);
        commBean.getData().setCategory(Holosecretkeys.CATEGORY_NORMAL);
        if (TextUtils.isEmpty(secretkeysVo.getActiveCode()) || secretkeysVo.getActiveCode().length() != 32){
            /**
             * 验证码格式判断
             */
            commBean.setCode(ConstantsErrorCode.ACTIVE_CODE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.ACTIVE_CODE_ERROR);
            return commBean;
        }

        Holoenterprise holoenterprise = secretkeysVo.getHoloenterprise();
        if (TextUtils.isEmpty(holoenterprise.getHmobilenum()) ||
                !StringUtils.isMobile(holoenterprise.getHmobilenum())){
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }

        Holosecretkeys holosecretkeys1 = holosecretkeysMapper.selectByPrimaryKey(secretkeysVo.getActiveCode());
        if (holosecretkeys1 != null && holosecretkeys1.getCategory() == Holosecretkeys.CATEGORY_ENTERPRISE){
            /**
             * 判断是否是企业用户
             * 是企业用户直接返回使用
             */
            commBean.setCode(-1);
            commBean.getData().setCategory(Holosecretkeys.CATEGORY_ENTERPRISE);
            /**
             * 最大可使用数量
             */
            commBean.getData().setMaxForEnterprises(holosecretkeys1.getMaxusers());
            return commBean;
        }else if (holosecretkeys1 != null && holosecretkeys1.getCategory() == Holosecretkeys.CATEGORY_NORMAL){
            /**
             * 不是企业用户,是普通用户
             */
            Integer fkuserid = holosecretkeys1.getFkuserid();
            if (fkuserid != null){
                if (fkuserid == secretkeysVo.getHoloenterprise().getHuserid()){
                    /**
                     * 用户关联不为空
                     * 已经被激活
                     */
                    commBean.setCode(ConstantsErrorCode.SUCCESS);
                    return commBean;
                }else {
                    commBean.setCode(ConstantsErrorCode.ACTIVE_CODE_BE_USED);
                    commBean.setMsg(ConstantsErrorMsg.ACTIVE_CODE_BE_USED);
                    return commBean;
                }
            }else {
                /**
                 * 去激活
                 * 变更数据库
                 */
                HolosecretkeysExample holosecretkeysExample = new HolosecretkeysExample();
                Holosecretkeys        holosecretkeys                = new Holosecretkeys();
                HolosecretkeysExample.Criteria holosecretkeysExampleCriteria = holosecretkeysExample.createCriteria();
                holosecretkeys.setFkuserid(secretkeysVo.getHoloenterprise().getHuserid());
                holosecretkeysExampleCriteria.andSecretkeyEqualTo(secretkeysVo.getActiveCode());

                try {
                    holosecretkeysMapper.updateByExampleSelective(holosecretkeys,
                                                                  holosecretkeysExample);
                    commBean.setCode(ConstantsErrorCode.SUCCESS);
                } catch (Exception e) {
                    e.printStackTrace();
                    commBean.setCode(ConstantsErrorCode.ACTIVE_CODE_ERROR);
                    commBean.setMsg(ConstantsErrorMsg.ACTIVE_CODE_ERROR);
                }
                return commBean;
            }

        }else {
            /**
             * 表中不存在
             * 返回错误
             */
            commBean.setCode(ConstantsErrorCode.ACTIVE_CODE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.ACTIVE_CODE_ERROR);
            return commBean;
        }
    }

    @Override
    public CommBean checkActived(String activeCode, String hmobilenum,LRUMap<String , LinkedList<String>> listHashMap) {
        /**
         * 检查是否已经过期
         * 由于企业用户有规定最大使用数量
         */
        CommBean commBean = new CommBean();
        if (TextUtils.isEmpty(activeCode)){
            /**
             * 普通用户不用带code过来
             */
            commBean.setCode(ConstantsErrorCode.SUCCESS);
        }else {
            /**
             * 企业用户需要带 code过来
             */
            LinkedList<String> linkedList = listHashMap.get(activeCode);
            if (linkedList != null && linkedList.contains(hmobilenum)){
                commBean.setCode(ConstantsErrorCode.SUCCESS);
            }else {
                commBean.setCode(ConstantsErrorCode.PASSID_ERROR);
                commBean.setMsg(ConstantsErrorMsg.PASSID_ERROR);
            }
        }

        return commBean;
    }
}
