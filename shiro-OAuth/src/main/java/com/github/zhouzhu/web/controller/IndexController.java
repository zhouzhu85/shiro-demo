package com.github.zhouzhu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: IndexController
 * @author:zhouzhu
 * @Date: 2018/8/2 17:22
 * @Version: V1.0
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
}
