package com.moyansz.scalescan.service.impl;

import com.moyansz.common.DateUtil;
import com.moyansz.common.StringUtils;
import com.moyansz.scalescan.mapper.HoloenterpriseMapper;
import com.moyansz.scalescan.po.Holoenterprise;
import com.moyansz.scalescan.po.HoloenterpriseExample;
import com.moyansz.scalescan.po.constants.ConstantsErrorCode;
import com.moyansz.scalescan.po.constants.ConstantsErrorMsg;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.vo.HoloenterpriseVo;
import com.moyansz.scalescan.po.vo.LoginInfo;
import com.moyansz.scalescan.service.EnterpriseService;

import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.service.impl
 * className:	        EnterpriseServiceImpl
 * author:	            Luoxiang
 * time:	            2017/5/9	17:45
 * desc:	            用户表操作层
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/9
 * upDateDesc:	        TODO
 */

@Service
public class EnterpriseServiceImpl
        implements EnterpriseService
{

    @Resource
    private HoloenterpriseMapper holoenterpriseMapper;

    @Transactional
    @Override
    public CommBean<LoginInfo> regist(HoloenterpriseVo holoenterpriseVo) {
        CommBean<LoginInfo> commBean = new CommBean();
        Holoenterprise holoenterprise = holoenterpriseVo.getHoloenterprise();
        if (holoenterprise == null){
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }

        if (performParaters(holoenterprise, commBean)) { return commBean; }

        /**
         * 防止重复注册
         */
        HoloenterpriseExample startOption = new HoloenterpriseExample();
        HoloenterpriseExample.Criteria startOptionCriteria = startOption.createCriteria();
        startOptionCriteria.andHmobilenumEqualTo(holoenterprise.getHmobilenum());
        if (!TextUtils.isEmpty(holoenterprise.getHcountryarea())){
            startOptionCriteria.andHcountryareaEqualTo(holoenterprise.getHcountryarea());
        }
        List<Holoenterprise> holoenterprises1 = holoenterpriseMapper.selectByExample(startOption);
        if (holoenterprises1 != null && holoenterprises1.size() > 0){
            commBean.setCode(ConstantsErrorCode.USER_EXISTS);
            commBean.setMsg(ConstantsErrorMsg.USER_EXISTS);
            return commBean;
        }

        try {
            //注册时间
            holoenterprise.setHregisttime(new Date());
            holoenterpriseMapper.insertSelective(holoenterprise);

            HoloenterpriseExample example = new HoloenterpriseExample();
            HoloenterpriseExample.Criteria criteria = example.createCriteria();
            criteria.andHmobilenumEqualTo(holoenterprise.getHmobilenum());
            criteria.andHusernameEqualTo(holoenterprise.getHusername());
            criteria.andHuserpasswordEqualTo(holoenterprise.getHuserpassword());
            if (!TextUtils.isEmpty(holoenterprise.getHcountryarea())){
                startOptionCriteria.andHcountryareaEqualTo(holoenterprise.getHcountryarea());
            }
            List<Holoenterprise> holoenterprises = holoenterpriseMapper.selectByExample(example);
            if (holoenterprises != null && holoenterprises.size() > 0){
                commBean.setCode(ConstantsErrorCode.SUCCESS);
                LoginInfo data = new LoginInfo().setHoloenterprise(holoenterprises.get(0));
                data.getHoloenterprise().setHuserpassword("");
                /**
                 * 新注册用户开启试用
                 */
                data.setActive(true);
                commBean.setData(data);
            }else {
                commBean.setCode(ConstantsErrorCode.REGIST_ERROR);
                commBean.setMsg(ConstantsErrorMsg.REGIST_ERROR);
            }

        } catch (Exception e) {
            commBean.setCode(ConstantsErrorCode.REGIST_ERROR);
            commBean.setMsg(ConstantsErrorMsg.REGIST_ERROR);
            e.printStackTrace();
        }

        return commBean;
    }

    private boolean performParaters(Holoenterprise holoenterprise, CommBean commBean) {
        if (TextUtils.isEmpty(holoenterprise.getHmobilenum()) || !StringUtils.isMobile(holoenterprise.getHmobilenum())) {
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return true;
        }

        if (TextUtils.isEmpty(holoenterprise.getHuserpassword()) || holoenterprise.getHuserpassword()
                                                                                  .length() < 6 || holoenterprise.getHuserpassword()
                                                                                                                 .length() > 16)
        {
            commBean.setCode(ConstantsErrorCode.PWD_FORMAT_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PWD_FORMAT_ERROR);
            return true;
        }
        return false;
    }

    @Override
    public CommBean forgetPwd(HoloenterpriseVo holoenterpriseVo) {
        CommBean commBean = new CommBean();
        Holoenterprise    holoenterprise = holoenterpriseVo.getHoloenterprise();
        if (holoenterprise == null){
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }
        if (performParaters(holoenterprise, commBean)) { return commBean; }

        HoloenterpriseExample example = new HoloenterpriseExample();
        HoloenterpriseExample.Criteria criteria = example.createCriteria();
        criteria.andHmobilenumEqualTo(holoenterprise.getHmobilenum());
        if (!TextUtils.isEmpty(holoenterprise.getHcountryarea())){
            criteria.andHcountryareaEqualTo(holoenterprise.getHcountryarea());
        }
        try {
            List<Holoenterprise> holoenterprises = holoenterpriseMapper.selectByExample(example);
            if (holoenterprises.size() == 0){
                commBean.setCode(ConstantsErrorCode.PHONE_UNREGIST);
                commBean.setMsg(ConstantsErrorMsg.PHONE_UNREGIST);
            }else if (holoenterprises.get(0).getHuserpassword().equals(holoenterprise.getHuserpassword())){
                commBean.setCode(ConstantsErrorCode.OLD_NEW_PWD_SAME);
                commBean.setMsg(ConstantsErrorMsg.OLD_NEW_PWD_SAME);
            }else {
                holoenterpriseMapper.updateByExampleSelective(holoenterprise , example);
                commBean.setCode(ConstantsErrorCode.SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            commBean.setCode(ConstantsErrorCode.MODIFY_PWD_ERROR);
            commBean.setMsg(ConstantsErrorMsg.MODIFY_PWD_ERROR);
        }

        return commBean;
    }

    @Override
    public CommBean<LoginInfo> login(HoloenterpriseVo holoenterpriseVo) {
        CommBean<LoginInfo> commBean = new CommBean();
        Holoenterprise    holoenterprise = holoenterpriseVo.getHoloenterprise();
        if (holoenterprise == null){
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }
        //参数校验 手机号码和密码
        if (performParaters(holoenterprise, commBean)) { return commBean; }

        List<LoginInfo>  loginInfos= null;
        try {
            loginInfos = holoenterpriseMapper.login(holoenterprise);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (loginInfos != null && loginInfos.size() > 0){
            /**
             * 在这里返回说明已经激活了
             */
            commBean.setCode(ConstantsErrorCode.SUCCESS);
            LoginInfo data = loginInfos.get(0);
            data.getHoloenterprise().setHuserpassword("");
            data.setRealyActive(true);
            data.setActive(true);
            commBean.setData(data);
            return commBean;
        }

        /**
         * ---------------------------------------------------------------------------------
         * 走到这里 说明该用户并没有激活过产品
         */
        HoloenterpriseExample example = new HoloenterpriseExample();
        HoloenterpriseExample.Criteria criteria = example.createCriteria();
        criteria.andHmobilenumEqualTo(holoenterprise.getHmobilenum());
        criteria.andHuserpasswordEqualTo(holoenterprise.getHuserpassword());
        if (!TextUtils.isEmpty(holoenterprise.getHcountryarea())){
            criteria.andHcountryareaEqualTo(holoenterprise.getHcountryarea());
        }
        List<Holoenterprise> holoenterprises = holoenterpriseMapper.selectByExample(example);
        if (holoenterprises != null && holoenterprises.size() > 0){
            commBean.setCode(ConstantsErrorCode.SUCCESS);
            Holoenterprise resultEnterprise = holoenterprises.get(0);
            resultEnterprise.setHuserpassword("");
            commBean.setData(new LoginInfo().setHoloenterprise(resultEnterprise));
            commBean.getData().setActive(false);
            Date hregisttime = resultEnterprise.getHregisttime();
            Date date = new Date();
                /**
                 * 新用户免费试用7天
                 */
            try {
                int daysBetween = DateUtil.daysBetween(hregisttime, date);
                if (daysBetween < 7){
                    commBean.getData().setActive(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*HolosecretkeysExample holosecretkeysExample = new HolosecretkeysExample();
            HolosecretkeysExample.Criteria holosecretkeysExampleCriteria    = holosecretkeysExample.createCriteria();
            holosecretkeysExampleCriteria.andFkuseridEqualTo(resultEnterprise.getHuserid());
            List<Holosecretkeys> holosecretkeys = holosecretkeysMapper.selectByExample(
                    holosecretkeysExample);
            if (holosecretkeys != null && holosecretkeys.size() > 0){
                commBean.getData().setActive(true);
            }else {
                commBean.getData().setActive(false);
                Date hregisttime = resultEnterprise.getHregisttime();
                Date date = new Date();
                *//**
                 * 新用户免费试用7天
                 *//*
                try {
                    int daysBetween = DateUtil.daysBetween(hregisttime, date);
                    if (daysBetween < 7){
                        commBean.getData().setActive(true);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }*/
        }else {
            commBean.setCode(ConstantsErrorCode.PHONE_OR_PWD_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_OR_PWD_ERROR);
        }
        return commBean;
    }

    @Override
    public CommBean checkPhone(String phone, String countryArea) {
        CommBean commBean = new CommBean();
        if (TextUtils.isEmpty(phone) || !StringUtils.isMobile(phone)) {
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }


        HoloenterpriseExample example = new HoloenterpriseExample();
        HoloenterpriseExample.Criteria criteria = example.createCriteria();
        if (!TextUtils.isEmpty(countryArea)){
            criteria.andHcountryareaEqualTo(countryArea);
        }
        criteria.andHmobilenumEqualTo(phone);

        List<Holoenterprise> holoenterprises = holoenterpriseMapper.selectByExample(example);
        if (holoenterprises != null && holoenterprises.size() > 0){
            commBean.setCode(ConstantsErrorCode.SUCCESS);
        }else {
            commBean.setCode(ConstantsErrorCode.PHONE_UNREGIST);
            commBean.setMsg(ConstantsErrorMsg.PHONE_UNREGIST);
        }
        return commBean;
    }

    @Transactional
    @Override
    public CommBean updateUsername(HoloenterpriseVo holoenterpriseVo) {
        CommBean commBean = new CommBean();
        Holoenterprise    holoenterprise = holoenterpriseVo.getHoloenterprise();
        if (holoenterprise == null){
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }

        if (TextUtils.isEmpty(holoenterprise.getHusername()) || holoenterprise.getHusername().length() > 16){
            commBean.setCode(ConstantsErrorCode.USERNAME_FORMAT_ERROR);
            commBean.setMsg(ConstantsErrorMsg.USERNAME_FORMAT_ERROR);
            return commBean;
        }


        HoloenterpriseExample example = new HoloenterpriseExample();
        HoloenterpriseExample.Criteria criteria = example.createCriteria();
        criteria.andHmobilenumEqualTo(holoenterprise.getHmobilenum());

        try {
            holoenterpriseMapper.updateByExampleSelective(holoenterprise, example);
            commBean.setCode(ConstantsErrorCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            commBean.setCode(ConstantsErrorCode.UPDATE_USERNAME_ERROR);
            commBean.setMsg(ConstantsErrorMsg.UPDATE_USERNAME_ERROR);
        }

        return commBean;
    }

    @Transactional
    @Override
    public CommBean updateDesc(HoloenterpriseVo holoenterpriseVo) {
        CommBean commBean = new CommBean();
        Holoenterprise    holoenterprise = holoenterpriseVo.getHoloenterprise();
        if (holoenterprise == null){
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }

        if (TextUtils.isEmpty(holoenterprise.getHentdesc()) || holoenterprise.getHentdesc().length() > 255){
            commBean.setCode(ConstantsErrorCode.DESC_FORMAT_ERROR);
            commBean.setMsg(ConstantsErrorMsg.DESC_FORMAT_ERROR);
            return commBean;
        }

        HoloenterpriseExample example = new HoloenterpriseExample();
        HoloenterpriseExample.Criteria criteria = example.createCriteria();
        criteria.andHmobilenumEqualTo(holoenterprise.getHmobilenum());

        try {
            holoenterpriseMapper.updateByExampleSelective(holoenterprise, example);
            commBean.setCode(ConstantsErrorCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            commBean.setCode(ConstantsErrorCode.UPDATE_DESC_ERROR);
            commBean.setMsg(ConstantsErrorMsg.UPDATE_DESC_ERROR);
        }

        return commBean;
    }

    @Override
    public void updatePic(Holoenterprise holoenterprise) {
        HoloenterpriseExample example = new HoloenterpriseExample();
        HoloenterpriseExample.Criteria criteria = example.createCriteria();
        criteria.andHuseridEqualTo(holoenterprise.getHuserid());

        holoenterpriseMapper.updateByExampleSelective(holoenterprise, example);
    }

    @Override
    public CommBean logout(HoloenterpriseVo holoenterpriseVo) {
        CommBean commBean = new CommBean();
        if (holoenterpriseVo.getHoloenterprise() == null){
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }
        /**
         * 通过帐号和密码退出
         * 校验参数
         */
        if (TextUtils.isEmpty(holoenterpriseVo.getHoloenterprise().getHmobilenum()) || !StringUtils.isMobile(holoenterpriseVo.getHoloenterprise().getHmobilenum())) {
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
            return commBean;
        }

        //校验成功
        commBean.setCode(ConstantsErrorCode.SUCCESS);
        return commBean;
    }
}
