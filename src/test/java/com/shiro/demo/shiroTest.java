package com.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.SimpleByteSource;
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

    @Test
    public void testHashService(){
        DefaultHashService hashService=new DefaultHashService();
        //默认算法SHA-512
        hashService.setHashAlgorithmName("SHA-512");
        //私盐，默认无
        hashService.setPrivateSalt(new SimpleByteSource("123"));
        //是否生成公盐，默认false
        hashService.setGeneratePublicSalt(true);
        //用于生成公盐，默认就这个
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        //生成hash值得迭代次数
        hashService.setHashIterations(1);
        HashRequest request=new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex=hashService.computeHash(request).toHex();
        System.out.println(hex);
    }

    @Test
    public void testSecureRandomNumberGenerator(){
        SecureRandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();
        randomNumberGenerator.setSeed("123".getBytes());
        String hex = randomNumberGenerator.nextBytes().toHex();
        System.out.println(hex);
    }


}
