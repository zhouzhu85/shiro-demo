package com.shiro.service;

import com.shiro.dao.UserDao;
import com.shiro.dao.UserDaoImpl;
import com.shiro.pojo.User;

import java.util.Set;

public class UserServiceImpl implements UserService{

    private UserDao userDao=new UserDaoImpl();
    private PasswordHelper passwordHelper=new PasswordHelper();

    /**
     * 创建用户
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptyPassword(user);
        return userDao.createUser(user);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    @Override
    public void changePassword(Long userId, String newPassword) {
        User user=userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptyPassword(user);
        userDao.updateUser(user);
    }

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    @Override
    public void correlationRoles(Long userId, Long roleIds) {
        userDao.correlationRole(userId,roleIds);
    }

    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    @Override
    public void uncorrelationRoles(Long userId, Long roleIds) {
        userDao.uncorrelationRoles(userId,roleIds);
    }

    /**
     *  根据用户名查找用户
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名查找角色
     * @param username
     * @return
     */
    @Override
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    /**
     * 根据用户名查找权限
     * @param username
     * @return
     */
    @Override
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}
