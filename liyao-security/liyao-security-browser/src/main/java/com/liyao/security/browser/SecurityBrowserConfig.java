package com.liyao.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 需要继承springSecurity提供的适配器
 */
@Configuration
public class SecurityBrowserConfig extends WebSecurityConfigurerAdapter {
    /**
     * 覆写父类方法
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //我不想让其登录的方式是basic，想让它成为表单登录的方式。
        //下面的整体意思就是，表单方式登录并且所有的请求都需要进行身份认证
        http.formLogin()//表单登录的方式
                .and()
                .authorizeRequests()//要授权请求的意思
                .anyRequest()//任何的请求
                .authenticated();//都需要身份认证

    }
}
