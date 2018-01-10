package com.moyansz.scalescan.controller;

import com.moyansz.scalescan.po.result.CommBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.controller
 * className:	        TestController
 * author:	            Luoxiang
 * time:	            2017/6/13	11:22
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/6/13
 * upDateDesc:	        TODO
 */

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("login")
    public @ResponseBody
    CommBean login(HttpServletResponse response , HttpSession session , HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            System.out.println(cookies.toString());
        }


        CommBean commBean = new CommBean();
        commBean.setCode(0);

        String attribute = (String) session.getAttribute("15012331292");
        System.out.println(attribute);

        String attribute1 = (String) session.getServletContext()
                                            .getAttribute("ServletContext15012331292");
        System.out.println(attribute1);

        Cookie cookie = new Cookie("testCookie", "testCookieValue");
        cookie.setPath(request.getRequestURI());
        cookie.setMaxAge(60 * 60 * 24);

        String value = new Date().toString();
        System.out.println(value);
        session.setAttribute("15012331292" , value);
        session.getServletContext().setAttribute("ServletContext15012331292" , value);
        response.addCookie(cookie);
        return commBean;
    }

    @RequestMapping("test")
    public @ResponseBody
    CommBean test(HttpSession session , String phone){
        /**
         * 手机端访问  httpsession无效
         */
        CommBean commBean = new CommBean();
        String   attribute = (String) session.getAttribute("phone");
        commBean.setCode(0);
        commBean.setMsg(attribute);

        session.setAttribute("phone" , phone);
        System.out.println((String) session.getAttribute("phone"));
        return commBean;
    }
}
