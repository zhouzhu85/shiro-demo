package com.github.zhouzhu.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ClassName: OAuth2Token
 * @author:zhouzhu
 * @Date: 2018/8/2 19:03
 * @Version: V1.0
 */
public class OAuth2Token implements AuthenticationToken{
    private String authCode;
    private String principal;
    public OAuth2Token(String authCode){
        this.authCode=authCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return authCode;
    }
}
