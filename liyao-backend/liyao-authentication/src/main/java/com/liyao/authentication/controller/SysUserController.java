package com.liyao.authentication.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.liyao.authentication.model.SysUser;
import com.liyao.authentication.service.SysUserService;
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
@RestController
@RequestMapping("/sysUser/")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

}
