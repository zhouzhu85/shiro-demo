package com.shiro.service;

import com.shiro.dao.RoleDao;
import com.shiro.dao.RoleDaoImpl;
import com.shiro.pojo.Role;


public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao=new RoleDaoImpl();

    @Override
    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    /**
     * 添加角色-权限关系
     * @param roleId
     * @param permissionIds
     */

    @Override
    public void correlationPermissions(Long roleId, Long permissionIds) {
        roleDao.correlationPermissions(roleId,permissionIds);
    }

    /**
     *  删除角色-权限之间的关系
     * @param roleId
     * @param permissionIds
     */

    @Override
    public void uncorrelationPermissions(Long roleId, Long permissionIds) {
        roleDao.uncorrelationPermissions(roleId,permissionIds);
    }
}
