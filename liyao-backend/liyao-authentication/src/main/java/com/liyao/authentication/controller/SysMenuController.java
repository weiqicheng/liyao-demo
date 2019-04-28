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

    @RequestMapping("add")
    @ResponseBody
    public String add(SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    sysMenuService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(SysMenu sysMenu) {
	    sysMenuService.update(sysMenu);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        SysMenu sysMenu = sysMenuService.findById(id);
        return sysMenu.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysMenu> list = sysMenuService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
