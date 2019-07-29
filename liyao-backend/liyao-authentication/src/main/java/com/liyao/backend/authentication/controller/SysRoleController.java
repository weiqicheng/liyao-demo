package com.liyao.backend.authentication.controller;


import com.liyao.backend.authentication.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@RestController
@RequestMapping("/sysRole/")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

}
