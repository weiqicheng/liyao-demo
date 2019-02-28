package com.liyao.system.service.impl;


import com.liyao.common.base.MyAbstractService;
import com.liyao.system.model.SysUser;
import com.liyao.system.service.SysUserService;
import com.liyao.system.mapper.SysUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@Service
public class SysUserServiceImpl extends MyAbstractService<SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

}
