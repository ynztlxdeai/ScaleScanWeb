package com.moyansz.scalescanback.controller;

import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.vo.back.HoloadminVo;
import com.moyansz.scalescan.service.AdminService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import shaded.org.apache.http.util.TextUtils;

/**
 * projectName: 	    ScaleScanWeb
 * packageName:	        com.moyansz.scalescanback.controller
 * className:	        AdminController
 * author:	            Luoxiang
 * time:	            2017/6/19	14:42
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/6/19
 * upDateDesc:	        TODO
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final String ERROR = "error";
    @Resource
    AdminService adminServiceImpl;

    @RequestMapping("login")
    public String login(HoloadminVo holoadminVo ,  HttpServletRequest request){
        CommBean commBean = adminServiceImpl.login(holoadminVo , request.getContextPath());
        if (commBean.getCode() != 0){
            request.setAttribute("msg" , commBean.getMsg());
            return ERROR;
        }
        return "index";
    }


    @RequestMapping("index")
    public String index(){
        return "login";
    }

    @RequestMapping("secret")
    public String secret(HttpServletRequest request){
        String o = UUID.randomUUID()
                       .toString();
        request.getSession().setAttribute("current" ,
                             o);
        return "secret";
    }

    @RequestMapping("createActiveCode")
    public String createActiveCode(HttpServletRequest request , int total , int userType , String currentValue){
        if (TextUtils.isEmpty(currentValue)){
            request.setAttribute("msg" ,"<a href=\""+request.getContextPath() + "/admin/secret\">不能重复提交</a>");
            return ERROR;
        }
        String current = (String) request.getSession().getAttribute("current");
        if (!currentValue.equals(current)){
            request.setAttribute("msg" ,"<a href=\""+request.getContextPath() + "/admin/secret\">不能重复提交</a>");
            return ERROR;
        }
        request.getSession().removeAttribute("current");
        CommBean secretCode = adminServiceImpl.createSecretCode(total, userType, request.getContextPath() , request.getServletContext().getRealPath("/secretPath"));
        if (secretCode.getCode() != 0){
            request.setAttribute("msg" , secretCode.getMsg());
            return ERROR;
        }
        request.setAttribute("msg" , secretCode.getMsg());
        return "download";
     }
}
