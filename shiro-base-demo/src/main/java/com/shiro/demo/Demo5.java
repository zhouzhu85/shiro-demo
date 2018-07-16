package com.shiro.demo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Realm用法
 */

public class Demo5 extends PublicDemo{
    @Test
    public void testLoginSuccess(){
        login("classpath:shiro-realm-service.ini",u2.getUsername(),passwrod);
        Assert.assertTrue(subject().isAuthenticated());
    }
}
