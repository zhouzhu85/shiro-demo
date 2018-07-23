package com.shiroweb.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * @ClassName: MySessionListener1
 * @author:zhouzhu
 * @Date: 2018/7/23 15:10
 * @Version: V1.0
 */
public class MySessionListener1 implements SessionListener{
    @Override
    public void onStart(Session session) { //会话创建时触发
        System.out.println("会话创建："+session.getId());
    }

    @Override
    public void onStop(Session session) { //会话过期时触发
        System.out.println("会话过期："+session.getId());
    }

    @Override
    public void onExpiration(Session session) { //退出或会话过期触发
        System.out.println("会话停止："+session.getId());
    }
}
