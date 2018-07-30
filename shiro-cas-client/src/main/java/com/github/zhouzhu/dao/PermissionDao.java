package com.github.zhouzhu.dao;


import com.github.zhouzhu.entity.Permission;

/**
 *
 */
public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);

}
