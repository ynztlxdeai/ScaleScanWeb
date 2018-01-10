package com.moyansz.scalescan.controller;

import com.moyansz.common.BestEduUtil;
import com.moyansz.scalescan.po.constants.ConstantsErrorCode;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.vo.HoloenterpriseVo;
import com.moyansz.scalescan.po.vo.LoginInfo;
import com.moyansz.scalescan.service.EnterpriseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.controller
 * className:	        EnterpriseController
 * author:	            Luoxiang
 * time:	            2017/5/9	18:04
 * desc:	            Holoenterprise表相关的控制类
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/9
 * upDateDesc:	        TODO
 */

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseServiceImpl;

    /**
     * 注册
     * @param holoenterpriseVo
     * @return
     */
    @RequestMapping("regist")
    public @ResponseBody
    CommBean<LoginInfo> regist(HoloenterpriseVo holoenterpriseVo , HttpSession session){
        CommBean<LoginInfo> regist = enterpriseServiceImpl.regist(holoenterpriseVo);
        if (regist.getCode() == ConstantsErrorCode.SUCCESS){
            String value = BestEduUtil.getGuid();
            regist.getData().setUuid(value);
            session.getServletContext().setAttribute(holoenterpriseVo.getHoloenterprise().getHmobilenum(), value);
        }

        return regist;

    }

    /**
     * 改密码
     * @param holoenterpriseVo
     * @return
     */
    @RequestMapping("forgetPwd")
    public @ResponseBody
    CommBean forgetPwd(HoloenterpriseVo holoenterpriseVo, HttpSession session){
        //LoggerUtils.debug(EnterpriseController.class , "test");
        CommBean commBean = enterpriseServiceImpl.forgetPwd(holoenterpriseVo);
        if (commBean.getCode() == ConstantsErrorCode.SUCCESS){
            session.getServletContext().removeAttribute(holoenterpriseVo.getHoloenterprise()
                                                                        .getHmobilenum());
        }
        return commBean;
    }


    /**
     * 登录
     * @param holoenterpriseVo
     * @return
     */
    @RequestMapping("login")
    public @ResponseBody
    CommBean<LoginInfo> login(HoloenterpriseVo holoenterpriseVo, HttpSession session){
        CommBean<LoginInfo> commBean = enterpriseServiceImpl.login(holoenterpriseVo);
        if (commBean.getCode() == ConstantsErrorCode.SUCCESS){
            String value = BestEduUtil.getGuid();
            commBean.getData().setUuid(value);
            session.getServletContext().setAttribute(holoenterpriseVo.getHoloenterprise().getHmobilenum(), value);
        }

        return commBean;
    }

    /**
     * 检查用户是否存在
     * @param phone
     * @return
     */
    @RequestMapping("checkPhone")
    public @ResponseBody
    CommBean checkPhone(String phone , String countryArea){
        //LoggerUtils.debug(EnterpriseController.class , "test");
        return enterpriseServiceImpl.checkPhone(phone ,countryArea);
    }


    @RequestMapping(value="updateUsername")
    public @ResponseBody
    CommBean updateUsername(HoloenterpriseVo holoenterpriseVo){
        //LoggerUtils.debug(EnterpriseController.class , "test");
        return enterpriseServiceImpl.updateUsername(holoenterpriseVo);
    }

    @RequestMapping("updateDesc")
    public @ResponseBody
    CommBean updateDesc(HoloenterpriseVo holoenterpriseVo){
        //LoggerUtils.debug(EnterpriseController.class , "test");
        return enterpriseServiceImpl.updateDesc(holoenterpriseVo);
    }

    @RequestMapping("logout")
    public @ResponseBody
    CommBean logout(HoloenterpriseVo holoenterpriseVo , HttpSession session){

        CommBean logout = enterpriseServiceImpl.logout(holoenterpriseVo);
        if (logout.getCode() == ConstantsErrorCode.SUCCESS){
            session.getServletContext().removeAttribute(holoenterpriseVo.getHoloenterprise()
                                                                        .getHmobilenum());

        }
        return logout;
    }

}
