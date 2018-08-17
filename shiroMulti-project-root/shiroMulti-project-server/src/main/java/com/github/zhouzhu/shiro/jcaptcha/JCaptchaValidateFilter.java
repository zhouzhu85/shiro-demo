package com.github.zhouzhu.shiro.jcaptcha;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: JCaptchaValidateFilter
 * @author:zhouzhu
 * @Date: 2018/8/14 18:08
 * @Version: V1.0
 */
public class JCaptchaValidateFilter extends AccessControlFilter{

    private boolean jcaptchaEbabled=true; //是否开启验证码支持
    private String jcaptchaParam="jcaptchaCode"; //前台提交的验证码参数名
    private String failureKeyAttribute="shiroLoginFailure"; //验证码验证失败后储存到的属性名

    public void setJcaptchaEbabled(boolean jcaptchaEbabled) {
        this.jcaptchaEbabled = jcaptchaEbabled;
    }

    public void setJcaptchaParam(String jcaptchaParam) {
        this.jcaptchaParam = jcaptchaParam;
    }

    public void setFailureKeyAttribute(String failureKeyAttribute) {
        this.failureKeyAttribute = failureKeyAttribute;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        //1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
        servletRequest.setAttribute("jcaptchaEbabled",jcaptchaEbabled);
        HttpServletRequest httpServletRequest= WebUtils.toHttp(servletRequest);
        //2.判断验证码是否禁用 或不是表单提交（允许访问）
        if(jcaptchaEbabled==false || !"post".equalsIgnoreCase(httpServletRequest.getMethod())){
            return true;
        }
        //3、此时是表单提交，验证验证码是否正确
        return JCaptcha.validateResponse(httpServletRequest,httpServletRequest.getParameter(jcaptchaParam));
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        //如果验证码失败了，储存失败key属性
        servletRequest.setAttribute(failureKeyAttribute,"JCaptcha.error");
        return true;
    }
}
