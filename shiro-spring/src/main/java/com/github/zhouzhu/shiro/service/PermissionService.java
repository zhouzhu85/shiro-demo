package com.github.zhouzhu.shiro.service;


import com.github.zhouzhu.shiro.pojo.Permission;

/**
 *
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
