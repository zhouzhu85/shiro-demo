package com.github.zhouzhu.shiro.jcaptcha;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName: MyFormAuthenticationFilter
 * @author:zhouzhu
 * @Date: 2018/8/14 19:37
 * @Version: V1.0
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter{
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (request.getAttribute(getFailureKeyAttribute())!=null){
            return true;
        }
        return super.onAccessDenied(request, response, mappedValue);
    }
}
