package com.shiro.dao;


import com.shiro.pojo.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
