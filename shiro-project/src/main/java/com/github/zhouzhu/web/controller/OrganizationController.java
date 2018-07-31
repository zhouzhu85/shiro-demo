package com.github.zhouzhu.web.controller;

import com.github.zhouzhu.entity.Organization;
import com.github.zhouzhu.service.OrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: OrganizationController
 * @author:zhouzhu
 * @Date: 2018/7/31 16:51
 * @Version: V1.0
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @RequiresPermissions("organization:view")
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        return "organization/index";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/tree",method = RequestMethod.GET)
    public String showTree(Model model){
        model.addAttribute("organizationList",organizationService.findAll());
        return "organization/tree";
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{parentId}/appendChild",method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId,Model model){
        Organization parent=organizationService.findOne(parentId);
        model.addAttribute("parent",parent);
        Organization child=new Organization();
        child.setParentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("child",child);
        model.addAttribute("op","新增");
        return "organization/appendChild";
    }


}
