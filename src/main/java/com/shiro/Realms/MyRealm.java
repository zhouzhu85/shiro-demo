package com.shiro.Realms;

import com.shiro.permission.BitPermission;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName: MyRealm
 * @author:zhouzhu
 * @Date: 2018/7/10 16:21
 * @Version: V1.0
 */
public class MyRealm extends AuthorizingRealm{

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("role1");
        authorizationInfo.addRole("role2");
        authorizationInfo.addObjectPermission(new BitPermission("+user1+10"));
        authorizationInfo.addObjectPermission(new WildcardPermission("user1:*"));
        authorizationInfo.addStringPermission("+user2+10");
        authorizationInfo.addStringPermission("user2:*");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
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
