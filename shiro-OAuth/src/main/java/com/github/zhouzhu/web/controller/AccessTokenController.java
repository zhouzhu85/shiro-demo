package com.github.zhouzhu.web.controller;

import com.github.zhouzhu.Constants;
import com.github.zhouzhu.service.OAuthService;
import com.github.zhouzhu.service.UserService;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URISyntaxException;

/**
 * @ClassName: AccessTokenController
 * @author:zhouzhu
 * @Date: 2018/8/2 15:07
 * @Version: V1.0
 */
@RestController
public class AccessTokenController {
    @Autowired
    private OAuthService oAuthService;
    @Autowired
    private UserService userService;

    @RequestMapping("/accessToken")
    public HttpEntity token(HttpServletRequest request)  throws URISyntaxException, OAuthSystemException{
        try {
            //构建OAuth请求
            OAuthTokenRequest oAuthTokenRequest=new OAuthTokenRequest(request);
            //检查提交的客户端id是否正确
            if(!oAuthService.checkClientId(oAuthTokenRequest.getClientId())){
                OAuthResponse response=OAuthResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                        .setError(OAuthError.TokenResponse.INVALID_CLIENT)
                        .setErrorDescription(Constants.INVALID_CLIENT_DESCRIPTION)
                        .buildJSONMessage();
                return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
            }
            //检查客户端安全key是否正确
            if(!oAuthService.checkClientSecret(oAuthTokenRequest.getClientSecret())){
                OAuthResponse response= OAuthASResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                        .setError(OAuthError.TokenResponse.UNAUTHORIZED_CLIENT)
                        .setErrorDescription(Constants.INVALID_CLIENT_DESCRIPTION)
                        .buildJSONMessage();
                return new ResponseEntity(response.getBody(),HttpStatus.valueOf(response.getResponseStatus()));
            }
            String authCode=oAuthTokenRequest.getParam(OAuth.OAUTH_CODE);
            //检查验证类型，此处只检查AUTHORIZATION_CODE类型，其他的还有PASSWORD或REFRESH_TOKEN
            if(oAuthTokenRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(GrantType.AUTHORIZATION_CODE.toString())){
                if(!oAuthService.checkAuthCode(authCode)){
                    OAuthResponse response=OAuthResponse
                            .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                            .setError(OAuthError.TokenResponse.INVALID_GRANT)
                            .setErrorDescription("错误的授权码")
                            .buildJSONMessage();
                    return new ResponseEntity(response.getBody(),HttpStatus.valueOf(response.getResponseStatus()));
                }
            }
            //生成Access token
            OAuthIssuer oauthIssuerImpl=new OAuthIssuerImpl(new MD5Generator());
            final String accessToken=oauthIssuerImpl.accessToken();
            oAuthService.addAccessToken(accessToken,oAuthService.getUsernameByAuthCode(authCode));

            //生成OAuth响应
            OAuthResponse response=OAuthASResponse
                    .tokenResponse(HttpServletResponse.SC_OK)
                    .setAccessToken(accessToken)
                    .setExpiresIn(String.valueOf(oAuthService.getExpireIn()))
                    .buildJSONMessage();
            return new ResponseEntity(response.getBody(),HttpStatus.valueOf(response.getResponseStatus()));
        } catch (OAuthProblemException e) {
           //构建错误响应
            OAuthResponse response=OAuthResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST).error(e)
                    .buildJSONMessage();
            return new ResponseEntity(response.getBody(),HttpStatus.valueOf(response.getResponseStatus()));
        }
    }
}
