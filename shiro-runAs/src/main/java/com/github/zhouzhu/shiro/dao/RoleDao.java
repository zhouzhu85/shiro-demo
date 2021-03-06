package com.github.zhouzhu.shiro.dao;


import com.github.zhouzhu.shiro.entity.Role;

import java.util.List;

/**
 *
 */
public interface RoleDao {

    public Role createRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);
    public List<Role> findAll();
}
