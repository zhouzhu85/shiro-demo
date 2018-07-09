package com.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
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
public class Demo2 {

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

    public void login(String configFile,String name,String password){
        //1.获取securityManager工厂，此处使用ini配置文件初始化SecurityMangaer
        Factory<SecurityManager> factory=new IniSecurityManagerFactory(configFile);
        //2.得到SecurityManager实例，并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject及创建用户名/密码身份验证token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        subject.login(token);
    }

    public Subject subject(){
        return SecurityUtils.getSubject();
    }
}
