package com.liyao.common.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.liyao.common.enums.YesOrNo;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 公共填充器
 *
 * @author gongmb 2018年11月29日11:01:12
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    private static final Logger _log = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println(new Date());
        _log.info("start insert fill ....");
        //避免使用metaObject.setValue()
        this.setFieldValByName("createBy", "1111", metaObject);
        this.setFieldValByName("createDate", new Date(), metaObject);
        this.setFieldValByName("updateBy", "1111", metaObject);
        this.setFieldValByName("updateDate", new Date(), metaObject);
        this.setFieldValByName("isDelete", YesOrNo.NO.getValue(), metaObject);
        this.setFieldValByName("version", 1, metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        _log.info("start update fill ....");
        this.setFieldValByName("updateBy", "2222", metaObject);
        this.setFieldValByName("updateDate", new Date(), metaObject);
    }
}
