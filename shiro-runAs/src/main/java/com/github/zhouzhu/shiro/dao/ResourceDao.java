package com.github.zhouzhu.shiro.dao;


import com.github.zhouzhu.shiro.entity.Resource;

import java.util.List;

/**
 *
 */
public interface ResourceDao {

    public Resource createResource(Resource resource);
    public Resource updateResource(Resource resource);
    public void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);
    List<Resource> findAll();

}
