package com.shiro.dao;

import com.shiro.pojo.User;

import java.util.Set;

public interface UserDao {
    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);
    public void correlationRole(Long userId,Long... roleIds);
    public void uncorrelationRoles(Long userId,Long... roleIds);

    User findOne(Long userId);
    User findByUsername(String username);
    Set<String> findRoles(String username);
    Set<String> findPermissions(String username);
}
