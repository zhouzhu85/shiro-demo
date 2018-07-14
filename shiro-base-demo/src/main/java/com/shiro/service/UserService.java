package com.shiro.service;

import com.shiro.pojo.User;

import java.util.Set;

public interface UserService {
    public User createUser(User user);
    //修改密码
    public void changePassword(Long userId,String newPassword);
    //添加用户-角色关系
    public void correlationRoles(Long userId,Long roleIds);
    //移除用户-角色关系
    public void uncorrelationRoles(Long userId,Long roleIds);
    //根据用户名查找用户
    public User findByUsername(String username);
    //根据用户名查找角色
    public Set<String> findRoles(String username);
    //根据用户名查找其权限
    public Set<String> findPermissions(String username);
}