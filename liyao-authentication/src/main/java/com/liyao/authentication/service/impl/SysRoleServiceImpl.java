package com.liyao.authentication.service.impl;


import com.liyao.common.base.MyAbstractService;
import com.liyao.authentication.mapper.SysRoleMapper;
import com.liyao.authentication.model.SysRole;
import com.liyao.authentication.service.SysRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@Service
public class SysRoleServiceImpl extends MyAbstractService<SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

}
