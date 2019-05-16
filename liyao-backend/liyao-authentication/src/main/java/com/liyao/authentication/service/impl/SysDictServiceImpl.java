package com.liyao.authentication.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper,SysDict> implements SysDictService {

}
