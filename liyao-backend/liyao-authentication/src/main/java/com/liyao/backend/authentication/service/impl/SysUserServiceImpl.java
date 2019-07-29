package com.liyao.backend.authentication.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.liyao.backend.authentication.model.SysUser;
import com.liyao.backend.authentication.service.SysUserService;
import com.liyao.backend.authentication.mapper.SysUserMapper;

import org.springframework.stereotype.Service;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {

}
