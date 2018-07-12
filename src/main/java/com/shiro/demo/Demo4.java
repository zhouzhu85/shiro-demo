package com.shiro.demo;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;

/**
 *  加密/解密
 * @ClassName: Demo4
 * @author:zhouzhu
 * @Date: 2018/7/12 15:06
 * @Version: V1.0
 */
public class Demo4 extends PublicDemo{

    //AES算法
    @Test
    public void testAesCipherService(){
        AesCipherService aesCipherService=new AesCipherService();
        //设置长度
        aesCipherService.setKeySize(128);
        //生成key
        Key key = aesCipherService.generateNewKey();
        String text="hello";
        //加密
        String encryptText = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();

        //解密
        String decrptText=new String(aesCipherService.decrypt(Hex.decode(encryptText),key.getEncoded()).getBytes());


        Assert.assertEquals(text,decrptText);

    }

    @Test
    public void testPasswordServiceWithMyRealm() {
        login("classpath:shiro-passwordservice.ini", "wu", "123");
    }

    //密码重试次数限制
    @Test
    public void testRetryLimitHashedCredentialsMatcherWithMyRealm(){
        for (int i=0;i<=10;i++){
            try {
                login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "123");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        login("classpath:shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "123");
    }

}
