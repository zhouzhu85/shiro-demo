package com.shiro.pojo;

public class RolePermission {
    private Long roleId;
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;

        RolePermission that=(RolePermission) obj;

        if(permissionId!=null ? !permissionId.equals(that.getPermissionId()):that.permissionId!=null) return false;
        if(roleId!=null ? !roleId.equals(that.roleId):that.roleId!=null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result=roleId!=null ? roleId.hashCode() :0;
        result=31* result+(permissionId!=null? permissionId.hashCode():0);
        return result;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
