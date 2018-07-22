package com.shiroweb.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AnyRolesFilter extends AccessControlFilter{
    private String unauthorizedUrl="/unauthorized.jsp";
    private String loginUrl="/login.jsp";

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) {
        String[] roles=(String[]) mappedValue;
        if(roles==null){
            return true; //如果没有设置角色参数，默认成功
        }
        for (String role:roles){
            if(getSubject(servletRequest,servletResponse).hasRole(role)){
                return true;
            }
        }
        return false; //跳到onAccessDenied处理
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {

        Subject subject = getSubject(servletRequest, servletResponse);

        if(subject.getPrincipal()==null){ //表示没有登录，重定向到登录页面
            saveRequest(servletRequest);
            WebUtils.issueRedirect(servletRequest,servletResponse,loginUrl);
        }else {
            if(StringUtils.hasText(unauthorizedUrl)){ //如果有未授权页面跳到过去
                WebUtils.issueRedirect(servletRequest,servletResponse,unauthorizedUrl);
            }else { //否则返回401未授权状态码
                WebUtils.toHttp(servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }

        return false;
    }
}
