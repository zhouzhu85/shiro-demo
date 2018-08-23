package com.github.zhouzhu.shiro.dao;

import com.github.zhouzhu.shiro.entity.App;

import java.util.List;

/**
 * @ClassName: AppDao
 * @author:zhouzhu
 * @Date: 2018/8/20 15:28
 * @Version: V1.0
 */
public interface AppDao {
    public App createApp(App app);
    public App updateApp(App app);
    public void deleteApp(Long appId);

    public App findOne(Long appId);
    public List<App> findAll();

    Long findAppIdByAppKey(String appKey);
}
