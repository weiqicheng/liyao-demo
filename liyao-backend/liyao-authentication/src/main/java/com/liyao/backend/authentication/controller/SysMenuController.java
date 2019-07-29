package com.liyao.backend.authentication.controller;

import com.liyao.backend.authentication.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@Controller
@RequestMapping("/sysMenu/")
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

}
