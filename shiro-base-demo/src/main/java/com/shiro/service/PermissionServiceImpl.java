package com.shiro.service;

import com.shiro.dao.PermissionDao;
import com.shiro.dao.PermissionDaoImpl;
import com.shiro.pojo.Permission;

public class PermissionServiceImpl implements PermissionService{

    private PermissionDao permissionDao=new PermissionDaoImpl();

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
