package com.github.zhouzhu.service;


import com.github.zhouzhu.entity.Permission;

/**
 *
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
