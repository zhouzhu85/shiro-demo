package com.shiro.Realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName: MyReam_passwordSevice
 * @author:zhouzhu
 * @Date: 2018/7/12 15:52
 * @Version: V1.0
 */
public class MyReam_passwordSevice extends AuthorizingRealm{

    public PasswordService passwordService;

    public void setPasswordService(PasswordService passwordService){
        this.passwordService=passwordService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return new SimpleAuthenticationInfo("wu",passwordService.encryptPassword("123"),getName());
    }
}
