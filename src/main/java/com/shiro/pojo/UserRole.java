package com.shiro.pojo;

import java.io.Serializable;

/**
 * 用户角色关系
 */

public class UserRole implements Serializable{
    private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()) return false;
        UserRole userRole=new UserRole();
        if(roleId!=null? !roleId.equals(userRole.getRoleId()):userRole.roleId!=null){
            return false;
        }
        if (userId!=null? !userId.equals(userRole.getUserId()):userRole.userId!=null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result=userId!=null?userId.hashCode():0;
        result=31*result+(roleId!=null?roleId.hashCode():0);

        return result;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
