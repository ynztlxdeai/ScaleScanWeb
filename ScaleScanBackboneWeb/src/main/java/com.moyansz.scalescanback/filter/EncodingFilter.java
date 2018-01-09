package com.moyansz.scalescanback.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.filter
 * className:	        EncodingFilter
 * author:	            Luoxiang
 * time:	            2017/5/15	9:52
 * desc:	            字符集转换
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/15
 * upDateDesc:	        TODO
 */

public class EncodingFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest  req  = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
