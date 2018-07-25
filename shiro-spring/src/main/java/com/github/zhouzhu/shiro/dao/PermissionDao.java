package com.github.zhouzhu.shiro.dao;


import com.github.zhouzhu.shiro.pojo.Permission;

/**
 * 权限dao
 */
public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);

}
