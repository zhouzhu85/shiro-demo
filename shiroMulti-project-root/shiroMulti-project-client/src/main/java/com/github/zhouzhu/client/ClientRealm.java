package com.github.zhouzhu.client;

import com.github.zhouzhu.shiro.remote.PermissionContext;
import com.github.zhouzhu.shiro.remote.RemoteServiceInterface;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName: ClientRealm
 * @author:zhouzhu
 * @Date: 2018/8/20 20:06
 * @Version: V1.0
 */
public class ClientRealm extends AuthorizingRealm{
    private RemoteServiceInterface remoteService;
    private String appKey;

    public void setRemoteService(RemoteServiceInterface remoteService) {
        this.remoteService = remoteService;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username=(String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        PermissionContext context=remoteService.getPermissions(appKey,username);
        authorizationInfo.setRoles(context.getRoles());
        authorizationInfo.setStringPermissions(context.getPermissions());
        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //永远不会被调用
        throw new UnsupportedOperationException("永远不会被调用");
    }
}
