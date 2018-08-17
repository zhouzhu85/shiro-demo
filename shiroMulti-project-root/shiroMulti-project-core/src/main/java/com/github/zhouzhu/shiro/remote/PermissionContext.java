package com.github.zhouzhu.shiro.remote;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName: PermissionContext
 * @author:zhouzhu
 * @Date: 2018/8/17 15:33
 * @Version: V1.0
 */
public class PermissionContext implements Serializable{
    private Set<String> roles;
    private Set<String> permissions;

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "PermissionContext{" +
                "roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
}
