package com.liyao.code.generator.service.impl;

import com.liyao.code.generator.mapper.TrUserMapper;
import com.liyao.code.generator.model.TrUser;
import com.liyao.code.generator.service.TrUserService;
import com.liyao.code.generator.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by zhh on 2018/11/09.
 */
@Service
public class TrUserServiceImpl extends AbstractService<TrUser> implements TrUserService {

    @Autowired
    private TrUserMapper trUserMapper;

}
