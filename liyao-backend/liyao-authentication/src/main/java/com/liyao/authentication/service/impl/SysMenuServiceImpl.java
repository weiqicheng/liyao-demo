package com.liyao.authentication.service.impl;


import com.liyao.common.base.MyAbstractService;
import com.liyao.authentication.mapper.SysMenuMapper;
import com.liyao.authentication.model.SysMenu;
import com.liyao.authentication.service.SysMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@Service
public class SysMenuServiceImpl extends MyAbstractService<SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

}
