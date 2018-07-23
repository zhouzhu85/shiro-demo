package com.shiroweb.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

/**
 * @ClassName: MySessionListener2
 * @author:zhouzhu
 * @Date: 2018/7/23 15:15
 * @Version: V1.0
 */
public class MySessionListener2 extends SessionListenerAdapter{
    @Override
    public void onStart(Session session) {
        System.out.println("会话创建："+session.getId());
    }
}
