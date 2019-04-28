package com.liyao.authentication.service;


import com.liyao.common.base.MyBaseService;
import com.liyao.authentication.model.SysDict;

/**
 * Created by zhh on 2018/11/11.
 */
public interface SysDictService extends MyBaseService<SysDict> {
    default void haha() {
        System.out.println("成哥最帅");

    }
}
