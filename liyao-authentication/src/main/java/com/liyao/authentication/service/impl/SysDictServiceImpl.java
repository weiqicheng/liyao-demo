package com.liyao.authentication.service.impl;


import com.liyao.common.base.MyAbstractService;
import com.liyao.authentication.mapper.SysDictMapper;
import com.liyao.authentication.model.SysDict;
import com.liyao.authentication.service.SysDictService;

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
