package com.shiro.service;

import com.shiro.pojo.User;

import java.util.Set;

public class UserServiceImpl implements UserService{
    @Override
    public User createUser(User user) {
        //加密密码
        
        return null;
    }

    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public void correlationRoles(Long userId, Long roleIds) {

    }

    @Override
    public void uncorrelationRoles(Long userId, Long roleIds) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}
