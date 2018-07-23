package com.shiroweb.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;

import java.io.*;

/**
 * @ClassName: SerializableUtils
 * @author:zhouzhu
 * @Date: 2018/7/23 16:14
 * @Version: V1.0
 */
public class SerializableUtils {
    public static String serialize(Session session){
        try {
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream oss=new ObjectOutputStream(bos);
            oss.writeObject(session);
            return Base64.encodeToString(bos.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("serialize session error",e);
        }
    }
    public static Session deserialize(String sessionStr){
        try {
            ByteArrayInputStream bis=new ByteArrayInputStream(Base64.decode(sessionStr));
            ObjectInputStream ois=new ObjectInputStream(bis);
            return (Session) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("deserialize session error", e);
        }
    }
}
