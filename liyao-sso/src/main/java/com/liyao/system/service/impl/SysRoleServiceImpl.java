package com.liyao.system.service.impl;

import com.liyao.base.MyAbstractService;
import com.liyao.system.mapper.SysRoleMapper;
import com.liyao.system.model.SysRole;
import com.liyao.system.service.SysRoleService;
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
