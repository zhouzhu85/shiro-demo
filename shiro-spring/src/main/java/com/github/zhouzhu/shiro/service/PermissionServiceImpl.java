package com.github.zhouzhu.shiro.service;

import com.github.zhouzhu.shiro.dao.PermissionDao;
import com.github.zhouzhu.shiro.pojo.Permission;

/**

 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao;

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
