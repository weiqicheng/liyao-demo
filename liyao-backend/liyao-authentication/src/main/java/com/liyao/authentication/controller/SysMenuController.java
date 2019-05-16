package com.liyao.authentication.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.liyao.authentication.model.SysMenu;
import com.liyao.authentication.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
