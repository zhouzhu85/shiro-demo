package com.github.zhouzhu.service;

import com.github.zhouzhu.entity.User;

import java.util.List;

/**
 * @ClassName: UserService
 * @author:zhouzhu
 * @Date: 2018/8/2 14:32
 * @Version: V1.0
 */
public interface UserService {
    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);

    User findOne(Long userId);

    List<User> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
