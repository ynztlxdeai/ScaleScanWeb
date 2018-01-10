package com.moyansz.scalescan.filter;

import com.moyansz.common.JSONUtils;
import com.moyansz.common.StringUtils;
import com.moyansz.scalescan.po.constants.ConstantsErrorCode;
import com.moyansz.scalescan.po.constants.ConstantsErrorMsg;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.vo.LoginInfo;

import org.apache.http.util.TextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.filter
 * className:	        PermissionInterceptor
 * author:	            Luoxiang
 * time:	            2017/5/10	11:34
 * desc:	            权限拦截器
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/10
 * upDateDesc:	        TODO
 */

public class PermissionInterceptor
        implements HandlerInterceptor
{

    @Override
    /**
     * 处理映射器之前执行
     */ public boolean preHandle(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object handler)
            throws Exception
    {

        boolean result     = false;
        String  requestURI = request.getRequestURI();
        switch (requestURI) {
            case "/enterprise/regist":
            case "/enterprise/forgetPwd":
            case "/enterprise/login":
            case "/enterprise/checkPhone":
                result = true;
                break;
            default:

                /**
                 * session实现 手机客户端无法获取正常的session 换cookies方案
                 */
                CommBean commBean = new CommBean();
                String hmobilenum = request.getParameter("hmobilenum");
                if (TextUtils.isEmpty(hmobilenum) || !StringUtils.isMobile(hmobilenum)) {
                    result = false;
                    commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
                    commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
                }
                String   uuid     = request.getParameter("uuid");
                String attrUuid = (String) request.getServletContext()
                                                   .getAttribute(hmobilenum);
                if(!TextUtils.isEmpty(uuid) && !TextUtils.isEmpty(attrUuid) && uuid.equals(attrUuid)){
                    result = true;
                }else {
                    result = false;
                }

                if (result == false) {
                    commBean.setCode(ConstantsErrorCode.LOGIN_TIME_OUT);
                    commBean.setMsg(ConstantsErrorMsg.LOGIN_TIME_OUT);

                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter()
                            .write(JSONUtils.toJSONObject(commBean)
                                            .toString());
                }
                break;
        }

        return result;
    }


    private boolean performSession(HttpServletRequest request,
                                   HttpServletResponse response,
                                   String hmobilenum)
            throws IOException
    {
        boolean  result;
        String   uuid     = request.getParameter("uuid");
        CommBean commBean = new CommBean();
        if (TextUtils.isEmpty(hmobilenum) || !StringUtils.isMobile(hmobilenum)) {
            result = false;
            commBean.setCode(ConstantsErrorCode.PHONE_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PHONE_ERROR);
        } else {
            HttpSession session = request.getSession();
            LoginInfo loginInfo = (LoginInfo) request.getSession()
                                                     .getAttribute(hmobilenum);
            if (loginInfo != null && loginInfo.getUuid() != null && loginInfo.getUuid()
                                                                             .equals(uuid))
            {
                result = true;
            } else {
                result = false;
                commBean.setCode(ConstantsErrorCode.LOGIN_TIME_OUT);
                commBean.setMsg(ConstantsErrorMsg.LOGIN_TIME_OUT);
            }
        }

        if (result == false) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter()
                    .write(JSONUtils.toJSONObject(commBean)
                                    .toString());
        }
        return result;
    }

    /**
     * 还没有调用controller,没有返回modleandview之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView)
            throws Exception
    {

    }

    /**
     * 返回modleandview之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex)
            throws Exception
    {

    }

}
