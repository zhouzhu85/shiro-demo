package com.github.zhouzhu.oauth2;


import org.apache.shiro.authc.AuthenticationException;

/**
 * @ClassName: OAuth2AuthenticationException
 * @author:zhouzhu
 * @Date: 2018/8/2 19:33
 * @Version: V1.0
 */
public class OAuth2AuthenticationException extends AuthenticationException {

    public OAuth2AuthenticationException(Throwable cause){
        super(cause);
    }
}
