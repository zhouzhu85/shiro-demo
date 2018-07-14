package com.shiro.service;

import com.shiro.pojo.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();
    private String alogrithmName="md5";
    private final int hashIterations=2;

    public void encryptyPassword(User user){
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword=new SimpleHash(alogrithmName,user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
