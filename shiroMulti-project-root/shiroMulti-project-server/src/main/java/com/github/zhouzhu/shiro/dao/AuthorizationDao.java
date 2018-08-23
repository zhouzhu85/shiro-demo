package com.github.zhouzhu.shiro.dao;


import com.github.zhouzhu.shiro.entity.Authorization;

import java.util.List;

/**
 *
 */
public interface AuthorizationDao {

    public Authorization createAuthorization(Authorization authorization);
    public Authorization updateAuthorization(Authorization authorization);
    public void deleteAuthorization(Long authorizationId);

    public Authorization findOne(Long authorizationId);
    public List<Authorization> findAll();

    public Authorization findByAppUser(Long appId, Long userId);
}
