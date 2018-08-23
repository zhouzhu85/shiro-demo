package com.github.zhouzhu.shiro.service;

import com.github.zhouzhu.shiro.dao.AppDao;
import com.github.zhouzhu.shiro.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AppServiceImpl
 * @author:zhouzhu
 * @Date: 2018/8/20 15:26
 * @Version: V1.0
 */
@Service
public class AppServiceImpl implements AppService{

    @Autowired
    private AppDao appDao;

    @Override
    public App createApp(App app) {
        return appDao.createApp(app);
    }

    @Override
    public App updateApp(App app) {
        return appDao.updateApp(app);
    }

    @Override
    public void delteApp(Long appId) {
        appDao.deleteApp(appId);
    }

    @Override
    public App findOne(Long appId) {
        return appDao.findOne(appId);
    }

    @Override
    public List<App> findAll() {
        return appDao.findAll();
    }

    @Override
    public Long findAppIdByAppKey(String appKey) {
        return appDao.findAppIdByAppKey(appKey);
    }
}
