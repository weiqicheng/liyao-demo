package com.liyao.backend.authentication.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.liyao.backend.authentication.model.SysDict;
import com.liyao.backend.authentication.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhh on 2018/11/11.
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/sysDict/")
public class SysDictController {

    @Autowired
    SysDictService sysDictService;

    @ApiOperation("获取列表")
    @RequestMapping("add")
    public String add(SysDict sysDict) {
        System.out.println("来了老弟！");
        return "";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam Integer id) {
        sysDictService.deleteById(id);
        System.out.println(123456);
        return "";
    }

    @RequestMapping("update")
    public String update(SysDict sysDict) {
        sysDictService.updateById(sysDict);
        return "";
    }

    @RequestMapping("detail")
    public String detail(@RequestParam Integer id) {
        SysDict sysDict = sysDictService.selectById(id);
        return sysDict.toString();
    }

    @RequestMapping("list")
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysDict> list = null;
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
