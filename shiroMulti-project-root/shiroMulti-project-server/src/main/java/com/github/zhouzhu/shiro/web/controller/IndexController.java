package com.github.zhouzhu.shiro.web.controller;


import com.github.zhouzhu.shiro.Constants;
import com.github.zhouzhu.shiro.entity.Resource;
import com.github.zhouzhu.shiro.entity.User;
import com.github.zhouzhu.shiro.service.AuthorizationService;
import com.github.zhouzhu.shiro.service.ResourceService;
import com.github.zhouzhu.shiro.service.UserService;
import com.github.zhouzhu.shiro.web.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 *
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping("/")
    public String index(@CurrentUser com.github.zhouzhu.shiro.entity.User loginUser, Model model) {
        Set<String> permissions = authorizationService.findPermissions(Constants.SERVER_APP_KEY, loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }



}
