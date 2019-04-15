package com.liyao.authentication.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.liyao.authentication.model.SysDict;
import com.liyao.authentication.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@Api("用户信息管理")
@RestController
//@RequestMapping("/sysDict/")
public class SysDictController {

    @Autowired
    SysDictService sysDictService;

    @ApiOperation("获取列表")
    @RequestMapping("add")
    @ResponseBody
    public String add(SysDict sysDict) {
        sysDictService.save(sysDict);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    sysDictService.deleteById(id);
        System.out.println(123456);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(SysDict sysDict) {
	    sysDictService.update(sysDict);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        SysDict sysDict = sysDictService.findById(id);
        return sysDict.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysDict> list = sysDictService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
