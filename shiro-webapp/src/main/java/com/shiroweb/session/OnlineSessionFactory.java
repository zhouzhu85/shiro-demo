package com.shiroweb.session;

import com.shiroweb.utils.IpUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建自定义的session，
 * 添加一些自定义的数据
 * 如 用户登录到的系统ip
 * 用户状态（在线 隐身 强制退出）
 * 等 比如当前所在系统等
 * @ClassName: OnlineSessionFactory
 * @author:zhouzhu
 * @Date: 2018/7/24 15:00
 * @Version: V1.0
 */
public class OnlineSessionFactory implements SessionFactory{
    @Override
    public Session createSession(SessionContext initData) {
       OnlineSession session=new OnlineSession();
       if(initData!=null && initData instanceof WebSessionContext){
            WebSessionContext sessionContext=(WebSessionContext) initData;
            HttpServletRequest request=(HttpServletRequest) sessionContext.getServletRequest();
            if(request!=null){
                session.setHost(IpUtils.getIpAddr(request));
                session.setUserAgent(request.getHeader("User-Agent"));
                session.setSystemHost(request.getLocalAddr()+":"+request.getLocalPort());
            }
       }
       return session;
    }
}
