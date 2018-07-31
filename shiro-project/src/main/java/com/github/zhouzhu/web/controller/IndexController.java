package com.github.zhouzhu.web.controller;

import com.github.zhouzhu.entity.Resource;
import com.github.zhouzhu.entity.User;
import com.github.zhouzhu.service.ResourceService;
import com.github.zhouzhu.service.UserService;
import com.github.zhouzhu.web.bind.annotaion.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: IndexController
 * @author:zhouzhu
 * @Date: 2018/7/31 10:39
 * @Version: V1.0
 */
@Controller
public class IndexController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model){
        Set<String> permissions=userService.findPermissions(loginUser.getUsername());
        List<Resource> menus=resourceService.findMenus(permissions);
        model.addAttribute("menus",menus);
        return null;
    }
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
