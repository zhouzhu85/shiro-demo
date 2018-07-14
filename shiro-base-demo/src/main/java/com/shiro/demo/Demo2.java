package com.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 授权
 */
public class Demo2 extends PublicDemo{

    @Test
    public void testHasRole(){
        login("classpath:shiro-role.ini","zhang","123");
        //判断拥有角色：role1
        Assert.assertTrue(subject().hasRole("role1"));
        //判断拥有角色：role1 and role2
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));
        //判断拥有角色：role1 and role2 !role3
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true,result[0]);
        Assert.assertEquals(true,result[1]);
        Assert.assertEquals(false,result[2]);
    }

    @Test(expected = UnauthenticatedException.class)
    public void testCheckRole(){
        login("classpath:shiro-role.ini","zhang","123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3
        subject().checkRoles("role1","role3");
    }

    @Test
    public void testIsPermitted1(){
        login("classpath:shiro-permission.ini","zhang","123");
        //断言拥有权限：user:create
        Assert.assertTrue(subject().isPermitted("user:create"));
        //断言拥有权限：user:create and user:update
        Assert.assertTrue(subject().isPermittedAll("user:update","user:delete"));
        //判断没有权限：user:view
        Assert.assertFalse(subject().isPermitted("user:view"));
    }

    @Test(expected = UnauthenticatedException.class)
    public void testCheckPermission(){
        login("classpath:shiro-permission.ini","zhang","123");
        //断言拥有权限：user:create
        subject().checkPermission("user:create");
        //断言拥有权限：user:update and user:delete
        subject().checkPermissions("user:update","user:delete");
        //断言拥有权限：user:view 失败抛出异常
        subject().checkPermissions("user:view");
    }

    @Test
    public void testIsPermitted2(){
        login("classpath:shiro-authorizer.ini", "zhang", "123");
        //判断拥有权限：user:create
        Assert.assertTrue(subject().isPermitted("user1:update"));
        Assert.assertTrue(subject().isPermitted("user2:update"));
        //通过二进制位的方式表示权限
        Assert.assertTrue(subject().isPermitted("+user1+2"));//新增权限
        Assert.assertTrue(subject().isPermitted("+user1+8"));//查看权限
        Assert.assertTrue(subject().isPermitted("+user2+10"));//新增及查看

        Assert.assertFalse(subject().isPermitted("+user1+4"));//没有删除权限

        Assert.assertTrue(subject().isPermitted("menu:view"));//通过MyRolePermissionResolver解析得到的权限
    }

}
