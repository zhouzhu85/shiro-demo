package com.shiro.demo;

import com.shiro.Realms.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.junit.Test;

/**
 * @ClassName: Shiro_CacheTest
 * @author:zhouzhu
 * @Date: 2018/7/25 10:23
 * @Version: V1.0
 */
public class Shiro_CacheTest extends PublicTest{
    @Test
    public void testClearCachedAuthenticationInfo(){
        login(u1.getUsername(),passwrod);
        userService.changePassword(u1.getId(),passwrod+"1");
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
        userRealm.clearCachedAuthenticationInfo(subject().getPrincipals());
        login(u1.getUsername(),passwrod+"1");
    }

    @Test
    public void testClearCachedAuthorizationInfo(){
        login(u1.getUsername(),passwrod);
        subject().checkRole(r1.getRole());
        userService.correlationRoles(u1.getId(),r2.getId());
        RealmSecurityManager realmSecurityManager=(RealmSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm userRealm= (UserRealm) realmSecurityManager.getRealms().iterator().next();
        userRealm.clearCachedAuthorizationInfo(subject().getPrincipals());
        subject().checkRole(r2.getRole());
    }
}
