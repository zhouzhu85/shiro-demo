package com.github.zhouzhu.web.bind.annotaion;

import com.github.zhouzhu.Constants;

import java.lang.annotation.*;

/**
 * 绑定当前登录的用户
 * 不同于@ModelAttribute
 * @ClassName: CurrentUser
 * @author:zhouzhu
 * @Date: 2018/7/31 10:46
 * @Version: V1.0
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
    /**
     * 当前用户在request中的名字
     * @return
     */
    String value() default Constants.CURRENT_USER;
}
