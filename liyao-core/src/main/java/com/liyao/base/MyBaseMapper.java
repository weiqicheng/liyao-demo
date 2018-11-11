package com.liyao.base;

import org.apache.ibatis.session.SqlSessionFactory;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import javax.annotation.Resource;

/**
 * 通用 Mapper, 如果被扫描到会报异常
 */

public interface MyBaseMapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {

}
