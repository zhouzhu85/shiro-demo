package com.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class shiroTest {

    @Test
    public void testHelloworld(){
        //获取SecurityMananger工厂，
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager  securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("wang","123");
        try {
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }

    //base64编码/解码
    @Test
    public void testBase64(){
        String str="hello";
        String base64Encoded= Base64.encodeToString(str.getBytes());
        System.out.println(base64Encoded);
        String str2=Base64.decodeToString(base64Encoded);
        System.out.println(str2);
        Assert.assertEquals(str,str2);
    }
    //十六进制字符串进行编码/解码
    @Test
    public void testHex(){
        String str="hello1";
        String base64Encoded= Hex.encodeToString(str.getBytes());
        String str2=new String(Hex.decode(base64Encoded.getBytes()));
        System.out.println(str+" : "+str2);
        Assert.assertEquals(str,str2);
    }
    //md5散列算法
    @Test
    public void testMD5(){
        String str="hello";
        String salt="123";
        String md5=new Md5Hash(str,salt,2).toString();
        System.out.println(md5);
    }

    //SHA256算法
    @Test
    public void testSHA256(){
        String str="hello";
        String salt="123";
        //内部使用MessageDigest
        String simpleHash = new SimpleHash("SHA-1", str, salt).toString();
        System.out.println(simpleHash);
    }
    
}
