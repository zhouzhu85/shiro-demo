package com.github.zhouzhu.shiro.entity;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Authorization
 * @author:zhouzhu
 * @Date: 2018/8/17 16:11
 * @Version: V1.0
 */
public class Authorization implements Serializable{
    private Long id;
    private Long userId;
    private Long appId;
    private List<Long> roleIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public List<Long> getRoleIds() {
        if (roleIds==null){
            roleIds=new ArrayList<Long>();
        }
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleIdsStr(){
        if (CollectionUtils.isEmpty(roleIds)){
            return "";
        }
        StringBuffer s=new StringBuffer();
        return "";
    }
}
