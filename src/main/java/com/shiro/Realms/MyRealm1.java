package com.shiro.Realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm{

    @Override
    public String getName() {
        return "myRealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username =(String) authenticationToken.getPrincipal(); //得到用户名
        String userpassword =new String((char[])authenticationToken.getCredentials()); //得到用户密码
        if(!"zhang".equals(username)){
            throw new UnknownAccountException();//如果用户名错误
        }
        if(!"123".equals(userpassword)){
            throw new IncorrectCredentialsException(); //如果密码错误
        }

        return new SimpleAuthenticationInfo(username,userpassword,getName());
    }
}
