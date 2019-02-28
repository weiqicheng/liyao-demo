package com.liyao.system.service.impl;


import com.liyao.common.base.MyAbstractService;
import com.liyao.system.mapper.SysDictMapper;
import com.liyao.system.model.SysDict;
import com.liyao.system.service.SysDictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@Service
public class SysDictServiceImpl extends MyAbstractService<SysDict> implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

}
