package com.github.zhouzhu.web.taglib;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.github.zhouzhu.entity.Organization;
import com.github.zhouzhu.entity.Resource;
import com.github.zhouzhu.entity.Role;
import com.github.zhouzhu.service.OrganizationService;
import com.github.zhouzhu.service.ResourceService;
import com.github.zhouzhu.service.RoleService;
import com.github.zhouzhu.spring.SpringUtils;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.util.CollectionUtils;

import javax.swing.*;
import java.util.Collection;

/**
 * @ClassName: Functions
 * @author:zhouzhu
 * @Date: 2018/8/1 13:47
 * @Version: V1.0
 */
public class Functions {

    public static boolean in(Iterable iterable,Object element){
        if(iterable==null){return false;}
        return CollectionUtils.contains(iterable.iterator(),element);
    }

    public static String organizationName(Long organizationId){
        Organization organization=getOrganizationService().findOne(organizationId);
        if(organization == null){
            return "";
        }
        return organization.getName();
    }

    public static String organizationNames(Collection<Long> organizationIds){
        if(CollectionUtils.isEmpty(organizationIds)){
            return "";
        }
        StringBuffer s=new StringBuffer();
        for (Long organizationId:organizationIds){
            Organization organization=getOrganizationService().findOne(organizationId);
            if(organization==null){
                return "";
            }
            s.append(organization.getName());
            s.append(",");
        }
        if(s.length()>0){
            s.deleteCharAt(s.length()-1);
        }
        return s.toString();
    }

    public static String roleName(Long roleId){
        Role role=getRoleService().findOne(roleId);
        if(role==null){
            return "";
        }
        return role.getDescription();
    }
    public static String roleNames(Collection<Long> roleIds){
        if(CollectionUtils.isEmpty(roleIds)){
            return "";
        }
        StringBuffer s=new StringBuffer();
        for (Long roleId:roleIds){
            Role role=getRoleService().findOne(roleId);
            if(role==null){
                return "";
            }
            s.append(role.getDescription());
            s.append(",");
        }
        if(s.length()>0){
            s.deleteCharAt(s.length()-1);
        }
        return s.toString();
    }

    public static String resourceName(Long resourceId){
        Resource resource=getResourceService().findOne(resourceId);
        if(resource==null){
            return "";
        }
        return resource.getName();
    }

    public static String resourceNames(Collection<Long> resourceIds){
        if(CollectionUtils.isEmpty(resourceIds)){
            return "";
        }
        StringBuffer s=new StringBuffer();
        for(Long resourceId:resourceIds){
            Resource resource=getResourceService().findOne(resourceId);
            if(resource==null){
                return "";
            }
            s.append(resource.getName());
            s.append(",");
        }
        if(s.length()>0){
            s.deleteCharAt(s.length()-1);
        }
        return s.toString();
    }

    private static OrganizationService organizationService;
    private static RoleService roleService;
    private static ResourceService resourceService;

    public static OrganizationService getOrganizationService(){
        if(organizationService==null){
            organizationService= SpringUtils.getBean(OrganizationService.class);
        }
        return organizationService;
    }

    public static RoleService getRoleService(){
        if(resourceService==null){
            roleService=SpringUtils.getBean(RoleService.class);
        }
        return roleService;
    }
    public static ResourceService getResourceService(){
        if(resourceService==null){
            resourceService= SpringUtils.getBean(ResourceService.class);
        }
        return resourceService;
    }
}
