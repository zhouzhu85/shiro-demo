package com.github.zhouzhu.client;

import com.github.zhouzhu.shiro.remote.RemoteServiceInterface;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import java.io.Serializable;

/**
 * @ClassName: ClientSessionDAO
 * @author:zhouzhu
 * @Date: 2018/8/20 20:12
 * @Version: V1.0
 */
public class ClientSessionDAO extends CachingSessionDAO{
    private RemoteServiceInterface remoteService;
    private String appKey;

    public void setRemoteService(RemoteServiceInterface remoteService) {
        this.remoteService = remoteService;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    protected void doUpdate(Session session) {
        remoteService.updateSession(appKey,session);
    }

    protected void doDelete(Session session) {
        remoteService.deleteSession(appKey,session);
    }

    protected Serializable doCreate(Session session) {
        Serializable sessionId=remoteService.createSession(session);
        assignSessionId(session,sessionId);
        return sessionId;
    }

    protected Session doReadSession(Serializable sessionId) {
        return remoteService.getSession(appKey,sessionId);
    }
}
