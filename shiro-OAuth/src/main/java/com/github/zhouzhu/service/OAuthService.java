package com.github.zhouzhu.service;

/**
 * @ClassName: OAuthService
 * @author:zhouzhu
 * @Date: 2018/8/2 14:43
 * @Version: V1.0
 */
public interface OAuthService {
    //添加auth code
    public void addAuthCode(String authCode,String username);
    //添加access token
    public void addAccessToken(String accessToken,String username);
    //验证auth code是否有效
    boolean checkAuthCode(String authCode);
    //验证access token是否有效
    boolean checkAccessToken(String accessToken);

    String getUsernameByAuthCode(String authCode);
    String getUsernameByAccessToken(String accessToken);


    //auth code / access token 过期时间
    long getExpireIn();


    public boolean checkClientId(String clientId);

    public boolean checkClientSecret(String clientSecret);
}
