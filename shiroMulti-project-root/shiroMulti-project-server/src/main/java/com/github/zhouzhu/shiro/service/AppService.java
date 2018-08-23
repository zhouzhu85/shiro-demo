package com.github.zhouzhu.shiro.service;

import com.github.zhouzhu.shiro.entity.App;

import java.util.List;

/**
 * @ClassName: AppService
 * @author:zhouzhu
 * @Date: 2018/8/20 15:23
 * @Version: V1.0
 */
public interface AppService {
    public App createApp(App app);
    public App updateApp(App app);
    public void delteApp(Long appId);
    public App findOne(Long appId);
    public List<App> findAll();

    /**
     * 根据appkey查找appid
     * @param appKey
     * @return
     */
    public Long findAppIdByAppKey(String appKey);
}
