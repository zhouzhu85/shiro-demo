package com.github.zhouzhu.client;

import com.github.zhouzhu.shiro.core.ClientSaveRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ClientAuthenticationFilter
 * @author:zhouzhu
 * @Date: 2018/8/20 19:48
 * @Version: V1.0
 */
public class ClientAuthenticationFilter extends AuthenticationFilter{

    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String backUrl=servletRequest.getParameter("backUrl");
        saveRequest(servletRequest,backUrl,getDefaultBackUrl(WebUtils.toHttp(servletRequest)));
        redirectToLogin(servletRequest,servletResponse);
        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject=getSubject(request,response);
        return subject.isAuthenticated();
    }

    protected void saveRequest(ServletRequest request,String backUrl,String fallbackUrl) {
        Subject subject= SecurityUtils.getSubject();
        Session session=subject.getSession();
        HttpServletRequest httpServletRequest= WebUtils.toHttp(request);
        session.setAttribute("authc.fallbackUrl",fallbackUrl);
        SavedRequest savedRequest=new ClientSaveRequest(httpServletRequest,backUrl);
        session.setAttribute(WebUtils.SAVED_REQUEST_KEY,savedRequest);
    }

    public String getDefaultBackUrl(HttpServletRequest request){
        String scheme=request.getScheme();
        String domain=request.getServerName();
        int port=request.getServerPort();
        String contextPath=request.getContextPath();
        StringBuffer backUrl=new StringBuffer(scheme);
        backUrl.append("://");
        backUrl.append(domain);
        if ("http".equalsIgnoreCase(scheme) && port!=80){
            backUrl.append(":").append(String.valueOf(port));
        }else if ("https".equalsIgnoreCase(scheme) && port!=443){
            backUrl.append(":").append(String.valueOf(port));
        }
        backUrl.append(contextPath);
        backUrl.append(getSuccessUrl());
        return backUrl.toString();
    }
}
