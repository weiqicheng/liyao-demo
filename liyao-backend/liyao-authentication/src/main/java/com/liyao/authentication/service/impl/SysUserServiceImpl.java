package com.liyao.authentication.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.liyao.authentication.model.SysUser;
import com.liyao.authentication.service.SysUserService;
import com.liyao.authentication.mapper.SysUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by zhh on 2018/11/11.
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {

}
