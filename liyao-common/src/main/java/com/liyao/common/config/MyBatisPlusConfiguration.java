package com.liyao.common.config;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.ISqlInjector;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.liyao.common.handler.MyMetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatisPlus配置
 */
@Configuration
public class MyBatisPlusConfiguration {


    /**
     * sql注入器
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    @Bean
    public GlobalConfiguration globalConfiguration(MyMetaObjectHandler myMetaObjectHandler) {
        GlobalConfiguration globalConfiguration = new GlobalConfiguration();
      /*  AUTO->`0`("数据库ID自增")
        INPUT->`1`(用户输入ID")
        ID_WORKER->`2`("全局唯一ID")
        UUID->`3`("全局唯一ID")*/
        globalConfiguration.setIdType(0);

        globalConfiguration.setDbType("mysql");
        //全局表为下划线命名设置 true
        globalConfiguration.setDbColumnUnderline(true);
        return globalConfiguration;
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }


}
