package com.liyao.system.service.impl;

import com.liyao.base.MyAbstractService;
import com.liyao.system.mapper.SysMenuMapper;
import com.liyao.system.model.SysMenu;
import com.liyao.system.service.SysMenuService;
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
