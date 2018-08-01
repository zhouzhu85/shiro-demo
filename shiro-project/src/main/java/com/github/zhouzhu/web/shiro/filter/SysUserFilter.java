package com.github.zhouzhu.web.shiro.filter;

import com.github.zhouzhu.Constants;
import com.github.zhouzhu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName: SysUserFilter
 * @author:zhouzhu
 * @Date: 2018/8/1 11:48
 * @Version: V1.0
 */
public class SysUserFilter extends PathMatchingFilter{
    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER,userService.findByUsername(username));
        return true;
    }
}
