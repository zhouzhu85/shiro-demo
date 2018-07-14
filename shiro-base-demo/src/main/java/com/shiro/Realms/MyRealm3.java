package com.shiro.Realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @ClassName: MyRealm3
 * @author:zhouzhu
 * @Date: 2018/7/9 15:28
 * @Version: V1.0
 */
public class MyRealm3 implements Realm{

    @Override
    public String getName() {
        return "myRealm3";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username =(String) authenticationToken.getPrincipal();
        String password=new String((char[])authenticationToken.getCredentials());
        if(!"zhang".equals(username)){
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username+"@163.com",password,getName());
    }
}
